package com.google.android.gms.measurement.internal;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.Size;
import androidx.annotation.WorkerThread;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.Clock;
import com.google.android.gms.common.util.ProcessUtils;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.common.wrappers.Wrappers;
import java.lang.reflect.InvocationTargetException;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.0.1 */
public final class zzs extends zzgj {
    private Boolean zza;
    @NonNull
    private zzu zzb = zzv.zza;
    private Boolean zzc;

    zzs(zzfn zzfn) {
        super(zzfn);
        zzak.zza(zzfn);
    }

    /* access modifiers changed from: package-private */
    public final void zza(@NonNull zzu zzu) {
        this.zzb = zzu;
    }

    static String zze() {
        return zzak.zzd.zza(null);
    }

    @WorkerThread
    public final int zza(@Size(min = 1) String str) {
        return zzb(str, zzak.zzr);
    }

    public final long zzf() {
        zzu();
        return 18079;
    }

    public final boolean zzg() {
        if (this.zzc == null) {
            synchronized (this) {
                if (this.zzc == null) {
                    ApplicationInfo applicationInfo = zzn().getApplicationInfo();
                    String myProcessName = ProcessUtils.getMyProcessName();
                    if (applicationInfo != null) {
                        String str = applicationInfo.processName;
                        this.zzc = Boolean.valueOf(str != null && str.equals(myProcessName));
                    }
                    if (this.zzc == null) {
                        this.zzc = Boolean.TRUE;
                        zzr().zzf().zza("My process not in the list of running processes");
                    }
                }
            }
        }
        return this.zzc.booleanValue();
    }

    @WorkerThread
    public final long zza(String str, @NonNull zzdy<Long> zzdy) {
        if (str == null) {
            return zzdy.zza(null).longValue();
        }
        String zza2 = this.zzb.zza(str, zzdy.zza());
        if (TextUtils.isEmpty(zza2)) {
            return zzdy.zza(null).longValue();
        }
        try {
            return zzdy.zza(Long.valueOf(Long.parseLong(zza2))).longValue();
        } catch (NumberFormatException unused) {
            return zzdy.zza(null).longValue();
        }
    }

    @WorkerThread
    public final int zzb(String str, @NonNull zzdy<Integer> zzdy) {
        if (str == null) {
            return zzdy.zza(null).intValue();
        }
        String zza2 = this.zzb.zza(str, zzdy.zza());
        if (TextUtils.isEmpty(zza2)) {
            return zzdy.zza(null).intValue();
        }
        try {
            return zzdy.zza(Integer.valueOf(Integer.parseInt(zza2))).intValue();
        } catch (NumberFormatException unused) {
            return zzdy.zza(null).intValue();
        }
    }

    @WorkerThread
    public final double zzc(String str, @NonNull zzdy<Double> zzdy) {
        if (str == null) {
            return zzdy.zza(null).doubleValue();
        }
        String zza2 = this.zzb.zza(str, zzdy.zza());
        if (TextUtils.isEmpty(zza2)) {
            return zzdy.zza(null).doubleValue();
        }
        try {
            return zzdy.zza(Double.valueOf(Double.parseDouble(zza2))).doubleValue();
        } catch (NumberFormatException unused) {
            return zzdy.zza(null).doubleValue();
        }
    }

    @WorkerThread
    public final boolean zzd(String str, @NonNull zzdy<Boolean> zzdy) {
        if (str == null) {
            return zzdy.zza(null).booleanValue();
        }
        String zza2 = this.zzb.zza(str, zzdy.zza());
        if (TextUtils.isEmpty(zza2)) {
            return zzdy.zza(null).booleanValue();
        }
        return zzdy.zza(Boolean.valueOf(Boolean.parseBoolean(zza2))).booleanValue();
    }

    public final boolean zze(String str, zzdy<Boolean> zzdy) {
        return zzd(str, zzdy);
    }

    public final boolean zza(zzdy<Boolean> zzdy) {
        return zzd((String) null, zzdy);
    }

