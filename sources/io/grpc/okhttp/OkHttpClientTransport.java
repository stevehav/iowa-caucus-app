package io.grpc.okhttp;

import android.support.v4.media.session.PlaybackStateCompat;
import com.facebook.common.util.UriUtil;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.MoreObjects;
import com.google.common.base.Preconditions;
import com.google.common.base.Stopwatch;
import com.google.common.base.Supplier;
import com.google.common.net.HttpHeaders;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.SettableFuture;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.squareup.okhttp.Credentials;
import com.squareup.okhttp.HttpUrl;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.internal.http.StatusLine;
import io.grpc.Attributes;
import io.grpc.CallOptions;
import io.grpc.Grpc;
import io.grpc.HttpConnectProxiedSocketAddress;
import io.grpc.InternalChannelz;
import io.grpc.InternalLogId;
import io.grpc.Metadata;
import io.grpc.MethodDescriptor;
import io.grpc.SecurityLevel;
import io.grpc.Status;
import io.grpc.StatusException;
import io.grpc.internal.ClientStreamListener;
import io.grpc.internal.ConnectionClientTransport;
import io.grpc.internal.GrpcAttributes;
import io.grpc.internal.GrpcUtil;
import io.grpc.internal.Http2Ping;
import io.grpc.internal.InUseStateAggregator;
import io.grpc.internal.KeepAliveManager;
import io.grpc.internal.ManagedClientTransport;
import io.grpc.internal.SerializingExecutor;
import io.grpc.internal.SharedResourceHolder;
import io.grpc.internal.StatsTraceContext;
import io.grpc.internal.TransportTracer;
import io.grpc.okhttp.ExceptionHandlingFrameWriter;
import io.grpc.okhttp.OkHttpClientStream;
import io.grpc.okhttp.OkHttpFrameLogger;
import io.grpc.okhttp.internal.ConnectionSpec;
import io.grpc.okhttp.internal.framed.ErrorCode;
import io.grpc.okhttp.internal.framed.FrameReader;
import io.grpc.okhttp.internal.framed.FrameWriter;
import io.grpc.okhttp.internal.framed.Header;
import io.grpc.okhttp.internal.framed.HeadersMode;
import io.grpc.okhttp.internal.framed.Http2;
import io.grpc.okhttp.internal.framed.Settings;
import java.io.EOFException;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketAddress;
import java.net.URI;
import java.util.Collections;
import java.util.EnumMap;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Nullable;
import javax.annotation.concurrent.GuardedBy;
import javax.net.SocketFactory;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import okio.Buffer;
import okio.BufferedSink;
import okio.BufferedSource;
import okio.ByteString;
import okio.Okio;
import okio.Sink;
import okio.Source;
import okio.Timeout;

class OkHttpClientTransport implements ConnectionClientTransport, ExceptionHandlingFrameWriter.TransportExceptionHandler {
    private static final OkHttpClientStream[] EMPTY_STREAM_ARRAY = new OkHttpClientStream[0];
    private static final Map<ErrorCode, Status> ERROR_CODE_TO_STATUS = buildErrorCodeToStatusMap();
    /* access modifiers changed from: private */
    public static final Logger log = Logger.getLogger(OkHttpClientTransport.class.getName());
    /* access modifiers changed from: private */
    public final InetSocketAddress address;
    /* access modifiers changed from: private */
    public Attributes attributes;
    /* access modifiers changed from: private */
    public ClientFrameHandler clientFrameHandler;
    SettableFuture<Void> connectedFuture;
    Runnable connectingCallback;
    /* access modifiers changed from: private */
    public final ConnectionSpec connectionSpec;
    /* access modifiers changed from: private */
    public int connectionUnacknowledgedBytesRead;
    private final String defaultAuthority;
    private boolean enableKeepAlive;
    /* access modifiers changed from: private */
    public final Executor executor;
    /* access modifiers changed from: private */
    @GuardedBy("lock")
    public ExceptionHandlingFrameWriter frameWriter;
    @GuardedBy("lock")
    private boolean goAwaySent;
    @GuardedBy("lock")
    private Status goAwayStatus;
    @GuardedBy("lock")
    private boolean hasStream;
    /* access modifiers changed from: private */
    public HostnameVerifier hostnameVerifier;
    @GuardedBy("lock")
    private final InUseStateAggregator<OkHttpClientStream> inUseState;
    /* access modifiers changed from: private */
    public final int initialWindowSize;
    /* access modifiers changed from: private */
    public KeepAliveManager keepAliveManager;
    private long keepAliveTimeNanos;
    private long keepAliveTimeoutNanos;
    private boolean keepAliveWithoutCalls;
    /* access modifiers changed from: private */
    public ManagedClientTransport.Listener listener;
    /* access modifiers changed from: private */
    public final Object lock;
    private final InternalLogId logId;
    /* access modifiers changed from: private */
    @GuardedBy("lock")
    public int maxConcurrentStreams;
    /* access modifiers changed from: private */
    public final int maxInboundMetadataSize;
    private final int maxMessageSize;
    @GuardedBy("lock")
    private int nextStreamId;
    /* access modifiers changed from: private */
    public OutboundFlowController outboundFlow;
    @GuardedBy("lock")
    private final LinkedList<OkHttpClientStream> pendingStreams;
    /* access modifiers changed from: private */
    @GuardedBy("lock")
    public Http2Ping ping;
    @Nullable
    @VisibleForTesting
    final HttpConnectProxiedSocketAddress proxiedAddr;
    private final Random random;
    private ScheduledExecutorService scheduler;
    /* access modifiers changed from: private */
    @GuardedBy("lock")
    public InternalChannelz.Security securityInfo;
    private final SerializingExecutor serializingExecutor;
    /* access modifiers changed from: private */
    public Socket socket;
    /* access modifiers changed from: private */
    public final SocketFactory socketFactory;
    /* access modifiers changed from: private */
    public SSLSocketFactory sslSocketFactory;
    @GuardedBy("lock")
    private boolean stopped;
    private final Supplier<Stopwatch> stopwatchFactory;
    /* access modifiers changed from: private */
    @GuardedBy("lock")
    public final Map<Integer, OkHttpClientStream> streams;
    /* access modifiers changed from: private */
    public OkHttpFrameLogger testFrameLogger;
    /* access modifiers changed from: private */
    public FrameReader testFrameReader;
    private FrameWriter testFrameWriter;
    /* access modifiers changed from: private */
    public final Runnable tooManyPingsRunnable;
    @GuardedBy("lock")
    private final TransportTracer transportTracer;
    private final String userAgent;

    static /* synthetic */ int access$2312(OkHttpClientTransport okHttpClientTransport, int i) {
        int i2 = okHttpClientTransport.connectionUnacknowledgedBytesRead + i;
        okHttpClientTransport.connectionUnacknowledgedBytesRead = i2;
        return i2;
    }

