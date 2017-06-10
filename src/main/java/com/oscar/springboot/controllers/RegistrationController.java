package com.oscar.springboot.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.oscar.springboot.domain.Customer;
import com.oscar.springboot.services.CustomerService;

@Controller
@RequestMapping("/registration")
public class RegistrationController {
	
	private CustomerService customerService;
	
	@Autowired
	public void setCustomerService(CustomerService customerService) {
		this.customerService = customerService;
	}

	@RequestMapping(method = RequestMethod.GET)
	public @ResponseBody Customer sayHello(
			@RequestParam(value = "id", required = true) long id) {
		return customerService.getCustomerByDbId(id);
	}

}
