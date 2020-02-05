package io.sentry.connection;

import io.sentry.event.Event;

public interface EventSampler {
    boolean shouldSendEvent(Event event);
}
