package com.oscar.springboot.services;

import com.oscar.springboot.domain.Customer;

public interface CustomerService {
	    Customer getCustomerByDbId(Long dbId);

	    Customer saveCustomer(Customer customer);
}
