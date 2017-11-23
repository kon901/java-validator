package org.validator;

import java.util.function.Supplier;

public class MultiValidationPredicate implements ValidationPredicate {

	private ValidationPredicate validationPredicate;
	private Supplier<Boolean> predicate;

	MultiValidationPredicate(ValidationPredicate validationPredicate, Supplier<Boolean> predicate) {
		this.validationPredicate = validationPredicate;
		this.predicate = predicate;
	}

	@Override
	public boolean test() {
		return validationPredicate.test() && predicate.get();
	}
}
