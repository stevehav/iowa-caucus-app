package com.google.firebase.firestore;

import com.google.firebase.components.ComponentContainer;
import com.google.firebase.components.ComponentFactory;

/* compiled from: com.google.firebase:firebase-firestore@@20.2.0 */
final /* synthetic */ class FirestoreRegistrar$$Lambda$1 implements ComponentFactory {
    private static final FirestoreRegistrar$$Lambda$1 instance = new FirestoreRegistrar$$Lambda$1();

    private FirestoreRegistrar$$Lambda$1() {
    }

    public static ComponentFactory lambdaFactory$() {
        return instance;
    }

    public Object create(ComponentContainer componentContainer) {
        return FirestoreRegistrar.lambda$getComponents$0(componentContainer);
    }
}
