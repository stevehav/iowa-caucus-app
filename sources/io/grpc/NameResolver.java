package io.grpc;

import androidx.core.app.NotificationCompat;
import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import io.grpc.Attributes;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.net.URI;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import javax.annotation.Nullable;
import javax.annotation.concurrent.ThreadSafe;

@ExperimentalApi("https://github.com/grpc/grpc-java/issues/1770")
public abstract class NameResolver {

    @ExperimentalApi("https://github.com/grpc/grpc-java/issues/4972")
    @Documented
    @Retention(RetentionPolicy.SOURCE)
    public @interface ResolutionResultAttr {
    }

    @ExperimentalApi("https://github.com/grpc/grpc-java/issues/1770")
    @ThreadSafe
    public interface Listener {
        void onAddresses(List<EquivalentAddressGroup> list, Attributes attributes);

        void onError(Status status);
    }

    @ExperimentalApi("https://github.com/grpc/grpc-java/issues/1770")
    public static abstract class ServiceConfigParser {
        public abstract ConfigOrError parseServiceConfig(Map<String, ?> map);
    }

    public abstract String getServiceAuthority();

    public void refresh() {
    }

    public abstract void shutdown();

    public void start(final Listener listener) {
        if (listener instanceof Listener2) {
            start((Listener2) listener);
        } else {
            start((Listener2) new Listener2() {
                public void onError(Status status) {
                    listener.onError(status);
                }

                public void onResult(ResolutionResult resolutionResult) {
                    listener.onAddresses(resolutionResult.getAddresses(), resolutionResult.getAttributes());
                }
            });
        }
    }

    public void start(Listener2 listener2) {
        start((Listener) listener2);
    }

    @ExperimentalApi("https://github.com/grpc/grpc-java/issues/1770")
    public static abstract class Factory {
        @Deprecated
        public static final Attributes.Key<Integer> PARAMS_DEFAULT_PORT = Attributes.Key.create("params-default-port");
        @Deprecated
        private static final Attributes.Key<ServiceConfigParser> PARAMS_PARSER = Attributes.Key.create("params-parser");
        @ExperimentalApi("https://github.com/grpc/grpc-java/issues/5113")
        @Deprecated
        public static final Attributes.Key<ProxyDetector> PARAMS_PROXY_DETECTOR = Attributes.Key.create("params-proxy-detector");
        @Deprecated
        private static final Attributes.Key<SynchronizationContext> PARAMS_SYNC_CONTEXT = Attributes.Key.create("params-sync-context");

        public abstract String getDefaultScheme();

        @Deprecated
        @Nullable
        public NameResolver newNameResolver(URI uri, Attributes attributes) {
            return newNameResolver(uri, Args.newBuilder().setDefaultPort(((Integer) attributes.get(PARAMS_DEFAULT_PORT)).intValue()).setProxyDetector((ProxyDetector) attributes.get(PARAMS_PROXY_DETECTOR)).setSynchronizationContext((SynchronizationContext) attributes.get(PARAMS_SYNC_CONTEXT)).setServiceConfigParser((ServiceConfigParser) attributes.get(PARAMS_PARSER)).build());
        }

        @Deprecated
        @Nullable
        public NameResolver newNameResolver(URI uri, final Helper helper) {
            return newNameResolver(uri, Attributes.newBuilder().set(PARAMS_DEFAULT_PORT, Integer.valueOf(helper.getDefaultPort())).set(PARAMS_PROXY_DETECTOR, helper.getProxyDetector()).set(PARAMS_SYNC_CONTEXT, helper.getSynchronizationContext()).set(PARAMS_PARSER, new ServiceConfigParser() {
                public ConfigOrError parseServiceConfig(Map<String, ?> map) {
                    return helper.parseServiceConfig(map);
                }
            }).build());
        }

        public NameResolver newNameResolver(URI uri, final Args args) {
            return newNameResolver(uri, (Helper) new Helper() {
                public int getDefaultPort() {
                    return args.getDefaultPort();
                }

                public ProxyDetector getProxyDetector() {
                    return args.getProxyDetector();
                }

                public SynchronizationContext getSynchronizationContext() {
                    return args.getSynchronizationContext();
                }

                public ConfigOrError parseServiceConfig(Map<String, ?> map) {
                    return args.getServiceConfigParser().parseServiceConfig(map);
                }
            });
        }
    }

