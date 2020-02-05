package io.opencensus.trace;

import io.opencensus.trace.MessageEvent;

final class AutoValue_MessageEvent extends MessageEvent {
    private final long compressedMessageSize;
    private final long messageId;
    private final MessageEvent.Type type;
    private final long uncompressedMessageSize;

    private AutoValue_MessageEvent(MessageEvent.Type type2, long j, long j2, long j3) {
        this.type = type2;
        this.messageId = j;
        this.uncompressedMessageSize = j2;
        this.compressedMessageSize = j3;
    }

    public MessageEvent.Type getType() {
        return this.type;
    }

    public long getMessageId() {
        return this.messageId;
    }

    public long getUncompressedMessageSize() {
        return this.uncompressedMessageSize;
    }

    public long getCompressedMessageSize() {
        return this.compressedMessageSize;
    }

    public String toString() {
        return "MessageEvent{type=" + this.type + ", messageId=" + this.messageId + ", uncompressedMessageSize=" + this.uncompressedMessageSize + ", compressedMessageSize=" + this.compressedMessageSize + "}";
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof MessageEvent)) {
            return false;
        }
        MessageEvent messageEvent = (MessageEvent) obj;
        if (this.type.equals(messageEvent.getType()) && this.messageId == messageEvent.getMessageId() && this.uncompressedMessageSize == messageEvent.getUncompressedMessageSize() && this.compressedMessageSize == messageEvent.getCompressedMessageSize()) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        long j = this.messageId;
        long j2 = this.uncompressedMessageSize;
        long hashCode = (long) (((int) (((long) (((int) (((long) ((this.type.hashCode() ^ 1000003) * 1000003)) ^ (j ^ (j >>> 32)))) * 1000003)) ^ (j2 ^ (j2 >>> 32)))) * 1000003);
        long j3 = this.compressedMessageSize;
        return (int) (hashCode ^ (j3 ^ (j3 >>> 32)));
    }

    static final class Builder extends MessageEvent.Builder {
        private Long compressedMessageSize;
        private Long messageId;
        private MessageEvent.Type type;
        private Long uncompressedMessageSize;

        Builder() {
        }

        /* access modifiers changed from: package-private */
        public MessageEvent.Builder setType(MessageEvent.Type type2) {
            if (type2 != null) {
                this.type = type2;
                return this;
            }
            throw new NullPointerException("Null type");
        }

        /* access modifiers changed from: package-private */
        public MessageEvent.Builder setMessageId(long j) {
            this.messageId = Long.valueOf(j);
            return this;
        }

        public MessageEvent.Builder setUncompressedMessageSize(long j) {
            this.uncompressedMessageSize = Long.valueOf(j);
            return this;
        }

        public MessageEvent.Builder setCompressedMessageSize(long j) {
            this.compressedMessageSize = Long.valueOf(j);
            return this;
        }

        public MessageEvent build() {
            String str = "";
            if (this.type == null) {
                str = str + " type";
            }
            if (this.messageId == null) {
                str = str + " messageId";
            }
            if (this.uncompressedMessageSize == null) {
                str = str + " uncompressedMessageSize";
            }
            if (this.compressedMessageSize == null) {
                str = str + " compressedMessageSize";
            }
            if (str.isEmpty()) {
                return new AutoValue_MessageEvent(this.type, this.messageId.longValue(), this.uncompressedMessageSize.longValue(), this.compressedMessageSize.longValue());
            }
            throw new IllegalStateException("Missing required properties:" + str);
        }
    }
}
