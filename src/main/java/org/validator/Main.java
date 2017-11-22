package org.validator;

public class Main {
	public static void main(String[] args) {
		Validator validator = RootValidator.validator().
				when(true).
				and(true).
				or(false).
				then(1).shouldBeEqualTo(123).
				and(2).shouldBeOneof(123, 456).
				and(3).isMandatory();
		validator.validate();
	}
}