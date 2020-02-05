package io.opencensus.trace.export;

import io.opencensus.common.Timestamp;
import io.opencensus.trace.Annotation;
import io.opencensus.trace.MessageEvent;
import io.opencensus.trace.Span;
import io.opencensus.trace.SpanContext;
import io.opencensus.trace.SpanId;
import io.opencensus.trace.Status;
import io.opencensus.trace.export.SpanData;
import javax.annotation.Nullable;

final class AutoValue_SpanData extends SpanData {
    private final SpanData.TimedEvents<Annotation> annotations;
    private final SpanData.Attributes attributes;
    private final Integer childSpanCount;
    private final SpanContext context;
    private final Timestamp endTimestamp;
    private final Boolean hasRemoteParent;
    private final Span.Kind kind;
    private final SpanData.Links links;
    private final SpanData.TimedEvents<MessageEvent> messageEvents;
    private final String name;
    private final SpanId parentSpanId;
    private final Timestamp startTimestamp;
    private final Status status;

    AutoValue_SpanData(SpanContext spanContext, @Nullable SpanId spanId, @Nullable Boolean bool, String str, @Nullable Span.Kind kind2, Timestamp timestamp, SpanData.Attributes attributes2, SpanData.TimedEvents<Annotation> timedEvents, SpanData.TimedEvents<MessageEvent> timedEvents2, SpanData.Links links2, @Nullable Integer num, @Nullable Status status2, @Nullable Timestamp timestamp2) {
        if (spanContext != null) {
            this.context = spanContext;
            this.parentSpanId = spanId;
            this.hasRemoteParent = bool;
            if (str != null) {
                this.name = str;
                this.kind = kind2;
                if (timestamp != null) {
                    this.startTimestamp = timestamp;
                    if (attributes2 != null) {
                        this.attributes = attributes2;
                        if (timedEvents != null) {
                            this.annotations = timedEvents;
                            if (timedEvents2 != null) {
                                this.messageEvents = timedEvents2;
                                if (links2 != null) {
                                    this.links = links2;
                                    this.childSpanCount = num;
                                    this.status = status2;
                                    this.endTimestamp = timestamp2;
                                    return;
                                }
                                throw new NullPointerException("Null links");
                            }
                            throw new NullPointerException("Null messageEvents");
                        }
                        throw new NullPointerException("Null annotations");
                    }
                    throw new NullPointerException("Null attributes");
                }
                throw new NullPointerException("Null startTimestamp");
            }
            throw new NullPointerException("Null name");
        }
        throw new NullPointerException("Null context");
    }

    public SpanContext getContext() {
        return this.context;
    }

    @Nullable
    public SpanId getParentSpanId() {
        return this.parentSpanId;
    }

    @Nullable
    public Boolean getHasRemoteParent() {
        return this.hasRemoteParent;
    }

    public String getName() {
        return this.name;
    }

    @Nullable
    public Span.Kind getKind() {
        return this.kind;
    }

    public Timestamp getStartTimestamp() {
        return this.startTimestamp;
    }

    public SpanData.Attributes getAttributes() {
        return this.attributes;
    }

    public SpanData.TimedEvents<Annotation> getAnnotations() {
        return this.annotations;
    }

    public SpanData.TimedEvents<MessageEvent> getMessageEvents() {
        return this.messageEvents;
    }

    public SpanData.Links getLinks() {
        return this.links;
    }

    @Nullable
    public Integer getChildSpanCount() {
        return this.childSpanCount;
    }

    @Nullable
    public Status getStatus() {
        return this.status;
    }

    @Nullable
    public Timestamp getEndTimestamp() {
        return this.endTimestamp;
    }

    public String toString() {
        return "SpanData{context=" + this.context + ", parentSpanId=" + this.parentSpanId + ", hasRemoteParent=" + this.hasRemoteParent + ", name=" + this.name + ", kind=" + this.kind + ", startTimestamp=" + this.startTimestamp + ", attributes=" + this.attributes + ", annotations=" + this.annotations + ", messageEvents=" + this.messageEvents + ", links=" + this.links + ", childSpanCount=" + this.childSpanCount + ", status=" + this.status + ", endTimestamp=" + this.endTimestamp + "}";
    }

    public boolean equals(Object obj) {
        SpanId spanId;
        Boolean bool;
        Span.Kind kind2;
        Integer num;
        Status status2;
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof SpanData)) {
            return false;
        }
        SpanData spanData = (SpanData) obj;
        if (this.context.equals(spanData.getContext()) && ((spanId = this.parentSpanId) != null ? spanId.equals(spanData.getParentSpanId()) : spanData.getParentSpanId() == null) && ((bool = this.hasRemoteParent) != null ? bool.equals(spanData.getHasRemoteParent()) : spanData.getHasRemoteParent() == null) && this.name.equals(spanData.getName()) && ((kind2 = this.kind) != null ? kind2.equals(spanData.getKind()) : spanData.getKind() == null) && this.startTimestamp.equals(spanData.getStartTimestamp()) && this.attributes.equals(spanData.getAttributes()) && this.annotations.equals(spanData.getAnnotations()) && this.messageEvents.equals(spanData.getMessageEvents()) && this.links.equals(spanData.getLinks()) && ((num = this.childSpanCount) != null ? num.equals(spanData.getChildSpanCount()) : spanData.getChildSpanCount() == null) && ((status2 = this.status) != null ? status2.equals(spanData.getStatus()) : spanData.getStatus() == null)) {
            Timestamp timestamp = this.endTimestamp;
            if (timestamp == null) {
                if (spanData.getEndTimestamp() == null) {
                    return true;
                }
            } else if (timestamp.equals(spanData.getEndTimestamp())) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        int hashCode = (this.context.hashCode() ^ 1000003) * 1000003;
        SpanId spanId = this.parentSpanId;
        int i = 0;
        int hashCode2 = (hashCode ^ (spanId == null ? 0 : spanId.hashCode())) * 1000003;
        Boolean bool = this.hasRemoteParent;
        int hashCode3 = (((hashCode2 ^ (bool == null ? 0 : bool.hashCode())) * 1000003) ^ this.name.hashCode()) * 1000003;
        Span.Kind kind2 = this.kind;
        int hashCode4 = (((((((((((hashCode3 ^ (kind2 == null ? 0 : kind2.hashCode())) * 1000003) ^ this.startTimestamp.hashCode()) * 1000003) ^ this.attributes.hashCode()) * 1000003) ^ this.annotations.hashCode()) * 1000003) ^ this.messageEvents.hashCode()) * 1000003) ^ this.links.hashCode()) * 1000003;
        Integer num = this.childSpanCount;
        int hashCode5 = (hashCode4 ^ (num == null ? 0 : num.hashCode())) * 1000003;
        Status status2 = this.status;
        int hashCode6 = (hashCode5 ^ (status2 == null ? 0 : status2.hashCode())) * 1000003;
        Timestamp timestamp = this.endTimestamp;
        if (timestamp != null) {
            i = timestamp.hashCode();
        }
        return hashCode6 ^ i;
    }
}
