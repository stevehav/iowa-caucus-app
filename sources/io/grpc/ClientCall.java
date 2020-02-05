package io.grpc;

import javax.annotation.Nullable;

public abstract class ClientCall<ReqT, RespT> {

    public static abstract class Listener<T> {
        public void onClose(Status status, Metadata metadata) {
        }

        public void onHeaders(Metadata metadata) {
        }

        public void onMessage(T t) {
        }

        public void onReady() {
        }
    }

    public abstract void cancel(@Nullable String str, @Nullable Throwable th);

    public abstract void halfClose();

    public boolean isReady() {
        return true;
    }

    public abstract void request(int i);

    public abstract void sendMessage(ReqT reqt);

    @ExperimentalApi("https://github.com/grpc/grpc-java/issues/1703")
    public void setMessageCompression(boolean z) {
    }

    public abstract void start(Listener<RespT> listener, Metadata metadata);

    @ExperimentalApi("https://github.com/grpc/grpc-java/issues/2607")
    public Attributes getAttributes() {
        return Attributes.EMPTY;
    }
}
