package com.google.android.gms.internal.firebase_auth;

import androidx.annotation.Nullable;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.firebase_auth.zzp;
import com.google.firebase.auth.api.internal.zzfk;

/* compiled from: com.google.firebase:firebase-auth@@18.1.0 */
public final class zzfg implements zzfk<zzp.zzi> {
    private final String zza;
    @Nullable
    private final String zzb;
    @Nullable
    private final String zzc;

    public zzfg(String str, @Nullable String str2, @Nullable String str3) {
        this.zza = Preconditions.checkNotEmpty(str);
        this.zzb = str2;
        this.zzc = str3;
    }

    public final /* synthetic */ zzjg zza() {
        zzp.zzi.zza zza2 = zzp.zzi.zza().zza(this.zza);
        String str = this.zzb;
        if (str != null) {
            zza2.zzb(str);
        }
        String str2 = this.zzc;
        if (str2 != null) {
            zza2.zzc(str2);
        }
        return (zzp.zzi) ((zzhx) zza2.zzf());
    }
}
