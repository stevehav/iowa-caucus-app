package com.google.firestore.v1;

import com.google.protobuf.AbstractMessageLite;
import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.Internal;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.Parser;
import com.google.protobuf.Timestamp;
import com.google.rpc.Status;
import java.io.IOException;
import java.io.InputStream;
import java.util.Collections;
import java.util.List;

/* compiled from: com.google.firebase:firebase-firestore@@20.2.0 */
public final class TargetChange extends GeneratedMessageLite<TargetChange, Builder> implements TargetChangeOrBuilder {
    public static final int CAUSE_FIELD_NUMBER = 3;
    /* access modifiers changed from: private */
    public static final TargetChange DEFAULT_INSTANCE = new TargetChange();
    private static volatile Parser<TargetChange> PARSER = null;
    public static final int READ_TIME_FIELD_NUMBER = 6;
    public static final int RESUME_TOKEN_FIELD_NUMBER = 4;
    public static final int TARGET_CHANGE_TYPE_FIELD_NUMBER = 1;
    public static final int TARGET_IDS_FIELD_NUMBER = 2;
    private int bitField0_;
    private Status cause_;
    private Timestamp readTime_;
    private ByteString resumeToken_ = ByteString.EMPTY;
    private int targetChangeType_;
    private Internal.IntList targetIds_ = emptyIntList();

    private TargetChange() {
    }

    /* compiled from: com.google.firebase:firebase-firestore@@20.2.0 */
    public enum TargetChangeType implements Internal.EnumLite {
        NO_CHANGE(0),
        ADD(1),
        REMOVE(2),
        CURRENT(3),
        RESET(4),
        UNRECOGNIZED(-1);
        
        public static final int ADD_VALUE = 1;
        public static final int CURRENT_VALUE = 3;
        public static final int NO_CHANGE_VALUE = 0;
        public static final int REMOVE_VALUE = 2;
        public static final int RESET_VALUE = 4;
        private static final Internal.EnumLiteMap<TargetChangeType> internalValueMap = null;
        private final int value;

        static {
            internalValueMap = new Internal.EnumLiteMap<TargetChangeType>() {
                public TargetChangeType findValueByNumber(int i) {
                    return TargetChangeType.forNumber(i);
                }
            };
        }

        public final int getNumber() {
            return this.value;
        }

        @Deprecated
        public static TargetChangeType valueOf(int i) {
            return forNumber(i);
        }

        public static TargetChangeType forNumber(int i) {
            if (i == 0) {
                return NO_CHANGE;
            }
            if (i == 1) {
                return ADD;
            }
            if (i == 2) {
                return REMOVE;
            }
            if (i == 3) {
                return CURRENT;
            }
            if (i != 4) {
                return null;
            }
            return RESET;
        }

        public static Internal.EnumLiteMap<TargetChangeType> internalGetValueMap() {
            return internalValueMap;
        }

        private TargetChangeType(int i) {
            this.value = i;
        }
    }

    public int getTargetChangeTypeValue() {
        return this.targetChangeType_;
    }

    public TargetChangeType getTargetChangeType() {
        TargetChangeType forNumber = TargetChangeType.forNumber(this.targetChangeType_);
        return forNumber == null ? TargetChangeType.UNRECOGNIZED : forNumber;
    }

    /* access modifiers changed from: private */
    public void setTargetChangeTypeValue(int i) {
        this.targetChangeType_ = i;
    }

    /* access modifiers changed from: private */
    public void setTargetChangeType(TargetChangeType targetChangeType) {
        if (targetChangeType != null) {
            this.targetChangeType_ = targetChangeType.getNumber();
            return;
        }
        throw new NullPointerException();
    }

    /* access modifiers changed from: private */
    public void clearTargetChangeType() {
        this.targetChangeType_ = 0;
    }

    public List<Integer> getTargetIdsList() {
        return this.targetIds_;
    }

    public int getTargetIdsCount() {
        return this.targetIds_.size();
    }

    public int getTargetIds(int i) {
        return this.targetIds_.getInt(i);
    }

    private void ensureTargetIdsIsMutable() {
        if (!this.targetIds_.isModifiable()) {
            this.targetIds_ = GeneratedMessageLite.mutableCopy(this.targetIds_);
        }
    }

    /* access modifiers changed from: private */
    public void setTargetIds(int i, int i2) {
        ensureTargetIdsIsMutable();
        this.targetIds_.setInt(i, i2);
    }

    /* access modifiers changed from: private */
    public void addTargetIds(int i) {
        ensureTargetIdsIsMutable();
        this.targetIds_.addInt(i);
    }

