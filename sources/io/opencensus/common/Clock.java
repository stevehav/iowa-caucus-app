package io.opencensus.common;

public abstract class Clock {
    public abstract Timestamp now();

    public abstract long nowNanos();
}
