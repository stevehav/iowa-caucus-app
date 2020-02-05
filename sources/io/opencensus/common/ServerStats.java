package io.opencensus.common;

import javax.annotation.concurrent.Immutable;

@Immutable
public abstract class ServerStats {
    public abstract long getLbLatencyNs();

    public abstract long getServiceLatencyNs();

    public abstract byte getTraceOption();

    ServerStats() {
    }

    public static ServerStats create(long j, long j2, byte b) {
        if (j < 0) {
            throw new IllegalArgumentException("'getLbLatencyNs' is less than zero: " + j);
        } else if (j2 >= 0) {
            return new AutoValue_ServerStats(j, j2, b);
        } else {
            throw new IllegalArgumentException("'getServiceLatencyNs' is less than zero: " + j2);
        }
    }
}
