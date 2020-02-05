package io.opencensus.metrics;

import io.opencensus.internal.Utils;
import io.opencensus.metrics.AutoValue_MetricOptions;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.concurrent.Immutable;

@Immutable
public abstract class MetricOptions {
    public abstract Map<LabelKey, LabelValue> getConstantLabels();

    public abstract String getDescription();

    public abstract List<LabelKey> getLabelKeys();

    public abstract String getUnit();

    public static Builder builder() {
        return new AutoValue_MetricOptions.Builder().setDescription("").setUnit("1").setLabelKeys(Collections.emptyList()).setConstantLabels(Collections.emptyMap());
    }

    public static abstract class Builder {
        /* access modifiers changed from: package-private */
        public abstract MetricOptions autoBuild();

        /* access modifiers changed from: package-private */
        public abstract Map<LabelKey, LabelValue> getConstantLabels();

        /* access modifiers changed from: package-private */
        public abstract List<LabelKey> getLabelKeys();

        public abstract Builder setConstantLabels(Map<LabelKey, LabelValue> map);

        public abstract Builder setDescription(String str);

        public abstract Builder setLabelKeys(List<LabelKey> list);

        public abstract Builder setUnit(String str);

        public MetricOptions build() {
            setLabelKeys(Collections.unmodifiableList(new ArrayList(getLabelKeys())));
            setConstantLabels(Collections.unmodifiableMap(new LinkedHashMap(getConstantLabels())));
            MetricOptions autoBuild = autoBuild();
            Utils.checkListElementNotNull(autoBuild.getLabelKeys(), "labelKeys elements");
            Utils.checkMapElementNotNull(autoBuild.getConstantLabels(), "constantLabels elements");
            HashSet hashSet = new HashSet();
            for (LabelKey next : autoBuild.getLabelKeys()) {
                if (!hashSet.contains(next.getKey())) {
                    hashSet.add(next.getKey());
                } else {
                    throw new IllegalArgumentException("Invalid LabelKey in labelKeys");
                }
            }
            for (Map.Entry next2 : autoBuild.getConstantLabels().entrySet()) {
                if (!hashSet.contains(((LabelKey) next2.getKey()).getKey())) {
                    hashSet.add(((LabelKey) next2.getKey()).getKey());
                } else {
                    throw new IllegalArgumentException("Invalid LabelKey in constantLabels");
                }
            }
            return autoBuild;
        }

        Builder() {
        }
    }

    MetricOptions() {
    }
}
