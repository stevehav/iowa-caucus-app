package com.google.android.gms.vision.clearcut;

import com.google.android.gms.internal.vision.zzdu;

final class zza implements Runnable {
    private final /* synthetic */ int zzbr;
    private final /* synthetic */ zzdu zzbs;
    private final /* synthetic */ DynamiteClearcutLogger zzbt;

    zza(DynamiteClearcutLogger dynamiteClearcutLogger, int i, zzdu zzdu) {
        this.zzbt = dynamiteClearcutLogger;
        this.zzbr = i;
        this.zzbs = zzdu;
    }

    public final void run() {
        this.zzbt.zzbq.zzb(this.zzbr, this.zzbs);
    }
}
