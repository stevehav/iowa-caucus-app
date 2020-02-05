package com.google.android.gms.internal.vision;

import java.io.IOException;

public final class zzdt extends zzjn<zzdt> {
    private static volatile zzdt[] zzpx;
    public zzdk zzpy = null;
    public Integer zzpz = null;
    public zzdo zzqa = null;
    private zzdj zzqb = null;

    public static zzdt[] zzcd() {
        if (zzpx == null) {
            synchronized (zzjr.zzado) {
                if (zzpx == null) {
                    zzpx = new zzdt[0];
                }
            }
        }
        return zzpx;
    }

    public zzdt() {
        this.zzadp = -1;
    }

    public final void zza(zzjl zzjl) throws IOException {
        zzdk zzdk = this.zzpy;
        if (zzdk != null) {
            zzjl.zza(1, (zzjt) zzdk);
        }
        Integer num = this.zzpz;
        if (num != null) {
            zzjl.zze(2, num.intValue());
        }
        zzdo zzdo = this.zzqa;
        if (zzdo != null) {
            zzjl.zza(16, (zzjt) zzdo);
        }
        zzdj zzdj = this.zzqb;
        if (zzdj != null) {
            zzjl.zza(17, (zzjt) zzdj);
        }
        super.zza(zzjl);
    }

    /* access modifiers changed from: protected */
    public final int zzt() {
        int zzt = super.zzt();
        zzdk zzdk = this.zzpy;
        if (zzdk != null) {
            zzt += zzjl.zzb(1, (zzjt) zzdk);
        }
        Integer num = this.zzpz;
        if (num != null) {
            zzt += zzjl.zzi(2, num.intValue());
        }
        zzdo zzdo = this.zzqa;
        if (zzdo != null) {
            zzt += zzjl.zzb(16, (zzjt) zzdo);
        }
        zzdj zzdj = this.zzqb;
        return zzdj != null ? zzt + zzjl.zzb(17, (zzjt) zzdj) : zzt;
    }

    public final /* synthetic */ zzjt zza(zzjk zzjk) throws IOException {
        while (true) {
            int zzdq = zzjk.zzdq();
            if (zzdq == 0) {
                return this;
            }
            if (zzdq == 10) {
                if (this.zzpy == null) {
                    this.zzpy = new zzdk();
                }
                zzjk.zza((zzjt) this.zzpy);
            } else if (zzdq == 16) {
                this.zzpz = Integer.valueOf(zzjk.zzdt());
            } else if (zzdq == 130) {
                if (this.zzqa == null) {
                    this.zzqa = new zzdo();
                }
                zzjk.zza((zzjt) this.zzqa);
            } else if (zzdq == 138) {
                if (this.zzqb == null) {
                    this.zzqb = new zzdj();
                }
                zzjk.zza((zzjt) this.zzqb);
            } else if (!super.zza(zzjk, zzdq)) {
                return this;
            }
        }
    }
}
