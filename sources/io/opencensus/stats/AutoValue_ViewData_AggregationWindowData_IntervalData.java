package io.opencensus.stats;

import io.opencensus.common.Timestamp;
import io.opencensus.stats.ViewData;
import javax.annotation.concurrent.Immutable;

@Immutable
@Deprecated
final class AutoValue_ViewData_AggregationWindowData_IntervalData extends ViewData.AggregationWindowData.IntervalData {
    private final Timestamp end;

    AutoValue_ViewData_AggregationWindowData_IntervalData(Timestamp timestamp) {
        if (timestamp != null) {
            this.end = timestamp;
            return;
        }
        throw new NullPointerException("Null end");
    }

    public Timestamp getEnd() {
        return this.end;
    }

    public String toString() {
        return "IntervalData{end=" + this.end + "}";
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof ViewData.AggregationWindowData.IntervalData) {
            return this.end.equals(((ViewData.AggregationWindowData.IntervalData) obj).getEnd());
        }
        return false;
    }

    public int hashCode() {
        return this.end.hashCode() ^ 1000003;
    }
}
