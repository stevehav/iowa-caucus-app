package com.google.android.gms.measurement.internal;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.Size;
import androidx.annotation.WorkerThread;
import androidx.collection.ArrayMap;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.Clock;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.0.1 */
public final class zzhx extends zzg {
    @VisibleForTesting
    protected zzhu zza;
    private volatile zzhu zzb;
    private zzhu zzc;
    private final Map<Activity, zzhu> zzd = new ArrayMap();
    private zzhu zze;
    private String zzf;

    public zzhx(zzfn zzfn) {
        super(zzfn);
    }

    /* access modifiers changed from: protected */
    public final boolean zzz() {
        return false;
    }

    @WorkerThread
    public final zzhu zzab() {
        zzw();
        zzd();
        return this.zza;
    }

    public final void zza(@NonNull Activity activity, @Size(max = 36, min = 1) @Nullable String str, @Size(max = 36, min = 1) @Nullable String str2) {
        if (this.zzb == null) {
            zzr().zzk().zza("setCurrentScreen cannot be called while no activity active");
        } else if (this.zzd.get(activity) == null) {
            zzr().zzk().zza("setCurrentScreen must be called with an activity in the activity lifecycle");
        } else {
            if (str2 == null) {
                str2 = zza(activity.getClass().getCanonicalName());
            }
            boolean equals = this.zzb.zzb.equals(str2);
            boolean zzd2 = zzjx.zzd(this.zzb.zza, str);
            if (equals && zzd2) {
                zzr().zzk().zza("setCurrentScreen cannot be called with the same class and name");
            } else if (str != null && (str.length() <= 0 || str.length() > 100)) {
                zzr().zzk().zza("Invalid screen name length in setCurrentScreen. Length", Integer.valueOf(str.length()));
            } else if (str2 == null || (str2.length() > 0 && str2.length() <= 100)) {
                zzr().zzx().zza("Setting current screen to name, class", str == null ? "null" : str, str2);
                zzhu zzhu = new zzhu(str, str2, zzp().zzg());
                this.zzd.put(activity, zzhu);
                zza(activity, zzhu, true);
            } else {
                zzr().zzk().zza("Invalid class name length in setCurrentScreen. Length", Integer.valueOf(str2.length()));
            }
        }
    }

    public final zzhu zzac() {
        zzb();
        return this.zzb;
    }

    @MainThread
    private final void zza(Activity activity, zzhu zzhu, boolean z) {
        zzhu zzhu2 = this.zzb == null ? this.zzc : this.zzb;
        if (zzhu.zzb == null) {
            zzhu = new zzhu(zzhu.zza, zza(activity.getClass().getCanonicalName()), zzhu.zzc);
        }
        this.zzc = this.zzb;
        this.zzb = zzhu;
        zzq().zza((Runnable) new zzhw(this, z, zzhu2, zzhu));
    }

    /* access modifiers changed from: private */
    @WorkerThread
    public final void zza(@NonNull zzhu zzhu, boolean z) {
        zze().zza(zzm().elapsedRealtime());
        if (zzk().zza(zzhu.zzd, z)) {
            zzhu.zzd = false;
        }
    }

    public static void zza(zzhu zzhu, Bundle bundle, boolean z) {
        if (bundle != null && zzhu != null && (!bundle.containsKey("_sc") || z)) {
            if (zzhu.zza != null) {
                bundle.putString("_sn", zzhu.zza);
            } else {
                bundle.remove("_sn");
            }
            bundle.putString("_sc", zzhu.zzb);
            bundle.putLong("_si", zzhu.zzc);
        } else if (bundle != null && zzhu == null && z) {
            bundle.remove("_sn");
            bundle.remove("_sc");
            bundle.remove("_si");
        }
    }

    @WorkerThread
    public final void zza(String str, zzhu zzhu) {
        zzd();
        synchronized (this) {
            if (this.zzf == null || this.zzf.equals(str) || zzhu != null) {
                this.zzf = str;
                this.zze = zzhu;
            }
        }
    }

    @VisibleForTesting
    private static String zza(String str) {
        String[] split = str.split("\\.");
        String str2 = split.length > 0 ? split[split.length - 1] : "";
        return str2.length() > 100 ? str2.substring(0, 100) : str2;
    }

    @MainThread
    private final zzhu zzd(@NonNull Activity activity) {
        Preconditions.checkNotNull(activity);
        zzhu zzhu = this.zzd.get(activity);
        if (zzhu != null) {
            return zzhu;
        }
        zzhu zzhu2 = new zzhu((String) null, zza(activity.getClass().getCanonicalName()), zzp().zzg());
        this.zzd.put(activity, zzhu2);
        return zzhu2;
    }

    @MainThread
    public final void zza(Activity activity, Bundle bundle) {
        Bundle bundle2;
        if (bundle != null && (bundle2 = bundle.getBundle("com.google.app_measurement.screen_service")) != null) {
            this.zzd.put(activity, new zzhu(bundle2.getString(AppMeasurementSdk.ConditionalUserProperty.NAME), bundle2.getString("referrer_name"), bundle2.getLong("id")));
        }
    }

    @MainThread
    public final void zza(Activity activity) {
        zza(activity, zzd(activity), false);
        zza zze2 = zze();
        zze2.zzq().zza((Runnable) new zze(zze2, zze2.zzm().elapsedRealtime()));
    }

    @MainThread
    public final void zzb(Activity activity) {
        zzhu zzd2 = zzd(activity);
        this.zzc = this.zzb;
        this.zzb = null;
        zzq().zza((Runnable) new zzhz(this, zzd2));
    }

    @MainThread
    public final void zzb(Activity activity, Bundle bundle) {
        zzhu zzhu;
        if (bundle != null && (zzhu = this.zzd.get(activity)) != null) {
            Bundle bundle2 = new Bundle();
            bundle2.putLong("id", zzhu.zzc);
            bundle2.putString(AppMeasurementSdk.ConditionalUserProperty.NAME, zzhu.zza);
            bundle2.putString("referrer_name", zzhu.zzb);
            bundle.putBundle("com.google.app_measurement.screen_service", bundle2);
        }
    }

    @MainThread
    public final void zzc(Activity activity) {
        this.zzd.remove(activity);
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
