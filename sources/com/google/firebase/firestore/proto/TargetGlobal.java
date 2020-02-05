package com.google.firebase.firestore.proto;

import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.Parser;
import com.google.protobuf.Timestamp;
import java.io.IOException;
import java.io.InputStream;

/* compiled from: com.google.firebase:firebase-firestore@@20.2.0 */
public final class TargetGlobal extends GeneratedMessageLite<TargetGlobal, Builder> implements TargetGlobalOrBuilder {
    /* access modifiers changed from: private */
    public static final TargetGlobal DEFAULT_INSTANCE = new TargetGlobal();
    public static final int HIGHEST_LISTEN_SEQUENCE_NUMBER_FIELD_NUMBER = 2;
    public static final int HIGHEST_TARGET_ID_FIELD_NUMBER = 1;
    public static final int LAST_REMOTE_SNAPSHOT_VERSION_FIELD_NUMBER = 3;
    private static volatile Parser<TargetGlobal> PARSER = null;
    public static final int TARGET_COUNT_FIELD_NUMBER = 4;
    private long highestListenSequenceNumber_;
    private int highestTargetId_;
    private Timestamp lastRemoteSnapshotVersion_;
    private int targetCount_;

    private TargetGlobal() {
    }

    public int getHighestTargetId() {
        return this.highestTargetId_;
    }

    /* access modifiers changed from: private */
    public void setHighestTargetId(int i) {
        this.highestTargetId_ = i;
    }

    /* access modifiers changed from: private */
    public void clearHighestTargetId() {
        this.highestTargetId_ = 0;
    }

    public long getHighestListenSequenceNumber() {
        return this.highestListenSequenceNumber_;
    }

    /* access modifiers changed from: private */
    public void setHighestListenSequenceNumber(long j) {
        this.highestListenSequenceNumber_ = j;
    }

    /* access modifiers changed from: private */
    public void clearHighestListenSequenceNumber() {
        this.highestListenSequenceNumber_ = 0;
    }

    public boolean hasLastRemoteSnapshotVersion() {
        return this.lastRemoteSnapshotVersion_ != null;
    }

    public Timestamp getLastRemoteSnapshotVersion() {
        Timestamp timestamp = this.lastRemoteSnapshotVersion_;
        return timestamp == null ? Timestamp.getDefaultInstance() : timestamp;
    }

    /* access modifiers changed from: private */
    public void setLastRemoteSnapshotVersion(Timestamp timestamp) {
        if (timestamp != null) {
            this.lastRemoteSnapshotVersion_ = timestamp;
            return;
        }
        throw new NullPointerException();
    }

    /* access modifiers changed from: private */
    public void setLastRemoteSnapshotVersion(Timestamp.Builder builder) {
        this.lastRemoteSnapshotVersion_ = (Timestamp) builder.build();
    }

    /* access modifiers changed from: private */
    public void mergeLastRemoteSnapshotVersion(Timestamp timestamp) {
        Timestamp timestamp2 = this.lastRemoteSnapshotVersion_;
        if (timestamp2 == null || timestamp2 == Timestamp.getDefaultInstance()) {
            this.lastRemoteSnapshotVersion_ = timestamp;
        } else {
            this.lastRemoteSnapshotVersion_ = (Timestamp) ((Timestamp.Builder) Timestamp.newBuilder(this.lastRemoteSnapshotVersion_).mergeFrom(timestamp)).buildPartial();
        }
    }

    /* access modifiers changed from: private */
    public void clearLastRemoteSnapshotVersion() {
        this.lastRemoteSnapshotVersion_ = null;
    }

    public int getTargetCount() {
        return this.targetCount_;
    }

    /* access modifiers changed from: private */
    public void setTargetCount(int i) {
        this.targetCount_ = i;
    }

    /* access modifiers changed from: private */
    public void clearTargetCount() {
        this.targetCount_ = 0;
    }

