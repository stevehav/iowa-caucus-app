package com.google.android.gms.measurement.internal;

import android.content.ComponentName;
import android.content.Context;
import android.os.RemoteException;
import androidx.annotation.Nullable;
import androidx.annotation.WorkerThread;
import com.google.android.gms.common.GooglePlayServicesUtilLight;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.stats.ConnectionTracker;
import com.google.android.gms.common.util.Clock;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.internal.measurement.zzp;
import io.sentry.DefaultSentryClientFactory;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

@VisibleForTesting
/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.0.1 */
public final class zzhy extends zzg {
    /* access modifiers changed from: private */
    public final zziq zza;
    /* access modifiers changed from: private */
    public zzeb zzb;
    private volatile Boolean zzc;
    private final zzaa zzd;
    private final zzji zze;
    private final List<Runnable> zzf = new ArrayList();
    private final zzaa zzg;

    protected zzhy(zzfn zzfn) {
        super(zzfn);
        this.zze = new zzji(zzfn.zzm());
        this.zza = new zziq(this);
        this.zzd = new zzib(this, zzfn);
        this.zzg = new zzii(this, zzfn);
    }

    /* access modifiers changed from: protected */
    public final boolean zzz() {
        return false;
    }

    @WorkerThread
    public final boolean zzab() {
        zzd();
        zzw();
        return this.zzb != null;
    }

    /* access modifiers changed from: protected */
    @WorkerThread
    public final void zzac() {
        zzd();
        zzw();
        zza((Runnable) new zzil(this, zza(true)));
    }

    /* access modifiers changed from: package-private */
    @WorkerThread
    @VisibleForTesting
    public final void zza(zzeb zzeb, AbstractSafeParcelable abstractSafeParcelable, zzn zzn) {
        int i;
        List<AbstractSafeParcelable> zza2;
        zzd();
        zzb();
        zzw();
        boolean zzai = zzai();
        int i2 = 0;
        int i3 = 100;
        while (i2 < 1001 && i3 == 100) {
            ArrayList arrayList = new ArrayList();
            if (!zzai || (zza2 = zzj().zza(100)) == null) {
                i = 0;
            } else {
                arrayList.addAll(zza2);
                i = zza2.size();
            }
            if (abstractSafeParcelable != null && i < 100) {
                arrayList.add(abstractSafeParcelable);
            }
            ArrayList arrayList2 = arrayList;
            int size = arrayList2.size();
            int i4 = 0;
            while (i4 < size) {
                Object obj = arrayList2.get(i4);
                i4++;
                AbstractSafeParcelable abstractSafeParcelable2 = (AbstractSafeParcelable) obj;
                if (abstractSafeParcelable2 instanceof zzai) {
                    try {
                        zzeb.zza((zzai) abstractSafeParcelable2, zzn);
                    } catch (RemoteException e) {
                        zzr().zzf().zza("Failed to send event to the service", e);
                    }
                } else if (abstractSafeParcelable2 instanceof zzjw) {
                    try {
                        zzeb.zza((zzjw) abstractSafeParcelable2, zzn);
                    } catch (RemoteException e2) {
                        zzr().zzf().zza("Failed to send attribute to the service", e2);
                    }
                } else if (abstractSafeParcelable2 instanceof zzq) {
                    try {
                        zzeb.zza((zzq) abstractSafeParcelable2, zzn);
                    } catch (RemoteException e3) {
                        zzr().zzf().zza("Failed to send conditional property to the service", e3);
                    }
                } else {
                    zzr().zzf().zza("Discarding data. Unrecognized parcel type.");
                }
            }
            i2++;
            i3 = i;
        }
    }

    /* access modifiers changed from: protected */
    @WorkerThread
    public final void zza(zzai zzai, String str) {
        Preconditions.checkNotNull(zzai);
        zzd();
        zzw();
        boolean zzai2 = zzai();
        zza((Runnable) new zzik(this, zzai2, zzai2 && zzj().zza(zzai), zzai, zza(true), str));
    }

    /* access modifiers changed from: protected */
    @WorkerThread
    public final void zza(zzq zzq) {
        Preconditions.checkNotNull(zzq);
        zzd();
        zzw();
        zzu();
        zza((Runnable) new zzin(this, true, zzj().zza(zzq), new zzq(zzq), zza(true), zzq));
    }

