package io.opencensus.trace;

import io.opencensus.common.Timestamp;
import io.opencensus.trace.NetworkEvent;
import javax.annotation.Nullable;
import javax.annotation.concurrent.Immutable;

@Immutable
@Deprecated
final class AutoValue_NetworkEvent extends NetworkEvent {
    private final long compressedMessageSize;
    private final Timestamp kernelTimestamp;
    private final long messageId;
    private final NetworkEvent.Type type;
    private final long uncompressedMessageSize;

    private AutoValue_NetworkEvent(@Nullable Timestamp timestamp, NetworkEvent.Type type2, long j, long j2, long j3) {
        this.kernelTimestamp = timestamp;
        this.type = type2;
        this.messageId = j;
        this.uncompressedMessageSize = j2;
        this.compressedMessageSize = j3;
    }

    @Nullable
    public Timestamp getKernelTimestamp() {
        return this.kernelTimestamp;
    }

    public NetworkEvent.Type getType() {
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
        return "NetworkEvent{kernelTimestamp=" + this.kernelTimestamp + ", type=" + this.type + ", messageId=" + this.messageId + ", uncompressedMessageSize=" + this.uncompressedMessageSize + ", compressedMessageSize=" + this.compressedMessageSize + "}";
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof NetworkEvent)) {
            return false;
        }
        NetworkEvent networkEvent = (NetworkEvent) obj;
        Timestamp timestamp = this.kernelTimestamp;
        if (timestamp != null ? timestamp.equals(networkEvent.getKernelTimestamp()) : networkEvent.getKernelTimestamp() == null) {
            if (this.type.equals(networkEvent.getType()) && this.messageId == networkEvent.getMessageId() && this.uncompressedMessageSize == networkEvent.getUncompressedMessageSize() && this.compressedMessageSize == networkEvent.getCompressedMessageSize()) {
                return true;
            }
            return false;
        }
        return false;
    }

    public int hashCode() {
        Timestamp timestamp = this.kernelTimestamp;
        int hashCode = timestamp == null ? 0 : timestamp.hashCode();
        long j = this.messageId;
        long j2 = this.uncompressedMessageSize;
        long hashCode2 = (long) (((int) (((long) (((int) (((long) ((((hashCode ^ 1000003) * 1000003) ^ this.type.hashCode()) * 1000003)) ^ (j ^ (j >>> 32)))) * 1000003)) ^ (j2 ^ (j2 >>> 32)))) * 1000003);
        long j3 = this.compressedMessageSize;
        return (int) (hashCode2 ^ (j3 ^ (j3 >>> 32)));
    }

    static final class Builder extends NetworkEvent.Builder {
        private Long compressedMessageSize;
        private Timestamp kernelTimestamp;
        private Long messageId;
        private NetworkEvent.Type type;
        private Long uncompressedMessageSize;

        Builder() {
        }

        public NetworkEvent.Builder setKernelTimestamp(@Nullable Timestamp timestamp) {
            this.kernelTimestamp = timestamp;
            return this;
        }

        /* access modifiers changed from: package-private */
        public NetworkEvent.Builder setType(NetworkEvent.Type type2) {
            if (type2 != null) {
                this.type = type2;
                return this;
            }
            throw new NullPointerException("Null type");
        }

        /* access modifiers changed from: package-private */
        public NetworkEvent.Builder setMessageId(long j) {
            this.messageId = Long.valueOf(j);
            return this;
        }

        public NetworkEvent.Builder setUncompressedMessageSize(long j) {
            this.uncompressedMessageSize = Long.valueOf(j);
            return this;
        }

        public NetworkEvent.Builder setCompressedMessageSize(long j) {
            this.compressedMessageSize = Long.valueOf(j);
            return this;
        }

        public NetworkEvent build() {
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
                return new AutoValue_NetworkEvent(this.kernelTimestamp, this.type, this.messageId.longValue(), this.uncompressedMessageSize.longValue(), this.compressedMessageSize.longValue());
            }
            throw new IllegalStateException("Missing required properties:" + str);
        }
    }
}
