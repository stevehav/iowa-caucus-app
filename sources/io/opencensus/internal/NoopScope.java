package io.opencensus.internal;

import io.opencensus.common.Scope;

public final class NoopScope implements Scope {
    private static final Scope INSTANCE = new NoopScope();

    public void close() {
    }

    private NoopScope() {
    }

    public static Scope getInstance() {
        return INSTANCE;
    }
}
