package com.google.android.gms.internal.firebase_auth;

import com.google.android.gms.internal.firebase_auth.zzp;
import com.google.firebase.auth.api.internal.zzea;

/* compiled from: com.google.firebase:firebase-auth@@18.1.0 */
public final class zzfm implements zzea<zzfm, zzp.zzl> {
    private String zza;

    public final String zzb() {
        return this.zza;
    }

    public final zzjq<zzp.zzl> zza() {
        return zzp.zzl.zzb();
    }

    public final /* synthetic */ zzea zza(zzjg zzjg) {
        if (zzjg instanceof zzp.zzl) {
            this.zza = ((zzp.zzl) zzjg).zza();
            return this;
        }
        throw new IllegalArgumentException("The passed proto must be an instance of SendVerificationCodeResponse.");
    }
}
