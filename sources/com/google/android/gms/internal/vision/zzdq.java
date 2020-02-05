package com.google.android.gms.internal.vision;

import com.google.android.gms.internal.vision.zzcz;
import java.io.IOException;

public final class zzdq extends zzjn<zzdq> {
    private zzcz.zzf.zzb zzpl;
    public Long zzpm = null;
    public Long zzpn = null;
    public Long zzpo = null;
    public Long zzpp = null;

    public zzdq() {
        this.zzadp = -1;
    }

    public final void zza(zzjl zzjl) throws IOException {
        zzcz.zzf.zzb zzb = this.zzpl;
        if (!(zzb == null || zzb == null)) {
            zzjl.zze(1, zzb.zzr());
        }
        Long l = this.zzpm;
        if (l != null) {
            zzjl.zzi(2, l.longValue());
        }
        Long l2 = this.zzpn;
        if (l2 != null) {
            zzjl.zzi(3, l2.longValue());
        }
        Long l3 = this.zzpp;
        if (l3 != null) {
            zzjl.zzi(4, l3.longValue());
        }
        Long l4 = this.zzpo;
        if (l4 != null) {
            zzjl.zzi(5, l4.longValue());
        }
        super.zza(zzjl);
    }

    /* access modifiers changed from: protected */
    public final int zzt() {
        int zzt = super.zzt();
        zzcz.zzf.zzb zzb = this.zzpl;
        if (!(zzb == null || zzb == null)) {
            zzt += zzjl.zzi(1, zzb.zzr());
        }
        Long l = this.zzpm;
        if (l != null) {
            zzt += zzjl.zzd(2, l.longValue());
        }
        Long l2 = this.zzpn;
        if (l2 != null) {
            zzt += zzjl.zzd(3, l2.longValue());
        }
        Long l3 = this.zzpp;
        if (l3 != null) {
            zzt += zzjl.zzd(4, l3.longValue());
        }
        Long l4 = this.zzpo;
        return l4 != null ? zzt + zzjl.zzd(5, l4.longValue()) : zzt;
    }

    public final /* synthetic */ zzjt zza(zzjk zzjk) throws IOException {
        while (true) {
            int zzdq = zzjk.zzdq();
            if (zzdq == 0) {
                return this;
            }
            if (zzdq == 8) {
                int position = zzjk.getPosition();
                int zzdt = zzjk.zzdt();
                if (zzdt == 0 || zzdt == 1 || zzdt == 2 || zzdt == 3) {
                    this.zzpl = zzcz.zzf.zzb.zzu(zzdt);
                } else {
                    zzjk.zzbt(position);
                    zza(zzjk, zzdq);
                }
            } else if (zzdq == 16) {
                this.zzpm = Long.valueOf(zzjk.zzdu());
            } else if (zzdq == 24) {
                this.zzpn = Long.valueOf(zzjk.zzdu());
            } else if (zzdq == 32) {
                this.zzpp = Long.valueOf(zzjk.zzdu());
            } else if (zzdq == 40) {
                this.zzpo = Long.valueOf(zzjk.zzdu());
            } else if (!super.zza(zzjk, zzdq)) {
                return this;
            }
        }
    }
}
