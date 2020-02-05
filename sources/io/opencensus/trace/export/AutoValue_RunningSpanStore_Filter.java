package io.opencensus.trace.export;

import io.opencensus.trace.export.RunningSpanStore;

final class AutoValue_RunningSpanStore_Filter extends RunningSpanStore.Filter {
    private final int maxSpansToReturn;
    private final String spanName;

    AutoValue_RunningSpanStore_Filter(String str, int i) {
        if (str != null) {
            this.spanName = str;
            this.maxSpansToReturn = i;
            return;
        }
        throw new NullPointerException("Null spanName");
    }

    public String getSpanName() {
        return this.spanName;
    }

    public int getMaxSpansToReturn() {
        return this.maxSpansToReturn;
    }

    public String toString() {
        return "Filter{spanName=" + this.spanName + ", maxSpansToReturn=" + this.maxSpansToReturn + "}";
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof RunningSpanStore.Filter)) {
            return false;
        }
        RunningSpanStore.Filter filter = (RunningSpanStore.Filter) obj;
        if (!this.spanName.equals(filter.getSpanName()) || this.maxSpansToReturn != filter.getMaxSpansToReturn()) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        return ((this.spanName.hashCode() ^ 1000003) * 1000003) ^ this.maxSpansToReturn;
    }
}
