package com.google.firebase.auth.api.internal;

import android.app.Activity;
import android.content.Context;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.internal.firebase_auth.zzes;
import com.google.android.gms.internal.firebase_auth.zzf;
import com.google.android.gms.internal.firebase_auth.zzfc;
import com.google.android.gms.internal.firebase_auth.zzfk;
import com.google.android.gms.internal.firebase_auth.zzgd;
import com.google.android.gms.internal.firebase_auth.zzk;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseError;
import com.google.firebase.auth.ActionCodeResult;
import com.google.firebase.auth.ActionCodeSettings;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.EmailAuthCredential;
import com.google.firebase.auth.FirebaseAuthProvider;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.GetTokenResult;
import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.PhoneAuthProvider;
import com.google.firebase.auth.SignInMethodQueryResult;
import com.google.firebase.auth.UserProfileChangeRequest;
import com.google.firebase.auth.internal.zza;
import com.google.firebase.auth.internal.zzab;
import com.google.firebase.auth.internal.zzae;
import com.google.firebase.auth.internal.zzar;
import com.google.firebase.auth.internal.zzaz;
import com.google.firebase.auth.internal.zzj;
import com.google.firebase.auth.internal.zzn;
import com.google.firebase.auth.internal.zzp;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.Future;

/* compiled from: com.google.firebase:firebase-auth@@18.1.0 */
public final class zzau extends zzam {
    private final Context zza;
    private final zzej zzb;
    private final Future<zzal<zzej>> zzc = zza();

    zzau(Context context, zzej zzej) {
        this.zza = context;
        this.zzb = zzej;
    }

    /* access modifiers changed from: package-private */
    public final Future<zzal<zzej>> zza() {
        Future<zzal<zzej>> future = this.zzc;
        if (future != null) {
            return future;
        }
        return zzf.zza().zza(zzk.zza).submit(new zzds(this.zzb, this.zza));
    }

    public final Task<GetTokenResult> zza(FirebaseApp firebaseApp, FirebaseUser firebaseUser, String str, zzaz zzaz) {
        zzbi zzbi = (zzbi) new zzbi(str).zza(firebaseApp).zza(firebaseUser).zza(zzaz).zza((zzae) zzaz);
        return zza(zza(zzbi), zzbi);
    }

    public final Task<AuthResult> zza(FirebaseApp firebaseApp, String str, @Nullable String str2, zza zza2) {
        zzcu zzcu = (zzcu) new zzcu(str, str2).zza(firebaseApp).zza(zza2);
        return zza(zzb(zzcu), zzcu);
    }

    public final Task<AuthResult> zza(FirebaseApp firebaseApp, AuthCredential authCredential, @Nullable String str, zza zza2) {
        zzcs zzcs = (zzcs) new zzcs(authCredential, str).zza(firebaseApp).zza(zza2);
        return zza(zzb(zzcs), zzcs);
    }

    public final Task<Void> zza(FirebaseApp firebaseApp, FirebaseUser firebaseUser, AuthCredential authCredential, @Nullable String str, zzaz zzaz) {
        zzbs zzbs = (zzbs) new zzbs(authCredential, str).zza(firebaseApp).zza(firebaseUser).zza(zzaz).zza((zzae) zzaz);
        return zza(zzb(zzbs), zzbs);
    }

    public final Task<AuthResult> zzb(FirebaseApp firebaseApp, FirebaseUser firebaseUser, AuthCredential authCredential, @Nullable String str, zzaz zzaz) {
        zzbu zzbu = (zzbu) new zzbu(authCredential, str).zza(firebaseApp).zza(firebaseUser).zza(zzaz).zza((zzae) zzaz);
        return zza(zzb(zzbu), zzbu);
    }

    public final Task<AuthResult> zza(FirebaseApp firebaseApp, zza zza2, @Nullable String str) {
        zzcq zzcq = (zzcq) new zzcq(str).zza(firebaseApp).zza(zza2);
        return zza(zzb(zzcq), zzcq);
    }

    public final void zza(FirebaseApp firebaseApp, zzfk zzfk, PhoneAuthProvider.OnVerificationStateChangedCallbacks onVerificationStateChangedCallbacks, @Nullable Activity activity, Executor executor) {
        zzdq zzdq = (zzdq) new zzdq(zzfk).zza(firebaseApp).zza(onVerificationStateChangedCallbacks, activity, executor);
        zza(zzb(zzdq), zzdq);
    }