    private static Map<ErrorCode, Status> buildErrorCodeToStatusMap() {
        EnumMap enumMap = new EnumMap(ErrorCode.class);
        enumMap.put(ErrorCode.NO_ERROR, Status.INTERNAL.withDescription("No error: A GRPC status of OK should have been sent"));
        enumMap.put(ErrorCode.PROTOCOL_ERROR, Status.INTERNAL.withDescription("Protocol error"));
        enumMap.put(ErrorCode.INTERNAL_ERROR, Status.INTERNAL.withDescription("Internal error"));
        enumMap.put(ErrorCode.FLOW_CONTROL_ERROR, Status.INTERNAL.withDescription("Flow control error"));
        enumMap.put(ErrorCode.STREAM_CLOSED, Status.INTERNAL.withDescription("Stream closed"));
        enumMap.put(ErrorCode.FRAME_TOO_LARGE, Status.INTERNAL.withDescription("Frame too large"));
        enumMap.put(ErrorCode.REFUSED_STREAM, Status.UNAVAILABLE.withDescription("Refused stream"));
        enumMap.put(ErrorCode.CANCEL, Status.CANCELLED.withDescription("Cancelled"));
        enumMap.put(ErrorCode.COMPRESSION_ERROR, Status.INTERNAL.withDescription("Compression error"));
        enumMap.put(ErrorCode.CONNECT_ERROR, Status.INTERNAL.withDescription("Connect error"));
        enumMap.put(ErrorCode.ENHANCE_YOUR_CALM, Status.RESOURCE_EXHAUSTED.withDescription("Enhance your calm"));
        enumMap.put(ErrorCode.INADEQUATE_SECURITY, Status.PERMISSION_DENIED.withDescription("Inadequate security"));
        return Collections.unmodifiableMap(enumMap);
    }

    OkHttpClientTransport(InetSocketAddress inetSocketAddress, String str, @Nullable String str2, Attributes attributes2, Executor executor2, @Nullable SocketFactory socketFactory2, @Nullable SSLSocketFactory sSLSocketFactory, @Nullable HostnameVerifier hostnameVerifier2, ConnectionSpec connectionSpec2, int i, int i2, @Nullable HttpConnectProxiedSocketAddress httpConnectProxiedSocketAddress, Runnable runnable, int i3, TransportTracer transportTracer2) {
        Executor executor3 = executor2;
        this.random = new Random();
        this.lock = new Object();
        this.streams = new HashMap();
        this.maxConcurrentStreams = 0;
        this.pendingStreams = new LinkedList<>();
        this.inUseState = new InUseStateAggregator<OkHttpClientStream>() {
            /* access modifiers changed from: protected */
            public void handleInUse() {
                OkHttpClientTransport.this.listener.transportInUse(true);
            }

            /* access modifiers changed from: protected */
            public void handleNotInUse() {
                OkHttpClientTransport.this.listener.transportInUse(false);
            }
        };
        InetSocketAddress inetSocketAddress2 = inetSocketAddress;
        this.address = (InetSocketAddress) Preconditions.checkNotNull(inetSocketAddress, "address");
        this.defaultAuthority = str;
        this.maxMessageSize = i;
        this.initialWindowSize = i2;
        this.executor = (Executor) Preconditions.checkNotNull(executor2, "executor");
        this.serializingExecutor = new SerializingExecutor(executor2);
        this.nextStreamId = 3;
        this.socketFactory = socketFactory2 == null ? SocketFactory.getDefault() : socketFactory2;
        this.sslSocketFactory = sSLSocketFactory;
        this.hostnameVerifier = hostnameVerifier2;
        ConnectionSpec connectionSpec3 = connectionSpec2;
        this.connectionSpec = (ConnectionSpec) Preconditions.checkNotNull(connectionSpec2, "connectionSpec");
        this.stopwatchFactory = GrpcUtil.STOPWATCH_SUPPLIER;
        String str3 = str2;
        this.userAgent = GrpcUtil.getGrpcUserAgent("okhttp", str2);
        this.proxiedAddr = httpConnectProxiedSocketAddress;
        this.tooManyPingsRunnable = (Runnable) Preconditions.checkNotNull(runnable, "tooManyPingsRunnable");
        this.maxInboundMetadataSize = i3;
        this.transportTracer = (TransportTracer) Preconditions.checkNotNull(transportTracer2);
        this.logId = InternalLogId.allocate(getClass(), inetSocketAddress.toString());
        Attributes attributes3 = attributes2;
        this.attributes = Attributes.newBuilder().set(GrpcAttributes.ATTR_CLIENT_EAG_ATTRS, attributes2).build();
        initTransportTracer();
    }

    @VisibleForTesting
    OkHttpClientTransport(String str, Executor executor2, FrameReader frameReader, FrameWriter frameWriter2, OkHttpFrameLogger okHttpFrameLogger, int i, Socket socket2, Supplier<Stopwatch> supplier, @Nullable Runnable runnable, SettableFuture<Void> settableFuture, int i2, int i3, Runnable runnable2, TransportTracer transportTracer2) {
        this.random = new Random();
        this.lock = new Object();
        this.streams = new HashMap();
        this.maxConcurrentStreams = 0;
        this.pendingStreams = new LinkedList<>();
        this.inUseState = new InUseStateAggregator<OkHttpClientStream>() {
            /* access modifiers changed from: protected */
            public void handleInUse() {
                OkHttpClientTransport.this.listener.transportInUse(true);
            }

            /* access modifiers changed from: protected */
            public void handleNotInUse() {
                OkHttpClientTransport.this.listener.transportInUse(false);
            }
        };
        this.address = null;
        this.maxMessageSize = i2;
        this.initialWindowSize = i3;
        this.defaultAuthority = "notarealauthority:80";
        this.userAgent = GrpcUtil.getGrpcUserAgent("okhttp", str);
        this.executor = (Executor) Preconditions.checkNotNull(executor2, "executor");
        this.serializingExecutor = new SerializingExecutor(executor2);
        this.socketFactory = SocketFactory.getDefault();
        this.testFrameReader = (FrameReader) Preconditions.checkNotNull(frameReader, "frameReader");
        this.testFrameWriter = (FrameWriter) Preconditions.checkNotNull(frameWriter2, "testFrameWriter");
        this.testFrameLogger = (OkHttpFrameLogger) Preconditions.checkNotNull(okHttpFrameLogger, "testFrameLogger");
        this.socket = (Socket) Preconditions.checkNotNull(socket2, "socket");
        this.nextStreamId = i;
        this.stopwatchFactory = supplier;
        this.connectionSpec = null;
        this.connectingCallback = runnable;
        this.connectedFuture = (SettableFuture) Preconditions.checkNotNull(settableFuture, "connectedFuture");
        this.proxiedAddr = null;
        this.tooManyPingsRunnable = (Runnable) Preconditions.checkNotNull(runnable2, "tooManyPingsRunnable");
        this.maxInboundMetadataSize = Integer.MAX_VALUE;
        this.transportTracer = (TransportTracer) Preconditions.checkNotNull(transportTracer2, "transportTracer");
        this.logId = InternalLogId.allocate(getClass(), String.valueOf(socket2.getInetAddress()));
        initTransportTracer();
    }

    private void initTransportTracer() {
        synchronized (this.lock) {
            this.transportTracer.setFlowControlWindowReader(new TransportTracer.FlowControlReader() {
                public TransportTracer.FlowControlWindows read() {
                    TransportTracer.FlowControlWindows flowControlWindows;
                    synchronized (OkHttpClientTransport.this.lock) {
                        flowControlWindows = new TransportTracer.FlowControlWindows(-1, OkHttpClientTransport.this.outboundFlow == null ? -1 : (long) OkHttpClientTransport.this.outboundFlow.windowUpdate((OkHttpClientStream) null, 0));
                    }
                    return flowControlWindows;
                }
            });
        }
    }

    /* access modifiers changed from: package-private */
    public void enableKeepAlive(boolean z, long j, long j2, boolean z2) {
        this.enableKeepAlive = z;
        this.keepAliveTimeNanos = j;
        this.keepAliveTimeoutNanos = j2;
        this.keepAliveWithoutCalls = z2;
    }

