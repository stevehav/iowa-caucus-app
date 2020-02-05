package io.opencensus.trace;

import io.opencensus.trace.Tracestate;

final class AutoValue_Tracestate_Entry extends Tracestate.Entry {
    private final String key;
    private final String value;

    AutoValue_Tracestate_Entry(String str, String str2) {
        if (str != null) {
            this.key = str;
            if (str2 != null) {
                this.value = str2;
                return;
            }
            throw new NullPointerException("Null value");
        }
        throw new NullPointerException("Null key");
    }

    public String getKey() {
        return this.key;
    }

    public String getValue() {
        return this.value;
    }

    public String toString() {
        return "Entry{key=" + this.key + ", value=" + this.value + "}";
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Tracestate.Entry)) {
            return false;
        }
        Tracestate.Entry entry = (Tracestate.Entry) obj;
        if (!this.key.equals(entry.getKey()) || !this.value.equals(entry.getValue())) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        return ((this.key.hashCode() ^ 1000003) * 1000003) ^ this.value.hashCode();
    }
}
