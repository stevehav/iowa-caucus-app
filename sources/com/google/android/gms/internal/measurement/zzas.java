package com.google.android.gms.internal.measurement;

import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.internal.measurement.zzz;

/* compiled from: com.google.android.gms:play-services-measurement-sdk-api@@17.0.1 */
final class zzas extends zzz.zzb {
    private final /* synthetic */ String zzc;
    private final /* synthetic */ zzl zzd;
    private final /* synthetic */ zzz zze;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    zzas(zzz zzz, String str, zzl zzl) {
        super(zzz);
        this.zze = zzz;
        this.zzc = str;
        this.zzd = zzl;
    }

    /* access modifiers changed from: package-private */
    public final void zza() throws RemoteException {
        this.zze.zzr.getMaxUserProperties(this.zzc, this.zzd);
    }

    /* access modifiers changed from: protected */
    public final void zzb() {
        this.zzd.zza((Bundle) null);
    }
}
