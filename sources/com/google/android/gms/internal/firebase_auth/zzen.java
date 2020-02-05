package com.google.android.gms.internal.firebase_auth;

import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.firebase_auth.zzp;
import com.google.firebase.auth.api.internal.zzfk;

/* compiled from: com.google.firebase:firebase-auth@@18.1.0 */
public final class zzen implements zzfk<zzp.zzf> {
    private String zza;

    public zzen(String str) {
        this.zza = Preconditions.checkNotEmpty(str);
    }

    public final /* synthetic */ zzjg zza() {
        return (zzp.zzf) ((zzhx) zzp.zzf.zza().zza(this.zza).zzf());
    }
}