    @ExperimentalApi("https://github.com/grpc/grpc-java/issues/1770")
    public static abstract class Listener2 implements Listener {
        public abstract void onError(Status status);

        public abstract void onResult(ResolutionResult resolutionResult);

        @Deprecated
        public final void onAddresses(List<EquivalentAddressGroup> list, Attributes attributes) {
            onResult(ResolutionResult.newBuilder().setAddresses(list).setAttributes(attributes).build());
        }
    }

    @ExperimentalApi("https://github.com/grpc/grpc-java/issues/1770")
    @Deprecated
    public static abstract class Helper {
        public abstract int getDefaultPort();

        public abstract ProxyDetector getProxyDetector();

        public SynchronizationContext getSynchronizationContext() {
            throw new UnsupportedOperationException("Not implemented");
        }

        public ConfigOrError parseServiceConfig(Map<String, ?> map) {
            throw new UnsupportedOperationException("should have been implemented");
        }
    }

    @ExperimentalApi("https://github.com/grpc/grpc-java/issues/1770")
    public static final class Args {
        private final int defaultPort;
        private final ProxyDetector proxyDetector;
        private final ServiceConfigParser serviceConfigParser;
        private final SynchronizationContext syncContext;

        Args(Integer num, ProxyDetector proxyDetector2, SynchronizationContext synchronizationContext, ServiceConfigParser serviceConfigParser2) {
            this.defaultPort = ((Integer) Preconditions.checkNotNull(num, "defaultPort not set")).intValue();
            this.proxyDetector = (ProxyDetector) Preconditions.checkNotNull(proxyDetector2, "proxyDetector not set");
            this.syncContext = (SynchronizationContext) Preconditions.checkNotNull(synchronizationContext, "syncContext not set");
            this.serviceConfigParser = (ServiceConfigParser) Preconditions.checkNotNull(serviceConfigParser2, "serviceConfigParser not set");
        }

        public int getDefaultPort() {
            return this.defaultPort;
        }

        public ProxyDetector getProxyDetector() {
            return this.proxyDetector;
        }

        public SynchronizationContext getSynchronizationContext() {
            return this.syncContext;
        }

        public ServiceConfigParser getServiceConfigParser() {
            return this.serviceConfigParser;
        }

        public String toString() {
            return MoreObjects.toStringHelper((Object) this).add("defaultPort", this.defaultPort).add("proxyDetector", (Object) this.proxyDetector).add("syncContext", (Object) this.syncContext).add("serviceConfigParser", (Object) this.serviceConfigParser).toString();
        }

        public Builder toBuilder() {
            Builder builder = new Builder();
            builder.setDefaultPort(this.defaultPort);
            builder.setProxyDetector(this.proxyDetector);
            builder.setSynchronizationContext(this.syncContext);
            builder.setServiceConfigParser(this.serviceConfigParser);
            return builder;
        }

        public static Builder newBuilder() {
            return new Builder();
        }

        public static final class Builder {
            private Integer defaultPort;
            private ProxyDetector proxyDetector;
            private ServiceConfigParser serviceConfigParser;
            private SynchronizationContext syncContext;

            Builder() {
            }

            public Builder setDefaultPort(int i) {
                this.defaultPort = Integer.valueOf(i);
                return this;
            }

            public Builder setProxyDetector(ProxyDetector proxyDetector2) {
                this.proxyDetector = (ProxyDetector) Preconditions.checkNotNull(proxyDetector2);
                return this;
            }

            public Builder setSynchronizationContext(SynchronizationContext synchronizationContext) {
                this.syncContext = (SynchronizationContext) Preconditions.checkNotNull(synchronizationContext);
                return this;
            }

            public Builder setServiceConfigParser(ServiceConfigParser serviceConfigParser2) {
                this.serviceConfigParser = (ServiceConfigParser) Preconditions.checkNotNull(serviceConfigParser2);
                return this;
            }

