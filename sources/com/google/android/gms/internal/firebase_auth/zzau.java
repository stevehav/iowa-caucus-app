package com.google.android.gms.internal.firebase_auth;

/* compiled from: com.google.firebase:firebase-auth@@18.1.0 */
abstract class zzau extends zzae<String> {
    final CharSequence zza;
    private final zzaf zzb;
    private final boolean zzc;
    private int zzd = 0;
    private int zze;

    protected zzau(zzan zzan, CharSequence charSequence) {
        this.zzb = zzan.zza;
        this.zzc = false;
        this.zze = zzan.zzd;
        this.zza = charSequence;
    }

    /* access modifiers changed from: package-private */
    public abstract int zza(int i);

    /* access modifiers changed from: package-private */
    public abstract int zzb(int i);

    /* access modifiers changed from: protected */
    public final /* synthetic */ Object zza() {
        int i;
        int i2 = this.zzd;
        while (true) {
            int i3 = this.zzd;
            if (i3 != -1) {
                int zza2 = zza(i3);
                if (zza2 == -1) {
                    zza2 = this.zza.length();
                    this.zzd = -1;
                } else {
                    this.zzd = zzb(zza2);
                }
                int i4 = this.zzd;
                if (i4 == i2) {
                    this.zzd = i4 + 1;
                    if (this.zzd > this.zza.length()) {
                        this.zzd = -1;
                    }
                } else {
                    while (i2 < zza2 && this.zzb.zza(this.zza.charAt(i2))) {
                        i2++;
                    }
                    while (i > i2 && this.zzb.zza(this.zza.charAt(i - 1))) {
                        zza2 = i - 1;
                    }
                    if (!this.zzc || i2 != i) {
                        int i5 = this.zze;
                    } else {
                        i2 = this.zzd;
                    }
                }
            } else {
                zzb();
                return null;
            }
        }
        int i52 = this.zze;
        if (i52 == 1) {
            i = this.zza.length();
            this.zzd = -1;
            while (i > i2 && this.zzb.zza(this.zza.charAt(i - 1))) {
                i--;
            }
        } else {
            this.zze = i52 - 1;
        }
        return this.zza.subSequence(i2, i).toString();
    }
}
