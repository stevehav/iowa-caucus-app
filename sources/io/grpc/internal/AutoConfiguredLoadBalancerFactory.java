package io.grpc.internal;

import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Preconditions;
import io.grpc.Attributes;
import io.grpc.ChannelLogger;
import io.grpc.ConnectivityState;
import io.grpc.ConnectivityStateInfo;
import io.grpc.EquivalentAddressGroup;
import io.grpc.LoadBalancer;
import io.grpc.LoadBalancerProvider;
import io.grpc.LoadBalancerRegistry;
import io.grpc.NameResolver;
import io.grpc.Status;
import io.grpc.internal.ServiceConfigUtil;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;
import javax.annotation.Nullable;

public final class AutoConfiguredLoadBalancerFactory extends LoadBalancer.Factory {
    private static final String GRPCLB_POLICY_NAME = "grpclb";
    /* access modifiers changed from: private */
    public static final Logger logger = Logger.getLogger(AutoConfiguredLoadBalancerFactory.class.getName());
    /* access modifiers changed from: private */
    public final String defaultPolicy;
    /* access modifiers changed from: private */
    public final LoadBalancerRegistry registry;

    public AutoConfiguredLoadBalancerFactory(String str) {
        this(LoadBalancerRegistry.getDefaultRegistry(), str);
    }

    @VisibleForTesting
    AutoConfiguredLoadBalancerFactory(LoadBalancerRegistry loadBalancerRegistry, String str) {
        this.registry = (LoadBalancerRegistry) Preconditions.checkNotNull(loadBalancerRegistry, "registry");
        this.defaultPolicy = (String) Preconditions.checkNotNull(str, "defaultPolicy");
    }

    public LoadBalancer newLoadBalancer(LoadBalancer.Helper helper) {
        return new AutoConfiguredLoadBalancer(helper);
    }

    private static final class NoopLoadBalancer extends LoadBalancer {
        public void handleNameResolutionError(Status status) {
        }

        @Deprecated
        public void handleResolvedAddressGroups(List<EquivalentAddressGroup> list, Attributes attributes) {
        }

        public void handleResolvedAddresses(LoadBalancer.ResolvedAddresses resolvedAddresses) {
        }

        public void handleSubchannelState(LoadBalancer.Subchannel subchannel, ConnectivityStateInfo connectivityStateInfo) {
        }

        public void shutdown() {
        }

        private NoopLoadBalancer() {
        }
    }

    @VisibleForTesting
    public final class AutoConfiguredLoadBalancer extends LoadBalancer {
        private LoadBalancer delegate;
        private LoadBalancerProvider delegateProvider;
        private final LoadBalancer.Helper helper;
        private boolean roundRobinDueToGrpclbDepMissing;

        public boolean canHandleEmptyAddressListFromNameResolution() {
            return true;
        }

        AutoConfiguredLoadBalancer(LoadBalancer.Helper helper2) {
            this.helper = helper2;
            this.delegateProvider = AutoConfiguredLoadBalancerFactory.this.registry.getProvider(AutoConfiguredLoadBalancerFactory.this.defaultPolicy);
            LoadBalancerProvider loadBalancerProvider = this.delegateProvider;
            if (loadBalancerProvider != null) {
                this.delegate = loadBalancerProvider.newLoadBalancer(helper2);
                return;
            }
            throw new IllegalStateException("Could not find policy '" + AutoConfiguredLoadBalancerFactory.this.defaultPolicy + "'. Make sure its implementation is either registered to LoadBalancerRegistry or included in META-INF/services/io.grpc.LoadBalancerProvider from your jar files.");
        }

