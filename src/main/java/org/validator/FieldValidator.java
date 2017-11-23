package org.validator;

import java.util.Objects;
import java.util.function.Supplier;
import java.util.stream.Stream;

public class FieldValidator implements Validator {

	private final RootValidator rootValidator;
	private final Supplier<Object> fieldValue;
	private String fieldName;
	private Supplier<Boolean> predicate;

	public FieldValidator(RootValidator rootValidator, Supplier<Object> fieldValue) {
		this.rootValidator = rootValidator;
		this.fieldValue = fieldValue;
		rootValidator.addValidator(this);
	}

	@Override
	public void validate() {
		if (!predicate.get()) {
			throw new RuntimeException(fieldName);
		}
	}

	public FieldValidator withName(String name) {
		this.fieldName = name;
		return this;
	}

	public RootValidator shouldBeEqualTo(Object o) {
		return shouldBeOneOf(o);
	}

	public RootValidator shouldBeOneOf(Object... objects) {
		predicate = () -> Stream.of(objects).anyMatch(o -> Objects.equals(o, fieldValue.get()));
		return rootValidator;
	}

	public RootValidator isMandatory() {
		Object o = fieldValue.get();
		predicate = () -> o instanceof CharSequence ? isNotEmpty((CharSequence) o) : o != null;
		return rootValidator;
	}

	private boolean isNotEmpty(CharSequence fieldValue) {
		return fieldValue != null && fieldValue.length() > 0;
	}
}
