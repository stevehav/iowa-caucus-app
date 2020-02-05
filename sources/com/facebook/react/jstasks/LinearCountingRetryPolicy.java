package com.facebook.react.jstasks;

public class LinearCountingRetryPolicy implements HeadlessJsTaskRetryPolicy {
    private final int mDelayBetweenAttemptsInMs;
    private final int mRetryAttempts;

    public LinearCountingRetryPolicy(int i, int i2) {
        this.mRetryAttempts = i;
        this.mDelayBetweenAttemptsInMs = i2;
    }

    public boolean canRetry() {
        return this.mRetryAttempts > 0;
    }

    public int getDelay() {
        return this.mDelayBetweenAttemptsInMs;
    }

    public HeadlessJsTaskRetryPolicy update() {
        int i = this.mRetryAttempts - 1;
        if (i > 0) {
            return new LinearCountingRetryPolicy(i, this.mDelayBetweenAttemptsInMs);
        }
        return NoRetryPolicy.INSTANCE;
    }

    public HeadlessJsTaskRetryPolicy copy() {
        return new LinearCountingRetryPolicy(this.mRetryAttempts, this.mDelayBetweenAttemptsInMs);
    }
}
