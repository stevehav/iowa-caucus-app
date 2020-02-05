package com.google.firestore.v1;

import com.google.firestore.v1.TargetChange;
import com.google.protobuf.ByteString;
import com.google.protobuf.MessageLiteOrBuilder;
import com.google.protobuf.Timestamp;
import com.google.rpc.Status;
import java.util.List;

/* compiled from: com.google.firebase:firebase-firestore@@20.2.0 */
public interface TargetChangeOrBuilder extends MessageLiteOrBuilder {
    Status getCause();

    Timestamp getReadTime();

    ByteString getResumeToken();

    TargetChange.TargetChangeType getTargetChangeType();

    int getTargetChangeTypeValue();

    int getTargetIds(int i);

    int getTargetIdsCount();

    List<Integer> getTargetIdsList();

    boolean hasCause();

    boolean hasReadTime();
}
