package com.google.firebase.auth.internal;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import androidx.fragment.app.FragmentActivity;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import com.google.android.gms.common.annotation.KeepName;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.util.DefaultClock;

@KeepName
/* compiled from: com.google.firebase:firebase-auth@@18.1.0 */
public class FederatedSignInActivity extends FragmentActivity {
    private static long zza;
    private static final zzam zzc = zzam.zza();
    private static Handler zzd;
    /* access modifiers changed from: private */
    public static Runnable zze;
    private boolean zzb = false;

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        String action = getIntent().getAction();
        if ("com.google.firebase.auth.internal.SIGN_IN".equals(action) || "com.google.firebase.auth.internal.LINK".equals(action) || "com.google.firebase.auth.internal.REAUTHENTICATE".equals(action)) {
            long currentTimeMillis = DefaultClock.getInstance().currentTimeMillis();
            if (currentTimeMillis - zza < 30000) {
                Log.e("IdpSignInActivity", "Could not start operation - already in progress");
                return;
            }
            zza = currentTimeMillis;
            if (bundle != null) {
                this.zzb = bundle.getBoolean("com.google.firebase.auth.internal.KEY_STARTED_SIGN_IN");
                return;
            }
            return;
        }
        String valueOf = String.valueOf(action);
        Log.e("IdpSignInActivity", valueOf.length() != 0 ? "Could not do operation - unknown action: ".concat(valueOf) : new String("Could not do operation - unknown action: "));
        zza();
    }

    /* access modifiers changed from: protected */
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putBoolean("com.google.firebase.auth.internal.KEY_STARTED_SIGN_IN", this.zzb);
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x009f A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x00a0  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onResume() {
        /*
            r10 = this;
            super.onResume()
            android.content.Intent r0 = r10.getIntent()
            java.lang.String r1 = r0.getAction()
            java.lang.String r2 = "com.google.firebase.auth.internal.WEB_SIGN_IN_FAILED"
            boolean r1 = r2.equals(r1)
            java.lang.String r2 = "IdpSignInActivity"
            r3 = 0
            r4 = 1
            java.lang.String r5 = "com.google.firebase.auth.internal.OPERATION"
            if (r1 == 0) goto L_0x0031
            java.lang.String r1 = "Web sign-in failed, finishing"
            android.util.Log.e(r2, r1)
            boolean r1 = com.google.firebase.auth.internal.zzay.zza(r0)
            if (r1 == 0) goto L_0x002c
            com.google.android.gms.common.api.Status r0 = com.google.firebase.auth.internal.zzay.zzb(r0)
            r10.zza((com.google.android.gms.common.api.Status) r0)
            goto L_0x002f
        L_0x002c:
            r10.zza()
        L_0x002f:
            r3 = 1
            goto L_0x009d
        L_0x0031:
            boolean r1 = r0.hasExtra(r5)
            if (r1 == 0) goto L_0x009d
            java.lang.String r1 = "com.google.firebase.auth.internal.VERIFY_ASSERTION_REQUEST"
            boolean r6 = r0.hasExtra(r1)
            if (r6 == 0) goto L_0x009d
            java.lang.String r6 = r0.getStringExtra(r5)
            java.lang.String r7 = "com.google.firebase.auth.internal.SIGN_IN"
            boolean r7 = r7.equals(r6)
            if (r7 != 0) goto L_0x005b
            java.lang.String r7 = "com.google.firebase.auth.internal.LINK"
            boolean r7 = r7.equals(r6)
            if (r7 != 0) goto L_0x005b
            java.lang.String r7 = "com.google.firebase.auth.internal.REAUTHENTICATE"
            boolean r7 = r7.equals(r6)
            if (r7 == 0) goto L_0x009d
        L_0x005b:
            android.os.Parcelable$Creator<com.google.android.gms.internal.firebase_auth.zzfr> r7 = com.google.android.gms.internal.firebase_auth.zzfr.CREATOR
            com.google.android.gms.common.internal.safeparcel.SafeParcelable r7 = com.google.android.gms.common.internal.safeparcel.SafeParcelableSerializer.deserializeFromIntentExtra(r0, r1, r7)
            com.google.android.gms.internal.firebase_auth.zzfr r7 = (com.google.android.gms.internal.firebase_auth.zzfr) r7
            java.lang.String r8 = "com.google.firebase.auth.internal.EXTRA_TENANT_ID"
            java.lang.String r0 = r0.getStringExtra(r8)
            r7.zzb((java.lang.String) r0)
            r8 = 0
            zza = r8
            r10.zzb = r3
            android.content.Intent r3 = new android.content.Intent
            r3.<init>()
            com.google.android.gms.common.internal.safeparcel.SafeParcelableSerializer.serializeToIntentExtra(r7, r3, r1)
            r3.putExtra(r5, r6)
            java.lang.String r1 = "com.google.firebase.auth.ACTION_RECEIVE_FIREBASE_AUTH_INTENT"
            r3.setAction(r1)
            androidx.localbroadcastmanager.content.LocalBroadcastManager r1 = androidx.localbroadcastmanager.content.LocalBroadcastManager.getInstance(r10)
            boolean r1 = r1.sendBroadcast(r3)
            if (r1 != 0) goto L_0x0094
            android.content.Context r1 = r10.getApplicationContext()
            com.google.firebase.auth.internal.zzas.zza(r1, r7, r6, r0)
            goto L_0x0099
        L_0x0094:
            com.google.firebase.auth.internal.zzam r0 = zzc
            r0.zza((android.content.Context) r10)
        L_0x0099:
            r10.finish()
            goto L_0x002f
        L_0x009d:
            if (r3 == 0) goto L_0x00a0
            return
        L_0x00a0:
            boolean r0 = r10.zzb
            if (r0 != 0) goto L_0x00df
            android.content.Intent r0 = new android.content.Intent
            java.lang.String r1 = "com.google.firebase.auth.api.gms.ui.START_WEB_SIGN_IN"
            r0.<init>(r1)
            java.lang.String r1 = "com.google.android.gms"
            r0.setPackage(r1)
            android.content.Intent r1 = r10.getIntent()
            android.os.Bundle r1 = r1.getExtras()
            r0.putExtras(r1)
            android.content.Intent r1 = r10.getIntent()
            java.lang.String r1 = r1.getAction()
            r0.putExtra(r5, r1)
            r1 = 40963(0xa003, float:5.7401E-41)
            r10.startActivityForResult(r0, r1)     // Catch:{ ActivityNotFoundException -> 0x00cd }
            goto L_0x00dc
        L_0x00cd:
            java.lang.String r0 = "Could not launch web sign-in Intent. Google Play service is unavailable"
            android.util.Log.w(r2, r0)
            com.google.android.gms.common.api.Status r1 = new com.google.android.gms.common.api.Status
            r2 = 17499(0x445b, float:2.4521E-41)
            r1.<init>(r2, r0)
            r10.zza((com.google.android.gms.common.api.Status) r1)
        L_0x00dc:
            r10.zzb = r4
            return
        L_0x00df:
            com.google.firebase.auth.internal.zzan r0 = new com.google.firebase.auth.internal.zzan
            r0.<init>(r10)
            zze = r0
            android.os.Handler r0 = zzd
            if (r0 != 0) goto L_0x00f1
            com.google.android.gms.internal.firebase_auth.zzj r0 = new com.google.android.gms.internal.firebase_auth.zzj
            r0.<init>()
            zzd = r0
        L_0x00f1:
            android.os.Handler r0 = zzd
            java.lang.Runnable r1 = zze
            r2 = 800(0x320, double:3.953E-321)
            r0.postDelayed(r1, r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.auth.internal.FederatedSignInActivity.onResume():void");
    }

    public void onNewIntent(Intent intent) {
        Runnable runnable;
        super.onNewIntent(intent);
        Handler handler = zzd;
        if (!(handler == null || (runnable = zze) == null)) {
            handler.removeCallbacks(runnable);
            zze = null;
        }
        setIntent(intent);
    }

    /* access modifiers changed from: private */
    public final void zza() {
        zza = 0;
        this.zzb = false;
        Intent intent = new Intent();
        intent.putExtra("com.google.firebase.auth.internal.EXTRA_CANCELED", true);
        intent.setAction("com.google.firebase.auth.ACTION_RECEIVE_FIREBASE_AUTH_INTENT");
        if (!LocalBroadcastManager.getInstance(this).sendBroadcast(intent)) {
            zzas.zza((Context) this, zzy.zza("WEB_CONTEXT_CANCELED"));
        } else {
            zzc.zza((Context) this);
        }
        finish();
    }

    private final void zza(Status status) {
        zza = 0;
        this.zzb = false;
        Intent intent = new Intent();
        zzay.zza(intent, status);
        intent.setAction("com.google.firebase.auth.ACTION_RECEIVE_FIREBASE_AUTH_INTENT");
        if (!LocalBroadcastManager.getInstance(this).sendBroadcast(intent)) {
            zzas.zza(getApplicationContext(), status);
        } else {
            zzc.zza((Context) this);
        }
        finish();
    }
}
