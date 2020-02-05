package io.grpc.internal;

import io.grpc.Context;

abstract class ContextRunnable implements Runnable {
    private final Context context;

    public abstract void runInContext();

    public ContextRunnable(Context context2) {
        this.context = context2;
    }

    public final void run() {
        Context attach = this.context.attach();
        try {
            runInContext();
        } finally {
            this.context.detach(attach);
        }
    }
}
