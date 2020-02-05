package io.grpc.internal;

import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import com.google.common.base.Strings;
import com.google.common.base.Verify;
import io.grpc.MethodDescriptor;
import io.grpc.Status;
import io.grpc.internal.RetriableStream;
import java.util.Collections;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.Nullable;

final class ManagedChannelServiceConfig {
    @Nullable
    private final Object loadBalancingConfig;
    @Nullable
    private final RetriableStream.Throttle retryThrottling;
    private final Map<String, MethodInfo> serviceMap;
    private final Map<String, MethodInfo> serviceMethodMap;

    ManagedChannelServiceConfig(Map<String, MethodInfo> map, Map<String, MethodInfo> map2, @Nullable RetriableStream.Throttle throttle, @Nullable Object obj) {
        this.serviceMethodMap = Collections.unmodifiableMap(new HashMap(map));
        this.serviceMap = Collections.unmodifiableMap(new HashMap(map2));
        this.retryThrottling = throttle;
        this.loadBalancingConfig = obj;
    }

    static ManagedChannelServiceConfig fromServiceConfig(Map<String, ?> map, boolean z, int i, int i2, @Nullable Object obj) {
        RetriableStream.Throttle throttlePolicy = z ? ServiceConfigUtil.getThrottlePolicy(map) : null;
        HashMap hashMap = new HashMap();
        HashMap hashMap2 = new HashMap();
        List<Map<String, ?>> methodConfigFromServiceConfig = ServiceConfigUtil.getMethodConfigFromServiceConfig(map);
        if (methodConfigFromServiceConfig == null) {
            return new ManagedChannelServiceConfig(hashMap, hashMap2, throttlePolicy, obj);
        }
        for (Map next : methodConfigFromServiceConfig) {
            MethodInfo methodInfo = new MethodInfo(next, z, i, i2);
            List<Map<String, ?>> nameListFromMethodConfig = ServiceConfigUtil.getNameListFromMethodConfig(next);
            Preconditions.checkArgument(nameListFromMethodConfig != null && !nameListFromMethodConfig.isEmpty(), "no names in method config %s", (Object) next);
            for (Map next2 : nameListFromMethodConfig) {
                String serviceFromName = ServiceConfigUtil.getServiceFromName(next2);
                Preconditions.checkArgument(!Strings.isNullOrEmpty(serviceFromName), "missing service name");
                String methodFromName = ServiceConfigUtil.getMethodFromName(next2);
                if (Strings.isNullOrEmpty(methodFromName)) {
                    Preconditions.checkArgument(!hashMap2.containsKey(serviceFromName), "Duplicate service %s", (Object) serviceFromName);
                    hashMap2.put(serviceFromName, methodInfo);
                } else {
                    String generateFullMethodName = MethodDescriptor.generateFullMethodName(serviceFromName, methodFromName);
                    Preconditions.checkArgument(!hashMap.containsKey(generateFullMethodName), "Duplicate method name %s", (Object) generateFullMethodName);
                    hashMap.put(generateFullMethodName, methodInfo);
                }
            }
        }
        return new ManagedChannelServiceConfig(hashMap, hashMap2, throttlePolicy, obj);
    }

    /* access modifiers changed from: package-private */
    public Map<String, MethodInfo> getServiceMap() {
        return this.serviceMap;
    }

    /* access modifiers changed from: package-private */
    public Map<String, MethodInfo> getServiceMethodMap() {
        return this.serviceMethodMap;
    }

    /* access modifiers changed from: package-private */
    @Nullable
    @VisibleForTesting
    public Object getLoadBalancingConfig() {
        return this.loadBalancingConfig;
    }

    static final class MethodInfo {
        final HedgingPolicy hedgingPolicy;
        final Integer maxInboundMessageSize;
        final Integer maxOutboundMessageSize;
        final RetryPolicy retryPolicy;
        final Long timeoutNanos;
        final Boolean waitForReady;

        MethodInfo(Map<String, ?> map, boolean z, int i, int i2) {
            this.timeoutNanos = ServiceConfigUtil.getTimeoutFromMethodConfig(map);
            this.waitForReady = ServiceConfigUtil.getWaitForReadyFromMethodConfig(map);
            this.maxInboundMessageSize = ServiceConfigUtil.getMaxResponseMessageBytesFromMethodConfig(map);
            Integer num = this.maxInboundMessageSize;
            boolean z2 = true;
            if (num != null) {
                Preconditions.checkArgument(num.intValue() >= 0, "maxInboundMessageSize %s exceeds bounds", (Object) this.maxInboundMessageSize);
            }
            this.maxOutboundMessageSize = ServiceConfigUtil.getMaxRequestMessageBytesFromMethodConfig(map);
            Integer num2 = this.maxOutboundMessageSize;
            if (num2 != null) {
                Preconditions.checkArgument(num2.intValue() < 0 ? false : z2, "maxOutboundMessageSize %s exceeds bounds", (Object) this.maxOutboundMessageSize);
            }
            Map<String, ?> map2 = null;
            Map<String, ?> retryPolicyFromMethodConfig = z ? ServiceConfigUtil.getRetryPolicyFromMethodConfig(map) : null;
            this.retryPolicy = retryPolicyFromMethodConfig == null ? RetryPolicy.DEFAULT : retryPolicy(retryPolicyFromMethodConfig, i);
            map2 = z ? ServiceConfigUtil.getHedgingPolicyFromMethodConfig(map) : map2;
            this.hedgingPolicy = map2 == null ? HedgingPolicy.DEFAULT : hedgingPolicy(map2, i2);
        }

