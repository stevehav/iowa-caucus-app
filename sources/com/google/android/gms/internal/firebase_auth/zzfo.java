package com.google.android.gms.internal.firebase_auth;

import androidx.annotation.Nullable;
import com.google.android.gms.common.util.Strings;
import com.google.android.gms.internal.firebase_auth.zzp;
import com.google.firebase.auth.api.internal.zzea;
import java.util.List;

/* compiled from: com.google.firebase:firebase-auth@@18.1.0 */
public final class zzfo implements zzea<zzfo, zzp.zzn> {
    private String zza;
    private String zzb;
    private Boolean zzc;
    private String zzd;
    private String zze;
    private zzfe zzf;
    private String zzg;
    private String zzh;
    private long zzi;

    @Nullable
    public final String zzb() {
        return this.zzg;
    }

    @Nullable
    public final String zzc() {
        return this.zzh;
    }

    public final long zzd() {
        return this.zzi;
    }

    @Nullable
    public final String zze() {
        return this.zza;
    }

    public final List<zzfc> zzf() {
        zzfe zzfe = this.zzf;
        if (zzfe != null) {
            return zzfe.zza();
        }
        return null;
    }

    public final zzjq<zzp.zzn> zza() {
        return zzp.zzn.zzj();
    }

    public final /* synthetic */ zzea zza(zzjg zzjg) {
        if (zzjg instanceof zzp.zzn) {
            zzp.zzn zzn = (zzp.zzn) zzjg;
            this.zza = Strings.emptyToNull(zzn.zza());
            this.zzb = Strings.emptyToNull(zzn.zzh());
            this.zzc = Boolean.valueOf(zzn.zzi());
            this.zzd = Strings.emptyToNull(zzn.zzb());
            this.zze = Strings.emptyToNull(zzn.zze());
            this.zzf = zzfe.zza(zzn.zzd());
            this.zzg = Strings.emptyToNull(zzn.zzc());
            this.zzh = Strings.emptyToNull(zzn.zzf());
            this.zzi = zzn.zzg();
            return this;
        }
        throw new IllegalArgumentException("The passed proto must be an instance of SetAccountInfoResponse.");
    }
}
