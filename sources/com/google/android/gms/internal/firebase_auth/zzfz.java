package com.google.android.gms.internal.firebase_auth;

import android.text.TextUtils;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.firebase_auth.zzp;
import com.google.firebase.auth.api.internal.zzfk;

/* compiled from: com.google.firebase:firebase-auth@@18.1.0 */
public final class zzfz implements zzfk<zzp.zzw> {
    private boolean zza;
    private String zzb;
    private String zzc;
    private String zzd;
    private String zze;
    private String zzf;
    private boolean zzg;

    private zzfz() {
    }

    public static zzfz zza(String str, String str2, boolean z) {
        zzfz zzfz = new zzfz();
        zzfz.zza = false;
        zzfz.zzc = Preconditions.checkNotEmpty(str);
        zzfz.zzd = Preconditions.checkNotEmpty(str2);
        zzfz.zzg = z;
        return zzfz;
    }

    public static zzfz zzb(String str, String str2, boolean z) {
        zzfz zzfz = new zzfz();
        zzfz.zza = false;
        zzfz.zzb = Preconditions.checkNotEmpty(str);
        zzfz.zze = Preconditions.checkNotEmpty(str2);
        zzfz.zzg = z;
        return zzfz;
    }

    public final void zza(String str) {
        this.zzf = str;
    }

    public final /* synthetic */ zzjg zza() {
        zzp.zzw.zza zza2 = zzp.zzw.zza();
        if (!TextUtils.isEmpty(this.zze)) {
            zza2.zzd(this.zze).zzb(this.zzb);
        } else {
            zza2.zza(this.zzc).zzc(this.zzd);
        }
        String str = this.zzf;
        if (str != null) {
            zza2.zze(str);
        }
        if (!this.zzg) {
            zza2.zza(zzaa.REAUTH);
        }
        return (zzp.zzw) ((zzhx) zza2.zzf());
    }
}
