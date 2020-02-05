package io.opencensus.stats;

import io.opencensus.stats.View;
import javax.annotation.concurrent.Immutable;

@Immutable
@Deprecated
final class AutoValue_View_AggregationWindow_Cumulative extends View.AggregationWindow.Cumulative {
    public int hashCode() {
        return 1;
    }

    public String toString() {
        return "Cumulative{}";
    }

    AutoValue_View_AggregationWindow_Cumulative() {
    }

    public boolean equals(Object obj) {
        return obj == this || (obj instanceof View.AggregationWindow.Cumulative);
    }
}
