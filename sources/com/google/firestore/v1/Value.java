package com.google.firestore.v1;

import com.google.firestore.v1.ArrayValue;
import com.google.firestore.v1.MapValue;
import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.Internal;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.NullValue;
import com.google.protobuf.Parser;
import com.google.protobuf.Timestamp;
import com.google.type.LatLng;
import java.io.IOException;
import java.io.InputStream;

/* compiled from: com.google.firebase:firebase-firestore@@20.2.0 */
public final class Value extends GeneratedMessageLite<Value, Builder> implements ValueOrBuilder {
    public static final int ARRAY_VALUE_FIELD_NUMBER = 9;
    public static final int BOOLEAN_VALUE_FIELD_NUMBER = 1;
    public static final int BYTES_VALUE_FIELD_NUMBER = 18;
    /* access modifiers changed from: private */
    public static final Value DEFAULT_INSTANCE = new Value();
    public static final int DOUBLE_VALUE_FIELD_NUMBER = 3;
    public static final int GEO_POINT_VALUE_FIELD_NUMBER = 8;
    public static final int INTEGER_VALUE_FIELD_NUMBER = 2;
    public static final int MAP_VALUE_FIELD_NUMBER = 6;
    public static final int NULL_VALUE_FIELD_NUMBER = 11;
    private static volatile Parser<Value> PARSER = null;
    public static final int REFERENCE_VALUE_FIELD_NUMBER = 5;
    public static final int STRING_VALUE_FIELD_NUMBER = 17;
    public static final int TIMESTAMP_VALUE_FIELD_NUMBER = 10;
    private int valueTypeCase_ = 0;
    private Object valueType_;

    private Value() {
    }

    /* compiled from: com.google.firebase:firebase-firestore@@20.2.0 */
    public enum ValueTypeCase implements Internal.EnumLite {
        NULL_VALUE(11),
        BOOLEAN_VALUE(1),
        INTEGER_VALUE(2),
        DOUBLE_VALUE(3),
        TIMESTAMP_VALUE(10),
        STRING_VALUE(17),
        BYTES_VALUE(18),
        REFERENCE_VALUE(5),
        GEO_POINT_VALUE(8),
        ARRAY_VALUE(9),
        MAP_VALUE(6),
        VALUETYPE_NOT_SET(0);
        
        private final int value;

        private ValueTypeCase(int i) {
            this.value = i;
        }

        @Deprecated
        public static ValueTypeCase valueOf(int i) {
            return forNumber(i);
        }

        public static ValueTypeCase forNumber(int i) {
            if (i == 0) {
                return VALUETYPE_NOT_SET;
            }
            if (i == 1) {
                return BOOLEAN_VALUE;
            }
            if (i == 2) {
                return INTEGER_VALUE;
            }
            if (i == 3) {
                return DOUBLE_VALUE;
            }
            if (i == 5) {
                return REFERENCE_VALUE;
            }
            if (i == 6) {
                return MAP_VALUE;
            }
            if (i == 17) {
                return STRING_VALUE;
            }
            if (i == 18) {
                return BYTES_VALUE;
            }
            switch (i) {
                case 8:
                    return GEO_POINT_VALUE;
                case 9:
                    return ARRAY_VALUE;
                case 10:
                    return TIMESTAMP_VALUE;
                case 11:
                    return NULL_VALUE;
                default:
                    return null;
            }
        }

        public int getNumber() {
            return this.value;
        }
    }

    public ValueTypeCase getValueTypeCase() {
        return ValueTypeCase.forNumber(this.valueTypeCase_);
    }

    /* access modifiers changed from: private */
    public void clearValueType() {
        this.valueTypeCase_ = 0;
        this.valueType_ = null;
    }

    public int getNullValueValue() {
        if (this.valueTypeCase_ == 11) {
            return ((Integer) this.valueType_).intValue();
        }
        return 0;
    }

    public NullValue getNullValue() {
        if (this.valueTypeCase_ != 11) {
            return NullValue.NULL_VALUE;
        }
        NullValue forNumber = NullValue.forNumber(((Integer) this.valueType_).intValue());
        return forNumber == null ? NullValue.UNRECOGNIZED : forNumber;
    }

    /* access modifiers changed from: private */
    public void setNullValueValue(int i) {
        this.valueTypeCase_ = 11;
        this.valueType_ = Integer.valueOf(i);
    }

    /* access modifiers changed from: private */
    public void setNullValue(NullValue nullValue) {
        if (nullValue != null) {
            this.valueTypeCase_ = 11;
            this.valueType_ = Integer.valueOf(nullValue.getNumber());
            return;
        }
        throw new NullPointerException();
    }

    /* access modifiers changed from: private */
    public void clearNullValue() {
        if (this.valueTypeCase_ == 11) {
            this.valueTypeCase_ = 0;
            this.valueType_ = null;
        }
    }

    public boolean getBooleanValue() {
        if (this.valueTypeCase_ == 1) {
            return ((Boolean) this.valueType_).booleanValue();
        }
        return false;
    }

    /* access modifiers changed from: private */
    public void setBooleanValue(boolean z) {
        this.valueTypeCase_ = 1;
        this.valueType_ = Boolean.valueOf(z);
    }

    /* access modifiers changed from: private */
    public void clearBooleanValue() {
        if (this.valueTypeCase_ == 1) {
            this.valueTypeCase_ = 0;
            this.valueType_ = null;
        }
    }

    public long getIntegerValue() {
        if (this.valueTypeCase_ == 2) {
            return ((Long) this.valueType_).longValue();
        }
        return 0;
    }

    /* access modifiers changed from: private */
    public void setIntegerValue(long j) {
        this.valueTypeCase_ = 2;
        this.valueType_ = Long.valueOf(j);
    }

    /* access modifiers changed from: private */
    public void clearIntegerValue() {
        if (this.valueTypeCase_ == 2) {
            this.valueTypeCase_ = 0;
            this.valueType_ = null;
        }
    }

    public double getDoubleValue() {
        if (this.valueTypeCase_ == 3) {
            return ((Double) this.valueType_).doubleValue();
        }
        return 0.0d;
    }

    /* access modifiers changed from: private */
    public void setDoubleValue(double d) {
        this.valueTypeCase_ = 3;
        this.valueType_ = Double.valueOf(d);
    }

    /* access modifiers changed from: private */
    public void clearDoubleValue() {
        if (this.valueTypeCase_ == 3) {
            this.valueTypeCase_ = 0;
            this.valueType_ = null;
        }
    }

    public Timestamp getTimestampValue() {
        if (this.valueTypeCase_ == 10) {
            return (Timestamp) this.valueType_;
        }
        return Timestamp.getDefaultInstance();
    }