    public final Task<Void> zza(FirebaseApp firebaseApp, FirebaseUser firebaseUser, UserProfileChangeRequest userProfileChangeRequest, zzaz zzaz) {
        zzdm zzdm = (zzdm) new zzdm(userProfileChangeRequest).zza(firebaseApp).zza(firebaseUser).zza(zzaz).zza((zzae) zzaz);
        return zza(zzb(zzdm), zzdm);
    }

    public final Task<Void> zzb(FirebaseApp firebaseApp, FirebaseUser firebaseUser, String str, zzaz zzaz) {
        zzdg zzdg = (zzdg) new zzdg(str).zza(firebaseApp).zza(firebaseUser).zza(zzaz).zza((zzae) zzaz);
        return zza(zzb(zzdg), zzdg);
    }

    public final Task<Void> zzc(FirebaseApp firebaseApp, FirebaseUser firebaseUser, String str, zzaz zzaz) {
        zzdi zzdi = (zzdi) new zzdi(str).zza(firebaseApp).zza(firebaseUser).zza(zzaz).zza((zzae) zzaz);
        return zza(zzb(zzdi), zzdi);
    }

    public final Task<Void> zza(FirebaseApp firebaseApp, FirebaseUser firebaseUser, PhoneAuthCredential phoneAuthCredential, zzaz zzaz) {
        zzdk zzdk = (zzdk) new zzdk(phoneAuthCredential).zza(firebaseApp).zza(firebaseUser).zza(zzaz).zza((zzae) zzaz);
        return zza(zzb(zzdk), zzdk);
    }

    public final Task<AuthResult> zza(FirebaseApp firebaseApp, String str, String str2, String str3, zza zza2) {
        zzbc zzbc = (zzbc) new zzbc(str, str2, str3).zza(firebaseApp).zza(zza2);
        return zza(zzb(zzbc), zzbc);
    }

    public final Task<AuthResult> zzb(FirebaseApp firebaseApp, String str, String str2, @Nullable String str3, zza zza2) {
        zzcw zzcw = (zzcw) new zzcw(str, str2, str3).zza(firebaseApp).zza(zza2);
        return zza(zzb(zzcw), zzcw);
    }

    public final Task<AuthResult> zza(FirebaseApp firebaseApp, EmailAuthCredential emailAuthCredential, zza zza2) {
        zzcy zzcy = (zzcy) new zzcy(emailAuthCredential).zza(firebaseApp).zza(zza2);
        return zza(zzb(zzcy), zzcy);
    }

    public final Task<Void> zza(FirebaseApp firebaseApp, FirebaseUser firebaseUser, String str, String str2, @Nullable String str3, zzaz zzaz) {
        zzca zzca = (zzca) new zzca(str, str2, str3).zza(firebaseApp).zza(firebaseUser).zza(zzaz).zza((zzae) zzaz);
        return zza(zzb(zzca), zzca);
    }

    public final Task<AuthResult> zzb(FirebaseApp firebaseApp, FirebaseUser firebaseUser, String str, String str2, String str3, zzaz zzaz) {
        zzcc zzcc = (zzcc) new zzcc(str, str2, str3).zza(firebaseApp).zza(firebaseUser).zza(zzaz).zza((zzae) zzaz);
        return zza(zzb(zzcc), zzcc);
    }

    public final Task<Void> zza(FirebaseApp firebaseApp, FirebaseUser firebaseUser, EmailAuthCredential emailAuthCredential, zzaz zzaz) {
        zzbw zzbw = (zzbw) new zzbw(emailAuthCredential).zza(firebaseApp).zza(firebaseUser).zza(zzaz).zza((zzae) zzaz);
        return zza(zzb(zzbw), zzbw);
    }

    public final Task<AuthResult> zzb(FirebaseApp firebaseApp, FirebaseUser firebaseUser, EmailAuthCredential emailAuthCredential, zzaz zzaz) {
        zzby zzby = (zzby) new zzby(emailAuthCredential).zza(firebaseApp).zza(firebaseUser).zza(zzaz).zza((zzae) zzaz);
        return zza(zzb(zzby), zzby);
    }

    public final Task<AuthResult> zza(FirebaseApp firebaseApp, PhoneAuthCredential phoneAuthCredential, @Nullable String str, zza zza2) {
        zzda zzda = (zzda) new zzda(phoneAuthCredential, str).zza(firebaseApp).zza(zza2);
        return zza(zzb(zzda), zzda);
    }

