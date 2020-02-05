package com.google.android.gms.measurement.internal;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import androidx.annotation.WorkerThread;
import com.google.android.gms.common.util.Clock;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.internal.measurement.zzh;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.0.1 */
public final class zzjd extends zzg {
    private Handler zza;
    @VisibleForTesting
    private long zzb = zzm().elapsedRealtime();
    @VisibleForTesting
    private long zzc = this.zzb;
    private final zzaa zzd = new zzjc(this, this.zzw);
    private final zzaa zze = new zzjf(this, this.zzw);
    private final Runnable zzf = new zzje(this);

    zzjd(zzfn zzfn) {
        super(zzfn);
    }

    /* access modifiers changed from: protected */
    public final boolean zzz() {
        return false;
    }

    @WorkerThread
    private final void zzae() {
        zzd();
        if (this.zza == null) {
            this.zza = new zzh(Looper.getMainLooper());
        }
    }

    /* access modifiers changed from: package-private */
    @WorkerThread
    public final void zzab() {
        zzd();
        this.zzd.zzc();
        this.zze.zzc();
        this.zzb = 0;
        this.zzc = this.zzb;
    }

    /* access modifiers changed from: private */
    @WorkerThread
    public final void zza(long j) {
        zzd();
        zzae();
        if (zzt().zza(zzak.zzcg)) {
            this.zza.removeCallbacks(this.zzf);
        }
        if (zzt().zze(zzg().zzab(), zzak.zzba)) {
            zzs().zzt.zza(false);
        }
        zzr().zzx().zza("Activity resumed, time", Long.valueOf(j));
        this.zzb = j;
        this.zzc = this.zzb;
        if (this.zzw.zzab()) {
            if (zzt().zzp(zzg().zzab())) {
                zza(zzm().currentTimeMillis(), false);
                return;
            }
            this.zzd.zzc();
            this.zze.zzc();
            if (zzs().zza(zzm().currentTimeMillis())) {
                zzs().zzm.zza(true);
                zzs().zzr.zza(0);
            }
            if (zzs().zzm.zza()) {
                this.zzd.zza(Math.max(0, zzs().zzk.zza() - zzs().zzr.zza()));
            } else {
                this.zze.zza(Math.max(0, 3600000 - zzs().zzr.zza()));
            }
        }
    }

    /* access modifiers changed from: package-private */
    @WorkerThread
    public final void zza(long j, boolean z) {
        zzd();
        zzae();
        this.zzd.zzc();
        this.zze.zzc();
        if (zzs().zza(j)) {
            zzs().zzm.zza(true);
            zzs().zzr.zza(0);
        }
        if (z && zzt().zzq(zzg().zzab())) {
            zzs().zzq.zza(j);
        }
        if (zzs().zzm.zza()) {
            zzb(j, z);
        } else {
            this.zze.zza(Math.max(0, 3600000 - zzs().zzr.zza()));
        }
    }

    /* access modifiers changed from: private */
    @WorkerThread
    public final void zzb(long j) {
        zzd();
        zzae();
        if (zzt().zze(zzg().zzab(), zzak.zzba)) {
            zzs().zzt.zza(true);
        }
        this.zzd.zzc();
        this.zze.zzc();
        zzr().zzx().zza("Activity paused, time", Long.valueOf(j));
        if (this.zzb != 0) {
            zzs().zzr.zza(zzs().zzr.zza() + (j - this.zzb));
        }
        if (zzt().zza(zzak.zzcg)) {
            this.zza.postDelayed(this.zzf, 2000);
        }
    }

    @WorkerThread
    private final void zzb(long j, boolean z) {
        zzd();
        zzr().zzx().zza("Session started, time", Long.valueOf(zzm().elapsedRealtime()));
        Long valueOf = zzt().zzn(zzg().zzab()) ? Long.valueOf(j / 1000) : null;
        zzf().zza("auto", "_sid", (Object) valueOf, j);
        zzs().zzm.zza(false);
        Bundle bundle = new Bundle();
        if (zzt().zzn(zzg().zzab())) {
            bundle.putLong("_sid", valueOf.longValue());
        }
        if (zzt().zza(zzak.zzch) && z) {
            bundle.putLong("_aib", 1);
        }
        zzf().zza("auto", "_s", j, bundle);
        zzs().zzq.zza(j);
    }

    /* access modifiers changed from: protected */
    @WorkerThread
    @VisibleForTesting
    public final void zzac() {
        zzd();
        zzb(zzm().currentTimeMillis(), false);
    }

    /* access modifiers changed from: package-private */
    @WorkerThread
    @VisibleForTesting
    public final long zzad() {
        long elapsedRealtime = zzm().elapsedRealtime();
        long j = elapsedRealtime - this.zzc;
        this.zzc = elapsedRealtime;
        return j;
    }

    @WorkerThread
    public final boolean zza(boolean z, boolean z2) {
        zzd();
        zzw();
        long elapsedRealtime = zzm().elapsedRealtime();
        zzs().zzq.zza(zzm().currentTimeMillis());
        long j = elapsedRealtime - this.zzb;
        if (z || j >= 1000) {
            zzs().zzr.zza(j);
            zzr().zzx().zza("Recording user engagement, ms", Long.valueOf(j));
            Bundle bundle = new Bundle();
            bundle.putLong("_et", j);
            zzhx.zza(zzi().zzab(), bundle, true);
            if (zzt().zzr(zzg().zzab())) {
                if (zzt().zze(zzg().zzab(), zzak.zzbf)) {
                    if (!z2) {
                        zzad();
                    }
                } else if (z2) {
                    bundle.putLong("_fr", 1);
                } else {
                    zzad();
                }
            }
            if (!zzt().zze(zzg().zzab(), zzak.zzbf) || !z2) {
                zzf().zza("auto", "_e", bundle);
            }
            this.zzb = elapsedRealtime;
            this.zze.zzc();
            this.zze.zza(Math.max(0, 3600000 - zzs().zzr.zza()));
            return true;
        }
        zzr().zzx().zza("Screen exposed for less than 1000 ms. Event not sent. time", Long.valueOf(j));
        return false;
    }

    /* access modifiers changed from: private */
    @WorkerThread
    public final void zzaf() {
        zzd();
        zza(false, false);
        zze().zza(zzm().elapsedRealtime());
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

    public final /* bridge */ /* synthetic */ zza zze() {
        return super.zze();
    }

    public final /* bridge */ /* synthetic */ zzgt zzf() {
        return super.zzf();
    }

    public final /* bridge */ /* synthetic */ zzec zzg() {
        return super.zzg();
    }

    public final /* bridge */ /* synthetic */ zzhy zzh() {
        return super.zzh();
    }

    public final /* bridge */ /* synthetic */ zzhx zzi() {
        return super.zzi();
    }

    public final /* bridge */ /* synthetic */ zzef zzj() {
        return super.zzj();
    }

    public final /* bridge */ /* synthetic */ zzjd zzk() {
        return super.zzk();
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
