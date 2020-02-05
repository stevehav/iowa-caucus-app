package com.google.android.gms.internal.clearcut;

import com.google.android.gms.internal.clearcut.zzge;
import java.io.IOException;
import java.util.Arrays;

public final class zzha extends zzfu<zzha> implements Cloneable {
    private String tag = "";
    public long zzbjf = 0;
    public long zzbjg = 0;
    private long zzbjh = 0;
    public int zzbji = 0;
    private String zzbjj = "";
    private int zzbjk = 0;
    private boolean zzbjl = false;
    private zzhb[] zzbjm = zzhb.zzge();
    private byte[] zzbjn = zzgb.zzse;
    private zzge.zzd zzbjo = null;
    public byte[] zzbjp = zzgb.zzse;
    private String zzbjq = "";
    private String zzbjr = "";
    private zzgy zzbjs = null;
    private String zzbjt = "";
    public long zzbju = 180000;
    private zzgz zzbjv = null;
    public byte[] zzbjw = zzgb.zzse;
    private String zzbjx = "";
    private int zzbjy = 0;
    private int[] zzbjz = zzgb.zzrx;
    private long zzbka = 0;
    private zzge.zzs zzbkb = null;
    public boolean zzbkc = false;

    public zzha() {
        this.zzrj = null;
        this.zzrs = -1;
    }

