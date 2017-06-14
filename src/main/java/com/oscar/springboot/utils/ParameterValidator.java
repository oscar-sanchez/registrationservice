package com.oscar.springboot.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.oscar.springboot.domain.Customer;
import com.oscar.springboot.exceptions.BadRequestException;

public class ParameterValidator {

	/** Regular expressions **/
	final static String CUSTOMER_ID_REGEX = "^[a-zA-z0-9_-]{3,20}$";
	final static String CUSTOMER_NAME_REGEX = "^[a-zA-z0-9_-]{3,20}$";
	final static String CONTACT_PERSON_REGEX = "^(?<name>[a-zA-Z0-9]{2,20})\\s+(?<lastname>[a-zA-Z 0-9]{2,20})$";
	final static String EMAIL_REGEX = "^[_A-Za-z0-9-]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
	final static String PHONE_REGEX = "\\+(9[976]\\d|8[987530]\\d|6[987]\\d|5[90]\\d|42\\d|3[875]\\d|2[98654321]\\d|9[8543210]|8[6421]|6[6543210]|5[87654321]|4[987654310]|3[9643210]|2[70]|7|1)\\d{1,14}$";

	public static void validate(Customer customer) {
		if (customer == null) {
			throw new BadRequestException("Wrong format of customer. The whole customer object is null");
		}

		// Validate Customer Id
		Pattern pattern = Pattern.compile(CUSTOMER_ID_REGEX);
		Matcher matcher = pattern.matcher(customer.getCustomerId());
		if (!matcher.matches()) {
			throw new BadRequestException("Wrong format at field customerId");
		}

		// Validate Customer Name
		pattern = Pattern.compile(CUSTOMER_NAME_REGEX);
		matcher = pattern.matcher(customer.getCustomerName());
		if (!matcher.matches()) {
			throw new BadRequestException("Wrong format at field customerName");
		}

		// Validate contact person
		pattern = Pattern.compile(CONTACT_PERSON_REGEX);
		matcher = pattern.matcher(customer.getContactPerson());
		if (!matcher.matches()) {
			throw new BadRequestException("Wrong format at field contactPerson. Please introduce name and lastname");
		}

		// Validate Email
		pattern = Pattern.compile(EMAIL_REGEX);
		matcher = pattern.matcher(customer.getEmail());
		if (!matcher.matches()) {
			throw new BadRequestException("Wrong format at field email");
		}

		// Validate Phone number
		pattern = Pattern.compile(PHONE_REGEX);
		matcher = pattern.matcher(customer.getPhoneNumber());
		if (!matcher.matches()) {
			throw new BadRequestException("Wrong format at field phoneNumber");
		}
	}
}
