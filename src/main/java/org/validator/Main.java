package org.validator;

public class Main {
	public static void main(String[] args) {
		Validator validator = RootValidator.validator().when(() -> true).thenValue(1).shouldBeEqualTo(123);
		validator.validate();
	}
}