package io.opencensus.stats;

import java.util.List;

final class AutoValue_BucketBoundaries extends BucketBoundaries {
    private final List<Double> boundaries;

    AutoValue_BucketBoundaries(List<Double> list) {
        if (list != null) {
            this.boundaries = list;
            return;
        }
        throw new NullPointerException("Null boundaries");
    }

    public List<Double> getBoundaries() {
        return this.boundaries;
    }

    public String toString() {
        return "BucketBoundaries{boundaries=" + this.boundaries + "}";
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof BucketBoundaries) {
            return this.boundaries.equals(((BucketBoundaries) obj).getBoundaries());
        }
        return false;
    }

    public int hashCode() {
        return this.boundaries.hashCode() ^ 1000003;
    }
}