        public void handleResolvedAddresses(LoadBalancer.ResolvedAddresses resolvedAddresses) {
            List<EquivalentAddressGroup> addresses = resolvedAddresses.getAddresses();
            Attributes attributes = resolvedAddresses.getAttributes();
            if (attributes.get(ATTR_LOAD_BALANCING_CONFIG) == null) {
                try {
                    PolicySelection decideLoadBalancerProvider = decideLoadBalancerProvider(addresses, (Map) attributes.get(GrpcAttributes.NAME_RESOLVER_SERVICE_CONFIG));
                    if (this.delegateProvider == null || !decideLoadBalancerProvider.provider.getPolicyName().equals(this.delegateProvider.getPolicyName())) {
                        this.helper.updateBalancingState(ConnectivityState.CONNECTING, new EmptyPicker());
                        this.delegate.shutdown();
                        this.delegateProvider = decideLoadBalancerProvider.provider;
                        LoadBalancer loadBalancer = this.delegate;
                        this.delegate = this.delegateProvider.newLoadBalancer(this.helper);
                        this.helper.getChannelLogger().log(ChannelLogger.ChannelLogLevel.INFO, "Load balancer changed from {0} to {1}", loadBalancer.getClass().getSimpleName(), this.delegate.getClass().getSimpleName());
                    }
                    if (decideLoadBalancerProvider.config != null) {
                        this.helper.getChannelLogger().log(ChannelLogger.ChannelLogLevel.DEBUG, "Load-balancing config: {0}", decideLoadBalancerProvider.config);
                        attributes = attributes.toBuilder().set(ATTR_LOAD_BALANCING_CONFIG, decideLoadBalancerProvider.config).build();
                    }
                    LoadBalancer delegate2 = getDelegate();
                    if (!decideLoadBalancerProvider.serverList.isEmpty() || delegate2.canHandleEmptyAddressListFromNameResolution()) {
                        delegate2.handleResolvedAddresses(LoadBalancer.ResolvedAddresses.newBuilder().setAddresses(decideLoadBalancerProvider.serverList).setAttributes(attributes).build());
                        return;
                    }
                    Status status = Status.UNAVAILABLE;
                    delegate2.handleNameResolutionError(status.withDescription("Name resolver returned no usable address. addrs=" + addresses + ", attrs=" + attributes));
                } catch (PolicyException e) {
                    this.helper.updateBalancingState(ConnectivityState.TRANSIENT_FAILURE, new FailingPicker(Status.INTERNAL.withDescription(e.getMessage())));
                    this.delegate.shutdown();
                    this.delegateProvider = null;
                    this.delegate = new NoopLoadBalancer();
                }
            } else {
                throw new IllegalArgumentException("Unexpected ATTR_LOAD_BALANCING_CONFIG from upstream: " + attributes.get(ATTR_LOAD_BALANCING_CONFIG));
            }
        }

        public void handleNameResolutionError(Status status) {
            getDelegate().handleNameResolutionError(status);
        }

        public void handleSubchannelState(LoadBalancer.Subchannel subchannel, ConnectivityStateInfo connectivityStateInfo) {
            getDelegate().handleSubchannelState(subchannel, connectivityStateInfo);
        }

        public void shutdown() {
            this.delegate.shutdown();
            this.delegate = null;
        }

        @VisibleForTesting
        public LoadBalancer getDelegate() {
            return this.delegate;
        }

        /* access modifiers changed from: package-private */
        @VisibleForTesting
        public void setDelegate(LoadBalancer loadBalancer) {
            this.delegate = loadBalancer;
        }

        /* access modifiers changed from: package-private */
        @VisibleForTesting
        public LoadBalancerProvider getDelegateProvider() {
            return this.delegateProvider;
        }

        /* access modifiers changed from: package-private */
        @VisibleForTesting
        public PolicySelection decideLoadBalancerProvider(List<EquivalentAddressGroup> list, @Nullable Map<String, ?> map) throws PolicyException {
            ArrayList arrayList = new ArrayList();
            boolean z = false;
            for (EquivalentAddressGroup next : list) {
                if (next.getAttributes().get(GrpcAttributes.ATTR_LB_ADDR_AUTHORITY) != null) {
                    z = true;
                } else {
                    arrayList.add(next);
                }
            }
            List<ServiceConfigUtil.LbConfig> unwrapLoadBalancingConfigList = map != null ? ServiceConfigUtil.unwrapLoadBalancingConfigList(ServiceConfigUtil.getLoadBalancingConfigsFromServiceConfig(map)) : null;
            if (unwrapLoadBalancingConfigList != null && !unwrapLoadBalancingConfigList.isEmpty()) {
                LinkedHashSet linkedHashSet = new LinkedHashSet();
                for (ServiceConfigUtil.LbConfig next2 : unwrapLoadBalancingConfigList) {
                    String policyName = next2.getPolicyName();
                    LoadBalancerProvider provider = AutoConfiguredLoadBalancerFactory.this.registry.getProvider(policyName);
                    if (provider == null) {
                        linkedHashSet.add(policyName);
                    } else {
                        if (!linkedHashSet.isEmpty()) {
                            this.helper.getChannelLogger().log(ChannelLogger.ChannelLogLevel.DEBUG, "{0} specified by Service Config are not available", linkedHashSet);
                        }
                        if (!policyName.equals(AutoConfiguredLoadBalancerFactory.GRPCLB_POLICY_NAME)) {
                            list = arrayList;
                        }
                        return new PolicySelection(provider, list, next2.getRawConfigValue());
                    }
                }
                if (!z) {
                    throw new PolicyException("None of " + linkedHashSet + " specified by Service Config are available.");
                }
            }
            if (z) {
                LoadBalancerProvider provider2 = AutoConfiguredLoadBalancerFactory.this.registry.getProvider(AutoConfiguredLoadBalancerFactory.GRPCLB_POLICY_NAME);
                if (provider2 != null) {
                    return new PolicySelection(provider2, list, (Map<String, ?>) null);
                }
                if (!arrayList.isEmpty()) {
                    if (!this.roundRobinDueToGrpclbDepMissing) {
                        this.roundRobinDueToGrpclbDepMissing = true;
                        this.helper.getChannelLogger().log(ChannelLogger.ChannelLogLevel.ERROR, "Found balancer addresses but grpclb runtime is missing. Will use round_robin. Please include grpc-grpclb in your runtime depedencies.");
                        AutoConfiguredLoadBalancerFactory.logger.warning("Found balancer addresses but grpclb runtime is missing. Will use round_robin. Please include grpc-grpclb in your runtime depedencies.");
                    }
                    return new PolicySelection(AutoConfiguredLoadBalancerFactory.this.getProviderOrThrow("round_robin", "received balancer addresses but grpclb runtime is missing"), arrayList, (Map<String, ?>) null);
                }
                throw new PolicyException("Received ONLY balancer addresses but grpclb runtime is missing");
            }
            this.roundRobinDueToGrpclbDepMissing = false;
            AutoConfiguredLoadBalancerFactory autoConfiguredLoadBalancerFactory = AutoConfiguredLoadBalancerFactory.this;
            return new PolicySelection(autoConfiguredLoadBalancerFactory.getProviderOrThrow(autoConfiguredLoadBalancerFactory.defaultPolicy, "using default policy"), list, (Map<String, ?>) null);
        }
    }

