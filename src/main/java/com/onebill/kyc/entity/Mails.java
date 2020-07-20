package com.onebill.kyc.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@SuppressWarnings("serial")
@Entity
@Table
public class Mails implements Serializable {
	
	@Id
	@Column
	@GeneratedValue(strategy = GenerationType.IDENTITY )
	private Integer srNo;
	
	@Column(unique = true)
	private String email;

	@Override
	public String toString() {
		return "Mails [srNo=" + srNo + ", email=" + email + ", cusId=" + customerDetails.getCusId() + "]";
	}

	@ManyToOne
	@JoinColumn(name = "cusId")
	private CustomerDetails customerDetails;

	public Integer getSrNo() {
		return srNo;
	}

	public void setSrNo(Integer srNo) {
		this.srNo = srNo;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Integer getCustomerDetails() {
		return customerDetails.getCusId();
	}

	public void setCustomerDetails(CustomerDetails customerDetails) {
		this.customerDetails = customerDetails;
	}
		

}
