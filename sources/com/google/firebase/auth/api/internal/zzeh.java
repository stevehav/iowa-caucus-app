package com.google.firebase.auth.api.internal;

import android.content.Context;
import com.google.android.gms.common.api.Api;

/* compiled from: com.google.firebase:firebase-auth@@18.1.0 */
public final class zzeh {
    public static final Api<zzej> zza = new Api<>("InternalFirebaseAuth.FIREBASE_AUTH_API", zzc, zzb);
    private static final Api.ClientKey<zzdu> zzb = new Api.ClientKey<>();
    private static final Api.AbstractClientBuilder<zzdu, zzej> zzc = new zzeg();

    public static zzau zza(Context context, zzej zzej) {
        return new zzau(context, zzej);
    }
}
