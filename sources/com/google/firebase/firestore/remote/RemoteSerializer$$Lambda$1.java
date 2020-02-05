package com.google.firebase.firestore.remote;

import com.google.common.base.Function;
import com.google.firestore.v1.Value;

/* compiled from: com.google.firebase:firebase-firestore@@20.2.0 */
final /* synthetic */ class RemoteSerializer$$Lambda$1 implements Function {
    private final RemoteSerializer arg$1;

    private RemoteSerializer$$Lambda$1(RemoteSerializer remoteSerializer) {
        this.arg$1 = remoteSerializer;
    }

    public static Function lambdaFactory$(RemoteSerializer remoteSerializer) {
        return new RemoteSerializer$$Lambda$1(remoteSerializer);
    }

    public Object apply(Object obj) {
        return this.arg$1.decodeValue((Value) obj);
    }
}
