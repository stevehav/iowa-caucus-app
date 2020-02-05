package com.google.firebase.firestore.remote;

import com.google.android.gms.tasks.OnSuccessListener;
import io.grpc.CallCredentials;

/* compiled from: com.google.firebase:firebase-firestore@@20.2.0 */
final /* synthetic */ class FirestoreCallCredentials$$Lambda$1 implements OnSuccessListener {
    private final CallCredentials.MetadataApplier arg$1;

    private FirestoreCallCredentials$$Lambda$1(CallCredentials.MetadataApplier metadataApplier) {
        this.arg$1 = metadataApplier;
    }

    public static OnSuccessListener lambdaFactory$(CallCredentials.MetadataApplier metadataApplier) {
        return new FirestoreCallCredentials$$Lambda$1(metadataApplier);
    }

    public void onSuccess(Object obj) {
        FirestoreCallCredentials.lambda$applyRequestMetadata$0(this.arg$1, (String) obj);
    }
}
