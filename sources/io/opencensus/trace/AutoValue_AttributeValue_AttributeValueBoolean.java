package io.opencensus.trace;

import io.opencensus.trace.AttributeValue;

final class AutoValue_AttributeValue_AttributeValueBoolean extends AttributeValue.AttributeValueBoolean {
    private final Boolean booleanValue;

    AutoValue_AttributeValue_AttributeValueBoolean(Boolean bool) {
        if (bool != null) {
            this.booleanValue = bool;
            return;
        }
        throw new NullPointerException("Null booleanValue");
    }

    /* access modifiers changed from: package-private */
    public Boolean getBooleanValue() {
        return this.booleanValue;
    }

    public String toString() {
        return "AttributeValueBoolean{booleanValue=" + this.booleanValue + "}";
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof AttributeValue.AttributeValueBoolean) {
            return this.booleanValue.equals(((AttributeValue.AttributeValueBoolean) obj).getBooleanValue());
        }
        return false;
    }

    public int hashCode() {
        return this.booleanValue.hashCode() ^ 1000003;
    }
}
