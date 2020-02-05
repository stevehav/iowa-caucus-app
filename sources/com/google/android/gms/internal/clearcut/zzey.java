package com.google.android.gms.internal.clearcut;

import com.google.android.gms.internal.clearcut.zzcg;
import java.io.IOException;
import java.util.Arrays;

public final class zzey {
    private static final zzey zzoz = new zzey(0, new int[0], new Object[0], false);
    private int count;
    private boolean zzfa;
    private int zzjq;
    private Object[] zzmj;
    private int[] zzpa;

    private zzey() {
        this(0, new int[8], new Object[8], true);
    }

    private zzey(int i, int[] iArr, Object[] objArr, boolean z) {
        this.zzjq = -1;
        this.count = i;
        this.zzpa = iArr;
        this.zzmj = objArr;
        this.zzfa = z;
    }

    static zzey zza(zzey zzey, zzey zzey2) {
        int i = zzey.count + zzey2.count;
        int[] copyOf = Arrays.copyOf(zzey.zzpa, i);
        System.arraycopy(zzey2.zzpa, 0, copyOf, zzey.count, zzey2.count);
        Object[] copyOf2 = Arrays.copyOf(zzey.zzmj, i);
        System.arraycopy(zzey2.zzmj, 0, copyOf2, zzey.count, zzey2.count);
        return new zzey(i, copyOf, copyOf2, true);
    }

    private static void zzb(int i, Object obj, zzfr zzfr) throws IOException {
        int i2 = i >>> 3;
        int i3 = i & 7;
        if (i3 == 0) {
            zzfr.zzi(i2, ((Long) obj).longValue());
        } else if (i3 == 1) {
            zzfr.zzc(i2, ((Long) obj).longValue());
        } else if (i3 == 2) {
            zzfr.zza(i2, (zzbb) obj);
        } else if (i3 != 3) {
            if (i3 == 5) {
                zzfr.zzf(i2, ((Integer) obj).intValue());
                return;
            }
            throw new RuntimeException(zzco.zzbn());
        } else if (zzfr.zzaj() == zzcg.zzg.zzko) {
            zzfr.zzaa(i2);
            ((zzey) obj).zzb(zzfr);
            zzfr.zzab(i2);
        } else {
            zzfr.zzab(i2);
            ((zzey) obj).zzb(zzfr);
            zzfr.zzaa(i2);
        }
    }

    public static zzey zzea() {
        return zzoz;
    }

    static zzey zzeb() {
        return new zzey();
    }

    public final boolean equals(Object obj) {
        boolean z;
        boolean z2;
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof zzey)) {
            return false;
        }
        zzey zzey = (zzey) obj;
        int i = this.count;
        if (i == zzey.count) {
            int[] iArr = this.zzpa;
            int[] iArr2 = zzey.zzpa;
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
                Object[] objArr = this.zzmj;
                Object[] objArr2 = zzey.zzmj;
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
        int[] iArr = this.zzpa;
        int i3 = 17;
        int i4 = 17;
        for (int i5 = 0; i5 < i; i5++) {
            i4 = (i4 * 31) + iArr[i5];
        }
        int i6 = (i2 + i4) * 31;
        Object[] objArr = this.zzmj;
        int i7 = this.count;
        for (int i8 = 0; i8 < i7; i8++) {
            i3 = (i3 * 31) + objArr[i8].hashCode();
        }
        return i6 + i3;
    }

    /* access modifiers changed from: package-private */
    public final void zza(zzfr zzfr) throws IOException {
        if (zzfr.zzaj() == zzcg.zzg.zzkp) {
            for (int i = this.count - 1; i >= 0; i--) {
                zzfr.zza(this.zzpa[i] >>> 3, this.zzmj[i]);
            }
            return;
        }
        for (int i2 = 0; i2 < this.count; i2++) {
            zzfr.zza(this.zzpa[i2] >>> 3, this.zzmj[i2]);
        }
    }

    /* access modifiers changed from: package-private */
    public final void zza(StringBuilder sb, int i) {
        for (int i2 = 0; i2 < this.count; i2++) {
            zzdr.zza(sb, i, String.valueOf(this.zzpa[i2] >>> 3), this.zzmj[i2]);
        }
    }

    public final int zzas() {
        int i;
        int i2 = this.zzjq;
        if (i2 != -1) {
            return i2;
        }
        int i3 = 0;
        for (int i4 = 0; i4 < this.count; i4++) {
            int i5 = this.zzpa[i4];
            int i6 = i5 >>> 3;
            int i7 = i5 & 7;
            if (i7 == 0) {
                i = zzbn.zze(i6, ((Long) this.zzmj[i4]).longValue());
            } else if (i7 == 1) {
                i = zzbn.zzg(i6, ((Long) this.zzmj[i4]).longValue());
            } else if (i7 == 2) {
                i = zzbn.zzc(i6, (zzbb) this.zzmj[i4]);
            } else if (i7 == 3) {
                i = (zzbn.zzr(i6) << 1) + ((zzey) this.zzmj[i4]).zzas();
            } else if (i7 == 5) {
                i = zzbn.zzj(i6, ((Integer) this.zzmj[i4]).intValue());
            } else {
                throw new IllegalStateException(zzco.zzbn());
            }
            i3 += i;
        }
        this.zzjq = i3;
        return i3;
    }

    /* access modifiers changed from: package-private */
    public final void zzb(int i, Object obj) {
        if (this.zzfa) {
            int i2 = this.count;
            if (i2 == this.zzpa.length) {
                int i3 = this.count + (i2 < 4 ? 8 : i2 >> 1);
                this.zzpa = Arrays.copyOf(this.zzpa, i3);
                this.zzmj = Arrays.copyOf(this.zzmj, i3);
            }
            int[] iArr = this.zzpa;
            int i4 = this.count;
            iArr[i4] = i;
            this.zzmj[i4] = obj;
            this.count = i4 + 1;
            return;
        }
        throw new UnsupportedOperationException();
    }

    public final void zzb(zzfr zzfr) throws IOException {
        if (this.count != 0) {
            if (zzfr.zzaj() == zzcg.zzg.zzko) {
                for (int i = 0; i < this.count; i++) {
                    zzb(this.zzpa[i], this.zzmj[i], zzfr);
                }
                return;
            }
            for (int i2 = this.count - 1; i2 >= 0; i2--) {
                zzb(this.zzpa[i2], this.zzmj[i2], zzfr);
            }
        }
    }

    public final int zzec() {
        int i = this.zzjq;
        if (i != -1) {
            return i;
        }
        int i2 = 0;
        for (int i3 = 0; i3 < this.count; i3++) {
            i2 += zzbn.zzd(this.zzpa[i3] >>> 3, (zzbb) this.zzmj[i3]);
        }
        this.zzjq = i2;
        return i2;
    }

    public final void zzv() {
        this.zzfa = false;
    }
}
