package com.google.firestore.v1;

import com.google.firestore.v1.GetDocumentRequest;
import com.google.protobuf.ByteString;
import com.google.protobuf.MessageLiteOrBuilder;
import com.google.protobuf.Timestamp;

/* compiled from: com.google.firebase:firebase-firestore@@20.2.0 */
public interface GetDocumentRequestOrBuilder extends MessageLiteOrBuilder {
    GetDocumentRequest.ConsistencySelectorCase getConsistencySelectorCase();

    DocumentMask getMask();

    String getName();

    ByteString getNameBytes();

    Timestamp getReadTime();

    ByteString getTransaction();

    boolean hasMask();
}
