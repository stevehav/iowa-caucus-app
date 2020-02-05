package io.sentry.connection;

import io.sentry.event.Event;

public interface EventSendCallback {
    void onFailure(Event event, Exception exc);

    void onSuccess(Event event);
}
