package io.grpc.internal;

import com.facebook.react.modules.systeminfo.AndroidInfoHelpers;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.MoreObjects;
import com.google.common.base.Preconditions;
import com.google.common.base.Stopwatch;
import com.google.common.base.Throwables;
import com.google.common.base.Verify;
import com.google.common.base.VerifyException;
import io.grpc.Attributes;
import io.grpc.EquivalentAddressGroup;
import io.grpc.NameResolver;
import io.grpc.ProxiedSocketAddress;
import io.grpc.ProxyDetector;
import io.grpc.Status;
import io.grpc.SynchronizationContext;
import io.grpc.internal.SharedResourceHolder;
import io.sentry.event.EventBuilder;
import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.net.URI;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Nullable;

final class DnsNameResolver extends NameResolver {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    @VisibleForTesting
    static final long DEFAULT_NETWORK_CACHE_TTL_SECONDS = 30;
    private static final String GRPCLB_NAME_PREFIX = "_grpclb._tcp.";
    private static final String JNDI_LOCALHOST_PROPERTY = System.getProperty("io.grpc.internal.DnsNameResolverProvider.enable_jndi_localhost", "false");
    private static final String JNDI_PROPERTY = System.getProperty("io.grpc.internal.DnsNameResolverProvider.enable_jndi", "true");
    private static final String JNDI_SRV_PROPERTY = System.getProperty("io.grpc.internal.DnsNameResolverProvider.enable_grpclb", "false");
    private static final String JNDI_TXT_PROPERTY = System.getProperty("io.grpc.internal.DnsNameResolverProvider.enable_service_config", "false");
    @VisibleForTesting
    static final String NETWORKADDRESS_CACHE_TTL_PROPERTY = "networkaddress.cache.ttl";
    private static final String SERVICE_CONFIG_CHOICE_CLIENT_HOSTNAME_KEY = "clientHostname";
    private static final String SERVICE_CONFIG_CHOICE_CLIENT_LANGUAGE_KEY = "clientLanguage";
    private static final Set<String> SERVICE_CONFIG_CHOICE_KEYS = Collections.unmodifiableSet(new HashSet(Arrays.asList(new String[]{SERVICE_CONFIG_CHOICE_CLIENT_LANGUAGE_KEY, SERVICE_CONFIG_CHOICE_PERCENTAGE_KEY, SERVICE_CONFIG_CHOICE_CLIENT_HOSTNAME_KEY, SERVICE_CONFIG_CHOICE_SERVICE_CONFIG_KEY})));
    private static final String SERVICE_CONFIG_CHOICE_PERCENTAGE_KEY = "percentage";
    private static final String SERVICE_CONFIG_CHOICE_SERVICE_CONFIG_KEY = "serviceConfig";
    private static final String SERVICE_CONFIG_NAME_PREFIX = "_grpc_config.";
    static final String SERVICE_CONFIG_PREFIX = "grpc_config=";
    @VisibleForTesting
    static boolean enableJndi = Boolean.parseBoolean(JNDI_PROPERTY);
    @VisibleForTesting
    static boolean enableJndiLocalhost = Boolean.parseBoolean(JNDI_LOCALHOST_PROPERTY);
    @VisibleForTesting
    static boolean enableSrv = Boolean.parseBoolean(JNDI_SRV_PROPERTY);
    @VisibleForTesting
    static boolean enableTxt = Boolean.parseBoolean(JNDI_TXT_PROPERTY);
    private static String localHostname;
    /* access modifiers changed from: private */
    public static final Logger logger = Logger.getLogger(DnsNameResolver.class.getName());
    private static final ResourceResolverFactory resourceResolverFactory = getResourceResolverFactory(DnsNameResolver.class.getClassLoader());
    /* access modifiers changed from: private */
    public volatile AddressResolver addressResolver = JdkAddressResolver.INSTANCE;
    private final String authority;
    /* access modifiers changed from: private */
    public final long cacheTtlNanos;
    /* access modifiers changed from: private */
    public ResolutionResults cachedResolutionResults;
    private Executor executor;
    private final SharedResourceHolder.Resource<Executor> executorResource;
    /* access modifiers changed from: private */
    public final String host;
    private NameResolver.Listener2 listener;
    /* access modifiers changed from: private */
    public final int port;
    @VisibleForTesting
    final ProxyDetector proxyDetector;
    /* access modifiers changed from: private */
    public final Random random = new Random();
    /* access modifiers changed from: private */
    public boolean resolving;
    private final AtomicReference<ResourceResolver> resourceResolver = new AtomicReference<>();
    private boolean shutdown;
    /* access modifiers changed from: private */
    public final Stopwatch stopwatch;
    /* access modifiers changed from: private */
    public final SynchronizationContext syncContext;

