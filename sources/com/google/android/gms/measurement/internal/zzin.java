package com.google.android.gms.measurement.internal;

import android.os.RemoteException;
import android.text.TextUtils;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.0.1 */
final class zzin implements Runnable {
    private final /* synthetic */ boolean zza;
    private final /* synthetic */ boolean zzb;
    private final /* synthetic */ zzq zzc;
    private final /* synthetic */ zzn zzd;
    private final /* synthetic */ zzq zze;
    private final /* synthetic */ zzhy zzf;

    zzin(zzhy zzhy, boolean z, boolean z2, zzq zzq, zzn zzn, zzq zzq2) {
        this.zzf = zzhy;
        this.zza = z;
        this.zzb = z2;
        this.zzc = zzq;
        this.zzd = zzn;
        this.zze = zzq2;
    }

    public final void run() {
        zzeb zzd2 = this.zzf.zzb;
        if (zzd2 == null) {
            this.zzf.zzr().zzf().zza("Discarding data. Failed to send conditional user property to service");
            return;
        }
        if (this.zza) {
            this.zzf.zza(zzd2, (AbstractSafeParcelable) this.zzb ? null : this.zzc, this.zzd);
        } else {
            try {
                if (TextUtils.isEmpty(this.zze.zza)) {
                    zzd2.zza(this.zzc, this.zzd);
                } else {
                    zzd2.zza(this.zzc);
                }
            } catch (RemoteException e) {
                this.zzf.zzr().zzf().zza("Failed to send conditional user property to the service", e);
            }
        }
        this.zzf.zzaj();
    }
}
