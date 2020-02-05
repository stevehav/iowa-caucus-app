package io.grpc;

import io.grpc.ServerCall;
import javax.annotation.concurrent.ThreadSafe;

@ThreadSafe
public interface ServerInterceptor {
    <ReqT, RespT> ServerCall.Listener<ReqT> interceptCall(ServerCall<ReqT, RespT> serverCall, Metadata metadata, ServerCallHandler<ReqT, RespT> serverCallHandler);
}
