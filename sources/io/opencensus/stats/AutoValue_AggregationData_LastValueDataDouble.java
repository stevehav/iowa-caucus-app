package io.opencensus.stats;

import io.opencensus.stats.AggregationData;

final class AutoValue_AggregationData_LastValueDataDouble extends AggregationData.LastValueDataDouble {
    private final double lastValue;

    AutoValue_AggregationData_LastValueDataDouble(double d) {
        this.lastValue = d;
    }

    public double getLastValue() {
        return this.lastValue;
    }

    public String toString() {
        return "LastValueDataDouble{lastValue=" + this.lastValue + "}";
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof AggregationData.LastValueDataDouble) || Double.doubleToLongBits(this.lastValue) != Double.doubleToLongBits(((AggregationData.LastValueDataDouble) obj).getLastValue())) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        return (int) (((long) 1000003) ^ ((Double.doubleToLongBits(this.lastValue) >>> 32) ^ Double.doubleToLongBits(this.lastValue)));
    }
}
