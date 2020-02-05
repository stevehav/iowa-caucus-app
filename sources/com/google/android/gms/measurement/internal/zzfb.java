package com.google.android.gms.measurement.internal;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import androidx.annotation.MainThread;
import com.google.android.gms.internal.measurement.zze;
import com.google.android.gms.internal.measurement.zzf;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.0.1 */
public final class zzfb implements ServiceConnection {
    final /* synthetic */ zzey zza;
    /* access modifiers changed from: private */
    public final String zzb;

    zzfb(zzey zzey, String str) {
        this.zza = zzey;
        this.zzb = str;
    }

    @MainThread
    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        if (iBinder == null) {
            this.zza.zza.zzr().zzi().zza("Install Referrer connection returned with null binder");
            return;
        }
        try {
            zzf zza2 = zze.zza(iBinder);
            if (zza2 == null) {
                this.zza.zza.zzr().zzi().zza("Install Referrer Service implementation was not found");
                return;
            }
            this.zza.zza.zzr().zzv().zza("Install Referrer Service connected");
            this.zza.zza.zzq().zza((Runnable) new zzfa(this, zza2, this));
        } catch (Exception e) {
            this.zza.zza.zzr().zzi().zza("Exception occurred while calling Install Referrer API", e);
        }
    }

    @MainThread
    public final void onServiceDisconnected(ComponentName componentName) {
        this.zza.zza.zzr().zzv().zza("Install Referrer Service disconnected");
    }
}
