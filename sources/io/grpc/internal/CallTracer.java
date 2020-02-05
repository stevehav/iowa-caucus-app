package io.grpc.internal;

import io.grpc.InternalChannelz;

final class CallTracer {
    static final Factory DEFAULT_FACTORY = new Factory() {
        public CallTracer create() {
            return new CallTracer(TimeProvider.SYSTEM_TIME_PROVIDER);
        }
    };
    private final LongCounter callsFailed = LongCounterFactory.create();
    private final LongCounter callsStarted = LongCounterFactory.create();
    private final LongCounter callsSucceeded = LongCounterFactory.create();
    private volatile long lastCallStartedNanos;
    private final TimeProvider timeProvider;

    public interface Factory {
        CallTracer create();
    }

    CallTracer(TimeProvider timeProvider2) {
        this.timeProvider = timeProvider2;
    }

    public void reportCallStarted() {
        this.callsStarted.add(1);
        this.lastCallStartedNanos = this.timeProvider.currentTimeNanos();
    }

    public void reportCallEnded(boolean z) {
        if (z) {
            this.callsSucceeded.add(1);
        } else {
            this.callsFailed.add(1);
        }
    }

    /* access modifiers changed from: package-private */
    public void updateBuilder(InternalChannelz.ChannelStats.Builder builder) {
        builder.setCallsStarted(this.callsStarted.value()).setCallsSucceeded(this.callsSucceeded.value()).setCallsFailed(this.callsFailed.value()).setLastCallStartedNanos(this.lastCallStartedNanos);
    }

    /* access modifiers changed from: package-private */
    public void updateBuilder(InternalChannelz.ServerStats.Builder builder) {
        builder.setCallsStarted(this.callsStarted.value()).setCallsSucceeded(this.callsSucceeded.value()).setCallsFailed(this.callsFailed.value()).setLastCallStartedNanos(this.lastCallStartedNanos);
    }

    public static Factory getDefaultFactory() {
        return DEFAULT_FACTORY;
    }
}
