package com.google.android.gms.internal.vision;

import com.google.android.gms.internal.vision.zzcz;
import java.io.IOException;

public final class zzdp extends zzjn<zzdp> {
    public zzdq zzpi = null;
    private zzcz.zzg zzpj;
    public zzdm[] zzpk = zzdm.zzcb();

    public zzdp() {
        this.zzadp = -1;
    }

    public final void zza(zzjl zzjl) throws IOException {
        zzdq zzdq = this.zzpi;
        if (zzdq != null) {
            zzjl.zza(1, (zzjt) zzdq);
        }
        zzcz.zzg zzg = this.zzpj;
        if (zzg != null) {
            zzjl.zze(2, (zzhf) zzg);
        }
        zzdm[] zzdmArr = this.zzpk;
        if (zzdmArr != null && zzdmArr.length > 0) {
            int i = 0;
            while (true) {
                zzdm[] zzdmArr2 = this.zzpk;
                if (i >= zzdmArr2.length) {
                    break;
                }
                zzdm zzdm = zzdmArr2[i];
                if (zzdm != null) {
                    zzjl.zza(3, (zzjt) zzdm);
                }
                i++;
            }
        }
        super.zza(zzjl);
    }

    /* access modifiers changed from: protected */
    public final int zzt() {
        int zzt = super.zzt();
        zzdq zzdq = this.zzpi;
        if (zzdq != null) {
            zzt += zzjl.zzb(1, (zzjt) zzdq);
        }
        zzcz.zzg zzg = this.zzpj;
        if (zzg != null) {
            zzt += zzfe.zzc(2, (zzhf) zzg);
        }
        zzdm[] zzdmArr = this.zzpk;
        if (zzdmArr != null && zzdmArr.length > 0) {
            int i = 0;
            while (true) {
                zzdm[] zzdmArr2 = this.zzpk;
                if (i >= zzdmArr2.length) {
                    break;
                }
                zzdm zzdm = zzdmArr2[i];
                if (zzdm != null) {
                    zzt += zzjl.zzb(3, (zzjt) zzdm);
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
                if (this.zzpi == null) {
                    this.zzpi = new zzdq();
                }
                zzjk.zza((zzjt) this.zzpi);
            } else if (zzdq == 18) {
                this.zzpj = (zzcz.zzg) zzjk.zza(zzcz.zzg.zzbx());
            } else if (zzdq == 26) {
                int zzb = zzjw.zzb(zzjk, 26);
                zzdm[] zzdmArr = this.zzpk;
                int length = zzdmArr == null ? 0 : zzdmArr.length;
                zzdm[] zzdmArr2 = new zzdm[(zzb + length)];
                if (length != 0) {
                    System.arraycopy(this.zzpk, 0, zzdmArr2, 0, length);
                }
                while (length < zzdmArr2.length - 1) {
                    zzdmArr2[length] = new zzdm();
                    zzjk.zza((zzjt) zzdmArr2[length]);
                    zzjk.zzdq();
                    length++;
                }
                zzdmArr2[length] = new zzdm();
                zzjk.zza((zzjt) zzdmArr2[length]);
                this.zzpk = zzdmArr2;
            } else if (!super.zza(zzjk, zzdq)) {
                return this;
            }
        }
    }
}
