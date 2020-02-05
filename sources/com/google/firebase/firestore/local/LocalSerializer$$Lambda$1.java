package com.google.firebase.firestore.local;

import com.google.common.base.Function;
import com.google.firebase.firestore.remote.RemoteSerializer;
import com.google.firestore.v1.Value;

/* compiled from: com.google.firebase:firebase-firestore@@20.2.0 */
final /* synthetic */ class LocalSerializer$$Lambda$1 implements Function {
    private final RemoteSerializer arg$1;

    private LocalSerializer$$Lambda$1(RemoteSerializer remoteSerializer) {
        this.arg$1 = remoteSerializer;
    }

    public static Function lambdaFactory$(RemoteSerializer remoteSerializer) {
        return new LocalSerializer$$Lambda$1(remoteSerializer);
    }

    public Object apply(Object obj) {
        return this.arg$1.decodeValue((Value) obj);
    }
}
