package io.grpc;

import javax.annotation.Nullable;
import javax.annotation.concurrent.ThreadSafe;

@ExperimentalApi("https://github.com/grpc/grpc-java/issues/2861")
@ThreadSafe
public abstract class ServerStreamTracer extends StreamTracer {

    public static abstract class Factory {
        public abstract ServerStreamTracer newServerStreamTracer(String str, Metadata metadata);
    }

    public static abstract class ServerCallInfo<ReqT, RespT> {
        public abstract Attributes getAttributes();

        @Nullable
        public abstract String getAuthority();

        public abstract MethodDescriptor<ReqT, RespT> getMethodDescriptor();
    }

    public Context filterContext(Context context) {
        return context;
    }

    @Deprecated
    public void serverCallStarted(ServerCall<?, ?> serverCall) {
    }

    public void serverCallStarted(ServerCallInfo<?, ?> serverCallInfo) {
        serverCallStarted((ServerCall<?, ?>) ReadOnlyServerCall.create(serverCallInfo));
    }

    @Deprecated
    private static final class ReadOnlyServerCall<ReqT, RespT> extends ForwardingServerCall<ReqT, RespT> {
        private final ServerCallInfo<ReqT, RespT> callInfo;

        public boolean isCancelled() {
            return false;
        }

        public boolean isReady() {
            return false;
        }

        /* access modifiers changed from: private */
        public static <ReqT, RespT> ReadOnlyServerCall<ReqT, RespT> create(ServerCallInfo<ReqT, RespT> serverCallInfo) {
            return new ReadOnlyServerCall<>(serverCallInfo);
        }

        private ReadOnlyServerCall(ServerCallInfo<ReqT, RespT> serverCallInfo) {
            this.callInfo = serverCallInfo;
        }

        public MethodDescriptor<ReqT, RespT> getMethodDescriptor() {
            return this.callInfo.getMethodDescriptor();
        }

        public Attributes getAttributes() {
            return this.callInfo.getAttributes();
        }

        public String getAuthority() {
            return this.callInfo.getAuthority();
        }

        /* access modifiers changed from: protected */
        public ServerCall<ReqT, RespT> delegate() {
            throw new UnsupportedOperationException();
        }
    }
}
