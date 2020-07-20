package com.onebill.kyc.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.onebill.kyc.entity.CustomerDetails;
import com.onebill.kyc.service.CustomerDetailsService;

@RestController
@CrossOrigin(origins = "*", allowCredentials = "true", allowedHeaders = "*", exposedHeaders = "Access-Control-Allow-Origin")
public class CustomerDetailsController {

	@Autowired
	CustomerDetailsService customerDetailsService;

	@PostMapping("/addCustomer")
	public ResponseEntity<CustomerDetails> addCustomer(@RequestParam("value") String cus,
			@RequestParam("idProof") MultipartFile idProof, @RequestParam("addressProof") MultipartFile addressProof)
			throws IOException {
		CustomerDetails customerDetails = new ObjectMapper().readValue(cus, CustomerDetails.class);
		customerDetails.setIdProof(idProof.getBytes());
		customerDetails.setAddressProof(addressProof.getBytes());
		return new ResponseEntity<CustomerDetails>(customerDetailsService.postCustomer(customerDetails),
				HttpStatus.ACCEPTED);
	}

	@GetMapping("/getCustomers")
	public ResponseEntity<List<CustomerDetails>> getCustomers() {
		return new ResponseEntity<List<CustomerDetails>>(customerDetailsService.getAllCustomers(), HttpStatus.FOUND);
	}
	
	
	@PutMapping("/updateCustomer") 
	public ResponseEntity<CustomerDetails> updateCustomer(@RequestParam("value") String cus,
			@RequestParam("idProof") MultipartFile idProof, @RequestParam("addressProof") MultipartFile addressProof)
			throws IOException {
		CustomerDetails customerDetails = new ObjectMapper().readValue(cus, CustomerDetails.class);
		customerDetails.setIdProof(idProof.getBytes());
		customerDetails.setAddressProof(addressProof.getBytes());
		return new ResponseEntity<CustomerDetails>(customerDetailsService.updateCustomer(customerDetails),
				HttpStatus.ACCEPTED);
	}	

	@DeleteMapping("/deleteCustomer/{id}")
	public ResponseEntity<CustomerDetails> deleteCustomer(@PathVariable Integer id) {
		return new ResponseEntity<CustomerDetails>(customerDetailsService.deleteCustomer(id), HttpStatus.ACCEPTED);
	}

}
