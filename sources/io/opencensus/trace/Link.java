package io.opencensus.trace;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import javax.annotation.concurrent.Immutable;

@Immutable
public abstract class Link {
    private static final Map<String, AttributeValue> EMPTY_ATTRIBUTES = Collections.emptyMap();

    public enum Type {
        CHILD_LINKED_SPAN,
        PARENT_LINKED_SPAN
    }

    public abstract Map<String, AttributeValue> getAttributes();

    public abstract SpanId getSpanId();

    public abstract TraceId getTraceId();

    public abstract Type getType();

    public static Link fromSpanContext(SpanContext spanContext, Type type) {
        return new AutoValue_Link(spanContext.getTraceId(), spanContext.getSpanId(), type, EMPTY_ATTRIBUTES);
    }

    public static Link fromSpanContext(SpanContext spanContext, Type type, Map<String, AttributeValue> map) {
        return new AutoValue_Link(spanContext.getTraceId(), spanContext.getSpanId(), type, Collections.unmodifiableMap(new HashMap(map)));
    }

    Link() {
    }
}
