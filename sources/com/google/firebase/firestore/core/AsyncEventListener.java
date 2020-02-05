package com.google.firebase.firestore.core;

import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestoreException;
import java.util.concurrent.Executor;
import javax.annotation.Nullable;

/* compiled from: com.google.firebase:firebase-firestore@@20.2.0 */
public class AsyncEventListener<T> implements EventListener<T> {
    private final EventListener<T> eventListener;
    private final Executor executor;
    private volatile boolean muted = false;

    public AsyncEventListener(Executor executor2, EventListener<T> eventListener2) {
        this.executor = executor2;
        this.eventListener = eventListener2;
    }

    public void onEvent(@Nullable T t, @Nullable FirebaseFirestoreException firebaseFirestoreException) {
        this.executor.execute(AsyncEventListener$$Lambda$1.lambdaFactory$(this, t, firebaseFirestoreException));
    }

    static /* synthetic */ void lambda$onEvent$0(AsyncEventListener asyncEventListener, Object obj, FirebaseFirestoreException firebaseFirestoreException) {
        if (!asyncEventListener.muted) {
            asyncEventListener.eventListener.onEvent(obj, firebaseFirestoreException);
        }
    }

    public void mute() {
        this.muted = true;
    }
}
