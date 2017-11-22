package org.validator;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

public class RootValidator implements Validator {

	private final List<Validator> validators = new ArrayList<>();

	private RootValidator() {
	}

	public static RootValidator validator() {
		return new RootValidator();
	}

	public ValidationPredicate when(Supplier<Boolean> predicate) {
		return null;
	}

	public ValidationPredicate when(boolean predicate) {
		return when(() -> predicate);
	}

	public RootValidator isMandatory() {
		return this;
	}

	public RootValidator shouldBeEqualTo(Object o) {
		return this;
	}


	public RootValidator shouldBeOneof(Object... o) {
		return this;
	}

	@Override
	public void validate() {
		validators.stream().filter(validator -> validator != this).forEach(Validator::validate);
	}

	public RootValidator and(Object o) {
		return this;
	}
}