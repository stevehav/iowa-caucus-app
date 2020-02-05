package com.google.android.gms.internal.firebase_auth;

import androidx.annotation.Nullable;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.logging.Logger;
import com.google.android.gms.internal.firebase_auth.zzp;
import com.google.firebase.auth.EmailAuthCredential;
import com.google.firebase.auth.api.internal.zzfk;
import com.google.firebase.auth.zzf;

/* compiled from: com.google.firebase:firebase-auth@@18.1.0 */
public final class zzej implements zzfk<zzp.zzd> {
    private static final Logger zza = new Logger("EmailLinkSignInRequest", new String[0]);
    private final String zzb;
    private final String zzc;
    @Nullable
    private final String zzd;

    public zzej(EmailAuthCredential emailAuthCredential, @Nullable String str) {
        this.zzb = Preconditions.checkNotEmpty(emailAuthCredential.zza());
        this.zzc = Preconditions.checkNotEmpty(emailAuthCredential.zzc());
        this.zzd = str;
    }

    public final /* synthetic */ zzjg zza() {
        zzp.zzd.zza zzb2 = zzp.zzd.zza().zzb(this.zzb);
        zzf zza2 = zzf.zza(this.zzc);
        String str = null;
        String zzb3 = zza2 != null ? zza2.zzb() : null;
        if (zza2 != null) {
            str = zza2.zzc();
        }
        if (zzb3 != null) {
            zzb2.zza(zzb3);
        }
        if (str != null) {
            zzb2.zzd(str);
        }
        String str2 = this.zzd;
        if (str2 != null) {
            zzb2.zzc(str2);
        }
        return (zzp.zzd) ((zzhx) zzb2.zzf());
    }
}
