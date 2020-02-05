package com.google.android.gms.internal.firebase_auth;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.google.android.gms.common.util.Strings;
import com.google.android.gms.internal.firebase_auth.zzp;
import com.google.firebase.auth.api.internal.zzea;
import java.util.ArrayList;
import java.util.List;

/* compiled from: com.google.firebase:firebase-auth@@18.1.0 */
public final class zzga implements zzea<zzga, zzp.zzv> {
    private String zza;
    private String zzb;
    private String zzc;
    private String zzd;
    private String zze;
    private String zzf;
    private long zzg;
    private List<zzfa> zzh;
    private String zzi;

    @NonNull
    public final String zzb() {
        return this.zzd;
    }

    @NonNull
    public final String zzc() {
        return this.zzf;
    }

    public final long zzd() {
        return this.zzg;
    }

    public final List<zzfa> zze() {
        return this.zzh;
    }

    public final String zzf() {
        return this.zzi;
    }

    public final boolean zzg() {
        return !TextUtils.isEmpty(this.zzi);
    }

    public final zzjq<zzp.zzv> zza() {
        return zzp.zzv.zzj();
    }

    public final /* synthetic */ zzea zza(zzjg zzjg) {
        if (zzjg instanceof zzp.zzv) {
            zzp.zzv zzv = (zzp.zzv) zzjg;
            this.zza = Strings.emptyToNull(zzv.zza());
            this.zzb = Strings.emptyToNull(zzv.zzb());
            this.zzc = Strings.emptyToNull(zzv.zzc());
            this.zzd = Strings.emptyToNull(zzv.zzd());
            this.zze = Strings.emptyToNull(zzv.zze());
            this.zzf = Strings.emptyToNull(zzv.zzf());
            this.zzg = zzv.zzg();
            this.zzh = new ArrayList();
            for (zzr zza2 : zzv.zzi()) {
                this.zzh.add(zzfa.zza(zza2));
            }
            this.zzi = zzv.zzh();
            return this;
        }
        throw new IllegalArgumentException("The passed proto must be an instance of VerifyPasswordResponse.");
    }
}