    /* access modifiers changed from: protected */
    @WorkerThread
    public final void zza(AtomicReference<List<zzq>> atomicReference, String str, String str2, String str3) {
        zzd();
        zzw();
        zza((Runnable) new zzim(this, atomicReference, str, str2, str3, zza(false)));
    }

    /* access modifiers changed from: protected */
    @WorkerThread
    public final void zza(zzp zzp, String str, String str2) {
        zzd();
        zzw();
        zza((Runnable) new zzip(this, str, str2, zza(false), zzp));
    }

    /* access modifiers changed from: protected */
    @WorkerThread
    public final void zza(AtomicReference<List<zzjw>> atomicReference, String str, String str2, String str3, boolean z) {
        zzd();
        zzw();
        zza((Runnable) new zzio(this, atomicReference, str, str2, str3, z, zza(false)));
    }

    /* access modifiers changed from: protected */
    @WorkerThread
    public final void zza(zzp zzp, String str, String str2, boolean z) {
        zzd();
        zzw();
        zza((Runnable) new zzir(this, str, str2, z, zza(false), zzp));
    }

    /* access modifiers changed from: protected */
    @WorkerThread
    public final void zza(zzjw zzjw) {
        zzd();
        zzw();
        zza((Runnable) new zzia(this, zzai() && zzj().zza(zzjw), zzjw, zza(true)));
    }

    /* access modifiers changed from: protected */
    @WorkerThread
    public final void zza(AtomicReference<List<zzjw>> atomicReference, boolean z) {
        zzd();
        zzw();
        zza((Runnable) new zzid(this, atomicReference, zza(false), z));
    }

    /* access modifiers changed from: protected */
    @WorkerThread
    public final void zzad() {
        zzd();
        zzb();
        zzw();
        zzn zza2 = zza(false);
        if (zzai()) {
            zzj().zzab();
        }
        zza((Runnable) new zzic(this, zza2));
    }

    private final boolean zzai() {
        zzu();
        return true;
    }

    @WorkerThread
    public final void zza(AtomicReference<String> atomicReference) {
        zzd();
        zzw();
        zza((Runnable) new zzif(this, atomicReference, zza(false)));
    }

    @WorkerThread
    public final void zza(zzp zzp) {
        zzd();
        zzw();
        zza((Runnable) new zzie(this, zza(false), zzp));
    }

    /* access modifiers changed from: protected */
    @WorkerThread
    public final void zzae() {
        zzd();
        zzw();
        zzn zza2 = zza(true);
        boolean zza3 = zzt().zza(zzak.zzcb);
        if (zza3) {
            zzj().zzac();
        }
        zza((Runnable) new zzih(this, zza2, zza3));
    }

    /* access modifiers changed from: protected */
    @WorkerThread
    public final void zza(zzhu zzhu) {
        zzd();
        zzw();
        zza((Runnable) new zzig(this, zzhu));
    }

