package com.oscar.springboot.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oscar.springboot.domain.Customer;
import com.oscar.springboot.repositories.CustomerRepository;

@Service
public class CustomerServiceImpl implements CustomerService{
	private CustomerRepository repository;
	
	@Autowired
	public void setCustomerRepository(CustomerRepository customerRepository) {
		this.repository = customerRepository;
	}

	@Override
	public Customer getCustomerByDbId(Long dbId) {
		return this.repository.findOne(dbId);
	}

	@Override
	public Customer saveCustomer(Customer customer) {
		return this.repository.save(customer);
	}

}
