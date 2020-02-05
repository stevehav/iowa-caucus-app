package io.opencensus.metrics.export;

import io.opencensus.common.Timestamp;
import javax.annotation.concurrent.Immutable;

@Immutable
public abstract class Point {
    public abstract Timestamp getTimestamp();

    public abstract Value getValue();

    Point() {
    }

    public static Point create(Value value, Timestamp timestamp) {
        return new AutoValue_Point(value, timestamp);
    }
}
