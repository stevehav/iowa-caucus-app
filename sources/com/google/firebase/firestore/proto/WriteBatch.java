package com.google.firebase.firestore.proto;

import com.google.firestore.v1.Write;
import com.google.firestore.v1.WriteOrBuilder;
import com.google.protobuf.AbstractMessageLite;
import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.Internal;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.MessageLite;
import com.google.protobuf.Parser;
import com.google.protobuf.Timestamp;
import java.io.IOException;
import java.io.InputStream;
import java.util.Collections;
import java.util.List;

/* compiled from: com.google.firebase:firebase-firestore@@20.2.0 */
public final class WriteBatch extends GeneratedMessageLite<WriteBatch, Builder> implements WriteBatchOrBuilder {
    public static final int BASE_WRITES_FIELD_NUMBER = 4;
    public static final int BATCH_ID_FIELD_NUMBER = 1;
    /* access modifiers changed from: private */
    public static final WriteBatch DEFAULT_INSTANCE = new WriteBatch();
    public static final int LOCAL_WRITE_TIME_FIELD_NUMBER = 3;
    private static volatile Parser<WriteBatch> PARSER = null;
    public static final int WRITES_FIELD_NUMBER = 2;
    private Internal.ProtobufList<Write> baseWrites_ = emptyProtobufList();
    private int batchId_;
    private int bitField0_;
    private Timestamp localWriteTime_;
    private Internal.ProtobufList<Write> writes_ = emptyProtobufList();

    private WriteBatch() {
    }

    public int getBatchId() {
        return this.batchId_;
    }

    /* access modifiers changed from: private */
    public void setBatchId(int i) {
        this.batchId_ = i;
    }

    /* access modifiers changed from: private */
    public void clearBatchId() {
        this.batchId_ = 0;
    }

    public List<Write> getWritesList() {
        return this.writes_;
    }

    public List<? extends WriteOrBuilder> getWritesOrBuilderList() {
        return this.writes_;
    }

    public int getWritesCount() {
        return this.writes_.size();
    }

    public Write getWrites(int i) {
        return (Write) this.writes_.get(i);
    }

    public WriteOrBuilder getWritesOrBuilder(int i) {
        return (WriteOrBuilder) this.writes_.get(i);
    }

    private void ensureWritesIsMutable() {
        if (!this.writes_.isModifiable()) {
            this.writes_ = GeneratedMessageLite.mutableCopy(this.writes_);
        }
    }

    /* access modifiers changed from: private */
    public void setWrites(int i, Write write) {
        if (write != null) {
            ensureWritesIsMutable();
            this.writes_.set(i, write);
            return;
        }
        throw new NullPointerException();
    }

    /* access modifiers changed from: private */
    public void setWrites(int i, Write.Builder builder) {
        ensureWritesIsMutable();
        this.writes_.set(i, (Write) builder.build());
    }

    /* access modifiers changed from: private */
    public void addWrites(Write write) {
        if (write != null) {
            ensureWritesIsMutable();
            this.writes_.add(write);
            return;
        }
        throw new NullPointerException();
    }

    /* access modifiers changed from: private */
    public void addWrites(int i, Write write) {
        if (write != null) {
            ensureWritesIsMutable();
            this.writes_.add(i, write);
            return;
        }
        throw new NullPointerException();
    }

    /* access modifiers changed from: private */
    public void addWrites(Write.Builder builder) {
        ensureWritesIsMutable();
        this.writes_.add((Write) builder.build());
    }

    /* access modifiers changed from: private */
    public void addWrites(int i, Write.Builder builder) {
        ensureWritesIsMutable();
        this.writes_.add(i, (Write) builder.build());
    }

    /* access modifiers changed from: private */
    public void addAllWrites(Iterable<? extends Write> iterable) {
        ensureWritesIsMutable();
        AbstractMessageLite.addAll(iterable, this.writes_);
    }

    /* access modifiers changed from: private */
    public void clearWrites() {
        this.writes_ = emptyProtobufList();
    }

    /* access modifiers changed from: private */
    public void removeWrites(int i) {
        ensureWritesIsMutable();
        this.writes_.remove(i);
    }

    public boolean hasLocalWriteTime() {
        return this.localWriteTime_ != null;
    }

    public Timestamp getLocalWriteTime() {
        Timestamp timestamp = this.localWriteTime_;
        return timestamp == null ? Timestamp.getDefaultInstance() : timestamp;
    }

    /* access modifiers changed from: private */
    public void setLocalWriteTime(Timestamp timestamp) {
        if (timestamp != null) {
            this.localWriteTime_ = timestamp;
            return;
        }
        throw new NullPointerException();
    }

