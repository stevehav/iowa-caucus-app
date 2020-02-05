package io.grpc;

import com.google.common.base.MoreObjects;
import io.grpc.ForwardingChannelBuilder;
import io.grpc.NameResolver;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import javax.annotation.Nullable;

@ExperimentalApi("https://github.com/grpc/grpc-java/issues/3363")
public abstract class ForwardingChannelBuilder<T extends ForwardingChannelBuilder<T>> extends ManagedChannelBuilder<T> {
    /* access modifiers changed from: protected */
    public abstract ManagedChannelBuilder<?> delegate();

    /* access modifiers changed from: protected */
    public final T thisT() {
        return this;
    }

    protected ForwardingChannelBuilder() {
    }

    public static ManagedChannelBuilder<?> forAddress(String str, int i) {
        throw new UnsupportedOperationException("Subclass failed to hide static factory");
    }

    public static ManagedChannelBuilder<?> forTarget(String str) {
        throw new UnsupportedOperationException("Subclass failed to hide static factory");
    }

    public T directExecutor() {
        delegate().directExecutor();
        return thisT();
    }

    public T executor(Executor executor) {
        delegate().executor(executor);
        return thisT();
    }

    public T intercept(List<ClientInterceptor> list) {
        delegate().intercept(list);
        return thisT();
    }

    public T intercept(ClientInterceptor... clientInterceptorArr) {
        delegate().intercept(clientInterceptorArr);
        return thisT();
    }

    public T userAgent(String str) {
        delegate().userAgent(str);
        return thisT();
    }

    public T overrideAuthority(String str) {
        delegate().overrideAuthority(str);
        return thisT();
    }

    @Deprecated
    public T usePlaintext(boolean z) {
        delegate().usePlaintext(z);
        return thisT();
    }

    public T usePlaintext() {
        delegate().usePlaintext();
        return thisT();
    }

    public T useTransportSecurity() {
        delegate().useTransportSecurity();
        return thisT();
    }

    public T nameResolverFactory(NameResolver.Factory factory) {
        delegate().nameResolverFactory(factory);
        return thisT();
    }

    public T defaultLoadBalancingPolicy(String str) {
        delegate().defaultLoadBalancingPolicy(str);
        return thisT();
    }

    public T enableFullStreamDecompression() {
        delegate().enableFullStreamDecompression();
        return thisT();
    }

    public T decompressorRegistry(DecompressorRegistry decompressorRegistry) {
        delegate().decompressorRegistry(decompressorRegistry);
        return thisT();
    }

    public T compressorRegistry(CompressorRegistry compressorRegistry) {
        delegate().compressorRegistry(compressorRegistry);
        return thisT();
    }

    public T idleTimeout(long j, TimeUnit timeUnit) {
        delegate().idleTimeout(j, timeUnit);
        return thisT();
    }

    public T maxInboundMessageSize(int i) {
        delegate().maxInboundMessageSize(i);
        return thisT();
    }

    public T maxInboundMetadataSize(int i) {
        delegate().maxInboundMetadataSize(i);
        return thisT();
    }

    public T keepAliveTime(long j, TimeUnit timeUnit) {
        delegate().keepAliveTime(j, timeUnit);
        return thisT();
    }

    public T keepAliveTimeout(long j, TimeUnit timeUnit) {
        delegate().keepAliveTimeout(j, timeUnit);
        return thisT();
    }

    public T keepAliveWithoutCalls(boolean z) {
        delegate().keepAliveWithoutCalls(z);
        return thisT();
    }

    public T maxRetryAttempts(int i) {
        delegate().maxRetryAttempts(i);
        return thisT();
    }

    public T maxHedgedAttempts(int i) {
        delegate().maxHedgedAttempts(i);
        return thisT();
    }

    public T retryBufferSize(long j) {
        delegate().retryBufferSize(j);
        return thisT();
    }

    public T perRpcBufferLimit(long j) {
        delegate().perRpcBufferLimit(j);
        return thisT();
    }

    public T disableRetry() {
        delegate().disableRetry();
        return thisT();
    }

    public T enableRetry() {
        delegate().enableRetry();
        return thisT();
    }

    public T setBinaryLog(BinaryLog binaryLog) {
        delegate().setBinaryLog(binaryLog);
        return thisT();
    }

    public T maxTraceEvents(int i) {
        delegate().maxTraceEvents(i);
        return thisT();
    }

    public T proxyDetector(ProxyDetector proxyDetector) {
        delegate().proxyDetector(proxyDetector);
        return thisT();
    }

    public T defaultServiceConfig(@Nullable Map<String, ?> map) {
        delegate().defaultServiceConfig(map);
        return thisT();
    }

    public T disableServiceConfigLookUp() {
        delegate().disableServiceConfigLookUp();
        return thisT();
    }

    public ManagedChannel build() {
        return delegate().build();
    }

    public String toString() {
        return MoreObjects.toStringHelper((Object) this).add("delegate", (Object) delegate()).toString();
    }
}
