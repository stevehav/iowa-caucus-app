package com.google.firebase.auth.internal;

import android.app.Activity;
import android.content.Intent;
import android.content.IntentFilter;
import androidx.annotation.VisibleForTesting;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.SafeParcelableSerializer;
import com.google.android.gms.internal.firebase_auth.zzfr;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.zzg;

/* compiled from: com.google.firebase:firebase-auth@@18.1.0 */
public final class zzad {
    private static zzad zzb;
    private boolean zza = false;

    private zzad() {
    }

    public static zzad zza() {
        if (zzb == null) {
            zzb = new zzad();
        }
        return zzb;
    }

    public final boolean zza(Activity activity, TaskCompletionSource<AuthResult> taskCompletionSource, FirebaseAuth firebaseAuth) {
        return zza(activity, taskCompletionSource, firebaseAuth, (FirebaseUser) null);
    }

    public final boolean zza(Activity activity, TaskCompletionSource<AuthResult> taskCompletionSource, FirebaseAuth firebaseAuth, FirebaseUser firebaseUser) {
        if (this.zza) {
            return false;
        }
        LocalBroadcastManager.getInstance(activity).registerReceiver(new zzal(this, activity, taskCompletionSource, firebaseAuth, firebaseUser), new IntentFilter("com.google.firebase.auth.ACTION_RECEIVE_FIREBASE_AUTH_INTENT"));
        this.zza = true;
        return true;
    }

    /* access modifiers changed from: private */
    public final void zza(Intent intent, TaskCompletionSource<AuthResult> taskCompletionSource, FirebaseAuth firebaseAuth) {
        firebaseAuth.signInWithCredential(zza(intent)).addOnSuccessListener(new zzaf(this, taskCompletionSource)).addOnFailureListener(new zzag(this, taskCompletionSource));
    }

    /* access modifiers changed from: private */
    public final void zza(Intent intent, TaskCompletionSource<AuthResult> taskCompletionSource, FirebaseUser firebaseUser) {
        firebaseUser.linkWithCredential(zza(intent)).addOnSuccessListener(new zzah(this, taskCompletionSource)).addOnFailureListener(new zzai(this, taskCompletionSource));
    }

    /* access modifiers changed from: private */
    public final void zzb(Intent intent, TaskCompletionSource<AuthResult> taskCompletionSource, FirebaseUser firebaseUser) {
        firebaseUser.reauthenticateAndRetrieveData(zza(intent)).addOnSuccessListener(new zzaj(this, taskCompletionSource)).addOnFailureListener(new zzak(this, taskCompletionSource));
    }

    private static AuthCredential zza(Intent intent) {
        Preconditions.checkNotNull(intent);
        return zzg.zza(((zzfr) SafeParcelableSerializer.deserializeFromIntentExtra(intent, "com.google.firebase.auth.internal.VERIFY_ASSERTION_REQUEST", zzfr.CREATOR)).zzb(true));
    }

    @VisibleForTesting
    static void zzb() {
        zzb.zza = false;
    }
}
