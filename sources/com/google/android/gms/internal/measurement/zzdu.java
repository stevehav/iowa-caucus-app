package com.google.android.gms.internal.measurement;

import java.util.NoSuchElementException;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.0.1 */
final class zzdu extends zzdw {
    private int zza = 0;
    private final int zzb = this.zzc.zza();
    private final /* synthetic */ zzdv zzc;

    zzdu(zzdv zzdv) {
        this.zzc = zzdv;
    }

    public final boolean hasNext() {
        return this.zza < this.zzb;
    }

    public final byte zza() {
        int i = this.zza;
        if (i < this.zzb) {
            this.zza = i + 1;
            return this.zzc.zzb(i);
        }
        throw new NoSuchElementException();
    }
}
