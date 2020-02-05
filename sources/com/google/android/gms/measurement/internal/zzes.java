package com.google.android.gms.measurement.internal;

import android.content.SharedPreferences;
import android.os.Build;
import android.text.TextUtils;
import android.util.Pair;
import androidx.annotation.NonNull;
import androidx.annotation.WorkerThread;
import com.google.android.gms.ads.identifier.AdvertisingIdClient;
import com.google.android.gms.common.util.VisibleForTesting;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.util.Locale;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.0.1 */
final class zzes extends zzgi {
    @VisibleForTesting
    static final Pair<String, Long> zza = new Pair<>("", 0L);
    private long zzaa;
    public zzew zzb;
    public final zzex zzc = new zzex(this, "last_upload", 0);
    public final zzex zzd = new zzex(this, "last_upload_attempt", 0);
    public final zzex zze = new zzex(this, "backoff", 0);
    public final zzex zzf = new zzex(this, "last_delete_stale", 0);
    public final zzex zzg = new zzex(this, "midnight_offset", 0);
    public final zzex zzh = new zzex(this, "first_open_time", 0);
    public final zzex zzi = new zzex(this, "app_install_time", 0);
    public final zzez zzj = new zzez(this, "app_instance_id", (String) null);
    public final zzex zzk = new zzex(this, "time_before_start", 10000);
    public final zzex zzl = new zzex(this, "session_timeout", 1800000);
    public final zzeu zzm = new zzeu(this, "start_new_session", true);
    public final zzez zzn = new zzez(this, "non_personalized_ads", (String) null);
    public final zzeu zzo = new zzeu(this, "use_dynamite_api", false);
    public final zzeu zzp = new zzeu(this, "allow_remote_dynamite", false);
    public final zzex zzq = new zzex(this, "last_pause_time", 0);
    public final zzex zzr = new zzex(this, "time_active", 0);
    public boolean zzs;
    public zzeu zzt = new zzeu(this, "app_backgrounded", false);
    public zzeu zzu = new zzeu(this, "deep_link_retrieval_complete", false);
    public zzex zzv = new zzex(this, "deep_link_retrieval_attempts", 0);
    private SharedPreferences zzx;
    private String zzy;
    private boolean zzz;

    /* access modifiers changed from: package-private */
    @WorkerThread
    @NonNull
    public final Pair<String, Boolean> zza(String str) {
        zzd();
        long elapsedRealtime = zzm().elapsedRealtime();
        String str2 = this.zzy;
        if (str2 != null && elapsedRealtime < this.zzaa) {
            return new Pair<>(str2, Boolean.valueOf(this.zzz));
        }
        this.zzaa = elapsedRealtime + zzt().zza(str, zzak.zze);
        AdvertisingIdClient.setShouldSkipGmsCoreVersionCheck(true);
        try {
            AdvertisingIdClient.Info advertisingIdInfo = AdvertisingIdClient.getAdvertisingIdInfo(zzn());
            if (advertisingIdInfo != null) {
                this.zzy = advertisingIdInfo.getId();
                this.zzz = advertisingIdInfo.isLimitAdTrackingEnabled();
            }
            if (this.zzy == null) {
                this.zzy = "";
            }
        } catch (Exception e) {
            zzr().zzw().zza("Unable to get advertising id", e);
            this.zzy = "";
        }
        AdvertisingIdClient.setShouldSkipGmsCoreVersionCheck(false);
        return new Pair<>(this.zzy, Boolean.valueOf(this.zzz));
    }

    /* access modifiers changed from: protected */
    public final boolean zze() {
        return true;
    }

    /* access modifiers changed from: package-private */
    @WorkerThread
    public final String zzb(String str) {
        zzd();
        String str2 = (String) zza(str).first;
        MessageDigest zzi2 = zzjx.zzi();
        if (zzi2 == null) {
            return null;
        }
        return String.format(Locale.US, "%032X", new Object[]{new BigInteger(1, zzi2.digest(str2.getBytes()))});
    }

    zzes(zzfn zzfn) {
        super(zzfn);
    }

    /* access modifiers changed from: protected */
    @WorkerThread
    public final void f_() {
        this.zzx = zzn().getSharedPreferences("com.google.android.gms.measurement.prefs", 0);
        this.zzs = this.zzx.getBoolean("has_been_opened", false);
        if (!this.zzs) {
            SharedPreferences.Editor edit = this.zzx.edit();
            edit.putBoolean("has_been_opened", true);
            edit.apply();
        }
        this.zzb = new zzew(this, "health_monitor", Math.max(0, zzak.zzf.zza(null).longValue()));
    }

