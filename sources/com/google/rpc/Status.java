package com.google.rpc;

import com.google.protobuf.AbstractMessageLite;
import com.google.protobuf.Any;
import com.google.protobuf.AnyOrBuilder;
import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.Internal;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.MessageLite;
import com.google.protobuf.Parser;
import java.io.IOException;
import java.io.InputStream;
import java.util.Collections;
import java.util.List;

/* compiled from: com.google.firebase:protolite-well-known-types@@16.0.1 */
public final class Status extends GeneratedMessageLite<Status, Builder> implements StatusOrBuilder {
    public static final int CODE_FIELD_NUMBER = 1;
    /* access modifiers changed from: private */
    public static final Status DEFAULT_INSTANCE = new Status();
    public static final int DETAILS_FIELD_NUMBER = 3;
    public static final int MESSAGE_FIELD_NUMBER = 2;
    private static volatile Parser<Status> PARSER;
    private int bitField0_;
    private int code_;
    private Internal.ProtobufList<Any> details_ = emptyProtobufList();
    private String message_ = "";

    private Status() {
    }

    public int getCode() {
        return this.code_;
    }

    /* access modifiers changed from: private */
    public void setCode(int i) {
        this.code_ = i;
    }

    /* access modifiers changed from: private */
    public void clearCode() {
        this.code_ = 0;
    }

    public String getMessage() {
        return this.message_;
    }

    public ByteString getMessageBytes() {
        return ByteString.copyFromUtf8(this.message_);
    }

    /* access modifiers changed from: private */
    public void setMessage(String str) {
        if (str != null) {
            this.message_ = str;
            return;
        }
        throw new NullPointerException();
    }

    /* access modifiers changed from: private */
    public void clearMessage() {
        this.message_ = getDefaultInstance().getMessage();
    }

    /* access modifiers changed from: private */
    public void setMessageBytes(ByteString byteString) {
        if (byteString != null) {
            checkByteStringIsUtf8(byteString);
            this.message_ = byteString.toStringUtf8();
            return;
        }
        throw new NullPointerException();
    }

    public List<Any> getDetailsList() {
        return this.details_;
    }

    public List<? extends AnyOrBuilder> getDetailsOrBuilderList() {
        return this.details_;
    }

    public int getDetailsCount() {
        return this.details_.size();
    }

    public Any getDetails(int i) {
        return (Any) this.details_.get(i);
    }

    public AnyOrBuilder getDetailsOrBuilder(int i) {
        return (AnyOrBuilder) this.details_.get(i);
    }

    private void ensureDetailsIsMutable() {
        if (!this.details_.isModifiable()) {
            this.details_ = GeneratedMessageLite.mutableCopy(this.details_);
        }
    }

    /* access modifiers changed from: private */
    public void setDetails(int i, Any any) {
        if (any != null) {
            ensureDetailsIsMutable();
            this.details_.set(i, any);
            return;
        }
        throw new NullPointerException();
    }

    /* access modifiers changed from: private */
    public void setDetails(int i, Any.Builder builder) {
        ensureDetailsIsMutable();
        this.details_.set(i, (Any) builder.build());
    }

    /* access modifiers changed from: private */
    public void addDetails(Any any) {
        if (any != null) {
            ensureDetailsIsMutable();
            this.details_.add(any);
            return;
        }
        throw new NullPointerException();
    }

    /* access modifiers changed from: private */
    public void addDetails(int i, Any any) {
        if (any != null) {
            ensureDetailsIsMutable();
            this.details_.add(i, any);
            return;
        }
        throw new NullPointerException();
    }

    /* access modifiers changed from: private */
    public void addDetails(Any.Builder builder) {
        ensureDetailsIsMutable();
        this.details_.add((Any) builder.build());
    }

    /* access modifiers changed from: private */
    public void addDetails(int i, Any.Builder builder) {
        ensureDetailsIsMutable();
        this.details_.add(i, (Any) builder.build());
    }

    /* access modifiers changed from: private */
    public void addAllDetails(Iterable<? extends Any> iterable) {
        ensureDetailsIsMutable();
        AbstractMessageLite.addAll(iterable, this.details_);
    }

    /* access modifiers changed from: private */
    public void clearDetails() {
        this.details_ = emptyProtobufList();
    }

    /* access modifiers changed from: private */
    public void removeDetails(int i) {
        ensureDetailsIsMutable();
        this.details_.remove(i);
    }

