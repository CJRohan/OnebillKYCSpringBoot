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
public class Numbers implements Serializable {
	
	@Id
	@Column
	@GeneratedValue(strategy = GenerationType.IDENTITY )
	private Integer srNo;
	
	@Column(unique = true)
	private Long number;
	@Column
	private String type;
	
	@ManyToOne
	@JoinColumn(name = "cusId")
	private CustomerDetails customerDetails;

	public Integer getSrNo() {
		return srNo;
	}

	public void setSrNo(Integer srNo) {
		this.srNo = srNo;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Integer getCustomerDetails() {
		return customerDetails.getCusId();
	}

	public void setCustomerDetails(CustomerDetails customerDetails) {
		this.customerDetails = customerDetails;
	}

	public Long getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = Long.parseLong(number);
	}

	@Override
	public String toString() {
		return "OfficeNumbers [number=" + number + ", cusId=" + customerDetails.getCusId() + "]";
	}

	
	

}