    public final Task<Void> zza(FirebaseApp firebaseApp, FirebaseUser firebaseUser, PhoneAuthCredential phoneAuthCredential, @Nullable String str, zzaz zzaz) {
        zzce zzce = (zzce) new zzce(phoneAuthCredential, str).zza(firebaseApp).zza(firebaseUser).zza(zzaz).zza((zzae) zzaz);
        return zza(zzb(zzce), zzce);
    }

    public final Task<AuthResult> zzb(FirebaseApp firebaseApp, FirebaseUser firebaseUser, PhoneAuthCredential phoneAuthCredential, @Nullable String str, zzaz zzaz) {
        zzcg zzcg = (zzcg) new zzcg(phoneAuthCredential, str).zza(firebaseApp).zza(firebaseUser).zza(zzaz).zza((zzae) zzaz);
        return zza(zzb(zzcg), zzcg);
    }

    public final Task<SignInMethodQueryResult> zza(FirebaseApp firebaseApp, String str, @Nullable String str2) {
        zzbg zzbg = (zzbg) new zzbg(str, str2).zza(firebaseApp);
        return zza(zza(zzbg), zzbg);
    }

    public final Task<Void> zza(FirebaseApp firebaseApp, String str, ActionCodeSettings actionCodeSettings, @Nullable String str2) {
        actionCodeSettings.zza(zzgd.PASSWORD_RESET);
        zzcm zzcm = (zzcm) new zzcm(str, actionCodeSettings, str2, "sendPasswordResetEmail").zza(firebaseApp);
        return zza(zzb(zzcm), zzcm);
    }

    public final Task<Void> zzb(FirebaseApp firebaseApp, String str, ActionCodeSettings actionCodeSettings, @Nullable String str2) {
        actionCodeSettings.zza(zzgd.EMAIL_SIGNIN);
        zzcm zzcm = (zzcm) new zzcm(str, actionCodeSettings, str2, "sendSignInLinkToEmail").zza(firebaseApp);
        return zza(zzb(zzcm), zzcm);
    }

    public final Task<Void> zza(FirebaseApp firebaseApp, @Nullable ActionCodeSettings actionCodeSettings, String str) {
        zzck zzck = (zzck) new zzck(str, actionCodeSettings).zza(firebaseApp);
        return zza(zzb(zzck), zzck);
    }

    public final Task<ActionCodeResult> zzb(FirebaseApp firebaseApp, String str, @Nullable String str2) {
        zzay zzay = (zzay) new zzay(str, str2).zza(firebaseApp);
        return zza(zzb(zzay), zzay);
    }

    public final Task<Void> zzc(FirebaseApp firebaseApp, String str, @Nullable String str2) {
        zzaw zzaw = (zzaw) new zzaw(str, str2).zza(firebaseApp);
        return zza(zzb(zzaw), zzaw);
    }

    public final Task<String> zzd(FirebaseApp firebaseApp, String str, @Nullable String str2) {
        zzdo zzdo = (zzdo) new zzdo(str, str2).zza(firebaseApp);
        return zza(zzb(zzdo), zzdo);
    }

    public final Task<Void> zza(FirebaseApp firebaseApp, String str, String str2, @Nullable String str3) {
        zzba zzba = (zzba) new zzba(str, str2, str3).zza(firebaseApp);
        return zza(zzb(zzba), zzba);
    }

