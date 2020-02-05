package com.google.firebase.auth.api.internal;

import android.content.Context;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.logging.Logger;
import com.google.android.gms.internal.firebase_auth.zzeb;
import com.google.android.gms.internal.firebase_auth.zzeg;
import com.google.android.gms.internal.firebase_auth.zzei;
import com.google.android.gms.internal.firebase_auth.zzej;
import com.google.android.gms.internal.firebase_auth.zzem;
import com.google.android.gms.internal.firebase_auth.zzen;
import com.google.android.gms.internal.firebase_auth.zzeo;
import com.google.android.gms.internal.firebase_auth.zzeq;
import com.google.android.gms.internal.firebase_auth.zzes;
import com.google.android.gms.internal.firebase_auth.zzew;
import com.google.android.gms.internal.firebase_auth.zzey;
import com.google.android.gms.internal.firebase_auth.zzff;
import com.google.android.gms.internal.firebase_auth.zzfg;
import com.google.android.gms.internal.firebase_auth.zzfk;
import com.google.android.gms.internal.firebase_auth.zzfl;
import com.google.android.gms.internal.firebase_auth.zzfm;
import com.google.android.gms.internal.firebase_auth.zzfn;
import com.google.android.gms.internal.firebase_auth.zzfo;
import com.google.android.gms.internal.firebase_auth.zzfq;
import com.google.android.gms.internal.firebase_auth.zzfr;
import com.google.android.gms.internal.firebase_auth.zzft;
import com.google.android.gms.internal.firebase_auth.zzfv;
import com.google.android.gms.internal.firebase_auth.zzfw;
import com.google.android.gms.internal.firebase_auth.zzfx;
import com.google.android.gms.internal.firebase_auth.zzfz;
import com.google.android.gms.internal.firebase_auth.zzga;
import com.google.android.gms.internal.firebase_auth.zzgb;
import com.google.android.gms.internal.firebase_auth.zzgd;
import com.google.firebase.FirebaseError;
import com.google.firebase.auth.ActionCodeSettings;
import com.google.firebase.auth.EmailAuthCredential;
import com.google.firebase.auth.UserProfileChangeRequest;
import com.google.firebase.auth.internal.zzy;
import com.google.firebase.auth.zzg;

/* compiled from: com.google.firebase:firebase-auth@@18.1.0 */
public final class zza {
    /* access modifiers changed from: private */
    public static final Logger zza = new Logger("FBAuthApiDispatcher", new String[0]);
    /* access modifiers changed from: private */
    public final zzfc zzb;
    /* access modifiers changed from: private */
    public final zzar zzc;

    public zza(zzfc zzfc, zzar zzar) {
        this.zzb = (zzfc) Preconditions.checkNotNull(zzfc);
        this.zzc = (zzar) Preconditions.checkNotNull(zzar);
    }

    public final void zza(String str, zzdr zzdr) {
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotNull(zzdr);
        this.zzb.zza(new zzeo(str), (zzfe<zzey>) new zzc(this, zzdr));
    }

    public final void zza(zzfw zzfw, zzdr zzdr) {
        Preconditions.checkNotNull(zzfw);
        Preconditions.checkNotNull(zzdr);
        this.zzb.zza(zzfw, (zzfe<zzfv>) new zzl(this, zzdr));
    }

    public final void zza(Context context, zzfr zzfr, zzdr zzdr) {
        Preconditions.checkNotNull(zzfr);
        Preconditions.checkNotNull(zzdr);
        if (this.zzc.zza()) {
            zzfr.zzc(true);
        }
        this.zzb.zza((Context) null, zzfr, (zzfe<zzft>) new zzx(this, zzdr));
    }

    public final void zzb(@Nullable String str, zzdr zzdr) {
        Preconditions.checkNotNull(zzdr);
        this.zzb.zza(new zzfn(str), (zzfe<zzfq>) new zzag(this, zzdr));
    }

    public final void zza(String str, UserProfileChangeRequest userProfileChangeRequest, zzdr zzdr) {
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotNull(userProfileChangeRequest);
        Preconditions.checkNotNull(zzdr);
        zza(str, (zzfe<zzey>) new zzaf(this, userProfileChangeRequest, zzdr));
    }

    public final void zza(String str, String str2, zzdr zzdr) {
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotEmpty(str2);
        Preconditions.checkNotNull(zzdr);
        zza(str, (zzfe<zzey>) new zzai(this, str2, zzdr));
    }

    public final void zzb(String str, String str2, zzdr zzdr) {
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotEmpty(str2);
        Preconditions.checkNotNull(zzdr);
        zza(str, (zzfe<zzey>) new zzah(this, str2, zzdr));
    }

    public final void zzc(String str, @Nullable String str2, zzdr zzdr) {
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotNull(zzdr);
        zzfl zzfl = new zzfl();
        zzfl.zzh(str);
        zzfl.zzi(str2);
        this.zzb.zza(zzfl, (zzfe<zzfo>) new zzak(this, zzdr));
    }