    /* access modifiers changed from: private */
    public void setTimestampValue(Timestamp timestamp) {
        if (timestamp != null) {
            this.valueType_ = timestamp;
            this.valueTypeCase_ = 10;
            return;
        }
        throw new NullPointerException();
    }

    /* access modifiers changed from: private */
    public void setTimestampValue(Timestamp.Builder builder) {
        this.valueType_ = builder.build();
        this.valueTypeCase_ = 10;
    }

    /* access modifiers changed from: private */
    public void mergeTimestampValue(Timestamp timestamp) {
        if (this.valueTypeCase_ != 10 || this.valueType_ == Timestamp.getDefaultInstance()) {
            this.valueType_ = timestamp;
        } else {
            this.valueType_ = ((Timestamp.Builder) Timestamp.newBuilder((Timestamp) this.valueType_).mergeFrom(timestamp)).buildPartial();
        }
        this.valueTypeCase_ = 10;
    }

    /* access modifiers changed from: private */
    public void clearTimestampValue() {
        if (this.valueTypeCase_ == 10) {
            this.valueTypeCase_ = 0;
            this.valueType_ = null;
        }
    }

    public String getStringValue() {
        return this.valueTypeCase_ == 17 ? (String) this.valueType_ : "";
    }

    public ByteString getStringValueBytes() {
        return ByteString.copyFromUtf8(this.valueTypeCase_ == 17 ? (String) this.valueType_ : "");
    }

    /* access modifiers changed from: private */
    public void setStringValue(String str) {
        if (str != null) {
            this.valueTypeCase_ = 17;
            this.valueType_ = str;
            return;
        }
        throw new NullPointerException();
    }

    /* access modifiers changed from: private */
    public void clearStringValue() {
        if (this.valueTypeCase_ == 17) {
            this.valueTypeCase_ = 0;
            this.valueType_ = null;
        }
    }

    /* access modifiers changed from: private */
    public void setStringValueBytes(ByteString byteString) {
        if (byteString != null) {
            checkByteStringIsUtf8(byteString);
            this.valueTypeCase_ = 17;
            this.valueType_ = byteString.toStringUtf8();
            return;
        }
        throw new NullPointerException();
    }

    public ByteString getBytesValue() {
        if (this.valueTypeCase_ == 18) {
            return (ByteString) this.valueType_;
        }
        return ByteString.EMPTY;
    }

    /* access modifiers changed from: private */
    public void setBytesValue(ByteString byteString) {
        if (byteString != null) {
            this.valueTypeCase_ = 18;
            this.valueType_ = byteString;
            return;
        }
        throw new NullPointerException();
    }

    /* access modifiers changed from: private */
    public void clearBytesValue() {
        if (this.valueTypeCase_ == 18) {
            this.valueTypeCase_ = 0;
            this.valueType_ = null;
        }
    }

    public String getReferenceValue() {
        return this.valueTypeCase_ == 5 ? (String) this.valueType_ : "";
    }

    public ByteString getReferenceValueBytes() {
        return ByteString.copyFromUtf8(this.valueTypeCase_ == 5 ? (String) this.valueType_ : "");
    }

    /* access modifiers changed from: private */
    public void setReferenceValue(String str) {
        if (str != null) {
            this.valueTypeCase_ = 5;
            this.valueType_ = str;
            return;
        }
        throw new NullPointerException();
    }

    /* access modifiers changed from: private */
    public void clearReferenceValue() {
        if (this.valueTypeCase_ == 5) {
            this.valueTypeCase_ = 0;
            this.valueType_ = null;
        }
    }

    /* access modifiers changed from: private */
    public void setReferenceValueBytes(ByteString byteString) {
        if (byteString != null) {
            checkByteStringIsUtf8(byteString);
            this.valueTypeCase_ = 5;
            this.valueType_ = byteString.toStringUtf8();
            return;
        }
        throw new NullPointerException();
    }

    public LatLng getGeoPointValue() {
        if (this.valueTypeCase_ == 8) {
            return (LatLng) this.valueType_;
        }
        return LatLng.getDefaultInstance();
    }

    /* access modifiers changed from: private */
    public void setGeoPointValue(LatLng latLng) {
        if (latLng != null) {
            this.valueType_ = latLng;
            this.valueTypeCase_ = 8;
            return;
        }
        throw new NullPointerException();
    }

    /* access modifiers changed from: private */
    public void setGeoPointValue(LatLng.Builder builder) {
        this.valueType_ = builder.build();
        this.valueTypeCase_ = 8;
    }

    /* access modifiers changed from: private */
    public void mergeGeoPointValue(LatLng latLng) {
        if (this.valueTypeCase_ != 8 || this.valueType_ == LatLng.getDefaultInstance()) {
            this.valueType_ = latLng;
        } else {
            this.valueType_ = ((LatLng.Builder) LatLng.newBuilder((LatLng) this.valueType_).mergeFrom(latLng)).buildPartial();
        }
        this.valueTypeCase_ = 8;
    }

    /* access modifiers changed from: private */
    public void clearGeoPointValue() {
        if (this.valueTypeCase_ == 8) {
            this.valueTypeCase_ = 0;
            this.valueType_ = null;
        }
    }

    public ArrayValue getArrayValue() {
        if (this.valueTypeCase_ == 9) {
            return (ArrayValue) this.valueType_;
        }
        return ArrayValue.getDefaultInstance();
    }

    /* access modifiers changed from: private */
    public void setArrayValue(ArrayValue arrayValue) {
        if (arrayValue != null) {
            this.valueType_ = arrayValue;
            this.valueTypeCase_ = 9;
            return;
        }
        throw new NullPointerException();
    }

    /* access modifiers changed from: private */
    public void setArrayValue(ArrayValue.Builder builder) {
        this.valueType_ = builder.build();
        this.valueTypeCase_ = 9;
    }

    /* access modifiers changed from: private */
    public void mergeArrayValue(ArrayValue arrayValue) {
        if (this.valueTypeCase_ != 9 || this.valueType_ == ArrayValue.getDefaultInstance()) {
            this.valueType_ = arrayValue;
        } else {
            this.valueType_ = ((ArrayValue.Builder) ArrayValue.newBuilder((ArrayValue) this.valueType_).mergeFrom(arrayValue)).buildPartial();
        }
        this.valueTypeCase_ = 9;
    }

    /* access modifiers changed from: private */
    public void clearArrayValue() {
        if (this.valueTypeCase_ == 9) {
            this.valueTypeCase_ = 0;
            this.valueType_ = null;
        }
    }

