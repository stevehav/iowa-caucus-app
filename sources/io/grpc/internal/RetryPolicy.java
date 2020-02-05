package io.grpc.internal;

import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;
import com.google.common.collect.ImmutableSet;
import io.grpc.Status;
import java.util.Collections;
import java.util.Set;
import javax.annotation.Nonnull;
import javax.annotation.concurrent.Immutable;

@Immutable
final class RetryPolicy {
    static final RetryPolicy DEFAULT = new RetryPolicy(1, 0, 0, 1.0d, Collections.emptySet());
    final double backoffMultiplier;
    final long initialBackoffNanos;
    final int maxAttempts;
    final long maxBackoffNanos;
    final Set<Status.Code> retryableStatusCodes;

    interface Provider {
        RetryPolicy get();
    }

    RetryPolicy(int i, long j, long j2, double d, @Nonnull Set<Status.Code> set) {
        this.maxAttempts = i;
        this.initialBackoffNanos = j;
        this.maxBackoffNanos = j2;
        this.backoffMultiplier = d;
        this.retryableStatusCodes = ImmutableSet.copyOf(set);
    }

    public int hashCode() {
        return Objects.hashCode(Integer.valueOf(this.maxAttempts), Long.valueOf(this.initialBackoffNanos), Long.valueOf(this.maxBackoffNanos), Double.valueOf(this.backoffMultiplier), this.retryableStatusCodes);
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof RetryPolicy)) {
            return false;
        }
        RetryPolicy retryPolicy = (RetryPolicy) obj;
        if (this.maxAttempts == retryPolicy.maxAttempts && this.initialBackoffNanos == retryPolicy.initialBackoffNanos && this.maxBackoffNanos == retryPolicy.maxBackoffNanos && Double.compare(this.backoffMultiplier, retryPolicy.backoffMultiplier) == 0 && Objects.equal(this.retryableStatusCodes, retryPolicy.retryableStatusCodes)) {
            return true;
        }
        return false;
    }

    public String toString() {
        return MoreObjects.toStringHelper((Object) this).add("maxAttempts", this.maxAttempts).add("initialBackoffNanos", this.initialBackoffNanos).add("maxBackoffNanos", this.maxBackoffNanos).add("backoffMultiplier", this.backoffMultiplier).add("retryableStatusCodes", (Object) this.retryableStatusCodes).toString();
    }
}
