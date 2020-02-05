package com.google.android.gms.measurement.internal;

import android.annotation.TargetApi;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.app.job.JobInfo;
import android.app.job.JobScheduler;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.PersistableBundle;
import androidx.core.app.NotificationCompat;
import com.google.android.gms.common.util.Clock;
import com.google.android.gms.internal.measurement.zzi;

/* compiled from: com.google.android.gms:play-services-measurement@@17.0.1 */
public final class zzjl extends zzjm {
    private final AlarmManager zzb = ((AlarmManager) zzn().getSystemService(NotificationCompat.CATEGORY_ALARM));
    private final zzaa zzc;
    private Integer zzd;

    protected zzjl(zzjp zzjp) {
        super(zzjp);
        this.zzc = new zzjk(this, zzjp.zzs(), zzjp);
    }

    /* access modifiers changed from: protected */
    public final boolean zze() {
        this.zzb.cancel(zzw());
        if (Build.VERSION.SDK_INT < 24) {
            return false;
        }
        zzk();
        return false;
    }

    @TargetApi(24)
    private final void zzk() {
        int zzv = zzv();
        zzr().zzx().zza("Cancelling job. JobID", Integer.valueOf(zzv));
        ((JobScheduler) zzn().getSystemService("jobscheduler")).cancel(zzv);
    }

    public final void zza(long j) {
        zzak();
        zzu();
        Context zzn = zzn();
        if (!zzfd.zza(zzn)) {
            zzr().zzw().zza("Receiver not registered/enabled");
        }
        if (!zzjx.zza(zzn, false)) {
            zzr().zzw().zza("Service not registered/enabled");
        }
        zzf();
        long elapsedRealtime = zzm().elapsedRealtime() + j;
        if (j < Math.max(0, zzak.zzaa.zza(null).longValue()) && !this.zzc.zzb()) {
            zzr().zzx().zza("Scheduling upload with DelayedRunnable");
            this.zzc.zza(j);
        }
        zzu();
        if (Build.VERSION.SDK_INT >= 24) {
            zzr().zzx().zza("Scheduling upload with JobScheduler");
            Context zzn2 = zzn();
            ComponentName componentName = new ComponentName(zzn2, "com.google.android.gms.measurement.AppMeasurementJobService");
            int zzv = zzv();
            PersistableBundle persistableBundle = new PersistableBundle();
            persistableBundle.putString("action", "com.google.android.gms.measurement.UPLOAD");
            JobInfo build = new JobInfo.Builder(zzv, componentName).setMinimumLatency(j).setOverrideDeadline(j << 1).setExtras(persistableBundle).build();
            zzr().zzx().zza("Scheduling job. JobID", Integer.valueOf(zzv));
            zzi.zza(zzn2, build, "com.google.android.gms", "UploadAlarm");
            return;
        }
        zzr().zzx().zza("Scheduling upload with AlarmManager");
        this.zzb.setInexactRepeating(2, elapsedRealtime, Math.max(zzak.zzv.zza(null).longValue(), j), zzw());
    }

    private final int zzv() {
        if (this.zzd == null) {
            String valueOf = String.valueOf(zzn().getPackageName());
            this.zzd = Integer.valueOf((valueOf.length() != 0 ? "measurement".concat(valueOf) : new String("measurement")).hashCode());
        }
        return this.zzd.intValue();
    }

    public final void zzf() {
        zzak();
        this.zzb.cancel(zzw());
        this.zzc.zzc();
        if (Build.VERSION.SDK_INT >= 24) {
            zzk();
        }
    }

    private final PendingIntent zzw() {
        Context zzn = zzn();
        return PendingIntent.getBroadcast(zzn, 0, new Intent().setClassName(zzn, "com.google.android.gms.measurement.AppMeasurementReceiver").setAction("com.google.android.gms.measurement.UPLOAD"), 0);
    }

    public final /* bridge */ /* synthetic */ zzjt zzg() {
        return super.zzg();
    }

    public final /* bridge */ /* synthetic */ zzp e_() {
        return super.e_();
    }

    public final /* bridge */ /* synthetic */ zzx zzi() {
        return super.zzi();
    }

    public final /* bridge */ /* synthetic */ zzfh zzj() {
        return super.zzj();
    }

    public final /* bridge */ /* synthetic */ void zza() {
        super.zza();
    }

    public final /* bridge */ /* synthetic */ void zzb() {
        super.zzb();
    }

    public final /* bridge */ /* synthetic */ void zzc() {
        super.zzc();
    }

    public final /* bridge */ /* synthetic */ void zzd() {
        super.zzd();
    }

    public final /* bridge */ /* synthetic */ zzac zzl() {
        return super.zzl();
    }

    public final /* bridge */ /* synthetic */ Clock zzm() {
        return super.zzm();
    }

    public final /* bridge */ /* synthetic */ Context zzn() {
        return super.zzn();
    }

    public final /* bridge */ /* synthetic */ zzeh zzo() {
        return super.zzo();
    }

    public final /* bridge */ /* synthetic */ zzjx zzp() {
        return super.zzp();
    }

    public final /* bridge */ /* synthetic */ zzfg zzq() {
        return super.zzq();
    }

    public final /* bridge */ /* synthetic */ zzej zzr() {
        return super.zzr();
    }

    public final /* bridge */ /* synthetic */ zzes zzs() {
        return super.zzs();
    }

    public final /* bridge */ /* synthetic */ zzs zzt() {
        return super.zzt();
    }

    public final /* bridge */ /* synthetic */ zzr zzu() {
        return super.zzu();
    }
}