    public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
        int i = this.highestTargetId_;
        if (i != 0) {
            codedOutputStream.writeInt32(1, i);
        }
        long j = this.highestListenSequenceNumber_;
        if (j != 0) {
            codedOutputStream.writeInt64(2, j);
        }
        if (this.lastRemoteSnapshotVersion_ != null) {
            codedOutputStream.writeMessage(3, getLastRemoteSnapshotVersion());
        }
        int i2 = this.targetCount_;
        if (i2 != 0) {
            codedOutputStream.writeInt32(4, i2);
        }
    }

    public int getSerializedSize() {
        int i = this.memoizedSerializedSize;
        if (i != -1) {
            return i;
        }
        int i2 = 0;
        int i3 = this.highestTargetId_;
        if (i3 != 0) {
            i2 = 0 + CodedOutputStream.computeInt32Size(1, i3);
        }
        long j = this.highestListenSequenceNumber_;
        if (j != 0) {
            i2 += CodedOutputStream.computeInt64Size(2, j);
        }
        if (this.lastRemoteSnapshotVersion_ != null) {
            i2 += CodedOutputStream.computeMessageSize(3, getLastRemoteSnapshotVersion());
        }
        int i4 = this.targetCount_;
        if (i4 != 0) {
            i2 += CodedOutputStream.computeInt32Size(4, i4);
        }
        this.memoizedSerializedSize = i2;
        return i2;
    }

    public static TargetGlobal parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
        return (TargetGlobal) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
    }

    public static TargetGlobal parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (TargetGlobal) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }

    public static TargetGlobal parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
        return (TargetGlobal) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static TargetGlobal parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (TargetGlobal) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
    }

    public static TargetGlobal parseFrom(InputStream inputStream) throws IOException {
        return (TargetGlobal) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static TargetGlobal parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (TargetGlobal) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static TargetGlobal parseDelimitedFrom(InputStream inputStream) throws IOException {
        return (TargetGlobal) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static TargetGlobal parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (TargetGlobal) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static TargetGlobal parseFrom(CodedInputStream codedInputStream) throws IOException {
        return (TargetGlobal) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
    }

    public static TargetGlobal parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (TargetGlobal) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
    }

    public static Builder newBuilder() {
        return (Builder) DEFAULT_INSTANCE.toBuilder();
    }

    public static Builder newBuilder(TargetGlobal targetGlobal) {
        return (Builder) ((Builder) DEFAULT_INSTANCE.toBuilder()).mergeFrom(targetGlobal);
    }

    /* compiled from: com.google.firebase:firebase-firestore@@20.2.0 */
    public static final class Builder extends GeneratedMessageLite.Builder<TargetGlobal, Builder> implements TargetGlobalOrBuilder {
        private Builder() {
            super(TargetGlobal.DEFAULT_INSTANCE);
        }

        public int getHighestTargetId() {
            return ((TargetGlobal) this.instance).getHighestTargetId();
        }

        public Builder setHighestTargetId(int i) {
            copyOnWrite();
            ((TargetGlobal) this.instance).setHighestTargetId(i);
            return this;
        }

        public Builder clearHighestTargetId() {
            copyOnWrite();
            ((TargetGlobal) this.instance).clearHighestTargetId();
            return this;
        }

        public long getHighestListenSequenceNumber() {
            return ((TargetGlobal) this.instance).getHighestListenSequenceNumber();
        }

        public Builder setHighestListenSequenceNumber(long j) {
            copyOnWrite();
            ((TargetGlobal) this.instance).setHighestListenSequenceNumber(j);
            return this;
        }

        public Builder clearHighestListenSequenceNumber() {
            copyOnWrite();
            ((TargetGlobal) this.instance).clearHighestListenSequenceNumber();
            return this;
        }

        public boolean hasLastRemoteSnapshotVersion() {
            return ((TargetGlobal) this.instance).hasLastRemoteSnapshotVersion();
        }

        public Timestamp getLastRemoteSnapshotVersion() {
            return ((TargetGlobal) this.instance).getLastRemoteSnapshotVersion();
        }

        public Builder setLastRemoteSnapshotVersion(Timestamp timestamp) {
            copyOnWrite();
            ((TargetGlobal) this.instance).setLastRemoteSnapshotVersion(timestamp);
            return this;
        }

        public Builder setLastRemoteSnapshotVersion(Timestamp.Builder builder) {
            copyOnWrite();
            ((TargetGlobal) this.instance).setLastRemoteSnapshotVersion(builder);
            return this;
        }

        public Builder mergeLastRemoteSnapshotVersion(Timestamp timestamp) {
            copyOnWrite();
            ((TargetGlobal) this.instance).mergeLastRemoteSnapshotVersion(timestamp);
            return this;
        }

        public Builder clearLastRemoteSnapshotVersion() {
            copyOnWrite();
            ((TargetGlobal) this.instance).clearLastRemoteSnapshotVersion();
            return this;
        }

        public int getTargetCount() {
            return ((TargetGlobal) this.instance).getTargetCount();
        }

        public Builder setTargetCount(int i) {
            copyOnWrite();
            ((TargetGlobal) this.instance).setTargetCount(i);
            return this;
        }

        public Builder clearTargetCount() {
            copyOnWrite();
            ((TargetGlobal) this.instance).clearTargetCount();
            return this;
        }
    }

    /* access modifiers changed from: protected */
    public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        boolean z = false;
        switch (methodToInvoke) {
            case NEW_MUTABLE_INSTANCE:
                return new TargetGlobal();
            case IS_INITIALIZED:
                return DEFAULT_INSTANCE;
            case MAKE_IMMUTABLE:
                return null;
            case NEW_BUILDER:
                return new Builder();
            case VISIT:
                GeneratedMessageLite.Visitor visitor = (GeneratedMessageLite.Visitor) obj;
                TargetGlobal targetGlobal = (TargetGlobal) obj2;
                this.highestTargetId_ = visitor.visitInt(this.highestTargetId_ != 0, this.highestTargetId_, targetGlobal.highestTargetId_ != 0, targetGlobal.highestTargetId_);
                this.highestListenSequenceNumber_ = visitor.visitLong(this.highestListenSequenceNumber_ != 0, this.highestListenSequenceNumber_, targetGlobal.highestListenSequenceNumber_ != 0, targetGlobal.highestListenSequenceNumber_);
                this.lastRemoteSnapshotVersion_ = (Timestamp) visitor.visitMessage(this.lastRemoteSnapshotVersion_, targetGlobal.lastRemoteSnapshotVersion_);
                boolean z2 = this.targetCount_ != 0;
                int i = this.targetCount_;
                if (targetGlobal.targetCount_ != 0) {
                    z = true;
                }
                this.targetCount_ = visitor.visitInt(z2, i, z, targetGlobal.targetCount_);
                GeneratedMessageLite.MergeFromVisitor mergeFromVisitor = GeneratedMessageLite.MergeFromVisitor.INSTANCE;
                return this;
            case MERGE_FROM_STREAM:
                CodedInputStream codedInputStream = (CodedInputStream) obj;
                ExtensionRegistryLite extensionRegistryLite = (ExtensionRegistryLite) obj2;
                while (!z) {
                    try {
                        int readTag = codedInputStream.readTag();
                        if (readTag != 0) {
                            if (readTag == 8) {
                                this.highestTargetId_ = codedInputStream.readInt32();
                            } else if (readTag == 16) {
                                this.highestListenSequenceNumber_ = codedInputStream.readInt64();
                            } else if (readTag == 26) {
                                Timestamp.Builder builder = this.lastRemoteSnapshotVersion_ != null ? (Timestamp.Builder) this.lastRemoteSnapshotVersion_.toBuilder() : null;
                                this.lastRemoteSnapshotVersion_ = (Timestamp) codedInputStream.readMessage(Timestamp.parser(), extensionRegistryLite);
                                if (builder != null) {
                                    builder.mergeFrom(this.lastRemoteSnapshotVersion_);
                                    this.lastRemoteSnapshotVersion_ = (Timestamp) builder.buildPartial();
                                }
                            } else if (readTag == 32) {
                                this.targetCount_ = codedInputStream.readInt32();
                            } else if (!codedInputStream.skipField(readTag)) {
                            }
                        }
                        z = true;
                    } catch (InvalidProtocolBufferException e) {
                        throw new RuntimeException(e.setUnfinishedMessage(this));
                    } catch (IOException e2) {
                        throw new RuntimeException(new InvalidProtocolBufferException(e2.getMessage()).setUnfinishedMessage(this));
                    }
                }
                break;
            case GET_DEFAULT_INSTANCE:
                break;
            case GET_PARSER:
                if (PARSER == null) {
                    synchronized (TargetGlobal.class) {
                        if (PARSER == null) {
                            PARSER = new GeneratedMessageLite.DefaultInstanceBasedParser(DEFAULT_INSTANCE);
                        }
                    }
                }
                return PARSER;
            default:
                throw new UnsupportedOperationException();
        }
        return DEFAULT_INSTANCE;
    }

    static {
        DEFAULT_INSTANCE.makeImmutable();
    }

    public static TargetGlobal getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static Parser<TargetGlobal> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }
}
