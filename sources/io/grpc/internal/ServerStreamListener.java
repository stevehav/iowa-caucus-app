package io.grpc.internal;

import io.grpc.Status;

public interface ServerStreamListener extends StreamListener {
    void closed(Status status);

    void halfClosed();
}
