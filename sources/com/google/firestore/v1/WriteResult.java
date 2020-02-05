package com.google.firestore.v1;

import com.google.firestore.v1.Value;
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
public final class WriteResult extends GeneratedMessageLite<WriteResult, Builder> implements WriteResultOrBuilder {
    /* access modifiers changed from: private */
    public static final WriteResult DEFAULT_INSTANCE = new WriteResult();
    private static volatile Parser<WriteResult> PARSER = null;
    public static final int TRANSFORM_RESULTS_FIELD_NUMBER = 2;
    public static final int UPDATE_TIME_FIELD_NUMBER = 1;
    private int bitField0_;
    private Internal.ProtobufList<Value> transformResults_ = emptyProtobufList();
    private Timestamp updateTime_;

    private WriteResult() {
    }

    public boolean hasUpdateTime() {
        return this.updateTime_ != null;
    }

    public Timestamp getUpdateTime() {
        Timestamp timestamp = this.updateTime_;
        return timestamp == null ? Timestamp.getDefaultInstance() : timestamp;
    }

    /* access modifiers changed from: private */
    public void setUpdateTime(Timestamp timestamp) {
        if (timestamp != null) {
            this.updateTime_ = timestamp;
            return;
        }
        throw new NullPointerException();
    }

    /* access modifiers changed from: private */
    public void setUpdateTime(Timestamp.Builder builder) {
        this.updateTime_ = (Timestamp) builder.build();
    }

    /* access modifiers changed from: private */
    public void mergeUpdateTime(Timestamp timestamp) {
        Timestamp timestamp2 = this.updateTime_;
        if (timestamp2 == null || timestamp2 == Timestamp.getDefaultInstance()) {
            this.updateTime_ = timestamp;
        } else {
            this.updateTime_ = (Timestamp) ((Timestamp.Builder) Timestamp.newBuilder(this.updateTime_).mergeFrom(timestamp)).buildPartial();
        }
    }

    /* access modifiers changed from: private */
    public void clearUpdateTime() {
        this.updateTime_ = null;
    }

    public List<Value> getTransformResultsList() {
        return this.transformResults_;
    }

    public List<? extends ValueOrBuilder> getTransformResultsOrBuilderList() {
        return this.transformResults_;
    }

    public int getTransformResultsCount() {
        return this.transformResults_.size();
    }

    public Value getTransformResults(int i) {
        return (Value) this.transformResults_.get(i);
    }

    public ValueOrBuilder getTransformResultsOrBuilder(int i) {
        return (ValueOrBuilder) this.transformResults_.get(i);
    }

    private void ensureTransformResultsIsMutable() {
        if (!this.transformResults_.isModifiable()) {
            this.transformResults_ = GeneratedMessageLite.mutableCopy(this.transformResults_);
        }
    }

    /* access modifiers changed from: private */
    public void setTransformResults(int i, Value value) {
        if (value != null) {
            ensureTransformResultsIsMutable();
            this.transformResults_.set(i, value);
            return;
        }
        throw new NullPointerException();
    }

    /* access modifiers changed from: private */
    public void setTransformResults(int i, Value.Builder builder) {
        ensureTransformResultsIsMutable();
        this.transformResults_.set(i, (Value) builder.build());
    }

    /* access modifiers changed from: private */
    public void addTransformResults(Value value) {
        if (value != null) {
            ensureTransformResultsIsMutable();
            this.transformResults_.add(value);
            return;
        }
        throw new NullPointerException();
    }

    /* access modifiers changed from: private */
    public void addTransformResults(int i, Value value) {
        if (value != null) {
            ensureTransformResultsIsMutable();
            this.transformResults_.add(i, value);
            return;
        }
        throw new NullPointerException();
    }

    /* access modifiers changed from: private */
    public void addTransformResults(Value.Builder builder) {
        ensureTransformResultsIsMutable();
        this.transformResults_.add((Value) builder.build());
    }

