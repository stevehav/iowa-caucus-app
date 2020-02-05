package io.opencensus.stats;

import io.opencensus.stats.Aggregation;

final class AutoValue_Aggregation_LastValue extends Aggregation.LastValue {
    public int hashCode() {
        return 1;
    }

    public String toString() {
        return "LastValue{}";
    }

    AutoValue_Aggregation_LastValue() {
    }

    public boolean equals(Object obj) {
        return obj == this || (obj instanceof Aggregation.LastValue);
    }
}
