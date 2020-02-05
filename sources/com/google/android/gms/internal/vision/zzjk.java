package com.google.android.gms.internal.vision;

import com.google.common.base.Ascii;
import com.google.common.primitives.UnsignedBytes;
import java.io.IOException;

public final class zzjk {
    private final byte[] buffer;
    private final int zzacz;
    private final int zzada;
    private int zzadb;
    private int zzadc;
    private zzez zzadd;
    private int zzsf;
    private int zzsg = 64;
    private int zzsh = 67108864;
    private int zzsl;
    private int zzsn;
    private int zzso = Integer.MAX_VALUE;

    public static zzjk zzk(byte[] bArr, int i, int i2) {
        return new zzjk(bArr, 0, i2);
    }

    public final int zzdq() throws IOException {
        if (this.zzadc == this.zzadb) {
            this.zzsn = 0;
            return 0;
        }
        this.zzsn = zzdt();
        int i = this.zzsn;
        if (i != 0) {
            return i;
        }
        throw new zzjs("Protocol message contained an invalid tag (zero).");
    }

    public final void zzak(int i) throws zzjs {
        if (this.zzsn != i) {
            throw new zzjs("Protocol message end-group tag did not match expected tag.");
        }
    }

    public final boolean zzal(int i) throws IOException {
        int zzdq;
        int i2 = i & 7;
        if (i2 == 0) {
            zzdt();
            return true;
        } else if (i2 == 1) {
            zzdy();
            zzdy();
            zzdy();
            zzdy();
            zzdy();
            zzdy();
            zzdy();
            zzdy();
            return true;
        } else if (i2 == 2) {
            zzap(zzdt());
            return true;
        } else if (i2 == 3) {
            do {
                zzdq = zzdq();
                if (zzdq == 0 || !zzal(zzdq)) {
                    zzak(((i >>> 3) << 3) | 4);
                }
                zzdq = zzdq();
                break;
            } while (!zzal(zzdq));
            zzak(((i >>> 3) << 3) | 4);
            return true;
        } else if (i2 == 4) {
            return false;
        } else {
            if (i2 == 5) {
                zzdv();
                return true;
            }
            throw new zzjs("Protocol message tag had invalid wire type.");
        }
    }

    public final boolean zzcu() throws IOException {
        return zzdt() != 0;
    }

    public final String readString() throws IOException {
        int zzdt = zzdt();
        if (zzdt >= 0) {
            int i = this.zzadb;
            int i2 = this.zzadc;
            if (zzdt <= i - i2) {
                String str = new String(this.buffer, i2, zzdt, zzjr.UTF_8);
                this.zzadc += zzdt;
                return str;
            }
            throw zzjs.zzht();
        }
        throw zzjs.zzhu();
    }

    public final void zza(zzjt zzjt) throws IOException {
        int zzdt = zzdt();
        if (this.zzsf < this.zzsg) {
            int zzan = zzan(zzdt);
            this.zzsf++;
            zzjt.zza(this);
            zzak(0);
            this.zzsf--;
            zzao(zzan);
            return;
        }
        throw new zzjs("Protocol message had too many levels of nesting.  May be malicious.  Use CodedInputStream.setRecursionLimit() to increase the depth limit.");
    }

    public final int zzdt() throws IOException {
        int i;
        byte zzdy = zzdy();
        if (zzdy >= 0) {
            return zzdy;
        }
        byte b = zzdy & Ascii.DEL;
        byte zzdy2 = zzdy();
        if (zzdy2 >= 0) {
            i = zzdy2 << 7;
        } else {
            b |= (zzdy2 & Ascii.DEL) << 7;
            byte zzdy3 = zzdy();
            if (zzdy3 >= 0) {
                i = zzdy3 << Ascii.SO;
            } else {
                b |= (zzdy3 & Ascii.DEL) << Ascii.SO;
                byte zzdy4 = zzdy();
                if (zzdy4 >= 0) {
                    i = zzdy4 << Ascii.NAK;
                } else {
                    byte b2 = b | ((zzdy4 & Ascii.DEL) << Ascii.NAK);
                    byte zzdy5 = zzdy();
                    byte b3 = b2 | (zzdy5 << Ascii.FS);
                    if (zzdy5 >= 0) {
                        return b3;
                    }
                    for (int i2 = 0; i2 < 5; i2++) {
                        if (zzdy() >= 0) {
                            return b3;
                        }
                    }
                    throw zzjs.zzhv();
                }
            }
        }
        return b | i;
    }

