package io.opencensus.stats;

import io.opencensus.stats.Aggregation;

final class AutoValue_Aggregation_Distribution extends Aggregation.Distribution {
    private final BucketBoundaries bucketBoundaries;

    AutoValue_Aggregation_Distribution(BucketBoundaries bucketBoundaries2) {
        if (bucketBoundaries2 != null) {
            this.bucketBoundaries = bucketBoundaries2;
            return;
        }
        throw new NullPointerException("Null bucketBoundaries");
    }

    public BucketBoundaries getBucketBoundaries() {
        return this.bucketBoundaries;
    }

    public String toString() {
        return "Distribution{bucketBoundaries=" + this.bucketBoundaries + "}";
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof Aggregation.Distribution) {
            return this.bucketBoundaries.equals(((Aggregation.Distribution) obj).getBucketBoundaries());
        }
        return false;
    }

    public int hashCode() {
        return this.bucketBoundaries.hashCode() ^ 1000003;
    }
}
