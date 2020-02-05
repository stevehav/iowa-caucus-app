package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.internal.measurement.zzp;
import java.util.ArrayList;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.0.1 */
final class zzip implements Runnable {
    private final /* synthetic */ String zza;
    private final /* synthetic */ String zzb;
    private final /* synthetic */ zzn zzc;
    private final /* synthetic */ zzp zzd;
    private final /* synthetic */ zzhy zze;

    zzip(zzhy zzhy, String str, String str2, zzn zzn, zzp zzp) {
        this.zze = zzhy;
        this.zza = str;
        this.zzb = str2;
        this.zzc = zzn;
        this.zzd = zzp;
    }

    public final void run() {
        ArrayList<Bundle> arrayList = new ArrayList<>();
        try {
            zzeb zzd2 = this.zze.zzb;
            if (zzd2 == null) {
                this.zze.zzr().zzf().zza("Failed to get conditional properties", this.zza, this.zzb);
                return;
            }
            arrayList = zzjx.zzb(zzd2.zza(this.zza, this.zzb, this.zzc));
            this.zze.zzaj();
            this.zze.zzp().zza(this.zzd, arrayList);
        } catch (RemoteException e) {
            this.zze.zzr().zzf().zza("Failed to get conditional properties", this.zza, this.zzb, e);
        } finally {
            this.zze.zzp().zza(this.zzd, arrayList);
        }
    }
}
