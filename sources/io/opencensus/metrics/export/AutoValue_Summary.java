package io.opencensus.metrics.export;

import io.opencensus.metrics.export.Summary;
import javax.annotation.Nullable;

final class AutoValue_Summary extends Summary {
    private final Long count;
    private final Summary.Snapshot snapshot;
    private final Double sum;

    AutoValue_Summary(@Nullable Long l, @Nullable Double d, Summary.Snapshot snapshot2) {
        this.count = l;
        this.sum = d;
        if (snapshot2 != null) {
            this.snapshot = snapshot2;
            return;
        }
        throw new NullPointerException("Null snapshot");
    }

    @Nullable
    public Long getCount() {
        return this.count;
    }

    @Nullable
    public Double getSum() {
        return this.sum;
    }

    public Summary.Snapshot getSnapshot() {
        return this.snapshot;
    }

    public String toString() {
        return "Summary{count=" + this.count + ", sum=" + this.sum + ", snapshot=" + this.snapshot + "}";
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Summary)) {
            return false;
        }
        Summary summary = (Summary) obj;
        Long l = this.count;
        if (l != null ? l.equals(summary.getCount()) : summary.getCount() == null) {
            Double d = this.sum;
            if (d != null ? d.equals(summary.getSum()) : summary.getSum() == null) {
                if (this.snapshot.equals(summary.getSnapshot())) {
                    return true;
                }
            }
        }
        return false;
    }

    public int hashCode() {
        Long l = this.count;
        int i = 0;
        int hashCode = ((l == null ? 0 : l.hashCode()) ^ 1000003) * 1000003;
        Double d = this.sum;
        if (d != null) {
            i = d.hashCode();
        }
        return ((hashCode ^ i) * 1000003) ^ this.snapshot.hashCode();
    }
}
