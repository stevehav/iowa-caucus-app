package com.google.android.gms.internal.clearcut;

import com.google.android.gms.common.api.Status;

final class zzi extends zzg {
    private final /* synthetic */ zzh zzap;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    zzi(zzh zzh) {
        super((zzf) null);
        this.zzap = zzh;
    }

    public final void zza(Status status) {
        this.zzap.setResult(status);
    }
}
