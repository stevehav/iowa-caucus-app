package com.google.android.gms.internal.measurement;

import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.internal.measurement.zzz;

/* compiled from: com.google.android.gms:play-services-measurement-sdk-api@@17.0.1 */
final class zzat extends zzz.zzb {
    private final /* synthetic */ Bundle zzc;
    private final /* synthetic */ zzl zzd;
    private final /* synthetic */ zzz zze;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    zzat(zzz zzz, Bundle bundle, zzl zzl) {
        super(zzz);
        this.zze = zzz;
        this.zzc = bundle;
        this.zzd = zzl;
    }

    /* access modifiers changed from: package-private */
    public final void zza() throws RemoteException {
        this.zze.zzr.performAction(this.zzc, this.zzd, this.zza);
    }

    /* access modifiers changed from: protected */
    public final void zzb() {
        this.zzd.zza((Bundle) null);
    }
}
