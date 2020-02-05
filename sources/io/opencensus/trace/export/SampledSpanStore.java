package io.opencensus.trace.export;

import io.opencensus.internal.Utils;
import io.opencensus.trace.Status;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import javax.annotation.Nullable;
import javax.annotation.concurrent.GuardedBy;
import javax.annotation.concurrent.Immutable;
import javax.annotation.concurrent.ThreadSafe;

@ThreadSafe
public abstract class SampledSpanStore {
    public abstract Collection<SpanData> getErrorSampledSpans(ErrorFilter errorFilter);

    public abstract Collection<SpanData> getLatencySampledSpans(LatencyFilter latencyFilter);

    public abstract Set<String> getRegisteredSpanNamesForCollection();

    public abstract Summary getSummary();

    @Deprecated
    public abstract void registerSpanNamesForCollection(Collection<String> collection);

    @Deprecated
    public abstract void unregisterSpanNamesForCollection(Collection<String> collection);

    protected SampledSpanStore() {
    }

    static SampledSpanStore newNoopSampledSpanStore() {
        return new NoopSampledSpanStore();
    }

    @Immutable
    public static abstract class Summary {
        public abstract Map<String, PerSpanNameSummary> getPerSpanNameSummary();

        Summary() {
        }

        public static Summary create(Map<String, PerSpanNameSummary> map) {
            return new AutoValue_SampledSpanStore_Summary(Collections.unmodifiableMap(new HashMap((Map) Utils.checkNotNull(map, "perSpanNameSummary"))));
        }
    }

    @Immutable
    public static abstract class PerSpanNameSummary {
        public abstract Map<Status.CanonicalCode, Integer> getNumbersOfErrorSampledSpans();

        public abstract Map<LatencyBucketBoundaries, Integer> getNumbersOfLatencySampledSpans();

        PerSpanNameSummary() {
        }

        public static PerSpanNameSummary create(Map<LatencyBucketBoundaries, Integer> map, Map<Status.CanonicalCode, Integer> map2) {
            return new AutoValue_SampledSpanStore_PerSpanNameSummary(Collections.unmodifiableMap(new HashMap((Map) Utils.checkNotNull(map, "numbersOfLatencySampledSpans"))), Collections.unmodifiableMap(new HashMap((Map) Utils.checkNotNull(map2, "numbersOfErrorSampledSpans"))));
        }
    }

    public enum LatencyBucketBoundaries {
        ZERO_MICROSx10(0, TimeUnit.MICROSECONDS.toNanos(10)),
        MICROSx10_MICROSx100(TimeUnit.MICROSECONDS.toNanos(10), TimeUnit.MICROSECONDS.toNanos(100)),
        MICROSx100_MILLIx1(TimeUnit.MICROSECONDS.toNanos(100), TimeUnit.MILLISECONDS.toNanos(1)),
        MILLIx1_MILLIx10(TimeUnit.MILLISECONDS.toNanos(1), TimeUnit.MILLISECONDS.toNanos(10)),
        MILLIx10_MILLIx100(TimeUnit.MILLISECONDS.toNanos(10), TimeUnit.MILLISECONDS.toNanos(100)),
        MILLIx100_SECONDx1(TimeUnit.MILLISECONDS.toNanos(100), TimeUnit.SECONDS.toNanos(1)),
        SECONDx1_SECONDx10(TimeUnit.SECONDS.toNanos(1), TimeUnit.SECONDS.toNanos(10)),
        SECONDx10_SECONDx100(TimeUnit.SECONDS.toNanos(10), TimeUnit.SECONDS.toNanos(100)),
        SECONDx100_MAX(TimeUnit.SECONDS.toNanos(100), Long.MAX_VALUE);
        
        private final long latencyLowerNs;
        private final long latencyUpperNs;

        private LatencyBucketBoundaries(long j, long j2) {
            this.latencyLowerNs = j;
            this.latencyUpperNs = j2;
        }

        public long getLatencyLowerNs() {
            return this.latencyLowerNs;
        }

        public long getLatencyUpperNs() {
            return this.latencyUpperNs;
        }
    }

    @Immutable
    public static abstract class LatencyFilter {
        public abstract long getLatencyLowerNs();

        public abstract long getLatencyUpperNs();

        public abstract int getMaxSpansToReturn();

        public abstract String getSpanName();

        LatencyFilter() {
        }

        public static LatencyFilter create(String str, long j, long j2, int i) {
            boolean z = true;
            Utils.checkArgument(i >= 0, "Negative maxSpansToReturn.");
            Utils.checkArgument(j >= 0, "Negative latencyLowerNs");
            if (j2 < 0) {
                z = false;
            }
            Utils.checkArgument(z, "Negative latencyUpperNs");
            return new AutoValue_SampledSpanStore_LatencyFilter(str, j, j2, i);
        }
    }

    @Immutable
    public static abstract class ErrorFilter {
        @Nullable
        public abstract Status.CanonicalCode getCanonicalCode();

        public abstract int getMaxSpansToReturn();

        public abstract String getSpanName();

        ErrorFilter() {
        }

        public static ErrorFilter create(String str, @Nullable Status.CanonicalCode canonicalCode, int i) {
            boolean z = true;
            if (canonicalCode != null) {
                Utils.checkArgument(canonicalCode != Status.CanonicalCode.OK, "Invalid canonical code.");
            }
            if (i < 0) {
                z = false;
            }
            Utils.checkArgument(z, "Negative maxSpansToReturn.");
            return new AutoValue_SampledSpanStore_ErrorFilter(str, canonicalCode, i);
        }
    }

    @ThreadSafe
    private static final class NoopSampledSpanStore extends SampledSpanStore {
        private static final PerSpanNameSummary EMPTY_PER_SPAN_NAME_SUMMARY = PerSpanNameSummary.create(Collections.emptyMap(), Collections.emptyMap());
        @GuardedBy("registeredSpanNames")
        private final Set<String> registeredSpanNames;

        private NoopSampledSpanStore() {
            this.registeredSpanNames = new HashSet();
        }

        public Summary getSummary() {
            HashMap hashMap = new HashMap();
            synchronized (this.registeredSpanNames) {
                for (String put : this.registeredSpanNames) {
                    hashMap.put(put, EMPTY_PER_SPAN_NAME_SUMMARY);
                }
            }
            return Summary.create(hashMap);
        }

        public Collection<SpanData> getLatencySampledSpans(LatencyFilter latencyFilter) {
            Utils.checkNotNull(latencyFilter, "latencyFilter");
            return Collections.emptyList();
        }

        public Collection<SpanData> getErrorSampledSpans(ErrorFilter errorFilter) {
            Utils.checkNotNull(errorFilter, "errorFilter");
            return Collections.emptyList();
        }

        public void registerSpanNamesForCollection(Collection<String> collection) {
            Utils.checkNotNull(collection, "spanNames");
            synchronized (this.registeredSpanNames) {
                this.registeredSpanNames.addAll(collection);
            }
        }

        public void unregisterSpanNamesForCollection(Collection<String> collection) {
            Utils.checkNotNull(collection, "spanNames");
            synchronized (this.registeredSpanNames) {
                this.registeredSpanNames.removeAll(collection);
            }
        }

        public Set<String> getRegisteredSpanNamesForCollection() {
            Set<String> unmodifiableSet;
            synchronized (this.registeredSpanNames) {
                unmodifiableSet = Collections.unmodifiableSet(new HashSet(this.registeredSpanNames));
            }
            return unmodifiableSet;
        }
    }
}
