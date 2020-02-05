package io.sentry.connection;

import io.sentry.event.Event;
import java.io.IOException;

public class NoopConnection extends AbstractConnection {
    public void close() throws IOException {
    }

    /* access modifiers changed from: protected */
    public void doSend(Event event) throws ConnectionException {
    }

    public NoopConnection() {
        super((String) null, (String) null);
    }
}
