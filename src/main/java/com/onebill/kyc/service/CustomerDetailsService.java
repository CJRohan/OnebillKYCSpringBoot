package com.onebill.kyc.service;

import java.util.List;

import com.onebill.kyc.entity.CustomerDetails;

public interface CustomerDetailsService {
	
	CustomerDetails postCustomer(CustomerDetails customerDetails);
	
	List<CustomerDetails> getAllCustomers();
	
	CustomerDetails deleteCustomer(Integer id);
	
	CustomerDetails updateCustomer(CustomerDetails customerDetails);

}
