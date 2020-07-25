package com.onebill.kyc.service;

import java.util.List;

import com.onebill.kyc.entity.CustomerDetails;

public interface CustomerDetailsService {
	
	/**
	 * adds a customer's details into database
	 * 
	 * @param customerDetails
	 * @return added customer's details
	 */
	CustomerDetails postCustomer(CustomerDetails customerDetails);
	
	/**
	 * method to get list of all customers
	 * 
	 * @return List of all active customers in database
	 */
	List<CustomerDetails> getAllCustomers();
	
	/**
	 * Set a customer as inactive
	 * 
	 * @param id
	 * @return details of deactivated customer
	 */
	CustomerDetails deleteCustomer(Integer id);
	
	/**
	 * Update the details of an existing customer
	 * 
	 * @param customerDetails
	 * @return updated details of customer
	 */
	CustomerDetails updateCustomer(CustomerDetails customerDetails);

}
