package com.google.android.gms.internal.clearcut;

import android.database.ContentObserver;
import android.os.Handler;

final class zzac extends ContentObserver {
    private final /* synthetic */ zzab zzdm;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    zzac(zzab zzab, Handler handler) {
        super((Handler) null);
        this.zzdm = zzab;
    }

    public final void onChange(boolean z) {
        this.zzdm.zzh();
        this.zzdm.zzj();
    }
}
