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
public class Address implements Serializable {
	
	@Id
	@Column
	@GeneratedValue(strategy = GenerationType.IDENTITY )
	private Integer srNo;
	
	@Column
	private String line1;
	@Column
	private String line2;
	@Column
	private String city;
	@Column
	private String state;
	@Column
	private String country;
	@Column
	private String pin;
	@Column
	private String type;
	
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


	@ManyToOne
	@JoinColumn(name = "cusId")
	private CustomerDetails customerDetails;

	public String getPin() {
		return pin;
	}

	public void setPin(String pin) {
		this.pin = pin;
	}

	public Integer getCustomerDetails() {
		return customerDetails.getCusId();
	}

	public void setCustomerDetails(CustomerDetails customerDetails) {
		this.customerDetails = customerDetails;
	}

	public String getLine1() {
		return line1;
	}

	public void setLine1(String line1) {
		this.line1 = line1;
	}

	public String getLine2() {
		return line2;
	}

	public void setLine2(String line2) {
		this.line2 = line2;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}
	

	@Override
	public String toString() {
		return "ResidentialAddress [line1=" + line1 + ", line2=" + line2 + ", city=" + city + ", state=" + state
				+ ", country=" + country + ", pin=" + pin + ", cusId=" + customerDetails.getCusId() + "]";
	}


	
	
	

}