    public MapValue getMapValue() {
        if (this.valueTypeCase_ == 6) {
            return (MapValue) this.valueType_;
        }
        return MapValue.getDefaultInstance();
    }

    /* access modifiers changed from: private */
    public void setMapValue(MapValue mapValue) {
        if (mapValue != null) {
            this.valueType_ = mapValue;
            this.valueTypeCase_ = 6;
            return;
        }
        throw new NullPointerException();
    }

    /* access modifiers changed from: private */
    public void setMapValue(MapValue.Builder builder) {
        this.valueType_ = builder.build();
        this.valueTypeCase_ = 6;
    }

    /* access modifiers changed from: private */
    public void mergeMapValue(MapValue mapValue) {
        if (this.valueTypeCase_ != 6 || this.valueType_ == MapValue.getDefaultInstance()) {
            this.valueType_ = mapValue;
        } else {
            this.valueType_ = ((MapValue.Builder) MapValue.newBuilder((MapValue) this.valueType_).mergeFrom(mapValue)).buildPartial();
        }
        this.valueTypeCase_ = 6;
    }

    /* access modifiers changed from: private */
    public void clearMapValue() {
        if (this.valueTypeCase_ == 6) {
            this.valueTypeCase_ = 0;
            this.valueType_ = null;
        }
    }

