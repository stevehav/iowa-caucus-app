package io.grpc;

import java.util.concurrent.Executor;

public abstract class CallCredentials {

    @ExperimentalApi("https://github.com/grpc/grpc-java/issues/1914")
    public static abstract class MetadataApplier {
        public abstract void apply(Metadata metadata);

        public abstract void fail(Status status);
    }

    @ExperimentalApi("https://github.com/grpc/grpc-java/issues/1914")
    public static abstract class RequestInfo {
        public abstract String getAuthority();

        public abstract MethodDescriptor<?, ?> getMethodDescriptor();

        public abstract SecurityLevel getSecurityLevel();

        public abstract Attributes getTransportAttrs();
    }

    public abstract void applyRequestMetadata(RequestInfo requestInfo, Executor executor, MetadataApplier metadataApplier);

    @ExperimentalApi("https://github.com/grpc/grpc-java/issues/1914")
    public abstract void thisUsesUnstableApi();
}
