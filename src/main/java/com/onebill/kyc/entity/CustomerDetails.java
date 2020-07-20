package com.onebill.kyc.entity;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


@SuppressWarnings("serial")
@Entity
@Table
@JsonIgnoreProperties(ignoreUnknown = true)
public class CustomerDetails implements Serializable {

	@Id
	@Column
	private Integer cusId;
	@Column
	private String firstName;
	@Column
	private String lastName;
	@Column
	private LocalDate dob;
	@Column
	private byte[] addressProof;
	@Column
	private byte[] idProof;
	@Column
	private Boolean active;
	
	public CustomerDetails() {
		this.active = true;		
	}	
	
//	public CustomerDetails(Integer cusId, String firstName, String lastName, String dob, String addressProof,
//			String idProof, Boolean active, List<Mails> emails,
//			List<Numbers> numbers, List<Address> address) {
//		this.cusId = cusId;
//		this.firstName = firstName;
//		this.lastName = lastName;
//		this.dob = dob;
//		this.addressProof = addressProof;
//		this.idProof = idProof;
//		this.active = active;
//		this.emails = emails;
//		this.numbers = numbers;
//		this.address = address;
//	}
	
	@OneToMany(mappedBy = "customerDetails", cascade = CascadeType.ALL)
	private List<Mails> emails;

	@OneToMany(mappedBy = "customerDetails", cascade = CascadeType.ALL)
	private List<Numbers> numbers;
	
	@OneToMany(mappedBy = "customerDetails", cascade = CascadeType.ALL)
	private List<Address> address;

	
	public void setListsSelf(Integer i) {
		
		if ( i != null)	this.cusId = i + 1;
		else this.cusId = 1;
		
		for (Mails mails : emails) {
			mails.setCustomerDetails(this);
		}
		for (Numbers num : numbers) {
			num.setCustomerDetails(this);
		}
		for (Address addr : address) {
			addr.setCustomerDetails(this);			
		}	
		
	}

	public List<Mails> getEmails() {
		return emails;
	}

	public void setEmails(List<Mails> emails) {
		this.emails = emails;
	}

	public List<Numbers> getNumbers() {
		return numbers;
	}

	public void setNumbers(List<Numbers> numbers) {
		this.numbers = numbers;
	}

	public List<Address> getAddress() {
		return address;
	}

	public void setAddress(List<Address> address) {
		this.address = address;
	}

	public Boolean getActive() {
		return active;
	}

	public void setActive(Boolean active) {
		this.active = active;
	}

	public Integer getCusId() {
		return cusId;
	}

	public void setCusId(Integer cusId) {
		this.cusId = cusId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getDob() {
		return dob.toString();
	}

	public void setDob(String dob) {
		this.dob = LocalDate.parse(dob);
	}

	public byte[] getAddressProof() {
		return addressProof;
	}

	public void setAddressProof(byte[] addressProof) {
		this.addressProof = addressProof;
	}

	public byte[] getIdProof() {
		return idProof;
	}

	public void setIdProof(byte[] idProof) {
		this.idProof = idProof;
	}

	@Override
	public String toString() {
		return "CustomerDetails [cusId=" + cusId + ", firstName=" + firstName + ", lastName=" + lastName + ", dob="
				+ dob + ", addressProof=" + addressProof + ", idProof=" + idProof + ", active=" + active + ", emails="
				+ emails + ", numbers=" + numbers + ", address=" + address + "]";
	}	

}
