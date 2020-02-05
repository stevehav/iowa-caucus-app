package io.grpc.internal;

import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import io.grpc.Attributes;
import io.grpc.ChannelLogger;
import io.grpc.HttpConnectProxiedSocketAddress;
import java.io.Closeable;
import java.net.SocketAddress;
import java.util.concurrent.ScheduledExecutorService;
import javax.annotation.Nullable;

public interface ClientTransportFactory extends Closeable {
    void close();

    ScheduledExecutorService getScheduledExecutorService();

    ConnectionClientTransport newClientTransport(SocketAddress socketAddress, ClientTransportOptions clientTransportOptions, ChannelLogger channelLogger);

    public static final class ClientTransportOptions {
        private String authority = "unknown-authority";
        private ChannelLogger channelLogger;
        @Nullable
        private HttpConnectProxiedSocketAddress connectProxiedSocketAddr;
        private Attributes eagAttributes = Attributes.EMPTY;
        @Nullable
        private String userAgent;

        public ChannelLogger getChannelLogger() {
            return this.channelLogger;
        }

        public ClientTransportOptions setChannelLogger(ChannelLogger channelLogger2) {
            this.channelLogger = channelLogger2;
            return this;
        }

        public String getAuthority() {
            return this.authority;
        }

        public ClientTransportOptions setAuthority(String str) {
            this.authority = (String) Preconditions.checkNotNull(str, "authority");
            return this;
        }

        public Attributes getEagAttributes() {
            return this.eagAttributes;
        }

        public ClientTransportOptions setEagAttributes(Attributes attributes) {
            Preconditions.checkNotNull(attributes, "eagAttributes");
            this.eagAttributes = attributes;
            return this;
        }

        @Nullable
        public String getUserAgent() {
            return this.userAgent;
        }

        public ClientTransportOptions setUserAgent(@Nullable String str) {
            this.userAgent = str;
            return this;
        }

        @Nullable
        public HttpConnectProxiedSocketAddress getHttpConnectProxiedSocketAddress() {
            return this.connectProxiedSocketAddr;
        }

        public ClientTransportOptions setHttpConnectProxiedSocketAddress(@Nullable HttpConnectProxiedSocketAddress httpConnectProxiedSocketAddress) {
            this.connectProxiedSocketAddr = httpConnectProxiedSocketAddress;
            return this;
        }

        public int hashCode() {
            return Objects.hashCode(this.authority, this.eagAttributes, this.userAgent, this.connectProxiedSocketAddr);
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof ClientTransportOptions)) {
                return false;
            }
            ClientTransportOptions clientTransportOptions = (ClientTransportOptions) obj;
            if (!this.authority.equals(clientTransportOptions.authority) || !this.eagAttributes.equals(clientTransportOptions.eagAttributes) || !Objects.equal(this.userAgent, clientTransportOptions.userAgent) || !Objects.equal(this.connectProxiedSocketAddr, clientTransportOptions.connectProxiedSocketAddr)) {
                return false;
            }
            return true;
        }
    }
}
