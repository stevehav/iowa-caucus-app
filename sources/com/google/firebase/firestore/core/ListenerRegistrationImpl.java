package com.google.firebase.firestore.core;

import com.google.firebase.firestore.ListenerRegistration;

/* compiled from: com.google.firebase:firebase-firestore@@20.2.0 */
public class ListenerRegistrationImpl implements ListenerRegistration {
    private final AsyncEventListener<ViewSnapshot> asyncEventListener;
    private final FirestoreClient client;
    private final QueryListener queryListener;

    public ListenerRegistrationImpl(FirestoreClient firestoreClient, QueryListener queryListener2, AsyncEventListener<ViewSnapshot> asyncEventListener2) {
        this.client = firestoreClient;
        this.queryListener = queryListener2;
        this.asyncEventListener = asyncEventListener2;
    }

    public void remove() {
        this.asyncEventListener.mute();
        this.client.stopListening(this.queryListener);
    }
}
