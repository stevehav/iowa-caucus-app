package com.google.firestore.v1;

import com.google.firestore.v1.Value;
import com.google.protobuf.ByteString;
import com.google.protobuf.MessageLiteOrBuilder;
import com.google.protobuf.NullValue;
import com.google.protobuf.Timestamp;
import com.google.type.LatLng;

/* compiled from: com.google.firebase:firebase-firestore@@20.2.0 */
public interface ValueOrBuilder extends MessageLiteOrBuilder {
    ArrayValue getArrayValue();

    boolean getBooleanValue();

    ByteString getBytesValue();

    double getDoubleValue();

    LatLng getGeoPointValue();

    long getIntegerValue();

    MapValue getMapValue();

    NullValue getNullValue();

    int getNullValueValue();

    String getReferenceValue();

    ByteString getReferenceValueBytes();

    String getStringValue();

    ByteString getStringValueBytes();

    Timestamp getTimestampValue();

    Value.ValueTypeCase getValueTypeCase();
}
