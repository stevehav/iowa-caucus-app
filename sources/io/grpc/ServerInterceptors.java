package io.grpc;

import com.google.common.base.Preconditions;
import io.grpc.MethodDescriptor;
import io.grpc.ServerCall;
import io.grpc.ServerServiceDefinition;
import java.io.BufferedInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public final class ServerInterceptors {
    private ServerInterceptors() {
    }

    public static ServerServiceDefinition interceptForward(ServerServiceDefinition serverServiceDefinition, ServerInterceptor... serverInterceptorArr) {
        return interceptForward(serverServiceDefinition, (List<? extends ServerInterceptor>) Arrays.asList(serverInterceptorArr));
    }

    public static ServerServiceDefinition interceptForward(BindableService bindableService, ServerInterceptor... serverInterceptorArr) {
        return interceptForward(bindableService.bindService(), (List<? extends ServerInterceptor>) Arrays.asList(serverInterceptorArr));
    }

    public static ServerServiceDefinition interceptForward(ServerServiceDefinition serverServiceDefinition, List<? extends ServerInterceptor> list) {
        ArrayList arrayList = new ArrayList(list);
        Collections.reverse(arrayList);
        return intercept(serverServiceDefinition, (List<? extends ServerInterceptor>) arrayList);
    }

    public static ServerServiceDefinition interceptForward(BindableService bindableService, List<? extends ServerInterceptor> list) {
        return interceptForward(bindableService.bindService(), list);
    }

    public static ServerServiceDefinition intercept(ServerServiceDefinition serverServiceDefinition, ServerInterceptor... serverInterceptorArr) {
        return intercept(serverServiceDefinition, (List<? extends ServerInterceptor>) Arrays.asList(serverInterceptorArr));
    }

    public static ServerServiceDefinition intercept(BindableService bindableService, ServerInterceptor... serverInterceptorArr) {
        Preconditions.checkNotNull(bindableService, "bindableService");
        return intercept(bindableService.bindService(), (List<? extends ServerInterceptor>) Arrays.asList(serverInterceptorArr));
    }

    public static ServerServiceDefinition intercept(ServerServiceDefinition serverServiceDefinition, List<? extends ServerInterceptor> list) {
        Preconditions.checkNotNull(serverServiceDefinition, "serviceDef");
        if (list.isEmpty()) {
            return serverServiceDefinition;
        }
        ServerServiceDefinition.Builder builder = ServerServiceDefinition.builder(serverServiceDefinition.getServiceDescriptor());
        for (ServerMethodDefinition<?, ?> wrapAndAddMethod : serverServiceDefinition.getMethods()) {
            wrapAndAddMethod(builder, wrapAndAddMethod, list);
        }
        return builder.build();
    }

    public static ServerServiceDefinition intercept(BindableService bindableService, List<? extends ServerInterceptor> list) {
        Preconditions.checkNotNull(bindableService, "bindableService");
        return intercept(bindableService.bindService(), list);
    }

    @ExperimentalApi("https://github.com/grpc/grpc-java/issues/1712")
    public static ServerServiceDefinition useInputStreamMessages(ServerServiceDefinition serverServiceDefinition) {
        return useMarshalledMessages(serverServiceDefinition, new MethodDescriptor.Marshaller<InputStream>() {
            public InputStream stream(InputStream inputStream) {
                return inputStream;
            }

            public InputStream parse(InputStream inputStream) {
                if (inputStream.markSupported()) {
                    return inputStream;
                }
                return new BufferedInputStream(inputStream);
            }
        });
    }

    @ExperimentalApi("https://github.com/grpc/grpc-java/issues/1712")
    public static <T> ServerServiceDefinition useMarshalledMessages(ServerServiceDefinition serverServiceDefinition, MethodDescriptor.Marshaller<T> marshaller) {
        ArrayList<ServerMethodDefinition> arrayList = new ArrayList<>();
        ArrayList arrayList2 = new ArrayList();
        for (ServerMethodDefinition next : serverServiceDefinition.getMethods()) {
            MethodDescriptor<NewReqT, NewRespT> build = next.getMethodDescriptor().toBuilder(marshaller, marshaller).build();
            arrayList2.add(build);
            arrayList.add(wrapMethod(next, build));
        }
        ServerServiceDefinition.Builder builder = ServerServiceDefinition.builder(new ServiceDescriptor(serverServiceDefinition.getServiceDescriptor().getName(), (Collection<MethodDescriptor<?, ?>>) arrayList2));
        for (ServerMethodDefinition addMethod : arrayList) {
            builder.addMethod(addMethod);
        }
        return builder.build();
    }

    /* JADX WARNING: type inference failed for: r3v0, types: [io.grpc.ServerMethodDefinition<ReqT, RespT>, io.grpc.ServerMethodDefinition] */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static <ReqT, RespT> void wrapAndAddMethod(io.grpc.ServerServiceDefinition.Builder r2, io.grpc.ServerMethodDefinition<ReqT, RespT> r3, java.util.List<? extends io.grpc.ServerInterceptor> r4) {
        /*
            io.grpc.ServerCallHandler r0 = r3.getServerCallHandler()
            java.util.Iterator r4 = r4.iterator()
        L_0x0008:
            boolean r1 = r4.hasNext()
            if (r1 == 0) goto L_0x0019
            java.lang.Object r1 = r4.next()
            io.grpc.ServerInterceptor r1 = (io.grpc.ServerInterceptor) r1
            io.grpc.ServerInterceptors$InterceptCallHandler r0 = io.grpc.ServerInterceptors.InterceptCallHandler.create(r1, r0)
            goto L_0x0008
        L_0x0019:
            io.grpc.ServerMethodDefinition r3 = r3.withServerCallHandler(r0)
            r2.addMethod(r3)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: io.grpc.ServerInterceptors.wrapAndAddMethod(io.grpc.ServerServiceDefinition$Builder, io.grpc.ServerMethodDefinition, java.util.List):void");
    }

    static final class InterceptCallHandler<ReqT, RespT> implements ServerCallHandler<ReqT, RespT> {
        private final ServerCallHandler<ReqT, RespT> callHandler;
        private final ServerInterceptor interceptor;

        public static <ReqT, RespT> InterceptCallHandler<ReqT, RespT> create(ServerInterceptor serverInterceptor, ServerCallHandler<ReqT, RespT> serverCallHandler) {
            return new InterceptCallHandler<>(serverInterceptor, serverCallHandler);
        }

        private InterceptCallHandler(ServerInterceptor serverInterceptor, ServerCallHandler<ReqT, RespT> serverCallHandler) {
            this.interceptor = (ServerInterceptor) Preconditions.checkNotNull(serverInterceptor, "interceptor");
            this.callHandler = serverCallHandler;
        }

        public ServerCall.Listener<ReqT> startCall(ServerCall<ReqT, RespT> serverCall, Metadata metadata) {
            return this.interceptor.interceptCall(serverCall, metadata, this.callHandler);
        }
    }

    static <OReqT, ORespT, WReqT, WRespT> ServerMethodDefinition<WReqT, WRespT> wrapMethod(ServerMethodDefinition<OReqT, ORespT> serverMethodDefinition, MethodDescriptor<WReqT, WRespT> methodDescriptor) {
        return ServerMethodDefinition.create(methodDescriptor, wrapHandler(serverMethodDefinition.getServerCallHandler(), serverMethodDefinition.getMethodDescriptor(), methodDescriptor));
    }

    private static <OReqT, ORespT, WReqT, WRespT> ServerCallHandler<WReqT, WRespT> wrapHandler(final ServerCallHandler<OReqT, ORespT> serverCallHandler, final MethodDescriptor<OReqT, ORespT> methodDescriptor, final MethodDescriptor<WReqT, WRespT> methodDescriptor2) {
        return new ServerCallHandler<WReqT, WRespT>() {
            public ServerCall.Listener<WReqT> startCall(final ServerCall<WReqT, WRespT> serverCall, Metadata metadata) {
                final ServerCall.Listener startCall = serverCallHandler.startCall(new PartialForwardingServerCall<OReqT, ORespT>() {
                    /* access modifiers changed from: protected */
                    public ServerCall<WReqT, WRespT> delegate() {
                        return serverCall;
                    }

                    public void sendMessage(ORespT orespt) {
                        delegate().sendMessage(methodDescriptor2.parseResponse(MethodDescriptor.this.streamResponse(orespt)));
                    }

                    public MethodDescriptor<OReqT, ORespT> getMethodDescriptor() {
                        return MethodDescriptor.this;
                    }
                }, metadata);
                return new PartialForwardingServerCallListener<WReqT>() {
                    /* access modifiers changed from: protected */
                    public ServerCall.Listener<OReqT> delegate() {
                        return startCall;
                    }

                    public void onMessage(WReqT wreqt) {
                        delegate().onMessage(MethodDescriptor.this.parseRequest(methodDescriptor2.streamRequest(wreqt)));
                    }
                };
            }
        };
    }
}
