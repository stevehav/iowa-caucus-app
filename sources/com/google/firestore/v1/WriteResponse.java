package com.google.firestore.v1;

import com.google.firestore.v1.WriteResult;
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
public final class WriteResponse extends GeneratedMessageLite<WriteResponse, Builder> implements WriteResponseOrBuilder {
    public static final int COMMIT_TIME_FIELD_NUMBER = 4;
    /* access modifiers changed from: private */
    public static final WriteResponse DEFAULT_INSTANCE = new WriteResponse();
    private static volatile Parser<WriteResponse> PARSER = null;
    public static final int STREAM_ID_FIELD_NUMBER = 1;
    public static final int STREAM_TOKEN_FIELD_NUMBER = 2;
    public static final int WRITE_RESULTS_FIELD_NUMBER = 3;
    private int bitField0_;
    private Timestamp commitTime_;
    private String streamId_ = "";
    private ByteString streamToken_ = ByteString.EMPTY;
    private Internal.ProtobufList<WriteResult> writeResults_ = emptyProtobufList();

    private WriteResponse() {
    }

    public String getStreamId() {
        return this.streamId_;
    }

    public ByteString getStreamIdBytes() {
        return ByteString.copyFromUtf8(this.streamId_);
    }

    /* access modifiers changed from: private */
    public void setStreamId(String str) {
        if (str != null) {
            this.streamId_ = str;
            return;
        }
        throw new NullPointerException();
    }

    /* access modifiers changed from: private */
    public void clearStreamId() {
        this.streamId_ = getDefaultInstance().getStreamId();
    }

    /* access modifiers changed from: private */
    public void setStreamIdBytes(ByteString byteString) {
        if (byteString != null) {
            checkByteStringIsUtf8(byteString);
            this.streamId_ = byteString.toStringUtf8();
            return;
        }
        throw new NullPointerException();
    }

    public ByteString getStreamToken() {
        return this.streamToken_;
    }

    /* access modifiers changed from: private */
    public void setStreamToken(ByteString byteString) {
        if (byteString != null) {
            this.streamToken_ = byteString;
            return;
        }
        throw new NullPointerException();
    }

    /* access modifiers changed from: private */
    public void clearStreamToken() {
        this.streamToken_ = getDefaultInstance().getStreamToken();
    }

    public List<WriteResult> getWriteResultsList() {
        return this.writeResults_;
    }

    public List<? extends WriteResultOrBuilder> getWriteResultsOrBuilderList() {
        return this.writeResults_;
    }

    public int getWriteResultsCount() {
        return this.writeResults_.size();
    }

    public WriteResult getWriteResults(int i) {
        return (WriteResult) this.writeResults_.get(i);
    }

    public WriteResultOrBuilder getWriteResultsOrBuilder(int i) {
        return (WriteResultOrBuilder) this.writeResults_.get(i);
    }

    private void ensureWriteResultsIsMutable() {
        if (!this.writeResults_.isModifiable()) {
            this.writeResults_ = GeneratedMessageLite.mutableCopy(this.writeResults_);
        }
    }

    /* access modifiers changed from: private */
    public void setWriteResults(int i, WriteResult writeResult) {
        if (writeResult != null) {
            ensureWriteResultsIsMutable();
            this.writeResults_.set(i, writeResult);
            return;
        }
        throw new NullPointerException();
    }

    /* access modifiers changed from: private */
    public void setWriteResults(int i, WriteResult.Builder builder) {
        ensureWriteResultsIsMutable();
        this.writeResults_.set(i, (WriteResult) builder.build());
    }

    /* access modifiers changed from: private */
    public void addWriteResults(WriteResult writeResult) {
        if (writeResult != null) {
            ensureWriteResultsIsMutable();
            this.writeResults_.add(writeResult);
            return;
        }
        throw new NullPointerException();
    }

    /* access modifiers changed from: private */
    public void addWriteResults(int i, WriteResult writeResult) {
        if (writeResult != null) {
            ensureWriteResultsIsMutable();
            this.writeResults_.add(i, writeResult);
            return;
        }
        throw new NullPointerException();
    }

