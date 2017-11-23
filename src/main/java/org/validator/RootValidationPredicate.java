package org.validator;

import java.util.function.Supplier;

public class RootValidationPredicate implements ValidationPredicate {
	private Supplier<Boolean> predicate;

	RootValidationPredicate(Supplier<Boolean> predicate) {
		this.predicate = predicate;
	}

	@Override
	public boolean test() {
		return predicate.get();
	}
}
