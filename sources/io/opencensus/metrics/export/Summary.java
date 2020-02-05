package io.opencensus.metrics.export;

import io.opencensus.internal.Utils;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.annotation.Nullable;
import javax.annotation.concurrent.Immutable;

@Immutable
public abstract class Summary {
    @Nullable
    public abstract Long getCount();

    public abstract Snapshot getSnapshot();

    @Nullable
    public abstract Double getSum();

    Summary() {
    }

    public static Summary create(@Nullable Long l, @Nullable Double d, Snapshot snapshot) {
        checkCountAndSum(l, d);
        Utils.checkNotNull(snapshot, "snapshot");
        return new AutoValue_Summary(l, d, snapshot);
    }

    @Immutable
    public static abstract class Snapshot {
        @Nullable
        public abstract Long getCount();

        @Nullable
        public abstract Double getSum();

        public abstract List<ValueAtPercentile> getValueAtPercentiles();

        public static Snapshot create(@Nullable Long l, @Nullable Double d, List<ValueAtPercentile> list) {
            Summary.checkCountAndSum(l, d);
            Utils.checkListElementNotNull((List) Utils.checkNotNull(list, "valueAtPercentiles"), "valueAtPercentile");
            return new AutoValue_Summary_Snapshot(l, d, Collections.unmodifiableList(new ArrayList(list)));
        }

        @Immutable
        public static abstract class ValueAtPercentile {
            public abstract double getPercentile();

            public abstract double getValue();

            public static ValueAtPercentile create(double d, double d2) {
                boolean z = true;
                Utils.checkArgument(0.0d < d && d <= 100.0d, "percentile must be in the interval (0.0, 100.0]");
                if (d2 < 0.0d) {
                    z = false;
                }
                Utils.checkArgument(z, "value must be non-negative");
                return new AutoValue_Summary_Snapshot_ValueAtPercentile(d, d2);
            }
        }
    }

    /* access modifiers changed from: private */
    public static void checkCountAndSum(@Nullable Long l, @Nullable Double d) {
        boolean z = false;
        Utils.checkArgument(l == null || l.longValue() >= 0, "count must be non-negative.");
        Utils.checkArgument(d == null || d.doubleValue() >= 0.0d, "sum must be non-negative.");
        if (l != null && l.longValue() == 0) {
            if (d == null || d.doubleValue() == 0.0d) {
                z = true;
            }
            Utils.checkArgument(z, "sum must be 0 if count is 0.");
        }
    }
}
