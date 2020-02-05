package com.google.firestore.v1;

import com.google.protobuf.MessageLiteOrBuilder;
import java.util.List;

/* compiled from: com.google.firebase:firebase-firestore@@20.2.0 */
public interface ArrayValueOrBuilder extends MessageLiteOrBuilder {
    Value getValues(int i);

    int getValuesCount();

    List<Value> getValuesList();
}