    /* access modifiers changed from: private */
    /* renamed from: zzgd */
    public final zzha clone() {
        try {
            zzha zzha = (zzha) super.clone();
            zzhb[] zzhbArr = this.zzbjm;
            if (zzhbArr != null && zzhbArr.length > 0) {
                zzha.zzbjm = new zzhb[zzhbArr.length];
                int i = 0;
                while (true) {
                    zzhb[] zzhbArr2 = this.zzbjm;
                    if (i >= zzhbArr2.length) {
                        break;
                    }
                    if (zzhbArr2[i] != null) {
                        zzha.zzbjm[i] = (zzhb) zzhbArr2[i].clone();
                    }
                    i++;
                }
            }
            zzge.zzd zzd = this.zzbjo;
            if (zzd != null) {
                zzha.zzbjo = zzd;
            }
            zzgy zzgy = this.zzbjs;
            if (zzgy != null) {
                zzha.zzbjs = (zzgy) zzgy.clone();
            }
            zzgz zzgz = this.zzbjv;
            if (zzgz != null) {
                zzha.zzbjv = (zzgz) zzgz.clone();
            }
            int[] iArr = this.zzbjz;
            if (iArr != null && iArr.length > 0) {
                zzha.zzbjz = (int[]) iArr.clone();
            }
            zzge.zzs zzs = this.zzbkb;
            if (zzs != null) {
                zzha.zzbkb = zzs;
            }
            return zzha;
        } catch (CloneNotSupportedException e) {
            throw new AssertionError(e);
        }
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzha)) {
            return false;
        }
        zzha zzha = (zzha) obj;
        if (this.zzbjf != zzha.zzbjf || this.zzbjg != zzha.zzbjg) {
            return false;
        }
        String str = this.tag;
        if (str == null) {
            if (zzha.tag != null) {
                return false;
            }
        } else if (!str.equals(zzha.tag)) {
            return false;
        }
        if (this.zzbji != zzha.zzbji) {
            return false;
        }
        String str2 = this.zzbjj;
        if (str2 == null) {
            if (zzha.zzbjj != null) {
                return false;
            }
        } else if (!str2.equals(zzha.zzbjj)) {
            return false;
        }
        if (!zzfy.equals((Object[]) this.zzbjm, (Object[]) zzha.zzbjm) || !Arrays.equals(this.zzbjn, zzha.zzbjn)) {
            return false;
        }
        zzge.zzd zzd = this.zzbjo;
        if (zzd == null) {
            if (zzha.zzbjo != null) {
                return false;
            }
        } else if (!zzd.equals(zzha.zzbjo)) {
            return false;
        }
        if (!Arrays.equals(this.zzbjp, zzha.zzbjp)) {
            return false;
        }
        String str3 = this.zzbjq;
        if (str3 == null) {
            if (zzha.zzbjq != null) {
                return false;
            }
        } else if (!str3.equals(zzha.zzbjq)) {
            return false;
        }
        String str4 = this.zzbjr;
        if (str4 == null) {
            if (zzha.zzbjr != null) {
                return false;
            }
        } else if (!str4.equals(zzha.zzbjr)) {
            return false;
        }
        zzgy zzgy = this.zzbjs;
        if (zzgy == null) {
            if (zzha.zzbjs != null) {
                return false;
            }
        } else if (!zzgy.equals(zzha.zzbjs)) {
            return false;
        }
        String str5 = this.zzbjt;
        if (str5 == null) {
            if (zzha.zzbjt != null) {
                return false;
            }
        } else if (!str5.equals(zzha.zzbjt)) {
            return false;
        }
        if (this.zzbju != zzha.zzbju) {
            return false;
        }
        zzgz zzgz = this.zzbjv;
        if (zzgz == null) {
            if (zzha.zzbjv != null) {
                return false;
            }
        } else if (!zzgz.equals(zzha.zzbjv)) {
            return false;
        }
        if (!Arrays.equals(this.zzbjw, zzha.zzbjw)) {
            return false;
        }
        String str6 = this.zzbjx;
        if (str6 == null) {
            if (zzha.zzbjx != null) {
                return false;
            }
        } else if (!str6.equals(zzha.zzbjx)) {
            return false;
        }
        if (!zzfy.equals(this.zzbjz, zzha.zzbjz)) {
            return false;
        }
        zzge.zzs zzs = this.zzbkb;
        if (zzs == null) {
            if (zzha.zzbkb != null) {
                return false;
            }
        } else if (!zzs.equals(zzha.zzbkb)) {
            return false;
        }
        if (this.zzbkc != zzha.zzbkc) {
            return false;
        }
        return (this.zzrj == null || this.zzrj.isEmpty()) ? zzha.zzrj == null || zzha.zzrj.isEmpty() : this.zzrj.equals(zzha.zzrj);
    }

    public final int hashCode() {
        long j = this.zzbjf;
        long j2 = this.zzbjg;
        int hashCode = (((((getClass().getName().hashCode() + 527) * 31) + ((int) (j ^ (j >>> 32)))) * 31) + ((int) (j2 ^ (j2 >>> 32)))) * 31 * 31;
        String str = this.tag;
        int i = 0;
        int hashCode2 = (((hashCode + (str == null ? 0 : str.hashCode())) * 31) + this.zzbji) * 31;
        String str2 = this.zzbjj;
        int hashCode3 = str2 == null ? 0 : str2.hashCode();
        int i2 = 1237;
        int hashCode4 = ((((((hashCode2 + hashCode3) * 31 * 31) + 1237) * 31) + zzfy.hashCode((Object[]) this.zzbjm)) * 31) + Arrays.hashCode(this.zzbjn);
        zzge.zzd zzd = this.zzbjo;
        int hashCode5 = ((((hashCode4 * 31) + (zzd == null ? 0 : zzd.hashCode())) * 31) + Arrays.hashCode(this.zzbjp)) * 31;
        String str3 = this.zzbjq;
        int hashCode6 = (hashCode5 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.zzbjr;
        int hashCode7 = hashCode6 + (str4 == null ? 0 : str4.hashCode());
        zzgy zzgy = this.zzbjs;
        int hashCode8 = ((hashCode7 * 31) + (zzgy == null ? 0 : zzgy.hashCode())) * 31;
        String str5 = this.zzbjt;
        int hashCode9 = str5 == null ? 0 : str5.hashCode();
        long j3 = this.zzbju;
        zzgz zzgz = this.zzbjv;
        int hashCode10 = (((((((hashCode8 + hashCode9) * 31) + ((int) (j3 ^ (j3 >>> 32)))) * 31) + (zzgz == null ? 0 : zzgz.hashCode())) * 31) + Arrays.hashCode(this.zzbjw)) * 31;
        String str6 = this.zzbjx;
        int hashCode11 = str6 == null ? 0 : str6.hashCode();
        zzge.zzs zzs = this.zzbkb;
        int hashCode12 = (((((hashCode10 + hashCode11) * 31 * 31) + zzfy.hashCode(this.zzbjz)) * 31 * 31) + (zzs == null ? 0 : zzs.hashCode())) * 31;
        if (this.zzbkc) {
            i2 = 1231;
        }
        int i3 = (hashCode12 + i2) * 31;
        if (this.zzrj != null && !this.zzrj.isEmpty()) {
            i = this.zzrj.hashCode();
        }
        return i3 + i;
    }

    public final void zza(zzfs zzfs) throws IOException {
        long j = this.zzbjf;
        if (j != 0) {
            zzfs.zzi(1, j);
        }
        String str = this.tag;
        if (str != null && !str.equals("")) {
            zzfs.zza(2, this.tag);
        }
        zzhb[] zzhbArr = this.zzbjm;
        int i = 0;
        if (zzhbArr != null && zzhbArr.length > 0) {
            int i2 = 0;
            while (true) {
                zzhb[] zzhbArr2 = this.zzbjm;
                if (i2 >= zzhbArr2.length) {
                    break;
                }
                zzhb zzhb = zzhbArr2[i2];
                if (zzhb != null) {
                    zzfs.zza(3, (zzfz) zzhb);
                }
                i2++;
            }
        }
        if (!Arrays.equals(this.zzbjn, zzgb.zzse)) {
            zzfs.zza(4, this.zzbjn);
        }
        if (!Arrays.equals(this.zzbjp, zzgb.zzse)) {
            zzfs.zza(6, this.zzbjp);
        }
        zzgy zzgy = this.zzbjs;
        if (zzgy != null) {
            zzfs.zza(7, (zzfz) zzgy);
        }
        String str2 = this.zzbjq;
        if (str2 != null && !str2.equals("")) {
            zzfs.zza(8, this.zzbjq);
        }
        zzge.zzd zzd = this.zzbjo;
        if (zzd != null) {
            zzfs.zze(9, zzd);
        }
        int i3 = this.zzbji;
        if (i3 != 0) {
            zzfs.zzc(11, i3);
        }
        String str3 = this.zzbjr;
        if (str3 != null && !str3.equals("")) {
            zzfs.zza(13, this.zzbjr);
        }
        String str4 = this.zzbjt;
        if (str4 != null && !str4.equals("")) {
            zzfs.zza(14, this.zzbjt);
        }
        long j2 = this.zzbju;
        if (j2 != 180000) {
            zzfs.zzb(15, 0);
            zzfs.zzn(zzfs.zzj(j2));
        }
        zzgz zzgz = this.zzbjv;
        if (zzgz != null) {
            zzfs.zza(16, (zzfz) zzgz);
        }
        long j3 = this.zzbjg;
        if (j3 != 0) {
            zzfs.zzi(17, j3);
        }
        if (!Arrays.equals(this.zzbjw, zzgb.zzse)) {
            zzfs.zza(18, this.zzbjw);
        }
        int[] iArr = this.zzbjz;
        if (iArr != null && iArr.length > 0) {
            while (true) {
                int[] iArr2 = this.zzbjz;
                if (i >= iArr2.length) {
                    break;
                }
                zzfs.zzc(20, iArr2[i]);
                i++;
            }
        }
        zzge.zzs zzs = this.zzbkb;
        if (zzs != null) {
            zzfs.zze(23, zzs);
        }
        String str5 = this.zzbjx;
        if (str5 != null && !str5.equals("")) {
            zzfs.zza(24, this.zzbjx);
        }
        boolean z = this.zzbkc;
        if (z) {
            zzfs.zzb(25, z);
        }
        String str6 = this.zzbjj;
        if (str6 != null && !str6.equals("")) {
            zzfs.zza(26, this.zzbjj);
        }
        super.zza(zzfs);
    }

    /* access modifiers changed from: protected */
    public final int zzen() {
        int[] iArr;
        int zzen = super.zzen();
        long j = this.zzbjf;
        if (j != 0) {
            zzen += zzfs.zzd(1, j);
        }
        String str = this.tag;
        if (str != null && !str.equals("")) {
            zzen += zzfs.zzb(2, this.tag);
        }
        zzhb[] zzhbArr = this.zzbjm;
        int i = 0;
        if (zzhbArr != null && zzhbArr.length > 0) {
            int i2 = zzen;
            int i3 = 0;
            while (true) {
                zzhb[] zzhbArr2 = this.zzbjm;
                if (i3 >= zzhbArr2.length) {
                    break;
                }
                zzhb zzhb = zzhbArr2[i3];
                if (zzhb != null) {
                    i2 += zzfs.zzb(3, (zzfz) zzhb);
                }
                i3++;
            }
            zzen = i2;
        }
        if (!Arrays.equals(this.zzbjn, zzgb.zzse)) {
            zzen += zzfs.zzb(4, this.zzbjn);
        }
        if (!Arrays.equals(this.zzbjp, zzgb.zzse)) {
            zzen += zzfs.zzb(6, this.zzbjp);
        }
        zzgy zzgy = this.zzbjs;
        if (zzgy != null) {
            zzen += zzfs.zzb(7, (zzfz) zzgy);
        }
        String str2 = this.zzbjq;
        if (str2 != null && !str2.equals("")) {
            zzen += zzfs.zzb(8, this.zzbjq);
        }
        zzge.zzd zzd = this.zzbjo;
        if (zzd != null) {
            zzen += zzbn.zzc(9, (zzdo) zzd);
        }
        int i4 = this.zzbji;
        if (i4 != 0) {
            zzen += zzfs.zzr(11) + zzfs.zzs(i4);
        }
        String str3 = this.zzbjr;
        if (str3 != null && !str3.equals("")) {
            zzen += zzfs.zzb(13, this.zzbjr);
        }
        String str4 = this.zzbjt;
        if (str4 != null && !str4.equals("")) {
            zzen += zzfs.zzb(14, this.zzbjt);
        }
        long j2 = this.zzbju;
        if (j2 != 180000) {
            zzen += zzfs.zzr(15) + zzfs.zzo(zzfs.zzj(j2));
        }
        zzgz zzgz = this.zzbjv;
        if (zzgz != null) {
            zzen += zzfs.zzb(16, (zzfz) zzgz);
        }
        long j3 = this.zzbjg;
        if (j3 != 0) {
            zzen += zzfs.zzd(17, j3);
        }
        if (!Arrays.equals(this.zzbjw, zzgb.zzse)) {
            zzen += zzfs.zzb(18, this.zzbjw);
        }
        int[] iArr2 = this.zzbjz;
        if (iArr2 != null && iArr2.length > 0) {
            int i5 = 0;
            while (true) {
                iArr = this.zzbjz;
                if (i >= iArr.length) {
                    break;
                }
                i5 += zzfs.zzs(iArr[i]);
                i++;
            }
            zzen = zzen + i5 + (iArr.length * 2);
        }
        zzge.zzs zzs = this.zzbkb;
        if (zzs != null) {
            zzen += zzbn.zzc(23, (zzdo) zzs);
        }
        String str5 = this.zzbjx;
        if (str5 != null && !str5.equals("")) {
            zzen += zzfs.zzb(24, this.zzbjx);
        }
        if (this.zzbkc) {
            zzen += zzfs.zzr(25) + 1;
        }
        String str6 = this.zzbjj;
        return (str6 == null || str6.equals("")) ? zzen : zzen + zzfs.zzb(26, this.zzbjj);
    }

    public final /* synthetic */ zzfu zzeo() throws CloneNotSupportedException {
        return (zzha) clone();
    }

    public final /* synthetic */ zzfz zzep() throws CloneNotSupportedException {
        return (zzha) clone();
    }
}
