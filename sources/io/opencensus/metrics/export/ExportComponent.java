package io.opencensus.metrics.export;

public abstract class ExportComponent {
    public abstract MetricProducerManager getMetricProducerManager();

    public static ExportComponent newNoopExportComponent() {
        return new NoopExportComponent();
    }

    private static final class NoopExportComponent extends ExportComponent {
        private static final MetricProducerManager METRIC_PRODUCER_MANAGER = MetricProducerManager.newNoopMetricProducerManager();

        private NoopExportComponent() {
        }

        public MetricProducerManager getMetricProducerManager() {
            return METRIC_PRODUCER_MANAGER;
        }
    }
}
