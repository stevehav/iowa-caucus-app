package io.grpc;

import com.google.common.base.MoreObjects;
import javax.annotation.Nullable;

abstract class PartialForwardingClientCall<ReqT, RespT> extends ClientCall<ReqT, RespT> {
    /* access modifiers changed from: protected */
    public abstract ClientCall<?, ?> delegate();

    PartialForwardingClientCall() {
    }

    public void request(int i) {
        delegate().request(i);
    }

    public void cancel(@Nullable String str, @Nullable Throwable th) {
        delegate().cancel(str, th);
    }

    public void halfClose() {
        delegate().halfClose();
    }

    public void setMessageCompression(boolean z) {
        delegate().setMessageCompression(z);
    }

    public boolean isReady() {
        return delegate().isReady();
    }

    public Attributes getAttributes() {
        return delegate().getAttributes();
    }

    public String toString() {
        return MoreObjects.toStringHelper((Object) this).add("delegate", (Object) delegate()).toString();
    }
}
