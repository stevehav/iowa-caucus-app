package io.opencensus.common;

public interface ToDoubleFunction<T> {
    double applyAsDouble(T t);
}
