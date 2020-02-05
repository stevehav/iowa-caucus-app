package io.opencensus.stats;

import io.opencensus.stats.Aggregation;
import javax.annotation.concurrent.Immutable;

@Immutable
@Deprecated
final class AutoValue_Aggregation_Mean extends Aggregation.Mean {
    public int hashCode() {
        return 1;
    }

    public String toString() {
        return "Mean{}";
    }

    AutoValue_Aggregation_Mean() {
    }

    public boolean equals(Object obj) {
        return obj == this || (obj instanceof Aggregation.Mean);
    }
}