    public final long zzdu() throws IOException {
        long j = 0;
        for (int i = 0; i < 64; i += 7) {
            byte zzdy = zzdy();
            j |= ((long) (zzdy & Ascii.DEL)) << i;
            if ((zzdy & UnsignedBytes.MAX_POWER_OF_TWO) == 0) {
                return j;
            }
        }
        throw zzjs.zzhv();
    }

    public final int zzdv() throws IOException {
        return (zzdy() & UnsignedBytes.MAX_VALUE) | ((zzdy() & UnsignedBytes.MAX_VALUE) << 8) | ((zzdy() & UnsignedBytes.MAX_VALUE) << Ascii.DLE) | ((zzdy() & UnsignedBytes.MAX_VALUE) << Ascii.CAN);
    }

    private zzjk(byte[] bArr, int i, int i2) {
        this.buffer = bArr;
        this.zzacz = i;
        int i3 = i2 + i;
        this.zzadb = i3;
        this.zzada = i3;
        this.zzadc = i;
    }

    public final <T extends zzfy<T, ?>> T zza(zzhq<T> zzhq) throws IOException {
        try {
            if (this.zzadd == null) {
                this.zzadd = zzez.zze(this.buffer, this.zzacz, this.zzada);
            }
            int zzds = this.zzadd.zzds();
            int i = this.zzadc - this.zzacz;
            if (zzds <= i) {
                this.zzadd.zzap(i - zzds);
                this.zzadd.zzam(this.zzsg - this.zzsf);
                T t = (zzfy) this.zzadd.zza(zzhq, zzfk.zzel());
                zzal(this.zzsn);
                return t;
            }
            throw new IOException(String.format("CodedInputStream read ahead of CodedInputByteBufferNano: %s > %s", new Object[]{Integer.valueOf(zzds), Integer.valueOf(i)}));
        } catch (zzgf e) {
            throw new zzjs("", e);
        }
    }

    public final int zzan(int i) throws zzjs {
        if (i >= 0) {
            int i2 = i + this.zzadc;
            int i3 = this.zzso;
            if (i2 <= i3) {
                this.zzso = i2;
                zzdx();
                return i3;
            }
            throw zzjs.zzht();
        }
        throw zzjs.zzhu();
    }

    private final void zzdx() {
        this.zzadb += this.zzsl;
        int i = this.zzadb;
        int i2 = this.zzso;
        if (i > i2) {
            this.zzsl = i - i2;
            this.zzadb = i - this.zzsl;
            return;
        }
        this.zzsl = 0;
    }

    public final void zzao(int i) {
        this.zzso = i;
        zzdx();
    }

    public final int zzhq() {
        int i = this.zzso;
        if (i == Integer.MAX_VALUE) {
            return -1;
        }
        return i - this.zzadc;
    }

    public final int getPosition() {
        return this.zzadc - this.zzacz;
    }

    public final byte[] zzv(int i, int i2) {
        if (i2 == 0) {
            return zzjw.zzaea;
        }
        byte[] bArr = new byte[i2];
        System.arraycopy(this.buffer, this.zzacz + i, bArr, 0, i2);
        return bArr;
    }

    public final void zzbt(int i) {
        zzw(i, this.zzsn);
    }

    /* access modifiers changed from: package-private */
    public final void zzw(int i, int i2) {
        int i3 = this.zzadc;
        int i4 = this.zzacz;
        if (i > i3 - i4) {
            StringBuilder sb = new StringBuilder(50);
            sb.append("Position ");
            sb.append(i);
            sb.append(" is beyond current ");
            sb.append(i3 - i4);
            throw new IllegalArgumentException(sb.toString());
        } else if (i >= 0) {
            this.zzadc = i4 + i;
            this.zzsn = i2;
        } else {
            StringBuilder sb2 = new StringBuilder(24);
            sb2.append("Bad position ");
            sb2.append(i);
            throw new IllegalArgumentException(sb2.toString());
        }
    }

    private final byte zzdy() throws IOException {
        int i = this.zzadc;
        if (i != this.zzadb) {
            byte[] bArr = this.buffer;
            this.zzadc = i + 1;
            return bArr[i];
        }
        throw zzjs.zzht();
    }

    private final void zzap(int i) throws IOException {
        if (i >= 0) {
            int i2 = this.zzadc;
            int i3 = i2 + i;
            int i4 = this.zzso;
            if (i3 > i4) {
                zzap(i4 - i2);
                throw zzjs.zzht();
            } else if (i <= this.zzadb - i2) {
                this.zzadc = i2 + i;
            } else {
                throw zzjs.zzht();
            }
        } else {
            throw zzjs.zzhu();
        }
    }
}
