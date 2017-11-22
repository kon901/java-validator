package org.validator;

import java.util.function.Supplier;

public interface ValidationPredicate {

	boolean test();

	RootValidator thenValue(Supplier<?> supplier);

	default RootValidator thenValue(Object o) {
		return thenValue(() -> o);
	}

	ValidationPredicate and(Supplier<Boolean> supplier);
	ValidationPredicate or(Supplier<Boolean> supplier);
}
