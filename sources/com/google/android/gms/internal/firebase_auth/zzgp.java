package com.google.android.gms.internal.firebase_auth;

import java.util.NoSuchElementException;

/* compiled from: com.google.firebase:firebase-auth@@18.1.0 */
final class zzgp extends zzgr {
    private int zza = 0;
    private final int zzb = this.zzc.zza();
    private final /* synthetic */ zzgm zzc;

    zzgp(zzgm zzgm) {
        this.zzc = zzgm;
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
