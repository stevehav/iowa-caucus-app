package io.opencensus.metrics.export;

import io.opencensus.metrics.export.Value;

final class AutoValue_Value_ValueDistribution extends Value.ValueDistribution {
    private final Distribution value;

    AutoValue_Value_ValueDistribution(Distribution distribution) {
        if (distribution != null) {
            this.value = distribution;
            return;
        }
        throw new NullPointerException("Null value");
    }

    /* access modifiers changed from: package-private */
    public Distribution getValue() {
        return this.value;
    }

    public String toString() {
        return "ValueDistribution{value=" + this.value + "}";
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof Value.ValueDistribution) {
            return this.value.equals(((Value.ValueDistribution) obj).getValue());
        }
        return false;
    }

    public int hashCode() {
        return this.value.hashCode() ^ 1000003;
    }
}
