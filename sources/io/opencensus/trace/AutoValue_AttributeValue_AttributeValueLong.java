package io.opencensus.trace;

import io.opencensus.trace.AttributeValue;

final class AutoValue_AttributeValue_AttributeValueLong extends AttributeValue.AttributeValueLong {
    private final Long longValue;

    AutoValue_AttributeValue_AttributeValueLong(Long l) {
        if (l != null) {
            this.longValue = l;
            return;
        }
        throw new NullPointerException("Null longValue");
    }

    /* access modifiers changed from: package-private */
    public Long getLongValue() {
        return this.longValue;
    }

    public String toString() {
        return "AttributeValueLong{longValue=" + this.longValue + "}";
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof AttributeValue.AttributeValueLong) {
            return this.longValue.equals(((AttributeValue.AttributeValueLong) obj).getLongValue());
        }
        return false;
    }

    public int hashCode() {
        return this.longValue.hashCode() ^ 1000003;
    }
}
