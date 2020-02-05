package com.google.firestore.v1;

import com.google.firestore.v1.Precondition;
import com.google.protobuf.MessageLiteOrBuilder;
import com.google.protobuf.Timestamp;

/* compiled from: com.google.firebase:firebase-firestore@@20.2.0 */
public interface PreconditionOrBuilder extends MessageLiteOrBuilder {
    Precondition.ConditionTypeCase getConditionTypeCase();

    boolean getExists();

    Timestamp getUpdateTime();
}
