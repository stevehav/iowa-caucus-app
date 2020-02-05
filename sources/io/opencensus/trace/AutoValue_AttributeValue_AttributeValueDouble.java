package io.opencensus.trace;

import io.opencensus.trace.AttributeValue;

final class AutoValue_AttributeValue_AttributeValueDouble extends AttributeValue.AttributeValueDouble {
    private final Double doubleValue;

    AutoValue_AttributeValue_AttributeValueDouble(Double d) {
        if (d != null) {
            this.doubleValue = d;
            return;
        }
        throw new NullPointerException("Null doubleValue");
    }

    /* access modifiers changed from: package-private */
    public Double getDoubleValue() {
        return this.doubleValue;
    }

    public String toString() {
        return "AttributeValueDouble{doubleValue=" + this.doubleValue + "}";
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof AttributeValue.AttributeValueDouble) {
            return this.doubleValue.equals(((AttributeValue.AttributeValueDouble) obj).getDoubleValue());
        }
        return false;
    }

    public int hashCode() {
        return this.doubleValue.hashCode() ^ 1000003;
    }
}
