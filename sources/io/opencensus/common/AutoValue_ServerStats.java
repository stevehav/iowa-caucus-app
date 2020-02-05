package io.opencensus.common;

final class AutoValue_ServerStats extends ServerStats {
    private final long lbLatencyNs;
    private final long serviceLatencyNs;
    private final byte traceOption;

    AutoValue_ServerStats(long j, long j2, byte b) {
        this.lbLatencyNs = j;
        this.serviceLatencyNs = j2;
        this.traceOption = b;
    }

    public long getLbLatencyNs() {
        return this.lbLatencyNs;
    }

    public long getServiceLatencyNs() {
        return this.serviceLatencyNs;
    }

    public byte getTraceOption() {
        return this.traceOption;
    }

    public String toString() {
        return "ServerStats{lbLatencyNs=" + this.lbLatencyNs + ", serviceLatencyNs=" + this.serviceLatencyNs + ", traceOption=" + this.traceOption + "}";
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ServerStats)) {
            return false;
        }
        ServerStats serverStats = (ServerStats) obj;
        if (this.lbLatencyNs == serverStats.getLbLatencyNs() && this.serviceLatencyNs == serverStats.getServiceLatencyNs() && this.traceOption == serverStats.getTraceOption()) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        long j = this.lbLatencyNs;
        long j2 = this.serviceLatencyNs;
        return this.traceOption ^ (((int) (((long) (((int) (((long) 1000003) ^ (j ^ (j >>> 32)))) * 1000003)) ^ (j2 ^ (j2 >>> 32)))) * 1000003);
    }
}
