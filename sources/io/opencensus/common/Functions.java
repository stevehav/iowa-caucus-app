package io.opencensus.common;

import javax.annotation.Nullable;

public final class Functions {
    private static final Function<Object, Void> RETURN_NULL = new Function<Object, Void>() {
        @Nullable
        public Void apply(Object obj) {
            return null;
        }
    };
    private static final Function<Object, String> RETURN_TO_STRING = new Function<Object, String>() {
        public String apply(Object obj) {
            if (obj == null) {
                return null;
            }
            return obj.toString();
        }
    };
    private static final Function<Object, Void> THROW_ASSERTION_ERROR = new Function<Object, Void>() {
        public Void apply(Object obj) {
            throw new AssertionError();
        }
    };
    private static final Function<Object, Void> THROW_ILLEGAL_ARGUMENT_EXCEPTION = new Function<Object, Void>() {
        public Void apply(Object obj) {
            throw new IllegalArgumentException();
        }
    };

    private Functions() {
    }

    public static <T> Function<Object, T> returnNull() {
        return RETURN_NULL;
    }

    public static <T> Function<Object, T> returnConstant(final T t) {
        return new Function<Object, T>() {
            public T apply(Object obj) {
                return t;
            }
        };
    }

    public static Function<Object, String> returnToString() {
        return RETURN_TO_STRING;
    }

    public static <T> Function<Object, T> throwIllegalArgumentException() {
        return THROW_ILLEGAL_ARGUMENT_EXCEPTION;
    }

    public static <T> Function<Object, T> throwAssertionError() {
        return THROW_ASSERTION_ERROR;
    }
}
