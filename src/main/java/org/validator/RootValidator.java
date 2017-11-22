package org.validator;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

public class RootValidator implements Validator {

	private final List<Validator> validators = new ArrayList<>();

	private RootValidator() {
	}

	public static <T> RootValidator validator() {
		return new RootValidator();
	}

	public ValidationPredicate when(Supplier<Boolean> predicate) {
		return null;
	}

	public ValidationPredicate when(boolean predicate) {
		return when(() -> predicate);
	}

	public Validator isMandatory() {
		return () -> {
			;
		};
	}

	public Validator shouldBeEqualTo(Object o) {
		return () -> {
			;
		};
	}


	public Validator shouldBeOneof(Object... o) {
		return () -> {
			;
		};
	}

	@Override
	public void validate() {
		validators.stream().filter(validator -> validator != this).forEach(Validator::validate);
	}
}