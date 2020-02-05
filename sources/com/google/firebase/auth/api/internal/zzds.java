package com.google.firebase.auth.api.internal;

import android.content.Context;
import androidx.annotation.NonNull;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.common.GooglePlayServicesUtilLight;
import com.google.android.gms.common.api.GoogleApi;
import com.google.android.gms.dynamite.DynamiteModule;
import com.google.firebase.FirebaseExceptionMapper;
import java.util.Collections;
import java.util.concurrent.Callable;

/* compiled from: com.google.firebase:firebase-auth@@18.1.0 */
final class zzds implements Callable<zzal<zzej>> {
    private final zzej zza;
    private final Context zzb;

    public zzds(zzej zzej, Context context) {
        this.zza = zzej;
        this.zzb = context;
    }

    @NonNull
    private final GoogleApi<zzej> zza(boolean z, Context context) {
        zzej zzej = (zzej) this.zza.clone();
        zzej.zza = z;
        return new zzaq(context, zzeh.zza, zzej, new FirebaseExceptionMapper());
    }

    public final /* synthetic */ Object call() throws Exception {
        int localVersion = DynamiteModule.getLocalVersion(this.zzb, "com.google.firebase.auth");
        int i = 1;
        GoogleApi<zzej> googleApi = null;
        GoogleApi<zzej> zza2 = localVersion != 0 ? zza(true, this.zzb) : null;
        if (localVersion != 0) {
            int isGooglePlayServicesAvailable = GoogleApiAvailability.getInstance().isGooglePlayServicesAvailable(this.zzb, GooglePlayServicesUtilLight.GOOGLE_PLAY_SERVICES_VERSION_CODE);
            if (isGooglePlayServicesAvailable == 0 || isGooglePlayServicesAvailable == 2) {
                i = DynamiteModule.getRemoteVersion(this.zzb, "com.google.android.gms.firebase_auth");
            } else {
                i = 0;
            }
        }
        if (i != 0) {
            googleApi = zza(false, this.zzb);
        }
        return new zzal(googleApi, zza2, new zzan(i, localVersion, Collections.emptyMap()));
    }
}
