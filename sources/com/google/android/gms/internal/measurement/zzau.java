package com.google.android.gms.internal.measurement;

import android.os.RemoteException;
import android.util.Log;
import android.util.Pair;
import com.google.android.gms.internal.measurement.zzz;
import com.google.android.gms.measurement.internal.zzgr;

/* compiled from: com.google.android.gms:play-services-measurement-sdk-api@@17.0.1 */
final class zzau extends zzz.zzb {
    private final /* synthetic */ zzgr zzc;
    private final /* synthetic */ zzz zzd;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    zzau(zzz zzz, zzgr zzgr) {
        super(zzz);
        this.zzd = zzz;
        this.zzc = zzgr;
    }

    /* access modifiers changed from: package-private */
    public final void zza() throws RemoteException {
        for (int i = 0; i < this.zzd.zzf.size(); i++) {
            if (this.zzc.equals(((Pair) this.zzd.zzf.get(i)).first)) {
                Log.w(this.zzd.zzc, "OnEventListener already registered.");
                return;
            }
        }
        zzz.zzd zzd2 = new zzz.zzd(this.zzc);
        this.zzd.zzf.add(new Pair(this.zzc, zzd2));
        this.zzd.zzr.registerOnMeasurementEventListener(zzd2);
    }
}