    /* access modifiers changed from: private */
    public void setLocalWriteTime(Timestamp.Builder builder) {
        this.localWriteTime_ = (Timestamp) builder.build();
    }

    /* access modifiers changed from: private */
    public void mergeLocalWriteTime(Timestamp timestamp) {
        Timestamp timestamp2 = this.localWriteTime_;
        if (timestamp2 == null || timestamp2 == Timestamp.getDefaultInstance()) {
            this.localWriteTime_ = timestamp;
        } else {
            this.localWriteTime_ = (Timestamp) ((Timestamp.Builder) Timestamp.newBuilder(this.localWriteTime_).mergeFrom(timestamp)).buildPartial();
        }
    }

    /* access modifiers changed from: private */
    public void clearLocalWriteTime() {
        this.localWriteTime_ = null;
    }

    public List<Write> getBaseWritesList() {
        return this.baseWrites_;
    }

    public List<? extends WriteOrBuilder> getBaseWritesOrBuilderList() {
        return this.baseWrites_;
    }

    public int getBaseWritesCount() {
        return this.baseWrites_.size();
    }

    public Write getBaseWrites(int i) {
        return (Write) this.baseWrites_.get(i);
    }

    public WriteOrBuilder getBaseWritesOrBuilder(int i) {
        return (WriteOrBuilder) this.baseWrites_.get(i);
    }

    private void ensureBaseWritesIsMutable() {
        if (!this.baseWrites_.isModifiable()) {
            this.baseWrites_ = GeneratedMessageLite.mutableCopy(this.baseWrites_);
        }
    }

    /* access modifiers changed from: private */
    public void setBaseWrites(int i, Write write) {
        if (write != null) {
            ensureBaseWritesIsMutable();
            this.baseWrites_.set(i, write);
            return;
        }
        throw new NullPointerException();
    }

    /* access modifiers changed from: private */
    public void setBaseWrites(int i, Write.Builder builder) {
        ensureBaseWritesIsMutable();
        this.baseWrites_.set(i, (Write) builder.build());
    }

    /* access modifiers changed from: private */
    public void addBaseWrites(Write write) {
        if (write != null) {
            ensureBaseWritesIsMutable();
            this.baseWrites_.add(write);
            return;
        }
        throw new NullPointerException();
    }

    /* access modifiers changed from: private */
    public void addBaseWrites(int i, Write write) {
        if (write != null) {
            ensureBaseWritesIsMutable();
            this.baseWrites_.add(i, write);
            return;
        }
        throw new NullPointerException();
    }

    /* access modifiers changed from: private */
    public void addBaseWrites(Write.Builder builder) {
        ensureBaseWritesIsMutable();
        this.baseWrites_.add((Write) builder.build());
    }

    /* access modifiers changed from: private */
    public void addBaseWrites(int i, Write.Builder builder) {
        ensureBaseWritesIsMutable();
        this.baseWrites_.add(i, (Write) builder.build());
    }

    /* access modifiers changed from: private */
    public void addAllBaseWrites(Iterable<? extends Write> iterable) {
        ensureBaseWritesIsMutable();
        AbstractMessageLite.addAll(iterable, this.baseWrites_);
    }

    /* access modifiers changed from: private */
    public void clearBaseWrites() {
        this.baseWrites_ = emptyProtobufList();
    }

    /* access modifiers changed from: private */
    public void removeBaseWrites(int i) {
        ensureBaseWritesIsMutable();
        this.baseWrites_.remove(i);
    }

