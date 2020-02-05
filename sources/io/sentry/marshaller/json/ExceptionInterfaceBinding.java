package io.sentry.marshaller.json;

import com.fasterxml.jackson.core.JsonGenerator;
import io.sentry.event.interfaces.ExceptionInterface;
import io.sentry.event.interfaces.SentryException;
import io.sentry.event.interfaces.StackTraceInterface;
import java.io.IOException;
import java.util.Deque;
import java.util.Iterator;

public class ExceptionInterfaceBinding implements InterfaceBinding<ExceptionInterface> {
    private static final String MODULE_PARAMETER = "module";
    private static final String STACKTRACE_PARAMETER = "stacktrace";
    private static final String TYPE_PARAMETER = "type";
    private static final String VALUE_PARAMETER = "value";
    private final InterfaceBinding<StackTraceInterface> stackTraceInterfaceBinding;

    public ExceptionInterfaceBinding(InterfaceBinding<StackTraceInterface> interfaceBinding) {
        this.stackTraceInterfaceBinding = interfaceBinding;
    }

    public void writeInterface(JsonGenerator jsonGenerator, ExceptionInterface exceptionInterface) throws IOException {
        Deque<SentryException> exceptions = exceptionInterface.getExceptions();
        jsonGenerator.writeStartArray();
        Iterator<SentryException> descendingIterator = exceptions.descendingIterator();
        while (descendingIterator.hasNext()) {
            writeException(jsonGenerator, descendingIterator.next());
        }
        jsonGenerator.writeEndArray();
    }

    private void writeException(JsonGenerator jsonGenerator, SentryException sentryException) throws IOException {
        jsonGenerator.writeStartObject();
        jsonGenerator.writeStringField("type", sentryException.getExceptionClassName());
        jsonGenerator.writeStringField("value", sentryException.getExceptionMessage());
        jsonGenerator.writeStringField(MODULE_PARAMETER, sentryException.getExceptionPackageName());
        jsonGenerator.writeFieldName(STACKTRACE_PARAMETER);
        this.stackTraceInterfaceBinding.writeInterface(jsonGenerator, sentryException.getStackTraceInterface());
        jsonGenerator.writeEndObject();
    }
}
