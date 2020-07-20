package com.onebill.kyc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.onebill.kyc.entity.CustomerDetails;
import com.onebill.kyc.repository.CustomerDetailsRepository;

@Service
public class CustomerDetailsServiceImpl implements CustomerDetailsService {

	@Autowired
	CustomerDetailsRepository customerDetailsRepository;

	@Override
	public CustomerDetails postCustomer(CustomerDetails customerDetails) {
		customerDetails.setListsSelf(customerDetailsRepository.getLastId());
		System.out.println("\n" + customerDetails + "\n");
		return customerDetailsRepository.save(customerDetails);
	}

	@Override
	public List<CustomerDetails> getAllCustomers() {
		return customerDetailsRepository.getAll();
	}

	@Override
	public CustomerDetails deleteCustomer(Integer id) {
		System.out.println(customerDetailsRepository.deleteCustomer(id));
		return customerDetailsRepository.findById(id).get();	
	}

	@Override
	public CustomerDetails updateCustomer(CustomerDetails customerDetails) {
		customerDetailsRepository.deleteById(customerDetails.getCusId());
		customerDetailsRepository.save(customerDetails);
		return null;
	}
	
	

}
