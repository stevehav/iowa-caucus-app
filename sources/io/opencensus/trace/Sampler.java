package io.opencensus.trace;

import java.util.List;
import javax.annotation.Nullable;

public abstract class Sampler {
    public abstract String getDescription();

    public abstract boolean shouldSample(@Nullable SpanContext spanContext, @Nullable Boolean bool, TraceId traceId, SpanId spanId, String str, List<Span> list);
}
