package com.google.android.gms.internal.vision;

import com.google.common.primitives.UnsignedBytes;
import java.io.IOException;
import java.io.Serializable;
import java.nio.charset.Charset;
import java.util.Comparator;
import java.util.Iterator;

public abstract class zzeo implements Serializable, Iterable<Byte> {
    public static final zzeo zzrx = new zzex(zzga.zzxn);
    private static final zzet zzry = (zzeg.zzck() ? new zzey((zzep) null) : new zzer((zzep) null));
    private static final Comparator<zzeo> zzrz = new zzeq();
    private int zzlv = 0;

    zzeo() {
    }

    /* access modifiers changed from: private */
    public static int zza(byte b) {
        return b & UnsignedBytes.MAX_VALUE;
    }

    public abstract boolean equals(Object obj);

    public abstract int size();

    /* access modifiers changed from: protected */
    public abstract int zza(int i, int i2, int i3);

    /* access modifiers changed from: protected */
    public abstract String zza(Charset charset);

    /* access modifiers changed from: package-private */
    public abstract void zza(zzen zzen) throws IOException;

    /* access modifiers changed from: protected */
    public abstract void zza(byte[] bArr, int i, int i2, int i3);

    public abstract byte zzai(int i);

    public abstract zzeo zzc(int i, int i2);

    public abstract boolean zzdl();

    public static zzeo zzb(byte[] bArr, int i, int i2) {
        zzb(i, i + i2, bArr.length);
        return new zzex(zzry.zzd(bArr, i, i2));
    }

    static zzeo zze(byte[] bArr) {
        return new zzex(bArr);
    }

    static zzeo zzc(byte[] bArr, int i, int i2) {
        return new zzes(bArr, i, i2);
    }

    public static zzeo zzl(String str) {
        return new zzex(str.getBytes(zzga.UTF_8));
    }

    public final String zzdk() {
        return size() == 0 ? "" : zza(zzga.UTF_8);
    }

    public final int hashCode() {
        int i = this.zzlv;
        if (i == 0) {
            int size = size();
            i = zza(size, 0, size);
            if (i == 0) {
                i = 1;
            }
            this.zzlv = i;
        }
        return i;
    }

    static zzev zzaj(int i) {
        return new zzev(i, (zzep) null);
    }

    /* access modifiers changed from: protected */
    public final int zzdm() {
        return this.zzlv;
    }

    static int zzb(int i, int i2, int i3) {
        int i4 = i2 - i;
        if ((i | i2 | i4 | (i3 - i2)) >= 0) {
            return i4;
        }
        if (i < 0) {
            StringBuilder sb = new StringBuilder(32);
            sb.append("Beginning index: ");
            sb.append(i);
            sb.append(" < 0");
            throw new IndexOutOfBoundsException(sb.toString());
        } else if (i2 < i) {
            StringBuilder sb2 = new StringBuilder(66);
            sb2.append("Beginning index larger than ending index: ");
            sb2.append(i);
            sb2.append(", ");
            sb2.append(i2);
            throw new IndexOutOfBoundsException(sb2.toString());
        } else {
            StringBuilder sb3 = new StringBuilder(37);
            sb3.append("End index: ");
            sb3.append(i2);
            sb3.append(" >= ");
            sb3.append(i3);
            throw new IndexOutOfBoundsException(sb3.toString());
        }
    }

    public final String toString() {
        return String.format("<ByteString@%s size=%d>", new Object[]{Integer.toHexString(System.identityHashCode(this)), Integer.valueOf(size())});
    }

    public /* synthetic */ Iterator iterator() {
        return new zzep(this);
    }
}
