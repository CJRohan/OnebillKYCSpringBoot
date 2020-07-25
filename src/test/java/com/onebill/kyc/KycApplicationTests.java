package com.onebill.kyc;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.onebill.kyc.controller.CustomerDetailsController;
import com.onebill.kyc.entity.CustomerDetails;
import com.onebill.kyc.entity.Mails;
import com.onebill.kyc.entity.Numbers;
import com.onebill.kyc.repository.CustomerDetailsRepository;
import com.onebill.kyc.service.CustomerDetailsService;

@SpringBootTest
class KycApplicationTests {
	
	@Autowired
	CustomerDetailsController customerDetailsController;
	
	@Autowired
	CustomerDetailsService customerDetailsService;// = new CustomerDetailsServiceImpl();
	
	@MockBean
	CustomerDetailsRepository customerDetailsRepository;
	
	CustomerDetails customerDetails = new CustomerDetails(1, "X", "Y", "1997-05-09", new byte[3], new byte[3],
			false, new ArrayList<Mails>(), new ArrayList<Numbers>(), new ArrayList<>());

	/**
	 * Test for service layer method to save a customer's details
	 */
	@Test 
	public void postCustomerTest() {
		when(customerDetailsRepository.save(customerDetails)).thenReturn(customerDetails);
		assertEquals(customerDetails, customerDetailsService.postCustomer(customerDetails));				
	}
	
	/**
	 * Test for service layer method to get list of all customers
	 */
	@Test
	public void getAllCustomersTest() {
		List<CustomerDetails> customers = new ArrayList<CustomerDetails>();
		customers.add(customerDetails);
		when(customerDetailsRepository.getAll()).thenReturn(customers);
		assertEquals(customers, customerDetailsService.getAllCustomers());
	}
	
	/**
	 * Test for service layer method to remove a customer(mark as inactive)
	 */
	@Test
	public void deleteCustomerTest() {
		when(customerDetailsRepository.deleteCustomer(1)).thenReturn(1);
		when(customerDetailsRepository.findById(1)).thenReturn(Optional.of(customerDetails));
		assertEquals(customerDetails, customerDetailsService.deleteCustomer(1));
	}
	
	/**
	 * Test for service layer method to update a customer
	 */
	@Test 
	public void updateCustomerTest() {
		when(customerDetailsRepository.save(customerDetails)).thenReturn(customerDetails);
		assertEquals(customerDetails, customerDetailsService.updateCustomer(customerDetails));				
	}
	
	

}