            public Args build() {
                return new Args(this.defaultPort, this.proxyDetector, this.syncContext, this.serviceConfigParser);
            }
        }
    }

    @ExperimentalApi("https://github.com/grpc/grpc-java/issues/1770")
    public static final class ResolutionResult {
        private final List<EquivalentAddressGroup> addresses;
        private final Attributes attributes;
        @Nullable
        private final ConfigOrError serviceConfig;

        ResolutionResult(List<EquivalentAddressGroup> list, Attributes attributes2, ConfigOrError configOrError) {
            this.addresses = Collections.unmodifiableList(new ArrayList(list));
            this.attributes = (Attributes) Preconditions.checkNotNull(attributes2, "attributes");
            this.serviceConfig = configOrError;
        }

        public static Builder newBuilder() {
            return new Builder();
        }

        public Builder toBuilder() {
            return newBuilder().setAddresses(this.addresses).setAttributes(this.attributes).setServiceConfig(this.serviceConfig);
        }

        public List<EquivalentAddressGroup> getAddresses() {
            return this.addresses;
        }

        public Attributes getAttributes() {
            return this.attributes;
        }

        @Nullable
        public ConfigOrError getServiceConfig() {
            return this.serviceConfig;
        }

        public String toString() {
            return MoreObjects.toStringHelper((Object) this).add("addresses", (Object) this.addresses).add("attributes", (Object) this.attributes).add("serviceConfig", (Object) this.serviceConfig).toString();
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof ResolutionResult)) {
                return false;
            }
            ResolutionResult resolutionResult = (ResolutionResult) obj;
            if (!Objects.equal(this.addresses, resolutionResult.addresses) || !Objects.equal(this.attributes, resolutionResult.attributes) || !Objects.equal(this.serviceConfig, resolutionResult.serviceConfig)) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            return Objects.hashCode(this.addresses, this.attributes, this.serviceConfig);
        }

        @ExperimentalApi("https://github.com/grpc/grpc-java/issues/1770")
        public static final class Builder {
            private List<EquivalentAddressGroup> addresses = Collections.emptyList();
            private Attributes attributes = Attributes.EMPTY;
            @Nullable
            private ConfigOrError serviceConfig;

            Builder() {
            }

            public Builder setAddresses(List<EquivalentAddressGroup> list) {
                this.addresses = list;
                return this;
            }

            public Builder setAttributes(Attributes attributes2) {
                this.attributes = attributes2;
                return this;
            }

            public Builder setServiceConfig(@Nullable ConfigOrError configOrError) {
                this.serviceConfig = configOrError;
                return this;
            }

            public ResolutionResult build() {
                return new ResolutionResult(this.addresses, this.attributes, this.serviceConfig);
            }
        }
    }

    @ExperimentalApi("https://github.com/grpc/grpc-java/issues/1770")
    public static final class ConfigOrError {
        static final /* synthetic */ boolean $assertionsDisabled = false;
        private final Object config;
        private final Status status;

        static {
            Class<NameResolver> cls = NameResolver.class;
        }

        public static ConfigOrError fromConfig(Object obj) {
            return new ConfigOrError(obj);
        }

        public static ConfigOrError fromError(Status status2) {
            return new ConfigOrError(status2);
        }

        private ConfigOrError(Object obj) {
            this.config = Preconditions.checkNotNull(obj, "config");
            this.status = null;
        }

        private ConfigOrError(Status status2) {
            this.config = null;
            this.status = (Status) Preconditions.checkNotNull(status2, NotificationCompat.CATEGORY_STATUS);
            Preconditions.checkArgument(!status2.isOk(), "cannot use OK status: %s", (Object) status2);
        }

        @Nullable
        public Object getConfig() {
            return this.config;
        }

        @Nullable
        public Status getError() {
            return this.status;
        }

        public String toString() {
            if (this.config != null) {
                return MoreObjects.toStringHelper((Object) this).add("config", this.config).toString();
            }
            return MoreObjects.toStringHelper((Object) this).add("error", (Object) this.status).toString();
        }
    }
}
