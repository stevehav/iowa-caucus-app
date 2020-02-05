package com.google.firebase.auth;

import android.net.Uri;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.firebase_auth.zzbd;
import com.google.android.gms.internal.firebase_auth.zzbe;
import java.util.Set;

/* compiled from: com.google.firebase:firebase-auth@@18.1.0 */
public final class zzf {
    private static final zzbe<String, Integer> zzg = new zzbd().zza("recoverEmail", 2).zza("resetPassword", 0).zza("signIn", 4).zza("verifyEmail", 1).zza("verifyBeforeChangeEmail", 5).zza("revertSecondFactorAddition", 6).zza();
    private final String zza;
    private final String zzb;
    private final String zzc;
    @Nullable
    private final String zzd;
    @Nullable
    private final String zze;
    @Nullable
    private final String zzf;

    private zzf(String str) {
        this.zza = zza(str, "apiKey");
        this.zzb = zza(str, "oobCode");
        this.zzc = zza(str, "mode");
        if (this.zza == null || this.zzb == null || this.zzc == null) {
            throw new IllegalArgumentException(String.format("%s, %s and %s are required in a valid action code URL", new Object[]{"apiKey", "oobCode", "mode"}));
        }
        this.zzd = zza(str, "continueUrl");
        this.zze = zza(str, "languageCode");
        this.zzf = zza(str, "tenantId");
    }

    @Nullable
    public static zzf zza(@NonNull String str) {
        Preconditions.checkNotEmpty(str);
        try {
            return new zzf(str);
        } catch (IllegalArgumentException unused) {
            return null;
        }
    }

    public final int zza() {
        return zzg.getOrDefault(this.zzc, 3).intValue();
    }

    @NonNull
    public final String zzb() {
        return this.zzb;
    }

    @Nullable
    public final String zzc() {
        return this.zzf;
    }

    private static String zza(String str, String str2) {
        Uri parse = Uri.parse(str);
        try {
            Set<String> queryParameterNames = parse.getQueryParameterNames();
            if (queryParameterNames.contains(str2)) {
                return parse.getQueryParameter(str2);
            }
            if (queryParameterNames.contains("link")) {
                return Uri.parse(parse.getQueryParameter("link")).getQueryParameter(str2);
            }
            return null;
        } catch (UnsupportedOperationException unused) {
            return null;
        }
    }
}
