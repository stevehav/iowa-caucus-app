package io.grpc.internal;

import com.google.common.annotations.VisibleForTesting;
import io.grpc.InternalChannelz;
import io.grpc.InternalInstrumented;
import io.grpc.LoadBalancer;
import javax.annotation.Nullable;

abstract class AbstractSubchannel extends LoadBalancer.Subchannel {
    /* access modifiers changed from: package-private */
    @VisibleForTesting
    public abstract InternalInstrumented<InternalChannelz.ChannelStats> getInternalSubchannel();

    /* access modifiers changed from: package-private */
    @Nullable
    public abstract ClientTransport obtainActiveTransport();

    AbstractSubchannel() {
    }
}
