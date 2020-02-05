package io.opencensus.stats;

import io.opencensus.stats.AggregationData;

final class AutoValue_AggregationData_LastValueDataLong extends AggregationData.LastValueDataLong {
    private final long lastValue;

    AutoValue_AggregationData_LastValueDataLong(long j) {
        this.lastValue = j;
    }

    public long getLastValue() {
        return this.lastValue;
    }

    public String toString() {
        return "LastValueDataLong{lastValue=" + this.lastValue + "}";
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof AggregationData.LastValueDataLong) || this.lastValue != ((AggregationData.LastValueDataLong) obj).getLastValue()) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        long j = this.lastValue;
        return (int) (((long) 1000003) ^ (j ^ (j >>> 32)));
    }
}
