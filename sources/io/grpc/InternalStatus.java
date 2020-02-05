package io.grpc;

import io.grpc.Metadata;

@Internal
public final class InternalStatus {
    @Internal
    public static final Metadata.Key<Status> CODE_KEY = Status.CODE_KEY;
    @Internal
    public static final Metadata.Key<String> MESSAGE_KEY = Status.MESSAGE_KEY;

    private InternalStatus() {
    }
}
