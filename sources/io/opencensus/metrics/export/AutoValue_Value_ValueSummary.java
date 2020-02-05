package io.opencensus.metrics.export;

import io.opencensus.metrics.export.Value;

final class AutoValue_Value_ValueSummary extends Value.ValueSummary {
    private final Summary value;

    AutoValue_Value_ValueSummary(Summary summary) {
        if (summary != null) {
            this.value = summary;
            return;
        }
        throw new NullPointerException("Null value");
    }

    /* access modifiers changed from: package-private */
    public Summary getValue() {
        return this.value;
    }

    public String toString() {
        return "ValueSummary{value=" + this.value + "}";
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof Value.ValueSummary) {
            return this.value.equals(((Value.ValueSummary) obj).getValue());
        }
        return false;
    }

    public int hashCode() {
        return this.value.hashCode() ^ 1000003;
    }
}