    /* access modifiers changed from: private */
    public void addAllTargetIds(Iterable<? extends Integer> iterable) {
        ensureTargetIdsIsMutable();
        AbstractMessageLite.addAll(iterable, this.targetIds_);
    }

    /* access modifiers changed from: private */
    public void clearTargetIds() {
        this.targetIds_ = emptyIntList();
    }

    public boolean hasCause() {
        return this.cause_ != null;
    }

    public Status getCause() {
        Status status = this.cause_;
        return status == null ? Status.getDefaultInstance() : status;
    }

    /* access modifiers changed from: private */
    public void setCause(Status status) {
        if (status != null) {
            this.cause_ = status;
            return;
        }
        throw new NullPointerException();
    }

    /* access modifiers changed from: private */
    public void setCause(Status.Builder builder) {
        this.cause_ = (Status) builder.build();
    }

    /* access modifiers changed from: private */
    public void mergeCause(Status status) {
        Status status2 = this.cause_;
        if (status2 == null || status2 == Status.getDefaultInstance()) {
            this.cause_ = status;
        } else {
            this.cause_ = (Status) ((Status.Builder) Status.newBuilder(this.cause_).mergeFrom(status)).buildPartial();
        }
    }

    /* access modifiers changed from: private */
    public void clearCause() {
        this.cause_ = null;
    }

    public ByteString getResumeToken() {
        return this.resumeToken_;
    }

    /* access modifiers changed from: private */
    public void setResumeToken(ByteString byteString) {
        if (byteString != null) {
            this.resumeToken_ = byteString;
            return;
        }
        throw new NullPointerException();
    }

    /* access modifiers changed from: private */
    public void clearResumeToken() {
        this.resumeToken_ = getDefaultInstance().getResumeToken();
    }

    public boolean hasReadTime() {
        return this.readTime_ != null;
    }

    public Timestamp getReadTime() {
        Timestamp timestamp = this.readTime_;
        return timestamp == null ? Timestamp.getDefaultInstance() : timestamp;
    }

    /* access modifiers changed from: private */
    public void setReadTime(Timestamp timestamp) {
        if (timestamp != null) {
            this.readTime_ = timestamp;
            return;
        }
        throw new NullPointerException();
    }

    /* access modifiers changed from: private */
    public void setReadTime(Timestamp.Builder builder) {
        this.readTime_ = (Timestamp) builder.build();
    }

    /* access modifiers changed from: private */
    public void mergeReadTime(Timestamp timestamp) {
        Timestamp timestamp2 = this.readTime_;
        if (timestamp2 == null || timestamp2 == Timestamp.getDefaultInstance()) {
            this.readTime_ = timestamp;
        } else {
            this.readTime_ = (Timestamp) ((Timestamp.Builder) Timestamp.newBuilder(this.readTime_).mergeFrom(timestamp)).buildPartial();
        }
    }

    /* access modifiers changed from: private */
    public void clearReadTime() {
        this.readTime_ = null;
    }

