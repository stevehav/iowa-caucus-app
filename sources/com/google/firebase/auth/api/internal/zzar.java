package com.google.firebase.auth.api.internal;

/* compiled from: com.google.firebase:firebase-auth@@18.1.0 */
public final class zzar {
    private final zzdy zza;
    private final zzel zzb;

    public zzar(zzdy zzdy, zzel zzel) {
        this.zza = zzdy;
        this.zzb = zzel;
    }

    public final boolean zza() {
        return this.zza.zza().booleanValue() && this.zzb.zza();
    }

    public final boolean zzb() {
        return this.zza.zzb().booleanValue() && this.zzb.zza(this.zza.zzc());
    }
}
