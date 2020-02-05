package com.google.android.gms.measurement.internal;

import android.content.Context;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.internal.measurement.zzx;

@VisibleForTesting
/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.0.1 */
public final class zzgq {
    final Context zza;
    String zzb;
    String zzc;
    String zzd;
    Boolean zze;
    long zzf;
    zzx zzg;
    boolean zzh = true;

    @VisibleForTesting
    public zzgq(Context context, zzx zzx) {
        Preconditions.checkNotNull(context);
        Context applicationContext = context.getApplicationContext();
        Preconditions.checkNotNull(applicationContext);
        this.zza = applicationContext;
        if (zzx != null) {
            this.zzg = zzx;
            this.zzb = zzx.zzf;
            this.zzc = zzx.zze;
            this.zzd = zzx.zzd;
            this.zzh = zzx.zzc;
            this.zzf = zzx.zzb;
            if (zzx.zzg != null) {
                this.zze = Boolean.valueOf(zzx.zzg.getBoolean("dataCollectionDefaultEnabled", true));
            }
        }
    }
}
