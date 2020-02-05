package io.grpc.internal;

import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.MoreObjects;
import com.google.common.base.Preconditions;
import com.google.common.net.HttpHeaders;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.MoreExecutors;
import com.google.common.util.concurrent.SettableFuture;
import io.grpc.Attributes;
import io.grpc.BinaryLog;
import io.grpc.CompressorRegistry;
import io.grpc.Context;
import io.grpc.Contexts;
import io.grpc.Decompressor;
import io.grpc.DecompressorRegistry;
import io.grpc.HandlerRegistry;
import io.grpc.InternalChannelz;
import io.grpc.InternalInstrumented;
import io.grpc.InternalLogId;
import io.grpc.Metadata;
import io.grpc.Server;
import io.grpc.ServerCall;
import io.grpc.ServerInterceptor;
import io.grpc.ServerMethodDefinition;
import io.grpc.ServerServiceDefinition;
import io.grpc.ServerTransportFilter;
import io.grpc.Status;
import io.grpc.internal.StreamListener;
import java.io.IOException;
import java.io.InputStream;
import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.Executor;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.concurrent.GuardedBy;

public final class ServerImpl extends Server implements InternalInstrumented<InternalChannelz.ServerStats> {
    /* access modifiers changed from: private */
    public static final ServerStreamListener NOOP_LISTENER = new NoopListener();
    /* access modifiers changed from: private */
    public static final Logger log = Logger.getLogger(ServerImpl.class.getName());
    /* access modifiers changed from: private */
    @GuardedBy("lock")
    public int activeTransportServers;
    /* access modifiers changed from: private */
    public final BinaryLog binlog;
    /* access modifiers changed from: private */
    public final InternalChannelz channelz;
    /* access modifiers changed from: private */
    public final CompressorRegistry compressorRegistry;
    /* access modifiers changed from: private */
    public final DecompressorRegistry decompressorRegistry;
    /* access modifiers changed from: private */
    public Executor executor;
    private final ObjectPool<? extends Executor> executorPool;
    /* access modifiers changed from: private */
    public final HandlerRegistry fallbackRegistry;
    /* access modifiers changed from: private */
    public final long handshakeTimeoutMillis;
    /* access modifiers changed from: private */
    public final ServerInterceptor[] interceptors;
    /* access modifiers changed from: private */
    public final Object lock = new Object();
    private final InternalLogId logId;
    /* access modifiers changed from: private */
    public final HandlerRegistry registry;
    /* access modifiers changed from: private */
    public final Context rootContext;
    /* access modifiers changed from: private */
    public final CallTracer serverCallTracer;
    /* access modifiers changed from: private */
    @GuardedBy("lock")
    public boolean serverShutdownCallbackInvoked;
    @GuardedBy("lock")
    private boolean shutdown;
    /* access modifiers changed from: private */
    @GuardedBy("lock")
    public Status shutdownNowStatus;
    @GuardedBy("lock")
    private boolean started;
    @GuardedBy("lock")
    private boolean terminated;
    /* access modifiers changed from: private */
    public final List<ServerTransportFilter> transportFilters;
    private final List<? extends InternalServer> transportServers;
    /* access modifiers changed from: private */
    @GuardedBy("lock")
    public boolean transportServersTerminated;
    /* access modifiers changed from: private */
    @GuardedBy("lock")
    public final Set<ServerTransport> transports = new HashSet();

    static /* synthetic */ int access$410(ServerImpl serverImpl) {
        int i = serverImpl.activeTransportServers;
        serverImpl.activeTransportServers = i - 1;
        return i;
    }

