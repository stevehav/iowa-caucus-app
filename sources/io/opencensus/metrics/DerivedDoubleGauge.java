package io.opencensus.metrics;

import com.google.android.gms.measurement.api.AppMeasurementSdk;
import io.opencensus.common.ToDoubleFunction;
import io.opencensus.internal.Utils;
import java.util.List;
import javax.annotation.concurrent.ThreadSafe;

@ThreadSafe
public abstract class DerivedDoubleGauge {
    public abstract void clear();

    public abstract <T> void createTimeSeries(List<LabelValue> list, T t, ToDoubleFunction<T> toDoubleFunction);

    public abstract void removeTimeSeries(List<LabelValue> list);

    static DerivedDoubleGauge newNoopDerivedDoubleGauge(String str, String str2, String str3, List<LabelKey> list) {
        return NoopDerivedDoubleGauge.create(str, str2, str3, list);
    }

    private static final class NoopDerivedDoubleGauge extends DerivedDoubleGauge {
        private final int labelKeysSize;

        public void clear() {
        }

        static NoopDerivedDoubleGauge create(String str, String str2, String str3, List<LabelKey> list) {
            return new NoopDerivedDoubleGauge(str, str2, str3, list);
        }

        NoopDerivedDoubleGauge(String str, String str2, String str3, List<LabelKey> list) {
            Utils.checkNotNull(str, AppMeasurementSdk.ConditionalUserProperty.NAME);
            Utils.checkNotNull(str2, "description");
            Utils.checkNotNull(str3, "unit");
            Utils.checkListElementNotNull((List) Utils.checkNotNull(list, "labelKeys"), "labelKey");
            this.labelKeysSize = list.size();
        }

        public <T> void createTimeSeries(List<LabelValue> list, T t, ToDoubleFunction<T> toDoubleFunction) {
            Utils.checkListElementNotNull((List) Utils.checkNotNull(list, "labelValues"), "labelValue");
            Utils.checkArgument(this.labelKeysSize == list.size(), "Label Keys and Label Values don't have same size.");
            Utils.checkNotNull(toDoubleFunction, "function");
        }

        public void removeTimeSeries(List<LabelValue> list) {
            Utils.checkNotNull(list, "labelValues");
        }
    }
}
