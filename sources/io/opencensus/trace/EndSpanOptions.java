package io.opencensus.trace;

import io.opencensus.trace.AutoValue_EndSpanOptions;
import javax.annotation.Nullable;
import javax.annotation.concurrent.Immutable;

@Immutable
public abstract class EndSpanOptions {
    public static final EndSpanOptions DEFAULT = builder().build();

    public abstract boolean getSampleToLocalSpanStore();

    @Nullable
    public abstract Status getStatus();

    public static Builder builder() {
        return new AutoValue_EndSpanOptions.Builder().setSampleToLocalSpanStore(false);
    }

    public static abstract class Builder {
        public abstract EndSpanOptions build();

        public abstract Builder setSampleToLocalSpanStore(boolean z);

        public abstract Builder setStatus(Status status);

        Builder() {
        }
    }

    EndSpanOptions() {
    }
}
