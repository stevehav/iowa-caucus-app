package com.google.android.gms.measurement.internal;

import android.os.RemoteException;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.0.1 */
final class zzid implements Runnable {
    private final /* synthetic */ AtomicReference zza;
    private final /* synthetic */ zzn zzb;
    private final /* synthetic */ boolean zzc;
    private final /* synthetic */ zzhy zzd;

    zzid(zzhy zzhy, AtomicReference atomicReference, zzn zzn, boolean z) {
        this.zzd = zzhy;
        this.zza = atomicReference;
        this.zzb = zzn;
        this.zzc = z;
    }

    public final void run() {
        synchronized (this.zza) {
            try {
                zzeb zzd2 = this.zzd.zzb;
                if (zzd2 == null) {
                    this.zzd.zzr().zzf().zza("Failed to get user properties");
                    this.zza.notify();
                    return;
                }
                this.zza.set(zzd2.zza(this.zzb, this.zzc));
                this.zzd.zzaj();
                this.zza.notify();
            } catch (RemoteException e) {
                try {
                    this.zzd.zzr().zzf().zza("Failed to get user properties", e);
                    this.zza.notify();
                } catch (Throwable th) {
                    this.zza.notify();
                    throw th;
                }
            }
        }
    }
}
