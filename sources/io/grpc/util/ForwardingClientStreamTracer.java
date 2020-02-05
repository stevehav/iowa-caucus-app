package io.grpc.util;

import com.google.common.base.MoreObjects;
import io.grpc.ClientStreamTracer;
import io.grpc.ExperimentalApi;
import io.grpc.Metadata;
import io.grpc.Status;

@ExperimentalApi("https://github.com/grpc/grpc-java/issues/2861")
public abstract class ForwardingClientStreamTracer extends ClientStreamTracer {
    /* access modifiers changed from: protected */
    public abstract ClientStreamTracer delegate();

    public void outboundHeaders() {
        delegate().outboundHeaders();
    }

    public void inboundHeaders() {
        delegate().inboundHeaders();
    }

    public void inboundTrailers(Metadata metadata) {
        delegate().inboundTrailers(metadata);
    }

    public void streamClosed(Status status) {
        delegate().streamClosed(status);
    }

    public void outboundMessage(int i) {
        delegate().outboundMessage(i);
    }

    public void inboundMessage(int i) {
        delegate().inboundMessage(i);
    }

    public void outboundMessageSent(int i, long j, long j2) {
        delegate().outboundMessageSent(i, j, j2);
    }

    public void inboundMessageRead(int i, long j, long j2) {
        delegate().inboundMessageRead(i, j, j2);
    }

    public void outboundWireSize(long j) {
        delegate().outboundWireSize(j);
    }

    public void outboundUncompressedSize(long j) {
        delegate().outboundUncompressedSize(j);
    }

    public void inboundWireSize(long j) {
        delegate().inboundWireSize(j);
    }

    public void inboundUncompressedSize(long j) {
        delegate().inboundUncompressedSize(j);
    }

    public String toString() {
        return MoreObjects.toStringHelper((Object) this).add("delegate", (Object) delegate()).toString();
    }
}
