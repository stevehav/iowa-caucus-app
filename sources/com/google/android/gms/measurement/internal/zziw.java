package com.google.android.gms.measurement.internal;

import android.annotation.TargetApi;
import android.app.job.JobParameters;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import androidx.annotation.MainThread;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.measurement.zzx;
import com.google.android.gms.measurement.internal.zzja;

/* compiled from: com.google.android.gms:play-services-measurement@@17.0.1 */
public final class zziw<T extends Context & zzja> {
    private final T zza;

    public zziw(T t) {
        Preconditions.checkNotNull(t);
        this.zza = t;
    }

    @MainThread
    public final void zza() {
        zzfn zza2 = zzfn.zza((Context) this.zza, (zzx) null);
        zzej zzr = zza2.zzr();
        zza2.zzu();
        zzr.zzx().zza("Local AppMeasurementService is starting up");
    }

    @MainThread
    public final void zzb() {
        zzfn zza2 = zzfn.zza((Context) this.zza, (zzx) null);
        zzej zzr = zza2.zzr();
        zza2.zzu();
        zzr.zzx().zza("Local AppMeasurementService is shutting down");
    }

    @MainThread
    public final int zza(Intent intent, int i, int i2) {
        zzfn zza2 = zzfn.zza((Context) this.zza, (zzx) null);
        zzej zzr = zza2.zzr();
        if (intent == null) {
            zzr.zzi().zza("AppMeasurementService started with null intent");
            return 2;
        }
        String action = intent.getAction();
        zza2.zzu();
        zzr.zzx().zza("Local AppMeasurementService called. startId, action", Integer.valueOf(i2), action);
        if ("com.google.android.gms.measurement.UPLOAD".equals(action)) {
            zza((Runnable) new zziz(this, i2, zzr, intent));
        }
        return 2;
    }

    private final void zza(Runnable runnable) {
        zzjp zza2 = zzjp.zza((Context) this.zza);
        zza2.zzq().zza((Runnable) new zzjb(this, zza2, runnable));
    }

    @MainThread
    public final IBinder zza(Intent intent) {
        if (intent == null) {
            zzc().zzf().zza("onBind called with null intent");
            return null;
        }
        String action = intent.getAction();
        if ("com.google.android.gms.measurement.START".equals(action)) {
            return new zzfo(zzjp.zza((Context) this.zza));
        }
        zzc().zzi().zza("onBind received unknown action", action);
        return null;
    }

    @MainThread
    public final boolean zzb(Intent intent) {
        if (intent == null) {
            zzc().zzf().zza("onUnbind called with null intent");
            return true;
        }
        zzc().zzx().zza("onUnbind called for intent. action", intent.getAction());
        return true;
    }

    @TargetApi(24)
    @MainThread
    public final boolean zza(JobParameters jobParameters) {
        zzfn zza2 = zzfn.zza((Context) this.zza, (zzx) null);
        zzej zzr = zza2.zzr();
        String string = jobParameters.getExtras().getString("action");
        zza2.zzu();
        zzr.zzx().zza("Local AppMeasurementJobService called. action", string);
        if (!"com.google.android.gms.measurement.UPLOAD".equals(string)) {
            return true;
        }
        zza((Runnable) new zziy(this, zzr, jobParameters));
        return true;
    }

    @MainThread
    public final void zzc(Intent intent) {
        if (intent == null) {
            zzc().zzf().zza("onRebind called with null intent");
            return;
        }
        zzc().zzx().zza("onRebind called. action", intent.getAction());
    }

    private final zzej zzc() {
        return zzfn.zza((Context) this.zza, (zzx) null).zzr();
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zza(zzej zzej, JobParameters jobParameters) {
        zzej.zzx().zza("AppMeasurementJobService processed last upload request.");
        ((zzja) this.zza).zza(jobParameters, false);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zza(int i, zzej zzej, Intent intent) {
        if (((zzja) this.zza).zza(i)) {
            zzej.zzx().zza("Local AppMeasurementService processed last upload request. StartId", Integer.valueOf(i));
            zzc().zzx().zza("Completed wakeful intent.");
            ((zzja) this.zza).zza(intent);
        }
    }
}
