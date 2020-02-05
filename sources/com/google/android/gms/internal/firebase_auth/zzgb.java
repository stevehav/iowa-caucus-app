package com.google.android.gms.internal.firebase_auth;

import androidx.annotation.Nullable;
import com.google.android.gms.common.util.Strings;
import com.google.android.gms.internal.firebase_auth.zzp;
import com.google.firebase.auth.api.internal.zzea;

/* compiled from: com.google.firebase:firebase-auth@@18.1.0 */
public final class zzgb implements zzea<zzgb, zzp.zzx> {
    private String zza;
    private String zzb;
    private long zzc;
    private String zzd;
    private boolean zze;
    private String zzf;
    private String zzg;
    private long zzh;
    private String zzi;

    @Nullable
    public final String zzb() {
        return this.zza;
    }

    @Nullable
    public final String zzc() {
        return this.zzb;
    }

    public final long zzd() {
        return this.zzc;
    }

    public final boolean zze() {
        return this.zze;
    }

    @Nullable
    public final String zzf() {
        return this.zzf;
    }

    @Nullable
    public final String zzg() {
        return this.zzi;
    }

    public final zzjq<zzp.zzx> zza() {
        return zzp.zzx.zzj();
    }

    public final /* synthetic */ zzea zza(zzjg zzjg) {
        if (zzjg instanceof zzp.zzx) {
            zzp.zzx zzx = (zzp.zzx) zzjg;
            this.zza = Strings.emptyToNull(zzx.zza());
            this.zzb = Strings.emptyToNull(zzx.zzb());
            this.zzc = zzx.zzc();
            this.zzd = Strings.emptyToNull(zzx.zzd());
            this.zze = zzx.zze();
            this.zzf = Strings.emptyToNull(zzx.zzf());
            this.zzg = Strings.emptyToNull(zzx.zzg());
            this.zzh = zzx.zzh();
            this.zzi = zzx.zzi();
            return this;
        }
        throw new IllegalArgumentException("The passed proto must be an instance of verifyPhoneNumberResponse.");
    }
}
