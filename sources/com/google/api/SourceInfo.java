package com.google.api;

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
public final class SourceInfo extends GeneratedMessageLite<SourceInfo, Builder> implements SourceInfoOrBuilder {
    /* access modifiers changed from: private */
    public static final SourceInfo DEFAULT_INSTANCE = new SourceInfo();
    private static volatile Parser<SourceInfo> PARSER = null;
    public static final int SOURCE_FILES_FIELD_NUMBER = 1;
    private Internal.ProtobufList<Any> sourceFiles_ = emptyProtobufList();

    private SourceInfo() {
    }

    public List<Any> getSourceFilesList() {
        return this.sourceFiles_;
    }

    public List<? extends AnyOrBuilder> getSourceFilesOrBuilderList() {
        return this.sourceFiles_;
    }

    public int getSourceFilesCount() {
        return this.sourceFiles_.size();
    }

    public Any getSourceFiles(int i) {
        return (Any) this.sourceFiles_.get(i);
    }

    public AnyOrBuilder getSourceFilesOrBuilder(int i) {
        return (AnyOrBuilder) this.sourceFiles_.get(i);
    }

    private void ensureSourceFilesIsMutable() {
        if (!this.sourceFiles_.isModifiable()) {
            this.sourceFiles_ = GeneratedMessageLite.mutableCopy(this.sourceFiles_);
        }
    }

    /* access modifiers changed from: private */
    public void setSourceFiles(int i, Any any) {
        if (any != null) {
            ensureSourceFilesIsMutable();
            this.sourceFiles_.set(i, any);
            return;
        }
        throw new NullPointerException();
    }

    /* access modifiers changed from: private */
    public void setSourceFiles(int i, Any.Builder builder) {
        ensureSourceFilesIsMutable();
        this.sourceFiles_.set(i, (Any) builder.build());
    }

    /* access modifiers changed from: private */
    public void addSourceFiles(Any any) {
        if (any != null) {
            ensureSourceFilesIsMutable();
            this.sourceFiles_.add(any);
            return;
        }
        throw new NullPointerException();
    }

    /* access modifiers changed from: private */
    public void addSourceFiles(int i, Any any) {
        if (any != null) {
            ensureSourceFilesIsMutable();
            this.sourceFiles_.add(i, any);
            return;
        }
        throw new NullPointerException();
    }

    /* access modifiers changed from: private */
    public void addSourceFiles(Any.Builder builder) {
        ensureSourceFilesIsMutable();
        this.sourceFiles_.add((Any) builder.build());
    }

    /* access modifiers changed from: private */
    public void addSourceFiles(int i, Any.Builder builder) {
        ensureSourceFilesIsMutable();
        this.sourceFiles_.add(i, (Any) builder.build());
    }

    /* access modifiers changed from: private */
    public void addAllSourceFiles(Iterable<? extends Any> iterable) {
        ensureSourceFilesIsMutable();
        AbstractMessageLite.addAll(iterable, this.sourceFiles_);
    }

    /* access modifiers changed from: private */
    public void clearSourceFiles() {
        this.sourceFiles_ = emptyProtobufList();
    }

    /* access modifiers changed from: private */
    public void removeSourceFiles(int i) {
        ensureSourceFilesIsMutable();
        this.sourceFiles_.remove(i);
    }