    private final void zza(String str, zzfe<zzey> zzfe) {
        Preconditions.checkNotNull(zzfe);
        Preconditions.checkNotEmpty(str);
        zzey zzb2 = zzey.zzb(str);
        if (zzb2.zzb()) {
            zzfe.zza(zzb2);
            return;
        }
        this.zzb.zza(new zzeo(zzb2.zzc()), (zzfe<zzey>) new zzaj(this, zzfe));
    }

    public final void zza(String str, String str2, @Nullable String str3, zzdr zzdr) {
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotEmpty(str2);
        Preconditions.checkNotNull(zzdr);
        this.zzb.zza(new zzfn(str, str2, (String) null, str3), (zzfe<zzfq>) new zzb(this, zzdr));
    }

    public final void zza(Context context, String str, String str2, @Nullable String str3, zzdr zzdr) {
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotEmpty(str2);
        Preconditions.checkNotNull(zzdr);
        this.zzb.zza((Context) null, new zzfx(str, str2, str3), (zzfe<zzga>) new zze(this, zzdr));
    }

    public final void zza(EmailAuthCredential emailAuthCredential, zzdr zzdr) {
        Preconditions.checkNotNull(emailAuthCredential);
        Preconditions.checkNotNull(zzdr);
        if (emailAuthCredential.zze()) {
            zza(emailAuthCredential.zzd(), (zzfe<zzey>) new zzd(this, emailAuthCredential, zzdr));
        } else {
            zza(new zzej(emailAuthCredential, (String) null), zzdr);
        }
    }

    /* access modifiers changed from: private */
    public final void zza(zzej zzej, zzdr zzdr) {
        Preconditions.checkNotNull(zzej);
        Preconditions.checkNotNull(zzdr);
        this.zzb.zza(zzej, (zzfe<zzem>) new zzg(this, zzdr));
    }

    /* access modifiers changed from: private */
    public final void zza(zzdr zzdr, zzey zzey, zzfl zzfl, zzfb zzfb) {
        Preconditions.checkNotNull(zzdr);
        Preconditions.checkNotNull(zzey);
        Preconditions.checkNotNull(zzfl);
        Preconditions.checkNotNull(zzfb);
        this.zzb.zza(new zzen(zzey.zzd()), (zzfe<zzeq>) new zzf(this, zzfb, zzdr, zzey, zzfl));
    }

    /* access modifiers changed from: private */
    public final void zza(zzdr zzdr, zzey zzey, zzes zzes, zzfl zzfl, zzfb zzfb) {
        Preconditions.checkNotNull(zzdr);
        Preconditions.checkNotNull(zzey);
        Preconditions.checkNotNull(zzes);
        Preconditions.checkNotNull(zzfl);
        Preconditions.checkNotNull(zzfb);
        this.zzb.zza(zzfl, (zzfe<zzfo>) new zzi(this, zzfl, zzes, zzdr, zzey, zzfb));
    }

    /* access modifiers changed from: private */
    public static zzey zza(zzey zzey, zzfo zzfo) {
        Preconditions.checkNotNull(zzey);
        Preconditions.checkNotNull(zzfo);
        String zzb2 = zzfo.zzb();
        String zzc2 = zzfo.zzc();
        return (TextUtils.isEmpty(zzb2) || TextUtils.isEmpty(zzc2)) ? zzey : new zzey(zzc2, zzb2, Long.valueOf(zzfo.zzd()), zzey.zzf());
    }

    /* access modifiers changed from: private */
    public final void zza(zzey zzey, @Nullable String str, @Nullable String str2, @Nullable Boolean bool, @Nullable zzg zzg, zzdr zzdr, zzfb zzfb) {
        Preconditions.checkNotNull(zzey);
        Preconditions.checkNotNull(zzfb);
        Preconditions.checkNotNull(zzdr);
        this.zzb.zza(new zzen(zzey.zzd()), (zzfe<zzeq>) new zzh(this, zzfb, str2, str, bool, zzg, zzdr, zzey));
    }

    public final void zzd(String str, @Nullable String str2, zzdr zzdr) {
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotNull(zzdr);
        this.zzb.zza(new zzeg(str, str2), (zzfe<zzei>) new zzk(this, zzdr));
    }

    public final void zza(String str, ActionCodeSettings actionCodeSettings, @Nullable String str2, zzdr zzdr) {
        zzew zzew;
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotNull(zzdr);
        zzgd zza2 = zzgd.zza(actionCodeSettings.zzd());
        if (zza2 != null) {
            zzew = new zzew(zza2);
        } else {
            zzew = new zzew(zzgd.OOB_REQ_TYPE_UNSPECIFIED);
        }
        zzew.zza(str);
        zzew.zza(actionCodeSettings);
        zzew.zzc(str2);
        this.zzb.zza(zzew, (zzfe<Object>) new zzj(this, zzdr));
    }

