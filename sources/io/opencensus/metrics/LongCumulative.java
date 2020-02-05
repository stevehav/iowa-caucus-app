package io.opencensus.metrics;

import io.opencensus.internal.Utils;
import java.util.List;
import javax.annotation.concurrent.ThreadSafe;

@ThreadSafe
public abstract class LongCumulative {

    public static abstract class LongPoint {
        public abstract void add(long j);
    }

    public abstract void clear();

    public abstract LongPoint getDefaultTimeSeries();

    public abstract LongPoint getOrCreateTimeSeries(List<LabelValue> list);

    public abstract void removeTimeSeries(List<LabelValue> list);

    static LongCumulative newNoopLongCumulative(String str, String str2, String str3, List<LabelKey> list) {
        return NoopLongCumulative.create(str, str2, str3, list);
    }

    private static final class NoopLongCumulative extends LongCumulative {
        private final int labelKeysSize;

        public void clear() {
        }

        static NoopLongCumulative create(String str, String str2, String str3, List<LabelKey> list) {
            return new NoopLongCumulative(str, str2, str3, list);
        }

        NoopLongCumulative(String str, String str2, String str3, List<LabelKey> list) {
            this.labelKeysSize = list.size();
        }

        public NoopLongPoint getOrCreateTimeSeries(List<LabelValue> list) {
            Utils.checkListElementNotNull((List) Utils.checkNotNull(list, "labelValues"), "labelValue");
            Utils.checkArgument(this.labelKeysSize == list.size(), "Label Keys and Label Values don't have same size.");
            return NoopLongPoint.INSTANCE;
        }

        public NoopLongPoint getDefaultTimeSeries() {
            return NoopLongPoint.INSTANCE;
        }

        public void removeTimeSeries(List<LabelValue> list) {
            Utils.checkNotNull(list, "labelValues");
        }

        private static final class NoopLongPoint extends LongPoint {
            /* access modifiers changed from: private */
            public static final NoopLongPoint INSTANCE = new NoopLongPoint();

            public void add(long j) {
            }

            private NoopLongPoint() {
            }
        }
    }
}
