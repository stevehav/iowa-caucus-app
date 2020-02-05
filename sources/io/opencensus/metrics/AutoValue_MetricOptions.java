package io.opencensus.metrics;

import io.opencensus.metrics.MetricOptions;
import java.util.List;
import java.util.Map;

final class AutoValue_MetricOptions extends MetricOptions {
    private final Map<LabelKey, LabelValue> constantLabels;
    private final String description;
    private final List<LabelKey> labelKeys;
    private final String unit;

    private AutoValue_MetricOptions(String str, String str2, List<LabelKey> list, Map<LabelKey, LabelValue> map) {
        this.description = str;
        this.unit = str2;
        this.labelKeys = list;
        this.constantLabels = map;
    }

    public String getDescription() {
        return this.description;
    }

    public String getUnit() {
        return this.unit;
    }

    public List<LabelKey> getLabelKeys() {
        return this.labelKeys;
    }

    public Map<LabelKey, LabelValue> getConstantLabels() {
        return this.constantLabels;
    }

    public String toString() {
        return "MetricOptions{description=" + this.description + ", unit=" + this.unit + ", labelKeys=" + this.labelKeys + ", constantLabels=" + this.constantLabels + "}";
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof MetricOptions)) {
            return false;
        }
        MetricOptions metricOptions = (MetricOptions) obj;
        if (!this.description.equals(metricOptions.getDescription()) || !this.unit.equals(metricOptions.getUnit()) || !this.labelKeys.equals(metricOptions.getLabelKeys()) || !this.constantLabels.equals(metricOptions.getConstantLabels())) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        return ((((((this.description.hashCode() ^ 1000003) * 1000003) ^ this.unit.hashCode()) * 1000003) ^ this.labelKeys.hashCode()) * 1000003) ^ this.constantLabels.hashCode();
    }

    static final class Builder extends MetricOptions.Builder {
        private Map<LabelKey, LabelValue> constantLabels;
        private String description;
        private List<LabelKey> labelKeys;
        private String unit;

        Builder() {
        }

        public MetricOptions.Builder setDescription(String str) {
            if (str != null) {
                this.description = str;
                return this;
            }
            throw new NullPointerException("Null description");
        }

        public MetricOptions.Builder setUnit(String str) {
            if (str != null) {
                this.unit = str;
                return this;
            }
            throw new NullPointerException("Null unit");
        }

        public MetricOptions.Builder setLabelKeys(List<LabelKey> list) {
            if (list != null) {
                this.labelKeys = list;
                return this;
            }
            throw new NullPointerException("Null labelKeys");
        }

        /* access modifiers changed from: package-private */
        public List<LabelKey> getLabelKeys() {
            List<LabelKey> list = this.labelKeys;
            if (list != null) {
                return list;
            }
            throw new IllegalStateException("Property \"labelKeys\" has not been set");
        }

        public MetricOptions.Builder setConstantLabels(Map<LabelKey, LabelValue> map) {
            if (map != null) {
                this.constantLabels = map;
                return this;
            }
            throw new NullPointerException("Null constantLabels");
        }

        /* access modifiers changed from: package-private */
        public Map<LabelKey, LabelValue> getConstantLabels() {
            Map<LabelKey, LabelValue> map = this.constantLabels;
            if (map != null) {
                return map;
            }
            throw new IllegalStateException("Property \"constantLabels\" has not been set");
        }

        /* access modifiers changed from: package-private */
        public MetricOptions autoBuild() {
            String str = "";
            if (this.description == null) {
                str = str + " description";
            }
            if (this.unit == null) {
                str = str + " unit";
            }
            if (this.labelKeys == null) {
                str = str + " labelKeys";
            }
            if (this.constantLabels == null) {
                str = str + " constantLabels";
            }
            if (str.isEmpty()) {
                return new AutoValue_MetricOptions(this.description, this.unit, this.labelKeys, this.constantLabels);
            }
            throw new IllegalStateException("Missing required properties:" + str);
        }
    }
}
