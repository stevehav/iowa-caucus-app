package com.google.android.gms.internal.firebase_auth;

import androidx.annotation.Nullable;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.firebase_auth.zzp;
import com.google.firebase.auth.api.internal.zzfk;

/* compiled from: com.google.firebase:firebase-auth@@18.1.0 */
public final class zzfn implements zzfk<zzp.zzo> {
    private String zza;
    private String zzb;
    @Nullable
    private String zzc;
    @Nullable
    private String zzd;

    public zzfn(@Nullable String str) {
        this.zzd = str;
    }

    public zzfn(String str, String str2, @Nullable String str3, @Nullable String str4) {
        this.zza = Preconditions.checkNotEmpty(str);
        this.zzb = Preconditions.checkNotEmpty(str2);
        this.zzc = null;
        this.zzd = str4;
    }

    public final /* synthetic */ zzjg zza() {
        zzp.zzo.zza zza2 = zzp.zzo.zza();
        String str = this.zza;
        if (str != null) {
            zza2.zza(str);
        }
        String str2 = this.zzb;
        if (str2 != null) {
            zza2.zzb(str2);
        }
        String str3 = this.zzd;
        if (str3 != null) {
            zza2.zzc(str3);
        }
        return (zzp.zzo) ((zzhx) zza2.zzf());
    }
}
