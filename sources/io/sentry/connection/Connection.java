package io.sentry.connection;

import io.sentry.event.Event;
import java.io.Closeable;

public interface Connection extends Closeable {
    void addEventSendCallback(EventSendCallback eventSendCallback);

    void send(Event event) throws ConnectionException;
}
