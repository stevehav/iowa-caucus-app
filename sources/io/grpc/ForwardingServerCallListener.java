package io.grpc;

import io.grpc.ServerCall;

public abstract class ForwardingServerCallListener<ReqT> extends PartialForwardingServerCallListener<ReqT> {
    /* access modifiers changed from: protected */
    public abstract ServerCall.Listener<ReqT> delegate();

    public /* bridge */ /* synthetic */ void onCancel() {
        super.onCancel();
    }

    public /* bridge */ /* synthetic */ void onComplete() {
        super.onComplete();
    }

    public /* bridge */ /* synthetic */ void onHalfClose() {
        super.onHalfClose();
    }

    public /* bridge */ /* synthetic */ void onReady() {
        super.onReady();
    }

    public /* bridge */ /* synthetic */ String toString() {
        return super.toString();
    }

    public void onMessage(ReqT reqt) {
        delegate().onMessage(reqt);
    }

    public static abstract class SimpleForwardingServerCallListener<ReqT> extends ForwardingServerCallListener<ReqT> {
        private final ServerCall.Listener<ReqT> delegate;

        public /* bridge */ /* synthetic */ void onCancel() {
            ForwardingServerCallListener.super.onCancel();
        }

        public /* bridge */ /* synthetic */ void onComplete() {
            ForwardingServerCallListener.super.onComplete();
        }

        public /* bridge */ /* synthetic */ void onHalfClose() {
            ForwardingServerCallListener.super.onHalfClose();
        }

        public /* bridge */ /* synthetic */ void onReady() {
            ForwardingServerCallListener.super.onReady();
        }

        public /* bridge */ /* synthetic */ String toString() {
            return ForwardingServerCallListener.super.toString();
        }

        protected SimpleForwardingServerCallListener(ServerCall.Listener<ReqT> listener) {
            this.delegate = listener;
        }

        /* access modifiers changed from: protected */
        public ServerCall.Listener<ReqT> delegate() {
            return this.delegate;
        }
    }
}
