package com.google.firebase.auth.internal;

import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.GetTokenResult;

/* compiled from: com.google.firebase:firebase-auth@@18.1.0 */
final class zzz implements Runnable {
    final /* synthetic */ zzaa zza;
    private final String zzb;

    zzz(zzaa zzaa, String str) {
        this.zza = zzaa;
        this.zzb = Preconditions.checkNotEmpty(str);
    }

    public final void run() {
        FirebaseAuth instance = FirebaseAuth.getInstance(FirebaseApp.getInstance(this.zzb));
        if (instance.getCurrentUser() != null) {
            Task<GetTokenResult> accessToken = instance.getAccessToken(true);
            zzaa.zzc.v("Token refreshing started", new Object[0]);
            accessToken.addOnFailureListener(new zzac(this));
        }
    }
}
