package com.google.android.gms.internal.firebase_auth;

import androidx.annotation.NonNull;
import com.google.android.gms.common.util.Strings;
import com.google.android.gms.internal.firebase_auth.zzp;
import com.google.firebase.auth.api.internal.zzea;

/* compiled from: com.google.firebase:firebase-auth@@18.1.0 */
public final class zzem implements zzea<zzem, zzp.zze> {
    private String zza;
    private String zzb;
    private String zzc;
    private String zzd;
    private boolean zze;
    private long zzf;

    @NonNull
    public final String zzb() {
        return this.zzc;
    }

    @NonNull
    public final String zzc() {
        return this.zzd;
    }

    public final boolean zzd() {
        return this.zze;
    }

    public final long zze() {
        return this.zzf;
    }

    public final zzjq<zzp.zze> zza() {
        return zzp.zze.zzg();
    }

    public final /* synthetic */ zzea zza(zzjg zzjg) {
        if (zzjg instanceof zzp.zze) {
            zzp.zze zze2 = (zzp.zze) zzjg;
            this.zza = Strings.emptyToNull(zze2.zze());
            this.zzb = Strings.emptyToNull(zze2.zzb());
            this.zzc = Strings.emptyToNull(zze2.zza());
            this.zzd = Strings.emptyToNull(zze2.zzc());
            this.zze = zze2.zzf();
            this.zzf = zze2.zzd();
            return this;
        }
        throw new IllegalArgumentException("The passed proto must be an instance of EmailLinkSigninResponse.");
    }
}
