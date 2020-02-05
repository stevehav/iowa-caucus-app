package com.google.android.gms.internal.firebase_auth;

/* compiled from: com.google.firebase:firebase-auth@@18.1.0 */
final class zzar extends zzau {
    private final /* synthetic */ zzas zzb;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    zzar(zzas zzas, zzan zzan, CharSequence charSequence) {
        super(zzan, charSequence);
        this.zzb = zzas;
    }

    public final int zza(int i) {
        int length = this.zzb.zza.length();
        int length2 = this.zza.length() - length;
        while (i <= length2) {
            int i2 = 0;
            while (i2 < length) {
                if (this.zza.charAt(i2 + i) == this.zzb.zza.charAt(i2)) {
                    i2++;
                } else {
                    i++;
                }
            }
            return i;
        }
        return -1;
    }

    public final int zzb(int i) {
        return i + this.zzb.zza.length();
    }
}
