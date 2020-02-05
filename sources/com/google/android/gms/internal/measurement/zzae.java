package com.google.android.gms.internal.measurement;

import android.os.RemoteException;
import com.google.android.gms.internal.measurement.zzz;

/* compiled from: com.google.android.gms:play-services-measurement-sdk-api@@17.0.1 */
final class zzae extends zzz.zzb {
    private final /* synthetic */ zzz zzc;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    zzae(zzz zzz) {
        super(zzz);
        this.zzc = zzz;
    }

    /* access modifiers changed from: package-private */
    public final void zza() throws RemoteException {
        this.zzc.zzr.resetAnalyticsData(this.zza);
    }
}
