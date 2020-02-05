package com.google.firebase.auth.internal;

import android.app.Activity;
import android.content.Context;
import androidx.annotation.VisibleForTesting;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

/* compiled from: com.google.firebase:firebase-auth@@18.1.0 */
public final class zzam {
    private static final zzam zzc = new zzam();
    private final zzas zza;
    private final zzad zzb;

    private zzam() {
        this(zzas.zza(), zzad.zza());
    }

    @VisibleForTesting
    private zzam(zzas zzas, zzad zzad) {
        this.zza = zzas;
        this.zzb = zzad;
    }

    public static zzam zza() {
        return zzc;
    }

    public final Task<AuthResult> zzb() {
        return this.zza.zzb();
    }

    public final void zza(FirebaseAuth firebaseAuth) {
        this.zza.zza(firebaseAuth);
    }

    public final void zza(Context context) {
        this.zza.zza(context);
    }

    public final boolean zza(Activity activity, TaskCompletionSource<AuthResult> taskCompletionSource, FirebaseAuth firebaseAuth) {
        return this.zzb.zza(activity, taskCompletionSource, firebaseAuth);
    }

    public final boolean zza(Activity activity, TaskCompletionSource<AuthResult> taskCompletionSource, FirebaseAuth firebaseAuth, FirebaseUser firebaseUser) {
        return this.zzb.zza(activity, taskCompletionSource, firebaseAuth, firebaseUser);
    }
}
