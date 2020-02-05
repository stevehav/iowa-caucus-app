package io.opencensus.stats;

import io.opencensus.common.Function;
import io.opencensus.stats.Measure;
import javax.annotation.concurrent.Immutable;

@Immutable
public abstract class Measurement {
    public abstract Measure getMeasure();

    public abstract <T> T match(Function<? super MeasurementDouble, T> function, Function<? super MeasurementLong, T> function2, Function<? super Measurement, T> function3);

    private Measurement() {
    }

    @Immutable
    public static abstract class MeasurementDouble extends Measurement {
        public abstract Measure.MeasureDouble getMeasure();

        public abstract double getValue();

        MeasurementDouble() {
            super();
        }

        public static MeasurementDouble create(Measure.MeasureDouble measureDouble, double d) {
            return new AutoValue_Measurement_MeasurementDouble(measureDouble, d);
        }

        public <T> T match(Function<? super MeasurementDouble, T> function, Function<? super MeasurementLong, T> function2, Function<? super Measurement, T> function3) {
            return function.apply(this);
        }
    }

    @Immutable
    public static abstract class MeasurementLong extends Measurement {
        public abstract Measure.MeasureLong getMeasure();

        public abstract long getValue();

        MeasurementLong() {
            super();
        }

        public static MeasurementLong create(Measure.MeasureLong measureLong, long j) {
            return new AutoValue_Measurement_MeasurementLong(measureLong, j);
        }

        public <T> T match(Function<? super MeasurementDouble, T> function, Function<? super MeasurementLong, T> function2, Function<? super Measurement, T> function3) {
            return function2.apply(this);
        }
    }
}
