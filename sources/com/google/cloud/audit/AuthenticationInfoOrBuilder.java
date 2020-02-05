package com.google.cloud.audit;

import com.google.protobuf.ByteString;
import com.google.protobuf.MessageLiteOrBuilder;

/* compiled from: com.google.firebase:protolite-well-known-types@@16.0.1 */
public interface AuthenticationInfoOrBuilder extends MessageLiteOrBuilder {
    String getPrincipalEmail();

    ByteString getPrincipalEmailBytes();
}
