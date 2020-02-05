package com.facebook.common.internal;

public class Suppliers {
    public static final Supplier<Boolean> BOOLEAN_FALSE = new Supplier<Boolean>() {
        public Boolean get() {
            return false;
        }
    };
    public static final Supplier<Boolean> BOOLEAN_TRUE = new Supplier<Boolean>() {
        public Boolean get() {
            return true;
        }
    };

    public static <T> Supplier<T> of(final T t) {
        return new Supplier<T>() {
            public T get() {
                return t;
            }
        };
    }
}