    /* access modifiers changed from: private */
    @WorkerThread
    public final SharedPreferences zzy() {
        zzd();
        zzaa();
        return this.zzx;
    }

    /* access modifiers changed from: package-private */
    @WorkerThread
    public final void zzc(String str) {
        zzd();
        SharedPreferences.Editor edit = zzy().edit();
        edit.putString("gmp_app_id", str);
        edit.apply();
    }

    /* access modifiers changed from: package-private */
    @WorkerThread
    public final String zzg() {
        zzd();
        return zzy().getString("gmp_app_id", (String) null);
    }

    /* access modifiers changed from: package-private */
    @WorkerThread
    public final void zzd(String str) {
        zzd();
        SharedPreferences.Editor edit = zzy().edit();
        edit.putString("admob_app_id", str);
        edit.apply();
    }

    /* access modifiers changed from: package-private */
    @WorkerThread
    public final String zzh() {
        zzd();
        return zzy().getString("admob_app_id", (String) null);
    }

    /* access modifiers changed from: package-private */
    @WorkerThread
    public final Boolean zzi() {
        zzd();
        if (!zzy().contains("use_service")) {
            return null;
        }
        return Boolean.valueOf(zzy().getBoolean("use_service", false));
    }

    /* access modifiers changed from: package-private */
    @WorkerThread
    public final void zza(boolean z) {
        zzd();
        zzr().zzx().zza("Setting useService", Boolean.valueOf(z));
        SharedPreferences.Editor edit = zzy().edit();
        edit.putBoolean("use_service", z);
        edit.apply();
    }

    /* access modifiers changed from: package-private */
    @WorkerThread
    public final void zzj() {
        zzd();
        zzr().zzx().zza("Clearing collection preferences.");
        if (zzt().zza(zzak.zzbi)) {
            Boolean zzk2 = zzk();
            SharedPreferences.Editor edit = zzy().edit();
            edit.clear();
            edit.apply();
            if (zzk2 != null) {
                zzb(zzk2.booleanValue());
                return;
            }
            return;
        }
        boolean contains = zzy().contains("measurement_enabled");
        boolean z = true;
        if (contains) {
            z = zzc(true);
        }
        SharedPreferences.Editor edit2 = zzy().edit();
        edit2.clear();
        edit2.apply();
        if (contains) {
            zzb(z);
        }
    }

    /* access modifiers changed from: package-private */
    @WorkerThread
    public final void zzb(boolean z) {
        zzd();
        zzr().zzx().zza("Setting measurementEnabled", Boolean.valueOf(z));
        SharedPreferences.Editor edit = zzy().edit();
        edit.putBoolean("measurement_enabled", z);
        edit.apply();
    }

    /* access modifiers changed from: package-private */
    @WorkerThread
    public final boolean zzc(boolean z) {
        zzd();
        return zzy().getBoolean("measurement_enabled", z);
    }

    /* access modifiers changed from: package-private */
    @WorkerThread
    public final Boolean zzk() {
        zzd();
        if (zzy().contains("measurement_enabled")) {
            return Boolean.valueOf(zzy().getBoolean("measurement_enabled", true));
        }
        return null;
    }

    /* access modifiers changed from: protected */
    @WorkerThread
    public final String zzv() {
        zzd();
        String string = zzy().getString("previous_os_version", (String) null);
        zzl().zzaa();
        String str = Build.VERSION.RELEASE;
        if (!TextUtils.isEmpty(str) && !str.equals(string)) {
            SharedPreferences.Editor edit = zzy().edit();
            edit.putString("previous_os_version", str);
            edit.apply();
        }
        return string;
    }

    /* access modifiers changed from: package-private */
    @WorkerThread
    public final void zzd(boolean z) {
        zzd();
        zzr().zzx().zza("Updating deferred analytics collection", Boolean.valueOf(z));
        SharedPreferences.Editor edit = zzy().edit();
        edit.putBoolean("deferred_analytics_collection", z);
        edit.apply();
    }

    /* access modifiers changed from: package-private */
    @WorkerThread
    public final boolean zzw() {
        zzd();
        return zzy().getBoolean("deferred_analytics_collection", false);
    }

    /* access modifiers changed from: package-private */
    @WorkerThread
    public final boolean zzx() {
        return this.zzx.contains("deferred_analytics_collection");
    }

    /* access modifiers changed from: package-private */
    public final boolean zza(long j) {
        return j - this.zzl.zza() > this.zzq.zza();
    }
}
