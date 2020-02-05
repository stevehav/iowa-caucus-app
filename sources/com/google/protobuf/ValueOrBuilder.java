package com.google.protobuf;

import com.google.protobuf.Value;

/* compiled from: com.google.firebase:protolite-well-known-types@@16.0.1 */
public interface ValueOrBuilder extends MessageLiteOrBuilder {
    boolean getBoolValue();

    Value.KindCase getKindCase();

    ListValue getListValue();

    NullValue getNullValue();

    int getNullValueValue();

    double getNumberValue();

    String getStringValue();

    ByteString getStringValueBytes();

    Struct getStructValue();
}
