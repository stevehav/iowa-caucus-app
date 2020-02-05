package io.grpc.internal;

import com.google.common.base.Preconditions;
import com.google.firebase.analytics.FirebaseAnalytics;
import io.grpc.ConnectivityState;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.Executor;
import javax.annotation.Nonnull;
import javax.annotation.concurrent.NotThreadSafe;

@NotThreadSafe
final class ConnectivityStateManager {
    private ArrayList<Listener> listeners = new ArrayList<>();
    private volatile ConnectivityState state = ConnectivityState.IDLE;

    ConnectivityStateManager() {
    }

    /* access modifiers changed from: package-private */
    public void notifyWhenStateChanged(Runnable runnable, Executor executor, ConnectivityState connectivityState) {
        Preconditions.checkNotNull(runnable, "callback");
        Preconditions.checkNotNull(executor, "executor");
        Preconditions.checkNotNull(connectivityState, FirebaseAnalytics.Param.SOURCE);
        Listener listener = new Listener(runnable, executor);
        if (this.state != connectivityState) {
            listener.runInExecutor();
        } else {
            this.listeners.add(listener);
        }
    }

    /* access modifiers changed from: package-private */
    public void gotoState(@Nonnull ConnectivityState connectivityState) {
        Preconditions.checkNotNull(connectivityState, "newState");
        if (this.state != connectivityState && this.state != ConnectivityState.SHUTDOWN) {
            this.state = connectivityState;
            if (!this.listeners.isEmpty()) {
                ArrayList<Listener> arrayList = this.listeners;
                this.listeners = new ArrayList<>();
                Iterator<Listener> it = arrayList.iterator();
                while (it.hasNext()) {
                    it.next().runInExecutor();
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    public ConnectivityState getState() {
        ConnectivityState connectivityState = this.state;
        if (connectivityState != null) {
            return connectivityState;
        }
        throw new UnsupportedOperationException("Channel state API is not implemented");
    }

    private static final class Listener {
        final Runnable callback;
        final Executor executor;

        Listener(Runnable runnable, Executor executor2) {
            this.callback = runnable;
            this.executor = executor2;
        }

        /* access modifiers changed from: package-private */
        public void runInExecutor() {
            this.executor.execute(this.callback);
        }
    }
}
