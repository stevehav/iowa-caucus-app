package com.google.firebase.auth.internal;

import android.os.Handler;
import android.os.Looper;
import com.google.android.gms.internal.firebase_auth.zzj;
import java.util.concurrent.Executor;

/* compiled from: com.google.firebase:firebase-auth@@18.1.0 */
public final class zzaw implements Executor {
    private static zzaw zza = new zzaw();
    private Handler zzb = new zzj(Looper.getMainLooper());

    private zzaw() {
    }

    public final void execute(Runnable runnable) {
        this.zzb.post(runnable);
    }

    public static zzaw zza() {
        return zza;
    }
}
