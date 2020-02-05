package io.grpc;

import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

public final class Deadline implements Comparable<Deadline> {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final long MAX_OFFSET = TimeUnit.DAYS.toNanos(36500);
    private static final long MIN_OFFSET = (-MAX_OFFSET);
    private static final long NANOS_PER_SECOND = TimeUnit.SECONDS.toNanos(1);
    private static final SystemTicker SYSTEM_TICKER = new SystemTicker();
    private final long deadlineNanos;
    private volatile boolean expired;
    private final Ticker ticker;

    public static Deadline after(long j, TimeUnit timeUnit) {
        return after(j, timeUnit, SYSTEM_TICKER);
    }

    static Deadline after(long j, TimeUnit timeUnit, Ticker ticker2) {
        checkNotNull(timeUnit, "units");
        return new Deadline(ticker2, timeUnit.toNanos(j), true);
    }

    private Deadline(Ticker ticker2, long j, boolean z) {
        this(ticker2, ticker2.read(), j, z);
    }

    private Deadline(Ticker ticker2, long j, long j2, boolean z) {
        this.ticker = ticker2;
        long min = Math.min(MAX_OFFSET, Math.max(MIN_OFFSET, j2));
        this.deadlineNanos = j + min;
        this.expired = z && min <= 0;
    }

    public boolean isExpired() {
        if (!this.expired) {
            if (this.deadlineNanos - this.ticker.read() > 0) {
                return false;
            }
            this.expired = true;
        }
        return true;
    }

    public boolean isBefore(Deadline deadline) {
        return this.deadlineNanos - deadline.deadlineNanos < 0;
    }

    public Deadline minimum(Deadline deadline) {
        return isBefore(deadline) ? this : deadline;
    }

    public Deadline offset(long j, TimeUnit timeUnit) {
        return j == 0 ? this : new Deadline(this.ticker, this.deadlineNanos, timeUnit.toNanos(j), isExpired());
    }

    public long timeRemaining(TimeUnit timeUnit) {
        long read = this.ticker.read();
        if (!this.expired && this.deadlineNanos - read <= 0) {
            this.expired = true;
        }
        return timeUnit.convert(this.deadlineNanos - read, TimeUnit.NANOSECONDS);
    }

    public ScheduledFuture<?> runOnExpiration(Runnable runnable, ScheduledExecutorService scheduledExecutorService) {
        checkNotNull(runnable, "task");
        checkNotNull(scheduledExecutorService, "scheduler");
        return scheduledExecutorService.schedule(runnable, this.deadlineNanos - this.ticker.read(), TimeUnit.NANOSECONDS);
    }

    public String toString() {
        long timeRemaining = timeRemaining(TimeUnit.NANOSECONDS);
        long abs = Math.abs(timeRemaining) / NANOS_PER_SECOND;
        long abs2 = Math.abs(timeRemaining) % NANOS_PER_SECOND;
        StringBuilder sb = new StringBuilder();
        if (timeRemaining < 0) {
            sb.append('-');
        }
        sb.append(abs);
        if (abs2 > 0) {
            sb.append(String.format(".%09d", new Object[]{Long.valueOf(abs2)}));
        }
        sb.append("s from now");
        return sb.toString();
    }

    public int compareTo(Deadline deadline) {
        long j = this.deadlineNanos - deadline.deadlineNanos;
        if (j < 0) {
            return -1;
        }
        return j > 0 ? 1 : 0;
    }

    static abstract class Ticker {
        public abstract long read();

        Ticker() {
        }
    }

    private static class SystemTicker extends Ticker {
        private SystemTicker() {
        }

        public long read() {
            return System.nanoTime();
        }
    }

    private static <T> T checkNotNull(T t, Object obj) {
        if (t != null) {
            return t;
        }
        throw new NullPointerException(String.valueOf(obj));
    }
}
