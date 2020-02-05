package com.google.api;

import com.google.api.AuthorizationConfig;
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
public final class Experimental extends GeneratedMessageLite<Experimental, Builder> implements ExperimentalOrBuilder {
    public static final int AUTHORIZATION_FIELD_NUMBER = 8;
    /* access modifiers changed from: private */
    public static final Experimental DEFAULT_INSTANCE = new Experimental();
    private static volatile Parser<Experimental> PARSER;
    private AuthorizationConfig authorization_;

    private Experimental() {
    }

    public boolean hasAuthorization() {
        return this.authorization_ != null;
    }

    public AuthorizationConfig getAuthorization() {
        AuthorizationConfig authorizationConfig = this.authorization_;
        return authorizationConfig == null ? AuthorizationConfig.getDefaultInstance() : authorizationConfig;
    }

    /* access modifiers changed from: private */
    public void setAuthorization(AuthorizationConfig authorizationConfig) {
        if (authorizationConfig != null) {
            this.authorization_ = authorizationConfig;
            return;
        }
        throw new NullPointerException();
    }

    /* access modifiers changed from: private */
    public void setAuthorization(AuthorizationConfig.Builder builder) {
        this.authorization_ = (AuthorizationConfig) builder.build();
    }

    /* access modifiers changed from: private */
    public void mergeAuthorization(AuthorizationConfig authorizationConfig) {
        AuthorizationConfig authorizationConfig2 = this.authorization_;
        if (authorizationConfig2 == null || authorizationConfig2 == AuthorizationConfig.getDefaultInstance()) {
            this.authorization_ = authorizationConfig;
        } else {
            this.authorization_ = (AuthorizationConfig) ((AuthorizationConfig.Builder) AuthorizationConfig.newBuilder(this.authorization_).mergeFrom(authorizationConfig)).buildPartial();
        }
    }

    /* access modifiers changed from: private */
    public void clearAuthorization() {
        this.authorization_ = null;
    }

    public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
        if (this.authorization_ != null) {
            codedOutputStream.writeMessage(8, getAuthorization());
        }
    }

    public int getSerializedSize() {
        int i = this.memoizedSerializedSize;
        if (i != -1) {
            return i;
        }
        int i2 = 0;
        if (this.authorization_ != null) {
            i2 = 0 + CodedOutputStream.computeMessageSize(8, getAuthorization());
        }
        this.memoizedSerializedSize = i2;
        return i2;
    }

    public static Experimental parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
        return (Experimental) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
    }

    public static Experimental parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (Experimental) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }

    public static Experimental parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
        return (Experimental) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static Experimental parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (Experimental) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
    }

    public static Experimental parseFrom(InputStream inputStream) throws IOException {
        return (Experimental) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static Experimental parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (Experimental) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static Experimental parseDelimitedFrom(InputStream inputStream) throws IOException {
        return (Experimental) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static Experimental parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (Experimental) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static Experimental parseFrom(CodedInputStream codedInputStream) throws IOException {
        return (Experimental) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
    }

    public static Experimental parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (Experimental) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
    }

    public static Builder newBuilder() {
        return (Builder) DEFAULT_INSTANCE.toBuilder();
    }

    public static Builder newBuilder(Experimental experimental) {
        return (Builder) ((Builder) DEFAULT_INSTANCE.toBuilder()).mergeFrom(experimental);
    }

    /* compiled from: com.google.firebase:protolite-well-known-types@@16.0.1 */
    public static final class Builder extends GeneratedMessageLite.Builder<Experimental, Builder> implements ExperimentalOrBuilder {
        private Builder() {
            super(Experimental.DEFAULT_INSTANCE);
        }

        public boolean hasAuthorization() {
            return ((Experimental) this.instance).hasAuthorization();
        }

        public AuthorizationConfig getAuthorization() {
            return ((Experimental) this.instance).getAuthorization();
        }

        public Builder setAuthorization(AuthorizationConfig authorizationConfig) {
            copyOnWrite();
            ((Experimental) this.instance).setAuthorization(authorizationConfig);
            return this;
        }

        public Builder setAuthorization(AuthorizationConfig.Builder builder) {
            copyOnWrite();
            ((Experimental) this.instance).setAuthorization(builder);
            return this;
        }

        public Builder mergeAuthorization(AuthorizationConfig authorizationConfig) {
            copyOnWrite();
            ((Experimental) this.instance).mergeAuthorization(authorizationConfig);
            return this;
        }

        public Builder clearAuthorization() {
            copyOnWrite();
            ((Experimental) this.instance).clearAuthorization();
            return this;
        }
    }

    /* access modifiers changed from: protected */
    public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        switch (methodToInvoke) {
            case NEW_MUTABLE_INSTANCE:
                return new Experimental();
            case IS_INITIALIZED:
                return DEFAULT_INSTANCE;
            case MAKE_IMMUTABLE:
                return null;
            case NEW_BUILDER:
                return new Builder();
            case VISIT:
                this.authorization_ = (AuthorizationConfig) ((GeneratedMessageLite.Visitor) obj).visitMessage(this.authorization_, ((Experimental) obj2).authorization_);
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
                            if (readTag == 66) {
                                AuthorizationConfig.Builder builder = this.authorization_ != null ? (AuthorizationConfig.Builder) this.authorization_.toBuilder() : null;
                                this.authorization_ = (AuthorizationConfig) codedInputStream.readMessage(AuthorizationConfig.parser(), extensionRegistryLite);
                                if (builder != null) {
                                    builder.mergeFrom(this.authorization_);
                                    this.authorization_ = (AuthorizationConfig) builder.buildPartial();
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
                    synchronized (Experimental.class) {
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

    public static Experimental getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static Parser<Experimental> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }
}
