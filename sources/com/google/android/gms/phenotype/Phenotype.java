package com.google.android.gms.phenotype;

import android.net.Uri;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.internal.phenotype.zzd;
import com.google.android.gms.internal.phenotype.zze;

@KeepForSdk
public final class Phenotype {
    @Deprecated
    private static final Api<Api.ApiOptions.NoOptions> API = new Api<>("Phenotype.API", CLIENT_BUILDER, CLIENT_KEY);
    private static final Api.AbstractClientBuilder<zze, Api.ApiOptions.NoOptions> CLIENT_BUILDER = new zzl();
    private static final Api.ClientKey<zze> CLIENT_KEY = new Api.ClientKey<>();
    @Deprecated
    private static final zzm zzaj = new zzd();

    private Phenotype() {
    }

    @KeepForSdk
    public static Uri getContentProviderUri(String str) {
        String valueOf = String.valueOf(Uri.encode(str));
        return Uri.parse(valueOf.length() != 0 ? "content://com.google.android.gms.phenotype/".concat(valueOf) : new String("content://com.google.android.gms.phenotype/"));
    }
}
