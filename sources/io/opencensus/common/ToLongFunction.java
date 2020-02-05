package io.opencensus.common;

public interface ToLongFunction<T> {
    long applyAsLong(T t);
}
