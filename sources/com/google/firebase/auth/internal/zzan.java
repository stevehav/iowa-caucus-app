package com.google.firebase.auth.internal;

/* compiled from: com.google.firebase:firebase-auth@@18.1.0 */
final class zzan implements Runnable {
    private final /* synthetic */ FederatedSignInActivity zza;

    zzan(FederatedSignInActivity federatedSignInActivity) {
        this.zza = federatedSignInActivity;
    }

    public final void run() {
        this.zza.zza();
        Runnable unused = FederatedSignInActivity.zze = null;
    }
}
