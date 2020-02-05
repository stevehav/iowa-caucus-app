package io.grpc;

import javax.annotation.Nullable;

public abstract class ServerCall<ReqT, RespT> {

    public static abstract class Listener<ReqT> {
        public void onCancel() {
        }

        public void onComplete() {
        }

        public void onHalfClose() {
        }

        public void onMessage(ReqT reqt) {
        }

        public void onReady() {
        }
    }

    public abstract void close(Status status, Metadata metadata);

    @ExperimentalApi("https://github.com/grpc/grpc-java/issues/2924")
    @Nullable
    public String getAuthority() {
        return null;
    }

    public abstract MethodDescriptor<ReqT, RespT> getMethodDescriptor();

    public abstract boolean isCancelled();

    public boolean isReady() {
        return true;
    }

    public abstract void request(int i);

    public abstract void sendHeaders(Metadata metadata);

    public abstract void sendMessage(RespT respt);

    @ExperimentalApi("https://github.com/grpc/grpc-java/issues/1704")
    public void setCompression(String str) {
    }

    @ExperimentalApi("https://github.com/grpc/grpc-java/issues/1704")
    public void setMessageCompression(boolean z) {
    }

    @ExperimentalApi("https://github.com/grpc/grpc-java/issues/1779")
    public Attributes getAttributes() {
        return Attributes.EMPTY;
    }
}
