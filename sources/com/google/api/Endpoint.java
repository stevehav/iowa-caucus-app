package com.google.api;

import com.google.protobuf.AbstractMessageLite;
import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.Internal;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.Parser;
import java.io.IOException;
import java.io.InputStream;
import java.util.Collections;
import java.util.List;

/* compiled from: com.google.firebase:protolite-well-known-types@@16.0.1 */
public final class Endpoint extends GeneratedMessageLite<Endpoint, Builder> implements EndpointOrBuilder {
    public static final int ALIASES_FIELD_NUMBER = 2;
    public static final int ALLOW_CORS_FIELD_NUMBER = 5;
    public static final int APIS_FIELD_NUMBER = 3;
    /* access modifiers changed from: private */
    public static final Endpoint DEFAULT_INSTANCE = new Endpoint();
    public static final int FEATURES_FIELD_NUMBER = 4;
    public static final int NAME_FIELD_NUMBER = 1;
    private static volatile Parser<Endpoint> PARSER = null;
    public static final int TARGET_FIELD_NUMBER = 101;
    private Internal.ProtobufList<String> aliases_ = GeneratedMessageLite.emptyProtobufList();
    private boolean allowCors_;
    private Internal.ProtobufList<String> apis_ = GeneratedMessageLite.emptyProtobufList();
    private int bitField0_;
    private Internal.ProtobufList<String> features_ = GeneratedMessageLite.emptyProtobufList();
    private String name_ = "";
    private String target_ = "";

