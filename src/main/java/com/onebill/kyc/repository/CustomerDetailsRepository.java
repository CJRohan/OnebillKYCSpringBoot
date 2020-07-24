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

	@Query(value = "select max(cus_id) from customer_details", nativeQuery = true)
	Integer getLastId();
	
	@Transactional
	@Modifying
	@Query(value = "update customer_details set active = 0 where cus_id = :id", nativeQuery = true)
	int deleteCustomer(@Param("id") Integer  id);
	
	
	@Query(value = "select * from customer_details where active != 0", nativeQuery = true)
	List<CustomerDetails> getAll();
	
	@Query(value = "select email from mails where email = :mail", nativeQuery = true)
	Optional<CustomerDetails> checkEmail(@Param("mail") String mail);
	
	@Query(value = "select number from numbers where number = :num", nativeQuery = true)
	Optional<CustomerDetails> checkNumber(@Param("num") Long num);
	
	
}
