package com.onebill.kyc.repository;


import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.onebill.kyc.entity.CustomerDetails;

public interface CustomerDetailsRepository extends JpaRepository<CustomerDetails, Integer> {

	/**
	 * getting the latest customer id from database
	 * 
	 * @return maximum customer id from database
	 */
	@Query(value = "select max(cus_id) from customer_details", nativeQuery = true)
	Integer getLastId();
	
	/**
	 * deactivating a customer based on the Customer's ID
	 * 
	 * @param id
	 * @return number of customers deactivated(will be ONE always)
	 */
	@Transactional
	@Modifying
	@Query(value = "update customer_details set active = 0 where cus_id = :id", nativeQuery = true)
	int deleteCustomer(@Param("id") Integer  id);
	
	/**
	 * getting list of all active customers from database
	 * 
	 * @return list of all active customers
	 */
	@Query(value = "select * from customer_details where active != 0", nativeQuery = true)
	List<CustomerDetails> getAll();
	
	/**
	 * to check if a E-Mail exists in the database
	 * 
	 * @param mail
	 * @return E-Mail if it exists else empty Optional<String> object
	 */
	@Query(value = "select email from mails where email = :mail", nativeQuery = true)
	Optional<String> checkEmail(@Param("mail") String mail);
	
	/**
	 * to check if a number exists in the database
	 * 
	 * @param num
	 * @return Number if it exists else empty Optional<String> object
	 */
	@Query(value = "select number from numbers where number = :num", nativeQuery = true)
	Optional<String> checkNumber(@Param("num") Long num);
	
	
}
