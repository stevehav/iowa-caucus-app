package com.google.firestore.v1;

import com.google.firestore.v1.Target;
import com.google.protobuf.ByteString;
import com.google.protobuf.MessageLiteOrBuilder;
import com.google.protobuf.Timestamp;

/* compiled from: com.google.firebase:firebase-firestore@@20.2.0 */
public interface TargetOrBuilder extends MessageLiteOrBuilder {
    Target.DocumentsTarget getDocuments();

    boolean getOnce();

    Target.QueryTarget getQuery();

    Timestamp getReadTime();

    ByteString getResumeToken();

    Target.ResumeTypeCase getResumeTypeCase();

    int getTargetId();

    Target.TargetTypeCase getTargetTypeCase();
}
