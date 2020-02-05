package com.google.firebase.firestore.proto;

import com.google.firestore.v1.Write;
import com.google.protobuf.MessageLiteOrBuilder;
import com.google.protobuf.Timestamp;
import java.util.List;

/* compiled from: com.google.firebase:firebase-firestore@@20.2.0 */
public interface WriteBatchOrBuilder extends MessageLiteOrBuilder {
    Write getBaseWrites(int i);

    int getBaseWritesCount();

    List<Write> getBaseWritesList();

    int getBatchId();

    Timestamp getLocalWriteTime();

    Write getWrites(int i);

    int getWritesCount();

    List<Write> getWritesList();

    boolean hasLocalWriteTime();
}
