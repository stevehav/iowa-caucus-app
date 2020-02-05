package com.google.android.gms.internal.vision;

import com.google.android.gms.internal.vision.zzfy;
import java.io.IOException;
import java.util.Arrays;

public final class zzip {
    private static final zzip zzaas = new zzip(0, new int[0], new Object[0], false);
    private int count;
    private int[] zzaat;
    private boolean zzrl;
    private int zzwk;
    private Object[] zzze;

    public static zzip zzhe() {
        return zzaas;
    }

    static zzip zzhf() {
        return new zzip();
    }

    static zzip zza(zzip zzip, zzip zzip2) {
        int i = zzip.count + zzip2.count;
        int[] copyOf = Arrays.copyOf(zzip.zzaat, i);
        System.arraycopy(zzip2.zzaat, 0, copyOf, zzip.count, zzip2.count);
        Object[] copyOf2 = Arrays.copyOf(zzip.zzze, i);
        System.arraycopy(zzip2.zzze, 0, copyOf2, zzip.count, zzip2.count);
        return new zzip(i, copyOf, copyOf2, true);
    }

    private zzip() {
        this(0, new int[8], new Object[8], true);
    }

    private zzip(int i, int[] iArr, Object[] objArr, boolean z) {
        this.zzwk = -1;
        this.count = i;
        this.zzaat = iArr;
        this.zzze = objArr;
        this.zzrl = z;
    }

    public final void zzci() {
        this.zzrl = false;
    }

    /* access modifiers changed from: package-private */
    public final void zza(zzjj zzjj) throws IOException {
        if (zzjj.zzed() == zzfy.zzg.zzxj) {
            for (int i = this.count - 1; i >= 0; i--) {
                zzjj.zza(this.zzaat[i] >>> 3, this.zzze[i]);
            }
            return;
        }
        for (int i2 = 0; i2 < this.count; i2++) {
            zzjj.zza(this.zzaat[i2] >>> 3, this.zzze[i2]);
        }
    }

    public final void zzb(zzjj zzjj) throws IOException {
        if (this.count != 0) {
            if (zzjj.zzed() == zzfy.zzg.zzxi) {
                for (int i = 0; i < this.count; i++) {
                    zzb(this.zzaat[i], this.zzze[i], zzjj);
                }
                return;
            }
            for (int i2 = this.count - 1; i2 >= 0; i2--) {
                zzb(this.zzaat[i2], this.zzze[i2], zzjj);
            }
        }
    }

    private static void zzb(int i, Object obj, zzjj zzjj) throws IOException {
        int i2 = i >>> 3;
        int i3 = i & 7;
        if (i3 == 0) {
            zzjj.zzi(i2, ((Long) obj).longValue());
        } else if (i3 == 1) {
            zzjj.zzc(i2, ((Long) obj).longValue());
        } else if (i3 == 2) {
            zzjj.zza(i2, (zzeo) obj);
        } else if (i3 != 3) {
            if (i3 == 5) {
                zzjj.zzh(i2, ((Integer) obj).intValue());
                return;
            }
            throw new RuntimeException(zzgf.zzfm());
        } else if (zzjj.zzed() == zzfy.zzg.zzxi) {
            zzjj.zzbe(i2);
            ((zzip) obj).zzb(zzjj);
            zzjj.zzbf(i2);
        } else {
            zzjj.zzbf(i2);
            ((zzip) obj).zzb(zzjj);
            zzjj.zzbe(i2);
        }
    }

    public final int zzhg() {
        int i = this.zzwk;
        if (i != -1) {
            return i;
        }
        int i2 = 0;
        for (int i3 = 0; i3 < this.count; i3++) {
            i2 += zzfe.zzd(this.zzaat[i3] >>> 3, (zzeo) this.zzze[i3]);
        }
        this.zzwk = i2;
        return i2;
    }

    public final int zzeq() {
        int i;
        int i2 = this.zzwk;
        if (i2 != -1) {
            return i2;
        }
        int i3 = 0;
        for (int i4 = 0; i4 < this.count; i4++) {
            int i5 = this.zzaat[i4];
            int i6 = i5 >>> 3;
            int i7 = i5 & 7;
            if (i7 == 0) {
                i = zzfe.zze(i6, ((Long) this.zzze[i4]).longValue());
            } else if (i7 == 1) {
                i = zzfe.zzg(i6, ((Long) this.zzze[i4]).longValue());
            } else if (i7 == 2) {
                i = zzfe.zzc(i6, (zzeo) this.zzze[i4]);
            } else if (i7 == 3) {
                i = (zzfe.zzav(i6) << 1) + ((zzip) this.zzze[i4]).zzeq();
            } else if (i7 == 5) {
                i = zzfe.zzl(i6, ((Integer) this.zzze[i4]).intValue());
            } else {
                throw new IllegalStateException(zzgf.zzfm());
            }
            i3 += i;
        }
        this.zzwk = i3;
        return i3;
    }

    public final boolean equals(Object obj) {
        boolean z;
        boolean z2;
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof zzip)) {
            return false;
        }
        zzip zzip = (zzip) obj;
        int i = this.count;
        if (i == zzip.count) {
            int[] iArr = this.zzaat;
            int[] iArr2 = zzip.zzaat;
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
                Object[] objArr = this.zzze;
                Object[] objArr2 = zzip.zzze;
                int i3 = this.count;
                int i4 = 0;
                while (true) {
                    if (i4 >= i3) {
                        z2 = true;
                        break;
                    } else if (!objArr[i4].equals(objArr2[i4])) {
                        z2 = false;
                        break;
                    } else {
                        i4++;
                    }
                }
                return z2;
            }
        }
    }

    public final int hashCode() {
        int i = this.count;
        int i2 = (i + 527) * 31;
        int[] iArr = this.zzaat;
        int i3 = 17;
        int i4 = 17;
        for (int i5 = 0; i5 < i; i5++) {
            i4 = (i4 * 31) + iArr[i5];
        }
        int i6 = (i2 + i4) * 31;
        Object[] objArr = this.zzze;
        int i7 = this.count;
        for (int i8 = 0; i8 < i7; i8++) {
            i3 = (i3 * 31) + objArr[i8].hashCode();
        }
        return i6 + i3;
    }

    /* access modifiers changed from: package-private */
    public final void zza(StringBuilder sb, int i) {
        for (int i2 = 0; i2 < this.count; i2++) {
            zzhi.zza(sb, i, String.valueOf(this.zzaat[i2] >>> 3), this.zzze[i2]);
        }
    }

    /* access modifiers changed from: package-private */
    public final void zzb(int i, Object obj) {
        if (this.zzrl) {
            int i2 = this.count;
            if (i2 == this.zzaat.length) {
                int i3 = this.count + (i2 < 4 ? 8 : i2 >> 1);
                this.zzaat = Arrays.copyOf(this.zzaat, i3);
                this.zzze = Arrays.copyOf(this.zzze, i3);
            }
            int[] iArr = this.zzaat;
            int i4 = this.count;
            iArr[i4] = i;
            this.zzze[i4] = obj;
            this.count = i4 + 1;
            return;
        }
        throw new UnsupportedOperationException();
    }
}
