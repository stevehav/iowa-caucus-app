package io.grpc.perfmark;

import java.io.Closeable;

public abstract class PerfMarkTask implements Closeable {
    public abstract void close();

    PerfMarkTask() {
    }
}
