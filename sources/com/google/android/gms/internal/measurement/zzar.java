package com.google.android.gms.internal.measurement;

import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.internal.measurement.zzz;

/* compiled from: com.google.android.gms:play-services-measurement-sdk-api@@17.0.1 */
final class zzar extends zzz.zzb {
    private final /* synthetic */ String zzc;
    private final /* synthetic */ String zzd;
    private final /* synthetic */ boolean zze;
    private final /* synthetic */ zzl zzf;
    private final /* synthetic */ zzz zzg;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    zzar(zzz zzz, String str, String str2, boolean z, zzl zzl) {
        super(zzz);
        this.zzg = zzz;
        this.zzc = str;
        this.zzd = str2;
        this.zze = z;
        this.zzf = zzl;
    }

    /* access modifiers changed from: package-private */
    public final void zza() throws RemoteException {
        this.zzg.zzr.getUserProperties(this.zzc, this.zzd, this.zze, this.zzf);
    }

    /* access modifiers changed from: protected */
    public final void zzb() {
        this.zzf.zza((Bundle) null);
    }
}
