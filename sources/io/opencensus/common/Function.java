package io.opencensus.common;

public interface Function<A, B> {
    B apply(A a);
}
