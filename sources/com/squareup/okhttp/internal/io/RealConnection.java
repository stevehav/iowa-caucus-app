package com.squareup.okhttp.internal.io;

import com.facebook.react.uimanager.ViewProps;
import com.google.common.net.HttpHeaders;
import com.squareup.okhttp.Address;
import com.squareup.okhttp.Connection;
import com.squareup.okhttp.ConnectionSpec;
import com.squareup.okhttp.Handshake;
import com.squareup.okhttp.HttpUrl;
import com.squareup.okhttp.Protocol;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;
import com.squareup.okhttp.Route;
import com.squareup.okhttp.internal.ConnectionSpecSelector;
import com.squareup.okhttp.internal.Platform;
import com.squareup.okhttp.internal.Util;
import com.squareup.okhttp.internal.Version;
import com.squareup.okhttp.internal.framed.FramedConnection;
import com.squareup.okhttp.internal.http.Http1xStream;
import com.squareup.okhttp.internal.http.OkHeaders;
import com.squareup.okhttp.internal.http.RouteException;
import com.squareup.okhttp.internal.http.StreamAllocation;
import com.squareup.okhttp.internal.tls.TrustRootIndex;
import java.io.IOException;
import java.lang.ref.Reference;
import java.net.ConnectException;
import java.net.Proxy;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.net.UnknownServiceException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.net.ssl.SSLSocketFactory;
import okio.BufferedSink;
import okio.BufferedSource;
import okio.Okio;
import okio.Source;

public final class RealConnection implements Connection {
    private static SSLSocketFactory lastSslSocketFactory;
    private static TrustRootIndex lastTrustRootIndex;
    public final List<Reference<StreamAllocation>> allocations = new ArrayList();
    public volatile FramedConnection framedConnection;
    private Handshake handshake;
    public long idleAtNanos = Long.MAX_VALUE;
    public boolean noNewStreams;
    private Protocol protocol;
    private Socket rawSocket;
    private final Route route;
    public BufferedSink sink;
    public Socket socket;
    public BufferedSource source;
    public int streamCount;

    public RealConnection(Route route2) {
        this.route = route2;
    }

    public void connect(int i, int i2, int i3, List<ConnectionSpec> list, boolean z) throws RouteException {
        Socket socket2;
        if (this.protocol == null) {
            ConnectionSpecSelector connectionSpecSelector = new ConnectionSpecSelector(list);
            Proxy proxy = this.route.getProxy();
            Address address = this.route.getAddress();
            if (this.route.getAddress().getSslSocketFactory() != null || list.contains(ConnectionSpec.CLEARTEXT)) {
                RouteException routeException = null;
                while (this.protocol == null) {
                    try {
                        if (proxy.type() != Proxy.Type.DIRECT) {
                            if (proxy.type() != Proxy.Type.HTTP) {
                                socket2 = new Socket(proxy);
                                this.rawSocket = socket2;
                                connectSocket(i, i2, i3, connectionSpecSelector);
                            }
                        }
                        socket2 = address.getSocketFactory().createSocket();
                        this.rawSocket = socket2;
                        connectSocket(i, i2, i3, connectionSpecSelector);
                    } catch (IOException e) {
                        Util.closeQuietly(this.socket);
                        Util.closeQuietly(this.rawSocket);
                        this.socket = null;
                        this.rawSocket = null;
                        this.source = null;
                        this.sink = null;
                        this.handshake = null;
                        this.protocol = null;
                        if (routeException == null) {
                            routeException = new RouteException(e);
                        } else {
                            routeException.addConnectException(e);
                        }
                        if (!z || !connectionSpecSelector.connectionFailed(e)) {
                            throw routeException;
                        }
                    }
                }
                return;
            }
            throw new RouteException(new UnknownServiceException("CLEARTEXT communication not supported: " + list));
        }
        throw new IllegalStateException("already connected");
    }

