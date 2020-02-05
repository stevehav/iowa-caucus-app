package io.opencensus.metrics.export;

import io.opencensus.metrics.export.Summary;

final class AutoValue_Summary_Snapshot_ValueAtPercentile extends Summary.Snapshot.ValueAtPercentile {
    private final double percentile;
    private final double value;

    AutoValue_Summary_Snapshot_ValueAtPercentile(double d, double d2) {
        this.percentile = d;
        this.value = d2;
    }

    public double getPercentile() {
        return this.percentile;
    }

    public double getValue() {
        return this.value;
    }

    public String toString() {
        return "ValueAtPercentile{percentile=" + this.percentile + ", value=" + this.value + "}";
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Summary.Snapshot.ValueAtPercentile)) {
            return false;
        }
        Summary.Snapshot.ValueAtPercentile valueAtPercentile = (Summary.Snapshot.ValueAtPercentile) obj;
        if (Double.doubleToLongBits(this.percentile) == Double.doubleToLongBits(valueAtPercentile.getPercentile()) && Double.doubleToLongBits(this.value) == Double.doubleToLongBits(valueAtPercentile.getValue())) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return (int) (((long) (((int) (((long) 1000003) ^ ((Double.doubleToLongBits(this.percentile) >>> 32) ^ Double.doubleToLongBits(this.percentile)))) * 1000003)) ^ ((Double.doubleToLongBits(this.value) >>> 32) ^ Double.doubleToLongBits(this.value)));
    }
}