    public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
        int i = this.batchId_;
        if (i != 0) {
            codedOutputStream.writeInt32(1, i);
        }
        for (int i2 = 0; i2 < this.writes_.size(); i2++) {
            codedOutputStream.writeMessage(2, (MessageLite) this.writes_.get(i2));
        }
        if (this.localWriteTime_ != null) {
            codedOutputStream.writeMessage(3, getLocalWriteTime());
        }
        for (int i3 = 0; i3 < this.baseWrites_.size(); i3++) {
            codedOutputStream.writeMessage(4, (MessageLite) this.baseWrites_.get(i3));
        }
    }

    public int getSerializedSize() {
        int i = this.memoizedSerializedSize;
        if (i != -1) {
            return i;
        }
        int i2 = this.batchId_;
        int computeInt32Size = i2 != 0 ? CodedOutputStream.computeInt32Size(1, i2) + 0 : 0;
        for (int i3 = 0; i3 < this.writes_.size(); i3++) {
            computeInt32Size += CodedOutputStream.computeMessageSize(2, (MessageLite) this.writes_.get(i3));
        }
        if (this.localWriteTime_ != null) {
            computeInt32Size += CodedOutputStream.computeMessageSize(3, getLocalWriteTime());
        }
        for (int i4 = 0; i4 < this.baseWrites_.size(); i4++) {
            computeInt32Size += CodedOutputStream.computeMessageSize(4, (MessageLite) this.baseWrites_.get(i4));
        }
        this.memoizedSerializedSize = computeInt32Size;
        return computeInt32Size;
    }

    public static WriteBatch parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
        return (WriteBatch) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
    }

    public static WriteBatch parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (WriteBatch) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }

    public static WriteBatch parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
        return (WriteBatch) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static WriteBatch parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (WriteBatch) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
    }

    public static WriteBatch parseFrom(InputStream inputStream) throws IOException {
        return (WriteBatch) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static WriteBatch parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (WriteBatch) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static WriteBatch parseDelimitedFrom(InputStream inputStream) throws IOException {
        return (WriteBatch) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static WriteBatch parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (WriteBatch) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static WriteBatch parseFrom(CodedInputStream codedInputStream) throws IOException {
        return (WriteBatch) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
    }

    public static WriteBatch parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (WriteBatch) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
    }

    public static Builder newBuilder() {
        return (Builder) DEFAULT_INSTANCE.toBuilder();
    }

    public static Builder newBuilder(WriteBatch writeBatch) {
        return (Builder) ((Builder) DEFAULT_INSTANCE.toBuilder()).mergeFrom(writeBatch);
    }

    /* compiled from: com.google.firebase:firebase-firestore@@20.2.0 */
    public static final class Builder extends GeneratedMessageLite.Builder<WriteBatch, Builder> implements WriteBatchOrBuilder {
        private Builder() {
            super(WriteBatch.DEFAULT_INSTANCE);
        }

        public int getBatchId() {
            return ((WriteBatch) this.instance).getBatchId();
        }

        public Builder setBatchId(int i) {
            copyOnWrite();
            ((WriteBatch) this.instance).setBatchId(i);
            return this;
        }

        public Builder clearBatchId() {
            copyOnWrite();
            ((WriteBatch) this.instance).clearBatchId();
            return this;
        }

        public List<Write> getWritesList() {
            return Collections.unmodifiableList(((WriteBatch) this.instance).getWritesList());
        }

        public int getWritesCount() {
            return ((WriteBatch) this.instance).getWritesCount();
        }

        public Write getWrites(int i) {
            return ((WriteBatch) this.instance).getWrites(i);
        }

        public Builder setWrites(int i, Write write) {
            copyOnWrite();
            ((WriteBatch) this.instance).setWrites(i, write);
            return this;
        }

        public Builder setWrites(int i, Write.Builder builder) {
            copyOnWrite();
            ((WriteBatch) this.instance).setWrites(i, builder);
            return this;
        }

        public Builder addWrites(Write write) {
            copyOnWrite();
            ((WriteBatch) this.instance).addWrites(write);
            return this;
        }

        public Builder addWrites(int i, Write write) {
            copyOnWrite();
            ((WriteBatch) this.instance).addWrites(i, write);
            return this;
        }

        public Builder addWrites(Write.Builder builder) {
            copyOnWrite();
            ((WriteBatch) this.instance).addWrites(builder);
            return this;
        }

        public Builder addWrites(int i, Write.Builder builder) {
            copyOnWrite();
            ((WriteBatch) this.instance).addWrites(i, builder);
            return this;
        }

        public Builder addAllWrites(Iterable<? extends Write> iterable) {
            copyOnWrite();
            ((WriteBatch) this.instance).addAllWrites(iterable);
            return this;
        }

        public Builder clearWrites() {
            copyOnWrite();
            ((WriteBatch) this.instance).clearWrites();
            return this;
        }

        public Builder removeWrites(int i) {
            copyOnWrite();
            ((WriteBatch) this.instance).removeWrites(i);
            return this;
        }

        public boolean hasLocalWriteTime() {
            return ((WriteBatch) this.instance).hasLocalWriteTime();
        }

        public Timestamp getLocalWriteTime() {
            return ((WriteBatch) this.instance).getLocalWriteTime();
        }

        public Builder setLocalWriteTime(Timestamp timestamp) {
            copyOnWrite();
            ((WriteBatch) this.instance).setLocalWriteTime(timestamp);
            return this;
        }

        public Builder setLocalWriteTime(Timestamp.Builder builder) {
            copyOnWrite();
            ((WriteBatch) this.instance).setLocalWriteTime(builder);
            return this;
        }

        public Builder mergeLocalWriteTime(Timestamp timestamp) {
            copyOnWrite();
            ((WriteBatch) this.instance).mergeLocalWriteTime(timestamp);
            return this;
        }

        public Builder clearLocalWriteTime() {
            copyOnWrite();
            ((WriteBatch) this.instance).clearLocalWriteTime();
            return this;
        }

        public List<Write> getBaseWritesList() {
            return Collections.unmodifiableList(((WriteBatch) this.instance).getBaseWritesList());
        }

        public int getBaseWritesCount() {
            return ((WriteBatch) this.instance).getBaseWritesCount();
        }

        public Write getBaseWrites(int i) {
            return ((WriteBatch) this.instance).getBaseWrites(i);
        }

        public Builder setBaseWrites(int i, Write write) {
            copyOnWrite();
            ((WriteBatch) this.instance).setBaseWrites(i, write);
            return this;
        }

        public Builder setBaseWrites(int i, Write.Builder builder) {
            copyOnWrite();
            ((WriteBatch) this.instance).setBaseWrites(i, builder);
            return this;
        }

        public Builder addBaseWrites(Write write) {
            copyOnWrite();
            ((WriteBatch) this.instance).addBaseWrites(write);
            return this;
        }

        public Builder addBaseWrites(int i, Write write) {
            copyOnWrite();
            ((WriteBatch) this.instance).addBaseWrites(i, write);
            return this;
        }

        public Builder addBaseWrites(Write.Builder builder) {
            copyOnWrite();
            ((WriteBatch) this.instance).addBaseWrites(builder);
            return this;
        }

        public Builder addBaseWrites(int i, Write.Builder builder) {
            copyOnWrite();
            ((WriteBatch) this.instance).addBaseWrites(i, builder);
            return this;
        }

        public Builder addAllBaseWrites(Iterable<? extends Write> iterable) {
            copyOnWrite();
            ((WriteBatch) this.instance).addAllBaseWrites(iterable);
            return this;
        }

        public Builder clearBaseWrites() {
            copyOnWrite();
            ((WriteBatch) this.instance).clearBaseWrites();
            return this;
        }

        public Builder removeBaseWrites(int i) {
            copyOnWrite();
            ((WriteBatch) this.instance).removeBaseWrites(i);
            return this;
        }
    }

    /* access modifiers changed from: protected */
    public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        boolean z = false;
        switch (methodToInvoke) {
            case NEW_MUTABLE_INSTANCE:
                return new WriteBatch();
            case IS_INITIALIZED:
                return DEFAULT_INSTANCE;
            case MAKE_IMMUTABLE:
                this.writes_.makeImmutable();
                this.baseWrites_.makeImmutable();
                return null;
            case NEW_BUILDER:
                return new Builder();
            case VISIT:
                GeneratedMessageLite.Visitor visitor = (GeneratedMessageLite.Visitor) obj;
                WriteBatch writeBatch = (WriteBatch) obj2;
                boolean z2 = this.batchId_ != 0;
                int i = this.batchId_;
                if (writeBatch.batchId_ != 0) {
                    z = true;
                }
                this.batchId_ = visitor.visitInt(z2, i, z, writeBatch.batchId_);
                this.writes_ = visitor.visitList(this.writes_, writeBatch.writes_);
                this.localWriteTime_ = (Timestamp) visitor.visitMessage(this.localWriteTime_, writeBatch.localWriteTime_);
                this.baseWrites_ = visitor.visitList(this.baseWrites_, writeBatch.baseWrites_);
                if (visitor == GeneratedMessageLite.MergeFromVisitor.INSTANCE) {
                    this.bitField0_ |= writeBatch.bitField0_;
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
                                this.batchId_ = codedInputStream.readInt32();
                            } else if (readTag == 18) {
                                if (!this.writes_.isModifiable()) {
                                    this.writes_ = GeneratedMessageLite.mutableCopy(this.writes_);
                                }
                                this.writes_.add((Write) codedInputStream.readMessage(Write.parser(), extensionRegistryLite));
                            } else if (readTag == 26) {
                                Timestamp.Builder builder = this.localWriteTime_ != null ? (Timestamp.Builder) this.localWriteTime_.toBuilder() : null;
                                this.localWriteTime_ = (Timestamp) codedInputStream.readMessage(Timestamp.parser(), extensionRegistryLite);
                                if (builder != null) {
                                    builder.mergeFrom(this.localWriteTime_);
                                    this.localWriteTime_ = (Timestamp) builder.buildPartial();
                                }
                            } else if (readTag == 34) {
                                if (!this.baseWrites_.isModifiable()) {
                                    this.baseWrites_ = GeneratedMessageLite.mutableCopy(this.baseWrites_);
                                }
                                this.baseWrites_.add((Write) codedInputStream.readMessage(Write.parser(), extensionRegistryLite));
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
                    synchronized (WriteBatch.class) {
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

    public static WriteBatch getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static Parser<WriteBatch> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }
}