    interface AddressResolver {
        List<InetAddress> resolveAddress(String str) throws Exception;
    }

    interface ResourceResolver {
        List<EquivalentAddressGroup> resolveSrv(AddressResolver addressResolver, String str) throws Exception;

        List<String> resolveTxt(String str) throws Exception;
    }

    interface ResourceResolverFactory {
        @Nullable
        ResourceResolver newResourceResolver();

        @Nullable
        Throwable unavailabilityCause();
    }

    DnsNameResolver(@Nullable String str, String str2, NameResolver.Args args, SharedResourceHolder.Resource<Executor> resource, Stopwatch stopwatch2, boolean z) {
        Preconditions.checkNotNull(args, "args");
        this.executorResource = resource;
        URI create = URI.create("//" + ((String) Preconditions.checkNotNull(str2, AppMeasurementSdk.ConditionalUserProperty.NAME)));
        Preconditions.checkArgument(create.getHost() != null, "Invalid DNS name: %s", (Object) str2);
        this.authority = (String) Preconditions.checkNotNull(create.getAuthority(), "nameUri (%s) doesn't have an authority", (Object) create);
        this.host = create.getHost();
        if (create.getPort() == -1) {
            this.port = args.getDefaultPort();
        } else {
            this.port = create.getPort();
        }
        this.proxyDetector = (ProxyDetector) Preconditions.checkNotNull(args.getProxyDetector(), "proxyDetector");
        this.cacheTtlNanos = getNetworkAddressCacheTtlNanos(z);
        this.stopwatch = (Stopwatch) Preconditions.checkNotNull(stopwatch2, "stopwatch");
        this.syncContext = (SynchronizationContext) Preconditions.checkNotNull(args.getSynchronizationContext(), "syncContext");
    }

    public String getServiceAuthority() {
        return this.authority;
    }

