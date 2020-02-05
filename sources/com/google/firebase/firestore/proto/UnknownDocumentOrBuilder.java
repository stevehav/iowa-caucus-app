package com.google.firebase.firestore.proto;

import com.google.protobuf.ByteString;
import com.google.protobuf.MessageLiteOrBuilder;
import com.google.protobuf.Timestamp;

/* compiled from: com.google.firebase:firebase-firestore@@20.2.0 */
public interface UnknownDocumentOrBuilder extends MessageLiteOrBuilder {
    String getName();

    ByteString getNameBytes();

    Timestamp getVersion();

    boolean hasVersion();
}
