package com.google.android.gms.internal.vision;

final class zzev {
    private final byte[] buffer;
    private final zzfe zzsd;

    private zzev(int i) {
        this.buffer = new byte[i];
        this.zzsd = zzfe.zzg(this.buffer);
    }

    public final zzeo zzdo() {
        this.zzsd.zzea();
        return new zzex(this.buffer);
    }

    public final zzfe zzdp() {
        return this.zzsd;
    }

    /* synthetic */ zzev(int i, zzep zzep) {
        this(i);
    }
}