    /* access modifiers changed from: private */
    public void addTransformResults(int i, Value.Builder builder) {
        ensureTransformResultsIsMutable();
        this.transformResults_.add(i, (Value) builder.build());
    }

    /* access modifiers changed from: private */
    public void addAllTransformResults(Iterable<? extends Value> iterable) {
        ensureTransformResultsIsMutable();
        AbstractMessageLite.addAll(iterable, this.transformResults_);
    }

    /* access modifiers changed from: private */
    public void clearTransformResults() {
        this.transformResults_ = emptyProtobufList();
    }

    /* access modifiers changed from: private */
    public void removeTransformResults(int i) {
        ensureTransformResultsIsMutable();
        this.transformResults_.remove(i);
    }

    public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
        if (this.updateTime_ != null) {
            codedOutputStream.writeMessage(1, getUpdateTime());
        }
        for (int i = 0; i < this.transformResults_.size(); i++) {
            codedOutputStream.writeMessage(2, (MessageLite) this.transformResults_.get(i));
        }
    }

    public int getSerializedSize() {
        int i = this.memoizedSerializedSize;
        if (i != -1) {
            return i;
        }
        int computeMessageSize = this.updateTime_ != null ? CodedOutputStream.computeMessageSize(1, getUpdateTime()) + 0 : 0;
        for (int i2 = 0; i2 < this.transformResults_.size(); i2++) {
            computeMessageSize += CodedOutputStream.computeMessageSize(2, (MessageLite) this.transformResults_.get(i2));
        }
        this.memoizedSerializedSize = computeMessageSize;
        return computeMessageSize;
    }

    public static WriteResult parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
        return (WriteResult) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
    }

    public static WriteResult parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (WriteResult) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }

    public static WriteResult parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
        return (WriteResult) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static WriteResult parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (WriteResult) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
    }

    public static WriteResult parseFrom(InputStream inputStream) throws IOException {
        return (WriteResult) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static WriteResult parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (WriteResult) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static WriteResult parseDelimitedFrom(InputStream inputStream) throws IOException {
        return (WriteResult) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static WriteResult parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (WriteResult) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static WriteResult parseFrom(CodedInputStream codedInputStream) throws IOException {
        return (WriteResult) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
    }

    public static WriteResult parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (WriteResult) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
    }

    public static Builder newBuilder() {
        return (Builder) DEFAULT_INSTANCE.toBuilder();
    }

    public static Builder newBuilder(WriteResult writeResult) {
        return (Builder) ((Builder) DEFAULT_INSTANCE.toBuilder()).mergeFrom(writeResult);
    }

    /* compiled from: com.google.firebase:firebase-firestore@@20.2.0 */
    public static final class Builder extends GeneratedMessageLite.Builder<WriteResult, Builder> implements WriteResultOrBuilder {
        private Builder() {
            super(WriteResult.DEFAULT_INSTANCE);
        }

        public boolean hasUpdateTime() {
            return ((WriteResult) this.instance).hasUpdateTime();
        }

        public Timestamp getUpdateTime() {
            return ((WriteResult) this.instance).getUpdateTime();
        }

        public Builder setUpdateTime(Timestamp timestamp) {
            copyOnWrite();
            ((WriteResult) this.instance).setUpdateTime(timestamp);
            return this;
        }

        public Builder setUpdateTime(Timestamp.Builder builder) {
            copyOnWrite();
            ((WriteResult) this.instance).setUpdateTime(builder);
            return this;
        }

        public Builder mergeUpdateTime(Timestamp timestamp) {
            copyOnWrite();
            ((WriteResult) this.instance).mergeUpdateTime(timestamp);
            return this;
        }

        public Builder clearUpdateTime() {
            copyOnWrite();
            ((WriteResult) this.instance).clearUpdateTime();
            return this;
        }

        public List<Value> getTransformResultsList() {
            return Collections.unmodifiableList(((WriteResult) this.instance).getTransformResultsList());
        }

        public int getTransformResultsCount() {
            return ((WriteResult) this.instance).getTransformResultsCount();
        }

        public Value getTransformResults(int i) {
            return ((WriteResult) this.instance).getTransformResults(i);
        }

        public Builder setTransformResults(int i, Value value) {
            copyOnWrite();
            ((WriteResult) this.instance).setTransformResults(i, value);
            return this;
        }

        public Builder setTransformResults(int i, Value.Builder builder) {
            copyOnWrite();
            ((WriteResult) this.instance).setTransformResults(i, builder);
            return this;
        }

        public Builder addTransformResults(Value value) {
            copyOnWrite();
            ((WriteResult) this.instance).addTransformResults(value);
            return this;
        }

        public Builder addTransformResults(int i, Value value) {
            copyOnWrite();
            ((WriteResult) this.instance).addTransformResults(i, value);
            return this;
        }

        public Builder addTransformResults(Value.Builder builder) {
            copyOnWrite();
            ((WriteResult) this.instance).addTransformResults(builder);
            return this;
        }

        public Builder addTransformResults(int i, Value.Builder builder) {
            copyOnWrite();
            ((WriteResult) this.instance).addTransformResults(i, builder);
            return this;
        }

        public Builder addAllTransformResults(Iterable<? extends Value> iterable) {
            copyOnWrite();
            ((WriteResult) this.instance).addAllTransformResults(iterable);
            return this;
        }

        public Builder clearTransformResults() {
            copyOnWrite();
            ((WriteResult) this.instance).clearTransformResults();
            return this;
        }

        public Builder removeTransformResults(int i) {
            copyOnWrite();
            ((WriteResult) this.instance).removeTransformResults(i);
            return this;
        }
    }

    /* access modifiers changed from: protected */
    public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        switch (methodToInvoke) {
            case NEW_MUTABLE_INSTANCE:
                return new WriteResult();
            case IS_INITIALIZED:
                return DEFAULT_INSTANCE;
            case MAKE_IMMUTABLE:
                this.transformResults_.makeImmutable();
                return null;
            case NEW_BUILDER:
                return new Builder();
            case VISIT:
                GeneratedMessageLite.Visitor visitor = (GeneratedMessageLite.Visitor) obj;
                WriteResult writeResult = (WriteResult) obj2;
                this.updateTime_ = (Timestamp) visitor.visitMessage(this.updateTime_, writeResult.updateTime_);
                this.transformResults_ = visitor.visitList(this.transformResults_, writeResult.transformResults_);
                if (visitor == GeneratedMessageLite.MergeFromVisitor.INSTANCE) {
                    this.bitField0_ |= writeResult.bitField0_;
                }
                return this;
            case MERGE_FROM_STREAM:
                CodedInputStream codedInputStream = (CodedInputStream) obj;
                ExtensionRegistryLite extensionRegistryLite = (ExtensionRegistryLite) obj2;
                boolean z = false;
                while (!z) {
                    try {
                        int readTag = codedInputStream.readTag();
                        if (readTag != 0) {
                            if (readTag == 10) {
                                Timestamp.Builder builder = this.updateTime_ != null ? (Timestamp.Builder) this.updateTime_.toBuilder() : null;
                                this.updateTime_ = (Timestamp) codedInputStream.readMessage(Timestamp.parser(), extensionRegistryLite);
                                if (builder != null) {
                                    builder.mergeFrom(this.updateTime_);
                                    this.updateTime_ = (Timestamp) builder.buildPartial();
                                }
                            } else if (readTag == 18) {
                                if (!this.transformResults_.isModifiable()) {
                                    this.transformResults_ = GeneratedMessageLite.mutableCopy(this.transformResults_);
                                }
                                this.transformResults_.add((Value) codedInputStream.readMessage(Value.parser(), extensionRegistryLite));
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
                    synchronized (WriteResult.class) {
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

    public static WriteResult getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static Parser<WriteResult> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }
}
