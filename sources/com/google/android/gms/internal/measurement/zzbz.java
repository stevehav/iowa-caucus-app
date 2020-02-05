package com.google.android.gms.internal.measurement;

import android.database.ContentObserver;
import android.os.Handler;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.0.1 */
final class zzbz extends ContentObserver {
    private final /* synthetic */ zzbx zza;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    zzbz(zzbx zzbx, Handler handler) {
        super((Handler) null);
        this.zza = zzbx;
    }

    public final void onChange(boolean z) {
        this.zza.zzb();
    }
}
