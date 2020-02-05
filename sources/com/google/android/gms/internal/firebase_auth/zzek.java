package com.google.android.gms.internal.firebase_auth;

import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.firebase_auth.zzp;
import com.google.firebase.auth.api.internal.zzfk;

/* compiled from: com.google.firebase:firebase-auth@@18.1.0 */
public final class zzek implements zzfk<zzp.zzc> {
    private String zza;

    public zzek(String str) {
        this.zza = Preconditions.checkNotEmpty(str);
    }

    public final /* synthetic */ zzjg zza() {
        return (zzp.zzc) ((zzhx) zzp.zzc.zza().zza(this.zza).zzf());
    }
}
