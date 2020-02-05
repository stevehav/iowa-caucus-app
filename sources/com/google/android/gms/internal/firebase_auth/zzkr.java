package com.google.android.gms.internal.firebase_auth;

import com.google.android.gms.internal.firebase_auth.zzhx;
import java.io.IOException;
import java.util.Arrays;

/* compiled from: com.google.firebase:firebase-auth@@18.1.0 */
public final class zzkr {
    private static final zzkr zza = new zzkr(0, new int[0], new Object[0], false);
    private int zzb;
    private int[] zzc;
    private Object[] zzd;
    private int zze;
    private boolean zzf;

    public static zzkr zza() {
        return zza;
    }

    static zzkr zzb() {
        return new zzkr();
    }

    static zzkr zza(zzkr zzkr, zzkr zzkr2) {
        int i = zzkr.zzb + zzkr2.zzb;
        int[] copyOf = Arrays.copyOf(zzkr.zzc, i);
        System.arraycopy(zzkr2.zzc, 0, copyOf, zzkr.zzb, zzkr2.zzb);
        Object[] copyOf2 = Arrays.copyOf(zzkr.zzd, i);
        System.arraycopy(zzkr2.zzd, 0, copyOf2, zzkr.zzb, zzkr2.zzb);
        return new zzkr(i, copyOf, copyOf2, true);
    }

    private zzkr() {
        this(0, new int[8], new Object[8], true);
    }

    private zzkr(int i, int[] iArr, Object[] objArr, boolean z) {
        this.zze = -1;
        this.zzb = i;
        this.zzc = iArr;
        this.zzd = objArr;
        this.zzf = z;
    }

    public final void zzc() {
        this.zzf = false;
    }

    /* access modifiers changed from: package-private */
    public final void zza(zzll zzll) throws IOException {
        if (zzll.zza() == zzhx.zze.zzk) {
            for (int i = this.zzb - 1; i >= 0; i--) {
                zzll.zza(this.zzc[i] >>> 3, this.zzd[i]);
            }
            return;
        }
        for (int i2 = 0; i2 < this.zzb; i2++) {
            zzll.zza(this.zzc[i2] >>> 3, this.zzd[i2]);
        }
    }

    public final void zzb(zzll zzll) throws IOException {
        if (this.zzb != 0) {
            if (zzll.zza() == zzhx.zze.zzj) {
                for (int i = 0; i < this.zzb; i++) {
                    zza(this.zzc[i], this.zzd[i], zzll);
                }
                return;
            }
            for (int i2 = this.zzb - 1; i2 >= 0; i2--) {
                zza(this.zzc[i2], this.zzd[i2], zzll);
            }
        }
    }

    private static void zza(int i, Object obj, zzll zzll) throws IOException {
        int i2 = i >>> 3;
        int i3 = i & 7;
        if (i3 == 0) {
            zzll.zza(i2, ((Long) obj).longValue());
        } else if (i3 == 1) {
            zzll.zzd(i2, ((Long) obj).longValue());
        } else if (i3 == 2) {
            zzll.zza(i2, (zzgm) obj);
        } else if (i3 != 3) {
            if (i3 == 5) {
                zzll.zzd(i2, ((Integer) obj).intValue());
                return;
            }
            throw new RuntimeException(zzig.zzf());
        } else if (zzll.zza() == zzhx.zze.zzj) {
            zzll.zza(i2);
            ((zzkr) obj).zzb(zzll);
            zzll.zzb(i2);
        } else {
            zzll.zzb(i2);
            ((zzkr) obj).zzb(zzll);
            zzll.zza(i2);
        }
    }

    public final int zzd() {
        int i = this.zze;
        if (i != -1) {
            return i;
        }
        int i2 = 0;
        for (int i3 = 0; i3 < this.zzb; i3++) {
            i2 += zzhh.zzd(this.zzc[i3] >>> 3, (zzgm) this.zzd[i3]);
        }
        this.zze = i2;
        return i2;
    }

    public final int zze() {
        int i;
        int i2 = this.zze;
        if (i2 != -1) {
            return i2;
        }
        int i3 = 0;
        for (int i4 = 0; i4 < this.zzb; i4++) {
            int i5 = this.zzc[i4];
            int i6 = i5 >>> 3;
            int i7 = i5 & 7;
            if (i7 == 0) {
                i = zzhh.zze(i6, ((Long) this.zzd[i4]).longValue());
            } else if (i7 == 1) {
                i = zzhh.zzg(i6, ((Long) this.zzd[i4]).longValue());
            } else if (i7 == 2) {
                i = zzhh.zzc(i6, (zzgm) this.zzd[i4]);
            } else if (i7 == 3) {
                i = (zzhh.zze(i6) << 1) + ((zzkr) this.zzd[i4]).zze();
            } else if (i7 == 5) {
                i = zzhh.zzi(i6, ((Integer) this.zzd[i4]).intValue());
            } else {
                throw new IllegalStateException(zzig.zzf());
            }
            i3 += i;
        }
        this.zze = i3;
        return i3;
    }

    public final boolean equals(Object obj) {
        boolean z;
        boolean z2;
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof zzkr)) {
            return false;
        }
        zzkr zzkr = (zzkr) obj;
        int i = this.zzb;
        if (i == zzkr.zzb) {
            int[] iArr = this.zzc;
            int[] iArr2 = zzkr.zzc;
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
                Object[] objArr = this.zzd;
                Object[] objArr2 = zzkr.zzd;
                int i3 = this.zzb;
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
        int i = this.zzb;
        int i2 = (i + 527) * 31;
        int[] iArr = this.zzc;
        int i3 = 17;
        int i4 = 17;
        for (int i5 = 0; i5 < i; i5++) {
            i4 = (i4 * 31) + iArr[i5];
        }
        int i6 = (i2 + i4) * 31;
        Object[] objArr = this.zzd;
        int i7 = this.zzb;
        for (int i8 = 0; i8 < i7; i8++) {
            i3 = (i3 * 31) + objArr[i8].hashCode();
        }
        return i6 + i3;
    }

    /* access modifiers changed from: package-private */
    public final void zza(StringBuilder sb, int i) {
        for (int i2 = 0; i2 < this.zzb; i2++) {
            zzjl.zza(sb, i, String.valueOf(this.zzc[i2] >>> 3), this.zzd[i2]);
        }
    }

    /* access modifiers changed from: package-private */
    public final void zza(int i, Object obj) {
        if (this.zzf) {
            int i2 = this.zzb;
            if (i2 == this.zzc.length) {
                int i3 = this.zzb + (i2 < 4 ? 8 : i2 >> 1);
                this.zzc = Arrays.copyOf(this.zzc, i3);
                this.zzd = Arrays.copyOf(this.zzd, i3);
            }
            int[] iArr = this.zzc;
            int i4 = this.zzb;
            iArr[i4] = i;
            this.zzd[i4] = obj;
            this.zzb = i4 + 1;
            return;
        }
        throw new UnsupportedOperationException();
    }
}
