package io.opencensus.trace;

import io.opencensus.trace.EndSpanOptions;
import javax.annotation.Nullable;

final class AutoValue_EndSpanOptions extends EndSpanOptions {
    private final boolean sampleToLocalSpanStore;
    private final Status status;

    private AutoValue_EndSpanOptions(boolean z, @Nullable Status status2) {
        this.sampleToLocalSpanStore = z;
        this.status = status2;
    }

    public boolean getSampleToLocalSpanStore() {
        return this.sampleToLocalSpanStore;
    }

    @Nullable
    public Status getStatus() {
        return this.status;
    }

    public String toString() {
        return "EndSpanOptions{sampleToLocalSpanStore=" + this.sampleToLocalSpanStore + ", status=" + this.status + "}";
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof EndSpanOptions)) {
            return false;
        }
        EndSpanOptions endSpanOptions = (EndSpanOptions) obj;
        if (this.sampleToLocalSpanStore == endSpanOptions.getSampleToLocalSpanStore()) {
            Status status2 = this.status;
            if (status2 == null) {
                if (endSpanOptions.getStatus() == null) {
                    return true;
                }
            } else if (status2.equals(endSpanOptions.getStatus())) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        int i = ((this.sampleToLocalSpanStore ? 1231 : 1237) ^ 1000003) * 1000003;
        Status status2 = this.status;
        return i ^ (status2 == null ? 0 : status2.hashCode());
    }

    static final class Builder extends EndSpanOptions.Builder {
        private Boolean sampleToLocalSpanStore;
        private Status status;

        Builder() {
        }

        public EndSpanOptions.Builder setSampleToLocalSpanStore(boolean z) {
            this.sampleToLocalSpanStore = Boolean.valueOf(z);
            return this;
        }

        public EndSpanOptions.Builder setStatus(@Nullable Status status2) {
            this.status = status2;
            return this;
        }

        public EndSpanOptions build() {
            String str = "";
            if (this.sampleToLocalSpanStore == null) {
                str = str + " sampleToLocalSpanStore";
            }
            if (str.isEmpty()) {
                return new AutoValue_EndSpanOptions(this.sampleToLocalSpanStore.booleanValue(), this.status);
            }
            throw new IllegalStateException("Missing required properties:" + str);
        }
    }
}