    ServerImpl(AbstractServerImplBuilder<?> abstractServerImplBuilder, List<? extends InternalServer> list, Context context) {
        this.executorPool = (ObjectPool) Preconditions.checkNotNull(abstractServerImplBuilder.executorPool, "executorPool");
        this.registry = (HandlerRegistry) Preconditions.checkNotNull(abstractServerImplBuilder.registryBuilder.build(), "registryBuilder");
        this.fallbackRegistry = (HandlerRegistry) Preconditions.checkNotNull(abstractServerImplBuilder.fallbackRegistry, "fallbackRegistry");
        Preconditions.checkNotNull(list, "transportServers");
        Preconditions.checkArgument(!list.isEmpty(), "no servers provided");
        this.transportServers = new ArrayList(list);
        this.logId = InternalLogId.allocate(HttpHeaders.SERVER, String.valueOf(getListenSocketsIgnoringLifecycle()));
        this.rootContext = ((Context) Preconditions.checkNotNull(context, "rootContext")).fork();
        this.decompressorRegistry = abstractServerImplBuilder.decompressorRegistry;
        this.compressorRegistry = abstractServerImplBuilder.compressorRegistry;
        this.transportFilters = Collections.unmodifiableList(new ArrayList(abstractServerImplBuilder.transportFilters));
        this.interceptors = (ServerInterceptor[]) abstractServerImplBuilder.interceptors.toArray(new ServerInterceptor[abstractServerImplBuilder.interceptors.size()]);
        this.handshakeTimeoutMillis = abstractServerImplBuilder.handshakeTimeoutMillis;
        this.binlog = abstractServerImplBuilder.binlog;
        this.channelz = abstractServerImplBuilder.channelz;
        this.serverCallTracer = abstractServerImplBuilder.callTracerFactory.create();
        this.channelz.addServer(this);
    }

    public ServerImpl start() throws IOException {
        synchronized (this.lock) {
            boolean z = false;
            Preconditions.checkState(!this.started, "Already started");
            if (!this.shutdown) {
                z = true;
            }
            Preconditions.checkState(z, "Shutting down");
            ServerListenerImpl serverListenerImpl = new ServerListenerImpl();
            for (InternalServer start : this.transportServers) {
                start.start(serverListenerImpl);
                this.activeTransportServers++;
            }
            this.executor = (Executor) Preconditions.checkNotNull(this.executorPool.getObject(), "executor");
            this.started = true;
        }
        return this;
    }

    public int getPort() {
        synchronized (this.lock) {
            Preconditions.checkState(this.started, "Not started");
            Preconditions.checkState(!this.terminated, "Already terminated");
            for (InternalServer listenSocketAddress : this.transportServers) {
                SocketAddress listenSocketAddress2 = listenSocketAddress.getListenSocketAddress();
                if (listenSocketAddress2 instanceof InetSocketAddress) {
                    int port = ((InetSocketAddress) listenSocketAddress2).getPort();
                    return port;
                }
            }
            return -1;
        }
    }

    public List<SocketAddress> getListenSockets() {
        List<SocketAddress> listenSocketsIgnoringLifecycle;
        synchronized (this.lock) {
            Preconditions.checkState(this.started, "Not started");
            Preconditions.checkState(!this.terminated, "Already terminated");
            listenSocketsIgnoringLifecycle = getListenSocketsIgnoringLifecycle();
        }
        return listenSocketsIgnoringLifecycle;
    }

    private List<SocketAddress> getListenSocketsIgnoringLifecycle() {
        List<SocketAddress> unmodifiableList;
        synchronized (this.lock) {
            ArrayList arrayList = new ArrayList(this.transportServers.size());
            for (InternalServer listenSocketAddress : this.transportServers) {
                arrayList.add(listenSocketAddress.getListenSocketAddress());
            }
            unmodifiableList = Collections.unmodifiableList(arrayList);
        }
        return unmodifiableList;
    }

    public List<ServerServiceDefinition> getServices() {
        List<ServerServiceDefinition> services = this.fallbackRegistry.getServices();
        if (services.isEmpty()) {
            return this.registry.getServices();
        }
        List<ServerServiceDefinition> services2 = this.registry.getServices();
        ArrayList arrayList = new ArrayList(services2.size() + services.size());
        arrayList.addAll(services2);
        arrayList.addAll(services);
        return Collections.unmodifiableList(arrayList);
    }

    public List<ServerServiceDefinition> getImmutableServices() {
        return this.registry.getServices();
    }

