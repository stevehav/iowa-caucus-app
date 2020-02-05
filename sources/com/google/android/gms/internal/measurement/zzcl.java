package com.google.android.gms.internal.measurement;

import android.annotation.SuppressLint;
import android.content.Context;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.0.1 */
public abstract class zzcl<T> {
    private static final Object zza = new Object();
    @SuppressLint({"StaticFieldLeak"})
    private static Context zzb = null;
    private static boolean zzc = false;
    private static zzcz<zzch> zzd;
    private static final AtomicInteger zzh = new AtomicInteger();
    private final zzcr zze;
    private final String zzf;
    private final T zzg;
    private volatile int zzi;
    private volatile T zzj;

    public static void zza(Context context) {
        synchronized (zza) {
            Context applicationContext = context.getApplicationContext();
            if (applicationContext != null) {
                context = applicationContext;
            }
            if (zzb != context) {
                zzbx.zzc();
                zzcu.zza();
                zzcg.zza();
                zzh.incrementAndGet();
                zzb = context;
                zzd = zzdc.zza(zzco.zza);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public abstract T zza(Object obj);

    static void zza() {
        zzh.incrementAndGet();
    }

    private zzcl(zzcr zzcr, String str, T t) {
        this.zzi = -1;
        if (zzcr.zzb != null) {
            this.zze = zzcr;
            this.zzf = str;
            this.zzg = t;
            return;
        }
        throw new IllegalArgumentException("Must pass a valid SharedPreferences file name or ContentProvider URI");
    }

    private final String zza(String str) {
        if (str != null && str.isEmpty()) {
            return this.zzf;
        }
        String valueOf = String.valueOf(str);
        String valueOf2 = String.valueOf(this.zzf);
        return valueOf2.length() != 0 ? valueOf.concat(valueOf2) : new String(valueOf);
    }

    public final String zzb() {
        return zza(this.zze.zzd);
    }

    /* JADX WARNING: Removed duplicated region for block: B:38:0x00b9  */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x00ba  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final T zzc() {
        /*
            r6 = this;
            java.util.concurrent.atomic.AtomicInteger r0 = zzh
            int r0 = r0.get()
            int r1 = r6.zzi
            if (r1 >= r0) goto L_0x00ea
            monitor-enter(r6)
            int r1 = r6.zzi     // Catch:{ all -> 0x00e7 }
            if (r1 >= r0) goto L_0x00e5
            android.content.Context r1 = zzb     // Catch:{ all -> 0x00e7 }
            if (r1 == 0) goto L_0x00dd
            com.google.android.gms.internal.measurement.zzcz<com.google.android.gms.internal.measurement.zzch> r1 = zzd     // Catch:{ all -> 0x00e7 }
            java.lang.Object r1 = r1.zza()     // Catch:{ all -> 0x00e7 }
            com.google.android.gms.internal.measurement.zzch r1 = (com.google.android.gms.internal.measurement.zzch) r1     // Catch:{ all -> 0x00e7 }
            com.google.android.gms.internal.measurement.zzcr r2 = r6.zze     // Catch:{ all -> 0x00e7 }
            android.net.Uri r2 = r2.zzb     // Catch:{ all -> 0x00e7 }
            com.google.android.gms.internal.measurement.zzcr r3 = r6.zze     // Catch:{ all -> 0x00e7 }
            java.lang.String r3 = r3.zzd     // Catch:{ all -> 0x00e7 }
            java.lang.String r4 = r6.zzf     // Catch:{ all -> 0x00e7 }
            r5 = 0
            java.lang.String r1 = r1.zza(r2, r5, r3, r4)     // Catch:{ all -> 0x00e7 }
            if (r1 == 0) goto L_0x0032
            java.lang.Object r1 = r6.zza((java.lang.Object) r1)     // Catch:{ all -> 0x00e7 }
            goto L_0x00d8
        L_0x0032:
            android.content.Context r1 = zzb     // Catch:{ all -> 0x00e7 }
            com.google.android.gms.internal.measurement.zzcg r1 = com.google.android.gms.internal.measurement.zzcg.zza((android.content.Context) r1)     // Catch:{ all -> 0x00e7 }
            java.lang.String r2 = "gms:phenotype:phenotype_flag:debug_bypass_phenotype"
            java.lang.Object r1 = r1.zza((java.lang.String) r2)     // Catch:{ all -> 0x00e7 }
            java.lang.String r1 = (java.lang.String) r1     // Catch:{ all -> 0x00e7 }
            if (r1 == 0) goto L_0x0050
            java.util.regex.Pattern r2 = com.google.android.gms.internal.measurement.zzbw.zzb     // Catch:{ all -> 0x00e7 }
            java.util.regex.Matcher r1 = r2.matcher(r1)     // Catch:{ all -> 0x00e7 }
            boolean r1 = r1.matches()     // Catch:{ all -> 0x00e7 }
            if (r1 == 0) goto L_0x0050
            r1 = 1
            goto L_0x0051
        L_0x0050:
            r1 = 0
        L_0x0051:
            if (r1 != 0) goto L_0x008d
            com.google.android.gms.internal.measurement.zzcr r1 = r6.zze     // Catch:{ all -> 0x00e7 }
            android.net.Uri r1 = r1.zzb     // Catch:{ all -> 0x00e7 }
            if (r1 == 0) goto L_0x0076
            android.content.Context r1 = zzb     // Catch:{ all -> 0x00e7 }
            com.google.android.gms.internal.measurement.zzcr r2 = r6.zze     // Catch:{ all -> 0x00e7 }
            android.net.Uri r2 = r2.zzb     // Catch:{ all -> 0x00e7 }
            boolean r1 = com.google.android.gms.internal.measurement.zzcj.zza(r1, r2)     // Catch:{ all -> 0x00e7 }
            if (r1 == 0) goto L_0x0074
            android.content.Context r1 = zzb     // Catch:{ all -> 0x00e7 }
            android.content.ContentResolver r1 = r1.getContentResolver()     // Catch:{ all -> 0x00e7 }
            com.google.android.gms.internal.measurement.zzcr r2 = r6.zze     // Catch:{ all -> 0x00e7 }
            android.net.Uri r2 = r2.zzb     // Catch:{ all -> 0x00e7 }
            com.google.android.gms.internal.measurement.zzbx r1 = com.google.android.gms.internal.measurement.zzbx.zza(r1, r2)     // Catch:{ all -> 0x00e7 }
            goto L_0x007c
        L_0x0074:
            r1 = r5
            goto L_0x007c
        L_0x0076:
            android.content.Context r1 = zzb     // Catch:{ all -> 0x00e7 }
            com.google.android.gms.internal.measurement.zzcu r1 = com.google.android.gms.internal.measurement.zzcu.zza((android.content.Context) r1, (java.lang.String) r5)     // Catch:{ all -> 0x00e7 }
        L_0x007c:
            if (r1 == 0) goto L_0x00b6
            java.lang.String r2 = r6.zzb()     // Catch:{ all -> 0x00e7 }
            java.lang.Object r1 = r1.zza(r2)     // Catch:{ all -> 0x00e7 }
            if (r1 == 0) goto L_0x00b6
            java.lang.Object r1 = r6.zza((java.lang.Object) r1)     // Catch:{ all -> 0x00e7 }
            goto L_0x00b7
        L_0x008d:
            java.lang.String r1 = "PhenotypeFlag"
            r2 = 3
            boolean r1 = android.util.Log.isLoggable(r1, r2)     // Catch:{ all -> 0x00e7 }
            if (r1 == 0) goto L_0x00b6
            java.lang.String r1 = "PhenotypeFlag"
            java.lang.String r2 = "Bypass reading Phenotype values for flag: "
            java.lang.String r3 = r6.zzb()     // Catch:{ all -> 0x00e7 }
            java.lang.String r3 = java.lang.String.valueOf(r3)     // Catch:{ all -> 0x00e7 }
            int r4 = r3.length()     // Catch:{ all -> 0x00e7 }
            if (r4 == 0) goto L_0x00ad
            java.lang.String r2 = r2.concat(r3)     // Catch:{ all -> 0x00e7 }
            goto L_0x00b3
        L_0x00ad:
            java.lang.String r3 = new java.lang.String     // Catch:{ all -> 0x00e7 }
            r3.<init>(r2)     // Catch:{ all -> 0x00e7 }
            r2 = r3
        L_0x00b3:
            android.util.Log.d(r1, r2)     // Catch:{ all -> 0x00e7 }
        L_0x00b6:
            r1 = r5
        L_0x00b7:
            if (r1 == 0) goto L_0x00ba
            goto L_0x00d8
        L_0x00ba:
            android.content.Context r1 = zzb     // Catch:{ all -> 0x00e7 }
            com.google.android.gms.internal.measurement.zzcg r1 = com.google.android.gms.internal.measurement.zzcg.zza((android.content.Context) r1)     // Catch:{ all -> 0x00e7 }
            com.google.android.gms.internal.measurement.zzcr r2 = r6.zze     // Catch:{ all -> 0x00e7 }
            java.lang.String r2 = r2.zzc     // Catch:{ all -> 0x00e7 }
            java.lang.String r2 = r6.zza((java.lang.String) r2)     // Catch:{ all -> 0x00e7 }
            java.lang.Object r1 = r1.zza(r2)     // Catch:{ all -> 0x00e7 }
            if (r1 == 0) goto L_0x00d2
            java.lang.Object r5 = r6.zza((java.lang.Object) r1)     // Catch:{ all -> 0x00e7 }
        L_0x00d2:
            r1 = r5
            if (r1 == 0) goto L_0x00d6
            goto L_0x00d8
        L_0x00d6:
            T r1 = r6.zzg     // Catch:{ all -> 0x00e7 }
        L_0x00d8:
            r6.zzj = r1     // Catch:{ all -> 0x00e7 }
            r6.zzi = r0     // Catch:{ all -> 0x00e7 }
            goto L_0x00e5
        L_0x00dd:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException     // Catch:{ all -> 0x00e7 }
            java.lang.String r1 = "Must call PhenotypeFlag.init() first"
            r0.<init>(r1)     // Catch:{ all -> 0x00e7 }
            throw r0     // Catch:{ all -> 0x00e7 }
        L_0x00e5:
            monitor-exit(r6)     // Catch:{ all -> 0x00e7 }
            goto L_0x00ea
        L_0x00e7:
            r0 = move-exception
            monitor-exit(r6)     // Catch:{ all -> 0x00e7 }
            throw r0
        L_0x00ea:
            T r0 = r6.zzj
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.zzcl.zzc():java.lang.Object");
    }

    /* access modifiers changed from: private */
    public static zzcl<Long> zzb(zzcr zzcr, String str, long j) {
        return new zzcn(zzcr, str, Long.valueOf(j));
    }

    /* access modifiers changed from: private */
    public static zzcl<Boolean> zzb(zzcr zzcr, String str, boolean z) {
        return new zzcq(zzcr, str, Boolean.valueOf(z));
    }

    /* access modifiers changed from: private */
    public static zzcl<Double> zzb(zzcr zzcr, String str, double d) {
        return new zzcp(zzcr, str, Double.valueOf(d));
    }

    /* access modifiers changed from: private */
    public static zzcl<String> zzb(zzcr zzcr, String str, String str2) {
        return new zzcs(zzcr, str, str2);
    }

    static final /* synthetic */ zzch zzd() {
        new zzck();
        return zzck.zza(zzb);
    }

    /* synthetic */ zzcl(zzcr zzcr, String str, Object obj, zzcn zzcn) {
        this(zzcr, str, obj);
    }
}
