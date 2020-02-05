package com.google.android.gms.internal.measurement;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.RemoteException;
import android.util.Log;
import android.util.Pair;
import androidx.annotation.NonNull;
import androidx.annotation.Size;
import androidx.annotation.WorkerThread;
import com.google.android.gms.common.api.internal.GoogleServices;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.Clock;
import com.google.android.gms.common.util.DefaultClock;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.common.wrappers.Wrappers;
import com.google.android.gms.dynamite.DynamiteModule;
import com.google.android.gms.dynamite.descriptors.com.google.android.gms.measurement.dynamite.ModuleDescriptor;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import com.google.android.gms.measurement.internal.zzgo;
import com.google.android.gms.measurement.internal.zzgr;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* compiled from: com.google.android.gms:play-services-measurement-sdk-api@@17.0.1 */
public class zzz {
    private static volatile zzz zzb = null;
    private static Boolean zzh = null;
    /* access modifiers changed from: private */
    public static Boolean zzi = null;
    private static boolean zzj = false;
    private static Boolean zzk = null;
    @VisibleForTesting
    private static String zzl = "use_dynamite_api";
    @VisibleForTesting
    private static String zzm = "allow_remote_dynamite";
    private static boolean zzn = false;
    private static boolean zzo = false;
    protected final Clock zza;
    /* access modifiers changed from: private */
    public final String zzc;
    private final ExecutorService zzd;
    private final AppMeasurementSdk zze;
    /* access modifiers changed from: private */
    public List<Pair<zzgr, zzd>> zzf;
    private int zzg;
    /* access modifiers changed from: private */
    public boolean zzp;
    private String zzq;
    /* access modifiers changed from: private */
    public zzk zzr;

    /* compiled from: com.google.android.gms:play-services-measurement-sdk-api@@17.0.1 */
    class zzc implements Application.ActivityLifecycleCallbacks {
        zzc() {
        }

        public final void onActivityCreated(Activity activity, Bundle bundle) {
            zzz.this.zza((zzb) new zzbd(this, activity, bundle));
        }

        public final void onActivityStarted(Activity activity) {
            zzz.this.zza((zzb) new zzbc(this, activity));
        }

        public final void onActivityResumed(Activity activity) {
            zzz.this.zza((zzb) new zzbf(this, activity));
        }

        public final void onActivityPaused(Activity activity) {
            zzz.this.zza((zzb) new zzbe(this, activity));
        }

        public final void onActivityStopped(Activity activity) {
            zzz.this.zza((zzb) new zzbh(this, activity));
        }

        public final void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
            zzl zzl = new zzl();
            zzz.this.zza((zzb) new zzbg(this, activity, zzl));
            Bundle zzb = zzl.zzb(50);
            if (zzb != null) {
                bundle.putAll(zzb);
            }
        }

