package io.opencensus.trace;

import java.util.Arrays;
import javax.annotation.Nullable;
import javax.annotation.concurrent.Immutable;

@Immutable
public final class SpanContext {
    public static final SpanContext INVALID = new SpanContext(TraceId.INVALID, SpanId.INVALID, TraceOptions.DEFAULT, TRACESTATE_DEFAULT);
    private static final Tracestate TRACESTATE_DEFAULT = Tracestate.builder().build();
    private final SpanId spanId;
    private final TraceId traceId;
    private final TraceOptions traceOptions;
    private final Tracestate tracestate;

    @Deprecated
    public static SpanContext create(TraceId traceId2, SpanId spanId2, TraceOptions traceOptions2) {
        return create(traceId2, spanId2, traceOptions2, TRACESTATE_DEFAULT);
    }

    public static SpanContext create(TraceId traceId2, SpanId spanId2, TraceOptions traceOptions2, Tracestate tracestate2) {
        return new SpanContext(traceId2, spanId2, traceOptions2, tracestate2);
    }

    public TraceId getTraceId() {
        return this.traceId;
    }

    public SpanId getSpanId() {
        return this.spanId;
    }

    public TraceOptions getTraceOptions() {
        return this.traceOptions;
    }

    public Tracestate getTracestate() {
        return this.tracestate;
    }

    public boolean isValid() {
        return this.traceId.isValid() && this.spanId.isValid();
    }

    public boolean equals(@Nullable Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof SpanContext)) {
            return false;
        }
        SpanContext spanContext = (SpanContext) obj;
        if (!this.traceId.equals(spanContext.traceId) || !this.spanId.equals(spanContext.spanId) || !this.traceOptions.equals(spanContext.traceOptions)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{this.traceId, this.spanId, this.traceOptions});
    }

    public String toString() {
        return "SpanContext{traceId=" + this.traceId + ", spanId=" + this.spanId + ", traceOptions=" + this.traceOptions + "}";
    }

    private SpanContext(TraceId traceId2, SpanId spanId2, TraceOptions traceOptions2, Tracestate tracestate2) {
        this.traceId = traceId2;
        this.spanId = spanId2;
        this.traceOptions = traceOptions2;
        this.tracestate = tracestate2;
    }
}
