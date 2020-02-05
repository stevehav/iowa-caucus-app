package com.google.android.gms.internal.vision;

import java.io.IOException;

public final class zzds extends zzjn<zzds> {
    private static volatile zzds[] zzpu;
    public Integer zzpv = null;
    public Integer zzpw = null;

    public static zzds[] zzcc() {
        if (zzpu == null) {
            synchronized (zzjr.zzado) {
                if (zzpu == null) {
                    zzpu = new zzds[0];
                }
            }
        }
        return zzpu;
    }

    public zzds() {
        this.zzadp = -1;
    }

    public final void zza(zzjl zzjl) throws IOException {
        Integer num = this.zzpv;
        if (num != null) {
            zzjl.zze(1, num.intValue());
        }
        Integer num2 = this.zzpw;
        if (num2 != null) {
            zzjl.zze(2, num2.intValue());
        }
        super.zza(zzjl);
    }

    /* access modifiers changed from: protected */
    public final int zzt() {
        int zzt = super.zzt();
        Integer num = this.zzpv;
        if (num != null) {
            zzt += zzjl.zzi(1, num.intValue());
        }
        Integer num2 = this.zzpw;
        return num2 != null ? zzt + zzjl.zzi(2, num2.intValue()) : zzt;
    }

    public final /* synthetic */ zzjt zza(zzjk zzjk) throws IOException {
        while (true) {
            int zzdq = zzjk.zzdq();
            if (zzdq == 0) {
                return this;
            }
            if (zzdq == 8) {
                this.zzpv = Integer.valueOf(zzjk.zzdt());
            } else if (zzdq == 16) {
                this.zzpw = Integer.valueOf(zzjk.zzdt());
            } else if (!super.zza(zzjk, zzdq)) {
                return this;
            }
        }
    }
}
