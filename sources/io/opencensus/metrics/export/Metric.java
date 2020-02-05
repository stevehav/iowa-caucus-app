package io.opencensus.metrics.export;

import io.opencensus.internal.Utils;
import io.opencensus.metrics.export.MetricDescriptor;
import io.opencensus.metrics.export.Value;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.annotation.concurrent.Immutable;

@Immutable
public abstract class Metric {
    public abstract MetricDescriptor getMetricDescriptor();

    public abstract List<TimeSeries> getTimeSeriesList();

    Metric() {
    }

    public static Metric create(MetricDescriptor metricDescriptor, List<TimeSeries> list) {
        Utils.checkListElementNotNull((List) Utils.checkNotNull(list, "timeSeriesList"), "timeSeries");
        return createInternal(metricDescriptor, Collections.unmodifiableList(new ArrayList(list)));
    }

    public static Metric createWithOneTimeSeries(MetricDescriptor metricDescriptor, TimeSeries timeSeries) {
        return createInternal(metricDescriptor, Collections.singletonList(Utils.checkNotNull(timeSeries, "timeSeries")));
    }

    private static Metric createInternal(MetricDescriptor metricDescriptor, List<TimeSeries> list) {
        Utils.checkNotNull(metricDescriptor, "metricDescriptor");
        checkTypeMatch(metricDescriptor.getType(), list);
        return new AutoValue_Metric(metricDescriptor, list);
    }

    private static void checkTypeMatch(MetricDescriptor.Type type, List<TimeSeries> list) {
        for (TimeSeries points : list) {
            for (Point value : points.getPoints()) {
                Value value2 = value.getValue();
                String simpleName = value2.getClass().getSuperclass() != null ? value2.getClass().getSuperclass().getSimpleName() : "";
                switch (type) {
                    case GAUGE_INT64:
                    case CUMULATIVE_INT64:
                        Utils.checkArgument(value2 instanceof Value.ValueLong, "Type mismatch: %s, %s.", type, simpleName);
                        break;
                    case CUMULATIVE_DOUBLE:
                    case GAUGE_DOUBLE:
                        Utils.checkArgument(value2 instanceof Value.ValueDouble, "Type mismatch: %s, %s.", type, simpleName);
                        break;
                    case GAUGE_DISTRIBUTION:
                    case CUMULATIVE_DISTRIBUTION:
                        Utils.checkArgument(value2 instanceof Value.ValueDistribution, "Type mismatch: %s, %s.", type, simpleName);
                        break;
                    case SUMMARY:
                        Utils.checkArgument(value2 instanceof Value.ValueSummary, "Type mismatch: %s, %s.", type, simpleName);
                        break;
                }
            }
        }
    }
}
