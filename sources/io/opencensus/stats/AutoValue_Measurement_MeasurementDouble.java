package io.opencensus.stats;

import io.opencensus.stats.Measure;
import io.opencensus.stats.Measurement;

final class AutoValue_Measurement_MeasurementDouble extends Measurement.MeasurementDouble {
    private final Measure.MeasureDouble measure;
    private final double value;

    AutoValue_Measurement_MeasurementDouble(Measure.MeasureDouble measureDouble, double d) {
        if (measureDouble != null) {
            this.measure = measureDouble;
            this.value = d;
            return;
        }
        throw new NullPointerException("Null measure");
    }

    public Measure.MeasureDouble getMeasure() {
        return this.measure;
    }

    public double getValue() {
        return this.value;
    }

    public String toString() {
        return "MeasurementDouble{measure=" + this.measure + ", value=" + this.value + "}";
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Measurement.MeasurementDouble)) {
            return false;
        }
        Measurement.MeasurementDouble measurementDouble = (Measurement.MeasurementDouble) obj;
        if (!this.measure.equals(measurementDouble.getMeasure()) || Double.doubleToLongBits(this.value) != Double.doubleToLongBits(measurementDouble.getValue())) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        return (int) (((long) ((this.measure.hashCode() ^ 1000003) * 1000003)) ^ ((Double.doubleToLongBits(this.value) >>> 32) ^ Double.doubleToLongBits(this.value)));
    }
}
