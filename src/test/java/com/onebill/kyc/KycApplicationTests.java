package com.onebill.kyc;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.onebill.kyc.controller.CustomerDetailsController;
import com.onebill.kyc.entity.CustomerDetails;
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

	@Test 
	public void postCustomerTest() {
		
//		//CustomerDetails customerDetails = new CustomerDetails(1, "X", "Y", "05-09-1997", "", "", true, new ArrayList<>(), new ArrayList<>(), new ArrayList<>());
//		when(customerDetailsRepository.save(customerDetails)).thenReturn(customerDetails);
//		assertEquals(customerDetails, customerDetailsService.postCustomer(customerDetails));
		
	}

}
