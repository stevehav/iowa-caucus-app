package com.google.android.gms.internal.vision;

import java.io.IOException;

public final class zzdk extends zzjn<zzdk> {
    public zzds[] zzoh = zzds.zzcc();

    public zzdk() {
        this.zzadp = -1;
    }

    public final void zza(zzjl zzjl) throws IOException {
        zzds[] zzdsArr = this.zzoh;
        if (zzdsArr != null && zzdsArr.length > 0) {
            int i = 0;
            while (true) {
                zzds[] zzdsArr2 = this.zzoh;
                if (i >= zzdsArr2.length) {
                    break;
                }
                zzds zzds = zzdsArr2[i];
                if (zzds != null) {
                    zzjl.zza(1, (zzjt) zzds);
                }
                i++;
            }
        }
        super.zza(zzjl);
    }

    /* access modifiers changed from: protected */
    public final int zzt() {
        int zzt = super.zzt();
        zzds[] zzdsArr = this.zzoh;
        if (zzdsArr != null && zzdsArr.length > 0) {
            int i = 0;
            while (true) {
                zzds[] zzdsArr2 = this.zzoh;
                if (i >= zzdsArr2.length) {
                    break;
                }
                zzds zzds = zzdsArr2[i];
                if (zzds != null) {
                    zzt += zzjl.zzb(1, (zzjt) zzds);
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
                int zzb = zzjw.zzb(zzjk, 10);
                zzds[] zzdsArr = this.zzoh;
                int length = zzdsArr == null ? 0 : zzdsArr.length;
                zzds[] zzdsArr2 = new zzds[(zzb + length)];
                if (length != 0) {
                    System.arraycopy(this.zzoh, 0, zzdsArr2, 0, length);
                }
                while (length < zzdsArr2.length - 1) {
                    zzdsArr2[length] = new zzds();
                    zzjk.zza((zzjt) zzdsArr2[length]);
                    zzjk.zzdq();
                    length++;
                }
                zzdsArr2[length] = new zzds();
                zzjk.zza((zzjt) zzdsArr2[length]);
                this.zzoh = zzdsArr2;
            } else if (!super.zza(zzjk, zzdq)) {
                return this;
            }
        }
    }
}
