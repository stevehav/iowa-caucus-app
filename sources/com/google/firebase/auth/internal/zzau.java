package com.google.firebase.auth.internal;

import android.app.Application;
import android.content.Context;
import com.google.android.gms.common.api.internal.BackgroundDetector;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.internal.firebase_auth.zzey;
import com.google.firebase.FirebaseApp;

/* compiled from: com.google.firebase:firebase-auth@@18.1.0 */
public final class zzau {
    private volatile int zza;
    /* access modifiers changed from: private */
    public final zzaa zzb;
    /* access modifiers changed from: private */
    public volatile boolean zzc;

    public zzau(FirebaseApp firebaseApp) {
        this(firebaseApp.getApplicationContext(), new zzaa(firebaseApp));
    }

    @VisibleForTesting
    private zzau(Context context, zzaa zzaa) {
        this.zzc = false;
        this.zza = 0;
        this.zzb = zzaa;
        BackgroundDetector.initialize((Application) context.getApplicationContext());
        BackgroundDetector.getInstance().addListener(new zzax(this));
    }

    public final void zza(int i) {
        if (i > 0 && this.zza == 0) {
            this.zza = i;
            if (zzb()) {
                this.zzb.zza();
            }
        } else if (i == 0 && this.zza != 0) {
            this.zzb.zzc();
        }
        this.zza = i;
    }

    public final void zza(zzey zzey) {
        if (zzey != null) {
            long zze = zzey.zze();
            if (zze <= 0) {
                zze = 3600;
            }
            zzaa zzaa = this.zzb;
            zzaa.zza = zzey.zzg() + (zze * 1000);
            zzaa.zzb = -1;
            if (zzb()) {
                this.zzb.zza();
            }
        }
    }

    public final void zza() {
        this.zzb.zzc();
    }

    /* access modifiers changed from: private */
    public final boolean zzb() {
        return this.zza > 0 && !this.zzc;
    }
}
