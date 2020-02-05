package io.sentry.event.helper;

import io.sentry.event.Event;

public interface ShouldSendEventCallback {
    boolean shouldSend(Event event);
}
