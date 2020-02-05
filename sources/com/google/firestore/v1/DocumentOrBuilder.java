package com.google.firestore.v1;

import com.google.protobuf.ByteString;
import com.google.protobuf.MessageLiteOrBuilder;
import com.google.protobuf.Timestamp;
import java.util.Map;

/* compiled from: com.google.firebase:firebase-firestore@@20.2.0 */
public interface DocumentOrBuilder extends MessageLiteOrBuilder {
    boolean containsFields(String str);

    Timestamp getCreateTime();

    @Deprecated
    Map<String, Value> getFields();

    int getFieldsCount();

    Map<String, Value> getFieldsMap();

    Value getFieldsOrDefault(String str, Value value);

    Value getFieldsOrThrow(String str);

    String getName();

    ByteString getNameBytes();

    Timestamp getUpdateTime();

    boolean hasCreateTime();

    boolean hasUpdateTime();
}
