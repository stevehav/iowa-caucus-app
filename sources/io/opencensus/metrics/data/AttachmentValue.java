package io.opencensus.metrics.data;

import javax.annotation.concurrent.Immutable;

public abstract class AttachmentValue {
    public abstract String getValue();

    @Immutable
    public static abstract class AttachmentValueString extends AttachmentValue {
        AttachmentValueString() {
        }

        public static AttachmentValueString create(String str) {
            return new AutoValue_AttachmentValue_AttachmentValueString(str);
        }
    }
}
