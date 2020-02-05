package io.grpc.internal;

import com.google.common.base.MoreObjects;
import com.google.common.base.Preconditions;
import io.grpc.NameResolver;

abstract class ForwardingNameResolver extends NameResolver {
    private final NameResolver delegate;

    ForwardingNameResolver(NameResolver nameResolver) {
        Preconditions.checkNotNull(nameResolver, "delegate can not be null");
        this.delegate = nameResolver;
    }

    public String getServiceAuthority() {
        return this.delegate.getServiceAuthority();
    }

    @Deprecated
    public void start(NameResolver.Listener listener) {
        this.delegate.start(listener);
    }

    public void start(NameResolver.Listener2 listener2) {
        this.delegate.start(listener2);
    }

    public void shutdown() {
        this.delegate.shutdown();
    }

    public void refresh() {
        this.delegate.refresh();
    }

    public String toString() {
        return MoreObjects.toStringHelper((Object) this).add("delegate", (Object) this.delegate).toString();
    }
}
