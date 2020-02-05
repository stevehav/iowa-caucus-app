package com.google.firebase.firestore.local;

import com.google.firebase.firestore.model.mutation.MutationBatchResult;
import com.google.firebase.firestore.util.Supplier;

/* compiled from: com.google.firebase:firebase-firestore@@20.2.0 */
final /* synthetic */ class LocalStore$$Lambda$3 implements Supplier {
    private final LocalStore arg$1;
    private final MutationBatchResult arg$2;

    private LocalStore$$Lambda$3(LocalStore localStore, MutationBatchResult mutationBatchResult) {
        this.arg$1 = localStore;
        this.arg$2 = mutationBatchResult;
    }

    public static Supplier lambdaFactory$(LocalStore localStore, MutationBatchResult mutationBatchResult) {
        return new LocalStore$$Lambda$3(localStore, mutationBatchResult);
    }

    public Object get() {
        return LocalStore.lambda$acknowledgeBatch$2(this.arg$1, this.arg$2);
    }
}