    /* access modifiers changed from: private */
    public void addWriteResults(WriteResult.Builder builder) {
        ensureWriteResultsIsMutable();
        this.writeResults_.add((WriteResult) builder.build());
    }

    /* access modifiers changed from: private */
    public void addWriteResults(int i, WriteResult.Builder builder) {
        ensureWriteResultsIsMutable();
        this.writeResults_.add(i, (WriteResult) builder.build());
    }

    /* access modifiers changed from: private */
    public void addAllWriteResults(Iterable<? extends WriteResult> iterable) {
        ensureWriteResultsIsMutable();
        AbstractMessageLite.addAll(iterable, this.writeResults_);
    }

    /* access modifiers changed from: private */
    public void clearWriteResults() {
        this.writeResults_ = emptyProtobufList();
    }

    /* access modifiers changed from: private */
    public void removeWriteResults(int i) {
        ensureWriteResultsIsMutable();
        this.writeResults_.remove(i);
    }

    public boolean hasCommitTime() {
        return this.commitTime_ != null;
    }

    public Timestamp getCommitTime() {
        Timestamp timestamp = this.commitTime_;
        return timestamp == null ? Timestamp.getDefaultInstance() : timestamp;
    }

    /* access modifiers changed from: private */
    public void setCommitTime(Timestamp timestamp) {
        if (timestamp != null) {
            this.commitTime_ = timestamp;
            return;
        }
        throw new NullPointerException();
    }

    /* access modifiers changed from: private */
    public void setCommitTime(Timestamp.Builder builder) {
        this.commitTime_ = (Timestamp) builder.build();
    }

    /* access modifiers changed from: private */
    public void mergeCommitTime(Timestamp timestamp) {
        Timestamp timestamp2 = this.commitTime_;
        if (timestamp2 == null || timestamp2 == Timestamp.getDefaultInstance()) {
            this.commitTime_ = timestamp;
        } else {
            this.commitTime_ = (Timestamp) ((Timestamp.Builder) Timestamp.newBuilder(this.commitTime_).mergeFrom(timestamp)).buildPartial();
        }
    }

    /* access modifiers changed from: private */
    public void clearCommitTime() {
        this.commitTime_ = null;
    }

