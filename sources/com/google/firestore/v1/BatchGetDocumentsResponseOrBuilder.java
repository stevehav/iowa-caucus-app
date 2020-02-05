package com.google.firestore.v1;

import com.google.firestore.v1.BatchGetDocumentsResponse;
import com.google.protobuf.ByteString;
import com.google.protobuf.MessageLiteOrBuilder;
import com.google.protobuf.Timestamp;

/* compiled from: com.google.firebase:firebase-firestore@@20.2.0 */
public interface BatchGetDocumentsResponseOrBuilder extends MessageLiteOrBuilder {
    Document getFound();

    String getMissing();

    ByteString getMissingBytes();

    Timestamp getReadTime();

    BatchGetDocumentsResponse.ResultCase getResultCase();

    ByteString getTransaction();

    boolean hasReadTime();
}