    private boolean isForTest() {
        return this.address == null;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0052, code lost:
        r1.addCallback(r9, r10);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0055, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void ping(io.grpc.internal.ClientTransport.PingCallback r9, java.util.concurrent.Executor r10) {
        /*
            r8 = this;
            java.lang.Object r0 = r8.lock
            monitor-enter(r0)
            io.grpc.okhttp.ExceptionHandlingFrameWriter r1 = r8.frameWriter     // Catch:{ all -> 0x0056 }
            r2 = 1
            r3 = 0
            if (r1 == 0) goto L_0x000b
            r1 = 1
            goto L_0x000c
        L_0x000b:
            r1 = 0
        L_0x000c:
            com.google.common.base.Preconditions.checkState(r1)     // Catch:{ all -> 0x0056 }
            boolean r1 = r8.stopped     // Catch:{ all -> 0x0056 }
            if (r1 == 0) goto L_0x001c
            java.lang.Throwable r1 = r8.getPingFailure()     // Catch:{ all -> 0x0056 }
            io.grpc.internal.Http2Ping.notifyFailed(r9, r10, r1)     // Catch:{ all -> 0x0056 }
            monitor-exit(r0)     // Catch:{ all -> 0x0056 }
            return
        L_0x001c:
            io.grpc.internal.Http2Ping r1 = r8.ping     // Catch:{ all -> 0x0056 }
            if (r1 == 0) goto L_0x0026
            io.grpc.internal.Http2Ping r1 = r8.ping     // Catch:{ all -> 0x0056 }
            r4 = 0
            r2 = 0
            goto L_0x0044
        L_0x0026:
            java.util.Random r1 = r8.random     // Catch:{ all -> 0x0056 }
            long r4 = r1.nextLong()     // Catch:{ all -> 0x0056 }
            com.google.common.base.Supplier<com.google.common.base.Stopwatch> r1 = r8.stopwatchFactory     // Catch:{ all -> 0x0056 }
            java.lang.Object r1 = r1.get()     // Catch:{ all -> 0x0056 }
            com.google.common.base.Stopwatch r1 = (com.google.common.base.Stopwatch) r1     // Catch:{ all -> 0x0056 }
            r1.start()     // Catch:{ all -> 0x0056 }
            io.grpc.internal.Http2Ping r6 = new io.grpc.internal.Http2Ping     // Catch:{ all -> 0x0056 }
            r6.<init>(r4, r1)     // Catch:{ all -> 0x0056 }
            r8.ping = r6     // Catch:{ all -> 0x0056 }
            io.grpc.internal.TransportTracer r1 = r8.transportTracer     // Catch:{ all -> 0x0056 }
            r1.reportKeepAliveSent()     // Catch:{ all -> 0x0056 }
            r1 = r6
        L_0x0044:
            if (r2 == 0) goto L_0x0051
            io.grpc.okhttp.ExceptionHandlingFrameWriter r2 = r8.frameWriter     // Catch:{ all -> 0x0056 }
            r6 = 32
            long r6 = r4 >>> r6
            int r7 = (int) r6     // Catch:{ all -> 0x0056 }
            int r5 = (int) r4     // Catch:{ all -> 0x0056 }
            r2.ping(r3, r7, r5)     // Catch:{ all -> 0x0056 }
        L_0x0051:
            monitor-exit(r0)     // Catch:{ all -> 0x0056 }
            r1.addCallback(r9, r10)
            return
        L_0x0056:
            r9 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x0056 }
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: io.grpc.okhttp.OkHttpClientTransport.ping(io.grpc.internal.ClientTransport$PingCallback, java.util.concurrent.Executor):void");
    }

    public OkHttpClientStream newStream(MethodDescriptor<?, ?> methodDescriptor, Metadata metadata, CallOptions callOptions) {
        Object obj;
        Metadata metadata2 = metadata;
        Preconditions.checkNotNull(methodDescriptor, FirebaseAnalytics.Param.METHOD);
        Preconditions.checkNotNull(metadata2, "headers");
        StatsTraceContext newClientContext = StatsTraceContext.newClientContext(callOptions, this.attributes, metadata2);
        Object obj2 = this.lock;
        synchronized (obj2) {
            try {
                obj = obj2;
                OkHttpClientStream okHttpClientStream = new OkHttpClientStream(methodDescriptor, metadata, this.frameWriter, this, this.outboundFlow, this.lock, this.maxMessageSize, this.initialWindowSize, this.defaultAuthority, this.userAgent, newClientContext, this.transportTracer, callOptions);
                return okHttpClientStream;
            } catch (Throwable th) {
                th = th;
                throw th;
            }
        }
    }

    /* access modifiers changed from: package-private */
    @GuardedBy("lock")
    public void streamReadyToStart(OkHttpClientStream okHttpClientStream) {
        if (this.goAwayStatus != null) {
            okHttpClientStream.transportState().transportReportStatus(this.goAwayStatus, ClientStreamListener.RpcProgress.REFUSED, true, new Metadata());
        } else if (this.streams.size() >= this.maxConcurrentStreams) {
            this.pendingStreams.add(okHttpClientStream);
            setInUse(okHttpClientStream);
        } else {
            startStream(okHttpClientStream);
        }
    }

    @GuardedBy("lock")
    private void startStream(OkHttpClientStream okHttpClientStream) {
        Preconditions.checkState(okHttpClientStream.id() == -1, "StreamId already assigned");
        this.streams.put(Integer.valueOf(this.nextStreamId), okHttpClientStream);
        setInUse(okHttpClientStream);
        okHttpClientStream.transportState().start(this.nextStreamId);
        if (!(okHttpClientStream.getType() == MethodDescriptor.MethodType.UNARY || okHttpClientStream.getType() == MethodDescriptor.MethodType.SERVER_STREAMING) || okHttpClientStream.useGet()) {
            this.frameWriter.flush();
        }
        int i = this.nextStreamId;
        if (i >= 2147483645) {
            this.nextStreamId = Integer.MAX_VALUE;
            startGoAway(Integer.MAX_VALUE, ErrorCode.NO_ERROR, Status.UNAVAILABLE.withDescription("Stream ids exhausted"));
            return;
        }
        this.nextStreamId = i + 2;
    }

    /* access modifiers changed from: private */
    @GuardedBy("lock")
    public boolean startPendingStreams() {
        boolean z = false;
        while (!this.pendingStreams.isEmpty() && this.streams.size() < this.maxConcurrentStreams) {
            startStream(this.pendingStreams.poll());
            z = true;
        }
        return z;
    }

    /* access modifiers changed from: package-private */
    @GuardedBy("lock")
    public void removePendingStream(OkHttpClientStream okHttpClientStream) {
        this.pendingStreams.remove(okHttpClientStream);
        maybeClearInUse(okHttpClientStream);
    }

    public Runnable start(ManagedClientTransport.Listener listener2) {
        this.listener = (ManagedClientTransport.Listener) Preconditions.checkNotNull(listener2, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        if (this.enableKeepAlive) {
            this.scheduler = (ScheduledExecutorService) SharedResourceHolder.get(GrpcUtil.TIMER_SERVICE);
            this.keepAliveManager = new KeepAliveManager(new KeepAliveManager.ClientKeepAlivePinger(this), this.scheduler, this.keepAliveTimeNanos, this.keepAliveTimeoutNanos, this.keepAliveWithoutCalls);
            this.keepAliveManager.onTransportStarted();
        }
        if (isForTest()) {
            synchronized (this.lock) {
                this.frameWriter = new ExceptionHandlingFrameWriter(this, this.testFrameWriter, this.testFrameLogger);
                this.outboundFlow = new OutboundFlowController(this, this.frameWriter, this.initialWindowSize);
            }
            this.serializingExecutor.execute(new Runnable() {
                public void run() {
                    if (OkHttpClientTransport.this.connectingCallback != null) {
                        OkHttpClientTransport.this.connectingCallback.run();
                    }
                    OkHttpClientTransport okHttpClientTransport = OkHttpClientTransport.this;
                    ClientFrameHandler unused = okHttpClientTransport.clientFrameHandler = new ClientFrameHandler(okHttpClientTransport.testFrameReader, OkHttpClientTransport.this.testFrameLogger);
                    OkHttpClientTransport.this.executor.execute(OkHttpClientTransport.this.clientFrameHandler);
                    synchronized (OkHttpClientTransport.this.lock) {
                        int unused2 = OkHttpClientTransport.this.maxConcurrentStreams = Integer.MAX_VALUE;
                        boolean unused3 = OkHttpClientTransport.this.startPendingStreams();
                    }
                    OkHttpClientTransport.this.connectedFuture.set(null);
                }
            });
            return null;
        }
        final AsyncSink sink = AsyncSink.sink(this.serializingExecutor, this);
        final Http2 http2 = new Http2();
        FrameWriter newWriter = http2.newWriter(Okio.buffer((Sink) sink), true);
        synchronized (this.lock) {
            this.frameWriter = new ExceptionHandlingFrameWriter(this, newWriter);
            this.outboundFlow = new OutboundFlowController(this, this.frameWriter, this.initialWindowSize);
        }
        final CountDownLatch countDownLatch = new CountDownLatch(1);
        this.serializingExecutor.execute(new Runnable() {
            public void run() {
                OkHttpClientTransport okHttpClientTransport;
                ClientFrameHandler clientFrameHandler;
                Socket access$1100;
                try {
                    countDownLatch.await();
                } catch (InterruptedException unused) {
                    Thread.currentThread().interrupt();
                }
                BufferedSource buffer = Okio.buffer((Source) new Source() {
                    public void close() {
                    }

                    public long read(Buffer buffer, long j) {
                        return -1;
                    }

                    public Timeout timeout() {
                        return Timeout.NONE;
                    }
                });
                SSLSession sSLSession = null;
                try {
                    if (OkHttpClientTransport.this.proxiedAddr == null) {
                        access$1100 = OkHttpClientTransport.this.socketFactory.createSocket(OkHttpClientTransport.this.address.getAddress(), OkHttpClientTransport.this.address.getPort());
                    } else if (OkHttpClientTransport.this.proxiedAddr.getProxyAddress() instanceof InetSocketAddress) {
                        access$1100 = OkHttpClientTransport.this.createHttpProxySocket(OkHttpClientTransport.this.proxiedAddr.getTargetAddress(), (InetSocketAddress) OkHttpClientTransport.this.proxiedAddr.getProxyAddress(), OkHttpClientTransport.this.proxiedAddr.getUsername(), OkHttpClientTransport.this.proxiedAddr.getPassword());
                    } else {
                        Status status = Status.INTERNAL;
                        throw status.withDescription("Unsupported SocketAddress implementation " + OkHttpClientTransport.this.proxiedAddr.getProxyAddress().getClass()).asException();
                    }
                    Socket socket = access$1100;
                    SSLSocket sSLSocket = socket;
                    if (OkHttpClientTransport.this.sslSocketFactory != null) {
                        SSLSocket upgrade = OkHttpTlsUpgrader.upgrade(OkHttpClientTransport.this.sslSocketFactory, OkHttpClientTransport.this.hostnameVerifier, socket, OkHttpClientTransport.this.getOverridenHost(), OkHttpClientTransport.this.getOverridenPort(), OkHttpClientTransport.this.connectionSpec);
                        sSLSession = upgrade.getSession();
                        sSLSocket = upgrade;
                    }
                    sSLSocket.setTcpNoDelay(true);
                    BufferedSource buffer2 = Okio.buffer(Okio.source(sSLSocket));
                    sink.becomeConnected(Okio.sink(sSLSocket), sSLSocket);
                    Attributes unused2 = OkHttpClientTransport.this.attributes = OkHttpClientTransport.this.attributes.toBuilder().set(Grpc.TRANSPORT_ATTR_REMOTE_ADDR, sSLSocket.getRemoteSocketAddress()).set(Grpc.TRANSPORT_ATTR_LOCAL_ADDR, sSLSocket.getLocalSocketAddress()).set(Grpc.TRANSPORT_ATTR_SSL_SESSION, sSLSession).set(GrpcAttributes.ATTR_SECURITY_LEVEL, sSLSession == null ? SecurityLevel.NONE : SecurityLevel.PRIVACY_AND_INTEGRITY).build();
                    OkHttpClientTransport okHttpClientTransport2 = OkHttpClientTransport.this;
                    ClientFrameHandler unused3 = okHttpClientTransport2.clientFrameHandler = new ClientFrameHandler(okHttpClientTransport2, http2.newReader(buffer2, true));
                    synchronized (OkHttpClientTransport.this.lock) {
                        Socket unused4 = OkHttpClientTransport.this.socket = (Socket) Preconditions.checkNotNull(sSLSocket, "socket");
                        if (sSLSession != null) {
                            InternalChannelz.Security unused5 = OkHttpClientTransport.this.securityInfo = new InternalChannelz.Security(new InternalChannelz.Tls(sSLSession));
                        }
                    }
                    return;
                } catch (StatusException e) {
                    OkHttpClientTransport.this.startGoAway(0, ErrorCode.INTERNAL_ERROR, e.getStatus());
                    okHttpClientTransport = OkHttpClientTransport.this;
                    clientFrameHandler = new ClientFrameHandler(okHttpClientTransport, http2.newReader(buffer, true));
                } catch (Exception e2) {
                    OkHttpClientTransport.this.onException(e2);
                    okHttpClientTransport = OkHttpClientTransport.this;
                    clientFrameHandler = new ClientFrameHandler(okHttpClientTransport, http2.newReader(buffer, true));
                } catch (Throwable th) {
                    OkHttpClientTransport okHttpClientTransport3 = OkHttpClientTransport.this;
                    ClientFrameHandler unused6 = okHttpClientTransport3.clientFrameHandler = new ClientFrameHandler(okHttpClientTransport3, http2.newReader(buffer, true));
                    throw th;
                }
                ClientFrameHandler unused7 = okHttpClientTransport.clientFrameHandler = clientFrameHandler;
            }
        });
        try {
            synchronized (this.lock) {
                this.frameWriter.connectionPreface();
                this.frameWriter.settings(new Settings());
            }
            countDownLatch.countDown();
            this.serializingExecutor.execute(new Runnable() {
                public void run() {
                    OkHttpClientTransport.this.executor.execute(OkHttpClientTransport.this.clientFrameHandler);
                    synchronized (OkHttpClientTransport.this.lock) {
                        int unused = OkHttpClientTransport.this.maxConcurrentStreams = Integer.MAX_VALUE;
                        boolean unused2 = OkHttpClientTransport.this.startPendingStreams();
                    }
                }
            });
            return null;
        } catch (Throwable th) {
            countDownLatch.countDown();
            throw th;
        }
    }

    /* access modifiers changed from: private */
    public Socket createHttpProxySocket(InetSocketAddress inetSocketAddress, InetSocketAddress inetSocketAddress2, String str, String str2) throws StatusException {
        Socket socket2;
        try {
            if (inetSocketAddress2.getAddress() != null) {
                socket2 = this.socketFactory.createSocket(inetSocketAddress2.getAddress(), inetSocketAddress2.getPort());
            } else {
                socket2 = this.socketFactory.createSocket(inetSocketAddress2.getHostName(), inetSocketAddress2.getPort());
            }
            socket2.setTcpNoDelay(true);
            Source source = Okio.source(socket2);
            BufferedSink buffer = Okio.buffer(Okio.sink(socket2));
            Request createHttpProxyRequest = createHttpProxyRequest(inetSocketAddress, str, str2);
            HttpUrl httpUrl = createHttpProxyRequest.httpUrl();
            buffer.writeUtf8(String.format("CONNECT %s:%d HTTP/1.1", new Object[]{httpUrl.host(), Integer.valueOf(httpUrl.port())})).writeUtf8("\r\n");
            int size = createHttpProxyRequest.headers().size();
            for (int i = 0; i < size; i++) {
                buffer.writeUtf8(createHttpProxyRequest.headers().name(i)).writeUtf8(": ").writeUtf8(createHttpProxyRequest.headers().value(i)).writeUtf8("\r\n");
            }
            buffer.writeUtf8("\r\n");
            buffer.flush();
            StatusLine parse = StatusLine.parse(readUtf8LineStrictUnbuffered(source));
            while (!readUtf8LineStrictUnbuffered(source).equals("")) {
            }
            if (parse.code >= 200 && parse.code < 300) {
                return socket2;
            }
            Buffer buffer2 = new Buffer();
            try {
                socket2.shutdownOutput();
                source.read(buffer2, PlaybackStateCompat.ACTION_PLAY_FROM_MEDIA_ID);
            } catch (IOException e) {
                buffer2.writeUtf8("Unable to read body: " + e.toString());
            }
            try {
                socket2.close();
            } catch (IOException unused) {
            }
            throw Status.UNAVAILABLE.withDescription(String.format("Response returned from proxy was not successful (expected 2xx, got %d %s). Response body:\n%s", new Object[]{Integer.valueOf(parse.code), parse.message, buffer2.readUtf8()})).asException();
        } catch (IOException e2) {
            throw Status.UNAVAILABLE.withDescription("Failed trying to connect with proxy").withCause(e2).asException();
        }
    }

    private Request createHttpProxyRequest(InetSocketAddress inetSocketAddress, String str, String str2) {
        HttpUrl build = new HttpUrl.Builder().scheme(UriUtil.HTTPS_SCHEME).host(inetSocketAddress.getHostName()).port(inetSocketAddress.getPort()).build();
        Request.Builder url = new Request.Builder().url(build);
        Request.Builder header = url.header(HttpHeaders.HOST, build.host() + ":" + build.port()).header(HttpHeaders.USER_AGENT, this.userAgent);
        if (!(str == null || str2 == null)) {
            header.header(HttpHeaders.PROXY_AUTHORIZATION, Credentials.basic(str, str2));
        }
        return header.build();
    }

    private static String readUtf8LineStrictUnbuffered(Source source) throws IOException {
        Buffer buffer = new Buffer();
        while (source.read(buffer, 1) != -1) {
            if (buffer.getByte(buffer.size() - 1) == 10) {
                return buffer.readUtf8LineStrict();
            }
        }
        throw new EOFException("\\n not found: " + buffer.readByteString().hex());
    }

    public String toString() {
        return MoreObjects.toStringHelper((Object) this).add("logId", this.logId.getId()).add("address", (Object) this.address).toString();
    }

    public InternalLogId getLogId() {
        return this.logId;
    }

    /* access modifiers changed from: package-private */
    @VisibleForTesting
    public String getOverridenHost() {
        URI authorityToUri = GrpcUtil.authorityToUri(this.defaultAuthority);
        if (authorityToUri.getHost() != null) {
            return authorityToUri.getHost();
        }
        return this.defaultAuthority;
    }

    /* access modifiers changed from: package-private */
    @VisibleForTesting
    public int getOverridenPort() {
        URI authorityToUri = GrpcUtil.authorityToUri(this.defaultAuthority);
        if (authorityToUri.getPort() != -1) {
            return authorityToUri.getPort();
        }
        return this.address.getPort();
    }

    public void shutdown(Status status) {
        synchronized (this.lock) {
            if (this.goAwayStatus == null) {
                this.goAwayStatus = status;
                this.listener.transportShutdown(this.goAwayStatus);
                stopIfNecessary();
            }
        }
    }

    public void shutdownNow(Status status) {
        shutdown(status);
        synchronized (this.lock) {
            Iterator<Map.Entry<Integer, OkHttpClientStream>> it = this.streams.entrySet().iterator();
            while (it.hasNext()) {
                Map.Entry next = it.next();
                it.remove();
                ((OkHttpClientStream) next.getValue()).transportState().transportReportStatus(status, false, new Metadata());
                maybeClearInUse((OkHttpClientStream) next.getValue());
            }
            Iterator it2 = this.pendingStreams.iterator();
            while (it2.hasNext()) {
                OkHttpClientStream okHttpClientStream = (OkHttpClientStream) it2.next();
                okHttpClientStream.transportState().transportReportStatus(status, true, new Metadata());
                maybeClearInUse(okHttpClientStream);
            }
            this.pendingStreams.clear();
            stopIfNecessary();
        }
    }

    public Attributes getAttributes() {
        return this.attributes;
    }

    /* access modifiers changed from: package-private */
    public OkHttpClientStream[] getActiveStreams() {
        OkHttpClientStream[] okHttpClientStreamArr;
        synchronized (this.lock) {
            okHttpClientStreamArr = (OkHttpClientStream[]) this.streams.values().toArray(EMPTY_STREAM_ARRAY);
        }
        return okHttpClientStreamArr;
    }

    /* access modifiers changed from: package-private */
    @VisibleForTesting
    public ClientFrameHandler getHandler() {
        return this.clientFrameHandler;
    }

    /* access modifiers changed from: package-private */
    @VisibleForTesting
    public SocketFactory getSocketFactory() {
        return this.socketFactory;
    }

    /* access modifiers changed from: package-private */
    @VisibleForTesting
    public int getPendingStreamSize() {
        int size;
        synchronized (this.lock) {
            size = this.pendingStreams.size();
        }
        return size;
    }

    public void onException(Throwable th) {
        Preconditions.checkNotNull(th, "failureCause");
        startGoAway(0, ErrorCode.INTERNAL_ERROR, Status.UNAVAILABLE.withCause(th));
    }

    /* access modifiers changed from: private */
    public void onError(ErrorCode errorCode, String str) {
        startGoAway(0, errorCode, toGrpcStatus(errorCode).augmentDescription(str));
    }

    /* access modifiers changed from: private */
    public void startGoAway(int i, ErrorCode errorCode, Status status) {
        synchronized (this.lock) {
            if (this.goAwayStatus == null) {
                this.goAwayStatus = status;
                this.listener.transportShutdown(status);
            }
            if (errorCode != null && !this.goAwaySent) {
                this.goAwaySent = true;
                this.frameWriter.goAway(0, errorCode, new byte[0]);
            }
            Iterator<Map.Entry<Integer, OkHttpClientStream>> it = this.streams.entrySet().iterator();
            while (it.hasNext()) {
                Map.Entry next = it.next();
                if (((Integer) next.getKey()).intValue() > i) {
                    it.remove();
                    ((OkHttpClientStream) next.getValue()).transportState().transportReportStatus(status, ClientStreamListener.RpcProgress.REFUSED, false, new Metadata());
                    maybeClearInUse((OkHttpClientStream) next.getValue());
                }
            }
            Iterator it2 = this.pendingStreams.iterator();
            while (it2.hasNext()) {
                OkHttpClientStream okHttpClientStream = (OkHttpClientStream) it2.next();
                okHttpClientStream.transportState().transportReportStatus(status, ClientStreamListener.RpcProgress.REFUSED, true, new Metadata());
                maybeClearInUse(okHttpClientStream);
            }
            this.pendingStreams.clear();
            stopIfNecessary();
        }
    }

    /* access modifiers changed from: package-private */
    public void finishStream(int i, @Nullable Status status, ClientStreamListener.RpcProgress rpcProgress, boolean z, @Nullable ErrorCode errorCode, @Nullable Metadata metadata) {
        synchronized (this.lock) {
            OkHttpClientStream remove = this.streams.remove(Integer.valueOf(i));
            if (remove != null) {
                if (errorCode != null) {
                    this.frameWriter.rstStream(i, ErrorCode.CANCEL);
                }
                if (status != null) {
                    OkHttpClientStream.TransportState transportState = remove.transportState();
                    if (metadata == null) {
                        metadata = new Metadata();
                    }
                    transportState.transportReportStatus(status, rpcProgress, z, metadata);
                }
                if (!startPendingStreams()) {
                    stopIfNecessary();
                    maybeClearInUse(remove);
                }
            }
        }
    }

    @GuardedBy("lock")
    private void stopIfNecessary() {
        if (this.goAwayStatus != null && this.streams.isEmpty() && this.pendingStreams.isEmpty() && !this.stopped) {
            this.stopped = true;
            KeepAliveManager keepAliveManager2 = this.keepAliveManager;
            if (keepAliveManager2 != null) {
                keepAliveManager2.onTransportTermination();
                this.scheduler = (ScheduledExecutorService) SharedResourceHolder.release(GrpcUtil.TIMER_SERVICE, this.scheduler);
            }
            Http2Ping http2Ping = this.ping;
            if (http2Ping != null) {
                http2Ping.failed(getPingFailure());
                this.ping = null;
            }
            if (!this.goAwaySent) {
                this.goAwaySent = true;
                this.frameWriter.goAway(0, ErrorCode.NO_ERROR, new byte[0]);
            }
            this.frameWriter.close();
        }
    }

    @GuardedBy("lock")
    private void maybeClearInUse(OkHttpClientStream okHttpClientStream) {
        if (this.hasStream && this.pendingStreams.isEmpty() && this.streams.isEmpty()) {
            this.hasStream = false;
            KeepAliveManager keepAliveManager2 = this.keepAliveManager;
            if (keepAliveManager2 != null) {
                keepAliveManager2.onTransportIdle();
            }
        }
        if (okHttpClientStream.shouldBeCountedForInUse()) {
            this.inUseState.updateObjectInUse(okHttpClientStream, false);
        }
    }

    @GuardedBy("lock")
    private void setInUse(OkHttpClientStream okHttpClientStream) {
        if (!this.hasStream) {
            this.hasStream = true;
            KeepAliveManager keepAliveManager2 = this.keepAliveManager;
            if (keepAliveManager2 != null) {
                keepAliveManager2.onTransportActive();
            }
        }
        if (okHttpClientStream.shouldBeCountedForInUse()) {
            this.inUseState.updateObjectInUse(okHttpClientStream, true);
        }
    }

    private Throwable getPingFailure() {
        synchronized (this.lock) {
            if (this.goAwayStatus != null) {
                StatusException asException = this.goAwayStatus.asException();
                return asException;
            }
            StatusException asException2 = Status.UNAVAILABLE.withDescription("Connection closed").asException();
            return asException2;
        }
    }

    /* access modifiers changed from: package-private */
    public boolean mayHaveCreatedStream(int i) {
        boolean z;
        synchronized (this.lock) {
            z = true;
            if (i >= this.nextStreamId || (i & 1) != 1) {
                z = false;
            }
        }
        return z;
    }

    /* access modifiers changed from: package-private */
    public OkHttpClientStream getStream(int i) {
        OkHttpClientStream okHttpClientStream;
        synchronized (this.lock) {
            okHttpClientStream = this.streams.get(Integer.valueOf(i));
        }
        return okHttpClientStream;
    }

    @VisibleForTesting
    static Status toGrpcStatus(ErrorCode errorCode) {
        Status status = ERROR_CODE_TO_STATUS.get(errorCode);
        if (status != null) {
            return status;
        }
        Status status2 = Status.UNKNOWN;
        return status2.withDescription("Unknown http2 error code: " + errorCode.httpCode);
    }

    public ListenableFuture<InternalChannelz.SocketStats> getStats() {
        SettableFuture create = SettableFuture.create();
        synchronized (this.lock) {
            if (this.socket == null) {
                create.set(new InternalChannelz.SocketStats(this.transportTracer.getStats(), (SocketAddress) null, (SocketAddress) null, new InternalChannelz.SocketOptions.Builder().build(), (InternalChannelz.Security) null));
            } else {
                create.set(new InternalChannelz.SocketStats(this.transportTracer.getStats(), this.socket.getLocalSocketAddress(), this.socket.getRemoteSocketAddress(), Utils.getSocketOptions(this.socket), this.securityInfo));
            }
        }
        return create;
    }

    @VisibleForTesting
    class ClientFrameHandler implements FrameReader.Handler, Runnable {
        boolean firstSettings;
        FrameReader frameReader;
        private final OkHttpFrameLogger logger;

        public void ackSettings() {
        }

        public void alternateService(int i, String str, ByteString byteString, String str2, int i2, long j) {
        }

        public void priority(int i, int i2, int i3, boolean z) {
        }

        ClientFrameHandler(OkHttpClientTransport okHttpClientTransport, FrameReader frameReader2) {
            this(frameReader2, new OkHttpFrameLogger(Level.FINE, (Class<?>) OkHttpClientTransport.class));
        }

        @VisibleForTesting
        ClientFrameHandler(FrameReader frameReader2, OkHttpFrameLogger okHttpFrameLogger) {
            this.firstSettings = true;
            this.frameReader = frameReader2;
            this.logger = okHttpFrameLogger;
        }

        public void run() {
            String name = Thread.currentThread().getName();
            if (!GrpcUtil.IS_RESTRICTED_APPENGINE) {
                Thread.currentThread().setName("OkHttpClientTransport");
            }
            while (this.frameReader.nextFrame(this)) {
                try {
                    if (OkHttpClientTransport.this.keepAliveManager != null) {
                        OkHttpClientTransport.this.keepAliveManager.onDataReceived();
                    }
                } catch (Throwable th) {
                    try {
                        this.frameReader.close();
                    } catch (IOException e) {
                        OkHttpClientTransport.log.log(Level.INFO, "Exception closing frame reader", e);
                    }
                    OkHttpClientTransport.this.listener.transportTerminated();
                    if (!GrpcUtil.IS_RESTRICTED_APPENGINE) {
                        Thread.currentThread().setName(name);
                    }
                    throw th;
                }
            }
            OkHttpClientTransport.this.startGoAway(0, ErrorCode.INTERNAL_ERROR, Status.UNAVAILABLE.withDescription("End of stream or IOException"));
            try {
                this.frameReader.close();
            } catch (IOException e2) {
                OkHttpClientTransport.log.log(Level.INFO, "Exception closing frame reader", e2);
            }
            OkHttpClientTransport.this.listener.transportTerminated();
            if (GrpcUtil.IS_RESTRICTED_APPENGINE) {
                return;
            }
            Thread.currentThread().setName(name);
        }

        public void data(boolean z, int i, BufferedSource bufferedSource, int i2) throws IOException {
            this.logger.logData(OkHttpFrameLogger.Direction.INBOUND, i, bufferedSource.buffer(), i2, z);
            OkHttpClientStream stream = OkHttpClientTransport.this.getStream(i);
            if (stream != null) {
                long j = (long) i2;
                bufferedSource.require(j);
                Buffer buffer = new Buffer();
                buffer.write(bufferedSource.buffer(), j);
                synchronized (OkHttpClientTransport.this.lock) {
                    stream.transportState().transportDataReceived(buffer, z);
                }
            } else if (OkHttpClientTransport.this.mayHaveCreatedStream(i)) {
                synchronized (OkHttpClientTransport.this.lock) {
                    OkHttpClientTransport.this.frameWriter.rstStream(i, ErrorCode.INVALID_STREAM);
                }
                bufferedSource.skip((long) i2);
            } else {
                OkHttpClientTransport okHttpClientTransport = OkHttpClientTransport.this;
                ErrorCode errorCode = ErrorCode.PROTOCOL_ERROR;
                okHttpClientTransport.onError(errorCode, "Received data for unknown stream: " + i);
                return;
            }
            OkHttpClientTransport.access$2312(OkHttpClientTransport.this, i2);
            if (((float) OkHttpClientTransport.this.connectionUnacknowledgedBytesRead) >= ((float) OkHttpClientTransport.this.initialWindowSize) * 0.5f) {
                synchronized (OkHttpClientTransport.this.lock) {
                    OkHttpClientTransport.this.frameWriter.windowUpdate(0, (long) OkHttpClientTransport.this.connectionUnacknowledgedBytesRead);
                }
                int unused = OkHttpClientTransport.this.connectionUnacknowledgedBytesRead = 0;
            }
        }

        public void headers(boolean z, boolean z2, int i, int i2, List<Header> list, HeadersMode headersMode) {
            Status status;
            int headerBlockSize;
            this.logger.logHeaders(OkHttpFrameLogger.Direction.INBOUND, i, list, z2);
            boolean z3 = true;
            if (OkHttpClientTransport.this.maxInboundMetadataSize == Integer.MAX_VALUE || (headerBlockSize = headerBlockSize(list)) <= OkHttpClientTransport.this.maxInboundMetadataSize) {
                status = null;
            } else {
                Status status2 = Status.RESOURCE_EXHAUSTED;
                Object[] objArr = new Object[3];
                objArr[0] = z2 ? "trailer" : "header";
                objArr[1] = Integer.valueOf(OkHttpClientTransport.this.maxInboundMetadataSize);
                objArr[2] = Integer.valueOf(headerBlockSize);
                status = status2.withDescription(String.format("Response %s metadata larger than %d: %d", objArr));
            }
            synchronized (OkHttpClientTransport.this.lock) {
                OkHttpClientStream okHttpClientStream = (OkHttpClientStream) OkHttpClientTransport.this.streams.get(Integer.valueOf(i));
                if (okHttpClientStream == null) {
                    if (OkHttpClientTransport.this.mayHaveCreatedStream(i)) {
                        OkHttpClientTransport.this.frameWriter.rstStream(i, ErrorCode.INVALID_STREAM);
                    }
                } else if (status == null) {
                    okHttpClientStream.transportState().transportHeadersReceived(list, z2);
                } else {
                    if (!z2) {
                        OkHttpClientTransport.this.frameWriter.rstStream(i, ErrorCode.CANCEL);
                    }
                    okHttpClientStream.transportState().transportReportStatus(status, false, new Metadata());
                }
                z3 = false;
            }
            if (z3) {
                OkHttpClientTransport okHttpClientTransport = OkHttpClientTransport.this;
                ErrorCode errorCode = ErrorCode.PROTOCOL_ERROR;
                okHttpClientTransport.onError(errorCode, "Received header for unknown stream: " + i);
            }
        }

        private int headerBlockSize(List<Header> list) {
            long j = 0;
            for (int i = 0; i < list.size(); i++) {
                Header header = list.get(i);
                j += (long) (header.name.size() + 32 + header.value.size());
            }
            return (int) Math.min(j, 2147483647L);
        }

        public void rstStream(int i, ErrorCode errorCode) {
            this.logger.logRstStream(OkHttpFrameLogger.Direction.INBOUND, i, errorCode);
            Status augmentDescription = OkHttpClientTransport.toGrpcStatus(errorCode).augmentDescription("Rst Stream");
            OkHttpClientTransport.this.finishStream(i, augmentDescription, errorCode == ErrorCode.REFUSED_STREAM ? ClientStreamListener.RpcProgress.REFUSED : ClientStreamListener.RpcProgress.PROCESSED, augmentDescription.getCode() == Status.Code.CANCELLED || augmentDescription.getCode() == Status.Code.DEADLINE_EXCEEDED, (ErrorCode) null, (Metadata) null);
        }

        public void settings(boolean z, Settings settings) {
            boolean z2;
            this.logger.logSettings(OkHttpFrameLogger.Direction.INBOUND, settings);
            synchronized (OkHttpClientTransport.this.lock) {
                if (OkHttpSettingsUtil.isSet(settings, 4)) {
                    int unused = OkHttpClientTransport.this.maxConcurrentStreams = OkHttpSettingsUtil.get(settings, 4);
                }
                if (OkHttpSettingsUtil.isSet(settings, 7)) {
                    z2 = OkHttpClientTransport.this.outboundFlow.initialOutboundWindowSize(OkHttpSettingsUtil.get(settings, 7));
                } else {
                    z2 = false;
                }
                if (this.firstSettings) {
                    OkHttpClientTransport.this.listener.transportReady();
                    this.firstSettings = false;
                }
                OkHttpClientTransport.this.frameWriter.ackSettings(settings);
                if (z2) {
                    OkHttpClientTransport.this.outboundFlow.writeStreams();
                }
                boolean unused2 = OkHttpClientTransport.this.startPendingStreams();
            }
        }

        public void ping(boolean z, int i, int i2) {
            Http2Ping http2Ping;
            long j = (((long) i) << 32) | (((long) i2) & 4294967295L);
            this.logger.logPing(OkHttpFrameLogger.Direction.INBOUND, j);
            if (!z) {
                synchronized (OkHttpClientTransport.this.lock) {
                    OkHttpClientTransport.this.frameWriter.ping(true, i, i2);
                }
                return;
            }
            synchronized (OkHttpClientTransport.this.lock) {
                if (OkHttpClientTransport.this.ping == null) {
                    OkHttpClientTransport.log.warning("Received unexpected ping ack. No ping outstanding");
                } else if (OkHttpClientTransport.this.ping.payload() == j) {
                    http2Ping = OkHttpClientTransport.this.ping;
                    Http2Ping unused = OkHttpClientTransport.this.ping = null;
                } else {
                    OkHttpClientTransport.log.log(Level.WARNING, String.format("Received unexpected ping ack. Expecting %d, got %d", new Object[]{Long.valueOf(OkHttpClientTransport.this.ping.payload()), Long.valueOf(j)}));
                }
                http2Ping = null;
            }
            if (http2Ping != null) {
                http2Ping.complete();
            }
        }

        public void goAway(int i, ErrorCode errorCode, ByteString byteString) {
            this.logger.logGoAway(OkHttpFrameLogger.Direction.INBOUND, i, errorCode, byteString);
            if (errorCode == ErrorCode.ENHANCE_YOUR_CALM) {
                String utf8 = byteString.utf8();
                OkHttpClientTransport.log.log(Level.WARNING, String.format("%s: Received GOAWAY with ENHANCE_YOUR_CALM. Debug data: %s", new Object[]{this, utf8}));
                if ("too_many_pings".equals(utf8)) {
                    OkHttpClientTransport.this.tooManyPingsRunnable.run();
                }
            }
            Status augmentDescription = GrpcUtil.Http2Error.statusForCode((long) errorCode.httpCode).augmentDescription("Received Goaway");
            if (byteString.size() > 0) {
                augmentDescription = augmentDescription.augmentDescription(byteString.utf8());
            }
            OkHttpClientTransport.this.startGoAway(i, (ErrorCode) null, augmentDescription);
        }

        public void pushPromise(int i, int i2, List<Header> list) throws IOException {
            this.logger.logPushPromise(OkHttpFrameLogger.Direction.INBOUND, i, i2, list);
            synchronized (OkHttpClientTransport.this.lock) {
                OkHttpClientTransport.this.frameWriter.rstStream(i, ErrorCode.PROTOCOL_ERROR);
            }
        }

        /* JADX WARNING: Code restructure failed: missing block: B:20:0x006a, code lost:
            if (r0 == false) goto L_?;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:21:0x006c, code lost:
            r9 = r7.this$0;
            r10 = io.grpc.okhttp.internal.framed.ErrorCode.PROTOCOL_ERROR;
            io.grpc.okhttp.OkHttpClientTransport.access$2200(r9, r10, "Received window_update for unknown stream: " + r8);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:31:?, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:32:?, code lost:
            return;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void windowUpdate(int r8, long r9) {
            /*
                r7 = this;
                io.grpc.okhttp.OkHttpFrameLogger r0 = r7.logger
                io.grpc.okhttp.OkHttpFrameLogger$Direction r1 = io.grpc.okhttp.OkHttpFrameLogger.Direction.INBOUND
                r0.logWindowsUpdate(r1, r8, r9)
                r0 = 0
                int r2 = (r9 > r0 ? 1 : (r9 == r0 ? 0 : -1))
                if (r2 != 0) goto L_0x002c
                java.lang.String r9 = "Received 0 flow control window increment."
                if (r8 != 0) goto L_0x0019
                io.grpc.okhttp.OkHttpClientTransport r8 = io.grpc.okhttp.OkHttpClientTransport.this
                io.grpc.okhttp.internal.framed.ErrorCode r10 = io.grpc.okhttp.internal.framed.ErrorCode.PROTOCOL_ERROR
                r8.onError(r10, r9)
                goto L_0x002b
            L_0x0019:
                io.grpc.okhttp.OkHttpClientTransport r0 = io.grpc.okhttp.OkHttpClientTransport.this
                io.grpc.Status r10 = io.grpc.Status.INTERNAL
                io.grpc.Status r2 = r10.withDescription(r9)
                io.grpc.internal.ClientStreamListener$RpcProgress r3 = io.grpc.internal.ClientStreamListener.RpcProgress.PROCESSED
                r4 = 0
                io.grpc.okhttp.internal.framed.ErrorCode r5 = io.grpc.okhttp.internal.framed.ErrorCode.PROTOCOL_ERROR
                r6 = 0
                r1 = r8
                r0.finishStream(r1, r2, r3, r4, r5, r6)
            L_0x002b:
                return
            L_0x002c:
                r0 = 0
                io.grpc.okhttp.OkHttpClientTransport r1 = io.grpc.okhttp.OkHttpClientTransport.this
                java.lang.Object r1 = r1.lock
                monitor-enter(r1)
                if (r8 != 0) goto L_0x0043
                io.grpc.okhttp.OkHttpClientTransport r8 = io.grpc.okhttp.OkHttpClientTransport.this     // Catch:{ all -> 0x0085 }
                io.grpc.okhttp.OutboundFlowController r8 = r8.outboundFlow     // Catch:{ all -> 0x0085 }
                r0 = 0
                int r10 = (int) r9     // Catch:{ all -> 0x0085 }
                r8.windowUpdate(r0, r10)     // Catch:{ all -> 0x0085 }
                monitor-exit(r1)     // Catch:{ all -> 0x0085 }
                return
            L_0x0043:
                io.grpc.okhttp.OkHttpClientTransport r2 = io.grpc.okhttp.OkHttpClientTransport.this     // Catch:{ all -> 0x0085 }
                java.util.Map r2 = r2.streams     // Catch:{ all -> 0x0085 }
                java.lang.Integer r3 = java.lang.Integer.valueOf(r8)     // Catch:{ all -> 0x0085 }
                java.lang.Object r2 = r2.get(r3)     // Catch:{ all -> 0x0085 }
                io.grpc.okhttp.OkHttpClientStream r2 = (io.grpc.okhttp.OkHttpClientStream) r2     // Catch:{ all -> 0x0085 }
                if (r2 == 0) goto L_0x0060
                io.grpc.okhttp.OkHttpClientTransport r3 = io.grpc.okhttp.OkHttpClientTransport.this     // Catch:{ all -> 0x0085 }
                io.grpc.okhttp.OutboundFlowController r3 = r3.outboundFlow     // Catch:{ all -> 0x0085 }
                int r10 = (int) r9     // Catch:{ all -> 0x0085 }
                r3.windowUpdate(r2, r10)     // Catch:{ all -> 0x0085 }
                goto L_0x0069
            L_0x0060:
                io.grpc.okhttp.OkHttpClientTransport r9 = io.grpc.okhttp.OkHttpClientTransport.this     // Catch:{ all -> 0x0085 }
                boolean r9 = r9.mayHaveCreatedStream(r8)     // Catch:{ all -> 0x0085 }
                if (r9 != 0) goto L_0x0069
                r0 = 1
            L_0x0069:
                monitor-exit(r1)     // Catch:{ all -> 0x0085 }
                if (r0 == 0) goto L_0x0084
                io.grpc.okhttp.OkHttpClientTransport r9 = io.grpc.okhttp.OkHttpClientTransport.this
                io.grpc.okhttp.internal.framed.ErrorCode r10 = io.grpc.okhttp.internal.framed.ErrorCode.PROTOCOL_ERROR
                java.lang.StringBuilder r0 = new java.lang.StringBuilder
                r0.<init>()
                java.lang.String r1 = "Received window_update for unknown stream: "
                r0.append(r1)
                r0.append(r8)
                java.lang.String r8 = r0.toString()
                r9.onError(r10, r8)
            L_0x0084:
                return
            L_0x0085:
                r8 = move-exception
                monitor-exit(r1)     // Catch:{ all -> 0x0085 }
                throw r8
            */
            throw new UnsupportedOperationException("Method not decompiled: io.grpc.okhttp.OkHttpClientTransport.ClientFrameHandler.windowUpdate(int, long):void");
        }
    }
}
