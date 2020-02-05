package io.opencensus.metrics.export;

import java.util.Collection;

public abstract class MetricProducer {
    public abstract Collection<Metric> getMetrics();
}
