package org.validator;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

public class RootValidator implements Validator {

	private final List<Validator> validators = new ArrayList<>();
	private ValidationPredicate validationPredicate;

	public RootValidator(ValidationPredicate validationPredicate) {
		this.validationPredicate = validationPredicate;
	}

	@Override
	public void validate() {
		if (validationPredicate.test()) {
			validators.stream().filter(validator -> validator != this).forEach(Validator::validate);
		}
	}

	public FieldValidator and(Object o) {
		return and(() -> o);
	}

	public FieldValidator and(Supplier<Object> supplier) {
		return new FieldValidator(this, supplier);
	}

	public void addValidator(Validator validator) {
		validators.add(validator);
	}
}