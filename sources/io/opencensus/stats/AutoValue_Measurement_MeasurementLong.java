package io.opencensus.stats;

import io.opencensus.stats.Measure;
import io.opencensus.stats.Measurement;

final class AutoValue_Measurement_MeasurementLong extends Measurement.MeasurementLong {
    private final Measure.MeasureLong measure;
    private final long value;

    AutoValue_Measurement_MeasurementLong(Measure.MeasureLong measureLong, long j) {
        if (measureLong != null) {
            this.measure = measureLong;
            this.value = j;
            return;
        }
        throw new NullPointerException("Null measure");
    }

    public Measure.MeasureLong getMeasure() {
        return this.measure;
    }

    public long getValue() {
        return this.value;
    }

    public String toString() {
        return "MeasurementLong{measure=" + this.measure + ", value=" + this.value + "}";
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Measurement.MeasurementLong)) {
            return false;
        }
        Measurement.MeasurementLong measurementLong = (Measurement.MeasurementLong) obj;
        if (!this.measure.equals(measurementLong.getMeasure()) || this.value != measurementLong.getValue()) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        long j = this.value;
        return (int) (((long) ((this.measure.hashCode() ^ 1000003) * 1000003)) ^ (j ^ (j >>> 32)));
    }
}
