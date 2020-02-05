package io.grpc;

import com.google.common.base.MoreObjects;
import com.google.common.base.Preconditions;
import java.io.InputStream;
import java.util.concurrent.atomic.AtomicReferenceArray;
import javax.annotation.CheckReturnValue;
import javax.annotation.Nullable;
import javax.annotation.concurrent.Immutable;

@Immutable
public final class MethodDescriptor<ReqT, RespT> {
    private final String fullMethodName;
    private final boolean idempotent;
    private final AtomicReferenceArray<Object> rawMethodNames;
    private final Marshaller<ReqT> requestMarshaller;
    private final Marshaller<RespT> responseMarshaller;
    private final boolean safe;
    private final boolean sampledToLocalTracing;
    @Nullable
    private final Object schemaDescriptor;
    @Nullable
    private final String serviceName;
    private final MethodType type;

    public interface Marshaller<T> {
        T parse(InputStream inputStream);

        InputStream stream(T t);
    }

    @ExperimentalApi("https://github.com/grpc/grpc-java/issues/2222")
    public interface PrototypeMarshaller<T> extends ReflectableMarshaller<T> {
        @Nullable
        T getMessagePrototype();
    }

    @ExperimentalApi("https://github.com/grpc/grpc-java/issues/2222")
    public interface ReflectableMarshaller<T> extends Marshaller<T> {
        Class<T> getMessageClass();
    }

    /* access modifiers changed from: package-private */
    public final Object getRawMethodName(int i) {
        return this.rawMethodNames.get(i);
    }

    /* access modifiers changed from: package-private */
    public final void setRawMethodName(int i, Object obj) {
        this.rawMethodNames.lazySet(i, obj);
    }

    public enum MethodType {
        UNARY,
        CLIENT_STREAMING,
        SERVER_STREAMING,
        BIDI_STREAMING,
        UNKNOWN;

        public final boolean clientSendsOneMessage() {
            return this == UNARY || this == SERVER_STREAMING;
        }

        public final boolean serverSendsOneMessage() {
            return this == UNARY || this == CLIENT_STREAMING;
        }
    }

    @Deprecated
    public static <RequestT, ResponseT> MethodDescriptor<RequestT, ResponseT> create(MethodType methodType, String str, Marshaller<RequestT> marshaller, Marshaller<ResponseT> marshaller2) {
        return new MethodDescriptor(methodType, str, marshaller, marshaller2, (Object) null, false, false, false);
    }

    private MethodDescriptor(MethodType methodType, String str, Marshaller<ReqT> marshaller, Marshaller<RespT> marshaller2, Object obj, boolean z, boolean z2, boolean z3) {
        boolean z4 = true;
        this.rawMethodNames = new AtomicReferenceArray<>(1);
        this.type = (MethodType) Preconditions.checkNotNull(methodType, "type");
        this.fullMethodName = (String) Preconditions.checkNotNull(str, "fullMethodName");
        this.serviceName = extractFullServiceName(str);
        this.requestMarshaller = (Marshaller) Preconditions.checkNotNull(marshaller, "requestMarshaller");
        this.responseMarshaller = (Marshaller) Preconditions.checkNotNull(marshaller2, "responseMarshaller");
        this.schemaDescriptor = obj;
        this.idempotent = z;
        this.safe = z2;
        this.sampledToLocalTracing = z3;
        if (z2 && methodType != MethodType.UNARY) {
            z4 = false;
        }
        Preconditions.checkArgument(z4, "Only unary methods can be specified safe");
    }

    public MethodType getType() {
        return this.type;
    }

    public String getFullMethodName() {
        return this.fullMethodName;
    }

    @ExperimentalApi("https://github.com/grpc/grpc-java/issues/5635")
    @Nullable
    public String getServiceName() {
        return this.serviceName;
    }

    public RespT parseResponse(InputStream inputStream) {
        return this.responseMarshaller.parse(inputStream);
    }

    public InputStream streamRequest(ReqT reqt) {
        return this.requestMarshaller.stream(reqt);
    }

    public ReqT parseRequest(InputStream inputStream) {
        return this.requestMarshaller.parse(inputStream);
    }

    public InputStream streamResponse(RespT respt) {
        return this.responseMarshaller.stream(respt);
    }

    @ExperimentalApi("https://github.com/grpc/grpc-java/issues/2592")
    public Marshaller<ReqT> getRequestMarshaller() {
        return this.requestMarshaller;
    }

    @ExperimentalApi("https://github.com/grpc/grpc-java/issues/2592")
    public Marshaller<RespT> getResponseMarshaller() {
        return this.responseMarshaller;
    }

