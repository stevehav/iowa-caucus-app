package com.google.android.gms.measurement.internal;

import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.0.1 */
final class zzia implements Runnable {
    private final /* synthetic */ boolean zza;
    private final /* synthetic */ zzjw zzb;
    private final /* synthetic */ zzn zzc;
    private final /* synthetic */ zzhy zzd;

    zzia(zzhy zzhy, boolean z, zzjw zzjw, zzn zzn) {
        this.zzd = zzhy;
        this.zza = z;
        this.zzb = zzjw;
        this.zzc = zzn;
    }

    public final void run() {
        zzeb zzd2 = this.zzd.zzb;
        if (zzd2 == null) {
            this.zzd.zzr().zzf().zza("Discarding data. Failed to set user attribute");
            return;
        }
        this.zzd.zza(zzd2, (AbstractSafeParcelable) this.zza ? null : this.zzb, this.zzc);
        this.zzd.zzaj();
    }
}