    public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
        getSerializedSize();
        if (this.targetChangeType_ != TargetChangeType.NO_CHANGE.getNumber()) {
            codedOutputStream.writeEnum(1, this.targetChangeType_);
        }
        for (int i = 0; i < this.targetIds_.size(); i++) {
            codedOutputStream.writeInt32(2, this.targetIds_.getInt(i));
        }
        if (this.cause_ != null) {
            codedOutputStream.writeMessage(3, getCause());
        }
        if (!this.resumeToken_.isEmpty()) {
            codedOutputStream.writeBytes(4, this.resumeToken_);
        }
        if (this.readTime_ != null) {
            codedOutputStream.writeMessage(6, getReadTime());
        }
    }

    public int getSerializedSize() {
        int i = this.memoizedSerializedSize;
        if (i != -1) {
            return i;
        }
        int computeEnumSize = this.targetChangeType_ != TargetChangeType.NO_CHANGE.getNumber() ? CodedOutputStream.computeEnumSize(1, this.targetChangeType_) + 0 : 0;
        int i2 = 0;
        for (int i3 = 0; i3 < this.targetIds_.size(); i3++) {
            i2 += CodedOutputStream.computeInt32SizeNoTag(this.targetIds_.getInt(i3));
        }
        int size = computeEnumSize + i2 + (getTargetIdsList().size() * 1);
        if (this.cause_ != null) {
            size += CodedOutputStream.computeMessageSize(3, getCause());
        }
        if (!this.resumeToken_.isEmpty()) {
            size += CodedOutputStream.computeBytesSize(4, this.resumeToken_);
        }
        if (this.readTime_ != null) {
            size += CodedOutputStream.computeMessageSize(6, getReadTime());
        }
        this.memoizedSerializedSize = size;
        return size;
    }

    public static TargetChange parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
        return (TargetChange) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
    }

    public static TargetChange parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (TargetChange) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }

    public static TargetChange parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
        return (TargetChange) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static TargetChange parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (TargetChange) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
    }

    public static TargetChange parseFrom(InputStream inputStream) throws IOException {
        return (TargetChange) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static TargetChange parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (TargetChange) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static TargetChange parseDelimitedFrom(InputStream inputStream) throws IOException {
        return (TargetChange) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static TargetChange parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (TargetChange) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static TargetChange parseFrom(CodedInputStream codedInputStream) throws IOException {
        return (TargetChange) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
    }

    public static TargetChange parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (TargetChange) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
    }

    public static Builder newBuilder() {
        return (Builder) DEFAULT_INSTANCE.toBuilder();
    }

    public static Builder newBuilder(TargetChange targetChange) {
        return (Builder) ((Builder) DEFAULT_INSTANCE.toBuilder()).mergeFrom(targetChange);
    }

    /* compiled from: com.google.firebase:firebase-firestore@@20.2.0 */
    public static final class Builder extends GeneratedMessageLite.Builder<TargetChange, Builder> implements TargetChangeOrBuilder {
        private Builder() {
            super(TargetChange.DEFAULT_INSTANCE);
        }

        public int getTargetChangeTypeValue() {
            return ((TargetChange) this.instance).getTargetChangeTypeValue();
        }

        public Builder setTargetChangeTypeValue(int i) {
            copyOnWrite();
            ((TargetChange) this.instance).setTargetChangeTypeValue(i);
            return this;
        }

        public TargetChangeType getTargetChangeType() {
            return ((TargetChange) this.instance).getTargetChangeType();
        }

        public Builder setTargetChangeType(TargetChangeType targetChangeType) {
            copyOnWrite();
            ((TargetChange) this.instance).setTargetChangeType(targetChangeType);
            return this;
        }

        public Builder clearTargetChangeType() {
            copyOnWrite();
            ((TargetChange) this.instance).clearTargetChangeType();
            return this;
        }

        public List<Integer> getTargetIdsList() {
            return Collections.unmodifiableList(((TargetChange) this.instance).getTargetIdsList());
        }

        public int getTargetIdsCount() {
            return ((TargetChange) this.instance).getTargetIdsCount();
        }

        public int getTargetIds(int i) {
            return ((TargetChange) this.instance).getTargetIds(i);
        }

        public Builder setTargetIds(int i, int i2) {
            copyOnWrite();
            ((TargetChange) this.instance).setTargetIds(i, i2);
            return this;
        }

        public Builder addTargetIds(int i) {
            copyOnWrite();
            ((TargetChange) this.instance).addTargetIds(i);
            return this;
        }

        public Builder addAllTargetIds(Iterable<? extends Integer> iterable) {
            copyOnWrite();
            ((TargetChange) this.instance).addAllTargetIds(iterable);
            return this;
        }

        public Builder clearTargetIds() {
            copyOnWrite();
            ((TargetChange) this.instance).clearTargetIds();
            return this;
        }

        public boolean hasCause() {
            return ((TargetChange) this.instance).hasCause();
        }

        public Status getCause() {
            return ((TargetChange) this.instance).getCause();
        }

        public Builder setCause(Status status) {
            copyOnWrite();
            ((TargetChange) this.instance).setCause(status);
            return this;
        }

        public Builder setCause(Status.Builder builder) {
            copyOnWrite();
            ((TargetChange) this.instance).setCause(builder);
            return this;
        }

        public Builder mergeCause(Status status) {
            copyOnWrite();
            ((TargetChange) this.instance).mergeCause(status);
            return this;
        }

        public Builder clearCause() {
            copyOnWrite();
            ((TargetChange) this.instance).clearCause();
            return this;
        }

        public ByteString getResumeToken() {
            return ((TargetChange) this.instance).getResumeToken();
        }

        public Builder setResumeToken(ByteString byteString) {
            copyOnWrite();
            ((TargetChange) this.instance).setResumeToken(byteString);
            return this;
        }

        public Builder clearResumeToken() {
            copyOnWrite();
            ((TargetChange) this.instance).clearResumeToken();
            return this;
        }

        public boolean hasReadTime() {
            return ((TargetChange) this.instance).hasReadTime();
        }

        public Timestamp getReadTime() {
            return ((TargetChange) this.instance).getReadTime();
        }

        public Builder setReadTime(Timestamp timestamp) {
            copyOnWrite();
            ((TargetChange) this.instance).setReadTime(timestamp);
            return this;
        }

        public Builder setReadTime(Timestamp.Builder builder) {
            copyOnWrite();
            ((TargetChange) this.instance).setReadTime(builder);
            return this;
        }

        public Builder mergeReadTime(Timestamp timestamp) {
            copyOnWrite();
            ((TargetChange) this.instance).mergeReadTime(timestamp);
            return this;
        }

        public Builder clearReadTime() {
            copyOnWrite();
            ((TargetChange) this.instance).clearReadTime();
            return this;
        }
    }

    /* access modifiers changed from: protected */
    public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        boolean z = false;
        switch (methodToInvoke) {
            case NEW_MUTABLE_INSTANCE:
                return new TargetChange();
            case IS_INITIALIZED:
                return DEFAULT_INSTANCE;
            case MAKE_IMMUTABLE:
                this.targetIds_.makeImmutable();
                return null;
            case NEW_BUILDER:
                return new Builder();
            case VISIT:
                GeneratedMessageLite.Visitor visitor = (GeneratedMessageLite.Visitor) obj;
                TargetChange targetChange = (TargetChange) obj2;
                this.targetChangeType_ = visitor.visitInt(this.targetChangeType_ != 0, this.targetChangeType_, targetChange.targetChangeType_ != 0, targetChange.targetChangeType_);
                this.targetIds_ = visitor.visitIntList(this.targetIds_, targetChange.targetIds_);
                this.cause_ = (Status) visitor.visitMessage(this.cause_, targetChange.cause_);
                boolean z2 = this.resumeToken_ != ByteString.EMPTY;
                ByteString byteString = this.resumeToken_;
                if (targetChange.resumeToken_ != ByteString.EMPTY) {
                    z = true;
                }
                this.resumeToken_ = visitor.visitByteString(z2, byteString, z, targetChange.resumeToken_);
                this.readTime_ = (Timestamp) visitor.visitMessage(this.readTime_, targetChange.readTime_);
                if (visitor == GeneratedMessageLite.MergeFromVisitor.INSTANCE) {
                    this.bitField0_ |= targetChange.bitField0_;
                }
                return this;
            case MERGE_FROM_STREAM:
                CodedInputStream codedInputStream = (CodedInputStream) obj;
                ExtensionRegistryLite extensionRegistryLite = (ExtensionRegistryLite) obj2;
                while (!z) {
                    try {
                        int readTag = codedInputStream.readTag();
                        if (readTag != 0) {
                            if (readTag == 8) {
                                this.targetChangeType_ = codedInputStream.readEnum();
                            } else if (readTag == 16) {
                                if (!this.targetIds_.isModifiable()) {
                                    this.targetIds_ = GeneratedMessageLite.mutableCopy(this.targetIds_);
                                }
                                this.targetIds_.addInt(codedInputStream.readInt32());
                            } else if (readTag == 18) {
                                int pushLimit = codedInputStream.pushLimit(codedInputStream.readRawVarint32());
                                if (!this.targetIds_.isModifiable() && codedInputStream.getBytesUntilLimit() > 0) {
                                    this.targetIds_ = GeneratedMessageLite.mutableCopy(this.targetIds_);
                                }
                                while (codedInputStream.getBytesUntilLimit() > 0) {
                                    this.targetIds_.addInt(codedInputStream.readInt32());
                                }
                                codedInputStream.popLimit(pushLimit);
                            } else if (readTag == 26) {
                                Status.Builder builder = this.cause_ != null ? (Status.Builder) this.cause_.toBuilder() : null;
                                this.cause_ = (Status) codedInputStream.readMessage(Status.parser(), extensionRegistryLite);
                                if (builder != null) {
                                    builder.mergeFrom(this.cause_);
                                    this.cause_ = (Status) builder.buildPartial();
                                }
                            } else if (readTag == 34) {
                                this.resumeToken_ = codedInputStream.readBytes();
                            } else if (readTag == 50) {
                                Timestamp.Builder builder2 = this.readTime_ != null ? (Timestamp.Builder) this.readTime_.toBuilder() : null;
                                this.readTime_ = (Timestamp) codedInputStream.readMessage(Timestamp.parser(), extensionRegistryLite);
                                if (builder2 != null) {
                                    builder2.mergeFrom(this.readTime_);
                                    this.readTime_ = (Timestamp) builder2.buildPartial();
                                }
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
                    synchronized (TargetChange.class) {
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

    public static TargetChange getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static Parser<TargetChange> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }
}
