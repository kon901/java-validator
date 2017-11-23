package org.validator;

import java.util.function.Supplier;

public interface ValidationPredicate {

	boolean test();

	default Validator then(Object o) {
		return then(() -> o);
	}

	default ValidationPredicate and(boolean b) {
		return and(() -> b);
	}

	default ValidationPredicate and(Supplier<Boolean> supplier) {
		return new MultiValidationPredicate(this, supplier);
	}

	default FieldValidator then(Supplier<Object> supplier) {
		return new FieldValidator(new RootValidator(this), supplier);
	}
}
