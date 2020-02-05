package io.grpc;

import io.grpc.CallCredentials;
import java.util.concurrent.Executor;

@ExperimentalApi("https://github.com/grpc/grpc-java/issues/4901")
@Deprecated
public abstract class CallCredentials2 extends CallCredentials {

    @ExperimentalApi("https://github.com/grpc/grpc-java/issues/1914")
    public static abstract class MetadataApplier extends CallCredentials.MetadataApplier {
    }

    @ExperimentalApi("https://github.com/grpc/grpc-java/issues/1914")
    public abstract void applyRequestMetadata(CallCredentials.RequestInfo requestInfo, Executor executor, MetadataApplier metadataApplier);

    public final void applyRequestMetadata(CallCredentials.RequestInfo requestInfo, Executor executor, final CallCredentials.MetadataApplier metadataApplier) {
        applyRequestMetadata(requestInfo, executor, (MetadataApplier) new MetadataApplier() {
            public void apply(Metadata metadata) {
                metadataApplier.apply(metadata);
            }

            public void fail(Status status) {
                metadataApplier.fail(status);
            }
        });
    }
}
