package io.opencensus.metrics.export;

import io.opencensus.common.Timestamp;

final class AutoValue_Point extends Point {
    private final Timestamp timestamp;
    private final Value value;

    AutoValue_Point(Value value2, Timestamp timestamp2) {
        if (value2 != null) {
            this.value = value2;
            if (timestamp2 != null) {
                this.timestamp = timestamp2;
                return;
            }
            throw new NullPointerException("Null timestamp");
        }
        throw new NullPointerException("Null value");
    }

    public Value getValue() {
        return this.value;
    }

    public Timestamp getTimestamp() {
        return this.timestamp;
    }

    public String toString() {
        return "Point{value=" + this.value + ", timestamp=" + this.timestamp + "}";
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Point)) {
            return false;
        }
        Point point = (Point) obj;
        if (!this.value.equals(point.getValue()) || !this.timestamp.equals(point.getTimestamp())) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        return ((this.value.hashCode() ^ 1000003) * 1000003) ^ this.timestamp.hashCode();
    }
}
