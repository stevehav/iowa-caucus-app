package com.google.android.gms.internal.firebase_auth;

import androidx.annotation.Nullable;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.firebase_auth.zzp;
import com.google.firebase.auth.api.internal.zzfk;

/* compiled from: com.google.firebase:firebase-auth@@18.1.0 */
public final class zzfw implements zzfk<zzp.zzs> {
    private String zza;
    @Nullable
    private String zzb;

    public zzfw(String str, @Nullable String str2) {
        this.zza = Preconditions.checkNotEmpty(str);
        this.zzb = str2;
    }

    public final /* synthetic */ zzjg zza() {
        zzp.zzs.zza zza2 = zzp.zzs.zza().zza(this.zza).zza(true);
        String str = this.zzb;
        if (str != null) {
            zza2.zzb(str);
        }
        return (zzp.zzs) ((zzhx) zza2.zzf());
    }
}
