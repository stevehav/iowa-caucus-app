package io.grpc.internal;

import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Preconditions;
import io.grpc.internal.BackoffPolicy;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public final class ExponentialBackoffPolicy implements BackoffPolicy {
    private long initialBackoffNanos = TimeUnit.SECONDS.toNanos(1);
    private double jitter = 0.2d;
    private long maxBackoffNanos = TimeUnit.MINUTES.toNanos(2);
    private double multiplier = 1.6d;
    private long nextBackoffNanos = this.initialBackoffNanos;
    private Random random = new Random();

    public static final class Provider implements BackoffPolicy.Provider {
        public BackoffPolicy get() {
            return new ExponentialBackoffPolicy();
        }
    }

    public long nextBackoffNanos() {
        long j = this.nextBackoffNanos;
        double d = (double) j;
        double d2 = this.multiplier;
        Double.isNaN(d);
        this.nextBackoffNanos = Math.min((long) (d2 * d), this.maxBackoffNanos);
        double d3 = this.jitter;
        Double.isNaN(d);
        Double.isNaN(d);
        return j + uniformRandom((-d3) * d, d3 * d);
    }

    private long uniformRandom(double d, double d2) {
        Preconditions.checkArgument(d2 >= d);
        return (long) ((this.random.nextDouble() * (d2 - d)) + d);
    }

    /* access modifiers changed from: package-private */
    @VisibleForTesting
    public ExponentialBackoffPolicy setRandom(Random random2) {
        this.random = random2;
        return this;
    }

    /* access modifiers changed from: package-private */
    @VisibleForTesting
    public ExponentialBackoffPolicy setInitialBackoffNanos(long j) {
        this.initialBackoffNanos = j;
        return this;
    }

    /* access modifiers changed from: package-private */
    @VisibleForTesting
    public ExponentialBackoffPolicy setMaxBackoffNanos(long j) {
        this.maxBackoffNanos = j;
        return this;
    }

    /* access modifiers changed from: package-private */
    @VisibleForTesting
    public ExponentialBackoffPolicy setMultiplier(double d) {
        this.multiplier = d;
        return this;
    }

    /* access modifiers changed from: package-private */
    @VisibleForTesting
    public ExponentialBackoffPolicy setJitter(double d) {
        this.jitter = d;
        return this;
    }
}
