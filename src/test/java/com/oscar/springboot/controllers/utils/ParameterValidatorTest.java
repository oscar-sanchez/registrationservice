package com.oscar.springboot.controllers.utils;

import static org.junit.Assert.fail;

import org.junit.Test;

import com.oscar.springboot.domain.Customer;
import com.oscar.springboot.exceptions.BadRequestException;
import com.oscar.springboot.utils.ParameterValidator;

public class ParameterValidatorTest {
	
	/** Valid parameters **/
	private final static String VALID_ID = "Customer-Id";
	private final static String VALID_NAME = "Customer_Name";
	private final static String VALID_CONTACT_PERSON = "Oscar Sanchez Iglesias";
	private final static String VALID_EMAIL = "anemail@gmail.com";
	private final static String VALID_PHONE = "+61423123456";

	@Test
	public void testValidCustomer() {
		try {
			Customer validCustomer = new Customer(VALID_ID, VALID_NAME, VALID_CONTACT_PERSON,
					VALID_EMAIL, VALID_PHONE);
			ParameterValidator.validate(validCustomer);
		} catch (BadRequestException e) {
			fail();
		}
	}

	@Test
	public void testNullCustomer() {
		try {
			ParameterValidator.validate(null);
			fail();
		} catch (BadRequestException e) {
		}
	}

	@Test
	public void testInvalidCustomerId() {
		try {
			ParameterValidator.validate(new Customer("ASFLKJIES'oiuh", VALID_NAME, VALID_CONTACT_PERSON,
					VALID_EMAIL, VALID_PHONE));
			fail();
		} catch (BadRequestException e) {
		}
	}

	@Test
	public void testInvalidCustomerName() {
		try {
			ParameterValidator.validate(new Customer(VALID_ID, "lk;23498slkj", VALID_CONTACT_PERSON,
					VALID_EMAIL, VALID_PHONE));
			fail();
		} catch (BadRequestException e) {
		}
	}
	
	@Test
	public void testInvalidContactPerson() {
		try {
			Customer validCustomer = new Customer(VALID_ID, VALID_NAME, "lkj@ alk123123",
					VALID_EMAIL, VALID_PHONE);
			ParameterValidator.validate(validCustomer);
			fail();
		} catch (BadRequestException e) {
		}
	}
	
	@Test
	public void testInvalidEmail() {
		try {
			Customer validCustomer = new Customer(VALID_ID, VALID_NAME, VALID_CONTACT_PERSON,
					"lkji234098dfg", VALID_PHONE);
			ParameterValidator.validate(validCustomer);
			fail();
		} catch (BadRequestException e) {
		}
	}
	
	@Test
	public void testInvalidPhoneNumber() {
		try {
			Customer validCustomer = new Customer(VALID_ID, VALID_NAME, VALID_CONTACT_PERSON,
					VALID_EMAIL, "80982339393");
			ParameterValidator.validate(validCustomer);
			fail();
		} catch (BadRequestException e) {
		}
	}
}
