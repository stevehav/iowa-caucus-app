package io.opencensus.metrics.export;

import io.opencensus.metrics.export.Value;

final class AutoValue_Value_ValueLong extends Value.ValueLong {
    private final long value;

    AutoValue_Value_ValueLong(long j) {
        this.value = j;
    }

    /* access modifiers changed from: package-private */
    public long getValue() {
        return this.value;
    }

    public String toString() {
        return "ValueLong{value=" + this.value + "}";
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Value.ValueLong) || this.value != ((Value.ValueLong) obj).getValue()) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        long j = this.value;
        return (int) (((long) 1000003) ^ (j ^ (j >>> 32)));
    }
}