    public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
        if (this.valueTypeCase_ == 1) {
            codedOutputStream.writeBool(1, ((Boolean) this.valueType_).booleanValue());
        }
        if (this.valueTypeCase_ == 2) {
            codedOutputStream.writeInt64(2, ((Long) this.valueType_).longValue());
        }
        if (this.valueTypeCase_ == 3) {
            codedOutputStream.writeDouble(3, ((Double) this.valueType_).doubleValue());
        }
        if (this.valueTypeCase_ == 5) {
            codedOutputStream.writeString(5, getReferenceValue());
        }
        if (this.valueTypeCase_ == 6) {
            codedOutputStream.writeMessage(6, (MapValue) this.valueType_);
        }
        if (this.valueTypeCase_ == 8) {
            codedOutputStream.writeMessage(8, (LatLng) this.valueType_);
        }
        if (this.valueTypeCase_ == 9) {
            codedOutputStream.writeMessage(9, (ArrayValue) this.valueType_);
        }
        if (this.valueTypeCase_ == 10) {
            codedOutputStream.writeMessage(10, (Timestamp) this.valueType_);
        }
        if (this.valueTypeCase_ == 11) {
            codedOutputStream.writeEnum(11, ((Integer) this.valueType_).intValue());
        }
        if (this.valueTypeCase_ == 17) {
            codedOutputStream.writeString(17, getStringValue());
        }
        if (this.valueTypeCase_ == 18) {
            codedOutputStream.writeBytes(18, (ByteString) this.valueType_);
        }
    }

    public int getSerializedSize() {
        int i = this.memoizedSerializedSize;
        if (i != -1) {
            return i;
        }
        int i2 = 0;
        if (this.valueTypeCase_ == 1) {
            i2 = 0 + CodedOutputStream.computeBoolSize(1, ((Boolean) this.valueType_).booleanValue());
        }
        if (this.valueTypeCase_ == 2) {
            i2 += CodedOutputStream.computeInt64Size(2, ((Long) this.valueType_).longValue());
        }
        if (this.valueTypeCase_ == 3) {
            i2 += CodedOutputStream.computeDoubleSize(3, ((Double) this.valueType_).doubleValue());
        }
        if (this.valueTypeCase_ == 5) {
            i2 += CodedOutputStream.computeStringSize(5, getReferenceValue());
        }
        if (this.valueTypeCase_ == 6) {
            i2 += CodedOutputStream.computeMessageSize(6, (MapValue) this.valueType_);
        }
        if (this.valueTypeCase_ == 8) {
            i2 += CodedOutputStream.computeMessageSize(8, (LatLng) this.valueType_);
        }
        if (this.valueTypeCase_ == 9) {
            i2 += CodedOutputStream.computeMessageSize(9, (ArrayValue) this.valueType_);
        }
        if (this.valueTypeCase_ == 10) {
            i2 += CodedOutputStream.computeMessageSize(10, (Timestamp) this.valueType_);
        }
        if (this.valueTypeCase_ == 11) {
            i2 += CodedOutputStream.computeEnumSize(11, ((Integer) this.valueType_).intValue());
        }
        if (this.valueTypeCase_ == 17) {
            i2 += CodedOutputStream.computeStringSize(17, getStringValue());
        }
        if (this.valueTypeCase_ == 18) {
            i2 += CodedOutputStream.computeBytesSize(18, (ByteString) this.valueType_);
        }
        this.memoizedSerializedSize = i2;
        return i2;
    }

    public static Value parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
        return (Value) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
    }

    public static Value parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (Value) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }

    public static Value parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
        return (Value) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static Value parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (Value) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
    }

    public static Value parseFrom(InputStream inputStream) throws IOException {
        return (Value) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static Value parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (Value) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static Value parseDelimitedFrom(InputStream inputStream) throws IOException {
        return (Value) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static Value parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (Value) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static Value parseFrom(CodedInputStream codedInputStream) throws IOException {
        return (Value) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
    }

    public static Value parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (Value) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
    }

    public static Builder newBuilder() {
        return (Builder) DEFAULT_INSTANCE.toBuilder();
    }

    public static Builder newBuilder(Value value) {
        return (Builder) ((Builder) DEFAULT_INSTANCE.toBuilder()).mergeFrom(value);
    }

    /* compiled from: com.google.firebase:firebase-firestore@@20.2.0 */
    public static final class Builder extends GeneratedMessageLite.Builder<Value, Builder> implements ValueOrBuilder {
        private Builder() {
            super(Value.DEFAULT_INSTANCE);
        }

        public ValueTypeCase getValueTypeCase() {
            return ((Value) this.instance).getValueTypeCase();
        }

        public Builder clearValueType() {
            copyOnWrite();
            ((Value) this.instance).clearValueType();
            return this;
        }

        public int getNullValueValue() {
            return ((Value) this.instance).getNullValueValue();
        }

        public Builder setNullValueValue(int i) {
            copyOnWrite();
            ((Value) this.instance).setNullValueValue(i);
            return this;
        }

        public NullValue getNullValue() {
            return ((Value) this.instance).getNullValue();
        }

        public Builder setNullValue(NullValue nullValue) {
            copyOnWrite();
            ((Value) this.instance).setNullValue(nullValue);
            return this;
        }

        public Builder clearNullValue() {
            copyOnWrite();
            ((Value) this.instance).clearNullValue();
            return this;
        }

        public boolean getBooleanValue() {
            return ((Value) this.instance).getBooleanValue();
        }

        public Builder setBooleanValue(boolean z) {
            copyOnWrite();
            ((Value) this.instance).setBooleanValue(z);
            return this;
        }

        public Builder clearBooleanValue() {
            copyOnWrite();
            ((Value) this.instance).clearBooleanValue();
            return this;
        }

        public long getIntegerValue() {
            return ((Value) this.instance).getIntegerValue();
        }

        public Builder setIntegerValue(long j) {
            copyOnWrite();
            ((Value) this.instance).setIntegerValue(j);
            return this;
        }

        public Builder clearIntegerValue() {
            copyOnWrite();
            ((Value) this.instance).clearIntegerValue();
            return this;
        }

        public double getDoubleValue() {
            return ((Value) this.instance).getDoubleValue();
        }

        public Builder setDoubleValue(double d) {
            copyOnWrite();
            ((Value) this.instance).setDoubleValue(d);
            return this;
        }

        public Builder clearDoubleValue() {
            copyOnWrite();
            ((Value) this.instance).clearDoubleValue();
            return this;
        }

        public Timestamp getTimestampValue() {
            return ((Value) this.instance).getTimestampValue();
        }

        public Builder setTimestampValue(Timestamp timestamp) {
            copyOnWrite();
            ((Value) this.instance).setTimestampValue(timestamp);
            return this;
        }

        public Builder setTimestampValue(Timestamp.Builder builder) {
            copyOnWrite();
            ((Value) this.instance).setTimestampValue(builder);
            return this;
        }

        public Builder mergeTimestampValue(Timestamp timestamp) {
            copyOnWrite();
            ((Value) this.instance).mergeTimestampValue(timestamp);
            return this;
        }

        public Builder clearTimestampValue() {
            copyOnWrite();
            ((Value) this.instance).clearTimestampValue();
            return this;
        }

        public String getStringValue() {
            return ((Value) this.instance).getStringValue();
        }

        public ByteString getStringValueBytes() {
            return ((Value) this.instance).getStringValueBytes();
        }

        public Builder setStringValue(String str) {
            copyOnWrite();
            ((Value) this.instance).setStringValue(str);
            return this;
        }

        public Builder clearStringValue() {
            copyOnWrite();
            ((Value) this.instance).clearStringValue();
            return this;
        }

        public Builder setStringValueBytes(ByteString byteString) {
            copyOnWrite();
            ((Value) this.instance).setStringValueBytes(byteString);
            return this;
        }

        public ByteString getBytesValue() {
            return ((Value) this.instance).getBytesValue();
        }

        public Builder setBytesValue(ByteString byteString) {
            copyOnWrite();
            ((Value) this.instance).setBytesValue(byteString);
            return this;
        }

        public Builder clearBytesValue() {
            copyOnWrite();
            ((Value) this.instance).clearBytesValue();
            return this;
        }

        public String getReferenceValue() {
            return ((Value) this.instance).getReferenceValue();
        }

        public ByteString getReferenceValueBytes() {
            return ((Value) this.instance).getReferenceValueBytes();
        }

        public Builder setReferenceValue(String str) {
            copyOnWrite();
            ((Value) this.instance).setReferenceValue(str);
            return this;
        }

        public Builder clearReferenceValue() {
            copyOnWrite();
            ((Value) this.instance).clearReferenceValue();
            return this;
        }

        public Builder setReferenceValueBytes(ByteString byteString) {
            copyOnWrite();
            ((Value) this.instance).setReferenceValueBytes(byteString);
            return this;
        }

        public LatLng getGeoPointValue() {
            return ((Value) this.instance).getGeoPointValue();
        }

        public Builder setGeoPointValue(LatLng latLng) {
            copyOnWrite();
            ((Value) this.instance).setGeoPointValue(latLng);
            return this;
        }

        public Builder setGeoPointValue(LatLng.Builder builder) {
            copyOnWrite();
            ((Value) this.instance).setGeoPointValue(builder);
            return this;
        }

        public Builder mergeGeoPointValue(LatLng latLng) {
            copyOnWrite();
            ((Value) this.instance).mergeGeoPointValue(latLng);
            return this;
        }

        public Builder clearGeoPointValue() {
            copyOnWrite();
            ((Value) this.instance).clearGeoPointValue();
            return this;
        }

        public ArrayValue getArrayValue() {
            return ((Value) this.instance).getArrayValue();
        }

        public Builder setArrayValue(ArrayValue arrayValue) {
            copyOnWrite();
            ((Value) this.instance).setArrayValue(arrayValue);
            return this;
        }

        public Builder setArrayValue(ArrayValue.Builder builder) {
            copyOnWrite();
            ((Value) this.instance).setArrayValue(builder);
            return this;
        }

        public Builder mergeArrayValue(ArrayValue arrayValue) {
            copyOnWrite();
            ((Value) this.instance).mergeArrayValue(arrayValue);
            return this;
        }

        public Builder clearArrayValue() {
            copyOnWrite();
            ((Value) this.instance).clearArrayValue();
            return this;
        }

        public MapValue getMapValue() {
            return ((Value) this.instance).getMapValue();
        }

        public Builder setMapValue(MapValue mapValue) {
            copyOnWrite();
            ((Value) this.instance).setMapValue(mapValue);
            return this;
        }

        public Builder setMapValue(MapValue.Builder builder) {
            copyOnWrite();
            ((Value) this.instance).setMapValue(builder);
            return this;
        }

        public Builder mergeMapValue(MapValue mapValue) {
            copyOnWrite();
            ((Value) this.instance).mergeMapValue(mapValue);
            return this;
        }

        public Builder clearMapValue() {
            copyOnWrite();
            ((Value) this.instance).clearMapValue();
            return this;
        }
    }

    /* JADX WARNING: type inference failed for: r7v18, types: [com.google.protobuf.GeneratedMessageLite$Builder] */
    /* JADX WARNING: type inference failed for: r7v27, types: [com.google.protobuf.GeneratedMessageLite$Builder] */
    /* JADX WARNING: type inference failed for: r7v36, types: [com.google.protobuf.GeneratedMessageLite$Builder] */
    /* access modifiers changed from: protected */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object dynamicMethod(com.google.protobuf.GeneratedMessageLite.MethodToInvoke r19, java.lang.Object r20, java.lang.Object r21) {
        /*
            r18 = this;
            r1 = r18
            int[] r0 = com.google.firestore.v1.Value.AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke
            int r2 = r19.ordinal()
            r0 = r0[r2]
            r2 = 5
            r3 = 18
            r4 = 17
            r5 = 3
            r6 = 2
            r7 = 11
            r8 = 6
            r9 = 9
            r10 = 8
            r11 = 10
            r13 = 0
            r14 = 1
            switch(r0) {
                case 1: goto L_0x027c;
                case 2: goto L_0x0279;
                case 3: goto L_0x0277;
                case 4: goto L_0x0270;
                case 5: goto L_0x018d;
                case 6: goto L_0x0041;
                case 7: goto L_0x018a;
                case 8: goto L_0x0025;
                default: goto L_0x001f;
            }
        L_0x001f:
            java.lang.UnsupportedOperationException r0 = new java.lang.UnsupportedOperationException
            r0.<init>()
            throw r0
        L_0x0025:
            com.google.protobuf.Parser<com.google.firestore.v1.Value> r0 = PARSER
            if (r0 != 0) goto L_0x003e
            java.lang.Class<com.google.firestore.v1.Value> r2 = com.google.firestore.v1.Value.class
            monitor-enter(r2)
            com.google.protobuf.Parser<com.google.firestore.v1.Value> r0 = PARSER     // Catch:{ all -> 0x003b }
            if (r0 != 0) goto L_0x0039
            com.google.protobuf.GeneratedMessageLite$DefaultInstanceBasedParser r0 = new com.google.protobuf.GeneratedMessageLite$DefaultInstanceBasedParser     // Catch:{ all -> 0x003b }
            com.google.firestore.v1.Value r3 = DEFAULT_INSTANCE     // Catch:{ all -> 0x003b }
            r0.<init>(r3)     // Catch:{ all -> 0x003b }
            PARSER = r0     // Catch:{ all -> 0x003b }
        L_0x0039:
            monitor-exit(r2)     // Catch:{ all -> 0x003b }
            goto L_0x003e
        L_0x003b:
            r0 = move-exception
            monitor-exit(r2)     // Catch:{ all -> 0x003b }
            throw r0
        L_0x003e:
            com.google.protobuf.Parser<com.google.firestore.v1.Value> r0 = PARSER
            return r0
        L_0x0041:
            r0 = r20
            com.google.protobuf.CodedInputStream r0 = (com.google.protobuf.CodedInputStream) r0
            r15 = r21
            com.google.protobuf.ExtensionRegistryLite r15 = (com.google.protobuf.ExtensionRegistryLite) r15
        L_0x0049:
            if (r13 != 0) goto L_0x018a
            int r12 = r0.readTag()     // Catch:{ InvalidProtocolBufferException -> 0x017e, IOException -> 0x016a }
            switch(r12) {
                case 0: goto L_0x015f;
                case 8: goto L_0x0152;
                case 16: goto L_0x0145;
                case 25: goto L_0x0138;
                case 42: goto L_0x012f;
                case 50: goto L_0x0102;
                case 66: goto L_0x00d5;
                case 74: goto L_0x00a7;
                case 82: goto L_0x007a;
                case 88: goto L_0x006c;
                case 138: goto L_0x0062;
                case 146: goto L_0x0058;
                default: goto L_0x0052;
            }     // Catch:{ InvalidProtocolBufferException -> 0x017e, IOException -> 0x016a }
        L_0x0052:
            boolean r7 = r0.skipField(r12)     // Catch:{ InvalidProtocolBufferException -> 0x017e, IOException -> 0x016a }
            goto L_0x0161
        L_0x0058:
            r1.valueTypeCase_ = r3     // Catch:{ InvalidProtocolBufferException -> 0x017e, IOException -> 0x016a }
            com.google.protobuf.ByteString r12 = r0.readBytes()     // Catch:{ InvalidProtocolBufferException -> 0x017e, IOException -> 0x016a }
            r1.valueType_ = r12     // Catch:{ InvalidProtocolBufferException -> 0x017e, IOException -> 0x016a }
            goto L_0x0164
        L_0x0062:
            java.lang.String r12 = r0.readStringRequireUtf8()     // Catch:{ InvalidProtocolBufferException -> 0x017e, IOException -> 0x016a }
            r1.valueTypeCase_ = r4     // Catch:{ InvalidProtocolBufferException -> 0x017e, IOException -> 0x016a }
            r1.valueType_ = r12     // Catch:{ InvalidProtocolBufferException -> 0x017e, IOException -> 0x016a }
            goto L_0x0164
        L_0x006c:
            int r12 = r0.readEnum()     // Catch:{ InvalidProtocolBufferException -> 0x017e, IOException -> 0x016a }
            r1.valueTypeCase_ = r7     // Catch:{ InvalidProtocolBufferException -> 0x017e, IOException -> 0x016a }
            java.lang.Integer r12 = java.lang.Integer.valueOf(r12)     // Catch:{ InvalidProtocolBufferException -> 0x017e, IOException -> 0x016a }
            r1.valueType_ = r12     // Catch:{ InvalidProtocolBufferException -> 0x017e, IOException -> 0x016a }
            goto L_0x0164
        L_0x007a:
            int r12 = r1.valueTypeCase_     // Catch:{ InvalidProtocolBufferException -> 0x017e, IOException -> 0x016a }
            if (r12 != r11) goto L_0x0089
            java.lang.Object r12 = r1.valueType_     // Catch:{ InvalidProtocolBufferException -> 0x017e, IOException -> 0x016a }
            com.google.protobuf.Timestamp r12 = (com.google.protobuf.Timestamp) r12     // Catch:{ InvalidProtocolBufferException -> 0x017e, IOException -> 0x016a }
            com.google.protobuf.GeneratedMessageLite$Builder r12 = r12.toBuilder()     // Catch:{ InvalidProtocolBufferException -> 0x017e, IOException -> 0x016a }
            com.google.protobuf.Timestamp$Builder r12 = (com.google.protobuf.Timestamp.Builder) r12     // Catch:{ InvalidProtocolBufferException -> 0x017e, IOException -> 0x016a }
            goto L_0x008a
        L_0x0089:
            r12 = 0
        L_0x008a:
            com.google.protobuf.Parser r7 = com.google.protobuf.Timestamp.parser()     // Catch:{ InvalidProtocolBufferException -> 0x017e, IOException -> 0x016a }
            com.google.protobuf.MessageLite r7 = r0.readMessage(r7, (com.google.protobuf.ExtensionRegistryLite) r15)     // Catch:{ InvalidProtocolBufferException -> 0x017e, IOException -> 0x016a }
            r1.valueType_ = r7     // Catch:{ InvalidProtocolBufferException -> 0x017e, IOException -> 0x016a }
            if (r12 == 0) goto L_0x00a3
            java.lang.Object r7 = r1.valueType_     // Catch:{ InvalidProtocolBufferException -> 0x017e, IOException -> 0x016a }
            com.google.protobuf.Timestamp r7 = (com.google.protobuf.Timestamp) r7     // Catch:{ InvalidProtocolBufferException -> 0x017e, IOException -> 0x016a }
            r12.mergeFrom(r7)     // Catch:{ InvalidProtocolBufferException -> 0x017e, IOException -> 0x016a }
            com.google.protobuf.GeneratedMessageLite r7 = r12.buildPartial()     // Catch:{ InvalidProtocolBufferException -> 0x017e, IOException -> 0x016a }
            r1.valueType_ = r7     // Catch:{ InvalidProtocolBufferException -> 0x017e, IOException -> 0x016a }
        L_0x00a3:
            r1.valueTypeCase_ = r11     // Catch:{ InvalidProtocolBufferException -> 0x017e, IOException -> 0x016a }
            goto L_0x0164
        L_0x00a7:
            int r7 = r1.valueTypeCase_     // Catch:{ InvalidProtocolBufferException -> 0x017e, IOException -> 0x016a }
            if (r7 != r9) goto L_0x00b7
            java.lang.Object r7 = r1.valueType_     // Catch:{ InvalidProtocolBufferException -> 0x017e, IOException -> 0x016a }
            com.google.firestore.v1.ArrayValue r7 = (com.google.firestore.v1.ArrayValue) r7     // Catch:{ InvalidProtocolBufferException -> 0x017e, IOException -> 0x016a }
            com.google.protobuf.GeneratedMessageLite$Builder r7 = r7.toBuilder()     // Catch:{ InvalidProtocolBufferException -> 0x017e, IOException -> 0x016a }
            r12 = r7
            com.google.firestore.v1.ArrayValue$Builder r12 = (com.google.firestore.v1.ArrayValue.Builder) r12     // Catch:{ InvalidProtocolBufferException -> 0x017e, IOException -> 0x016a }
            goto L_0x00b8
        L_0x00b7:
            r12 = 0
        L_0x00b8:
            com.google.protobuf.Parser r7 = com.google.firestore.v1.ArrayValue.parser()     // Catch:{ InvalidProtocolBufferException -> 0x017e, IOException -> 0x016a }
            com.google.protobuf.MessageLite r7 = r0.readMessage(r7, (com.google.protobuf.ExtensionRegistryLite) r15)     // Catch:{ InvalidProtocolBufferException -> 0x017e, IOException -> 0x016a }
            r1.valueType_ = r7     // Catch:{ InvalidProtocolBufferException -> 0x017e, IOException -> 0x016a }
            if (r12 == 0) goto L_0x00d1
            java.lang.Object r7 = r1.valueType_     // Catch:{ InvalidProtocolBufferException -> 0x017e, IOException -> 0x016a }
            com.google.firestore.v1.ArrayValue r7 = (com.google.firestore.v1.ArrayValue) r7     // Catch:{ InvalidProtocolBufferException -> 0x017e, IOException -> 0x016a }
            r12.mergeFrom(r7)     // Catch:{ InvalidProtocolBufferException -> 0x017e, IOException -> 0x016a }
            com.google.protobuf.GeneratedMessageLite r7 = r12.buildPartial()     // Catch:{ InvalidProtocolBufferException -> 0x017e, IOException -> 0x016a }
            r1.valueType_ = r7     // Catch:{ InvalidProtocolBufferException -> 0x017e, IOException -> 0x016a }
        L_0x00d1:
            r1.valueTypeCase_ = r9     // Catch:{ InvalidProtocolBufferException -> 0x017e, IOException -> 0x016a }
            goto L_0x0164
        L_0x00d5:
            int r7 = r1.valueTypeCase_     // Catch:{ InvalidProtocolBufferException -> 0x017e, IOException -> 0x016a }
            if (r7 != r10) goto L_0x00e5
            java.lang.Object r7 = r1.valueType_     // Catch:{ InvalidProtocolBufferException -> 0x017e, IOException -> 0x016a }
            com.google.type.LatLng r7 = (com.google.type.LatLng) r7     // Catch:{ InvalidProtocolBufferException -> 0x017e, IOException -> 0x016a }
            com.google.protobuf.GeneratedMessageLite$Builder r7 = r7.toBuilder()     // Catch:{ InvalidProtocolBufferException -> 0x017e, IOException -> 0x016a }
            r12 = r7
            com.google.type.LatLng$Builder r12 = (com.google.type.LatLng.Builder) r12     // Catch:{ InvalidProtocolBufferException -> 0x017e, IOException -> 0x016a }
            goto L_0x00e6
        L_0x00e5:
            r12 = 0
        L_0x00e6:
            com.google.protobuf.Parser r7 = com.google.type.LatLng.parser()     // Catch:{ InvalidProtocolBufferException -> 0x017e, IOException -> 0x016a }
            com.google.protobuf.MessageLite r7 = r0.readMessage(r7, (com.google.protobuf.ExtensionRegistryLite) r15)     // Catch:{ InvalidProtocolBufferException -> 0x017e, IOException -> 0x016a }
            r1.valueType_ = r7     // Catch:{ InvalidProtocolBufferException -> 0x017e, IOException -> 0x016a }
            if (r12 == 0) goto L_0x00ff
            java.lang.Object r7 = r1.valueType_     // Catch:{ InvalidProtocolBufferException -> 0x017e, IOException -> 0x016a }
            com.google.type.LatLng r7 = (com.google.type.LatLng) r7     // Catch:{ InvalidProtocolBufferException -> 0x017e, IOException -> 0x016a }
            r12.mergeFrom(r7)     // Catch:{ InvalidProtocolBufferException -> 0x017e, IOException -> 0x016a }
            com.google.protobuf.GeneratedMessageLite r7 = r12.buildPartial()     // Catch:{ InvalidProtocolBufferException -> 0x017e, IOException -> 0x016a }
            r1.valueType_ = r7     // Catch:{ InvalidProtocolBufferException -> 0x017e, IOException -> 0x016a }
        L_0x00ff:
            r1.valueTypeCase_ = r10     // Catch:{ InvalidProtocolBufferException -> 0x017e, IOException -> 0x016a }
            goto L_0x0164
        L_0x0102:
            int r7 = r1.valueTypeCase_     // Catch:{ InvalidProtocolBufferException -> 0x017e, IOException -> 0x016a }
            if (r7 != r8) goto L_0x0112
            java.lang.Object r7 = r1.valueType_     // Catch:{ InvalidProtocolBufferException -> 0x017e, IOException -> 0x016a }
            com.google.firestore.v1.MapValue r7 = (com.google.firestore.v1.MapValue) r7     // Catch:{ InvalidProtocolBufferException -> 0x017e, IOException -> 0x016a }
            com.google.protobuf.GeneratedMessageLite$Builder r7 = r7.toBuilder()     // Catch:{ InvalidProtocolBufferException -> 0x017e, IOException -> 0x016a }
            r12 = r7
            com.google.firestore.v1.MapValue$Builder r12 = (com.google.firestore.v1.MapValue.Builder) r12     // Catch:{ InvalidProtocolBufferException -> 0x017e, IOException -> 0x016a }
            goto L_0x0113
        L_0x0112:
            r12 = 0
        L_0x0113:
            com.google.protobuf.Parser r7 = com.google.firestore.v1.MapValue.parser()     // Catch:{ InvalidProtocolBufferException -> 0x017e, IOException -> 0x016a }
            com.google.protobuf.MessageLite r7 = r0.readMessage(r7, (com.google.protobuf.ExtensionRegistryLite) r15)     // Catch:{ InvalidProtocolBufferException -> 0x017e, IOException -> 0x016a }
            r1.valueType_ = r7     // Catch:{ InvalidProtocolBufferException -> 0x017e, IOException -> 0x016a }
            if (r12 == 0) goto L_0x012c
            java.lang.Object r7 = r1.valueType_     // Catch:{ InvalidProtocolBufferException -> 0x017e, IOException -> 0x016a }
            com.google.firestore.v1.MapValue r7 = (com.google.firestore.v1.MapValue) r7     // Catch:{ InvalidProtocolBufferException -> 0x017e, IOException -> 0x016a }
            r12.mergeFrom(r7)     // Catch:{ InvalidProtocolBufferException -> 0x017e, IOException -> 0x016a }
            com.google.protobuf.GeneratedMessageLite r7 = r12.buildPartial()     // Catch:{ InvalidProtocolBufferException -> 0x017e, IOException -> 0x016a }
            r1.valueType_ = r7     // Catch:{ InvalidProtocolBufferException -> 0x017e, IOException -> 0x016a }
        L_0x012c:
            r1.valueTypeCase_ = r8     // Catch:{ InvalidProtocolBufferException -> 0x017e, IOException -> 0x016a }
            goto L_0x0164
        L_0x012f:
            java.lang.String r7 = r0.readStringRequireUtf8()     // Catch:{ InvalidProtocolBufferException -> 0x017e, IOException -> 0x016a }
            r1.valueTypeCase_ = r2     // Catch:{ InvalidProtocolBufferException -> 0x017e, IOException -> 0x016a }
            r1.valueType_ = r7     // Catch:{ InvalidProtocolBufferException -> 0x017e, IOException -> 0x016a }
            goto L_0x0164
        L_0x0138:
            r1.valueTypeCase_ = r5     // Catch:{ InvalidProtocolBufferException -> 0x017e, IOException -> 0x016a }
            double r16 = r0.readDouble()     // Catch:{ InvalidProtocolBufferException -> 0x017e, IOException -> 0x016a }
            java.lang.Double r7 = java.lang.Double.valueOf(r16)     // Catch:{ InvalidProtocolBufferException -> 0x017e, IOException -> 0x016a }
            r1.valueType_ = r7     // Catch:{ InvalidProtocolBufferException -> 0x017e, IOException -> 0x016a }
            goto L_0x0164
        L_0x0145:
            r1.valueTypeCase_ = r6     // Catch:{ InvalidProtocolBufferException -> 0x017e, IOException -> 0x016a }
            long r16 = r0.readInt64()     // Catch:{ InvalidProtocolBufferException -> 0x017e, IOException -> 0x016a }
            java.lang.Long r7 = java.lang.Long.valueOf(r16)     // Catch:{ InvalidProtocolBufferException -> 0x017e, IOException -> 0x016a }
            r1.valueType_ = r7     // Catch:{ InvalidProtocolBufferException -> 0x017e, IOException -> 0x016a }
            goto L_0x0164
        L_0x0152:
            r1.valueTypeCase_ = r14     // Catch:{ InvalidProtocolBufferException -> 0x017e, IOException -> 0x016a }
            boolean r7 = r0.readBool()     // Catch:{ InvalidProtocolBufferException -> 0x017e, IOException -> 0x016a }
            java.lang.Boolean r7 = java.lang.Boolean.valueOf(r7)     // Catch:{ InvalidProtocolBufferException -> 0x017e, IOException -> 0x016a }
            r1.valueType_ = r7     // Catch:{ InvalidProtocolBufferException -> 0x017e, IOException -> 0x016a }
            goto L_0x0164
        L_0x015f:
            r13 = 1
            goto L_0x0164
        L_0x0161:
            if (r7 != 0) goto L_0x0164
            goto L_0x015f
        L_0x0164:
            r7 = 11
            goto L_0x0049
        L_0x0168:
            r0 = move-exception
            goto L_0x0189
        L_0x016a:
            r0 = move-exception
            java.lang.RuntimeException r2 = new java.lang.RuntimeException     // Catch:{ all -> 0x0168 }
            com.google.protobuf.InvalidProtocolBufferException r3 = new com.google.protobuf.InvalidProtocolBufferException     // Catch:{ all -> 0x0168 }
            java.lang.String r0 = r0.getMessage()     // Catch:{ all -> 0x0168 }
            r3.<init>((java.lang.String) r0)     // Catch:{ all -> 0x0168 }
            com.google.protobuf.InvalidProtocolBufferException r0 = r3.setUnfinishedMessage(r1)     // Catch:{ all -> 0x0168 }
            r2.<init>(r0)     // Catch:{ all -> 0x0168 }
            throw r2     // Catch:{ all -> 0x0168 }
        L_0x017e:
            r0 = move-exception
            java.lang.RuntimeException r2 = new java.lang.RuntimeException     // Catch:{ all -> 0x0168 }
            com.google.protobuf.InvalidProtocolBufferException r0 = r0.setUnfinishedMessage(r1)     // Catch:{ all -> 0x0168 }
            r2.<init>(r0)     // Catch:{ all -> 0x0168 }
            throw r2     // Catch:{ all -> 0x0168 }
        L_0x0189:
            throw r0
        L_0x018a:
            com.google.firestore.v1.Value r0 = DEFAULT_INSTANCE
            return r0
        L_0x018d:
            r0 = r20
            com.google.protobuf.GeneratedMessageLite$Visitor r0 = (com.google.protobuf.GeneratedMessageLite.Visitor) r0
            r7 = r21
            com.google.firestore.v1.Value r7 = (com.google.firestore.v1.Value) r7
            int[] r12 = com.google.firestore.v1.Value.AnonymousClass1.$SwitchMap$com$google$firestore$v1$Value$ValueTypeCase
            com.google.firestore.v1.Value$ValueTypeCase r15 = r7.getValueTypeCase()
            int r15 = r15.ordinal()
            r12 = r12[r15]
            switch(r12) {
                case 1: goto L_0x0254;
                case 2: goto L_0x0244;
                case 3: goto L_0x0234;
                case 4: goto L_0x0224;
                case 5: goto L_0x0214;
                case 6: goto L_0x0204;
                case 7: goto L_0x01f4;
                case 8: goto L_0x01e3;
                case 9: goto L_0x01d2;
                case 10: goto L_0x01c1;
                case 11: goto L_0x01b0;
                case 12: goto L_0x01a6;
                default: goto L_0x01a4;
            }
        L_0x01a4:
            goto L_0x0265
        L_0x01a6:
            int r2 = r1.valueTypeCase_
            if (r2 == 0) goto L_0x01ab
            r13 = 1
        L_0x01ab:
            r0.visitOneofNotSet(r13)
            goto L_0x0265
        L_0x01b0:
            int r2 = r1.valueTypeCase_
            if (r2 != r8) goto L_0x01b5
            r13 = 1
        L_0x01b5:
            java.lang.Object r2 = r1.valueType_
            java.lang.Object r3 = r7.valueType_
            java.lang.Object r2 = r0.visitOneofMessage(r13, r2, r3)
            r1.valueType_ = r2
            goto L_0x0265
        L_0x01c1:
            int r2 = r1.valueTypeCase_
            if (r2 != r9) goto L_0x01c6
            r13 = 1
        L_0x01c6:
            java.lang.Object r2 = r1.valueType_
            java.lang.Object r3 = r7.valueType_
            java.lang.Object r2 = r0.visitOneofMessage(r13, r2, r3)
            r1.valueType_ = r2
            goto L_0x0265
        L_0x01d2:
            int r2 = r1.valueTypeCase_
            if (r2 != r10) goto L_0x01d7
            r13 = 1
        L_0x01d7:
            java.lang.Object r2 = r1.valueType_
            java.lang.Object r3 = r7.valueType_
            java.lang.Object r2 = r0.visitOneofMessage(r13, r2, r3)
            r1.valueType_ = r2
            goto L_0x0265
        L_0x01e3:
            int r3 = r1.valueTypeCase_
            if (r3 != r2) goto L_0x01e8
            r13 = 1
        L_0x01e8:
            java.lang.Object r2 = r1.valueType_
            java.lang.Object r3 = r7.valueType_
            java.lang.Object r2 = r0.visitOneofString(r13, r2, r3)
            r1.valueType_ = r2
            goto L_0x0265
        L_0x01f4:
            int r2 = r1.valueTypeCase_
            if (r2 != r3) goto L_0x01f9
            r13 = 1
        L_0x01f9:
            java.lang.Object r2 = r1.valueType_
            java.lang.Object r3 = r7.valueType_
            java.lang.Object r2 = r0.visitOneofByteString(r13, r2, r3)
            r1.valueType_ = r2
            goto L_0x0265
        L_0x0204:
            int r2 = r1.valueTypeCase_
            if (r2 != r4) goto L_0x0209
            r13 = 1
        L_0x0209:
            java.lang.Object r2 = r1.valueType_
            java.lang.Object r3 = r7.valueType_
            java.lang.Object r2 = r0.visitOneofString(r13, r2, r3)
            r1.valueType_ = r2
            goto L_0x0265
        L_0x0214:
            int r2 = r1.valueTypeCase_
            if (r2 != r11) goto L_0x0219
            r13 = 1
        L_0x0219:
            java.lang.Object r2 = r1.valueType_
            java.lang.Object r3 = r7.valueType_
            java.lang.Object r2 = r0.visitOneofMessage(r13, r2, r3)
            r1.valueType_ = r2
            goto L_0x0265
        L_0x0224:
            int r2 = r1.valueTypeCase_
            if (r2 != r5) goto L_0x0229
            r13 = 1
        L_0x0229:
            java.lang.Object r2 = r1.valueType_
            java.lang.Object r3 = r7.valueType_
            java.lang.Object r2 = r0.visitOneofDouble(r13, r2, r3)
            r1.valueType_ = r2
            goto L_0x0265
        L_0x0234:
            int r2 = r1.valueTypeCase_
            if (r2 != r6) goto L_0x0239
            r13 = 1
        L_0x0239:
            java.lang.Object r2 = r1.valueType_
            java.lang.Object r3 = r7.valueType_
            java.lang.Object r2 = r0.visitOneofLong(r13, r2, r3)
            r1.valueType_ = r2
            goto L_0x0265
        L_0x0244:
            int r2 = r1.valueTypeCase_
            if (r2 != r14) goto L_0x0249
            r13 = 1
        L_0x0249:
            java.lang.Object r2 = r1.valueType_
            java.lang.Object r3 = r7.valueType_
            java.lang.Object r2 = r0.visitOneofBoolean(r13, r2, r3)
            r1.valueType_ = r2
            goto L_0x0265
        L_0x0254:
            int r2 = r1.valueTypeCase_
            r3 = 11
            if (r2 != r3) goto L_0x025b
            r13 = 1
        L_0x025b:
            java.lang.Object r2 = r1.valueType_
            java.lang.Object r3 = r7.valueType_
            java.lang.Object r2 = r0.visitOneofInt(r13, r2, r3)
            r1.valueType_ = r2
        L_0x0265:
            com.google.protobuf.GeneratedMessageLite$MergeFromVisitor r2 = com.google.protobuf.GeneratedMessageLite.MergeFromVisitor.INSTANCE
            if (r0 != r2) goto L_0x026f
            int r0 = r7.valueTypeCase_
            if (r0 == 0) goto L_0x026f
            r1.valueTypeCase_ = r0
        L_0x026f:
            return r1
        L_0x0270:
            com.google.firestore.v1.Value$Builder r0 = new com.google.firestore.v1.Value$Builder
            r2 = 0
            r0.<init>()
            return r0
        L_0x0277:
            r2 = 0
            return r2
        L_0x0279:
            com.google.firestore.v1.Value r0 = DEFAULT_INSTANCE
            return r0
        L_0x027c:
            com.google.firestore.v1.Value r0 = new com.google.firestore.v1.Value
            r0.<init>()
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firestore.v1.Value.dynamicMethod(com.google.protobuf.GeneratedMessageLite$MethodToInvoke, java.lang.Object, java.lang.Object):java.lang.Object");
    }

    static {
        DEFAULT_INSTANCE.makeImmutable();
    }

    public static Value getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static Parser<Value> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }
}
