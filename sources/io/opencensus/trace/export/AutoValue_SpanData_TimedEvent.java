package io.opencensus.trace.export;

import io.opencensus.common.Timestamp;
import io.opencensus.trace.export.SpanData;

final class AutoValue_SpanData_TimedEvent<T> extends SpanData.TimedEvent<T> {
    private final T event;
    private final Timestamp timestamp;

    AutoValue_SpanData_TimedEvent(Timestamp timestamp2, T t) {
        if (timestamp2 != null) {
            this.timestamp = timestamp2;
            if (t != null) {
                this.event = t;
                return;
            }
            throw new NullPointerException("Null event");
        }
        throw new NullPointerException("Null timestamp");
    }

    public Timestamp getTimestamp() {
        return this.timestamp;
    }

    public T getEvent() {
        return this.event;
    }

    public String toString() {
        return "TimedEvent{timestamp=" + this.timestamp + ", event=" + this.event + "}";
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof SpanData.TimedEvent)) {
            return false;
        }
        SpanData.TimedEvent timedEvent = (SpanData.TimedEvent) obj;
        if (!this.timestamp.equals(timedEvent.getTimestamp()) || !this.event.equals(timedEvent.getEvent())) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        return ((this.timestamp.hashCode() ^ 1000003) * 1000003) ^ this.event.hashCode();
    }
}
