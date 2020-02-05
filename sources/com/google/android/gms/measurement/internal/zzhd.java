package com.google.android.gms.measurement.internal;

import android.os.Bundle;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.0.1 */
final class zzhd implements Runnable {
    private final /* synthetic */ Bundle zza;
    private final /* synthetic */ zzgt zzb;

    zzhd(zzgt zzgt, Bundle bundle) {
        this.zzb = zzgt;
        this.zza = bundle;
    }

    public final void run() {
        this.zzb.zzd(this.zza);
    }
}
