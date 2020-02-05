package com.google.protobuf;

import com.adobe.xmp.options.PropertyOptions;
import com.drew.metadata.exif.ExifDirectoryBase;
import com.drew.metadata.exif.makernotes.NikonType2MakernoteDirectory;
import com.drew.metadata.exif.makernotes.OlympusRawInfoMakernoteDirectory;
import com.drew.metadata.iptc.IptcDirectory;
import com.facebook.imageutils.JfifUtil;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.Internal;
import java.io.IOException;
import java.io.InputStream;
import java.util.Collections;
import java.util.List;

/* compiled from: com.google.firebase:protolite-well-known-types@@16.0.1 */
public final class DescriptorProtos {

    /* compiled from: com.google.firebase:protolite-well-known-types@@16.0.1 */
    public interface DescriptorProtoOrBuilder extends MessageLiteOrBuilder {
        EnumDescriptorProto getEnumType(int i);

        int getEnumTypeCount();

        List<EnumDescriptorProto> getEnumTypeList();

        FieldDescriptorProto getExtension(int i);

        int getExtensionCount();

        List<FieldDescriptorProto> getExtensionList();

        DescriptorProto.ExtensionRange getExtensionRange(int i);

        int getExtensionRangeCount();

        List<DescriptorProto.ExtensionRange> getExtensionRangeList();

        FieldDescriptorProto getField(int i);

        int getFieldCount();

        List<FieldDescriptorProto> getFieldList();

        String getName();

        ByteString getNameBytes();

        DescriptorProto getNestedType(int i);

        int getNestedTypeCount();

        List<DescriptorProto> getNestedTypeList();

        OneofDescriptorProto getOneofDecl(int i);

        int getOneofDeclCount();

        List<OneofDescriptorProto> getOneofDeclList();

        MessageOptions getOptions();

        String getReservedName(int i);

        ByteString getReservedNameBytes(int i);

        int getReservedNameCount();

        List<String> getReservedNameList();

        DescriptorProto.ReservedRange getReservedRange(int i);

        int getReservedRangeCount();

        List<DescriptorProto.ReservedRange> getReservedRangeList();

        boolean hasName();

        boolean hasOptions();
    }

    /* compiled from: com.google.firebase:protolite-well-known-types@@16.0.1 */
    public interface EnumDescriptorProtoOrBuilder extends MessageLiteOrBuilder {
        String getName();

        ByteString getNameBytes();

        EnumOptions getOptions();

        String getReservedName(int i);

        ByteString getReservedNameBytes(int i);

        int getReservedNameCount();

        List<String> getReservedNameList();

        EnumDescriptorProto.EnumReservedRange getReservedRange(int i);

        int getReservedRangeCount();

        List<EnumDescriptorProto.EnumReservedRange> getReservedRangeList();

        EnumValueDescriptorProto getValue(int i);

        int getValueCount();

        List<EnumValueDescriptorProto> getValueList();

        boolean hasName();

        boolean hasOptions();
    }

    /* compiled from: com.google.firebase:protolite-well-known-types@@16.0.1 */
    public interface EnumOptionsOrBuilder extends GeneratedMessageLite.ExtendableMessageOrBuilder<EnumOptions, EnumOptions.Builder> {
        boolean getAllowAlias();

        boolean getDeprecated();

        UninterpretedOption getUninterpretedOption(int i);

        int getUninterpretedOptionCount();

        List<UninterpretedOption> getUninterpretedOptionList();

        boolean hasAllowAlias();

        boolean hasDeprecated();
    }

    /* compiled from: com.google.firebase:protolite-well-known-types@@16.0.1 */
    public interface EnumValueDescriptorProtoOrBuilder extends MessageLiteOrBuilder {
        String getName();

        ByteString getNameBytes();

        int getNumber();

        EnumValueOptions getOptions();

        boolean hasName();

        boolean hasNumber();

        boolean hasOptions();
    }

    /* compiled from: com.google.firebase:protolite-well-known-types@@16.0.1 */
    public interface EnumValueOptionsOrBuilder extends GeneratedMessageLite.ExtendableMessageOrBuilder<EnumValueOptions, EnumValueOptions.Builder> {
        boolean getDeprecated();

        UninterpretedOption getUninterpretedOption(int i);

        int getUninterpretedOptionCount();

        List<UninterpretedOption> getUninterpretedOptionList();

        boolean hasDeprecated();
    }

    /* compiled from: com.google.firebase:protolite-well-known-types@@16.0.1 */
    public interface ExtensionRangeOptionsOrBuilder extends GeneratedMessageLite.ExtendableMessageOrBuilder<ExtensionRangeOptions, ExtensionRangeOptions.Builder> {
        UninterpretedOption getUninterpretedOption(int i);

        int getUninterpretedOptionCount();

        List<UninterpretedOption> getUninterpretedOptionList();
    }

    /* compiled from: com.google.firebase:protolite-well-known-types@@16.0.1 */
    public interface FieldDescriptorProtoOrBuilder extends MessageLiteOrBuilder {
        String getDefaultValue();

        ByteString getDefaultValueBytes();

        String getExtendee();

        ByteString getExtendeeBytes();

        String getJsonName();

        ByteString getJsonNameBytes();

        FieldDescriptorProto.Label getLabel();

        String getName();

        ByteString getNameBytes();

        int getNumber();

        int getOneofIndex();

        FieldOptions getOptions();

        FieldDescriptorProto.Type getType();

        String getTypeName();

        ByteString getTypeNameBytes();

        boolean hasDefaultValue();

        boolean hasExtendee();

        boolean hasJsonName();

        boolean hasLabel();

        boolean hasName();

        boolean hasNumber();

        boolean hasOneofIndex();

        boolean hasOptions();

        boolean hasType();

        boolean hasTypeName();
    }

    /* compiled from: com.google.firebase:protolite-well-known-types@@16.0.1 */
    public interface FieldOptionsOrBuilder extends GeneratedMessageLite.ExtendableMessageOrBuilder<FieldOptions, FieldOptions.Builder> {
        FieldOptions.CType getCtype();

        boolean getDeprecated();

        FieldOptions.JSType getJstype();

        boolean getLazy();

        boolean getPacked();

        UninterpretedOption getUninterpretedOption(int i);

        int getUninterpretedOptionCount();

        List<UninterpretedOption> getUninterpretedOptionList();

        boolean getWeak();

        boolean hasCtype();

        boolean hasDeprecated();

        boolean hasJstype();

        boolean hasLazy();

        boolean hasPacked();

        boolean hasWeak();
    }

    /* compiled from: com.google.firebase:protolite-well-known-types@@16.0.1 */
    public interface FileDescriptorProtoOrBuilder extends MessageLiteOrBuilder {
        String getDependency(int i);

        ByteString getDependencyBytes(int i);

        int getDependencyCount();

        List<String> getDependencyList();

        EnumDescriptorProto getEnumType(int i);

        int getEnumTypeCount();

        List<EnumDescriptorProto> getEnumTypeList();

        FieldDescriptorProto getExtension(int i);

        int getExtensionCount();

        List<FieldDescriptorProto> getExtensionList();

        DescriptorProto getMessageType(int i);

        int getMessageTypeCount();

        List<DescriptorProto> getMessageTypeList();

        String getName();

        ByteString getNameBytes();

        FileOptions getOptions();

        String getPackage();

        ByteString getPackageBytes();

        int getPublicDependency(int i);

        int getPublicDependencyCount();

        List<Integer> getPublicDependencyList();

        ServiceDescriptorProto getService(int i);

        int getServiceCount();

        List<ServiceDescriptorProto> getServiceList();

        SourceCodeInfo getSourceCodeInfo();

        String getSyntax();

        ByteString getSyntaxBytes();

        int getWeakDependency(int i);

        int getWeakDependencyCount();

        List<Integer> getWeakDependencyList();

        boolean hasName();

        boolean hasOptions();

        boolean hasPackage();

        boolean hasSourceCodeInfo();

        boolean hasSyntax();
    }

    /* compiled from: com.google.firebase:protolite-well-known-types@@16.0.1 */
    public interface FileDescriptorSetOrBuilder extends MessageLiteOrBuilder {
        FileDescriptorProto getFile(int i);

        int getFileCount();

        List<FileDescriptorProto> getFileList();
    }

    /* compiled from: com.google.firebase:protolite-well-known-types@@16.0.1 */
    public interface FileOptionsOrBuilder extends GeneratedMessageLite.ExtendableMessageOrBuilder<FileOptions, FileOptions.Builder> {
        boolean getCcEnableArenas();

        boolean getCcGenericServices();

        String getCsharpNamespace();

        ByteString getCsharpNamespaceBytes();

        boolean getDeprecated();

        String getGoPackage();

        ByteString getGoPackageBytes();

        @Deprecated
        boolean getJavaGenerateEqualsAndHash();

        boolean getJavaGenericServices();

        boolean getJavaMultipleFiles();

        String getJavaOuterClassname();

        ByteString getJavaOuterClassnameBytes();

        String getJavaPackage();

        ByteString getJavaPackageBytes();

        boolean getJavaStringCheckUtf8();

        String getObjcClassPrefix();

        ByteString getObjcClassPrefixBytes();

        FileOptions.OptimizeMode getOptimizeFor();

        String getPhpClassPrefix();

        ByteString getPhpClassPrefixBytes();

        boolean getPhpGenericServices();

        String getPhpNamespace();

        ByteString getPhpNamespaceBytes();

        boolean getPyGenericServices();

        String getSwiftPrefix();

        ByteString getSwiftPrefixBytes();

        UninterpretedOption getUninterpretedOption(int i);

        int getUninterpretedOptionCount();

        List<UninterpretedOption> getUninterpretedOptionList();

        boolean hasCcEnableArenas();

        boolean hasCcGenericServices();

        boolean hasCsharpNamespace();

        boolean hasDeprecated();

        boolean hasGoPackage();

        @Deprecated
        boolean hasJavaGenerateEqualsAndHash();

        boolean hasJavaGenericServices();

        boolean hasJavaMultipleFiles();

        boolean hasJavaOuterClassname();

        boolean hasJavaPackage();

        boolean hasJavaStringCheckUtf8();

        boolean hasObjcClassPrefix();

        boolean hasOptimizeFor();

        boolean hasPhpClassPrefix();

        boolean hasPhpGenericServices();

        boolean hasPhpNamespace();

        boolean hasPyGenericServices();

        boolean hasSwiftPrefix();
    }

    /* compiled from: com.google.firebase:protolite-well-known-types@@16.0.1 */
    public interface GeneratedCodeInfoOrBuilder extends MessageLiteOrBuilder {
        GeneratedCodeInfo.Annotation getAnnotation(int i);

        int getAnnotationCount();

        List<GeneratedCodeInfo.Annotation> getAnnotationList();
    }

    /* compiled from: com.google.firebase:protolite-well-known-types@@16.0.1 */
    public interface MessageOptionsOrBuilder extends GeneratedMessageLite.ExtendableMessageOrBuilder<MessageOptions, MessageOptions.Builder> {
        boolean getDeprecated();

        boolean getMapEntry();

        boolean getMessageSetWireFormat();

        boolean getNoStandardDescriptorAccessor();

        UninterpretedOption getUninterpretedOption(int i);

        int getUninterpretedOptionCount();

        List<UninterpretedOption> getUninterpretedOptionList();

        boolean hasDeprecated();

        boolean hasMapEntry();

        boolean hasMessageSetWireFormat();

        boolean hasNoStandardDescriptorAccessor();
    }

    /* compiled from: com.google.firebase:protolite-well-known-types@@16.0.1 */
    public interface MethodDescriptorProtoOrBuilder extends MessageLiteOrBuilder {
        boolean getClientStreaming();

        String getInputType();

        ByteString getInputTypeBytes();

        String getName();

        ByteString getNameBytes();

        MethodOptions getOptions();

        String getOutputType();

        ByteString getOutputTypeBytes();

        boolean getServerStreaming();

        boolean hasClientStreaming();

        boolean hasInputType();

        boolean hasName();

        boolean hasOptions();

        boolean hasOutputType();

        boolean hasServerStreaming();
    }

    /* compiled from: com.google.firebase:protolite-well-known-types@@16.0.1 */
    public interface MethodOptionsOrBuilder extends GeneratedMessageLite.ExtendableMessageOrBuilder<MethodOptions, MethodOptions.Builder> {
        boolean getDeprecated();

        MethodOptions.IdempotencyLevel getIdempotencyLevel();

        UninterpretedOption getUninterpretedOption(int i);

        int getUninterpretedOptionCount();

        List<UninterpretedOption> getUninterpretedOptionList();

        boolean hasDeprecated();

        boolean hasIdempotencyLevel();
    }

    /* compiled from: com.google.firebase:protolite-well-known-types@@16.0.1 */
    public interface OneofDescriptorProtoOrBuilder extends MessageLiteOrBuilder {
        String getName();

        ByteString getNameBytes();

        OneofOptions getOptions();

        boolean hasName();

        boolean hasOptions();
    }

    /* compiled from: com.google.firebase:protolite-well-known-types@@16.0.1 */
    public interface OneofOptionsOrBuilder extends GeneratedMessageLite.ExtendableMessageOrBuilder<OneofOptions, OneofOptions.Builder> {
        UninterpretedOption getUninterpretedOption(int i);

        int getUninterpretedOptionCount();

        List<UninterpretedOption> getUninterpretedOptionList();
    }

    /* compiled from: com.google.firebase:protolite-well-known-types@@16.0.1 */
    public interface ServiceDescriptorProtoOrBuilder extends MessageLiteOrBuilder {
        MethodDescriptorProto getMethod(int i);

        int getMethodCount();

        List<MethodDescriptorProto> getMethodList();

        String getName();

        ByteString getNameBytes();

        ServiceOptions getOptions();

        boolean hasName();

        boolean hasOptions();
    }

    /* compiled from: com.google.firebase:protolite-well-known-types@@16.0.1 */
    public interface ServiceOptionsOrBuilder extends GeneratedMessageLite.ExtendableMessageOrBuilder<ServiceOptions, ServiceOptions.Builder> {
        boolean getDeprecated();

        UninterpretedOption getUninterpretedOption(int i);

        int getUninterpretedOptionCount();

        List<UninterpretedOption> getUninterpretedOptionList();

        boolean hasDeprecated();
    }

    /* compiled from: com.google.firebase:protolite-well-known-types@@16.0.1 */
    public interface SourceCodeInfoOrBuilder extends MessageLiteOrBuilder {
        SourceCodeInfo.Location getLocation(int i);

        int getLocationCount();

        List<SourceCodeInfo.Location> getLocationList();
    }

    /* compiled from: com.google.firebase:protolite-well-known-types@@16.0.1 */
    public interface UninterpretedOptionOrBuilder extends MessageLiteOrBuilder {
        String getAggregateValue();

        ByteString getAggregateValueBytes();

        double getDoubleValue();

        String getIdentifierValue();

        ByteString getIdentifierValueBytes();

        UninterpretedOption.NamePart getName(int i);

        int getNameCount();

        List<UninterpretedOption.NamePart> getNameList();

        long getNegativeIntValue();

        long getPositiveIntValue();

        ByteString getStringValue();

        boolean hasAggregateValue();

        boolean hasDoubleValue();

        boolean hasIdentifierValue();

        boolean hasNegativeIntValue();

        boolean hasPositiveIntValue();

        boolean hasStringValue();
    }

    public static void registerAllExtensions(ExtensionRegistryLite extensionRegistryLite) {
    }

    private DescriptorProtos() {
    }

    /* compiled from: com.google.firebase:protolite-well-known-types@@16.0.1 */
    public static final class FileDescriptorSet extends GeneratedMessageLite<FileDescriptorSet, Builder> implements FileDescriptorSetOrBuilder {
        /* access modifiers changed from: private */
        public static final FileDescriptorSet DEFAULT_INSTANCE = new FileDescriptorSet();
        public static final int FILE_FIELD_NUMBER = 1;
        private static volatile Parser<FileDescriptorSet> PARSER;
        private Internal.ProtobufList<FileDescriptorProto> file_ = emptyProtobufList();
        private byte memoizedIsInitialized = -1;

        private FileDescriptorSet() {
        }

        public List<FileDescriptorProto> getFileList() {
            return this.file_;
        }

        public List<? extends FileDescriptorProtoOrBuilder> getFileOrBuilderList() {
            return this.file_;
        }

        public int getFileCount() {
            return this.file_.size();
        }

        public FileDescriptorProto getFile(int i) {
            return (FileDescriptorProto) this.file_.get(i);
        }

        public FileDescriptorProtoOrBuilder getFileOrBuilder(int i) {
            return (FileDescriptorProtoOrBuilder) this.file_.get(i);
        }

        private void ensureFileIsMutable() {
            if (!this.file_.isModifiable()) {
                this.file_ = GeneratedMessageLite.mutableCopy(this.file_);
            }
        }

        /* access modifiers changed from: private */
        public void setFile(int i, FileDescriptorProto fileDescriptorProto) {
            if (fileDescriptorProto != null) {
                ensureFileIsMutable();
                this.file_.set(i, fileDescriptorProto);
                return;
            }
            throw new NullPointerException();
        }

        /* access modifiers changed from: private */
        public void setFile(int i, FileDescriptorProto.Builder builder) {
            ensureFileIsMutable();
            this.file_.set(i, (FileDescriptorProto) builder.build());
        }

        /* access modifiers changed from: private */
        public void addFile(FileDescriptorProto fileDescriptorProto) {
            if (fileDescriptorProto != null) {
                ensureFileIsMutable();
                this.file_.add(fileDescriptorProto);
                return;
            }
            throw new NullPointerException();
        }

        /* access modifiers changed from: private */
        public void addFile(int i, FileDescriptorProto fileDescriptorProto) {
            if (fileDescriptorProto != null) {
                ensureFileIsMutable();
                this.file_.add(i, fileDescriptorProto);
                return;
            }
            throw new NullPointerException();
        }

        /* access modifiers changed from: private */
        public void addFile(FileDescriptorProto.Builder builder) {
            ensureFileIsMutable();
            this.file_.add((FileDescriptorProto) builder.build());
        }

        /* access modifiers changed from: private */
        public void addFile(int i, FileDescriptorProto.Builder builder) {
            ensureFileIsMutable();
            this.file_.add(i, (FileDescriptorProto) builder.build());
        }

        /* access modifiers changed from: private */
        public void addAllFile(Iterable<? extends FileDescriptorProto> iterable) {
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
            for (int i = 0; i < this.file_.size(); i++) {
                codedOutputStream.writeMessage(1, (MessageLite) this.file_.get(i));
            }
            this.unknownFields.writeTo(codedOutputStream);
        }

        public int getSerializedSize() {
            int i = this.memoizedSerializedSize;
            if (i != -1) {
                return i;
            }
            int i2 = 0;
            for (int i3 = 0; i3 < this.file_.size(); i3++) {
                i2 += CodedOutputStream.computeMessageSize(1, (MessageLite) this.file_.get(i3));
            }
            int serializedSize = i2 + this.unknownFields.getSerializedSize();
            this.memoizedSerializedSize = serializedSize;
            return serializedSize;
        }

        public static FileDescriptorSet parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return (FileDescriptorSet) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
        }

        public static FileDescriptorSet parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (FileDescriptorSet) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
        }

        public static FileDescriptorSet parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return (FileDescriptorSet) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
        }

        public static FileDescriptorSet parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (FileDescriptorSet) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
        }

        public static FileDescriptorSet parseFrom(InputStream inputStream) throws IOException {
            return (FileDescriptorSet) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static FileDescriptorSet parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (FileDescriptorSet) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static FileDescriptorSet parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (FileDescriptorSet) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static FileDescriptorSet parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (FileDescriptorSet) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static FileDescriptorSet parseFrom(CodedInputStream codedInputStream) throws IOException {
            return (FileDescriptorSet) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
        }

        public static FileDescriptorSet parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (FileDescriptorSet) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
        }

        public static Builder newBuilder() {
            return (Builder) DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(FileDescriptorSet fileDescriptorSet) {
            return (Builder) ((Builder) DEFAULT_INSTANCE.toBuilder()).mergeFrom(fileDescriptorSet);
        }

        /* compiled from: com.google.firebase:protolite-well-known-types@@16.0.1 */
        public static final class Builder extends GeneratedMessageLite.Builder<FileDescriptorSet, Builder> implements FileDescriptorSetOrBuilder {
            private Builder() {
                super(FileDescriptorSet.DEFAULT_INSTANCE);
            }

            public List<FileDescriptorProto> getFileList() {
                return Collections.unmodifiableList(((FileDescriptorSet) this.instance).getFileList());
            }

            public int getFileCount() {
                return ((FileDescriptorSet) this.instance).getFileCount();
            }

            public FileDescriptorProto getFile(int i) {
                return ((FileDescriptorSet) this.instance).getFile(i);
            }

            public Builder setFile(int i, FileDescriptorProto fileDescriptorProto) {
                copyOnWrite();
                ((FileDescriptorSet) this.instance).setFile(i, fileDescriptorProto);
                return this;
            }

            public Builder setFile(int i, FileDescriptorProto.Builder builder) {
                copyOnWrite();
                ((FileDescriptorSet) this.instance).setFile(i, builder);
                return this;
            }

            public Builder addFile(FileDescriptorProto fileDescriptorProto) {
                copyOnWrite();
                ((FileDescriptorSet) this.instance).addFile(fileDescriptorProto);
                return this;
            }

            public Builder addFile(int i, FileDescriptorProto fileDescriptorProto) {
                copyOnWrite();
                ((FileDescriptorSet) this.instance).addFile(i, fileDescriptorProto);
                return this;
            }

            public Builder addFile(FileDescriptorProto.Builder builder) {
                copyOnWrite();
                ((FileDescriptorSet) this.instance).addFile(builder);
                return this;
            }

            public Builder addFile(int i, FileDescriptorProto.Builder builder) {
                copyOnWrite();
                ((FileDescriptorSet) this.instance).addFile(i, builder);
                return this;
            }

            public Builder addAllFile(Iterable<? extends FileDescriptorProto> iterable) {
                copyOnWrite();
                ((FileDescriptorSet) this.instance).addAllFile(iterable);
                return this;
            }

            public Builder clearFile() {
                copyOnWrite();
                ((FileDescriptorSet) this.instance).clearFile();
                return this;
            }

            public Builder removeFile(int i) {
                copyOnWrite();
                ((FileDescriptorSet) this.instance).removeFile(i);
                return this;
            }
        }

        /* access modifiers changed from: protected */
        public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            boolean z = false;
            switch (methodToInvoke) {
                case NEW_MUTABLE_INSTANCE:
                    return new FileDescriptorSet();
                case IS_INITIALIZED:
                    byte b = this.memoizedIsInitialized;
                    if (b == 1) {
                        return DEFAULT_INSTANCE;
                    }
                    if (b == 0) {
                        return null;
                    }
                    boolean booleanValue = ((Boolean) obj).booleanValue();
                    for (int i = 0; i < getFileCount(); i++) {
                        if (!getFile(i).isInitialized()) {
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
                    this.file_.makeImmutable();
                    return null;
                case NEW_BUILDER:
                    return new Builder();
                case VISIT:
                    this.file_ = ((GeneratedMessageLite.Visitor) obj).visitList(this.file_, ((FileDescriptorSet) obj2).file_);
                    GeneratedMessageLite.MergeFromVisitor mergeFromVisitor = GeneratedMessageLite.MergeFromVisitor.INSTANCE;
                    return this;
                case MERGE_FROM_STREAM:
                    CodedInputStream codedInputStream = (CodedInputStream) obj;
                    ExtensionRegistryLite extensionRegistryLite = (ExtensionRegistryLite) obj2;
                    while (!z) {
                        try {
                            int readTag = codedInputStream.readTag();
                            if (readTag != 0) {
                                if (readTag == 10) {
                                    if (!this.file_.isModifiable()) {
                                        this.file_ = GeneratedMessageLite.mutableCopy(this.file_);
                                    }
                                    this.file_.add((FileDescriptorProto) codedInputStream.readMessage(FileDescriptorProto.parser(), extensionRegistryLite));
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
                        synchronized (FileDescriptorSet.class) {
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

        public static FileDescriptorSet getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<FileDescriptorSet> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }
    }

    /* compiled from: com.google.firebase:protolite-well-known-types@@16.0.1 */
    public static final class FileDescriptorProto extends GeneratedMessageLite<FileDescriptorProto, Builder> implements FileDescriptorProtoOrBuilder {
        /* access modifiers changed from: private */
        public static final FileDescriptorProto DEFAULT_INSTANCE = new FileDescriptorProto();
        public static final int DEPENDENCY_FIELD_NUMBER = 3;
        public static final int ENUM_TYPE_FIELD_NUMBER = 5;
        public static final int EXTENSION_FIELD_NUMBER = 7;
        public static final int MESSAGE_TYPE_FIELD_NUMBER = 4;
        public static final int NAME_FIELD_NUMBER = 1;
        public static final int OPTIONS_FIELD_NUMBER = 8;
        public static final int PACKAGE_FIELD_NUMBER = 2;
        private static volatile Parser<FileDescriptorProto> PARSER = null;
        public static final int PUBLIC_DEPENDENCY_FIELD_NUMBER = 10;
        public static final int SERVICE_FIELD_NUMBER = 6;
        public static final int SOURCE_CODE_INFO_FIELD_NUMBER = 9;
        public static final int SYNTAX_FIELD_NUMBER = 12;
        public static final int WEAK_DEPENDENCY_FIELD_NUMBER = 11;
        private int bitField0_;
        private Internal.ProtobufList<String> dependency_ = GeneratedMessageLite.emptyProtobufList();
        private Internal.ProtobufList<EnumDescriptorProto> enumType_ = emptyProtobufList();
        private Internal.ProtobufList<FieldDescriptorProto> extension_ = emptyProtobufList();
        private byte memoizedIsInitialized = -1;
        private Internal.ProtobufList<DescriptorProto> messageType_ = emptyProtobufList();
        private String name_ = "";
        private FileOptions options_;
        private String package_ = "";
        private Internal.IntList publicDependency_ = emptyIntList();
        private Internal.ProtobufList<ServiceDescriptorProto> service_ = emptyProtobufList();
        private SourceCodeInfo sourceCodeInfo_;
        private String syntax_ = "";
        private Internal.IntList weakDependency_ = emptyIntList();

        private FileDescriptorProto() {
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

        public boolean hasPackage() {
            return (this.bitField0_ & 2) == 2;
        }

        public String getPackage() {
            return this.package_;
        }

        public ByteString getPackageBytes() {
            return ByteString.copyFromUtf8(this.package_);
        }

        /* access modifiers changed from: private */
        public void setPackage(String str) {
            if (str != null) {
                this.bitField0_ |= 2;
                this.package_ = str;
                return;
            }
            throw new NullPointerException();
        }

        /* access modifiers changed from: private */
        public void clearPackage() {
            this.bitField0_ &= -3;
            this.package_ = getDefaultInstance().getPackage();
        }

        /* access modifiers changed from: private */
        public void setPackageBytes(ByteString byteString) {
            if (byteString != null) {
                this.bitField0_ |= 2;
                this.package_ = byteString.toStringUtf8();
                return;
            }
            throw new NullPointerException();
        }

        public List<String> getDependencyList() {
            return this.dependency_;
        }

        public int getDependencyCount() {
            return this.dependency_.size();
        }

        public String getDependency(int i) {
            return (String) this.dependency_.get(i);
        }

        public ByteString getDependencyBytes(int i) {
            return ByteString.copyFromUtf8((String) this.dependency_.get(i));
        }

        private void ensureDependencyIsMutable() {
            if (!this.dependency_.isModifiable()) {
                this.dependency_ = GeneratedMessageLite.mutableCopy(this.dependency_);
            }
        }

        /* access modifiers changed from: private */
        public void setDependency(int i, String str) {
            if (str != null) {
                ensureDependencyIsMutable();
                this.dependency_.set(i, str);
                return;
            }
            throw new NullPointerException();
        }

        /* access modifiers changed from: private */
        public void addDependency(String str) {
            if (str != null) {
                ensureDependencyIsMutable();
                this.dependency_.add(str);
                return;
            }
            throw new NullPointerException();
        }

        /* access modifiers changed from: private */
        public void addAllDependency(Iterable<String> iterable) {
            ensureDependencyIsMutable();
            AbstractMessageLite.addAll(iterable, this.dependency_);
        }

        /* access modifiers changed from: private */
        public void clearDependency() {
            this.dependency_ = GeneratedMessageLite.emptyProtobufList();
        }

        /* access modifiers changed from: private */
        public void addDependencyBytes(ByteString byteString) {
            if (byteString != null) {
                ensureDependencyIsMutable();
                this.dependency_.add(byteString.toStringUtf8());
                return;
            }
            throw new NullPointerException();
        }

        public List<Integer> getPublicDependencyList() {
            return this.publicDependency_;
        }

        public int getPublicDependencyCount() {
            return this.publicDependency_.size();
        }

        public int getPublicDependency(int i) {
            return this.publicDependency_.getInt(i);
        }

        private void ensurePublicDependencyIsMutable() {
            if (!this.publicDependency_.isModifiable()) {
                this.publicDependency_ = GeneratedMessageLite.mutableCopy(this.publicDependency_);
            }
        }

        /* access modifiers changed from: private */
        public void setPublicDependency(int i, int i2) {
            ensurePublicDependencyIsMutable();
            this.publicDependency_.setInt(i, i2);
        }

        /* access modifiers changed from: private */
        public void addPublicDependency(int i) {
            ensurePublicDependencyIsMutable();
            this.publicDependency_.addInt(i);
        }

        /* access modifiers changed from: private */
        public void addAllPublicDependency(Iterable<? extends Integer> iterable) {
            ensurePublicDependencyIsMutable();
            AbstractMessageLite.addAll(iterable, this.publicDependency_);
        }

        /* access modifiers changed from: private */
        public void clearPublicDependency() {
            this.publicDependency_ = emptyIntList();
        }

        public List<Integer> getWeakDependencyList() {
            return this.weakDependency_;
        }

        public int getWeakDependencyCount() {
            return this.weakDependency_.size();
        }

        public int getWeakDependency(int i) {
            return this.weakDependency_.getInt(i);
        }

        private void ensureWeakDependencyIsMutable() {
            if (!this.weakDependency_.isModifiable()) {
                this.weakDependency_ = GeneratedMessageLite.mutableCopy(this.weakDependency_);
            }
        }

        /* access modifiers changed from: private */
        public void setWeakDependency(int i, int i2) {
            ensureWeakDependencyIsMutable();
            this.weakDependency_.setInt(i, i2);
        }

        /* access modifiers changed from: private */
        public void addWeakDependency(int i) {
            ensureWeakDependencyIsMutable();
            this.weakDependency_.addInt(i);
        }

        /* access modifiers changed from: private */
        public void addAllWeakDependency(Iterable<? extends Integer> iterable) {
            ensureWeakDependencyIsMutable();
            AbstractMessageLite.addAll(iterable, this.weakDependency_);
        }

        /* access modifiers changed from: private */
        public void clearWeakDependency() {
            this.weakDependency_ = emptyIntList();
        }

        public List<DescriptorProto> getMessageTypeList() {
            return this.messageType_;
        }

        public List<? extends DescriptorProtoOrBuilder> getMessageTypeOrBuilderList() {
            return this.messageType_;
        }

        public int getMessageTypeCount() {
            return this.messageType_.size();
        }

        public DescriptorProto getMessageType(int i) {
            return (DescriptorProto) this.messageType_.get(i);
        }

        public DescriptorProtoOrBuilder getMessageTypeOrBuilder(int i) {
            return (DescriptorProtoOrBuilder) this.messageType_.get(i);
        }

        private void ensureMessageTypeIsMutable() {
            if (!this.messageType_.isModifiable()) {
                this.messageType_ = GeneratedMessageLite.mutableCopy(this.messageType_);
            }
        }

        /* access modifiers changed from: private */
        public void setMessageType(int i, DescriptorProto descriptorProto) {
            if (descriptorProto != null) {
                ensureMessageTypeIsMutable();
                this.messageType_.set(i, descriptorProto);
                return;
            }
            throw new NullPointerException();
        }

        /* access modifiers changed from: private */
        public void setMessageType(int i, DescriptorProto.Builder builder) {
            ensureMessageTypeIsMutable();
            this.messageType_.set(i, (DescriptorProto) builder.build());
        }

        /* access modifiers changed from: private */
        public void addMessageType(DescriptorProto descriptorProto) {
            if (descriptorProto != null) {
                ensureMessageTypeIsMutable();
                this.messageType_.add(descriptorProto);
                return;
            }
            throw new NullPointerException();
        }

        /* access modifiers changed from: private */
        public void addMessageType(int i, DescriptorProto descriptorProto) {
            if (descriptorProto != null) {
                ensureMessageTypeIsMutable();
                this.messageType_.add(i, descriptorProto);
                return;
            }
            throw new NullPointerException();
        }

        /* access modifiers changed from: private */
        public void addMessageType(DescriptorProto.Builder builder) {
            ensureMessageTypeIsMutable();
            this.messageType_.add((DescriptorProto) builder.build());
        }

        /* access modifiers changed from: private */
        public void addMessageType(int i, DescriptorProto.Builder builder) {
            ensureMessageTypeIsMutable();
            this.messageType_.add(i, (DescriptorProto) builder.build());
        }

        /* access modifiers changed from: private */
        public void addAllMessageType(Iterable<? extends DescriptorProto> iterable) {
            ensureMessageTypeIsMutable();
            AbstractMessageLite.addAll(iterable, this.messageType_);
        }

        /* access modifiers changed from: private */
        public void clearMessageType() {
            this.messageType_ = emptyProtobufList();
        }

        /* access modifiers changed from: private */
        public void removeMessageType(int i) {
            ensureMessageTypeIsMutable();
            this.messageType_.remove(i);
        }

        public List<EnumDescriptorProto> getEnumTypeList() {
            return this.enumType_;
        }

        public List<? extends EnumDescriptorProtoOrBuilder> getEnumTypeOrBuilderList() {
            return this.enumType_;
        }

        public int getEnumTypeCount() {
            return this.enumType_.size();
        }

        public EnumDescriptorProto getEnumType(int i) {
            return (EnumDescriptorProto) this.enumType_.get(i);
        }

        public EnumDescriptorProtoOrBuilder getEnumTypeOrBuilder(int i) {
            return (EnumDescriptorProtoOrBuilder) this.enumType_.get(i);
        }

        private void ensureEnumTypeIsMutable() {
            if (!this.enumType_.isModifiable()) {
                this.enumType_ = GeneratedMessageLite.mutableCopy(this.enumType_);
            }
        }

        /* access modifiers changed from: private */
        public void setEnumType(int i, EnumDescriptorProto enumDescriptorProto) {
            if (enumDescriptorProto != null) {
                ensureEnumTypeIsMutable();
                this.enumType_.set(i, enumDescriptorProto);
                return;
            }
            throw new NullPointerException();
        }

        /* access modifiers changed from: private */
        public void setEnumType(int i, EnumDescriptorProto.Builder builder) {
            ensureEnumTypeIsMutable();
            this.enumType_.set(i, (EnumDescriptorProto) builder.build());
        }

        /* access modifiers changed from: private */
        public void addEnumType(EnumDescriptorProto enumDescriptorProto) {
            if (enumDescriptorProto != null) {
                ensureEnumTypeIsMutable();
                this.enumType_.add(enumDescriptorProto);
                return;
            }
            throw new NullPointerException();
        }

        /* access modifiers changed from: private */
        public void addEnumType(int i, EnumDescriptorProto enumDescriptorProto) {
            if (enumDescriptorProto != null) {
                ensureEnumTypeIsMutable();
                this.enumType_.add(i, enumDescriptorProto);
                return;
            }
            throw new NullPointerException();
        }

        /* access modifiers changed from: private */
        public void addEnumType(EnumDescriptorProto.Builder builder) {
            ensureEnumTypeIsMutable();
            this.enumType_.add((EnumDescriptorProto) builder.build());
        }

        /* access modifiers changed from: private */
        public void addEnumType(int i, EnumDescriptorProto.Builder builder) {
            ensureEnumTypeIsMutable();
            this.enumType_.add(i, (EnumDescriptorProto) builder.build());
        }

        /* access modifiers changed from: private */
        public void addAllEnumType(Iterable<? extends EnumDescriptorProto> iterable) {
            ensureEnumTypeIsMutable();
            AbstractMessageLite.addAll(iterable, this.enumType_);
        }

        /* access modifiers changed from: private */
        public void clearEnumType() {
            this.enumType_ = emptyProtobufList();
        }

        /* access modifiers changed from: private */
        public void removeEnumType(int i) {
            ensureEnumTypeIsMutable();
            this.enumType_.remove(i);
        }

        public List<ServiceDescriptorProto> getServiceList() {
            return this.service_;
        }

        public List<? extends ServiceDescriptorProtoOrBuilder> getServiceOrBuilderList() {
            return this.service_;
        }

        public int getServiceCount() {
            return this.service_.size();
        }

        public ServiceDescriptorProto getService(int i) {
            return (ServiceDescriptorProto) this.service_.get(i);
        }

        public ServiceDescriptorProtoOrBuilder getServiceOrBuilder(int i) {
            return (ServiceDescriptorProtoOrBuilder) this.service_.get(i);
        }

        private void ensureServiceIsMutable() {
            if (!this.service_.isModifiable()) {
                this.service_ = GeneratedMessageLite.mutableCopy(this.service_);
            }
        }

        /* access modifiers changed from: private */
        public void setService(int i, ServiceDescriptorProto serviceDescriptorProto) {
            if (serviceDescriptorProto != null) {
                ensureServiceIsMutable();
                this.service_.set(i, serviceDescriptorProto);
                return;
            }
            throw new NullPointerException();
        }

        /* access modifiers changed from: private */
        public void setService(int i, ServiceDescriptorProto.Builder builder) {
            ensureServiceIsMutable();
            this.service_.set(i, (ServiceDescriptorProto) builder.build());
        }

        /* access modifiers changed from: private */
        public void addService(ServiceDescriptorProto serviceDescriptorProto) {
            if (serviceDescriptorProto != null) {
                ensureServiceIsMutable();
                this.service_.add(serviceDescriptorProto);
                return;
            }
            throw new NullPointerException();
        }

        /* access modifiers changed from: private */
        public void addService(int i, ServiceDescriptorProto serviceDescriptorProto) {
            if (serviceDescriptorProto != null) {
                ensureServiceIsMutable();
                this.service_.add(i, serviceDescriptorProto);
                return;
            }
            throw new NullPointerException();
        }

        /* access modifiers changed from: private */
        public void addService(ServiceDescriptorProto.Builder builder) {
            ensureServiceIsMutable();
            this.service_.add((ServiceDescriptorProto) builder.build());
        }

        /* access modifiers changed from: private */
        public void addService(int i, ServiceDescriptorProto.Builder builder) {
            ensureServiceIsMutable();
            this.service_.add(i, (ServiceDescriptorProto) builder.build());
        }

        /* access modifiers changed from: private */
        public void addAllService(Iterable<? extends ServiceDescriptorProto> iterable) {
            ensureServiceIsMutable();
            AbstractMessageLite.addAll(iterable, this.service_);
        }

        /* access modifiers changed from: private */
        public void clearService() {
            this.service_ = emptyProtobufList();
        }

        /* access modifiers changed from: private */
        public void removeService(int i) {
            ensureServiceIsMutable();
            this.service_.remove(i);
        }

        public List<FieldDescriptorProto> getExtensionList() {
            return this.extension_;
        }

        public List<? extends FieldDescriptorProtoOrBuilder> getExtensionOrBuilderList() {
            return this.extension_;
        }

        public int getExtensionCount() {
            return this.extension_.size();
        }

        public FieldDescriptorProto getExtension(int i) {
            return (FieldDescriptorProto) this.extension_.get(i);
        }

        public FieldDescriptorProtoOrBuilder getExtensionOrBuilder(int i) {
            return (FieldDescriptorProtoOrBuilder) this.extension_.get(i);
        }

        private void ensureExtensionIsMutable() {
            if (!this.extension_.isModifiable()) {
                this.extension_ = GeneratedMessageLite.mutableCopy(this.extension_);
            }
        }

        /* access modifiers changed from: private */
        public void setExtension(int i, FieldDescriptorProto fieldDescriptorProto) {
            if (fieldDescriptorProto != null) {
                ensureExtensionIsMutable();
                this.extension_.set(i, fieldDescriptorProto);
                return;
            }
            throw new NullPointerException();
        }

        /* access modifiers changed from: private */
        public void setExtension(int i, FieldDescriptorProto.Builder builder) {
            ensureExtensionIsMutable();
            this.extension_.set(i, (FieldDescriptorProto) builder.build());
        }

        /* access modifiers changed from: private */
        public void addExtension(FieldDescriptorProto fieldDescriptorProto) {
            if (fieldDescriptorProto != null) {
                ensureExtensionIsMutable();
                this.extension_.add(fieldDescriptorProto);
                return;
            }
            throw new NullPointerException();
        }

        /* access modifiers changed from: private */
        public void addExtension(int i, FieldDescriptorProto fieldDescriptorProto) {
            if (fieldDescriptorProto != null) {
                ensureExtensionIsMutable();
                this.extension_.add(i, fieldDescriptorProto);
                return;
            }
            throw new NullPointerException();
        }

        /* access modifiers changed from: private */
        public void addExtension(FieldDescriptorProto.Builder builder) {
            ensureExtensionIsMutable();
            this.extension_.add((FieldDescriptorProto) builder.build());
        }

        /* access modifiers changed from: private */
        public void addExtension(int i, FieldDescriptorProto.Builder builder) {
            ensureExtensionIsMutable();
            this.extension_.add(i, (FieldDescriptorProto) builder.build());
        }

        /* access modifiers changed from: private */
        public void addAllExtension(Iterable<? extends FieldDescriptorProto> iterable) {
            ensureExtensionIsMutable();
            AbstractMessageLite.addAll(iterable, this.extension_);
        }

        /* access modifiers changed from: private */
        public void clearExtension() {
            this.extension_ = emptyProtobufList();
        }

        /* access modifiers changed from: private */
        public void removeExtension(int i) {
            ensureExtensionIsMutable();
            this.extension_.remove(i);
        }

        public boolean hasOptions() {
            return (this.bitField0_ & 4) == 4;
        }

        public FileOptions getOptions() {
            FileOptions fileOptions = this.options_;
            return fileOptions == null ? FileOptions.getDefaultInstance() : fileOptions;
        }

        /* access modifiers changed from: private */
        public void setOptions(FileOptions fileOptions) {
            if (fileOptions != null) {
                this.options_ = fileOptions;
                this.bitField0_ |= 4;
                return;
            }
            throw new NullPointerException();
        }

        /* access modifiers changed from: private */
        public void setOptions(FileOptions.Builder builder) {
            this.options_ = (FileOptions) builder.build();
            this.bitField0_ |= 4;
        }

        /* access modifiers changed from: private */
        public void mergeOptions(FileOptions fileOptions) {
            FileOptions fileOptions2 = this.options_;
            if (fileOptions2 == null || fileOptions2 == FileOptions.getDefaultInstance()) {
                this.options_ = fileOptions;
            } else {
                this.options_ = (FileOptions) ((FileOptions.Builder) FileOptions.newBuilder(this.options_).mergeFrom(fileOptions)).buildPartial();
            }
            this.bitField0_ |= 4;
        }

        /* access modifiers changed from: private */
        public void clearOptions() {
            this.options_ = null;
            this.bitField0_ &= -5;
        }

        public boolean hasSourceCodeInfo() {
            return (this.bitField0_ & 8) == 8;
        }

        public SourceCodeInfo getSourceCodeInfo() {
            SourceCodeInfo sourceCodeInfo = this.sourceCodeInfo_;
            return sourceCodeInfo == null ? SourceCodeInfo.getDefaultInstance() : sourceCodeInfo;
        }

        /* access modifiers changed from: private */
        public void setSourceCodeInfo(SourceCodeInfo sourceCodeInfo) {
            if (sourceCodeInfo != null) {
                this.sourceCodeInfo_ = sourceCodeInfo;
                this.bitField0_ |= 8;
                return;
            }
            throw new NullPointerException();
        }

        /* access modifiers changed from: private */
        public void setSourceCodeInfo(SourceCodeInfo.Builder builder) {
            this.sourceCodeInfo_ = (SourceCodeInfo) builder.build();
            this.bitField0_ |= 8;
        }

        /* access modifiers changed from: private */
        public void mergeSourceCodeInfo(SourceCodeInfo sourceCodeInfo) {
            SourceCodeInfo sourceCodeInfo2 = this.sourceCodeInfo_;
            if (sourceCodeInfo2 == null || sourceCodeInfo2 == SourceCodeInfo.getDefaultInstance()) {
                this.sourceCodeInfo_ = sourceCodeInfo;
            } else {
                this.sourceCodeInfo_ = (SourceCodeInfo) ((SourceCodeInfo.Builder) SourceCodeInfo.newBuilder(this.sourceCodeInfo_).mergeFrom(sourceCodeInfo)).buildPartial();
            }
            this.bitField0_ |= 8;
        }

        /* access modifiers changed from: private */
        public void clearSourceCodeInfo() {
            this.sourceCodeInfo_ = null;
            this.bitField0_ &= -9;
        }

        public boolean hasSyntax() {
            return (this.bitField0_ & 16) == 16;
        }

        public String getSyntax() {
            return this.syntax_;
        }

        public ByteString getSyntaxBytes() {
            return ByteString.copyFromUtf8(this.syntax_);
        }

        /* access modifiers changed from: private */
        public void setSyntax(String str) {
            if (str != null) {
                this.bitField0_ |= 16;
                this.syntax_ = str;
                return;
            }
            throw new NullPointerException();
        }

        /* access modifiers changed from: private */
        public void clearSyntax() {
            this.bitField0_ &= -17;
            this.syntax_ = getDefaultInstance().getSyntax();
        }

        /* access modifiers changed from: private */
        public void setSyntaxBytes(ByteString byteString) {
            if (byteString != null) {
                this.bitField0_ |= 16;
                this.syntax_ = byteString.toStringUtf8();
                return;
            }
            throw new NullPointerException();
        }

        public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
            if ((this.bitField0_ & 1) == 1) {
                codedOutputStream.writeString(1, getName());
            }
            if ((this.bitField0_ & 2) == 2) {
                codedOutputStream.writeString(2, getPackage());
            }
            for (int i = 0; i < this.dependency_.size(); i++) {
                codedOutputStream.writeString(3, (String) this.dependency_.get(i));
            }
            for (int i2 = 0; i2 < this.messageType_.size(); i2++) {
                codedOutputStream.writeMessage(4, (MessageLite) this.messageType_.get(i2));
            }
            for (int i3 = 0; i3 < this.enumType_.size(); i3++) {
                codedOutputStream.writeMessage(5, (MessageLite) this.enumType_.get(i3));
            }
            for (int i4 = 0; i4 < this.service_.size(); i4++) {
                codedOutputStream.writeMessage(6, (MessageLite) this.service_.get(i4));
            }
            for (int i5 = 0; i5 < this.extension_.size(); i5++) {
                codedOutputStream.writeMessage(7, (MessageLite) this.extension_.get(i5));
            }
            if ((this.bitField0_ & 4) == 4) {
                codedOutputStream.writeMessage(8, getOptions());
            }
            if ((this.bitField0_ & 8) == 8) {
                codedOutputStream.writeMessage(9, getSourceCodeInfo());
            }
            for (int i6 = 0; i6 < this.publicDependency_.size(); i6++) {
                codedOutputStream.writeInt32(10, this.publicDependency_.getInt(i6));
            }
            for (int i7 = 0; i7 < this.weakDependency_.size(); i7++) {
                codedOutputStream.writeInt32(11, this.weakDependency_.getInt(i7));
            }
            if ((this.bitField0_ & 16) == 16) {
                codedOutputStream.writeString(12, getSyntax());
            }
            this.unknownFields.writeTo(codedOutputStream);
        }

        public int getSerializedSize() {
            int i = this.memoizedSerializedSize;
            if (i != -1) {
                return i;
            }
            int computeStringSize = (this.bitField0_ & 1) == 1 ? CodedOutputStream.computeStringSize(1, getName()) + 0 : 0;
            if ((this.bitField0_ & 2) == 2) {
                computeStringSize += CodedOutputStream.computeStringSize(2, getPackage());
            }
            int i2 = 0;
            for (int i3 = 0; i3 < this.dependency_.size(); i3++) {
                i2 += CodedOutputStream.computeStringSizeNoTag((String) this.dependency_.get(i3));
            }
            int size = computeStringSize + i2 + (getDependencyList().size() * 1);
            for (int i4 = 0; i4 < this.messageType_.size(); i4++) {
                size += CodedOutputStream.computeMessageSize(4, (MessageLite) this.messageType_.get(i4));
            }
            for (int i5 = 0; i5 < this.enumType_.size(); i5++) {
                size += CodedOutputStream.computeMessageSize(5, (MessageLite) this.enumType_.get(i5));
            }
            for (int i6 = 0; i6 < this.service_.size(); i6++) {
                size += CodedOutputStream.computeMessageSize(6, (MessageLite) this.service_.get(i6));
            }
            for (int i7 = 0; i7 < this.extension_.size(); i7++) {
                size += CodedOutputStream.computeMessageSize(7, (MessageLite) this.extension_.get(i7));
            }
            if ((this.bitField0_ & 4) == 4) {
                size += CodedOutputStream.computeMessageSize(8, getOptions());
            }
            if ((this.bitField0_ & 8) == 8) {
                size += CodedOutputStream.computeMessageSize(9, getSourceCodeInfo());
            }
            int i8 = 0;
            for (int i9 = 0; i9 < this.publicDependency_.size(); i9++) {
                i8 += CodedOutputStream.computeInt32SizeNoTag(this.publicDependency_.getInt(i9));
            }
            int size2 = size + i8 + (getPublicDependencyList().size() * 1);
            int i10 = 0;
            for (int i11 = 0; i11 < this.weakDependency_.size(); i11++) {
                i10 += CodedOutputStream.computeInt32SizeNoTag(this.weakDependency_.getInt(i11));
            }
            int size3 = size2 + i10 + (getWeakDependencyList().size() * 1);
            if ((this.bitField0_ & 16) == 16) {
                size3 += CodedOutputStream.computeStringSize(12, getSyntax());
            }
            int serializedSize = size3 + this.unknownFields.getSerializedSize();
            this.memoizedSerializedSize = serializedSize;
            return serializedSize;
        }

        public static FileDescriptorProto parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return (FileDescriptorProto) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
        }

        public static FileDescriptorProto parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (FileDescriptorProto) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
        }

        public static FileDescriptorProto parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return (FileDescriptorProto) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
        }

        public static FileDescriptorProto parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (FileDescriptorProto) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
        }

        public static FileDescriptorProto parseFrom(InputStream inputStream) throws IOException {
            return (FileDescriptorProto) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static FileDescriptorProto parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (FileDescriptorProto) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static FileDescriptorProto parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (FileDescriptorProto) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static FileDescriptorProto parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (FileDescriptorProto) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static FileDescriptorProto parseFrom(CodedInputStream codedInputStream) throws IOException {
            return (FileDescriptorProto) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
        }

        public static FileDescriptorProto parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (FileDescriptorProto) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
        }

        public static Builder newBuilder() {
            return (Builder) DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(FileDescriptorProto fileDescriptorProto) {
            return (Builder) ((Builder) DEFAULT_INSTANCE.toBuilder()).mergeFrom(fileDescriptorProto);
        }

        /* compiled from: com.google.firebase:protolite-well-known-types@@16.0.1 */
        public static final class Builder extends GeneratedMessageLite.Builder<FileDescriptorProto, Builder> implements FileDescriptorProtoOrBuilder {
            private Builder() {
                super(FileDescriptorProto.DEFAULT_INSTANCE);
            }

            public boolean hasName() {
                return ((FileDescriptorProto) this.instance).hasName();
            }

            public String getName() {
                return ((FileDescriptorProto) this.instance).getName();
            }

            public ByteString getNameBytes() {
                return ((FileDescriptorProto) this.instance).getNameBytes();
            }

            public Builder setName(String str) {
                copyOnWrite();
                ((FileDescriptorProto) this.instance).setName(str);
                return this;
            }

            public Builder clearName() {
                copyOnWrite();
                ((FileDescriptorProto) this.instance).clearName();
                return this;
            }

            public Builder setNameBytes(ByteString byteString) {
                copyOnWrite();
                ((FileDescriptorProto) this.instance).setNameBytes(byteString);
                return this;
            }

            public boolean hasPackage() {
                return ((FileDescriptorProto) this.instance).hasPackage();
            }

            public String getPackage() {
                return ((FileDescriptorProto) this.instance).getPackage();
            }

            public ByteString getPackageBytes() {
                return ((FileDescriptorProto) this.instance).getPackageBytes();
            }

            public Builder setPackage(String str) {
                copyOnWrite();
                ((FileDescriptorProto) this.instance).setPackage(str);
                return this;
            }

            public Builder clearPackage() {
                copyOnWrite();
                ((FileDescriptorProto) this.instance).clearPackage();
                return this;
            }

            public Builder setPackageBytes(ByteString byteString) {
                copyOnWrite();
                ((FileDescriptorProto) this.instance).setPackageBytes(byteString);
                return this;
            }

            public List<String> getDependencyList() {
                return Collections.unmodifiableList(((FileDescriptorProto) this.instance).getDependencyList());
            }

            public int getDependencyCount() {
                return ((FileDescriptorProto) this.instance).getDependencyCount();
            }

            public String getDependency(int i) {
                return ((FileDescriptorProto) this.instance).getDependency(i);
            }

            public ByteString getDependencyBytes(int i) {
                return ((FileDescriptorProto) this.instance).getDependencyBytes(i);
            }

            public Builder setDependency(int i, String str) {
                copyOnWrite();
                ((FileDescriptorProto) this.instance).setDependency(i, str);
                return this;
            }

            public Builder addDependency(String str) {
                copyOnWrite();
                ((FileDescriptorProto) this.instance).addDependency(str);
                return this;
            }

            public Builder addAllDependency(Iterable<String> iterable) {
                copyOnWrite();
                ((FileDescriptorProto) this.instance).addAllDependency(iterable);
                return this;
            }

            public Builder clearDependency() {
                copyOnWrite();
                ((FileDescriptorProto) this.instance).clearDependency();
                return this;
            }

            public Builder addDependencyBytes(ByteString byteString) {
                copyOnWrite();
                ((FileDescriptorProto) this.instance).addDependencyBytes(byteString);
                return this;
            }

            public List<Integer> getPublicDependencyList() {
                return Collections.unmodifiableList(((FileDescriptorProto) this.instance).getPublicDependencyList());
            }

            public int getPublicDependencyCount() {
                return ((FileDescriptorProto) this.instance).getPublicDependencyCount();
            }

            public int getPublicDependency(int i) {
                return ((FileDescriptorProto) this.instance).getPublicDependency(i);
            }

            public Builder setPublicDependency(int i, int i2) {
                copyOnWrite();
                ((FileDescriptorProto) this.instance).setPublicDependency(i, i2);
                return this;
            }

            public Builder addPublicDependency(int i) {
                copyOnWrite();
                ((FileDescriptorProto) this.instance).addPublicDependency(i);
                return this;
            }

            public Builder addAllPublicDependency(Iterable<? extends Integer> iterable) {
                copyOnWrite();
                ((FileDescriptorProto) this.instance).addAllPublicDependency(iterable);
                return this;
            }

            public Builder clearPublicDependency() {
                copyOnWrite();
                ((FileDescriptorProto) this.instance).clearPublicDependency();
                return this;
            }

            public List<Integer> getWeakDependencyList() {
                return Collections.unmodifiableList(((FileDescriptorProto) this.instance).getWeakDependencyList());
            }

            public int getWeakDependencyCount() {
                return ((FileDescriptorProto) this.instance).getWeakDependencyCount();
            }

            public int getWeakDependency(int i) {
                return ((FileDescriptorProto) this.instance).getWeakDependency(i);
            }

            public Builder setWeakDependency(int i, int i2) {
                copyOnWrite();
                ((FileDescriptorProto) this.instance).setWeakDependency(i, i2);
                return this;
            }

            public Builder addWeakDependency(int i) {
                copyOnWrite();
                ((FileDescriptorProto) this.instance).addWeakDependency(i);
                return this;
            }

            public Builder addAllWeakDependency(Iterable<? extends Integer> iterable) {
                copyOnWrite();
                ((FileDescriptorProto) this.instance).addAllWeakDependency(iterable);
                return this;
            }

            public Builder clearWeakDependency() {
                copyOnWrite();
                ((FileDescriptorProto) this.instance).clearWeakDependency();
                return this;
            }

            public List<DescriptorProto> getMessageTypeList() {
                return Collections.unmodifiableList(((FileDescriptorProto) this.instance).getMessageTypeList());
            }

            public int getMessageTypeCount() {
                return ((FileDescriptorProto) this.instance).getMessageTypeCount();
            }

            public DescriptorProto getMessageType(int i) {
                return ((FileDescriptorProto) this.instance).getMessageType(i);
            }

            public Builder setMessageType(int i, DescriptorProto descriptorProto) {
                copyOnWrite();
                ((FileDescriptorProto) this.instance).setMessageType(i, descriptorProto);
                return this;
            }

            public Builder setMessageType(int i, DescriptorProto.Builder builder) {
                copyOnWrite();
                ((FileDescriptorProto) this.instance).setMessageType(i, builder);
                return this;
            }

            public Builder addMessageType(DescriptorProto descriptorProto) {
                copyOnWrite();
                ((FileDescriptorProto) this.instance).addMessageType(descriptorProto);
                return this;
            }

            public Builder addMessageType(int i, DescriptorProto descriptorProto) {
                copyOnWrite();
                ((FileDescriptorProto) this.instance).addMessageType(i, descriptorProto);
                return this;
            }

            public Builder addMessageType(DescriptorProto.Builder builder) {
                copyOnWrite();
                ((FileDescriptorProto) this.instance).addMessageType(builder);
                return this;
            }

            public Builder addMessageType(int i, DescriptorProto.Builder builder) {
                copyOnWrite();
                ((FileDescriptorProto) this.instance).addMessageType(i, builder);
                return this;
            }

            public Builder addAllMessageType(Iterable<? extends DescriptorProto> iterable) {
                copyOnWrite();
                ((FileDescriptorProto) this.instance).addAllMessageType(iterable);
                return this;
            }

            public Builder clearMessageType() {
                copyOnWrite();
                ((FileDescriptorProto) this.instance).clearMessageType();
                return this;
            }

            public Builder removeMessageType(int i) {
                copyOnWrite();
                ((FileDescriptorProto) this.instance).removeMessageType(i);
                return this;
            }

            public List<EnumDescriptorProto> getEnumTypeList() {
                return Collections.unmodifiableList(((FileDescriptorProto) this.instance).getEnumTypeList());
            }

            public int getEnumTypeCount() {
                return ((FileDescriptorProto) this.instance).getEnumTypeCount();
            }

            public EnumDescriptorProto getEnumType(int i) {
                return ((FileDescriptorProto) this.instance).getEnumType(i);
            }

            public Builder setEnumType(int i, EnumDescriptorProto enumDescriptorProto) {
                copyOnWrite();
                ((FileDescriptorProto) this.instance).setEnumType(i, enumDescriptorProto);
                return this;
            }

            public Builder setEnumType(int i, EnumDescriptorProto.Builder builder) {
                copyOnWrite();
                ((FileDescriptorProto) this.instance).setEnumType(i, builder);
                return this;
            }

            public Builder addEnumType(EnumDescriptorProto enumDescriptorProto) {
                copyOnWrite();
                ((FileDescriptorProto) this.instance).addEnumType(enumDescriptorProto);
                return this;
            }

            public Builder addEnumType(int i, EnumDescriptorProto enumDescriptorProto) {
                copyOnWrite();
                ((FileDescriptorProto) this.instance).addEnumType(i, enumDescriptorProto);
                return this;
            }

            public Builder addEnumType(EnumDescriptorProto.Builder builder) {
                copyOnWrite();
                ((FileDescriptorProto) this.instance).addEnumType(builder);
                return this;
            }

            public Builder addEnumType(int i, EnumDescriptorProto.Builder builder) {
                copyOnWrite();
                ((FileDescriptorProto) this.instance).addEnumType(i, builder);
                return this;
            }

            public Builder addAllEnumType(Iterable<? extends EnumDescriptorProto> iterable) {
                copyOnWrite();
                ((FileDescriptorProto) this.instance).addAllEnumType(iterable);
                return this;
            }

            public Builder clearEnumType() {
                copyOnWrite();
                ((FileDescriptorProto) this.instance).clearEnumType();
                return this;
            }

            public Builder removeEnumType(int i) {
                copyOnWrite();
                ((FileDescriptorProto) this.instance).removeEnumType(i);
                return this;
            }

            public List<ServiceDescriptorProto> getServiceList() {
                return Collections.unmodifiableList(((FileDescriptorProto) this.instance).getServiceList());
            }

            public int getServiceCount() {
                return ((FileDescriptorProto) this.instance).getServiceCount();
            }

            public ServiceDescriptorProto getService(int i) {
                return ((FileDescriptorProto) this.instance).getService(i);
            }

            public Builder setService(int i, ServiceDescriptorProto serviceDescriptorProto) {
                copyOnWrite();
                ((FileDescriptorProto) this.instance).setService(i, serviceDescriptorProto);
                return this;
            }

            public Builder setService(int i, ServiceDescriptorProto.Builder builder) {
                copyOnWrite();
                ((FileDescriptorProto) this.instance).setService(i, builder);
                return this;
            }

            public Builder addService(ServiceDescriptorProto serviceDescriptorProto) {
                copyOnWrite();
                ((FileDescriptorProto) this.instance).addService(serviceDescriptorProto);
                return this;
            }

            public Builder addService(int i, ServiceDescriptorProto serviceDescriptorProto) {
                copyOnWrite();
                ((FileDescriptorProto) this.instance).addService(i, serviceDescriptorProto);
                return this;
            }

            public Builder addService(ServiceDescriptorProto.Builder builder) {
                copyOnWrite();
                ((FileDescriptorProto) this.instance).addService(builder);
                return this;
            }

            public Builder addService(int i, ServiceDescriptorProto.Builder builder) {
                copyOnWrite();
                ((FileDescriptorProto) this.instance).addService(i, builder);
                return this;
            }

            public Builder addAllService(Iterable<? extends ServiceDescriptorProto> iterable) {
                copyOnWrite();
                ((FileDescriptorProto) this.instance).addAllService(iterable);
                return this;
            }

            public Builder clearService() {
                copyOnWrite();
                ((FileDescriptorProto) this.instance).clearService();
                return this;
            }

            public Builder removeService(int i) {
                copyOnWrite();
                ((FileDescriptorProto) this.instance).removeService(i);
                return this;
            }

            public List<FieldDescriptorProto> getExtensionList() {
                return Collections.unmodifiableList(((FileDescriptorProto) this.instance).getExtensionList());
            }

            public int getExtensionCount() {
                return ((FileDescriptorProto) this.instance).getExtensionCount();
            }

            public FieldDescriptorProto getExtension(int i) {
                return ((FileDescriptorProto) this.instance).getExtension(i);
            }

            public Builder setExtension(int i, FieldDescriptorProto fieldDescriptorProto) {
                copyOnWrite();
                ((FileDescriptorProto) this.instance).setExtension(i, fieldDescriptorProto);
                return this;
            }

            public Builder setExtension(int i, FieldDescriptorProto.Builder builder) {
                copyOnWrite();
                ((FileDescriptorProto) this.instance).setExtension(i, builder);
                return this;
            }

            public Builder addExtension(FieldDescriptorProto fieldDescriptorProto) {
                copyOnWrite();
                ((FileDescriptorProto) this.instance).addExtension(fieldDescriptorProto);
                return this;
            }

            public Builder addExtension(int i, FieldDescriptorProto fieldDescriptorProto) {
                copyOnWrite();
                ((FileDescriptorProto) this.instance).addExtension(i, fieldDescriptorProto);
                return this;
            }

            public Builder addExtension(FieldDescriptorProto.Builder builder) {
                copyOnWrite();
                ((FileDescriptorProto) this.instance).addExtension(builder);
                return this;
            }

            public Builder addExtension(int i, FieldDescriptorProto.Builder builder) {
                copyOnWrite();
                ((FileDescriptorProto) this.instance).addExtension(i, builder);
                return this;
            }

            public Builder addAllExtension(Iterable<? extends FieldDescriptorProto> iterable) {
                copyOnWrite();
                ((FileDescriptorProto) this.instance).addAllExtension(iterable);
                return this;
            }

            public Builder clearExtension() {
                copyOnWrite();
                ((FileDescriptorProto) this.instance).clearExtension();
                return this;
            }

            public Builder removeExtension(int i) {
                copyOnWrite();
                ((FileDescriptorProto) this.instance).removeExtension(i);
                return this;
            }

            public boolean hasOptions() {
                return ((FileDescriptorProto) this.instance).hasOptions();
            }

            public FileOptions getOptions() {
                return ((FileDescriptorProto) this.instance).getOptions();
            }

            public Builder setOptions(FileOptions fileOptions) {
                copyOnWrite();
                ((FileDescriptorProto) this.instance).setOptions(fileOptions);
                return this;
            }

            public Builder setOptions(FileOptions.Builder builder) {
                copyOnWrite();
                ((FileDescriptorProto) this.instance).setOptions(builder);
                return this;
            }

            public Builder mergeOptions(FileOptions fileOptions) {
                copyOnWrite();
                ((FileDescriptorProto) this.instance).mergeOptions(fileOptions);
                return this;
            }

            public Builder clearOptions() {
                copyOnWrite();
                ((FileDescriptorProto) this.instance).clearOptions();
                return this;
            }

            public boolean hasSourceCodeInfo() {
                return ((FileDescriptorProto) this.instance).hasSourceCodeInfo();
            }

            public SourceCodeInfo getSourceCodeInfo() {
                return ((FileDescriptorProto) this.instance).getSourceCodeInfo();
            }

            public Builder setSourceCodeInfo(SourceCodeInfo sourceCodeInfo) {
                copyOnWrite();
                ((FileDescriptorProto) this.instance).setSourceCodeInfo(sourceCodeInfo);
                return this;
            }

            public Builder setSourceCodeInfo(SourceCodeInfo.Builder builder) {
                copyOnWrite();
                ((FileDescriptorProto) this.instance).setSourceCodeInfo(builder);
                return this;
            }

            public Builder mergeSourceCodeInfo(SourceCodeInfo sourceCodeInfo) {
                copyOnWrite();
                ((FileDescriptorProto) this.instance).mergeSourceCodeInfo(sourceCodeInfo);
                return this;
            }

            public Builder clearSourceCodeInfo() {
                copyOnWrite();
                ((FileDescriptorProto) this.instance).clearSourceCodeInfo();
                return this;
            }

            public boolean hasSyntax() {
                return ((FileDescriptorProto) this.instance).hasSyntax();
            }

            public String getSyntax() {
                return ((FileDescriptorProto) this.instance).getSyntax();
            }

            public ByteString getSyntaxBytes() {
                return ((FileDescriptorProto) this.instance).getSyntaxBytes();
            }

            public Builder setSyntax(String str) {
                copyOnWrite();
                ((FileDescriptorProto) this.instance).setSyntax(str);
                return this;
            }

            public Builder clearSyntax() {
                copyOnWrite();
                ((FileDescriptorProto) this.instance).clearSyntax();
                return this;
            }

            public Builder setSyntaxBytes(ByteString byteString) {
                copyOnWrite();
                ((FileDescriptorProto) this.instance).setSyntaxBytes(byteString);
                return this;
            }
        }

        /* access modifiers changed from: protected */
        public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            boolean z = false;
            switch (methodToInvoke) {
                case NEW_MUTABLE_INSTANCE:
                    return new FileDescriptorProto();
                case IS_INITIALIZED:
                    byte b = this.memoizedIsInitialized;
                    if (b == 1) {
                        return DEFAULT_INSTANCE;
                    }
                    if (b == 0) {
                        return null;
                    }
                    boolean booleanValue = ((Boolean) obj).booleanValue();
                    for (int i = 0; i < getMessageTypeCount(); i++) {
                        if (!getMessageType(i).isInitialized()) {
                            if (booleanValue) {
                                this.memoizedIsInitialized = 0;
                            }
                            return null;
                        }
                    }
                    for (int i2 = 0; i2 < getEnumTypeCount(); i2++) {
                        if (!getEnumType(i2).isInitialized()) {
                            if (booleanValue) {
                                this.memoizedIsInitialized = 0;
                            }
                            return null;
                        }
                    }
                    for (int i3 = 0; i3 < getServiceCount(); i3++) {
                        if (!getService(i3).isInitialized()) {
                            if (booleanValue) {
                                this.memoizedIsInitialized = 0;
                            }
                            return null;
                        }
                    }
                    for (int i4 = 0; i4 < getExtensionCount(); i4++) {
                        if (!getExtension(i4).isInitialized()) {
                            if (booleanValue) {
                                this.memoizedIsInitialized = 0;
                            }
                            return null;
                        }
                    }
                    if (!hasOptions() || getOptions().isInitialized()) {
                        if (booleanValue) {
                            this.memoizedIsInitialized = 1;
                        }
                        return DEFAULT_INSTANCE;
                    }
                    if (booleanValue) {
                        this.memoizedIsInitialized = 0;
                    }
                    return null;
                case MAKE_IMMUTABLE:
                    this.dependency_.makeImmutable();
                    this.publicDependency_.makeImmutable();
                    this.weakDependency_.makeImmutable();
                    this.messageType_.makeImmutable();
                    this.enumType_.makeImmutable();
                    this.service_.makeImmutable();
                    this.extension_.makeImmutable();
                    return null;
                case NEW_BUILDER:
                    return new Builder();
                case VISIT:
                    GeneratedMessageLite.Visitor visitor = (GeneratedMessageLite.Visitor) obj;
                    FileDescriptorProto fileDescriptorProto = (FileDescriptorProto) obj2;
                    this.name_ = visitor.visitString(hasName(), this.name_, fileDescriptorProto.hasName(), fileDescriptorProto.name_);
                    this.package_ = visitor.visitString(hasPackage(), this.package_, fileDescriptorProto.hasPackage(), fileDescriptorProto.package_);
                    this.dependency_ = visitor.visitList(this.dependency_, fileDescriptorProto.dependency_);
                    this.publicDependency_ = visitor.visitIntList(this.publicDependency_, fileDescriptorProto.publicDependency_);
                    this.weakDependency_ = visitor.visitIntList(this.weakDependency_, fileDescriptorProto.weakDependency_);
                    this.messageType_ = visitor.visitList(this.messageType_, fileDescriptorProto.messageType_);
                    this.enumType_ = visitor.visitList(this.enumType_, fileDescriptorProto.enumType_);
                    this.service_ = visitor.visitList(this.service_, fileDescriptorProto.service_);
                    this.extension_ = visitor.visitList(this.extension_, fileDescriptorProto.extension_);
                    this.options_ = (FileOptions) visitor.visitMessage(this.options_, fileDescriptorProto.options_);
                    this.sourceCodeInfo_ = (SourceCodeInfo) visitor.visitMessage(this.sourceCodeInfo_, fileDescriptorProto.sourceCodeInfo_);
                    this.syntax_ = visitor.visitString(hasSyntax(), this.syntax_, fileDescriptorProto.hasSyntax(), fileDescriptorProto.syntax_);
                    if (visitor == GeneratedMessageLite.MergeFromVisitor.INSTANCE) {
                        this.bitField0_ |= fileDescriptorProto.bitField0_;
                    }
                    return this;
                case MERGE_FROM_STREAM:
                    CodedInputStream codedInputStream = (CodedInputStream) obj;
                    ExtensionRegistryLite extensionRegistryLite = (ExtensionRegistryLite) obj2;
                    while (!z) {
                        try {
                            int readTag = codedInputStream.readTag();
                            switch (readTag) {
                                case 0:
                                    z = true;
                                    break;
                                case 10:
                                    String readString = codedInputStream.readString();
                                    this.bitField0_ |= 1;
                                    this.name_ = readString;
                                    break;
                                case 18:
                                    String readString2 = codedInputStream.readString();
                                    this.bitField0_ |= 2;
                                    this.package_ = readString2;
                                    break;
                                case 26:
                                    String readString3 = codedInputStream.readString();
                                    if (!this.dependency_.isModifiable()) {
                                        this.dependency_ = GeneratedMessageLite.mutableCopy(this.dependency_);
                                    }
                                    this.dependency_.add(readString3);
                                    break;
                                case 34:
                                    if (!this.messageType_.isModifiable()) {
                                        this.messageType_ = GeneratedMessageLite.mutableCopy(this.messageType_);
                                    }
                                    this.messageType_.add((DescriptorProto) codedInputStream.readMessage(DescriptorProto.parser(), extensionRegistryLite));
                                    break;
                                case 42:
                                    if (!this.enumType_.isModifiable()) {
                                        this.enumType_ = GeneratedMessageLite.mutableCopy(this.enumType_);
                                    }
                                    this.enumType_.add((EnumDescriptorProto) codedInputStream.readMessage(EnumDescriptorProto.parser(), extensionRegistryLite));
                                    break;
                                case 50:
                                    if (!this.service_.isModifiable()) {
                                        this.service_ = GeneratedMessageLite.mutableCopy(this.service_);
                                    }
                                    this.service_.add((ServiceDescriptorProto) codedInputStream.readMessage(ServiceDescriptorProto.parser(), extensionRegistryLite));
                                    break;
                                case 58:
                                    if (!this.extension_.isModifiable()) {
                                        this.extension_ = GeneratedMessageLite.mutableCopy(this.extension_);
                                    }
                                    this.extension_.add((FieldDescriptorProto) codedInputStream.readMessage(FieldDescriptorProto.parser(), extensionRegistryLite));
                                    break;
                                case 66:
                                    FileOptions.Builder builder = (this.bitField0_ & 4) == 4 ? (FileOptions.Builder) this.options_.toBuilder() : null;
                                    this.options_ = (FileOptions) codedInputStream.readMessage(FileOptions.parser(), extensionRegistryLite);
                                    if (builder != null) {
                                        builder.mergeFrom(this.options_);
                                        this.options_ = (FileOptions) builder.buildPartial();
                                    }
                                    this.bitField0_ |= 4;
                                    break;
                                case 74:
                                    SourceCodeInfo.Builder builder2 = (this.bitField0_ & 8) == 8 ? (SourceCodeInfo.Builder) this.sourceCodeInfo_.toBuilder() : null;
                                    this.sourceCodeInfo_ = (SourceCodeInfo) codedInputStream.readMessage(SourceCodeInfo.parser(), extensionRegistryLite);
                                    if (builder2 != null) {
                                        builder2.mergeFrom(this.sourceCodeInfo_);
                                        this.sourceCodeInfo_ = (SourceCodeInfo) builder2.buildPartial();
                                    }
                                    this.bitField0_ |= 8;
                                    break;
                                case 80:
                                    if (!this.publicDependency_.isModifiable()) {
                                        this.publicDependency_ = GeneratedMessageLite.mutableCopy(this.publicDependency_);
                                    }
                                    this.publicDependency_.addInt(codedInputStream.readInt32());
                                    break;
                                case 82:
                                    int pushLimit = codedInputStream.pushLimit(codedInputStream.readRawVarint32());
                                    if (!this.publicDependency_.isModifiable() && codedInputStream.getBytesUntilLimit() > 0) {
                                        this.publicDependency_ = GeneratedMessageLite.mutableCopy(this.publicDependency_);
                                    }
                                    while (codedInputStream.getBytesUntilLimit() > 0) {
                                        this.publicDependency_.addInt(codedInputStream.readInt32());
                                    }
                                    codedInputStream.popLimit(pushLimit);
                                    break;
                                case 88:
                                    if (!this.weakDependency_.isModifiable()) {
                                        this.weakDependency_ = GeneratedMessageLite.mutableCopy(this.weakDependency_);
                                    }
                                    this.weakDependency_.addInt(codedInputStream.readInt32());
                                    break;
                                case 90:
                                    int pushLimit2 = codedInputStream.pushLimit(codedInputStream.readRawVarint32());
                                    if (!this.weakDependency_.isModifiable() && codedInputStream.getBytesUntilLimit() > 0) {
                                        this.weakDependency_ = GeneratedMessageLite.mutableCopy(this.weakDependency_);
                                    }
                                    while (codedInputStream.getBytesUntilLimit() > 0) {
                                        this.weakDependency_.addInt(codedInputStream.readInt32());
                                    }
                                    codedInputStream.popLimit(pushLimit2);
                                    break;
                                case 98:
                                    String readString4 = codedInputStream.readString();
                                    this.bitField0_ |= 16;
                                    this.syntax_ = readString4;
                                    break;
                                default:
                                    if (parseUnknownField(readTag, codedInputStream)) {
                                        break;
                                    }
                                    z = true;
                                    break;
                            }
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
                        synchronized (FileDescriptorProto.class) {
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

        public static FileDescriptorProto getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<FileDescriptorProto> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }
    }

    /* compiled from: com.google.firebase:protolite-well-known-types@@16.0.1 */
    public static final class DescriptorProto extends GeneratedMessageLite<DescriptorProto, Builder> implements DescriptorProtoOrBuilder {
        /* access modifiers changed from: private */
        public static final DescriptorProto DEFAULT_INSTANCE = new DescriptorProto();
        public static final int ENUM_TYPE_FIELD_NUMBER = 4;
        public static final int EXTENSION_FIELD_NUMBER = 6;
        public static final int EXTENSION_RANGE_FIELD_NUMBER = 5;
        public static final int FIELD_FIELD_NUMBER = 2;
        public static final int NAME_FIELD_NUMBER = 1;
        public static final int NESTED_TYPE_FIELD_NUMBER = 3;
        public static final int ONEOF_DECL_FIELD_NUMBER = 8;
        public static final int OPTIONS_FIELD_NUMBER = 7;
        private static volatile Parser<DescriptorProto> PARSER = null;
        public static final int RESERVED_NAME_FIELD_NUMBER = 10;
        public static final int RESERVED_RANGE_FIELD_NUMBER = 9;
        private int bitField0_;
        private Internal.ProtobufList<EnumDescriptorProto> enumType_ = emptyProtobufList();
        private Internal.ProtobufList<ExtensionRange> extensionRange_ = emptyProtobufList();
        private Internal.ProtobufList<FieldDescriptorProto> extension_ = emptyProtobufList();
        private Internal.ProtobufList<FieldDescriptorProto> field_ = emptyProtobufList();
        private byte memoizedIsInitialized = -1;
        private String name_ = "";
        private Internal.ProtobufList<DescriptorProto> nestedType_ = emptyProtobufList();
        private Internal.ProtobufList<OneofDescriptorProto> oneofDecl_ = emptyProtobufList();
        private MessageOptions options_;
        private Internal.ProtobufList<String> reservedName_ = GeneratedMessageLite.emptyProtobufList();
        private Internal.ProtobufList<ReservedRange> reservedRange_ = emptyProtobufList();

        /* compiled from: com.google.firebase:protolite-well-known-types@@16.0.1 */
        public interface ExtensionRangeOrBuilder extends MessageLiteOrBuilder {
            int getEnd();

            ExtensionRangeOptions getOptions();

            int getStart();

            boolean hasEnd();

            boolean hasOptions();

            boolean hasStart();
        }

        /* compiled from: com.google.firebase:protolite-well-known-types@@16.0.1 */
        public interface ReservedRangeOrBuilder extends MessageLiteOrBuilder {
            int getEnd();

            int getStart();

            boolean hasEnd();

            boolean hasStart();
        }

        private DescriptorProto() {
        }

        /* compiled from: com.google.firebase:protolite-well-known-types@@16.0.1 */
        public static final class ExtensionRange extends GeneratedMessageLite<ExtensionRange, Builder> implements ExtensionRangeOrBuilder {
            /* access modifiers changed from: private */
            public static final ExtensionRange DEFAULT_INSTANCE = new ExtensionRange();
            public static final int END_FIELD_NUMBER = 2;
            public static final int OPTIONS_FIELD_NUMBER = 3;
            private static volatile Parser<ExtensionRange> PARSER = null;
            public static final int START_FIELD_NUMBER = 1;
            private int bitField0_;
            private int end_;
            private byte memoizedIsInitialized = -1;
            private ExtensionRangeOptions options_;
            private int start_;

            private ExtensionRange() {
            }

            public boolean hasStart() {
                return (this.bitField0_ & 1) == 1;
            }

            public int getStart() {
                return this.start_;
            }

            /* access modifiers changed from: private */
            public void setStart(int i) {
                this.bitField0_ |= 1;
                this.start_ = i;
            }

            /* access modifiers changed from: private */
            public void clearStart() {
                this.bitField0_ &= -2;
                this.start_ = 0;
            }

            public boolean hasEnd() {
                return (this.bitField0_ & 2) == 2;
            }

            public int getEnd() {
                return this.end_;
            }

            /* access modifiers changed from: private */
            public void setEnd(int i) {
                this.bitField0_ |= 2;
                this.end_ = i;
            }

            /* access modifiers changed from: private */
            public void clearEnd() {
                this.bitField0_ &= -3;
                this.end_ = 0;
            }

            public boolean hasOptions() {
                return (this.bitField0_ & 4) == 4;
            }

            public ExtensionRangeOptions getOptions() {
                ExtensionRangeOptions extensionRangeOptions = this.options_;
                return extensionRangeOptions == null ? ExtensionRangeOptions.getDefaultInstance() : extensionRangeOptions;
            }

            /* access modifiers changed from: private */
            public void setOptions(ExtensionRangeOptions extensionRangeOptions) {
                if (extensionRangeOptions != null) {
                    this.options_ = extensionRangeOptions;
                    this.bitField0_ |= 4;
                    return;
                }
                throw new NullPointerException();
            }

            /* access modifiers changed from: private */
            public void setOptions(ExtensionRangeOptions.Builder builder) {
                this.options_ = (ExtensionRangeOptions) builder.build();
                this.bitField0_ |= 4;
            }

            /* access modifiers changed from: private */
            public void mergeOptions(ExtensionRangeOptions extensionRangeOptions) {
                ExtensionRangeOptions extensionRangeOptions2 = this.options_;
                if (extensionRangeOptions2 == null || extensionRangeOptions2 == ExtensionRangeOptions.getDefaultInstance()) {
                    this.options_ = extensionRangeOptions;
                } else {
                    this.options_ = (ExtensionRangeOptions) ((ExtensionRangeOptions.Builder) ExtensionRangeOptions.newBuilder(this.options_).mergeFrom(extensionRangeOptions)).buildPartial();
                }
                this.bitField0_ |= 4;
            }

            /* access modifiers changed from: private */
            public void clearOptions() {
                this.options_ = null;
                this.bitField0_ &= -5;
            }

            public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
                if ((this.bitField0_ & 1) == 1) {
                    codedOutputStream.writeInt32(1, this.start_);
                }
                if ((this.bitField0_ & 2) == 2) {
                    codedOutputStream.writeInt32(2, this.end_);
                }
                if ((this.bitField0_ & 4) == 4) {
                    codedOutputStream.writeMessage(3, getOptions());
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
                    i2 = 0 + CodedOutputStream.computeInt32Size(1, this.start_);
                }
                if ((this.bitField0_ & 2) == 2) {
                    i2 += CodedOutputStream.computeInt32Size(2, this.end_);
                }
                if ((this.bitField0_ & 4) == 4) {
                    i2 += CodedOutputStream.computeMessageSize(3, getOptions());
                }
                int serializedSize = i2 + this.unknownFields.getSerializedSize();
                this.memoizedSerializedSize = serializedSize;
                return serializedSize;
            }

            public static ExtensionRange parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
                return (ExtensionRange) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
            }

            public static ExtensionRange parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return (ExtensionRange) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
            }

            public static ExtensionRange parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
                return (ExtensionRange) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
            }

            public static ExtensionRange parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return (ExtensionRange) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
            }

            public static ExtensionRange parseFrom(InputStream inputStream) throws IOException {
                return (ExtensionRange) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
            }

            public static ExtensionRange parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                return (ExtensionRange) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
            }

            public static ExtensionRange parseDelimitedFrom(InputStream inputStream) throws IOException {
                return (ExtensionRange) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
            }

            public static ExtensionRange parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                return (ExtensionRange) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
            }

            public static ExtensionRange parseFrom(CodedInputStream codedInputStream) throws IOException {
                return (ExtensionRange) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
            }

            public static ExtensionRange parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                return (ExtensionRange) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
            }

            public static Builder newBuilder() {
                return (Builder) DEFAULT_INSTANCE.toBuilder();
            }

            public static Builder newBuilder(ExtensionRange extensionRange) {
                return (Builder) ((Builder) DEFAULT_INSTANCE.toBuilder()).mergeFrom(extensionRange);
            }

            /* compiled from: com.google.firebase:protolite-well-known-types@@16.0.1 */
            public static final class Builder extends GeneratedMessageLite.Builder<ExtensionRange, Builder> implements ExtensionRangeOrBuilder {
                private Builder() {
                    super(ExtensionRange.DEFAULT_INSTANCE);
                }

                public boolean hasStart() {
                    return ((ExtensionRange) this.instance).hasStart();
                }

                public int getStart() {
                    return ((ExtensionRange) this.instance).getStart();
                }

                public Builder setStart(int i) {
                    copyOnWrite();
                    ((ExtensionRange) this.instance).setStart(i);
                    return this;
                }

                public Builder clearStart() {
                    copyOnWrite();
                    ((ExtensionRange) this.instance).clearStart();
                    return this;
                }

                public boolean hasEnd() {
                    return ((ExtensionRange) this.instance).hasEnd();
                }

                public int getEnd() {
                    return ((ExtensionRange) this.instance).getEnd();
                }

                public Builder setEnd(int i) {
                    copyOnWrite();
                    ((ExtensionRange) this.instance).setEnd(i);
                    return this;
                }

                public Builder clearEnd() {
                    copyOnWrite();
                    ((ExtensionRange) this.instance).clearEnd();
                    return this;
                }

                public boolean hasOptions() {
                    return ((ExtensionRange) this.instance).hasOptions();
                }

                public ExtensionRangeOptions getOptions() {
                    return ((ExtensionRange) this.instance).getOptions();
                }

                public Builder setOptions(ExtensionRangeOptions extensionRangeOptions) {
                    copyOnWrite();
                    ((ExtensionRange) this.instance).setOptions(extensionRangeOptions);
                    return this;
                }

                public Builder setOptions(ExtensionRangeOptions.Builder builder) {
                    copyOnWrite();
                    ((ExtensionRange) this.instance).setOptions(builder);
                    return this;
                }

                public Builder mergeOptions(ExtensionRangeOptions extensionRangeOptions) {
                    copyOnWrite();
                    ((ExtensionRange) this.instance).mergeOptions(extensionRangeOptions);
                    return this;
                }

                public Builder clearOptions() {
                    copyOnWrite();
                    ((ExtensionRange) this.instance).clearOptions();
                    return this;
                }
            }

            /* access modifiers changed from: protected */
            public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
                boolean z = false;
                switch (methodToInvoke) {
                    case NEW_MUTABLE_INSTANCE:
                        return new ExtensionRange();
                    case IS_INITIALIZED:
                        byte b = this.memoizedIsInitialized;
                        if (b == 1) {
                            return DEFAULT_INSTANCE;
                        }
                        if (b == 0) {
                            return null;
                        }
                        boolean booleanValue = ((Boolean) obj).booleanValue();
                        if (!hasOptions() || getOptions().isInitialized()) {
                            if (booleanValue) {
                                this.memoizedIsInitialized = 1;
                            }
                            return DEFAULT_INSTANCE;
                        }
                        if (booleanValue) {
                            this.memoizedIsInitialized = 0;
                        }
                        return null;
                    case MAKE_IMMUTABLE:
                        return null;
                    case NEW_BUILDER:
                        return new Builder();
                    case VISIT:
                        GeneratedMessageLite.Visitor visitor = (GeneratedMessageLite.Visitor) obj;
                        ExtensionRange extensionRange = (ExtensionRange) obj2;
                        this.start_ = visitor.visitInt(hasStart(), this.start_, extensionRange.hasStart(), extensionRange.start_);
                        this.end_ = visitor.visitInt(hasEnd(), this.end_, extensionRange.hasEnd(), extensionRange.end_);
                        this.options_ = (ExtensionRangeOptions) visitor.visitMessage(this.options_, extensionRange.options_);
                        if (visitor == GeneratedMessageLite.MergeFromVisitor.INSTANCE) {
                            this.bitField0_ |= extensionRange.bitField0_;
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
                                        this.bitField0_ |= 1;
                                        this.start_ = codedInputStream.readInt32();
                                    } else if (readTag == 16) {
                                        this.bitField0_ |= 2;
                                        this.end_ = codedInputStream.readInt32();
                                    } else if (readTag == 26) {
                                        ExtensionRangeOptions.Builder builder = (this.bitField0_ & 4) == 4 ? (ExtensionRangeOptions.Builder) this.options_.toBuilder() : null;
                                        this.options_ = (ExtensionRangeOptions) codedInputStream.readMessage(ExtensionRangeOptions.parser(), extensionRegistryLite);
                                        if (builder != null) {
                                            builder.mergeFrom(this.options_);
                                            this.options_ = (ExtensionRangeOptions) builder.buildPartial();
                                        }
                                        this.bitField0_ |= 4;
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
                            synchronized (ExtensionRange.class) {
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

            public static ExtensionRange getDefaultInstance() {
                return DEFAULT_INSTANCE;
            }

            public static Parser<ExtensionRange> parser() {
                return DEFAULT_INSTANCE.getParserForType();
            }
        }

        /* compiled from: com.google.firebase:protolite-well-known-types@@16.0.1 */
        public static final class ReservedRange extends GeneratedMessageLite<ReservedRange, Builder> implements ReservedRangeOrBuilder {
            /* access modifiers changed from: private */
            public static final ReservedRange DEFAULT_INSTANCE = new ReservedRange();
            public static final int END_FIELD_NUMBER = 2;
            private static volatile Parser<ReservedRange> PARSER = null;
            public static final int START_FIELD_NUMBER = 1;
            private int bitField0_;
            private int end_;
            private int start_;

            private ReservedRange() {
            }

            public boolean hasStart() {
                return (this.bitField0_ & 1) == 1;
            }

            public int getStart() {
                return this.start_;
            }

            /* access modifiers changed from: private */
            public void setStart(int i) {
                this.bitField0_ |= 1;
                this.start_ = i;
            }

            /* access modifiers changed from: private */
            public void clearStart() {
                this.bitField0_ &= -2;
                this.start_ = 0;
            }

            public boolean hasEnd() {
                return (this.bitField0_ & 2) == 2;
            }

            public int getEnd() {
                return this.end_;
            }

            /* access modifiers changed from: private */
            public void setEnd(int i) {
                this.bitField0_ |= 2;
                this.end_ = i;
            }

            /* access modifiers changed from: private */
            public void clearEnd() {
                this.bitField0_ &= -3;
                this.end_ = 0;
            }

            public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
                if ((this.bitField0_ & 1) == 1) {
                    codedOutputStream.writeInt32(1, this.start_);
                }
                if ((this.bitField0_ & 2) == 2) {
                    codedOutputStream.writeInt32(2, this.end_);
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
                    i2 = 0 + CodedOutputStream.computeInt32Size(1, this.start_);
                }
                if ((this.bitField0_ & 2) == 2) {
                    i2 += CodedOutputStream.computeInt32Size(2, this.end_);
                }
                int serializedSize = i2 + this.unknownFields.getSerializedSize();
                this.memoizedSerializedSize = serializedSize;
                return serializedSize;
            }

            public static ReservedRange parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
                return (ReservedRange) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
            }

            public static ReservedRange parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return (ReservedRange) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
            }

            public static ReservedRange parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
                return (ReservedRange) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
            }

            public static ReservedRange parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return (ReservedRange) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
            }

            public static ReservedRange parseFrom(InputStream inputStream) throws IOException {
                return (ReservedRange) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
            }

            public static ReservedRange parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                return (ReservedRange) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
            }

            public static ReservedRange parseDelimitedFrom(InputStream inputStream) throws IOException {
                return (ReservedRange) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
            }

            public static ReservedRange parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                return (ReservedRange) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
            }

            public static ReservedRange parseFrom(CodedInputStream codedInputStream) throws IOException {
                return (ReservedRange) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
            }

            public static ReservedRange parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                return (ReservedRange) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
            }

            public static Builder newBuilder() {
                return (Builder) DEFAULT_INSTANCE.toBuilder();
            }

            public static Builder newBuilder(ReservedRange reservedRange) {
                return (Builder) ((Builder) DEFAULT_INSTANCE.toBuilder()).mergeFrom(reservedRange);
            }

            /* compiled from: com.google.firebase:protolite-well-known-types@@16.0.1 */
            public static final class Builder extends GeneratedMessageLite.Builder<ReservedRange, Builder> implements ReservedRangeOrBuilder {
                private Builder() {
                    super(ReservedRange.DEFAULT_INSTANCE);
                }

                public boolean hasStart() {
                    return ((ReservedRange) this.instance).hasStart();
                }

                public int getStart() {
                    return ((ReservedRange) this.instance).getStart();
                }

                public Builder setStart(int i) {
                    copyOnWrite();
                    ((ReservedRange) this.instance).setStart(i);
                    return this;
                }

                public Builder clearStart() {
                    copyOnWrite();
                    ((ReservedRange) this.instance).clearStart();
                    return this;
                }

                public boolean hasEnd() {
                    return ((ReservedRange) this.instance).hasEnd();
                }

                public int getEnd() {
                    return ((ReservedRange) this.instance).getEnd();
                }

                public Builder setEnd(int i) {
                    copyOnWrite();
                    ((ReservedRange) this.instance).setEnd(i);
                    return this;
                }

                public Builder clearEnd() {
                    copyOnWrite();
                    ((ReservedRange) this.instance).clearEnd();
                    return this;
                }
            }

            /* access modifiers changed from: protected */
            public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
                switch (methodToInvoke) {
                    case NEW_MUTABLE_INSTANCE:
                        return new ReservedRange();
                    case IS_INITIALIZED:
                        return DEFAULT_INSTANCE;
                    case MAKE_IMMUTABLE:
                        return null;
                    case NEW_BUILDER:
                        return new Builder();
                    case VISIT:
                        GeneratedMessageLite.Visitor visitor = (GeneratedMessageLite.Visitor) obj;
                        ReservedRange reservedRange = (ReservedRange) obj2;
                        this.start_ = visitor.visitInt(hasStart(), this.start_, reservedRange.hasStart(), reservedRange.start_);
                        this.end_ = visitor.visitInt(hasEnd(), this.end_, reservedRange.hasEnd(), reservedRange.end_);
                        if (visitor == GeneratedMessageLite.MergeFromVisitor.INSTANCE) {
                            this.bitField0_ |= reservedRange.bitField0_;
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
                                        this.start_ = codedInputStream.readInt32();
                                    } else if (readTag == 16) {
                                        this.bitField0_ |= 2;
                                        this.end_ = codedInputStream.readInt32();
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
                            synchronized (ReservedRange.class) {
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

            public static ReservedRange getDefaultInstance() {
                return DEFAULT_INSTANCE;
            }

            public static Parser<ReservedRange> parser() {
                return DEFAULT_INSTANCE.getParserForType();
            }
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

        public List<FieldDescriptorProto> getFieldList() {
            return this.field_;
        }

        public List<? extends FieldDescriptorProtoOrBuilder> getFieldOrBuilderList() {
            return this.field_;
        }

        public int getFieldCount() {
            return this.field_.size();
        }

        public FieldDescriptorProto getField(int i) {
            return (FieldDescriptorProto) this.field_.get(i);
        }

        public FieldDescriptorProtoOrBuilder getFieldOrBuilder(int i) {
            return (FieldDescriptorProtoOrBuilder) this.field_.get(i);
        }

        private void ensureFieldIsMutable() {
            if (!this.field_.isModifiable()) {
                this.field_ = GeneratedMessageLite.mutableCopy(this.field_);
            }
        }

        /* access modifiers changed from: private */
        public void setField(int i, FieldDescriptorProto fieldDescriptorProto) {
            if (fieldDescriptorProto != null) {
                ensureFieldIsMutable();
                this.field_.set(i, fieldDescriptorProto);
                return;
            }
            throw new NullPointerException();
        }

        /* access modifiers changed from: private */
        public void setField(int i, FieldDescriptorProto.Builder builder) {
            ensureFieldIsMutable();
            this.field_.set(i, (FieldDescriptorProto) builder.build());
        }

        /* access modifiers changed from: private */
        public void addField(FieldDescriptorProto fieldDescriptorProto) {
            if (fieldDescriptorProto != null) {
                ensureFieldIsMutable();
                this.field_.add(fieldDescriptorProto);
                return;
            }
            throw new NullPointerException();
        }

        /* access modifiers changed from: private */
        public void addField(int i, FieldDescriptorProto fieldDescriptorProto) {
            if (fieldDescriptorProto != null) {
                ensureFieldIsMutable();
                this.field_.add(i, fieldDescriptorProto);
                return;
            }
            throw new NullPointerException();
        }

        /* access modifiers changed from: private */
        public void addField(FieldDescriptorProto.Builder builder) {
            ensureFieldIsMutable();
            this.field_.add((FieldDescriptorProto) builder.build());
        }

        /* access modifiers changed from: private */
        public void addField(int i, FieldDescriptorProto.Builder builder) {
            ensureFieldIsMutable();
            this.field_.add(i, (FieldDescriptorProto) builder.build());
        }

        /* access modifiers changed from: private */
        public void addAllField(Iterable<? extends FieldDescriptorProto> iterable) {
            ensureFieldIsMutable();
            AbstractMessageLite.addAll(iterable, this.field_);
        }

        /* access modifiers changed from: private */
        public void clearField() {
            this.field_ = emptyProtobufList();
        }

        /* access modifiers changed from: private */
        public void removeField(int i) {
            ensureFieldIsMutable();
            this.field_.remove(i);
        }

        public List<FieldDescriptorProto> getExtensionList() {
            return this.extension_;
        }

        public List<? extends FieldDescriptorProtoOrBuilder> getExtensionOrBuilderList() {
            return this.extension_;
        }

        public int getExtensionCount() {
            return this.extension_.size();
        }

        public FieldDescriptorProto getExtension(int i) {
            return (FieldDescriptorProto) this.extension_.get(i);
        }

        public FieldDescriptorProtoOrBuilder getExtensionOrBuilder(int i) {
            return (FieldDescriptorProtoOrBuilder) this.extension_.get(i);
        }

        private void ensureExtensionIsMutable() {
            if (!this.extension_.isModifiable()) {
                this.extension_ = GeneratedMessageLite.mutableCopy(this.extension_);
            }
        }

        /* access modifiers changed from: private */
        public void setExtension(int i, FieldDescriptorProto fieldDescriptorProto) {
            if (fieldDescriptorProto != null) {
                ensureExtensionIsMutable();
                this.extension_.set(i, fieldDescriptorProto);
                return;
            }
            throw new NullPointerException();
        }

        /* access modifiers changed from: private */
        public void setExtension(int i, FieldDescriptorProto.Builder builder) {
            ensureExtensionIsMutable();
            this.extension_.set(i, (FieldDescriptorProto) builder.build());
        }

        /* access modifiers changed from: private */
        public void addExtension(FieldDescriptorProto fieldDescriptorProto) {
            if (fieldDescriptorProto != null) {
                ensureExtensionIsMutable();
                this.extension_.add(fieldDescriptorProto);
                return;
            }
            throw new NullPointerException();
        }

        /* access modifiers changed from: private */
        public void addExtension(int i, FieldDescriptorProto fieldDescriptorProto) {
            if (fieldDescriptorProto != null) {
                ensureExtensionIsMutable();
                this.extension_.add(i, fieldDescriptorProto);
                return;
            }
            throw new NullPointerException();
        }

        /* access modifiers changed from: private */
        public void addExtension(FieldDescriptorProto.Builder builder) {
            ensureExtensionIsMutable();
            this.extension_.add((FieldDescriptorProto) builder.build());
        }

        /* access modifiers changed from: private */
        public void addExtension(int i, FieldDescriptorProto.Builder builder) {
            ensureExtensionIsMutable();
            this.extension_.add(i, (FieldDescriptorProto) builder.build());
        }

        /* access modifiers changed from: private */
        public void addAllExtension(Iterable<? extends FieldDescriptorProto> iterable) {
            ensureExtensionIsMutable();
            AbstractMessageLite.addAll(iterable, this.extension_);
        }

        /* access modifiers changed from: private */
        public void clearExtension() {
            this.extension_ = emptyProtobufList();
        }

        /* access modifiers changed from: private */
        public void removeExtension(int i) {
            ensureExtensionIsMutable();
            this.extension_.remove(i);
        }

        public List<DescriptorProto> getNestedTypeList() {
            return this.nestedType_;
        }

        public List<? extends DescriptorProtoOrBuilder> getNestedTypeOrBuilderList() {
            return this.nestedType_;
        }

        public int getNestedTypeCount() {
            return this.nestedType_.size();
        }

        public DescriptorProto getNestedType(int i) {
            return (DescriptorProto) this.nestedType_.get(i);
        }

        public DescriptorProtoOrBuilder getNestedTypeOrBuilder(int i) {
            return (DescriptorProtoOrBuilder) this.nestedType_.get(i);
        }

        private void ensureNestedTypeIsMutable() {
            if (!this.nestedType_.isModifiable()) {
                this.nestedType_ = GeneratedMessageLite.mutableCopy(this.nestedType_);
            }
        }

        /* access modifiers changed from: private */
        public void setNestedType(int i, DescriptorProto descriptorProto) {
            if (descriptorProto != null) {
                ensureNestedTypeIsMutable();
                this.nestedType_.set(i, descriptorProto);
                return;
            }
            throw new NullPointerException();
        }

        /* access modifiers changed from: private */
        public void setNestedType(int i, Builder builder) {
            ensureNestedTypeIsMutable();
            this.nestedType_.set(i, (DescriptorProto) builder.build());
        }

        /* access modifiers changed from: private */
        public void addNestedType(DescriptorProto descriptorProto) {
            if (descriptorProto != null) {
                ensureNestedTypeIsMutable();
                this.nestedType_.add(descriptorProto);
                return;
            }
            throw new NullPointerException();
        }

        /* access modifiers changed from: private */
        public void addNestedType(int i, DescriptorProto descriptorProto) {
            if (descriptorProto != null) {
                ensureNestedTypeIsMutable();
                this.nestedType_.add(i, descriptorProto);
                return;
            }
            throw new NullPointerException();
        }

        /* access modifiers changed from: private */
        public void addNestedType(Builder builder) {
            ensureNestedTypeIsMutable();
            this.nestedType_.add((DescriptorProto) builder.build());
        }

        /* access modifiers changed from: private */
        public void addNestedType(int i, Builder builder) {
            ensureNestedTypeIsMutable();
            this.nestedType_.add(i, (DescriptorProto) builder.build());
        }

        /* access modifiers changed from: private */
        public void addAllNestedType(Iterable<? extends DescriptorProto> iterable) {
            ensureNestedTypeIsMutable();
            AbstractMessageLite.addAll(iterable, this.nestedType_);
        }

        /* access modifiers changed from: private */
        public void clearNestedType() {
            this.nestedType_ = emptyProtobufList();
        }

        /* access modifiers changed from: private */
        public void removeNestedType(int i) {
            ensureNestedTypeIsMutable();
            this.nestedType_.remove(i);
        }

        public List<EnumDescriptorProto> getEnumTypeList() {
            return this.enumType_;
        }

        public List<? extends EnumDescriptorProtoOrBuilder> getEnumTypeOrBuilderList() {
            return this.enumType_;
        }

        public int getEnumTypeCount() {
            return this.enumType_.size();
        }

        public EnumDescriptorProto getEnumType(int i) {
            return (EnumDescriptorProto) this.enumType_.get(i);
        }

        public EnumDescriptorProtoOrBuilder getEnumTypeOrBuilder(int i) {
            return (EnumDescriptorProtoOrBuilder) this.enumType_.get(i);
        }

        private void ensureEnumTypeIsMutable() {
            if (!this.enumType_.isModifiable()) {
                this.enumType_ = GeneratedMessageLite.mutableCopy(this.enumType_);
            }
        }

        /* access modifiers changed from: private */
        public void setEnumType(int i, EnumDescriptorProto enumDescriptorProto) {
            if (enumDescriptorProto != null) {
                ensureEnumTypeIsMutable();
                this.enumType_.set(i, enumDescriptorProto);
                return;
            }
            throw new NullPointerException();
        }

        /* access modifiers changed from: private */
        public void setEnumType(int i, EnumDescriptorProto.Builder builder) {
            ensureEnumTypeIsMutable();
            this.enumType_.set(i, (EnumDescriptorProto) builder.build());
        }

        /* access modifiers changed from: private */
        public void addEnumType(EnumDescriptorProto enumDescriptorProto) {
            if (enumDescriptorProto != null) {
                ensureEnumTypeIsMutable();
                this.enumType_.add(enumDescriptorProto);
                return;
            }
            throw new NullPointerException();
        }

        /* access modifiers changed from: private */
        public void addEnumType(int i, EnumDescriptorProto enumDescriptorProto) {
            if (enumDescriptorProto != null) {
                ensureEnumTypeIsMutable();
                this.enumType_.add(i, enumDescriptorProto);
                return;
            }
            throw new NullPointerException();
        }

        /* access modifiers changed from: private */
        public void addEnumType(EnumDescriptorProto.Builder builder) {
            ensureEnumTypeIsMutable();
            this.enumType_.add((EnumDescriptorProto) builder.build());
        }

        /* access modifiers changed from: private */
        public void addEnumType(int i, EnumDescriptorProto.Builder builder) {
            ensureEnumTypeIsMutable();
            this.enumType_.add(i, (EnumDescriptorProto) builder.build());
        }

        /* access modifiers changed from: private */
        public void addAllEnumType(Iterable<? extends EnumDescriptorProto> iterable) {
            ensureEnumTypeIsMutable();
            AbstractMessageLite.addAll(iterable, this.enumType_);
        }

        /* access modifiers changed from: private */
        public void clearEnumType() {
            this.enumType_ = emptyProtobufList();
        }

        /* access modifiers changed from: private */
        public void removeEnumType(int i) {
            ensureEnumTypeIsMutable();
            this.enumType_.remove(i);
        }

        public List<ExtensionRange> getExtensionRangeList() {
            return this.extensionRange_;
        }

        public List<? extends ExtensionRangeOrBuilder> getExtensionRangeOrBuilderList() {
            return this.extensionRange_;
        }

        public int getExtensionRangeCount() {
            return this.extensionRange_.size();
        }

        public ExtensionRange getExtensionRange(int i) {
            return (ExtensionRange) this.extensionRange_.get(i);
        }

        public ExtensionRangeOrBuilder getExtensionRangeOrBuilder(int i) {
            return (ExtensionRangeOrBuilder) this.extensionRange_.get(i);
        }

        private void ensureExtensionRangeIsMutable() {
            if (!this.extensionRange_.isModifiable()) {
                this.extensionRange_ = GeneratedMessageLite.mutableCopy(this.extensionRange_);
            }
        }

        /* access modifiers changed from: private */
        public void setExtensionRange(int i, ExtensionRange extensionRange) {
            if (extensionRange != null) {
                ensureExtensionRangeIsMutable();
                this.extensionRange_.set(i, extensionRange);
                return;
            }
            throw new NullPointerException();
        }

        /* access modifiers changed from: private */
        public void setExtensionRange(int i, ExtensionRange.Builder builder) {
            ensureExtensionRangeIsMutable();
            this.extensionRange_.set(i, (ExtensionRange) builder.build());
        }

        /* access modifiers changed from: private */
        public void addExtensionRange(ExtensionRange extensionRange) {
            if (extensionRange != null) {
                ensureExtensionRangeIsMutable();
                this.extensionRange_.add(extensionRange);
                return;
            }
            throw new NullPointerException();
        }

        /* access modifiers changed from: private */
        public void addExtensionRange(int i, ExtensionRange extensionRange) {
            if (extensionRange != null) {
                ensureExtensionRangeIsMutable();
                this.extensionRange_.add(i, extensionRange);
                return;
            }
            throw new NullPointerException();
        }

        /* access modifiers changed from: private */
        public void addExtensionRange(ExtensionRange.Builder builder) {
            ensureExtensionRangeIsMutable();
            this.extensionRange_.add((ExtensionRange) builder.build());
        }

        /* access modifiers changed from: private */
        public void addExtensionRange(int i, ExtensionRange.Builder builder) {
            ensureExtensionRangeIsMutable();
            this.extensionRange_.add(i, (ExtensionRange) builder.build());
        }

        /* access modifiers changed from: private */
        public void addAllExtensionRange(Iterable<? extends ExtensionRange> iterable) {
            ensureExtensionRangeIsMutable();
            AbstractMessageLite.addAll(iterable, this.extensionRange_);
        }

        /* access modifiers changed from: private */
        public void clearExtensionRange() {
            this.extensionRange_ = emptyProtobufList();
        }

        /* access modifiers changed from: private */
        public void removeExtensionRange(int i) {
            ensureExtensionRangeIsMutable();
            this.extensionRange_.remove(i);
        }

        public List<OneofDescriptorProto> getOneofDeclList() {
            return this.oneofDecl_;
        }

        public List<? extends OneofDescriptorProtoOrBuilder> getOneofDeclOrBuilderList() {
            return this.oneofDecl_;
        }

        public int getOneofDeclCount() {
            return this.oneofDecl_.size();
        }

        public OneofDescriptorProto getOneofDecl(int i) {
            return (OneofDescriptorProto) this.oneofDecl_.get(i);
        }

        public OneofDescriptorProtoOrBuilder getOneofDeclOrBuilder(int i) {
            return (OneofDescriptorProtoOrBuilder) this.oneofDecl_.get(i);
        }

        private void ensureOneofDeclIsMutable() {
            if (!this.oneofDecl_.isModifiable()) {
                this.oneofDecl_ = GeneratedMessageLite.mutableCopy(this.oneofDecl_);
            }
        }

        /* access modifiers changed from: private */
        public void setOneofDecl(int i, OneofDescriptorProto oneofDescriptorProto) {
            if (oneofDescriptorProto != null) {
                ensureOneofDeclIsMutable();
                this.oneofDecl_.set(i, oneofDescriptorProto);
                return;
            }
            throw new NullPointerException();
        }

        /* access modifiers changed from: private */
        public void setOneofDecl(int i, OneofDescriptorProto.Builder builder) {
            ensureOneofDeclIsMutable();
            this.oneofDecl_.set(i, (OneofDescriptorProto) builder.build());
        }

        /* access modifiers changed from: private */
        public void addOneofDecl(OneofDescriptorProto oneofDescriptorProto) {
            if (oneofDescriptorProto != null) {
                ensureOneofDeclIsMutable();
                this.oneofDecl_.add(oneofDescriptorProto);
                return;
            }
            throw new NullPointerException();
        }

        /* access modifiers changed from: private */
        public void addOneofDecl(int i, OneofDescriptorProto oneofDescriptorProto) {
            if (oneofDescriptorProto != null) {
                ensureOneofDeclIsMutable();
                this.oneofDecl_.add(i, oneofDescriptorProto);
                return;
            }
            throw new NullPointerException();
        }

        /* access modifiers changed from: private */
        public void addOneofDecl(OneofDescriptorProto.Builder builder) {
            ensureOneofDeclIsMutable();
            this.oneofDecl_.add((OneofDescriptorProto) builder.build());
        }

        /* access modifiers changed from: private */
        public void addOneofDecl(int i, OneofDescriptorProto.Builder builder) {
            ensureOneofDeclIsMutable();
            this.oneofDecl_.add(i, (OneofDescriptorProto) builder.build());
        }

        /* access modifiers changed from: private */
        public void addAllOneofDecl(Iterable<? extends OneofDescriptorProto> iterable) {
            ensureOneofDeclIsMutable();
            AbstractMessageLite.addAll(iterable, this.oneofDecl_);
        }

        /* access modifiers changed from: private */
        public void clearOneofDecl() {
            this.oneofDecl_ = emptyProtobufList();
        }

        /* access modifiers changed from: private */
        public void removeOneofDecl(int i) {
            ensureOneofDeclIsMutable();
            this.oneofDecl_.remove(i);
        }

        public boolean hasOptions() {
            return (this.bitField0_ & 2) == 2;
        }

        public MessageOptions getOptions() {
            MessageOptions messageOptions = this.options_;
            return messageOptions == null ? MessageOptions.getDefaultInstance() : messageOptions;
        }

        /* access modifiers changed from: private */
        public void setOptions(MessageOptions messageOptions) {
            if (messageOptions != null) {
                this.options_ = messageOptions;
                this.bitField0_ |= 2;
                return;
            }
            throw new NullPointerException();
        }

        /* access modifiers changed from: private */
        public void setOptions(MessageOptions.Builder builder) {
            this.options_ = (MessageOptions) builder.build();
            this.bitField0_ |= 2;
        }

        /* access modifiers changed from: private */
        public void mergeOptions(MessageOptions messageOptions) {
            MessageOptions messageOptions2 = this.options_;
            if (messageOptions2 == null || messageOptions2 == MessageOptions.getDefaultInstance()) {
                this.options_ = messageOptions;
            } else {
                this.options_ = (MessageOptions) ((MessageOptions.Builder) MessageOptions.newBuilder(this.options_).mergeFrom(messageOptions)).buildPartial();
            }
            this.bitField0_ |= 2;
        }

        /* access modifiers changed from: private */
        public void clearOptions() {
            this.options_ = null;
            this.bitField0_ &= -3;
        }

        public List<ReservedRange> getReservedRangeList() {
            return this.reservedRange_;
        }

        public List<? extends ReservedRangeOrBuilder> getReservedRangeOrBuilderList() {
            return this.reservedRange_;
        }

        public int getReservedRangeCount() {
            return this.reservedRange_.size();
        }

        public ReservedRange getReservedRange(int i) {
            return (ReservedRange) this.reservedRange_.get(i);
        }

        public ReservedRangeOrBuilder getReservedRangeOrBuilder(int i) {
            return (ReservedRangeOrBuilder) this.reservedRange_.get(i);
        }

        private void ensureReservedRangeIsMutable() {
            if (!this.reservedRange_.isModifiable()) {
                this.reservedRange_ = GeneratedMessageLite.mutableCopy(this.reservedRange_);
            }
        }

        /* access modifiers changed from: private */
        public void setReservedRange(int i, ReservedRange reservedRange) {
            if (reservedRange != null) {
                ensureReservedRangeIsMutable();
                this.reservedRange_.set(i, reservedRange);
                return;
            }
            throw new NullPointerException();
        }

        /* access modifiers changed from: private */
        public void setReservedRange(int i, ReservedRange.Builder builder) {
            ensureReservedRangeIsMutable();
            this.reservedRange_.set(i, (ReservedRange) builder.build());
        }

        /* access modifiers changed from: private */
        public void addReservedRange(ReservedRange reservedRange) {
            if (reservedRange != null) {
                ensureReservedRangeIsMutable();
                this.reservedRange_.add(reservedRange);
                return;
            }
            throw new NullPointerException();
        }

        /* access modifiers changed from: private */
        public void addReservedRange(int i, ReservedRange reservedRange) {
            if (reservedRange != null) {
                ensureReservedRangeIsMutable();
                this.reservedRange_.add(i, reservedRange);
                return;
            }
            throw new NullPointerException();
        }

        /* access modifiers changed from: private */
        public void addReservedRange(ReservedRange.Builder builder) {
            ensureReservedRangeIsMutable();
            this.reservedRange_.add((ReservedRange) builder.build());
        }

        /* access modifiers changed from: private */
        public void addReservedRange(int i, ReservedRange.Builder builder) {
            ensureReservedRangeIsMutable();
            this.reservedRange_.add(i, (ReservedRange) builder.build());
        }

        /* access modifiers changed from: private */
        public void addAllReservedRange(Iterable<? extends ReservedRange> iterable) {
            ensureReservedRangeIsMutable();
            AbstractMessageLite.addAll(iterable, this.reservedRange_);
        }

        /* access modifiers changed from: private */
        public void clearReservedRange() {
            this.reservedRange_ = emptyProtobufList();
        }

        /* access modifiers changed from: private */
        public void removeReservedRange(int i) {
            ensureReservedRangeIsMutable();
            this.reservedRange_.remove(i);
        }

        public List<String> getReservedNameList() {
            return this.reservedName_;
        }

        public int getReservedNameCount() {
            return this.reservedName_.size();
        }

        public String getReservedName(int i) {
            return (String) this.reservedName_.get(i);
        }

        public ByteString getReservedNameBytes(int i) {
            return ByteString.copyFromUtf8((String) this.reservedName_.get(i));
        }

        private void ensureReservedNameIsMutable() {
            if (!this.reservedName_.isModifiable()) {
                this.reservedName_ = GeneratedMessageLite.mutableCopy(this.reservedName_);
            }
        }

        /* access modifiers changed from: private */
        public void setReservedName(int i, String str) {
            if (str != null) {
                ensureReservedNameIsMutable();
                this.reservedName_.set(i, str);
                return;
            }
            throw new NullPointerException();
        }

        /* access modifiers changed from: private */
        public void addReservedName(String str) {
            if (str != null) {
                ensureReservedNameIsMutable();
                this.reservedName_.add(str);
                return;
            }
            throw new NullPointerException();
        }

        /* access modifiers changed from: private */
        public void addAllReservedName(Iterable<String> iterable) {
            ensureReservedNameIsMutable();
            AbstractMessageLite.addAll(iterable, this.reservedName_);
        }

        /* access modifiers changed from: private */
        public void clearReservedName() {
            this.reservedName_ = GeneratedMessageLite.emptyProtobufList();
        }

        /* access modifiers changed from: private */
        public void addReservedNameBytes(ByteString byteString) {
            if (byteString != null) {
                ensureReservedNameIsMutable();
                this.reservedName_.add(byteString.toStringUtf8());
                return;
            }
            throw new NullPointerException();
        }

        public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
            if ((this.bitField0_ & 1) == 1) {
                codedOutputStream.writeString(1, getName());
            }
            for (int i = 0; i < this.field_.size(); i++) {
                codedOutputStream.writeMessage(2, (MessageLite) this.field_.get(i));
            }
            for (int i2 = 0; i2 < this.nestedType_.size(); i2++) {
                codedOutputStream.writeMessage(3, (MessageLite) this.nestedType_.get(i2));
            }
            for (int i3 = 0; i3 < this.enumType_.size(); i3++) {
                codedOutputStream.writeMessage(4, (MessageLite) this.enumType_.get(i3));
            }
            for (int i4 = 0; i4 < this.extensionRange_.size(); i4++) {
                codedOutputStream.writeMessage(5, (MessageLite) this.extensionRange_.get(i4));
            }
            for (int i5 = 0; i5 < this.extension_.size(); i5++) {
                codedOutputStream.writeMessage(6, (MessageLite) this.extension_.get(i5));
            }
            if ((this.bitField0_ & 2) == 2) {
                codedOutputStream.writeMessage(7, getOptions());
            }
            for (int i6 = 0; i6 < this.oneofDecl_.size(); i6++) {
                codedOutputStream.writeMessage(8, (MessageLite) this.oneofDecl_.get(i6));
            }
            for (int i7 = 0; i7 < this.reservedRange_.size(); i7++) {
                codedOutputStream.writeMessage(9, (MessageLite) this.reservedRange_.get(i7));
            }
            for (int i8 = 0; i8 < this.reservedName_.size(); i8++) {
                codedOutputStream.writeString(10, (String) this.reservedName_.get(i8));
            }
            this.unknownFields.writeTo(codedOutputStream);
        }

        public int getSerializedSize() {
            int i = this.memoizedSerializedSize;
            if (i != -1) {
                return i;
            }
            int computeStringSize = (this.bitField0_ & 1) == 1 ? CodedOutputStream.computeStringSize(1, getName()) + 0 : 0;
            for (int i2 = 0; i2 < this.field_.size(); i2++) {
                computeStringSize += CodedOutputStream.computeMessageSize(2, (MessageLite) this.field_.get(i2));
            }
            for (int i3 = 0; i3 < this.nestedType_.size(); i3++) {
                computeStringSize += CodedOutputStream.computeMessageSize(3, (MessageLite) this.nestedType_.get(i3));
            }
            for (int i4 = 0; i4 < this.enumType_.size(); i4++) {
                computeStringSize += CodedOutputStream.computeMessageSize(4, (MessageLite) this.enumType_.get(i4));
            }
            for (int i5 = 0; i5 < this.extensionRange_.size(); i5++) {
                computeStringSize += CodedOutputStream.computeMessageSize(5, (MessageLite) this.extensionRange_.get(i5));
            }
            for (int i6 = 0; i6 < this.extension_.size(); i6++) {
                computeStringSize += CodedOutputStream.computeMessageSize(6, (MessageLite) this.extension_.get(i6));
            }
            if ((this.bitField0_ & 2) == 2) {
                computeStringSize += CodedOutputStream.computeMessageSize(7, getOptions());
            }
            for (int i7 = 0; i7 < this.oneofDecl_.size(); i7++) {
                computeStringSize += CodedOutputStream.computeMessageSize(8, (MessageLite) this.oneofDecl_.get(i7));
            }
            for (int i8 = 0; i8 < this.reservedRange_.size(); i8++) {
                computeStringSize += CodedOutputStream.computeMessageSize(9, (MessageLite) this.reservedRange_.get(i8));
            }
            int i9 = 0;
            for (int i10 = 0; i10 < this.reservedName_.size(); i10++) {
                i9 += CodedOutputStream.computeStringSizeNoTag((String) this.reservedName_.get(i10));
            }
            int size = computeStringSize + i9 + (getReservedNameList().size() * 1) + this.unknownFields.getSerializedSize();
            this.memoizedSerializedSize = size;
            return size;
        }

        public static DescriptorProto parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return (DescriptorProto) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
        }

        public static DescriptorProto parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (DescriptorProto) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
        }

        public static DescriptorProto parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return (DescriptorProto) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
        }

        public static DescriptorProto parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (DescriptorProto) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
        }

        public static DescriptorProto parseFrom(InputStream inputStream) throws IOException {
            return (DescriptorProto) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static DescriptorProto parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (DescriptorProto) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static DescriptorProto parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (DescriptorProto) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static DescriptorProto parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (DescriptorProto) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static DescriptorProto parseFrom(CodedInputStream codedInputStream) throws IOException {
            return (DescriptorProto) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
        }

        public static DescriptorProto parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (DescriptorProto) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
        }

        public static Builder newBuilder() {
            return (Builder) DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(DescriptorProto descriptorProto) {
            return (Builder) ((Builder) DEFAULT_INSTANCE.toBuilder()).mergeFrom(descriptorProto);
        }

        /* compiled from: com.google.firebase:protolite-well-known-types@@16.0.1 */
        public static final class Builder extends GeneratedMessageLite.Builder<DescriptorProto, Builder> implements DescriptorProtoOrBuilder {
            private Builder() {
                super(DescriptorProto.DEFAULT_INSTANCE);
            }

            public boolean hasName() {
                return ((DescriptorProto) this.instance).hasName();
            }

            public String getName() {
                return ((DescriptorProto) this.instance).getName();
            }

            public ByteString getNameBytes() {
                return ((DescriptorProto) this.instance).getNameBytes();
            }

            public Builder setName(String str) {
                copyOnWrite();
                ((DescriptorProto) this.instance).setName(str);
                return this;
            }

            public Builder clearName() {
                copyOnWrite();
                ((DescriptorProto) this.instance).clearName();
                return this;
            }

            public Builder setNameBytes(ByteString byteString) {
                copyOnWrite();
                ((DescriptorProto) this.instance).setNameBytes(byteString);
                return this;
            }

            public List<FieldDescriptorProto> getFieldList() {
                return Collections.unmodifiableList(((DescriptorProto) this.instance).getFieldList());
            }

            public int getFieldCount() {
                return ((DescriptorProto) this.instance).getFieldCount();
            }

            public FieldDescriptorProto getField(int i) {
                return ((DescriptorProto) this.instance).getField(i);
            }

            public Builder setField(int i, FieldDescriptorProto fieldDescriptorProto) {
                copyOnWrite();
                ((DescriptorProto) this.instance).setField(i, fieldDescriptorProto);
                return this;
            }

            public Builder setField(int i, FieldDescriptorProto.Builder builder) {
                copyOnWrite();
                ((DescriptorProto) this.instance).setField(i, builder);
                return this;
            }

            public Builder addField(FieldDescriptorProto fieldDescriptorProto) {
                copyOnWrite();
                ((DescriptorProto) this.instance).addField(fieldDescriptorProto);
                return this;
            }

            public Builder addField(int i, FieldDescriptorProto fieldDescriptorProto) {
                copyOnWrite();
                ((DescriptorProto) this.instance).addField(i, fieldDescriptorProto);
                return this;
            }

            public Builder addField(FieldDescriptorProto.Builder builder) {
                copyOnWrite();
                ((DescriptorProto) this.instance).addField(builder);
                return this;
            }

            public Builder addField(int i, FieldDescriptorProto.Builder builder) {
                copyOnWrite();
                ((DescriptorProto) this.instance).addField(i, builder);
                return this;
            }

            public Builder addAllField(Iterable<? extends FieldDescriptorProto> iterable) {
                copyOnWrite();
                ((DescriptorProto) this.instance).addAllField(iterable);
                return this;
            }

            public Builder clearField() {
                copyOnWrite();
                ((DescriptorProto) this.instance).clearField();
                return this;
            }

            public Builder removeField(int i) {
                copyOnWrite();
                ((DescriptorProto) this.instance).removeField(i);
                return this;
            }

            public List<FieldDescriptorProto> getExtensionList() {
                return Collections.unmodifiableList(((DescriptorProto) this.instance).getExtensionList());
            }

            public int getExtensionCount() {
                return ((DescriptorProto) this.instance).getExtensionCount();
            }

            public FieldDescriptorProto getExtension(int i) {
                return ((DescriptorProto) this.instance).getExtension(i);
            }

            public Builder setExtension(int i, FieldDescriptorProto fieldDescriptorProto) {
                copyOnWrite();
                ((DescriptorProto) this.instance).setExtension(i, fieldDescriptorProto);
                return this;
            }

            public Builder setExtension(int i, FieldDescriptorProto.Builder builder) {
                copyOnWrite();
                ((DescriptorProto) this.instance).setExtension(i, builder);
                return this;
            }

            public Builder addExtension(FieldDescriptorProto fieldDescriptorProto) {
                copyOnWrite();
                ((DescriptorProto) this.instance).addExtension(fieldDescriptorProto);
                return this;
            }

            public Builder addExtension(int i, FieldDescriptorProto fieldDescriptorProto) {
                copyOnWrite();
                ((DescriptorProto) this.instance).addExtension(i, fieldDescriptorProto);
                return this;
            }

            public Builder addExtension(FieldDescriptorProto.Builder builder) {
                copyOnWrite();
                ((DescriptorProto) this.instance).addExtension(builder);
                return this;
            }

            public Builder addExtension(int i, FieldDescriptorProto.Builder builder) {
                copyOnWrite();
                ((DescriptorProto) this.instance).addExtension(i, builder);
                return this;
            }

            public Builder addAllExtension(Iterable<? extends FieldDescriptorProto> iterable) {
                copyOnWrite();
                ((DescriptorProto) this.instance).addAllExtension(iterable);
                return this;
            }

            public Builder clearExtension() {
                copyOnWrite();
                ((DescriptorProto) this.instance).clearExtension();
                return this;
            }

            public Builder removeExtension(int i) {
                copyOnWrite();
                ((DescriptorProto) this.instance).removeExtension(i);
                return this;
            }

            public List<DescriptorProto> getNestedTypeList() {
                return Collections.unmodifiableList(((DescriptorProto) this.instance).getNestedTypeList());
            }

            public int getNestedTypeCount() {
                return ((DescriptorProto) this.instance).getNestedTypeCount();
            }

            public DescriptorProto getNestedType(int i) {
                return ((DescriptorProto) this.instance).getNestedType(i);
            }

            public Builder setNestedType(int i, DescriptorProto descriptorProto) {
                copyOnWrite();
                ((DescriptorProto) this.instance).setNestedType(i, descriptorProto);
                return this;
            }

            public Builder setNestedType(int i, Builder builder) {
                copyOnWrite();
                ((DescriptorProto) this.instance).setNestedType(i, builder);
                return this;
            }

            public Builder addNestedType(DescriptorProto descriptorProto) {
                copyOnWrite();
                ((DescriptorProto) this.instance).addNestedType(descriptorProto);
                return this;
            }

            public Builder addNestedType(int i, DescriptorProto descriptorProto) {
                copyOnWrite();
                ((DescriptorProto) this.instance).addNestedType(i, descriptorProto);
                return this;
            }

            public Builder addNestedType(Builder builder) {
                copyOnWrite();
                ((DescriptorProto) this.instance).addNestedType(builder);
                return this;
            }

            public Builder addNestedType(int i, Builder builder) {
                copyOnWrite();
                ((DescriptorProto) this.instance).addNestedType(i, builder);
                return this;
            }

            public Builder addAllNestedType(Iterable<? extends DescriptorProto> iterable) {
                copyOnWrite();
                ((DescriptorProto) this.instance).addAllNestedType(iterable);
                return this;
            }

            public Builder clearNestedType() {
                copyOnWrite();
                ((DescriptorProto) this.instance).clearNestedType();
                return this;
            }

            public Builder removeNestedType(int i) {
                copyOnWrite();
                ((DescriptorProto) this.instance).removeNestedType(i);
                return this;
            }

            public List<EnumDescriptorProto> getEnumTypeList() {
                return Collections.unmodifiableList(((DescriptorProto) this.instance).getEnumTypeList());
            }

            public int getEnumTypeCount() {
                return ((DescriptorProto) this.instance).getEnumTypeCount();
            }

            public EnumDescriptorProto getEnumType(int i) {
                return ((DescriptorProto) this.instance).getEnumType(i);
            }

            public Builder setEnumType(int i, EnumDescriptorProto enumDescriptorProto) {
                copyOnWrite();
                ((DescriptorProto) this.instance).setEnumType(i, enumDescriptorProto);
                return this;
            }

            public Builder setEnumType(int i, EnumDescriptorProto.Builder builder) {
                copyOnWrite();
                ((DescriptorProto) this.instance).setEnumType(i, builder);
                return this;
            }

            public Builder addEnumType(EnumDescriptorProto enumDescriptorProto) {
                copyOnWrite();
                ((DescriptorProto) this.instance).addEnumType(enumDescriptorProto);
                return this;
            }

            public Builder addEnumType(int i, EnumDescriptorProto enumDescriptorProto) {
                copyOnWrite();
                ((DescriptorProto) this.instance).addEnumType(i, enumDescriptorProto);
                return this;
            }

            public Builder addEnumType(EnumDescriptorProto.Builder builder) {
                copyOnWrite();
                ((DescriptorProto) this.instance).addEnumType(builder);
                return this;
            }

            public Builder addEnumType(int i, EnumDescriptorProto.Builder builder) {
                copyOnWrite();
                ((DescriptorProto) this.instance).addEnumType(i, builder);
                return this;
            }

            public Builder addAllEnumType(Iterable<? extends EnumDescriptorProto> iterable) {
                copyOnWrite();
                ((DescriptorProto) this.instance).addAllEnumType(iterable);
                return this;
            }

            public Builder clearEnumType() {
                copyOnWrite();
                ((DescriptorProto) this.instance).clearEnumType();
                return this;
            }

            public Builder removeEnumType(int i) {
                copyOnWrite();
                ((DescriptorProto) this.instance).removeEnumType(i);
                return this;
            }

            public List<ExtensionRange> getExtensionRangeList() {
                return Collections.unmodifiableList(((DescriptorProto) this.instance).getExtensionRangeList());
            }

            public int getExtensionRangeCount() {
                return ((DescriptorProto) this.instance).getExtensionRangeCount();
            }

            public ExtensionRange getExtensionRange(int i) {
                return ((DescriptorProto) this.instance).getExtensionRange(i);
            }

            public Builder setExtensionRange(int i, ExtensionRange extensionRange) {
                copyOnWrite();
                ((DescriptorProto) this.instance).setExtensionRange(i, extensionRange);
                return this;
            }

            public Builder setExtensionRange(int i, ExtensionRange.Builder builder) {
                copyOnWrite();
                ((DescriptorProto) this.instance).setExtensionRange(i, builder);
                return this;
            }

            public Builder addExtensionRange(ExtensionRange extensionRange) {
                copyOnWrite();
                ((DescriptorProto) this.instance).addExtensionRange(extensionRange);
                return this;
            }

            public Builder addExtensionRange(int i, ExtensionRange extensionRange) {
                copyOnWrite();
                ((DescriptorProto) this.instance).addExtensionRange(i, extensionRange);
                return this;
            }

            public Builder addExtensionRange(ExtensionRange.Builder builder) {
                copyOnWrite();
                ((DescriptorProto) this.instance).addExtensionRange(builder);
                return this;
            }

            public Builder addExtensionRange(int i, ExtensionRange.Builder builder) {
                copyOnWrite();
                ((DescriptorProto) this.instance).addExtensionRange(i, builder);
                return this;
            }

            public Builder addAllExtensionRange(Iterable<? extends ExtensionRange> iterable) {
                copyOnWrite();
                ((DescriptorProto) this.instance).addAllExtensionRange(iterable);
                return this;
            }

            public Builder clearExtensionRange() {
                copyOnWrite();
                ((DescriptorProto) this.instance).clearExtensionRange();
                return this;
            }

            public Builder removeExtensionRange(int i) {
                copyOnWrite();
                ((DescriptorProto) this.instance).removeExtensionRange(i);
                return this;
            }

            public List<OneofDescriptorProto> getOneofDeclList() {
                return Collections.unmodifiableList(((DescriptorProto) this.instance).getOneofDeclList());
            }

            public int getOneofDeclCount() {
                return ((DescriptorProto) this.instance).getOneofDeclCount();
            }

            public OneofDescriptorProto getOneofDecl(int i) {
                return ((DescriptorProto) this.instance).getOneofDecl(i);
            }

            public Builder setOneofDecl(int i, OneofDescriptorProto oneofDescriptorProto) {
                copyOnWrite();
                ((DescriptorProto) this.instance).setOneofDecl(i, oneofDescriptorProto);
                return this;
            }

            public Builder setOneofDecl(int i, OneofDescriptorProto.Builder builder) {
                copyOnWrite();
                ((DescriptorProto) this.instance).setOneofDecl(i, builder);
                return this;
            }

            public Builder addOneofDecl(OneofDescriptorProto oneofDescriptorProto) {
                copyOnWrite();
                ((DescriptorProto) this.instance).addOneofDecl(oneofDescriptorProto);
                return this;
            }

            public Builder addOneofDecl(int i, OneofDescriptorProto oneofDescriptorProto) {
                copyOnWrite();
                ((DescriptorProto) this.instance).addOneofDecl(i, oneofDescriptorProto);
                return this;
            }

            public Builder addOneofDecl(OneofDescriptorProto.Builder builder) {
                copyOnWrite();
                ((DescriptorProto) this.instance).addOneofDecl(builder);
                return this;
            }

            public Builder addOneofDecl(int i, OneofDescriptorProto.Builder builder) {
                copyOnWrite();
                ((DescriptorProto) this.instance).addOneofDecl(i, builder);
                return this;
            }

            public Builder addAllOneofDecl(Iterable<? extends OneofDescriptorProto> iterable) {
                copyOnWrite();
                ((DescriptorProto) this.instance).addAllOneofDecl(iterable);
                return this;
            }

            public Builder clearOneofDecl() {
                copyOnWrite();
                ((DescriptorProto) this.instance).clearOneofDecl();
                return this;
            }

            public Builder removeOneofDecl(int i) {
                copyOnWrite();
                ((DescriptorProto) this.instance).removeOneofDecl(i);
                return this;
            }

            public boolean hasOptions() {
                return ((DescriptorProto) this.instance).hasOptions();
            }

            public MessageOptions getOptions() {
                return ((DescriptorProto) this.instance).getOptions();
            }

            public Builder setOptions(MessageOptions messageOptions) {
                copyOnWrite();
                ((DescriptorProto) this.instance).setOptions(messageOptions);
                return this;
            }

            public Builder setOptions(MessageOptions.Builder builder) {
                copyOnWrite();
                ((DescriptorProto) this.instance).setOptions(builder);
                return this;
            }

            public Builder mergeOptions(MessageOptions messageOptions) {
                copyOnWrite();
                ((DescriptorProto) this.instance).mergeOptions(messageOptions);
                return this;
            }

            public Builder clearOptions() {
                copyOnWrite();
                ((DescriptorProto) this.instance).clearOptions();
                return this;
            }

            public List<ReservedRange> getReservedRangeList() {
                return Collections.unmodifiableList(((DescriptorProto) this.instance).getReservedRangeList());
            }

            public int getReservedRangeCount() {
                return ((DescriptorProto) this.instance).getReservedRangeCount();
            }

            public ReservedRange getReservedRange(int i) {
                return ((DescriptorProto) this.instance).getReservedRange(i);
            }

            public Builder setReservedRange(int i, ReservedRange reservedRange) {
                copyOnWrite();
                ((DescriptorProto) this.instance).setReservedRange(i, reservedRange);
                return this;
            }

            public Builder setReservedRange(int i, ReservedRange.Builder builder) {
                copyOnWrite();
                ((DescriptorProto) this.instance).setReservedRange(i, builder);
                return this;
            }

            public Builder addReservedRange(ReservedRange reservedRange) {
                copyOnWrite();
                ((DescriptorProto) this.instance).addReservedRange(reservedRange);
                return this;
            }

            public Builder addReservedRange(int i, ReservedRange reservedRange) {
                copyOnWrite();
                ((DescriptorProto) this.instance).addReservedRange(i, reservedRange);
                return this;
            }

            public Builder addReservedRange(ReservedRange.Builder builder) {
                copyOnWrite();
                ((DescriptorProto) this.instance).addReservedRange(builder);
                return this;
            }

            public Builder addReservedRange(int i, ReservedRange.Builder builder) {
                copyOnWrite();
                ((DescriptorProto) this.instance).addReservedRange(i, builder);
                return this;
            }

            public Builder addAllReservedRange(Iterable<? extends ReservedRange> iterable) {
                copyOnWrite();
                ((DescriptorProto) this.instance).addAllReservedRange(iterable);
                return this;
            }

            public Builder clearReservedRange() {
                copyOnWrite();
                ((DescriptorProto) this.instance).clearReservedRange();
                return this;
            }

            public Builder removeReservedRange(int i) {
                copyOnWrite();
                ((DescriptorProto) this.instance).removeReservedRange(i);
                return this;
            }

            public List<String> getReservedNameList() {
                return Collections.unmodifiableList(((DescriptorProto) this.instance).getReservedNameList());
            }

            public int getReservedNameCount() {
                return ((DescriptorProto) this.instance).getReservedNameCount();
            }

            public String getReservedName(int i) {
                return ((DescriptorProto) this.instance).getReservedName(i);
            }

            public ByteString getReservedNameBytes(int i) {
                return ((DescriptorProto) this.instance).getReservedNameBytes(i);
            }

            public Builder setReservedName(int i, String str) {
                copyOnWrite();
                ((DescriptorProto) this.instance).setReservedName(i, str);
                return this;
            }

            public Builder addReservedName(String str) {
                copyOnWrite();
                ((DescriptorProto) this.instance).addReservedName(str);
                return this;
            }

            public Builder addAllReservedName(Iterable<String> iterable) {
                copyOnWrite();
                ((DescriptorProto) this.instance).addAllReservedName(iterable);
                return this;
            }

            public Builder clearReservedName() {
                copyOnWrite();
                ((DescriptorProto) this.instance).clearReservedName();
                return this;
            }

            public Builder addReservedNameBytes(ByteString byteString) {
                copyOnWrite();
                ((DescriptorProto) this.instance).addReservedNameBytes(byteString);
                return this;
            }
        }

        /* access modifiers changed from: protected */
        public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            boolean z = false;
            switch (methodToInvoke) {
                case NEW_MUTABLE_INSTANCE:
                    return new DescriptorProto();
                case IS_INITIALIZED:
                    byte b = this.memoizedIsInitialized;
                    if (b == 1) {
                        return DEFAULT_INSTANCE;
                    }
                    if (b == 0) {
                        return null;
                    }
                    boolean booleanValue = ((Boolean) obj).booleanValue();
                    for (int i = 0; i < getFieldCount(); i++) {
                        if (!getField(i).isInitialized()) {
                            if (booleanValue) {
                                this.memoizedIsInitialized = 0;
                            }
                            return null;
                        }
                    }
                    for (int i2 = 0; i2 < getExtensionCount(); i2++) {
                        if (!getExtension(i2).isInitialized()) {
                            if (booleanValue) {
                                this.memoizedIsInitialized = 0;
                            }
                            return null;
                        }
                    }
                    for (int i3 = 0; i3 < getNestedTypeCount(); i3++) {
                        if (!getNestedType(i3).isInitialized()) {
                            if (booleanValue) {
                                this.memoizedIsInitialized = 0;
                            }
                            return null;
                        }
                    }
                    for (int i4 = 0; i4 < getEnumTypeCount(); i4++) {
                        if (!getEnumType(i4).isInitialized()) {
                            if (booleanValue) {
                                this.memoizedIsInitialized = 0;
                            }
                            return null;
                        }
                    }
                    for (int i5 = 0; i5 < getExtensionRangeCount(); i5++) {
                        if (!getExtensionRange(i5).isInitialized()) {
                            if (booleanValue) {
                                this.memoizedIsInitialized = 0;
                            }
                            return null;
                        }
                    }
                    for (int i6 = 0; i6 < getOneofDeclCount(); i6++) {
                        if (!getOneofDecl(i6).isInitialized()) {
                            if (booleanValue) {
                                this.memoizedIsInitialized = 0;
                            }
                            return null;
                        }
                    }
                    if (!hasOptions() || getOptions().isInitialized()) {
                        if (booleanValue) {
                            this.memoizedIsInitialized = 1;
                        }
                        return DEFAULT_INSTANCE;
                    }
                    if (booleanValue) {
                        this.memoizedIsInitialized = 0;
                    }
                    return null;
                case MAKE_IMMUTABLE:
                    this.field_.makeImmutable();
                    this.extension_.makeImmutable();
                    this.nestedType_.makeImmutable();
                    this.enumType_.makeImmutable();
                    this.extensionRange_.makeImmutable();
                    this.oneofDecl_.makeImmutable();
                    this.reservedRange_.makeImmutable();
                    this.reservedName_.makeImmutable();
                    return null;
                case NEW_BUILDER:
                    return new Builder();
                case VISIT:
                    GeneratedMessageLite.Visitor visitor = (GeneratedMessageLite.Visitor) obj;
                    DescriptorProto descriptorProto = (DescriptorProto) obj2;
                    this.name_ = visitor.visitString(hasName(), this.name_, descriptorProto.hasName(), descriptorProto.name_);
                    this.field_ = visitor.visitList(this.field_, descriptorProto.field_);
                    this.extension_ = visitor.visitList(this.extension_, descriptorProto.extension_);
                    this.nestedType_ = visitor.visitList(this.nestedType_, descriptorProto.nestedType_);
                    this.enumType_ = visitor.visitList(this.enumType_, descriptorProto.enumType_);
                    this.extensionRange_ = visitor.visitList(this.extensionRange_, descriptorProto.extensionRange_);
                    this.oneofDecl_ = visitor.visitList(this.oneofDecl_, descriptorProto.oneofDecl_);
                    this.options_ = (MessageOptions) visitor.visitMessage(this.options_, descriptorProto.options_);
                    this.reservedRange_ = visitor.visitList(this.reservedRange_, descriptorProto.reservedRange_);
                    this.reservedName_ = visitor.visitList(this.reservedName_, descriptorProto.reservedName_);
                    if (visitor == GeneratedMessageLite.MergeFromVisitor.INSTANCE) {
                        this.bitField0_ |= descriptorProto.bitField0_;
                    }
                    return this;
                case MERGE_FROM_STREAM:
                    CodedInputStream codedInputStream = (CodedInputStream) obj;
                    ExtensionRegistryLite extensionRegistryLite = (ExtensionRegistryLite) obj2;
                    while (!z) {
                        try {
                            int readTag = codedInputStream.readTag();
                            switch (readTag) {
                                case 0:
                                    z = true;
                                    break;
                                case 10:
                                    String readString = codedInputStream.readString();
                                    this.bitField0_ |= 1;
                                    this.name_ = readString;
                                    break;
                                case 18:
                                    if (!this.field_.isModifiable()) {
                                        this.field_ = GeneratedMessageLite.mutableCopy(this.field_);
                                    }
                                    this.field_.add((FieldDescriptorProto) codedInputStream.readMessage(FieldDescriptorProto.parser(), extensionRegistryLite));
                                    break;
                                case 26:
                                    if (!this.nestedType_.isModifiable()) {
                                        this.nestedType_ = GeneratedMessageLite.mutableCopy(this.nestedType_);
                                    }
                                    this.nestedType_.add((DescriptorProto) codedInputStream.readMessage(parser(), extensionRegistryLite));
                                    break;
                                case 34:
                                    if (!this.enumType_.isModifiable()) {
                                        this.enumType_ = GeneratedMessageLite.mutableCopy(this.enumType_);
                                    }
                                    this.enumType_.add((EnumDescriptorProto) codedInputStream.readMessage(EnumDescriptorProto.parser(), extensionRegistryLite));
                                    break;
                                case 42:
                                    if (!this.extensionRange_.isModifiable()) {
                                        this.extensionRange_ = GeneratedMessageLite.mutableCopy(this.extensionRange_);
                                    }
                                    this.extensionRange_.add((ExtensionRange) codedInputStream.readMessage(ExtensionRange.parser(), extensionRegistryLite));
                                    break;
                                case 50:
                                    if (!this.extension_.isModifiable()) {
                                        this.extension_ = GeneratedMessageLite.mutableCopy(this.extension_);
                                    }
                                    this.extension_.add((FieldDescriptorProto) codedInputStream.readMessage(FieldDescriptorProto.parser(), extensionRegistryLite));
                                    break;
                                case 58:
                                    MessageOptions.Builder builder = (this.bitField0_ & 2) == 2 ? (MessageOptions.Builder) this.options_.toBuilder() : null;
                                    this.options_ = (MessageOptions) codedInputStream.readMessage(MessageOptions.parser(), extensionRegistryLite);
                                    if (builder != null) {
                                        builder.mergeFrom(this.options_);
                                        this.options_ = (MessageOptions) builder.buildPartial();
                                    }
                                    this.bitField0_ |= 2;
                                    break;
                                case 66:
                                    if (!this.oneofDecl_.isModifiable()) {
                                        this.oneofDecl_ = GeneratedMessageLite.mutableCopy(this.oneofDecl_);
                                    }
                                    this.oneofDecl_.add((OneofDescriptorProto) codedInputStream.readMessage(OneofDescriptorProto.parser(), extensionRegistryLite));
                                    break;
                                case 74:
                                    if (!this.reservedRange_.isModifiable()) {
                                        this.reservedRange_ = GeneratedMessageLite.mutableCopy(this.reservedRange_);
                                    }
                                    this.reservedRange_.add((ReservedRange) codedInputStream.readMessage(ReservedRange.parser(), extensionRegistryLite));
                                    break;
                                case 82:
                                    String readString2 = codedInputStream.readString();
                                    if (!this.reservedName_.isModifiable()) {
                                        this.reservedName_ = GeneratedMessageLite.mutableCopy(this.reservedName_);
                                    }
                                    this.reservedName_.add(readString2);
                                    break;
                                default:
                                    if (parseUnknownField(readTag, codedInputStream)) {
                                        break;
                                    }
                                    z = true;
                                    break;
                            }
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
                        synchronized (DescriptorProto.class) {
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

        public static DescriptorProto getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<DescriptorProto> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }
    }

    /* compiled from: com.google.firebase:protolite-well-known-types@@16.0.1 */
    public static final class ExtensionRangeOptions extends GeneratedMessageLite.ExtendableMessage<ExtensionRangeOptions, Builder> implements ExtensionRangeOptionsOrBuilder {
        /* access modifiers changed from: private */
        public static final ExtensionRangeOptions DEFAULT_INSTANCE = new ExtensionRangeOptions();
        private static volatile Parser<ExtensionRangeOptions> PARSER = null;
        public static final int UNINTERPRETED_OPTION_FIELD_NUMBER = 999;
        private byte memoizedIsInitialized = -1;
        private Internal.ProtobufList<UninterpretedOption> uninterpretedOption_ = emptyProtobufList();

        private ExtensionRangeOptions() {
        }

        public List<UninterpretedOption> getUninterpretedOptionList() {
            return this.uninterpretedOption_;
        }

        public List<? extends UninterpretedOptionOrBuilder> getUninterpretedOptionOrBuilderList() {
            return this.uninterpretedOption_;
        }

        public int getUninterpretedOptionCount() {
            return this.uninterpretedOption_.size();
        }

        public UninterpretedOption getUninterpretedOption(int i) {
            return (UninterpretedOption) this.uninterpretedOption_.get(i);
        }

        public UninterpretedOptionOrBuilder getUninterpretedOptionOrBuilder(int i) {
            return (UninterpretedOptionOrBuilder) this.uninterpretedOption_.get(i);
        }

        private void ensureUninterpretedOptionIsMutable() {
            if (!this.uninterpretedOption_.isModifiable()) {
                this.uninterpretedOption_ = GeneratedMessageLite.mutableCopy(this.uninterpretedOption_);
            }
        }

        /* access modifiers changed from: private */
        public void setUninterpretedOption(int i, UninterpretedOption uninterpretedOption) {
            if (uninterpretedOption != null) {
                ensureUninterpretedOptionIsMutable();
                this.uninterpretedOption_.set(i, uninterpretedOption);
                return;
            }
            throw new NullPointerException();
        }

        /* access modifiers changed from: private */
        public void setUninterpretedOption(int i, UninterpretedOption.Builder builder) {
            ensureUninterpretedOptionIsMutable();
            this.uninterpretedOption_.set(i, (UninterpretedOption) builder.build());
        }

        /* access modifiers changed from: private */
        public void addUninterpretedOption(UninterpretedOption uninterpretedOption) {
            if (uninterpretedOption != null) {
                ensureUninterpretedOptionIsMutable();
                this.uninterpretedOption_.add(uninterpretedOption);
                return;
            }
            throw new NullPointerException();
        }

        /* access modifiers changed from: private */
        public void addUninterpretedOption(int i, UninterpretedOption uninterpretedOption) {
            if (uninterpretedOption != null) {
                ensureUninterpretedOptionIsMutable();
                this.uninterpretedOption_.add(i, uninterpretedOption);
                return;
            }
            throw new NullPointerException();
        }

        /* access modifiers changed from: private */
        public void addUninterpretedOption(UninterpretedOption.Builder builder) {
            ensureUninterpretedOptionIsMutable();
            this.uninterpretedOption_.add((UninterpretedOption) builder.build());
        }

        /* access modifiers changed from: private */
        public void addUninterpretedOption(int i, UninterpretedOption.Builder builder) {
            ensureUninterpretedOptionIsMutable();
            this.uninterpretedOption_.add(i, (UninterpretedOption) builder.build());
        }

        /* access modifiers changed from: private */
        public void addAllUninterpretedOption(Iterable<? extends UninterpretedOption> iterable) {
            ensureUninterpretedOptionIsMutable();
            AbstractMessageLite.addAll(iterable, this.uninterpretedOption_);
        }

        /* access modifiers changed from: private */
        public void clearUninterpretedOption() {
            this.uninterpretedOption_ = emptyProtobufList();
        }

        /* access modifiers changed from: private */
        public void removeUninterpretedOption(int i) {
            ensureUninterpretedOptionIsMutable();
            this.uninterpretedOption_.remove(i);
        }

        public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
            GeneratedMessageLite.ExtendableMessage<MessageType, BuilderType>.ExtensionWriter newExtensionWriter = newExtensionWriter();
            for (int i = 0; i < this.uninterpretedOption_.size(); i++) {
                codedOutputStream.writeMessage(999, (MessageLite) this.uninterpretedOption_.get(i));
            }
            newExtensionWriter.writeUntil(PropertyOptions.DELETE_EXISTING, codedOutputStream);
            this.unknownFields.writeTo(codedOutputStream);
        }

        public int getSerializedSize() {
            int i = this.memoizedSerializedSize;
            if (i != -1) {
                return i;
            }
            int i2 = 0;
            for (int i3 = 0; i3 < this.uninterpretedOption_.size(); i3++) {
                i2 += CodedOutputStream.computeMessageSize(999, (MessageLite) this.uninterpretedOption_.get(i3));
            }
            int extensionsSerializedSize = i2 + extensionsSerializedSize() + this.unknownFields.getSerializedSize();
            this.memoizedSerializedSize = extensionsSerializedSize;
            return extensionsSerializedSize;
        }

        public static ExtensionRangeOptions parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return (ExtensionRangeOptions) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
        }

        public static ExtensionRangeOptions parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (ExtensionRangeOptions) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
        }

        public static ExtensionRangeOptions parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return (ExtensionRangeOptions) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
        }

        public static ExtensionRangeOptions parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (ExtensionRangeOptions) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
        }

        public static ExtensionRangeOptions parseFrom(InputStream inputStream) throws IOException {
            return (ExtensionRangeOptions) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static ExtensionRangeOptions parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (ExtensionRangeOptions) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static ExtensionRangeOptions parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (ExtensionRangeOptions) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static ExtensionRangeOptions parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (ExtensionRangeOptions) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static ExtensionRangeOptions parseFrom(CodedInputStream codedInputStream) throws IOException {
            return (ExtensionRangeOptions) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
        }

        public static ExtensionRangeOptions parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (ExtensionRangeOptions) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
        }

        public static Builder newBuilder() {
            return (Builder) DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(ExtensionRangeOptions extensionRangeOptions) {
            return (Builder) ((Builder) DEFAULT_INSTANCE.toBuilder()).mergeFrom(extensionRangeOptions);
        }

        /* compiled from: com.google.firebase:protolite-well-known-types@@16.0.1 */
        public static final class Builder extends GeneratedMessageLite.ExtendableBuilder<ExtensionRangeOptions, Builder> implements ExtensionRangeOptionsOrBuilder {
            private Builder() {
                super(ExtensionRangeOptions.DEFAULT_INSTANCE);
            }

            public List<UninterpretedOption> getUninterpretedOptionList() {
                return Collections.unmodifiableList(((ExtensionRangeOptions) this.instance).getUninterpretedOptionList());
            }

            public int getUninterpretedOptionCount() {
                return ((ExtensionRangeOptions) this.instance).getUninterpretedOptionCount();
            }

            public UninterpretedOption getUninterpretedOption(int i) {
                return ((ExtensionRangeOptions) this.instance).getUninterpretedOption(i);
            }

            public Builder setUninterpretedOption(int i, UninterpretedOption uninterpretedOption) {
                copyOnWrite();
                ((ExtensionRangeOptions) this.instance).setUninterpretedOption(i, uninterpretedOption);
                return this;
            }

            public Builder setUninterpretedOption(int i, UninterpretedOption.Builder builder) {
                copyOnWrite();
                ((ExtensionRangeOptions) this.instance).setUninterpretedOption(i, builder);
                return this;
            }

            public Builder addUninterpretedOption(UninterpretedOption uninterpretedOption) {
                copyOnWrite();
                ((ExtensionRangeOptions) this.instance).addUninterpretedOption(uninterpretedOption);
                return this;
            }

            public Builder addUninterpretedOption(int i, UninterpretedOption uninterpretedOption) {
                copyOnWrite();
                ((ExtensionRangeOptions) this.instance).addUninterpretedOption(i, uninterpretedOption);
                return this;
            }

            public Builder addUninterpretedOption(UninterpretedOption.Builder builder) {
                copyOnWrite();
                ((ExtensionRangeOptions) this.instance).addUninterpretedOption(builder);
                return this;
            }

            public Builder addUninterpretedOption(int i, UninterpretedOption.Builder builder) {
                copyOnWrite();
                ((ExtensionRangeOptions) this.instance).addUninterpretedOption(i, builder);
                return this;
            }

            public Builder addAllUninterpretedOption(Iterable<? extends UninterpretedOption> iterable) {
                copyOnWrite();
                ((ExtensionRangeOptions) this.instance).addAllUninterpretedOption(iterable);
                return this;
            }

            public Builder clearUninterpretedOption() {
                copyOnWrite();
                ((ExtensionRangeOptions) this.instance).clearUninterpretedOption();
                return this;
            }

            public Builder removeUninterpretedOption(int i) {
                copyOnWrite();
                ((ExtensionRangeOptions) this.instance).removeUninterpretedOption(i);
                return this;
            }
        }

        /* access modifiers changed from: protected */
        public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            boolean z = false;
            switch (methodToInvoke) {
                case NEW_MUTABLE_INSTANCE:
                    return new ExtensionRangeOptions();
                case IS_INITIALIZED:
                    byte b = this.memoizedIsInitialized;
                    if (b == 1) {
                        return DEFAULT_INSTANCE;
                    }
                    if (b == 0) {
                        return null;
                    }
                    boolean booleanValue = ((Boolean) obj).booleanValue();
                    for (int i = 0; i < getUninterpretedOptionCount(); i++) {
                        if (!getUninterpretedOption(i).isInitialized()) {
                            if (booleanValue) {
                                this.memoizedIsInitialized = 0;
                            }
                            return null;
                        }
                    }
                    if (!extensionsAreInitialized()) {
                        if (booleanValue) {
                            this.memoizedIsInitialized = 0;
                        }
                        return null;
                    }
                    if (booleanValue) {
                        this.memoizedIsInitialized = 1;
                    }
                    return DEFAULT_INSTANCE;
                case MAKE_IMMUTABLE:
                    this.uninterpretedOption_.makeImmutable();
                    return null;
                case NEW_BUILDER:
                    return new Builder();
                case VISIT:
                    this.uninterpretedOption_ = ((GeneratedMessageLite.Visitor) obj).visitList(this.uninterpretedOption_, ((ExtensionRangeOptions) obj2).uninterpretedOption_);
                    GeneratedMessageLite.MergeFromVisitor mergeFromVisitor = GeneratedMessageLite.MergeFromVisitor.INSTANCE;
                    return this;
                case MERGE_FROM_STREAM:
                    CodedInputStream codedInputStream = (CodedInputStream) obj;
                    ExtensionRegistryLite extensionRegistryLite = (ExtensionRegistryLite) obj2;
                    while (!z) {
                        try {
                            int readTag = codedInputStream.readTag();
                            if (readTag != 0) {
                                if (readTag == 7994) {
                                    if (!this.uninterpretedOption_.isModifiable()) {
                                        this.uninterpretedOption_ = GeneratedMessageLite.mutableCopy(this.uninterpretedOption_);
                                    }
                                    this.uninterpretedOption_.add((UninterpretedOption) codedInputStream.readMessage(UninterpretedOption.parser(), extensionRegistryLite));
                                } else if (!parseUnknownField((ExtensionRangeOptions) getDefaultInstanceForType(), codedInputStream, extensionRegistryLite, readTag)) {
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
                        synchronized (ExtensionRangeOptions.class) {
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

        public static ExtensionRangeOptions getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<ExtensionRangeOptions> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }
    }

    /* compiled from: com.google.firebase:protolite-well-known-types@@16.0.1 */
    public static final class FieldDescriptorProto extends GeneratedMessageLite<FieldDescriptorProto, Builder> implements FieldDescriptorProtoOrBuilder {
        /* access modifiers changed from: private */
        public static final FieldDescriptorProto DEFAULT_INSTANCE = new FieldDescriptorProto();
        public static final int DEFAULT_VALUE_FIELD_NUMBER = 7;
        public static final int EXTENDEE_FIELD_NUMBER = 2;
        public static final int JSON_NAME_FIELD_NUMBER = 10;
        public static final int LABEL_FIELD_NUMBER = 4;
        public static final int NAME_FIELD_NUMBER = 1;
        public static final int NUMBER_FIELD_NUMBER = 3;
        public static final int ONEOF_INDEX_FIELD_NUMBER = 9;
        public static final int OPTIONS_FIELD_NUMBER = 8;
        private static volatile Parser<FieldDescriptorProto> PARSER = null;
        public static final int TYPE_FIELD_NUMBER = 5;
        public static final int TYPE_NAME_FIELD_NUMBER = 6;
        private int bitField0_;
        private String defaultValue_ = "";
        private String extendee_ = "";
        private String jsonName_ = "";
        private int label_ = 1;
        private byte memoizedIsInitialized = -1;
        private String name_ = "";
        private int number_;
        private int oneofIndex_;
        private FieldOptions options_;
        private String typeName_ = "";
        private int type_ = 1;

        private FieldDescriptorProto() {
        }

        /* compiled from: com.google.firebase:protolite-well-known-types@@16.0.1 */
        public enum Type implements Internal.EnumLite {
            TYPE_DOUBLE(1),
            TYPE_FLOAT(2),
            TYPE_INT64(3),
            TYPE_UINT64(4),
            TYPE_INT32(5),
            TYPE_FIXED64(6),
            TYPE_FIXED32(7),
            TYPE_BOOL(8),
            TYPE_STRING(9),
            TYPE_GROUP(10),
            TYPE_MESSAGE(11),
            TYPE_BYTES(12),
            TYPE_UINT32(13),
            TYPE_ENUM(14),
            TYPE_SFIXED32(15),
            TYPE_SFIXED64(16),
            TYPE_SINT32(17),
            TYPE_SINT64(18);
            
            public static final int TYPE_BOOL_VALUE = 8;
            public static final int TYPE_BYTES_VALUE = 12;
            public static final int TYPE_DOUBLE_VALUE = 1;
            public static final int TYPE_ENUM_VALUE = 14;
            public static final int TYPE_FIXED32_VALUE = 7;
            public static final int TYPE_FIXED64_VALUE = 6;
            public static final int TYPE_FLOAT_VALUE = 2;
            public static final int TYPE_GROUP_VALUE = 10;
            public static final int TYPE_INT32_VALUE = 5;
            public static final int TYPE_INT64_VALUE = 3;
            public static final int TYPE_MESSAGE_VALUE = 11;
            public static final int TYPE_SFIXED32_VALUE = 15;
            public static final int TYPE_SFIXED64_VALUE = 16;
            public static final int TYPE_SINT32_VALUE = 17;
            public static final int TYPE_SINT64_VALUE = 18;
            public static final int TYPE_STRING_VALUE = 9;
            public static final int TYPE_UINT32_VALUE = 13;
            public static final int TYPE_UINT64_VALUE = 4;
            private static final Internal.EnumLiteMap<Type> internalValueMap = null;
            private final int value;

            static {
                internalValueMap = new Internal.EnumLiteMap<Type>() {
                    public Type findValueByNumber(int i) {
                        return Type.forNumber(i);
                    }
                };
            }

            public final int getNumber() {
                return this.value;
            }

            @Deprecated
            public static Type valueOf(int i) {
                return forNumber(i);
            }

            public static Type forNumber(int i) {
                switch (i) {
                    case 1:
                        return TYPE_DOUBLE;
                    case 2:
                        return TYPE_FLOAT;
                    case 3:
                        return TYPE_INT64;
                    case 4:
                        return TYPE_UINT64;
                    case 5:
                        return TYPE_INT32;
                    case 6:
                        return TYPE_FIXED64;
                    case 7:
                        return TYPE_FIXED32;
                    case 8:
                        return TYPE_BOOL;
                    case 9:
                        return TYPE_STRING;
                    case 10:
                        return TYPE_GROUP;
                    case 11:
                        return TYPE_MESSAGE;
                    case 12:
                        return TYPE_BYTES;
                    case 13:
                        return TYPE_UINT32;
                    case 14:
                        return TYPE_ENUM;
                    case 15:
                        return TYPE_SFIXED32;
                    case 16:
                        return TYPE_SFIXED64;
                    case 17:
                        return TYPE_SINT32;
                    case 18:
                        return TYPE_SINT64;
                    default:
                        return null;
                }
            }

            public static Internal.EnumLiteMap<Type> internalGetValueMap() {
                return internalValueMap;
            }

            private Type(int i) {
                this.value = i;
            }
        }

        /* compiled from: com.google.firebase:protolite-well-known-types@@16.0.1 */
        public enum Label implements Internal.EnumLite {
            LABEL_OPTIONAL(1),
            LABEL_REQUIRED(2),
            LABEL_REPEATED(3);
            
            public static final int LABEL_OPTIONAL_VALUE = 1;
            public static final int LABEL_REPEATED_VALUE = 3;
            public static final int LABEL_REQUIRED_VALUE = 2;
            private static final Internal.EnumLiteMap<Label> internalValueMap = null;
            private final int value;

            static {
                internalValueMap = new Internal.EnumLiteMap<Label>() {
                    public Label findValueByNumber(int i) {
                        return Label.forNumber(i);
                    }
                };
            }

            public final int getNumber() {
                return this.value;
            }

            @Deprecated
            public static Label valueOf(int i) {
                return forNumber(i);
            }

            public static Label forNumber(int i) {
                if (i == 1) {
                    return LABEL_OPTIONAL;
                }
                if (i == 2) {
                    return LABEL_REQUIRED;
                }
                if (i != 3) {
                    return null;
                }
                return LABEL_REPEATED;
            }

            public static Internal.EnumLiteMap<Label> internalGetValueMap() {
                return internalValueMap;
            }

            private Label(int i) {
                this.value = i;
            }
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

        public boolean hasNumber() {
            return (this.bitField0_ & 2) == 2;
        }

        public int getNumber() {
            return this.number_;
        }

        /* access modifiers changed from: private */
        public void setNumber(int i) {
            this.bitField0_ |= 2;
            this.number_ = i;
        }

        /* access modifiers changed from: private */
        public void clearNumber() {
            this.bitField0_ &= -3;
            this.number_ = 0;
        }

        public boolean hasLabel() {
            return (this.bitField0_ & 4) == 4;
        }

        public Label getLabel() {
            Label forNumber = Label.forNumber(this.label_);
            return forNumber == null ? Label.LABEL_OPTIONAL : forNumber;
        }

        /* access modifiers changed from: private */
        public void setLabel(Label label) {
            if (label != null) {
                this.bitField0_ |= 4;
                this.label_ = label.getNumber();
                return;
            }
            throw new NullPointerException();
        }

        /* access modifiers changed from: private */
        public void clearLabel() {
            this.bitField0_ &= -5;
            this.label_ = 1;
        }

        public boolean hasType() {
            return (this.bitField0_ & 8) == 8;
        }

        public Type getType() {
            Type forNumber = Type.forNumber(this.type_);
            return forNumber == null ? Type.TYPE_DOUBLE : forNumber;
        }

        /* access modifiers changed from: private */
        public void setType(Type type) {
            if (type != null) {
                this.bitField0_ |= 8;
                this.type_ = type.getNumber();
                return;
            }
            throw new NullPointerException();
        }

        /* access modifiers changed from: private */
        public void clearType() {
            this.bitField0_ &= -9;
            this.type_ = 1;
        }

        public boolean hasTypeName() {
            return (this.bitField0_ & 16) == 16;
        }

        public String getTypeName() {
            return this.typeName_;
        }

        public ByteString getTypeNameBytes() {
            return ByteString.copyFromUtf8(this.typeName_);
        }

        /* access modifiers changed from: private */
        public void setTypeName(String str) {
            if (str != null) {
                this.bitField0_ |= 16;
                this.typeName_ = str;
                return;
            }
            throw new NullPointerException();
        }

        /* access modifiers changed from: private */
        public void clearTypeName() {
            this.bitField0_ &= -17;
            this.typeName_ = getDefaultInstance().getTypeName();
        }

        /* access modifiers changed from: private */
        public void setTypeNameBytes(ByteString byteString) {
            if (byteString != null) {
                this.bitField0_ |= 16;
                this.typeName_ = byteString.toStringUtf8();
                return;
            }
            throw new NullPointerException();
        }

        public boolean hasExtendee() {
            return (this.bitField0_ & 32) == 32;
        }

        public String getExtendee() {
            return this.extendee_;
        }

        public ByteString getExtendeeBytes() {
            return ByteString.copyFromUtf8(this.extendee_);
        }

        /* access modifiers changed from: private */
        public void setExtendee(String str) {
            if (str != null) {
                this.bitField0_ |= 32;
                this.extendee_ = str;
                return;
            }
            throw new NullPointerException();
        }

        /* access modifiers changed from: private */
        public void clearExtendee() {
            this.bitField0_ &= -33;
            this.extendee_ = getDefaultInstance().getExtendee();
        }

        /* access modifiers changed from: private */
        public void setExtendeeBytes(ByteString byteString) {
            if (byteString != null) {
                this.bitField0_ |= 32;
                this.extendee_ = byteString.toStringUtf8();
                return;
            }
            throw new NullPointerException();
        }

        public boolean hasDefaultValue() {
            return (this.bitField0_ & 64) == 64;
        }

        public String getDefaultValue() {
            return this.defaultValue_;
        }

        public ByteString getDefaultValueBytes() {
            return ByteString.copyFromUtf8(this.defaultValue_);
        }

        /* access modifiers changed from: private */
        public void setDefaultValue(String str) {
            if (str != null) {
                this.bitField0_ |= 64;
                this.defaultValue_ = str;
                return;
            }
            throw new NullPointerException();
        }

        /* access modifiers changed from: private */
        public void clearDefaultValue() {
            this.bitField0_ &= -65;
            this.defaultValue_ = getDefaultInstance().getDefaultValue();
        }

        /* access modifiers changed from: private */
        public void setDefaultValueBytes(ByteString byteString) {
            if (byteString != null) {
                this.bitField0_ |= 64;
                this.defaultValue_ = byteString.toStringUtf8();
                return;
            }
            throw new NullPointerException();
        }

        public boolean hasOneofIndex() {
            return (this.bitField0_ & 128) == 128;
        }

        public int getOneofIndex() {
            return this.oneofIndex_;
        }

        /* access modifiers changed from: private */
        public void setOneofIndex(int i) {
            this.bitField0_ |= 128;
            this.oneofIndex_ = i;
        }

        /* access modifiers changed from: private */
        public void clearOneofIndex() {
            this.bitField0_ &= -129;
            this.oneofIndex_ = 0;
        }

        public boolean hasJsonName() {
            return (this.bitField0_ & 256) == 256;
        }

        public String getJsonName() {
            return this.jsonName_;
        }

        public ByteString getJsonNameBytes() {
            return ByteString.copyFromUtf8(this.jsonName_);
        }

        /* access modifiers changed from: private */
        public void setJsonName(String str) {
            if (str != null) {
                this.bitField0_ |= 256;
                this.jsonName_ = str;
                return;
            }
            throw new NullPointerException();
        }

        /* access modifiers changed from: private */
        public void clearJsonName() {
            this.bitField0_ &= -257;
            this.jsonName_ = getDefaultInstance().getJsonName();
        }

        /* access modifiers changed from: private */
        public void setJsonNameBytes(ByteString byteString) {
            if (byteString != null) {
                this.bitField0_ |= 256;
                this.jsonName_ = byteString.toStringUtf8();
                return;
            }
            throw new NullPointerException();
        }

        public boolean hasOptions() {
            return (this.bitField0_ & 512) == 512;
        }

        public FieldOptions getOptions() {
            FieldOptions fieldOptions = this.options_;
            return fieldOptions == null ? FieldOptions.getDefaultInstance() : fieldOptions;
        }

        /* access modifiers changed from: private */
        public void setOptions(FieldOptions fieldOptions) {
            if (fieldOptions != null) {
                this.options_ = fieldOptions;
                this.bitField0_ |= 512;
                return;
            }
            throw new NullPointerException();
        }

        /* access modifiers changed from: private */
        public void setOptions(FieldOptions.Builder builder) {
            this.options_ = (FieldOptions) builder.build();
            this.bitField0_ |= 512;
        }

        /* access modifiers changed from: private */
        public void mergeOptions(FieldOptions fieldOptions) {
            FieldOptions fieldOptions2 = this.options_;
            if (fieldOptions2 == null || fieldOptions2 == FieldOptions.getDefaultInstance()) {
                this.options_ = fieldOptions;
            } else {
                this.options_ = (FieldOptions) ((FieldOptions.Builder) FieldOptions.newBuilder(this.options_).mergeFrom(fieldOptions)).buildPartial();
            }
            this.bitField0_ |= 512;
        }

        /* access modifiers changed from: private */
        public void clearOptions() {
            this.options_ = null;
            this.bitField0_ &= -513;
        }

        public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
            if ((this.bitField0_ & 1) == 1) {
                codedOutputStream.writeString(1, getName());
            }
            if ((this.bitField0_ & 32) == 32) {
                codedOutputStream.writeString(2, getExtendee());
            }
            if ((this.bitField0_ & 2) == 2) {
                codedOutputStream.writeInt32(3, this.number_);
            }
            if ((this.bitField0_ & 4) == 4) {
                codedOutputStream.writeEnum(4, this.label_);
            }
            if ((this.bitField0_ & 8) == 8) {
                codedOutputStream.writeEnum(5, this.type_);
            }
            if ((this.bitField0_ & 16) == 16) {
                codedOutputStream.writeString(6, getTypeName());
            }
            if ((this.bitField0_ & 64) == 64) {
                codedOutputStream.writeString(7, getDefaultValue());
            }
            if ((this.bitField0_ & 512) == 512) {
                codedOutputStream.writeMessage(8, getOptions());
            }
            if ((this.bitField0_ & 128) == 128) {
                codedOutputStream.writeInt32(9, this.oneofIndex_);
            }
            if ((this.bitField0_ & 256) == 256) {
                codedOutputStream.writeString(10, getJsonName());
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
            if ((this.bitField0_ & 32) == 32) {
                i2 += CodedOutputStream.computeStringSize(2, getExtendee());
            }
            if ((this.bitField0_ & 2) == 2) {
                i2 += CodedOutputStream.computeInt32Size(3, this.number_);
            }
            if ((this.bitField0_ & 4) == 4) {
                i2 += CodedOutputStream.computeEnumSize(4, this.label_);
            }
            if ((this.bitField0_ & 8) == 8) {
                i2 += CodedOutputStream.computeEnumSize(5, this.type_);
            }
            if ((this.bitField0_ & 16) == 16) {
                i2 += CodedOutputStream.computeStringSize(6, getTypeName());
            }
            if ((this.bitField0_ & 64) == 64) {
                i2 += CodedOutputStream.computeStringSize(7, getDefaultValue());
            }
            if ((this.bitField0_ & 512) == 512) {
                i2 += CodedOutputStream.computeMessageSize(8, getOptions());
            }
            if ((this.bitField0_ & 128) == 128) {
                i2 += CodedOutputStream.computeInt32Size(9, this.oneofIndex_);
            }
            if ((this.bitField0_ & 256) == 256) {
                i2 += CodedOutputStream.computeStringSize(10, getJsonName());
            }
            int serializedSize = i2 + this.unknownFields.getSerializedSize();
            this.memoizedSerializedSize = serializedSize;
            return serializedSize;
        }

        public static FieldDescriptorProto parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return (FieldDescriptorProto) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
        }

        public static FieldDescriptorProto parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (FieldDescriptorProto) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
        }

        public static FieldDescriptorProto parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return (FieldDescriptorProto) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
        }

        public static FieldDescriptorProto parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (FieldDescriptorProto) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
        }

        public static FieldDescriptorProto parseFrom(InputStream inputStream) throws IOException {
            return (FieldDescriptorProto) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static FieldDescriptorProto parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (FieldDescriptorProto) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static FieldDescriptorProto parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (FieldDescriptorProto) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static FieldDescriptorProto parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (FieldDescriptorProto) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static FieldDescriptorProto parseFrom(CodedInputStream codedInputStream) throws IOException {
            return (FieldDescriptorProto) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
        }

        public static FieldDescriptorProto parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (FieldDescriptorProto) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
        }

        public static Builder newBuilder() {
            return (Builder) DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(FieldDescriptorProto fieldDescriptorProto) {
            return (Builder) ((Builder) DEFAULT_INSTANCE.toBuilder()).mergeFrom(fieldDescriptorProto);
        }

        /* compiled from: com.google.firebase:protolite-well-known-types@@16.0.1 */
        public static final class Builder extends GeneratedMessageLite.Builder<FieldDescriptorProto, Builder> implements FieldDescriptorProtoOrBuilder {
            private Builder() {
                super(FieldDescriptorProto.DEFAULT_INSTANCE);
            }

            public boolean hasName() {
                return ((FieldDescriptorProto) this.instance).hasName();
            }

            public String getName() {
                return ((FieldDescriptorProto) this.instance).getName();
            }

            public ByteString getNameBytes() {
                return ((FieldDescriptorProto) this.instance).getNameBytes();
            }

            public Builder setName(String str) {
                copyOnWrite();
                ((FieldDescriptorProto) this.instance).setName(str);
                return this;
            }

            public Builder clearName() {
                copyOnWrite();
                ((FieldDescriptorProto) this.instance).clearName();
                return this;
            }

            public Builder setNameBytes(ByteString byteString) {
                copyOnWrite();
                ((FieldDescriptorProto) this.instance).setNameBytes(byteString);
                return this;
            }

            public boolean hasNumber() {
                return ((FieldDescriptorProto) this.instance).hasNumber();
            }

            public int getNumber() {
                return ((FieldDescriptorProto) this.instance).getNumber();
            }

            public Builder setNumber(int i) {
                copyOnWrite();
                ((FieldDescriptorProto) this.instance).setNumber(i);
                return this;
            }

            public Builder clearNumber() {
                copyOnWrite();
                ((FieldDescriptorProto) this.instance).clearNumber();
                return this;
            }

            public boolean hasLabel() {
                return ((FieldDescriptorProto) this.instance).hasLabel();
            }

            public Label getLabel() {
                return ((FieldDescriptorProto) this.instance).getLabel();
            }

            public Builder setLabel(Label label) {
                copyOnWrite();
                ((FieldDescriptorProto) this.instance).setLabel(label);
                return this;
            }

            public Builder clearLabel() {
                copyOnWrite();
                ((FieldDescriptorProto) this.instance).clearLabel();
                return this;
            }

            public boolean hasType() {
                return ((FieldDescriptorProto) this.instance).hasType();
            }

            public Type getType() {
                return ((FieldDescriptorProto) this.instance).getType();
            }

            public Builder setType(Type type) {
                copyOnWrite();
                ((FieldDescriptorProto) this.instance).setType(type);
                return this;
            }

            public Builder clearType() {
                copyOnWrite();
                ((FieldDescriptorProto) this.instance).clearType();
                return this;
            }

            public boolean hasTypeName() {
                return ((FieldDescriptorProto) this.instance).hasTypeName();
            }

            public String getTypeName() {
                return ((FieldDescriptorProto) this.instance).getTypeName();
            }

            public ByteString getTypeNameBytes() {
                return ((FieldDescriptorProto) this.instance).getTypeNameBytes();
            }

            public Builder setTypeName(String str) {
                copyOnWrite();
                ((FieldDescriptorProto) this.instance).setTypeName(str);
                return this;
            }

            public Builder clearTypeName() {
                copyOnWrite();
                ((FieldDescriptorProto) this.instance).clearTypeName();
                return this;
            }

            public Builder setTypeNameBytes(ByteString byteString) {
                copyOnWrite();
                ((FieldDescriptorProto) this.instance).setTypeNameBytes(byteString);
                return this;
            }

            public boolean hasExtendee() {
                return ((FieldDescriptorProto) this.instance).hasExtendee();
            }

            public String getExtendee() {
                return ((FieldDescriptorProto) this.instance).getExtendee();
            }

            public ByteString getExtendeeBytes() {
                return ((FieldDescriptorProto) this.instance).getExtendeeBytes();
            }

            public Builder setExtendee(String str) {
                copyOnWrite();
                ((FieldDescriptorProto) this.instance).setExtendee(str);
                return this;
            }

            public Builder clearExtendee() {
                copyOnWrite();
                ((FieldDescriptorProto) this.instance).clearExtendee();
                return this;
            }

            public Builder setExtendeeBytes(ByteString byteString) {
                copyOnWrite();
                ((FieldDescriptorProto) this.instance).setExtendeeBytes(byteString);
                return this;
            }

            public boolean hasDefaultValue() {
                return ((FieldDescriptorProto) this.instance).hasDefaultValue();
            }

            public String getDefaultValue() {
                return ((FieldDescriptorProto) this.instance).getDefaultValue();
            }

            public ByteString getDefaultValueBytes() {
                return ((FieldDescriptorProto) this.instance).getDefaultValueBytes();
            }

            public Builder setDefaultValue(String str) {
                copyOnWrite();
                ((FieldDescriptorProto) this.instance).setDefaultValue(str);
                return this;
            }

            public Builder clearDefaultValue() {
                copyOnWrite();
                ((FieldDescriptorProto) this.instance).clearDefaultValue();
                return this;
            }

            public Builder setDefaultValueBytes(ByteString byteString) {
                copyOnWrite();
                ((FieldDescriptorProto) this.instance).setDefaultValueBytes(byteString);
                return this;
            }

            public boolean hasOneofIndex() {
                return ((FieldDescriptorProto) this.instance).hasOneofIndex();
            }

            public int getOneofIndex() {
                return ((FieldDescriptorProto) this.instance).getOneofIndex();
            }

            public Builder setOneofIndex(int i) {
                copyOnWrite();
                ((FieldDescriptorProto) this.instance).setOneofIndex(i);
                return this;
            }

            public Builder clearOneofIndex() {
                copyOnWrite();
                ((FieldDescriptorProto) this.instance).clearOneofIndex();
                return this;
            }

            public boolean hasJsonName() {
                return ((FieldDescriptorProto) this.instance).hasJsonName();
            }

            public String getJsonName() {
                return ((FieldDescriptorProto) this.instance).getJsonName();
            }

            public ByteString getJsonNameBytes() {
                return ((FieldDescriptorProto) this.instance).getJsonNameBytes();
            }

            public Builder setJsonName(String str) {
                copyOnWrite();
                ((FieldDescriptorProto) this.instance).setJsonName(str);
                return this;
            }

            public Builder clearJsonName() {
                copyOnWrite();
                ((FieldDescriptorProto) this.instance).clearJsonName();
                return this;
            }

            public Builder setJsonNameBytes(ByteString byteString) {
                copyOnWrite();
                ((FieldDescriptorProto) this.instance).setJsonNameBytes(byteString);
                return this;
            }

            public boolean hasOptions() {
                return ((FieldDescriptorProto) this.instance).hasOptions();
            }

            public FieldOptions getOptions() {
                return ((FieldDescriptorProto) this.instance).getOptions();
            }

            public Builder setOptions(FieldOptions fieldOptions) {
                copyOnWrite();
                ((FieldDescriptorProto) this.instance).setOptions(fieldOptions);
                return this;
            }

            public Builder setOptions(FieldOptions.Builder builder) {
                copyOnWrite();
                ((FieldDescriptorProto) this.instance).setOptions(builder);
                return this;
            }

            public Builder mergeOptions(FieldOptions fieldOptions) {
                copyOnWrite();
                ((FieldDescriptorProto) this.instance).mergeOptions(fieldOptions);
                return this;
            }

            public Builder clearOptions() {
                copyOnWrite();
                ((FieldDescriptorProto) this.instance).clearOptions();
                return this;
            }
        }

        /* access modifiers changed from: protected */
        public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            boolean z = false;
            switch (methodToInvoke) {
                case NEW_MUTABLE_INSTANCE:
                    return new FieldDescriptorProto();
                case IS_INITIALIZED:
                    byte b = this.memoizedIsInitialized;
                    if (b == 1) {
                        return DEFAULT_INSTANCE;
                    }
                    if (b == 0) {
                        return null;
                    }
                    boolean booleanValue = ((Boolean) obj).booleanValue();
                    if (!hasOptions() || getOptions().isInitialized()) {
                        if (booleanValue) {
                            this.memoizedIsInitialized = 1;
                        }
                        return DEFAULT_INSTANCE;
                    }
                    if (booleanValue) {
                        this.memoizedIsInitialized = 0;
                    }
                    return null;
                case MAKE_IMMUTABLE:
                    return null;
                case NEW_BUILDER:
                    return new Builder();
                case VISIT:
                    GeneratedMessageLite.Visitor visitor = (GeneratedMessageLite.Visitor) obj;
                    FieldDescriptorProto fieldDescriptorProto = (FieldDescriptorProto) obj2;
                    this.name_ = visitor.visitString(hasName(), this.name_, fieldDescriptorProto.hasName(), fieldDescriptorProto.name_);
                    this.number_ = visitor.visitInt(hasNumber(), this.number_, fieldDescriptorProto.hasNumber(), fieldDescriptorProto.number_);
                    this.label_ = visitor.visitInt(hasLabel(), this.label_, fieldDescriptorProto.hasLabel(), fieldDescriptorProto.label_);
                    this.type_ = visitor.visitInt(hasType(), this.type_, fieldDescriptorProto.hasType(), fieldDescriptorProto.type_);
                    this.typeName_ = visitor.visitString(hasTypeName(), this.typeName_, fieldDescriptorProto.hasTypeName(), fieldDescriptorProto.typeName_);
                    this.extendee_ = visitor.visitString(hasExtendee(), this.extendee_, fieldDescriptorProto.hasExtendee(), fieldDescriptorProto.extendee_);
                    this.defaultValue_ = visitor.visitString(hasDefaultValue(), this.defaultValue_, fieldDescriptorProto.hasDefaultValue(), fieldDescriptorProto.defaultValue_);
                    this.oneofIndex_ = visitor.visitInt(hasOneofIndex(), this.oneofIndex_, fieldDescriptorProto.hasOneofIndex(), fieldDescriptorProto.oneofIndex_);
                    this.jsonName_ = visitor.visitString(hasJsonName(), this.jsonName_, fieldDescriptorProto.hasJsonName(), fieldDescriptorProto.jsonName_);
                    this.options_ = (FieldOptions) visitor.visitMessage(this.options_, fieldDescriptorProto.options_);
                    if (visitor == GeneratedMessageLite.MergeFromVisitor.INSTANCE) {
                        this.bitField0_ |= fieldDescriptorProto.bitField0_;
                    }
                    return this;
                case MERGE_FROM_STREAM:
                    CodedInputStream codedInputStream = (CodedInputStream) obj;
                    ExtensionRegistryLite extensionRegistryLite = (ExtensionRegistryLite) obj2;
                    while (!z) {
                        try {
                            int readTag = codedInputStream.readTag();
                            switch (readTag) {
                                case 0:
                                    z = true;
                                    break;
                                case 10:
                                    String readString = codedInputStream.readString();
                                    this.bitField0_ |= 1;
                                    this.name_ = readString;
                                    break;
                                case 18:
                                    String readString2 = codedInputStream.readString();
                                    this.bitField0_ |= 32;
                                    this.extendee_ = readString2;
                                    break;
                                case 24:
                                    this.bitField0_ |= 2;
                                    this.number_ = codedInputStream.readInt32();
                                    break;
                                case 32:
                                    int readEnum = codedInputStream.readEnum();
                                    if (Label.forNumber(readEnum) != null) {
                                        this.bitField0_ |= 4;
                                        this.label_ = readEnum;
                                        break;
                                    } else {
                                        super.mergeVarintField(4, readEnum);
                                        break;
                                    }
                                case 40:
                                    int readEnum2 = codedInputStream.readEnum();
                                    if (Type.forNumber(readEnum2) != null) {
                                        this.bitField0_ |= 8;
                                        this.type_ = readEnum2;
                                        break;
                                    } else {
                                        super.mergeVarintField(5, readEnum2);
                                        break;
                                    }
                                case 50:
                                    String readString3 = codedInputStream.readString();
                                    this.bitField0_ |= 16;
                                    this.typeName_ = readString3;
                                    break;
                                case 58:
                                    String readString4 = codedInputStream.readString();
                                    this.bitField0_ |= 64;
                                    this.defaultValue_ = readString4;
                                    break;
                                case 66:
                                    FieldOptions.Builder builder = (this.bitField0_ & 512) == 512 ? (FieldOptions.Builder) this.options_.toBuilder() : null;
                                    this.options_ = (FieldOptions) codedInputStream.readMessage(FieldOptions.parser(), extensionRegistryLite);
                                    if (builder != null) {
                                        builder.mergeFrom(this.options_);
                                        this.options_ = (FieldOptions) builder.buildPartial();
                                    }
                                    this.bitField0_ |= 512;
                                    break;
                                case 72:
                                    this.bitField0_ |= 128;
                                    this.oneofIndex_ = codedInputStream.readInt32();
                                    break;
                                case 82:
                                    String readString5 = codedInputStream.readString();
                                    this.bitField0_ |= 256;
                                    this.jsonName_ = readString5;
                                    break;
                                default:
                                    if (parseUnknownField(readTag, codedInputStream)) {
                                        break;
                                    }
                                    z = true;
                                    break;
                            }
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
                        synchronized (FieldDescriptorProto.class) {
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

        public static FieldDescriptorProto getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<FieldDescriptorProto> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }
    }

    /* compiled from: com.google.firebase:protolite-well-known-types@@16.0.1 */
    public static final class OneofDescriptorProto extends GeneratedMessageLite<OneofDescriptorProto, Builder> implements OneofDescriptorProtoOrBuilder {
        /* access modifiers changed from: private */
        public static final OneofDescriptorProto DEFAULT_INSTANCE = new OneofDescriptorProto();
        public static final int NAME_FIELD_NUMBER = 1;
        public static final int OPTIONS_FIELD_NUMBER = 2;
        private static volatile Parser<OneofDescriptorProto> PARSER;
        private int bitField0_;
        private byte memoizedIsInitialized = -1;
        private String name_ = "";
        private OneofOptions options_;

        private OneofDescriptorProto() {
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

        public boolean hasOptions() {
            return (this.bitField0_ & 2) == 2;
        }

        public OneofOptions getOptions() {
            OneofOptions oneofOptions = this.options_;
            return oneofOptions == null ? OneofOptions.getDefaultInstance() : oneofOptions;
        }

        /* access modifiers changed from: private */
        public void setOptions(OneofOptions oneofOptions) {
            if (oneofOptions != null) {
                this.options_ = oneofOptions;
                this.bitField0_ |= 2;
                return;
            }
            throw new NullPointerException();
        }

        /* access modifiers changed from: private */
        public void setOptions(OneofOptions.Builder builder) {
            this.options_ = (OneofOptions) builder.build();
            this.bitField0_ |= 2;
        }

        /* access modifiers changed from: private */
        public void mergeOptions(OneofOptions oneofOptions) {
            OneofOptions oneofOptions2 = this.options_;
            if (oneofOptions2 == null || oneofOptions2 == OneofOptions.getDefaultInstance()) {
                this.options_ = oneofOptions;
            } else {
                this.options_ = (OneofOptions) ((OneofOptions.Builder) OneofOptions.newBuilder(this.options_).mergeFrom(oneofOptions)).buildPartial();
            }
            this.bitField0_ |= 2;
        }

        /* access modifiers changed from: private */
        public void clearOptions() {
            this.options_ = null;
            this.bitField0_ &= -3;
        }

        public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
            if ((this.bitField0_ & 1) == 1) {
                codedOutputStream.writeString(1, getName());
            }
            if ((this.bitField0_ & 2) == 2) {
                codedOutputStream.writeMessage(2, getOptions());
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
                i2 += CodedOutputStream.computeMessageSize(2, getOptions());
            }
            int serializedSize = i2 + this.unknownFields.getSerializedSize();
            this.memoizedSerializedSize = serializedSize;
            return serializedSize;
        }

        public static OneofDescriptorProto parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return (OneofDescriptorProto) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
        }

        public static OneofDescriptorProto parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (OneofDescriptorProto) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
        }

        public static OneofDescriptorProto parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return (OneofDescriptorProto) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
        }

        public static OneofDescriptorProto parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (OneofDescriptorProto) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
        }

        public static OneofDescriptorProto parseFrom(InputStream inputStream) throws IOException {
            return (OneofDescriptorProto) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static OneofDescriptorProto parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (OneofDescriptorProto) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static OneofDescriptorProto parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (OneofDescriptorProto) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static OneofDescriptorProto parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (OneofDescriptorProto) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static OneofDescriptorProto parseFrom(CodedInputStream codedInputStream) throws IOException {
            return (OneofDescriptorProto) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
        }

        public static OneofDescriptorProto parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (OneofDescriptorProto) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
        }

        public static Builder newBuilder() {
            return (Builder) DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(OneofDescriptorProto oneofDescriptorProto) {
            return (Builder) ((Builder) DEFAULT_INSTANCE.toBuilder()).mergeFrom(oneofDescriptorProto);
        }

        /* compiled from: com.google.firebase:protolite-well-known-types@@16.0.1 */
        public static final class Builder extends GeneratedMessageLite.Builder<OneofDescriptorProto, Builder> implements OneofDescriptorProtoOrBuilder {
            private Builder() {
                super(OneofDescriptorProto.DEFAULT_INSTANCE);
            }

            public boolean hasName() {
                return ((OneofDescriptorProto) this.instance).hasName();
            }

            public String getName() {
                return ((OneofDescriptorProto) this.instance).getName();
            }

            public ByteString getNameBytes() {
                return ((OneofDescriptorProto) this.instance).getNameBytes();
            }

            public Builder setName(String str) {
                copyOnWrite();
                ((OneofDescriptorProto) this.instance).setName(str);
                return this;
            }

            public Builder clearName() {
                copyOnWrite();
                ((OneofDescriptorProto) this.instance).clearName();
                return this;
            }

            public Builder setNameBytes(ByteString byteString) {
                copyOnWrite();
                ((OneofDescriptorProto) this.instance).setNameBytes(byteString);
                return this;
            }

            public boolean hasOptions() {
                return ((OneofDescriptorProto) this.instance).hasOptions();
            }

            public OneofOptions getOptions() {
                return ((OneofDescriptorProto) this.instance).getOptions();
            }

            public Builder setOptions(OneofOptions oneofOptions) {
                copyOnWrite();
                ((OneofDescriptorProto) this.instance).setOptions(oneofOptions);
                return this;
            }

            public Builder setOptions(OneofOptions.Builder builder) {
                copyOnWrite();
                ((OneofDescriptorProto) this.instance).setOptions(builder);
                return this;
            }

            public Builder mergeOptions(OneofOptions oneofOptions) {
                copyOnWrite();
                ((OneofDescriptorProto) this.instance).mergeOptions(oneofOptions);
                return this;
            }

            public Builder clearOptions() {
                copyOnWrite();
                ((OneofDescriptorProto) this.instance).clearOptions();
                return this;
            }
        }

        /* access modifiers changed from: protected */
        public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            boolean z = false;
            switch (methodToInvoke) {
                case NEW_MUTABLE_INSTANCE:
                    return new OneofDescriptorProto();
                case IS_INITIALIZED:
                    byte b = this.memoizedIsInitialized;
                    if (b == 1) {
                        return DEFAULT_INSTANCE;
                    }
                    if (b == 0) {
                        return null;
                    }
                    boolean booleanValue = ((Boolean) obj).booleanValue();
                    if (!hasOptions() || getOptions().isInitialized()) {
                        if (booleanValue) {
                            this.memoizedIsInitialized = 1;
                        }
                        return DEFAULT_INSTANCE;
                    }
                    if (booleanValue) {
                        this.memoizedIsInitialized = 0;
                    }
                    return null;
                case MAKE_IMMUTABLE:
                    return null;
                case NEW_BUILDER:
                    return new Builder();
                case VISIT:
                    GeneratedMessageLite.Visitor visitor = (GeneratedMessageLite.Visitor) obj;
                    OneofDescriptorProto oneofDescriptorProto = (OneofDescriptorProto) obj2;
                    this.name_ = visitor.visitString(hasName(), this.name_, oneofDescriptorProto.hasName(), oneofDescriptorProto.name_);
                    this.options_ = (OneofOptions) visitor.visitMessage(this.options_, oneofDescriptorProto.options_);
                    if (visitor == GeneratedMessageLite.MergeFromVisitor.INSTANCE) {
                        this.bitField0_ |= oneofDescriptorProto.bitField0_;
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
                                    this.bitField0_ |= 1;
                                    this.name_ = readString;
                                } else if (readTag == 18) {
                                    OneofOptions.Builder builder = (this.bitField0_ & 2) == 2 ? (OneofOptions.Builder) this.options_.toBuilder() : null;
                                    this.options_ = (OneofOptions) codedInputStream.readMessage(OneofOptions.parser(), extensionRegistryLite);
                                    if (builder != null) {
                                        builder.mergeFrom(this.options_);
                                        this.options_ = (OneofOptions) builder.buildPartial();
                                    }
                                    this.bitField0_ |= 2;
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
                        synchronized (OneofDescriptorProto.class) {
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

        public static OneofDescriptorProto getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<OneofDescriptorProto> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }
    }

    /* compiled from: com.google.firebase:protolite-well-known-types@@16.0.1 */
    public static final class EnumDescriptorProto extends GeneratedMessageLite<EnumDescriptorProto, Builder> implements EnumDescriptorProtoOrBuilder {
        /* access modifiers changed from: private */
        public static final EnumDescriptorProto DEFAULT_INSTANCE = new EnumDescriptorProto();
        public static final int NAME_FIELD_NUMBER = 1;
        public static final int OPTIONS_FIELD_NUMBER = 3;
        private static volatile Parser<EnumDescriptorProto> PARSER = null;
        public static final int RESERVED_NAME_FIELD_NUMBER = 5;
        public static final int RESERVED_RANGE_FIELD_NUMBER = 4;
        public static final int VALUE_FIELD_NUMBER = 2;
        private int bitField0_;
        private byte memoizedIsInitialized = -1;
        private String name_ = "";
        private EnumOptions options_;
        private Internal.ProtobufList<String> reservedName_ = GeneratedMessageLite.emptyProtobufList();
        private Internal.ProtobufList<EnumReservedRange> reservedRange_ = emptyProtobufList();
        private Internal.ProtobufList<EnumValueDescriptorProto> value_ = emptyProtobufList();

        /* compiled from: com.google.firebase:protolite-well-known-types@@16.0.1 */
        public interface EnumReservedRangeOrBuilder extends MessageLiteOrBuilder {
            int getEnd();

            int getStart();

            boolean hasEnd();

            boolean hasStart();
        }

        private EnumDescriptorProto() {
        }

        /* compiled from: com.google.firebase:protolite-well-known-types@@16.0.1 */
        public static final class EnumReservedRange extends GeneratedMessageLite<EnumReservedRange, Builder> implements EnumReservedRangeOrBuilder {
            /* access modifiers changed from: private */
            public static final EnumReservedRange DEFAULT_INSTANCE = new EnumReservedRange();
            public static final int END_FIELD_NUMBER = 2;
            private static volatile Parser<EnumReservedRange> PARSER = null;
            public static final int START_FIELD_NUMBER = 1;
            private int bitField0_;
            private int end_;
            private int start_;

            private EnumReservedRange() {
            }

            public boolean hasStart() {
                return (this.bitField0_ & 1) == 1;
            }

            public int getStart() {
                return this.start_;
            }

            /* access modifiers changed from: private */
            public void setStart(int i) {
                this.bitField0_ |= 1;
                this.start_ = i;
            }

            /* access modifiers changed from: private */
            public void clearStart() {
                this.bitField0_ &= -2;
                this.start_ = 0;
            }

            public boolean hasEnd() {
                return (this.bitField0_ & 2) == 2;
            }

            public int getEnd() {
                return this.end_;
            }

            /* access modifiers changed from: private */
            public void setEnd(int i) {
                this.bitField0_ |= 2;
                this.end_ = i;
            }

            /* access modifiers changed from: private */
            public void clearEnd() {
                this.bitField0_ &= -3;
                this.end_ = 0;
            }

            public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
                if ((this.bitField0_ & 1) == 1) {
                    codedOutputStream.writeInt32(1, this.start_);
                }
                if ((this.bitField0_ & 2) == 2) {
                    codedOutputStream.writeInt32(2, this.end_);
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
                    i2 = 0 + CodedOutputStream.computeInt32Size(1, this.start_);
                }
                if ((this.bitField0_ & 2) == 2) {
                    i2 += CodedOutputStream.computeInt32Size(2, this.end_);
                }
                int serializedSize = i2 + this.unknownFields.getSerializedSize();
                this.memoizedSerializedSize = serializedSize;
                return serializedSize;
            }

            public static EnumReservedRange parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
                return (EnumReservedRange) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
            }

            public static EnumReservedRange parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return (EnumReservedRange) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
            }

            public static EnumReservedRange parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
                return (EnumReservedRange) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
            }

            public static EnumReservedRange parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return (EnumReservedRange) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
            }

            public static EnumReservedRange parseFrom(InputStream inputStream) throws IOException {
                return (EnumReservedRange) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
            }

            public static EnumReservedRange parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                return (EnumReservedRange) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
            }

            public static EnumReservedRange parseDelimitedFrom(InputStream inputStream) throws IOException {
                return (EnumReservedRange) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
            }

            public static EnumReservedRange parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                return (EnumReservedRange) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
            }

            public static EnumReservedRange parseFrom(CodedInputStream codedInputStream) throws IOException {
                return (EnumReservedRange) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
            }

            public static EnumReservedRange parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                return (EnumReservedRange) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
            }

            public static Builder newBuilder() {
                return (Builder) DEFAULT_INSTANCE.toBuilder();
            }

            public static Builder newBuilder(EnumReservedRange enumReservedRange) {
                return (Builder) ((Builder) DEFAULT_INSTANCE.toBuilder()).mergeFrom(enumReservedRange);
            }

            /* compiled from: com.google.firebase:protolite-well-known-types@@16.0.1 */
            public static final class Builder extends GeneratedMessageLite.Builder<EnumReservedRange, Builder> implements EnumReservedRangeOrBuilder {
                private Builder() {
                    super(EnumReservedRange.DEFAULT_INSTANCE);
                }

                public boolean hasStart() {
                    return ((EnumReservedRange) this.instance).hasStart();
                }

                public int getStart() {
                    return ((EnumReservedRange) this.instance).getStart();
                }

                public Builder setStart(int i) {
                    copyOnWrite();
                    ((EnumReservedRange) this.instance).setStart(i);
                    return this;
                }

                public Builder clearStart() {
                    copyOnWrite();
                    ((EnumReservedRange) this.instance).clearStart();
                    return this;
                }

                public boolean hasEnd() {
                    return ((EnumReservedRange) this.instance).hasEnd();
                }

                public int getEnd() {
                    return ((EnumReservedRange) this.instance).getEnd();
                }

                public Builder setEnd(int i) {
                    copyOnWrite();
                    ((EnumReservedRange) this.instance).setEnd(i);
                    return this;
                }

                public Builder clearEnd() {
                    copyOnWrite();
                    ((EnumReservedRange) this.instance).clearEnd();
                    return this;
                }
            }

            /* access modifiers changed from: protected */
            public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
                switch (methodToInvoke) {
                    case NEW_MUTABLE_INSTANCE:
                        return new EnumReservedRange();
                    case IS_INITIALIZED:
                        return DEFAULT_INSTANCE;
                    case MAKE_IMMUTABLE:
                        return null;
                    case NEW_BUILDER:
                        return new Builder();
                    case VISIT:
                        GeneratedMessageLite.Visitor visitor = (GeneratedMessageLite.Visitor) obj;
                        EnumReservedRange enumReservedRange = (EnumReservedRange) obj2;
                        this.start_ = visitor.visitInt(hasStart(), this.start_, enumReservedRange.hasStart(), enumReservedRange.start_);
                        this.end_ = visitor.visitInt(hasEnd(), this.end_, enumReservedRange.hasEnd(), enumReservedRange.end_);
                        if (visitor == GeneratedMessageLite.MergeFromVisitor.INSTANCE) {
                            this.bitField0_ |= enumReservedRange.bitField0_;
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
                                        this.start_ = codedInputStream.readInt32();
                                    } else if (readTag == 16) {
                                        this.bitField0_ |= 2;
                                        this.end_ = codedInputStream.readInt32();
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
                            synchronized (EnumReservedRange.class) {
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

            public static EnumReservedRange getDefaultInstance() {
                return DEFAULT_INSTANCE;
            }

            public static Parser<EnumReservedRange> parser() {
                return DEFAULT_INSTANCE.getParserForType();
            }
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

        public List<EnumValueDescriptorProto> getValueList() {
            return this.value_;
        }

        public List<? extends EnumValueDescriptorProtoOrBuilder> getValueOrBuilderList() {
            return this.value_;
        }

        public int getValueCount() {
            return this.value_.size();
        }

        public EnumValueDescriptorProto getValue(int i) {
            return (EnumValueDescriptorProto) this.value_.get(i);
        }

        public EnumValueDescriptorProtoOrBuilder getValueOrBuilder(int i) {
            return (EnumValueDescriptorProtoOrBuilder) this.value_.get(i);
        }

        private void ensureValueIsMutable() {
            if (!this.value_.isModifiable()) {
                this.value_ = GeneratedMessageLite.mutableCopy(this.value_);
            }
        }

        /* access modifiers changed from: private */
        public void setValue(int i, EnumValueDescriptorProto enumValueDescriptorProto) {
            if (enumValueDescriptorProto != null) {
                ensureValueIsMutable();
                this.value_.set(i, enumValueDescriptorProto);
                return;
            }
            throw new NullPointerException();
        }

        /* access modifiers changed from: private */
        public void setValue(int i, EnumValueDescriptorProto.Builder builder) {
            ensureValueIsMutable();
            this.value_.set(i, (EnumValueDescriptorProto) builder.build());
        }

        /* access modifiers changed from: private */
        public void addValue(EnumValueDescriptorProto enumValueDescriptorProto) {
            if (enumValueDescriptorProto != null) {
                ensureValueIsMutable();
                this.value_.add(enumValueDescriptorProto);
                return;
            }
            throw new NullPointerException();
        }

        /* access modifiers changed from: private */
        public void addValue(int i, EnumValueDescriptorProto enumValueDescriptorProto) {
            if (enumValueDescriptorProto != null) {
                ensureValueIsMutable();
                this.value_.add(i, enumValueDescriptorProto);
                return;
            }
            throw new NullPointerException();
        }

        /* access modifiers changed from: private */
        public void addValue(EnumValueDescriptorProto.Builder builder) {
            ensureValueIsMutable();
            this.value_.add((EnumValueDescriptorProto) builder.build());
        }

        /* access modifiers changed from: private */
        public void addValue(int i, EnumValueDescriptorProto.Builder builder) {
            ensureValueIsMutable();
            this.value_.add(i, (EnumValueDescriptorProto) builder.build());
        }

        /* access modifiers changed from: private */
        public void addAllValue(Iterable<? extends EnumValueDescriptorProto> iterable) {
            ensureValueIsMutable();
            AbstractMessageLite.addAll(iterable, this.value_);
        }

        /* access modifiers changed from: private */
        public void clearValue() {
            this.value_ = emptyProtobufList();
        }

        /* access modifiers changed from: private */
        public void removeValue(int i) {
            ensureValueIsMutable();
            this.value_.remove(i);
        }

        public boolean hasOptions() {
            return (this.bitField0_ & 2) == 2;
        }

        public EnumOptions getOptions() {
            EnumOptions enumOptions = this.options_;
            return enumOptions == null ? EnumOptions.getDefaultInstance() : enumOptions;
        }

        /* access modifiers changed from: private */
        public void setOptions(EnumOptions enumOptions) {
            if (enumOptions != null) {
                this.options_ = enumOptions;
                this.bitField0_ |= 2;
                return;
            }
            throw new NullPointerException();
        }

        /* access modifiers changed from: private */
        public void setOptions(EnumOptions.Builder builder) {
            this.options_ = (EnumOptions) builder.build();
            this.bitField0_ |= 2;
        }

        /* access modifiers changed from: private */
        public void mergeOptions(EnumOptions enumOptions) {
            EnumOptions enumOptions2 = this.options_;
            if (enumOptions2 == null || enumOptions2 == EnumOptions.getDefaultInstance()) {
                this.options_ = enumOptions;
            } else {
                this.options_ = (EnumOptions) ((EnumOptions.Builder) EnumOptions.newBuilder(this.options_).mergeFrom(enumOptions)).buildPartial();
            }
            this.bitField0_ |= 2;
        }

        /* access modifiers changed from: private */
        public void clearOptions() {
            this.options_ = null;
            this.bitField0_ &= -3;
        }

        public List<EnumReservedRange> getReservedRangeList() {
            return this.reservedRange_;
        }

        public List<? extends EnumReservedRangeOrBuilder> getReservedRangeOrBuilderList() {
            return this.reservedRange_;
        }

        public int getReservedRangeCount() {
            return this.reservedRange_.size();
        }

        public EnumReservedRange getReservedRange(int i) {
            return (EnumReservedRange) this.reservedRange_.get(i);
        }

        public EnumReservedRangeOrBuilder getReservedRangeOrBuilder(int i) {
            return (EnumReservedRangeOrBuilder) this.reservedRange_.get(i);
        }

        private void ensureReservedRangeIsMutable() {
            if (!this.reservedRange_.isModifiable()) {
                this.reservedRange_ = GeneratedMessageLite.mutableCopy(this.reservedRange_);
            }
        }

        /* access modifiers changed from: private */
        public void setReservedRange(int i, EnumReservedRange enumReservedRange) {
            if (enumReservedRange != null) {
                ensureReservedRangeIsMutable();
                this.reservedRange_.set(i, enumReservedRange);
                return;
            }
            throw new NullPointerException();
        }

        /* access modifiers changed from: private */
        public void setReservedRange(int i, EnumReservedRange.Builder builder) {
            ensureReservedRangeIsMutable();
            this.reservedRange_.set(i, (EnumReservedRange) builder.build());
        }

        /* access modifiers changed from: private */
        public void addReservedRange(EnumReservedRange enumReservedRange) {
            if (enumReservedRange != null) {
                ensureReservedRangeIsMutable();
                this.reservedRange_.add(enumReservedRange);
                return;
            }
            throw new NullPointerException();
        }

        /* access modifiers changed from: private */
        public void addReservedRange(int i, EnumReservedRange enumReservedRange) {
            if (enumReservedRange != null) {
                ensureReservedRangeIsMutable();
                this.reservedRange_.add(i, enumReservedRange);
                return;
            }
            throw new NullPointerException();
        }

        /* access modifiers changed from: private */
        public void addReservedRange(EnumReservedRange.Builder builder) {
            ensureReservedRangeIsMutable();
            this.reservedRange_.add((EnumReservedRange) builder.build());
        }

        /* access modifiers changed from: private */
        public void addReservedRange(int i, EnumReservedRange.Builder builder) {
            ensureReservedRangeIsMutable();
            this.reservedRange_.add(i, (EnumReservedRange) builder.build());
        }

        /* access modifiers changed from: private */
        public void addAllReservedRange(Iterable<? extends EnumReservedRange> iterable) {
            ensureReservedRangeIsMutable();
            AbstractMessageLite.addAll(iterable, this.reservedRange_);
        }

        /* access modifiers changed from: private */
        public void clearReservedRange() {
            this.reservedRange_ = emptyProtobufList();
        }

        /* access modifiers changed from: private */
        public void removeReservedRange(int i) {
            ensureReservedRangeIsMutable();
            this.reservedRange_.remove(i);
        }

        public List<String> getReservedNameList() {
            return this.reservedName_;
        }

        public int getReservedNameCount() {
            return this.reservedName_.size();
        }

        public String getReservedName(int i) {
            return (String) this.reservedName_.get(i);
        }

        public ByteString getReservedNameBytes(int i) {
            return ByteString.copyFromUtf8((String) this.reservedName_.get(i));
        }

        private void ensureReservedNameIsMutable() {
            if (!this.reservedName_.isModifiable()) {
                this.reservedName_ = GeneratedMessageLite.mutableCopy(this.reservedName_);
            }
        }

        /* access modifiers changed from: private */
        public void setReservedName(int i, String str) {
            if (str != null) {
                ensureReservedNameIsMutable();
                this.reservedName_.set(i, str);
                return;
            }
            throw new NullPointerException();
        }

        /* access modifiers changed from: private */
        public void addReservedName(String str) {
            if (str != null) {
                ensureReservedNameIsMutable();
                this.reservedName_.add(str);
                return;
            }
            throw new NullPointerException();
        }

        /* access modifiers changed from: private */
        public void addAllReservedName(Iterable<String> iterable) {
            ensureReservedNameIsMutable();
            AbstractMessageLite.addAll(iterable, this.reservedName_);
        }

        /* access modifiers changed from: private */
        public void clearReservedName() {
            this.reservedName_ = GeneratedMessageLite.emptyProtobufList();
        }

        /* access modifiers changed from: private */
        public void addReservedNameBytes(ByteString byteString) {
            if (byteString != null) {
                ensureReservedNameIsMutable();
                this.reservedName_.add(byteString.toStringUtf8());
                return;
            }
            throw new NullPointerException();
        }

        public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
            if ((this.bitField0_ & 1) == 1) {
                codedOutputStream.writeString(1, getName());
            }
            for (int i = 0; i < this.value_.size(); i++) {
                codedOutputStream.writeMessage(2, (MessageLite) this.value_.get(i));
            }
            if ((this.bitField0_ & 2) == 2) {
                codedOutputStream.writeMessage(3, getOptions());
            }
            for (int i2 = 0; i2 < this.reservedRange_.size(); i2++) {
                codedOutputStream.writeMessage(4, (MessageLite) this.reservedRange_.get(i2));
            }
            for (int i3 = 0; i3 < this.reservedName_.size(); i3++) {
                codedOutputStream.writeString(5, (String) this.reservedName_.get(i3));
            }
            this.unknownFields.writeTo(codedOutputStream);
        }

        public int getSerializedSize() {
            int i = this.memoizedSerializedSize;
            if (i != -1) {
                return i;
            }
            int computeStringSize = (this.bitField0_ & 1) == 1 ? CodedOutputStream.computeStringSize(1, getName()) + 0 : 0;
            for (int i2 = 0; i2 < this.value_.size(); i2++) {
                computeStringSize += CodedOutputStream.computeMessageSize(2, (MessageLite) this.value_.get(i2));
            }
            if ((this.bitField0_ & 2) == 2) {
                computeStringSize += CodedOutputStream.computeMessageSize(3, getOptions());
            }
            for (int i3 = 0; i3 < this.reservedRange_.size(); i3++) {
                computeStringSize += CodedOutputStream.computeMessageSize(4, (MessageLite) this.reservedRange_.get(i3));
            }
            int i4 = 0;
            for (int i5 = 0; i5 < this.reservedName_.size(); i5++) {
                i4 += CodedOutputStream.computeStringSizeNoTag((String) this.reservedName_.get(i5));
            }
            int size = computeStringSize + i4 + (getReservedNameList().size() * 1) + this.unknownFields.getSerializedSize();
            this.memoizedSerializedSize = size;
            return size;
        }

        public static EnumDescriptorProto parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return (EnumDescriptorProto) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
        }

        public static EnumDescriptorProto parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (EnumDescriptorProto) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
        }

        public static EnumDescriptorProto parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return (EnumDescriptorProto) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
        }

        public static EnumDescriptorProto parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (EnumDescriptorProto) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
        }

        public static EnumDescriptorProto parseFrom(InputStream inputStream) throws IOException {
            return (EnumDescriptorProto) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static EnumDescriptorProto parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (EnumDescriptorProto) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static EnumDescriptorProto parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (EnumDescriptorProto) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static EnumDescriptorProto parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (EnumDescriptorProto) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static EnumDescriptorProto parseFrom(CodedInputStream codedInputStream) throws IOException {
            return (EnumDescriptorProto) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
        }

        public static EnumDescriptorProto parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (EnumDescriptorProto) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
        }

        public static Builder newBuilder() {
            return (Builder) DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(EnumDescriptorProto enumDescriptorProto) {
            return (Builder) ((Builder) DEFAULT_INSTANCE.toBuilder()).mergeFrom(enumDescriptorProto);
        }

        /* compiled from: com.google.firebase:protolite-well-known-types@@16.0.1 */
        public static final class Builder extends GeneratedMessageLite.Builder<EnumDescriptorProto, Builder> implements EnumDescriptorProtoOrBuilder {
            private Builder() {
                super(EnumDescriptorProto.DEFAULT_INSTANCE);
            }

            public boolean hasName() {
                return ((EnumDescriptorProto) this.instance).hasName();
            }

            public String getName() {
                return ((EnumDescriptorProto) this.instance).getName();
            }

            public ByteString getNameBytes() {
                return ((EnumDescriptorProto) this.instance).getNameBytes();
            }

            public Builder setName(String str) {
                copyOnWrite();
                ((EnumDescriptorProto) this.instance).setName(str);
                return this;
            }

            public Builder clearName() {
                copyOnWrite();
                ((EnumDescriptorProto) this.instance).clearName();
                return this;
            }

            public Builder setNameBytes(ByteString byteString) {
                copyOnWrite();
                ((EnumDescriptorProto) this.instance).setNameBytes(byteString);
                return this;
            }

            public List<EnumValueDescriptorProto> getValueList() {
                return Collections.unmodifiableList(((EnumDescriptorProto) this.instance).getValueList());
            }

            public int getValueCount() {
                return ((EnumDescriptorProto) this.instance).getValueCount();
            }

            public EnumValueDescriptorProto getValue(int i) {
                return ((EnumDescriptorProto) this.instance).getValue(i);
            }

            public Builder setValue(int i, EnumValueDescriptorProto enumValueDescriptorProto) {
                copyOnWrite();
                ((EnumDescriptorProto) this.instance).setValue(i, enumValueDescriptorProto);
                return this;
            }

            public Builder setValue(int i, EnumValueDescriptorProto.Builder builder) {
                copyOnWrite();
                ((EnumDescriptorProto) this.instance).setValue(i, builder);
                return this;
            }

            public Builder addValue(EnumValueDescriptorProto enumValueDescriptorProto) {
                copyOnWrite();
                ((EnumDescriptorProto) this.instance).addValue(enumValueDescriptorProto);
                return this;
            }

            public Builder addValue(int i, EnumValueDescriptorProto enumValueDescriptorProto) {
                copyOnWrite();
                ((EnumDescriptorProto) this.instance).addValue(i, enumValueDescriptorProto);
                return this;
            }

            public Builder addValue(EnumValueDescriptorProto.Builder builder) {
                copyOnWrite();
                ((EnumDescriptorProto) this.instance).addValue(builder);
                return this;
            }

            public Builder addValue(int i, EnumValueDescriptorProto.Builder builder) {
                copyOnWrite();
                ((EnumDescriptorProto) this.instance).addValue(i, builder);
                return this;
            }

            public Builder addAllValue(Iterable<? extends EnumValueDescriptorProto> iterable) {
                copyOnWrite();
                ((EnumDescriptorProto) this.instance).addAllValue(iterable);
                return this;
            }

            public Builder clearValue() {
                copyOnWrite();
                ((EnumDescriptorProto) this.instance).clearValue();
                return this;
            }

            public Builder removeValue(int i) {
                copyOnWrite();
                ((EnumDescriptorProto) this.instance).removeValue(i);
                return this;
            }

            public boolean hasOptions() {
                return ((EnumDescriptorProto) this.instance).hasOptions();
            }

            public EnumOptions getOptions() {
                return ((EnumDescriptorProto) this.instance).getOptions();
            }

            public Builder setOptions(EnumOptions enumOptions) {
                copyOnWrite();
                ((EnumDescriptorProto) this.instance).setOptions(enumOptions);
                return this;
            }

            public Builder setOptions(EnumOptions.Builder builder) {
                copyOnWrite();
                ((EnumDescriptorProto) this.instance).setOptions(builder);
                return this;
            }

            public Builder mergeOptions(EnumOptions enumOptions) {
                copyOnWrite();
                ((EnumDescriptorProto) this.instance).mergeOptions(enumOptions);
                return this;
            }

            public Builder clearOptions() {
                copyOnWrite();
                ((EnumDescriptorProto) this.instance).clearOptions();
                return this;
            }

            public List<EnumReservedRange> getReservedRangeList() {
                return Collections.unmodifiableList(((EnumDescriptorProto) this.instance).getReservedRangeList());
            }

            public int getReservedRangeCount() {
                return ((EnumDescriptorProto) this.instance).getReservedRangeCount();
            }

            public EnumReservedRange getReservedRange(int i) {
                return ((EnumDescriptorProto) this.instance).getReservedRange(i);
            }

            public Builder setReservedRange(int i, EnumReservedRange enumReservedRange) {
                copyOnWrite();
                ((EnumDescriptorProto) this.instance).setReservedRange(i, enumReservedRange);
                return this;
            }

            public Builder setReservedRange(int i, EnumReservedRange.Builder builder) {
                copyOnWrite();
                ((EnumDescriptorProto) this.instance).setReservedRange(i, builder);
                return this;
            }

            public Builder addReservedRange(EnumReservedRange enumReservedRange) {
                copyOnWrite();
                ((EnumDescriptorProto) this.instance).addReservedRange(enumReservedRange);
                return this;
            }

            public Builder addReservedRange(int i, EnumReservedRange enumReservedRange) {
                copyOnWrite();
                ((EnumDescriptorProto) this.instance).addReservedRange(i, enumReservedRange);
                return this;
            }

            public Builder addReservedRange(EnumReservedRange.Builder builder) {
                copyOnWrite();
                ((EnumDescriptorProto) this.instance).addReservedRange(builder);
                return this;
            }

            public Builder addReservedRange(int i, EnumReservedRange.Builder builder) {
                copyOnWrite();
                ((EnumDescriptorProto) this.instance).addReservedRange(i, builder);
                return this;
            }

            public Builder addAllReservedRange(Iterable<? extends EnumReservedRange> iterable) {
                copyOnWrite();
                ((EnumDescriptorProto) this.instance).addAllReservedRange(iterable);
                return this;
            }

            public Builder clearReservedRange() {
                copyOnWrite();
                ((EnumDescriptorProto) this.instance).clearReservedRange();
                return this;
            }

            public Builder removeReservedRange(int i) {
                copyOnWrite();
                ((EnumDescriptorProto) this.instance).removeReservedRange(i);
                return this;
            }

            public List<String> getReservedNameList() {
                return Collections.unmodifiableList(((EnumDescriptorProto) this.instance).getReservedNameList());
            }

            public int getReservedNameCount() {
                return ((EnumDescriptorProto) this.instance).getReservedNameCount();
            }

            public String getReservedName(int i) {
                return ((EnumDescriptorProto) this.instance).getReservedName(i);
            }

            public ByteString getReservedNameBytes(int i) {
                return ((EnumDescriptorProto) this.instance).getReservedNameBytes(i);
            }

            public Builder setReservedName(int i, String str) {
                copyOnWrite();
                ((EnumDescriptorProto) this.instance).setReservedName(i, str);
                return this;
            }

            public Builder addReservedName(String str) {
                copyOnWrite();
                ((EnumDescriptorProto) this.instance).addReservedName(str);
                return this;
            }

            public Builder addAllReservedName(Iterable<String> iterable) {
                copyOnWrite();
                ((EnumDescriptorProto) this.instance).addAllReservedName(iterable);
                return this;
            }

            public Builder clearReservedName() {
                copyOnWrite();
                ((EnumDescriptorProto) this.instance).clearReservedName();
                return this;
            }

            public Builder addReservedNameBytes(ByteString byteString) {
                copyOnWrite();
                ((EnumDescriptorProto) this.instance).addReservedNameBytes(byteString);
                return this;
            }
        }

        /* access modifiers changed from: protected */
        public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            boolean z = false;
            switch (methodToInvoke) {
                case NEW_MUTABLE_INSTANCE:
                    return new EnumDescriptorProto();
                case IS_INITIALIZED:
                    byte b = this.memoizedIsInitialized;
                    if (b == 1) {
                        return DEFAULT_INSTANCE;
                    }
                    if (b == 0) {
                        return null;
                    }
                    boolean booleanValue = ((Boolean) obj).booleanValue();
                    for (int i = 0; i < getValueCount(); i++) {
                        if (!getValue(i).isInitialized()) {
                            if (booleanValue) {
                                this.memoizedIsInitialized = 0;
                            }
                            return null;
                        }
                    }
                    if (!hasOptions() || getOptions().isInitialized()) {
                        if (booleanValue) {
                            this.memoizedIsInitialized = 1;
                        }
                        return DEFAULT_INSTANCE;
                    }
                    if (booleanValue) {
                        this.memoizedIsInitialized = 0;
                    }
                    return null;
                case MAKE_IMMUTABLE:
                    this.value_.makeImmutable();
                    this.reservedRange_.makeImmutable();
                    this.reservedName_.makeImmutable();
                    return null;
                case NEW_BUILDER:
                    return new Builder();
                case VISIT:
                    GeneratedMessageLite.Visitor visitor = (GeneratedMessageLite.Visitor) obj;
                    EnumDescriptorProto enumDescriptorProto = (EnumDescriptorProto) obj2;
                    this.name_ = visitor.visitString(hasName(), this.name_, enumDescriptorProto.hasName(), enumDescriptorProto.name_);
                    this.value_ = visitor.visitList(this.value_, enumDescriptorProto.value_);
                    this.options_ = (EnumOptions) visitor.visitMessage(this.options_, enumDescriptorProto.options_);
                    this.reservedRange_ = visitor.visitList(this.reservedRange_, enumDescriptorProto.reservedRange_);
                    this.reservedName_ = visitor.visitList(this.reservedName_, enumDescriptorProto.reservedName_);
                    if (visitor == GeneratedMessageLite.MergeFromVisitor.INSTANCE) {
                        this.bitField0_ |= enumDescriptorProto.bitField0_;
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
                                    this.bitField0_ |= 1;
                                    this.name_ = readString;
                                } else if (readTag == 18) {
                                    if (!this.value_.isModifiable()) {
                                        this.value_ = GeneratedMessageLite.mutableCopy(this.value_);
                                    }
                                    this.value_.add((EnumValueDescriptorProto) codedInputStream.readMessage(EnumValueDescriptorProto.parser(), extensionRegistryLite));
                                } else if (readTag == 26) {
                                    EnumOptions.Builder builder = (this.bitField0_ & 2) == 2 ? (EnumOptions.Builder) this.options_.toBuilder() : null;
                                    this.options_ = (EnumOptions) codedInputStream.readMessage(EnumOptions.parser(), extensionRegistryLite);
                                    if (builder != null) {
                                        builder.mergeFrom(this.options_);
                                        this.options_ = (EnumOptions) builder.buildPartial();
                                    }
                                    this.bitField0_ |= 2;
                                } else if (readTag == 34) {
                                    if (!this.reservedRange_.isModifiable()) {
                                        this.reservedRange_ = GeneratedMessageLite.mutableCopy(this.reservedRange_);
                                    }
                                    this.reservedRange_.add((EnumReservedRange) codedInputStream.readMessage(EnumReservedRange.parser(), extensionRegistryLite));
                                } else if (readTag == 42) {
                                    String readString2 = codedInputStream.readString();
                                    if (!this.reservedName_.isModifiable()) {
                                        this.reservedName_ = GeneratedMessageLite.mutableCopy(this.reservedName_);
                                    }
                                    this.reservedName_.add(readString2);
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
                        synchronized (EnumDescriptorProto.class) {
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

        public static EnumDescriptorProto getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<EnumDescriptorProto> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }
    }

    /* compiled from: com.google.firebase:protolite-well-known-types@@16.0.1 */
    public static final class EnumValueDescriptorProto extends GeneratedMessageLite<EnumValueDescriptorProto, Builder> implements EnumValueDescriptorProtoOrBuilder {
        /* access modifiers changed from: private */
        public static final EnumValueDescriptorProto DEFAULT_INSTANCE = new EnumValueDescriptorProto();
        public static final int NAME_FIELD_NUMBER = 1;
        public static final int NUMBER_FIELD_NUMBER = 2;
        public static final int OPTIONS_FIELD_NUMBER = 3;
        private static volatile Parser<EnumValueDescriptorProto> PARSER;
        private int bitField0_;
        private byte memoizedIsInitialized = -1;
        private String name_ = "";
        private int number_;
        private EnumValueOptions options_;

        private EnumValueDescriptorProto() {
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

        public boolean hasNumber() {
            return (this.bitField0_ & 2) == 2;
        }

        public int getNumber() {
            return this.number_;
        }

        /* access modifiers changed from: private */
        public void setNumber(int i) {
            this.bitField0_ |= 2;
            this.number_ = i;
        }

        /* access modifiers changed from: private */
        public void clearNumber() {
            this.bitField0_ &= -3;
            this.number_ = 0;
        }

        public boolean hasOptions() {
            return (this.bitField0_ & 4) == 4;
        }

        public EnumValueOptions getOptions() {
            EnumValueOptions enumValueOptions = this.options_;
            return enumValueOptions == null ? EnumValueOptions.getDefaultInstance() : enumValueOptions;
        }

        /* access modifiers changed from: private */
        public void setOptions(EnumValueOptions enumValueOptions) {
            if (enumValueOptions != null) {
                this.options_ = enumValueOptions;
                this.bitField0_ |= 4;
                return;
            }
            throw new NullPointerException();
        }

        /* access modifiers changed from: private */
        public void setOptions(EnumValueOptions.Builder builder) {
            this.options_ = (EnumValueOptions) builder.build();
            this.bitField0_ |= 4;
        }

        /* access modifiers changed from: private */
        public void mergeOptions(EnumValueOptions enumValueOptions) {
            EnumValueOptions enumValueOptions2 = this.options_;
            if (enumValueOptions2 == null || enumValueOptions2 == EnumValueOptions.getDefaultInstance()) {
                this.options_ = enumValueOptions;
            } else {
                this.options_ = (EnumValueOptions) ((EnumValueOptions.Builder) EnumValueOptions.newBuilder(this.options_).mergeFrom(enumValueOptions)).buildPartial();
            }
            this.bitField0_ |= 4;
        }

        /* access modifiers changed from: private */
        public void clearOptions() {
            this.options_ = null;
            this.bitField0_ &= -5;
        }

        public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
            if ((this.bitField0_ & 1) == 1) {
                codedOutputStream.writeString(1, getName());
            }
            if ((this.bitField0_ & 2) == 2) {
                codedOutputStream.writeInt32(2, this.number_);
            }
            if ((this.bitField0_ & 4) == 4) {
                codedOutputStream.writeMessage(3, getOptions());
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
                i2 += CodedOutputStream.computeInt32Size(2, this.number_);
            }
            if ((this.bitField0_ & 4) == 4) {
                i2 += CodedOutputStream.computeMessageSize(3, getOptions());
            }
            int serializedSize = i2 + this.unknownFields.getSerializedSize();
            this.memoizedSerializedSize = serializedSize;
            return serializedSize;
        }

        public static EnumValueDescriptorProto parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return (EnumValueDescriptorProto) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
        }

        public static EnumValueDescriptorProto parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (EnumValueDescriptorProto) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
        }

        public static EnumValueDescriptorProto parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return (EnumValueDescriptorProto) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
        }

        public static EnumValueDescriptorProto parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (EnumValueDescriptorProto) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
        }

        public static EnumValueDescriptorProto parseFrom(InputStream inputStream) throws IOException {
            return (EnumValueDescriptorProto) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static EnumValueDescriptorProto parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (EnumValueDescriptorProto) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static EnumValueDescriptorProto parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (EnumValueDescriptorProto) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static EnumValueDescriptorProto parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (EnumValueDescriptorProto) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static EnumValueDescriptorProto parseFrom(CodedInputStream codedInputStream) throws IOException {
            return (EnumValueDescriptorProto) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
        }

        public static EnumValueDescriptorProto parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (EnumValueDescriptorProto) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
        }

        public static Builder newBuilder() {
            return (Builder) DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(EnumValueDescriptorProto enumValueDescriptorProto) {
            return (Builder) ((Builder) DEFAULT_INSTANCE.toBuilder()).mergeFrom(enumValueDescriptorProto);
        }

        /* compiled from: com.google.firebase:protolite-well-known-types@@16.0.1 */
        public static final class Builder extends GeneratedMessageLite.Builder<EnumValueDescriptorProto, Builder> implements EnumValueDescriptorProtoOrBuilder {
            private Builder() {
                super(EnumValueDescriptorProto.DEFAULT_INSTANCE);
            }

            public boolean hasName() {
                return ((EnumValueDescriptorProto) this.instance).hasName();
            }

            public String getName() {
                return ((EnumValueDescriptorProto) this.instance).getName();
            }

            public ByteString getNameBytes() {
                return ((EnumValueDescriptorProto) this.instance).getNameBytes();
            }

            public Builder setName(String str) {
                copyOnWrite();
                ((EnumValueDescriptorProto) this.instance).setName(str);
                return this;
            }

            public Builder clearName() {
                copyOnWrite();
                ((EnumValueDescriptorProto) this.instance).clearName();
                return this;
            }

            public Builder setNameBytes(ByteString byteString) {
                copyOnWrite();
                ((EnumValueDescriptorProto) this.instance).setNameBytes(byteString);
                return this;
            }

            public boolean hasNumber() {
                return ((EnumValueDescriptorProto) this.instance).hasNumber();
            }

            public int getNumber() {
                return ((EnumValueDescriptorProto) this.instance).getNumber();
            }

            public Builder setNumber(int i) {
                copyOnWrite();
                ((EnumValueDescriptorProto) this.instance).setNumber(i);
                return this;
            }

            public Builder clearNumber() {
                copyOnWrite();
                ((EnumValueDescriptorProto) this.instance).clearNumber();
                return this;
            }

            public boolean hasOptions() {
                return ((EnumValueDescriptorProto) this.instance).hasOptions();
            }

            public EnumValueOptions getOptions() {
                return ((EnumValueDescriptorProto) this.instance).getOptions();
            }

            public Builder setOptions(EnumValueOptions enumValueOptions) {
                copyOnWrite();
                ((EnumValueDescriptorProto) this.instance).setOptions(enumValueOptions);
                return this;
            }

            public Builder setOptions(EnumValueOptions.Builder builder) {
                copyOnWrite();
                ((EnumValueDescriptorProto) this.instance).setOptions(builder);
                return this;
            }

            public Builder mergeOptions(EnumValueOptions enumValueOptions) {
                copyOnWrite();
                ((EnumValueDescriptorProto) this.instance).mergeOptions(enumValueOptions);
                return this;
            }

            public Builder clearOptions() {
                copyOnWrite();
                ((EnumValueDescriptorProto) this.instance).clearOptions();
                return this;
            }
        }

        /* access modifiers changed from: protected */
        public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            boolean z = false;
            switch (methodToInvoke) {
                case NEW_MUTABLE_INSTANCE:
                    return new EnumValueDescriptorProto();
                case IS_INITIALIZED:
                    byte b = this.memoizedIsInitialized;
                    if (b == 1) {
                        return DEFAULT_INSTANCE;
                    }
                    if (b == 0) {
                        return null;
                    }
                    boolean booleanValue = ((Boolean) obj).booleanValue();
                    if (!hasOptions() || getOptions().isInitialized()) {
                        if (booleanValue) {
                            this.memoizedIsInitialized = 1;
                        }
                        return DEFAULT_INSTANCE;
                    }
                    if (booleanValue) {
                        this.memoizedIsInitialized = 0;
                    }
                    return null;
                case MAKE_IMMUTABLE:
                    return null;
                case NEW_BUILDER:
                    return new Builder();
                case VISIT:
                    GeneratedMessageLite.Visitor visitor = (GeneratedMessageLite.Visitor) obj;
                    EnumValueDescriptorProto enumValueDescriptorProto = (EnumValueDescriptorProto) obj2;
                    this.name_ = visitor.visitString(hasName(), this.name_, enumValueDescriptorProto.hasName(), enumValueDescriptorProto.name_);
                    this.number_ = visitor.visitInt(hasNumber(), this.number_, enumValueDescriptorProto.hasNumber(), enumValueDescriptorProto.number_);
                    this.options_ = (EnumValueOptions) visitor.visitMessage(this.options_, enumValueDescriptorProto.options_);
                    if (visitor == GeneratedMessageLite.MergeFromVisitor.INSTANCE) {
                        this.bitField0_ |= enumValueDescriptorProto.bitField0_;
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
                                    this.bitField0_ |= 1;
                                    this.name_ = readString;
                                } else if (readTag == 16) {
                                    this.bitField0_ |= 2;
                                    this.number_ = codedInputStream.readInt32();
                                } else if (readTag == 26) {
                                    EnumValueOptions.Builder builder = (this.bitField0_ & 4) == 4 ? (EnumValueOptions.Builder) this.options_.toBuilder() : null;
                                    this.options_ = (EnumValueOptions) codedInputStream.readMessage(EnumValueOptions.parser(), extensionRegistryLite);
                                    if (builder != null) {
                                        builder.mergeFrom(this.options_);
                                        this.options_ = (EnumValueOptions) builder.buildPartial();
                                    }
                                    this.bitField0_ |= 4;
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
                        synchronized (EnumValueDescriptorProto.class) {
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

        public static EnumValueDescriptorProto getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<EnumValueDescriptorProto> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }
    }

    /* compiled from: com.google.firebase:protolite-well-known-types@@16.0.1 */
    public static final class ServiceDescriptorProto extends GeneratedMessageLite<ServiceDescriptorProto, Builder> implements ServiceDescriptorProtoOrBuilder {
        /* access modifiers changed from: private */
        public static final ServiceDescriptorProto DEFAULT_INSTANCE = new ServiceDescriptorProto();
        public static final int METHOD_FIELD_NUMBER = 2;
        public static final int NAME_FIELD_NUMBER = 1;
        public static final int OPTIONS_FIELD_NUMBER = 3;
        private static volatile Parser<ServiceDescriptorProto> PARSER;
        private int bitField0_;
        private byte memoizedIsInitialized = -1;
        private Internal.ProtobufList<MethodDescriptorProto> method_ = emptyProtobufList();
        private String name_ = "";
        private ServiceOptions options_;

        private ServiceDescriptorProto() {
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

        public List<MethodDescriptorProto> getMethodList() {
            return this.method_;
        }

        public List<? extends MethodDescriptorProtoOrBuilder> getMethodOrBuilderList() {
            return this.method_;
        }

        public int getMethodCount() {
            return this.method_.size();
        }

        public MethodDescriptorProto getMethod(int i) {
            return (MethodDescriptorProto) this.method_.get(i);
        }

        public MethodDescriptorProtoOrBuilder getMethodOrBuilder(int i) {
            return (MethodDescriptorProtoOrBuilder) this.method_.get(i);
        }

        private void ensureMethodIsMutable() {
            if (!this.method_.isModifiable()) {
                this.method_ = GeneratedMessageLite.mutableCopy(this.method_);
            }
        }

        /* access modifiers changed from: private */
        public void setMethod(int i, MethodDescriptorProto methodDescriptorProto) {
            if (methodDescriptorProto != null) {
                ensureMethodIsMutable();
                this.method_.set(i, methodDescriptorProto);
                return;
            }
            throw new NullPointerException();
        }

        /* access modifiers changed from: private */
        public void setMethod(int i, MethodDescriptorProto.Builder builder) {
            ensureMethodIsMutable();
            this.method_.set(i, (MethodDescriptorProto) builder.build());
        }

        /* access modifiers changed from: private */
        public void addMethod(MethodDescriptorProto methodDescriptorProto) {
            if (methodDescriptorProto != null) {
                ensureMethodIsMutable();
                this.method_.add(methodDescriptorProto);
                return;
            }
            throw new NullPointerException();
        }

        /* access modifiers changed from: private */
        public void addMethod(int i, MethodDescriptorProto methodDescriptorProto) {
            if (methodDescriptorProto != null) {
                ensureMethodIsMutable();
                this.method_.add(i, methodDescriptorProto);
                return;
            }
            throw new NullPointerException();
        }

        /* access modifiers changed from: private */
        public void addMethod(MethodDescriptorProto.Builder builder) {
            ensureMethodIsMutable();
            this.method_.add((MethodDescriptorProto) builder.build());
        }

        /* access modifiers changed from: private */
        public void addMethod(int i, MethodDescriptorProto.Builder builder) {
            ensureMethodIsMutable();
            this.method_.add(i, (MethodDescriptorProto) builder.build());
        }

        /* access modifiers changed from: private */
        public void addAllMethod(Iterable<? extends MethodDescriptorProto> iterable) {
            ensureMethodIsMutable();
            AbstractMessageLite.addAll(iterable, this.method_);
        }

        /* access modifiers changed from: private */
        public void clearMethod() {
            this.method_ = emptyProtobufList();
        }

        /* access modifiers changed from: private */
        public void removeMethod(int i) {
            ensureMethodIsMutable();
            this.method_.remove(i);
        }

        public boolean hasOptions() {
            return (this.bitField0_ & 2) == 2;
        }

        public ServiceOptions getOptions() {
            ServiceOptions serviceOptions = this.options_;
            return serviceOptions == null ? ServiceOptions.getDefaultInstance() : serviceOptions;
        }

        /* access modifiers changed from: private */
        public void setOptions(ServiceOptions serviceOptions) {
            if (serviceOptions != null) {
                this.options_ = serviceOptions;
                this.bitField0_ |= 2;
                return;
            }
            throw new NullPointerException();
        }

        /* access modifiers changed from: private */
        public void setOptions(ServiceOptions.Builder builder) {
            this.options_ = (ServiceOptions) builder.build();
            this.bitField0_ |= 2;
        }

        /* access modifiers changed from: private */
        public void mergeOptions(ServiceOptions serviceOptions) {
            ServiceOptions serviceOptions2 = this.options_;
            if (serviceOptions2 == null || serviceOptions2 == ServiceOptions.getDefaultInstance()) {
                this.options_ = serviceOptions;
            } else {
                this.options_ = (ServiceOptions) ((ServiceOptions.Builder) ServiceOptions.newBuilder(this.options_).mergeFrom(serviceOptions)).buildPartial();
            }
            this.bitField0_ |= 2;
        }

        /* access modifiers changed from: private */
        public void clearOptions() {
            this.options_ = null;
            this.bitField0_ &= -3;
        }

        public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
            if ((this.bitField0_ & 1) == 1) {
                codedOutputStream.writeString(1, getName());
            }
            for (int i = 0; i < this.method_.size(); i++) {
                codedOutputStream.writeMessage(2, (MessageLite) this.method_.get(i));
            }
            if ((this.bitField0_ & 2) == 2) {
                codedOutputStream.writeMessage(3, getOptions());
            }
            this.unknownFields.writeTo(codedOutputStream);
        }

        public int getSerializedSize() {
            int i = this.memoizedSerializedSize;
            if (i != -1) {
                return i;
            }
            int computeStringSize = (this.bitField0_ & 1) == 1 ? CodedOutputStream.computeStringSize(1, getName()) + 0 : 0;
            for (int i2 = 0; i2 < this.method_.size(); i2++) {
                computeStringSize += CodedOutputStream.computeMessageSize(2, (MessageLite) this.method_.get(i2));
            }
            if ((this.bitField0_ & 2) == 2) {
                computeStringSize += CodedOutputStream.computeMessageSize(3, getOptions());
            }
            int serializedSize = computeStringSize + this.unknownFields.getSerializedSize();
            this.memoizedSerializedSize = serializedSize;
            return serializedSize;
        }

        public static ServiceDescriptorProto parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return (ServiceDescriptorProto) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
        }

        public static ServiceDescriptorProto parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (ServiceDescriptorProto) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
        }

        public static ServiceDescriptorProto parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return (ServiceDescriptorProto) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
        }

        public static ServiceDescriptorProto parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (ServiceDescriptorProto) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
        }

        public static ServiceDescriptorProto parseFrom(InputStream inputStream) throws IOException {
            return (ServiceDescriptorProto) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static ServiceDescriptorProto parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (ServiceDescriptorProto) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static ServiceDescriptorProto parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (ServiceDescriptorProto) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static ServiceDescriptorProto parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (ServiceDescriptorProto) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static ServiceDescriptorProto parseFrom(CodedInputStream codedInputStream) throws IOException {
            return (ServiceDescriptorProto) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
        }

        public static ServiceDescriptorProto parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (ServiceDescriptorProto) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
        }

        public static Builder newBuilder() {
            return (Builder) DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(ServiceDescriptorProto serviceDescriptorProto) {
            return (Builder) ((Builder) DEFAULT_INSTANCE.toBuilder()).mergeFrom(serviceDescriptorProto);
        }

        /* compiled from: com.google.firebase:protolite-well-known-types@@16.0.1 */
        public static final class Builder extends GeneratedMessageLite.Builder<ServiceDescriptorProto, Builder> implements ServiceDescriptorProtoOrBuilder {
            private Builder() {
                super(ServiceDescriptorProto.DEFAULT_INSTANCE);
            }

            public boolean hasName() {
                return ((ServiceDescriptorProto) this.instance).hasName();
            }

            public String getName() {
                return ((ServiceDescriptorProto) this.instance).getName();
            }

            public ByteString getNameBytes() {
                return ((ServiceDescriptorProto) this.instance).getNameBytes();
            }

            public Builder setName(String str) {
                copyOnWrite();
                ((ServiceDescriptorProto) this.instance).setName(str);
                return this;
            }

            public Builder clearName() {
                copyOnWrite();
                ((ServiceDescriptorProto) this.instance).clearName();
                return this;
            }

            public Builder setNameBytes(ByteString byteString) {
                copyOnWrite();
                ((ServiceDescriptorProto) this.instance).setNameBytes(byteString);
                return this;
            }

            public List<MethodDescriptorProto> getMethodList() {
                return Collections.unmodifiableList(((ServiceDescriptorProto) this.instance).getMethodList());
            }

            public int getMethodCount() {
                return ((ServiceDescriptorProto) this.instance).getMethodCount();
            }

            public MethodDescriptorProto getMethod(int i) {
                return ((ServiceDescriptorProto) this.instance).getMethod(i);
            }

            public Builder setMethod(int i, MethodDescriptorProto methodDescriptorProto) {
                copyOnWrite();
                ((ServiceDescriptorProto) this.instance).setMethod(i, methodDescriptorProto);
                return this;
            }

            public Builder setMethod(int i, MethodDescriptorProto.Builder builder) {
                copyOnWrite();
                ((ServiceDescriptorProto) this.instance).setMethod(i, builder);
                return this;
            }

            public Builder addMethod(MethodDescriptorProto methodDescriptorProto) {
                copyOnWrite();
                ((ServiceDescriptorProto) this.instance).addMethod(methodDescriptorProto);
                return this;
            }

            public Builder addMethod(int i, MethodDescriptorProto methodDescriptorProto) {
                copyOnWrite();
                ((ServiceDescriptorProto) this.instance).addMethod(i, methodDescriptorProto);
                return this;
            }

            public Builder addMethod(MethodDescriptorProto.Builder builder) {
                copyOnWrite();
                ((ServiceDescriptorProto) this.instance).addMethod(builder);
                return this;
            }

            public Builder addMethod(int i, MethodDescriptorProto.Builder builder) {
                copyOnWrite();
                ((ServiceDescriptorProto) this.instance).addMethod(i, builder);
                return this;
            }

            public Builder addAllMethod(Iterable<? extends MethodDescriptorProto> iterable) {
                copyOnWrite();
                ((ServiceDescriptorProto) this.instance).addAllMethod(iterable);
                return this;
            }

            public Builder clearMethod() {
                copyOnWrite();
                ((ServiceDescriptorProto) this.instance).clearMethod();
                return this;
            }

            public Builder removeMethod(int i) {
                copyOnWrite();
                ((ServiceDescriptorProto) this.instance).removeMethod(i);
                return this;
            }

            public boolean hasOptions() {
                return ((ServiceDescriptorProto) this.instance).hasOptions();
            }

            public ServiceOptions getOptions() {
                return ((ServiceDescriptorProto) this.instance).getOptions();
            }

            public Builder setOptions(ServiceOptions serviceOptions) {
                copyOnWrite();
                ((ServiceDescriptorProto) this.instance).setOptions(serviceOptions);
                return this;
            }

            public Builder setOptions(ServiceOptions.Builder builder) {
                copyOnWrite();
                ((ServiceDescriptorProto) this.instance).setOptions(builder);
                return this;
            }

            public Builder mergeOptions(ServiceOptions serviceOptions) {
                copyOnWrite();
                ((ServiceDescriptorProto) this.instance).mergeOptions(serviceOptions);
                return this;
            }

            public Builder clearOptions() {
                copyOnWrite();
                ((ServiceDescriptorProto) this.instance).clearOptions();
                return this;
            }
        }

        /* access modifiers changed from: protected */
        public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            boolean z = false;
            switch (methodToInvoke) {
                case NEW_MUTABLE_INSTANCE:
                    return new ServiceDescriptorProto();
                case IS_INITIALIZED:
                    byte b = this.memoizedIsInitialized;
                    if (b == 1) {
                        return DEFAULT_INSTANCE;
                    }
                    if (b == 0) {
                        return null;
                    }
                    boolean booleanValue = ((Boolean) obj).booleanValue();
                    for (int i = 0; i < getMethodCount(); i++) {
                        if (!getMethod(i).isInitialized()) {
                            if (booleanValue) {
                                this.memoizedIsInitialized = 0;
                            }
                            return null;
                        }
                    }
                    if (!hasOptions() || getOptions().isInitialized()) {
                        if (booleanValue) {
                            this.memoizedIsInitialized = 1;
                        }
                        return DEFAULT_INSTANCE;
                    }
                    if (booleanValue) {
                        this.memoizedIsInitialized = 0;
                    }
                    return null;
                case MAKE_IMMUTABLE:
                    this.method_.makeImmutable();
                    return null;
                case NEW_BUILDER:
                    return new Builder();
                case VISIT:
                    GeneratedMessageLite.Visitor visitor = (GeneratedMessageLite.Visitor) obj;
                    ServiceDescriptorProto serviceDescriptorProto = (ServiceDescriptorProto) obj2;
                    this.name_ = visitor.visitString(hasName(), this.name_, serviceDescriptorProto.hasName(), serviceDescriptorProto.name_);
                    this.method_ = visitor.visitList(this.method_, serviceDescriptorProto.method_);
                    this.options_ = (ServiceOptions) visitor.visitMessage(this.options_, serviceDescriptorProto.options_);
                    if (visitor == GeneratedMessageLite.MergeFromVisitor.INSTANCE) {
                        this.bitField0_ |= serviceDescriptorProto.bitField0_;
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
                                    this.bitField0_ |= 1;
                                    this.name_ = readString;
                                } else if (readTag == 18) {
                                    if (!this.method_.isModifiable()) {
                                        this.method_ = GeneratedMessageLite.mutableCopy(this.method_);
                                    }
                                    this.method_.add((MethodDescriptorProto) codedInputStream.readMessage(MethodDescriptorProto.parser(), extensionRegistryLite));
                                } else if (readTag == 26) {
                                    ServiceOptions.Builder builder = (this.bitField0_ & 2) == 2 ? (ServiceOptions.Builder) this.options_.toBuilder() : null;
                                    this.options_ = (ServiceOptions) codedInputStream.readMessage(ServiceOptions.parser(), extensionRegistryLite);
                                    if (builder != null) {
                                        builder.mergeFrom(this.options_);
                                        this.options_ = (ServiceOptions) builder.buildPartial();
                                    }
                                    this.bitField0_ |= 2;
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
                        synchronized (ServiceDescriptorProto.class) {
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

        public static ServiceDescriptorProto getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<ServiceDescriptorProto> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }
    }

    /* compiled from: com.google.firebase:protolite-well-known-types@@16.0.1 */
    public static final class MethodDescriptorProto extends GeneratedMessageLite<MethodDescriptorProto, Builder> implements MethodDescriptorProtoOrBuilder {
        public static final int CLIENT_STREAMING_FIELD_NUMBER = 5;
        /* access modifiers changed from: private */
        public static final MethodDescriptorProto DEFAULT_INSTANCE = new MethodDescriptorProto();
        public static final int INPUT_TYPE_FIELD_NUMBER = 2;
        public static final int NAME_FIELD_NUMBER = 1;
        public static final int OPTIONS_FIELD_NUMBER = 4;
        public static final int OUTPUT_TYPE_FIELD_NUMBER = 3;
        private static volatile Parser<MethodDescriptorProto> PARSER = null;
        public static final int SERVER_STREAMING_FIELD_NUMBER = 6;
        private int bitField0_;
        private boolean clientStreaming_;
        private String inputType_ = "";
        private byte memoizedIsInitialized = -1;
        private String name_ = "";
        private MethodOptions options_;
        private String outputType_ = "";
        private boolean serverStreaming_;

        private MethodDescriptorProto() {
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

        public boolean hasInputType() {
            return (this.bitField0_ & 2) == 2;
        }

        public String getInputType() {
            return this.inputType_;
        }

        public ByteString getInputTypeBytes() {
            return ByteString.copyFromUtf8(this.inputType_);
        }

        /* access modifiers changed from: private */
        public void setInputType(String str) {
            if (str != null) {
                this.bitField0_ |= 2;
                this.inputType_ = str;
                return;
            }
            throw new NullPointerException();
        }

        /* access modifiers changed from: private */
        public void clearInputType() {
            this.bitField0_ &= -3;
            this.inputType_ = getDefaultInstance().getInputType();
        }

        /* access modifiers changed from: private */
        public void setInputTypeBytes(ByteString byteString) {
            if (byteString != null) {
                this.bitField0_ |= 2;
                this.inputType_ = byteString.toStringUtf8();
                return;
            }
            throw new NullPointerException();
        }

        public boolean hasOutputType() {
            return (this.bitField0_ & 4) == 4;
        }

        public String getOutputType() {
            return this.outputType_;
        }

        public ByteString getOutputTypeBytes() {
            return ByteString.copyFromUtf8(this.outputType_);
        }

        /* access modifiers changed from: private */
        public void setOutputType(String str) {
            if (str != null) {
                this.bitField0_ |= 4;
                this.outputType_ = str;
                return;
            }
            throw new NullPointerException();
        }

        /* access modifiers changed from: private */
        public void clearOutputType() {
            this.bitField0_ &= -5;
            this.outputType_ = getDefaultInstance().getOutputType();
        }

        /* access modifiers changed from: private */
        public void setOutputTypeBytes(ByteString byteString) {
            if (byteString != null) {
                this.bitField0_ |= 4;
                this.outputType_ = byteString.toStringUtf8();
                return;
            }
            throw new NullPointerException();
        }

        public boolean hasOptions() {
            return (this.bitField0_ & 8) == 8;
        }

        public MethodOptions getOptions() {
            MethodOptions methodOptions = this.options_;
            return methodOptions == null ? MethodOptions.getDefaultInstance() : methodOptions;
        }

        /* access modifiers changed from: private */
        public void setOptions(MethodOptions methodOptions) {
            if (methodOptions != null) {
                this.options_ = methodOptions;
                this.bitField0_ |= 8;
                return;
            }
            throw new NullPointerException();
        }

        /* access modifiers changed from: private */
        public void setOptions(MethodOptions.Builder builder) {
            this.options_ = (MethodOptions) builder.build();
            this.bitField0_ |= 8;
        }

        /* access modifiers changed from: private */
        public void mergeOptions(MethodOptions methodOptions) {
            MethodOptions methodOptions2 = this.options_;
            if (methodOptions2 == null || methodOptions2 == MethodOptions.getDefaultInstance()) {
                this.options_ = methodOptions;
            } else {
                this.options_ = (MethodOptions) ((MethodOptions.Builder) MethodOptions.newBuilder(this.options_).mergeFrom(methodOptions)).buildPartial();
            }
            this.bitField0_ |= 8;
        }

        /* access modifiers changed from: private */
        public void clearOptions() {
            this.options_ = null;
            this.bitField0_ &= -9;
        }

        public boolean hasClientStreaming() {
            return (this.bitField0_ & 16) == 16;
        }

        public boolean getClientStreaming() {
            return this.clientStreaming_;
        }

        /* access modifiers changed from: private */
        public void setClientStreaming(boolean z) {
            this.bitField0_ |= 16;
            this.clientStreaming_ = z;
        }

        /* access modifiers changed from: private */
        public void clearClientStreaming() {
            this.bitField0_ &= -17;
            this.clientStreaming_ = false;
        }

        public boolean hasServerStreaming() {
            return (this.bitField0_ & 32) == 32;
        }

        public boolean getServerStreaming() {
            return this.serverStreaming_;
        }

        /* access modifiers changed from: private */
        public void setServerStreaming(boolean z) {
            this.bitField0_ |= 32;
            this.serverStreaming_ = z;
        }

        /* access modifiers changed from: private */
        public void clearServerStreaming() {
            this.bitField0_ &= -33;
            this.serverStreaming_ = false;
        }

        public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
            if ((this.bitField0_ & 1) == 1) {
                codedOutputStream.writeString(1, getName());
            }
            if ((this.bitField0_ & 2) == 2) {
                codedOutputStream.writeString(2, getInputType());
            }
            if ((this.bitField0_ & 4) == 4) {
                codedOutputStream.writeString(3, getOutputType());
            }
            if ((this.bitField0_ & 8) == 8) {
                codedOutputStream.writeMessage(4, getOptions());
            }
            if ((this.bitField0_ & 16) == 16) {
                codedOutputStream.writeBool(5, this.clientStreaming_);
            }
            if ((this.bitField0_ & 32) == 32) {
                codedOutputStream.writeBool(6, this.serverStreaming_);
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
                i2 += CodedOutputStream.computeStringSize(2, getInputType());
            }
            if ((this.bitField0_ & 4) == 4) {
                i2 += CodedOutputStream.computeStringSize(3, getOutputType());
            }
            if ((this.bitField0_ & 8) == 8) {
                i2 += CodedOutputStream.computeMessageSize(4, getOptions());
            }
            if ((this.bitField0_ & 16) == 16) {
                i2 += CodedOutputStream.computeBoolSize(5, this.clientStreaming_);
            }
            if ((this.bitField0_ & 32) == 32) {
                i2 += CodedOutputStream.computeBoolSize(6, this.serverStreaming_);
            }
            int serializedSize = i2 + this.unknownFields.getSerializedSize();
            this.memoizedSerializedSize = serializedSize;
            return serializedSize;
        }

        public static MethodDescriptorProto parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return (MethodDescriptorProto) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
        }

        public static MethodDescriptorProto parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (MethodDescriptorProto) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
        }

        public static MethodDescriptorProto parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return (MethodDescriptorProto) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
        }

        public static MethodDescriptorProto parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (MethodDescriptorProto) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
        }

        public static MethodDescriptorProto parseFrom(InputStream inputStream) throws IOException {
            return (MethodDescriptorProto) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static MethodDescriptorProto parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (MethodDescriptorProto) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static MethodDescriptorProto parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (MethodDescriptorProto) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static MethodDescriptorProto parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (MethodDescriptorProto) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static MethodDescriptorProto parseFrom(CodedInputStream codedInputStream) throws IOException {
            return (MethodDescriptorProto) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
        }

        public static MethodDescriptorProto parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (MethodDescriptorProto) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
        }

        public static Builder newBuilder() {
            return (Builder) DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(MethodDescriptorProto methodDescriptorProto) {
            return (Builder) ((Builder) DEFAULT_INSTANCE.toBuilder()).mergeFrom(methodDescriptorProto);
        }

        /* compiled from: com.google.firebase:protolite-well-known-types@@16.0.1 */
        public static final class Builder extends GeneratedMessageLite.Builder<MethodDescriptorProto, Builder> implements MethodDescriptorProtoOrBuilder {
            private Builder() {
                super(MethodDescriptorProto.DEFAULT_INSTANCE);
            }

            public boolean hasName() {
                return ((MethodDescriptorProto) this.instance).hasName();
            }

            public String getName() {
                return ((MethodDescriptorProto) this.instance).getName();
            }

            public ByteString getNameBytes() {
                return ((MethodDescriptorProto) this.instance).getNameBytes();
            }

            public Builder setName(String str) {
                copyOnWrite();
                ((MethodDescriptorProto) this.instance).setName(str);
                return this;
            }

            public Builder clearName() {
                copyOnWrite();
                ((MethodDescriptorProto) this.instance).clearName();
                return this;
            }

            public Builder setNameBytes(ByteString byteString) {
                copyOnWrite();
                ((MethodDescriptorProto) this.instance).setNameBytes(byteString);
                return this;
            }

            public boolean hasInputType() {
                return ((MethodDescriptorProto) this.instance).hasInputType();
            }

            public String getInputType() {
                return ((MethodDescriptorProto) this.instance).getInputType();
            }

            public ByteString getInputTypeBytes() {
                return ((MethodDescriptorProto) this.instance).getInputTypeBytes();
            }

            public Builder setInputType(String str) {
                copyOnWrite();
                ((MethodDescriptorProto) this.instance).setInputType(str);
                return this;
            }

            public Builder clearInputType() {
                copyOnWrite();
                ((MethodDescriptorProto) this.instance).clearInputType();
                return this;
            }

            public Builder setInputTypeBytes(ByteString byteString) {
                copyOnWrite();
                ((MethodDescriptorProto) this.instance).setInputTypeBytes(byteString);
                return this;
            }

            public boolean hasOutputType() {
                return ((MethodDescriptorProto) this.instance).hasOutputType();
            }

            public String getOutputType() {
                return ((MethodDescriptorProto) this.instance).getOutputType();
            }

            public ByteString getOutputTypeBytes() {
                return ((MethodDescriptorProto) this.instance).getOutputTypeBytes();
            }

            public Builder setOutputType(String str) {
                copyOnWrite();
                ((MethodDescriptorProto) this.instance).setOutputType(str);
                return this;
            }

            public Builder clearOutputType() {
                copyOnWrite();
                ((MethodDescriptorProto) this.instance).clearOutputType();
                return this;
            }

            public Builder setOutputTypeBytes(ByteString byteString) {
                copyOnWrite();
                ((MethodDescriptorProto) this.instance).setOutputTypeBytes(byteString);
                return this;
            }

            public boolean hasOptions() {
                return ((MethodDescriptorProto) this.instance).hasOptions();
            }

            public MethodOptions getOptions() {
                return ((MethodDescriptorProto) this.instance).getOptions();
            }

            public Builder setOptions(MethodOptions methodOptions) {
                copyOnWrite();
                ((MethodDescriptorProto) this.instance).setOptions(methodOptions);
                return this;
            }

            public Builder setOptions(MethodOptions.Builder builder) {
                copyOnWrite();
                ((MethodDescriptorProto) this.instance).setOptions(builder);
                return this;
            }

            public Builder mergeOptions(MethodOptions methodOptions) {
                copyOnWrite();
                ((MethodDescriptorProto) this.instance).mergeOptions(methodOptions);
                return this;
            }

            public Builder clearOptions() {
                copyOnWrite();
                ((MethodDescriptorProto) this.instance).clearOptions();
                return this;
            }

            public boolean hasClientStreaming() {
                return ((MethodDescriptorProto) this.instance).hasClientStreaming();
            }

            public boolean getClientStreaming() {
                return ((MethodDescriptorProto) this.instance).getClientStreaming();
            }

            public Builder setClientStreaming(boolean z) {
                copyOnWrite();
                ((MethodDescriptorProto) this.instance).setClientStreaming(z);
                return this;
            }

            public Builder clearClientStreaming() {
                copyOnWrite();
                ((MethodDescriptorProto) this.instance).clearClientStreaming();
                return this;
            }

            public boolean hasServerStreaming() {
                return ((MethodDescriptorProto) this.instance).hasServerStreaming();
            }

            public boolean getServerStreaming() {
                return ((MethodDescriptorProto) this.instance).getServerStreaming();
            }

            public Builder setServerStreaming(boolean z) {
                copyOnWrite();
                ((MethodDescriptorProto) this.instance).setServerStreaming(z);
                return this;
            }

            public Builder clearServerStreaming() {
                copyOnWrite();
                ((MethodDescriptorProto) this.instance).clearServerStreaming();
                return this;
            }
        }

        /* access modifiers changed from: protected */
        public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            boolean z = false;
            switch (methodToInvoke) {
                case NEW_MUTABLE_INSTANCE:
                    return new MethodDescriptorProto();
                case IS_INITIALIZED:
                    byte b = this.memoizedIsInitialized;
                    if (b == 1) {
                        return DEFAULT_INSTANCE;
                    }
                    if (b == 0) {
                        return null;
                    }
                    boolean booleanValue = ((Boolean) obj).booleanValue();
                    if (!hasOptions() || getOptions().isInitialized()) {
                        if (booleanValue) {
                            this.memoizedIsInitialized = 1;
                        }
                        return DEFAULT_INSTANCE;
                    }
                    if (booleanValue) {
                        this.memoizedIsInitialized = 0;
                    }
                    return null;
                case MAKE_IMMUTABLE:
                    return null;
                case NEW_BUILDER:
                    return new Builder();
                case VISIT:
                    GeneratedMessageLite.Visitor visitor = (GeneratedMessageLite.Visitor) obj;
                    MethodDescriptorProto methodDescriptorProto = (MethodDescriptorProto) obj2;
                    this.name_ = visitor.visitString(hasName(), this.name_, methodDescriptorProto.hasName(), methodDescriptorProto.name_);
                    this.inputType_ = visitor.visitString(hasInputType(), this.inputType_, methodDescriptorProto.hasInputType(), methodDescriptorProto.inputType_);
                    this.outputType_ = visitor.visitString(hasOutputType(), this.outputType_, methodDescriptorProto.hasOutputType(), methodDescriptorProto.outputType_);
                    this.options_ = (MethodOptions) visitor.visitMessage(this.options_, methodDescriptorProto.options_);
                    this.clientStreaming_ = visitor.visitBoolean(hasClientStreaming(), this.clientStreaming_, methodDescriptorProto.hasClientStreaming(), methodDescriptorProto.clientStreaming_);
                    this.serverStreaming_ = visitor.visitBoolean(hasServerStreaming(), this.serverStreaming_, methodDescriptorProto.hasServerStreaming(), methodDescriptorProto.serverStreaming_);
                    if (visitor == GeneratedMessageLite.MergeFromVisitor.INSTANCE) {
                        this.bitField0_ |= methodDescriptorProto.bitField0_;
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
                                    this.bitField0_ |= 1;
                                    this.name_ = readString;
                                } else if (readTag == 18) {
                                    String readString2 = codedInputStream.readString();
                                    this.bitField0_ |= 2;
                                    this.inputType_ = readString2;
                                } else if (readTag == 26) {
                                    String readString3 = codedInputStream.readString();
                                    this.bitField0_ |= 4;
                                    this.outputType_ = readString3;
                                } else if (readTag == 34) {
                                    MethodOptions.Builder builder = (this.bitField0_ & 8) == 8 ? (MethodOptions.Builder) this.options_.toBuilder() : null;
                                    this.options_ = (MethodOptions) codedInputStream.readMessage(MethodOptions.parser(), extensionRegistryLite);
                                    if (builder != null) {
                                        builder.mergeFrom(this.options_);
                                        this.options_ = (MethodOptions) builder.buildPartial();
                                    }
                                    this.bitField0_ |= 8;
                                } else if (readTag == 40) {
                                    this.bitField0_ |= 16;
                                    this.clientStreaming_ = codedInputStream.readBool();
                                } else if (readTag == 48) {
                                    this.bitField0_ |= 32;
                                    this.serverStreaming_ = codedInputStream.readBool();
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
                        synchronized (MethodDescriptorProto.class) {
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

        public static MethodDescriptorProto getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<MethodDescriptorProto> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }
    }

    /* compiled from: com.google.firebase:protolite-well-known-types@@16.0.1 */
    public static final class FileOptions extends GeneratedMessageLite.ExtendableMessage<FileOptions, Builder> implements FileOptionsOrBuilder {
        public static final int CC_ENABLE_ARENAS_FIELD_NUMBER = 31;
        public static final int CC_GENERIC_SERVICES_FIELD_NUMBER = 16;
        public static final int CSHARP_NAMESPACE_FIELD_NUMBER = 37;
        /* access modifiers changed from: private */
        public static final FileOptions DEFAULT_INSTANCE = new FileOptions();
        public static final int DEPRECATED_FIELD_NUMBER = 23;
        public static final int GO_PACKAGE_FIELD_NUMBER = 11;
        public static final int JAVA_GENERATE_EQUALS_AND_HASH_FIELD_NUMBER = 20;
        public static final int JAVA_GENERIC_SERVICES_FIELD_NUMBER = 17;
        public static final int JAVA_MULTIPLE_FILES_FIELD_NUMBER = 10;
        public static final int JAVA_OUTER_CLASSNAME_FIELD_NUMBER = 8;
        public static final int JAVA_PACKAGE_FIELD_NUMBER = 1;
        public static final int JAVA_STRING_CHECK_UTF8_FIELD_NUMBER = 27;
        public static final int OBJC_CLASS_PREFIX_FIELD_NUMBER = 36;
        public static final int OPTIMIZE_FOR_FIELD_NUMBER = 9;
        private static volatile Parser<FileOptions> PARSER = null;
        public static final int PHP_CLASS_PREFIX_FIELD_NUMBER = 40;
        public static final int PHP_GENERIC_SERVICES_FIELD_NUMBER = 42;
        public static final int PHP_NAMESPACE_FIELD_NUMBER = 41;
        public static final int PY_GENERIC_SERVICES_FIELD_NUMBER = 18;
        public static final int SWIFT_PREFIX_FIELD_NUMBER = 39;
        public static final int UNINTERPRETED_OPTION_FIELD_NUMBER = 999;
        private int bitField0_;
        private boolean ccEnableArenas_;
        private boolean ccGenericServices_;
        private String csharpNamespace_ = "";
        private boolean deprecated_;
        private String goPackage_ = "";
        private boolean javaGenerateEqualsAndHash_;
        private boolean javaGenericServices_;
        private boolean javaMultipleFiles_;
        private String javaOuterClassname_ = "";
        private String javaPackage_ = "";
        private boolean javaStringCheckUtf8_;
        private byte memoizedIsInitialized = -1;
        private String objcClassPrefix_ = "";
        private int optimizeFor_ = 1;
        private String phpClassPrefix_ = "";
        private boolean phpGenericServices_;
        private String phpNamespace_ = "";
        private boolean pyGenericServices_;
        private String swiftPrefix_ = "";
        private Internal.ProtobufList<UninterpretedOption> uninterpretedOption_ = emptyProtobufList();

        private FileOptions() {
        }

        /* compiled from: com.google.firebase:protolite-well-known-types@@16.0.1 */
        public enum OptimizeMode implements Internal.EnumLite {
            SPEED(1),
            CODE_SIZE(2),
            LITE_RUNTIME(3);
            
            public static final int CODE_SIZE_VALUE = 2;
            public static final int LITE_RUNTIME_VALUE = 3;
            public static final int SPEED_VALUE = 1;
            private static final Internal.EnumLiteMap<OptimizeMode> internalValueMap = null;
            private final int value;

            static {
                internalValueMap = new Internal.EnumLiteMap<OptimizeMode>() {
                    public OptimizeMode findValueByNumber(int i) {
                        return OptimizeMode.forNumber(i);
                    }
                };
            }

            public final int getNumber() {
                return this.value;
            }

            @Deprecated
            public static OptimizeMode valueOf(int i) {
                return forNumber(i);
            }

            public static OptimizeMode forNumber(int i) {
                if (i == 1) {
                    return SPEED;
                }
                if (i == 2) {
                    return CODE_SIZE;
                }
                if (i != 3) {
                    return null;
                }
                return LITE_RUNTIME;
            }

            public static Internal.EnumLiteMap<OptimizeMode> internalGetValueMap() {
                return internalValueMap;
            }

            private OptimizeMode(int i) {
                this.value = i;
            }
        }

        public boolean hasJavaPackage() {
            return (this.bitField0_ & 1) == 1;
        }

        public String getJavaPackage() {
            return this.javaPackage_;
        }

        public ByteString getJavaPackageBytes() {
            return ByteString.copyFromUtf8(this.javaPackage_);
        }

        /* access modifiers changed from: private */
        public void setJavaPackage(String str) {
            if (str != null) {
                this.bitField0_ |= 1;
                this.javaPackage_ = str;
                return;
            }
            throw new NullPointerException();
        }

        /* access modifiers changed from: private */
        public void clearJavaPackage() {
            this.bitField0_ &= -2;
            this.javaPackage_ = getDefaultInstance().getJavaPackage();
        }

        /* access modifiers changed from: private */
        public void setJavaPackageBytes(ByteString byteString) {
            if (byteString != null) {
                this.bitField0_ |= 1;
                this.javaPackage_ = byteString.toStringUtf8();
                return;
            }
            throw new NullPointerException();
        }

        public boolean hasJavaOuterClassname() {
            return (this.bitField0_ & 2) == 2;
        }

        public String getJavaOuterClassname() {
            return this.javaOuterClassname_;
        }

        public ByteString getJavaOuterClassnameBytes() {
            return ByteString.copyFromUtf8(this.javaOuterClassname_);
        }

        /* access modifiers changed from: private */
        public void setJavaOuterClassname(String str) {
            if (str != null) {
                this.bitField0_ |= 2;
                this.javaOuterClassname_ = str;
                return;
            }
            throw new NullPointerException();
        }

        /* access modifiers changed from: private */
        public void clearJavaOuterClassname() {
            this.bitField0_ &= -3;
            this.javaOuterClassname_ = getDefaultInstance().getJavaOuterClassname();
        }

        /* access modifiers changed from: private */
        public void setJavaOuterClassnameBytes(ByteString byteString) {
            if (byteString != null) {
                this.bitField0_ |= 2;
                this.javaOuterClassname_ = byteString.toStringUtf8();
                return;
            }
            throw new NullPointerException();
        }

        public boolean hasJavaMultipleFiles() {
            return (this.bitField0_ & 4) == 4;
        }

        public boolean getJavaMultipleFiles() {
            return this.javaMultipleFiles_;
        }

        /* access modifiers changed from: private */
        public void setJavaMultipleFiles(boolean z) {
            this.bitField0_ |= 4;
            this.javaMultipleFiles_ = z;
        }

        /* access modifiers changed from: private */
        public void clearJavaMultipleFiles() {
            this.bitField0_ &= -5;
            this.javaMultipleFiles_ = false;
        }

        @Deprecated
        public boolean hasJavaGenerateEqualsAndHash() {
            return (this.bitField0_ & 8) == 8;
        }

        @Deprecated
        public boolean getJavaGenerateEqualsAndHash() {
            return this.javaGenerateEqualsAndHash_;
        }

        /* access modifiers changed from: private */
        public void setJavaGenerateEqualsAndHash(boolean z) {
            this.bitField0_ |= 8;
            this.javaGenerateEqualsAndHash_ = z;
        }

        /* access modifiers changed from: private */
        public void clearJavaGenerateEqualsAndHash() {
            this.bitField0_ &= -9;
            this.javaGenerateEqualsAndHash_ = false;
        }

        public boolean hasJavaStringCheckUtf8() {
            return (this.bitField0_ & 16) == 16;
        }

        public boolean getJavaStringCheckUtf8() {
            return this.javaStringCheckUtf8_;
        }

        /* access modifiers changed from: private */
        public void setJavaStringCheckUtf8(boolean z) {
            this.bitField0_ |= 16;
            this.javaStringCheckUtf8_ = z;
        }

        /* access modifiers changed from: private */
        public void clearJavaStringCheckUtf8() {
            this.bitField0_ &= -17;
            this.javaStringCheckUtf8_ = false;
        }

        public boolean hasOptimizeFor() {
            return (this.bitField0_ & 32) == 32;
        }

        public OptimizeMode getOptimizeFor() {
            OptimizeMode forNumber = OptimizeMode.forNumber(this.optimizeFor_);
            return forNumber == null ? OptimizeMode.SPEED : forNumber;
        }

        /* access modifiers changed from: private */
        public void setOptimizeFor(OptimizeMode optimizeMode) {
            if (optimizeMode != null) {
                this.bitField0_ |= 32;
                this.optimizeFor_ = optimizeMode.getNumber();
                return;
            }
            throw new NullPointerException();
        }

        /* access modifiers changed from: private */
        public void clearOptimizeFor() {
            this.bitField0_ &= -33;
            this.optimizeFor_ = 1;
        }

        public boolean hasGoPackage() {
            return (this.bitField0_ & 64) == 64;
        }

        public String getGoPackage() {
            return this.goPackage_;
        }

        public ByteString getGoPackageBytes() {
            return ByteString.copyFromUtf8(this.goPackage_);
        }

        /* access modifiers changed from: private */
        public void setGoPackage(String str) {
            if (str != null) {
                this.bitField0_ |= 64;
                this.goPackage_ = str;
                return;
            }
            throw new NullPointerException();
        }

        /* access modifiers changed from: private */
        public void clearGoPackage() {
            this.bitField0_ &= -65;
            this.goPackage_ = getDefaultInstance().getGoPackage();
        }

        /* access modifiers changed from: private */
        public void setGoPackageBytes(ByteString byteString) {
            if (byteString != null) {
                this.bitField0_ |= 64;
                this.goPackage_ = byteString.toStringUtf8();
                return;
            }
            throw new NullPointerException();
        }

        public boolean hasCcGenericServices() {
            return (this.bitField0_ & 128) == 128;
        }

        public boolean getCcGenericServices() {
            return this.ccGenericServices_;
        }

        /* access modifiers changed from: private */
        public void setCcGenericServices(boolean z) {
            this.bitField0_ |= 128;
            this.ccGenericServices_ = z;
        }

        /* access modifiers changed from: private */
        public void clearCcGenericServices() {
            this.bitField0_ &= -129;
            this.ccGenericServices_ = false;
        }

        public boolean hasJavaGenericServices() {
            return (this.bitField0_ & 256) == 256;
        }

        public boolean getJavaGenericServices() {
            return this.javaGenericServices_;
        }

        /* access modifiers changed from: private */
        public void setJavaGenericServices(boolean z) {
            this.bitField0_ |= 256;
            this.javaGenericServices_ = z;
        }

        /* access modifiers changed from: private */
        public void clearJavaGenericServices() {
            this.bitField0_ &= -257;
            this.javaGenericServices_ = false;
        }

        public boolean hasPyGenericServices() {
            return (this.bitField0_ & 512) == 512;
        }

        public boolean getPyGenericServices() {
            return this.pyGenericServices_;
        }

        /* access modifiers changed from: private */
        public void setPyGenericServices(boolean z) {
            this.bitField0_ |= 512;
            this.pyGenericServices_ = z;
        }

        /* access modifiers changed from: private */
        public void clearPyGenericServices() {
            this.bitField0_ &= -513;
            this.pyGenericServices_ = false;
        }

        public boolean hasPhpGenericServices() {
            return (this.bitField0_ & 1024) == 1024;
        }

        public boolean getPhpGenericServices() {
            return this.phpGenericServices_;
        }

        /* access modifiers changed from: private */
        public void setPhpGenericServices(boolean z) {
            this.bitField0_ |= 1024;
            this.phpGenericServices_ = z;
        }

        /* access modifiers changed from: private */
        public void clearPhpGenericServices() {
            this.bitField0_ &= -1025;
            this.phpGenericServices_ = false;
        }

        public boolean hasDeprecated() {
            return (this.bitField0_ & 2048) == 2048;
        }

        public boolean getDeprecated() {
            return this.deprecated_;
        }

        /* access modifiers changed from: private */
        public void setDeprecated(boolean z) {
            this.bitField0_ |= 2048;
            this.deprecated_ = z;
        }

        /* access modifiers changed from: private */
        public void clearDeprecated() {
            this.bitField0_ &= -2049;
            this.deprecated_ = false;
        }

        public boolean hasCcEnableArenas() {
            return (this.bitField0_ & 4096) == 4096;
        }

        public boolean getCcEnableArenas() {
            return this.ccEnableArenas_;
        }

        /* access modifiers changed from: private */
        public void setCcEnableArenas(boolean z) {
            this.bitField0_ |= 4096;
            this.ccEnableArenas_ = z;
        }

        /* access modifiers changed from: private */
        public void clearCcEnableArenas() {
            this.bitField0_ &= -4097;
            this.ccEnableArenas_ = false;
        }

        public boolean hasObjcClassPrefix() {
            return (this.bitField0_ & 8192) == 8192;
        }

        public String getObjcClassPrefix() {
            return this.objcClassPrefix_;
        }

        public ByteString getObjcClassPrefixBytes() {
            return ByteString.copyFromUtf8(this.objcClassPrefix_);
        }

        /* access modifiers changed from: private */
        public void setObjcClassPrefix(String str) {
            if (str != null) {
                this.bitField0_ |= 8192;
                this.objcClassPrefix_ = str;
                return;
            }
            throw new NullPointerException();
        }

        /* access modifiers changed from: private */
        public void clearObjcClassPrefix() {
            this.bitField0_ &= -8193;
            this.objcClassPrefix_ = getDefaultInstance().getObjcClassPrefix();
        }

        /* access modifiers changed from: private */
        public void setObjcClassPrefixBytes(ByteString byteString) {
            if (byteString != null) {
                this.bitField0_ |= 8192;
                this.objcClassPrefix_ = byteString.toStringUtf8();
                return;
            }
            throw new NullPointerException();
        }

        public boolean hasCsharpNamespace() {
            return (this.bitField0_ & 16384) == 16384;
        }

        public String getCsharpNamespace() {
            return this.csharpNamespace_;
        }

        public ByteString getCsharpNamespaceBytes() {
            return ByteString.copyFromUtf8(this.csharpNamespace_);
        }

        /* access modifiers changed from: private */
        public void setCsharpNamespace(String str) {
            if (str != null) {
                this.bitField0_ |= 16384;
                this.csharpNamespace_ = str;
                return;
            }
            throw new NullPointerException();
        }

        /* access modifiers changed from: private */
        public void clearCsharpNamespace() {
            this.bitField0_ &= -16385;
            this.csharpNamespace_ = getDefaultInstance().getCsharpNamespace();
        }

        /* access modifiers changed from: private */
        public void setCsharpNamespaceBytes(ByteString byteString) {
            if (byteString != null) {
                this.bitField0_ |= 16384;
                this.csharpNamespace_ = byteString.toStringUtf8();
                return;
            }
            throw new NullPointerException();
        }

        public boolean hasSwiftPrefix() {
            return (this.bitField0_ & 32768) == 32768;
        }

        public String getSwiftPrefix() {
            return this.swiftPrefix_;
        }

        public ByteString getSwiftPrefixBytes() {
            return ByteString.copyFromUtf8(this.swiftPrefix_);
        }

        /* access modifiers changed from: private */
        public void setSwiftPrefix(String str) {
            if (str != null) {
                this.bitField0_ |= 32768;
                this.swiftPrefix_ = str;
                return;
            }
            throw new NullPointerException();
        }

        /* access modifiers changed from: private */
        public void clearSwiftPrefix() {
            this.bitField0_ &= -32769;
            this.swiftPrefix_ = getDefaultInstance().getSwiftPrefix();
        }

        /* access modifiers changed from: private */
        public void setSwiftPrefixBytes(ByteString byteString) {
            if (byteString != null) {
                this.bitField0_ |= 32768;
                this.swiftPrefix_ = byteString.toStringUtf8();
                return;
            }
            throw new NullPointerException();
        }

        public boolean hasPhpClassPrefix() {
            return (this.bitField0_ & 65536) == 65536;
        }

        public String getPhpClassPrefix() {
            return this.phpClassPrefix_;
        }

        public ByteString getPhpClassPrefixBytes() {
            return ByteString.copyFromUtf8(this.phpClassPrefix_);
        }

        /* access modifiers changed from: private */
        public void setPhpClassPrefix(String str) {
            if (str != null) {
                this.bitField0_ |= 65536;
                this.phpClassPrefix_ = str;
                return;
            }
            throw new NullPointerException();
        }

        /* access modifiers changed from: private */
        public void clearPhpClassPrefix() {
            this.bitField0_ &= -65537;
            this.phpClassPrefix_ = getDefaultInstance().getPhpClassPrefix();
        }

        /* access modifiers changed from: private */
        public void setPhpClassPrefixBytes(ByteString byteString) {
            if (byteString != null) {
                this.bitField0_ |= 65536;
                this.phpClassPrefix_ = byteString.toStringUtf8();
                return;
            }
            throw new NullPointerException();
        }

        public boolean hasPhpNamespace() {
            return (this.bitField0_ & 131072) == 131072;
        }

        public String getPhpNamespace() {
            return this.phpNamespace_;
        }

        public ByteString getPhpNamespaceBytes() {
            return ByteString.copyFromUtf8(this.phpNamespace_);
        }

        /* access modifiers changed from: private */
        public void setPhpNamespace(String str) {
            if (str != null) {
                this.bitField0_ |= 131072;
                this.phpNamespace_ = str;
                return;
            }
            throw new NullPointerException();
        }

        /* access modifiers changed from: private */
        public void clearPhpNamespace() {
            this.bitField0_ &= -131073;
            this.phpNamespace_ = getDefaultInstance().getPhpNamespace();
        }

        /* access modifiers changed from: private */
        public void setPhpNamespaceBytes(ByteString byteString) {
            if (byteString != null) {
                this.bitField0_ |= 131072;
                this.phpNamespace_ = byteString.toStringUtf8();
                return;
            }
            throw new NullPointerException();
        }

        public List<UninterpretedOption> getUninterpretedOptionList() {
            return this.uninterpretedOption_;
        }

        public List<? extends UninterpretedOptionOrBuilder> getUninterpretedOptionOrBuilderList() {
            return this.uninterpretedOption_;
        }

        public int getUninterpretedOptionCount() {
            return this.uninterpretedOption_.size();
        }

        public UninterpretedOption getUninterpretedOption(int i) {
            return (UninterpretedOption) this.uninterpretedOption_.get(i);
        }

        public UninterpretedOptionOrBuilder getUninterpretedOptionOrBuilder(int i) {
            return (UninterpretedOptionOrBuilder) this.uninterpretedOption_.get(i);
        }

        private void ensureUninterpretedOptionIsMutable() {
            if (!this.uninterpretedOption_.isModifiable()) {
                this.uninterpretedOption_ = GeneratedMessageLite.mutableCopy(this.uninterpretedOption_);
            }
        }

        /* access modifiers changed from: private */
        public void setUninterpretedOption(int i, UninterpretedOption uninterpretedOption) {
            if (uninterpretedOption != null) {
                ensureUninterpretedOptionIsMutable();
                this.uninterpretedOption_.set(i, uninterpretedOption);
                return;
            }
            throw new NullPointerException();
        }

        /* access modifiers changed from: private */
        public void setUninterpretedOption(int i, UninterpretedOption.Builder builder) {
            ensureUninterpretedOptionIsMutable();
            this.uninterpretedOption_.set(i, (UninterpretedOption) builder.build());
        }

        /* access modifiers changed from: private */
        public void addUninterpretedOption(UninterpretedOption uninterpretedOption) {
            if (uninterpretedOption != null) {
                ensureUninterpretedOptionIsMutable();
                this.uninterpretedOption_.add(uninterpretedOption);
                return;
            }
            throw new NullPointerException();
        }

        /* access modifiers changed from: private */
        public void addUninterpretedOption(int i, UninterpretedOption uninterpretedOption) {
            if (uninterpretedOption != null) {
                ensureUninterpretedOptionIsMutable();
                this.uninterpretedOption_.add(i, uninterpretedOption);
                return;
            }
            throw new NullPointerException();
        }

        /* access modifiers changed from: private */
        public void addUninterpretedOption(UninterpretedOption.Builder builder) {
            ensureUninterpretedOptionIsMutable();
            this.uninterpretedOption_.add((UninterpretedOption) builder.build());
        }

        /* access modifiers changed from: private */
        public void addUninterpretedOption(int i, UninterpretedOption.Builder builder) {
            ensureUninterpretedOptionIsMutable();
            this.uninterpretedOption_.add(i, (UninterpretedOption) builder.build());
        }

        /* access modifiers changed from: private */
        public void addAllUninterpretedOption(Iterable<? extends UninterpretedOption> iterable) {
            ensureUninterpretedOptionIsMutable();
            AbstractMessageLite.addAll(iterable, this.uninterpretedOption_);
        }

        /* access modifiers changed from: private */
        public void clearUninterpretedOption() {
            this.uninterpretedOption_ = emptyProtobufList();
        }

        /* access modifiers changed from: private */
        public void removeUninterpretedOption(int i) {
            ensureUninterpretedOptionIsMutable();
            this.uninterpretedOption_.remove(i);
        }

        public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
            GeneratedMessageLite.ExtendableMessage<MessageType, BuilderType>.ExtensionWriter newExtensionWriter = newExtensionWriter();
            if ((this.bitField0_ & 1) == 1) {
                codedOutputStream.writeString(1, getJavaPackage());
            }
            if ((this.bitField0_ & 2) == 2) {
                codedOutputStream.writeString(8, getJavaOuterClassname());
            }
            if ((this.bitField0_ & 32) == 32) {
                codedOutputStream.writeEnum(9, this.optimizeFor_);
            }
            if ((this.bitField0_ & 4) == 4) {
                codedOutputStream.writeBool(10, this.javaMultipleFiles_);
            }
            if ((this.bitField0_ & 64) == 64) {
                codedOutputStream.writeString(11, getGoPackage());
            }
            if ((this.bitField0_ & 128) == 128) {
                codedOutputStream.writeBool(16, this.ccGenericServices_);
            }
            if ((this.bitField0_ & 256) == 256) {
                codedOutputStream.writeBool(17, this.javaGenericServices_);
            }
            if ((this.bitField0_ & 512) == 512) {
                codedOutputStream.writeBool(18, this.pyGenericServices_);
            }
            if ((this.bitField0_ & 8) == 8) {
                codedOutputStream.writeBool(20, this.javaGenerateEqualsAndHash_);
            }
            if ((this.bitField0_ & 2048) == 2048) {
                codedOutputStream.writeBool(23, this.deprecated_);
            }
            if ((this.bitField0_ & 16) == 16) {
                codedOutputStream.writeBool(27, this.javaStringCheckUtf8_);
            }
            if ((this.bitField0_ & 4096) == 4096) {
                codedOutputStream.writeBool(31, this.ccEnableArenas_);
            }
            if ((this.bitField0_ & 8192) == 8192) {
                codedOutputStream.writeString(36, getObjcClassPrefix());
            }
            if ((this.bitField0_ & 16384) == 16384) {
                codedOutputStream.writeString(37, getCsharpNamespace());
            }
            if ((this.bitField0_ & 32768) == 32768) {
                codedOutputStream.writeString(39, getSwiftPrefix());
            }
            if ((this.bitField0_ & 65536) == 65536) {
                codedOutputStream.writeString(40, getPhpClassPrefix());
            }
            if ((this.bitField0_ & 131072) == 131072) {
                codedOutputStream.writeString(41, getPhpNamespace());
            }
            if ((this.bitField0_ & 1024) == 1024) {
                codedOutputStream.writeBool(42, this.phpGenericServices_);
            }
            for (int i = 0; i < this.uninterpretedOption_.size(); i++) {
                codedOutputStream.writeMessage(999, (MessageLite) this.uninterpretedOption_.get(i));
            }
            newExtensionWriter.writeUntil(PropertyOptions.DELETE_EXISTING, codedOutputStream);
            this.unknownFields.writeTo(codedOutputStream);
        }

        public int getSerializedSize() {
            int i = this.memoizedSerializedSize;
            if (i != -1) {
                return i;
            }
            int computeStringSize = (this.bitField0_ & 1) == 1 ? CodedOutputStream.computeStringSize(1, getJavaPackage()) + 0 : 0;
            if ((this.bitField0_ & 2) == 2) {
                computeStringSize += CodedOutputStream.computeStringSize(8, getJavaOuterClassname());
            }
            if ((this.bitField0_ & 32) == 32) {
                computeStringSize += CodedOutputStream.computeEnumSize(9, this.optimizeFor_);
            }
            if ((this.bitField0_ & 4) == 4) {
                computeStringSize += CodedOutputStream.computeBoolSize(10, this.javaMultipleFiles_);
            }
            if ((this.bitField0_ & 64) == 64) {
                computeStringSize += CodedOutputStream.computeStringSize(11, getGoPackage());
            }
            if ((this.bitField0_ & 128) == 128) {
                computeStringSize += CodedOutputStream.computeBoolSize(16, this.ccGenericServices_);
            }
            if ((this.bitField0_ & 256) == 256) {
                computeStringSize += CodedOutputStream.computeBoolSize(17, this.javaGenericServices_);
            }
            if ((this.bitField0_ & 512) == 512) {
                computeStringSize += CodedOutputStream.computeBoolSize(18, this.pyGenericServices_);
            }
            if ((this.bitField0_ & 8) == 8) {
                computeStringSize += CodedOutputStream.computeBoolSize(20, this.javaGenerateEqualsAndHash_);
            }
            if ((this.bitField0_ & 2048) == 2048) {
                computeStringSize += CodedOutputStream.computeBoolSize(23, this.deprecated_);
            }
            if ((this.bitField0_ & 16) == 16) {
                computeStringSize += CodedOutputStream.computeBoolSize(27, this.javaStringCheckUtf8_);
            }
            if ((this.bitField0_ & 4096) == 4096) {
                computeStringSize += CodedOutputStream.computeBoolSize(31, this.ccEnableArenas_);
            }
            if ((this.bitField0_ & 8192) == 8192) {
                computeStringSize += CodedOutputStream.computeStringSize(36, getObjcClassPrefix());
            }
            if ((this.bitField0_ & 16384) == 16384) {
                computeStringSize += CodedOutputStream.computeStringSize(37, getCsharpNamespace());
            }
            if ((this.bitField0_ & 32768) == 32768) {
                computeStringSize += CodedOutputStream.computeStringSize(39, getSwiftPrefix());
            }
            if ((this.bitField0_ & 65536) == 65536) {
                computeStringSize += CodedOutputStream.computeStringSize(40, getPhpClassPrefix());
            }
            if ((this.bitField0_ & 131072) == 131072) {
                computeStringSize += CodedOutputStream.computeStringSize(41, getPhpNamespace());
            }
            if ((this.bitField0_ & 1024) == 1024) {
                computeStringSize += CodedOutputStream.computeBoolSize(42, this.phpGenericServices_);
            }
            for (int i2 = 0; i2 < this.uninterpretedOption_.size(); i2++) {
                computeStringSize += CodedOutputStream.computeMessageSize(999, (MessageLite) this.uninterpretedOption_.get(i2));
            }
            int extensionsSerializedSize = computeStringSize + extensionsSerializedSize() + this.unknownFields.getSerializedSize();
            this.memoizedSerializedSize = extensionsSerializedSize;
            return extensionsSerializedSize;
        }

        public static FileOptions parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return (FileOptions) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
        }

        public static FileOptions parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (FileOptions) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
        }

        public static FileOptions parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return (FileOptions) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
        }

        public static FileOptions parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (FileOptions) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
        }

        public static FileOptions parseFrom(InputStream inputStream) throws IOException {
            return (FileOptions) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static FileOptions parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (FileOptions) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static FileOptions parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (FileOptions) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static FileOptions parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (FileOptions) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static FileOptions parseFrom(CodedInputStream codedInputStream) throws IOException {
            return (FileOptions) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
        }

        public static FileOptions parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (FileOptions) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
        }

        public static Builder newBuilder() {
            return (Builder) DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(FileOptions fileOptions) {
            return (Builder) ((Builder) DEFAULT_INSTANCE.toBuilder()).mergeFrom(fileOptions);
        }

        /* compiled from: com.google.firebase:protolite-well-known-types@@16.0.1 */
        public static final class Builder extends GeneratedMessageLite.ExtendableBuilder<FileOptions, Builder> implements FileOptionsOrBuilder {
            private Builder() {
                super(FileOptions.DEFAULT_INSTANCE);
            }

            public boolean hasJavaPackage() {
                return ((FileOptions) this.instance).hasJavaPackage();
            }

            public String getJavaPackage() {
                return ((FileOptions) this.instance).getJavaPackage();
            }

            public ByteString getJavaPackageBytes() {
                return ((FileOptions) this.instance).getJavaPackageBytes();
            }

            public Builder setJavaPackage(String str) {
                copyOnWrite();
                ((FileOptions) this.instance).setJavaPackage(str);
                return this;
            }

            public Builder clearJavaPackage() {
                copyOnWrite();
                ((FileOptions) this.instance).clearJavaPackage();
                return this;
            }

            public Builder setJavaPackageBytes(ByteString byteString) {
                copyOnWrite();
                ((FileOptions) this.instance).setJavaPackageBytes(byteString);
                return this;
            }

            public boolean hasJavaOuterClassname() {
                return ((FileOptions) this.instance).hasJavaOuterClassname();
            }

            public String getJavaOuterClassname() {
                return ((FileOptions) this.instance).getJavaOuterClassname();
            }

            public ByteString getJavaOuterClassnameBytes() {
                return ((FileOptions) this.instance).getJavaOuterClassnameBytes();
            }

            public Builder setJavaOuterClassname(String str) {
                copyOnWrite();
                ((FileOptions) this.instance).setJavaOuterClassname(str);
                return this;
            }

            public Builder clearJavaOuterClassname() {
                copyOnWrite();
                ((FileOptions) this.instance).clearJavaOuterClassname();
                return this;
            }

            public Builder setJavaOuterClassnameBytes(ByteString byteString) {
                copyOnWrite();
                ((FileOptions) this.instance).setJavaOuterClassnameBytes(byteString);
                return this;
            }

            public boolean hasJavaMultipleFiles() {
                return ((FileOptions) this.instance).hasJavaMultipleFiles();
            }

            public boolean getJavaMultipleFiles() {
                return ((FileOptions) this.instance).getJavaMultipleFiles();
            }

            public Builder setJavaMultipleFiles(boolean z) {
                copyOnWrite();
                ((FileOptions) this.instance).setJavaMultipleFiles(z);
                return this;
            }

            public Builder clearJavaMultipleFiles() {
                copyOnWrite();
                ((FileOptions) this.instance).clearJavaMultipleFiles();
                return this;
            }

            @Deprecated
            public boolean hasJavaGenerateEqualsAndHash() {
                return ((FileOptions) this.instance).hasJavaGenerateEqualsAndHash();
            }

            @Deprecated
            public boolean getJavaGenerateEqualsAndHash() {
                return ((FileOptions) this.instance).getJavaGenerateEqualsAndHash();
            }

            @Deprecated
            public Builder setJavaGenerateEqualsAndHash(boolean z) {
                copyOnWrite();
                ((FileOptions) this.instance).setJavaGenerateEqualsAndHash(z);
                return this;
            }

            @Deprecated
            public Builder clearJavaGenerateEqualsAndHash() {
                copyOnWrite();
                ((FileOptions) this.instance).clearJavaGenerateEqualsAndHash();
                return this;
            }

            public boolean hasJavaStringCheckUtf8() {
                return ((FileOptions) this.instance).hasJavaStringCheckUtf8();
            }

            public boolean getJavaStringCheckUtf8() {
                return ((FileOptions) this.instance).getJavaStringCheckUtf8();
            }

            public Builder setJavaStringCheckUtf8(boolean z) {
                copyOnWrite();
                ((FileOptions) this.instance).setJavaStringCheckUtf8(z);
                return this;
            }

            public Builder clearJavaStringCheckUtf8() {
                copyOnWrite();
                ((FileOptions) this.instance).clearJavaStringCheckUtf8();
                return this;
            }

            public boolean hasOptimizeFor() {
                return ((FileOptions) this.instance).hasOptimizeFor();
            }

            public OptimizeMode getOptimizeFor() {
                return ((FileOptions) this.instance).getOptimizeFor();
            }

            public Builder setOptimizeFor(OptimizeMode optimizeMode) {
                copyOnWrite();
                ((FileOptions) this.instance).setOptimizeFor(optimizeMode);
                return this;
            }

            public Builder clearOptimizeFor() {
                copyOnWrite();
                ((FileOptions) this.instance).clearOptimizeFor();
                return this;
            }

            public boolean hasGoPackage() {
                return ((FileOptions) this.instance).hasGoPackage();
            }

            public String getGoPackage() {
                return ((FileOptions) this.instance).getGoPackage();
            }

            public ByteString getGoPackageBytes() {
                return ((FileOptions) this.instance).getGoPackageBytes();
            }

            public Builder setGoPackage(String str) {
                copyOnWrite();
                ((FileOptions) this.instance).setGoPackage(str);
                return this;
            }

            public Builder clearGoPackage() {
                copyOnWrite();
                ((FileOptions) this.instance).clearGoPackage();
                return this;
            }

            public Builder setGoPackageBytes(ByteString byteString) {
                copyOnWrite();
                ((FileOptions) this.instance).setGoPackageBytes(byteString);
                return this;
            }

            public boolean hasCcGenericServices() {
                return ((FileOptions) this.instance).hasCcGenericServices();
            }

            public boolean getCcGenericServices() {
                return ((FileOptions) this.instance).getCcGenericServices();
            }

            public Builder setCcGenericServices(boolean z) {
                copyOnWrite();
                ((FileOptions) this.instance).setCcGenericServices(z);
                return this;
            }

            public Builder clearCcGenericServices() {
                copyOnWrite();
                ((FileOptions) this.instance).clearCcGenericServices();
                return this;
            }

            public boolean hasJavaGenericServices() {
                return ((FileOptions) this.instance).hasJavaGenericServices();
            }

            public boolean getJavaGenericServices() {
                return ((FileOptions) this.instance).getJavaGenericServices();
            }

            public Builder setJavaGenericServices(boolean z) {
                copyOnWrite();
                ((FileOptions) this.instance).setJavaGenericServices(z);
                return this;
            }

            public Builder clearJavaGenericServices() {
                copyOnWrite();
                ((FileOptions) this.instance).clearJavaGenericServices();
                return this;
            }

            public boolean hasPyGenericServices() {
                return ((FileOptions) this.instance).hasPyGenericServices();
            }

            public boolean getPyGenericServices() {
                return ((FileOptions) this.instance).getPyGenericServices();
            }

            public Builder setPyGenericServices(boolean z) {
                copyOnWrite();
                ((FileOptions) this.instance).setPyGenericServices(z);
                return this;
            }

            public Builder clearPyGenericServices() {
                copyOnWrite();
                ((FileOptions) this.instance).clearPyGenericServices();
                return this;
            }

            public boolean hasPhpGenericServices() {
                return ((FileOptions) this.instance).hasPhpGenericServices();
            }

            public boolean getPhpGenericServices() {
                return ((FileOptions) this.instance).getPhpGenericServices();
            }

            public Builder setPhpGenericServices(boolean z) {
                copyOnWrite();
                ((FileOptions) this.instance).setPhpGenericServices(z);
                return this;
            }

            public Builder clearPhpGenericServices() {
                copyOnWrite();
                ((FileOptions) this.instance).clearPhpGenericServices();
                return this;
            }

            public boolean hasDeprecated() {
                return ((FileOptions) this.instance).hasDeprecated();
            }

            public boolean getDeprecated() {
                return ((FileOptions) this.instance).getDeprecated();
            }

            public Builder setDeprecated(boolean z) {
                copyOnWrite();
                ((FileOptions) this.instance).setDeprecated(z);
                return this;
            }

            public Builder clearDeprecated() {
                copyOnWrite();
                ((FileOptions) this.instance).clearDeprecated();
                return this;
            }

            public boolean hasCcEnableArenas() {
                return ((FileOptions) this.instance).hasCcEnableArenas();
            }

            public boolean getCcEnableArenas() {
                return ((FileOptions) this.instance).getCcEnableArenas();
            }

            public Builder setCcEnableArenas(boolean z) {
                copyOnWrite();
                ((FileOptions) this.instance).setCcEnableArenas(z);
                return this;
            }

            public Builder clearCcEnableArenas() {
                copyOnWrite();
                ((FileOptions) this.instance).clearCcEnableArenas();
                return this;
            }

            public boolean hasObjcClassPrefix() {
                return ((FileOptions) this.instance).hasObjcClassPrefix();
            }

            public String getObjcClassPrefix() {
                return ((FileOptions) this.instance).getObjcClassPrefix();
            }

            public ByteString getObjcClassPrefixBytes() {
                return ((FileOptions) this.instance).getObjcClassPrefixBytes();
            }

            public Builder setObjcClassPrefix(String str) {
                copyOnWrite();
                ((FileOptions) this.instance).setObjcClassPrefix(str);
                return this;
            }

            public Builder clearObjcClassPrefix() {
                copyOnWrite();
                ((FileOptions) this.instance).clearObjcClassPrefix();
                return this;
            }

            public Builder setObjcClassPrefixBytes(ByteString byteString) {
                copyOnWrite();
                ((FileOptions) this.instance).setObjcClassPrefixBytes(byteString);
                return this;
            }

            public boolean hasCsharpNamespace() {
                return ((FileOptions) this.instance).hasCsharpNamespace();
            }

            public String getCsharpNamespace() {
                return ((FileOptions) this.instance).getCsharpNamespace();
            }

            public ByteString getCsharpNamespaceBytes() {
                return ((FileOptions) this.instance).getCsharpNamespaceBytes();
            }

            public Builder setCsharpNamespace(String str) {
                copyOnWrite();
                ((FileOptions) this.instance).setCsharpNamespace(str);
                return this;
            }

            public Builder clearCsharpNamespace() {
                copyOnWrite();
                ((FileOptions) this.instance).clearCsharpNamespace();
                return this;
            }

            public Builder setCsharpNamespaceBytes(ByteString byteString) {
                copyOnWrite();
                ((FileOptions) this.instance).setCsharpNamespaceBytes(byteString);
                return this;
            }

            public boolean hasSwiftPrefix() {
                return ((FileOptions) this.instance).hasSwiftPrefix();
            }

            public String getSwiftPrefix() {
                return ((FileOptions) this.instance).getSwiftPrefix();
            }

            public ByteString getSwiftPrefixBytes() {
                return ((FileOptions) this.instance).getSwiftPrefixBytes();
            }

            public Builder setSwiftPrefix(String str) {
                copyOnWrite();
                ((FileOptions) this.instance).setSwiftPrefix(str);
                return this;
            }

            public Builder clearSwiftPrefix() {
                copyOnWrite();
                ((FileOptions) this.instance).clearSwiftPrefix();
                return this;
            }

            public Builder setSwiftPrefixBytes(ByteString byteString) {
                copyOnWrite();
                ((FileOptions) this.instance).setSwiftPrefixBytes(byteString);
                return this;
            }

            public boolean hasPhpClassPrefix() {
                return ((FileOptions) this.instance).hasPhpClassPrefix();
            }

            public String getPhpClassPrefix() {
                return ((FileOptions) this.instance).getPhpClassPrefix();
            }

            public ByteString getPhpClassPrefixBytes() {
                return ((FileOptions) this.instance).getPhpClassPrefixBytes();
            }

            public Builder setPhpClassPrefix(String str) {
                copyOnWrite();
                ((FileOptions) this.instance).setPhpClassPrefix(str);
                return this;
            }

            public Builder clearPhpClassPrefix() {
                copyOnWrite();
                ((FileOptions) this.instance).clearPhpClassPrefix();
                return this;
            }

            public Builder setPhpClassPrefixBytes(ByteString byteString) {
                copyOnWrite();
                ((FileOptions) this.instance).setPhpClassPrefixBytes(byteString);
                return this;
            }

            public boolean hasPhpNamespace() {
                return ((FileOptions) this.instance).hasPhpNamespace();
            }

            public String getPhpNamespace() {
                return ((FileOptions) this.instance).getPhpNamespace();
            }

            public ByteString getPhpNamespaceBytes() {
                return ((FileOptions) this.instance).getPhpNamespaceBytes();
            }

            public Builder setPhpNamespace(String str) {
                copyOnWrite();
                ((FileOptions) this.instance).setPhpNamespace(str);
                return this;
            }

            public Builder clearPhpNamespace() {
                copyOnWrite();
                ((FileOptions) this.instance).clearPhpNamespace();
                return this;
            }

            public Builder setPhpNamespaceBytes(ByteString byteString) {
                copyOnWrite();
                ((FileOptions) this.instance).setPhpNamespaceBytes(byteString);
                return this;
            }

            public List<UninterpretedOption> getUninterpretedOptionList() {
                return Collections.unmodifiableList(((FileOptions) this.instance).getUninterpretedOptionList());
            }

            public int getUninterpretedOptionCount() {
                return ((FileOptions) this.instance).getUninterpretedOptionCount();
            }

            public UninterpretedOption getUninterpretedOption(int i) {
                return ((FileOptions) this.instance).getUninterpretedOption(i);
            }

            public Builder setUninterpretedOption(int i, UninterpretedOption uninterpretedOption) {
                copyOnWrite();
                ((FileOptions) this.instance).setUninterpretedOption(i, uninterpretedOption);
                return this;
            }

            public Builder setUninterpretedOption(int i, UninterpretedOption.Builder builder) {
                copyOnWrite();
                ((FileOptions) this.instance).setUninterpretedOption(i, builder);
                return this;
            }

            public Builder addUninterpretedOption(UninterpretedOption uninterpretedOption) {
                copyOnWrite();
                ((FileOptions) this.instance).addUninterpretedOption(uninterpretedOption);
                return this;
            }

            public Builder addUninterpretedOption(int i, UninterpretedOption uninterpretedOption) {
                copyOnWrite();
                ((FileOptions) this.instance).addUninterpretedOption(i, uninterpretedOption);
                return this;
            }

            public Builder addUninterpretedOption(UninterpretedOption.Builder builder) {
                copyOnWrite();
                ((FileOptions) this.instance).addUninterpretedOption(builder);
                return this;
            }

            public Builder addUninterpretedOption(int i, UninterpretedOption.Builder builder) {
                copyOnWrite();
                ((FileOptions) this.instance).addUninterpretedOption(i, builder);
                return this;
            }

            public Builder addAllUninterpretedOption(Iterable<? extends UninterpretedOption> iterable) {
                copyOnWrite();
                ((FileOptions) this.instance).addAllUninterpretedOption(iterable);
                return this;
            }

            public Builder clearUninterpretedOption() {
                copyOnWrite();
                ((FileOptions) this.instance).clearUninterpretedOption();
                return this;
            }

            public Builder removeUninterpretedOption(int i) {
                copyOnWrite();
                ((FileOptions) this.instance).removeUninterpretedOption(i);
                return this;
            }
        }

        /* access modifiers changed from: protected */
        public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            boolean z = false;
            switch (methodToInvoke) {
                case NEW_MUTABLE_INSTANCE:
                    return new FileOptions();
                case IS_INITIALIZED:
                    byte b = this.memoizedIsInitialized;
                    if (b == 1) {
                        return DEFAULT_INSTANCE;
                    }
                    if (b == 0) {
                        return null;
                    }
                    boolean booleanValue = ((Boolean) obj).booleanValue();
                    for (int i = 0; i < getUninterpretedOptionCount(); i++) {
                        if (!getUninterpretedOption(i).isInitialized()) {
                            if (booleanValue) {
                                this.memoizedIsInitialized = 0;
                            }
                            return null;
                        }
                    }
                    if (!extensionsAreInitialized()) {
                        if (booleanValue) {
                            this.memoizedIsInitialized = 0;
                        }
                        return null;
                    }
                    if (booleanValue) {
                        this.memoizedIsInitialized = 1;
                    }
                    return DEFAULT_INSTANCE;
                case MAKE_IMMUTABLE:
                    this.uninterpretedOption_.makeImmutable();
                    return null;
                case NEW_BUILDER:
                    return new Builder();
                case VISIT:
                    GeneratedMessageLite.Visitor visitor = (GeneratedMessageLite.Visitor) obj;
                    FileOptions fileOptions = (FileOptions) obj2;
                    this.javaPackage_ = visitor.visitString(hasJavaPackage(), this.javaPackage_, fileOptions.hasJavaPackage(), fileOptions.javaPackage_);
                    this.javaOuterClassname_ = visitor.visitString(hasJavaOuterClassname(), this.javaOuterClassname_, fileOptions.hasJavaOuterClassname(), fileOptions.javaOuterClassname_);
                    this.javaMultipleFiles_ = visitor.visitBoolean(hasJavaMultipleFiles(), this.javaMultipleFiles_, fileOptions.hasJavaMultipleFiles(), fileOptions.javaMultipleFiles_);
                    this.javaGenerateEqualsAndHash_ = visitor.visitBoolean(hasJavaGenerateEqualsAndHash(), this.javaGenerateEqualsAndHash_, fileOptions.hasJavaGenerateEqualsAndHash(), fileOptions.javaGenerateEqualsAndHash_);
                    this.javaStringCheckUtf8_ = visitor.visitBoolean(hasJavaStringCheckUtf8(), this.javaStringCheckUtf8_, fileOptions.hasJavaStringCheckUtf8(), fileOptions.javaStringCheckUtf8_);
                    this.optimizeFor_ = visitor.visitInt(hasOptimizeFor(), this.optimizeFor_, fileOptions.hasOptimizeFor(), fileOptions.optimizeFor_);
                    this.goPackage_ = visitor.visitString(hasGoPackage(), this.goPackage_, fileOptions.hasGoPackage(), fileOptions.goPackage_);
                    this.ccGenericServices_ = visitor.visitBoolean(hasCcGenericServices(), this.ccGenericServices_, fileOptions.hasCcGenericServices(), fileOptions.ccGenericServices_);
                    this.javaGenericServices_ = visitor.visitBoolean(hasJavaGenericServices(), this.javaGenericServices_, fileOptions.hasJavaGenericServices(), fileOptions.javaGenericServices_);
                    this.pyGenericServices_ = visitor.visitBoolean(hasPyGenericServices(), this.pyGenericServices_, fileOptions.hasPyGenericServices(), fileOptions.pyGenericServices_);
                    this.phpGenericServices_ = visitor.visitBoolean(hasPhpGenericServices(), this.phpGenericServices_, fileOptions.hasPhpGenericServices(), fileOptions.phpGenericServices_);
                    this.deprecated_ = visitor.visitBoolean(hasDeprecated(), this.deprecated_, fileOptions.hasDeprecated(), fileOptions.deprecated_);
                    this.ccEnableArenas_ = visitor.visitBoolean(hasCcEnableArenas(), this.ccEnableArenas_, fileOptions.hasCcEnableArenas(), fileOptions.ccEnableArenas_);
                    this.objcClassPrefix_ = visitor.visitString(hasObjcClassPrefix(), this.objcClassPrefix_, fileOptions.hasObjcClassPrefix(), fileOptions.objcClassPrefix_);
                    this.csharpNamespace_ = visitor.visitString(hasCsharpNamespace(), this.csharpNamespace_, fileOptions.hasCsharpNamespace(), fileOptions.csharpNamespace_);
                    this.swiftPrefix_ = visitor.visitString(hasSwiftPrefix(), this.swiftPrefix_, fileOptions.hasSwiftPrefix(), fileOptions.swiftPrefix_);
                    this.phpClassPrefix_ = visitor.visitString(hasPhpClassPrefix(), this.phpClassPrefix_, fileOptions.hasPhpClassPrefix(), fileOptions.phpClassPrefix_);
                    this.phpNamespace_ = visitor.visitString(hasPhpNamespace(), this.phpNamespace_, fileOptions.hasPhpNamespace(), fileOptions.phpNamespace_);
                    this.uninterpretedOption_ = visitor.visitList(this.uninterpretedOption_, fileOptions.uninterpretedOption_);
                    if (visitor == GeneratedMessageLite.MergeFromVisitor.INSTANCE) {
                        this.bitField0_ |= fileOptions.bitField0_;
                    }
                    return this;
                case MERGE_FROM_STREAM:
                    CodedInputStream codedInputStream = (CodedInputStream) obj;
                    ExtensionRegistryLite extensionRegistryLite = (ExtensionRegistryLite) obj2;
                    while (!z) {
                        try {
                            int readTag = codedInputStream.readTag();
                            switch (readTag) {
                                case 0:
                                    z = true;
                                    break;
                                case 10:
                                    String readString = codedInputStream.readString();
                                    this.bitField0_ |= 1;
                                    this.javaPackage_ = readString;
                                    break;
                                case 66:
                                    String readString2 = codedInputStream.readString();
                                    this.bitField0_ |= 2;
                                    this.javaOuterClassname_ = readString2;
                                    break;
                                case 72:
                                    int readEnum = codedInputStream.readEnum();
                                    if (OptimizeMode.forNumber(readEnum) != null) {
                                        this.bitField0_ |= 32;
                                        this.optimizeFor_ = readEnum;
                                        break;
                                    } else {
                                        super.mergeVarintField(9, readEnum);
                                        break;
                                    }
                                case 80:
                                    this.bitField0_ |= 4;
                                    this.javaMultipleFiles_ = codedInputStream.readBool();
                                    break;
                                case 90:
                                    String readString3 = codedInputStream.readString();
                                    this.bitField0_ |= 64;
                                    this.goPackage_ = readString3;
                                    break;
                                case 128:
                                    this.bitField0_ |= 128;
                                    this.ccGenericServices_ = codedInputStream.readBool();
                                    break;
                                case 136:
                                    this.bitField0_ |= 256;
                                    this.javaGenericServices_ = codedInputStream.readBool();
                                    break;
                                case 144:
                                    this.bitField0_ |= 512;
                                    this.pyGenericServices_ = codedInputStream.readBool();
                                    break;
                                case 160:
                                    this.bitField0_ |= 8;
                                    this.javaGenerateEqualsAndHash_ = codedInputStream.readBool();
                                    break;
                                case NikonType2MakernoteDirectory.TAG_FILE_INFO:
                                    this.bitField0_ |= 2048;
                                    this.deprecated_ = codedInputStream.readBool();
                                    break;
                                case JfifUtil.MARKER_SOI:
                                    this.bitField0_ |= 16;
                                    this.javaStringCheckUtf8_ = codedInputStream.readBool();
                                    break;
                                case 248:
                                    this.bitField0_ |= 4096;
                                    this.ccEnableArenas_ = codedInputStream.readBool();
                                    break;
                                case OlympusRawInfoMakernoteDirectory.TagWbRbLevelsFineWeather:
                                    String readString4 = codedInputStream.readString();
                                    this.bitField0_ |= 8192;
                                    this.objcClassPrefix_ = readString4;
                                    break;
                                case 298:
                                    String readString5 = codedInputStream.readString();
                                    this.bitField0_ |= 16384;
                                    this.csharpNamespace_ = readString5;
                                    break;
                                case 314:
                                    String readString6 = codedInputStream.readString();
                                    this.bitField0_ |= 32768;
                                    this.swiftPrefix_ = readString6;
                                    break;
                                case ExifDirectoryBase.TAG_TILE_WIDTH:
                                    String readString7 = codedInputStream.readString();
                                    this.bitField0_ |= 65536;
                                    this.phpClassPrefix_ = readString7;
                                    break;
                                case ExifDirectoryBase.TAG_SUB_IFD_OFFSET:
                                    String readString8 = codedInputStream.readString();
                                    this.bitField0_ |= 131072;
                                    this.phpNamespace_ = readString8;
                                    break;
                                case IptcDirectory.TAG_TIME_SENT:
                                    this.bitField0_ |= 1024;
                                    this.phpGenericServices_ = codedInputStream.readBool();
                                    break;
                                case 7994:
                                    if (!this.uninterpretedOption_.isModifiable()) {
                                        this.uninterpretedOption_ = GeneratedMessageLite.mutableCopy(this.uninterpretedOption_);
                                    }
                                    this.uninterpretedOption_.add((UninterpretedOption) codedInputStream.readMessage(UninterpretedOption.parser(), extensionRegistryLite));
                                    break;
                                default:
                                    if (parseUnknownField((FileOptions) getDefaultInstanceForType(), codedInputStream, extensionRegistryLite, readTag)) {
                                        break;
                                    }
                                    z = true;
                                    break;
                            }
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
                        synchronized (FileOptions.class) {
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

        public static FileOptions getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<FileOptions> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }
    }

    /* compiled from: com.google.firebase:protolite-well-known-types@@16.0.1 */
    public static final class MessageOptions extends GeneratedMessageLite.ExtendableMessage<MessageOptions, Builder> implements MessageOptionsOrBuilder {
        /* access modifiers changed from: private */
        public static final MessageOptions DEFAULT_INSTANCE = new MessageOptions();
        public static final int DEPRECATED_FIELD_NUMBER = 3;
        public static final int MAP_ENTRY_FIELD_NUMBER = 7;
        public static final int MESSAGE_SET_WIRE_FORMAT_FIELD_NUMBER = 1;
        public static final int NO_STANDARD_DESCRIPTOR_ACCESSOR_FIELD_NUMBER = 2;
        private static volatile Parser<MessageOptions> PARSER = null;
        public static final int UNINTERPRETED_OPTION_FIELD_NUMBER = 999;
        private int bitField0_;
        private boolean deprecated_;
        private boolean mapEntry_;
        private byte memoizedIsInitialized = -1;
        private boolean messageSetWireFormat_;
        private boolean noStandardDescriptorAccessor_;
        private Internal.ProtobufList<UninterpretedOption> uninterpretedOption_ = emptyProtobufList();

        private MessageOptions() {
        }

        public boolean hasMessageSetWireFormat() {
            return (this.bitField0_ & 1) == 1;
        }

        public boolean getMessageSetWireFormat() {
            return this.messageSetWireFormat_;
        }

        /* access modifiers changed from: private */
        public void setMessageSetWireFormat(boolean z) {
            this.bitField0_ |= 1;
            this.messageSetWireFormat_ = z;
        }

        /* access modifiers changed from: private */
        public void clearMessageSetWireFormat() {
            this.bitField0_ &= -2;
            this.messageSetWireFormat_ = false;
        }

        public boolean hasNoStandardDescriptorAccessor() {
            return (this.bitField0_ & 2) == 2;
        }

        public boolean getNoStandardDescriptorAccessor() {
            return this.noStandardDescriptorAccessor_;
        }

        /* access modifiers changed from: private */
        public void setNoStandardDescriptorAccessor(boolean z) {
            this.bitField0_ |= 2;
            this.noStandardDescriptorAccessor_ = z;
        }

        /* access modifiers changed from: private */
        public void clearNoStandardDescriptorAccessor() {
            this.bitField0_ &= -3;
            this.noStandardDescriptorAccessor_ = false;
        }

        public boolean hasDeprecated() {
            return (this.bitField0_ & 4) == 4;
        }

        public boolean getDeprecated() {
            return this.deprecated_;
        }

        /* access modifiers changed from: private */
        public void setDeprecated(boolean z) {
            this.bitField0_ |= 4;
            this.deprecated_ = z;
        }

        /* access modifiers changed from: private */
        public void clearDeprecated() {
            this.bitField0_ &= -5;
            this.deprecated_ = false;
        }

        public boolean hasMapEntry() {
            return (this.bitField0_ & 8) == 8;
        }

        public boolean getMapEntry() {
            return this.mapEntry_;
        }

        /* access modifiers changed from: private */
        public void setMapEntry(boolean z) {
            this.bitField0_ |= 8;
            this.mapEntry_ = z;
        }

        /* access modifiers changed from: private */
        public void clearMapEntry() {
            this.bitField0_ &= -9;
            this.mapEntry_ = false;
        }

        public List<UninterpretedOption> getUninterpretedOptionList() {
            return this.uninterpretedOption_;
        }

        public List<? extends UninterpretedOptionOrBuilder> getUninterpretedOptionOrBuilderList() {
            return this.uninterpretedOption_;
        }

        public int getUninterpretedOptionCount() {
            return this.uninterpretedOption_.size();
        }

        public UninterpretedOption getUninterpretedOption(int i) {
            return (UninterpretedOption) this.uninterpretedOption_.get(i);
        }

        public UninterpretedOptionOrBuilder getUninterpretedOptionOrBuilder(int i) {
            return (UninterpretedOptionOrBuilder) this.uninterpretedOption_.get(i);
        }

        private void ensureUninterpretedOptionIsMutable() {
            if (!this.uninterpretedOption_.isModifiable()) {
                this.uninterpretedOption_ = GeneratedMessageLite.mutableCopy(this.uninterpretedOption_);
            }
        }

        /* access modifiers changed from: private */
        public void setUninterpretedOption(int i, UninterpretedOption uninterpretedOption) {
            if (uninterpretedOption != null) {
                ensureUninterpretedOptionIsMutable();
                this.uninterpretedOption_.set(i, uninterpretedOption);
                return;
            }
            throw new NullPointerException();
        }

        /* access modifiers changed from: private */
        public void setUninterpretedOption(int i, UninterpretedOption.Builder builder) {
            ensureUninterpretedOptionIsMutable();
            this.uninterpretedOption_.set(i, (UninterpretedOption) builder.build());
        }

        /* access modifiers changed from: private */
        public void addUninterpretedOption(UninterpretedOption uninterpretedOption) {
            if (uninterpretedOption != null) {
                ensureUninterpretedOptionIsMutable();
                this.uninterpretedOption_.add(uninterpretedOption);
                return;
            }
            throw new NullPointerException();
        }

        /* access modifiers changed from: private */
        public void addUninterpretedOption(int i, UninterpretedOption uninterpretedOption) {
            if (uninterpretedOption != null) {
                ensureUninterpretedOptionIsMutable();
                this.uninterpretedOption_.add(i, uninterpretedOption);
                return;
            }
            throw new NullPointerException();
        }

        /* access modifiers changed from: private */
        public void addUninterpretedOption(UninterpretedOption.Builder builder) {
            ensureUninterpretedOptionIsMutable();
            this.uninterpretedOption_.add((UninterpretedOption) builder.build());
        }

        /* access modifiers changed from: private */
        public void addUninterpretedOption(int i, UninterpretedOption.Builder builder) {
            ensureUninterpretedOptionIsMutable();
            this.uninterpretedOption_.add(i, (UninterpretedOption) builder.build());
        }

        /* access modifiers changed from: private */
        public void addAllUninterpretedOption(Iterable<? extends UninterpretedOption> iterable) {
            ensureUninterpretedOptionIsMutable();
            AbstractMessageLite.addAll(iterable, this.uninterpretedOption_);
        }

        /* access modifiers changed from: private */
        public void clearUninterpretedOption() {
            this.uninterpretedOption_ = emptyProtobufList();
        }

        /* access modifiers changed from: private */
        public void removeUninterpretedOption(int i) {
            ensureUninterpretedOptionIsMutable();
            this.uninterpretedOption_.remove(i);
        }

        public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
            GeneratedMessageLite.ExtendableMessage<MessageType, BuilderType>.ExtensionWriter newExtensionWriter = newExtensionWriter();
            if ((this.bitField0_ & 1) == 1) {
                codedOutputStream.writeBool(1, this.messageSetWireFormat_);
            }
            if ((this.bitField0_ & 2) == 2) {
                codedOutputStream.writeBool(2, this.noStandardDescriptorAccessor_);
            }
            if ((this.bitField0_ & 4) == 4) {
                codedOutputStream.writeBool(3, this.deprecated_);
            }
            if ((this.bitField0_ & 8) == 8) {
                codedOutputStream.writeBool(7, this.mapEntry_);
            }
            for (int i = 0; i < this.uninterpretedOption_.size(); i++) {
                codedOutputStream.writeMessage(999, (MessageLite) this.uninterpretedOption_.get(i));
            }
            newExtensionWriter.writeUntil(PropertyOptions.DELETE_EXISTING, codedOutputStream);
            this.unknownFields.writeTo(codedOutputStream);
        }

        public int getSerializedSize() {
            int i = this.memoizedSerializedSize;
            if (i != -1) {
                return i;
            }
            int computeBoolSize = (this.bitField0_ & 1) == 1 ? CodedOutputStream.computeBoolSize(1, this.messageSetWireFormat_) + 0 : 0;
            if ((this.bitField0_ & 2) == 2) {
                computeBoolSize += CodedOutputStream.computeBoolSize(2, this.noStandardDescriptorAccessor_);
            }
            if ((this.bitField0_ & 4) == 4) {
                computeBoolSize += CodedOutputStream.computeBoolSize(3, this.deprecated_);
            }
            if ((this.bitField0_ & 8) == 8) {
                computeBoolSize += CodedOutputStream.computeBoolSize(7, this.mapEntry_);
            }
            for (int i2 = 0; i2 < this.uninterpretedOption_.size(); i2++) {
                computeBoolSize += CodedOutputStream.computeMessageSize(999, (MessageLite) this.uninterpretedOption_.get(i2));
            }
            int extensionsSerializedSize = computeBoolSize + extensionsSerializedSize() + this.unknownFields.getSerializedSize();
            this.memoizedSerializedSize = extensionsSerializedSize;
            return extensionsSerializedSize;
        }

        public static MessageOptions parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return (MessageOptions) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
        }

        public static MessageOptions parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (MessageOptions) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
        }

        public static MessageOptions parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return (MessageOptions) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
        }

        public static MessageOptions parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (MessageOptions) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
        }

        public static MessageOptions parseFrom(InputStream inputStream) throws IOException {
            return (MessageOptions) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static MessageOptions parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (MessageOptions) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static MessageOptions parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (MessageOptions) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static MessageOptions parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (MessageOptions) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static MessageOptions parseFrom(CodedInputStream codedInputStream) throws IOException {
            return (MessageOptions) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
        }

        public static MessageOptions parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (MessageOptions) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
        }

        public static Builder newBuilder() {
            return (Builder) DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(MessageOptions messageOptions) {
            return (Builder) ((Builder) DEFAULT_INSTANCE.toBuilder()).mergeFrom(messageOptions);
        }

        /* compiled from: com.google.firebase:protolite-well-known-types@@16.0.1 */
        public static final class Builder extends GeneratedMessageLite.ExtendableBuilder<MessageOptions, Builder> implements MessageOptionsOrBuilder {
            private Builder() {
                super(MessageOptions.DEFAULT_INSTANCE);
            }

            public boolean hasMessageSetWireFormat() {
                return ((MessageOptions) this.instance).hasMessageSetWireFormat();
            }

            public boolean getMessageSetWireFormat() {
                return ((MessageOptions) this.instance).getMessageSetWireFormat();
            }

            public Builder setMessageSetWireFormat(boolean z) {
                copyOnWrite();
                ((MessageOptions) this.instance).setMessageSetWireFormat(z);
                return this;
            }

            public Builder clearMessageSetWireFormat() {
                copyOnWrite();
                ((MessageOptions) this.instance).clearMessageSetWireFormat();
                return this;
            }

            public boolean hasNoStandardDescriptorAccessor() {
                return ((MessageOptions) this.instance).hasNoStandardDescriptorAccessor();
            }

            public boolean getNoStandardDescriptorAccessor() {
                return ((MessageOptions) this.instance).getNoStandardDescriptorAccessor();
            }

            public Builder setNoStandardDescriptorAccessor(boolean z) {
                copyOnWrite();
                ((MessageOptions) this.instance).setNoStandardDescriptorAccessor(z);
                return this;
            }

            public Builder clearNoStandardDescriptorAccessor() {
                copyOnWrite();
                ((MessageOptions) this.instance).clearNoStandardDescriptorAccessor();
                return this;
            }

            public boolean hasDeprecated() {
                return ((MessageOptions) this.instance).hasDeprecated();
            }

            public boolean getDeprecated() {
                return ((MessageOptions) this.instance).getDeprecated();
            }

            public Builder setDeprecated(boolean z) {
                copyOnWrite();
                ((MessageOptions) this.instance).setDeprecated(z);
                return this;
            }

            public Builder clearDeprecated() {
                copyOnWrite();
                ((MessageOptions) this.instance).clearDeprecated();
                return this;
            }

            public boolean hasMapEntry() {
                return ((MessageOptions) this.instance).hasMapEntry();
            }

            public boolean getMapEntry() {
                return ((MessageOptions) this.instance).getMapEntry();
            }

            public Builder setMapEntry(boolean z) {
                copyOnWrite();
                ((MessageOptions) this.instance).setMapEntry(z);
                return this;
            }

            public Builder clearMapEntry() {
                copyOnWrite();
                ((MessageOptions) this.instance).clearMapEntry();
                return this;
            }

            public List<UninterpretedOption> getUninterpretedOptionList() {
                return Collections.unmodifiableList(((MessageOptions) this.instance).getUninterpretedOptionList());
            }

            public int getUninterpretedOptionCount() {
                return ((MessageOptions) this.instance).getUninterpretedOptionCount();
            }

            public UninterpretedOption getUninterpretedOption(int i) {
                return ((MessageOptions) this.instance).getUninterpretedOption(i);
            }

            public Builder setUninterpretedOption(int i, UninterpretedOption uninterpretedOption) {
                copyOnWrite();
                ((MessageOptions) this.instance).setUninterpretedOption(i, uninterpretedOption);
                return this;
            }

            public Builder setUninterpretedOption(int i, UninterpretedOption.Builder builder) {
                copyOnWrite();
                ((MessageOptions) this.instance).setUninterpretedOption(i, builder);
                return this;
            }

            public Builder addUninterpretedOption(UninterpretedOption uninterpretedOption) {
                copyOnWrite();
                ((MessageOptions) this.instance).addUninterpretedOption(uninterpretedOption);
                return this;
            }

            public Builder addUninterpretedOption(int i, UninterpretedOption uninterpretedOption) {
                copyOnWrite();
                ((MessageOptions) this.instance).addUninterpretedOption(i, uninterpretedOption);
                return this;
            }

            public Builder addUninterpretedOption(UninterpretedOption.Builder builder) {
                copyOnWrite();
                ((MessageOptions) this.instance).addUninterpretedOption(builder);
                return this;
            }

            public Builder addUninterpretedOption(int i, UninterpretedOption.Builder builder) {
                copyOnWrite();
                ((MessageOptions) this.instance).addUninterpretedOption(i, builder);
                return this;
            }

            public Builder addAllUninterpretedOption(Iterable<? extends UninterpretedOption> iterable) {
                copyOnWrite();
                ((MessageOptions) this.instance).addAllUninterpretedOption(iterable);
                return this;
            }

            public Builder clearUninterpretedOption() {
                copyOnWrite();
                ((MessageOptions) this.instance).clearUninterpretedOption();
                return this;
            }

            public Builder removeUninterpretedOption(int i) {
                copyOnWrite();
                ((MessageOptions) this.instance).removeUninterpretedOption(i);
                return this;
            }
        }

        /* access modifiers changed from: protected */
        public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            boolean z = false;
            switch (methodToInvoke) {
                case NEW_MUTABLE_INSTANCE:
                    return new MessageOptions();
                case IS_INITIALIZED:
                    byte b = this.memoizedIsInitialized;
                    if (b == 1) {
                        return DEFAULT_INSTANCE;
                    }
                    if (b == 0) {
                        return null;
                    }
                    boolean booleanValue = ((Boolean) obj).booleanValue();
                    for (int i = 0; i < getUninterpretedOptionCount(); i++) {
                        if (!getUninterpretedOption(i).isInitialized()) {
                            if (booleanValue) {
                                this.memoizedIsInitialized = 0;
                            }
                            return null;
                        }
                    }
                    if (!extensionsAreInitialized()) {
                        if (booleanValue) {
                            this.memoizedIsInitialized = 0;
                        }
                        return null;
                    }
                    if (booleanValue) {
                        this.memoizedIsInitialized = 1;
                    }
                    return DEFAULT_INSTANCE;
                case MAKE_IMMUTABLE:
                    this.uninterpretedOption_.makeImmutable();
                    return null;
                case NEW_BUILDER:
                    return new Builder();
                case VISIT:
                    GeneratedMessageLite.Visitor visitor = (GeneratedMessageLite.Visitor) obj;
                    MessageOptions messageOptions = (MessageOptions) obj2;
                    this.messageSetWireFormat_ = visitor.visitBoolean(hasMessageSetWireFormat(), this.messageSetWireFormat_, messageOptions.hasMessageSetWireFormat(), messageOptions.messageSetWireFormat_);
                    this.noStandardDescriptorAccessor_ = visitor.visitBoolean(hasNoStandardDescriptorAccessor(), this.noStandardDescriptorAccessor_, messageOptions.hasNoStandardDescriptorAccessor(), messageOptions.noStandardDescriptorAccessor_);
                    this.deprecated_ = visitor.visitBoolean(hasDeprecated(), this.deprecated_, messageOptions.hasDeprecated(), messageOptions.deprecated_);
                    this.mapEntry_ = visitor.visitBoolean(hasMapEntry(), this.mapEntry_, messageOptions.hasMapEntry(), messageOptions.mapEntry_);
                    this.uninterpretedOption_ = visitor.visitList(this.uninterpretedOption_, messageOptions.uninterpretedOption_);
                    if (visitor == GeneratedMessageLite.MergeFromVisitor.INSTANCE) {
                        this.bitField0_ |= messageOptions.bitField0_;
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
                                    this.bitField0_ |= 1;
                                    this.messageSetWireFormat_ = codedInputStream.readBool();
                                } else if (readTag == 16) {
                                    this.bitField0_ |= 2;
                                    this.noStandardDescriptorAccessor_ = codedInputStream.readBool();
                                } else if (readTag == 24) {
                                    this.bitField0_ |= 4;
                                    this.deprecated_ = codedInputStream.readBool();
                                } else if (readTag == 56) {
                                    this.bitField0_ |= 8;
                                    this.mapEntry_ = codedInputStream.readBool();
                                } else if (readTag == 7994) {
                                    if (!this.uninterpretedOption_.isModifiable()) {
                                        this.uninterpretedOption_ = GeneratedMessageLite.mutableCopy(this.uninterpretedOption_);
                                    }
                                    this.uninterpretedOption_.add((UninterpretedOption) codedInputStream.readMessage(UninterpretedOption.parser(), extensionRegistryLite));
                                } else if (!parseUnknownField((MessageOptions) getDefaultInstanceForType(), codedInputStream, extensionRegistryLite, readTag)) {
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
                        synchronized (MessageOptions.class) {
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

        public static MessageOptions getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<MessageOptions> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }
    }

    /* compiled from: com.google.firebase:protolite-well-known-types@@16.0.1 */
    public static final class FieldOptions extends GeneratedMessageLite.ExtendableMessage<FieldOptions, Builder> implements FieldOptionsOrBuilder {
        public static final int CTYPE_FIELD_NUMBER = 1;
        /* access modifiers changed from: private */
        public static final FieldOptions DEFAULT_INSTANCE = new FieldOptions();
        public static final int DEPRECATED_FIELD_NUMBER = 3;
        public static final int JSTYPE_FIELD_NUMBER = 6;
        public static final int LAZY_FIELD_NUMBER = 5;
        public static final int PACKED_FIELD_NUMBER = 2;
        private static volatile Parser<FieldOptions> PARSER = null;
        public static final int UNINTERPRETED_OPTION_FIELD_NUMBER = 999;
        public static final int WEAK_FIELD_NUMBER = 10;
        private int bitField0_;
        private int ctype_;
        private boolean deprecated_;
        private int jstype_;
        private boolean lazy_;
        private byte memoizedIsInitialized = -1;
        private boolean packed_;
        private Internal.ProtobufList<UninterpretedOption> uninterpretedOption_ = emptyProtobufList();
        private boolean weak_;

        private FieldOptions() {
        }

        /* compiled from: com.google.firebase:protolite-well-known-types@@16.0.1 */
        public enum CType implements Internal.EnumLite {
            STRING(0),
            CORD(1),
            STRING_PIECE(2);
            
            public static final int CORD_VALUE = 1;
            public static final int STRING_PIECE_VALUE = 2;
            public static final int STRING_VALUE = 0;
            private static final Internal.EnumLiteMap<CType> internalValueMap = null;
            private final int value;

            static {
                internalValueMap = new Internal.EnumLiteMap<CType>() {
                    public CType findValueByNumber(int i) {
                        return CType.forNumber(i);
                    }
                };
            }

            public final int getNumber() {
                return this.value;
            }

            @Deprecated
            public static CType valueOf(int i) {
                return forNumber(i);
            }

            public static CType forNumber(int i) {
                if (i == 0) {
                    return STRING;
                }
                if (i == 1) {
                    return CORD;
                }
                if (i != 2) {
                    return null;
                }
                return STRING_PIECE;
            }

            public static Internal.EnumLiteMap<CType> internalGetValueMap() {
                return internalValueMap;
            }

            private CType(int i) {
                this.value = i;
            }
        }

        /* compiled from: com.google.firebase:protolite-well-known-types@@16.0.1 */
        public enum JSType implements Internal.EnumLite {
            JS_NORMAL(0),
            JS_STRING(1),
            JS_NUMBER(2);
            
            public static final int JS_NORMAL_VALUE = 0;
            public static final int JS_NUMBER_VALUE = 2;
            public static final int JS_STRING_VALUE = 1;
            private static final Internal.EnumLiteMap<JSType> internalValueMap = null;
            private final int value;

            static {
                internalValueMap = new Internal.EnumLiteMap<JSType>() {
                    public JSType findValueByNumber(int i) {
                        return JSType.forNumber(i);
                    }
                };
            }

            public final int getNumber() {
                return this.value;
            }

            @Deprecated
            public static JSType valueOf(int i) {
                return forNumber(i);
            }

            public static JSType forNumber(int i) {
                if (i == 0) {
                    return JS_NORMAL;
                }
                if (i == 1) {
                    return JS_STRING;
                }
                if (i != 2) {
                    return null;
                }
                return JS_NUMBER;
            }

            public static Internal.EnumLiteMap<JSType> internalGetValueMap() {
                return internalValueMap;
            }

            private JSType(int i) {
                this.value = i;
            }
        }

        public boolean hasCtype() {
            return (this.bitField0_ & 1) == 1;
        }

        public CType getCtype() {
            CType forNumber = CType.forNumber(this.ctype_);
            return forNumber == null ? CType.STRING : forNumber;
        }

        /* access modifiers changed from: private */
        public void setCtype(CType cType) {
            if (cType != null) {
                this.bitField0_ |= 1;
                this.ctype_ = cType.getNumber();
                return;
            }
            throw new NullPointerException();
        }

        /* access modifiers changed from: private */
        public void clearCtype() {
            this.bitField0_ &= -2;
            this.ctype_ = 0;
        }

        public boolean hasPacked() {
            return (this.bitField0_ & 2) == 2;
        }

        public boolean getPacked() {
            return this.packed_;
        }

        /* access modifiers changed from: private */
        public void setPacked(boolean z) {
            this.bitField0_ |= 2;
            this.packed_ = z;
        }

        /* access modifiers changed from: private */
        public void clearPacked() {
            this.bitField0_ &= -3;
            this.packed_ = false;
        }

        public boolean hasJstype() {
            return (this.bitField0_ & 4) == 4;
        }

        public JSType getJstype() {
            JSType forNumber = JSType.forNumber(this.jstype_);
            return forNumber == null ? JSType.JS_NORMAL : forNumber;
        }

        /* access modifiers changed from: private */
        public void setJstype(JSType jSType) {
            if (jSType != null) {
                this.bitField0_ |= 4;
                this.jstype_ = jSType.getNumber();
                return;
            }
            throw new NullPointerException();
        }

        /* access modifiers changed from: private */
        public void clearJstype() {
            this.bitField0_ &= -5;
            this.jstype_ = 0;
        }

        public boolean hasLazy() {
            return (this.bitField0_ & 8) == 8;
        }

        public boolean getLazy() {
            return this.lazy_;
        }

        /* access modifiers changed from: private */
        public void setLazy(boolean z) {
            this.bitField0_ |= 8;
            this.lazy_ = z;
        }

        /* access modifiers changed from: private */
        public void clearLazy() {
            this.bitField0_ &= -9;
            this.lazy_ = false;
        }

        public boolean hasDeprecated() {
            return (this.bitField0_ & 16) == 16;
        }

        public boolean getDeprecated() {
            return this.deprecated_;
        }

        /* access modifiers changed from: private */
        public void setDeprecated(boolean z) {
            this.bitField0_ |= 16;
            this.deprecated_ = z;
        }

        /* access modifiers changed from: private */
        public void clearDeprecated() {
            this.bitField0_ &= -17;
            this.deprecated_ = false;
        }

        public boolean hasWeak() {
            return (this.bitField0_ & 32) == 32;
        }

        public boolean getWeak() {
            return this.weak_;
        }

        /* access modifiers changed from: private */
        public void setWeak(boolean z) {
            this.bitField0_ |= 32;
            this.weak_ = z;
        }

        /* access modifiers changed from: private */
        public void clearWeak() {
            this.bitField0_ &= -33;
            this.weak_ = false;
        }

        public List<UninterpretedOption> getUninterpretedOptionList() {
            return this.uninterpretedOption_;
        }

        public List<? extends UninterpretedOptionOrBuilder> getUninterpretedOptionOrBuilderList() {
            return this.uninterpretedOption_;
        }

        public int getUninterpretedOptionCount() {
            return this.uninterpretedOption_.size();
        }

        public UninterpretedOption getUninterpretedOption(int i) {
            return (UninterpretedOption) this.uninterpretedOption_.get(i);
        }

        public UninterpretedOptionOrBuilder getUninterpretedOptionOrBuilder(int i) {
            return (UninterpretedOptionOrBuilder) this.uninterpretedOption_.get(i);
        }

        private void ensureUninterpretedOptionIsMutable() {
            if (!this.uninterpretedOption_.isModifiable()) {
                this.uninterpretedOption_ = GeneratedMessageLite.mutableCopy(this.uninterpretedOption_);
            }
        }

        /* access modifiers changed from: private */
        public void setUninterpretedOption(int i, UninterpretedOption uninterpretedOption) {
            if (uninterpretedOption != null) {
                ensureUninterpretedOptionIsMutable();
                this.uninterpretedOption_.set(i, uninterpretedOption);
                return;
            }
            throw new NullPointerException();
        }

        /* access modifiers changed from: private */
        public void setUninterpretedOption(int i, UninterpretedOption.Builder builder) {
            ensureUninterpretedOptionIsMutable();
            this.uninterpretedOption_.set(i, (UninterpretedOption) builder.build());
        }

        /* access modifiers changed from: private */
        public void addUninterpretedOption(UninterpretedOption uninterpretedOption) {
            if (uninterpretedOption != null) {
                ensureUninterpretedOptionIsMutable();
                this.uninterpretedOption_.add(uninterpretedOption);
                return;
            }
            throw new NullPointerException();
        }

        /* access modifiers changed from: private */
        public void addUninterpretedOption(int i, UninterpretedOption uninterpretedOption) {
            if (uninterpretedOption != null) {
                ensureUninterpretedOptionIsMutable();
                this.uninterpretedOption_.add(i, uninterpretedOption);
                return;
            }
            throw new NullPointerException();
        }

        /* access modifiers changed from: private */
        public void addUninterpretedOption(UninterpretedOption.Builder builder) {
            ensureUninterpretedOptionIsMutable();
            this.uninterpretedOption_.add((UninterpretedOption) builder.build());
        }

        /* access modifiers changed from: private */
        public void addUninterpretedOption(int i, UninterpretedOption.Builder builder) {
            ensureUninterpretedOptionIsMutable();
            this.uninterpretedOption_.add(i, (UninterpretedOption) builder.build());
        }

        /* access modifiers changed from: private */
        public void addAllUninterpretedOption(Iterable<? extends UninterpretedOption> iterable) {
            ensureUninterpretedOptionIsMutable();
            AbstractMessageLite.addAll(iterable, this.uninterpretedOption_);
        }

        /* access modifiers changed from: private */
        public void clearUninterpretedOption() {
            this.uninterpretedOption_ = emptyProtobufList();
        }

        /* access modifiers changed from: private */
        public void removeUninterpretedOption(int i) {
            ensureUninterpretedOptionIsMutable();
            this.uninterpretedOption_.remove(i);
        }

        public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
            GeneratedMessageLite.ExtendableMessage<MessageType, BuilderType>.ExtensionWriter newExtensionWriter = newExtensionWriter();
            if ((this.bitField0_ & 1) == 1) {
                codedOutputStream.writeEnum(1, this.ctype_);
            }
            if ((this.bitField0_ & 2) == 2) {
                codedOutputStream.writeBool(2, this.packed_);
            }
            if ((this.bitField0_ & 16) == 16) {
                codedOutputStream.writeBool(3, this.deprecated_);
            }
            if ((this.bitField0_ & 8) == 8) {
                codedOutputStream.writeBool(5, this.lazy_);
            }
            if ((this.bitField0_ & 4) == 4) {
                codedOutputStream.writeEnum(6, this.jstype_);
            }
            if ((this.bitField0_ & 32) == 32) {
                codedOutputStream.writeBool(10, this.weak_);
            }
            for (int i = 0; i < this.uninterpretedOption_.size(); i++) {
                codedOutputStream.writeMessage(999, (MessageLite) this.uninterpretedOption_.get(i));
            }
            newExtensionWriter.writeUntil(PropertyOptions.DELETE_EXISTING, codedOutputStream);
            this.unknownFields.writeTo(codedOutputStream);
        }

        public int getSerializedSize() {
            int i = this.memoizedSerializedSize;
            if (i != -1) {
                return i;
            }
            int computeEnumSize = (this.bitField0_ & 1) == 1 ? CodedOutputStream.computeEnumSize(1, this.ctype_) + 0 : 0;
            if ((this.bitField0_ & 2) == 2) {
                computeEnumSize += CodedOutputStream.computeBoolSize(2, this.packed_);
            }
            if ((this.bitField0_ & 16) == 16) {
                computeEnumSize += CodedOutputStream.computeBoolSize(3, this.deprecated_);
            }
            if ((this.bitField0_ & 8) == 8) {
                computeEnumSize += CodedOutputStream.computeBoolSize(5, this.lazy_);
            }
            if ((this.bitField0_ & 4) == 4) {
                computeEnumSize += CodedOutputStream.computeEnumSize(6, this.jstype_);
            }
            if ((this.bitField0_ & 32) == 32) {
                computeEnumSize += CodedOutputStream.computeBoolSize(10, this.weak_);
            }
            for (int i2 = 0; i2 < this.uninterpretedOption_.size(); i2++) {
                computeEnumSize += CodedOutputStream.computeMessageSize(999, (MessageLite) this.uninterpretedOption_.get(i2));
            }
            int extensionsSerializedSize = computeEnumSize + extensionsSerializedSize() + this.unknownFields.getSerializedSize();
            this.memoizedSerializedSize = extensionsSerializedSize;
            return extensionsSerializedSize;
        }

        public static FieldOptions parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return (FieldOptions) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
        }

        public static FieldOptions parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (FieldOptions) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
        }

        public static FieldOptions parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return (FieldOptions) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
        }

        public static FieldOptions parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (FieldOptions) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
        }

        public static FieldOptions parseFrom(InputStream inputStream) throws IOException {
            return (FieldOptions) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static FieldOptions parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (FieldOptions) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static FieldOptions parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (FieldOptions) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static FieldOptions parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (FieldOptions) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static FieldOptions parseFrom(CodedInputStream codedInputStream) throws IOException {
            return (FieldOptions) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
        }

        public static FieldOptions parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (FieldOptions) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
        }

        public static Builder newBuilder() {
            return (Builder) DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(FieldOptions fieldOptions) {
            return (Builder) ((Builder) DEFAULT_INSTANCE.toBuilder()).mergeFrom(fieldOptions);
        }

        /* compiled from: com.google.firebase:protolite-well-known-types@@16.0.1 */
        public static final class Builder extends GeneratedMessageLite.ExtendableBuilder<FieldOptions, Builder> implements FieldOptionsOrBuilder {
            private Builder() {
                super(FieldOptions.DEFAULT_INSTANCE);
            }

            public boolean hasCtype() {
                return ((FieldOptions) this.instance).hasCtype();
            }

            public CType getCtype() {
                return ((FieldOptions) this.instance).getCtype();
            }

            public Builder setCtype(CType cType) {
                copyOnWrite();
                ((FieldOptions) this.instance).setCtype(cType);
                return this;
            }

            public Builder clearCtype() {
                copyOnWrite();
                ((FieldOptions) this.instance).clearCtype();
                return this;
            }

            public boolean hasPacked() {
                return ((FieldOptions) this.instance).hasPacked();
            }

            public boolean getPacked() {
                return ((FieldOptions) this.instance).getPacked();
            }

            public Builder setPacked(boolean z) {
                copyOnWrite();
                ((FieldOptions) this.instance).setPacked(z);
                return this;
            }

            public Builder clearPacked() {
                copyOnWrite();
                ((FieldOptions) this.instance).clearPacked();
                return this;
            }

            public boolean hasJstype() {
                return ((FieldOptions) this.instance).hasJstype();
            }

            public JSType getJstype() {
                return ((FieldOptions) this.instance).getJstype();
            }

            public Builder setJstype(JSType jSType) {
                copyOnWrite();
                ((FieldOptions) this.instance).setJstype(jSType);
                return this;
            }

            public Builder clearJstype() {
                copyOnWrite();
                ((FieldOptions) this.instance).clearJstype();
                return this;
            }

            public boolean hasLazy() {
                return ((FieldOptions) this.instance).hasLazy();
            }

            public boolean getLazy() {
                return ((FieldOptions) this.instance).getLazy();
            }

            public Builder setLazy(boolean z) {
                copyOnWrite();
                ((FieldOptions) this.instance).setLazy(z);
                return this;
            }

            public Builder clearLazy() {
                copyOnWrite();
                ((FieldOptions) this.instance).clearLazy();
                return this;
            }

            public boolean hasDeprecated() {
                return ((FieldOptions) this.instance).hasDeprecated();
            }

            public boolean getDeprecated() {
                return ((FieldOptions) this.instance).getDeprecated();
            }

            public Builder setDeprecated(boolean z) {
                copyOnWrite();
                ((FieldOptions) this.instance).setDeprecated(z);
                return this;
            }

            public Builder clearDeprecated() {
                copyOnWrite();
                ((FieldOptions) this.instance).clearDeprecated();
                return this;
            }

            public boolean hasWeak() {
                return ((FieldOptions) this.instance).hasWeak();
            }

            public boolean getWeak() {
                return ((FieldOptions) this.instance).getWeak();
            }

            public Builder setWeak(boolean z) {
                copyOnWrite();
                ((FieldOptions) this.instance).setWeak(z);
                return this;
            }

            public Builder clearWeak() {
                copyOnWrite();
                ((FieldOptions) this.instance).clearWeak();
                return this;
            }

            public List<UninterpretedOption> getUninterpretedOptionList() {
                return Collections.unmodifiableList(((FieldOptions) this.instance).getUninterpretedOptionList());
            }

            public int getUninterpretedOptionCount() {
                return ((FieldOptions) this.instance).getUninterpretedOptionCount();
            }

            public UninterpretedOption getUninterpretedOption(int i) {
                return ((FieldOptions) this.instance).getUninterpretedOption(i);
            }

            public Builder setUninterpretedOption(int i, UninterpretedOption uninterpretedOption) {
                copyOnWrite();
                ((FieldOptions) this.instance).setUninterpretedOption(i, uninterpretedOption);
                return this;
            }

            public Builder setUninterpretedOption(int i, UninterpretedOption.Builder builder) {
                copyOnWrite();
                ((FieldOptions) this.instance).setUninterpretedOption(i, builder);
                return this;
            }

            public Builder addUninterpretedOption(UninterpretedOption uninterpretedOption) {
                copyOnWrite();
                ((FieldOptions) this.instance).addUninterpretedOption(uninterpretedOption);
                return this;
            }

            public Builder addUninterpretedOption(int i, UninterpretedOption uninterpretedOption) {
                copyOnWrite();
                ((FieldOptions) this.instance).addUninterpretedOption(i, uninterpretedOption);
                return this;
            }

            public Builder addUninterpretedOption(UninterpretedOption.Builder builder) {
                copyOnWrite();
                ((FieldOptions) this.instance).addUninterpretedOption(builder);
                return this;
            }

            public Builder addUninterpretedOption(int i, UninterpretedOption.Builder builder) {
                copyOnWrite();
                ((FieldOptions) this.instance).addUninterpretedOption(i, builder);
                return this;
            }

            public Builder addAllUninterpretedOption(Iterable<? extends UninterpretedOption> iterable) {
                copyOnWrite();
                ((FieldOptions) this.instance).addAllUninterpretedOption(iterable);
                return this;
            }

            public Builder clearUninterpretedOption() {
                copyOnWrite();
                ((FieldOptions) this.instance).clearUninterpretedOption();
                return this;
            }

            public Builder removeUninterpretedOption(int i) {
                copyOnWrite();
                ((FieldOptions) this.instance).removeUninterpretedOption(i);
                return this;
            }
        }

        /* access modifiers changed from: protected */
        public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            boolean z = false;
            switch (methodToInvoke) {
                case NEW_MUTABLE_INSTANCE:
                    return new FieldOptions();
                case IS_INITIALIZED:
                    byte b = this.memoizedIsInitialized;
                    if (b == 1) {
                        return DEFAULT_INSTANCE;
                    }
                    if (b == 0) {
                        return null;
                    }
                    boolean booleanValue = ((Boolean) obj).booleanValue();
                    for (int i = 0; i < getUninterpretedOptionCount(); i++) {
                        if (!getUninterpretedOption(i).isInitialized()) {
                            if (booleanValue) {
                                this.memoizedIsInitialized = 0;
                            }
                            return null;
                        }
                    }
                    if (!extensionsAreInitialized()) {
                        if (booleanValue) {
                            this.memoizedIsInitialized = 0;
                        }
                        return null;
                    }
                    if (booleanValue) {
                        this.memoizedIsInitialized = 1;
                    }
                    return DEFAULT_INSTANCE;
                case MAKE_IMMUTABLE:
                    this.uninterpretedOption_.makeImmutable();
                    return null;
                case NEW_BUILDER:
                    return new Builder();
                case VISIT:
                    GeneratedMessageLite.Visitor visitor = (GeneratedMessageLite.Visitor) obj;
                    FieldOptions fieldOptions = (FieldOptions) obj2;
                    this.ctype_ = visitor.visitInt(hasCtype(), this.ctype_, fieldOptions.hasCtype(), fieldOptions.ctype_);
                    this.packed_ = visitor.visitBoolean(hasPacked(), this.packed_, fieldOptions.hasPacked(), fieldOptions.packed_);
                    this.jstype_ = visitor.visitInt(hasJstype(), this.jstype_, fieldOptions.hasJstype(), fieldOptions.jstype_);
                    this.lazy_ = visitor.visitBoolean(hasLazy(), this.lazy_, fieldOptions.hasLazy(), fieldOptions.lazy_);
                    this.deprecated_ = visitor.visitBoolean(hasDeprecated(), this.deprecated_, fieldOptions.hasDeprecated(), fieldOptions.deprecated_);
                    this.weak_ = visitor.visitBoolean(hasWeak(), this.weak_, fieldOptions.hasWeak(), fieldOptions.weak_);
                    this.uninterpretedOption_ = visitor.visitList(this.uninterpretedOption_, fieldOptions.uninterpretedOption_);
                    if (visitor == GeneratedMessageLite.MergeFromVisitor.INSTANCE) {
                        this.bitField0_ |= fieldOptions.bitField0_;
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
                                    int readEnum = codedInputStream.readEnum();
                                    if (CType.forNumber(readEnum) == null) {
                                        super.mergeVarintField(1, readEnum);
                                    } else {
                                        this.bitField0_ |= 1;
                                        this.ctype_ = readEnum;
                                    }
                                } else if (readTag == 16) {
                                    this.bitField0_ |= 2;
                                    this.packed_ = codedInputStream.readBool();
                                } else if (readTag == 24) {
                                    this.bitField0_ |= 16;
                                    this.deprecated_ = codedInputStream.readBool();
                                } else if (readTag == 40) {
                                    this.bitField0_ |= 8;
                                    this.lazy_ = codedInputStream.readBool();
                                } else if (readTag == 48) {
                                    int readEnum2 = codedInputStream.readEnum();
                                    if (JSType.forNumber(readEnum2) == null) {
                                        super.mergeVarintField(6, readEnum2);
                                    } else {
                                        this.bitField0_ |= 4;
                                        this.jstype_ = readEnum2;
                                    }
                                } else if (readTag == 80) {
                                    this.bitField0_ |= 32;
                                    this.weak_ = codedInputStream.readBool();
                                } else if (readTag == 7994) {
                                    if (!this.uninterpretedOption_.isModifiable()) {
                                        this.uninterpretedOption_ = GeneratedMessageLite.mutableCopy(this.uninterpretedOption_);
                                    }
                                    this.uninterpretedOption_.add((UninterpretedOption) codedInputStream.readMessage(UninterpretedOption.parser(), extensionRegistryLite));
                                } else if (!parseUnknownField((FieldOptions) getDefaultInstanceForType(), codedInputStream, extensionRegistryLite, readTag)) {
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
                        synchronized (FieldOptions.class) {
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

        public static FieldOptions getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<FieldOptions> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }
    }

    /* compiled from: com.google.firebase:protolite-well-known-types@@16.0.1 */
    public static final class OneofOptions extends GeneratedMessageLite.ExtendableMessage<OneofOptions, Builder> implements OneofOptionsOrBuilder {
        /* access modifiers changed from: private */
        public static final OneofOptions DEFAULT_INSTANCE = new OneofOptions();
        private static volatile Parser<OneofOptions> PARSER = null;
        public static final int UNINTERPRETED_OPTION_FIELD_NUMBER = 999;
        private byte memoizedIsInitialized = -1;
        private Internal.ProtobufList<UninterpretedOption> uninterpretedOption_ = emptyProtobufList();

        private OneofOptions() {
        }

        public List<UninterpretedOption> getUninterpretedOptionList() {
            return this.uninterpretedOption_;
        }

        public List<? extends UninterpretedOptionOrBuilder> getUninterpretedOptionOrBuilderList() {
            return this.uninterpretedOption_;
        }

        public int getUninterpretedOptionCount() {
            return this.uninterpretedOption_.size();
        }

        public UninterpretedOption getUninterpretedOption(int i) {
            return (UninterpretedOption) this.uninterpretedOption_.get(i);
        }

        public UninterpretedOptionOrBuilder getUninterpretedOptionOrBuilder(int i) {
            return (UninterpretedOptionOrBuilder) this.uninterpretedOption_.get(i);
        }

        private void ensureUninterpretedOptionIsMutable() {
            if (!this.uninterpretedOption_.isModifiable()) {
                this.uninterpretedOption_ = GeneratedMessageLite.mutableCopy(this.uninterpretedOption_);
            }
        }

        /* access modifiers changed from: private */
        public void setUninterpretedOption(int i, UninterpretedOption uninterpretedOption) {
            if (uninterpretedOption != null) {
                ensureUninterpretedOptionIsMutable();
                this.uninterpretedOption_.set(i, uninterpretedOption);
                return;
            }
            throw new NullPointerException();
        }

        /* access modifiers changed from: private */
        public void setUninterpretedOption(int i, UninterpretedOption.Builder builder) {
            ensureUninterpretedOptionIsMutable();
            this.uninterpretedOption_.set(i, (UninterpretedOption) builder.build());
        }

        /* access modifiers changed from: private */
        public void addUninterpretedOption(UninterpretedOption uninterpretedOption) {
            if (uninterpretedOption != null) {
                ensureUninterpretedOptionIsMutable();
                this.uninterpretedOption_.add(uninterpretedOption);
                return;
            }
            throw new NullPointerException();
        }

        /* access modifiers changed from: private */
        public void addUninterpretedOption(int i, UninterpretedOption uninterpretedOption) {
            if (uninterpretedOption != null) {
                ensureUninterpretedOptionIsMutable();
                this.uninterpretedOption_.add(i, uninterpretedOption);
                return;
            }
            throw new NullPointerException();
        }

        /* access modifiers changed from: private */
        public void addUninterpretedOption(UninterpretedOption.Builder builder) {
            ensureUninterpretedOptionIsMutable();
            this.uninterpretedOption_.add((UninterpretedOption) builder.build());
        }

        /* access modifiers changed from: private */
        public void addUninterpretedOption(int i, UninterpretedOption.Builder builder) {
            ensureUninterpretedOptionIsMutable();
            this.uninterpretedOption_.add(i, (UninterpretedOption) builder.build());
        }

        /* access modifiers changed from: private */
        public void addAllUninterpretedOption(Iterable<? extends UninterpretedOption> iterable) {
            ensureUninterpretedOptionIsMutable();
            AbstractMessageLite.addAll(iterable, this.uninterpretedOption_);
        }

        /* access modifiers changed from: private */
        public void clearUninterpretedOption() {
            this.uninterpretedOption_ = emptyProtobufList();
        }

        /* access modifiers changed from: private */
        public void removeUninterpretedOption(int i) {
            ensureUninterpretedOptionIsMutable();
            this.uninterpretedOption_.remove(i);
        }

        public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
            GeneratedMessageLite.ExtendableMessage<MessageType, BuilderType>.ExtensionWriter newExtensionWriter = newExtensionWriter();
            for (int i = 0; i < this.uninterpretedOption_.size(); i++) {
                codedOutputStream.writeMessage(999, (MessageLite) this.uninterpretedOption_.get(i));
            }
            newExtensionWriter.writeUntil(PropertyOptions.DELETE_EXISTING, codedOutputStream);
            this.unknownFields.writeTo(codedOutputStream);
        }

        public int getSerializedSize() {
            int i = this.memoizedSerializedSize;
            if (i != -1) {
                return i;
            }
            int i2 = 0;
            for (int i3 = 0; i3 < this.uninterpretedOption_.size(); i3++) {
                i2 += CodedOutputStream.computeMessageSize(999, (MessageLite) this.uninterpretedOption_.get(i3));
            }
            int extensionsSerializedSize = i2 + extensionsSerializedSize() + this.unknownFields.getSerializedSize();
            this.memoizedSerializedSize = extensionsSerializedSize;
            return extensionsSerializedSize;
        }

        public static OneofOptions parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return (OneofOptions) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
        }

        public static OneofOptions parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (OneofOptions) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
        }

        public static OneofOptions parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return (OneofOptions) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
        }

        public static OneofOptions parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (OneofOptions) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
        }

        public static OneofOptions parseFrom(InputStream inputStream) throws IOException {
            return (OneofOptions) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static OneofOptions parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (OneofOptions) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static OneofOptions parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (OneofOptions) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static OneofOptions parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (OneofOptions) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static OneofOptions parseFrom(CodedInputStream codedInputStream) throws IOException {
            return (OneofOptions) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
        }

        public static OneofOptions parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (OneofOptions) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
        }

        public static Builder newBuilder() {
            return (Builder) DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(OneofOptions oneofOptions) {
            return (Builder) ((Builder) DEFAULT_INSTANCE.toBuilder()).mergeFrom(oneofOptions);
        }

        /* compiled from: com.google.firebase:protolite-well-known-types@@16.0.1 */
        public static final class Builder extends GeneratedMessageLite.ExtendableBuilder<OneofOptions, Builder> implements OneofOptionsOrBuilder {
            private Builder() {
                super(OneofOptions.DEFAULT_INSTANCE);
            }

            public List<UninterpretedOption> getUninterpretedOptionList() {
                return Collections.unmodifiableList(((OneofOptions) this.instance).getUninterpretedOptionList());
            }

            public int getUninterpretedOptionCount() {
                return ((OneofOptions) this.instance).getUninterpretedOptionCount();
            }

            public UninterpretedOption getUninterpretedOption(int i) {
                return ((OneofOptions) this.instance).getUninterpretedOption(i);
            }

            public Builder setUninterpretedOption(int i, UninterpretedOption uninterpretedOption) {
                copyOnWrite();
                ((OneofOptions) this.instance).setUninterpretedOption(i, uninterpretedOption);
                return this;
            }

            public Builder setUninterpretedOption(int i, UninterpretedOption.Builder builder) {
                copyOnWrite();
                ((OneofOptions) this.instance).setUninterpretedOption(i, builder);
                return this;
            }

            public Builder addUninterpretedOption(UninterpretedOption uninterpretedOption) {
                copyOnWrite();
                ((OneofOptions) this.instance).addUninterpretedOption(uninterpretedOption);
                return this;
            }

            public Builder addUninterpretedOption(int i, UninterpretedOption uninterpretedOption) {
                copyOnWrite();
                ((OneofOptions) this.instance).addUninterpretedOption(i, uninterpretedOption);
                return this;
            }

            public Builder addUninterpretedOption(UninterpretedOption.Builder builder) {
                copyOnWrite();
                ((OneofOptions) this.instance).addUninterpretedOption(builder);
                return this;
            }

            public Builder addUninterpretedOption(int i, UninterpretedOption.Builder builder) {
                copyOnWrite();
                ((OneofOptions) this.instance).addUninterpretedOption(i, builder);
                return this;
            }

            public Builder addAllUninterpretedOption(Iterable<? extends UninterpretedOption> iterable) {
                copyOnWrite();
                ((OneofOptions) this.instance).addAllUninterpretedOption(iterable);
                return this;
            }

            public Builder clearUninterpretedOption() {
                copyOnWrite();
                ((OneofOptions) this.instance).clearUninterpretedOption();
                return this;
            }

            public Builder removeUninterpretedOption(int i) {
                copyOnWrite();
                ((OneofOptions) this.instance).removeUninterpretedOption(i);
                return this;
            }
        }

        /* access modifiers changed from: protected */
        public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            boolean z = false;
            switch (methodToInvoke) {
                case NEW_MUTABLE_INSTANCE:
                    return new OneofOptions();
                case IS_INITIALIZED:
                    byte b = this.memoizedIsInitialized;
                    if (b == 1) {
                        return DEFAULT_INSTANCE;
                    }
                    if (b == 0) {
                        return null;
                    }
                    boolean booleanValue = ((Boolean) obj).booleanValue();
                    for (int i = 0; i < getUninterpretedOptionCount(); i++) {
                        if (!getUninterpretedOption(i).isInitialized()) {
                            if (booleanValue) {
                                this.memoizedIsInitialized = 0;
                            }
                            return null;
                        }
                    }
                    if (!extensionsAreInitialized()) {
                        if (booleanValue) {
                            this.memoizedIsInitialized = 0;
                        }
                        return null;
                    }
                    if (booleanValue) {
                        this.memoizedIsInitialized = 1;
                    }
                    return DEFAULT_INSTANCE;
                case MAKE_IMMUTABLE:
                    this.uninterpretedOption_.makeImmutable();
                    return null;
                case NEW_BUILDER:
                    return new Builder();
                case VISIT:
                    this.uninterpretedOption_ = ((GeneratedMessageLite.Visitor) obj).visitList(this.uninterpretedOption_, ((OneofOptions) obj2).uninterpretedOption_);
                    GeneratedMessageLite.MergeFromVisitor mergeFromVisitor = GeneratedMessageLite.MergeFromVisitor.INSTANCE;
                    return this;
                case MERGE_FROM_STREAM:
                    CodedInputStream codedInputStream = (CodedInputStream) obj;
                    ExtensionRegistryLite extensionRegistryLite = (ExtensionRegistryLite) obj2;
                    while (!z) {
                        try {
                            int readTag = codedInputStream.readTag();
                            if (readTag != 0) {
                                if (readTag == 7994) {
                                    if (!this.uninterpretedOption_.isModifiable()) {
                                        this.uninterpretedOption_ = GeneratedMessageLite.mutableCopy(this.uninterpretedOption_);
                                    }
                                    this.uninterpretedOption_.add((UninterpretedOption) codedInputStream.readMessage(UninterpretedOption.parser(), extensionRegistryLite));
                                } else if (!parseUnknownField((OneofOptions) getDefaultInstanceForType(), codedInputStream, extensionRegistryLite, readTag)) {
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
                        synchronized (OneofOptions.class) {
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

        public static OneofOptions getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<OneofOptions> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }
    }

    /* compiled from: com.google.firebase:protolite-well-known-types@@16.0.1 */
    public static final class EnumOptions extends GeneratedMessageLite.ExtendableMessage<EnumOptions, Builder> implements EnumOptionsOrBuilder {
        public static final int ALLOW_ALIAS_FIELD_NUMBER = 2;
        /* access modifiers changed from: private */
        public static final EnumOptions DEFAULT_INSTANCE = new EnumOptions();
        public static final int DEPRECATED_FIELD_NUMBER = 3;
        private static volatile Parser<EnumOptions> PARSER = null;
        public static final int UNINTERPRETED_OPTION_FIELD_NUMBER = 999;
        private boolean allowAlias_;
        private int bitField0_;
        private boolean deprecated_;
        private byte memoizedIsInitialized = -1;
        private Internal.ProtobufList<UninterpretedOption> uninterpretedOption_ = emptyProtobufList();

        private EnumOptions() {
        }

        public boolean hasAllowAlias() {
            return (this.bitField0_ & 1) == 1;
        }

        public boolean getAllowAlias() {
            return this.allowAlias_;
        }

        /* access modifiers changed from: private */
        public void setAllowAlias(boolean z) {
            this.bitField0_ |= 1;
            this.allowAlias_ = z;
        }

        /* access modifiers changed from: private */
        public void clearAllowAlias() {
            this.bitField0_ &= -2;
            this.allowAlias_ = false;
        }

        public boolean hasDeprecated() {
            return (this.bitField0_ & 2) == 2;
        }

        public boolean getDeprecated() {
            return this.deprecated_;
        }

        /* access modifiers changed from: private */
        public void setDeprecated(boolean z) {
            this.bitField0_ |= 2;
            this.deprecated_ = z;
        }

        /* access modifiers changed from: private */
        public void clearDeprecated() {
            this.bitField0_ &= -3;
            this.deprecated_ = false;
        }

        public List<UninterpretedOption> getUninterpretedOptionList() {
            return this.uninterpretedOption_;
        }

        public List<? extends UninterpretedOptionOrBuilder> getUninterpretedOptionOrBuilderList() {
            return this.uninterpretedOption_;
        }

        public int getUninterpretedOptionCount() {
            return this.uninterpretedOption_.size();
        }

        public UninterpretedOption getUninterpretedOption(int i) {
            return (UninterpretedOption) this.uninterpretedOption_.get(i);
        }

        public UninterpretedOptionOrBuilder getUninterpretedOptionOrBuilder(int i) {
            return (UninterpretedOptionOrBuilder) this.uninterpretedOption_.get(i);
        }

        private void ensureUninterpretedOptionIsMutable() {
            if (!this.uninterpretedOption_.isModifiable()) {
                this.uninterpretedOption_ = GeneratedMessageLite.mutableCopy(this.uninterpretedOption_);
            }
        }

        /* access modifiers changed from: private */
        public void setUninterpretedOption(int i, UninterpretedOption uninterpretedOption) {
            if (uninterpretedOption != null) {
                ensureUninterpretedOptionIsMutable();
                this.uninterpretedOption_.set(i, uninterpretedOption);
                return;
            }
            throw new NullPointerException();
        }

        /* access modifiers changed from: private */
        public void setUninterpretedOption(int i, UninterpretedOption.Builder builder) {
            ensureUninterpretedOptionIsMutable();
            this.uninterpretedOption_.set(i, (UninterpretedOption) builder.build());
        }

        /* access modifiers changed from: private */
        public void addUninterpretedOption(UninterpretedOption uninterpretedOption) {
            if (uninterpretedOption != null) {
                ensureUninterpretedOptionIsMutable();
                this.uninterpretedOption_.add(uninterpretedOption);
                return;
            }
            throw new NullPointerException();
        }

        /* access modifiers changed from: private */
        public void addUninterpretedOption(int i, UninterpretedOption uninterpretedOption) {
            if (uninterpretedOption != null) {
                ensureUninterpretedOptionIsMutable();
                this.uninterpretedOption_.add(i, uninterpretedOption);
                return;
            }
            throw new NullPointerException();
        }

        /* access modifiers changed from: private */
        public void addUninterpretedOption(UninterpretedOption.Builder builder) {
            ensureUninterpretedOptionIsMutable();
            this.uninterpretedOption_.add((UninterpretedOption) builder.build());
        }

        /* access modifiers changed from: private */
        public void addUninterpretedOption(int i, UninterpretedOption.Builder builder) {
            ensureUninterpretedOptionIsMutable();
            this.uninterpretedOption_.add(i, (UninterpretedOption) builder.build());
        }

        /* access modifiers changed from: private */
        public void addAllUninterpretedOption(Iterable<? extends UninterpretedOption> iterable) {
            ensureUninterpretedOptionIsMutable();
            AbstractMessageLite.addAll(iterable, this.uninterpretedOption_);
        }

        /* access modifiers changed from: private */
        public void clearUninterpretedOption() {
            this.uninterpretedOption_ = emptyProtobufList();
        }

        /* access modifiers changed from: private */
        public void removeUninterpretedOption(int i) {
            ensureUninterpretedOptionIsMutable();
            this.uninterpretedOption_.remove(i);
        }

        public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
            GeneratedMessageLite.ExtendableMessage<MessageType, BuilderType>.ExtensionWriter newExtensionWriter = newExtensionWriter();
            if ((this.bitField0_ & 1) == 1) {
                codedOutputStream.writeBool(2, this.allowAlias_);
            }
            if ((this.bitField0_ & 2) == 2) {
                codedOutputStream.writeBool(3, this.deprecated_);
            }
            for (int i = 0; i < this.uninterpretedOption_.size(); i++) {
                codedOutputStream.writeMessage(999, (MessageLite) this.uninterpretedOption_.get(i));
            }
            newExtensionWriter.writeUntil(PropertyOptions.DELETE_EXISTING, codedOutputStream);
            this.unknownFields.writeTo(codedOutputStream);
        }

        public int getSerializedSize() {
            int i = this.memoizedSerializedSize;
            if (i != -1) {
                return i;
            }
            int computeBoolSize = (this.bitField0_ & 1) == 1 ? CodedOutputStream.computeBoolSize(2, this.allowAlias_) + 0 : 0;
            if ((this.bitField0_ & 2) == 2) {
                computeBoolSize += CodedOutputStream.computeBoolSize(3, this.deprecated_);
            }
            for (int i2 = 0; i2 < this.uninterpretedOption_.size(); i2++) {
                computeBoolSize += CodedOutputStream.computeMessageSize(999, (MessageLite) this.uninterpretedOption_.get(i2));
            }
            int extensionsSerializedSize = computeBoolSize + extensionsSerializedSize() + this.unknownFields.getSerializedSize();
            this.memoizedSerializedSize = extensionsSerializedSize;
            return extensionsSerializedSize;
        }

        public static EnumOptions parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return (EnumOptions) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
        }

        public static EnumOptions parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (EnumOptions) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
        }

        public static EnumOptions parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return (EnumOptions) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
        }

        public static EnumOptions parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (EnumOptions) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
        }

        public static EnumOptions parseFrom(InputStream inputStream) throws IOException {
            return (EnumOptions) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static EnumOptions parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (EnumOptions) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static EnumOptions parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (EnumOptions) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static EnumOptions parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (EnumOptions) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static EnumOptions parseFrom(CodedInputStream codedInputStream) throws IOException {
            return (EnumOptions) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
        }

        public static EnumOptions parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (EnumOptions) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
        }

        public static Builder newBuilder() {
            return (Builder) DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(EnumOptions enumOptions) {
            return (Builder) ((Builder) DEFAULT_INSTANCE.toBuilder()).mergeFrom(enumOptions);
        }

        /* compiled from: com.google.firebase:protolite-well-known-types@@16.0.1 */
        public static final class Builder extends GeneratedMessageLite.ExtendableBuilder<EnumOptions, Builder> implements EnumOptionsOrBuilder {
            private Builder() {
                super(EnumOptions.DEFAULT_INSTANCE);
            }

            public boolean hasAllowAlias() {
                return ((EnumOptions) this.instance).hasAllowAlias();
            }

            public boolean getAllowAlias() {
                return ((EnumOptions) this.instance).getAllowAlias();
            }

            public Builder setAllowAlias(boolean z) {
                copyOnWrite();
                ((EnumOptions) this.instance).setAllowAlias(z);
                return this;
            }

            public Builder clearAllowAlias() {
                copyOnWrite();
                ((EnumOptions) this.instance).clearAllowAlias();
                return this;
            }

            public boolean hasDeprecated() {
                return ((EnumOptions) this.instance).hasDeprecated();
            }

            public boolean getDeprecated() {
                return ((EnumOptions) this.instance).getDeprecated();
            }

            public Builder setDeprecated(boolean z) {
                copyOnWrite();
                ((EnumOptions) this.instance).setDeprecated(z);
                return this;
            }

            public Builder clearDeprecated() {
                copyOnWrite();
                ((EnumOptions) this.instance).clearDeprecated();
                return this;
            }

            public List<UninterpretedOption> getUninterpretedOptionList() {
                return Collections.unmodifiableList(((EnumOptions) this.instance).getUninterpretedOptionList());
            }

            public int getUninterpretedOptionCount() {
                return ((EnumOptions) this.instance).getUninterpretedOptionCount();
            }

            public UninterpretedOption getUninterpretedOption(int i) {
                return ((EnumOptions) this.instance).getUninterpretedOption(i);
            }

            public Builder setUninterpretedOption(int i, UninterpretedOption uninterpretedOption) {
                copyOnWrite();
                ((EnumOptions) this.instance).setUninterpretedOption(i, uninterpretedOption);
                return this;
            }

            public Builder setUninterpretedOption(int i, UninterpretedOption.Builder builder) {
                copyOnWrite();
                ((EnumOptions) this.instance).setUninterpretedOption(i, builder);
                return this;
            }

            public Builder addUninterpretedOption(UninterpretedOption uninterpretedOption) {
                copyOnWrite();
                ((EnumOptions) this.instance).addUninterpretedOption(uninterpretedOption);
                return this;
            }

            public Builder addUninterpretedOption(int i, UninterpretedOption uninterpretedOption) {
                copyOnWrite();
                ((EnumOptions) this.instance).addUninterpretedOption(i, uninterpretedOption);
                return this;
            }

            public Builder addUninterpretedOption(UninterpretedOption.Builder builder) {
                copyOnWrite();
                ((EnumOptions) this.instance).addUninterpretedOption(builder);
                return this;
            }

            public Builder addUninterpretedOption(int i, UninterpretedOption.Builder builder) {
                copyOnWrite();
                ((EnumOptions) this.instance).addUninterpretedOption(i, builder);
                return this;
            }

            public Builder addAllUninterpretedOption(Iterable<? extends UninterpretedOption> iterable) {
                copyOnWrite();
                ((EnumOptions) this.instance).addAllUninterpretedOption(iterable);
                return this;
            }

            public Builder clearUninterpretedOption() {
                copyOnWrite();
                ((EnumOptions) this.instance).clearUninterpretedOption();
                return this;
            }

            public Builder removeUninterpretedOption(int i) {
                copyOnWrite();
                ((EnumOptions) this.instance).removeUninterpretedOption(i);
                return this;
            }
        }

        /* access modifiers changed from: protected */
        public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            boolean z = false;
            switch (methodToInvoke) {
                case NEW_MUTABLE_INSTANCE:
                    return new EnumOptions();
                case IS_INITIALIZED:
                    byte b = this.memoizedIsInitialized;
                    if (b == 1) {
                        return DEFAULT_INSTANCE;
                    }
                    if (b == 0) {
                        return null;
                    }
                    boolean booleanValue = ((Boolean) obj).booleanValue();
                    for (int i = 0; i < getUninterpretedOptionCount(); i++) {
                        if (!getUninterpretedOption(i).isInitialized()) {
                            if (booleanValue) {
                                this.memoizedIsInitialized = 0;
                            }
                            return null;
                        }
                    }
                    if (!extensionsAreInitialized()) {
                        if (booleanValue) {
                            this.memoizedIsInitialized = 0;
                        }
                        return null;
                    }
                    if (booleanValue) {
                        this.memoizedIsInitialized = 1;
                    }
                    return DEFAULT_INSTANCE;
                case MAKE_IMMUTABLE:
                    this.uninterpretedOption_.makeImmutable();
                    return null;
                case NEW_BUILDER:
                    return new Builder();
                case VISIT:
                    GeneratedMessageLite.Visitor visitor = (GeneratedMessageLite.Visitor) obj;
                    EnumOptions enumOptions = (EnumOptions) obj2;
                    this.allowAlias_ = visitor.visitBoolean(hasAllowAlias(), this.allowAlias_, enumOptions.hasAllowAlias(), enumOptions.allowAlias_);
                    this.deprecated_ = visitor.visitBoolean(hasDeprecated(), this.deprecated_, enumOptions.hasDeprecated(), enumOptions.deprecated_);
                    this.uninterpretedOption_ = visitor.visitList(this.uninterpretedOption_, enumOptions.uninterpretedOption_);
                    if (visitor == GeneratedMessageLite.MergeFromVisitor.INSTANCE) {
                        this.bitField0_ |= enumOptions.bitField0_;
                    }
                    return this;
                case MERGE_FROM_STREAM:
                    CodedInputStream codedInputStream = (CodedInputStream) obj;
                    ExtensionRegistryLite extensionRegistryLite = (ExtensionRegistryLite) obj2;
                    while (!z) {
                        try {
                            int readTag = codedInputStream.readTag();
                            if (readTag != 0) {
                                if (readTag == 16) {
                                    this.bitField0_ |= 1;
                                    this.allowAlias_ = codedInputStream.readBool();
                                } else if (readTag == 24) {
                                    this.bitField0_ |= 2;
                                    this.deprecated_ = codedInputStream.readBool();
                                } else if (readTag == 7994) {
                                    if (!this.uninterpretedOption_.isModifiable()) {
                                        this.uninterpretedOption_ = GeneratedMessageLite.mutableCopy(this.uninterpretedOption_);
                                    }
                                    this.uninterpretedOption_.add((UninterpretedOption) codedInputStream.readMessage(UninterpretedOption.parser(), extensionRegistryLite));
                                } else if (!parseUnknownField((EnumOptions) getDefaultInstanceForType(), codedInputStream, extensionRegistryLite, readTag)) {
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
                        synchronized (EnumOptions.class) {
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

        public static EnumOptions getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<EnumOptions> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }
    }

    /* compiled from: com.google.firebase:protolite-well-known-types@@16.0.1 */
    public static final class EnumValueOptions extends GeneratedMessageLite.ExtendableMessage<EnumValueOptions, Builder> implements EnumValueOptionsOrBuilder {
        /* access modifiers changed from: private */
        public static final EnumValueOptions DEFAULT_INSTANCE = new EnumValueOptions();
        public static final int DEPRECATED_FIELD_NUMBER = 1;
        private static volatile Parser<EnumValueOptions> PARSER = null;
        public static final int UNINTERPRETED_OPTION_FIELD_NUMBER = 999;
        private int bitField0_;
        private boolean deprecated_;
        private byte memoizedIsInitialized = -1;
        private Internal.ProtobufList<UninterpretedOption> uninterpretedOption_ = emptyProtobufList();

        private EnumValueOptions() {
        }

        public boolean hasDeprecated() {
            return (this.bitField0_ & 1) == 1;
        }

        public boolean getDeprecated() {
            return this.deprecated_;
        }

        /* access modifiers changed from: private */
        public void setDeprecated(boolean z) {
            this.bitField0_ |= 1;
            this.deprecated_ = z;
        }

        /* access modifiers changed from: private */
        public void clearDeprecated() {
            this.bitField0_ &= -2;
            this.deprecated_ = false;
        }

        public List<UninterpretedOption> getUninterpretedOptionList() {
            return this.uninterpretedOption_;
        }

        public List<? extends UninterpretedOptionOrBuilder> getUninterpretedOptionOrBuilderList() {
            return this.uninterpretedOption_;
        }

        public int getUninterpretedOptionCount() {
            return this.uninterpretedOption_.size();
        }

        public UninterpretedOption getUninterpretedOption(int i) {
            return (UninterpretedOption) this.uninterpretedOption_.get(i);
        }

        public UninterpretedOptionOrBuilder getUninterpretedOptionOrBuilder(int i) {
            return (UninterpretedOptionOrBuilder) this.uninterpretedOption_.get(i);
        }

        private void ensureUninterpretedOptionIsMutable() {
            if (!this.uninterpretedOption_.isModifiable()) {
                this.uninterpretedOption_ = GeneratedMessageLite.mutableCopy(this.uninterpretedOption_);
            }
        }

        /* access modifiers changed from: private */
        public void setUninterpretedOption(int i, UninterpretedOption uninterpretedOption) {
            if (uninterpretedOption != null) {
                ensureUninterpretedOptionIsMutable();
                this.uninterpretedOption_.set(i, uninterpretedOption);
                return;
            }
            throw new NullPointerException();
        }

        /* access modifiers changed from: private */
        public void setUninterpretedOption(int i, UninterpretedOption.Builder builder) {
            ensureUninterpretedOptionIsMutable();
            this.uninterpretedOption_.set(i, (UninterpretedOption) builder.build());
        }

        /* access modifiers changed from: private */
        public void addUninterpretedOption(UninterpretedOption uninterpretedOption) {
            if (uninterpretedOption != null) {
                ensureUninterpretedOptionIsMutable();
                this.uninterpretedOption_.add(uninterpretedOption);
                return;
            }
            throw new NullPointerException();
        }

        /* access modifiers changed from: private */
        public void addUninterpretedOption(int i, UninterpretedOption uninterpretedOption) {
            if (uninterpretedOption != null) {
                ensureUninterpretedOptionIsMutable();
                this.uninterpretedOption_.add(i, uninterpretedOption);
                return;
            }
            throw new NullPointerException();
        }

        /* access modifiers changed from: private */
        public void addUninterpretedOption(UninterpretedOption.Builder builder) {
            ensureUninterpretedOptionIsMutable();
            this.uninterpretedOption_.add((UninterpretedOption) builder.build());
        }

        /* access modifiers changed from: private */
        public void addUninterpretedOption(int i, UninterpretedOption.Builder builder) {
            ensureUninterpretedOptionIsMutable();
            this.uninterpretedOption_.add(i, (UninterpretedOption) builder.build());
        }

        /* access modifiers changed from: private */
        public void addAllUninterpretedOption(Iterable<? extends UninterpretedOption> iterable) {
            ensureUninterpretedOptionIsMutable();
            AbstractMessageLite.addAll(iterable, this.uninterpretedOption_);
        }

        /* access modifiers changed from: private */
        public void clearUninterpretedOption() {
            this.uninterpretedOption_ = emptyProtobufList();
        }

        /* access modifiers changed from: private */
        public void removeUninterpretedOption(int i) {
            ensureUninterpretedOptionIsMutable();
            this.uninterpretedOption_.remove(i);
        }

        public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
            GeneratedMessageLite.ExtendableMessage<MessageType, BuilderType>.ExtensionWriter newExtensionWriter = newExtensionWriter();
            if ((this.bitField0_ & 1) == 1) {
                codedOutputStream.writeBool(1, this.deprecated_);
            }
            for (int i = 0; i < this.uninterpretedOption_.size(); i++) {
                codedOutputStream.writeMessage(999, (MessageLite) this.uninterpretedOption_.get(i));
            }
            newExtensionWriter.writeUntil(PropertyOptions.DELETE_EXISTING, codedOutputStream);
            this.unknownFields.writeTo(codedOutputStream);
        }

        public int getSerializedSize() {
            int i = this.memoizedSerializedSize;
            if (i != -1) {
                return i;
            }
            int computeBoolSize = (this.bitField0_ & 1) == 1 ? CodedOutputStream.computeBoolSize(1, this.deprecated_) + 0 : 0;
            for (int i2 = 0; i2 < this.uninterpretedOption_.size(); i2++) {
                computeBoolSize += CodedOutputStream.computeMessageSize(999, (MessageLite) this.uninterpretedOption_.get(i2));
            }
            int extensionsSerializedSize = computeBoolSize + extensionsSerializedSize() + this.unknownFields.getSerializedSize();
            this.memoizedSerializedSize = extensionsSerializedSize;
            return extensionsSerializedSize;
        }

        public static EnumValueOptions parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return (EnumValueOptions) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
        }

        public static EnumValueOptions parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (EnumValueOptions) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
        }

        public static EnumValueOptions parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return (EnumValueOptions) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
        }

        public static EnumValueOptions parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (EnumValueOptions) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
        }

        public static EnumValueOptions parseFrom(InputStream inputStream) throws IOException {
            return (EnumValueOptions) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static EnumValueOptions parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (EnumValueOptions) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static EnumValueOptions parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (EnumValueOptions) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static EnumValueOptions parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (EnumValueOptions) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static EnumValueOptions parseFrom(CodedInputStream codedInputStream) throws IOException {
            return (EnumValueOptions) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
        }

        public static EnumValueOptions parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (EnumValueOptions) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
        }

        public static Builder newBuilder() {
            return (Builder) DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(EnumValueOptions enumValueOptions) {
            return (Builder) ((Builder) DEFAULT_INSTANCE.toBuilder()).mergeFrom(enumValueOptions);
        }

        /* compiled from: com.google.firebase:protolite-well-known-types@@16.0.1 */
        public static final class Builder extends GeneratedMessageLite.ExtendableBuilder<EnumValueOptions, Builder> implements EnumValueOptionsOrBuilder {
            private Builder() {
                super(EnumValueOptions.DEFAULT_INSTANCE);
            }

            public boolean hasDeprecated() {
                return ((EnumValueOptions) this.instance).hasDeprecated();
            }

            public boolean getDeprecated() {
                return ((EnumValueOptions) this.instance).getDeprecated();
            }

            public Builder setDeprecated(boolean z) {
                copyOnWrite();
                ((EnumValueOptions) this.instance).setDeprecated(z);
                return this;
            }

            public Builder clearDeprecated() {
                copyOnWrite();
                ((EnumValueOptions) this.instance).clearDeprecated();
                return this;
            }

            public List<UninterpretedOption> getUninterpretedOptionList() {
                return Collections.unmodifiableList(((EnumValueOptions) this.instance).getUninterpretedOptionList());
            }

            public int getUninterpretedOptionCount() {
                return ((EnumValueOptions) this.instance).getUninterpretedOptionCount();
            }

            public UninterpretedOption getUninterpretedOption(int i) {
                return ((EnumValueOptions) this.instance).getUninterpretedOption(i);
            }

            public Builder setUninterpretedOption(int i, UninterpretedOption uninterpretedOption) {
                copyOnWrite();
                ((EnumValueOptions) this.instance).setUninterpretedOption(i, uninterpretedOption);
                return this;
            }

            public Builder setUninterpretedOption(int i, UninterpretedOption.Builder builder) {
                copyOnWrite();
                ((EnumValueOptions) this.instance).setUninterpretedOption(i, builder);
                return this;
            }

            public Builder addUninterpretedOption(UninterpretedOption uninterpretedOption) {
                copyOnWrite();
                ((EnumValueOptions) this.instance).addUninterpretedOption(uninterpretedOption);
                return this;
            }

            public Builder addUninterpretedOption(int i, UninterpretedOption uninterpretedOption) {
                copyOnWrite();
                ((EnumValueOptions) this.instance).addUninterpretedOption(i, uninterpretedOption);
                return this;
            }

            public Builder addUninterpretedOption(UninterpretedOption.Builder builder) {
                copyOnWrite();
                ((EnumValueOptions) this.instance).addUninterpretedOption(builder);
                return this;
            }

            public Builder addUninterpretedOption(int i, UninterpretedOption.Builder builder) {
                copyOnWrite();
                ((EnumValueOptions) this.instance).addUninterpretedOption(i, builder);
                return this;
            }

            public Builder addAllUninterpretedOption(Iterable<? extends UninterpretedOption> iterable) {
                copyOnWrite();
                ((EnumValueOptions) this.instance).addAllUninterpretedOption(iterable);
                return this;
            }

            public Builder clearUninterpretedOption() {
                copyOnWrite();
                ((EnumValueOptions) this.instance).clearUninterpretedOption();
                return this;
            }

            public Builder removeUninterpretedOption(int i) {
                copyOnWrite();
                ((EnumValueOptions) this.instance).removeUninterpretedOption(i);
                return this;
            }
        }

        /* access modifiers changed from: protected */
        public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            boolean z = false;
            switch (methodToInvoke) {
                case NEW_MUTABLE_INSTANCE:
                    return new EnumValueOptions();
                case IS_INITIALIZED:
                    byte b = this.memoizedIsInitialized;
                    if (b == 1) {
                        return DEFAULT_INSTANCE;
                    }
                    if (b == 0) {
                        return null;
                    }
                    boolean booleanValue = ((Boolean) obj).booleanValue();
                    for (int i = 0; i < getUninterpretedOptionCount(); i++) {
                        if (!getUninterpretedOption(i).isInitialized()) {
                            if (booleanValue) {
                                this.memoizedIsInitialized = 0;
                            }
                            return null;
                        }
                    }
                    if (!extensionsAreInitialized()) {
                        if (booleanValue) {
                            this.memoizedIsInitialized = 0;
                        }
                        return null;
                    }
                    if (booleanValue) {
                        this.memoizedIsInitialized = 1;
                    }
                    return DEFAULT_INSTANCE;
                case MAKE_IMMUTABLE:
                    this.uninterpretedOption_.makeImmutable();
                    return null;
                case NEW_BUILDER:
                    return new Builder();
                case VISIT:
                    GeneratedMessageLite.Visitor visitor = (GeneratedMessageLite.Visitor) obj;
                    EnumValueOptions enumValueOptions = (EnumValueOptions) obj2;
                    this.deprecated_ = visitor.visitBoolean(hasDeprecated(), this.deprecated_, enumValueOptions.hasDeprecated(), enumValueOptions.deprecated_);
                    this.uninterpretedOption_ = visitor.visitList(this.uninterpretedOption_, enumValueOptions.uninterpretedOption_);
                    if (visitor == GeneratedMessageLite.MergeFromVisitor.INSTANCE) {
                        this.bitField0_ |= enumValueOptions.bitField0_;
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
                                    this.bitField0_ |= 1;
                                    this.deprecated_ = codedInputStream.readBool();
                                } else if (readTag == 7994) {
                                    if (!this.uninterpretedOption_.isModifiable()) {
                                        this.uninterpretedOption_ = GeneratedMessageLite.mutableCopy(this.uninterpretedOption_);
                                    }
                                    this.uninterpretedOption_.add((UninterpretedOption) codedInputStream.readMessage(UninterpretedOption.parser(), extensionRegistryLite));
                                } else if (!parseUnknownField((EnumValueOptions) getDefaultInstanceForType(), codedInputStream, extensionRegistryLite, readTag)) {
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
                        synchronized (EnumValueOptions.class) {
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

        public static EnumValueOptions getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<EnumValueOptions> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }
    }

    /* compiled from: com.google.firebase:protolite-well-known-types@@16.0.1 */
    public static final class ServiceOptions extends GeneratedMessageLite.ExtendableMessage<ServiceOptions, Builder> implements ServiceOptionsOrBuilder {
        /* access modifiers changed from: private */
        public static final ServiceOptions DEFAULT_INSTANCE = new ServiceOptions();
        public static final int DEPRECATED_FIELD_NUMBER = 33;
        private static volatile Parser<ServiceOptions> PARSER = null;
        public static final int UNINTERPRETED_OPTION_FIELD_NUMBER = 999;
        private int bitField0_;
        private boolean deprecated_;
        private byte memoizedIsInitialized = -1;
        private Internal.ProtobufList<UninterpretedOption> uninterpretedOption_ = emptyProtobufList();

        private ServiceOptions() {
        }

        public boolean hasDeprecated() {
            return (this.bitField0_ & 1) == 1;
        }

        public boolean getDeprecated() {
            return this.deprecated_;
        }

        /* access modifiers changed from: private */
        public void setDeprecated(boolean z) {
            this.bitField0_ |= 1;
            this.deprecated_ = z;
        }

        /* access modifiers changed from: private */
        public void clearDeprecated() {
            this.bitField0_ &= -2;
            this.deprecated_ = false;
        }

        public List<UninterpretedOption> getUninterpretedOptionList() {
            return this.uninterpretedOption_;
        }

        public List<? extends UninterpretedOptionOrBuilder> getUninterpretedOptionOrBuilderList() {
            return this.uninterpretedOption_;
        }

        public int getUninterpretedOptionCount() {
            return this.uninterpretedOption_.size();
        }

        public UninterpretedOption getUninterpretedOption(int i) {
            return (UninterpretedOption) this.uninterpretedOption_.get(i);
        }

        public UninterpretedOptionOrBuilder getUninterpretedOptionOrBuilder(int i) {
            return (UninterpretedOptionOrBuilder) this.uninterpretedOption_.get(i);
        }

        private void ensureUninterpretedOptionIsMutable() {
            if (!this.uninterpretedOption_.isModifiable()) {
                this.uninterpretedOption_ = GeneratedMessageLite.mutableCopy(this.uninterpretedOption_);
            }
        }

        /* access modifiers changed from: private */
        public void setUninterpretedOption(int i, UninterpretedOption uninterpretedOption) {
            if (uninterpretedOption != null) {
                ensureUninterpretedOptionIsMutable();
                this.uninterpretedOption_.set(i, uninterpretedOption);
                return;
            }
            throw new NullPointerException();
        }

        /* access modifiers changed from: private */
        public void setUninterpretedOption(int i, UninterpretedOption.Builder builder) {
            ensureUninterpretedOptionIsMutable();
            this.uninterpretedOption_.set(i, (UninterpretedOption) builder.build());
        }

        /* access modifiers changed from: private */
        public void addUninterpretedOption(UninterpretedOption uninterpretedOption) {
            if (uninterpretedOption != null) {
                ensureUninterpretedOptionIsMutable();
                this.uninterpretedOption_.add(uninterpretedOption);
                return;
            }
            throw new NullPointerException();
        }

        /* access modifiers changed from: private */
        public void addUninterpretedOption(int i, UninterpretedOption uninterpretedOption) {
            if (uninterpretedOption != null) {
                ensureUninterpretedOptionIsMutable();
                this.uninterpretedOption_.add(i, uninterpretedOption);
                return;
            }
            throw new NullPointerException();
        }

        /* access modifiers changed from: private */
        public void addUninterpretedOption(UninterpretedOption.Builder builder) {
            ensureUninterpretedOptionIsMutable();
            this.uninterpretedOption_.add((UninterpretedOption) builder.build());
        }

        /* access modifiers changed from: private */
        public void addUninterpretedOption(int i, UninterpretedOption.Builder builder) {
            ensureUninterpretedOptionIsMutable();
            this.uninterpretedOption_.add(i, (UninterpretedOption) builder.build());
        }

        /* access modifiers changed from: private */
        public void addAllUninterpretedOption(Iterable<? extends UninterpretedOption> iterable) {
            ensureUninterpretedOptionIsMutable();
            AbstractMessageLite.addAll(iterable, this.uninterpretedOption_);
        }

        /* access modifiers changed from: private */
        public void clearUninterpretedOption() {
            this.uninterpretedOption_ = emptyProtobufList();
        }

        /* access modifiers changed from: private */
        public void removeUninterpretedOption(int i) {
            ensureUninterpretedOptionIsMutable();
            this.uninterpretedOption_.remove(i);
        }

        public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
            GeneratedMessageLite.ExtendableMessage<MessageType, BuilderType>.ExtensionWriter newExtensionWriter = newExtensionWriter();
            if ((this.bitField0_ & 1) == 1) {
                codedOutputStream.writeBool(33, this.deprecated_);
            }
            for (int i = 0; i < this.uninterpretedOption_.size(); i++) {
                codedOutputStream.writeMessage(999, (MessageLite) this.uninterpretedOption_.get(i));
            }
            newExtensionWriter.writeUntil(PropertyOptions.DELETE_EXISTING, codedOutputStream);
            this.unknownFields.writeTo(codedOutputStream);
        }

        public int getSerializedSize() {
            int i = this.memoizedSerializedSize;
            if (i != -1) {
                return i;
            }
            int computeBoolSize = (this.bitField0_ & 1) == 1 ? CodedOutputStream.computeBoolSize(33, this.deprecated_) + 0 : 0;
            for (int i2 = 0; i2 < this.uninterpretedOption_.size(); i2++) {
                computeBoolSize += CodedOutputStream.computeMessageSize(999, (MessageLite) this.uninterpretedOption_.get(i2));
            }
            int extensionsSerializedSize = computeBoolSize + extensionsSerializedSize() + this.unknownFields.getSerializedSize();
            this.memoizedSerializedSize = extensionsSerializedSize;
            return extensionsSerializedSize;
        }

        public static ServiceOptions parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return (ServiceOptions) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
        }

        public static ServiceOptions parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (ServiceOptions) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
        }

        public static ServiceOptions parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return (ServiceOptions) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
        }

        public static ServiceOptions parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (ServiceOptions) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
        }

        public static ServiceOptions parseFrom(InputStream inputStream) throws IOException {
            return (ServiceOptions) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static ServiceOptions parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (ServiceOptions) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static ServiceOptions parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (ServiceOptions) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static ServiceOptions parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (ServiceOptions) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static ServiceOptions parseFrom(CodedInputStream codedInputStream) throws IOException {
            return (ServiceOptions) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
        }

        public static ServiceOptions parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (ServiceOptions) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
        }

        public static Builder newBuilder() {
            return (Builder) DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(ServiceOptions serviceOptions) {
            return (Builder) ((Builder) DEFAULT_INSTANCE.toBuilder()).mergeFrom(serviceOptions);
        }

        /* compiled from: com.google.firebase:protolite-well-known-types@@16.0.1 */
        public static final class Builder extends GeneratedMessageLite.ExtendableBuilder<ServiceOptions, Builder> implements ServiceOptionsOrBuilder {
            private Builder() {
                super(ServiceOptions.DEFAULT_INSTANCE);
            }

            public boolean hasDeprecated() {
                return ((ServiceOptions) this.instance).hasDeprecated();
            }

            public boolean getDeprecated() {
                return ((ServiceOptions) this.instance).getDeprecated();
            }

            public Builder setDeprecated(boolean z) {
                copyOnWrite();
                ((ServiceOptions) this.instance).setDeprecated(z);
                return this;
            }

            public Builder clearDeprecated() {
                copyOnWrite();
                ((ServiceOptions) this.instance).clearDeprecated();
                return this;
            }

            public List<UninterpretedOption> getUninterpretedOptionList() {
                return Collections.unmodifiableList(((ServiceOptions) this.instance).getUninterpretedOptionList());
            }

            public int getUninterpretedOptionCount() {
                return ((ServiceOptions) this.instance).getUninterpretedOptionCount();
            }

            public UninterpretedOption getUninterpretedOption(int i) {
                return ((ServiceOptions) this.instance).getUninterpretedOption(i);
            }

            public Builder setUninterpretedOption(int i, UninterpretedOption uninterpretedOption) {
                copyOnWrite();
                ((ServiceOptions) this.instance).setUninterpretedOption(i, uninterpretedOption);
                return this;
            }

            public Builder setUninterpretedOption(int i, UninterpretedOption.Builder builder) {
                copyOnWrite();
                ((ServiceOptions) this.instance).setUninterpretedOption(i, builder);
                return this;
            }

            public Builder addUninterpretedOption(UninterpretedOption uninterpretedOption) {
                copyOnWrite();
                ((ServiceOptions) this.instance).addUninterpretedOption(uninterpretedOption);
                return this;
            }

            public Builder addUninterpretedOption(int i, UninterpretedOption uninterpretedOption) {
                copyOnWrite();
                ((ServiceOptions) this.instance).addUninterpretedOption(i, uninterpretedOption);
                return this;
            }

            public Builder addUninterpretedOption(UninterpretedOption.Builder builder) {
                copyOnWrite();
                ((ServiceOptions) this.instance).addUninterpretedOption(builder);
                return this;
            }

            public Builder addUninterpretedOption(int i, UninterpretedOption.Builder builder) {
                copyOnWrite();
                ((ServiceOptions) this.instance).addUninterpretedOption(i, builder);
                return this;
            }

            public Builder addAllUninterpretedOption(Iterable<? extends UninterpretedOption> iterable) {
                copyOnWrite();
                ((ServiceOptions) this.instance).addAllUninterpretedOption(iterable);
                return this;
            }

            public Builder clearUninterpretedOption() {
                copyOnWrite();
                ((ServiceOptions) this.instance).clearUninterpretedOption();
                return this;
            }

            public Builder removeUninterpretedOption(int i) {
                copyOnWrite();
                ((ServiceOptions) this.instance).removeUninterpretedOption(i);
                return this;
            }
        }

        /* access modifiers changed from: protected */
        public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            boolean z = false;
            switch (methodToInvoke) {
                case NEW_MUTABLE_INSTANCE:
                    return new ServiceOptions();
                case IS_INITIALIZED:
                    byte b = this.memoizedIsInitialized;
                    if (b == 1) {
                        return DEFAULT_INSTANCE;
                    }
                    if (b == 0) {
                        return null;
                    }
                    boolean booleanValue = ((Boolean) obj).booleanValue();
                    for (int i = 0; i < getUninterpretedOptionCount(); i++) {
                        if (!getUninterpretedOption(i).isInitialized()) {
                            if (booleanValue) {
                                this.memoizedIsInitialized = 0;
                            }
                            return null;
                        }
                    }
                    if (!extensionsAreInitialized()) {
                        if (booleanValue) {
                            this.memoizedIsInitialized = 0;
                        }
                        return null;
                    }
                    if (booleanValue) {
                        this.memoizedIsInitialized = 1;
                    }
                    return DEFAULT_INSTANCE;
                case MAKE_IMMUTABLE:
                    this.uninterpretedOption_.makeImmutable();
                    return null;
                case NEW_BUILDER:
                    return new Builder();
                case VISIT:
                    GeneratedMessageLite.Visitor visitor = (GeneratedMessageLite.Visitor) obj;
                    ServiceOptions serviceOptions = (ServiceOptions) obj2;
                    this.deprecated_ = visitor.visitBoolean(hasDeprecated(), this.deprecated_, serviceOptions.hasDeprecated(), serviceOptions.deprecated_);
                    this.uninterpretedOption_ = visitor.visitList(this.uninterpretedOption_, serviceOptions.uninterpretedOption_);
                    if (visitor == GeneratedMessageLite.MergeFromVisitor.INSTANCE) {
                        this.bitField0_ |= serviceOptions.bitField0_;
                    }
                    return this;
                case MERGE_FROM_STREAM:
                    CodedInputStream codedInputStream = (CodedInputStream) obj;
                    ExtensionRegistryLite extensionRegistryLite = (ExtensionRegistryLite) obj2;
                    while (!z) {
                        try {
                            int readTag = codedInputStream.readTag();
                            if (readTag != 0) {
                                if (readTag == 264) {
                                    this.bitField0_ |= 1;
                                    this.deprecated_ = codedInputStream.readBool();
                                } else if (readTag == 7994) {
                                    if (!this.uninterpretedOption_.isModifiable()) {
                                        this.uninterpretedOption_ = GeneratedMessageLite.mutableCopy(this.uninterpretedOption_);
                                    }
                                    this.uninterpretedOption_.add((UninterpretedOption) codedInputStream.readMessage(UninterpretedOption.parser(), extensionRegistryLite));
                                } else if (!parseUnknownField((ServiceOptions) getDefaultInstanceForType(), codedInputStream, extensionRegistryLite, readTag)) {
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
                        synchronized (ServiceOptions.class) {
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

        public static ServiceOptions getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<ServiceOptions> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }
    }

    /* compiled from: com.google.firebase:protolite-well-known-types@@16.0.1 */
    public static final class MethodOptions extends GeneratedMessageLite.ExtendableMessage<MethodOptions, Builder> implements MethodOptionsOrBuilder {
        /* access modifiers changed from: private */
        public static final MethodOptions DEFAULT_INSTANCE = new MethodOptions();
        public static final int DEPRECATED_FIELD_NUMBER = 33;
        public static final int IDEMPOTENCY_LEVEL_FIELD_NUMBER = 34;
        private static volatile Parser<MethodOptions> PARSER = null;
        public static final int UNINTERPRETED_OPTION_FIELD_NUMBER = 999;
        private int bitField0_;
        private boolean deprecated_;
        private int idempotencyLevel_;
        private byte memoizedIsInitialized = -1;
        private Internal.ProtobufList<UninterpretedOption> uninterpretedOption_ = emptyProtobufList();

        private MethodOptions() {
        }

        /* compiled from: com.google.firebase:protolite-well-known-types@@16.0.1 */
        public enum IdempotencyLevel implements Internal.EnumLite {
            IDEMPOTENCY_UNKNOWN(0),
            NO_SIDE_EFFECTS(1),
            IDEMPOTENT(2);
            
            public static final int IDEMPOTENCY_UNKNOWN_VALUE = 0;
            public static final int IDEMPOTENT_VALUE = 2;
            public static final int NO_SIDE_EFFECTS_VALUE = 1;
            private static final Internal.EnumLiteMap<IdempotencyLevel> internalValueMap = null;
            private final int value;

            static {
                internalValueMap = new Internal.EnumLiteMap<IdempotencyLevel>() {
                    public IdempotencyLevel findValueByNumber(int i) {
                        return IdempotencyLevel.forNumber(i);
                    }
                };
            }

            public final int getNumber() {
                return this.value;
            }

            @Deprecated
            public static IdempotencyLevel valueOf(int i) {
                return forNumber(i);
            }

            public static IdempotencyLevel forNumber(int i) {
                if (i == 0) {
                    return IDEMPOTENCY_UNKNOWN;
                }
                if (i == 1) {
                    return NO_SIDE_EFFECTS;
                }
                if (i != 2) {
                    return null;
                }
                return IDEMPOTENT;
            }

            public static Internal.EnumLiteMap<IdempotencyLevel> internalGetValueMap() {
                return internalValueMap;
            }

            private IdempotencyLevel(int i) {
                this.value = i;
            }
        }

        public boolean hasDeprecated() {
            return (this.bitField0_ & 1) == 1;
        }

        public boolean getDeprecated() {
            return this.deprecated_;
        }

        /* access modifiers changed from: private */
        public void setDeprecated(boolean z) {
            this.bitField0_ |= 1;
            this.deprecated_ = z;
        }

        /* access modifiers changed from: private */
        public void clearDeprecated() {
            this.bitField0_ &= -2;
            this.deprecated_ = false;
        }

        public boolean hasIdempotencyLevel() {
            return (this.bitField0_ & 2) == 2;
        }

        public IdempotencyLevel getIdempotencyLevel() {
            IdempotencyLevel forNumber = IdempotencyLevel.forNumber(this.idempotencyLevel_);
            return forNumber == null ? IdempotencyLevel.IDEMPOTENCY_UNKNOWN : forNumber;
        }

        /* access modifiers changed from: private */
        public void setIdempotencyLevel(IdempotencyLevel idempotencyLevel) {
            if (idempotencyLevel != null) {
                this.bitField0_ |= 2;
                this.idempotencyLevel_ = idempotencyLevel.getNumber();
                return;
            }
            throw new NullPointerException();
        }

        /* access modifiers changed from: private */
        public void clearIdempotencyLevel() {
            this.bitField0_ &= -3;
            this.idempotencyLevel_ = 0;
        }

        public List<UninterpretedOption> getUninterpretedOptionList() {
            return this.uninterpretedOption_;
        }

        public List<? extends UninterpretedOptionOrBuilder> getUninterpretedOptionOrBuilderList() {
            return this.uninterpretedOption_;
        }

        public int getUninterpretedOptionCount() {
            return this.uninterpretedOption_.size();
        }

        public UninterpretedOption getUninterpretedOption(int i) {
            return (UninterpretedOption) this.uninterpretedOption_.get(i);
        }

        public UninterpretedOptionOrBuilder getUninterpretedOptionOrBuilder(int i) {
            return (UninterpretedOptionOrBuilder) this.uninterpretedOption_.get(i);
        }

        private void ensureUninterpretedOptionIsMutable() {
            if (!this.uninterpretedOption_.isModifiable()) {
                this.uninterpretedOption_ = GeneratedMessageLite.mutableCopy(this.uninterpretedOption_);
            }
        }

        /* access modifiers changed from: private */
        public void setUninterpretedOption(int i, UninterpretedOption uninterpretedOption) {
            if (uninterpretedOption != null) {
                ensureUninterpretedOptionIsMutable();
                this.uninterpretedOption_.set(i, uninterpretedOption);
                return;
            }
            throw new NullPointerException();
        }

        /* access modifiers changed from: private */
        public void setUninterpretedOption(int i, UninterpretedOption.Builder builder) {
            ensureUninterpretedOptionIsMutable();
            this.uninterpretedOption_.set(i, (UninterpretedOption) builder.build());
        }

        /* access modifiers changed from: private */
        public void addUninterpretedOption(UninterpretedOption uninterpretedOption) {
            if (uninterpretedOption != null) {
                ensureUninterpretedOptionIsMutable();
                this.uninterpretedOption_.add(uninterpretedOption);
                return;
            }
            throw new NullPointerException();
        }

        /* access modifiers changed from: private */
        public void addUninterpretedOption(int i, UninterpretedOption uninterpretedOption) {
            if (uninterpretedOption != null) {
                ensureUninterpretedOptionIsMutable();
                this.uninterpretedOption_.add(i, uninterpretedOption);
                return;
            }
            throw new NullPointerException();
        }

        /* access modifiers changed from: private */
        public void addUninterpretedOption(UninterpretedOption.Builder builder) {
            ensureUninterpretedOptionIsMutable();
            this.uninterpretedOption_.add((UninterpretedOption) builder.build());
        }

        /* access modifiers changed from: private */
        public void addUninterpretedOption(int i, UninterpretedOption.Builder builder) {
            ensureUninterpretedOptionIsMutable();
            this.uninterpretedOption_.add(i, (UninterpretedOption) builder.build());
        }

        /* access modifiers changed from: private */
        public void addAllUninterpretedOption(Iterable<? extends UninterpretedOption> iterable) {
            ensureUninterpretedOptionIsMutable();
            AbstractMessageLite.addAll(iterable, this.uninterpretedOption_);
        }

        /* access modifiers changed from: private */
        public void clearUninterpretedOption() {
            this.uninterpretedOption_ = emptyProtobufList();
        }

        /* access modifiers changed from: private */
        public void removeUninterpretedOption(int i) {
            ensureUninterpretedOptionIsMutable();
            this.uninterpretedOption_.remove(i);
        }

        public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
            GeneratedMessageLite.ExtendableMessage<MessageType, BuilderType>.ExtensionWriter newExtensionWriter = newExtensionWriter();
            if ((this.bitField0_ & 1) == 1) {
                codedOutputStream.writeBool(33, this.deprecated_);
            }
            if ((this.bitField0_ & 2) == 2) {
                codedOutputStream.writeEnum(34, this.idempotencyLevel_);
            }
            for (int i = 0; i < this.uninterpretedOption_.size(); i++) {
                codedOutputStream.writeMessage(999, (MessageLite) this.uninterpretedOption_.get(i));
            }
            newExtensionWriter.writeUntil(PropertyOptions.DELETE_EXISTING, codedOutputStream);
            this.unknownFields.writeTo(codedOutputStream);
        }

        public int getSerializedSize() {
            int i = this.memoizedSerializedSize;
            if (i != -1) {
                return i;
            }
            int computeBoolSize = (this.bitField0_ & 1) == 1 ? CodedOutputStream.computeBoolSize(33, this.deprecated_) + 0 : 0;
            if ((this.bitField0_ & 2) == 2) {
                computeBoolSize += CodedOutputStream.computeEnumSize(34, this.idempotencyLevel_);
            }
            for (int i2 = 0; i2 < this.uninterpretedOption_.size(); i2++) {
                computeBoolSize += CodedOutputStream.computeMessageSize(999, (MessageLite) this.uninterpretedOption_.get(i2));
            }
            int extensionsSerializedSize = computeBoolSize + extensionsSerializedSize() + this.unknownFields.getSerializedSize();
            this.memoizedSerializedSize = extensionsSerializedSize;
            return extensionsSerializedSize;
        }

        public static MethodOptions parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return (MethodOptions) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
        }

        public static MethodOptions parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (MethodOptions) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
        }

        public static MethodOptions parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return (MethodOptions) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
        }

        public static MethodOptions parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (MethodOptions) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
        }

        public static MethodOptions parseFrom(InputStream inputStream) throws IOException {
            return (MethodOptions) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static MethodOptions parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (MethodOptions) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static MethodOptions parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (MethodOptions) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static MethodOptions parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (MethodOptions) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static MethodOptions parseFrom(CodedInputStream codedInputStream) throws IOException {
            return (MethodOptions) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
        }

        public static MethodOptions parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (MethodOptions) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
        }

        public static Builder newBuilder() {
            return (Builder) DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(MethodOptions methodOptions) {
            return (Builder) ((Builder) DEFAULT_INSTANCE.toBuilder()).mergeFrom(methodOptions);
        }

        /* compiled from: com.google.firebase:protolite-well-known-types@@16.0.1 */
        public static final class Builder extends GeneratedMessageLite.ExtendableBuilder<MethodOptions, Builder> implements MethodOptionsOrBuilder {
            private Builder() {
                super(MethodOptions.DEFAULT_INSTANCE);
            }

            public boolean hasDeprecated() {
                return ((MethodOptions) this.instance).hasDeprecated();
            }

            public boolean getDeprecated() {
                return ((MethodOptions) this.instance).getDeprecated();
            }

            public Builder setDeprecated(boolean z) {
                copyOnWrite();
                ((MethodOptions) this.instance).setDeprecated(z);
                return this;
            }

            public Builder clearDeprecated() {
                copyOnWrite();
                ((MethodOptions) this.instance).clearDeprecated();
                return this;
            }

            public boolean hasIdempotencyLevel() {
                return ((MethodOptions) this.instance).hasIdempotencyLevel();
            }

            public IdempotencyLevel getIdempotencyLevel() {
                return ((MethodOptions) this.instance).getIdempotencyLevel();
            }

            public Builder setIdempotencyLevel(IdempotencyLevel idempotencyLevel) {
                copyOnWrite();
                ((MethodOptions) this.instance).setIdempotencyLevel(idempotencyLevel);
                return this;
            }

            public Builder clearIdempotencyLevel() {
                copyOnWrite();
                ((MethodOptions) this.instance).clearIdempotencyLevel();
                return this;
            }

            public List<UninterpretedOption> getUninterpretedOptionList() {
                return Collections.unmodifiableList(((MethodOptions) this.instance).getUninterpretedOptionList());
            }

            public int getUninterpretedOptionCount() {
                return ((MethodOptions) this.instance).getUninterpretedOptionCount();
            }

            public UninterpretedOption getUninterpretedOption(int i) {
                return ((MethodOptions) this.instance).getUninterpretedOption(i);
            }

            public Builder setUninterpretedOption(int i, UninterpretedOption uninterpretedOption) {
                copyOnWrite();
                ((MethodOptions) this.instance).setUninterpretedOption(i, uninterpretedOption);
                return this;
            }

            public Builder setUninterpretedOption(int i, UninterpretedOption.Builder builder) {
                copyOnWrite();
                ((MethodOptions) this.instance).setUninterpretedOption(i, builder);
                return this;
            }

            public Builder addUninterpretedOption(UninterpretedOption uninterpretedOption) {
                copyOnWrite();
                ((MethodOptions) this.instance).addUninterpretedOption(uninterpretedOption);
                return this;
            }

            public Builder addUninterpretedOption(int i, UninterpretedOption uninterpretedOption) {
                copyOnWrite();
                ((MethodOptions) this.instance).addUninterpretedOption(i, uninterpretedOption);
                return this;
            }

            public Builder addUninterpretedOption(UninterpretedOption.Builder builder) {
                copyOnWrite();
                ((MethodOptions) this.instance).addUninterpretedOption(builder);
                return this;
            }

            public Builder addUninterpretedOption(int i, UninterpretedOption.Builder builder) {
                copyOnWrite();
                ((MethodOptions) this.instance).addUninterpretedOption(i, builder);
                return this;
            }

            public Builder addAllUninterpretedOption(Iterable<? extends UninterpretedOption> iterable) {
                copyOnWrite();
                ((MethodOptions) this.instance).addAllUninterpretedOption(iterable);
                return this;
            }

            public Builder clearUninterpretedOption() {
                copyOnWrite();
                ((MethodOptions) this.instance).clearUninterpretedOption();
                return this;
            }

            public Builder removeUninterpretedOption(int i) {
                copyOnWrite();
                ((MethodOptions) this.instance).removeUninterpretedOption(i);
                return this;
            }
        }

        /* access modifiers changed from: protected */
        public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            boolean z = false;
            switch (methodToInvoke) {
                case NEW_MUTABLE_INSTANCE:
                    return new MethodOptions();
                case IS_INITIALIZED:
                    byte b = this.memoizedIsInitialized;
                    if (b == 1) {
                        return DEFAULT_INSTANCE;
                    }
                    if (b == 0) {
                        return null;
                    }
                    boolean booleanValue = ((Boolean) obj).booleanValue();
                    for (int i = 0; i < getUninterpretedOptionCount(); i++) {
                        if (!getUninterpretedOption(i).isInitialized()) {
                            if (booleanValue) {
                                this.memoizedIsInitialized = 0;
                            }
                            return null;
                        }
                    }
                    if (!extensionsAreInitialized()) {
                        if (booleanValue) {
                            this.memoizedIsInitialized = 0;
                        }
                        return null;
                    }
                    if (booleanValue) {
                        this.memoizedIsInitialized = 1;
                    }
                    return DEFAULT_INSTANCE;
                case MAKE_IMMUTABLE:
                    this.uninterpretedOption_.makeImmutable();
                    return null;
                case NEW_BUILDER:
                    return new Builder();
                case VISIT:
                    GeneratedMessageLite.Visitor visitor = (GeneratedMessageLite.Visitor) obj;
                    MethodOptions methodOptions = (MethodOptions) obj2;
                    this.deprecated_ = visitor.visitBoolean(hasDeprecated(), this.deprecated_, methodOptions.hasDeprecated(), methodOptions.deprecated_);
                    this.idempotencyLevel_ = visitor.visitInt(hasIdempotencyLevel(), this.idempotencyLevel_, methodOptions.hasIdempotencyLevel(), methodOptions.idempotencyLevel_);
                    this.uninterpretedOption_ = visitor.visitList(this.uninterpretedOption_, methodOptions.uninterpretedOption_);
                    if (visitor == GeneratedMessageLite.MergeFromVisitor.INSTANCE) {
                        this.bitField0_ |= methodOptions.bitField0_;
                    }
                    return this;
                case MERGE_FROM_STREAM:
                    CodedInputStream codedInputStream = (CodedInputStream) obj;
                    ExtensionRegistryLite extensionRegistryLite = (ExtensionRegistryLite) obj2;
                    while (!z) {
                        try {
                            int readTag = codedInputStream.readTag();
                            if (readTag != 0) {
                                if (readTag == 264) {
                                    this.bitField0_ |= 1;
                                    this.deprecated_ = codedInputStream.readBool();
                                } else if (readTag == 272) {
                                    int readEnum = codedInputStream.readEnum();
                                    if (IdempotencyLevel.forNumber(readEnum) == null) {
                                        super.mergeVarintField(34, readEnum);
                                    } else {
                                        this.bitField0_ |= 2;
                                        this.idempotencyLevel_ = readEnum;
                                    }
                                } else if (readTag == 7994) {
                                    if (!this.uninterpretedOption_.isModifiable()) {
                                        this.uninterpretedOption_ = GeneratedMessageLite.mutableCopy(this.uninterpretedOption_);
                                    }
                                    this.uninterpretedOption_.add((UninterpretedOption) codedInputStream.readMessage(UninterpretedOption.parser(), extensionRegistryLite));
                                } else if (!parseUnknownField((MethodOptions) getDefaultInstanceForType(), codedInputStream, extensionRegistryLite, readTag)) {
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
                        synchronized (MethodOptions.class) {
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

        public static MethodOptions getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<MethodOptions> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }
    }

    /* compiled from: com.google.firebase:protolite-well-known-types@@16.0.1 */
    public static final class UninterpretedOption extends GeneratedMessageLite<UninterpretedOption, Builder> implements UninterpretedOptionOrBuilder {
        public static final int AGGREGATE_VALUE_FIELD_NUMBER = 8;
        /* access modifiers changed from: private */
        public static final UninterpretedOption DEFAULT_INSTANCE = new UninterpretedOption();
        public static final int DOUBLE_VALUE_FIELD_NUMBER = 6;
        public static final int IDENTIFIER_VALUE_FIELD_NUMBER = 3;
        public static final int NAME_FIELD_NUMBER = 2;
        public static final int NEGATIVE_INT_VALUE_FIELD_NUMBER = 5;
        private static volatile Parser<UninterpretedOption> PARSER = null;
        public static final int POSITIVE_INT_VALUE_FIELD_NUMBER = 4;
        public static final int STRING_VALUE_FIELD_NUMBER = 7;
        private String aggregateValue_ = "";
        private int bitField0_;
        private double doubleValue_;
        private String identifierValue_ = "";
        private byte memoizedIsInitialized = -1;
        private Internal.ProtobufList<NamePart> name_ = emptyProtobufList();
        private long negativeIntValue_;
        private long positiveIntValue_;
        private ByteString stringValue_ = ByteString.EMPTY;

        /* compiled from: com.google.firebase:protolite-well-known-types@@16.0.1 */
        public interface NamePartOrBuilder extends MessageLiteOrBuilder {
            boolean getIsExtension();

            String getNamePart();

            ByteString getNamePartBytes();

            boolean hasIsExtension();

            boolean hasNamePart();
        }

        private UninterpretedOption() {
        }

        /* compiled from: com.google.firebase:protolite-well-known-types@@16.0.1 */
        public static final class NamePart extends GeneratedMessageLite<NamePart, Builder> implements NamePartOrBuilder {
            /* access modifiers changed from: private */
            public static final NamePart DEFAULT_INSTANCE = new NamePart();
            public static final int IS_EXTENSION_FIELD_NUMBER = 2;
            public static final int NAME_PART_FIELD_NUMBER = 1;
            private static volatile Parser<NamePart> PARSER;
            private int bitField0_;
            private boolean isExtension_;
            private byte memoizedIsInitialized = -1;
            private String namePart_ = "";

            private NamePart() {
            }

            public boolean hasNamePart() {
                return (this.bitField0_ & 1) == 1;
            }

            public String getNamePart() {
                return this.namePart_;
            }

            public ByteString getNamePartBytes() {
                return ByteString.copyFromUtf8(this.namePart_);
            }

            /* access modifiers changed from: private */
            public void setNamePart(String str) {
                if (str != null) {
                    this.bitField0_ |= 1;
                    this.namePart_ = str;
                    return;
                }
                throw new NullPointerException();
            }

            /* access modifiers changed from: private */
            public void clearNamePart() {
                this.bitField0_ &= -2;
                this.namePart_ = getDefaultInstance().getNamePart();
            }

            /* access modifiers changed from: private */
            public void setNamePartBytes(ByteString byteString) {
                if (byteString != null) {
                    this.bitField0_ |= 1;
                    this.namePart_ = byteString.toStringUtf8();
                    return;
                }
                throw new NullPointerException();
            }

            public boolean hasIsExtension() {
                return (this.bitField0_ & 2) == 2;
            }

            public boolean getIsExtension() {
                return this.isExtension_;
            }

            /* access modifiers changed from: private */
            public void setIsExtension(boolean z) {
                this.bitField0_ |= 2;
                this.isExtension_ = z;
            }

            /* access modifiers changed from: private */
            public void clearIsExtension() {
                this.bitField0_ &= -3;
                this.isExtension_ = false;
            }

            public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
                if ((this.bitField0_ & 1) == 1) {
                    codedOutputStream.writeString(1, getNamePart());
                }
                if ((this.bitField0_ & 2) == 2) {
                    codedOutputStream.writeBool(2, this.isExtension_);
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
                    i2 = 0 + CodedOutputStream.computeStringSize(1, getNamePart());
                }
                if ((this.bitField0_ & 2) == 2) {
                    i2 += CodedOutputStream.computeBoolSize(2, this.isExtension_);
                }
                int serializedSize = i2 + this.unknownFields.getSerializedSize();
                this.memoizedSerializedSize = serializedSize;
                return serializedSize;
            }

            public static NamePart parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
                return (NamePart) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
            }

            public static NamePart parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return (NamePart) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
            }

            public static NamePart parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
                return (NamePart) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
            }

            public static NamePart parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return (NamePart) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
            }

            public static NamePart parseFrom(InputStream inputStream) throws IOException {
                return (NamePart) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
            }

            public static NamePart parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                return (NamePart) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
            }

            public static NamePart parseDelimitedFrom(InputStream inputStream) throws IOException {
                return (NamePart) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
            }

            public static NamePart parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                return (NamePart) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
            }

            public static NamePart parseFrom(CodedInputStream codedInputStream) throws IOException {
                return (NamePart) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
            }

            public static NamePart parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                return (NamePart) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
            }

            public static Builder newBuilder() {
                return (Builder) DEFAULT_INSTANCE.toBuilder();
            }

            public static Builder newBuilder(NamePart namePart) {
                return (Builder) ((Builder) DEFAULT_INSTANCE.toBuilder()).mergeFrom(namePart);
            }

            /* compiled from: com.google.firebase:protolite-well-known-types@@16.0.1 */
            public static final class Builder extends GeneratedMessageLite.Builder<NamePart, Builder> implements NamePartOrBuilder {
                private Builder() {
                    super(NamePart.DEFAULT_INSTANCE);
                }

                public boolean hasNamePart() {
                    return ((NamePart) this.instance).hasNamePart();
                }

                public String getNamePart() {
                    return ((NamePart) this.instance).getNamePart();
                }

                public ByteString getNamePartBytes() {
                    return ((NamePart) this.instance).getNamePartBytes();
                }

                public Builder setNamePart(String str) {
                    copyOnWrite();
                    ((NamePart) this.instance).setNamePart(str);
                    return this;
                }

                public Builder clearNamePart() {
                    copyOnWrite();
                    ((NamePart) this.instance).clearNamePart();
                    return this;
                }

                public Builder setNamePartBytes(ByteString byteString) {
                    copyOnWrite();
                    ((NamePart) this.instance).setNamePartBytes(byteString);
                    return this;
                }

                public boolean hasIsExtension() {
                    return ((NamePart) this.instance).hasIsExtension();
                }

                public boolean getIsExtension() {
                    return ((NamePart) this.instance).getIsExtension();
                }

                public Builder setIsExtension(boolean z) {
                    copyOnWrite();
                    ((NamePart) this.instance).setIsExtension(z);
                    return this;
                }

                public Builder clearIsExtension() {
                    copyOnWrite();
                    ((NamePart) this.instance).clearIsExtension();
                    return this;
                }
            }

            /* access modifiers changed from: protected */
            public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
                boolean z = false;
                switch (methodToInvoke) {
                    case NEW_MUTABLE_INSTANCE:
                        return new NamePart();
                    case IS_INITIALIZED:
                        byte b = this.memoizedIsInitialized;
                        if (b == 1) {
                            return DEFAULT_INSTANCE;
                        }
                        if (b == 0) {
                            return null;
                        }
                        boolean booleanValue = ((Boolean) obj).booleanValue();
                        if (!hasNamePart()) {
                            if (booleanValue) {
                                this.memoizedIsInitialized = 0;
                            }
                            return null;
                        } else if (!hasIsExtension()) {
                            if (booleanValue) {
                                this.memoizedIsInitialized = 0;
                            }
                            return null;
                        } else {
                            if (booleanValue) {
                                this.memoizedIsInitialized = 1;
                            }
                            return DEFAULT_INSTANCE;
                        }
                    case MAKE_IMMUTABLE:
                        return null;
                    case NEW_BUILDER:
                        return new Builder();
                    case VISIT:
                        GeneratedMessageLite.Visitor visitor = (GeneratedMessageLite.Visitor) obj;
                        NamePart namePart = (NamePart) obj2;
                        this.namePart_ = visitor.visitString(hasNamePart(), this.namePart_, namePart.hasNamePart(), namePart.namePart_);
                        this.isExtension_ = visitor.visitBoolean(hasIsExtension(), this.isExtension_, namePart.hasIsExtension(), namePart.isExtension_);
                        if (visitor == GeneratedMessageLite.MergeFromVisitor.INSTANCE) {
                            this.bitField0_ |= namePart.bitField0_;
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
                                        this.bitField0_ |= 1;
                                        this.namePart_ = readString;
                                    } else if (readTag == 16) {
                                        this.bitField0_ |= 2;
                                        this.isExtension_ = codedInputStream.readBool();
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
                            synchronized (NamePart.class) {
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

            public static NamePart getDefaultInstance() {
                return DEFAULT_INSTANCE;
            }

            public static Parser<NamePart> parser() {
                return DEFAULT_INSTANCE.getParserForType();
            }
        }

        public List<NamePart> getNameList() {
            return this.name_;
        }

        public List<? extends NamePartOrBuilder> getNameOrBuilderList() {
            return this.name_;
        }

        public int getNameCount() {
            return this.name_.size();
        }

        public NamePart getName(int i) {
            return (NamePart) this.name_.get(i);
        }

        public NamePartOrBuilder getNameOrBuilder(int i) {
            return (NamePartOrBuilder) this.name_.get(i);
        }

        private void ensureNameIsMutable() {
            if (!this.name_.isModifiable()) {
                this.name_ = GeneratedMessageLite.mutableCopy(this.name_);
            }
        }

        /* access modifiers changed from: private */
        public void setName(int i, NamePart namePart) {
            if (namePart != null) {
                ensureNameIsMutable();
                this.name_.set(i, namePart);
                return;
            }
            throw new NullPointerException();
        }

        /* access modifiers changed from: private */
        public void setName(int i, NamePart.Builder builder) {
            ensureNameIsMutable();
            this.name_.set(i, (NamePart) builder.build());
        }

        /* access modifiers changed from: private */
        public void addName(NamePart namePart) {
            if (namePart != null) {
                ensureNameIsMutable();
                this.name_.add(namePart);
                return;
            }
            throw new NullPointerException();
        }

        /* access modifiers changed from: private */
        public void addName(int i, NamePart namePart) {
            if (namePart != null) {
                ensureNameIsMutable();
                this.name_.add(i, namePart);
                return;
            }
            throw new NullPointerException();
        }

        /* access modifiers changed from: private */
        public void addName(NamePart.Builder builder) {
            ensureNameIsMutable();
            this.name_.add((NamePart) builder.build());
        }

        /* access modifiers changed from: private */
        public void addName(int i, NamePart.Builder builder) {
            ensureNameIsMutable();
            this.name_.add(i, (NamePart) builder.build());
        }

        /* access modifiers changed from: private */
        public void addAllName(Iterable<? extends NamePart> iterable) {
            ensureNameIsMutable();
            AbstractMessageLite.addAll(iterable, this.name_);
        }

        /* access modifiers changed from: private */
        public void clearName() {
            this.name_ = emptyProtobufList();
        }

        /* access modifiers changed from: private */
        public void removeName(int i) {
            ensureNameIsMutable();
            this.name_.remove(i);
        }

        public boolean hasIdentifierValue() {
            return (this.bitField0_ & 1) == 1;
        }

        public String getIdentifierValue() {
            return this.identifierValue_;
        }

        public ByteString getIdentifierValueBytes() {
            return ByteString.copyFromUtf8(this.identifierValue_);
        }

        /* access modifiers changed from: private */
        public void setIdentifierValue(String str) {
            if (str != null) {
                this.bitField0_ |= 1;
                this.identifierValue_ = str;
                return;
            }
            throw new NullPointerException();
        }

        /* access modifiers changed from: private */
        public void clearIdentifierValue() {
            this.bitField0_ &= -2;
            this.identifierValue_ = getDefaultInstance().getIdentifierValue();
        }

        /* access modifiers changed from: private */
        public void setIdentifierValueBytes(ByteString byteString) {
            if (byteString != null) {
                this.bitField0_ |= 1;
                this.identifierValue_ = byteString.toStringUtf8();
                return;
            }
            throw new NullPointerException();
        }

        public boolean hasPositiveIntValue() {
            return (this.bitField0_ & 2) == 2;
        }

        public long getPositiveIntValue() {
            return this.positiveIntValue_;
        }

        /* access modifiers changed from: private */
        public void setPositiveIntValue(long j) {
            this.bitField0_ |= 2;
            this.positiveIntValue_ = j;
        }

        /* access modifiers changed from: private */
        public void clearPositiveIntValue() {
            this.bitField0_ &= -3;
            this.positiveIntValue_ = 0;
        }

        public boolean hasNegativeIntValue() {
            return (this.bitField0_ & 4) == 4;
        }

        public long getNegativeIntValue() {
            return this.negativeIntValue_;
        }

        /* access modifiers changed from: private */
        public void setNegativeIntValue(long j) {
            this.bitField0_ |= 4;
            this.negativeIntValue_ = j;
        }

        /* access modifiers changed from: private */
        public void clearNegativeIntValue() {
            this.bitField0_ &= -5;
            this.negativeIntValue_ = 0;
        }

        public boolean hasDoubleValue() {
            return (this.bitField0_ & 8) == 8;
        }

        public double getDoubleValue() {
            return this.doubleValue_;
        }

        /* access modifiers changed from: private */
        public void setDoubleValue(double d) {
            this.bitField0_ |= 8;
            this.doubleValue_ = d;
        }

        /* access modifiers changed from: private */
        public void clearDoubleValue() {
            this.bitField0_ &= -9;
            this.doubleValue_ = 0.0d;
        }

        public boolean hasStringValue() {
            return (this.bitField0_ & 16) == 16;
        }

        public ByteString getStringValue() {
            return this.stringValue_;
        }

        /* access modifiers changed from: private */
        public void setStringValue(ByteString byteString) {
            if (byteString != null) {
                this.bitField0_ |= 16;
                this.stringValue_ = byteString;
                return;
            }
            throw new NullPointerException();
        }

        /* access modifiers changed from: private */
        public void clearStringValue() {
            this.bitField0_ &= -17;
            this.stringValue_ = getDefaultInstance().getStringValue();
        }

        public boolean hasAggregateValue() {
            return (this.bitField0_ & 32) == 32;
        }

        public String getAggregateValue() {
            return this.aggregateValue_;
        }

        public ByteString getAggregateValueBytes() {
            return ByteString.copyFromUtf8(this.aggregateValue_);
        }

        /* access modifiers changed from: private */
        public void setAggregateValue(String str) {
            if (str != null) {
                this.bitField0_ |= 32;
                this.aggregateValue_ = str;
                return;
            }
            throw new NullPointerException();
        }

        /* access modifiers changed from: private */
        public void clearAggregateValue() {
            this.bitField0_ &= -33;
            this.aggregateValue_ = getDefaultInstance().getAggregateValue();
        }

        /* access modifiers changed from: private */
        public void setAggregateValueBytes(ByteString byteString) {
            if (byteString != null) {
                this.bitField0_ |= 32;
                this.aggregateValue_ = byteString.toStringUtf8();
                return;
            }
            throw new NullPointerException();
        }

        public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
            for (int i = 0; i < this.name_.size(); i++) {
                codedOutputStream.writeMessage(2, (MessageLite) this.name_.get(i));
            }
            if ((this.bitField0_ & 1) == 1) {
                codedOutputStream.writeString(3, getIdentifierValue());
            }
            if ((this.bitField0_ & 2) == 2) {
                codedOutputStream.writeUInt64(4, this.positiveIntValue_);
            }
            if ((this.bitField0_ & 4) == 4) {
                codedOutputStream.writeInt64(5, this.negativeIntValue_);
            }
            if ((this.bitField0_ & 8) == 8) {
                codedOutputStream.writeDouble(6, this.doubleValue_);
            }
            if ((this.bitField0_ & 16) == 16) {
                codedOutputStream.writeBytes(7, this.stringValue_);
            }
            if ((this.bitField0_ & 32) == 32) {
                codedOutputStream.writeString(8, getAggregateValue());
            }
            this.unknownFields.writeTo(codedOutputStream);
        }

        public int getSerializedSize() {
            int i = this.memoizedSerializedSize;
            if (i != -1) {
                return i;
            }
            int i2 = 0;
            for (int i3 = 0; i3 < this.name_.size(); i3++) {
                i2 += CodedOutputStream.computeMessageSize(2, (MessageLite) this.name_.get(i3));
            }
            if ((this.bitField0_ & 1) == 1) {
                i2 += CodedOutputStream.computeStringSize(3, getIdentifierValue());
            }
            if ((this.bitField0_ & 2) == 2) {
                i2 += CodedOutputStream.computeUInt64Size(4, this.positiveIntValue_);
            }
            if ((this.bitField0_ & 4) == 4) {
                i2 += CodedOutputStream.computeInt64Size(5, this.negativeIntValue_);
            }
            if ((this.bitField0_ & 8) == 8) {
                i2 += CodedOutputStream.computeDoubleSize(6, this.doubleValue_);
            }
            if ((this.bitField0_ & 16) == 16) {
                i2 += CodedOutputStream.computeBytesSize(7, this.stringValue_);
            }
            if ((this.bitField0_ & 32) == 32) {
                i2 += CodedOutputStream.computeStringSize(8, getAggregateValue());
            }
            int serializedSize = i2 + this.unknownFields.getSerializedSize();
            this.memoizedSerializedSize = serializedSize;
            return serializedSize;
        }

        public static UninterpretedOption parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return (UninterpretedOption) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
        }

        public static UninterpretedOption parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (UninterpretedOption) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
        }

        public static UninterpretedOption parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return (UninterpretedOption) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
        }

        public static UninterpretedOption parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (UninterpretedOption) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
        }

        public static UninterpretedOption parseFrom(InputStream inputStream) throws IOException {
            return (UninterpretedOption) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static UninterpretedOption parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (UninterpretedOption) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static UninterpretedOption parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (UninterpretedOption) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static UninterpretedOption parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (UninterpretedOption) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static UninterpretedOption parseFrom(CodedInputStream codedInputStream) throws IOException {
            return (UninterpretedOption) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
        }

        public static UninterpretedOption parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (UninterpretedOption) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
        }

        public static Builder newBuilder() {
            return (Builder) DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(UninterpretedOption uninterpretedOption) {
            return (Builder) ((Builder) DEFAULT_INSTANCE.toBuilder()).mergeFrom(uninterpretedOption);
        }

        /* compiled from: com.google.firebase:protolite-well-known-types@@16.0.1 */
        public static final class Builder extends GeneratedMessageLite.Builder<UninterpretedOption, Builder> implements UninterpretedOptionOrBuilder {
            private Builder() {
                super(UninterpretedOption.DEFAULT_INSTANCE);
            }

            public List<NamePart> getNameList() {
                return Collections.unmodifiableList(((UninterpretedOption) this.instance).getNameList());
            }

            public int getNameCount() {
                return ((UninterpretedOption) this.instance).getNameCount();
            }

            public NamePart getName(int i) {
                return ((UninterpretedOption) this.instance).getName(i);
            }

            public Builder setName(int i, NamePart namePart) {
                copyOnWrite();
                ((UninterpretedOption) this.instance).setName(i, namePart);
                return this;
            }

            public Builder setName(int i, NamePart.Builder builder) {
                copyOnWrite();
                ((UninterpretedOption) this.instance).setName(i, builder);
                return this;
            }

            public Builder addName(NamePart namePart) {
                copyOnWrite();
                ((UninterpretedOption) this.instance).addName(namePart);
                return this;
            }

            public Builder addName(int i, NamePart namePart) {
                copyOnWrite();
                ((UninterpretedOption) this.instance).addName(i, namePart);
                return this;
            }

            public Builder addName(NamePart.Builder builder) {
                copyOnWrite();
                ((UninterpretedOption) this.instance).addName(builder);
                return this;
            }

            public Builder addName(int i, NamePart.Builder builder) {
                copyOnWrite();
                ((UninterpretedOption) this.instance).addName(i, builder);
                return this;
            }

            public Builder addAllName(Iterable<? extends NamePart> iterable) {
                copyOnWrite();
                ((UninterpretedOption) this.instance).addAllName(iterable);
                return this;
            }

            public Builder clearName() {
                copyOnWrite();
                ((UninterpretedOption) this.instance).clearName();
                return this;
            }

            public Builder removeName(int i) {
                copyOnWrite();
                ((UninterpretedOption) this.instance).removeName(i);
                return this;
            }

            public boolean hasIdentifierValue() {
                return ((UninterpretedOption) this.instance).hasIdentifierValue();
            }

            public String getIdentifierValue() {
                return ((UninterpretedOption) this.instance).getIdentifierValue();
            }

            public ByteString getIdentifierValueBytes() {
                return ((UninterpretedOption) this.instance).getIdentifierValueBytes();
            }

            public Builder setIdentifierValue(String str) {
                copyOnWrite();
                ((UninterpretedOption) this.instance).setIdentifierValue(str);
                return this;
            }

            public Builder clearIdentifierValue() {
                copyOnWrite();
                ((UninterpretedOption) this.instance).clearIdentifierValue();
                return this;
            }

            public Builder setIdentifierValueBytes(ByteString byteString) {
                copyOnWrite();
                ((UninterpretedOption) this.instance).setIdentifierValueBytes(byteString);
                return this;
            }

            public boolean hasPositiveIntValue() {
                return ((UninterpretedOption) this.instance).hasPositiveIntValue();
            }

            public long getPositiveIntValue() {
                return ((UninterpretedOption) this.instance).getPositiveIntValue();
            }

            public Builder setPositiveIntValue(long j) {
                copyOnWrite();
                ((UninterpretedOption) this.instance).setPositiveIntValue(j);
                return this;
            }

            public Builder clearPositiveIntValue() {
                copyOnWrite();
                ((UninterpretedOption) this.instance).clearPositiveIntValue();
                return this;
            }

            public boolean hasNegativeIntValue() {
                return ((UninterpretedOption) this.instance).hasNegativeIntValue();
            }

            public long getNegativeIntValue() {
                return ((UninterpretedOption) this.instance).getNegativeIntValue();
            }

            public Builder setNegativeIntValue(long j) {
                copyOnWrite();
                ((UninterpretedOption) this.instance).setNegativeIntValue(j);
                return this;
            }

            public Builder clearNegativeIntValue() {
                copyOnWrite();
                ((UninterpretedOption) this.instance).clearNegativeIntValue();
                return this;
            }

            public boolean hasDoubleValue() {
                return ((UninterpretedOption) this.instance).hasDoubleValue();
            }

            public double getDoubleValue() {
                return ((UninterpretedOption) this.instance).getDoubleValue();
            }

            public Builder setDoubleValue(double d) {
                copyOnWrite();
                ((UninterpretedOption) this.instance).setDoubleValue(d);
                return this;
            }

            public Builder clearDoubleValue() {
                copyOnWrite();
                ((UninterpretedOption) this.instance).clearDoubleValue();
                return this;
            }

            public boolean hasStringValue() {
                return ((UninterpretedOption) this.instance).hasStringValue();
            }

            public ByteString getStringValue() {
                return ((UninterpretedOption) this.instance).getStringValue();
            }

            public Builder setStringValue(ByteString byteString) {
                copyOnWrite();
                ((UninterpretedOption) this.instance).setStringValue(byteString);
                return this;
            }

            public Builder clearStringValue() {
                copyOnWrite();
                ((UninterpretedOption) this.instance).clearStringValue();
                return this;
            }

            public boolean hasAggregateValue() {
                return ((UninterpretedOption) this.instance).hasAggregateValue();
            }

            public String getAggregateValue() {
                return ((UninterpretedOption) this.instance).getAggregateValue();
            }

            public ByteString getAggregateValueBytes() {
                return ((UninterpretedOption) this.instance).getAggregateValueBytes();
            }

            public Builder setAggregateValue(String str) {
                copyOnWrite();
                ((UninterpretedOption) this.instance).setAggregateValue(str);
                return this;
            }

            public Builder clearAggregateValue() {
                copyOnWrite();
                ((UninterpretedOption) this.instance).clearAggregateValue();
                return this;
            }

            public Builder setAggregateValueBytes(ByteString byteString) {
                copyOnWrite();
                ((UninterpretedOption) this.instance).setAggregateValueBytes(byteString);
                return this;
            }
        }

        /* access modifiers changed from: protected */
        public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            boolean z = false;
            switch (methodToInvoke) {
                case NEW_MUTABLE_INSTANCE:
                    return new UninterpretedOption();
                case IS_INITIALIZED:
                    byte b = this.memoizedIsInitialized;
                    if (b == 1) {
                        return DEFAULT_INSTANCE;
                    }
                    if (b == 0) {
                        return null;
                    }
                    boolean booleanValue = ((Boolean) obj).booleanValue();
                    for (int i = 0; i < getNameCount(); i++) {
                        if (!getName(i).isInitialized()) {
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
                    this.name_.makeImmutable();
                    return null;
                case NEW_BUILDER:
                    return new Builder();
                case VISIT:
                    GeneratedMessageLite.Visitor visitor = (GeneratedMessageLite.Visitor) obj;
                    UninterpretedOption uninterpretedOption = (UninterpretedOption) obj2;
                    this.name_ = visitor.visitList(this.name_, uninterpretedOption.name_);
                    this.identifierValue_ = visitor.visitString(hasIdentifierValue(), this.identifierValue_, uninterpretedOption.hasIdentifierValue(), uninterpretedOption.identifierValue_);
                    this.positiveIntValue_ = visitor.visitLong(hasPositiveIntValue(), this.positiveIntValue_, uninterpretedOption.hasPositiveIntValue(), uninterpretedOption.positiveIntValue_);
                    this.negativeIntValue_ = visitor.visitLong(hasNegativeIntValue(), this.negativeIntValue_, uninterpretedOption.hasNegativeIntValue(), uninterpretedOption.negativeIntValue_);
                    this.doubleValue_ = visitor.visitDouble(hasDoubleValue(), this.doubleValue_, uninterpretedOption.hasDoubleValue(), uninterpretedOption.doubleValue_);
                    this.stringValue_ = visitor.visitByteString(hasStringValue(), this.stringValue_, uninterpretedOption.hasStringValue(), uninterpretedOption.stringValue_);
                    this.aggregateValue_ = visitor.visitString(hasAggregateValue(), this.aggregateValue_, uninterpretedOption.hasAggregateValue(), uninterpretedOption.aggregateValue_);
                    if (visitor == GeneratedMessageLite.MergeFromVisitor.INSTANCE) {
                        this.bitField0_ |= uninterpretedOption.bitField0_;
                    }
                    return this;
                case MERGE_FROM_STREAM:
                    CodedInputStream codedInputStream = (CodedInputStream) obj;
                    ExtensionRegistryLite extensionRegistryLite = (ExtensionRegistryLite) obj2;
                    while (!z) {
                        try {
                            int readTag = codedInputStream.readTag();
                            if (readTag != 0) {
                                if (readTag == 18) {
                                    if (!this.name_.isModifiable()) {
                                        this.name_ = GeneratedMessageLite.mutableCopy(this.name_);
                                    }
                                    this.name_.add((NamePart) codedInputStream.readMessage(NamePart.parser(), extensionRegistryLite));
                                } else if (readTag == 26) {
                                    String readString = codedInputStream.readString();
                                    this.bitField0_ |= 1;
                                    this.identifierValue_ = readString;
                                } else if (readTag == 32) {
                                    this.bitField0_ |= 2;
                                    this.positiveIntValue_ = codedInputStream.readUInt64();
                                } else if (readTag == 40) {
                                    this.bitField0_ |= 4;
                                    this.negativeIntValue_ = codedInputStream.readInt64();
                                } else if (readTag == 49) {
                                    this.bitField0_ |= 8;
                                    this.doubleValue_ = codedInputStream.readDouble();
                                } else if (readTag == 58) {
                                    this.bitField0_ |= 16;
                                    this.stringValue_ = codedInputStream.readBytes();
                                } else if (readTag == 66) {
                                    String readString2 = codedInputStream.readString();
                                    this.bitField0_ = 32 | this.bitField0_;
                                    this.aggregateValue_ = readString2;
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
                        synchronized (UninterpretedOption.class) {
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

        public static UninterpretedOption getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<UninterpretedOption> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }
    }

    /* compiled from: com.google.firebase:protolite-well-known-types@@16.0.1 */
    public static final class SourceCodeInfo extends GeneratedMessageLite<SourceCodeInfo, Builder> implements SourceCodeInfoOrBuilder {
        /* access modifiers changed from: private */
        public static final SourceCodeInfo DEFAULT_INSTANCE = new SourceCodeInfo();
        public static final int LOCATION_FIELD_NUMBER = 1;
        private static volatile Parser<SourceCodeInfo> PARSER;
        private Internal.ProtobufList<Location> location_ = emptyProtobufList();

        /* compiled from: com.google.firebase:protolite-well-known-types@@16.0.1 */
        public interface LocationOrBuilder extends MessageLiteOrBuilder {
            String getLeadingComments();

            ByteString getLeadingCommentsBytes();

            String getLeadingDetachedComments(int i);

            ByteString getLeadingDetachedCommentsBytes(int i);

            int getLeadingDetachedCommentsCount();

            List<String> getLeadingDetachedCommentsList();

            int getPath(int i);

            int getPathCount();

            List<Integer> getPathList();

            int getSpan(int i);

            int getSpanCount();

            List<Integer> getSpanList();

            String getTrailingComments();

            ByteString getTrailingCommentsBytes();

            boolean hasLeadingComments();

            boolean hasTrailingComments();
        }

        private SourceCodeInfo() {
        }

        /* compiled from: com.google.firebase:protolite-well-known-types@@16.0.1 */
        public static final class Location extends GeneratedMessageLite<Location, Builder> implements LocationOrBuilder {
            /* access modifiers changed from: private */
            public static final Location DEFAULT_INSTANCE = new Location();
            public static final int LEADING_COMMENTS_FIELD_NUMBER = 3;
            public static final int LEADING_DETACHED_COMMENTS_FIELD_NUMBER = 6;
            private static volatile Parser<Location> PARSER = null;
            public static final int PATH_FIELD_NUMBER = 1;
            public static final int SPAN_FIELD_NUMBER = 2;
            public static final int TRAILING_COMMENTS_FIELD_NUMBER = 4;
            private int bitField0_;
            private String leadingComments_ = "";
            private Internal.ProtobufList<String> leadingDetachedComments_ = GeneratedMessageLite.emptyProtobufList();
            private int pathMemoizedSerializedSize = -1;
            private Internal.IntList path_ = emptyIntList();
            private int spanMemoizedSerializedSize = -1;
            private Internal.IntList span_ = emptyIntList();
            private String trailingComments_ = "";

            private Location() {
            }

            public List<Integer> getPathList() {
                return this.path_;
            }

            public int getPathCount() {
                return this.path_.size();
            }

            public int getPath(int i) {
                return this.path_.getInt(i);
            }

            private void ensurePathIsMutable() {
                if (!this.path_.isModifiable()) {
                    this.path_ = GeneratedMessageLite.mutableCopy(this.path_);
                }
            }

            /* access modifiers changed from: private */
            public void setPath(int i, int i2) {
                ensurePathIsMutable();
                this.path_.setInt(i, i2);
            }

            /* access modifiers changed from: private */
            public void addPath(int i) {
                ensurePathIsMutable();
                this.path_.addInt(i);
            }

            /* access modifiers changed from: private */
            public void addAllPath(Iterable<? extends Integer> iterable) {
                ensurePathIsMutable();
                AbstractMessageLite.addAll(iterable, this.path_);
            }

            /* access modifiers changed from: private */
            public void clearPath() {
                this.path_ = emptyIntList();
            }

            public List<Integer> getSpanList() {
                return this.span_;
            }

            public int getSpanCount() {
                return this.span_.size();
            }

            public int getSpan(int i) {
                return this.span_.getInt(i);
            }

            private void ensureSpanIsMutable() {
                if (!this.span_.isModifiable()) {
                    this.span_ = GeneratedMessageLite.mutableCopy(this.span_);
                }
            }

            /* access modifiers changed from: private */
            public void setSpan(int i, int i2) {
                ensureSpanIsMutable();
                this.span_.setInt(i, i2);
            }

            /* access modifiers changed from: private */
            public void addSpan(int i) {
                ensureSpanIsMutable();
                this.span_.addInt(i);
            }

            /* access modifiers changed from: private */
            public void addAllSpan(Iterable<? extends Integer> iterable) {
                ensureSpanIsMutable();
                AbstractMessageLite.addAll(iterable, this.span_);
            }

            /* access modifiers changed from: private */
            public void clearSpan() {
                this.span_ = emptyIntList();
            }

            public boolean hasLeadingComments() {
                return (this.bitField0_ & 1) == 1;
            }

            public String getLeadingComments() {
                return this.leadingComments_;
            }

            public ByteString getLeadingCommentsBytes() {
                return ByteString.copyFromUtf8(this.leadingComments_);
            }

            /* access modifiers changed from: private */
            public void setLeadingComments(String str) {
                if (str != null) {
                    this.bitField0_ |= 1;
                    this.leadingComments_ = str;
                    return;
                }
                throw new NullPointerException();
            }

            /* access modifiers changed from: private */
            public void clearLeadingComments() {
                this.bitField0_ &= -2;
                this.leadingComments_ = getDefaultInstance().getLeadingComments();
            }

            /* access modifiers changed from: private */
            public void setLeadingCommentsBytes(ByteString byteString) {
                if (byteString != null) {
                    this.bitField0_ |= 1;
                    this.leadingComments_ = byteString.toStringUtf8();
                    return;
                }
                throw new NullPointerException();
            }

            public boolean hasTrailingComments() {
                return (this.bitField0_ & 2) == 2;
            }

            public String getTrailingComments() {
                return this.trailingComments_;
            }

            public ByteString getTrailingCommentsBytes() {
                return ByteString.copyFromUtf8(this.trailingComments_);
            }

            /* access modifiers changed from: private */
            public void setTrailingComments(String str) {
                if (str != null) {
                    this.bitField0_ |= 2;
                    this.trailingComments_ = str;
                    return;
                }
                throw new NullPointerException();
            }

            /* access modifiers changed from: private */
            public void clearTrailingComments() {
                this.bitField0_ &= -3;
                this.trailingComments_ = getDefaultInstance().getTrailingComments();
            }

            /* access modifiers changed from: private */
            public void setTrailingCommentsBytes(ByteString byteString) {
                if (byteString != null) {
                    this.bitField0_ |= 2;
                    this.trailingComments_ = byteString.toStringUtf8();
                    return;
                }
                throw new NullPointerException();
            }

            public List<String> getLeadingDetachedCommentsList() {
                return this.leadingDetachedComments_;
            }

            public int getLeadingDetachedCommentsCount() {
                return this.leadingDetachedComments_.size();
            }

            public String getLeadingDetachedComments(int i) {
                return (String) this.leadingDetachedComments_.get(i);
            }

            public ByteString getLeadingDetachedCommentsBytes(int i) {
                return ByteString.copyFromUtf8((String) this.leadingDetachedComments_.get(i));
            }

            private void ensureLeadingDetachedCommentsIsMutable() {
                if (!this.leadingDetachedComments_.isModifiable()) {
                    this.leadingDetachedComments_ = GeneratedMessageLite.mutableCopy(this.leadingDetachedComments_);
                }
            }

            /* access modifiers changed from: private */
            public void setLeadingDetachedComments(int i, String str) {
                if (str != null) {
                    ensureLeadingDetachedCommentsIsMutable();
                    this.leadingDetachedComments_.set(i, str);
                    return;
                }
                throw new NullPointerException();
            }

            /* access modifiers changed from: private */
            public void addLeadingDetachedComments(String str) {
                if (str != null) {
                    ensureLeadingDetachedCommentsIsMutable();
                    this.leadingDetachedComments_.add(str);
                    return;
                }
                throw new NullPointerException();
            }

            /* access modifiers changed from: private */
            public void addAllLeadingDetachedComments(Iterable<String> iterable) {
                ensureLeadingDetachedCommentsIsMutable();
                AbstractMessageLite.addAll(iterable, this.leadingDetachedComments_);
            }

            /* access modifiers changed from: private */
            public void clearLeadingDetachedComments() {
                this.leadingDetachedComments_ = GeneratedMessageLite.emptyProtobufList();
            }

            /* access modifiers changed from: private */
            public void addLeadingDetachedCommentsBytes(ByteString byteString) {
                if (byteString != null) {
                    ensureLeadingDetachedCommentsIsMutable();
                    this.leadingDetachedComments_.add(byteString.toStringUtf8());
                    return;
                }
                throw new NullPointerException();
            }

            public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
                getSerializedSize();
                if (getPathList().size() > 0) {
                    codedOutputStream.writeUInt32NoTag(10);
                    codedOutputStream.writeUInt32NoTag(this.pathMemoizedSerializedSize);
                }
                for (int i = 0; i < this.path_.size(); i++) {
                    codedOutputStream.writeInt32NoTag(this.path_.getInt(i));
                }
                if (getSpanList().size() > 0) {
                    codedOutputStream.writeUInt32NoTag(18);
                    codedOutputStream.writeUInt32NoTag(this.spanMemoizedSerializedSize);
                }
                for (int i2 = 0; i2 < this.span_.size(); i2++) {
                    codedOutputStream.writeInt32NoTag(this.span_.getInt(i2));
                }
                if ((this.bitField0_ & 1) == 1) {
                    codedOutputStream.writeString(3, getLeadingComments());
                }
                if ((this.bitField0_ & 2) == 2) {
                    codedOutputStream.writeString(4, getTrailingComments());
                }
                for (int i3 = 0; i3 < this.leadingDetachedComments_.size(); i3++) {
                    codedOutputStream.writeString(6, (String) this.leadingDetachedComments_.get(i3));
                }
                this.unknownFields.writeTo(codedOutputStream);
            }

            public int getSerializedSize() {
                int i = this.memoizedSerializedSize;
                if (i != -1) {
                    return i;
                }
                int i2 = 0;
                for (int i3 = 0; i3 < this.path_.size(); i3++) {
                    i2 += CodedOutputStream.computeInt32SizeNoTag(this.path_.getInt(i3));
                }
                int i4 = 0 + i2;
                if (!getPathList().isEmpty()) {
                    i4 = i4 + 1 + CodedOutputStream.computeInt32SizeNoTag(i2);
                }
                this.pathMemoizedSerializedSize = i2;
                int i5 = 0;
                for (int i6 = 0; i6 < this.span_.size(); i6++) {
                    i5 += CodedOutputStream.computeInt32SizeNoTag(this.span_.getInt(i6));
                }
                int i7 = i4 + i5;
                if (!getSpanList().isEmpty()) {
                    i7 = i7 + 1 + CodedOutputStream.computeInt32SizeNoTag(i5);
                }
                this.spanMemoizedSerializedSize = i5;
                if ((this.bitField0_ & 1) == 1) {
                    i7 += CodedOutputStream.computeStringSize(3, getLeadingComments());
                }
                if ((this.bitField0_ & 2) == 2) {
                    i7 += CodedOutputStream.computeStringSize(4, getTrailingComments());
                }
                int i8 = 0;
                for (int i9 = 0; i9 < this.leadingDetachedComments_.size(); i9++) {
                    i8 += CodedOutputStream.computeStringSizeNoTag((String) this.leadingDetachedComments_.get(i9));
                }
                int size = i7 + i8 + (getLeadingDetachedCommentsList().size() * 1) + this.unknownFields.getSerializedSize();
                this.memoizedSerializedSize = size;
                return size;
            }

            public static Location parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
                return (Location) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
            }

            public static Location parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return (Location) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
            }

            public static Location parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
                return (Location) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
            }

            public static Location parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return (Location) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
            }

            public static Location parseFrom(InputStream inputStream) throws IOException {
                return (Location) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
            }

            public static Location parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                return (Location) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
            }

            public static Location parseDelimitedFrom(InputStream inputStream) throws IOException {
                return (Location) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
            }

            public static Location parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                return (Location) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
            }

            public static Location parseFrom(CodedInputStream codedInputStream) throws IOException {
                return (Location) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
            }

            public static Location parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                return (Location) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
            }

            public static Builder newBuilder() {
                return (Builder) DEFAULT_INSTANCE.toBuilder();
            }

            public static Builder newBuilder(Location location) {
                return (Builder) ((Builder) DEFAULT_INSTANCE.toBuilder()).mergeFrom(location);
            }

            /* compiled from: com.google.firebase:protolite-well-known-types@@16.0.1 */
            public static final class Builder extends GeneratedMessageLite.Builder<Location, Builder> implements LocationOrBuilder {
                private Builder() {
                    super(Location.DEFAULT_INSTANCE);
                }

                public List<Integer> getPathList() {
                    return Collections.unmodifiableList(((Location) this.instance).getPathList());
                }

                public int getPathCount() {
                    return ((Location) this.instance).getPathCount();
                }

                public int getPath(int i) {
                    return ((Location) this.instance).getPath(i);
                }

                public Builder setPath(int i, int i2) {
                    copyOnWrite();
                    ((Location) this.instance).setPath(i, i2);
                    return this;
                }

                public Builder addPath(int i) {
                    copyOnWrite();
                    ((Location) this.instance).addPath(i);
                    return this;
                }

                public Builder addAllPath(Iterable<? extends Integer> iterable) {
                    copyOnWrite();
                    ((Location) this.instance).addAllPath(iterable);
                    return this;
                }

                public Builder clearPath() {
                    copyOnWrite();
                    ((Location) this.instance).clearPath();
                    return this;
                }

                public List<Integer> getSpanList() {
                    return Collections.unmodifiableList(((Location) this.instance).getSpanList());
                }

                public int getSpanCount() {
                    return ((Location) this.instance).getSpanCount();
                }

                public int getSpan(int i) {
                    return ((Location) this.instance).getSpan(i);
                }

                public Builder setSpan(int i, int i2) {
                    copyOnWrite();
                    ((Location) this.instance).setSpan(i, i2);
                    return this;
                }

                public Builder addSpan(int i) {
                    copyOnWrite();
                    ((Location) this.instance).addSpan(i);
                    return this;
                }

                public Builder addAllSpan(Iterable<? extends Integer> iterable) {
                    copyOnWrite();
                    ((Location) this.instance).addAllSpan(iterable);
                    return this;
                }

                public Builder clearSpan() {
                    copyOnWrite();
                    ((Location) this.instance).clearSpan();
                    return this;
                }

                public boolean hasLeadingComments() {
                    return ((Location) this.instance).hasLeadingComments();
                }

                public String getLeadingComments() {
                    return ((Location) this.instance).getLeadingComments();
                }

                public ByteString getLeadingCommentsBytes() {
                    return ((Location) this.instance).getLeadingCommentsBytes();
                }

                public Builder setLeadingComments(String str) {
                    copyOnWrite();
                    ((Location) this.instance).setLeadingComments(str);
                    return this;
                }

                public Builder clearLeadingComments() {
                    copyOnWrite();
                    ((Location) this.instance).clearLeadingComments();
                    return this;
                }

                public Builder setLeadingCommentsBytes(ByteString byteString) {
                    copyOnWrite();
                    ((Location) this.instance).setLeadingCommentsBytes(byteString);
                    return this;
                }

                public boolean hasTrailingComments() {
                    return ((Location) this.instance).hasTrailingComments();
                }

                public String getTrailingComments() {
                    return ((Location) this.instance).getTrailingComments();
                }

                public ByteString getTrailingCommentsBytes() {
                    return ((Location) this.instance).getTrailingCommentsBytes();
                }

                public Builder setTrailingComments(String str) {
                    copyOnWrite();
                    ((Location) this.instance).setTrailingComments(str);
                    return this;
                }

                public Builder clearTrailingComments() {
                    copyOnWrite();
                    ((Location) this.instance).clearTrailingComments();
                    return this;
                }

                public Builder setTrailingCommentsBytes(ByteString byteString) {
                    copyOnWrite();
                    ((Location) this.instance).setTrailingCommentsBytes(byteString);
                    return this;
                }

                public List<String> getLeadingDetachedCommentsList() {
                    return Collections.unmodifiableList(((Location) this.instance).getLeadingDetachedCommentsList());
                }

                public int getLeadingDetachedCommentsCount() {
                    return ((Location) this.instance).getLeadingDetachedCommentsCount();
                }

                public String getLeadingDetachedComments(int i) {
                    return ((Location) this.instance).getLeadingDetachedComments(i);
                }

                public ByteString getLeadingDetachedCommentsBytes(int i) {
                    return ((Location) this.instance).getLeadingDetachedCommentsBytes(i);
                }

                public Builder setLeadingDetachedComments(int i, String str) {
                    copyOnWrite();
                    ((Location) this.instance).setLeadingDetachedComments(i, str);
                    return this;
                }

                public Builder addLeadingDetachedComments(String str) {
                    copyOnWrite();
                    ((Location) this.instance).addLeadingDetachedComments(str);
                    return this;
                }

                public Builder addAllLeadingDetachedComments(Iterable<String> iterable) {
                    copyOnWrite();
                    ((Location) this.instance).addAllLeadingDetachedComments(iterable);
                    return this;
                }

                public Builder clearLeadingDetachedComments() {
                    copyOnWrite();
                    ((Location) this.instance).clearLeadingDetachedComments();
                    return this;
                }

                public Builder addLeadingDetachedCommentsBytes(ByteString byteString) {
                    copyOnWrite();
                    ((Location) this.instance).addLeadingDetachedCommentsBytes(byteString);
                    return this;
                }
            }

            /* access modifiers changed from: protected */
            public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
                switch (methodToInvoke) {
                    case NEW_MUTABLE_INSTANCE:
                        return new Location();
                    case IS_INITIALIZED:
                        return DEFAULT_INSTANCE;
                    case MAKE_IMMUTABLE:
                        this.path_.makeImmutable();
                        this.span_.makeImmutable();
                        this.leadingDetachedComments_.makeImmutable();
                        return null;
                    case NEW_BUILDER:
                        return new Builder();
                    case VISIT:
                        GeneratedMessageLite.Visitor visitor = (GeneratedMessageLite.Visitor) obj;
                        Location location = (Location) obj2;
                        this.path_ = visitor.visitIntList(this.path_, location.path_);
                        this.span_ = visitor.visitIntList(this.span_, location.span_);
                        this.leadingComments_ = visitor.visitString(hasLeadingComments(), this.leadingComments_, location.hasLeadingComments(), location.leadingComments_);
                        this.trailingComments_ = visitor.visitString(hasTrailingComments(), this.trailingComments_, location.hasTrailingComments(), location.trailingComments_);
                        this.leadingDetachedComments_ = visitor.visitList(this.leadingDetachedComments_, location.leadingDetachedComments_);
                        if (visitor == GeneratedMessageLite.MergeFromVisitor.INSTANCE) {
                            this.bitField0_ |= location.bitField0_;
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
                                        if (!this.path_.isModifiable()) {
                                            this.path_ = GeneratedMessageLite.mutableCopy(this.path_);
                                        }
                                        this.path_.addInt(codedInputStream.readInt32());
                                    } else if (readTag == 10) {
                                        int pushLimit = codedInputStream.pushLimit(codedInputStream.readRawVarint32());
                                        if (!this.path_.isModifiable() && codedInputStream.getBytesUntilLimit() > 0) {
                                            this.path_ = GeneratedMessageLite.mutableCopy(this.path_);
                                        }
                                        while (codedInputStream.getBytesUntilLimit() > 0) {
                                            this.path_.addInt(codedInputStream.readInt32());
                                        }
                                        codedInputStream.popLimit(pushLimit);
                                    } else if (readTag == 16) {
                                        if (!this.span_.isModifiable()) {
                                            this.span_ = GeneratedMessageLite.mutableCopy(this.span_);
                                        }
                                        this.span_.addInt(codedInputStream.readInt32());
                                    } else if (readTag == 18) {
                                        int pushLimit2 = codedInputStream.pushLimit(codedInputStream.readRawVarint32());
                                        if (!this.span_.isModifiable() && codedInputStream.getBytesUntilLimit() > 0) {
                                            this.span_ = GeneratedMessageLite.mutableCopy(this.span_);
                                        }
                                        while (codedInputStream.getBytesUntilLimit() > 0) {
                                            this.span_.addInt(codedInputStream.readInt32());
                                        }
                                        codedInputStream.popLimit(pushLimit2);
                                    } else if (readTag == 26) {
                                        String readString = codedInputStream.readString();
                                        this.bitField0_ = 1 | this.bitField0_;
                                        this.leadingComments_ = readString;
                                    } else if (readTag == 34) {
                                        String readString2 = codedInputStream.readString();
                                        this.bitField0_ |= 2;
                                        this.trailingComments_ = readString2;
                                    } else if (readTag == 50) {
                                        String readString3 = codedInputStream.readString();
                                        if (!this.leadingDetachedComments_.isModifiable()) {
                                            this.leadingDetachedComments_ = GeneratedMessageLite.mutableCopy(this.leadingDetachedComments_);
                                        }
                                        this.leadingDetachedComments_.add(readString3);
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
                            synchronized (Location.class) {
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

            public static Location getDefaultInstance() {
                return DEFAULT_INSTANCE;
            }

            public static Parser<Location> parser() {
                return DEFAULT_INSTANCE.getParserForType();
            }
        }

        public List<Location> getLocationList() {
            return this.location_;
        }

        public List<? extends LocationOrBuilder> getLocationOrBuilderList() {
            return this.location_;
        }

        public int getLocationCount() {
            return this.location_.size();
        }

        public Location getLocation(int i) {
            return (Location) this.location_.get(i);
        }

        public LocationOrBuilder getLocationOrBuilder(int i) {
            return (LocationOrBuilder) this.location_.get(i);
        }

        private void ensureLocationIsMutable() {
            if (!this.location_.isModifiable()) {
                this.location_ = GeneratedMessageLite.mutableCopy(this.location_);
            }
        }

        /* access modifiers changed from: private */
        public void setLocation(int i, Location location) {
            if (location != null) {
                ensureLocationIsMutable();
                this.location_.set(i, location);
                return;
            }
            throw new NullPointerException();
        }

        /* access modifiers changed from: private */
        public void setLocation(int i, Location.Builder builder) {
            ensureLocationIsMutable();
            this.location_.set(i, (Location) builder.build());
        }

        /* access modifiers changed from: private */
        public void addLocation(Location location) {
            if (location != null) {
                ensureLocationIsMutable();
                this.location_.add(location);
                return;
            }
            throw new NullPointerException();
        }

        /* access modifiers changed from: private */
        public void addLocation(int i, Location location) {
            if (location != null) {
                ensureLocationIsMutable();
                this.location_.add(i, location);
                return;
            }
            throw new NullPointerException();
        }

        /* access modifiers changed from: private */
        public void addLocation(Location.Builder builder) {
            ensureLocationIsMutable();
            this.location_.add((Location) builder.build());
        }

        /* access modifiers changed from: private */
        public void addLocation(int i, Location.Builder builder) {
            ensureLocationIsMutable();
            this.location_.add(i, (Location) builder.build());
        }

        /* access modifiers changed from: private */
        public void addAllLocation(Iterable<? extends Location> iterable) {
            ensureLocationIsMutable();
            AbstractMessageLite.addAll(iterable, this.location_);
        }

        /* access modifiers changed from: private */
        public void clearLocation() {
            this.location_ = emptyProtobufList();
        }

        /* access modifiers changed from: private */
        public void removeLocation(int i) {
            ensureLocationIsMutable();
            this.location_.remove(i);
        }

        public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
            for (int i = 0; i < this.location_.size(); i++) {
                codedOutputStream.writeMessage(1, (MessageLite) this.location_.get(i));
            }
            this.unknownFields.writeTo(codedOutputStream);
        }

        public int getSerializedSize() {
            int i = this.memoizedSerializedSize;
            if (i != -1) {
                return i;
            }
            int i2 = 0;
            for (int i3 = 0; i3 < this.location_.size(); i3++) {
                i2 += CodedOutputStream.computeMessageSize(1, (MessageLite) this.location_.get(i3));
            }
            int serializedSize = i2 + this.unknownFields.getSerializedSize();
            this.memoizedSerializedSize = serializedSize;
            return serializedSize;
        }

        public static SourceCodeInfo parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return (SourceCodeInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
        }

        public static SourceCodeInfo parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (SourceCodeInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
        }

        public static SourceCodeInfo parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return (SourceCodeInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
        }

        public static SourceCodeInfo parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (SourceCodeInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
        }

        public static SourceCodeInfo parseFrom(InputStream inputStream) throws IOException {
            return (SourceCodeInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static SourceCodeInfo parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (SourceCodeInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static SourceCodeInfo parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (SourceCodeInfo) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static SourceCodeInfo parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (SourceCodeInfo) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static SourceCodeInfo parseFrom(CodedInputStream codedInputStream) throws IOException {
            return (SourceCodeInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
        }

        public static SourceCodeInfo parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (SourceCodeInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
        }

        public static Builder newBuilder() {
            return (Builder) DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(SourceCodeInfo sourceCodeInfo) {
            return (Builder) ((Builder) DEFAULT_INSTANCE.toBuilder()).mergeFrom(sourceCodeInfo);
        }

        /* compiled from: com.google.firebase:protolite-well-known-types@@16.0.1 */
        public static final class Builder extends GeneratedMessageLite.Builder<SourceCodeInfo, Builder> implements SourceCodeInfoOrBuilder {
            private Builder() {
                super(SourceCodeInfo.DEFAULT_INSTANCE);
            }

            public List<Location> getLocationList() {
                return Collections.unmodifiableList(((SourceCodeInfo) this.instance).getLocationList());
            }

            public int getLocationCount() {
                return ((SourceCodeInfo) this.instance).getLocationCount();
            }

            public Location getLocation(int i) {
                return ((SourceCodeInfo) this.instance).getLocation(i);
            }

            public Builder setLocation(int i, Location location) {
                copyOnWrite();
                ((SourceCodeInfo) this.instance).setLocation(i, location);
                return this;
            }

            public Builder setLocation(int i, Location.Builder builder) {
                copyOnWrite();
                ((SourceCodeInfo) this.instance).setLocation(i, builder);
                return this;
            }

            public Builder addLocation(Location location) {
                copyOnWrite();
                ((SourceCodeInfo) this.instance).addLocation(location);
                return this;
            }

            public Builder addLocation(int i, Location location) {
                copyOnWrite();
                ((SourceCodeInfo) this.instance).addLocation(i, location);
                return this;
            }

            public Builder addLocation(Location.Builder builder) {
                copyOnWrite();
                ((SourceCodeInfo) this.instance).addLocation(builder);
                return this;
            }

            public Builder addLocation(int i, Location.Builder builder) {
                copyOnWrite();
                ((SourceCodeInfo) this.instance).addLocation(i, builder);
                return this;
            }

            public Builder addAllLocation(Iterable<? extends Location> iterable) {
                copyOnWrite();
                ((SourceCodeInfo) this.instance).addAllLocation(iterable);
                return this;
            }

            public Builder clearLocation() {
                copyOnWrite();
                ((SourceCodeInfo) this.instance).clearLocation();
                return this;
            }

            public Builder removeLocation(int i) {
                copyOnWrite();
                ((SourceCodeInfo) this.instance).removeLocation(i);
                return this;
            }
        }

        /* access modifiers changed from: protected */
        public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            switch (methodToInvoke) {
                case NEW_MUTABLE_INSTANCE:
                    return new SourceCodeInfo();
                case IS_INITIALIZED:
                    return DEFAULT_INSTANCE;
                case MAKE_IMMUTABLE:
                    this.location_.makeImmutable();
                    return null;
                case NEW_BUILDER:
                    return new Builder();
                case VISIT:
                    this.location_ = ((GeneratedMessageLite.Visitor) obj).visitList(this.location_, ((SourceCodeInfo) obj2).location_);
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
                                    if (!this.location_.isModifiable()) {
                                        this.location_ = GeneratedMessageLite.mutableCopy(this.location_);
                                    }
                                    this.location_.add((Location) codedInputStream.readMessage(Location.parser(), extensionRegistryLite));
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
                        synchronized (SourceCodeInfo.class) {
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

        public static SourceCodeInfo getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<SourceCodeInfo> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }
    }

    /* compiled from: com.google.firebase:protolite-well-known-types@@16.0.1 */
    public static final class GeneratedCodeInfo extends GeneratedMessageLite<GeneratedCodeInfo, Builder> implements GeneratedCodeInfoOrBuilder {
        public static final int ANNOTATION_FIELD_NUMBER = 1;
        /* access modifiers changed from: private */
        public static final GeneratedCodeInfo DEFAULT_INSTANCE = new GeneratedCodeInfo();
        private static volatile Parser<GeneratedCodeInfo> PARSER;
        private Internal.ProtobufList<Annotation> annotation_ = emptyProtobufList();

        /* compiled from: com.google.firebase:protolite-well-known-types@@16.0.1 */
        public interface AnnotationOrBuilder extends MessageLiteOrBuilder {
            int getBegin();

            int getEnd();

            int getPath(int i);

            int getPathCount();

            List<Integer> getPathList();

            String getSourceFile();

            ByteString getSourceFileBytes();

            boolean hasBegin();

            boolean hasEnd();

            boolean hasSourceFile();
        }

        private GeneratedCodeInfo() {
        }

        /* compiled from: com.google.firebase:protolite-well-known-types@@16.0.1 */
        public static final class Annotation extends GeneratedMessageLite<Annotation, Builder> implements AnnotationOrBuilder {
            public static final int BEGIN_FIELD_NUMBER = 3;
            /* access modifiers changed from: private */
            public static final Annotation DEFAULT_INSTANCE = new Annotation();
            public static final int END_FIELD_NUMBER = 4;
            private static volatile Parser<Annotation> PARSER = null;
            public static final int PATH_FIELD_NUMBER = 1;
            public static final int SOURCE_FILE_FIELD_NUMBER = 2;
            private int begin_;
            private int bitField0_;
            private int end_;
            private int pathMemoizedSerializedSize = -1;
            private Internal.IntList path_ = emptyIntList();
            private String sourceFile_ = "";

            private Annotation() {
            }

            public List<Integer> getPathList() {
                return this.path_;
            }

            public int getPathCount() {
                return this.path_.size();
            }

            public int getPath(int i) {
                return this.path_.getInt(i);
            }

            private void ensurePathIsMutable() {
                if (!this.path_.isModifiable()) {
                    this.path_ = GeneratedMessageLite.mutableCopy(this.path_);
                }
            }

            /* access modifiers changed from: private */
            public void setPath(int i, int i2) {
                ensurePathIsMutable();
                this.path_.setInt(i, i2);
            }

            /* access modifiers changed from: private */
            public void addPath(int i) {
                ensurePathIsMutable();
                this.path_.addInt(i);
            }

            /* access modifiers changed from: private */
            public void addAllPath(Iterable<? extends Integer> iterable) {
                ensurePathIsMutable();
                AbstractMessageLite.addAll(iterable, this.path_);
            }

            /* access modifiers changed from: private */
            public void clearPath() {
                this.path_ = emptyIntList();
            }

            public boolean hasSourceFile() {
                return (this.bitField0_ & 1) == 1;
            }

            public String getSourceFile() {
                return this.sourceFile_;
            }

            public ByteString getSourceFileBytes() {
                return ByteString.copyFromUtf8(this.sourceFile_);
            }

            /* access modifiers changed from: private */
            public void setSourceFile(String str) {
                if (str != null) {
                    this.bitField0_ |= 1;
                    this.sourceFile_ = str;
                    return;
                }
                throw new NullPointerException();
            }

            /* access modifiers changed from: private */
            public void clearSourceFile() {
                this.bitField0_ &= -2;
                this.sourceFile_ = getDefaultInstance().getSourceFile();
            }

            /* access modifiers changed from: private */
            public void setSourceFileBytes(ByteString byteString) {
                if (byteString != null) {
                    this.bitField0_ |= 1;
                    this.sourceFile_ = byteString.toStringUtf8();
                    return;
                }
                throw new NullPointerException();
            }

            public boolean hasBegin() {
                return (this.bitField0_ & 2) == 2;
            }

            public int getBegin() {
                return this.begin_;
            }

            /* access modifiers changed from: private */
            public void setBegin(int i) {
                this.bitField0_ |= 2;
                this.begin_ = i;
            }

            /* access modifiers changed from: private */
            public void clearBegin() {
                this.bitField0_ &= -3;
                this.begin_ = 0;
            }

            public boolean hasEnd() {
                return (this.bitField0_ & 4) == 4;
            }

            public int getEnd() {
                return this.end_;
            }

            /* access modifiers changed from: private */
            public void setEnd(int i) {
                this.bitField0_ |= 4;
                this.end_ = i;
            }

            /* access modifiers changed from: private */
            public void clearEnd() {
                this.bitField0_ &= -5;
                this.end_ = 0;
            }

            public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
                getSerializedSize();
                if (getPathList().size() > 0) {
                    codedOutputStream.writeUInt32NoTag(10);
                    codedOutputStream.writeUInt32NoTag(this.pathMemoizedSerializedSize);
                }
                for (int i = 0; i < this.path_.size(); i++) {
                    codedOutputStream.writeInt32NoTag(this.path_.getInt(i));
                }
                if ((this.bitField0_ & 1) == 1) {
                    codedOutputStream.writeString(2, getSourceFile());
                }
                if ((this.bitField0_ & 2) == 2) {
                    codedOutputStream.writeInt32(3, this.begin_);
                }
                if ((this.bitField0_ & 4) == 4) {
                    codedOutputStream.writeInt32(4, this.end_);
                }
                this.unknownFields.writeTo(codedOutputStream);
            }

            public int getSerializedSize() {
                int i = this.memoizedSerializedSize;
                if (i != -1) {
                    return i;
                }
                int i2 = 0;
                for (int i3 = 0; i3 < this.path_.size(); i3++) {
                    i2 += CodedOutputStream.computeInt32SizeNoTag(this.path_.getInt(i3));
                }
                int i4 = 0 + i2;
                if (!getPathList().isEmpty()) {
                    i4 = i4 + 1 + CodedOutputStream.computeInt32SizeNoTag(i2);
                }
                this.pathMemoizedSerializedSize = i2;
                if ((this.bitField0_ & 1) == 1) {
                    i4 += CodedOutputStream.computeStringSize(2, getSourceFile());
                }
                if ((this.bitField0_ & 2) == 2) {
                    i4 += CodedOutputStream.computeInt32Size(3, this.begin_);
                }
                if ((this.bitField0_ & 4) == 4) {
                    i4 += CodedOutputStream.computeInt32Size(4, this.end_);
                }
                int serializedSize = i4 + this.unknownFields.getSerializedSize();
                this.memoizedSerializedSize = serializedSize;
                return serializedSize;
            }

            public static Annotation parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
                return (Annotation) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
            }

            public static Annotation parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return (Annotation) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
            }

            public static Annotation parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
                return (Annotation) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
            }

            public static Annotation parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return (Annotation) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
            }

            public static Annotation parseFrom(InputStream inputStream) throws IOException {
                return (Annotation) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
            }

            public static Annotation parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                return (Annotation) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
            }

            public static Annotation parseDelimitedFrom(InputStream inputStream) throws IOException {
                return (Annotation) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
            }

            public static Annotation parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                return (Annotation) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
            }

            public static Annotation parseFrom(CodedInputStream codedInputStream) throws IOException {
                return (Annotation) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
            }

            public static Annotation parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                return (Annotation) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
            }

            public static Builder newBuilder() {
                return (Builder) DEFAULT_INSTANCE.toBuilder();
            }

            public static Builder newBuilder(Annotation annotation) {
                return (Builder) ((Builder) DEFAULT_INSTANCE.toBuilder()).mergeFrom(annotation);
            }

            /* compiled from: com.google.firebase:protolite-well-known-types@@16.0.1 */
            public static final class Builder extends GeneratedMessageLite.Builder<Annotation, Builder> implements AnnotationOrBuilder {
                private Builder() {
                    super(Annotation.DEFAULT_INSTANCE);
                }

                public List<Integer> getPathList() {
                    return Collections.unmodifiableList(((Annotation) this.instance).getPathList());
                }

                public int getPathCount() {
                    return ((Annotation) this.instance).getPathCount();
                }

                public int getPath(int i) {
                    return ((Annotation) this.instance).getPath(i);
                }

                public Builder setPath(int i, int i2) {
                    copyOnWrite();
                    ((Annotation) this.instance).setPath(i, i2);
                    return this;
                }

                public Builder addPath(int i) {
                    copyOnWrite();
                    ((Annotation) this.instance).addPath(i);
                    return this;
                }

                public Builder addAllPath(Iterable<? extends Integer> iterable) {
                    copyOnWrite();
                    ((Annotation) this.instance).addAllPath(iterable);
                    return this;
                }

                public Builder clearPath() {
                    copyOnWrite();
                    ((Annotation) this.instance).clearPath();
                    return this;
                }

                public boolean hasSourceFile() {
                    return ((Annotation) this.instance).hasSourceFile();
                }

                public String getSourceFile() {
                    return ((Annotation) this.instance).getSourceFile();
                }

                public ByteString getSourceFileBytes() {
                    return ((Annotation) this.instance).getSourceFileBytes();
                }

                public Builder setSourceFile(String str) {
                    copyOnWrite();
                    ((Annotation) this.instance).setSourceFile(str);
                    return this;
                }

                public Builder clearSourceFile() {
                    copyOnWrite();
                    ((Annotation) this.instance).clearSourceFile();
                    return this;
                }

                public Builder setSourceFileBytes(ByteString byteString) {
                    copyOnWrite();
                    ((Annotation) this.instance).setSourceFileBytes(byteString);
                    return this;
                }

                public boolean hasBegin() {
                    return ((Annotation) this.instance).hasBegin();
                }

                public int getBegin() {
                    return ((Annotation) this.instance).getBegin();
                }

                public Builder setBegin(int i) {
                    copyOnWrite();
                    ((Annotation) this.instance).setBegin(i);
                    return this;
                }

                public Builder clearBegin() {
                    copyOnWrite();
                    ((Annotation) this.instance).clearBegin();
                    return this;
                }

                public boolean hasEnd() {
                    return ((Annotation) this.instance).hasEnd();
                }

                public int getEnd() {
                    return ((Annotation) this.instance).getEnd();
                }

                public Builder setEnd(int i) {
                    copyOnWrite();
                    ((Annotation) this.instance).setEnd(i);
                    return this;
                }

                public Builder clearEnd() {
                    copyOnWrite();
                    ((Annotation) this.instance).clearEnd();
                    return this;
                }
            }

            /* access modifiers changed from: protected */
            public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
                switch (methodToInvoke) {
                    case NEW_MUTABLE_INSTANCE:
                        return new Annotation();
                    case IS_INITIALIZED:
                        return DEFAULT_INSTANCE;
                    case MAKE_IMMUTABLE:
                        this.path_.makeImmutable();
                        return null;
                    case NEW_BUILDER:
                        return new Builder();
                    case VISIT:
                        GeneratedMessageLite.Visitor visitor = (GeneratedMessageLite.Visitor) obj;
                        Annotation annotation = (Annotation) obj2;
                        this.path_ = visitor.visitIntList(this.path_, annotation.path_);
                        this.sourceFile_ = visitor.visitString(hasSourceFile(), this.sourceFile_, annotation.hasSourceFile(), annotation.sourceFile_);
                        this.begin_ = visitor.visitInt(hasBegin(), this.begin_, annotation.hasBegin(), annotation.begin_);
                        this.end_ = visitor.visitInt(hasEnd(), this.end_, annotation.hasEnd(), annotation.end_);
                        if (visitor == GeneratedMessageLite.MergeFromVisitor.INSTANCE) {
                            this.bitField0_ |= annotation.bitField0_;
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
                                        if (!this.path_.isModifiable()) {
                                            this.path_ = GeneratedMessageLite.mutableCopy(this.path_);
                                        }
                                        this.path_.addInt(codedInputStream.readInt32());
                                    } else if (readTag == 10) {
                                        int pushLimit = codedInputStream.pushLimit(codedInputStream.readRawVarint32());
                                        if (!this.path_.isModifiable() && codedInputStream.getBytesUntilLimit() > 0) {
                                            this.path_ = GeneratedMessageLite.mutableCopy(this.path_);
                                        }
                                        while (codedInputStream.getBytesUntilLimit() > 0) {
                                            this.path_.addInt(codedInputStream.readInt32());
                                        }
                                        codedInputStream.popLimit(pushLimit);
                                    } else if (readTag == 18) {
                                        String readString = codedInputStream.readString();
                                        this.bitField0_ = 1 | this.bitField0_;
                                        this.sourceFile_ = readString;
                                    } else if (readTag == 24) {
                                        this.bitField0_ |= 2;
                                        this.begin_ = codedInputStream.readInt32();
                                    } else if (readTag == 32) {
                                        this.bitField0_ |= 4;
                                        this.end_ = codedInputStream.readInt32();
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
                            synchronized (Annotation.class) {
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

            public static Annotation getDefaultInstance() {
                return DEFAULT_INSTANCE;
            }

            public static Parser<Annotation> parser() {
                return DEFAULT_INSTANCE.getParserForType();
            }
        }

        public List<Annotation> getAnnotationList() {
            return this.annotation_;
        }

        public List<? extends AnnotationOrBuilder> getAnnotationOrBuilderList() {
            return this.annotation_;
        }

        public int getAnnotationCount() {
            return this.annotation_.size();
        }

        public Annotation getAnnotation(int i) {
            return (Annotation) this.annotation_.get(i);
        }

        public AnnotationOrBuilder getAnnotationOrBuilder(int i) {
            return (AnnotationOrBuilder) this.annotation_.get(i);
        }

        private void ensureAnnotationIsMutable() {
            if (!this.annotation_.isModifiable()) {
                this.annotation_ = GeneratedMessageLite.mutableCopy(this.annotation_);
            }
        }

        /* access modifiers changed from: private */
        public void setAnnotation(int i, Annotation annotation) {
            if (annotation != null) {
                ensureAnnotationIsMutable();
                this.annotation_.set(i, annotation);
                return;
            }
            throw new NullPointerException();
        }

        /* access modifiers changed from: private */
        public void setAnnotation(int i, Annotation.Builder builder) {
            ensureAnnotationIsMutable();
            this.annotation_.set(i, (Annotation) builder.build());
        }

        /* access modifiers changed from: private */
        public void addAnnotation(Annotation annotation) {
            if (annotation != null) {
                ensureAnnotationIsMutable();
                this.annotation_.add(annotation);
                return;
            }
            throw new NullPointerException();
        }

        /* access modifiers changed from: private */
        public void addAnnotation(int i, Annotation annotation) {
            if (annotation != null) {
                ensureAnnotationIsMutable();
                this.annotation_.add(i, annotation);
                return;
            }
            throw new NullPointerException();
        }

        /* access modifiers changed from: private */
        public void addAnnotation(Annotation.Builder builder) {
            ensureAnnotationIsMutable();
            this.annotation_.add((Annotation) builder.build());
        }

        /* access modifiers changed from: private */
        public void addAnnotation(int i, Annotation.Builder builder) {
            ensureAnnotationIsMutable();
            this.annotation_.add(i, (Annotation) builder.build());
        }

        /* access modifiers changed from: private */
        public void addAllAnnotation(Iterable<? extends Annotation> iterable) {
            ensureAnnotationIsMutable();
            AbstractMessageLite.addAll(iterable, this.annotation_);
        }

        /* access modifiers changed from: private */
        public void clearAnnotation() {
            this.annotation_ = emptyProtobufList();
        }

        /* access modifiers changed from: private */
        public void removeAnnotation(int i) {
            ensureAnnotationIsMutable();
            this.annotation_.remove(i);
        }

        public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
            for (int i = 0; i < this.annotation_.size(); i++) {
                codedOutputStream.writeMessage(1, (MessageLite) this.annotation_.get(i));
            }
            this.unknownFields.writeTo(codedOutputStream);
        }

        public int getSerializedSize() {
            int i = this.memoizedSerializedSize;
            if (i != -1) {
                return i;
            }
            int i2 = 0;
            for (int i3 = 0; i3 < this.annotation_.size(); i3++) {
                i2 += CodedOutputStream.computeMessageSize(1, (MessageLite) this.annotation_.get(i3));
            }
            int serializedSize = i2 + this.unknownFields.getSerializedSize();
            this.memoizedSerializedSize = serializedSize;
            return serializedSize;
        }

        public static GeneratedCodeInfo parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return (GeneratedCodeInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
        }

        public static GeneratedCodeInfo parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (GeneratedCodeInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
        }

        public static GeneratedCodeInfo parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return (GeneratedCodeInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
        }

        public static GeneratedCodeInfo parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (GeneratedCodeInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
        }

        public static GeneratedCodeInfo parseFrom(InputStream inputStream) throws IOException {
            return (GeneratedCodeInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static GeneratedCodeInfo parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (GeneratedCodeInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static GeneratedCodeInfo parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (GeneratedCodeInfo) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static GeneratedCodeInfo parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (GeneratedCodeInfo) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static GeneratedCodeInfo parseFrom(CodedInputStream codedInputStream) throws IOException {
            return (GeneratedCodeInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
        }

        public static GeneratedCodeInfo parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (GeneratedCodeInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
        }

        public static Builder newBuilder() {
            return (Builder) DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(GeneratedCodeInfo generatedCodeInfo) {
            return (Builder) ((Builder) DEFAULT_INSTANCE.toBuilder()).mergeFrom(generatedCodeInfo);
        }

        /* compiled from: com.google.firebase:protolite-well-known-types@@16.0.1 */
        public static final class Builder extends GeneratedMessageLite.Builder<GeneratedCodeInfo, Builder> implements GeneratedCodeInfoOrBuilder {
            private Builder() {
                super(GeneratedCodeInfo.DEFAULT_INSTANCE);
            }

            public List<Annotation> getAnnotationList() {
                return Collections.unmodifiableList(((GeneratedCodeInfo) this.instance).getAnnotationList());
            }

            public int getAnnotationCount() {
                return ((GeneratedCodeInfo) this.instance).getAnnotationCount();
            }

            public Annotation getAnnotation(int i) {
                return ((GeneratedCodeInfo) this.instance).getAnnotation(i);
            }

            public Builder setAnnotation(int i, Annotation annotation) {
                copyOnWrite();
                ((GeneratedCodeInfo) this.instance).setAnnotation(i, annotation);
                return this;
            }

            public Builder setAnnotation(int i, Annotation.Builder builder) {
                copyOnWrite();
                ((GeneratedCodeInfo) this.instance).setAnnotation(i, builder);
                return this;
            }

            public Builder addAnnotation(Annotation annotation) {
                copyOnWrite();
                ((GeneratedCodeInfo) this.instance).addAnnotation(annotation);
                return this;
            }

            public Builder addAnnotation(int i, Annotation annotation) {
                copyOnWrite();
                ((GeneratedCodeInfo) this.instance).addAnnotation(i, annotation);
                return this;
            }

            public Builder addAnnotation(Annotation.Builder builder) {
                copyOnWrite();
                ((GeneratedCodeInfo) this.instance).addAnnotation(builder);
                return this;
            }

            public Builder addAnnotation(int i, Annotation.Builder builder) {
                copyOnWrite();
                ((GeneratedCodeInfo) this.instance).addAnnotation(i, builder);
                return this;
            }

            public Builder addAllAnnotation(Iterable<? extends Annotation> iterable) {
                copyOnWrite();
                ((GeneratedCodeInfo) this.instance).addAllAnnotation(iterable);
                return this;
            }

            public Builder clearAnnotation() {
                copyOnWrite();
                ((GeneratedCodeInfo) this.instance).clearAnnotation();
                return this;
            }

            public Builder removeAnnotation(int i) {
                copyOnWrite();
                ((GeneratedCodeInfo) this.instance).removeAnnotation(i);
                return this;
            }
        }

        /* access modifiers changed from: protected */
        public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            switch (methodToInvoke) {
                case NEW_MUTABLE_INSTANCE:
                    return new GeneratedCodeInfo();
                case IS_INITIALIZED:
                    return DEFAULT_INSTANCE;
                case MAKE_IMMUTABLE:
                    this.annotation_.makeImmutable();
                    return null;
                case NEW_BUILDER:
                    return new Builder();
                case VISIT:
                    this.annotation_ = ((GeneratedMessageLite.Visitor) obj).visitList(this.annotation_, ((GeneratedCodeInfo) obj2).annotation_);
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
                                    if (!this.annotation_.isModifiable()) {
                                        this.annotation_ = GeneratedMessageLite.mutableCopy(this.annotation_);
                                    }
                                    this.annotation_.add((Annotation) codedInputStream.readMessage(Annotation.parser(), extensionRegistryLite));
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
                        synchronized (GeneratedCodeInfo.class) {
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

        public static GeneratedCodeInfo getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<GeneratedCodeInfo> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }
    }
}
