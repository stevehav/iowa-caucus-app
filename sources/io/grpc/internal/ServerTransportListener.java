package io.grpc.internal;

import io.grpc.Attributes;
import io.grpc.Metadata;

public interface ServerTransportListener {
    void streamCreated(ServerStream serverStream, String str, Metadata metadata);

    Attributes transportReady(Attributes attributes);

    void transportTerminated();
}