    @Nullable
    public Object getSchemaDescriptor() {
        return this.schemaDescriptor;
    }

    @ExperimentalApi("https://github.com/grpc/grpc-java/issues/1775")
    public boolean isIdempotent() {
        return this.idempotent;
    }

    @ExperimentalApi("https://github.com/grpc/grpc-java/issues/1775")
    public boolean isSafe() {
        return this.safe;
    }

    public boolean isSampledToLocalTracing() {
        return this.sampledToLocalTracing;
    }

    public static String generateFullMethodName(String str, String str2) {
        return ((String) Preconditions.checkNotNull(str, "fullServiceName")) + "/" + ((String) Preconditions.checkNotNull(str2, "methodName"));
    }

    @Nullable
    public static String extractFullServiceName(String str) {
        int lastIndexOf = ((String) Preconditions.checkNotNull(str, "fullMethodName")).lastIndexOf(47);
        if (lastIndexOf == -1) {
            return null;
        }
        return str.substring(0, lastIndexOf);
    }

    @CheckReturnValue
    public static <ReqT, RespT> Builder<ReqT, RespT> newBuilder() {
        return newBuilder((Marshaller) null, (Marshaller) null);
    }

    @CheckReturnValue
    public static <ReqT, RespT> Builder<ReqT, RespT> newBuilder(Marshaller<ReqT> marshaller, Marshaller<RespT> marshaller2) {
        return new Builder().setRequestMarshaller(marshaller).setResponseMarshaller(marshaller2);
    }

    @CheckReturnValue
    public Builder<ReqT, RespT> toBuilder() {
        return toBuilder(this.requestMarshaller, this.responseMarshaller);
    }

    @CheckReturnValue
    public <NewReqT, NewRespT> Builder<NewReqT, NewRespT> toBuilder(Marshaller<NewReqT> marshaller, Marshaller<NewRespT> marshaller2) {
        return newBuilder().setRequestMarshaller(marshaller).setResponseMarshaller(marshaller2).setType(this.type).setFullMethodName(this.fullMethodName).setIdempotent(this.idempotent).setSafe(this.safe).setSampledToLocalTracing(this.sampledToLocalTracing).setSchemaDescriptor(this.schemaDescriptor);
    }

    public static final class Builder<ReqT, RespT> {
        private String fullMethodName;
        private boolean idempotent;
        private Marshaller<ReqT> requestMarshaller;
        private Marshaller<RespT> responseMarshaller;
        private boolean safe;
        private boolean sampledToLocalTracing;
        private Object schemaDescriptor;
        private MethodType type;

        private Builder() {
        }

        public Builder<ReqT, RespT> setRequestMarshaller(Marshaller<ReqT> marshaller) {
            this.requestMarshaller = marshaller;
            return this;
        }

        public Builder<ReqT, RespT> setResponseMarshaller(Marshaller<RespT> marshaller) {
            this.responseMarshaller = marshaller;
            return this;
        }

        public Builder<ReqT, RespT> setType(MethodType methodType) {
            this.type = methodType;
            return this;
        }

        public Builder<ReqT, RespT> setFullMethodName(String str) {
            this.fullMethodName = str;
            return this;
        }

        public Builder<ReqT, RespT> setSchemaDescriptor(@Nullable Object obj) {
            this.schemaDescriptor = obj;
            return this;
        }

        @ExperimentalApi("https://github.com/grpc/grpc-java/issues/1775")
        public Builder<ReqT, RespT> setIdempotent(boolean z) {
            this.idempotent = z;
            return this;
        }

        @ExperimentalApi("https://github.com/grpc/grpc-java/issues/1775")
        public Builder<ReqT, RespT> setSafe(boolean z) {
            this.safe = z;
            return this;
        }

        public Builder<ReqT, RespT> setSampledToLocalTracing(boolean z) {
            this.sampledToLocalTracing = z;
            return this;
        }

        @CheckReturnValue
        public MethodDescriptor<ReqT, RespT> build() {
            return new MethodDescriptor(this.type, this.fullMethodName, this.requestMarshaller, this.responseMarshaller, this.schemaDescriptor, this.idempotent, this.safe, this.sampledToLocalTracing);
        }
    }

    public String toString() {
        return MoreObjects.toStringHelper((Object) this).add("fullMethodName", (Object) this.fullMethodName).add("type", (Object) this.type).add("idempotent", this.idempotent).add("safe", this.safe).add("sampledToLocalTracing", this.sampledToLocalTracing).add("requestMarshaller", (Object) this.requestMarshaller).add("responseMarshaller", (Object) this.responseMarshaller).add("schemaDescriptor", this.schemaDescriptor).omitNullValues().toString();
    }
}
