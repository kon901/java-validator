package org.validator;

import java.util.function.Supplier;

public interface ValidationPredicate {

	boolean test();

	RootValidator then(Supplier<?> supplier);

	default RootValidator then(Object o) {
		return then(() -> o);
	}

	ValidationPredicate and(Supplier<Boolean> supplier);
	ValidationPredicate or(Supplier<Boolean> supplier);

	default ValidationPredicate and(boolean b) {
		return and(() -> b);
	}

	default ValidationPredicate or(boolean b) {
		return or(() -> b);
	}
}
