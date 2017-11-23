package org.validator;

import java.util.function.Supplier;

public interface Validator {

	static ValidationPredicate when(boolean b) {
		return when(() -> b);
	}

	static ValidationPredicate when(Supplier<Boolean> predicate) {
		return new RootValidationPredicate(predicate);
	}

	void validate();
}