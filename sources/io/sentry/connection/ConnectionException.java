package io.sentry.connection;

public class ConnectionException extends RuntimeException {
    private Long recommendedLockdownTime = null;
    private Integer responseCode = null;

    public ConnectionException() {
    }

    public ConnectionException(String str, Throwable th) {
        super(str, th);
    }

    public ConnectionException(String str, Throwable th, Long l, Integer num) {
        super(str, th);
        this.recommendedLockdownTime = l;
        this.responseCode = num;
    }

    public Long getRecommendedLockdownTime() {
        return this.recommendedLockdownTime;
    }

    public Integer getResponseCode() {
        return this.responseCode;
    }
}
