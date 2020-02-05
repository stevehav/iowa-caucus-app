package io.opencensus.common;

import java.io.Closeable;

@Deprecated
public interface NonThrowingCloseable extends Closeable {
    void close();
}
