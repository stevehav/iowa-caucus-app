package com.google.firebase.analytics;

import java.util.concurrent.Callable;
import java.util.concurrent.TimeoutException;

/* compiled from: com.google.android.gms:play-services-measurement-api@@17.0.1 */
final class zzb implements Callable<String> {
    private final /* synthetic */ FirebaseAnalytics zza;

    zzb(FirebaseAnalytics firebaseAnalytics) {
        this.zza = firebaseAnalytics;
    }

    public final /* synthetic */ Object call() throws Exception {
        String str;
        String zza2 = this.zza.zzb();
        if (zza2 != null) {
            return zza2;
        }
        if (this.zza.zzd) {
            str = this.zza.zzc.zzh();
        } else {
            str = this.zza.zzb.zzh().zzc(120000);
        }
        if (str != null) {
            this.zza.zza(str);
            return str;
        }
        throw new TimeoutException();
    }
}
