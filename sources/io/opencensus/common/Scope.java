package io.opencensus.common;

public interface Scope extends NonThrowingCloseable {
    void close();
}
