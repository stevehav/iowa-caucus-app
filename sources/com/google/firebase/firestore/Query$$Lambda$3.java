package com.google.firebase.firestore;

import com.google.firebase.firestore.core.ViewSnapshot;

/* compiled from: com.google.firebase:firebase-firestore@@20.2.0 */
final /* synthetic */ class Query$$Lambda$3 implements EventListener {
    private final Query arg$1;
    private final EventListener arg$2;

    private Query$$Lambda$3(Query query, EventListener eventListener) {
        this.arg$1 = query;
        this.arg$2 = eventListener;
    }

    public static EventListener lambdaFactory$(Query query, EventListener eventListener) {
        return new Query$$Lambda$3(query, eventListener);
    }

    public void onEvent(Object obj, FirebaseFirestoreException firebaseFirestoreException) {
        Query.lambda$addSnapshotListenerInternal$2(this.arg$1, this.arg$2, (ViewSnapshot) obj, firebaseFirestoreException);
    }
}
