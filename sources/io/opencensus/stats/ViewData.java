package io.opencensus.stats;

import io.opencensus.common.Duration;
import io.opencensus.common.Function;
import io.opencensus.common.Functions;
import io.opencensus.common.Timestamp;
import io.opencensus.stats.Aggregation;
import io.opencensus.stats.AggregationData;
import io.opencensus.stats.Measure;
import io.opencensus.stats.View;
import io.opencensus.tags.TagValue;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.concurrent.Immutable;

@Immutable
public abstract class ViewData {
    public abstract Map<List<TagValue>, AggregationData> getAggregationMap();

    public abstract Timestamp getEnd();

    public abstract Timestamp getStart();

    public abstract View getView();

    @Deprecated
    public abstract AggregationWindowData getWindowData();

    ViewData() {
    }

    @Deprecated
    public static ViewData create(final View view, Map<? extends List<TagValue>, ? extends AggregationData> map, AggregationWindowData aggregationWindowData) {
        checkWindow(view.getWindow(), aggregationWindowData);
        final HashMap hashMap = new HashMap();
        for (Map.Entry next : map.entrySet()) {
            checkAggregation(view.getAggregation(), (AggregationData) next.getValue(), view.getMeasure());
            hashMap.put(Collections.unmodifiableList(new ArrayList((Collection) next.getKey())), next.getValue());
        }
        return (ViewData) aggregationWindowData.match(new Function<AggregationWindowData.CumulativeData, ViewData>() {
            public ViewData apply(AggregationWindowData.CumulativeData cumulativeData) {
                return ViewData.createInternal(View.this, Collections.unmodifiableMap(hashMap), cumulativeData, cumulativeData.getStart(), cumulativeData.getEnd());
            }
        }, new Function<AggregationWindowData.IntervalData, ViewData>() {
            public ViewData apply(AggregationWindowData.IntervalData intervalData) {
                Duration duration = ((View.AggregationWindow.Interval) View.this.getWindow()).getDuration();
                return ViewData.createInternal(View.this, Collections.unmodifiableMap(hashMap), intervalData, intervalData.getEnd().addDuration(Duration.create(-duration.getSeconds(), -duration.getNanos())), intervalData.getEnd());
            }
        }, Functions.throwAssertionError());
    }

    public static ViewData create(View view, Map<? extends List<TagValue>, ? extends AggregationData> map, Timestamp timestamp, Timestamp timestamp2) {
        HashMap hashMap = new HashMap();
        for (Map.Entry next : map.entrySet()) {
            checkAggregation(view.getAggregation(), (AggregationData) next.getValue(), view.getMeasure());
            hashMap.put(Collections.unmodifiableList(new ArrayList((Collection) next.getKey())), next.getValue());
        }
        return createInternal(view, Collections.unmodifiableMap(hashMap), AggregationWindowData.CumulativeData.create(timestamp, timestamp2), timestamp, timestamp2);
    }

    /* access modifiers changed from: private */
    public static ViewData createInternal(View view, Map<List<TagValue>, AggregationData> map, AggregationWindowData aggregationWindowData, Timestamp timestamp, Timestamp timestamp2) {
        return new AutoValue_ViewData(view, map, aggregationWindowData, timestamp, timestamp2);
    }

    private static void checkWindow(View.AggregationWindow aggregationWindow, final AggregationWindowData aggregationWindowData) {
        aggregationWindow.match(new Function<View.AggregationWindow.Cumulative, Void>() {
            public Void apply(View.AggregationWindow.Cumulative cumulative) {
                AggregationWindowData aggregationWindowData = AggregationWindowData.this;
                ViewData.throwIfWindowMismatch(aggregationWindowData instanceof AggregationWindowData.CumulativeData, cumulative, aggregationWindowData);
                return null;
            }
        }, new Function<View.AggregationWindow.Interval, Void>() {
            public Void apply(View.AggregationWindow.Interval interval) {
                AggregationWindowData aggregationWindowData = AggregationWindowData.this;
                ViewData.throwIfWindowMismatch(aggregationWindowData instanceof AggregationWindowData.IntervalData, interval, aggregationWindowData);
                return null;
            }
        }, Functions.throwAssertionError());
    }

    /* access modifiers changed from: private */
    public static void throwIfWindowMismatch(boolean z, View.AggregationWindow aggregationWindow, AggregationWindowData aggregationWindowData) {
        if (!z) {
            throw new IllegalArgumentException(createErrorMessageForWindow(aggregationWindow, aggregationWindowData));
        }
    }

    private static String createErrorMessageForWindow(View.AggregationWindow aggregationWindow, AggregationWindowData aggregationWindowData) {
        return "AggregationWindow and AggregationWindowData types mismatch. AggregationWindow: " + aggregationWindow.getClass().getSimpleName() + " AggregationWindowData: " + aggregationWindowData.getClass().getSimpleName();
    }