    @Nullable
    @VisibleForTesting
    private final Bundle zzaa() {
        try {
            if (zzn().getPackageManager() == null) {
                zzr().zzf().zza("Failed to load metadata: PackageManager is null");
                return null;
            }
            ApplicationInfo applicationInfo = Wrappers.packageManager(zzn()).getApplicationInfo(zzn().getPackageName(), 128);
            if (applicationInfo != null) {
                return applicationInfo.metaData;
            }
            zzr().zzf().zza("Failed to load metadata: ApplicationInfo is null");
            return null;
        } catch (PackageManager.NameNotFoundException e) {
            zzr().zzf().zza("Failed to load metadata: Package name not found", e);
            return null;
        }
    }

    /* access modifiers changed from: package-private */
    @Nullable
    @VisibleForTesting
    public final Boolean zzb(@Size(min = 1) String str) {
        Preconditions.checkNotEmpty(str);
        Bundle zzaa = zzaa();
        if (zzaa == null) {
            zzr().zzf().zza("Failed to load metadata: Metadata bundle is null");
            return null;
        } else if (!zzaa.containsKey(str)) {
            return null;
        } else {
            return Boolean.valueOf(zzaa.getBoolean(str));
        }
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x002a A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:9:0x002b A[SYNTHETIC, Splitter:B:9:0x002b] */
    @androidx.annotation.Nullable
    @com.google.android.gms.common.util.VisibleForTesting
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.util.List<java.lang.String> zzc(@androidx.annotation.Size(min = 1) java.lang.String r4) {
        /*
            r3 = this;
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r4)
            android.os.Bundle r0 = r3.zzaa()
            r1 = 0
            if (r0 != 0) goto L_0x0019
            com.google.android.gms.measurement.internal.zzej r4 = r3.zzr()
            com.google.android.gms.measurement.internal.zzel r4 = r4.zzf()
            java.lang.String r0 = "Failed to load metadata: Metadata bundle is null"
            r4.zza(r0)
        L_0x0017:
            r4 = r1
            goto L_0x0028
        L_0x0019:
            boolean r2 = r0.containsKey(r4)
            if (r2 != 0) goto L_0x0020
            goto L_0x0017
        L_0x0020:
            int r4 = r0.getInt(r4)
            java.lang.Integer r4 = java.lang.Integer.valueOf(r4)
        L_0x0028:
            if (r4 != 0) goto L_0x002b
            return r1
        L_0x002b:
            android.content.Context r0 = r3.zzn()     // Catch:{ NotFoundException -> 0x0043 }
            android.content.res.Resources r0 = r0.getResources()     // Catch:{ NotFoundException -> 0x0043 }
            int r4 = r4.intValue()     // Catch:{ NotFoundException -> 0x0043 }
            java.lang.String[] r4 = r0.getStringArray(r4)     // Catch:{ NotFoundException -> 0x0043 }
            if (r4 != 0) goto L_0x003e
            return r1
        L_0x003e:
            java.util.List r4 = java.util.Arrays.asList(r4)     // Catch:{ NotFoundException -> 0x0043 }
            return r4
        L_0x0043:
            r4 = move-exception
            com.google.android.gms.measurement.internal.zzej r0 = r3.zzr()
            com.google.android.gms.measurement.internal.zzel r0 = r0.zzf()
            java.lang.String r2 = "Failed to load string array from metadata: resource not found"
            r0.zza(r2, r4)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzs.zzc(java.lang.String):java.util.List");
    }

    public final boolean zzh() {
        zzu();
        Boolean zzb2 = zzb("firebase_analytics_collection_deactivated");
        return zzb2 != null && zzb2.booleanValue();
    }

    public final Boolean zzi() {
        zzu();
        return zzb("firebase_analytics_collection_enabled");
    }

    public final Boolean zzj() {
        zzb();
        Boolean zzb2 = zzb("google_analytics_adid_collection_enabled");
        return Boolean.valueOf(zzb2 == null || zzb2.booleanValue());
    }

    public static long zzk() {
        return zzak.zzag.zza(null).longValue();
    }

    public static long zzv() {
        return zzak.zzg.zza(null).longValue();
    }

    public final String zzw() {
        return zza("debug.firebase.analytics.app", "");
    }

    public final String zzx() {
        return zza("debug.deferred.deeplink", "");
    }

    private final String zza(String str, String str2) {
        try {
            return (String) Class.forName("android.os.SystemProperties").getMethod("get", new Class[]{String.class, String.class}).invoke((Object) null, new Object[]{str, str2});
        } catch (ClassNotFoundException e) {
            zzr().zzf().zza("Could not find SystemProperties class", e);
            return str2;
        } catch (NoSuchMethodException e2) {
            zzr().zzf().zza("Could not find SystemProperties.get() method", e2);
            return str2;
        } catch (IllegalAccessException e3) {
            zzr().zzf().zza("Could not access SystemProperties.get()", e3);
            return str2;
        } catch (InvocationTargetException e4) {
            zzr().zzf().zza("SystemProperties.get() threw an exception", e4);
            return str2;
        }
    }

    public static boolean zzy() {
        return zzak.zzc.zza(null).booleanValue();
    }

    public final boolean zzd(String str) {
        return "1".equals(this.zzb.zza(str, "gaia_collection_enabled"));
    }

    public final boolean zze(String str) {
        return "1".equals(this.zzb.zza(str, "measurement.event_sampling_enabled"));
    }

    /* access modifiers changed from: package-private */
    @WorkerThread
    public final boolean zzf(String str) {
        return zzd(str, zzak.zzaq);
    }

    /* access modifiers changed from: package-private */
    @WorkerThread
    public final boolean zzg(String str) {
        return zzd(str, zzak.zzak);
    }

    /* access modifiers changed from: package-private */
    @WorkerThread
    public final String zzh(String str) {
        zzdy<String> zzdy = zzak.zzal;
        if (str == null) {
            return zzdy.zza(null);
        }
        return zzdy.zza(this.zzb.zza(str, zzdy.zza()));
    }

    /* access modifiers changed from: package-private */
    public final boolean zzi(String str) {
        return zzd(str, zzak.zzar);
    }

    /* access modifiers changed from: package-private */
    @WorkerThread
    public final boolean zzj(String str) {
        return zzd(str, zzak.zzas);
    }

    /* access modifiers changed from: package-private */
    @WorkerThread
    public final boolean zzk(String str) {
        return zzd(str, zzak.zzat);
    }

    /* access modifiers changed from: package-private */
    @WorkerThread
    public final boolean zzl(String str) {
        return zzd(str, zzak.zzav);
    }

    /* access modifiers changed from: package-private */
    @WorkerThread
    public final boolean zzz() {
        if (this.zza == null) {
            this.zza = zzb("app_measurement_lite");
            if (this.zza == null) {
                this.zza = false;
            }
        }
        if (this.zza.booleanValue() || !this.zzw.zzt()) {
            return true;
        }
        return false;
    }

    /* access modifiers changed from: package-private */
    @WorkerThread
    public final boolean zzm(String str) {
        return zzd(str, zzak.zzau);
    }

    /* access modifiers changed from: package-private */
    @WorkerThread
    public final boolean zzn(String str) {
        return zzd(str, zzak.zzaw);
    }

    /* access modifiers changed from: package-private */
    @WorkerThread
    public final boolean zzo(String str) {
        return zzd(str, zzak.zzax);
    }

    /* access modifiers changed from: package-private */
    @WorkerThread
    public final boolean zzp(String str) {
        return zzd(str, zzak.zzay);
    }

    /* access modifiers changed from: package-private */
    @WorkerThread
    public final boolean zzq(String str) {
        return zzd(str, zzak.zzaz);
    }

    /* access modifiers changed from: package-private */
    @WorkerThread
    public final boolean zzr(String str) {
        return zzd(str, zzak.zzbe);
    }

    /* access modifiers changed from: package-private */
    @WorkerThread
    public final boolean zzs(String str) {
        return zzd(str, zzak.zzbn);
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
