package io.grpc;

public final class ServerMethodDefinition<ReqT, RespT> {
    private final ServerCallHandler<ReqT, RespT> handler;
    private final MethodDescriptor<ReqT, RespT> method;

    private ServerMethodDefinition(MethodDescriptor<ReqT, RespT> methodDescriptor, ServerCallHandler<ReqT, RespT> serverCallHandler) {
        this.method = methodDescriptor;
        this.handler = serverCallHandler;
    }

    public static <ReqT, RespT> ServerMethodDefinition<ReqT, RespT> create(MethodDescriptor<ReqT, RespT> methodDescriptor, ServerCallHandler<ReqT, RespT> serverCallHandler) {
        return new ServerMethodDefinition<>(methodDescriptor, serverCallHandler);
    }

    public MethodDescriptor<ReqT, RespT> getMethodDescriptor() {
        return this.method;
    }

    public ServerCallHandler<ReqT, RespT> getServerCallHandler() {
        return this.handler;
    }

    public ServerMethodDefinition<ReqT, RespT> withServerCallHandler(ServerCallHandler<ReqT, RespT> serverCallHandler) {
        return new ServerMethodDefinition<>(this.method, serverCallHandler);
    }
}
