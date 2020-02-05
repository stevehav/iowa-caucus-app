package io.opencensus.common;

public final class ServerStatsDeserializationException extends Exception {
    private static final long serialVersionUID = 0;

    public ServerStatsDeserializationException(String str) {
        super(str);
    }

    public ServerStatsDeserializationException(String str, Throwable th) {
        super(str, th);
    }
}
