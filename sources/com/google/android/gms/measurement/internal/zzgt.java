package com.google.android.gms.measurement.internal;

import android.app.Application;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import androidx.annotation.WorkerThread;
import androidx.collection.ArrayMap;
import com.google.android.gms.common.api.internal.GoogleServices;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.Clock;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.0.1 */
public final class zzgt extends zzg {
    @VisibleForTesting
    protected zzhm zza;
    @VisibleForTesting
    protected boolean zzb = true;
    private zzgo zzc;
    private final Set<zzgr> zzd = new CopyOnWriteArraySet();
    private boolean zze;
    private final AtomicReference<String> zzf = new AtomicReference<>();

    protected zzgt(zzfn zzfn) {
        super(zzfn);
    }

    /* access modifiers changed from: protected */
    public final boolean zzz() {
        return false;
    }

    public final void zzab() {
        if (zzn().getApplicationContext() instanceof Application) {
            ((Application) zzn().getApplicationContext()).unregisterActivityLifecycleCallbacks(this.zza);
        }
    }

    public final Boolean zzac() {
        AtomicReference atomicReference = new AtomicReference();
        return (Boolean) zzq().zza(atomicReference, 15000, "boolean test flag value", new zzgv(this, atomicReference));
    }

    public final String zzad() {
        AtomicReference atomicReference = new AtomicReference();
        return (String) zzq().zza(atomicReference, 15000, "String test flag value", new zzhf(this, atomicReference));
    }

    public final Long zzae() {
        AtomicReference atomicReference = new AtomicReference();
        return (Long) zzq().zza(atomicReference, 15000, "long test flag value", new zzhh(this, atomicReference));
    }

    public final Integer zzaf() {
        AtomicReference atomicReference = new AtomicReference();
        return (Integer) zzq().zza(atomicReference, 15000, "int test flag value", new zzhg(this, atomicReference));
    }

    public final Double zzag() {
        AtomicReference atomicReference = new AtomicReference();
        return (Double) zzq().zza(atomicReference, 15000, "double test flag value", new zzhj(this, atomicReference));
    }

    public final void zza(boolean z) {
        zzw();
        zzb();
        zzq().zza((Runnable) new zzhi(this, z));
    }

    public final void zzb(boolean z) {
        zzw();
        zzb();
        zzq().zza((Runnable) new zzhl(this, z));
    }

    /* access modifiers changed from: private */
    @WorkerThread
    public final void zzd(boolean z) {
        zzd();
        zzb();
        zzw();
        zzr().zzw().zza("Setting app measurement enabled (FE)", Boolean.valueOf(z));
        zzs().zzb(z);
        zzam();
    }

    /* access modifiers changed from: private */
    @WorkerThread
    public final void zzam() {
        if (zzt().zze(zzg().zzab(), zzak.zzbh)) {
            zzd();
            String zza2 = zzs().zzn.zza();
            if (zza2 != null) {
                if ("unset".equals(zza2)) {
                    zza("app", "_npa", (Object) null, zzm().currentTimeMillis());
                } else {
                    zza("app", "_npa", (Object) Long.valueOf("true".equals(zza2) ? 1 : 0), zzm().currentTimeMillis());
                }
            }
        }
        if (!this.zzw.zzab() || !this.zzb) {
            zzr().zzw().zza("Updating Scion state (FE)");
            zzh().zzac();
            return;
        }
        zzr().zzw().zza("Recording app launch after enabling measurement for the first time (FE)");
        zzai();
    }

    public final void zza(long j) {
        zzb();
        zzq().zza((Runnable) new zzhk(this, j));
    }

    public final void zzb(long j) {
        zzb();
        zzq().zza((Runnable) new zzhn(this, j));
    }

    public final void zza(String str, String str2, Bundle bundle, boolean z) {
        zza(str, str2, bundle, false, true, zzm().currentTimeMillis());
    }

    public final void zza(String str, String str2, Bundle bundle) {
        zza(str, str2, bundle, true, true, zzm().currentTimeMillis());
    }

    /* access modifiers changed from: package-private */
    @WorkerThread
    public final void zzb(String str, String str2, Bundle bundle) {
        zzb();
        zzd();
        zza(str, str2, zzm().currentTimeMillis(), bundle);
    }

