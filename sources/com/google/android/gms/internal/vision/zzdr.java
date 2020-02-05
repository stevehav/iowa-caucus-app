package com.google.android.gms.internal.vision;

import java.io.IOException;

public final class zzdr extends zzjn<zzdr> {
    public String name = null;
    public String zzon = null;
    public Long zzpq = null;
    public zzdh zzpr = null;
    public zzdn zzps = null;
    private zzdi zzpt = null;

    public zzdr() {
        this.zzadp = -1;
    }

    public final void zza(zzjl zzjl) throws IOException {
        String str = this.name;
        if (str != null) {
            zzjl.zza(1, str);
        }
        Long l = this.zzpq;
        if (l != null) {
            zzjl.zzi(2, l.longValue());
        }
        zzdh zzdh = this.zzpr;
        if (zzdh != null) {
            zzjl.zza(3, (zzjt) zzdh);
        }
        String str2 = this.zzon;
        if (str2 != null) {
            zzjl.zza(6, str2);
        }
        zzdn zzdn = this.zzps;
        if (zzdn != null) {
            zzjl.zza(16, (zzjt) zzdn);
        }
        zzdi zzdi = this.zzpt;
        if (zzdi != null) {
            zzjl.zza(17, (zzjt) zzdi);
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
        Long l = this.zzpq;
        if (l != null) {
            zzt += zzjl.zzd(2, l.longValue());
        }
        zzdh zzdh = this.zzpr;
        if (zzdh != null) {
            zzt += zzjl.zzb(3, (zzjt) zzdh);
        }
        String str2 = this.zzon;
        if (str2 != null) {
            zzt += zzjl.zzb(6, str2);
        }
        zzdn zzdn = this.zzps;
        if (zzdn != null) {
            zzt += zzjl.zzb(16, (zzjt) zzdn);
        }
        zzdi zzdi = this.zzpt;
        return zzdi != null ? zzt + zzjl.zzb(17, (zzjt) zzdi) : zzt;
    }

    public final /* synthetic */ zzjt zza(zzjk zzjk) throws IOException {
        while (true) {
            int zzdq = zzjk.zzdq();
            if (zzdq == 0) {
                return this;
            }
            if (zzdq == 10) {
                this.name = zzjk.readString();
            } else if (zzdq == 16) {
                this.zzpq = Long.valueOf(zzjk.zzdu());
            } else if (zzdq == 26) {
                if (this.zzpr == null) {
                    this.zzpr = new zzdh();
                }
                zzjk.zza((zzjt) this.zzpr);
            } else if (zzdq == 50) {
                this.zzon = zzjk.readString();
            } else if (zzdq == 130) {
                if (this.zzps == null) {
                    this.zzps = new zzdn();
                }
                zzjk.zza((zzjt) this.zzps);
            } else if (zzdq == 138) {
                if (this.zzpt == null) {
                    this.zzpt = new zzdi();
                }
                zzjk.zza((zzjt) this.zzpt);
            } else if (!super.zza(zzjk, zzdq)) {
                return this;
            }
        }
    }
}
