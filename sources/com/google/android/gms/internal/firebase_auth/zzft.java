package com.google.android.gms.internal.firebase_auth;

import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.google.android.gms.common.util.Strings;
import com.google.android.gms.internal.firebase_auth.zzp;
import com.google.firebase.auth.api.internal.zzea;
import com.google.firebase.auth.zzg;
import java.util.ArrayList;
import java.util.List;

/* compiled from: com.google.firebase:firebase-auth@@18.1.0 */
public final class zzft implements zzea<zzft, zzp.zzr> {
    private boolean zza;
    private boolean zzb;
    private String zzc;
    private String zzd;
    private long zze;
    private String zzf;
    private String zzg;
    private String zzh;
    private String zzi;
    private String zzj;
    private String zzk;
    private boolean zzl;
    private String zzm;
    private String zzn;
    private String zzo;
    private String zzp;
    private String zzq;
    private String zzr;
    private List<zzfa> zzs;
    private String zzt;

    public final boolean zzb() {
        return this.zza;
    }

    public final String zzc() {
        return this.zzc;
    }

    public final String zzd() {
        return this.zzg;
    }

    public final String zze() {
        return this.zzj;
    }

    public final String zzf() {
        return this.zzk;
    }

    @Nullable
    public final String zzg() {
        return this.zzd;
    }

    public final long zzh() {
        return this.zze;
    }

    public final boolean zzi() {
        return this.zzl;
    }

    public final String zzj() {
        return this.zzp;
    }

    public final boolean zzk() {
        return this.zza || !TextUtils.isEmpty(this.zzp);
    }

    @Nullable
    public final String zzl() {
        return this.zzr;
    }

    public final List<zzfa> zzm() {
        return this.zzs;
    }

    public final String zzn() {
        return this.zzt;
    }

    public final boolean zzo() {
        return !TextUtils.isEmpty(this.zzt);
    }

    @Nullable
    public final zzg zzp() {
        if (!TextUtils.isEmpty(this.zzm) || !TextUtils.isEmpty(this.zzn)) {
            return zzg.zza(this.zzj, this.zzn, this.zzm, this.zzq, this.zzo);
        }
        return null;
    }

    public final zzjq<zzp.zzr> zza() {
        return zzp.zzr.zzu();
    }

    public final /* synthetic */ zzea zza(zzjg zzjg) {
        if (zzjg instanceof zzp.zzr) {
            zzp.zzr zzr2 = (zzp.zzr) zzjg;
            this.zza = zzr2.zzg();
            this.zzb = zzr2.zzi();
            this.zzc = Strings.emptyToNull(zzr2.zzf());
            this.zzd = Strings.emptyToNull(zzr2.zzk());
            this.zze = zzr2.zzl();
            this.zzf = Strings.emptyToNull(zzr2.zzd());
            this.zzg = Strings.emptyToNull(zzr2.zzb());
            this.zzh = Strings.emptyToNull(zzr2.zze());
            this.zzi = Strings.emptyToNull(zzr2.zzc());
            this.zzj = Strings.emptyToNull(zzr2.zza());
            this.zzk = Strings.emptyToNull(zzr2.zzn());
            this.zzl = zzr2.zzp();
            this.zzm = zzr2.zzh();
            this.zzn = zzr2.zzm();
            this.zzp = Strings.emptyToNull(zzr2.zzo());
            this.zzq = Strings.emptyToNull(zzr2.zzq());
            this.zzr = Strings.emptyToNull(zzr2.zzr());
            this.zzs = new ArrayList();
            for (zzr zza2 : zzr2.zzt()) {
                this.zzs.add(zzfa.zza(zza2));
            }
            this.zzt = Strings.emptyToNull(zzr2.zzs());
            this.zzo = Strings.emptyToNull(zzr2.zzj());
            return this;
        }
        throw new IllegalArgumentException("The passed proto must be an instance of VerifyAssertionResponse.");
    }
}
