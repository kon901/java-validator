package org.validator;

import java.util.ArrayList;
import java.util.List;

public class RootValidator<T> implements Validator<T> {

	private final T objectToValidate;
	private final List<Validator> validators = new ArrayList<>();

	private RootValidator(T objectToValidate) {
		this.objectToValidate = objectToValidate;
	}

	public static <T> Validator validatorFor(T objectToValidate) {
		return new RootValidator<>(objectToValidate);
	}

	@Override
	public void validate() {
		validators.stream().filter(validator -> validator != this).forEach(Validator::validate);
	}
}