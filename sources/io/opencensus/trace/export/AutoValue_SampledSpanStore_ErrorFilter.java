package io.opencensus.trace.export;

import io.opencensus.trace.Status;
import io.opencensus.trace.export.SampledSpanStore;
import javax.annotation.Nullable;

final class AutoValue_SampledSpanStore_ErrorFilter extends SampledSpanStore.ErrorFilter {
    private final Status.CanonicalCode canonicalCode;
    private final int maxSpansToReturn;
    private final String spanName;

    AutoValue_SampledSpanStore_ErrorFilter(String str, @Nullable Status.CanonicalCode canonicalCode2, int i) {
        if (str != null) {
            this.spanName = str;
            this.canonicalCode = canonicalCode2;
            this.maxSpansToReturn = i;
            return;
        }
        throw new NullPointerException("Null spanName");
    }

    public String getSpanName() {
        return this.spanName;
    }

    @Nullable
    public Status.CanonicalCode getCanonicalCode() {
        return this.canonicalCode;
    }

    public int getMaxSpansToReturn() {
        return this.maxSpansToReturn;
    }

    public String toString() {
        return "ErrorFilter{spanName=" + this.spanName + ", canonicalCode=" + this.canonicalCode + ", maxSpansToReturn=" + this.maxSpansToReturn + "}";
    }

    public boolean equals(Object obj) {
        Status.CanonicalCode canonicalCode2;
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof SampledSpanStore.ErrorFilter)) {
            return false;
        }
        SampledSpanStore.ErrorFilter errorFilter = (SampledSpanStore.ErrorFilter) obj;
        if (!this.spanName.equals(errorFilter.getSpanName()) || ((canonicalCode2 = this.canonicalCode) != null ? !canonicalCode2.equals(errorFilter.getCanonicalCode()) : errorFilter.getCanonicalCode() != null) || this.maxSpansToReturn != errorFilter.getMaxSpansToReturn()) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int hashCode = (this.spanName.hashCode() ^ 1000003) * 1000003;
        Status.CanonicalCode canonicalCode2 = this.canonicalCode;
        return ((hashCode ^ (canonicalCode2 == null ? 0 : canonicalCode2.hashCode())) * 1000003) ^ this.maxSpansToReturn;
    }
}
