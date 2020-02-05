package io.sentry.marshaller.json;

import com.fasterxml.jackson.core.JsonGenerator;
import io.sentry.event.interfaces.SentryInterface;
import java.io.IOException;

public interface InterfaceBinding<T extends SentryInterface> {
    void writeInterface(JsonGenerator jsonGenerator, T t) throws IOException;
}
