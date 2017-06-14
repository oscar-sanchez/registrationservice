package com.oscar.springboot.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.oscar.springboot.domain.Customer;
import com.oscar.springboot.services.CustomerService;
import com.oscar.springboot.utils.ParameterValidator;

@RestController
@RequestMapping("/registration")
public class RegistrationController {

	private CustomerService customerService;

	@Autowired
	public void setCustomerService(CustomerService customerService) {
		this.customerService = customerService;
	}

	@RequestMapping(method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody Customer getCustomer(@RequestParam(value = "id", required = true) long id) {
		return customerService.getCustomerByDbId(id);
	}

	@RequestMapping(method = RequestMethod.POST, produces = "application/json")
	public @ResponseBody Customer registerCustomer(@RequestBody Customer customer) {
		// Check input parameters
		ParameterValidator.validate(customer);
		
		// Save customer into the DB
		Customer newC = customerService.saveCustomer(customer);
		
		
		return newC;
	}
}
