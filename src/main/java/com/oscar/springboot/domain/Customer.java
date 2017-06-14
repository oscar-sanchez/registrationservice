package com.oscar.springboot.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Version;

@Entity
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Version
    private Integer version;

    private String customerId;
    private String customerName;
    private String contactPerson;
    private String email;
    private String phoneNumber;
    
    /** Basic constructor for JPA only **/
    public Customer() {}
    
    public Customer(String customerId, String customerName, String contactPerson, String email,
    		String phoneNumber) {
    	this.customerId = customerId;
    	this.customerName = customerName;
    	this.contactPerson = contactPerson;
    	this.email = email;
    	this.phoneNumber = phoneNumber;
    }

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getVersion() {
		return version;
	}

	public void setVersion(Integer version) {
		this.version = version;
	}

	public String getCustomerId() {
		return customerId;
	}

	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getContactPerson() {
		return contactPerson;
	}

	public void setContactPerson(String contactPerson) {
		this.contactPerson = contactPerson;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	@Override
	public String toString() {
		return "Customer [id=" + id + ", version=" + version + ", customerId=" + customerId + ", customerName="
				+ customerName + ", contactPerson=" + contactPerson + ", email=" + email + ", phoneNumber="
				+ phoneNumber + "]";
	}
}
