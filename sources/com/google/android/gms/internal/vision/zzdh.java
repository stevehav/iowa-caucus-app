package com.google.android.gms.internal.vision;

import java.io.IOException;

public final class zzdh extends zzjn<zzdh> {
    public String version = null;
    public String zzod = null;

    public zzdh() {
        this.zzadp = -1;
    }

    public final void zza(zzjl zzjl) throws IOException {
        String str = this.zzod;
        if (str != null) {
            zzjl.zza(1, str);
        }
        String str2 = this.version;
        if (str2 != null) {
            zzjl.zza(2, str2);
        }
        super.zza(zzjl);
    }

    /* access modifiers changed from: protected */
    public final int zzt() {
        int zzt = super.zzt();
        String str = this.zzod;
        if (str != null) {
            zzt += zzjl.zzb(1, str);
        }
        String str2 = this.version;
        return str2 != null ? zzt + zzjl.zzb(2, str2) : zzt;
    }

    public final /* synthetic */ zzjt zza(zzjk zzjk) throws IOException {
        while (true) {
            int zzdq = zzjk.zzdq();
            if (zzdq == 0) {
                return this;
            }
            if (zzdq == 10) {
                this.zzod = zzjk.readString();
            } else if (zzdq == 18) {
                this.version = zzjk.readString();
            } else if (!super.zza(zzjk, zzdq)) {
                return this;
            }
        }
    }
}
