package com.google.protobuf.compiler;

import com.google.protobuf.AbstractMessageLite;
import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.DescriptorProtos;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.Internal;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.MessageLite;
import com.google.protobuf.MessageLiteOrBuilder;
import com.google.protobuf.Parser;
import java.io.IOException;
import java.io.InputStream;
import java.util.Collections;
import java.util.List;

/* compiled from: com.google.firebase:protolite-well-known-types@@16.0.1 */
public final class PluginProtos {

    /* compiled from: com.google.firebase:protolite-well-known-types@@16.0.1 */
    public interface CodeGeneratorRequestOrBuilder extends MessageLiteOrBuilder {
        Version getCompilerVersion();

        String getFileToGenerate(int i);

        ByteString getFileToGenerateBytes(int i);

        int getFileToGenerateCount();

        List<String> getFileToGenerateList();

        String getParameter();

        ByteString getParameterBytes();

        DescriptorProtos.FileDescriptorProto getProtoFile(int i);

        int getProtoFileCount();

        List<DescriptorProtos.FileDescriptorProto> getProtoFileList();

        boolean hasCompilerVersion();

        boolean hasParameter();
    }

    /* compiled from: com.google.firebase:protolite-well-known-types@@16.0.1 */
    public interface CodeGeneratorResponseOrBuilder extends MessageLiteOrBuilder {
        String getError();

        ByteString getErrorBytes();

        CodeGeneratorResponse.File getFile(int i);

        int getFileCount();

        List<CodeGeneratorResponse.File> getFileList();

        boolean hasError();
    }

    /* compiled from: com.google.firebase:protolite-well-known-types@@16.0.1 */
    public interface VersionOrBuilder extends MessageLiteOrBuilder {
        int getMajor();

        int getMinor();

        int getPatch();

        String getSuffix();

        ByteString getSuffixBytes();

        boolean hasMajor();

        boolean hasMinor();

        boolean hasPatch();

        boolean hasSuffix();
    }

    public static void registerAllExtensions(ExtensionRegistryLite extensionRegistryLite) {
    }

    private PluginProtos() {
    }

    /* compiled from: com.google.firebase:protolite-well-known-types@@16.0.1 */
    public static final class Version extends GeneratedMessageLite<Version, Builder> implements VersionOrBuilder {
        /* access modifiers changed from: private */
        public static final Version DEFAULT_INSTANCE = new Version();
        public static final int MAJOR_FIELD_NUMBER = 1;
        public static final int MINOR_FIELD_NUMBER = 2;
        private static volatile Parser<Version> PARSER = null;
        public static final int PATCH_FIELD_NUMBER = 3;
        public static final int SUFFIX_FIELD_NUMBER = 4;
        private int bitField0_;
        private int major_;
        private int minor_;
        private int patch_;
        private String suffix_ = "";

        private Version() {
        }

        public boolean hasMajor() {
            return (this.bitField0_ & 1) == 1;
        }

        public int getMajor() {
            return this.major_;
        }

        /* access modifiers changed from: private */
        public void setMajor(int i) {
            this.bitField0_ |= 1;
            this.major_ = i;
        }

        /* access modifiers changed from: private */
        public void clearMajor() {
            this.bitField0_ &= -2;
            this.major_ = 0;
        }

        public boolean hasMinor() {
            return (this.bitField0_ & 2) == 2;
        }

        public int getMinor() {
            return this.minor_;
        }

        /* access modifiers changed from: private */
        public void setMinor(int i) {
            this.bitField0_ |= 2;
            this.minor_ = i;
        }

        /* access modifiers changed from: private */
        public void clearMinor() {
            this.bitField0_ &= -3;
            this.minor_ = 0;
        }

        public boolean hasPatch() {
            return (this.bitField0_ & 4) == 4;
        }

        public int getPatch() {
            return this.patch_;
        }

        /* access modifiers changed from: private */
        public void setPatch(int i) {
            this.bitField0_ |= 4;
            this.patch_ = i;
        }

        /* access modifiers changed from: private */
        public void clearPatch() {
            this.bitField0_ &= -5;
            this.patch_ = 0;
        }

        public boolean hasSuffix() {
            return (this.bitField0_ & 8) == 8;
        }

        public String getSuffix() {
            return this.suffix_;
        }

        public ByteString getSuffixBytes() {
            return ByteString.copyFromUtf8(this.suffix_);
        }

        /* access modifiers changed from: private */
        public void setSuffix(String str) {
            if (str != null) {
                this.bitField0_ |= 8;
                this.suffix_ = str;
                return;
            }
            throw new NullPointerException();
        }

        /* access modifiers changed from: private */
        public void clearSuffix() {
            this.bitField0_ &= -9;
            this.suffix_ = getDefaultInstance().getSuffix();
        }

        /* access modifiers changed from: private */
        public void setSuffixBytes(ByteString byteString) {
            if (byteString != null) {
                this.bitField0_ |= 8;
                this.suffix_ = byteString.toStringUtf8();
                return;
            }
            throw new NullPointerException();
        }

        public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
            if ((this.bitField0_ & 1) == 1) {
                codedOutputStream.writeInt32(1, this.major_);
            }
            if ((this.bitField0_ & 2) == 2) {
                codedOutputStream.writeInt32(2, this.minor_);
            }
            if ((this.bitField0_ & 4) == 4) {
                codedOutputStream.writeInt32(3, this.patch_);
            }
            if ((this.bitField0_ & 8) == 8) {
                codedOutputStream.writeString(4, getSuffix());
            }
            this.unknownFields.writeTo(codedOutputStream);
        }

        public int getSerializedSize() {
            int i = this.memoizedSerializedSize;
            if (i != -1) {
                return i;
            }
            int i2 = 0;
            if ((this.bitField0_ & 1) == 1) {
                i2 = 0 + CodedOutputStream.computeInt32Size(1, this.major_);
            }
            if ((this.bitField0_ & 2) == 2) {
                i2 += CodedOutputStream.computeInt32Size(2, this.minor_);
            }
            if ((this.bitField0_ & 4) == 4) {
                i2 += CodedOutputStream.computeInt32Size(3, this.patch_);
            }
            if ((this.bitField0_ & 8) == 8) {
                i2 += CodedOutputStream.computeStringSize(4, getSuffix());
            }
            int serializedSize = i2 + this.unknownFields.getSerializedSize();
            this.memoizedSerializedSize = serializedSize;
            return serializedSize;
        }