    public void start(NameResolver.Listener2 listener2) {
        Preconditions.checkState(this.listener == null, "already started");
        this.executor = (Executor) SharedResourceHolder.get(this.executorResource);
        this.listener = (NameResolver.Listener2) Preconditions.checkNotNull(listener2, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        resolve();
    }

    public void refresh() {
        Preconditions.checkState(this.listener != null, "not started");
        resolve();
    }

    private final class Resolve implements Runnable {
        private final NameResolver.Listener2 savedListener;

        Resolve(NameResolver.Listener2 listener2) {
            this.savedListener = (NameResolver.Listener2) Preconditions.checkNotNull(listener2, "savedListener");
        }

        public void run() {
            if (DnsNameResolver.logger.isLoggable(Level.FINER)) {
                Logger access$000 = DnsNameResolver.logger;
                access$000.finer("Attempting DNS resolution of " + DnsNameResolver.this.host);
            }
            try {
                resolveInternal();
            } finally {
                DnsNameResolver.this.syncContext.execute(new Runnable() {
                    public void run() {
                        boolean unused = DnsNameResolver.this.resolving = false;
                    }
                });
            }
        }

        /* access modifiers changed from: package-private */
        @VisibleForTesting
        public void resolveInternal() {
            try {
                ProxiedSocketAddress proxyFor = DnsNameResolver.this.proxyDetector.proxyFor(InetSocketAddress.createUnresolved(DnsNameResolver.this.host, DnsNameResolver.this.port));
                if (proxyFor != null) {
                    if (DnsNameResolver.logger.isLoggable(Level.FINER)) {
                        Logger access$000 = DnsNameResolver.logger;
                        access$000.finer("Using proxy address " + proxyFor);
                    }
                    this.savedListener.onResult(NameResolver.ResolutionResult.newBuilder().setAddresses(Collections.singletonList(new EquivalentAddressGroup((SocketAddress) proxyFor))).setAttributes(Attributes.EMPTY).build());
                    return;
                }
                ResourceResolver resourceResolver = null;
                try {
                    if (DnsNameResolver.shouldUseJndi(DnsNameResolver.enableJndi, DnsNameResolver.enableJndiLocalhost, DnsNameResolver.this.host)) {
                        resourceResolver = DnsNameResolver.this.getResourceResolver();
                    }
                    final ResolutionResults resolveAll = DnsNameResolver.resolveAll(DnsNameResolver.this.addressResolver, resourceResolver, DnsNameResolver.enableSrv, DnsNameResolver.enableTxt, DnsNameResolver.this.host);
                    DnsNameResolver.this.syncContext.execute(new Runnable() {
                        public void run() {
                            ResolutionResults unused = DnsNameResolver.this.cachedResolutionResults = resolveAll;
                            if (DnsNameResolver.this.cacheTtlNanos > 0) {
                                DnsNameResolver.this.stopwatch.reset().start();
                            }
                        }
                    });
                    if (DnsNameResolver.logger.isLoggable(Level.FINER)) {
                        Logger access$0002 = DnsNameResolver.logger;
                        access$0002.finer("Found DNS results " + resolveAll + " for " + DnsNameResolver.this.host);
                    }
                    ArrayList arrayList = new ArrayList();
                    for (InetAddress inetSocketAddress : resolveAll.addresses) {
                        arrayList.add(new EquivalentAddressGroup((SocketAddress) new InetSocketAddress(inetSocketAddress, DnsNameResolver.this.port)));
                    }
                    arrayList.addAll(resolveAll.balancerAddresses);
                    if (arrayList.isEmpty()) {
                        NameResolver.Listener2 listener2 = this.savedListener;
                        Status status = Status.UNAVAILABLE;
                        listener2.onError(status.withDescription("No DNS backend or balancer addresses found for " + DnsNameResolver.this.host));
                        return;
                    }
                    Attributes.Builder newBuilder = Attributes.newBuilder();
                    if (!resolveAll.txtRecords.isEmpty()) {
                        NameResolver.ConfigOrError parseServiceConfig = DnsNameResolver.parseServiceConfig(resolveAll.txtRecords, DnsNameResolver.this.random, DnsNameResolver.getLocalHostname());
                        if (parseServiceConfig != null) {
                            if (parseServiceConfig.getError() != null) {
                                this.savedListener.onError(parseServiceConfig.getError());
                                return;
                            } else {
                                newBuilder.set(GrpcAttributes.NAME_RESOLVER_SERVICE_CONFIG, (Map) parseServiceConfig.getConfig());
                            }
                        }
                    } else {
                        DnsNameResolver.logger.log(Level.FINE, "No TXT records found for {0}", new Object[]{DnsNameResolver.this.host});
                    }
                    this.savedListener.onResult(NameResolver.ResolutionResult.newBuilder().setAddresses(arrayList).setAttributes(newBuilder.build()).build());
                } catch (Exception e) {
                    NameResolver.Listener2 listener22 = this.savedListener;
                    Status status2 = Status.UNAVAILABLE;
                    listener22.onError(status2.withDescription("Unable to resolve host " + DnsNameResolver.this.host).withCause(e));
                }
            } catch (IOException e2) {
                NameResolver.Listener2 listener23 = this.savedListener;
                Status status3 = Status.UNAVAILABLE;
                listener23.onError(status3.withDescription("Unable to resolve host " + DnsNameResolver.this.host).withCause(e2));
            }
        }
    }

    @Nullable
    static NameResolver.ConfigOrError parseServiceConfig(List<String> list, Random random2, String str) {
        try {
            Map<String, ?> map = null;
            for (Map maybeChooseServiceConfig : parseTxtResults(list)) {
                try {
                    map = maybeChooseServiceConfig(maybeChooseServiceConfig, random2, str);
                    if (map != null) {
                        break;
                    }
                } catch (RuntimeException e) {
                    return NameResolver.ConfigOrError.fromError(Status.UNKNOWN.withDescription("failed to pick service config choice").withCause(e));
                }
            }
            if (map == null) {
                return null;
            }
            return NameResolver.ConfigOrError.fromConfig(map);
        } catch (IOException | RuntimeException e2) {
            return NameResolver.ConfigOrError.fromError(Status.UNKNOWN.withDescription("failed to parse TXT records").withCause(e2));
        }
    }

    private void resolve() {
        if (!this.resolving && !this.shutdown && cacheRefreshRequired()) {
            this.resolving = true;
            this.executor.execute(new Resolve(this.listener));
        }
    }

    private boolean cacheRefreshRequired() {
        if (this.cachedResolutionResults != null) {
            long j = this.cacheTtlNanos;
            return j == 0 || (j > 0 && this.stopwatch.elapsed(TimeUnit.NANOSECONDS) > this.cacheTtlNanos);
        }
    }

    public void shutdown() {
        if (!this.shutdown) {
            this.shutdown = true;
            Executor executor2 = this.executor;
            if (executor2 != null) {
                this.executor = (Executor) SharedResourceHolder.release(this.executorResource, executor2);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public final int getPort() {
        return this.port;
    }

    @VisibleForTesting
    static ResolutionResults resolveAll(AddressResolver addressResolver2, @Nullable ResourceResolver resourceResolver2, boolean z, boolean z2, String str) {
        Exception e;
        List<InetAddress> emptyList = Collections.emptyList();
        List<EquivalentAddressGroup> emptyList2 = Collections.emptyList();
        List<String> emptyList3 = Collections.emptyList();
        Exception exc = null;
        try {
            emptyList = addressResolver2.resolveAddress(str);
            e = null;
        } catch (Exception e2) {
            e = e2;
        }
        if (resourceResolver2 != null) {
            if (z) {
                try {
                    emptyList2 = resourceResolver2.resolveSrv(addressResolver2, GRPCLB_NAME_PREFIX + str);
                } catch (Exception e3) {
                    e = e3;
                }
            }
            e = null;
            if (z2) {
                boolean z3 = false;
                boolean z4 = !z || e != null;
                if (e != null && z4) {
                    z3 = true;
                }
                if (!z3) {
                    try {
                        emptyList3 = resourceResolver2.resolveTxt(SERVICE_CONFIG_NAME_PREFIX + str);
                    } catch (Exception e4) {
                        exc = e4;
                    }
                }
            }
        } else {
            e = null;
        }
        if (e != null) {
            if (e == null) {
                try {
                    if (!emptyList2.isEmpty()) {
                    }
                } catch (Throwable th) {
                    if (e != null) {
                        logger.log(Level.FINE, "Address resolution failure", e);
                    }
                    if (e != null) {
                        logger.log(Level.FINE, "Balancer resolution failure", e);
                    }
                    if (exc != null) {
                        logger.log(Level.FINE, "ServiceConfig resolution failure", exc);
                    }
                    throw th;
                }
            }
            Throwables.throwIfUnchecked(e);
            throw new RuntimeException(e);
        }
        if (e != null) {
            logger.log(Level.FINE, "Address resolution failure", e);
        }
        if (e != null) {
            logger.log(Level.FINE, "Balancer resolution failure", e);
        }
        if (exc != null) {
            logger.log(Level.FINE, "ServiceConfig resolution failure", exc);
        }
        return new ResolutionResults(emptyList, emptyList3, emptyList2);
    }

    @VisibleForTesting
    static List<Map<String, ?>> parseTxtResults(List<String> list) throws IOException {
        ArrayList arrayList = new ArrayList();
        for (String next : list) {
            if (!next.startsWith(SERVICE_CONFIG_PREFIX)) {
                logger.log(Level.FINE, "Ignoring non service config {0}", new Object[]{next});
            } else {
                Object parse = JsonParser.parse(next.substring(12));
                if (parse instanceof List) {
                    arrayList.addAll(ServiceConfigUtil.checkObjectList((List) parse));
                } else {
                    throw new ClassCastException("wrong type " + parse);
                }
            }
        }
        return arrayList;
    }

    @Nullable
    private static final Double getPercentageFromChoice(Map<String, ?> map) {
        if (!map.containsKey(SERVICE_CONFIG_CHOICE_PERCENTAGE_KEY)) {
            return null;
        }
        return ServiceConfigUtil.getDouble(map, SERVICE_CONFIG_CHOICE_PERCENTAGE_KEY);
    }

    @Nullable
    private static final List<String> getClientLanguagesFromChoice(Map<String, ?> map) {
        if (!map.containsKey(SERVICE_CONFIG_CHOICE_CLIENT_LANGUAGE_KEY)) {
            return null;
        }
        return ServiceConfigUtil.checkStringList(ServiceConfigUtil.getList(map, SERVICE_CONFIG_CHOICE_CLIENT_LANGUAGE_KEY));
    }

    @Nullable
    private static final List<String> getHostnamesFromChoice(Map<String, ?> map) {
        if (!map.containsKey(SERVICE_CONFIG_CHOICE_CLIENT_HOSTNAME_KEY)) {
            return null;
        }
        return ServiceConfigUtil.checkStringList(ServiceConfigUtil.getList(map, SERVICE_CONFIG_CHOICE_CLIENT_HOSTNAME_KEY));
    }

    private static long getNetworkAddressCacheTtlNanos(boolean z) {
        if (z) {
            return 0;
        }
        String property = System.getProperty(NETWORKADDRESS_CACHE_TTL_PROPERTY);
        long j = DEFAULT_NETWORK_CACHE_TTL_SECONDS;
        if (property != null) {
            try {
                j = Long.parseLong(property);
            } catch (NumberFormatException unused) {
                logger.log(Level.WARNING, "Property({0}) valid is not valid number format({1}), fall back to default({2})", new Object[]{NETWORKADDRESS_CACHE_TTL_PROPERTY, property, Long.valueOf(DEFAULT_NETWORK_CACHE_TTL_SECONDS)});
            }
        }
        return j > 0 ? TimeUnit.SECONDS.toNanos(j) : j;
    }

    @Nullable
    @VisibleForTesting
    static Map<String, ?> maybeChooseServiceConfig(Map<String, ?> map, Random random2, String str) {
        boolean z;
        boolean z2;
        for (Map.Entry next : map.entrySet()) {
            Verify.verify(SERVICE_CONFIG_CHOICE_KEYS.contains(next.getKey()), "Bad key: %s", (Object) next);
        }
        List<String> clientLanguagesFromChoice = getClientLanguagesFromChoice(map);
        if (clientLanguagesFromChoice != null && !clientLanguagesFromChoice.isEmpty()) {
            Iterator<String> it = clientLanguagesFromChoice.iterator();
            while (true) {
                if (it.hasNext()) {
                    if (EventBuilder.DEFAULT_PLATFORM.equalsIgnoreCase(it.next())) {
                        z2 = true;
                        break;
                    }
                } else {
                    z2 = false;
                    break;
                }
            }
            if (!z2) {
                return null;
            }
        }
        Double percentageFromChoice = getPercentageFromChoice(map);
        if (percentageFromChoice != null) {
            int intValue = percentageFromChoice.intValue();
            Verify.verify(intValue >= 0 && intValue <= 100, "Bad percentage: %s", (Object) percentageFromChoice);
            if (random2.nextInt(100) >= intValue) {
                return null;
            }
        }
        List<String> hostnamesFromChoice = getHostnamesFromChoice(map);
        if (hostnamesFromChoice != null && !hostnamesFromChoice.isEmpty()) {
            Iterator<String> it2 = hostnamesFromChoice.iterator();
            while (true) {
                if (it2.hasNext()) {
                    if (it2.next().equals(str)) {
                        z = true;
                        break;
                    }
                } else {
                    z = false;
                    break;
                }
            }
            if (!z) {
                return null;
            }
        }
        Map<String, ?> object = ServiceConfigUtil.getObject(map, SERVICE_CONFIG_CHOICE_SERVICE_CONFIG_KEY);
        if (object != null) {
            return object;
        }
        throw new VerifyException(String.format("key '%s' missing in '%s'", new Object[]{map, SERVICE_CONFIG_CHOICE_SERVICE_CONFIG_KEY}));
    }

    @VisibleForTesting
    static final class ResolutionResults {
        final List<? extends InetAddress> addresses;
        final List<EquivalentAddressGroup> balancerAddresses;
        final List<String> txtRecords;

        ResolutionResults(List<? extends InetAddress> list, List<String> list2, List<EquivalentAddressGroup> list3) {
            this.addresses = Collections.unmodifiableList((List) Preconditions.checkNotNull(list, "addresses"));
            this.txtRecords = Collections.unmodifiableList((List) Preconditions.checkNotNull(list2, "txtRecords"));
            this.balancerAddresses = Collections.unmodifiableList((List) Preconditions.checkNotNull(list3, "balancerAddresses"));
        }

        public String toString() {
            return MoreObjects.toStringHelper((Object) this).add("addresses", (Object) this.addresses).add("txtRecords", (Object) this.txtRecords).add("balancerAddresses", (Object) this.balancerAddresses).toString();
        }
    }

    /* access modifiers changed from: package-private */
    @VisibleForTesting
    public void setAddressResolver(AddressResolver addressResolver2) {
        this.addressResolver = addressResolver2;
    }

    /* access modifiers changed from: package-private */
    @VisibleForTesting
    public void setResourceResolver(ResourceResolver resourceResolver2) {
        this.resourceResolver.set(resourceResolver2);
    }

    private enum JdkAddressResolver implements AddressResolver {
        INSTANCE;

        public List<InetAddress> resolveAddress(String str) throws UnknownHostException {
            return Collections.unmodifiableList(Arrays.asList(InetAddress.getAllByName(str)));
        }
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:2:0x000a, code lost:
        r1 = resourceResolverFactory;
     */
    @javax.annotation.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public io.grpc.internal.DnsNameResolver.ResourceResolver getResourceResolver() {
        /*
            r2 = this;
            java.util.concurrent.atomic.AtomicReference<io.grpc.internal.DnsNameResolver$ResourceResolver> r0 = r2.resourceResolver
            java.lang.Object r0 = r0.get()
            io.grpc.internal.DnsNameResolver$ResourceResolver r0 = (io.grpc.internal.DnsNameResolver.ResourceResolver) r0
            if (r0 != 0) goto L_0x0012
            io.grpc.internal.DnsNameResolver$ResourceResolverFactory r1 = resourceResolverFactory
            if (r1 == 0) goto L_0x0012
            io.grpc.internal.DnsNameResolver$ResourceResolver r0 = r1.newResourceResolver()
        L_0x0012:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: io.grpc.internal.DnsNameResolver.getResourceResolver():io.grpc.internal.DnsNameResolver$ResourceResolver");
    }

    @Nullable
    @VisibleForTesting
    static ResourceResolverFactory getResourceResolverFactory(ClassLoader classLoader) {
        try {
            try {
                try {
                    ResourceResolverFactory resourceResolverFactory2 = (ResourceResolverFactory) Class.forName("io.grpc.internal.JndiResourceResolverFactory", true, classLoader).asSubclass(ResourceResolverFactory.class).getConstructor(new Class[0]).newInstance(new Object[0]);
                    if (resourceResolverFactory2.unavailabilityCause() == null) {
                        return resourceResolverFactory2;
                    }
                    logger.log(Level.FINE, "JndiResourceResolverFactory not available, skipping.", resourceResolverFactory2.unavailabilityCause());
                    return null;
                } catch (Exception e) {
                    logger.log(Level.FINE, "Can't construct JndiResourceResolverFactory, skipping.", e);
                    return null;
                }
            } catch (Exception e2) {
                logger.log(Level.FINE, "Can't find JndiResourceResolverFactory ctor, skipping.", e2);
                return null;
            }
        } catch (ClassNotFoundException e3) {
            logger.log(Level.FINE, "Unable to find JndiResourceResolverFactory, skipping.", e3);
            return null;
        }
    }

    /* access modifiers changed from: private */
    public static String getLocalHostname() {
        if (localHostname == null) {
            try {
                localHostname = InetAddress.getLocalHost().getHostName();
            } catch (UnknownHostException e) {
                throw new RuntimeException(e);
            }
        }
        return localHostname;
    }

    @VisibleForTesting
    static boolean shouldUseJndi(boolean z, boolean z2, String str) {
        if (!z) {
            return false;
        }
        if (AndroidInfoHelpers.DEVICE_LOCALHOST.equalsIgnoreCase(str)) {
            return z2;
        }
        if (str.contains(":")) {
            return false;
        }
        boolean z3 = true;
        for (int i = 0; i < str.length(); i++) {
            char charAt = str.charAt(i);
            if (charAt != '.') {
                z3 &= charAt >= '0' && charAt <= '9';
            }
        }
        if (!z3) {
            return true;
        }
        return false;
    }
}
