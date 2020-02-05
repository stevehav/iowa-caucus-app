package com.google.android.gms.internal.measurement;

import android.os.RemoteException;
import com.google.android.gms.internal.measurement.zzz;

/* compiled from: com.google.android.gms:play-services-measurement-sdk-api@@17.0.1 */
final class zzah extends zzz.zzb {
    private final /* synthetic */ long zzc;
    private final /* synthetic */ zzz zzd;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    zzah(zzz zzz, long j) {
        super(zzz);
        this.zzd = zzz;
        this.zzc = j;
    }

    /* access modifiers changed from: package-private */
    public final void zza() throws RemoteException {
        this.zzd.zzr.setMinimumSessionDuration(this.zzc);
    }
}
