package io.opencensus.metrics;

import javax.annotation.Nullable;

final class AutoValue_LabelValue extends LabelValue {
    private final String value;

    AutoValue_LabelValue(@Nullable String str) {
        this.value = str;
    }

    @Nullable
    public String getValue() {
        return this.value;
    }

    public String toString() {
        return "LabelValue{value=" + this.value + "}";
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof LabelValue)) {
            return false;
        }
        LabelValue labelValue = (LabelValue) obj;
        String str = this.value;
        if (str != null) {
            return str.equals(labelValue.getValue());
        }
        if (labelValue.getValue() == null) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        String str = this.value;
        return (str == null ? 0 : str.hashCode()) ^ 1000003;
    }
}
