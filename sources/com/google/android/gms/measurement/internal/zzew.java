package com.google.android.gms.measurement.internal;

import android.content.SharedPreferences;
import android.util.Pair;
import androidx.annotation.WorkerThread;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.VisibleForTesting;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.0.1 */
public final class zzew {
    @VisibleForTesting
    private final String zza;
    private final String zzb;
    private final String zzc;
    private final long zzd;
    private final /* synthetic */ zzes zze;

    private zzew(zzes zzes, String str, long j) {
        this.zze = zzes;
        Preconditions.checkNotEmpty(str);
        Preconditions.checkArgument(j > 0);
        this.zza = String.valueOf(str).concat(":start");
        this.zzb = String.valueOf(str).concat(":count");
        this.zzc = String.valueOf(str).concat(":value");
        this.zzd = j;
    }

    @WorkerThread
    private final void zzb() {
        this.zze.zzd();
        long currentTimeMillis = this.zze.zzm().currentTimeMillis();
        SharedPreferences.Editor edit = this.zze.zzy().edit();
        edit.remove(this.zzb);
        edit.remove(this.zzc);
        edit.putLong(this.zza, currentTimeMillis);
        edit.apply();
    }

    @WorkerThread
    public final void zza(String str, long j) {
        this.zze.zzd();
        if (zzc() == 0) {
            zzb();
        }
        if (str == null) {
            str = "";
        }
        long j2 = this.zze.zzy().getLong(this.zzb, 0);
        if (j2 <= 0) {
            SharedPreferences.Editor edit = this.zze.zzy().edit();
            edit.putString(this.zzc, str);
            edit.putLong(this.zzb, 1);
            edit.apply();
            return;
        }
        long j3 = j2 + 1;
        boolean z = (this.zze.zzp().zzh().nextLong() & Long.MAX_VALUE) < Long.MAX_VALUE / j3;
        SharedPreferences.Editor edit2 = this.zze.zzy().edit();
        if (z) {
            edit2.putString(this.zzc, str);
        }
        edit2.putLong(this.zzb, j3);
        edit2.apply();
    }

    @WorkerThread
    public final Pair<String, Long> zza() {
        long j;
        this.zze.zzd();
        this.zze.zzd();
        long zzc2 = zzc();
        if (zzc2 == 0) {
            zzb();
            j = 0;
        } else {
            j = Math.abs(zzc2 - this.zze.zzm().currentTimeMillis());
        }
        long j2 = this.zzd;
        if (j < j2) {
            return null;
        }
        if (j > (j2 << 1)) {
            zzb();
            return null;
        }
        String string = this.zze.zzy().getString(this.zzc, (String) null);
        long j3 = this.zze.zzy().getLong(this.zzb, 0);
        zzb();
        if (string == null || j3 <= 0) {
            return zzes.zza;
        }
        return new Pair<>(string, Long.valueOf(j3));
    }

    @WorkerThread
    private final long zzc() {
        return this.zze.zzy().getLong(this.zza, 0);
    }
}