    private void connectSocket(int i, int i2, int i3, ConnectionSpecSelector connectionSpecSelector) throws IOException {
        this.rawSocket.setSoTimeout(i2);
        try {
            Platform.get().connectSocket(this.rawSocket, this.route.getSocketAddress(), i);
            this.source = Okio.buffer(Okio.source(this.rawSocket));
            this.sink = Okio.buffer(Okio.sink(this.rawSocket));
            if (this.route.getAddress().getSslSocketFactory() != null) {
                connectTls(i2, i3, connectionSpecSelector);
            } else {
                this.protocol = Protocol.HTTP_1_1;
                this.socket = this.rawSocket;
            }
            if (this.protocol == Protocol.SPDY_3 || this.protocol == Protocol.HTTP_2) {
                this.socket.setSoTimeout(0);
                FramedConnection build = new FramedConnection.Builder(true).socket(this.socket, this.route.getAddress().url().host(), this.source, this.sink).protocol(this.protocol).build();
                build.sendConnectionPreface();
                this.framedConnection = build;
            }
        } catch (ConnectException unused) {
            throw new ConnectException("Failed to connect to " + this.route.getSocketAddress());
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v2, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v3, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v7, resolved type: javax.net.ssl.SSLSocket} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v4, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v7, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v8, resolved type: java.lang.String} */
    /* JADX WARNING: type inference failed for: r7v2, types: [java.net.Socket, javax.net.ssl.SSLSocket] */
    /* JADX WARNING: type inference failed for: r7v5 */
    /* JADX WARNING: type inference failed for: r7v8 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x0126 A[Catch:{ all -> 0x011c }] */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x012c A[Catch:{ all -> 0x011c }] */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x012f  */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void connectTls(int r6, int r7, com.squareup.okhttp.internal.ConnectionSpecSelector r8) throws java.io.IOException {
        /*
            r5 = this;
            com.squareup.okhttp.Route r0 = r5.route
            boolean r0 = r0.requiresTunnel()
            if (r0 == 0) goto L_0x000b
            r5.createTunnel(r6, r7)
        L_0x000b:
            com.squareup.okhttp.Route r6 = r5.route
            com.squareup.okhttp.Address r6 = r6.getAddress()
            javax.net.ssl.SSLSocketFactory r7 = r6.getSslSocketFactory()
            r0 = 0
            java.net.Socket r1 = r5.rawSocket     // Catch:{ AssertionError -> 0x011f }
            java.lang.String r2 = r6.getUriHost()     // Catch:{ AssertionError -> 0x011f }
            int r3 = r6.getUriPort()     // Catch:{ AssertionError -> 0x011f }
            r4 = 1
            java.net.Socket r7 = r7.createSocket(r1, r2, r3, r4)     // Catch:{ AssertionError -> 0x011f }
            javax.net.ssl.SSLSocket r7 = (javax.net.ssl.SSLSocket) r7     // Catch:{ AssertionError -> 0x011f }
            com.squareup.okhttp.ConnectionSpec r8 = r8.configureSecureSocket(r7)     // Catch:{ AssertionError -> 0x0119, all -> 0x0117 }
            boolean r1 = r8.supportsTlsExtensions()     // Catch:{ AssertionError -> 0x0119, all -> 0x0117 }
            if (r1 == 0) goto L_0x0040
            com.squareup.okhttp.internal.Platform r1 = com.squareup.okhttp.internal.Platform.get()     // Catch:{ AssertionError -> 0x0119, all -> 0x0117 }
            java.lang.String r2 = r6.getUriHost()     // Catch:{ AssertionError -> 0x0119, all -> 0x0117 }
            java.util.List r3 = r6.getProtocols()     // Catch:{ AssertionError -> 0x0119, all -> 0x0117 }
            r1.configureTlsExtensions(r7, r2, r3)     // Catch:{ AssertionError -> 0x0119, all -> 0x0117 }
        L_0x0040:
            r7.startHandshake()     // Catch:{ AssertionError -> 0x0119, all -> 0x0117 }
            javax.net.ssl.SSLSession r1 = r7.getSession()     // Catch:{ AssertionError -> 0x0119, all -> 0x0117 }
            com.squareup.okhttp.Handshake r1 = com.squareup.okhttp.Handshake.get(r1)     // Catch:{ AssertionError -> 0x0119, all -> 0x0117 }
            javax.net.ssl.HostnameVerifier r2 = r6.getHostnameVerifier()     // Catch:{ AssertionError -> 0x0119, all -> 0x0117 }
            java.lang.String r3 = r6.getUriHost()     // Catch:{ AssertionError -> 0x0119, all -> 0x0117 }
            javax.net.ssl.SSLSession r4 = r7.getSession()     // Catch:{ AssertionError -> 0x0119, all -> 0x0117 }
            boolean r2 = r2.verify(r3, r4)     // Catch:{ AssertionError -> 0x0119, all -> 0x0117 }
            if (r2 == 0) goto L_0x00c4
            com.squareup.okhttp.CertificatePinner r2 = r6.getCertificatePinner()     // Catch:{ AssertionError -> 0x0119, all -> 0x0117 }
            com.squareup.okhttp.CertificatePinner r3 = com.squareup.okhttp.CertificatePinner.DEFAULT     // Catch:{ AssertionError -> 0x0119, all -> 0x0117 }
            if (r2 == r3) goto L_0x0085
            javax.net.ssl.SSLSocketFactory r2 = r6.getSslSocketFactory()     // Catch:{ AssertionError -> 0x0119, all -> 0x0117 }
            com.squareup.okhttp.internal.tls.TrustRootIndex r2 = trustRootIndex(r2)     // Catch:{ AssertionError -> 0x0119, all -> 0x0117 }
            com.squareup.okhttp.internal.tls.CertificateChainCleaner r3 = new com.squareup.okhttp.internal.tls.CertificateChainCleaner     // Catch:{ AssertionError -> 0x0119, all -> 0x0117 }
            r3.<init>(r2)     // Catch:{ AssertionError -> 0x0119, all -> 0x0117 }
            java.util.List r2 = r1.peerCertificates()     // Catch:{ AssertionError -> 0x0119, all -> 0x0117 }
            java.util.List r2 = r3.clean(r2)     // Catch:{ AssertionError -> 0x0119, all -> 0x0117 }
            com.squareup.okhttp.CertificatePinner r3 = r6.getCertificatePinner()     // Catch:{ AssertionError -> 0x0119, all -> 0x0117 }
            java.lang.String r6 = r6.getUriHost()     // Catch:{ AssertionError -> 0x0119, all -> 0x0117 }
            r3.check((java.lang.String) r6, (java.util.List<java.security.cert.Certificate>) r2)     // Catch:{ AssertionError -> 0x0119, all -> 0x0117 }
        L_0x0085:
            boolean r6 = r8.supportsTlsExtensions()     // Catch:{ AssertionError -> 0x0119, all -> 0x0117 }
            if (r6 == 0) goto L_0x0093
            com.squareup.okhttp.internal.Platform r6 = com.squareup.okhttp.internal.Platform.get()     // Catch:{ AssertionError -> 0x0119, all -> 0x0117 }
            java.lang.String r0 = r6.getSelectedProtocol(r7)     // Catch:{ AssertionError -> 0x0119, all -> 0x0117 }
        L_0x0093:
            r5.socket = r7     // Catch:{ AssertionError -> 0x0119, all -> 0x0117 }
            java.net.Socket r6 = r5.socket     // Catch:{ AssertionError -> 0x0119, all -> 0x0117 }
            okio.Source r6 = okio.Okio.source((java.net.Socket) r6)     // Catch:{ AssertionError -> 0x0119, all -> 0x0117 }
            okio.BufferedSource r6 = okio.Okio.buffer((okio.Source) r6)     // Catch:{ AssertionError -> 0x0119, all -> 0x0117 }
            r5.source = r6     // Catch:{ AssertionError -> 0x0119, all -> 0x0117 }
            java.net.Socket r6 = r5.socket     // Catch:{ AssertionError -> 0x0119, all -> 0x0117 }
            okio.Sink r6 = okio.Okio.sink((java.net.Socket) r6)     // Catch:{ AssertionError -> 0x0119, all -> 0x0117 }
            okio.BufferedSink r6 = okio.Okio.buffer((okio.Sink) r6)     // Catch:{ AssertionError -> 0x0119, all -> 0x0117 }
            r5.sink = r6     // Catch:{ AssertionError -> 0x0119, all -> 0x0117 }
            r5.handshake = r1     // Catch:{ AssertionError -> 0x0119, all -> 0x0117 }
            if (r0 == 0) goto L_0x00b6
            com.squareup.okhttp.Protocol r6 = com.squareup.okhttp.Protocol.get(r0)     // Catch:{ AssertionError -> 0x0119, all -> 0x0117 }
            goto L_0x00b8
        L_0x00b6:
            com.squareup.okhttp.Protocol r6 = com.squareup.okhttp.Protocol.HTTP_1_1     // Catch:{ AssertionError -> 0x0119, all -> 0x0117 }
        L_0x00b8:
            r5.protocol = r6     // Catch:{ AssertionError -> 0x0119, all -> 0x0117 }
            if (r7 == 0) goto L_0x00c3
            com.squareup.okhttp.internal.Platform r6 = com.squareup.okhttp.internal.Platform.get()
            r6.afterHandshake(r7)
        L_0x00c3:
            return
        L_0x00c4:
            java.util.List r8 = r1.peerCertificates()     // Catch:{ AssertionError -> 0x0119, all -> 0x0117 }
            r0 = 0
            java.lang.Object r8 = r8.get(r0)     // Catch:{ AssertionError -> 0x0119, all -> 0x0117 }
            java.security.cert.X509Certificate r8 = (java.security.cert.X509Certificate) r8     // Catch:{ AssertionError -> 0x0119, all -> 0x0117 }
            javax.net.ssl.SSLPeerUnverifiedException r0 = new javax.net.ssl.SSLPeerUnverifiedException     // Catch:{ AssertionError -> 0x0119, all -> 0x0117 }
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ AssertionError -> 0x0119, all -> 0x0117 }
            r1.<init>()     // Catch:{ AssertionError -> 0x0119, all -> 0x0117 }
            java.lang.String r2 = "Hostname "
            r1.append(r2)     // Catch:{ AssertionError -> 0x0119, all -> 0x0117 }
            java.lang.String r6 = r6.getUriHost()     // Catch:{ AssertionError -> 0x0119, all -> 0x0117 }
            r1.append(r6)     // Catch:{ AssertionError -> 0x0119, all -> 0x0117 }
            java.lang.String r6 = " not verified:"
            r1.append(r6)     // Catch:{ AssertionError -> 0x0119, all -> 0x0117 }
            java.lang.String r6 = "\n    certificate: "
            r1.append(r6)     // Catch:{ AssertionError -> 0x0119, all -> 0x0117 }
            java.lang.String r6 = com.squareup.okhttp.CertificatePinner.pin(r8)     // Catch:{ AssertionError -> 0x0119, all -> 0x0117 }
            r1.append(r6)     // Catch:{ AssertionError -> 0x0119, all -> 0x0117 }
            java.lang.String r6 = "\n    DN: "
            r1.append(r6)     // Catch:{ AssertionError -> 0x0119, all -> 0x0117 }
            java.security.Principal r6 = r8.getSubjectDN()     // Catch:{ AssertionError -> 0x0119, all -> 0x0117 }
            java.lang.String r6 = r6.getName()     // Catch:{ AssertionError -> 0x0119, all -> 0x0117 }
            r1.append(r6)     // Catch:{ AssertionError -> 0x0119, all -> 0x0117 }
            java.lang.String r6 = "\n    subjectAltNames: "
            r1.append(r6)     // Catch:{ AssertionError -> 0x0119, all -> 0x0117 }
            java.util.List r6 = com.squareup.okhttp.internal.tls.OkHostnameVerifier.allSubjectAltNames(r8)     // Catch:{ AssertionError -> 0x0119, all -> 0x0117 }
            r1.append(r6)     // Catch:{ AssertionError -> 0x0119, all -> 0x0117 }
            java.lang.String r6 = r1.toString()     // Catch:{ AssertionError -> 0x0119, all -> 0x0117 }
            r0.<init>(r6)     // Catch:{ AssertionError -> 0x0119, all -> 0x0117 }
            throw r0     // Catch:{ AssertionError -> 0x0119, all -> 0x0117 }
        L_0x0117:
            r6 = move-exception
            goto L_0x012d
        L_0x0119:
            r6 = move-exception
            r0 = r7
            goto L_0x0120
        L_0x011c:
            r6 = move-exception
            r7 = r0
            goto L_0x012d
        L_0x011f:
            r6 = move-exception
        L_0x0120:
            boolean r7 = com.squareup.okhttp.internal.Util.isAndroidGetsocknameError(r6)     // Catch:{ all -> 0x011c }
            if (r7 == 0) goto L_0x012c
            java.io.IOException r7 = new java.io.IOException     // Catch:{ all -> 0x011c }
            r7.<init>(r6)     // Catch:{ all -> 0x011c }
            throw r7     // Catch:{ all -> 0x011c }
        L_0x012c:
            throw r6     // Catch:{ all -> 0x011c }
        L_0x012d:
            if (r7 == 0) goto L_0x0136
            com.squareup.okhttp.internal.Platform r8 = com.squareup.okhttp.internal.Platform.get()
            r8.afterHandshake(r7)
        L_0x0136:
            com.squareup.okhttp.internal.Util.closeQuietly((java.net.Socket) r7)
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.squareup.okhttp.internal.io.RealConnection.connectTls(int, int, com.squareup.okhttp.internal.ConnectionSpecSelector):void");
    }

    private static synchronized TrustRootIndex trustRootIndex(SSLSocketFactory sSLSocketFactory) {
        TrustRootIndex trustRootIndex;
        synchronized (RealConnection.class) {
            if (sSLSocketFactory != lastSslSocketFactory) {
                lastTrustRootIndex = Platform.get().trustRootIndex(Platform.get().trustManager(sSLSocketFactory));
                lastSslSocketFactory = sSLSocketFactory;
            }
            trustRootIndex = lastTrustRootIndex;
        }
        return trustRootIndex;
    }

    private void createTunnel(int i, int i2) throws IOException {
        Request createTunnelRequest = createTunnelRequest();
        HttpUrl httpUrl = createTunnelRequest.httpUrl();
        String str = "CONNECT " + httpUrl.host() + ":" + httpUrl.port() + " HTTP/1.1";
        do {
            Http1xStream http1xStream = new Http1xStream((StreamAllocation) null, this.source, this.sink);
            this.source.timeout().timeout((long) i, TimeUnit.MILLISECONDS);
            this.sink.timeout().timeout((long) i2, TimeUnit.MILLISECONDS);
            http1xStream.writeRequest(createTunnelRequest.headers(), str);
            http1xStream.finishRequest();
            Response build = http1xStream.readResponse().request(createTunnelRequest).build();
            long contentLength = OkHeaders.contentLength(build);
            if (contentLength == -1) {
                contentLength = 0;
            }
            Source newFixedLengthSource = http1xStream.newFixedLengthSource(contentLength);
            Util.skipAll(newFixedLengthSource, Integer.MAX_VALUE, TimeUnit.MILLISECONDS);
            newFixedLengthSource.close();
            int code = build.code();
            if (code != 200) {
                if (code == 407) {
                    createTunnelRequest = OkHeaders.processAuthHeader(this.route.getAddress().getAuthenticator(), build, this.route.getProxy());
                } else {
                    throw new IOException("Unexpected response code for CONNECT: " + build.code());
                }
            } else if (!this.source.buffer().exhausted() || !this.sink.buffer().exhausted()) {
                throw new IOException("TLS tunnel buffered too many bytes!");
            } else {
                return;
            }
        } while (createTunnelRequest != null);
        throw new IOException("Failed to authenticate with proxy");
    }

    private Request createTunnelRequest() throws IOException {
        return new Request.Builder().url(this.route.getAddress().url()).header(HttpHeaders.HOST, Util.hostHeader(this.route.getAddress().url())).header("Proxy-Connection", "Keep-Alive").header(HttpHeaders.USER_AGENT, Version.userAgent()).build();
    }

    /* access modifiers changed from: package-private */
    public boolean isConnected() {
        return this.protocol != null;
    }

    public Route getRoute() {
        return this.route;
    }

    public void cancel() {
        Util.closeQuietly(this.rawSocket);
    }

    public Socket getSocket() {
        return this.socket;
    }

    public int allocationLimit() {
        FramedConnection framedConnection2 = this.framedConnection;
        if (framedConnection2 != null) {
            return framedConnection2.maxConcurrentStreams();
        }
        return 1;
    }

    public boolean isHealthy(boolean z) {
        int soTimeout;
        if (this.socket.isClosed() || this.socket.isInputShutdown() || this.socket.isOutputShutdown()) {
            return false;
        }
        if (this.framedConnection == null && z) {
            try {
                soTimeout = this.socket.getSoTimeout();
                this.socket.setSoTimeout(1);
                if (this.source.exhausted()) {
                    this.socket.setSoTimeout(soTimeout);
                    return false;
                }
                this.socket.setSoTimeout(soTimeout);
                return true;
            } catch (SocketTimeoutException unused) {
            } catch (IOException unused2) {
                return false;
            } catch (Throwable th) {
                this.socket.setSoTimeout(soTimeout);
                throw th;
            }
        }
        return true;
    }

    public Handshake getHandshake() {
        return this.handshake;
    }

    public boolean isMultiplexed() {
        return this.framedConnection != null;
    }

    public Protocol getProtocol() {
        Protocol protocol2 = this.protocol;
        return protocol2 != null ? protocol2 : Protocol.HTTP_1_1;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Connection{");
        sb.append(this.route.getAddress().url().host());
        sb.append(":");
        sb.append(this.route.getAddress().url().port());
        sb.append(", proxy=");
        sb.append(this.route.getProxy());
        sb.append(" hostAddress=");
        sb.append(this.route.getSocketAddress());
        sb.append(" cipherSuite=");
        Handshake handshake2 = this.handshake;
        sb.append(handshake2 != null ? handshake2.cipherSuite() : ViewProps.NONE);
        sb.append(" protocol=");
        sb.append(this.protocol);
        sb.append('}');
        return sb.toString();
    }
}
