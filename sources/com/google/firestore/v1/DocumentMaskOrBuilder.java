package com.google.firestore.v1;

import com.google.protobuf.ByteString;
import com.google.protobuf.MessageLiteOrBuilder;
import java.util.List;

/* compiled from: com.google.firebase:firebase-firestore@@20.2.0 */
public interface DocumentMaskOrBuilder extends MessageLiteOrBuilder {
    String getFieldPaths(int i);

    ByteString getFieldPathsBytes(int i);

    int getFieldPathsCount();

    List<String> getFieldPathsList();
}
