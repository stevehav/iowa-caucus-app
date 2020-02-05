package io.grpc.internal;

import com.google.common.base.Supplier;
import io.grpc.HttpConnectProxiedSocketAddress;
import io.grpc.ProxiedSocketAddress;
import io.grpc.ProxyDetector;
import java.io.IOException;
import java.net.Authenticator;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.MalformedURLException;
import java.net.PasswordAuthentication;
import java.net.Proxy;
import java.net.ProxySelector;
import java.net.SocketAddress;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Nullable;

class ProxyDetectorImpl implements ProxyDetector {
    private static final AuthenticationProvider DEFAULT_AUTHENTICATOR = new AuthenticationProvider() {
        public PasswordAuthentication requestPasswordAuthentication(String str, InetAddress inetAddress, int i, String str2, String str3, String str4) {
            URL url;
            try {
                url = new URL(str2, str, i, "");
            } catch (MalformedURLException unused) {
                ProxyDetectorImpl.log.log(Level.WARNING, String.format("failed to create URL for Authenticator: %s %s", new Object[]{str2, str}));
                url = null;
            }
            return Authenticator.requestPasswordAuthentication(str, inetAddress, i, str2, str3, str4, url, Authenticator.RequestorType.PROXY);
        }
    };
    private static final Supplier<ProxySelector> DEFAULT_PROXY_SELECTOR = new Supplier<ProxySelector>() {
        public ProxySelector get() {
            return ProxySelector.getDefault();
        }
    };
    @Deprecated
    private static final String GRPC_PROXY_ENV_VAR = "GRPC_PROXY_EXP";
    static final String PROXY_SCHEME = "https";
    /* access modifiers changed from: private */
    public static final Logger log = Logger.getLogger(ProxyDetectorImpl.class.getName());
    private final AuthenticationProvider authenticationProvider;
    private final InetSocketAddress overrideProxyAddress;
    private final Supplier<ProxySelector> proxySelector;

    interface AuthenticationProvider {
        PasswordAuthentication requestPasswordAuthentication(String str, InetAddress inetAddress, int i, String str2, String str3, String str4);
    }

    public ProxyDetectorImpl() {
        this(DEFAULT_PROXY_SELECTOR, DEFAULT_AUTHENTICATOR, System.getenv(GRPC_PROXY_ENV_VAR));
    }

    /* JADX WARNING: type inference failed for: r1v0, types: [com.google.common.base.Supplier<java.net.ProxySelector>, java.lang.Object] */
    /* JADX WARNING: Unknown variable types count: 1 */
    @com.google.common.annotations.VisibleForTesting
    /* Code decompiled incorrectly, please refer to instructions dump. */
    ProxyDetectorImpl(com.google.common.base.Supplier<java.net.ProxySelector> r1, io.grpc.internal.ProxyDetectorImpl.AuthenticationProvider r2, @javax.annotation.Nullable java.lang.String r3) {
        /*
            r0 = this;
            r0.<init>()
            java.lang.Object r1 = com.google.common.base.Preconditions.checkNotNull(r1)
            com.google.common.base.Supplier r1 = (com.google.common.base.Supplier) r1
            r0.proxySelector = r1
            java.lang.Object r1 = com.google.common.base.Preconditions.checkNotNull(r2)
            io.grpc.internal.ProxyDetectorImpl$AuthenticationProvider r1 = (io.grpc.internal.ProxyDetectorImpl.AuthenticationProvider) r1
            r0.authenticationProvider = r1
            if (r3 == 0) goto L_0x001c
            java.net.InetSocketAddress r1 = overrideProxy(r3)
            r0.overrideProxyAddress = r1
            goto L_0x001f
        L_0x001c:
            r1 = 0
            r0.overrideProxyAddress = r1
        L_0x001f:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: io.grpc.internal.ProxyDetectorImpl.<init>(com.google.common.base.Supplier, io.grpc.internal.ProxyDetectorImpl$AuthenticationProvider, java.lang.String):void");
    }

    @Nullable
    public ProxiedSocketAddress proxyFor(SocketAddress socketAddress) throws IOException {
        if (!(socketAddress instanceof InetSocketAddress)) {
            return null;
        }
        if (this.overrideProxyAddress != null) {
            return HttpConnectProxiedSocketAddress.newBuilder().setProxyAddress(this.overrideProxyAddress).setTargetAddress((InetSocketAddress) socketAddress).build();
        }
        return detectProxy((InetSocketAddress) socketAddress);
    }

    private ProxiedSocketAddress detectProxy(InetSocketAddress inetSocketAddress) throws IOException {
        String str = null;
        try {
            try {
                URI uri = new URI("https", (String) null, GrpcUtil.getHost(inetSocketAddress), inetSocketAddress.getPort(), (String) null, (String) null, (String) null);
                ProxySelector proxySelector2 = this.proxySelector.get();
                if (proxySelector2 == null) {
                    log.log(Level.FINE, "proxy selector is null, so continuing without proxy lookup");
                    return null;
                }
                List<Proxy> select = proxySelector2.select(uri);
                if (select.size() > 1) {
                    log.warning("More than 1 proxy detected, gRPC will select the first one");
                }
                Proxy proxy = select.get(0);
                if (proxy.type() == Proxy.Type.DIRECT) {
                    return null;
                }
                InetSocketAddress inetSocketAddress2 = (InetSocketAddress) proxy.address();
                PasswordAuthentication requestPasswordAuthentication = this.authenticationProvider.requestPasswordAuthentication(GrpcUtil.getHost(inetSocketAddress2), inetSocketAddress2.getAddress(), inetSocketAddress2.getPort(), "https", "", (String) null);
                if (inetSocketAddress2.isUnresolved()) {
                    inetSocketAddress2 = new InetSocketAddress(InetAddress.getByName(inetSocketAddress2.getHostName()), inetSocketAddress2.getPort());
                }
                HttpConnectProxiedSocketAddress.Builder proxyAddress = HttpConnectProxiedSocketAddress.newBuilder().setTargetAddress(inetSocketAddress).setProxyAddress(inetSocketAddress2);
                if (requestPasswordAuthentication == null) {
                    return proxyAddress.build();
                }
                HttpConnectProxiedSocketAddress.Builder username = proxyAddress.setUsername(requestPasswordAuthentication.getUserName());
                if (requestPasswordAuthentication.getPassword() != null) {
                    str = new String(requestPasswordAuthentication.getPassword());
                }
                return username.setPassword(str).build();
            } catch (URISyntaxException e) {
                log.log(Level.WARNING, "Failed to construct URI for proxy lookup, proceeding without proxy", e);
                return null;
            }
        } catch (Throwable th) {
            log.log(Level.WARNING, "Failed to get host for proxy lookup, proceeding without proxy", th);
            return null;
        }
    }

    private static InetSocketAddress overrideProxy(String str) {
        if (str == null) {
            return null;
        }
        String[] split = str.split(":", 2);
        int i = 80;
        if (split.length > 1) {
            i = Integer.parseInt(split[1]);
        }
        log.warning("Detected GRPC_PROXY_EXP and will honor it, but this feature will be removed in a future release. Use the JVM flags \"-Dhttps.proxyHost=HOST -Dhttps.proxyPort=PORT\" to set the https proxy for this JVM.");
        return new InetSocketAddress(split[0], i);
    }
}
