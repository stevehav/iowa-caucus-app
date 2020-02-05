package io.grpc.stub;

import com.facebook.react.uimanager.events.TouchesHelper;
import com.google.common.base.Preconditions;
import com.google.firebase.analytics.FirebaseAnalytics;
import io.grpc.ExperimentalApi;
import java.util.Iterator;

@ExperimentalApi("https://github.com/grpc/grpc-java/issues/4694")
public final class StreamObservers {
    public static <V> void copyWithFlowControl(final Iterator<V> it, final CallStreamObserver<V> callStreamObserver) {
        Preconditions.checkNotNull(it, FirebaseAnalytics.Param.SOURCE);
        Preconditions.checkNotNull(callStreamObserver, TouchesHelper.TARGET_KEY);
        callStreamObserver.setOnReadyHandler(new Runnable() {
            private boolean completed;

            public void run() {
                if (!this.completed) {
                    while (CallStreamObserver.this.isReady() && it.hasNext()) {
                        CallStreamObserver.this.onNext(it.next());
                    }
                    if (!it.hasNext()) {
                        this.completed = true;
                        CallStreamObserver.this.onCompleted();
                    }
                }
            }
        });
    }

    public static <V> void copyWithFlowControl(Iterable<V> iterable, CallStreamObserver<V> callStreamObserver) {
        Preconditions.checkNotNull(iterable, FirebaseAnalytics.Param.SOURCE);
        copyWithFlowControl(iterable.iterator(), callStreamObserver);
    }
}
