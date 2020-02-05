package com.google.android.gms.internal.vision;

import java.io.IOException;

public abstract class zzez {
    int zzsf;
    int zzsg;
    private int zzsh;
    zzfc zzsi;
    private boolean zzsj;

    public static int zzaq(int i) {
        return (-(i & 1)) ^ (i >>> 1);
    }

    public static long zzd(long j) {
        return (-(j & 1)) ^ (j >>> 1);
    }

    public static zzez zzf(byte[] bArr) {
        return zza(bArr, 0, bArr.length, false);
    }

    public abstract double readDouble() throws IOException;

    public abstract float readFloat() throws IOException;

    public abstract String readString() throws IOException;

    public abstract <T extends zzhf> T zza(zzhq<T> zzhq, zzfk zzfk) throws IOException;

    public abstract void zzak(int i) throws zzgf;

    public abstract boolean zzal(int i) throws IOException;

    public abstract int zzan(int i) throws zzgf;

    public abstract void zzao(int i);

    public abstract void zzap(int i) throws IOException;

    public abstract boolean zzcm() throws IOException;

    public abstract long zzcp() throws IOException;

    public abstract long zzcq() throws IOException;

    public abstract int zzcr() throws IOException;

    public abstract long zzcs() throws IOException;

    public abstract int zzct() throws IOException;

    public abstract boolean zzcu() throws IOException;

    public abstract String zzcv() throws IOException;

    public abstract zzeo zzcw() throws IOException;

    public abstract int zzcx() throws IOException;

    public abstract int zzcy() throws IOException;

    public abstract int zzcz() throws IOException;

    public abstract long zzda() throws IOException;

    public abstract int zzdb() throws IOException;

    public abstract long zzdc() throws IOException;

    public abstract int zzdq() throws IOException;

    /* access modifiers changed from: package-private */
    public abstract long zzdr() throws IOException;

    public abstract int zzds();

    public static zzez zze(byte[] bArr, int i, int i2) {
        return zza(bArr, i, i2, false);
    }

    private static zzez zza(byte[] bArr, int i, int i2, boolean z) {
        zzfb zzfb = new zzfb(bArr, i, i2, false);
        try {
            zzfb.zzan(i2);
            return zzfb;
        } catch (zzgf e) {
            throw new IllegalArgumentException(e);
        }
    }

    private zzez() {
        this.zzsg = 100;
        this.zzsh = Integer.MAX_VALUE;
        this.zzsj = false;
    }

    public final int zzam(int i) {
        if (i >= 0) {
            int i2 = this.zzsg;
            this.zzsg = i;
            return i2;
        }
        StringBuilder sb = new StringBuilder(47);
        sb.append("Recursion limit cannot be negative: ");
        sb.append(i);
        throw new IllegalArgumentException(sb.toString());
    }
}
