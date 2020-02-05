package io.grpc.internal;

import com.google.common.base.MoreObjects;
import io.grpc.Attributes;
import io.grpc.Compressor;
import io.grpc.Deadline;
import io.grpc.DecompressorRegistry;
import io.grpc.Status;
import java.io.InputStream;

abstract class ForwardingClientStream implements ClientStream {
    /* access modifiers changed from: protected */
    public abstract ClientStream delegate();

    ForwardingClientStream() {
    }

    public void request(int i) {
        delegate().request(i);
    }

    public void writeMessage(InputStream inputStream) {
        delegate().writeMessage(inputStream);
    }

    public void flush() {
        delegate().flush();
    }

    public boolean isReady() {
        return delegate().isReady();
    }

    public void setCompressor(Compressor compressor) {
        delegate().setCompressor(compressor);
    }

    public void setMessageCompression(boolean z) {
        delegate().setMessageCompression(z);
    }

    public void cancel(Status status) {
        delegate().cancel(status);
    }

    public void halfClose() {
        delegate().halfClose();
    }

    public void setAuthority(String str) {
        delegate().setAuthority(str);
    }

    public void setFullStreamDecompression(boolean z) {
        delegate().setFullStreamDecompression(z);
    }

    public void setDecompressorRegistry(DecompressorRegistry decompressorRegistry) {
        delegate().setDecompressorRegistry(decompressorRegistry);
    }

    public void start(ClientStreamListener clientStreamListener) {
        delegate().start(clientStreamListener);
    }

    public void setMaxInboundMessageSize(int i) {
        delegate().setMaxInboundMessageSize(i);
    }

    public void setMaxOutboundMessageSize(int i) {
        delegate().setMaxOutboundMessageSize(i);
    }

    public void setDeadline(Deadline deadline) {
        delegate().setDeadline(deadline);
    }

    public Attributes getAttributes() {
        return delegate().getAttributes();
    }

    public String toString() {
        return MoreObjects.toStringHelper((Object) this).add("delegate", (Object) delegate()).toString();
    }
}
