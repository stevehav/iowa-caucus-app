package io.opencensus.metrics.export;

import io.opencensus.metrics.export.Value;

final class AutoValue_Value_ValueDouble extends Value.ValueDouble {
    private final double value;

    AutoValue_Value_ValueDouble(double d) {
        this.value = d;
    }

    /* access modifiers changed from: package-private */
    public double getValue() {
        return this.value;
    }

    public String toString() {
        return "ValueDouble{value=" + this.value + "}";
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Value.ValueDouble) || Double.doubleToLongBits(this.value) != Double.doubleToLongBits(((Value.ValueDouble) obj).getValue())) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        return (int) (((long) 1000003) ^ ((Double.doubleToLongBits(this.value) >>> 32) ^ Double.doubleToLongBits(this.value)));
    }
}