    public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
        for (int i = 0; i < this.sourceFiles_.size(); i++) {
            codedOutputStream.writeMessage(1, (MessageLite) this.sourceFiles_.get(i));
        }
    }

    public int getSerializedSize() {
        int i = this.memoizedSerializedSize;
        if (i != -1) {
            return i;
        }
        int i2 = 0;
        for (int i3 = 0; i3 < this.sourceFiles_.size(); i3++) {
            i2 += CodedOutputStream.computeMessageSize(1, (MessageLite) this.sourceFiles_.get(i3));
        }
        this.memoizedSerializedSize = i2;
        return i2;
    }

    public static SourceInfo parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
        return (SourceInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
    }

    public static SourceInfo parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (SourceInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }

    public static SourceInfo parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
        return (SourceInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static SourceInfo parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (SourceInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
    }

    public static SourceInfo parseFrom(InputStream inputStream) throws IOException {
        return (SourceInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static SourceInfo parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (SourceInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static SourceInfo parseDelimitedFrom(InputStream inputStream) throws IOException {
        return (SourceInfo) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static SourceInfo parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (SourceInfo) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static SourceInfo parseFrom(CodedInputStream codedInputStream) throws IOException {
        return (SourceInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
    }

    public static SourceInfo parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (SourceInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
    }

    public static Builder newBuilder() {
        return (Builder) DEFAULT_INSTANCE.toBuilder();
    }

    public static Builder newBuilder(SourceInfo sourceInfo) {
        return (Builder) ((Builder) DEFAULT_INSTANCE.toBuilder()).mergeFrom(sourceInfo);
    }

    /* compiled from: com.google.firebase:protolite-well-known-types@@16.0.1 */
    public static final class Builder extends GeneratedMessageLite.Builder<SourceInfo, Builder> implements SourceInfoOrBuilder {
        private Builder() {
            super(SourceInfo.DEFAULT_INSTANCE);
        }

        public List<Any> getSourceFilesList() {
            return Collections.unmodifiableList(((SourceInfo) this.instance).getSourceFilesList());
        }

        public int getSourceFilesCount() {
            return ((SourceInfo) this.instance).getSourceFilesCount();
        }

        public Any getSourceFiles(int i) {
            return ((SourceInfo) this.instance).getSourceFiles(i);
        }

        public Builder setSourceFiles(int i, Any any) {
            copyOnWrite();
            ((SourceInfo) this.instance).setSourceFiles(i, any);
            return this;
        }

        public Builder setSourceFiles(int i, Any.Builder builder) {
            copyOnWrite();
            ((SourceInfo) this.instance).setSourceFiles(i, builder);
            return this;
        }

        public Builder addSourceFiles(Any any) {
            copyOnWrite();
            ((SourceInfo) this.instance).addSourceFiles(any);
            return this;
        }

        public Builder addSourceFiles(int i, Any any) {
            copyOnWrite();
            ((SourceInfo) this.instance).addSourceFiles(i, any);
            return this;
        }

        public Builder addSourceFiles(Any.Builder builder) {
            copyOnWrite();
            ((SourceInfo) this.instance).addSourceFiles(builder);
            return this;
        }

        public Builder addSourceFiles(int i, Any.Builder builder) {
            copyOnWrite();
            ((SourceInfo) this.instance).addSourceFiles(i, builder);
            return this;
        }

        public Builder addAllSourceFiles(Iterable<? extends Any> iterable) {
            copyOnWrite();
            ((SourceInfo) this.instance).addAllSourceFiles(iterable);
            return this;
        }

        public Builder clearSourceFiles() {
            copyOnWrite();
            ((SourceInfo) this.instance).clearSourceFiles();
            return this;
        }

        public Builder removeSourceFiles(int i) {
            copyOnWrite();
            ((SourceInfo) this.instance).removeSourceFiles(i);
            return this;
        }
    }

    /* access modifiers changed from: protected */
    public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        switch (methodToInvoke) {
            case NEW_MUTABLE_INSTANCE:
                return new SourceInfo();
            case IS_INITIALIZED:
                return DEFAULT_INSTANCE;
            case MAKE_IMMUTABLE:
                this.sourceFiles_.makeImmutable();
                return null;
            case NEW_BUILDER:
                return new Builder();
            case VISIT:
                this.sourceFiles_ = ((GeneratedMessageLite.Visitor) obj).visitList(this.sourceFiles_, ((SourceInfo) obj2).sourceFiles_);
                GeneratedMessageLite.MergeFromVisitor mergeFromVisitor = GeneratedMessageLite.MergeFromVisitor.INSTANCE;
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
                                if (!this.sourceFiles_.isModifiable()) {
                                    this.sourceFiles_ = GeneratedMessageLite.mutableCopy(this.sourceFiles_);
                                }
                                this.sourceFiles_.add((Any) codedInputStream.readMessage(Any.parser(), extensionRegistryLite));
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
                    synchronized (SourceInfo.class) {
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

    public static SourceInfo getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static Parser<SourceInfo> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }
}
