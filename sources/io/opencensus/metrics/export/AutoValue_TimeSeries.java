package io.opencensus.metrics.export;

import io.opencensus.common.Timestamp;
import io.opencensus.metrics.LabelValue;
import java.util.List;
import javax.annotation.Nullable;

final class AutoValue_TimeSeries extends TimeSeries {
    private final List<LabelValue> labelValues;
    private final List<Point> points;
    private final Timestamp startTimestamp;

    AutoValue_TimeSeries(List<LabelValue> list, List<Point> list2, @Nullable Timestamp timestamp) {
        if (list != null) {
            this.labelValues = list;
            if (list2 != null) {
                this.points = list2;
                this.startTimestamp = timestamp;
                return;
            }
            throw new NullPointerException("Null points");
        }
        throw new NullPointerException("Null labelValues");
    }

    public List<LabelValue> getLabelValues() {
        return this.labelValues;
    }

    public List<Point> getPoints() {
        return this.points;
    }

    @Nullable
    public Timestamp getStartTimestamp() {
        return this.startTimestamp;
    }

    public String toString() {
        return "TimeSeries{labelValues=" + this.labelValues + ", points=" + this.points + ", startTimestamp=" + this.startTimestamp + "}";
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof TimeSeries)) {
            return false;
        }
        TimeSeries timeSeries = (TimeSeries) obj;
        if (this.labelValues.equals(timeSeries.getLabelValues()) && this.points.equals(timeSeries.getPoints())) {
            Timestamp timestamp = this.startTimestamp;
            if (timestamp == null) {
                if (timeSeries.getStartTimestamp() == null) {
                    return true;
                }
            } else if (timestamp.equals(timeSeries.getStartTimestamp())) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        int hashCode = (((this.labelValues.hashCode() ^ 1000003) * 1000003) ^ this.points.hashCode()) * 1000003;
        Timestamp timestamp = this.startTimestamp;
        return hashCode ^ (timestamp == null ? 0 : timestamp.hashCode());
    }
}
