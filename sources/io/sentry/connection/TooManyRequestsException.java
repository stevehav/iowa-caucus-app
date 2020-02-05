package io.sentry.connection;

public class TooManyRequestsException extends ConnectionException {
    public TooManyRequestsException(String str, Throwable th, Long l, Integer num) {
        super(str, th, l, num);
    }
}