    /* access modifiers changed from: private */
    public LoadBalancerProvider getProviderOrThrow(String str, String str2) throws PolicyException {
        LoadBalancerProvider provider = this.registry.getProvider(str);
        if (provider != null) {
            return provider;
        }
        throw new PolicyException("Trying to load '" + str + "' because " + str2 + ", but it's unavailable");
    }

    /* access modifiers changed from: package-private */
    @Nullable
    public NameResolver.ConfigOrError selectLoadBalancerPolicy(Map<String, ?> map) {
        List<ServiceConfigUtil.LbConfig> list;
        if (map != null) {
            try {
                list = ServiceConfigUtil.unwrapLoadBalancingConfigList(ServiceConfigUtil.getLoadBalancingConfigsFromServiceConfig(map));
            } catch (RuntimeException e) {
                return NameResolver.ConfigOrError.fromError(Status.UNKNOWN.withDescription("can't parse load balancer configuration").withCause(e));
            }
        } else {
            list = null;
        }
        if (list == null || list.isEmpty()) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (ServiceConfigUtil.LbConfig next : list) {
            String policyName = next.getPolicyName();
            LoadBalancerProvider provider = this.registry.getProvider(policyName);
            if (provider != null) {
                return NameResolver.ConfigOrError.fromConfig(new PolicySelection(provider, (List<EquivalentAddressGroup>) null, next.getRawConfigValue()));
            }
            arrayList.add(policyName);
        }
        return NameResolver.ConfigOrError.fromError(Status.UNKNOWN.withDescription("None of " + arrayList + " specified by Service Config are available."));
    }

    @VisibleForTesting
    static final class PolicyException extends Exception {
        private static final long serialVersionUID = 1;

        private PolicyException(String str) {
            super(str);
        }
    }

    @VisibleForTesting
    static final class PolicySelection {
        @Nullable
        final Map<String, ?> config;
        final LoadBalancerProvider provider;
        @Nullable
        final List<EquivalentAddressGroup> serverList;

        PolicySelection(LoadBalancerProvider loadBalancerProvider, List<EquivalentAddressGroup> list, @Nullable Map<String, ?> map) {
            this.provider = (LoadBalancerProvider) Preconditions.checkNotNull(loadBalancerProvider, "provider");
            this.serverList = Collections.unmodifiableList((List) Preconditions.checkNotNull(list, "serverList"));
            this.config = map;
        }

        PolicySelection(LoadBalancerProvider loadBalancerProvider, @Nullable Map<String, ?> map) {
            this.provider = (LoadBalancerProvider) Preconditions.checkNotNull(loadBalancerProvider, "provider");
            this.serverList = null;
            this.config = map;
        }
    }

    private static final class EmptyPicker extends LoadBalancer.SubchannelPicker {
        private EmptyPicker() {
        }

        public LoadBalancer.PickResult pickSubchannel(LoadBalancer.PickSubchannelArgs pickSubchannelArgs) {
            return LoadBalancer.PickResult.withNoResult();
        }
    }

    private static final class FailingPicker extends LoadBalancer.SubchannelPicker {
        private final Status failure;

        FailingPicker(Status status) {
            this.failure = status;
        }

        public LoadBalancer.PickResult pickSubchannel(LoadBalancer.PickSubchannelArgs pickSubchannelArgs) {
            return LoadBalancer.PickResult.withError(this.failure);
        }
    }
}
