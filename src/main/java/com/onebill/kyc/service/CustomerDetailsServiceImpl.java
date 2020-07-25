package com.onebill.kyc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.onebill.kyc.entity.CustomerDetails;
import com.onebill.kyc.entity.Mails;
import com.onebill.kyc.entity.Numbers;
import com.onebill.kyc.repository.CustomerDetailsRepository;

@Service
public class CustomerDetailsServiceImpl implements CustomerDetailsService {

	@Autowired
	CustomerDetailsRepository customerDetailsRepository;

	@Override
	public CustomerDetails postCustomer(CustomerDetails customerDetails) {
		validateCustomer(customerDetails);
		
		customerDetails.setListsSelf(customerDetailsRepository.getLastId());
		
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
		validateCustomer(customerDetails);
		
		customerDetails.setListsSelf(customerDetails.getCusId()-1);

		return customerDetailsRepository.save(customerDetails);
		
	}
	
	
	/**
	 * validate the entry by checking if first name is empty,
	 * email should not exist already and number should not exist previously
	 * @param customerDetails
	 */
	private void validateCustomer(CustomerDetails customerDetails) {
		
		if (customerDetails.getFirstName() == null) {
			throw new RuntimeException("First Name required");
		}

		for (Mails mail : customerDetails.getEmails()) {

			if (customerDetailsRepository.checkEmail(mail.getEmail()).isPresent()) {
				throw new RuntimeException("Duplicate Email: " + mail.getEmail());
			}
			if (!mail.getEmail().matches("^[a-zA-Z0-9_!#$%&’*+/=?`{|}~^.-]+@[a-zA-Z]+(.com|.in|.co.in)$")) {
				throw new RuntimeException("Invalid Email Syntax: " + mail.getEmail());
			}

		}

		for (Numbers num : customerDetails.getNumbers()) {

			if (customerDetailsRepository.checkNumber(num.getNumber()).isPresent()) {
				throw new RuntimeException("Duplicate Number: " + num.getNumber());
			}

		}

	}

}