    private Endpoint() {
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
            this.name_ = str;
            return;
        }
        throw new NullPointerException();
    }

    /* access modifiers changed from: private */
    public void clearName() {
        this.name_ = getDefaultInstance().getName();
    }

    /* access modifiers changed from: private */
    public void setNameBytes(ByteString byteString) {
        if (byteString != null) {
            checkByteStringIsUtf8(byteString);
            this.name_ = byteString.toStringUtf8();
            return;
        }
        throw new NullPointerException();
    }

    public List<String> getAliasesList() {
        return this.aliases_;
    }

    public int getAliasesCount() {
        return this.aliases_.size();
    }

    public String getAliases(int i) {
        return (String) this.aliases_.get(i);
    }

    public ByteString getAliasesBytes(int i) {
        return ByteString.copyFromUtf8((String) this.aliases_.get(i));
    }

    private void ensureAliasesIsMutable() {
        if (!this.aliases_.isModifiable()) {
            this.aliases_ = GeneratedMessageLite.mutableCopy(this.aliases_);
        }
    }

    /* access modifiers changed from: private */
    public void setAliases(int i, String str) {
        if (str != null) {
            ensureAliasesIsMutable();
            this.aliases_.set(i, str);
            return;
        }
        throw new NullPointerException();
    }

    /* access modifiers changed from: private */
    public void addAliases(String str) {
        if (str != null) {
            ensureAliasesIsMutable();
            this.aliases_.add(str);
            return;
        }
        throw new NullPointerException();
    }

    /* access modifiers changed from: private */
    public void addAllAliases(Iterable<String> iterable) {
        ensureAliasesIsMutable();
        AbstractMessageLite.addAll(iterable, this.aliases_);
    }

    /* access modifiers changed from: private */
    public void clearAliases() {
        this.aliases_ = GeneratedMessageLite.emptyProtobufList();
    }

    /* access modifiers changed from: private */
    public void addAliasesBytes(ByteString byteString) {
        if (byteString != null) {
            checkByteStringIsUtf8(byteString);
            ensureAliasesIsMutable();
            this.aliases_.add(byteString.toStringUtf8());
            return;
        }
        throw new NullPointerException();
    }

    public List<String> getApisList() {
        return this.apis_;
    }

    public int getApisCount() {
        return this.apis_.size();
    }

    public String getApis(int i) {
        return (String) this.apis_.get(i);
    }

    public ByteString getApisBytes(int i) {
        return ByteString.copyFromUtf8((String) this.apis_.get(i));
    }

    private void ensureApisIsMutable() {
        if (!this.apis_.isModifiable()) {
            this.apis_ = GeneratedMessageLite.mutableCopy(this.apis_);
        }
    }

    /* access modifiers changed from: private */
    public void setApis(int i, String str) {
        if (str != null) {
            ensureApisIsMutable();
            this.apis_.set(i, str);
            return;
        }
        throw new NullPointerException();
    }

    /* access modifiers changed from: private */
    public void addApis(String str) {
        if (str != null) {
            ensureApisIsMutable();
            this.apis_.add(str);
            return;
        }
        throw new NullPointerException();
    }

    /* access modifiers changed from: private */
    public void addAllApis(Iterable<String> iterable) {
        ensureApisIsMutable();
        AbstractMessageLite.addAll(iterable, this.apis_);
    }

    /* access modifiers changed from: private */
    public void clearApis() {
        this.apis_ = GeneratedMessageLite.emptyProtobufList();
    }

    /* access modifiers changed from: private */
    public void addApisBytes(ByteString byteString) {
        if (byteString != null) {
            checkByteStringIsUtf8(byteString);
            ensureApisIsMutable();
            this.apis_.add(byteString.toStringUtf8());
            return;
        }
        throw new NullPointerException();
    }

    public List<String> getFeaturesList() {
        return this.features_;
    }

    public int getFeaturesCount() {
        return this.features_.size();
    }

    public String getFeatures(int i) {
        return (String) this.features_.get(i);
    }

    public ByteString getFeaturesBytes(int i) {
        return ByteString.copyFromUtf8((String) this.features_.get(i));
    }

    private void ensureFeaturesIsMutable() {
        if (!this.features_.isModifiable()) {
            this.features_ = GeneratedMessageLite.mutableCopy(this.features_);
        }
    }

    /* access modifiers changed from: private */
    public void setFeatures(int i, String str) {
        if (str != null) {
            ensureFeaturesIsMutable();
            this.features_.set(i, str);
            return;
        }
        throw new NullPointerException();
    }

    /* access modifiers changed from: private */
    public void addFeatures(String str) {
        if (str != null) {
            ensureFeaturesIsMutable();
            this.features_.add(str);
            return;
        }
        throw new NullPointerException();
    }

    /* access modifiers changed from: private */
    public void addAllFeatures(Iterable<String> iterable) {
        ensureFeaturesIsMutable();
        AbstractMessageLite.addAll(iterable, this.features_);
    }

    /* access modifiers changed from: private */
    public void clearFeatures() {
        this.features_ = GeneratedMessageLite.emptyProtobufList();
    }

    /* access modifiers changed from: private */
    public void addFeaturesBytes(ByteString byteString) {
        if (byteString != null) {
            checkByteStringIsUtf8(byteString);
            ensureFeaturesIsMutable();
            this.features_.add(byteString.toStringUtf8());
            return;
        }
        throw new NullPointerException();
    }

    public String getTarget() {
        return this.target_;
    }

    public ByteString getTargetBytes() {
        return ByteString.copyFromUtf8(this.target_);
    }

    /* access modifiers changed from: private */
    public void setTarget(String str) {
        if (str != null) {
            this.target_ = str;
            return;
        }
        throw new NullPointerException();
    }

    /* access modifiers changed from: private */
    public void clearTarget() {
        this.target_ = getDefaultInstance().getTarget();
    }

    /* access modifiers changed from: private */
    public void setTargetBytes(ByteString byteString) {
        if (byteString != null) {
            checkByteStringIsUtf8(byteString);
            this.target_ = byteString.toStringUtf8();
            return;
        }
        throw new NullPointerException();
    }

    public boolean getAllowCors() {
        return this.allowCors_;
    }

    /* access modifiers changed from: private */
    public void setAllowCors(boolean z) {
        this.allowCors_ = z;
    }

    /* access modifiers changed from: private */
    public void clearAllowCors() {
        this.allowCors_ = false;
    }

    public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
        if (!this.name_.isEmpty()) {
            codedOutputStream.writeString(1, getName());
        }
        for (int i = 0; i < this.aliases_.size(); i++) {
            codedOutputStream.writeString(2, (String) this.aliases_.get(i));
        }
        for (int i2 = 0; i2 < this.apis_.size(); i2++) {
            codedOutputStream.writeString(3, (String) this.apis_.get(i2));
        }
        for (int i3 = 0; i3 < this.features_.size(); i3++) {
            codedOutputStream.writeString(4, (String) this.features_.get(i3));
        }
        boolean z = this.allowCors_;
        if (z) {
            codedOutputStream.writeBool(5, z);
        }
        if (!this.target_.isEmpty()) {
            codedOutputStream.writeString(101, getTarget());
        }
    }

    public int getSerializedSize() {
        int i = this.memoizedSerializedSize;
        if (i != -1) {
            return i;
        }
        int computeStringSize = !this.name_.isEmpty() ? CodedOutputStream.computeStringSize(1, getName()) + 0 : 0;
        int i2 = 0;
        for (int i3 = 0; i3 < this.aliases_.size(); i3++) {
            i2 += CodedOutputStream.computeStringSizeNoTag((String) this.aliases_.get(i3));
        }
        int size = computeStringSize + i2 + (getAliasesList().size() * 1);
        int i4 = 0;
        for (int i5 = 0; i5 < this.apis_.size(); i5++) {
            i4 += CodedOutputStream.computeStringSizeNoTag((String) this.apis_.get(i5));
        }
        int size2 = size + i4 + (getApisList().size() * 1);
        int i6 = 0;
        for (int i7 = 0; i7 < this.features_.size(); i7++) {
            i6 += CodedOutputStream.computeStringSizeNoTag((String) this.features_.get(i7));
        }
        int size3 = size2 + i6 + (getFeaturesList().size() * 1);
        boolean z = this.allowCors_;
        if (z) {
            size3 += CodedOutputStream.computeBoolSize(5, z);
        }
        if (!this.target_.isEmpty()) {
            size3 += CodedOutputStream.computeStringSize(101, getTarget());
        }
        this.memoizedSerializedSize = size3;
        return size3;
    }

    public static Endpoint parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
        return (Endpoint) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
    }

    public static Endpoint parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (Endpoint) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }

    public static Endpoint parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
        return (Endpoint) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static Endpoint parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (Endpoint) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
    }

    public static Endpoint parseFrom(InputStream inputStream) throws IOException {
        return (Endpoint) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static Endpoint parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (Endpoint) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static Endpoint parseDelimitedFrom(InputStream inputStream) throws IOException {
        return (Endpoint) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static Endpoint parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (Endpoint) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static Endpoint parseFrom(CodedInputStream codedInputStream) throws IOException {
        return (Endpoint) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
    }

    public static Endpoint parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (Endpoint) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
    }

    public static Builder newBuilder() {
        return (Builder) DEFAULT_INSTANCE.toBuilder();
    }

    public static Builder newBuilder(Endpoint endpoint) {
        return (Builder) ((Builder) DEFAULT_INSTANCE.toBuilder()).mergeFrom(endpoint);
    }

    /* compiled from: com.google.firebase:protolite-well-known-types@@16.0.1 */
    public static final class Builder extends GeneratedMessageLite.Builder<Endpoint, Builder> implements EndpointOrBuilder {
        private Builder() {
            super(Endpoint.DEFAULT_INSTANCE);
        }

        public String getName() {
            return ((Endpoint) this.instance).getName();
        }

        public ByteString getNameBytes() {
            return ((Endpoint) this.instance).getNameBytes();
        }

        public Builder setName(String str) {
            copyOnWrite();
            ((Endpoint) this.instance).setName(str);
            return this;
        }

        public Builder clearName() {
            copyOnWrite();
            ((Endpoint) this.instance).clearName();
            return this;
        }

        public Builder setNameBytes(ByteString byteString) {
            copyOnWrite();
            ((Endpoint) this.instance).setNameBytes(byteString);
            return this;
        }

        public List<String> getAliasesList() {
            return Collections.unmodifiableList(((Endpoint) this.instance).getAliasesList());
        }

        public int getAliasesCount() {
            return ((Endpoint) this.instance).getAliasesCount();
        }

        public String getAliases(int i) {
            return ((Endpoint) this.instance).getAliases(i);
        }

        public ByteString getAliasesBytes(int i) {
            return ((Endpoint) this.instance).getAliasesBytes(i);
        }

        public Builder setAliases(int i, String str) {
            copyOnWrite();
            ((Endpoint) this.instance).setAliases(i, str);
            return this;
        }

        public Builder addAliases(String str) {
            copyOnWrite();
            ((Endpoint) this.instance).addAliases(str);
            return this;
        }

        public Builder addAllAliases(Iterable<String> iterable) {
            copyOnWrite();
            ((Endpoint) this.instance).addAllAliases(iterable);
            return this;
        }

        public Builder clearAliases() {
            copyOnWrite();
            ((Endpoint) this.instance).clearAliases();
            return this;
        }

        public Builder addAliasesBytes(ByteString byteString) {
            copyOnWrite();
            ((Endpoint) this.instance).addAliasesBytes(byteString);
            return this;
        }

        public List<String> getApisList() {
            return Collections.unmodifiableList(((Endpoint) this.instance).getApisList());
        }

        public int getApisCount() {
            return ((Endpoint) this.instance).getApisCount();
        }

        public String getApis(int i) {
            return ((Endpoint) this.instance).getApis(i);
        }

        public ByteString getApisBytes(int i) {
            return ((Endpoint) this.instance).getApisBytes(i);
        }

        public Builder setApis(int i, String str) {
            copyOnWrite();
            ((Endpoint) this.instance).setApis(i, str);
            return this;
        }

        public Builder addApis(String str) {
            copyOnWrite();
            ((Endpoint) this.instance).addApis(str);
            return this;
        }

        public Builder addAllApis(Iterable<String> iterable) {
            copyOnWrite();
            ((Endpoint) this.instance).addAllApis(iterable);
            return this;
        }

        public Builder clearApis() {
            copyOnWrite();
            ((Endpoint) this.instance).clearApis();
            return this;
        }

        public Builder addApisBytes(ByteString byteString) {
            copyOnWrite();
            ((Endpoint) this.instance).addApisBytes(byteString);
            return this;
        }

        public List<String> getFeaturesList() {
            return Collections.unmodifiableList(((Endpoint) this.instance).getFeaturesList());
        }

        public int getFeaturesCount() {
            return ((Endpoint) this.instance).getFeaturesCount();
        }

        public String getFeatures(int i) {
            return ((Endpoint) this.instance).getFeatures(i);
        }

        public ByteString getFeaturesBytes(int i) {
            return ((Endpoint) this.instance).getFeaturesBytes(i);
        }

        public Builder setFeatures(int i, String str) {
            copyOnWrite();
            ((Endpoint) this.instance).setFeatures(i, str);
            return this;
        }

        public Builder addFeatures(String str) {
            copyOnWrite();
            ((Endpoint) this.instance).addFeatures(str);
            return this;
        }

        public Builder addAllFeatures(Iterable<String> iterable) {
            copyOnWrite();
            ((Endpoint) this.instance).addAllFeatures(iterable);
            return this;
        }

        public Builder clearFeatures() {
            copyOnWrite();
            ((Endpoint) this.instance).clearFeatures();
            return this;
        }

        public Builder addFeaturesBytes(ByteString byteString) {
            copyOnWrite();
            ((Endpoint) this.instance).addFeaturesBytes(byteString);
            return this;
        }

        public String getTarget() {
            return ((Endpoint) this.instance).getTarget();
        }

        public ByteString getTargetBytes() {
            return ((Endpoint) this.instance).getTargetBytes();
        }

        public Builder setTarget(String str) {
            copyOnWrite();
            ((Endpoint) this.instance).setTarget(str);
            return this;
        }

        public Builder clearTarget() {
            copyOnWrite();
            ((Endpoint) this.instance).clearTarget();
            return this;
        }

        public Builder setTargetBytes(ByteString byteString) {
            copyOnWrite();
            ((Endpoint) this.instance).setTargetBytes(byteString);
            return this;
        }

        public boolean getAllowCors() {
            return ((Endpoint) this.instance).getAllowCors();
        }

        public Builder setAllowCors(boolean z) {
            copyOnWrite();
            ((Endpoint) this.instance).setAllowCors(z);
            return this;
        }

        public Builder clearAllowCors() {
            copyOnWrite();
            ((Endpoint) this.instance).clearAllowCors();
            return this;
        }
    }

    /* access modifiers changed from: protected */
    public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        switch (methodToInvoke) {
            case NEW_MUTABLE_INSTANCE:
                return new Endpoint();
            case IS_INITIALIZED:
                return DEFAULT_INSTANCE;
            case MAKE_IMMUTABLE:
                this.aliases_.makeImmutable();
                this.apis_.makeImmutable();
                this.features_.makeImmutable();
                return null;
            case NEW_BUILDER:
                return new Builder();
            case VISIT:
                GeneratedMessageLite.Visitor visitor = (GeneratedMessageLite.Visitor) obj;
                Endpoint endpoint = (Endpoint) obj2;
                this.name_ = visitor.visitString(!this.name_.isEmpty(), this.name_, !endpoint.name_.isEmpty(), endpoint.name_);
                this.aliases_ = visitor.visitList(this.aliases_, endpoint.aliases_);
                this.apis_ = visitor.visitList(this.apis_, endpoint.apis_);
                this.features_ = visitor.visitList(this.features_, endpoint.features_);
                this.target_ = visitor.visitString(!this.target_.isEmpty(), this.target_, true ^ endpoint.target_.isEmpty(), endpoint.target_);
                boolean z = this.allowCors_;
                boolean z2 = endpoint.allowCors_;
                this.allowCors_ = visitor.visitBoolean(z, z, z2, z2);
                if (visitor == GeneratedMessageLite.MergeFromVisitor.INSTANCE) {
                    this.bitField0_ |= endpoint.bitField0_;
                }
                return this;
            case MERGE_FROM_STREAM:
                CodedInputStream codedInputStream = (CodedInputStream) obj;
                ExtensionRegistryLite extensionRegistryLite = (ExtensionRegistryLite) obj2;
                boolean z3 = false;
                while (!z3) {
                    try {
                        int readTag = codedInputStream.readTag();
                        if (readTag != 0) {
                            if (readTag == 10) {
                                this.name_ = codedInputStream.readStringRequireUtf8();
                            } else if (readTag == 18) {
                                String readStringRequireUtf8 = codedInputStream.readStringRequireUtf8();
                                if (!this.aliases_.isModifiable()) {
                                    this.aliases_ = GeneratedMessageLite.mutableCopy(this.aliases_);
                                }
                                this.aliases_.add(readStringRequireUtf8);
                            } else if (readTag == 26) {
                                String readStringRequireUtf82 = codedInputStream.readStringRequireUtf8();
                                if (!this.apis_.isModifiable()) {
                                    this.apis_ = GeneratedMessageLite.mutableCopy(this.apis_);
                                }
                                this.apis_.add(readStringRequireUtf82);
                            } else if (readTag == 34) {
                                String readStringRequireUtf83 = codedInputStream.readStringRequireUtf8();
                                if (!this.features_.isModifiable()) {
                                    this.features_ = GeneratedMessageLite.mutableCopy(this.features_);
                                }
                                this.features_.add(readStringRequireUtf83);
                            } else if (readTag == 40) {
                                this.allowCors_ = codedInputStream.readBool();
                            } else if (readTag == 810) {
                                this.target_ = codedInputStream.readStringRequireUtf8();
                            } else if (!codedInputStream.skipField(readTag)) {
                            }
                        }
                        z3 = true;
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
                    synchronized (Endpoint.class) {
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

    public static Endpoint getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static Parser<Endpoint> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }
}
