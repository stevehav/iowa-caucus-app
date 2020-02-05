package com.google.firestore.v1;

import com.google.firestore.v1.RunQueryRequest;
import com.google.protobuf.ByteString;
import com.google.protobuf.MessageLiteOrBuilder;
import com.google.protobuf.Timestamp;

/* compiled from: com.google.firebase:firebase-firestore@@20.2.0 */
public interface RunQueryRequestOrBuilder extends MessageLiteOrBuilder {
    RunQueryRequest.ConsistencySelectorCase getConsistencySelectorCase();

    TransactionOptions getNewTransaction();

    String getParent();

    ByteString getParentBytes();

    RunQueryRequest.QueryTypeCase getQueryTypeCase();

    Timestamp getReadTime();

    StructuredQuery getStructuredQuery();

    ByteString getTransaction();
}