        public int hashCode() {
            return Objects.hashCode(this.timeoutNanos, this.waitForReady, this.maxInboundMessageSize, this.maxOutboundMessageSize, this.retryPolicy, this.hedgingPolicy);
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof MethodInfo)) {
                return false;
            }
            MethodInfo methodInfo = (MethodInfo) obj;
            if (!Objects.equal(this.timeoutNanos, methodInfo.timeoutNanos) || !Objects.equal(this.waitForReady, methodInfo.waitForReady) || !Objects.equal(this.maxInboundMessageSize, methodInfo.maxInboundMessageSize) || !Objects.equal(this.maxOutboundMessageSize, methodInfo.maxOutboundMessageSize) || !Objects.equal(this.retryPolicy, methodInfo.retryPolicy) || !Objects.equal(this.hedgingPolicy, methodInfo.hedgingPolicy)) {
                return false;
            }
            return true;
        }

        public String toString() {
            return MoreObjects.toStringHelper((Object) this).add("timeoutNanos", (Object) this.timeoutNanos).add("waitForReady", (Object) this.waitForReady).add("maxInboundMessageSize", (Object) this.maxInboundMessageSize).add("maxOutboundMessageSize", (Object) this.maxOutboundMessageSize).add("retryPolicy", (Object) this.retryPolicy).add("hedgingPolicy", (Object) this.hedgingPolicy).toString();
        }

        private static RetryPolicy retryPolicy(Map<String, ?> map, int i) {
            int intValue = ((Integer) Preconditions.checkNotNull(ServiceConfigUtil.getMaxAttemptsFromRetryPolicy(map), "maxAttempts cannot be empty")).intValue();
            Preconditions.checkArgument(intValue >= 2, "maxAttempts must be greater than 1: %s", intValue);
            int min = Math.min(intValue, i);
            long longValue = ((Long) Preconditions.checkNotNull(ServiceConfigUtil.getInitialBackoffNanosFromRetryPolicy(map), "initialBackoff cannot be empty")).longValue();
            Preconditions.checkArgument(longValue > 0, "initialBackoffNanos must be greater than 0: %s", longValue);
            long longValue2 = ((Long) Preconditions.checkNotNull(ServiceConfigUtil.getMaxBackoffNanosFromRetryPolicy(map), "maxBackoff cannot be empty")).longValue();
            Preconditions.checkArgument(longValue2 > 0, "maxBackoff must be greater than 0: %s", longValue2);
            double doubleValue = ((Double) Preconditions.checkNotNull(ServiceConfigUtil.getBackoffMultiplierFromRetryPolicy(map), "backoffMultiplier cannot be empty")).doubleValue();
            Preconditions.checkArgument(doubleValue > 0.0d, "backoffMultiplier must be greater than 0: %s", (Object) Double.valueOf(doubleValue));
            List<String> retryableStatusCodesFromRetryPolicy = ServiceConfigUtil.getRetryableStatusCodesFromRetryPolicy(map);
            Preconditions.checkNotNull(retryableStatusCodesFromRetryPolicy, "rawCodes must be present");
            Preconditions.checkArgument(!retryableStatusCodesFromRetryPolicy.isEmpty(), "rawCodes can't be empty");
            EnumSet<E> noneOf = EnumSet.noneOf(Status.Code.class);
            for (String next : retryableStatusCodesFromRetryPolicy) {
                Verify.verify(!"OK".equals(next), "rawCode can not be \"OK\"", new Object[0]);
                noneOf.add(Status.Code.valueOf(next));
            }
            return new RetryPolicy(min, longValue, longValue2, doubleValue, Collections.unmodifiableSet(noneOf));
        }

        private static HedgingPolicy hedgingPolicy(Map<String, ?> map, int i) {
            int intValue = ((Integer) Preconditions.checkNotNull(ServiceConfigUtil.getMaxAttemptsFromHedgingPolicy(map), "maxAttempts cannot be empty")).intValue();
            Preconditions.checkArgument(intValue >= 2, "maxAttempts must be greater than 1: %s", intValue);
            int min = Math.min(intValue, i);
            long longValue = ((Long) Preconditions.checkNotNull(ServiceConfigUtil.getHedgingDelayNanosFromHedgingPolicy(map), "hedgingDelay cannot be empty")).longValue();
            Preconditions.checkArgument(longValue >= 0, "hedgingDelay must not be negative: %s", longValue);
            List<String> nonFatalStatusCodesFromHedgingPolicy = ServiceConfigUtil.getNonFatalStatusCodesFromHedgingPolicy(map);
            Preconditions.checkNotNull(nonFatalStatusCodesFromHedgingPolicy, "rawCodes must be present");
            Preconditions.checkArgument(!nonFatalStatusCodesFromHedgingPolicy.isEmpty(), "rawCodes can't be empty");
            EnumSet<E> noneOf = EnumSet.noneOf(Status.Code.class);
            for (String next : nonFatalStatusCodesFromHedgingPolicy) {
                Verify.verify(!"OK".equals(next), "rawCode can not be \"OK\"", new Object[0]);
                noneOf.add(Status.Code.valueOf(next));
            }
            return new HedgingPolicy(min, longValue, Collections.unmodifiableSet(noneOf));
        }
    }
}
