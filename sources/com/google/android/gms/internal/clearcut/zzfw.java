package com.google.android.gms.internal.clearcut;

public final class zzfw implements Cloneable {
    private static final zzfx zzrl = new zzfx();
    private int mSize;
    private boolean zzrm;
    private int[] zzrn;
    private zzfx[] zzro;

    zzfw() {
        this(10);
    }

    private zzfw(int i) {
        this.zzrm = false;
        int i2 = i << 2;
        int i3 = 4;
        while (true) {
            if (i3 >= 32) {
                break;
            }
            int i4 = (1 << i3) - 12;
            if (i2 <= i4) {
                i2 = i4;
                break;
            }
            i3++;
        }
        int i5 = i2 / 4;
        this.zzrn = new int[i5];
        this.zzro = new zzfx[i5];
        this.mSize = 0;
    }

    public final /* synthetic */ Object clone() throws CloneNotSupportedException {
        int i = this.mSize;
        zzfw zzfw = new zzfw(i);
        System.arraycopy(this.zzrn, 0, zzfw.zzrn, 0, i);
        for (int i2 = 0; i2 < i; i2++) {
            zzfx[] zzfxArr = this.zzro;
            if (zzfxArr[i2] != null) {
                zzfw.zzro[i2] = (zzfx) zzfxArr[i2].clone();
            }
        }
        zzfw.mSize = i;
        return zzfw;
    }

    public final boolean equals(Object obj) {
        boolean z;
        boolean z2;
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzfw)) {
            return false;
        }
        zzfw zzfw = (zzfw) obj;
        int i = this.mSize;
        if (i != zzfw.mSize) {
            return false;
        }
        int[] iArr = this.zzrn;
        int[] iArr2 = zzfw.zzrn;
        int i2 = 0;
        while (true) {
            if (i2 >= i) {
                z = true;
                break;
            } else if (iArr[i2] != iArr2[i2]) {
                z = false;
                break;
            } else {
                i2++;
            }
        }
        if (z) {
            zzfx[] zzfxArr = this.zzro;
            zzfx[] zzfxArr2 = zzfw.zzro;
            int i3 = this.mSize;
            int i4 = 0;
            while (true) {
                if (i4 >= i3) {
                    z2 = true;
                    break;
                } else if (!zzfxArr[i4].equals(zzfxArr2[i4])) {
                    z2 = false;
                    break;
                } else {
                    i4++;
                }
            }
            if (z2) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        int i = 17;
        for (int i2 = 0; i2 < this.mSize; i2++) {
            i = (((i * 31) + this.zzrn[i2]) * 31) + this.zzro[i2].hashCode();
        }
        return i;
    }

    public final boolean isEmpty() {
        return this.mSize == 0;
    }

    /* access modifiers changed from: package-private */
    public final int size() {
        return this.mSize;
    }

    /* access modifiers changed from: package-private */
    public final zzfx zzaq(int i) {
        return this.zzro[i];
    }
}
