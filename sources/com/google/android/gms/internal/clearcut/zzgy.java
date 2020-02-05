package com.google.android.gms.internal.clearcut;

import java.io.IOException;

public final class zzgy extends zzfu<zzgy> implements Cloneable {
    private String[] zzbiw = zzgb.zzsc;
    private String[] zzbix = zzgb.zzsc;
    private int[] zzbiy = zzgb.zzrx;
    private long[] zzbiz = zzgb.zzry;
    private long[] zzbja = zzgb.zzry;

    public zzgy() {
        this.zzrj = null;
        this.zzrs = -1;
    }

    /* access modifiers changed from: private */
    /* renamed from: zzgb */
    public final zzgy clone() {
        try {
            zzgy zzgy = (zzgy) super.clone();
            String[] strArr = this.zzbiw;
            if (strArr != null && strArr.length > 0) {
                zzgy.zzbiw = (String[]) strArr.clone();
            }
            String[] strArr2 = this.zzbix;
            if (strArr2 != null && strArr2.length > 0) {
                zzgy.zzbix = (String[]) strArr2.clone();
            }
            int[] iArr = this.zzbiy;
            if (iArr != null && iArr.length > 0) {
                zzgy.zzbiy = (int[]) iArr.clone();
            }
            long[] jArr = this.zzbiz;
            if (jArr != null && jArr.length > 0) {
                zzgy.zzbiz = (long[]) jArr.clone();
            }
            long[] jArr2 = this.zzbja;
            if (jArr2 != null && jArr2.length > 0) {
                zzgy.zzbja = (long[]) jArr2.clone();
            }
            return zzgy;
        } catch (CloneNotSupportedException e) {
            throw new AssertionError(e);
        }
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzgy)) {
            return false;
        }
        zzgy zzgy = (zzgy) obj;
        if (zzfy.equals((Object[]) this.zzbiw, (Object[]) zzgy.zzbiw) && zzfy.equals((Object[]) this.zzbix, (Object[]) zzgy.zzbix) && zzfy.equals(this.zzbiy, zzgy.zzbiy) && zzfy.equals(this.zzbiz, zzgy.zzbiz) && zzfy.equals(this.zzbja, zzgy.zzbja)) {
            return (this.zzrj == null || this.zzrj.isEmpty()) ? zzgy.zzrj == null || zzgy.zzrj.isEmpty() : this.zzrj.equals(zzgy.zzrj);
        }
        return false;
    }

    public final int hashCode() {
        return ((((((((((((getClass().getName().hashCode() + 527) * 31) + zzfy.hashCode((Object[]) this.zzbiw)) * 31) + zzfy.hashCode((Object[]) this.zzbix)) * 31) + zzfy.hashCode(this.zzbiy)) * 31) + zzfy.hashCode(this.zzbiz)) * 31) + zzfy.hashCode(this.zzbja)) * 31) + ((this.zzrj == null || this.zzrj.isEmpty()) ? 0 : this.zzrj.hashCode());
    }

    public final void zza(zzfs zzfs) throws IOException {
        String[] strArr = this.zzbiw;
        int i = 0;
        if (strArr != null && strArr.length > 0) {
            int i2 = 0;
            while (true) {
                String[] strArr2 = this.zzbiw;
                if (i2 >= strArr2.length) {
                    break;
                }
                String str = strArr2[i2];
                if (str != null) {
                    zzfs.zza(1, str);
                }
                i2++;
            }
        }
        String[] strArr3 = this.zzbix;
        if (strArr3 != null && strArr3.length > 0) {
            int i3 = 0;
            while (true) {
                String[] strArr4 = this.zzbix;
                if (i3 >= strArr4.length) {
                    break;
                }
                String str2 = strArr4[i3];
                if (str2 != null) {
                    zzfs.zza(2, str2);
                }
                i3++;
            }
        }
        int[] iArr = this.zzbiy;
        if (iArr != null && iArr.length > 0) {
            int i4 = 0;
            while (true) {
                int[] iArr2 = this.zzbiy;
                if (i4 >= iArr2.length) {
                    break;
                }
                zzfs.zzc(3, iArr2[i4]);
                i4++;
            }
        }
        long[] jArr = this.zzbiz;
        if (jArr != null && jArr.length > 0) {
            int i5 = 0;
            while (true) {
                long[] jArr2 = this.zzbiz;
                if (i5 >= jArr2.length) {
                    break;
                }
                zzfs.zzi(4, jArr2[i5]);
                i5++;
            }
        }
        long[] jArr3 = this.zzbja;
        if (jArr3 != null && jArr3.length > 0) {
            while (true) {
                long[] jArr4 = this.zzbja;
                if (i >= jArr4.length) {
                    break;
                }
                zzfs.zzi(5, jArr4[i]);
                i++;
            }
        }
        super.zza(zzfs);
    }

    /* access modifiers changed from: protected */
    public final int zzen() {
        long[] jArr;
        int[] iArr;
        int zzen = super.zzen();
        String[] strArr = this.zzbiw;
        int i = 0;
        if (strArr != null && strArr.length > 0) {
            int i2 = 0;
            int i3 = 0;
            int i4 = 0;
            while (true) {
                String[] strArr2 = this.zzbiw;
                if (i2 >= strArr2.length) {
                    break;
                }
                String str = strArr2[i2];
                if (str != null) {
                    i4++;
                    i3 += zzfs.zzh(str);
                }
                i2++;
            }
            zzen = zzen + i3 + (i4 * 1);
        }
        String[] strArr3 = this.zzbix;
        if (strArr3 != null && strArr3.length > 0) {
            int i5 = 0;
            int i6 = 0;
            int i7 = 0;
            while (true) {
                String[] strArr4 = this.zzbix;
                if (i5 >= strArr4.length) {
                    break;
                }
                String str2 = strArr4[i5];
                if (str2 != null) {
                    i7++;
                    i6 += zzfs.zzh(str2);
                }
                i5++;
            }
            zzen = zzen + i6 + (i7 * 1);
        }
        int[] iArr2 = this.zzbiy;
        if (iArr2 != null && iArr2.length > 0) {
            int i8 = 0;
            int i9 = 0;
            while (true) {
                iArr = this.zzbiy;
                if (i8 >= iArr.length) {
                    break;
                }
                i9 += zzfs.zzs(iArr[i8]);
                i8++;
            }
            zzen = zzen + i9 + (iArr.length * 1);
        }
        long[] jArr2 = this.zzbiz;
        if (jArr2 != null && jArr2.length > 0) {
            int i10 = 0;
            int i11 = 0;
            while (true) {
                jArr = this.zzbiz;
                if (i10 >= jArr.length) {
                    break;
                }
                i11 += zzfs.zzo(jArr[i10]);
                i10++;
            }
            zzen = zzen + i11 + (jArr.length * 1);
        }
        long[] jArr3 = this.zzbja;
        if (jArr3 == null || jArr3.length <= 0) {
            return zzen;
        }
        int i12 = 0;
        while (true) {
            long[] jArr4 = this.zzbja;
            if (i >= jArr4.length) {
                return zzen + i12 + (jArr4.length * 1);
            }
            i12 += zzfs.zzo(jArr4[i]);
            i++;
        }
    }

    public final /* synthetic */ zzfu zzeo() throws CloneNotSupportedException {
        return (zzgy) clone();
    }

    public final /* synthetic */ zzfz zzep() throws CloneNotSupportedException {
        return (zzgy) clone();
    }
}
