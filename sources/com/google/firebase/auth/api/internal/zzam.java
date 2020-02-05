package com.google.firebase.auth.api.internal;

import androidx.annotation.GuardedBy;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApi;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.logging.Logger;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;
import com.google.firebase.FirebaseError;
import com.google.firebase.auth.api.internal.zzao;
import java.util.concurrent.Future;

/* compiled from: com.google.firebase:firebase-auth@@18.1.0 */
public abstract class zzam<T extends zzao> {
    private static Logger zza = new Logger("BiChannelGoogleApi", "FirebaseAuth: ");
    @GuardedBy("this")
    private zzal<T> zzb;

    /* access modifiers changed from: package-private */
    public abstract Future<zzal<T>> zza();

    public final <ResultT, A extends Api.AnyClient> Task<ResultT> zza(zzap<A, ResultT> zzap) {
        GoogleApi zza2 = zza(zzap.zza());
        if (zza2 == null) {
            return zzb();
        }
        if (((zzao) zza2.getApiOptions()).zza) {
            zzap.zzd();
        }
        return zza2.doRead(zzap.zzb());
    }

    public final <ResultT, A extends Api.AnyClient> Task<ResultT> zzb(zzap<A, ResultT> zzap) {
        GoogleApi zza2 = zza(zzap.zza());
        if (zza2 == null) {
            return zzb();
        }
        if (((zzao) zza2.getApiOptions()).zza) {
            zzap.zzd();
        }
        return zza2.doWrite(zzap.zzb());
    }

    private static <ResultT> Task<ResultT> zzb() {
        return Tasks.forException(zzdw.zza(new Status(FirebaseError.ERROR_INTERNAL_ERROR, "Unable to connect to GoogleApi instance - Google Play Services may be unavailable")));
    }

    private final GoogleApi<T> zza(String str) {
        zzal zzc = zzc();
        if (zzc.zzc.zza(str)) {
            Logger logger = zza;
            String valueOf = String.valueOf(zzc.zzb);
            StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 43);
            sb.append("getGoogleApiForMethod() returned Fallback: ");
            sb.append(valueOf);
            logger.w(sb.toString(), new Object[0]);
            return zzc.zzb;
        }
        Logger logger2 = zza;
        String valueOf2 = String.valueOf(zzc.zza);
        StringBuilder sb2 = new StringBuilder(String.valueOf(valueOf2).length() + 38);
        sb2.append("getGoogleApiForMethod() returned Gms: ");
        sb2.append(valueOf2);
        logger2.w(sb2.toString(), new Object[0]);
        return zzc.zza;
    }

    private final zzal<T> zzc() {
        zzal<T> zzal;
        synchronized (this) {
            if (this.zzb == null) {
                try {
                    this.zzb = (zzal) zza().get();
                } catch (Exception e) {
                    String valueOf = String.valueOf(e.getMessage());
                    throw new RuntimeException(valueOf.length() != 0 ? "There was an error while initializing the connection to Google Play Services: ".concat(valueOf) : new String("There was an error while initializing the connection to Google Play Services: "));
                }
            }
            zzal = this.zzb;
        }
        return zzal;
    }
}
