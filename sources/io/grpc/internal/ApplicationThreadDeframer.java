package io.grpc.internal;

import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.google.common.base.Preconditions;
import io.grpc.Decompressor;
import io.grpc.internal.MessageDeframer;
import io.grpc.internal.StreamListener;
import java.io.InputStream;
import java.util.ArrayDeque;
import java.util.Queue;
import javax.annotation.Nullable;

public class ApplicationThreadDeframer implements Deframer, MessageDeframer.Listener {
    /* access modifiers changed from: private */
    public final MessageDeframer deframer;
    /* access modifiers changed from: private */
    public final Queue<InputStream> messageReadQueue = new ArrayDeque();
    /* access modifiers changed from: private */
    public final MessageDeframer.Listener storedListener;
    private final TransportExecutor transportExecutor;

    interface TransportExecutor {
        void runOnTransportThread(Runnable runnable);
    }

    ApplicationThreadDeframer(MessageDeframer.Listener listener, TransportExecutor transportExecutor2, MessageDeframer messageDeframer) {
        this.storedListener = (MessageDeframer.Listener) Preconditions.checkNotNull(listener, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        this.transportExecutor = (TransportExecutor) Preconditions.checkNotNull(transportExecutor2, "transportExecutor");
        messageDeframer.setListener(this);
        this.deframer = messageDeframer;
    }

    public void setMaxInboundMessageSize(int i) {
        this.deframer.setMaxInboundMessageSize(i);
    }

    public void setDecompressor(Decompressor decompressor) {
        this.deframer.setDecompressor(decompressor);
    }

    public void setFullStreamDecompressor(GzipInflatingBuffer gzipInflatingBuffer) {
        this.deframer.setFullStreamDecompressor(gzipInflatingBuffer);
    }

    public void request(final int i) {
        this.storedListener.messagesAvailable(new InitializingMessageProducer(new Runnable() {
            public void run() {
                if (!ApplicationThreadDeframer.this.deframer.isClosed()) {
                    try {
                        ApplicationThreadDeframer.this.deframer.request(i);
                    } catch (Throwable th) {
                        ApplicationThreadDeframer.this.storedListener.deframeFailed(th);
                        ApplicationThreadDeframer.this.deframer.close();
                    }
                }
            }
        }));
    }

    public void deframe(final ReadableBuffer readableBuffer) {
        this.storedListener.messagesAvailable(new InitializingMessageProducer(new Runnable() {
            public void run() {
                try {
                    ApplicationThreadDeframer.this.deframer.deframe(readableBuffer);
                } catch (Throwable th) {
                    ApplicationThreadDeframer.this.deframeFailed(th);
                    ApplicationThreadDeframer.this.deframer.close();
                }
            }
        }));
    }

    public void closeWhenComplete() {
        this.storedListener.messagesAvailable(new InitializingMessageProducer(new Runnable() {
            public void run() {
                ApplicationThreadDeframer.this.deframer.closeWhenComplete();
            }
        }));
    }

    public void close() {
        this.deframer.stopDelivery();
        this.storedListener.messagesAvailable(new InitializingMessageProducer(new Runnable() {
            public void run() {
                ApplicationThreadDeframer.this.deframer.close();
            }
        }));
    }

    public void bytesRead(final int i) {
        this.transportExecutor.runOnTransportThread(new Runnable() {
            public void run() {
                ApplicationThreadDeframer.this.storedListener.bytesRead(i);
            }
        });
    }

    public void messagesAvailable(StreamListener.MessageProducer messageProducer) {
        while (true) {
            InputStream next = messageProducer.next();
            if (next != null) {
                this.messageReadQueue.add(next);
            } else {
                return;
            }
        }
    }

    public void deframerClosed(final boolean z) {
        this.transportExecutor.runOnTransportThread(new Runnable() {
            public void run() {
                ApplicationThreadDeframer.this.storedListener.deframerClosed(z);
            }
        });
    }

    public void deframeFailed(final Throwable th) {
        this.transportExecutor.runOnTransportThread(new Runnable() {
            public void run() {
                ApplicationThreadDeframer.this.storedListener.deframeFailed(th);
            }
        });
    }

    private class InitializingMessageProducer implements StreamListener.MessageProducer {
        private boolean initialized;
        private final Runnable runnable;

        private InitializingMessageProducer(Runnable runnable2) {
            this.initialized = false;
            this.runnable = runnable2;
        }

        private void initialize() {
            if (!this.initialized) {
                this.runnable.run();
                this.initialized = true;
            }
        }

        @Nullable
        public InputStream next() {
            initialize();
            return (InputStream) ApplicationThreadDeframer.this.messageReadQueue.poll();
        }
    }
}