    /* access modifiers changed from: private */
    @WorkerThread
    public final void zzaj() {
        zzd();
        this.zze.zza();
        this.zzd.zza(zzak.zzaj.zza(null).longValue());
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x010d  */
    @androidx.annotation.WorkerThread
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zzaf() {
        /*
            r6 = this;
            r6.zzd()
            r6.zzw()
            boolean r0 = r6.zzab()
            if (r0 == 0) goto L_0x000d
            return
        L_0x000d:
            java.lang.Boolean r0 = r6.zzc
            r1 = 0
            r2 = 1
            if (r0 != 0) goto L_0x011a
            r6.zzd()
            r6.zzw()
            com.google.android.gms.measurement.internal.zzes r0 = r6.zzs()
            java.lang.Boolean r0 = r0.zzi()
            if (r0 == 0) goto L_0x002c
            boolean r0 = r0.booleanValue()
            if (r0 == 0) goto L_0x002c
            r0 = 1
            goto L_0x0114
        L_0x002c:
            r6.zzu()
            com.google.android.gms.measurement.internal.zzec r0 = r6.zzg()
            int r0 = r0.zzaf()
            if (r0 != r2) goto L_0x003d
        L_0x0039:
            r0 = 1
        L_0x003a:
            r3 = 1
            goto L_0x00f1
        L_0x003d:
            com.google.android.gms.measurement.internal.zzej r0 = r6.zzr()
            com.google.android.gms.measurement.internal.zzel r0 = r0.zzx()
            java.lang.String r3 = "Checking service availability"
            r0.zza(r3)
            com.google.android.gms.measurement.internal.zzjx r0 = r6.zzp()
            r3 = 12451000(0xbdfcb8, float:1.7447567E-38)
            int r0 = r0.zza((int) r3)
            if (r0 == 0) goto L_0x00e2
            if (r0 == r2) goto L_0x00d2
            r3 = 2
            if (r0 == r3) goto L_0x00a6
            r3 = 3
            if (r0 == r3) goto L_0x0098
            r3 = 9
            if (r0 == r3) goto L_0x008a
            r3 = 18
            if (r0 == r3) goto L_0x007c
            com.google.android.gms.measurement.internal.zzej r3 = r6.zzr()
            com.google.android.gms.measurement.internal.zzel r3 = r3.zzi()
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
            java.lang.String r4 = "Unexpected service status"
            r3.zza(r4, r0)
        L_0x0078:
            r0 = 0
        L_0x0079:
            r3 = 0
            goto L_0x00f1
        L_0x007c:
            com.google.android.gms.measurement.internal.zzej r0 = r6.zzr()
            com.google.android.gms.measurement.internal.zzel r0 = r0.zzi()
            java.lang.String r3 = "Service updating"
            r0.zza(r3)
            goto L_0x0039
        L_0x008a:
            com.google.android.gms.measurement.internal.zzej r0 = r6.zzr()
            com.google.android.gms.measurement.internal.zzel r0 = r0.zzi()
            java.lang.String r3 = "Service invalid"
            r0.zza(r3)
            goto L_0x0078
        L_0x0098:
            com.google.android.gms.measurement.internal.zzej r0 = r6.zzr()
            com.google.android.gms.measurement.internal.zzel r0 = r0.zzi()
            java.lang.String r3 = "Service disabled"
            r0.zza(r3)
            goto L_0x0078
        L_0x00a6:
            com.google.android.gms.measurement.internal.zzej r0 = r6.zzr()
            com.google.android.gms.measurement.internal.zzel r0 = r0.zzw()
            java.lang.String r3 = "Service container out of date"
            r0.zza(r3)
            com.google.android.gms.measurement.internal.zzjx r0 = r6.zzp()
            int r0 = r0.zzj()
            r3 = 17443(0x4423, float:2.4443E-41)
            if (r0 >= r3) goto L_0x00c0
            goto L_0x00df
        L_0x00c0:
            com.google.android.gms.measurement.internal.zzes r0 = r6.zzs()
            java.lang.Boolean r0 = r0.zzi()
            if (r0 == 0) goto L_0x00d0
            boolean r0 = r0.booleanValue()
            if (r0 == 0) goto L_0x0078
        L_0x00d0:
            r0 = 1
            goto L_0x0079
        L_0x00d2:
            com.google.android.gms.measurement.internal.zzej r0 = r6.zzr()
            com.google.android.gms.measurement.internal.zzel r0 = r0.zzx()
            java.lang.String r3 = "Service missing"
            r0.zza(r3)
        L_0x00df:
            r0 = 0
            goto L_0x003a
        L_0x00e2:
            com.google.android.gms.measurement.internal.zzej r0 = r6.zzr()
            com.google.android.gms.measurement.internal.zzel r0 = r0.zzx()
            java.lang.String r3 = "Service available"
            r0.zza(r3)
            goto L_0x0039
        L_0x00f1:
            if (r0 != 0) goto L_0x010b
            com.google.android.gms.measurement.internal.zzs r4 = r6.zzt()
            boolean r4 = r4.zzz()
            if (r4 == 0) goto L_0x010b
            com.google.android.gms.measurement.internal.zzej r3 = r6.zzr()
            com.google.android.gms.measurement.internal.zzel r3 = r3.zzf()
            java.lang.String r4 = "No way to upload. Consider using the full version of Analytics"
            r3.zza(r4)
            r3 = 0
        L_0x010b:
            if (r3 == 0) goto L_0x0114
            com.google.android.gms.measurement.internal.zzes r3 = r6.zzs()
            r3.zza((boolean) r0)
        L_0x0114:
            java.lang.Boolean r0 = java.lang.Boolean.valueOf(r0)
            r6.zzc = r0
        L_0x011a:
            java.lang.Boolean r0 = r6.zzc
            boolean r0 = r0.booleanValue()
            if (r0 == 0) goto L_0x0128
            com.google.android.gms.measurement.internal.zziq r0 = r6.zza
            r0.zzb()
            return
        L_0x0128:
            com.google.android.gms.measurement.internal.zzs r0 = r6.zzt()
            boolean r0 = r0.zzz()
            if (r0 != 0) goto L_0x0186
            r6.zzu()
            android.content.Context r0 = r6.zzn()
            android.content.pm.PackageManager r0 = r0.getPackageManager()
            android.content.Intent r3 = new android.content.Intent
            r3.<init>()
            android.content.Context r4 = r6.zzn()
            java.lang.String r5 = "com.google.android.gms.measurement.AppMeasurementService"
            android.content.Intent r3 = r3.setClassName(r4, r5)
            r4 = 65536(0x10000, float:9.18355E-41)
            java.util.List r0 = r0.queryIntentServices(r3, r4)
            if (r0 == 0) goto L_0x015b
            int r0 = r0.size()
            if (r0 <= 0) goto L_0x015b
            r1 = 1
        L_0x015b:
            if (r1 == 0) goto L_0x0179
            android.content.Intent r0 = new android.content.Intent
            java.lang.String r1 = "com.google.android.gms.measurement.START"
            r0.<init>(r1)
            android.content.ComponentName r1 = new android.content.ComponentName
            android.content.Context r2 = r6.zzn()
            r6.zzu()
            r1.<init>(r2, r5)
            r0.setComponent(r1)
            com.google.android.gms.measurement.internal.zziq r1 = r6.zza
            r1.zza(r0)
            return
        L_0x0179:
            com.google.android.gms.measurement.internal.zzej r0 = r6.zzr()
            com.google.android.gms.measurement.internal.zzel r0 = r0.zzf()
            java.lang.String r1 = "Unable to use remote or local measurement implementation. Please register the AppMeasurementService service in the app manifest"
            r0.zza(r1)
        L_0x0186:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzhy.zzaf():void");
    }

    /* access modifiers changed from: package-private */
    public final Boolean zzag() {
        return this.zzc;
    }

    /* access modifiers changed from: protected */
    @WorkerThread
    @VisibleForTesting
    public final void zza(zzeb zzeb) {
        zzd();
        Preconditions.checkNotNull(zzeb);
        this.zzb = zzeb;
        zzaj();
        zzal();
    }

    @WorkerThread
    public final void zzah() {
        zzd();
        zzw();
        this.zza.zza();
        try {
            ConnectionTracker.getInstance().unbindService(zzn(), this.zza);
        } catch (IllegalArgumentException | IllegalStateException unused) {
        }
        this.zzb = null;
    }

    /* access modifiers changed from: private */
    @WorkerThread
    public final void zza(ComponentName componentName) {
        zzd();
        if (this.zzb != null) {
            this.zzb = null;
            zzr().zzx().zza("Disconnected from device MeasurementService", componentName);
            zzd();
            zzaf();
        }
    }

    /* access modifiers changed from: private */
    @WorkerThread
    public final void zzak() {
        zzd();
        if (zzab()) {
            zzr().zzx().zza("Inactivity, disconnecting from the service");
            zzah();
        }
    }

    @WorkerThread
    private final void zza(Runnable runnable) throws IllegalStateException {
        zzd();
        if (zzab()) {
            runnable.run();
        } else if (((long) this.zzf.size()) >= 1000) {
            zzr().zzf().zza("Discarding data. Max runnable queue size reached");
        } else {
            this.zzf.add(runnable);
            this.zzg.zza(DefaultSentryClientFactory.BUFFER_FLUSHTIME_DEFAULT);
            zzaf();
        }
    }

    /* access modifiers changed from: private */
    @WorkerThread
    public final void zzal() {
        zzd();
        zzr().zzx().zza("Processing queued up service tasks", Integer.valueOf(this.zzf.size()));
        for (Runnable run : this.zzf) {
            try {
                run.run();
            } catch (Exception e) {
                zzr().zzf().zza("Task exception while flushing queue", e);
            }
        }
        this.zzf.clear();
        this.zzg.zzc();
    }

    @WorkerThread
    @Nullable
    private final zzn zza(boolean z) {
        zzu();
        return zzg().zza(z ? zzr().zzy() : null);
    }

    @WorkerThread
    public final void zza(zzp zzp, zzai zzai, String str) {
        zzd();
        zzw();
        if (zzp().zza((int) GooglePlayServicesUtilLight.GOOGLE_PLAY_SERVICES_VERSION_CODE) != 0) {
            zzr().zzi().zza("Not bundling data. Service unavailable or out of date");
            zzp().zza(zzp, new byte[0]);
            return;
        }
        zza((Runnable) new zzij(this, zzai, str, zzp));
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
