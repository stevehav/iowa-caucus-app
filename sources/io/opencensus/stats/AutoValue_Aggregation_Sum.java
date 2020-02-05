package io.opencensus.stats;

import io.opencensus.stats.Aggregation;

final class AutoValue_Aggregation_Sum extends Aggregation.Sum {
    public int hashCode() {
        return 1;
    }

    public String toString() {
        return "Sum{}";
    }

    AutoValue_Aggregation_Sum() {
    }

    public boolean equals(Object obj) {
        return obj == this || (obj instanceof Aggregation.Sum);
    }
}
