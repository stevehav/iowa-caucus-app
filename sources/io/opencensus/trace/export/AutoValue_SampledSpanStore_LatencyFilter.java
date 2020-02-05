package io.opencensus.trace.export;

import io.opencensus.trace.export.SampledSpanStore;

final class AutoValue_SampledSpanStore_LatencyFilter extends SampledSpanStore.LatencyFilter {
    private final long latencyLowerNs;
    private final long latencyUpperNs;
    private final int maxSpansToReturn;
    private final String spanName;

    AutoValue_SampledSpanStore_LatencyFilter(String str, long j, long j2, int i) {
        if (str != null) {
            this.spanName = str;
            this.latencyLowerNs = j;
            this.latencyUpperNs = j2;
            this.maxSpansToReturn = i;
            return;
        }
        throw new NullPointerException("Null spanName");
    }

    public String getSpanName() {
        return this.spanName;
    }

    public long getLatencyLowerNs() {
        return this.latencyLowerNs;
    }

    public long getLatencyUpperNs() {
        return this.latencyUpperNs;
    }

    public int getMaxSpansToReturn() {
        return this.maxSpansToReturn;
    }

    public String toString() {
        return "LatencyFilter{spanName=" + this.spanName + ", latencyLowerNs=" + this.latencyLowerNs + ", latencyUpperNs=" + this.latencyUpperNs + ", maxSpansToReturn=" + this.maxSpansToReturn + "}";
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof SampledSpanStore.LatencyFilter)) {
            return false;
        }
        SampledSpanStore.LatencyFilter latencyFilter = (SampledSpanStore.LatencyFilter) obj;
        if (this.spanName.equals(latencyFilter.getSpanName()) && this.latencyLowerNs == latencyFilter.getLatencyLowerNs() && this.latencyUpperNs == latencyFilter.getLatencyUpperNs() && this.maxSpansToReturn == latencyFilter.getMaxSpansToReturn()) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        long j = this.latencyLowerNs;
        long j2 = this.latencyUpperNs;
        return (((int) (((long) (((int) (((long) ((this.spanName.hashCode() ^ 1000003) * 1000003)) ^ (j ^ (j >>> 32)))) * 1000003)) ^ (j2 ^ (j2 >>> 32)))) * 1000003) ^ this.maxSpansToReturn;
    }
}
