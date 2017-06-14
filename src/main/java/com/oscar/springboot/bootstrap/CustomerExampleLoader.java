package com.oscar.springboot.bootstrap;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import com.oscar.springboot.domain.Customer;
import com.oscar.springboot.services.CustomerService;

@Component
public class CustomerExampleLoader implements ApplicationListener<ContextRefreshedEvent> {
	private CustomerService customerService;
	private boolean alreadyInitialised = false;

	private Logger log = Logger.getLogger(CustomerExampleLoader.class);

	@Autowired
	public void setCustomerService(CustomerService customerService) {
		this.customerService = customerService;
	}

	@Override
	public void onApplicationEvent(ContextRefreshedEvent event) {
		if(alreadyInitialised) {
			return;
		}
		alreadyInitialised = true;
		Customer egCustomer = new Customer("NSW-1", "FirstCustomer", "Who", "myemail@gmail.com", "+61423123456");
		customerService.saveCustomer(egCustomer);
		log.info("Saved Example customer - internal id: " + egCustomer.getId());
	}
}
