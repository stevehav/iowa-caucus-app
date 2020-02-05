package com.facebook.react.jstasks;

public class NoRetryPolicy implements HeadlessJsTaskRetryPolicy {
    public static final NoRetryPolicy INSTANCE = new NoRetryPolicy();

    public boolean canRetry() {
        return false;
    }

    public HeadlessJsTaskRetryPolicy copy() {
        return this;
    }

    private NoRetryPolicy() {
    }

    public int getDelay() {
        throw new IllegalStateException("Should not retrieve delay as canRetry is: " + canRetry());
    }

    public HeadlessJsTaskRetryPolicy update() {
        throw new IllegalStateException("Should not update as canRetry is: " + canRetry());
    }
}
