package io.grpc;

public abstract class ForwardingServerCall<ReqT, RespT> extends PartialForwardingServerCall<ReqT, RespT> {
    /* access modifiers changed from: protected */
    public abstract ServerCall<ReqT, RespT> delegate();

    public /* bridge */ /* synthetic */ void close(Status status, Metadata metadata) {
        super.close(status, metadata);
    }

    @ExperimentalApi("https://github.com/grpc/grpc-java/issues/1779")
    public /* bridge */ /* synthetic */ Attributes getAttributes() {
        return super.getAttributes();
    }

    public /* bridge */ /* synthetic */ String getAuthority() {
        return super.getAuthority();
    }

    public /* bridge */ /* synthetic */ boolean isCancelled() {
        return super.isCancelled();
    }

    public /* bridge */ /* synthetic */ boolean isReady() {
        return super.isReady();
    }

    public /* bridge */ /* synthetic */ void request(int i) {
        super.request(i);
    }

    public /* bridge */ /* synthetic */ void sendHeaders(Metadata metadata) {
        super.sendHeaders(metadata);
    }

    @ExperimentalApi("https://github.com/grpc/grpc-java/issues/1704")
    public /* bridge */ /* synthetic */ void setCompression(String str) {
        super.setCompression(str);
    }

    @ExperimentalApi("https://github.com/grpc/grpc-java/issues/1703")
    public /* bridge */ /* synthetic */ void setMessageCompression(boolean z) {
        super.setMessageCompression(z);
    }

    public /* bridge */ /* synthetic */ String toString() {
        return super.toString();
    }

    public void sendMessage(RespT respt) {
        delegate().sendMessage(respt);
    }

    public static abstract class SimpleForwardingServerCall<ReqT, RespT> extends ForwardingServerCall<ReqT, RespT> {
        private final ServerCall<ReqT, RespT> delegate;

        public /* bridge */ /* synthetic */ void close(Status status, Metadata metadata) {
            ForwardingServerCall.super.close(status, metadata);
        }

        @ExperimentalApi("https://github.com/grpc/grpc-java/issues/1779")
        public /* bridge */ /* synthetic */ Attributes getAttributes() {
            return ForwardingServerCall.super.getAttributes();
        }

        public /* bridge */ /* synthetic */ String getAuthority() {
            return ForwardingServerCall.super.getAuthority();
        }

        public /* bridge */ /* synthetic */ boolean isCancelled() {
            return ForwardingServerCall.super.isCancelled();
        }

        public /* bridge */ /* synthetic */ boolean isReady() {
            return ForwardingServerCall.super.isReady();
        }

        public /* bridge */ /* synthetic */ void request(int i) {
            ForwardingServerCall.super.request(i);
        }

        public /* bridge */ /* synthetic */ void sendHeaders(Metadata metadata) {
            ForwardingServerCall.super.sendHeaders(metadata);
        }

        @ExperimentalApi("https://github.com/grpc/grpc-java/issues/1704")
        public /* bridge */ /* synthetic */ void setCompression(String str) {
            ForwardingServerCall.super.setCompression(str);
        }

        @ExperimentalApi("https://github.com/grpc/grpc-java/issues/1703")
        public /* bridge */ /* synthetic */ void setMessageCompression(boolean z) {
            ForwardingServerCall.super.setMessageCompression(z);
        }

        public /* bridge */ /* synthetic */ String toString() {
            return ForwardingServerCall.super.toString();
        }

        protected SimpleForwardingServerCall(ServerCall<ReqT, RespT> serverCall) {
            this.delegate = serverCall;
        }

        /* access modifiers changed from: protected */
        public ServerCall<ReqT, RespT> delegate() {
            return this.delegate;
        }

        public MethodDescriptor<ReqT, RespT> getMethodDescriptor() {
            return this.delegate.getMethodDescriptor();
        }
    }
}
