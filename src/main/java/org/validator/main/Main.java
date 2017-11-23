package org.validator.main;

import org.validator.Validator;

public class Main {
	public static void main(String[] args) {
		Customer customer = new Customer();
		Validator validator = Validator.
				when(customer::isAdult).
				and(customer::isAuthenticated).
				then(customer::getFirstName).withName("firstName").isMandatory().
				and(customer::getFirstName).withName("wqeeqeqew").shouldBeOneOf("asd", "qweqwe");

		validator.validate();
	}
}