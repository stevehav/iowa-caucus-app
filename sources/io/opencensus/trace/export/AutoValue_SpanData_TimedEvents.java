package io.opencensus.trace.export;

import io.opencensus.trace.export.SpanData;
import java.util.List;

final class AutoValue_SpanData_TimedEvents<T> extends SpanData.TimedEvents<T> {
    private final int droppedEventsCount;
    private final List<SpanData.TimedEvent<T>> events;

    AutoValue_SpanData_TimedEvents(List<SpanData.TimedEvent<T>> list, int i) {
        if (list != null) {
            this.events = list;
            this.droppedEventsCount = i;
            return;
        }
        throw new NullPointerException("Null events");
    }

    public List<SpanData.TimedEvent<T>> getEvents() {
        return this.events;
    }

    public int getDroppedEventsCount() {
        return this.droppedEventsCount;
    }

    public String toString() {
        return "TimedEvents{events=" + this.events + ", droppedEventsCount=" + this.droppedEventsCount + "}";
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof SpanData.TimedEvents)) {
            return false;
        }
        SpanData.TimedEvents timedEvents = (SpanData.TimedEvents) obj;
        if (!this.events.equals(timedEvents.getEvents()) || this.droppedEventsCount != timedEvents.getDroppedEventsCount()) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        return ((this.events.hashCode() ^ 1000003) * 1000003) ^ this.droppedEventsCount;
    }
}
