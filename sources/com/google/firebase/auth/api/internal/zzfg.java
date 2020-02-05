package com.google.firebase.auth.api.internal;

import android.text.TextUtils;
import com.google.android.gms.internal.firebase_auth.zzfz;
import com.google.firebase.auth.PhoneAuthCredential;

/* compiled from: com.google.firebase:firebase-auth@@18.1.0 */
public final class zzfg {
    public static zzfz zza(PhoneAuthCredential phoneAuthCredential) {
        if (!TextUtils.isEmpty(phoneAuthCredential.zzd())) {
            return zzfz.zzb(phoneAuthCredential.zzb(), phoneAuthCredential.zzd(), phoneAuthCredential.zzc());
        }
        return zzfz.zza(phoneAuthCredential.zza(), phoneAuthCredential.getSmsCode(), phoneAuthCredential.zzc());
    }
}
