package io.opencensus.metrics;

import javax.annotation.concurrent.Immutable;

@Immutable
public abstract class LabelKey {
    public abstract String getDescription();

    public abstract String getKey();

    LabelKey() {
    }

    public static LabelKey create(String str, String str2) {
        return new AutoValue_LabelKey(str, str2);
    }
}
