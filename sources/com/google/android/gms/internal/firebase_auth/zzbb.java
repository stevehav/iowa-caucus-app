package com.google.android.gms.internal.firebase_auth;

import java.util.List;

/* compiled from: com.google.firebase:firebase-auth@@18.1.0 */
final class zzbb extends zzaz<E> {
    private final transient int zza;
    private final transient int zzb;
    private final /* synthetic */ zzaz zzc;

    zzbb(zzaz zzaz, int i, int i2) {
        this.zzc = zzaz;
        this.zza = i;
        this.zzb = i2;
    }

    public final int size() {
        return this.zzb;
    }

    /* access modifiers changed from: package-private */
    public final Object[] zzd() {
        return this.zzc.zzd();
    }

    /* access modifiers changed from: package-private */
    public final int zze() {
        return this.zzc.zze() + this.zza;
    }

    /* access modifiers changed from: package-private */
    public final int zzf() {
        return this.zzc.zze() + this.zza + this.zzb;
    }

    public final E get(int i) {
        zzao.zza(i, this.zzb);
        return this.zzc.get(i + this.zza);
    }

    public final zzaz<E> zza(int i, int i2) {
        zzao.zza(i, i2, this.zzb);
        zzaz zzaz = this.zzc;
        int i3 = this.zza;
        return (zzaz) zzaz.subList(i + i3, i2 + i3);
    }

    public final /* synthetic */ List subList(int i, int i2) {
        return subList(i, i2);
    }
}