    private static void checkAggregation(final Aggregation aggregation, final AggregationData aggregationData, final Measure measure) {
        aggregation.match(new Function<Aggregation.Sum, Void>() {
            public Void apply(Aggregation.Sum sum) {
                Measure.this.match(new Function<Measure.MeasureDouble, Void>() {
                    public Void apply(Measure.MeasureDouble measureDouble) {
                        ViewData.throwIfAggregationMismatch(aggregationData instanceof AggregationData.SumDataDouble, aggregation, aggregationData);
                        return null;
                    }
                }, new Function<Measure.MeasureLong, Void>() {
                    public Void apply(Measure.MeasureLong measureLong) {
                        ViewData.throwIfAggregationMismatch(aggregationData instanceof AggregationData.SumDataLong, aggregation, aggregationData);
                        return null;
                    }
                }, Functions.throwAssertionError());
                return null;
            }
        }, new Function<Aggregation.Count, Void>() {
            public Void apply(Aggregation.Count count) {
                AggregationData aggregationData = AggregationData.this;
                ViewData.throwIfAggregationMismatch(aggregationData instanceof AggregationData.CountData, aggregation, aggregationData);
                return null;
            }
        }, new Function<Aggregation.Distribution, Void>() {
            public Void apply(Aggregation.Distribution distribution) {
                AggregationData aggregationData = AggregationData.this;
                ViewData.throwIfAggregationMismatch(aggregationData instanceof AggregationData.DistributionData, aggregation, aggregationData);
                return null;
            }
        }, new Function<Aggregation.LastValue, Void>() {
            public Void apply(Aggregation.LastValue lastValue) {
                Measure.this.match(new Function<Measure.MeasureDouble, Void>() {
                    public Void apply(Measure.MeasureDouble measureDouble) {
                        ViewData.throwIfAggregationMismatch(aggregationData instanceof AggregationData.LastValueDataDouble, aggregation, aggregationData);
                        return null;
                    }
                }, new Function<Measure.MeasureLong, Void>() {
                    public Void apply(Measure.MeasureLong measureLong) {
                        ViewData.throwIfAggregationMismatch(aggregationData instanceof AggregationData.LastValueDataLong, aggregation, aggregationData);
                        return null;
                    }
                }, Functions.throwAssertionError());
                return null;
            }
        }, new Function<Aggregation, Void>() {
            public Void apply(Aggregation aggregation) {
                if (aggregation instanceof Aggregation.Mean) {
                    AggregationData aggregationData = AggregationData.this;
                    ViewData.throwIfAggregationMismatch(aggregationData instanceof AggregationData.MeanData, aggregation, aggregationData);
                    return null;
                }
                throw new AssertionError();
            }
        });
    }

    /* access modifiers changed from: private */
    public static void throwIfAggregationMismatch(boolean z, Aggregation aggregation, AggregationData aggregationData) {
        if (!z) {
            throw new IllegalArgumentException(createErrorMessageForAggregation(aggregation, aggregationData));
        }
    }

    private static String createErrorMessageForAggregation(Aggregation aggregation, AggregationData aggregationData) {
        return "Aggregation and AggregationData types mismatch. Aggregation: " + aggregation.getClass().getSimpleName() + " AggregationData: " + aggregationData.getClass().getSimpleName();
    }

    @Immutable
    @Deprecated
    public static abstract class AggregationWindowData {
        public abstract <T> T match(Function<? super CumulativeData, T> function, Function<? super IntervalData, T> function2, Function<? super AggregationWindowData, T> function3);

        private AggregationWindowData() {
        }

        @Immutable
        @Deprecated
        public static abstract class CumulativeData extends AggregationWindowData {
            public abstract Timestamp getEnd();

            public abstract Timestamp getStart();

            CumulativeData() {
                super();
            }

            public final <T> T match(Function<? super CumulativeData, T> function, Function<? super IntervalData, T> function2, Function<? super AggregationWindowData, T> function3) {
                return function.apply(this);
            }

            public static CumulativeData create(Timestamp timestamp, Timestamp timestamp2) {
                if (timestamp.compareTo(timestamp2) <= 0) {
                    return new AutoValue_ViewData_AggregationWindowData_CumulativeData(timestamp, timestamp2);
                }
                throw new IllegalArgumentException("Start time is later than end time.");
            }
        }

        @Immutable
        @Deprecated
        public static abstract class IntervalData extends AggregationWindowData {
            public abstract Timestamp getEnd();

            IntervalData() {
                super();
            }

            public final <T> T match(Function<? super CumulativeData, T> function, Function<? super IntervalData, T> function2, Function<? super AggregationWindowData, T> function3) {
                return function2.apply(this);
            }

            public static IntervalData create(Timestamp timestamp) {
                return new AutoValue_ViewData_AggregationWindowData_IntervalData(timestamp);
            }
        }
    }
}