    public List<ServerServiceDefinition> getMutableServices() {
        return Collections.unmodifiableList(this.fallbackRegistry.getServices());
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0016, code lost:
        if (r2 == false) goto L_0x002e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0018, code lost:
        r0 = r3.transportServers.iterator();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0022, code lost:
        if (r0.hasNext() == false) goto L_0x002e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0024, code lost:
        ((io.grpc.internal.InternalServer) r0.next()).shutdown();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x002e, code lost:
        return r3;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public io.grpc.internal.ServerImpl shutdown() {
        /*
            r3 = this;
            java.lang.Object r0 = r3.lock
            monitor-enter(r0)
            boolean r1 = r3.shutdown     // Catch:{ all -> 0x002f }
            if (r1 == 0) goto L_0x0009
            monitor-exit(r0)     // Catch:{ all -> 0x002f }
            return r3
        L_0x0009:
            r1 = 1
            r3.shutdown = r1     // Catch:{ all -> 0x002f }
            boolean r2 = r3.started     // Catch:{ all -> 0x002f }
            if (r2 != 0) goto L_0x0015
            r3.transportServersTerminated = r1     // Catch:{ all -> 0x002f }
            r3.checkForTermination()     // Catch:{ all -> 0x002f }
        L_0x0015:
            monitor-exit(r0)     // Catch:{ all -> 0x002f }
            if (r2 == 0) goto L_0x002e
            java.util.List<? extends io.grpc.internal.InternalServer> r0 = r3.transportServers
            java.util.Iterator r0 = r0.iterator()
        L_0x001e:
            boolean r1 = r0.hasNext()
            if (r1 == 0) goto L_0x002e
            java.lang.Object r1 = r0.next()
            io.grpc.internal.InternalServer r1 = (io.grpc.internal.InternalServer) r1
            r1.shutdown()
            goto L_0x001e
        L_0x002e:
            return r3
        L_0x002f:
            r1 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x002f }
            goto L_0x0033
        L_0x0032:
            throw r1
        L_0x0033:
            goto L_0x0032
        */
        throw new UnsupportedOperationException("Method not decompiled: io.grpc.internal.ServerImpl.shutdown():io.grpc.internal.ServerImpl");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0022, code lost:
        r1 = r2.iterator();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x002a, code lost:
        if (r1.hasNext() == false) goto L_0x0036;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x002c, code lost:
        ((io.grpc.internal.ServerTransport) r1.next()).shutdownNow(r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0036, code lost:
        return r4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0020, code lost:
        if (r3 == false) goto L_0x0036;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public io.grpc.internal.ServerImpl shutdownNow() {
        /*
            r4 = this;
            r4.shutdown()
            io.grpc.Status r0 = io.grpc.Status.UNAVAILABLE
            java.lang.String r1 = "Server shutdownNow invoked"
            io.grpc.Status r0 = r0.withDescription(r1)
            java.lang.Object r1 = r4.lock
            monitor-enter(r1)
            io.grpc.Status r2 = r4.shutdownNowStatus     // Catch:{ all -> 0x0037 }
            if (r2 == 0) goto L_0x0014
            monitor-exit(r1)     // Catch:{ all -> 0x0037 }
            return r4
        L_0x0014:
            r4.shutdownNowStatus = r0     // Catch:{ all -> 0x0037 }
            java.util.ArrayList r2 = new java.util.ArrayList     // Catch:{ all -> 0x0037 }
            java.util.Set<io.grpc.internal.ServerTransport> r3 = r4.transports     // Catch:{ all -> 0x0037 }
            r2.<init>(r3)     // Catch:{ all -> 0x0037 }
            boolean r3 = r4.serverShutdownCallbackInvoked     // Catch:{ all -> 0x0037 }
            monitor-exit(r1)     // Catch:{ all -> 0x0037 }
            if (r3 == 0) goto L_0x0036
            java.util.Iterator r1 = r2.iterator()
        L_0x0026:
            boolean r2 = r1.hasNext()
            if (r2 == 0) goto L_0x0036
            java.lang.Object r2 = r1.next()
            io.grpc.internal.ServerTransport r2 = (io.grpc.internal.ServerTransport) r2
            r2.shutdownNow(r0)
            goto L_0x0026
        L_0x0036:
            return r4
        L_0x0037:
            r0 = move-exception
            monitor-exit(r1)     // Catch:{ all -> 0x0037 }
            goto L_0x003b
        L_0x003a:
            throw r0
        L_0x003b:
            goto L_0x003a
        */
        throw new UnsupportedOperationException("Method not decompiled: io.grpc.internal.ServerImpl.shutdownNow():io.grpc.internal.ServerImpl");
    }

    public boolean isShutdown() {
        boolean z;
        synchronized (this.lock) {
            z = this.shutdown;
        }
        return z;
    }

    public boolean awaitTermination(long j, TimeUnit timeUnit) throws InterruptedException {
        boolean z;
        synchronized (this.lock) {
            long nanoTime = System.nanoTime() + timeUnit.toNanos(j);
            while (!this.terminated) {
                long nanoTime2 = nanoTime - System.nanoTime();
                if (nanoTime2 <= 0) {
                    break;
                }
                TimeUnit.NANOSECONDS.timedWait(this.lock, nanoTime2);
            }
            z = this.terminated;
        }
        return z;
    }

    public void awaitTermination() throws InterruptedException {
        synchronized (this.lock) {
            while (!this.terminated) {
                this.lock.wait();
            }
        }
    }

    public boolean isTerminated() {
        boolean z;
        synchronized (this.lock) {
            z = this.terminated;
        }
        return z;
    }

    /* access modifiers changed from: private */
    public void transportClosed(ServerTransport serverTransport) {
        synchronized (this.lock) {
            if (this.transports.remove(serverTransport)) {
                this.channelz.removeServerSocket(this, serverTransport);
                checkForTermination();
            } else {
                throw new AssertionError("Transport already removed");
            }
        }
    }

    /* access modifiers changed from: private */
    public void checkForTermination() {
        synchronized (this.lock) {
            if (this.shutdown && this.transports.isEmpty() && this.transportServersTerminated) {
                if (!this.terminated) {
                    this.terminated = true;
                    this.channelz.removeServer(this);
                    if (this.executor != null) {
                        this.executor = (Executor) this.executorPool.returnObject(this.executor);
                    }
                    this.lock.notifyAll();
                } else {
                    throw new AssertionError("Server already terminated");
                }
            }
        }
    }

    private final class ServerListenerImpl implements ServerListener {
        private ServerListenerImpl() {
        }

        public ServerTransportListener transportCreated(ServerTransport serverTransport) {
            synchronized (ServerImpl.this.lock) {
                ServerImpl.this.transports.add(serverTransport);
            }
            ServerTransportListenerImpl serverTransportListenerImpl = new ServerTransportListenerImpl(serverTransport);
            serverTransportListenerImpl.init();
            return serverTransportListenerImpl;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:11:0x0036, code lost:
            if (r0.hasNext() == false) goto L_0x0048;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:12:0x0038, code lost:
            r1 = (io.grpc.internal.ServerTransport) r0.next();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:13:0x003e, code lost:
            if (r2 != null) goto L_0x0044;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:14:0x0040, code lost:
            r1.shutdown();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:15:0x0044, code lost:
            r1.shutdownNow(r2);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:16:0x0048, code lost:
            r1 = io.grpc.internal.ServerImpl.access$200(r5.this$0);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:17:0x004e, code lost:
            monitor-enter(r1);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:19:?, code lost:
            io.grpc.internal.ServerImpl.access$702(r5.this$0, true);
            io.grpc.internal.ServerImpl.access$800(r5.this$0);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:20:0x0059, code lost:
            monitor-exit(r1);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:21:0x005a, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:9:0x002e, code lost:
            r0 = r1.iterator();
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void serverShutdown() {
            /*
                r5 = this;
                io.grpc.internal.ServerImpl r0 = io.grpc.internal.ServerImpl.this
                java.lang.Object r0 = r0.lock
                monitor-enter(r0)
                io.grpc.internal.ServerImpl r1 = io.grpc.internal.ServerImpl.this     // Catch:{ all -> 0x005e }
                io.grpc.internal.ServerImpl.access$410(r1)     // Catch:{ all -> 0x005e }
                io.grpc.internal.ServerImpl r1 = io.grpc.internal.ServerImpl.this     // Catch:{ all -> 0x005e }
                int r1 = r1.activeTransportServers     // Catch:{ all -> 0x005e }
                if (r1 == 0) goto L_0x0016
                monitor-exit(r0)     // Catch:{ all -> 0x005e }
                return
            L_0x0016:
                java.util.ArrayList r1 = new java.util.ArrayList     // Catch:{ all -> 0x005e }
                io.grpc.internal.ServerImpl r2 = io.grpc.internal.ServerImpl.this     // Catch:{ all -> 0x005e }
                java.util.Set r2 = r2.transports     // Catch:{ all -> 0x005e }
                r1.<init>(r2)     // Catch:{ all -> 0x005e }
                io.grpc.internal.ServerImpl r2 = io.grpc.internal.ServerImpl.this     // Catch:{ all -> 0x005e }
                io.grpc.Status r2 = r2.shutdownNowStatus     // Catch:{ all -> 0x005e }
                io.grpc.internal.ServerImpl r3 = io.grpc.internal.ServerImpl.this     // Catch:{ all -> 0x005e }
                r4 = 1
                boolean unused = r3.serverShutdownCallbackInvoked = r4     // Catch:{ all -> 0x005e }
                monitor-exit(r0)     // Catch:{ all -> 0x005e }
                java.util.Iterator r0 = r1.iterator()
            L_0x0032:
                boolean r1 = r0.hasNext()
                if (r1 == 0) goto L_0x0048
                java.lang.Object r1 = r0.next()
                io.grpc.internal.ServerTransport r1 = (io.grpc.internal.ServerTransport) r1
                if (r2 != 0) goto L_0x0044
                r1.shutdown()
                goto L_0x0032
            L_0x0044:
                r1.shutdownNow(r2)
                goto L_0x0032
            L_0x0048:
                io.grpc.internal.ServerImpl r0 = io.grpc.internal.ServerImpl.this
                java.lang.Object r1 = r0.lock
                monitor-enter(r1)
                io.grpc.internal.ServerImpl r0 = io.grpc.internal.ServerImpl.this     // Catch:{ all -> 0x005b }
                boolean unused = r0.transportServersTerminated = r4     // Catch:{ all -> 0x005b }
                io.grpc.internal.ServerImpl r0 = io.grpc.internal.ServerImpl.this     // Catch:{ all -> 0x005b }
                r0.checkForTermination()     // Catch:{ all -> 0x005b }
                monitor-exit(r1)     // Catch:{ all -> 0x005b }
                return
            L_0x005b:
                r0 = move-exception
                monitor-exit(r1)     // Catch:{ all -> 0x005b }
                throw r0
            L_0x005e:
                r1 = move-exception
                monitor-exit(r0)     // Catch:{ all -> 0x005e }
                goto L_0x0062
            L_0x0061:
                throw r1
            L_0x0062:
                goto L_0x0061
            */
            throw new UnsupportedOperationException("Method not decompiled: io.grpc.internal.ServerImpl.ServerListenerImpl.serverShutdown():void");
        }
    }

    private final class ServerTransportListenerImpl implements ServerTransportListener {
        private Attributes attributes;
        private Future<?> handshakeTimeoutFuture;
        /* access modifiers changed from: private */
        public final ServerTransport transport;

        ServerTransportListenerImpl(ServerTransport serverTransport) {
            this.transport = serverTransport;
        }

        public void init() {
            if (ServerImpl.this.handshakeTimeoutMillis != Long.MAX_VALUE) {
                this.handshakeTimeoutFuture = this.transport.getScheduledExecutorService().schedule(new Runnable() {
                    public void run() {
                        ServerTransportListenerImpl.this.transport.shutdownNow(Status.CANCELLED.withDescription("Handshake timeout exceeded"));
                    }
                }, ServerImpl.this.handshakeTimeoutMillis, TimeUnit.MILLISECONDS);
            } else {
                this.handshakeTimeoutFuture = new FutureTask(new Runnable() {
                    public void run() {
                    }
                }, (Object) null);
            }
            ServerImpl.this.channelz.addServerSocket(ServerImpl.this, this.transport);
        }

        public Attributes transportReady(Attributes attributes2) {
            this.handshakeTimeoutFuture.cancel(false);
            this.handshakeTimeoutFuture = null;
            for (ServerTransportFilter serverTransportFilter : ServerImpl.this.transportFilters) {
                attributes2 = (Attributes) Preconditions.checkNotNull(serverTransportFilter.transportReady(attributes2), "Filter %s returned null", (Object) serverTransportFilter);
            }
            this.attributes = attributes2;
            return attributes2;
        }

        public void transportTerminated() {
            Future<?> future = this.handshakeTimeoutFuture;
            if (future != null) {
                future.cancel(false);
                this.handshakeTimeoutFuture = null;
            }
            for (ServerTransportFilter transportTerminated : ServerImpl.this.transportFilters) {
                transportTerminated.transportTerminated(this.attributes);
            }
            ServerImpl.this.transportClosed(this.transport);
        }

        public void streamCreated(ServerStream serverStream, String str, Metadata metadata) {
            Executor executor;
            if (metadata.containsKey(GrpcUtil.MESSAGE_ENCODING_KEY)) {
                String str2 = (String) metadata.get(GrpcUtil.MESSAGE_ENCODING_KEY);
                Decompressor lookupDecompressor = ServerImpl.this.decompressorRegistry.lookupDecompressor(str2);
                if (lookupDecompressor == null) {
                    serverStream.close(Status.UNIMPLEMENTED.withDescription(String.format("Can't find decompressor for %s", new Object[]{str2})), new Metadata());
                    return;
                }
                serverStream.setDecompressor(lookupDecompressor);
            }
            StatsTraceContext statsTraceContext = (StatsTraceContext) Preconditions.checkNotNull(serverStream.statsTraceContext(), "statsTraceCtx not present from stream");
            Context.CancellableContext createContext = createContext(serverStream, metadata, statsTraceContext);
            if (ServerImpl.this.executor == MoreExecutors.directExecutor()) {
                executor = new SerializeReentrantCallsDirectExecutor();
            } else {
                executor = new SerializingExecutor(ServerImpl.this.executor);
            }
            JumpToApplicationThreadServerStreamListener jumpToApplicationThreadServerStreamListener = new JumpToApplicationThreadServerStreamListener(executor, ServerImpl.this.executor, serverStream, createContext);
            serverStream.setListener(jumpToApplicationThreadServerStreamListener);
            executor.execute(new ContextRunnable(createContext, str, serverStream, metadata, statsTraceContext, jumpToApplicationThreadServerStreamListener) {
                final /* synthetic */ Context.CancellableContext val$context;
                final /* synthetic */ Metadata val$headers;
                final /* synthetic */ JumpToApplicationThreadServerStreamListener val$jumpListener;
                final /* synthetic */ String val$methodName;
                final /* synthetic */ StatsTraceContext val$statsTraceCtx;
                final /* synthetic */ ServerStream val$stream;

                {
                    this.val$context = r2;
                    this.val$methodName = r3;
                    this.val$stream = r4;
                    this.val$headers = r5;
                    this.val$statsTraceCtx = r6;
                    this.val$jumpListener = r7;
                }

                public void runInContext() {
                    ServerStreamListener access$1600 = ServerImpl.NOOP_LISTENER;
                    try {
                        ServerMethodDefinition<?, ?> lookupMethod = ServerImpl.this.registry.lookupMethod(this.val$methodName);
                        if (lookupMethod == null) {
                            lookupMethod = ServerImpl.this.fallbackRegistry.lookupMethod(this.val$methodName, this.val$stream.getAuthority());
                        }
                        ServerMethodDefinition<?, ?> serverMethodDefinition = lookupMethod;
                        if (serverMethodDefinition == null) {
                            Status status = Status.UNIMPLEMENTED;
                            this.val$stream.close(status.withDescription("Method not found: " + this.val$methodName), new Metadata());
                            this.val$context.cancel((Throwable) null);
                            this.val$jumpListener.setListener(access$1600);
                            return;
                        }
                        this.val$jumpListener.setListener(ServerTransportListenerImpl.this.startCall(this.val$stream, this.val$methodName, serverMethodDefinition, this.val$headers, this.val$context, this.val$statsTraceCtx));
                    } catch (RuntimeException e) {
                        this.val$stream.close(Status.fromThrowable(e), new Metadata());
                        this.val$context.cancel((Throwable) null);
                        throw e;
                    } catch (Error e2) {
                        this.val$stream.close(Status.fromThrowable(e2), new Metadata());
                        this.val$context.cancel((Throwable) null);
                        throw e2;
                    } catch (Throwable th) {
                        this.val$jumpListener.setListener(access$1600);
                        throw th;
                    }
                }
            });
        }

        private Context.CancellableContext createContext(final ServerStream serverStream, Metadata metadata, StatsTraceContext statsTraceContext) {
            Long l = (Long) metadata.get(GrpcUtil.TIMEOUT_KEY);
            Context serverFilterContext = statsTraceContext.serverFilterContext(ServerImpl.this.rootContext);
            if (l == null) {
                return serverFilterContext.withCancellation();
            }
            Context.CancellableContext withDeadlineAfter = serverFilterContext.withDeadlineAfter(l.longValue(), TimeUnit.NANOSECONDS, this.transport.getScheduledExecutorService());
            withDeadlineAfter.addListener(new Context.CancellationListener() {
                public void cancelled(Context context) {
                    Status statusFromCancelled = Contexts.statusFromCancelled(context);
                    if (Status.DEADLINE_EXCEEDED.getCode().equals(statusFromCancelled.getCode())) {
                        serverStream.cancel(statusFromCancelled);
                    }
                }
            }, MoreExecutors.directExecutor());
            return withDeadlineAfter;
        }

        /* JADX WARNING: type inference failed for: r9v0, types: [io.grpc.ServerMethodDefinition<ReqT, RespT>, io.grpc.ServerMethodDefinition] */
        /* access modifiers changed from: private */
        /* JADX WARNING: Unknown variable types count: 1 */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public <ReqT, RespT> io.grpc.internal.ServerStreamListener startCall(io.grpc.internal.ServerStream r7, java.lang.String r8, io.grpc.ServerMethodDefinition<ReqT, RespT> r9, io.grpc.Metadata r10, io.grpc.Context.CancellableContext r11, io.grpc.internal.StatsTraceContext r12) {
            /*
                r6 = this;
                io.grpc.internal.ServerCallInfoImpl r0 = new io.grpc.internal.ServerCallInfoImpl
                io.grpc.MethodDescriptor r1 = r9.getMethodDescriptor()
                io.grpc.Attributes r2 = r7.getAttributes()
                java.lang.String r3 = r7.getAuthority()
                r0.<init>(r1, r2, r3)
                r12.serverCallStarted(r0)
                io.grpc.ServerCallHandler r12 = r9.getServerCallHandler()
                io.grpc.internal.ServerImpl r0 = io.grpc.internal.ServerImpl.this
                io.grpc.ServerInterceptor[] r0 = r0.interceptors
                int r1 = r0.length
                r2 = 0
            L_0x0020:
                if (r2 >= r1) goto L_0x002b
                r3 = r0[r2]
                io.grpc.ServerCallHandler r12 = io.grpc.InternalServerInterceptors.interceptCallHandler(r3, r12)
                int r2 = r2 + 1
                goto L_0x0020
            L_0x002b:
                io.grpc.ServerMethodDefinition r9 = r9.withServerCallHandler(r12)
                io.grpc.internal.ServerImpl r12 = io.grpc.internal.ServerImpl.this
                io.grpc.BinaryLog r12 = r12.binlog
                if (r12 != 0) goto L_0x0038
                goto L_0x0042
            L_0x0038:
                io.grpc.internal.ServerImpl r12 = io.grpc.internal.ServerImpl.this
                io.grpc.BinaryLog r12 = r12.binlog
                io.grpc.ServerMethodDefinition r9 = r12.wrapMethodDefinition(r9)
            L_0x0042:
                r2 = r9
                r0 = r6
                r1 = r8
                r3 = r7
                r4 = r10
                r5 = r11
                io.grpc.internal.ServerStreamListener r7 = r0.startWrappedCall(r1, r2, r3, r4, r5)
                return r7
            */
            throw new UnsupportedOperationException("Method not decompiled: io.grpc.internal.ServerImpl.ServerTransportListenerImpl.startCall(io.grpc.internal.ServerStream, java.lang.String, io.grpc.ServerMethodDefinition, io.grpc.Metadata, io.grpc.Context$CancellableContext, io.grpc.internal.StatsTraceContext):io.grpc.internal.ServerStreamListener");
        }

        private <WReqT, WRespT> ServerStreamListener startWrappedCall(String str, ServerMethodDefinition<WReqT, WRespT> serverMethodDefinition, ServerStream serverStream, Metadata metadata, Context.CancellableContext cancellableContext) {
            ServerCallImpl serverCallImpl = new ServerCallImpl(serverStream, serverMethodDefinition.getMethodDescriptor(), metadata, cancellableContext, ServerImpl.this.decompressorRegistry, ServerImpl.this.compressorRegistry, ServerImpl.this.serverCallTracer);
            ServerCall.Listener<WReqT> startCall = serverMethodDefinition.getServerCallHandler().startCall(serverCallImpl, metadata);
            if (startCall != null) {
                return serverCallImpl.newServerStreamListener(startCall);
            }
            throw new NullPointerException("startCall() returned a null listener for method " + str);
        }
    }

    public InternalLogId getLogId() {
        return this.logId;
    }

    public ListenableFuture<InternalChannelz.ServerStats> getStats() {
        InternalChannelz.ServerStats.Builder builder = new InternalChannelz.ServerStats.Builder();
        for (InternalServer listenSocketStats : this.transportServers) {
            InternalInstrumented<InternalChannelz.SocketStats> listenSocketStats2 = listenSocketStats.getListenSocketStats();
            if (listenSocketStats2 != null) {
                builder.addListenSockets(Collections.singletonList(listenSocketStats2));
            }
        }
        this.serverCallTracer.updateBuilder(builder);
        SettableFuture create = SettableFuture.create();
        create.set(builder.build());
        return create;
    }

    public String toString() {
        return MoreObjects.toStringHelper((Object) this).add("logId", this.logId.getId()).add("transportServers", (Object) this.transportServers).toString();
    }

    private static final class NoopListener implements ServerStreamListener {
        public void closed(Status status) {
        }

        public void halfClosed() {
        }

        public void onReady() {
        }

        private NoopListener() {
        }

        public void messagesAvailable(StreamListener.MessageProducer messageProducer) {
            while (true) {
                InputStream next = messageProducer.next();
                if (next != null) {
                    try {
                        next.close();
                    } catch (IOException e) {
                        while (true) {
                            InputStream next2 = messageProducer.next();
                            if (next2 != null) {
                                try {
                                    next2.close();
                                } catch (IOException e2) {
                                    ServerImpl.log.log(Level.WARNING, "Exception closing stream", e2);
                                }
                            } else {
                                throw new RuntimeException(e);
                            }
                        }
                    }
                } else {
                    return;
                }
            }
        }
    }

    @VisibleForTesting
    static final class JumpToApplicationThreadServerStreamListener implements ServerStreamListener {
        private final Executor callExecutor;
        private final Executor cancelExecutor;
        /* access modifiers changed from: private */
        public final Context.CancellableContext context;
        private ServerStreamListener listener;
        private final ServerStream stream;

        public JumpToApplicationThreadServerStreamListener(Executor executor, Executor executor2, ServerStream serverStream, Context.CancellableContext cancellableContext) {
            this.callExecutor = executor;
            this.cancelExecutor = executor2;
            this.stream = serverStream;
            this.context = cancellableContext;
        }

        /* access modifiers changed from: private */
        public ServerStreamListener getListener() {
            ServerStreamListener serverStreamListener = this.listener;
            if (serverStreamListener != null) {
                return serverStreamListener;
            }
            throw new IllegalStateException("listener unset");
        }

        /* access modifiers changed from: package-private */
        @VisibleForTesting
        public void setListener(ServerStreamListener serverStreamListener) {
            Preconditions.checkNotNull(serverStreamListener, "listener must not be null");
            Preconditions.checkState(this.listener == null, "Listener already set");
            this.listener = serverStreamListener;
        }

        /* access modifiers changed from: private */
        public void internalClose() {
            this.stream.close(Status.UNKNOWN, new Metadata());
        }

        public void messagesAvailable(final StreamListener.MessageProducer messageProducer) {
            this.callExecutor.execute(new ContextRunnable() {
                public void runInContext() {
                    try {
                        JumpToApplicationThreadServerStreamListener.this.getListener().messagesAvailable(messageProducer);
                    } catch (RuntimeException e) {
                        JumpToApplicationThreadServerStreamListener.this.internalClose();
                        throw e;
                    } catch (Error e2) {
                        JumpToApplicationThreadServerStreamListener.this.internalClose();
                        throw e2;
                    }
                }
            });
        }

        public void halfClosed() {
            this.callExecutor.execute(new ContextRunnable() {
                {
                    Context.CancellableContext access$2600 = JumpToApplicationThreadServerStreamListener.this.context;
                }

                public void runInContext() {
                    try {
                        JumpToApplicationThreadServerStreamListener.this.getListener().halfClosed();
                    } catch (RuntimeException e) {
                        JumpToApplicationThreadServerStreamListener.this.internalClose();
                        throw e;
                    } catch (Error e2) {
                        JumpToApplicationThreadServerStreamListener.this.internalClose();
                        throw e2;
                    }
                }
            });
        }

        public void closed(final Status status) {
            if (!status.isOk()) {
                this.cancelExecutor.execute(new ContextCloser(this.context, status.getCause()));
            }
            this.callExecutor.execute(new ContextRunnable() {
                public void runInContext() {
                    JumpToApplicationThreadServerStreamListener.this.getListener().closed(status);
                }
            });
        }

        public void onReady() {
            this.callExecutor.execute(new ContextRunnable() {
                {
                    Context.CancellableContext access$2600 = JumpToApplicationThreadServerStreamListener.this.context;
                }

                public void runInContext() {
                    try {
                        JumpToApplicationThreadServerStreamListener.this.getListener().onReady();
                    } catch (RuntimeException e) {
                        JumpToApplicationThreadServerStreamListener.this.internalClose();
                        throw e;
                    } catch (Error e2) {
                        JumpToApplicationThreadServerStreamListener.this.internalClose();
                        throw e2;
                    }
                }
            });
        }
    }

    @VisibleForTesting
    static final class ContextCloser implements Runnable {
        private final Throwable cause;
        private final Context.CancellableContext context;

        ContextCloser(Context.CancellableContext cancellableContext, Throwable th) {
            this.context = cancellableContext;
            this.cause = th;
        }

        public void run() {
            this.context.cancel(this.cause);
        }
    }
}
