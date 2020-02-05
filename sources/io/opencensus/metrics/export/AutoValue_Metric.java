package io.opencensus.metrics.export;

import java.util.List;

final class AutoValue_Metric extends Metric {
    private final MetricDescriptor metricDescriptor;
    private final List<TimeSeries> timeSeriesList;

    AutoValue_Metric(MetricDescriptor metricDescriptor2, List<TimeSeries> list) {
        if (metricDescriptor2 != null) {
            this.metricDescriptor = metricDescriptor2;
            if (list != null) {
                this.timeSeriesList = list;
                return;
            }
            throw new NullPointerException("Null timeSeriesList");
        }
        throw new NullPointerException("Null metricDescriptor");
    }

    public MetricDescriptor getMetricDescriptor() {
        return this.metricDescriptor;
    }

    public List<TimeSeries> getTimeSeriesList() {
        return this.timeSeriesList;
    }

    public String toString() {
        return "Metric{metricDescriptor=" + this.metricDescriptor + ", timeSeriesList=" + this.timeSeriesList + "}";
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Metric)) {
            return false;
        }
        Metric metric = (Metric) obj;
        if (!this.metricDescriptor.equals(metric.getMetricDescriptor()) || !this.timeSeriesList.equals(metric.getTimeSeriesList())) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        return ((this.metricDescriptor.hashCode() ^ 1000003) * 1000003) ^ this.timeSeriesList.hashCode();
    }
}