    public final Task<AuthResult> zza(FirebaseApp firebaseApp, FirebaseUser firebaseUser, AuthCredential authCredential, zzaz zzaz) {
        Preconditions.checkNotNull(firebaseApp);
        Preconditions.checkNotNull(authCredential);
        Preconditions.checkNotNull(firebaseUser);
        Preconditions.checkNotNull(zzaz);
        List<String> zza2 = firebaseUser.zza();
        if (zza2 != null && zza2.contains(authCredential.getProvider())) {
            return Tasks.forException(zzdw.zza(new Status(FirebaseError.ERROR_PROVIDER_ALREADY_LINKED)));
        }
        if (authCredential instanceof EmailAuthCredential) {
            EmailAuthCredential emailAuthCredential = (EmailAuthCredential) authCredential;
            if (!emailAuthCredential.zzf()) {
                zzbk zzbk = (zzbk) new zzbk(emailAuthCredential).zza(firebaseApp).zza(firebaseUser).zza(zzaz).zza((zzae) zzaz);
                return zza(zzb(zzbk), zzbk);
            }
            zzbq zzbq = (zzbq) new zzbq(emailAuthCredential).zza(firebaseApp).zza(firebaseUser).zza(zzaz).zza((zzae) zzaz);
            return zza(zzb(zzbq), zzbq);
        } else if (authCredential instanceof PhoneAuthCredential) {
            zzbo zzbo = (zzbo) new zzbo((PhoneAuthCredential) authCredential).zza(firebaseApp).zza(firebaseUser).zza(zzaz).zza((zzae) zzaz);
            return zza(zzb(zzbo), zzbo);
        } else {
            Preconditions.checkNotNull(firebaseApp);
            Preconditions.checkNotNull(authCredential);
            Preconditions.checkNotNull(firebaseUser);
            Preconditions.checkNotNull(zzaz);
            zzbm zzbm = (zzbm) new zzbm(authCredential).zza(firebaseApp).zza(firebaseUser).zza(zzaz).zza((zzae) zzaz);
            return zza(zzb(zzbm), zzbm);
        }
    }

    public final Task<AuthResult> zzd(FirebaseApp firebaseApp, FirebaseUser firebaseUser, String str, zzaz zzaz) {
        Preconditions.checkNotNull(firebaseApp);
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotNull(firebaseUser);
        Preconditions.checkNotNull(zzaz);
        List<String> zza2 = firebaseUser.zza();
        if ((zza2 != null && !zza2.contains(str)) || firebaseUser.isAnonymous()) {
            return Tasks.forException(zzdw.zza(new Status(FirebaseError.ERROR_NO_SUCH_PROVIDER, str)));
        }
        char c = 65535;
        if (str.hashCode() == 1216985755 && str.equals("password")) {
            c = 0;
        }
        if (c != 0) {
            zzde zzde = (zzde) new zzde(str).zza(firebaseApp).zza(firebaseUser).zza(zzaz).zza((zzae) zzaz);
            return zza(zzb(zzde), zzde);
        }
        zzdc zzdc = (zzdc) new zzdc().zza(firebaseApp).zza(firebaseUser).zza(zzaz).zza((zzae) zzaz);
        return zza(zzb(zzdc), zzdc);
    }

    @NonNull
    public final Task<Void> zza(FirebaseApp firebaseApp, FirebaseUser firebaseUser, zzaz zzaz) {
        zzci zzci = (zzci) new zzci().zza(firebaseApp).zza(firebaseUser).zza(zzaz).zza((zzae) zzaz);
        return zza(zza(zzci), zzci);
    }

    @NonNull
    public final Task<Void> zza(FirebaseUser firebaseUser, zzab zzab) {
        zzbe zzbe = (zzbe) new zzbe().zza(firebaseUser).zza(zzab).zza((zzae) zzab);
        return zza(zzb(zzbe), zzbe);
    }

    @NonNull
    public final Task<Void> zza(String str) {
        zzco zzco = new zzco(str);
        return zza(zzb(zzco), zzco);
    }

    @NonNull
    @VisibleForTesting
    static zzn zza(FirebaseApp firebaseApp, zzes zzes) {
        Preconditions.checkNotNull(firebaseApp);
        Preconditions.checkNotNull(zzes);
        ArrayList arrayList = new ArrayList();
        arrayList.add(new zzj(zzes, FirebaseAuthProvider.PROVIDER_ID));
        List<zzfc> zzj = zzes.zzj();
        if (zzj != null && !zzj.isEmpty()) {
            for (int i = 0; i < zzj.size(); i++) {
                arrayList.add(new zzj(zzj.get(i)));
            }
        }
        zzn zzn = new zzn(firebaseApp, arrayList);
        zzn.zza(new zzp(zzes.zzh(), zzes.zzg()));
        zzn.zza(zzes.zzi());
        zzn.zza(zzes.zzl());
        zzn.zzb(zzar.zza(zzes.zzm()));
        return zzn;
    }

    @NonNull
    @VisibleForTesting
    private final <ResultT> Task<ResultT> zza(Task<ResultT> task, zzap<zzdu, ResultT> zzap) {
        return task.continueWithTask(new zzat(this, zzap));
    }
}
