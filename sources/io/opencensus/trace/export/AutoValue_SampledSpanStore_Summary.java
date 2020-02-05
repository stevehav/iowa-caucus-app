package io.opencensus.trace.export;

import io.opencensus.trace.export.SampledSpanStore;
import java.util.Map;

final class AutoValue_SampledSpanStore_Summary extends SampledSpanStore.Summary {
    private final Map<String, SampledSpanStore.PerSpanNameSummary> perSpanNameSummary;

    AutoValue_SampledSpanStore_Summary(Map<String, SampledSpanStore.PerSpanNameSummary> map) {
        if (map != null) {
            this.perSpanNameSummary = map;
            return;
        }
        throw new NullPointerException("Null perSpanNameSummary");
    }

    public Map<String, SampledSpanStore.PerSpanNameSummary> getPerSpanNameSummary() {
        return this.perSpanNameSummary;
    }

    public String toString() {
        return "Summary{perSpanNameSummary=" + this.perSpanNameSummary + "}";
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof SampledSpanStore.Summary) {
            return this.perSpanNameSummary.equals(((SampledSpanStore.Summary) obj).getPerSpanNameSummary());
        }
        return false;
    }

    public int hashCode() {
        return this.perSpanNameSummary.hashCode() ^ 1000003;
    }
}
