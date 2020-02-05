package io.opencensus.trace;

import io.opencensus.internal.Utils;
import io.opencensus.trace.AutoValue_MessageEvent;
import javax.annotation.concurrent.Immutable;

@Immutable
public abstract class MessageEvent extends BaseMessageEvent {

    public enum Type {
        SENT,
        RECEIVED
    }

    public abstract long getCompressedMessageSize();

    public abstract long getMessageId();

    public abstract Type getType();

    public abstract long getUncompressedMessageSize();

    public static Builder builder(Type type, long j) {
        return new AutoValue_MessageEvent.Builder().setType((Type) Utils.checkNotNull(type, "type")).setMessageId(j).setUncompressedMessageSize(0).setCompressedMessageSize(0);
    }

    public static abstract class Builder {
        public abstract MessageEvent build();

        public abstract Builder setCompressedMessageSize(long j);

        /* access modifiers changed from: package-private */
        public abstract Builder setMessageId(long j);

        /* access modifiers changed from: package-private */
        public abstract Builder setType(Type type);

        public abstract Builder setUncompressedMessageSize(long j);

        Builder() {
        }
    }

    MessageEvent() {
    }
}
