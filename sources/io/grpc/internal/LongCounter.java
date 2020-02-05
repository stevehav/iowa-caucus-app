package io.grpc.internal;

public interface LongCounter {
    void add(long j);

    long value();
}