    public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
        int i = this.code_;
        if (i != 0) {
            codedOutputStream.writeInt32(1, i);
        }
        if (!this.message_.isEmpty()) {
            codedOutputStream.writeString(2, getMessage());
        }
        for (int i2 = 0; i2 < this.details_.size(); i2++) {
            codedOutputStream.writeMessage(3, (MessageLite) this.details_.get(i2));
        }
    }

    public int getSerializedSize() {
        int i = this.memoizedSerializedSize;
        if (i != -1) {
            return i;
        }
        int i2 = this.code_;
        int computeInt32Size = i2 != 0 ? CodedOutputStream.computeInt32Size(1, i2) + 0 : 0;
        if (!this.message_.isEmpty()) {
            computeInt32Size += CodedOutputStream.computeStringSize(2, getMessage());
        }
        for (int i3 = 0; i3 < this.details_.size(); i3++) {
            computeInt32Size += CodedOutputStream.computeMessageSize(3, (MessageLite) this.details_.get(i3));
        }
        this.memoizedSerializedSize = computeInt32Size;
        return computeInt32Size;
    }

    public static Status parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
        return (Status) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
    }

    public static Status parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (Status) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }

    public static Status parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
        return (Status) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static Status parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (Status) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
    }

    public static Status parseFrom(InputStream inputStream) throws IOException {
        return (Status) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static Status parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (Status) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static Status parseDelimitedFrom(InputStream inputStream) throws IOException {
        return (Status) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static Status parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (Status) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static Status parseFrom(CodedInputStream codedInputStream) throws IOException {
        return (Status) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
    }

    public static Status parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (Status) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
    }

    public static Builder newBuilder() {
        return (Builder) DEFAULT_INSTANCE.toBuilder();
    }

    public static Builder newBuilder(Status status) {
        return (Builder) ((Builder) DEFAULT_INSTANCE.toBuilder()).mergeFrom(status);
    }

    /* compiled from: com.google.firebase:protolite-well-known-types@@16.0.1 */
    public static final class Builder extends GeneratedMessageLite.Builder<Status, Builder> implements StatusOrBuilder {
        private Builder() {
            super(Status.DEFAULT_INSTANCE);
        }

        public int getCode() {
            return ((Status) this.instance).getCode();
        }

        public Builder setCode(int i) {
            copyOnWrite();
            ((Status) this.instance).setCode(i);
            return this;
        }

        public Builder clearCode() {
            copyOnWrite();
            ((Status) this.instance).clearCode();
            return this;
        }

        public String getMessage() {
            return ((Status) this.instance).getMessage();
        }

        public ByteString getMessageBytes() {
            return ((Status) this.instance).getMessageBytes();
        }

        public Builder setMessage(String str) {
            copyOnWrite();
            ((Status) this.instance).setMessage(str);
            return this;
        }

        public Builder clearMessage() {
            copyOnWrite();
            ((Status) this.instance).clearMessage();
            return this;
        }

        public Builder setMessageBytes(ByteString byteString) {
            copyOnWrite();
            ((Status) this.instance).setMessageBytes(byteString);
            return this;
        }

        public List<Any> getDetailsList() {
            return Collections.unmodifiableList(((Status) this.instance).getDetailsList());
        }

        public int getDetailsCount() {
            return ((Status) this.instance).getDetailsCount();
        }

        public Any getDetails(int i) {
            return ((Status) this.instance).getDetails(i);
        }

        public Builder setDetails(int i, Any any) {
            copyOnWrite();
            ((Status) this.instance).setDetails(i, any);
            return this;
        }

        public Builder setDetails(int i, Any.Builder builder) {
            copyOnWrite();
            ((Status) this.instance).setDetails(i, builder);
            return this;
        }

        public Builder addDetails(Any any) {
            copyOnWrite();
            ((Status) this.instance).addDetails(any);
            return this;
        }

        public Builder addDetails(int i, Any any) {
            copyOnWrite();
            ((Status) this.instance).addDetails(i, any);
            return this;
        }

        public Builder addDetails(Any.Builder builder) {
            copyOnWrite();
            ((Status) this.instance).addDetails(builder);
            return this;
        }

        public Builder addDetails(int i, Any.Builder builder) {
            copyOnWrite();
            ((Status) this.instance).addDetails(i, builder);
            return this;
        }

        public Builder addAllDetails(Iterable<? extends Any> iterable) {
            copyOnWrite();
            ((Status) this.instance).addAllDetails(iterable);
            return this;
        }

        public Builder clearDetails() {
            copyOnWrite();
            ((Status) this.instance).clearDetails();
            return this;
        }

        public Builder removeDetails(int i) {
            copyOnWrite();
            ((Status) this.instance).removeDetails(i);
            return this;
        }
    }

    /* access modifiers changed from: protected */
    public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        boolean z = false;
        switch (methodToInvoke) {
            case NEW_MUTABLE_INSTANCE:
                return new Status();
            case IS_INITIALIZED:
                return DEFAULT_INSTANCE;
            case MAKE_IMMUTABLE:
                this.details_.makeImmutable();
                return null;
            case NEW_BUILDER:
                return new Builder();
            case VISIT:
                GeneratedMessageLite.Visitor visitor = (GeneratedMessageLite.Visitor) obj;
                Status status = (Status) obj2;
                boolean z2 = this.code_ != 0;
                int i = this.code_;
                if (status.code_ != 0) {
                    z = true;
                }
                this.code_ = visitor.visitInt(z2, i, z, status.code_);
                this.message_ = visitor.visitString(!this.message_.isEmpty(), this.message_, !status.message_.isEmpty(), status.message_);
                this.details_ = visitor.visitList(this.details_, status.details_);
                if (visitor == GeneratedMessageLite.MergeFromVisitor.INSTANCE) {
                    this.bitField0_ |= status.bitField0_;
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
                                this.code_ = codedInputStream.readInt32();
                            } else if (readTag == 18) {
                                this.message_ = codedInputStream.readStringRequireUtf8();
                            } else if (readTag == 26) {
                                if (!this.details_.isModifiable()) {
                                    this.details_ = GeneratedMessageLite.mutableCopy(this.details_);
                                }
                                this.details_.add((Any) codedInputStream.readMessage(Any.parser(), extensionRegistryLite));
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
                    synchronized (Status.class) {
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

    public static Status getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static Parser<Status> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }
}
