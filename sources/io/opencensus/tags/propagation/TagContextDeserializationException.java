package io.opencensus.tags.propagation;

public final class TagContextDeserializationException extends Exception {
    private static final long serialVersionUID = 0;

    public TagContextDeserializationException(String str) {
        super(str);
    }

    public TagContextDeserializationException(String str, Throwable th) {
        super(str, th);
    }
}