    /* access modifiers changed from: package-private */
    @WorkerThread
    public final void zza(String str, String str2, long j, Bundle bundle) {
        zzb();
        zzd();
        zza(str, str2, j, bundle, true, this.zzc == null || zzjx.zze(str2), false, (String) null);
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x0136  */
    @androidx.annotation.WorkerThread
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zza(java.lang.String r28, java.lang.String r29, long r30, android.os.Bundle r32, boolean r33, boolean r34, boolean r35, java.lang.String r36) {
        /*
            r27 = this;
            r7 = r27
            r8 = r28
            r15 = r29
            r13 = r30
            r12 = r32
            r11 = r36
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r28)
            com.google.android.gms.measurement.internal.zzs r0 = r27.zzt()
            com.google.android.gms.measurement.internal.zzdy<java.lang.Boolean> r1 = com.google.android.gms.measurement.internal.zzak.zzbm
            boolean r0 = r0.zze(r11, r1)
            if (r0 != 0) goto L_0x001e
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r29)
        L_0x001e:
            com.google.android.gms.common.internal.Preconditions.checkNotNull(r32)
            r27.zzd()
            r27.zzw()
            com.google.android.gms.measurement.internal.zzfn r0 = r7.zzw
            boolean r0 = r0.zzab()
            if (r0 != 0) goto L_0x003d
            com.google.android.gms.measurement.internal.zzej r0 = r27.zzr()
            com.google.android.gms.measurement.internal.zzel r0 = r0.zzw()
            java.lang.String r1 = "Event not sent since app measurement is disabled"
            r0.zza(r1)
            return
        L_0x003d:
            com.google.android.gms.measurement.internal.zzs r0 = r27.zzt()
            com.google.android.gms.measurement.internal.zzec r1 = r27.zzg()
            java.lang.String r1 = r1.zzab()
            com.google.android.gms.measurement.internal.zzdy<java.lang.Boolean> r2 = com.google.android.gms.measurement.internal.zzak.zzbt
            boolean r0 = r0.zze(r1, r2)
            if (r0 == 0) goto L_0x006f
            com.google.android.gms.measurement.internal.zzec r0 = r27.zzg()
            java.util.List r0 = r0.zzag()
            if (r0 == 0) goto L_0x006f
            boolean r0 = r0.contains(r15)
            if (r0 != 0) goto L_0x006f
            com.google.android.gms.measurement.internal.zzej r0 = r27.zzr()
            com.google.android.gms.measurement.internal.zzel r0 = r0.zzw()
            java.lang.String r1 = "Dropping non-safelisted event. event name, origin"
            r0.zza(r1, r15, r8)
            return
        L_0x006f:
            boolean r0 = r7.zze
            r10 = 0
            r16 = 0
            r9 = 1
            if (r0 != 0) goto L_0x00c8
            r7.zze = r9
            com.google.android.gms.measurement.internal.zzfn r0 = r7.zzw     // Catch:{ ClassNotFoundException -> 0x00bb }
            boolean r0 = r0.zzt()     // Catch:{ ClassNotFoundException -> 0x00bb }
            java.lang.String r1 = "com.google.android.gms.tagmanager.TagManagerService"
            if (r0 != 0) goto L_0x0090
            android.content.Context r0 = r27.zzn()     // Catch:{ ClassNotFoundException -> 0x00bb }
            java.lang.ClassLoader r0 = r0.getClassLoader()     // Catch:{ ClassNotFoundException -> 0x00bb }
            java.lang.Class r0 = java.lang.Class.forName(r1, r9, r0)     // Catch:{ ClassNotFoundException -> 0x00bb }
            goto L_0x0094
        L_0x0090:
            java.lang.Class r0 = java.lang.Class.forName(r1)     // Catch:{ ClassNotFoundException -> 0x00bb }
        L_0x0094:
            java.lang.String r1 = "initialize"
            java.lang.Class[] r2 = new java.lang.Class[r9]     // Catch:{ Exception -> 0x00ac }
            java.lang.Class<android.content.Context> r3 = android.content.Context.class
            r2[r16] = r3     // Catch:{ Exception -> 0x00ac }
            java.lang.reflect.Method r0 = r0.getDeclaredMethod(r1, r2)     // Catch:{ Exception -> 0x00ac }
            java.lang.Object[] r1 = new java.lang.Object[r9]     // Catch:{ Exception -> 0x00ac }
            android.content.Context r2 = r27.zzn()     // Catch:{ Exception -> 0x00ac }
            r1[r16] = r2     // Catch:{ Exception -> 0x00ac }
            r0.invoke(r10, r1)     // Catch:{ Exception -> 0x00ac }
            goto L_0x00c8
        L_0x00ac:
            r0 = move-exception
            com.google.android.gms.measurement.internal.zzej r1 = r27.zzr()     // Catch:{ ClassNotFoundException -> 0x00bb }
            com.google.android.gms.measurement.internal.zzel r1 = r1.zzi()     // Catch:{ ClassNotFoundException -> 0x00bb }
            java.lang.String r2 = "Failed to invoke Tag Manager's initialize() method"
            r1.zza(r2, r0)     // Catch:{ ClassNotFoundException -> 0x00bb }
            goto L_0x00c8
        L_0x00bb:
            com.google.android.gms.measurement.internal.zzej r0 = r27.zzr()
            com.google.android.gms.measurement.internal.zzel r0 = r0.zzv()
            java.lang.String r1 = "Tag Manager is not found and thus will not be used"
            r0.zza(r1)
        L_0x00c8:
            com.google.android.gms.measurement.internal.zzs r0 = r27.zzt()
            com.google.android.gms.measurement.internal.zzec r1 = r27.zzg()
            java.lang.String r1 = r1.zzab()
            com.google.android.gms.measurement.internal.zzdy<java.lang.Boolean> r2 = com.google.android.gms.measurement.internal.zzak.zzcc
            boolean r0 = r0.zze(r1, r2)
            if (r0 == 0) goto L_0x0101
            java.lang.String r0 = "_cmp"
            boolean r0 = r0.equals(r15)
            if (r0 == 0) goto L_0x0101
            java.lang.String r0 = "gclid"
            boolean r1 = r12.containsKey(r0)
            if (r1 == 0) goto L_0x0101
            java.lang.String r4 = r12.getString(r0)
            com.google.android.gms.common.util.Clock r0 = r27.zzm()
            long r5 = r0.currentTimeMillis()
            java.lang.String r2 = "auto"
            java.lang.String r3 = "_lgclid"
            r1 = r27
            r1.zza((java.lang.String) r2, (java.lang.String) r3, (java.lang.Object) r4, (long) r5)
        L_0x0101:
            r0 = 40
            r1 = 2
            if (r35 == 0) goto L_0x016a
            r27.zzu()
            java.lang.String r2 = "_iap"
            boolean r2 = r2.equals(r15)
            if (r2 != 0) goto L_0x016a
            com.google.android.gms.measurement.internal.zzfn r2 = r7.zzw
            com.google.android.gms.measurement.internal.zzjx r2 = r2.zzi()
            java.lang.String r3 = "event"
            boolean r4 = r2.zza((java.lang.String) r3, (java.lang.String) r15)
            if (r4 != 0) goto L_0x0121
        L_0x011f:
            r2 = 2
            goto L_0x0134
        L_0x0121:
            java.lang.String[] r4 = com.google.android.gms.measurement.internal.zzgn.zza
            boolean r4 = r2.zza((java.lang.String) r3, (java.lang.String[]) r4, (java.lang.String) r15)
            if (r4 != 0) goto L_0x012c
            r2 = 13
            goto L_0x0134
        L_0x012c:
            boolean r2 = r2.zza((java.lang.String) r3, (int) r0, (java.lang.String) r15)
            if (r2 != 0) goto L_0x0133
            goto L_0x011f
        L_0x0133:
            r2 = 0
        L_0x0134:
            if (r2 == 0) goto L_0x016a
            com.google.android.gms.measurement.internal.zzej r1 = r27.zzr()
            com.google.android.gms.measurement.internal.zzel r1 = r1.zzh()
            com.google.android.gms.measurement.internal.zzeh r3 = r27.zzo()
            java.lang.String r3 = r3.zza((java.lang.String) r15)
            java.lang.String r4 = "Invalid public event name. Event will not be logged (FE)"
            r1.zza(r4, r3)
            com.google.android.gms.measurement.internal.zzfn r1 = r7.zzw
            r1.zzi()
            java.lang.String r0 = com.google.android.gms.measurement.internal.zzjx.zza((java.lang.String) r15, (int) r0, (boolean) r9)
            if (r15 == 0) goto L_0x015d
            int r16 = r29.length()
            r1 = r16
            goto L_0x015e
        L_0x015d:
            r1 = 0
        L_0x015e:
            com.google.android.gms.measurement.internal.zzfn r3 = r7.zzw
            com.google.android.gms.measurement.internal.zzjx r3 = r3.zzi()
            java.lang.String r4 = "_ev"
            r3.zza((int) r2, (java.lang.String) r4, (java.lang.String) r0, (int) r1)
            return
        L_0x016a:
            r27.zzu()
            com.google.android.gms.measurement.internal.zzhx r2 = r27.zzi()
            com.google.android.gms.measurement.internal.zzhu r2 = r2.zzab()
            java.lang.String r3 = "_sc"
            if (r2 == 0) goto L_0x0181
            boolean r4 = r12.containsKey(r3)
            if (r4 != 0) goto L_0x0181
            r2.zzd = r9
        L_0x0181:
            if (r33 == 0) goto L_0x0187
            if (r35 == 0) goto L_0x0187
            r4 = 1
            goto L_0x0188
        L_0x0187:
            r4 = 0
        L_0x0188:
            com.google.android.gms.measurement.internal.zzhx.zza((com.google.android.gms.measurement.internal.zzhu) r2, (android.os.Bundle) r12, (boolean) r4)
            java.lang.String r4 = "am"
            boolean r17 = r4.equals(r8)
            boolean r4 = com.google.android.gms.measurement.internal.zzjx.zze(r29)
            if (r33 == 0) goto L_0x01ca
            com.google.android.gms.measurement.internal.zzgo r5 = r7.zzc
            if (r5 == 0) goto L_0x01ca
            if (r4 != 0) goto L_0x01ca
            if (r17 != 0) goto L_0x01ca
            com.google.android.gms.measurement.internal.zzej r0 = r27.zzr()
            com.google.android.gms.measurement.internal.zzel r0 = r0.zzw()
            com.google.android.gms.measurement.internal.zzeh r1 = r27.zzo()
            java.lang.String r1 = r1.zza((java.lang.String) r15)
            com.google.android.gms.measurement.internal.zzeh r2 = r27.zzo()
            java.lang.String r2 = r2.zza((android.os.Bundle) r12)
            java.lang.String r3 = "Passing event to registered event handler (FE)"
            r0.zza(r3, r1, r2)
            com.google.android.gms.measurement.internal.zzgo r1 = r7.zzc
            r2 = r28
            r3 = r29
            r4 = r32
            r5 = r30
            r1.interceptEvent(r2, r3, r4, r5)
            return
        L_0x01ca:
            com.google.android.gms.measurement.internal.zzfn r4 = r7.zzw
            boolean r4 = r4.zzag()
            if (r4 != 0) goto L_0x01d3
            return
        L_0x01d3:
            com.google.android.gms.measurement.internal.zzjx r4 = r27.zzp()
            int r4 = r4.zzb((java.lang.String) r15)
            if (r4 == 0) goto L_0x0219
            com.google.android.gms.measurement.internal.zzej r1 = r27.zzr()
            com.google.android.gms.measurement.internal.zzel r1 = r1.zzh()
            com.google.android.gms.measurement.internal.zzeh r2 = r27.zzo()
            java.lang.String r2 = r2.zza((java.lang.String) r15)
            java.lang.String r3 = "Invalid event name. Event will not be logged (FE)"
            r1.zza(r3, r2)
            r27.zzp()
            java.lang.String r0 = com.google.android.gms.measurement.internal.zzjx.zza((java.lang.String) r15, (int) r0, (boolean) r9)
            if (r15 == 0) goto L_0x0201
            int r1 = r29.length()
            r16 = r1
        L_0x0201:
            com.google.android.gms.measurement.internal.zzfn r1 = r7.zzw
            com.google.android.gms.measurement.internal.zzjx r1 = r1.zzi()
            java.lang.String r2 = "_ev"
            r28 = r1
            r29 = r36
            r30 = r4
            r31 = r2
            r32 = r0
            r33 = r16
            r28.zza((java.lang.String) r29, (int) r30, (java.lang.String) r31, (java.lang.String) r32, (int) r33)
            return
        L_0x0219:
            r0 = 4
            java.lang.String[] r0 = new java.lang.String[r0]
            java.lang.String r5 = "_o"
            r0[r16] = r5
            java.lang.String r4 = "_sn"
            r0[r9] = r4
            r0[r1] = r3
            r1 = 3
            java.lang.String r6 = "_si"
            r0[r1] = r6
            java.util.List r0 = com.google.android.gms.common.util.CollectionUtils.listOf((T[]) r0)
            com.google.android.gms.measurement.internal.zzjx r1 = r27.zzp()
            r18 = 1
            r9 = r1
            r1 = r10
            r10 = r36
            r11 = r29
            r12 = r32
            r7 = r13
            r13 = r0
            r14 = r35
            r33 = r5
            r5 = r15
            r15 = r18
            android.os.Bundle r15 = r9.zza(r10, r11, r12, r13, r14, r15)
            if (r15 == 0) goto L_0x0273
            boolean r9 = r15.containsKey(r3)
            if (r9 == 0) goto L_0x0273
            boolean r9 = r15.containsKey(r6)
            if (r9 != 0) goto L_0x0259
            goto L_0x0273
        L_0x0259:
            java.lang.String r1 = r15.getString(r4)
            java.lang.String r3 = r15.getString(r3)
            long r9 = r15.getLong(r6)
            java.lang.Long r4 = java.lang.Long.valueOf(r9)
            com.google.android.gms.measurement.internal.zzhu r10 = new com.google.android.gms.measurement.internal.zzhu
            long r11 = r4.longValue()
            r10.<init>(r1, r3, r11)
            goto L_0x0274
        L_0x0273:
            r10 = r1
        L_0x0274:
            if (r10 != 0) goto L_0x0278
            r14 = r2
            goto L_0x0279
        L_0x0278:
            r14 = r10
        L_0x0279:
            com.google.android.gms.measurement.internal.zzs r1 = r27.zzt()
            r13 = r36
            boolean r1 = r1.zzr(r13)
            java.lang.String r12 = "_ae"
            r9 = 0
            if (r1 == 0) goto L_0x02af
            r27.zzu()
            com.google.android.gms.measurement.internal.zzhx r1 = r27.zzi()
            com.google.android.gms.measurement.internal.zzhu r1 = r1.zzab()
            if (r1 == 0) goto L_0x02af
            boolean r1 = r12.equals(r5)
            if (r1 == 0) goto L_0x02af
            com.google.android.gms.measurement.internal.zzjd r1 = r27.zzk()
            long r1 = r1.zzad()
            int r3 = (r1 > r9 ? 1 : (r1 == r9 ? 0 : -1))
            if (r3 <= 0) goto L_0x02af
            com.google.android.gms.measurement.internal.zzjx r3 = r27.zzp()
            r3.zza((android.os.Bundle) r15, (long) r1)
        L_0x02af:
            java.util.ArrayList r11 = new java.util.ArrayList
            r11.<init>()
            r11.add(r15)
            com.google.android.gms.measurement.internal.zzjx r1 = r27.zzp()
            java.security.SecureRandom r1 = r1.zzh()
            long r3 = r1.nextLong()
            com.google.android.gms.measurement.internal.zzs r1 = r27.zzt()
            com.google.android.gms.measurement.internal.zzec r2 = r27.zzg()
            java.lang.String r2 = r2.zzab()
            com.google.android.gms.measurement.internal.zzdy<java.lang.Boolean> r6 = com.google.android.gms.measurement.internal.zzak.zzba
            boolean r1 = r1.zze(r2, r6)
            if (r1 == 0) goto L_0x0363
            com.google.android.gms.measurement.internal.zzes r1 = r27.zzs()
            com.google.android.gms.measurement.internal.zzex r1 = r1.zzq
            long r1 = r1.zza()
            int r6 = (r1 > r9 ? 1 : (r1 == r9 ? 0 : -1))
            if (r6 <= 0) goto L_0x0363
            com.google.android.gms.measurement.internal.zzes r1 = r27.zzs()
            boolean r1 = r1.zza((long) r7)
            if (r1 == 0) goto L_0x0363
            com.google.android.gms.measurement.internal.zzes r1 = r27.zzs()
            com.google.android.gms.measurement.internal.zzeu r1 = r1.zzt
            boolean r1 = r1.zza()
            if (r1 == 0) goto L_0x0363
            com.google.android.gms.measurement.internal.zzej r1 = r27.zzr()
            com.google.android.gms.measurement.internal.zzel r1 = r1.zzx()
            java.lang.String r2 = "Current session is expired, remove the session number and Id"
            r1.zza(r2)
            com.google.android.gms.measurement.internal.zzs r1 = r27.zzt()
            com.google.android.gms.measurement.internal.zzec r2 = r27.zzg()
            java.lang.String r2 = r2.zzab()
            com.google.android.gms.measurement.internal.zzdy<java.lang.Boolean> r6 = com.google.android.gms.measurement.internal.zzak.zzaw
            boolean r1 = r1.zze(r2, r6)
            if (r1 == 0) goto L_0x0338
            r6 = 0
            com.google.android.gms.common.util.Clock r1 = r27.zzm()
            long r19 = r1.currentTimeMillis()
            java.lang.String r2 = "auto"
            java.lang.String r18 = "_sid"
            r1 = r27
            r21 = r3
            r3 = r18
            r4 = r6
            r23 = r33
            r5 = r19
            r1.zza((java.lang.String) r2, (java.lang.String) r3, (java.lang.Object) r4, (long) r5)
            goto L_0x033c
        L_0x0338:
            r23 = r33
            r21 = r3
        L_0x033c:
            com.google.android.gms.measurement.internal.zzs r1 = r27.zzt()
            com.google.android.gms.measurement.internal.zzec r2 = r27.zzg()
            java.lang.String r2 = r2.zzab()
            com.google.android.gms.measurement.internal.zzdy<java.lang.Boolean> r3 = com.google.android.gms.measurement.internal.zzak.zzax
            boolean r1 = r1.zze(r2, r3)
            if (r1 == 0) goto L_0x0367
            r4 = 0
            com.google.android.gms.common.util.Clock r1 = r27.zzm()
            long r5 = r1.currentTimeMillis()
            java.lang.String r2 = "auto"
            java.lang.String r3 = "_sno"
            r1 = r27
            r1.zza((java.lang.String) r2, (java.lang.String) r3, (java.lang.Object) r4, (long) r5)
            goto L_0x0367
        L_0x0363:
            r23 = r33
            r21 = r3
        L_0x0367:
            com.google.android.gms.measurement.internal.zzs r1 = r27.zzt()
            com.google.android.gms.measurement.internal.zzec r2 = r27.zzg()
            java.lang.String r2 = r2.zzab()
            boolean r1 = r1.zzq(r2)
            if (r1 == 0) goto L_0x03a0
            java.lang.String r1 = "extend_session"
            long r1 = r15.getLong(r1, r9)
            r3 = 1
            int r5 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r5 != 0) goto L_0x03a0
            com.google.android.gms.measurement.internal.zzej r1 = r27.zzr()
            com.google.android.gms.measurement.internal.zzel r1 = r1.zzx()
            java.lang.String r2 = "EXTEND_SESSION param attached: initiate a new session or extend the current active session"
            r1.zza(r2)
            r5 = r7
            r7 = r27
            com.google.android.gms.measurement.internal.zzfn r1 = r7.zzw
            com.google.android.gms.measurement.internal.zzjd r1 = r1.zze()
            r8 = 1
            r1.zza((long) r5, (boolean) r8)
            goto L_0x03a4
        L_0x03a0:
            r5 = r7
            r8 = 1
            r7 = r27
        L_0x03a4:
            java.util.Set r1 = r15.keySet()
            int r2 = r32.size()
            java.lang.String[] r2 = new java.lang.String[r2]
            java.lang.Object[] r1 = r1.toArray(r2)
            java.lang.String[] r1 = (java.lang.String[]) r1
            java.util.Arrays.sort(r1)
            int r2 = r1.length
            r3 = 0
            r4 = 0
        L_0x03ba:
            java.lang.String r10 = "_eid"
            if (r3 >= r2) goto L_0x046b
            r9 = r1[r3]
            java.lang.Object r18 = r15.get(r9)
            r27.zzp()
            android.os.Bundle[] r8 = com.google.android.gms.measurement.internal.zzjx.zza((java.lang.Object) r18)
            if (r8 == 0) goto L_0x0444
            r32 = r1
            int r1 = r8.length
            r15.putInt(r9, r1)
            r18 = r2
            r1 = 0
        L_0x03d6:
            int r2 = r8.length
            if (r1 >= r2) goto L_0x0434
            r2 = r8[r1]
            r5 = 1
            com.google.android.gms.measurement.internal.zzhx.zza((com.google.android.gms.measurement.internal.zzhu) r14, (android.os.Bundle) r2, (boolean) r5)
            com.google.android.gms.measurement.internal.zzjx r5 = r27.zzp()
            r6 = 0
            java.lang.String r19 = "_ep"
            r24 = r9
            r9 = r5
            r5 = r10
            r10 = r36
            r25 = r11
            r11 = r19
            r26 = r12
            r12 = r2
            r2 = r13
            r13 = r0
            r19 = r14
            r14 = r35
            r33 = r0
            r0 = r15
            r15 = r6
            android.os.Bundle r6 = r9.zza(r10, r11, r12, r13, r14, r15)
            java.lang.String r9 = "_en"
            r10 = r29
            r6.putString(r9, r10)
            r11 = r21
            r6.putLong(r5, r11)
            java.lang.String r9 = "_gn"
            r13 = r24
            r6.putString(r9, r13)
            int r9 = r8.length
            java.lang.String r14 = "_ll"
            r6.putInt(r14, r9)
            java.lang.String r9 = "_i"
            r6.putInt(r9, r1)
            r9 = r25
            r9.add(r6)
            int r1 = r1 + 1
            r15 = r0
            r10 = r5
            r14 = r19
            r12 = r26
            r5 = r30
            r0 = r33
            r11 = r9
            r9 = r13
            r13 = r2
            goto L_0x03d6
        L_0x0434:
            r10 = r29
            r33 = r0
            r9 = r11
            r26 = r12
            r2 = r13
            r19 = r14
            r0 = r15
            r11 = r21
            int r1 = r8.length
            int r4 = r4 + r1
            goto L_0x0455
        L_0x0444:
            r10 = r29
            r33 = r0
            r32 = r1
            r18 = r2
            r9 = r11
            r26 = r12
            r2 = r13
            r19 = r14
            r0 = r15
            r11 = r21
        L_0x0455:
            int r3 = r3 + 1
            r5 = r30
            r1 = r32
            r15 = r0
            r13 = r2
            r21 = r11
            r2 = r18
            r14 = r19
            r12 = r26
            r8 = 1
            r0 = r33
            r11 = r9
            goto L_0x03ba
        L_0x046b:
            r5 = r10
            r9 = r11
            r26 = r12
            r2 = r13
            r0 = r15
            r11 = r21
            r10 = r29
            if (r4 == 0) goto L_0x047f
            r0.putLong(r5, r11)
            java.lang.String r1 = "_epc"
            r0.putInt(r1, r4)
        L_0x047f:
            r0 = 0
        L_0x0480:
            int r1 = r9.size()
            if (r0 >= r1) goto L_0x050b
            java.lang.Object r1 = r9.get(r0)
            android.os.Bundle r1 = (android.os.Bundle) r1
            if (r0 == 0) goto L_0x0490
            r3 = 1
            goto L_0x0491
        L_0x0490:
            r3 = 0
        L_0x0491:
            if (r3 == 0) goto L_0x0498
            java.lang.String r3 = "_ep"
            r8 = r28
            goto L_0x049b
        L_0x0498:
            r8 = r28
            r3 = r10
        L_0x049b:
            r11 = r23
            r1.putString(r11, r8)
            if (r34 == 0) goto L_0x04aa
            com.google.android.gms.measurement.internal.zzjx r4 = r27.zzp()
            android.os.Bundle r1 = r4.zza((android.os.Bundle) r1)
        L_0x04aa:
            r12 = r1
            com.google.android.gms.measurement.internal.zzej r1 = r27.zzr()
            com.google.android.gms.measurement.internal.zzel r1 = r1.zzw()
            com.google.android.gms.measurement.internal.zzeh r4 = r27.zzo()
            java.lang.String r4 = r4.zza((java.lang.String) r10)
            com.google.android.gms.measurement.internal.zzeh r5 = r27.zzo()
            java.lang.String r5 = r5.zza((android.os.Bundle) r12)
            java.lang.String r6 = "Logging event (FE)"
            r1.zza(r6, r4, r5)
            com.google.android.gms.measurement.internal.zzai r13 = new com.google.android.gms.measurement.internal.zzai
            com.google.android.gms.measurement.internal.zzah r4 = new com.google.android.gms.measurement.internal.zzah
            r4.<init>(r12)
            r1 = r13
            r14 = r2
            r2 = r3
            r3 = r4
            r4 = r28
            r5 = r30
            r1.<init>(r2, r3, r4, r5)
            com.google.android.gms.measurement.internal.zzhy r1 = r27.zzh()
            r1.zza((com.google.android.gms.measurement.internal.zzai) r13, (java.lang.String) r14)
            if (r17 != 0) goto L_0x0504
            java.util.Set<com.google.android.gms.measurement.internal.zzgr> r1 = r7.zzd
            java.util.Iterator r13 = r1.iterator()
        L_0x04e9:
            boolean r1 = r13.hasNext()
            if (r1 == 0) goto L_0x0504
            java.lang.Object r1 = r13.next()
            com.google.android.gms.measurement.internal.zzgr r1 = (com.google.android.gms.measurement.internal.zzgr) r1
            android.os.Bundle r4 = new android.os.Bundle
            r4.<init>(r12)
            r2 = r28
            r3 = r29
            r5 = r30
            r1.onEvent(r2, r3, r4, r5)
            goto L_0x04e9
        L_0x0504:
            int r0 = r0 + 1
            r23 = r11
            r2 = r14
            goto L_0x0480
        L_0x050b:
            r27.zzu()
            com.google.android.gms.measurement.internal.zzhx r0 = r27.zzi()
            com.google.android.gms.measurement.internal.zzhu r0 = r0.zzab()
            if (r0 == 0) goto L_0x0528
            r0 = r26
            boolean r0 = r0.equals(r10)
            if (r0 == 0) goto L_0x0528
            com.google.android.gms.measurement.internal.zzjd r0 = r27.zzk()
            r1 = 1
            r0.zza((boolean) r1, (boolean) r1)
        L_0x0528:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzgt.zza(java.lang.String, java.lang.String, long, android.os.Bundle, boolean, boolean, boolean, java.lang.String):void");
    }

    public final void zza(String str, String str2, Bundle bundle, boolean z, boolean z2, long j) {
        boolean z3;
        zzb();
        String str3 = str == null ? "app" : str;
        Bundle bundle2 = bundle == null ? new Bundle() : bundle;
        if (z2) {
            if (this.zzc != null && !zzjx.zze(str2)) {
                z3 = false;
                zzb(str3, str2, j, bundle2, z2, z3, !z, (String) null);
            }
        }
        z3 = true;
        zzb(str3, str2, j, bundle2, z2, z3, !z, (String) null);
    }

    private final void zzb(String str, String str2, long j, Bundle bundle, boolean z, boolean z2, boolean z3, String str3) {
        zzq().zza((Runnable) new zzgu(this, str, str2, j, zzjx.zzb(bundle), z, z2, z3, str3));
    }

    public final void zza(String str, String str2, Object obj, boolean z) {
        zza(str, str2, obj, z, zzm().currentTimeMillis());
    }

    public final void zza(String str, String str2, Object obj, boolean z, long j) {
        if (str == null) {
            str = "app";
        }
        String str3 = str;
        int i = 6;
        int i2 = 0;
        if (z) {
            i = zzp().zzc(str2);
        } else {
            zzjx zzp = zzp();
            if (zzp.zza("user property", str2)) {
                if (!zzp.zza("user property", zzgp.zza, str2)) {
                    i = 15;
                } else if (zzp.zza("user property", 24, str2)) {
                    i = 0;
                }
            }
        }
        if (i != 0) {
            zzp();
            String zza2 = zzjx.zza(str2, 24, true);
            if (str2 != null) {
                i2 = str2.length();
            }
            this.zzw.zzi().zza(i, "_ev", zza2, i2);
        } else if (obj != null) {
            int zzb2 = zzp().zzb(str2, obj);
            if (zzb2 != 0) {
                zzp();
                String zza3 = zzjx.zza(str2, 24, true);
                if ((obj instanceof String) || (obj instanceof CharSequence)) {
                    i2 = String.valueOf(obj).length();
                }
                this.zzw.zzi().zza(zzb2, "_ev", zza3, i2);
                return;
            }
            Object zzc2 = zzp().zzc(str2, obj);
            if (zzc2 != null) {
                zza(str3, str2, j, zzc2);
            }
        } else {
            zza(str3, str2, j, (Object) null);
        }
    }

    private final void zza(String str, String str2, long j, Object obj) {
        zzq().zza((Runnable) new zzgx(this, str, str2, obj, j));
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x0084  */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x0092  */
    @androidx.annotation.WorkerThread
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zza(java.lang.String r9, java.lang.String r10, java.lang.Object r11, long r12) {
        /*
            r8 = this;
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r9)
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r10)
            r8.zzd()
            r8.zzb()
            r8.zzw()
            com.google.android.gms.measurement.internal.zzs r0 = r8.zzt()
            com.google.android.gms.measurement.internal.zzec r1 = r8.zzg()
            java.lang.String r1 = r1.zzab()
            com.google.android.gms.measurement.internal.zzdy<java.lang.Boolean> r2 = com.google.android.gms.measurement.internal.zzak.zzbh
            boolean r0 = r0.zze(r1, r2)
            java.lang.String r1 = "_npa"
            if (r0 == 0) goto L_0x007a
            java.lang.String r0 = "allow_personalized_ads"
            boolean r0 = r0.equals(r10)
            if (r0 == 0) goto L_0x007a
            boolean r0 = r11 instanceof java.lang.String
            if (r0 == 0) goto L_0x006a
            r0 = r11
            java.lang.String r0 = (java.lang.String) r0
            boolean r2 = android.text.TextUtils.isEmpty(r0)
            if (r2 != 0) goto L_0x006a
            java.util.Locale r10 = java.util.Locale.ENGLISH
            java.lang.String r10 = r0.toLowerCase(r10)
            java.lang.String r11 = "false"
            boolean r10 = r11.equals(r10)
            r2 = 1
            if (r10 == 0) goto L_0x004c
            r4 = r2
            goto L_0x004e
        L_0x004c:
            r4 = 0
        L_0x004e:
            java.lang.Long r10 = java.lang.Long.valueOf(r4)
            com.google.android.gms.measurement.internal.zzes r0 = r8.zzs()
            com.google.android.gms.measurement.internal.zzez r0 = r0.zzn
            r4 = r10
            java.lang.Long r4 = (java.lang.Long) r4
            long r4 = r4.longValue()
            int r6 = (r4 > r2 ? 1 : (r4 == r2 ? 0 : -1))
            if (r6 != 0) goto L_0x0065
            java.lang.String r11 = "true"
        L_0x0065:
            r0.zza(r11)
            r6 = r10
            goto L_0x0078
        L_0x006a:
            if (r11 != 0) goto L_0x007a
            com.google.android.gms.measurement.internal.zzes r10 = r8.zzs()
            com.google.android.gms.measurement.internal.zzez r10 = r10.zzn
            java.lang.String r0 = "unset"
            r10.zza(r0)
            r6 = r11
        L_0x0078:
            r3 = r1
            goto L_0x007c
        L_0x007a:
            r3 = r10
            r6 = r11
        L_0x007c:
            com.google.android.gms.measurement.internal.zzfn r10 = r8.zzw
            boolean r10 = r10.zzab()
            if (r10 != 0) goto L_0x0092
            com.google.android.gms.measurement.internal.zzej r9 = r8.zzr()
            com.google.android.gms.measurement.internal.zzel r9 = r9.zzw()
            java.lang.String r10 = "User property not set since app measurement is disabled"
            r9.zza(r10)
            return
        L_0x0092:
            com.google.android.gms.measurement.internal.zzfn r10 = r8.zzw
            boolean r10 = r10.zzag()
            if (r10 != 0) goto L_0x009b
            return
        L_0x009b:
            com.google.android.gms.measurement.internal.zzej r10 = r8.zzr()
            com.google.android.gms.measurement.internal.zzel r10 = r10.zzw()
            com.google.android.gms.measurement.internal.zzeh r11 = r8.zzo()
            java.lang.String r11 = r11.zza((java.lang.String) r3)
            java.lang.String r0 = "Setting user property (FE)"
            r10.zza(r0, r11, r6)
            com.google.android.gms.measurement.internal.zzjw r10 = new com.google.android.gms.measurement.internal.zzjw
            r2 = r10
            r4 = r12
            r7 = r9
            r2.<init>(r3, r4, r6, r7)
            com.google.android.gms.measurement.internal.zzhy r9 = r8.zzh()
            r9.zza((com.google.android.gms.measurement.internal.zzjw) r10)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzgt.zza(java.lang.String, java.lang.String, java.lang.Object, long):void");
    }

    public final List<zzjw> zzc(boolean z) {
        zzb();
        zzw();
        zzr().zzw().zza("Fetching user attributes (FE)");
        if (zzq().zzg()) {
            zzr().zzf().zza("Cannot get all user properties from analytics worker thread");
            return Collections.emptyList();
        } else if (zzr.zza()) {
            zzr().zzf().zza("Cannot get all user properties from main thread");
            return Collections.emptyList();
        } else {
            AtomicReference atomicReference = new AtomicReference();
            synchronized (atomicReference) {
                this.zzw.zzq().zza((Runnable) new zzgw(this, atomicReference, z));
                try {
                    atomicReference.wait(5000);
                } catch (InterruptedException e) {
                    zzr().zzi().zza("Interrupted waiting for get user properties", e);
                }
            }
            List<zzjw> list = (List) atomicReference.get();
            if (list != null) {
                return list;
            }
            zzr().zzi().zza("Timed out waiting for get user properties");
            return Collections.emptyList();
        }
    }

    @Nullable
    public final String zzah() {
        zzb();
        return this.zzf.get();
    }

    @Nullable
    public final String zzc(long j) {
        if (zzq().zzg()) {
            zzr().zzf().zza("Cannot retrieve app instance id from analytics worker thread");
            return null;
        } else if (zzr.zza()) {
            zzr().zzf().zza("Cannot retrieve app instance id from main thread");
            return null;
        } else {
            long elapsedRealtime = zzm().elapsedRealtime();
            String zze2 = zze(120000);
            long elapsedRealtime2 = zzm().elapsedRealtime() - elapsedRealtime;
            return (zze2 != null || elapsedRealtime2 >= 120000) ? zze2 : zze(120000 - elapsedRealtime2);
        }
    }

    /* access modifiers changed from: package-private */
    public final void zza(@Nullable String str) {
        this.zzf.set(str);
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(4:10|11|12|13) */
    /* JADX WARNING: Code restructure failed: missing block: B:11:?, code lost:
        zzr().zzi().zza("Interrupted waiting for app instance id");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x002c, code lost:
        return null;
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:10:0x001d */
    @androidx.annotation.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final java.lang.String zze(long r4) {
        /*
            r3 = this;
            java.util.concurrent.atomic.AtomicReference r0 = new java.util.concurrent.atomic.AtomicReference
            r0.<init>()
            monitor-enter(r0)
            com.google.android.gms.measurement.internal.zzfg r1 = r3.zzq()     // Catch:{ all -> 0x002d }
            com.google.android.gms.measurement.internal.zzgz r2 = new com.google.android.gms.measurement.internal.zzgz     // Catch:{ all -> 0x002d }
            r2.<init>(r3, r0)     // Catch:{ all -> 0x002d }
            r1.zza((java.lang.Runnable) r2)     // Catch:{ all -> 0x002d }
            r0.wait(r4)     // Catch:{ InterruptedException -> 0x001d }
            monitor-exit(r0)     // Catch:{ all -> 0x002d }
            java.lang.Object r4 = r0.get()
            java.lang.String r4 = (java.lang.String) r4
            return r4
        L_0x001d:
            com.google.android.gms.measurement.internal.zzej r4 = r3.zzr()     // Catch:{ all -> 0x002d }
            com.google.android.gms.measurement.internal.zzel r4 = r4.zzi()     // Catch:{ all -> 0x002d }
            java.lang.String r5 = "Interrupted waiting for app instance id"
            r4.zza(r5)     // Catch:{ all -> 0x002d }
            r4 = 0
            monitor-exit(r0)     // Catch:{ all -> 0x002d }
            return r4
        L_0x002d:
            r4 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x002d }
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzgt.zze(long):java.lang.String");
    }

    public final void zzd(long j) {
        zza((String) null);
        zzq().zza((Runnable) new zzgy(this, j));
    }

    @WorkerThread
    public final void zzai() {
        zzd();
        zzb();
        zzw();
        if (this.zzw.zzag()) {
            if (zzt().zze(this.zzw.zzy().zzab(), zzak.zzca)) {
                zzs zzt = zzt();
                zzt.zzu();
                Boolean zzb2 = zzt.zzb("google_analytics_deferred_deep_link_enabled");
                if (zzb2 != null && zzb2.booleanValue()) {
                    zzr().zzw().zza("Deferred Deep Link feature enabled.");
                    zzq().zza((Runnable) new zzgs(this));
                }
            }
            zzh().zzae();
            this.zzb = false;
            String zzv = zzs().zzv();
            if (!TextUtils.isEmpty(zzv)) {
                zzl().zzaa();
                if (!zzv.equals(Build.VERSION.RELEASE)) {
                    Bundle bundle = new Bundle();
                    bundle.putString("_po", zzv);
                    zza("auto", "_ou", bundle);
                }
            }
        }
    }

    @WorkerThread
    public final void zza(zzgo zzgo) {
        zzgo zzgo2;
        zzd();
        zzb();
        zzw();
        if (!(zzgo == null || zzgo == (zzgo2 = this.zzc))) {
            Preconditions.checkState(zzgo2 == null, "EventInterceptor already set.");
        }
        this.zzc = zzgo;
    }

    public final void zza(zzgr zzgr) {
        zzb();
        zzw();
        Preconditions.checkNotNull(zzgr);
        if (!this.zzd.add(zzgr)) {
            zzr().zzi().zza("OnEventListener already registered");
        }
    }

    public final void zzb(zzgr zzgr) {
        zzb();
        zzw();
        Preconditions.checkNotNull(zzgr);
        if (!this.zzd.remove(zzgr)) {
            zzr().zzi().zza("OnEventListener had not been registered");
        }
    }

    public final void zza(Bundle bundle) {
        zza(bundle, zzm().currentTimeMillis());
    }

    public final void zza(Bundle bundle, long j) {
        Preconditions.checkNotNull(bundle);
        zzb();
        Bundle bundle2 = new Bundle(bundle);
        if (!TextUtils.isEmpty(bundle2.getString("app_id"))) {
            zzr().zzi().zza("Package name should be null when calling setConditionalUserProperty");
        }
        bundle2.remove("app_id");
        zzb(bundle2, j);
    }

    public final void zzb(Bundle bundle) {
        Preconditions.checkNotNull(bundle);
        Preconditions.checkNotEmpty(bundle.getString("app_id"));
        zza();
        zzb(new Bundle(bundle), zzm().currentTimeMillis());
    }

    private final void zzb(Bundle bundle, long j) {
        Preconditions.checkNotNull(bundle);
        zzgk.zza(bundle, "app_id", String.class, null);
        zzgk.zza(bundle, "origin", String.class, null);
        zzgk.zza(bundle, AppMeasurementSdk.ConditionalUserProperty.NAME, String.class, null);
        zzgk.zza(bundle, "value", Object.class, null);
        zzgk.zza(bundle, AppMeasurementSdk.ConditionalUserProperty.TRIGGER_EVENT_NAME, String.class, null);
        zzgk.zza(bundle, AppMeasurementSdk.ConditionalUserProperty.TRIGGER_TIMEOUT, Long.class, 0L);
        zzgk.zza(bundle, AppMeasurementSdk.ConditionalUserProperty.TIMED_OUT_EVENT_NAME, String.class, null);
        zzgk.zza(bundle, AppMeasurementSdk.ConditionalUserProperty.TIMED_OUT_EVENT_PARAMS, Bundle.class, null);
        zzgk.zza(bundle, AppMeasurementSdk.ConditionalUserProperty.TRIGGERED_EVENT_NAME, String.class, null);
        zzgk.zza(bundle, AppMeasurementSdk.ConditionalUserProperty.TRIGGERED_EVENT_PARAMS, Bundle.class, null);
        zzgk.zza(bundle, AppMeasurementSdk.ConditionalUserProperty.TIME_TO_LIVE, Long.class, 0L);
        zzgk.zza(bundle, AppMeasurementSdk.ConditionalUserProperty.EXPIRED_EVENT_NAME, String.class, null);
        zzgk.zza(bundle, AppMeasurementSdk.ConditionalUserProperty.EXPIRED_EVENT_PARAMS, Bundle.class, null);
        Preconditions.checkNotEmpty(bundle.getString(AppMeasurementSdk.ConditionalUserProperty.NAME));
        Preconditions.checkNotEmpty(bundle.getString("origin"));
        Preconditions.checkNotNull(bundle.get("value"));
        bundle.putLong(AppMeasurementSdk.ConditionalUserProperty.CREATION_TIMESTAMP, j);
        String string = bundle.getString(AppMeasurementSdk.ConditionalUserProperty.NAME);
        Object obj = bundle.get("value");
        if (zzp().zzc(string) != 0) {
            zzr().zzf().zza("Invalid conditional user property name", zzo().zzc(string));
        } else if (zzp().zzb(string, obj) != 0) {
            zzr().zzf().zza("Invalid conditional user property value", zzo().zzc(string), obj);
        } else {
            Object zzc2 = zzp().zzc(string, obj);
            if (zzc2 == null) {
                zzr().zzf().zza("Unable to normalize conditional user property value", zzo().zzc(string), obj);
                return;
            }
            zzgk.zza(bundle, zzc2);
            long j2 = bundle.getLong(AppMeasurementSdk.ConditionalUserProperty.TRIGGER_TIMEOUT);
            if (TextUtils.isEmpty(bundle.getString(AppMeasurementSdk.ConditionalUserProperty.TRIGGER_EVENT_NAME)) || (j2 <= 15552000000L && j2 >= 1)) {
                long j3 = bundle.getLong(AppMeasurementSdk.ConditionalUserProperty.TIME_TO_LIVE);
                if (j3 > 15552000000L || j3 < 1) {
                    zzr().zzf().zza("Invalid conditional user property time to live", zzo().zzc(string), Long.valueOf(j3));
                } else {
                    zzq().zza((Runnable) new zzha(this, bundle));
                }
            } else {
                zzr().zzf().zza("Invalid conditional user property timeout", zzo().zzc(string), Long.valueOf(j2));
            }
        }
    }

    public final void zzc(String str, String str2, Bundle bundle) {
        zzb();
        zzb((String) null, str, str2, bundle);
    }

    public final void zza(String str, String str2, String str3, Bundle bundle) {
        Preconditions.checkNotEmpty(str);
        zza();
        zzb(str, str2, str3, bundle);
    }

    private final void zzb(String str, String str2, String str3, Bundle bundle) {
        long currentTimeMillis = zzm().currentTimeMillis();
        Preconditions.checkNotEmpty(str2);
        Bundle bundle2 = new Bundle();
        if (str != null) {
            bundle2.putString("app_id", str);
        }
        bundle2.putString(AppMeasurementSdk.ConditionalUserProperty.NAME, str2);
        bundle2.putLong(AppMeasurementSdk.ConditionalUserProperty.CREATION_TIMESTAMP, currentTimeMillis);
        if (str3 != null) {
            bundle2.putString(AppMeasurementSdk.ConditionalUserProperty.EXPIRED_EVENT_NAME, str3);
            bundle2.putBundle(AppMeasurementSdk.ConditionalUserProperty.EXPIRED_EVENT_PARAMS, bundle);
        }
        zzq().zza((Runnable) new zzhd(this, bundle2));
    }

    /* access modifiers changed from: private */
    @WorkerThread
    public final void zzc(Bundle bundle) {
        Bundle bundle2 = bundle;
        zzd();
        zzw();
        Preconditions.checkNotNull(bundle);
        Preconditions.checkNotEmpty(bundle2.getString(AppMeasurementSdk.ConditionalUserProperty.NAME));
        Preconditions.checkNotEmpty(bundle2.getString("origin"));
        Preconditions.checkNotNull(bundle2.get("value"));
        if (!this.zzw.zzab()) {
            zzr().zzw().zza("Conditional property not sent since collection is disabled");
            return;
        }
        zzjw zzjw = new zzjw(bundle2.getString(AppMeasurementSdk.ConditionalUserProperty.NAME), bundle2.getLong(AppMeasurementSdk.ConditionalUserProperty.TRIGGERED_TIMESTAMP), bundle2.get("value"), bundle2.getString("origin"));
        try {
            zzai zza2 = zzp().zza(bundle2.getString("app_id"), bundle2.getString(AppMeasurementSdk.ConditionalUserProperty.TRIGGERED_EVENT_NAME), bundle2.getBundle(AppMeasurementSdk.ConditionalUserProperty.TRIGGERED_EVENT_PARAMS), bundle2.getString("origin"), 0, true, false);
            zzh().zza(new zzq(bundle2.getString("app_id"), bundle2.getString("origin"), zzjw, bundle2.getLong(AppMeasurementSdk.ConditionalUserProperty.CREATION_TIMESTAMP), false, bundle2.getString(AppMeasurementSdk.ConditionalUserProperty.TRIGGER_EVENT_NAME), zzp().zza(bundle2.getString("app_id"), bundle2.getString(AppMeasurementSdk.ConditionalUserProperty.TIMED_OUT_EVENT_NAME), bundle2.getBundle(AppMeasurementSdk.ConditionalUserProperty.TIMED_OUT_EVENT_PARAMS), bundle2.getString("origin"), 0, true, false), bundle2.getLong(AppMeasurementSdk.ConditionalUserProperty.TRIGGER_TIMEOUT), zza2, bundle2.getLong(AppMeasurementSdk.ConditionalUserProperty.TIME_TO_LIVE), zzp().zza(bundle2.getString("app_id"), bundle2.getString(AppMeasurementSdk.ConditionalUserProperty.EXPIRED_EVENT_NAME), bundle2.getBundle(AppMeasurementSdk.ConditionalUserProperty.EXPIRED_EVENT_PARAMS), bundle2.getString("origin"), 0, true, false)));
        } catch (IllegalArgumentException unused) {
        }
    }

    /* access modifiers changed from: private */
    @WorkerThread
    public final void zzd(Bundle bundle) {
        Bundle bundle2 = bundle;
        zzd();
        zzw();
        Preconditions.checkNotNull(bundle);
        Preconditions.checkNotEmpty(bundle2.getString(AppMeasurementSdk.ConditionalUserProperty.NAME));
        if (!this.zzw.zzab()) {
            zzr().zzw().zza("Conditional property not cleared since collection is disabled");
            return;
        }
        zzjw zzjw = new zzjw(bundle2.getString(AppMeasurementSdk.ConditionalUserProperty.NAME), 0, (Object) null, (String) null);
        try {
            zzai zza2 = zzp().zza(bundle2.getString("app_id"), bundle2.getString(AppMeasurementSdk.ConditionalUserProperty.EXPIRED_EVENT_NAME), bundle2.getBundle(AppMeasurementSdk.ConditionalUserProperty.EXPIRED_EVENT_PARAMS), bundle2.getString("origin"), bundle2.getLong(AppMeasurementSdk.ConditionalUserProperty.CREATION_TIMESTAMP), true, false);
            zzjw zzjw2 = zzjw;
            zzh().zza(new zzq(bundle2.getString("app_id"), bundle2.getString("origin"), zzjw2, bundle2.getLong(AppMeasurementSdk.ConditionalUserProperty.CREATION_TIMESTAMP), bundle2.getBoolean("active"), bundle2.getString(AppMeasurementSdk.ConditionalUserProperty.TRIGGER_EVENT_NAME), (zzai) null, bundle2.getLong(AppMeasurementSdk.ConditionalUserProperty.TRIGGER_TIMEOUT), (zzai) null, bundle2.getLong(AppMeasurementSdk.ConditionalUserProperty.TIME_TO_LIVE), zza2));
        } catch (IllegalArgumentException unused) {
        }
    }

    public final ArrayList<Bundle> zza(String str, String str2) {
        zzb();
        return zzb((String) null, str, str2);
    }

    public final ArrayList<Bundle> zza(String str, String str2, String str3) {
        Preconditions.checkNotEmpty(str);
        zza();
        return zzb(str, str2, str3);
    }

    @VisibleForTesting
    private final ArrayList<Bundle> zzb(String str, String str2, String str3) {
        if (zzq().zzg()) {
            zzr().zzf().zza("Cannot get conditional user properties from analytics worker thread");
            return new ArrayList<>(0);
        } else if (zzr.zza()) {
            zzr().zzf().zza("Cannot get conditional user properties from main thread");
            return new ArrayList<>(0);
        } else {
            AtomicReference atomicReference = new AtomicReference();
            synchronized (atomicReference) {
                this.zzw.zzq().zza((Runnable) new zzhc(this, atomicReference, str, str2, str3));
                try {
                    atomicReference.wait(5000);
                } catch (InterruptedException e) {
                    zzr().zzi().zza("Interrupted waiting for get conditional user properties", str, e);
                }
            }
            List list = (List) atomicReference.get();
            if (list != null) {
                return zzjx.zzb((List<zzq>) list);
            }
            zzr().zzi().zza("Timed out waiting for get conditional user properties", str);
            return new ArrayList<>();
        }
    }

    public final Map<String, Object> zza(String str, String str2, boolean z) {
        zzb();
        return zzb((String) null, str, str2, z);
    }

    public final Map<String, Object> zza(String str, String str2, String str3, boolean z) {
        Preconditions.checkNotEmpty(str);
        zza();
        return zzb(str, str2, str3, z);
    }

    @VisibleForTesting
    private final Map<String, Object> zzb(String str, String str2, String str3, boolean z) {
        if (zzq().zzg()) {
            zzr().zzf().zza("Cannot get user properties from analytics worker thread");
            return Collections.emptyMap();
        } else if (zzr.zza()) {
            zzr().zzf().zza("Cannot get user properties from main thread");
            return Collections.emptyMap();
        } else {
            AtomicReference atomicReference = new AtomicReference();
            synchronized (atomicReference) {
                this.zzw.zzq().zza((Runnable) new zzhe(this, atomicReference, str, str2, str3, z));
                try {
                    atomicReference.wait(5000);
                } catch (InterruptedException e) {
                    zzr().zzi().zza("Interrupted waiting for get user properties", e);
                }
            }
            List<zzjw> list = (List) atomicReference.get();
            if (list == null) {
                zzr().zzi().zza("Timed out waiting for handle get user properties");
                return Collections.emptyMap();
            }
            ArrayMap arrayMap = new ArrayMap(list.size());
            for (zzjw zzjw : list) {
                arrayMap.put(zzjw.zza, zzjw.zza());
            }
            return arrayMap;
        }
    }

    @Nullable
    public final String zzaj() {
        zzhu zzac = this.zzw.zzv().zzac();
        if (zzac != null) {
            return zzac.zza;
        }
        return null;
    }

    @Nullable
    public final String zzak() {
        zzhu zzac = this.zzw.zzv().zzac();
        if (zzac != null) {
            return zzac.zzb;
        }
        return null;
    }

    @Nullable
    public final String zzal() {
        if (this.zzw.zzo() != null) {
            return this.zzw.zzo();
        }
        try {
            return GoogleServices.getGoogleAppId();
        } catch (IllegalStateException e) {
            this.zzw.zzr().zzf().zza("getGoogleAppId failed with exception", e);
            return null;
        }
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
