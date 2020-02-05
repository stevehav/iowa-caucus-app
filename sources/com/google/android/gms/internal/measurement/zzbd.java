package com.google.android.gms.internal.measurement;

import android.app.Activity;
import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.internal.measurement.zzz;

/* compiled from: com.google.android.gms:play-services-measurement-sdk-api@@17.0.1 */
final class zzbd extends zzz.zzb {
    private final /* synthetic */ Activity zzc;
    private final /* synthetic */ Bundle zzd;
    private final /* synthetic */ zzz.zzc zze;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    zzbd(zzz.zzc zzc2, Activity activity, Bundle bundle) {
        super(zzz.this);
        this.zze = zzc2;
        this.zzc = activity;
        this.zzd = bundle;
    }

    /* access modifiers changed from: package-private */
    public final void zza() throws RemoteException {
        zzz.this.zzr.onActivityCreated(ObjectWrapper.wrap(this.zzc), this.zzd, this.zzb);
    }
}
