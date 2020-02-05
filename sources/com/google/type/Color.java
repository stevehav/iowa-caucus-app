package com.google.type;

import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.FloatValue;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.Parser;
import java.io.IOException;
import java.io.InputStream;

/* compiled from: com.google.firebase:protolite-well-known-types@@16.0.1 */
public final class Color extends GeneratedMessageLite<Color, Builder> implements ColorOrBuilder {
    public static final int ALPHA_FIELD_NUMBER = 4;
    public static final int BLUE_FIELD_NUMBER = 3;
    /* access modifiers changed from: private */
    public static final Color DEFAULT_INSTANCE = new Color();
    public static final int GREEN_FIELD_NUMBER = 2;
    private static volatile Parser<Color> PARSER = null;
    public static final int RED_FIELD_NUMBER = 1;
    private FloatValue alpha_;
    private float blue_;
    private float green_;
    private float red_;

    private Color() {
    }

    public float getRed() {
        return this.red_;
    }

    /* access modifiers changed from: private */
    public void setRed(float f) {
        this.red_ = f;
    }

    /* access modifiers changed from: private */
    public void clearRed() {
        this.red_ = 0.0f;
    }

    public float getGreen() {
        return this.green_;
    }

    /* access modifiers changed from: private */
    public void setGreen(float f) {
        this.green_ = f;
    }

    /* access modifiers changed from: private */
    public void clearGreen() {
        this.green_ = 0.0f;
    }

    public float getBlue() {
        return this.blue_;
    }

    /* access modifiers changed from: private */
    public void setBlue(float f) {
        this.blue_ = f;
    }

    /* access modifiers changed from: private */
    public void clearBlue() {
        this.blue_ = 0.0f;
    }

    public boolean hasAlpha() {
        return this.alpha_ != null;
    }

    public FloatValue getAlpha() {
        FloatValue floatValue = this.alpha_;
        return floatValue == null ? FloatValue.getDefaultInstance() : floatValue;
    }

    /* access modifiers changed from: private */
    public void setAlpha(FloatValue floatValue) {
        if (floatValue != null) {
            this.alpha_ = floatValue;
            return;
        }
        throw new NullPointerException();
    }

    /* access modifiers changed from: private */
    public void setAlpha(FloatValue.Builder builder) {
        this.alpha_ = (FloatValue) builder.build();
    }

    /* access modifiers changed from: private */
    public void mergeAlpha(FloatValue floatValue) {
        FloatValue floatValue2 = this.alpha_;
        if (floatValue2 == null || floatValue2 == FloatValue.getDefaultInstance()) {
            this.alpha_ = floatValue;
        } else {
            this.alpha_ = (FloatValue) ((FloatValue.Builder) FloatValue.newBuilder(this.alpha_).mergeFrom(floatValue)).buildPartial();
        }
    }

    /* access modifiers changed from: private */
    public void clearAlpha() {
        this.alpha_ = null;
    }

