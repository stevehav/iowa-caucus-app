package com.google.api;

import com.google.protobuf.ByteString;
import com.google.protobuf.MessageLiteOrBuilder;

/* compiled from: com.google.firebase:protolite-well-known-types@@16.0.1 */
public interface HttpBodyOrBuilder extends MessageLiteOrBuilder {
    String getContentType();

    ByteString getContentTypeBytes();

    ByteString getData();
}
