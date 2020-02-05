package io.grpc.util;

import com.google.common.util.concurrent.MoreExecutors;
import com.google.common.util.concurrent.SettableFuture;
import io.grpc.Attributes;
import io.grpc.ExperimentalApi;
import io.grpc.ForwardingServerCall;
import io.grpc.ForwardingServerCallListener;
import io.grpc.Metadata;
import io.grpc.ServerCall;
import io.grpc.ServerCallHandler;
import io.grpc.ServerInterceptor;
import io.grpc.Status;
import io.grpc.StatusRuntimeException;
import io.grpc.internal.SerializingExecutor;
import java.util.concurrent.ExecutionException;
import javax.annotation.Nullable;

@ExperimentalApi("https://github.com/grpc/grpc-java/issues/2189")
public final class TransmitStatusRuntimeExceptionInterceptor implements ServerInterceptor {
    private TransmitStatusRuntimeExceptionInterceptor() {
    }

    public static ServerInterceptor instance() {
        return new TransmitStatusRuntimeExceptionInterceptor();
    }

    public <ReqT, RespT> ServerCall.Listener<ReqT> interceptCall(ServerCall<ReqT, RespT> serverCall, Metadata metadata, ServerCallHandler<ReqT, RespT> serverCallHandler) {
        final SerializingServerCall serializingServerCall = new SerializingServerCall(serverCall);
        return new ForwardingServerCallListener.SimpleForwardingServerCallListener<ReqT>(serverCallHandler.startCall(serializingServerCall, metadata)) {
            public void onMessage(ReqT reqt) {
                try {
                    super.onMessage(reqt);
                } catch (StatusRuntimeException e) {
                    closeWithException(e);
                }
            }

            public void onHalfClose() {
                try {
                    super.onHalfClose();
                } catch (StatusRuntimeException e) {
                    closeWithException(e);
                }
            }

            public void onCancel() {
                try {
                    super.onCancel();
                } catch (StatusRuntimeException e) {
                    closeWithException(e);
                }
            }

            public void onComplete() {
                try {
                    super.onComplete();
                } catch (StatusRuntimeException e) {
                    closeWithException(e);
                }
            }

            public void onReady() {
                try {
                    super.onReady();
                } catch (StatusRuntimeException e) {
                    closeWithException(e);
                }
            }

            private void closeWithException(StatusRuntimeException statusRuntimeException) {
                Metadata trailers = statusRuntimeException.getTrailers();
                if (trailers == null) {
                    trailers = new Metadata();
                }
                serializingServerCall.close(statusRuntimeException.getStatus(), trailers);
            }
        };
    }

    private static class SerializingServerCall<ReqT, RespT> extends ForwardingServerCall.SimpleForwardingServerCall<ReqT, RespT> {
        private static final String ERROR_MSG = "Encountered error during serialized access";
        /* access modifiers changed from: private */
        public boolean closeCalled = false;
        private final SerializingExecutor serializingExecutor = new SerializingExecutor(MoreExecutors.directExecutor());

        SerializingServerCall(ServerCall<ReqT, RespT> serverCall) {
            super(serverCall);
        }

        public void sendMessage(final RespT respt) {
            this.serializingExecutor.execute(new Runnable() {
                public void run() {
                    SerializingServerCall.super.sendMessage(respt);
                }
            });
        }

        public void request(final int i) {
            this.serializingExecutor.execute(new Runnable() {
                public void run() {
                    SerializingServerCall.super.request(i);
                }
            });
        }

        public void sendHeaders(final Metadata metadata) {
            this.serializingExecutor.execute(new Runnable() {
                public void run() {
                    SerializingServerCall.super.sendHeaders(metadata);
                }
            });
        }

        public void close(final Status status, final Metadata metadata) {
            this.serializingExecutor.execute(new Runnable() {
                public void run() {
                    if (!SerializingServerCall.this.closeCalled) {
                        boolean unused = SerializingServerCall.this.closeCalled = true;
                        SerializingServerCall.super.close(status, metadata);
                    }
                }
            });
        }

        public boolean isReady() {
            final SettableFuture create = SettableFuture.create();
            this.serializingExecutor.execute(new Runnable() {
                public void run() {
                    create.set(Boolean.valueOf(SerializingServerCall.super.isReady()));
                }
            });
            try {
                return ((Boolean) create.get()).booleanValue();
            } catch (InterruptedException e) {
                throw new RuntimeException(ERROR_MSG, e);
            } catch (ExecutionException e2) {
                throw new RuntimeException(ERROR_MSG, e2);
            }
        }

        public boolean isCancelled() {
            final SettableFuture create = SettableFuture.create();
            this.serializingExecutor.execute(new Runnable() {
                public void run() {
                    create.set(Boolean.valueOf(SerializingServerCall.super.isCancelled()));
                }
            });
            try {
                return ((Boolean) create.get()).booleanValue();
            } catch (InterruptedException e) {
                throw new RuntimeException(ERROR_MSG, e);
            } catch (ExecutionException e2) {
                throw new RuntimeException(ERROR_MSG, e2);
            }
        }

        public void setMessageCompression(final boolean z) {
            this.serializingExecutor.execute(new Runnable() {
                public void run() {
                    SerializingServerCall.super.setMessageCompression(z);
                }
            });
        }

        public void setCompression(final String str) {
            this.serializingExecutor.execute(new Runnable() {
                public void run() {
                    SerializingServerCall.super.setCompression(str);
                }
            });
        }

        public Attributes getAttributes() {
            final SettableFuture create = SettableFuture.create();
            this.serializingExecutor.execute(new Runnable() {
                public void run() {
                    create.set(SerializingServerCall.super.getAttributes());
                }
            });
            try {
                return (Attributes) create.get();
            } catch (InterruptedException e) {
                throw new RuntimeException(ERROR_MSG, e);
            } catch (ExecutionException e2) {
                throw new RuntimeException(ERROR_MSG, e2);
            }
        }

        @Nullable
        public String getAuthority() {
            final SettableFuture create = SettableFuture.create();
            this.serializingExecutor.execute(new Runnable() {
                public void run() {
                    create.set(SerializingServerCall.super.getAuthority());
                }
            });
            try {
                return (String) create.get();
            } catch (InterruptedException e) {
                throw new RuntimeException(ERROR_MSG, e);
            } catch (ExecutionException e2) {
                throw new RuntimeException(ERROR_MSG, e2);
            }
        }
    }
}
