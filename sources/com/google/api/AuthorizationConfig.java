package com.google.api;

import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.Parser;
import java.io.IOException;
import java.io.InputStream;

/* compiled from: com.google.firebase:protolite-well-known-types@@16.0.1 */
public final class AuthorizationConfig extends GeneratedMessageLite<AuthorizationConfig, Builder> implements AuthorizationConfigOrBuilder {
    /* access modifiers changed from: private */
    public static final AuthorizationConfig DEFAULT_INSTANCE = new AuthorizationConfig();
    private static volatile Parser<AuthorizationConfig> PARSER = null;
    public static final int PROVIDER_FIELD_NUMBER = 1;
    private String provider_ = "";

    private AuthorizationConfig() {
    }

    public String getProvider() {
        return this.provider_;
    }

    public ByteString getProviderBytes() {
        return ByteString.copyFromUtf8(this.provider_);
    }

    /* access modifiers changed from: private */
    public void setProvider(String str) {
        if (str != null) {
            this.provider_ = str;
            return;
        }
        throw new NullPointerException();
    }

    /* access modifiers changed from: private */
    public void clearProvider() {
        this.provider_ = getDefaultInstance().getProvider();
    }

    /* access modifiers changed from: private */
    public void setProviderBytes(ByteString byteString) {
        if (byteString != null) {
            checkByteStringIsUtf8(byteString);
            this.provider_ = byteString.toStringUtf8();
            return;
        }
        throw new NullPointerException();
    }

    public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
        if (!this.provider_.isEmpty()) {
            codedOutputStream.writeString(1, getProvider());
        }
    }

    public int getSerializedSize() {
        int i = this.memoizedSerializedSize;
        if (i != -1) {
            return i;
        }
        int i2 = 0;
        if (!this.provider_.isEmpty()) {
            i2 = 0 + CodedOutputStream.computeStringSize(1, getProvider());
        }
        this.memoizedSerializedSize = i2;
        return i2;
    }

    public static AuthorizationConfig parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
        return (AuthorizationConfig) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
    }

    public static AuthorizationConfig parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (AuthorizationConfig) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }

    public static AuthorizationConfig parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
        return (AuthorizationConfig) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static AuthorizationConfig parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (AuthorizationConfig) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
    }

    public static AuthorizationConfig parseFrom(InputStream inputStream) throws IOException {
        return (AuthorizationConfig) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static AuthorizationConfig parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (AuthorizationConfig) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static AuthorizationConfig parseDelimitedFrom(InputStream inputStream) throws IOException {
        return (AuthorizationConfig) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static AuthorizationConfig parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (AuthorizationConfig) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static AuthorizationConfig parseFrom(CodedInputStream codedInputStream) throws IOException {
        return (AuthorizationConfig) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
    }

    public static AuthorizationConfig parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (AuthorizationConfig) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
    }

    public static Builder newBuilder() {
        return (Builder) DEFAULT_INSTANCE.toBuilder();
    }

    public static Builder newBuilder(AuthorizationConfig authorizationConfig) {
        return (Builder) ((Builder) DEFAULT_INSTANCE.toBuilder()).mergeFrom(authorizationConfig);
    }

    /* compiled from: com.google.firebase:protolite-well-known-types@@16.0.1 */
    public static final class Builder extends GeneratedMessageLite.Builder<AuthorizationConfig, Builder> implements AuthorizationConfigOrBuilder {
        private Builder() {
            super(AuthorizationConfig.DEFAULT_INSTANCE);
        }

        public String getProvider() {
            return ((AuthorizationConfig) this.instance).getProvider();
        }

        public ByteString getProviderBytes() {
            return ((AuthorizationConfig) this.instance).getProviderBytes();
        }

        public Builder setProvider(String str) {
            copyOnWrite();
            ((AuthorizationConfig) this.instance).setProvider(str);
            return this;
        }

        public Builder clearProvider() {
            copyOnWrite();
            ((AuthorizationConfig) this.instance).clearProvider();
            return this;
        }

        public Builder setProviderBytes(ByteString byteString) {
            copyOnWrite();
            ((AuthorizationConfig) this.instance).setProviderBytes(byteString);
            return this;
        }
    }

    /* access modifiers changed from: protected */
    public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        switch (methodToInvoke) {
            case NEW_MUTABLE_INSTANCE:
                return new AuthorizationConfig();
            case IS_INITIALIZED:
                return DEFAULT_INSTANCE;
            case MAKE_IMMUTABLE:
                return null;
            case NEW_BUILDER:
                return new Builder();
            case VISIT:
                AuthorizationConfig authorizationConfig = (AuthorizationConfig) obj2;
                this.provider_ = ((GeneratedMessageLite.Visitor) obj).visitString(!this.provider_.isEmpty(), this.provider_, true ^ authorizationConfig.provider_.isEmpty(), authorizationConfig.provider_);
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
                                this.provider_ = codedInputStream.readStringRequireUtf8();
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
                    synchronized (AuthorizationConfig.class) {
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

    public static AuthorizationConfig getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static Parser<AuthorizationConfig> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }
}
