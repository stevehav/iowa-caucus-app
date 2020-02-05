package com.google.firestore.v1;

import com.google.firestore.v1.TransactionOptions;
import com.google.protobuf.MessageLiteOrBuilder;

/* compiled from: com.google.firebase:firebase-firestore@@20.2.0 */
public interface TransactionOptionsOrBuilder extends MessageLiteOrBuilder {
    TransactionOptions.ModeCase getModeCase();

    TransactionOptions.ReadOnly getReadOnly();

    TransactionOptions.ReadWrite getReadWrite();
}