        public static Version parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return (Version) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
        }

        public static Version parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (Version) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
        }

        public static Version parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return (Version) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
        }

        public static Version parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (Version) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
        }

        public static Version parseFrom(InputStream inputStream) throws IOException {
            return (Version) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static Version parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (Version) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static Version parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (Version) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static Version parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (Version) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static Version parseFrom(CodedInputStream codedInputStream) throws IOException {
            return (Version) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
        }

        public static Version parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (Version) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
        }

        public static Builder newBuilder() {
            return (Builder) DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(Version version) {
            return (Builder) ((Builder) DEFAULT_INSTANCE.toBuilder()).mergeFrom(version);
        }

        /* compiled from: com.google.firebase:protolite-well-known-types@@16.0.1 */
        public static final class Builder extends GeneratedMessageLite.Builder<Version, Builder> implements VersionOrBuilder {
            private Builder() {
                super(Version.DEFAULT_INSTANCE);
            }

            public boolean hasMajor() {
                return ((Version) this.instance).hasMajor();
            }

            public int getMajor() {
                return ((Version) this.instance).getMajor();
            }

            public Builder setMajor(int i) {
                copyOnWrite();
                ((Version) this.instance).setMajor(i);
                return this;
            }

            public Builder clearMajor() {
                copyOnWrite();
                ((Version) this.instance).clearMajor();
                return this;
            }

            public boolean hasMinor() {
                return ((Version) this.instance).hasMinor();
            }

            public int getMinor() {
                return ((Version) this.instance).getMinor();
            }

            public Builder setMinor(int i) {
                copyOnWrite();
                ((Version) this.instance).setMinor(i);
                return this;
            }

            public Builder clearMinor() {
                copyOnWrite();
                ((Version) this.instance).clearMinor();
                return this;
            }

            public boolean hasPatch() {
                return ((Version) this.instance).hasPatch();
            }

            public int getPatch() {
                return ((Version) this.instance).getPatch();
            }

            public Builder setPatch(int i) {
                copyOnWrite();
                ((Version) this.instance).setPatch(i);
                return this;
            }

            public Builder clearPatch() {
                copyOnWrite();
                ((Version) this.instance).clearPatch();
                return this;
            }

            public boolean hasSuffix() {
                return ((Version) this.instance).hasSuffix();
            }

            public String getSuffix() {
                return ((Version) this.instance).getSuffix();
            }

            public ByteString getSuffixBytes() {
                return ((Version) this.instance).getSuffixBytes();
            }

            public Builder setSuffix(String str) {
                copyOnWrite();
                ((Version) this.instance).setSuffix(str);
                return this;
            }

            public Builder clearSuffix() {
                copyOnWrite();
                ((Version) this.instance).clearSuffix();
                return this;
            }

            public Builder setSuffixBytes(ByteString byteString) {
                copyOnWrite();
                ((Version) this.instance).setSuffixBytes(byteString);
                return this;
            }
        }

        /* access modifiers changed from: protected */
        public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            switch (methodToInvoke) {
                case NEW_MUTABLE_INSTANCE:
                    return new Version();
                case IS_INITIALIZED:
                    return DEFAULT_INSTANCE;
                case MAKE_IMMUTABLE:
                    return null;
                case NEW_BUILDER:
                    return new Builder();
                case VISIT:
                    GeneratedMessageLite.Visitor visitor = (GeneratedMessageLite.Visitor) obj;
                    Version version = (Version) obj2;
                    this.major_ = visitor.visitInt(hasMajor(), this.major_, version.hasMajor(), version.major_);
                    this.minor_ = visitor.visitInt(hasMinor(), this.minor_, version.hasMinor(), version.minor_);
                    this.patch_ = visitor.visitInt(hasPatch(), this.patch_, version.hasPatch(), version.patch_);
                    this.suffix_ = visitor.visitString(hasSuffix(), this.suffix_, version.hasSuffix(), version.suffix_);
                    if (visitor == GeneratedMessageLite.MergeFromVisitor.INSTANCE) {
                        this.bitField0_ |= version.bitField0_;
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
                                if (readTag == 8) {
                                    this.bitField0_ |= 1;
                                    this.major_ = codedInputStream.readInt32();
                                } else if (readTag == 16) {
                                    this.bitField0_ |= 2;
                                    this.minor_ = codedInputStream.readInt32();
                                } else if (readTag == 24) {
                                    this.bitField0_ |= 4;
                                    this.patch_ = codedInputStream.readInt32();
                                } else if (readTag == 34) {
                                    String readString = codedInputStream.readString();
                                    this.bitField0_ |= 8;
                                    this.suffix_ = readString;
                                } else if (!parseUnknownField(readTag, codedInputStream)) {
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
                        synchronized (Version.class) {
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

        public static Version getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<Version> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }
    }

    /* compiled from: com.google.firebase:protolite-well-known-types@@16.0.1 */
    public static final class CodeGeneratorRequest extends GeneratedMessageLite<CodeGeneratorRequest, Builder> implements CodeGeneratorRequestOrBuilder {
        public static final int COMPILER_VERSION_FIELD_NUMBER = 3;
        /* access modifiers changed from: private */
        public static final CodeGeneratorRequest DEFAULT_INSTANCE = new CodeGeneratorRequest();
        public static final int FILE_TO_GENERATE_FIELD_NUMBER = 1;
        public static final int PARAMETER_FIELD_NUMBER = 2;
        private static volatile Parser<CodeGeneratorRequest> PARSER = null;
        public static final int PROTO_FILE_FIELD_NUMBER = 15;
        private int bitField0_;
        private Version compilerVersion_;
        private Internal.ProtobufList<String> fileToGenerate_ = GeneratedMessageLite.emptyProtobufList();
        private byte memoizedIsInitialized = -1;
        private String parameter_ = "";
        private Internal.ProtobufList<DescriptorProtos.FileDescriptorProto> protoFile_ = emptyProtobufList();

        private CodeGeneratorRequest() {
        }

        public List<String> getFileToGenerateList() {
            return this.fileToGenerate_;
        }

        public int getFileToGenerateCount() {
            return this.fileToGenerate_.size();
        }

        public String getFileToGenerate(int i) {
            return (String) this.fileToGenerate_.get(i);
        }

        public ByteString getFileToGenerateBytes(int i) {
            return ByteString.copyFromUtf8((String) this.fileToGenerate_.get(i));
        }

        private void ensureFileToGenerateIsMutable() {
            if (!this.fileToGenerate_.isModifiable()) {
                this.fileToGenerate_ = GeneratedMessageLite.mutableCopy(this.fileToGenerate_);
            }
        }

        /* access modifiers changed from: private */
        public void setFileToGenerate(int i, String str) {
            if (str != null) {
                ensureFileToGenerateIsMutable();
                this.fileToGenerate_.set(i, str);
                return;
            }
            throw new NullPointerException();
        }

        /* access modifiers changed from: private */
        public void addFileToGenerate(String str) {
            if (str != null) {
                ensureFileToGenerateIsMutable();
                this.fileToGenerate_.add(str);
                return;
            }
            throw new NullPointerException();
        }

        /* access modifiers changed from: private */
        public void addAllFileToGenerate(Iterable<String> iterable) {
            ensureFileToGenerateIsMutable();
            AbstractMessageLite.addAll(iterable, this.fileToGenerate_);
        }

        /* access modifiers changed from: private */
        public void clearFileToGenerate() {
            this.fileToGenerate_ = GeneratedMessageLite.emptyProtobufList();
        }

        /* access modifiers changed from: private */
        public void addFileToGenerateBytes(ByteString byteString) {
            if (byteString != null) {
                ensureFileToGenerateIsMutable();
                this.fileToGenerate_.add(byteString.toStringUtf8());
                return;
            }
            throw new NullPointerException();
        }

        public boolean hasParameter() {
            return (this.bitField0_ & 1) == 1;
        }

        public String getParameter() {
            return this.parameter_;
        }

        public ByteString getParameterBytes() {
            return ByteString.copyFromUtf8(this.parameter_);
        }

        /* access modifiers changed from: private */
        public void setParameter(String str) {
            if (str != null) {
                this.bitField0_ |= 1;
                this.parameter_ = str;
                return;
            }
            throw new NullPointerException();
        }

        /* access modifiers changed from: private */
        public void clearParameter() {
            this.bitField0_ &= -2;
            this.parameter_ = getDefaultInstance().getParameter();
        }

        /* access modifiers changed from: private */
        public void setParameterBytes(ByteString byteString) {
            if (byteString != null) {
                this.bitField0_ |= 1;
                this.parameter_ = byteString.toStringUtf8();
                return;
            }
            throw new NullPointerException();
        }

        public List<DescriptorProtos.FileDescriptorProto> getProtoFileList() {
            return this.protoFile_;
        }

        public List<? extends DescriptorProtos.FileDescriptorProtoOrBuilder> getProtoFileOrBuilderList() {
            return this.protoFile_;
        }

        public int getProtoFileCount() {
            return this.protoFile_.size();
        }

        public DescriptorProtos.FileDescriptorProto getProtoFile(int i) {
            return (DescriptorProtos.FileDescriptorProto) this.protoFile_.get(i);
        }

        public DescriptorProtos.FileDescriptorProtoOrBuilder getProtoFileOrBuilder(int i) {
            return (DescriptorProtos.FileDescriptorProtoOrBuilder) this.protoFile_.get(i);
        }

        private void ensureProtoFileIsMutable() {
            if (!this.protoFile_.isModifiable()) {
                this.protoFile_ = GeneratedMessageLite.mutableCopy(this.protoFile_);
            }
        }

        /* access modifiers changed from: private */
        public void setProtoFile(int i, DescriptorProtos.FileDescriptorProto fileDescriptorProto) {
            if (fileDescriptorProto != null) {
                ensureProtoFileIsMutable();
                this.protoFile_.set(i, fileDescriptorProto);
                return;
            }
            throw new NullPointerException();
        }

        /* access modifiers changed from: private */
        public void setProtoFile(int i, DescriptorProtos.FileDescriptorProto.Builder builder) {
            ensureProtoFileIsMutable();
            this.protoFile_.set(i, (DescriptorProtos.FileDescriptorProto) builder.build());
        }

        /* access modifiers changed from: private */
        public void addProtoFile(DescriptorProtos.FileDescriptorProto fileDescriptorProto) {
            if (fileDescriptorProto != null) {
                ensureProtoFileIsMutable();
                this.protoFile_.add(fileDescriptorProto);
                return;
            }
            throw new NullPointerException();
        }

        /* access modifiers changed from: private */
        public void addProtoFile(int i, DescriptorProtos.FileDescriptorProto fileDescriptorProto) {
            if (fileDescriptorProto != null) {
                ensureProtoFileIsMutable();
                this.protoFile_.add(i, fileDescriptorProto);
                return;
            }
            throw new NullPointerException();
        }

        /* access modifiers changed from: private */
        public void addProtoFile(DescriptorProtos.FileDescriptorProto.Builder builder) {
            ensureProtoFileIsMutable();
            this.protoFile_.add((DescriptorProtos.FileDescriptorProto) builder.build());
        }

        /* access modifiers changed from: private */
        public void addProtoFile(int i, DescriptorProtos.FileDescriptorProto.Builder builder) {
            ensureProtoFileIsMutable();
            this.protoFile_.add(i, (DescriptorProtos.FileDescriptorProto) builder.build());
        }

        /* access modifiers changed from: private */
        public void addAllProtoFile(Iterable<? extends DescriptorProtos.FileDescriptorProto> iterable) {
            ensureProtoFileIsMutable();
            AbstractMessageLite.addAll(iterable, this.protoFile_);
        }

        /* access modifiers changed from: private */
        public void clearProtoFile() {
            this.protoFile_ = emptyProtobufList();
        }

        /* access modifiers changed from: private */
        public void removeProtoFile(int i) {
            ensureProtoFileIsMutable();
            this.protoFile_.remove(i);
        }

        public boolean hasCompilerVersion() {
            return (this.bitField0_ & 2) == 2;
        }

        public Version getCompilerVersion() {
            Version version = this.compilerVersion_;
            return version == null ? Version.getDefaultInstance() : version;
        }

        /* access modifiers changed from: private */
        public void setCompilerVersion(Version version) {
            if (version != null) {
                this.compilerVersion_ = version;
                this.bitField0_ |= 2;
                return;
            }
            throw new NullPointerException();
        }

        /* access modifiers changed from: private */
        public void setCompilerVersion(Version.Builder builder) {
            this.compilerVersion_ = (Version) builder.build();
            this.bitField0_ |= 2;
        }

        /* access modifiers changed from: private */
        public void mergeCompilerVersion(Version version) {
            Version version2 = this.compilerVersion_;
            if (version2 == null || version2 == Version.getDefaultInstance()) {
                this.compilerVersion_ = version;
            } else {
                this.compilerVersion_ = (Version) ((Version.Builder) Version.newBuilder(this.compilerVersion_).mergeFrom(version)).buildPartial();
            }
            this.bitField0_ |= 2;
        }

        /* access modifiers changed from: private */
        public void clearCompilerVersion() {
            this.compilerVersion_ = null;
            this.bitField0_ &= -3;
        }

        public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
            for (int i = 0; i < this.fileToGenerate_.size(); i++) {
                codedOutputStream.writeString(1, (String) this.fileToGenerate_.get(i));
            }
            if ((this.bitField0_ & 1) == 1) {
                codedOutputStream.writeString(2, getParameter());
            }
            if ((this.bitField0_ & 2) == 2) {
                codedOutputStream.writeMessage(3, getCompilerVersion());
            }
            for (int i2 = 0; i2 < this.protoFile_.size(); i2++) {
                codedOutputStream.writeMessage(15, (MessageLite) this.protoFile_.get(i2));
            }
            this.unknownFields.writeTo(codedOutputStream);
        }

        public int getSerializedSize() {
            int i = this.memoizedSerializedSize;
            if (i != -1) {
                return i;
            }
            int i2 = 0;
            for (int i3 = 0; i3 < this.fileToGenerate_.size(); i3++) {
                i2 += CodedOutputStream.computeStringSizeNoTag((String) this.fileToGenerate_.get(i3));
            }
            int size = i2 + 0 + (getFileToGenerateList().size() * 1);
            if ((this.bitField0_ & 1) == 1) {
                size += CodedOutputStream.computeStringSize(2, getParameter());
            }
            if ((this.bitField0_ & 2) == 2) {
                size += CodedOutputStream.computeMessageSize(3, getCompilerVersion());
            }
            for (int i4 = 0; i4 < this.protoFile_.size(); i4++) {
                size += CodedOutputStream.computeMessageSize(15, (MessageLite) this.protoFile_.get(i4));
            }
            int serializedSize = size + this.unknownFields.getSerializedSize();
            this.memoizedSerializedSize = serializedSize;
            return serializedSize;
        }

        public static CodeGeneratorRequest parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return (CodeGeneratorRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
        }

        public static CodeGeneratorRequest parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (CodeGeneratorRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
        }

        public static CodeGeneratorRequest parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return (CodeGeneratorRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
        }

        public static CodeGeneratorRequest parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (CodeGeneratorRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
        }

        public static CodeGeneratorRequest parseFrom(InputStream inputStream) throws IOException {
            return (CodeGeneratorRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static CodeGeneratorRequest parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (CodeGeneratorRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static CodeGeneratorRequest parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (CodeGeneratorRequest) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static CodeGeneratorRequest parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (CodeGeneratorRequest) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static CodeGeneratorRequest parseFrom(CodedInputStream codedInputStream) throws IOException {
            return (CodeGeneratorRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
        }

        public static CodeGeneratorRequest parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (CodeGeneratorRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
        }

        public static Builder newBuilder() {
            return (Builder) DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(CodeGeneratorRequest codeGeneratorRequest) {
            return (Builder) ((Builder) DEFAULT_INSTANCE.toBuilder()).mergeFrom(codeGeneratorRequest);
        }

        /* compiled from: com.google.firebase:protolite-well-known-types@@16.0.1 */
        public static final class Builder extends GeneratedMessageLite.Builder<CodeGeneratorRequest, Builder> implements CodeGeneratorRequestOrBuilder {
            private Builder() {
                super(CodeGeneratorRequest.DEFAULT_INSTANCE);
            }

            public List<String> getFileToGenerateList() {
                return Collections.unmodifiableList(((CodeGeneratorRequest) this.instance).getFileToGenerateList());
            }

            public int getFileToGenerateCount() {
                return ((CodeGeneratorRequest) this.instance).getFileToGenerateCount();
            }

            public String getFileToGenerate(int i) {
                return ((CodeGeneratorRequest) this.instance).getFileToGenerate(i);
            }

            public ByteString getFileToGenerateBytes(int i) {
                return ((CodeGeneratorRequest) this.instance).getFileToGenerateBytes(i);
            }

            public Builder setFileToGenerate(int i, String str) {
                copyOnWrite();
                ((CodeGeneratorRequest) this.instance).setFileToGenerate(i, str);
                return this;
            }

            public Builder addFileToGenerate(String str) {
                copyOnWrite();
                ((CodeGeneratorRequest) this.instance).addFileToGenerate(str);
                return this;
            }

            public Builder addAllFileToGenerate(Iterable<String> iterable) {
                copyOnWrite();
                ((CodeGeneratorRequest) this.instance).addAllFileToGenerate(iterable);
                return this;
            }

            public Builder clearFileToGenerate() {
                copyOnWrite();
                ((CodeGeneratorRequest) this.instance).clearFileToGenerate();
                return this;
            }

            public Builder addFileToGenerateBytes(ByteString byteString) {
                copyOnWrite();
                ((CodeGeneratorRequest) this.instance).addFileToGenerateBytes(byteString);
                return this;
            }

            public boolean hasParameter() {
                return ((CodeGeneratorRequest) this.instance).hasParameter();
            }

            public String getParameter() {
                return ((CodeGeneratorRequest) this.instance).getParameter();
            }

            public ByteString getParameterBytes() {
                return ((CodeGeneratorRequest) this.instance).getParameterBytes();
            }

            public Builder setParameter(String str) {
                copyOnWrite();
                ((CodeGeneratorRequest) this.instance).setParameter(str);
                return this;
            }

            public Builder clearParameter() {
                copyOnWrite();
                ((CodeGeneratorRequest) this.instance).clearParameter();
                return this;
            }

            public Builder setParameterBytes(ByteString byteString) {
                copyOnWrite();
                ((CodeGeneratorRequest) this.instance).setParameterBytes(byteString);
                return this;
            }

            public List<DescriptorProtos.FileDescriptorProto> getProtoFileList() {
                return Collections.unmodifiableList(((CodeGeneratorRequest) this.instance).getProtoFileList());
            }

            public int getProtoFileCount() {
                return ((CodeGeneratorRequest) this.instance).getProtoFileCount();
            }

            public DescriptorProtos.FileDescriptorProto getProtoFile(int i) {
                return ((CodeGeneratorRequest) this.instance).getProtoFile(i);
            }

            public Builder setProtoFile(int i, DescriptorProtos.FileDescriptorProto fileDescriptorProto) {
                copyOnWrite();
                ((CodeGeneratorRequest) this.instance).setProtoFile(i, fileDescriptorProto);
                return this;
            }

            public Builder setProtoFile(int i, DescriptorProtos.FileDescriptorProto.Builder builder) {
                copyOnWrite();
                ((CodeGeneratorRequest) this.instance).setProtoFile(i, builder);
                return this;
            }

            public Builder addProtoFile(DescriptorProtos.FileDescriptorProto fileDescriptorProto) {
                copyOnWrite();
                ((CodeGeneratorRequest) this.instance).addProtoFile(fileDescriptorProto);
                return this;
            }

            public Builder addProtoFile(int i, DescriptorProtos.FileDescriptorProto fileDescriptorProto) {
                copyOnWrite();
                ((CodeGeneratorRequest) this.instance).addProtoFile(i, fileDescriptorProto);
                return this;
            }

            public Builder addProtoFile(DescriptorProtos.FileDescriptorProto.Builder builder) {
                copyOnWrite();
                ((CodeGeneratorRequest) this.instance).addProtoFile(builder);
                return this;
            }

            public Builder addProtoFile(int i, DescriptorProtos.FileDescriptorProto.Builder builder) {
                copyOnWrite();
                ((CodeGeneratorRequest) this.instance).addProtoFile(i, builder);
                return this;
            }

            public Builder addAllProtoFile(Iterable<? extends DescriptorProtos.FileDescriptorProto> iterable) {
                copyOnWrite();
                ((CodeGeneratorRequest) this.instance).addAllProtoFile(iterable);
                return this;
            }

            public Builder clearProtoFile() {
                copyOnWrite();
                ((CodeGeneratorRequest) this.instance).clearProtoFile();
                return this;
            }

            public Builder removeProtoFile(int i) {
                copyOnWrite();
                ((CodeGeneratorRequest) this.instance).removeProtoFile(i);
                return this;
            }

            public boolean hasCompilerVersion() {
                return ((CodeGeneratorRequest) this.instance).hasCompilerVersion();
            }

            public Version getCompilerVersion() {
                return ((CodeGeneratorRequest) this.instance).getCompilerVersion();
            }

            public Builder setCompilerVersion(Version version) {
                copyOnWrite();
                ((CodeGeneratorRequest) this.instance).setCompilerVersion(version);
                return this;
            }

            public Builder setCompilerVersion(Version.Builder builder) {
                copyOnWrite();
                ((CodeGeneratorRequest) this.instance).setCompilerVersion(builder);
                return this;
            }

            public Builder mergeCompilerVersion(Version version) {
                copyOnWrite();
                ((CodeGeneratorRequest) this.instance).mergeCompilerVersion(version);
                return this;
            }

            public Builder clearCompilerVersion() {
                copyOnWrite();
                ((CodeGeneratorRequest) this.instance).clearCompilerVersion();
                return this;
            }
        }

        /* access modifiers changed from: protected */
        public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            boolean z = false;
            switch (methodToInvoke) {
                case NEW_MUTABLE_INSTANCE:
                    return new CodeGeneratorRequest();
                case IS_INITIALIZED:
                    byte b = this.memoizedIsInitialized;
                    if (b == 1) {
                        return DEFAULT_INSTANCE;
                    }
                    if (b == 0) {
                        return null;
                    }
                    boolean booleanValue = ((Boolean) obj).booleanValue();
                    for (int i = 0; i < getProtoFileCount(); i++) {
                        if (!getProtoFile(i).isInitialized()) {
                            if (booleanValue) {
                                this.memoizedIsInitialized = 0;
                            }
                            return null;
                        }
                    }
                    if (booleanValue) {
                        this.memoizedIsInitialized = 1;
                    }
                    return DEFAULT_INSTANCE;
                case MAKE_IMMUTABLE:
                    this.fileToGenerate_.makeImmutable();
                    this.protoFile_.makeImmutable();
                    return null;
                case NEW_BUILDER:
                    return new Builder();
                case VISIT:
                    GeneratedMessageLite.Visitor visitor = (GeneratedMessageLite.Visitor) obj;
                    CodeGeneratorRequest codeGeneratorRequest = (CodeGeneratorRequest) obj2;
                    this.fileToGenerate_ = visitor.visitList(this.fileToGenerate_, codeGeneratorRequest.fileToGenerate_);
                    this.parameter_ = visitor.visitString(hasParameter(), this.parameter_, codeGeneratorRequest.hasParameter(), codeGeneratorRequest.parameter_);
                    this.protoFile_ = visitor.visitList(this.protoFile_, codeGeneratorRequest.protoFile_);
                    this.compilerVersion_ = (Version) visitor.visitMessage(this.compilerVersion_, codeGeneratorRequest.compilerVersion_);
                    if (visitor == GeneratedMessageLite.MergeFromVisitor.INSTANCE) {
                        this.bitField0_ |= codeGeneratorRequest.bitField0_;
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
                                    String readString = codedInputStream.readString();
                                    if (!this.fileToGenerate_.isModifiable()) {
                                        this.fileToGenerate_ = GeneratedMessageLite.mutableCopy(this.fileToGenerate_);
                                    }
                                    this.fileToGenerate_.add(readString);
                                } else if (readTag == 18) {
                                    String readString2 = codedInputStream.readString();
                                    this.bitField0_ |= 1;
                                    this.parameter_ = readString2;
                                } else if (readTag == 26) {
                                    Version.Builder builder = (this.bitField0_ & 2) == 2 ? (Version.Builder) this.compilerVersion_.toBuilder() : null;
                                    this.compilerVersion_ = (Version) codedInputStream.readMessage(Version.parser(), extensionRegistryLite);
                                    if (builder != null) {
                                        builder.mergeFrom(this.compilerVersion_);
                                        this.compilerVersion_ = (Version) builder.buildPartial();
                                    }
                                    this.bitField0_ |= 2;
                                } else if (readTag == 122) {
                                    if (!this.protoFile_.isModifiable()) {
                                        this.protoFile_ = GeneratedMessageLite.mutableCopy(this.protoFile_);
                                    }
                                    this.protoFile_.add((DescriptorProtos.FileDescriptorProto) codedInputStream.readMessage(DescriptorProtos.FileDescriptorProto.parser(), extensionRegistryLite));
                                } else if (!parseUnknownField(readTag, codedInputStream)) {
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
                        synchronized (CodeGeneratorRequest.class) {
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

        public static CodeGeneratorRequest getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<CodeGeneratorRequest> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }
    }

    /* compiled from: com.google.firebase:protolite-well-known-types@@16.0.1 */
    public static final class CodeGeneratorResponse extends GeneratedMessageLite<CodeGeneratorResponse, Builder> implements CodeGeneratorResponseOrBuilder {
        /* access modifiers changed from: private */
        public static final CodeGeneratorResponse DEFAULT_INSTANCE = new CodeGeneratorResponse();
        public static final int ERROR_FIELD_NUMBER = 1;
        public static final int FILE_FIELD_NUMBER = 15;
        private static volatile Parser<CodeGeneratorResponse> PARSER;
        private int bitField0_;
        private String error_ = "";
        private Internal.ProtobufList<File> file_ = emptyProtobufList();

        /* compiled from: com.google.firebase:protolite-well-known-types@@16.0.1 */
        public interface FileOrBuilder extends MessageLiteOrBuilder {
            String getContent();

            ByteString getContentBytes();

            String getInsertionPoint();

            ByteString getInsertionPointBytes();

            String getName();

            ByteString getNameBytes();

            boolean hasContent();

            boolean hasInsertionPoint();

            boolean hasName();
        }

        private CodeGeneratorResponse() {
        }

        /* compiled from: com.google.firebase:protolite-well-known-types@@16.0.1 */
        public static final class File extends GeneratedMessageLite<File, Builder> implements FileOrBuilder {
            public static final int CONTENT_FIELD_NUMBER = 15;
            /* access modifiers changed from: private */
            public static final File DEFAULT_INSTANCE = new File();
            public static final int INSERTION_POINT_FIELD_NUMBER = 2;
            public static final int NAME_FIELD_NUMBER = 1;
            private static volatile Parser<File> PARSER;
            private int bitField0_;
            private String content_ = "";
            private String insertionPoint_ = "";
            private String name_ = "";

            private File() {
            }

            public boolean hasName() {
                return (this.bitField0_ & 1) == 1;
            }

            public String getName() {
                return this.name_;
            }

            public ByteString getNameBytes() {
                return ByteString.copyFromUtf8(this.name_);
            }

            /* access modifiers changed from: private */
            public void setName(String str) {
                if (str != null) {
                    this.bitField0_ |= 1;
                    this.name_ = str;
                    return;
                }
                throw new NullPointerException();
            }

            /* access modifiers changed from: private */
            public void clearName() {
                this.bitField0_ &= -2;
                this.name_ = getDefaultInstance().getName();
            }

            /* access modifiers changed from: private */
            public void setNameBytes(ByteString byteString) {
                if (byteString != null) {
                    this.bitField0_ |= 1;
                    this.name_ = byteString.toStringUtf8();
                    return;
                }
                throw new NullPointerException();
            }

            public boolean hasInsertionPoint() {
                return (this.bitField0_ & 2) == 2;
            }

            public String getInsertionPoint() {
                return this.insertionPoint_;
            }

            public ByteString getInsertionPointBytes() {
                return ByteString.copyFromUtf8(this.insertionPoint_);
            }

            /* access modifiers changed from: private */
            public void setInsertionPoint(String str) {
                if (str != null) {
                    this.bitField0_ |= 2;
                    this.insertionPoint_ = str;
                    return;
                }
                throw new NullPointerException();
            }

            /* access modifiers changed from: private */
            public void clearInsertionPoint() {
                this.bitField0_ &= -3;
                this.insertionPoint_ = getDefaultInstance().getInsertionPoint();
            }

            /* access modifiers changed from: private */
            public void setInsertionPointBytes(ByteString byteString) {
                if (byteString != null) {
                    this.bitField0_ |= 2;
                    this.insertionPoint_ = byteString.toStringUtf8();
                    return;
                }
                throw new NullPointerException();
            }

            public boolean hasContent() {
                return (this.bitField0_ & 4) == 4;
            }

            public String getContent() {
                return this.content_;
            }

            public ByteString getContentBytes() {
                return ByteString.copyFromUtf8(this.content_);
            }

            /* access modifiers changed from: private */
            public void setContent(String str) {
                if (str != null) {
                    this.bitField0_ |= 4;
                    this.content_ = str;
                    return;
                }
                throw new NullPointerException();
            }

            /* access modifiers changed from: private */
            public void clearContent() {
                this.bitField0_ &= -5;
                this.content_ = getDefaultInstance().getContent();
            }

            /* access modifiers changed from: private */
            public void setContentBytes(ByteString byteString) {
                if (byteString != null) {
                    this.bitField0_ |= 4;
                    this.content_ = byteString.toStringUtf8();
                    return;
                }
                throw new NullPointerException();
            }

            public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
                if ((this.bitField0_ & 1) == 1) {
                    codedOutputStream.writeString(1, getName());
                }
                if ((this.bitField0_ & 2) == 2) {
                    codedOutputStream.writeString(2, getInsertionPoint());
                }
                if ((this.bitField0_ & 4) == 4) {
                    codedOutputStream.writeString(15, getContent());
                }
                this.unknownFields.writeTo(codedOutputStream);
            }

            public int getSerializedSize() {
                int i = this.memoizedSerializedSize;
                if (i != -1) {
                    return i;
                }
                int i2 = 0;
                if ((this.bitField0_ & 1) == 1) {
                    i2 = 0 + CodedOutputStream.computeStringSize(1, getName());
                }
                if ((this.bitField0_ & 2) == 2) {
                    i2 += CodedOutputStream.computeStringSize(2, getInsertionPoint());
                }
                if ((this.bitField0_ & 4) == 4) {
                    i2 += CodedOutputStream.computeStringSize(15, getContent());
                }
                int serializedSize = i2 + this.unknownFields.getSerializedSize();
                this.memoizedSerializedSize = serializedSize;
                return serializedSize;
            }

            public static File parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
                return (File) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
            }

            public static File parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return (File) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
            }

            public static File parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
                return (File) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
            }

            public static File parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return (File) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
            }

            public static File parseFrom(InputStream inputStream) throws IOException {
                return (File) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
            }

            public static File parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                return (File) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
            }

            public static File parseDelimitedFrom(InputStream inputStream) throws IOException {
                return (File) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
            }

            public static File parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                return (File) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
            }

            public static File parseFrom(CodedInputStream codedInputStream) throws IOException {
                return (File) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
            }

            public static File parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                return (File) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
            }

            public static Builder newBuilder() {
                return (Builder) DEFAULT_INSTANCE.toBuilder();
            }

            public static Builder newBuilder(File file) {
                return (Builder) ((Builder) DEFAULT_INSTANCE.toBuilder()).mergeFrom(file);
            }

            /* compiled from: com.google.firebase:protolite-well-known-types@@16.0.1 */
            public static final class Builder extends GeneratedMessageLite.Builder<File, Builder> implements FileOrBuilder {
                private Builder() {
                    super(File.DEFAULT_INSTANCE);
                }

                public boolean hasName() {
                    return ((File) this.instance).hasName();
                }

                public String getName() {
                    return ((File) this.instance).getName();
                }

                public ByteString getNameBytes() {
                    return ((File) this.instance).getNameBytes();
                }

                public Builder setName(String str) {
                    copyOnWrite();
                    ((File) this.instance).setName(str);
                    return this;
                }

                public Builder clearName() {
                    copyOnWrite();
                    ((File) this.instance).clearName();
                    return this;
                }

                public Builder setNameBytes(ByteString byteString) {
                    copyOnWrite();
                    ((File) this.instance).setNameBytes(byteString);
                    return this;
                }

                public boolean hasInsertionPoint() {
                    return ((File) this.instance).hasInsertionPoint();
                }

                public String getInsertionPoint() {
                    return ((File) this.instance).getInsertionPoint();
                }

                public ByteString getInsertionPointBytes() {
                    return ((File) this.instance).getInsertionPointBytes();
                }

                public Builder setInsertionPoint(String str) {
                    copyOnWrite();
                    ((File) this.instance).setInsertionPoint(str);
                    return this;
                }

                public Builder clearInsertionPoint() {
                    copyOnWrite();
                    ((File) this.instance).clearInsertionPoint();
                    return this;
                }

                public Builder setInsertionPointBytes(ByteString byteString) {
                    copyOnWrite();
                    ((File) this.instance).setInsertionPointBytes(byteString);
                    return this;
                }

                public boolean hasContent() {
                    return ((File) this.instance).hasContent();
                }

                public String getContent() {
                    return ((File) this.instance).getContent();
                }

                public ByteString getContentBytes() {
                    return ((File) this.instance).getContentBytes();
                }

                public Builder setContent(String str) {
                    copyOnWrite();
                    ((File) this.instance).setContent(str);
                    return this;
                }

                public Builder clearContent() {
                    copyOnWrite();
                    ((File) this.instance).clearContent();
                    return this;
                }

                public Builder setContentBytes(ByteString byteString) {
                    copyOnWrite();
                    ((File) this.instance).setContentBytes(byteString);
                    return this;
                }
            }

            /* access modifiers changed from: protected */
            public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
                switch (methodToInvoke) {
                    case NEW_MUTABLE_INSTANCE:
                        return new File();
                    case IS_INITIALIZED:
                        return DEFAULT_INSTANCE;
                    case MAKE_IMMUTABLE:
                        return null;
                    case NEW_BUILDER:
                        return new Builder();
                    case VISIT:
                        GeneratedMessageLite.Visitor visitor = (GeneratedMessageLite.Visitor) obj;
                        File file = (File) obj2;
                        this.name_ = visitor.visitString(hasName(), this.name_, file.hasName(), file.name_);
                        this.insertionPoint_ = visitor.visitString(hasInsertionPoint(), this.insertionPoint_, file.hasInsertionPoint(), file.insertionPoint_);
                        this.content_ = visitor.visitString(hasContent(), this.content_, file.hasContent(), file.content_);
                        if (visitor == GeneratedMessageLite.MergeFromVisitor.INSTANCE) {
                            this.bitField0_ |= file.bitField0_;
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
                                        String readString = codedInputStream.readString();
                                        this.bitField0_ = 1 | this.bitField0_;
                                        this.name_ = readString;
                                    } else if (readTag == 18) {
                                        String readString2 = codedInputStream.readString();
                                        this.bitField0_ |= 2;
                                        this.insertionPoint_ = readString2;
                                    } else if (readTag == 122) {
                                        String readString3 = codedInputStream.readString();
                                        this.bitField0_ |= 4;
                                        this.content_ = readString3;
                                    } else if (!parseUnknownField(readTag, codedInputStream)) {
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
                            synchronized (File.class) {
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

            public static File getDefaultInstance() {
                return DEFAULT_INSTANCE;
            }

            public static Parser<File> parser() {
                return DEFAULT_INSTANCE.getParserForType();
            }
        }

        public boolean hasError() {
            return (this.bitField0_ & 1) == 1;
        }

        public String getError() {
            return this.error_;
        }

        public ByteString getErrorBytes() {
            return ByteString.copyFromUtf8(this.error_);
        }

        /* access modifiers changed from: private */
        public void setError(String str) {
            if (str != null) {
                this.bitField0_ |= 1;
                this.error_ = str;
                return;
            }
            throw new NullPointerException();
        }

        /* access modifiers changed from: private */
        public void clearError() {
            this.bitField0_ &= -2;
            this.error_ = getDefaultInstance().getError();
        }

        /* access modifiers changed from: private */
        public void setErrorBytes(ByteString byteString) {
            if (byteString != null) {
                this.bitField0_ |= 1;
                this.error_ = byteString.toStringUtf8();
                return;
            }
            throw new NullPointerException();
        }

        public List<File> getFileList() {
            return this.file_;
        }

        public List<? extends FileOrBuilder> getFileOrBuilderList() {
            return this.file_;
        }

        public int getFileCount() {
            return this.file_.size();
        }

        public File getFile(int i) {
            return (File) this.file_.get(i);
        }

        public FileOrBuilder getFileOrBuilder(int i) {
            return (FileOrBuilder) this.file_.get(i);
        }

        private void ensureFileIsMutable() {
            if (!this.file_.isModifiable()) {
                this.file_ = GeneratedMessageLite.mutableCopy(this.file_);
            }
        }

        /* access modifiers changed from: private */
        public void setFile(int i, File file) {
            if (file != null) {
                ensureFileIsMutable();
                this.file_.set(i, file);
                return;
            }
            throw new NullPointerException();
        }

        /* access modifiers changed from: private */
        public void setFile(int i, File.Builder builder) {
            ensureFileIsMutable();
            this.file_.set(i, (File) builder.build());
        }

        /* access modifiers changed from: private */
        public void addFile(File file) {
            if (file != null) {
                ensureFileIsMutable();
                this.file_.add(file);
                return;
            }
            throw new NullPointerException();
        }

        /* access modifiers changed from: private */
        public void addFile(int i, File file) {
            if (file != null) {
                ensureFileIsMutable();
                this.file_.add(i, file);
                return;
            }
            throw new NullPointerException();
        }

        /* access modifiers changed from: private */
        public void addFile(File.Builder builder) {
            ensureFileIsMutable();
            this.file_.add((File) builder.build());
        }

        /* access modifiers changed from: private */
        public void addFile(int i, File.Builder builder) {
            ensureFileIsMutable();
            this.file_.add(i, (File) builder.build());
        }

        /* access modifiers changed from: private */
        public void addAllFile(Iterable<? extends File> iterable) {
            ensureFileIsMutable();
            AbstractMessageLite.addAll(iterable, this.file_);
        }

        /* access modifiers changed from: private */
        public void clearFile() {
            this.file_ = emptyProtobufList();
        }

        /* access modifiers changed from: private */
        public void removeFile(int i) {
            ensureFileIsMutable();
            this.file_.remove(i);
        }

        public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
            if ((this.bitField0_ & 1) == 1) {
                codedOutputStream.writeString(1, getError());
            }
            for (int i = 0; i < this.file_.size(); i++) {
                codedOutputStream.writeMessage(15, (MessageLite) this.file_.get(i));
            }
            this.unknownFields.writeTo(codedOutputStream);
        }

        public int getSerializedSize() {
            int i = this.memoizedSerializedSize;
            if (i != -1) {
                return i;
            }
            int computeStringSize = (this.bitField0_ & 1) == 1 ? CodedOutputStream.computeStringSize(1, getError()) + 0 : 0;
            for (int i2 = 0; i2 < this.file_.size(); i2++) {
                computeStringSize += CodedOutputStream.computeMessageSize(15, (MessageLite) this.file_.get(i2));
            }
            int serializedSize = computeStringSize + this.unknownFields.getSerializedSize();
            this.memoizedSerializedSize = serializedSize;
            return serializedSize;
        }

        public static CodeGeneratorResponse parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return (CodeGeneratorResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
        }

        public static CodeGeneratorResponse parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (CodeGeneratorResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
        }

        public static CodeGeneratorResponse parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return (CodeGeneratorResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
        }

        public static CodeGeneratorResponse parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (CodeGeneratorResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
        }

        public static CodeGeneratorResponse parseFrom(InputStream inputStream) throws IOException {
            return (CodeGeneratorResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static CodeGeneratorResponse parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (CodeGeneratorResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static CodeGeneratorResponse parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (CodeGeneratorResponse) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static CodeGeneratorResponse parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (CodeGeneratorResponse) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static CodeGeneratorResponse parseFrom(CodedInputStream codedInputStream) throws IOException {
            return (CodeGeneratorResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
        }

        public static CodeGeneratorResponse parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (CodeGeneratorResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
        }

        public static Builder newBuilder() {
            return (Builder) DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(CodeGeneratorResponse codeGeneratorResponse) {
            return (Builder) ((Builder) DEFAULT_INSTANCE.toBuilder()).mergeFrom(codeGeneratorResponse);
        }

        /* compiled from: com.google.firebase:protolite-well-known-types@@16.0.1 */
        public static final class Builder extends GeneratedMessageLite.Builder<CodeGeneratorResponse, Builder> implements CodeGeneratorResponseOrBuilder {
            private Builder() {
                super(CodeGeneratorResponse.DEFAULT_INSTANCE);
            }

            public boolean hasError() {
                return ((CodeGeneratorResponse) this.instance).hasError();
            }

            public String getError() {
                return ((CodeGeneratorResponse) this.instance).getError();
            }

            public ByteString getErrorBytes() {
                return ((CodeGeneratorResponse) this.instance).getErrorBytes();
            }

            public Builder setError(String str) {
                copyOnWrite();
                ((CodeGeneratorResponse) this.instance).setError(str);
                return this;
            }

            public Builder clearError() {
                copyOnWrite();
                ((CodeGeneratorResponse) this.instance).clearError();
                return this;
            }

            public Builder setErrorBytes(ByteString byteString) {
                copyOnWrite();
                ((CodeGeneratorResponse) this.instance).setErrorBytes(byteString);
                return this;
            }

            public List<File> getFileList() {
                return Collections.unmodifiableList(((CodeGeneratorResponse) this.instance).getFileList());
            }

            public int getFileCount() {
                return ((CodeGeneratorResponse) this.instance).getFileCount();
            }

            public File getFile(int i) {
                return ((CodeGeneratorResponse) this.instance).getFile(i);
            }

            public Builder setFile(int i, File file) {
                copyOnWrite();
                ((CodeGeneratorResponse) this.instance).setFile(i, file);
                return this;
            }

            public Builder setFile(int i, File.Builder builder) {
                copyOnWrite();
                ((CodeGeneratorResponse) this.instance).setFile(i, builder);
                return this;
            }

            public Builder addFile(File file) {
                copyOnWrite();
                ((CodeGeneratorResponse) this.instance).addFile(file);
                return this;
            }

            public Builder addFile(int i, File file) {
                copyOnWrite();
                ((CodeGeneratorResponse) this.instance).addFile(i, file);
                return this;
            }

            public Builder addFile(File.Builder builder) {
                copyOnWrite();
                ((CodeGeneratorResponse) this.instance).addFile(builder);
                return this;
            }

            public Builder addFile(int i, File.Builder builder) {
                copyOnWrite();
                ((CodeGeneratorResponse) this.instance).addFile(i, builder);
                return this;
            }

            public Builder addAllFile(Iterable<? extends File> iterable) {
                copyOnWrite();
                ((CodeGeneratorResponse) this.instance).addAllFile(iterable);
                return this;
            }

            public Builder clearFile() {
                copyOnWrite();
                ((CodeGeneratorResponse) this.instance).clearFile();
                return this;
            }

            public Builder removeFile(int i) {
                copyOnWrite();
                ((CodeGeneratorResponse) this.instance).removeFile(i);
                return this;
            }
        }

        /* access modifiers changed from: protected */
        public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            switch (methodToInvoke) {
                case NEW_MUTABLE_INSTANCE:
                    return new CodeGeneratorResponse();
                case IS_INITIALIZED:
                    return DEFAULT_INSTANCE;
                case MAKE_IMMUTABLE:
                    this.file_.makeImmutable();
                    return null;
                case NEW_BUILDER:
                    return new Builder();
                case VISIT:
                    GeneratedMessageLite.Visitor visitor = (GeneratedMessageLite.Visitor) obj;
                    CodeGeneratorResponse codeGeneratorResponse = (CodeGeneratorResponse) obj2;
                    this.error_ = visitor.visitString(hasError(), this.error_, codeGeneratorResponse.hasError(), codeGeneratorResponse.error_);
                    this.file_ = visitor.visitList(this.file_, codeGeneratorResponse.file_);
                    if (visitor == GeneratedMessageLite.MergeFromVisitor.INSTANCE) {
                        this.bitField0_ |= codeGeneratorResponse.bitField0_;
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
                                    String readString = codedInputStream.readString();
                                    this.bitField0_ = 1 | this.bitField0_;
                                    this.error_ = readString;
                                } else if (readTag == 122) {
                                    if (!this.file_.isModifiable()) {
                                        this.file_ = GeneratedMessageLite.mutableCopy(this.file_);
                                    }
                                    this.file_.add((File) codedInputStream.readMessage(File.parser(), extensionRegistryLite));
                                } else if (!parseUnknownField(readTag, codedInputStream)) {
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
                        synchronized (CodeGeneratorResponse.class) {
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

        public static CodeGeneratorResponse getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<CodeGeneratorResponse> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }
    }
}
