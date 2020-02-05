package com.google.android.gms.internal.measurement;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.0.1 */
final class zzed {
    private final zzek zza;
    private final byte[] zzb;

    private zzed(int i) {
        this.zzb = new byte[i];
        this.zza = zzek.zza(this.zzb);
    }

    public final zzdv zza() {
        this.zza.zzb();
        return new zzef(this.zzb);
    }

    public final zzek zzb() {
        return this.zza;
    }

    /* synthetic */ zzed(int i, zzdu zzdu) {
        this(i);
    }
}