    public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
        if (!this.streamId_.isEmpty()) {
            codedOutputStream.writeString(1, getStreamId());
        }
        if (!this.streamToken_.isEmpty()) {
            codedOutputStream.writeBytes(2, this.streamToken_);
        }
        for (int i = 0; i < this.writeResults_.size(); i++) {
            codedOutputStream.writeMessage(3, (MessageLite) this.writeResults_.get(i));
        }
        if (this.commitTime_ != null) {
            codedOutputStream.writeMessage(4, getCommitTime());
        }
    }

    public int getSerializedSize() {
        int i = this.memoizedSerializedSize;
        if (i != -1) {
            return i;
        }
        int computeStringSize = !this.streamId_.isEmpty() ? CodedOutputStream.computeStringSize(1, getStreamId()) + 0 : 0;
        if (!this.streamToken_.isEmpty()) {
            computeStringSize += CodedOutputStream.computeBytesSize(2, this.streamToken_);
        }
        for (int i2 = 0; i2 < this.writeResults_.size(); i2++) {
            computeStringSize += CodedOutputStream.computeMessageSize(3, (MessageLite) this.writeResults_.get(i2));
        }
        if (this.commitTime_ != null) {
            computeStringSize += CodedOutputStream.computeMessageSize(4, getCommitTime());
        }
        this.memoizedSerializedSize = computeStringSize;
        return computeStringSize;
    }

    public static WriteResponse parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
        return (WriteResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
    }

    public static WriteResponse parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (WriteResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }

    public static WriteResponse parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
        return (WriteResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static WriteResponse parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (WriteResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
    }

    public static WriteResponse parseFrom(InputStream inputStream) throws IOException {
        return (WriteResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static WriteResponse parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (WriteResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static WriteResponse parseDelimitedFrom(InputStream inputStream) throws IOException {
        return (WriteResponse) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static WriteResponse parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (WriteResponse) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static WriteResponse parseFrom(CodedInputStream codedInputStream) throws IOException {
        return (WriteResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
    }

    public static WriteResponse parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (WriteResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
    }

    public static Builder newBuilder() {
        return (Builder) DEFAULT_INSTANCE.toBuilder();
    }

    public static Builder newBuilder(WriteResponse writeResponse) {
        return (Builder) ((Builder) DEFAULT_INSTANCE.toBuilder()).mergeFrom(writeResponse);
    }

    /* compiled from: com.google.firebase:firebase-firestore@@20.2.0 */
    public static final class Builder extends GeneratedMessageLite.Builder<WriteResponse, Builder> implements WriteResponseOrBuilder {
        private Builder() {
            super(WriteResponse.DEFAULT_INSTANCE);
        }

        public String getStreamId() {
            return ((WriteResponse) this.instance).getStreamId();
        }

        public ByteString getStreamIdBytes() {
            return ((WriteResponse) this.instance).getStreamIdBytes();
        }

        public Builder setStreamId(String str) {
            copyOnWrite();
            ((WriteResponse) this.instance).setStreamId(str);
            return this;
        }

        public Builder clearStreamId() {
            copyOnWrite();
            ((WriteResponse) this.instance).clearStreamId();
            return this;
        }

        public Builder setStreamIdBytes(ByteString byteString) {
            copyOnWrite();
            ((WriteResponse) this.instance).setStreamIdBytes(byteString);
            return this;
        }

        public ByteString getStreamToken() {
            return ((WriteResponse) this.instance).getStreamToken();
        }

        public Builder setStreamToken(ByteString byteString) {
            copyOnWrite();
            ((WriteResponse) this.instance).setStreamToken(byteString);
            return this;
        }

        public Builder clearStreamToken() {
            copyOnWrite();
            ((WriteResponse) this.instance).clearStreamToken();
            return this;
        }

        public List<WriteResult> getWriteResultsList() {
            return Collections.unmodifiableList(((WriteResponse) this.instance).getWriteResultsList());
        }

        public int getWriteResultsCount() {
            return ((WriteResponse) this.instance).getWriteResultsCount();
        }

        public WriteResult getWriteResults(int i) {
            return ((WriteResponse) this.instance).getWriteResults(i);
        }

        public Builder setWriteResults(int i, WriteResult writeResult) {
            copyOnWrite();
            ((WriteResponse) this.instance).setWriteResults(i, writeResult);
            return this;
        }

        public Builder setWriteResults(int i, WriteResult.Builder builder) {
            copyOnWrite();
            ((WriteResponse) this.instance).setWriteResults(i, builder);
            return this;
        }

        public Builder addWriteResults(WriteResult writeResult) {
            copyOnWrite();
            ((WriteResponse) this.instance).addWriteResults(writeResult);
            return this;
        }

        public Builder addWriteResults(int i, WriteResult writeResult) {
            copyOnWrite();
            ((WriteResponse) this.instance).addWriteResults(i, writeResult);
            return this;
        }

        public Builder addWriteResults(WriteResult.Builder builder) {
            copyOnWrite();
            ((WriteResponse) this.instance).addWriteResults(builder);
            return this;
        }

        public Builder addWriteResults(int i, WriteResult.Builder builder) {
            copyOnWrite();
            ((WriteResponse) this.instance).addWriteResults(i, builder);
            return this;
        }

        public Builder addAllWriteResults(Iterable<? extends WriteResult> iterable) {
            copyOnWrite();
            ((WriteResponse) this.instance).addAllWriteResults(iterable);
            return this;
        }

        public Builder clearWriteResults() {
            copyOnWrite();
            ((WriteResponse) this.instance).clearWriteResults();
            return this;
        }

        public Builder removeWriteResults(int i) {
            copyOnWrite();
            ((WriteResponse) this.instance).removeWriteResults(i);
            return this;
        }

        public boolean hasCommitTime() {
            return ((WriteResponse) this.instance).hasCommitTime();
        }

        public Timestamp getCommitTime() {
            return ((WriteResponse) this.instance).getCommitTime();
        }

        public Builder setCommitTime(Timestamp timestamp) {
            copyOnWrite();
            ((WriteResponse) this.instance).setCommitTime(timestamp);
            return this;
        }

        public Builder setCommitTime(Timestamp.Builder builder) {
            copyOnWrite();
            ((WriteResponse) this.instance).setCommitTime(builder);
            return this;
        }

        public Builder mergeCommitTime(Timestamp timestamp) {
            copyOnWrite();
            ((WriteResponse) this.instance).mergeCommitTime(timestamp);
            return this;
        }

        public Builder clearCommitTime() {
            copyOnWrite();
            ((WriteResponse) this.instance).clearCommitTime();
            return this;
        }
    }

    /* access modifiers changed from: protected */
    public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        boolean z = false;
        switch (methodToInvoke) {
            case NEW_MUTABLE_INSTANCE:
                return new WriteResponse();
            case IS_INITIALIZED:
                return DEFAULT_INSTANCE;
            case MAKE_IMMUTABLE:
                this.writeResults_.makeImmutable();
                return null;
            case NEW_BUILDER:
                return new Builder();
            case VISIT:
                GeneratedMessageLite.Visitor visitor = (GeneratedMessageLite.Visitor) obj;
                WriteResponse writeResponse = (WriteResponse) obj2;
                this.streamId_ = visitor.visitString(!this.streamId_.isEmpty(), this.streamId_, !writeResponse.streamId_.isEmpty(), writeResponse.streamId_);
                boolean z2 = this.streamToken_ != ByteString.EMPTY;
                ByteString byteString = this.streamToken_;
                if (writeResponse.streamToken_ != ByteString.EMPTY) {
                    z = true;
                }
                this.streamToken_ = visitor.visitByteString(z2, byteString, z, writeResponse.streamToken_);
                this.writeResults_ = visitor.visitList(this.writeResults_, writeResponse.writeResults_);
                this.commitTime_ = (Timestamp) visitor.visitMessage(this.commitTime_, writeResponse.commitTime_);
                if (visitor == GeneratedMessageLite.MergeFromVisitor.INSTANCE) {
                    this.bitField0_ |= writeResponse.bitField0_;
                }
                return this;
            case MERGE_FROM_STREAM:
                CodedInputStream codedInputStream = (CodedInputStream) obj;
                ExtensionRegistryLite extensionRegistryLite = (ExtensionRegistryLite) obj2;
                while (!z) {
                    try {
                        int readTag = codedInputStream.readTag();
                        if (readTag != 0) {
                            if (readTag == 10) {
                                this.streamId_ = codedInputStream.readStringRequireUtf8();
                            } else if (readTag == 18) {
                                this.streamToken_ = codedInputStream.readBytes();
                            } else if (readTag == 26) {
                                if (!this.writeResults_.isModifiable()) {
                                    this.writeResults_ = GeneratedMessageLite.mutableCopy(this.writeResults_);
                                }
                                this.writeResults_.add((WriteResult) codedInputStream.readMessage(WriteResult.parser(), extensionRegistryLite));
                            } else if (readTag == 34) {
                                Timestamp.Builder builder = this.commitTime_ != null ? (Timestamp.Builder) this.commitTime_.toBuilder() : null;
                                this.commitTime_ = (Timestamp) codedInputStream.readMessage(Timestamp.parser(), extensionRegistryLite);
                                if (builder != null) {
                                    builder.mergeFrom(this.commitTime_);
                                    this.commitTime_ = (Timestamp) builder.buildPartial();
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
                    synchronized (WriteResponse.class) {
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

    public static WriteResponse getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static Parser<WriteResponse> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }
}
