package com.google.android.gms.internal.clearcut;

public abstract class zzbk {
    private static volatile boolean zzft = true;
    private int zzfq;
    private int zzfr;
    private boolean zzfs;

    private zzbk() {
        this.zzfq = 100;
        this.zzfr = Integer.MAX_VALUE;
        this.zzfs = false;
    }

    public static long zza(long j) {
        return (-(j & 1)) ^ (j >>> 1);
    }

    static zzbk zza(byte[] bArr, int i, int i2, boolean z) {
        zzbm zzbm = new zzbm(bArr, 0, i2, false);
        try {
            zzbm.zzl(i2);
            return zzbm;
        } catch (zzco e) {
            throw new IllegalArgumentException(e);
        }
    }

    public static int zzm(int i) {
        return (-(i & 1)) ^ (i >>> 1);
    }

    public abstract int zzaf();

    public abstract int zzl(int i) throws zzco;
}
