package com.facebook.common.internal;

public class AndroidPredicates {
    private AndroidPredicates() {
    }

    public static <T> Predicate<T> True() {
        return new Predicate<T>() {
            public boolean apply(T t) {
                return true;
            }
        };
    }

    public static <T> Predicate<T> False() {
        return new Predicate<T>() {
            public boolean apply(T t) {
                return false;
            }
        };
    }
}
