package io.grpc;

import com.google.common.util.concurrent.ListenableFuture;

@Internal
public interface InternalInstrumented<T> extends InternalWithLogId {
    ListenableFuture<T> getStats();
}