        public final void onActivityDestroyed(Activity activity) {
            zzz.this.zza((zzb) new zzbi(this, activity));
        }
    }

    public static zzz zza(@NonNull Context context) {
        return zza(context, (String) null, (String) null, (String) null, (Bundle) null);
    }

    /* compiled from: com.google.android.gms:play-services-measurement-sdk-api@@17.0.1 */
    abstract class zzb implements Runnable {
        final long zza;
        final long zzb;
        private final boolean zzc;

        zzb(zzz zzz) {
            this(true);
        }

        /* access modifiers changed from: package-private */
        public abstract void zza() throws RemoteException;

        /* access modifiers changed from: protected */
        public void zzb() {
        }

        zzb(boolean z) {
            this.zza = zzz.this.zza.currentTimeMillis();
            this.zzb = zzz.this.zza.elapsedRealtime();
            this.zzc = z;
        }

        public void run() {
            if (zzz.this.zzp) {
                zzb();
                return;
            }
            try {
                zza();
            } catch (Exception e) {
                zzz.this.zza(e, false, this.zzc);
                zzb();
            }
        }
    }

    public static zzz zza(Context context, String str, String str2, String str3, Bundle bundle) {
        Preconditions.checkNotNull(context);
        if (zzb == null) {
            synchronized (zzz.class) {
                if (zzb == null) {
                    zzb = new zzz(context, str, str2, str3, bundle);
                }
            }
        }
        return zzb;
    }

    /* compiled from: com.google.android.gms:play-services-measurement-sdk-api@@17.0.1 */
    static class zza extends zzt {
        private final zzgo zza;

        zza(zzgo zzgo) {
            this.zza = zzgo;
        }

        public final void zza(String str, String str2, Bundle bundle, long j) {
            this.zza.interceptEvent(str, str2, bundle, j);
        }

        public final int zza() {
            return System.identityHashCode(this.zza);
        }
    }

    /* compiled from: com.google.android.gms:play-services-measurement-sdk-api@@17.0.1 */
    static class zzd extends zzt {
        private final zzgr zza;

        zzd(zzgr zzgr) {
            this.zza = zzgr;
        }

        public final void zza(String str, String str2, Bundle bundle, long j) {
            this.zza.onEvent(str, str2, bundle, j);
        }

        public final int zza() {
            return System.identityHashCode(this.zza);
        }
    }

    public final AppMeasurementSdk zza() {
        return this.zze;
    }

    private zzz(Context context, String str, String str2, String str3, Bundle bundle) {
        if (str == null || !zzc(str2, str3)) {
            this.zzc = "FA";
        } else {
            this.zzc = str;
        }
        this.zza = DefaultClock.getInstance();
        this.zzd = new ThreadPoolExecutor(0, 1, 30, TimeUnit.SECONDS, new LinkedBlockingQueue());
        this.zze = new AppMeasurementSdk(this);
        boolean z = false;
        if (!(!zzf(context) || zzk())) {
            this.zzq = null;
            this.zzp = true;
            Log.w(this.zzc, "Disabling data collection. Found google_app_id in strings.xml but Google Analytics for Firebase is missing. Remove this value or add Google Analytics for Firebase to resume data collection.");
            return;
        }
        if (!zzc(str2, str3)) {
            this.zzq = "fa";
            if (str2 == null || str3 == null) {
                if ((str2 == null) ^ (str3 == null ? true : z)) {
                    Log.w(this.zzc, "Specified origin or custom app id is null. Both parameters will be ignored.");
                }
            } else {
                Log.v(this.zzc, "Deferring to Google Analytics for Firebase for event data collection. https://goo.gl/J1sWQy");
                this.zzp = true;
                return;
            }
        } else {
            this.zzq = str2;
        }
        zza((zzb) new zzy(this, str2, str3, context, bundle));
        Application application = (Application) context.getApplicationContext();
        if (application == null) {
            Log.w(this.zzc, "Unable to register lifecycle notifications. Application null.");
        } else {
            application.registerActivityLifecycleCallbacks(new zzc());
        }
    }

    private static boolean zzf(Context context) {
        try {
            GoogleServices.initialize(context);
            if (GoogleServices.getGoogleAppId() != null) {
                return true;
            }
            return false;
        } catch (IllegalStateException unused) {
        }
    }

    /* access modifiers changed from: private */
    public static boolean zzc(String str, String str2) {
        return (str2 == null || str == null || zzk()) ? false : true;
    }

    /* access modifiers changed from: private */
    public final void zza(zzb zzb2) {
        this.zzd.execute(zzb2);
    }

    /* access modifiers changed from: protected */
    public final zzk zza(Context context, boolean z) {
        DynamiteModule.VersionPolicy versionPolicy;
        if (z) {
            try {
                versionPolicy = DynamiteModule.PREFER_HIGHEST_OR_REMOTE_VERSION;
            } catch (DynamiteModule.LoadingException e) {
                zza((Exception) e, true, false);
                return null;
            }
        } else {
            versionPolicy = DynamiteModule.PREFER_LOCAL;
        }
        return zzn.asInterface(DynamiteModule.load(context, versionPolicy, ModuleDescriptor.MODULE_ID).instantiate("com.google.android.gms.measurement.internal.AppMeasurementDynamiteService"));
    }

    /* access modifiers changed from: private */
    public static int zzg(Context context) {
        return DynamiteModule.getRemoteVersion(context, ModuleDescriptor.MODULE_ID);
    }

    /* access modifiers changed from: private */
    public static int zzh(Context context) {
        return DynamiteModule.getLocalVersion(context, ModuleDescriptor.MODULE_ID);
    }

    /* access modifiers changed from: private */
    public final void zza(Exception exc, boolean z, boolean z2) {
        this.zzp |= z;
        if (z) {
            Log.w(this.zzc, "Data collection startup failed. No data will be collected.", exc);
            return;
        }
        if (z2) {
            zza(5, "Error with data collection. Data lost.", (Object) exc, (Object) null, (Object) null);
        }
        Log.w(this.zzc, "Error with data collection. Data lost.", exc);
    }

    private static boolean zzk() {
        try {
            Class.forName("com.google.firebase.analytics.FirebaseAnalytics");
            return true;
        } catch (ClassNotFoundException unused) {
            return false;
        }
    }

    public final void zza(zzgo zzgo) {
        zza((zzb) new zzal(this, zzgo));
    }

    public final void zza(zzgr zzgr) {
        Preconditions.checkNotNull(zzgr);
        zza((zzb) new zzau(this, zzgr));
    }

    public final void zzb(zzgr zzgr) {
        Preconditions.checkNotNull(zzgr);
        zza((zzb) new zzaz(this, zzgr));
    }

    public final void zza(@NonNull String str, Bundle bundle) {
        zza((String) null, str, bundle, false, true, (Long) null);
    }

    public final void zza(String str, String str2, Bundle bundle) {
        zza(str, str2, bundle, true, true, (Long) null);
    }

    public final void zza(String str, String str2, Bundle bundle, long j) {
        zza(str, str2, bundle, true, false, Long.valueOf(j));
    }

    private final void zza(String str, String str2, Bundle bundle, boolean z, boolean z2, Long l) {
        zza((zzb) new zzay(this, l, str, str2, bundle, z, z2));
    }

    public final void zza(String str, String str2) {
        zza((String) null, str, (Object) str2, false);
    }

    public final void zza(String str, String str2, Object obj) {
        zza(str, str2, obj, true);
    }

    private final void zza(String str, String str2, Object obj, boolean z) {
        zza((zzb) new zzbb(this, str, str2, obj, z));
    }

    public final void zza(Bundle bundle) {
        zza((zzb) new zzba(this, bundle));
    }

    public final void zzb(String str, String str2, Bundle bundle) {
        zza((zzb) new zzab(this, str, str2, bundle));
    }

    public final List<Bundle> zzb(String str, String str2) {
        zzl zzl2 = new zzl();
        zza((zzb) new zzaa(this, str, str2, zzl2));
        List<Bundle> list = (List) zzl.zza(zzl2.zzb(5000), List.class);
        return list == null ? Collections.emptyList() : list;
    }

    public final void zza(String str) {
        zza((zzb) new zzad(this, str));
    }

    public final void zza(Activity activity, String str, String str2) {
        zza((zzb) new zzac(this, activity, str, str2));
    }

    public final void zza(boolean z) {
        zza((zzb) new zzaf(this, z));
    }

    public final void zzb() {
        zza((zzb) new zzae(this));
    }

    public final void zza(long j) {
        zza((zzb) new zzah(this, j));
    }

    public final void zzb(long j) {
        zza((zzb) new zzag(this, j));
    }

    public final void zzb(String str) {
        zza((zzb) new zzaj(this, str));
    }

    public final void zzc(String str) {
        zza((zzb) new zzai(this, str));
    }

    public final String zzc() {
        zzl zzl2 = new zzl();
        zza((zzb) new zzak(this, zzl2));
        return zzl2.zza(500);
    }

    public final String zzd() {
        zzl zzl2 = new zzl();
        zza((zzb) new zzan(this, zzl2));
        return zzl2.zza(50);
    }

    public final long zze() {
        zzl zzl2 = new zzl();
        zza((zzb) new zzam(this, zzl2));
        Long l = (Long) zzl.zza(zzl2.zzb(500), Long.class);
        if (l != null) {
            return l.longValue();
        }
        long nextLong = new Random(System.nanoTime() ^ this.zza.currentTimeMillis()).nextLong();
        int i = this.zzg + 1;
        this.zzg = i;
        return nextLong + ((long) i);
    }

    public final String zzf() {
        zzl zzl2 = new zzl();
        zza((zzb) new zzap(this, zzl2));
        return zzl2.zza(500);
    }

    public final String zzg() {
        zzl zzl2 = new zzl();
        zza((zzb) new zzao(this, zzl2));
        return zzl2.zza(500);
    }

    public final Map<String, Object> zza(String str, String str2, boolean z) {
        zzl zzl2 = new zzl();
        zza((zzb) new zzar(this, str, str2, z, zzl2));
        Bundle zzb2 = zzl2.zzb(5000);
        if (zzb2 == null || zzb2.size() == 0) {
            return Collections.emptyMap();
        }
        HashMap hashMap = new HashMap(zzb2.size());
        for (String str3 : zzb2.keySet()) {
            Object obj = zzb2.get(str3);
            if ((obj instanceof Double) || (obj instanceof Long) || (obj instanceof String)) {
                hashMap.put(str3, obj);
            }
        }
        return hashMap;
    }

    public final void zza(int i, String str, Object obj, Object obj2, Object obj3) {
        zza((zzb) new zzaq(this, false, 5, str, obj, (Object) null, (Object) null));
    }

    public final Bundle zza(Bundle bundle, boolean z) {
        zzl zzl2 = new zzl();
        zza((zzb) new zzat(this, bundle, zzl2));
        if (z) {
            return zzl2.zzb(5000);
        }
        return null;
    }

    public final int zzd(String str) {
        zzl zzl2 = new zzl();
        zza((zzb) new zzas(this, str, zzl2));
        Integer num = (Integer) zzl.zza(zzl2.zzb(10000), Integer.class);
        if (num == null) {
            return 25;
        }
        return num.intValue();
    }

    @WorkerThread
    public final String zzh() {
        zzl zzl2 = new zzl();
        zza((zzb) new zzav(this, zzl2));
        return zzl2.zza(120000);
    }

    public final String zzi() {
        return this.zzq;
    }

    public final Object zza(int i) {
        zzl zzl2 = new zzl();
        zza((zzb) new zzax(this, zzl2, i));
        return zzl.zza(zzl2.zzb(15000), Object.class);
    }

    public final void zzb(boolean z) {
        zza((zzb) new zzaw(this, z));
    }

    /* access modifiers changed from: private */
    public static void zzi(Context context) {
        synchronized (zzz.class) {
            try {
                if (zzh != null && zzi != null) {
                    return;
                }
                if (zza(context, "app_measurement_internal_disable_startup_flags")) {
                    zzh = false;
                    zzi = false;
                    return;
                }
                SharedPreferences sharedPreferences = context.getSharedPreferences("com.google.android.gms.measurement.prefs", 0);
                zzh = Boolean.valueOf(sharedPreferences.getBoolean(zzl, false));
                zzi = Boolean.valueOf(sharedPreferences.getBoolean(zzm, false));
                SharedPreferences.Editor edit = sharedPreferences.edit();
                edit.remove(zzl);
                edit.remove(zzm);
                edit.apply();
            } catch (Exception e) {
                Log.e("FA", "Exception reading flag from SharedPreferences.", e);
                zzh = false;
                zzi = false;
            }
        }
    }

    public static boolean zzb(Context context) {
        zzi(context);
        synchronized (zzz.class) {
            if (!zzj) {
                try {
                    String str = (String) Class.forName("android.os.SystemProperties").getMethod("get", new Class[]{String.class, String.class}).invoke((Object) null, new Object[]{"measurement.dynamite.enabled", ""});
                    if ("true".equals(str)) {
                        zzk = true;
                    } else if ("false".equals(str)) {
                        zzk = false;
                    } else {
                        zzk = null;
                    }
                    zzj = true;
                } catch (Exception e) {
                    try {
                        Log.e("FA", "Unable to call SystemProperties.get()", e);
                        zzk = null;
                    } finally {
                        zzj = true;
                    }
                }
            }
        }
        Boolean bool = zzk;
        if (bool == null) {
            bool = zzh;
        }
        return bool.booleanValue();
    }

    private static boolean zza(Context context, @Size(min = 1) String str) {
        Preconditions.checkNotEmpty(str);
        try {
            ApplicationInfo applicationInfo = Wrappers.packageManager(context).getApplicationInfo(context.getPackageName(), 128);
            if (applicationInfo != null) {
                if (applicationInfo.metaData != null) {
                    return applicationInfo.metaData.getBoolean(str);
                }
            }
        } catch (PackageManager.NameNotFoundException unused) {
        }
        return false;
    }
}