    public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
        float f = this.red_;
        if (f != 0.0f) {
            codedOutputStream.writeFloat(1, f);
        }
        float f2 = this.green_;
        if (f2 != 0.0f) {
            codedOutputStream.writeFloat(2, f2);
        }
        float f3 = this.blue_;
        if (f3 != 0.0f) {
            codedOutputStream.writeFloat(3, f3);
        }
        if (this.alpha_ != null) {
            codedOutputStream.writeMessage(4, getAlpha());
        }
    }

    public int getSerializedSize() {
        int i = this.memoizedSerializedSize;
        if (i != -1) {
            return i;
        }
        int i2 = 0;
        float f = this.red_;
        if (f != 0.0f) {
            i2 = 0 + CodedOutputStream.computeFloatSize(1, f);
        }
        float f2 = this.green_;
        if (f2 != 0.0f) {
            i2 += CodedOutputStream.computeFloatSize(2, f2);
        }
        float f3 = this.blue_;
        if (f3 != 0.0f) {
            i2 += CodedOutputStream.computeFloatSize(3, f3);
        }
        if (this.alpha_ != null) {
            i2 += CodedOutputStream.computeMessageSize(4, getAlpha());
        }
        this.memoizedSerializedSize = i2;
        return i2;
    }

    public static Color parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
        return (Color) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
    }

    public static Color parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (Color) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }

    public static Color parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
        return (Color) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static Color parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (Color) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
    }

    public static Color parseFrom(InputStream inputStream) throws IOException {
        return (Color) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static Color parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (Color) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static Color parseDelimitedFrom(InputStream inputStream) throws IOException {
        return (Color) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static Color parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (Color) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static Color parseFrom(CodedInputStream codedInputStream) throws IOException {
        return (Color) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
    }

    public static Color parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (Color) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
    }

    public static Builder newBuilder() {
        return (Builder) DEFAULT_INSTANCE.toBuilder();
    }

    public static Builder newBuilder(Color color) {
        return (Builder) ((Builder) DEFAULT_INSTANCE.toBuilder()).mergeFrom(color);
    }

    /* compiled from: com.google.firebase:protolite-well-known-types@@16.0.1 */
    public static final class Builder extends GeneratedMessageLite.Builder<Color, Builder> implements ColorOrBuilder {
        private Builder() {
            super(Color.DEFAULT_INSTANCE);
        }

        public float getRed() {
            return ((Color) this.instance).getRed();
        }

        public Builder setRed(float f) {
            copyOnWrite();
            ((Color) this.instance).setRed(f);
            return this;
        }

        public Builder clearRed() {
            copyOnWrite();
            ((Color) this.instance).clearRed();
            return this;
        }

        public float getGreen() {
            return ((Color) this.instance).getGreen();
        }

        public Builder setGreen(float f) {
            copyOnWrite();
            ((Color) this.instance).setGreen(f);
            return this;
        }

        public Builder clearGreen() {
            copyOnWrite();
            ((Color) this.instance).clearGreen();
            return this;
        }

        public float getBlue() {
            return ((Color) this.instance).getBlue();
        }

        public Builder setBlue(float f) {
            copyOnWrite();
            ((Color) this.instance).setBlue(f);
            return this;
        }

        public Builder clearBlue() {
            copyOnWrite();
            ((Color) this.instance).clearBlue();
            return this;
        }

        public boolean hasAlpha() {
            return ((Color) this.instance).hasAlpha();
        }

        public FloatValue getAlpha() {
            return ((Color) this.instance).getAlpha();
        }

        public Builder setAlpha(FloatValue floatValue) {
            copyOnWrite();
            ((Color) this.instance).setAlpha(floatValue);
            return this;
        }

        public Builder setAlpha(FloatValue.Builder builder) {
            copyOnWrite();
            ((Color) this.instance).setAlpha(builder);
            return this;
        }

        public Builder mergeAlpha(FloatValue floatValue) {
            copyOnWrite();
            ((Color) this.instance).mergeAlpha(floatValue);
            return this;
        }

        public Builder clearAlpha() {
            copyOnWrite();
            ((Color) this.instance).clearAlpha();
            return this;
        }
    }

    /* access modifiers changed from: protected */
    public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        boolean z = false;
        switch (methodToInvoke) {
            case NEW_MUTABLE_INSTANCE:
                return new Color();
            case IS_INITIALIZED:
                return DEFAULT_INSTANCE;
            case MAKE_IMMUTABLE:
                return null;
            case NEW_BUILDER:
                return new Builder();
            case VISIT:
                GeneratedMessageLite.Visitor visitor = (GeneratedMessageLite.Visitor) obj;
                Color color = (Color) obj2;
                this.red_ = visitor.visitFloat(this.red_ != 0.0f, this.red_, color.red_ != 0.0f, color.red_);
                this.green_ = visitor.visitFloat(this.green_ != 0.0f, this.green_, color.green_ != 0.0f, color.green_);
                boolean z2 = this.blue_ != 0.0f;
                float f = this.blue_;
                if (color.blue_ != 0.0f) {
                    z = true;
                }
                this.blue_ = visitor.visitFloat(z2, f, z, color.blue_);
                this.alpha_ = (FloatValue) visitor.visitMessage(this.alpha_, color.alpha_);
                GeneratedMessageLite.MergeFromVisitor mergeFromVisitor = GeneratedMessageLite.MergeFromVisitor.INSTANCE;
                return this;
            case MERGE_FROM_STREAM:
                CodedInputStream codedInputStream = (CodedInputStream) obj;
                ExtensionRegistryLite extensionRegistryLite = (ExtensionRegistryLite) obj2;
                while (!z) {
                    try {
                        int readTag = codedInputStream.readTag();
                        if (readTag != 0) {
                            if (readTag == 13) {
                                this.red_ = codedInputStream.readFloat();
                            } else if (readTag == 21) {
                                this.green_ = codedInputStream.readFloat();
                            } else if (readTag == 29) {
                                this.blue_ = codedInputStream.readFloat();
                            } else if (readTag == 34) {
                                FloatValue.Builder builder = this.alpha_ != null ? (FloatValue.Builder) this.alpha_.toBuilder() : null;
                                this.alpha_ = (FloatValue) codedInputStream.readMessage(FloatValue.parser(), extensionRegistryLite);
                                if (builder != null) {
                                    builder.mergeFrom(this.alpha_);
                                    this.alpha_ = (FloatValue) builder.buildPartial();
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
                    synchronized (Color.class) {
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

    public static Color getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static Parser<Color> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }
}
