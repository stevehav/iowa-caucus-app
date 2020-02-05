package com.google.android.gms.internal.measurement;

import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.internal.measurement.zzz;

/* compiled from: com.google.android.gms:play-services-measurement-sdk-api@@17.0.1 */
final class zzab extends zzz.zzb {
    private final /* synthetic */ String zzc;
    private final /* synthetic */ String zzd;
    private final /* synthetic */ Bundle zze;
    private final /* synthetic */ zzz zzf;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    zzab(zzz zzz, String str, String str2, Bundle bundle) {
        super(zzz);
        this.zzf = zzz;
        this.zzc = str;
        this.zzd = str2;
        this.zze = bundle;
    }

    /* access modifiers changed from: package-private */
    public final void zza() throws RemoteException {
        this.zzf.zzr.clearConditionalUserProperty(this.zzc, this.zzd, this.zze);
    }
}
