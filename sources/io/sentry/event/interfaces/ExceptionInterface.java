package io.sentry.event.interfaces;

import java.util.Deque;

public class ExceptionInterface implements SentryInterface {
    public static final String EXCEPTION_INTERFACE = "sentry.interfaces.Exception";
    private final Deque<SentryException> exceptions;

    public String getInterfaceName() {
        return EXCEPTION_INTERFACE;
    }

    public ExceptionInterface(Throwable th) {
        this(SentryException.extractExceptionQueue(th));
    }

    public ExceptionInterface(Deque<SentryException> deque) {
        this.exceptions = deque;
    }

    public Deque<SentryException> getExceptions() {
        return this.exceptions;
    }

    public String toString() {
        return "ExceptionInterface{exceptions=" + this.exceptions + '}';
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        return this.exceptions.equals(((ExceptionInterface) obj).exceptions);
    }

    public int hashCode() {
        return this.exceptions.hashCode();
    }
}