    public final void zza(String str, @Nullable ActionCodeSettings actionCodeSettings, zzdr zzdr) {
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotNull(zzdr);
        zzew zzew = new zzew(zzgd.VERIFY_EMAIL);
        zzew.zzb(str);
        if (actionCodeSettings != null) {
            zzew.zza(actionCodeSettings);
        }
        zzb(zzew, zzdr);
    }

    public final void zze(String str, @Nullable String str2, zzdr zzdr) {
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotNull(zzdr);
        this.zzb.zza(new zzfg(str, (String) null, str2), (zzfe<zzff>) new zzm(this, zzdr));
    }

    public final void zzb(String str, String str2, @Nullable String str3, zzdr zzdr) {
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotEmpty(str2);
        Preconditions.checkNotNull(zzdr);
        this.zzb.zza(new zzfg(str, str2, str3), (zzfe<zzff>) new zzo(this, zzdr));
    }

    public final void zza(zzfk zzfk, zzdr zzdr) {
        Preconditions.checkNotEmpty(zzfk.zzb());
        Preconditions.checkNotNull(zzdr);
        this.zzb.zza(zzfk, (zzfe<zzfm>) new zzn(this, zzdr));
    }

    public final void zza(Context context, zzfz zzfz, zzdr zzdr) {
        Preconditions.checkNotNull(zzfz);
        Preconditions.checkNotNull(zzdr);
        this.zzb.zza((Context) null, zzfz, (zzfe<zzgb>) new zzq(this, zzdr));
    }

    public final void zzc(String str, String str2, String str3, zzdr zzdr) {
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotEmpty(str2);
        Preconditions.checkNotEmpty(str3);
        Preconditions.checkNotNull(zzdr);
        zza(str3, (zzfe<zzey>) new zzp(this, str, str2, zzdr));
    }

    public final void zza(Context context, String str, zzfz zzfz, zzdr zzdr) {
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotNull(zzfz);
        Preconditions.checkNotNull(zzdr);
        zza(str, (zzfe<zzey>) new zzs(this, zzfz, (Context) null, zzdr));
    }

    public final void zza(String str, zzfr zzfr, zzdr zzdr) {
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotNull(zzfr);
        Preconditions.checkNotNull(zzdr);
        zza(str, (zzfe<zzey>) new zzu(this, zzfr, zzdr));
    }

    public final void zzc(String str, zzdr zzdr) {
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotNull(zzdr);
        zza(str, (zzfe<zzey>) new zzw(this, zzdr));
    }

    public final void zzf(String str, String str2, zzdr zzdr) {
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotEmpty(str2);
        Preconditions.checkNotNull(zzdr);
        zza(str2, (zzfe<zzey>) new zzv(this, str, zzdr));
    }

    public final void zza(zzew zzew, zzdr zzdr) {
        zzb(zzew, zzdr);
    }

    public final void zzd(String str, zzdr zzdr) {
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotNull(zzdr);
        zza(str, (zzfe<zzey>) new zzaa(this, zzdr));
    }

    public final void zze(String str, zzdr zzdr) {
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotNull(zzdr);
        zza(str, (zzfe<zzey>) new zzac(this, zzdr));
    }

    public final void zzf(@Nullable String str, zzdr zzdr) {
        Preconditions.checkNotNull(zzdr);
        this.zzb.zza(str, (zzfe<Void>) new zzae(this, zzdr));
    }

    private final void zzb(zzew zzew, zzdr zzdr) {
        Preconditions.checkNotNull(zzew);
        Preconditions.checkNotNull(zzdr);
        this.zzb.zza(zzew, (zzfe<Object>) new zzad(this, zzdr));
    }

    /* access modifiers changed from: private */
    public final void zza(zzft zzft, zzdr zzdr, zzfb zzfb) {
        Status status;
        if (zzft.zzk()) {
            zzg zzp = zzft.zzp();
            String zzd = zzft.zzd();
            String zzl = zzft.zzl();
            if (zzft.zzb()) {
                status = new Status(FirebaseError.ERROR_ACCOUNT_EXISTS_WITH_DIFFERENT_CREDENTIAL);
            } else {
                status = zzy.zza(zzft.zzj());
            }
            if (this.zzc.zza()) {
                zzdr.zza(new zzeb(status, zzp, zzd, zzl));
            } else {
                zzdr.zza(status);
            }
        } else {
            zza(new zzey(zzft.zzg(), zzft.zzc(), Long.valueOf(zzft.zzh()), "Bearer"), zzft.zzf(), zzft.zze(), Boolean.valueOf(zzft.zzi()), zzft.zzp(), zzdr, zzfb);
        }
    }
}
