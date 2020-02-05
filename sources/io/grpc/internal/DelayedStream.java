package io.grpc.internal;

import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Preconditions;
import io.grpc.Attributes;
import io.grpc.Compressor;
import io.grpc.Deadline;
import io.grpc.DecompressorRegistry;
import io.grpc.Metadata;
import io.grpc.Status;
import io.grpc.internal.ClientStreamListener;
import io.grpc.internal.StreamListener;
import io.sentry.marshaller.json.JsonMarshaller;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.concurrent.GuardedBy;

class DelayedStream implements ClientStream {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    @GuardedBy("this")
    private DelayedStreamListener delayedListener;
    @GuardedBy("this")
    private Status error;
    private ClientStreamListener listener;
    private volatile boolean passThrough;
    @GuardedBy("this")
    private List<Runnable> pendingCalls = new ArrayList();
    /* access modifiers changed from: private */
    public ClientStream realStream;

    DelayedStream() {
    }

    public void setMaxInboundMessageSize(final int i) {
        if (this.passThrough) {
            this.realStream.setMaxInboundMessageSize(i);
        } else {
            delayOrExecute(new Runnable() {
                public void run() {
                    DelayedStream.this.realStream.setMaxInboundMessageSize(i);
                }
            });
        }
    }

    public void setMaxOutboundMessageSize(final int i) {
        if (this.passThrough) {
            this.realStream.setMaxOutboundMessageSize(i);
        } else {
            delayOrExecute(new Runnable() {
                public void run() {
                    DelayedStream.this.realStream.setMaxOutboundMessageSize(i);
                }
            });
        }
    }

    public void setDeadline(final Deadline deadline) {
        delayOrExecute(new Runnable() {
            public void run() {
                DelayedStream.this.realStream.setDeadline(deadline);
            }
        });
    }

