package com.google.firebase.firestore;

import com.google.firebase.firestore.core.ViewSnapshot;

/* compiled from: com.google.firebase:firebase-firestore@@20.2.0 */
final /* synthetic */ class DocumentReference$$Lambda$3 implements EventListener {
    private final DocumentReference arg$1;
    private final EventListener arg$2;

    private DocumentReference$$Lambda$3(DocumentReference documentReference, EventListener eventListener) {
        this.arg$1 = documentReference;
        this.arg$2 = eventListener;
    }

    public static EventListener lambdaFactory$(DocumentReference documentReference, EventListener eventListener) {
        return new DocumentReference$$Lambda$3(documentReference, eventListener);
    }

    public void onEvent(Object obj, FirebaseFirestoreException firebaseFirestoreException) {
        DocumentReference.lambda$addSnapshotListenerInternal$2(this.arg$1, this.arg$2, (ViewSnapshot) obj, firebaseFirestoreException);
    }
}
