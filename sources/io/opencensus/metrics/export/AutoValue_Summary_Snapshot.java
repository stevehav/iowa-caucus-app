package io.opencensus.metrics.export;

import io.opencensus.metrics.export.Summary;
import java.util.List;
import javax.annotation.Nullable;

final class AutoValue_Summary_Snapshot extends Summary.Snapshot {
    private final Long count;
    private final Double sum;
    private final List<Summary.Snapshot.ValueAtPercentile> valueAtPercentiles;

    AutoValue_Summary_Snapshot(@Nullable Long l, @Nullable Double d, List<Summary.Snapshot.ValueAtPercentile> list) {
        this.count = l;
        this.sum = d;
        if (list != null) {
            this.valueAtPercentiles = list;
            return;
        }
        throw new NullPointerException("Null valueAtPercentiles");
    }

    @Nullable
    public Long getCount() {
        return this.count;
    }

    @Nullable
    public Double getSum() {
        return this.sum;
    }

    public List<Summary.Snapshot.ValueAtPercentile> getValueAtPercentiles() {
        return this.valueAtPercentiles;
    }

    public String toString() {
        return "Snapshot{count=" + this.count + ", sum=" + this.sum + ", valueAtPercentiles=" + this.valueAtPercentiles + "}";
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Summary.Snapshot)) {
            return false;
        }
        Summary.Snapshot snapshot = (Summary.Snapshot) obj;
        Long l = this.count;
        if (l != null ? l.equals(snapshot.getCount()) : snapshot.getCount() == null) {
            Double d = this.sum;
            if (d != null ? d.equals(snapshot.getSum()) : snapshot.getSum() == null) {
                if (this.valueAtPercentiles.equals(snapshot.getValueAtPercentiles())) {
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
        return ((hashCode ^ i) * 1000003) ^ this.valueAtPercentiles.hashCode();
    }
}