    /* access modifiers changed from: package-private */
    public final void setStream(ClientStream clientStream) {
        synchronized (this) {
            if (this.realStream == null) {
                this.realStream = (ClientStream) Preconditions.checkNotNull(clientStream, "stream");
                drainPendingCalls();
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0022, code lost:
        r0 = r1.iterator();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x002a, code lost:
        if (r0.hasNext() == false) goto L_0x0036;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x002c, code lost:
        ((java.lang.Runnable) r0.next()).run();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:7:0x0017, code lost:
        if (r0 == null) goto L_?;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0019, code lost:
        r0.drainPendingCallbacks();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void drainPendingCalls() {
        /*
            r3 = this;
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
        L_0x0005:
            monitor-enter(r3)
            java.util.List<java.lang.Runnable> r1 = r3.pendingCalls     // Catch:{ all -> 0x003b }
            boolean r1 = r1.isEmpty()     // Catch:{ all -> 0x003b }
            if (r1 == 0) goto L_0x001d
            r0 = 0
            r3.pendingCalls = r0     // Catch:{ all -> 0x003b }
            r0 = 1
            r3.passThrough = r0     // Catch:{ all -> 0x003b }
            io.grpc.internal.DelayedStream$DelayedStreamListener r0 = r3.delayedListener     // Catch:{ all -> 0x003b }
            monitor-exit(r3)     // Catch:{ all -> 0x003b }
            if (r0 == 0) goto L_0x001c
            r0.drainPendingCallbacks()
        L_0x001c:
            return
        L_0x001d:
            java.util.List<java.lang.Runnable> r1 = r3.pendingCalls     // Catch:{ all -> 0x003b }
            r3.pendingCalls = r0     // Catch:{ all -> 0x003b }
            monitor-exit(r3)     // Catch:{ all -> 0x003b }
            java.util.Iterator r0 = r1.iterator()
        L_0x0026:
            boolean r2 = r0.hasNext()
            if (r2 == 0) goto L_0x0036
            java.lang.Object r2 = r0.next()
            java.lang.Runnable r2 = (java.lang.Runnable) r2
            r2.run()
            goto L_0x0026
        L_0x0036:
            r1.clear()
            r0 = r1
            goto L_0x0005
        L_0x003b:
            r0 = move-exception
            monitor-exit(r3)     // Catch:{ all -> 0x003b }
            goto L_0x003f
        L_0x003e:
            throw r0
        L_0x003f:
            goto L_0x003e
        */
        throw new UnsupportedOperationException("Method not decompiled: io.grpc.internal.DelayedStream.drainPendingCalls():void");
    }

    private void delayOrExecute(Runnable runnable) {
        synchronized (this) {
            if (!this.passThrough) {
                this.pendingCalls.add(runnable);
            } else {
                runnable.run();
            }
        }
    }

    public void setAuthority(final String str) {
        Preconditions.checkState(this.listener == null, "May only be called before start");
        Preconditions.checkNotNull(str, "authority");
        delayOrExecute(new Runnable() {
            public void run() {
                DelayedStream.this.realStream.setAuthority(str);
            }
        });
    }

    public void start(final ClientStreamListener clientStreamListener) {
        Status status;
        boolean z;
        Preconditions.checkState(this.listener == null, "already started");
        synchronized (this) {
            this.listener = (ClientStreamListener) Preconditions.checkNotNull(clientStreamListener, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
            status = this.error;
            z = this.passThrough;
            if (!z) {
                DelayedStreamListener delayedStreamListener = new DelayedStreamListener(clientStreamListener);
                this.delayedListener = delayedStreamListener;
                clientStreamListener = delayedStreamListener;
            }
        }
        if (status != null) {
            clientStreamListener.closed(status, new Metadata());
        } else if (z) {
            this.realStream.start(clientStreamListener);
        } else {
            delayOrExecute(new Runnable() {
                public void run() {
                    DelayedStream.this.realStream.start(clientStreamListener);
                }
            });
        }
    }

    public Attributes getAttributes() {
        Preconditions.checkState(this.passThrough, "Called getAttributes before attributes are ready");
        return this.realStream.getAttributes();
    }

    public void writeMessage(final InputStream inputStream) {
        Preconditions.checkNotNull(inputStream, JsonMarshaller.MESSAGE);
        if (this.passThrough) {
            this.realStream.writeMessage(inputStream);
        } else {
            delayOrExecute(new Runnable() {
                public void run() {
                    DelayedStream.this.realStream.writeMessage(inputStream);
                }
            });
        }
    }

    public void flush() {
        if (this.passThrough) {
            this.realStream.flush();
        } else {
            delayOrExecute(new Runnable() {
                public void run() {
                    DelayedStream.this.realStream.flush();
                }
            });
        }
    }

    public void cancel(final Status status) {
        ClientStreamListener clientStreamListener;
        boolean z;
        Preconditions.checkNotNull(status, "reason");
        synchronized (this) {
            if (this.realStream == null) {
                this.realStream = NoopClientStream.INSTANCE;
                z = false;
                clientStreamListener = this.listener;
                this.error = status;
            } else {
                z = true;
                clientStreamListener = null;
            }
        }
        if (z) {
            delayOrExecute(new Runnable() {
                public void run() {
                    DelayedStream.this.realStream.cancel(status);
                }
            });
            return;
        }
        if (clientStreamListener != null) {
            clientStreamListener.closed(status, new Metadata());
        }
        drainPendingCalls();
    }

    public void halfClose() {
        delayOrExecute(new Runnable() {
            public void run() {
                DelayedStream.this.realStream.halfClose();
            }
        });
    }

    public void request(final int i) {
        if (this.passThrough) {
            this.realStream.request(i);
        } else {
            delayOrExecute(new Runnable() {
                public void run() {
                    DelayedStream.this.realStream.request(i);
                }
            });
        }
    }

    public void setCompressor(final Compressor compressor) {
        Preconditions.checkNotNull(compressor, "compressor");
        delayOrExecute(new Runnable() {
            public void run() {
                DelayedStream.this.realStream.setCompressor(compressor);
            }
        });
    }

    public void setFullStreamDecompression(final boolean z) {
        delayOrExecute(new Runnable() {
            public void run() {
                DelayedStream.this.realStream.setFullStreamDecompression(z);
            }
        });
    }

    public void setDecompressorRegistry(final DecompressorRegistry decompressorRegistry) {
        Preconditions.checkNotNull(decompressorRegistry, "decompressorRegistry");
        delayOrExecute(new Runnable() {
            public void run() {
                DelayedStream.this.realStream.setDecompressorRegistry(decompressorRegistry);
            }
        });
    }

    public boolean isReady() {
        if (this.passThrough) {
            return this.realStream.isReady();
        }
        return false;
    }

    public void setMessageCompression(final boolean z) {
        if (this.passThrough) {
            this.realStream.setMessageCompression(z);
        } else {
            delayOrExecute(new Runnable() {
                public void run() {
                    DelayedStream.this.realStream.setMessageCompression(z);
                }
            });
        }
    }

    /* access modifiers changed from: package-private */
    @VisibleForTesting
    public ClientStream getRealStream() {
        return this.realStream;
    }

    private static class DelayedStreamListener implements ClientStreamListener {
        static final /* synthetic */ boolean $assertionsDisabled = false;
        private volatile boolean passThrough;
        @GuardedBy("this")
        private List<Runnable> pendingCallbacks = new ArrayList();
        /* access modifiers changed from: private */
        public final ClientStreamListener realListener;

        static {
            Class<DelayedStream> cls = DelayedStream.class;
        }

        public DelayedStreamListener(ClientStreamListener clientStreamListener) {
            this.realListener = clientStreamListener;
        }

        private void delayOrExecute(Runnable runnable) {
            synchronized (this) {
                if (!this.passThrough) {
                    this.pendingCallbacks.add(runnable);
                } else {
                    runnable.run();
                }
            }
        }

        public void messagesAvailable(final StreamListener.MessageProducer messageProducer) {
            if (this.passThrough) {
                this.realListener.messagesAvailable(messageProducer);
            } else {
                delayOrExecute(new Runnable() {
                    public void run() {
                        DelayedStreamListener.this.realListener.messagesAvailable(messageProducer);
                    }
                });
            }
        }

        public void onReady() {
            if (this.passThrough) {
                this.realListener.onReady();
            } else {
                delayOrExecute(new Runnable() {
                    public void run() {
                        DelayedStreamListener.this.realListener.onReady();
                    }
                });
            }
        }

        public void headersRead(final Metadata metadata) {
            delayOrExecute(new Runnable() {
                public void run() {
                    DelayedStreamListener.this.realListener.headersRead(metadata);
                }
            });
        }

        public void closed(final Status status, final Metadata metadata) {
            delayOrExecute(new Runnable() {
                public void run() {
                    DelayedStreamListener.this.realListener.closed(status, metadata);
                }
            });
        }

        public void closed(final Status status, final ClientStreamListener.RpcProgress rpcProgress, final Metadata metadata) {
            delayOrExecute(new Runnable() {
                public void run() {
                    DelayedStreamListener.this.realListener.closed(status, rpcProgress, metadata);
                }
            });
        }

        /* JADX WARNING: Code restructure failed: missing block: B:10:0x001b, code lost:
            r0 = r1.iterator();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:12:0x0023, code lost:
            if (r0.hasNext() == false) goto L_0x002f;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:13:0x0025, code lost:
            ((java.lang.Runnable) r0.next()).run();
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void drainPendingCallbacks() {
            /*
                r3 = this;
                java.util.ArrayList r0 = new java.util.ArrayList
                r0.<init>()
            L_0x0005:
                monitor-enter(r3)
                java.util.List<java.lang.Runnable> r1 = r3.pendingCallbacks     // Catch:{ all -> 0x0034 }
                boolean r1 = r1.isEmpty()     // Catch:{ all -> 0x0034 }
                if (r1 == 0) goto L_0x0016
                r0 = 0
                r3.pendingCallbacks = r0     // Catch:{ all -> 0x0034 }
                r0 = 1
                r3.passThrough = r0     // Catch:{ all -> 0x0034 }
                monitor-exit(r3)     // Catch:{ all -> 0x0034 }
                return
            L_0x0016:
                java.util.List<java.lang.Runnable> r1 = r3.pendingCallbacks     // Catch:{ all -> 0x0034 }
                r3.pendingCallbacks = r0     // Catch:{ all -> 0x0034 }
                monitor-exit(r3)     // Catch:{ all -> 0x0034 }
                java.util.Iterator r0 = r1.iterator()
            L_0x001f:
                boolean r2 = r0.hasNext()
                if (r2 == 0) goto L_0x002f
                java.lang.Object r2 = r0.next()
                java.lang.Runnable r2 = (java.lang.Runnable) r2
                r2.run()
                goto L_0x001f
            L_0x002f:
                r1.clear()
                r0 = r1
                goto L_0x0005
            L_0x0034:
                r0 = move-exception
                monitor-exit(r3)     // Catch:{ all -> 0x0034 }
                goto L_0x0038
            L_0x0037:
                throw r0
            L_0x0038:
                goto L_0x0037
            */
            throw new UnsupportedOperationException("Method not decompiled: io.grpc.internal.DelayedStream.DelayedStreamListener.drainPendingCallbacks():void");
        }
    }
}
