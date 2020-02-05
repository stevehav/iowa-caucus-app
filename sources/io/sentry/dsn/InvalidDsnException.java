package io.sentry.dsn;

public class InvalidDsnException extends RuntimeException {
    public InvalidDsnException() {
    }

    public InvalidDsnException(String str) {
        super(str);
    }

    public InvalidDsnException(String str, Throwable th) {
        super(str, th);
    }

    public InvalidDsnException(Throwable th) {
        super(th);
    }
}
