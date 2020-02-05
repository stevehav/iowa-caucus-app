package com.google.android.gms.internal.vision;

import com.google.android.gms.internal.vision.zzcz;
import java.io.IOException;

public final class zzdm extends zzjn<zzdm> {
    private static volatile zzdm[] zzoo;
    public String name = null;
    private String zzop = null;
    private String[] zzoq = zzjw.zzady;
    private zzcz.zzd.zzb zzor;
    public String zzos = null;
    public Long zzot = null;
    public Long zzou = null;
    public zzdt[] zzov = zzdt.zzcd();

    public static zzdm[] zzcb() {
        if (zzoo == null) {
            synchronized (zzjr.zzado) {
                if (zzoo == null) {
                    zzoo = new zzdm[0];
                }
            }
        }
        return zzoo;
    }

    public zzdm() {
        this.zzadp = -1;
    }

    public final void zza(zzjl zzjl) throws IOException {
        String str = this.name;
        if (str != null) {
            zzjl.zza(1, str);
        }
        String str2 = this.zzop;
        if (str2 != null) {
            zzjl.zza(2, str2);
        }
        String[] strArr = this.zzoq;
        int i = 0;
        if (strArr != null && strArr.length > 0) {
            int i2 = 0;
            while (true) {
                String[] strArr2 = this.zzoq;
                if (i2 >= strArr2.length) {
                    break;
                }
                String str3 = strArr2[i2];
                if (str3 != null) {
                    zzjl.zza(3, str3);
                }
                i2++;
            }
        }
        zzcz.zzd.zzb zzb = this.zzor;
        if (!(zzb == null || zzb == null)) {
            zzjl.zze(4, zzb.zzr());
        }
        String str4 = this.zzos;
        if (str4 != null) {
            zzjl.zza(5, str4);
        }
        Long l = this.zzot;
        if (l != null) {
            zzjl.zzi(6, l.longValue());
        }
        Long l2 = this.zzou;
        if (l2 != null) {
            zzjl.zzi(7, l2.longValue());
        }
        zzdt[] zzdtArr = this.zzov;
        if (zzdtArr != null && zzdtArr.length > 0) {
            while (true) {
                zzdt[] zzdtArr2 = this.zzov;
                if (i >= zzdtArr2.length) {
                    break;
                }
                zzdt zzdt = zzdtArr2[i];
                if (zzdt != null) {
                    zzjl.zza(8, (zzjt) zzdt);
                }
                i++;
            }
        }
        super.zza(zzjl);
    }

    /* access modifiers changed from: protected */
    public final int zzt() {
        int zzt = super.zzt();
        String str = this.name;
        if (str != null) {
            zzt += zzjl.zzb(1, str);
        }
        String str2 = this.zzop;
        if (str2 != null) {
            zzt += zzjl.zzb(2, str2);
        }
        String[] strArr = this.zzoq;
        int i = 0;
        if (strArr != null && strArr.length > 0) {
            int i2 = 0;
            int i3 = 0;
            int i4 = 0;
            while (true) {
                String[] strArr2 = this.zzoq;
                if (i2 >= strArr2.length) {
                    break;
                }
                String str3 = strArr2[i2];
                if (str3 != null) {
                    i4++;
                    i3 += zzjl.zzn(str3);
                }
                i2++;
            }
            zzt = zzt + i3 + (i4 * 1);
        }
        zzcz.zzd.zzb zzb = this.zzor;
        if (!(zzb == null || zzb == null)) {
            zzt += zzjl.zzi(4, zzb.zzr());
        }
        String str4 = this.zzos;
        if (str4 != null) {
            zzt += zzjl.zzb(5, str4);
        }
        Long l = this.zzot;
        if (l != null) {
            zzt += zzjl.zzd(6, l.longValue());
        }
        Long l2 = this.zzou;
        if (l2 != null) {
            zzt += zzjl.zzd(7, l2.longValue());
        }
        zzdt[] zzdtArr = this.zzov;
        if (zzdtArr != null && zzdtArr.length > 0) {
            while (true) {
                zzdt[] zzdtArr2 = this.zzov;
                if (i >= zzdtArr2.length) {
                    break;
                }
                zzdt zzdt = zzdtArr2[i];
                if (zzdt != null) {
                    zzt += zzjl.zzb(8, (zzjt) zzdt);
                }
                i++;
            }
        }
        return zzt;
    }

    public final /* synthetic */ zzjt zza(zzjk zzjk) throws IOException {
        while (true) {
            int zzdq = zzjk.zzdq();
            if (zzdq == 0) {
                return this;
            }
            if (zzdq == 10) {
                this.name = zzjk.readString();
            } else if (zzdq == 18) {
                this.zzop = zzjk.readString();
            } else if (zzdq == 26) {
                int zzb = zzjw.zzb(zzjk, 26);
                String[] strArr = this.zzoq;
                int length = strArr == null ? 0 : strArr.length;
                String[] strArr2 = new String[(zzb + length)];
                if (length != 0) {
                    System.arraycopy(this.zzoq, 0, strArr2, 0, length);
                }
                while (length < strArr2.length - 1) {
                    strArr2[length] = zzjk.readString();
                    zzjk.zzdq();
                    length++;
                }
                strArr2[length] = zzjk.readString();
                this.zzoq = strArr2;
            } else if (zzdq == 32) {
                int position = zzjk.getPosition();
                int zzdt = zzjk.zzdt();
                if (zzdt == 0 || zzdt == 1 || zzdt == 2 || zzdt == 3) {
                    this.zzor = zzcz.zzd.zzb.zzt(zzdt);
                } else {
                    zzjk.zzbt(position);
                    zza(zzjk, zzdq);
                }
            } else if (zzdq == 42) {
                this.zzos = zzjk.readString();
            } else if (zzdq == 48) {
                this.zzot = Long.valueOf(zzjk.zzdu());
            } else if (zzdq == 56) {
                this.zzou = Long.valueOf(zzjk.zzdu());
            } else if (zzdq == 66) {
                int zzb2 = zzjw.zzb(zzjk, 66);
                zzdt[] zzdtArr = this.zzov;
                int length2 = zzdtArr == null ? 0 : zzdtArr.length;
                zzdt[] zzdtArr2 = new zzdt[(zzb2 + length2)];
                if (length2 != 0) {
                    System.arraycopy(this.zzov, 0, zzdtArr2, 0, length2);
                }
                while (length2 < zzdtArr2.length - 1) {
                    zzdtArr2[length2] = new zzdt();
                    zzjk.zza((zzjt) zzdtArr2[length2]);
                    zzjk.zzdq();
                    length2++;
                }
                zzdtArr2[length2] = new zzdt();
                zzjk.zza((zzjt) zzdtArr2[length2]);
                this.zzov = zzdtArr2;
            } else if (!super.zza(zzjk, zzdq)) {
                return this;
            }
        }
    }
}
