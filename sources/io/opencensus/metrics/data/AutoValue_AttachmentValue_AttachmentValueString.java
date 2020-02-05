package io.opencensus.metrics.data;

import io.opencensus.metrics.data.AttachmentValue;

final class AutoValue_AttachmentValue_AttachmentValueString extends AttachmentValue.AttachmentValueString {
    private final String value;

    AutoValue_AttachmentValue_AttachmentValueString(String str) {
        if (str != null) {
            this.value = str;
            return;
        }
        throw new NullPointerException("Null value");
    }

    public String getValue() {
        return this.value;
    }

    public String toString() {
        return "AttachmentValueString{value=" + this.value + "}";
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof AttachmentValue.AttachmentValueString) {
            return this.value.equals(((AttachmentValue.AttachmentValueString) obj).getValue());
        }
        return false;
    }

    public int hashCode() {
        return this.value.hashCode() ^ 1000003;
    }
}
