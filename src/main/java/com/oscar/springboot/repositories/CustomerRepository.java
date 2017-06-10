package com.oscar.springboot.repositories;

import org.springframework.data.repository.CrudRepository;

import com.oscar.springboot.domain.Customer;

public interface CustomerRepository extends CrudRepository<Customer, Long>{

}
