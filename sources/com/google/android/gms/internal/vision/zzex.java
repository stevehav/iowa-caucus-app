package com.google.android.gms.internal.vision;

import java.io.IOException;
import java.nio.charset.Charset;

class zzex extends zzew {
    protected final byte[] zzse;

    zzex(byte[] bArr) {
        if (bArr != null) {
            this.zzse = bArr;
            return;
        }
        throw new NullPointerException();
    }

    /* access modifiers changed from: protected */
    public int zzdn() {
        return 0;
    }

    public byte zzai(int i) {
        return this.zzse[i];
    }

    public int size() {
        return this.zzse.length;
    }

    public final zzeo zzc(int i, int i2) {
        int zzb = zzb(0, i2, size());
        if (zzb == 0) {
            return zzeo.zzrx;
        }
        return new zzes(this.zzse, zzdn(), zzb);
    }

    /* access modifiers changed from: protected */
    public void zza(byte[] bArr, int i, int i2, int i3) {
        System.arraycopy(this.zzse, 0, bArr, 0, i3);
    }

    /* access modifiers changed from: package-private */
    public final void zza(zzen zzen) throws IOException {
        zzen.zza(this.zzse, zzdn(), size());
    }

    /* access modifiers changed from: protected */
    public final String zza(Charset charset) {
        return new String(this.zzse, zzdn(), size(), charset);
    }

    public final boolean zzdl() {
        int zzdn = zzdn();
        return zziw.zzg(this.zzse, zzdn, size() + zzdn);
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzeo) || size() != ((zzeo) obj).size()) {
            return false;
        }
        if (size() == 0) {
            return true;
        }
        if (!(obj instanceof zzex)) {
            return obj.equals(this);
        }
        zzex zzex = (zzex) obj;
        int zzdm = zzdm();
        int zzdm2 = zzex.zzdm();
        if (zzdm == 0 || zzdm2 == 0 || zzdm == zzdm2) {
            return zza(zzex, 0, size());
        }
        return false;
    }

    /* access modifiers changed from: package-private */
    public final boolean zza(zzeo zzeo, int i, int i2) {
        if (i2 > zzeo.size()) {
            int size = size();
            StringBuilder sb = new StringBuilder(40);
            sb.append("Length too large: ");
            sb.append(i2);
            sb.append(size);
            throw new IllegalArgumentException(sb.toString());
        } else if (i2 > zzeo.size()) {
            int size2 = zzeo.size();
            StringBuilder sb2 = new StringBuilder(59);
            sb2.append("Ran off end of other: 0, ");
            sb2.append(i2);
            sb2.append(", ");
            sb2.append(size2);
            throw new IllegalArgumentException(sb2.toString());
        } else if (!(zzeo instanceof zzex)) {
            return zzeo.zzc(0, i2).equals(zzc(0, i2));
        } else {
            zzex zzex = (zzex) zzeo;
            byte[] bArr = this.zzse;
            byte[] bArr2 = zzex.zzse;
            int zzdn = zzdn() + i2;
            int zzdn2 = zzdn();
            int zzdn3 = zzex.zzdn();
            while (zzdn2 < zzdn) {
                if (bArr[zzdn2] != bArr2[zzdn3]) {
                    return false;
                }
                zzdn2++;
                zzdn3++;
            }
            return true;
        }
    }

    /* access modifiers changed from: protected */
    public final int zza(int i, int i2, int i3) {
        return zzga.zza(i, this.zzse, zzdn(), i3);
    }
}
