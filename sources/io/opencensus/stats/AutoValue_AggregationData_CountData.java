package io.opencensus.stats;

import io.opencensus.stats.AggregationData;

final class AutoValue_AggregationData_CountData extends AggregationData.CountData {
    private final long count;

    AutoValue_AggregationData_CountData(long j) {
        this.count = j;
    }

    public long getCount() {
        return this.count;
    }

    public String toString() {
        return "CountData{count=" + this.count + "}";
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof AggregationData.CountData) || this.count != ((AggregationData.CountData) obj).getCount()) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        long j = this.count;
        return (int) (((long) 1000003) ^ (j ^ (j >>> 32)));
    }
}
