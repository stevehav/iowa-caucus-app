package com.google.android.gms.internal.measurement;

import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.internal.measurement.zzz;

/* compiled from: com.google.android.gms:play-services-measurement-sdk-api@@17.0.1 */
final class zzax extends zzz.zzb {
    private final /* synthetic */ zzl zzc;
    private final /* synthetic */ int zzd;
    private final /* synthetic */ zzz zze;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    zzax(zzz zzz, zzl zzl, int i) {
        super(zzz);
        this.zze = zzz;
        this.zzc = zzl;
        this.zzd = i;
    }

    /* access modifiers changed from: package-private */
    public final void zza() throws RemoteException {
        this.zze.zzr.getTestFlag(this.zzc, this.zzd);
    }

    /* access modifiers changed from: protected */
    public final void zzb() {
        this.zzc.zza((Bundle) null);
    }
}
