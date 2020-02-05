package io.opencensus.metrics.export;

import io.opencensus.internal.Utils;
import java.util.Collections;
import java.util.Set;
import javax.annotation.concurrent.ThreadSafe;

@ThreadSafe
public abstract class MetricProducerManager {
    public abstract void add(MetricProducer metricProducer);

    public abstract Set<MetricProducer> getAllMetricProducer();

    public abstract void remove(MetricProducer metricProducer);

    static MetricProducerManager newNoopMetricProducerManager() {
        return new NoopMetricProducerManager();
    }

    private static final class NoopMetricProducerManager extends MetricProducerManager {
        private NoopMetricProducerManager() {
        }

        public void add(MetricProducer metricProducer) {
            Utils.checkNotNull(metricProducer, "metricProducer");
        }

        public void remove(MetricProducer metricProducer) {
            Utils.checkNotNull(metricProducer, "metricProducer");
        }

        public Set<MetricProducer> getAllMetricProducer() {
            return Collections.emptySet();
        }
    }
}
