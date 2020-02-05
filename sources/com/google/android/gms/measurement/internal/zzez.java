package com.google.android.gms.measurement.internal;

import android.content.SharedPreferences;
import androidx.annotation.WorkerThread;
import com.google.android.gms.common.internal.Preconditions;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.0.1 */
public final class zzez {
    private final String zza;
    private final String zzb = null;
    private boolean zzc;
    private String zzd;
    private final /* synthetic */ zzes zze;

    public zzez(zzes zzes, String str, String str2) {
        this.zze = zzes;
        Preconditions.checkNotEmpty(str);
        this.zza = str;
    }

    @WorkerThread
    public final String zza() {
        if (!this.zzc) {
            this.zzc = true;
            this.zzd = this.zze.zzy().getString(this.zza, (String) null);
        }
        return this.zzd;
    }

    @WorkerThread
    public final void zza(String str) {
        if (!zzjx.zzd(str, this.zzd)) {
            SharedPreferences.Editor edit = this.zze.zzy().edit();
            edit.putString(this.zza, str);
            edit.apply();
            this.zzd = str;
        }
    }
}
