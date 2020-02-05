package com.google.android.gms.measurement.internal;

import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Pair;
import androidx.annotation.WorkerThread;
import com.google.android.gms.common.api.internal.GoogleServices;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.Clock;
import com.google.android.gms.common.util.DefaultClock;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.common.wrappers.Wrappers;
import com.google.android.gms.internal.measurement.zzcl;
import com.google.android.gms.internal.measurement.zzx;
import java.net.URL;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.0.1 */
public class zzfn implements zzgl {
    private static volatile zzfn zza;
    private long zzaa;
    private volatile Boolean zzab;
    @VisibleForTesting
    private Boolean zzac;
    @VisibleForTesting
    private Boolean zzad;
    private int zzae;
    private AtomicInteger zzaf = new AtomicInteger(0);
    private final long zzag;
    private final Context zzb;
    private final String zzc;
    private final String zzd;
    private final String zze;
    private final boolean zzf;
    private final zzr zzg;
    private final zzs zzh;
    private final zzes zzi;
    private final zzej zzj;
    private final zzfg zzk;
    private final zzjd zzl;
    private final zzjx zzm;
    private final zzeh zzn;
    private final Clock zzo;
    private final zzhx zzp;
    private final zzgt zzq;
    private final zza zzr;
    private final zzho zzs;
    private zzef zzt;
    private zzhy zzu;
    private zzac zzv;
    private zzec zzw;
    private zzey zzx;
    private boolean zzy = false;
    private Boolean zzz;

    private zzfn(zzgq zzgq) {
        boolean z = false;
        Preconditions.checkNotNull(zzgq);
        this.zzg = new zzr(zzgq.zza);
        zzak.zza(this.zzg);
        this.zzb = zzgq.zza;
        this.zzc = zzgq.zzb;
        this.zzd = zzgq.zzc;
        this.zze = zzgq.zzd;
        this.zzf = zzgq.zzh;
        this.zzab = zzgq.zze;
        zzx zzx2 = zzgq.zzg;
        if (!(zzx2 == null || zzx2.zzg == null)) {
            Object obj = zzx2.zzg.get("measurementEnabled");
            if (obj instanceof Boolean) {
                this.zzac = (Boolean) obj;
            }
            Object obj2 = zzx2.zzg.get("measurementDeactivated");
            if (obj2 instanceof Boolean) {
                this.zzad = (Boolean) obj2;
            }
        }
        zzcl.zza(this.zzb);
        this.zzo = DefaultClock.getInstance();
        this.zzag = this.zzo.currentTimeMillis();
        this.zzh = new zzs(this);
        zzes zzes = new zzes(this);
        zzes.zzab();
        this.zzi = zzes;
        zzej zzej = new zzej(this);
        zzej.zzab();
        this.zzj = zzej;
        zzjx zzjx = new zzjx(this);
        zzjx.zzab();
        this.zzm = zzjx;
        zzeh zzeh = new zzeh(this);
        zzeh.zzab();
        this.zzn = zzeh;
        this.zzr = new zza(this);
        zzhx zzhx = new zzhx(this);
        zzhx.zzx();
        this.zzp = zzhx;
        zzgt zzgt = new zzgt(this);
        zzgt.zzx();
        this.zzq = zzgt;
        zzjd zzjd = new zzjd(this);
        zzjd.zzx();
        this.zzl = zzjd;
        zzho zzho = new zzho(this);
        zzho.zzab();
        this.zzs = zzho;
        zzfg zzfg = new zzfg(this);
        zzfg.zzab();
        this.zzk = zzfg;
        if (!(zzgq.zzg == null || zzgq.zzg.zzb == 0)) {
            z = true;
        }
        boolean z2 = !z;
        zzr zzr2 = this.zzg;
        if (this.zzb.getApplicationContext() instanceof Application) {
            zzgt zzh2 = zzh();
            if (zzh2.zzn().getApplicationContext() instanceof Application) {
                Application application = (Application) zzh2.zzn().getApplicationContext();
                if (zzh2.zza == null) {
                    zzh2.zza = new zzhm(zzh2, (zzgv) null);
                }
                if (z2) {
                    application.unregisterActivityLifecycleCallbacks(zzh2.zza);
                    application.registerActivityLifecycleCallbacks(zzh2.zza);
                    zzh2.zzr().zzx().zza("Registered activity lifecycle callback");
                }
            }
        } else {
            zzr().zzi().zza("Application context is not an Application");
        }
        this.zzk.zza((Runnable) new zzfp(this, zzgq));
    }

    /* access modifiers changed from: private */
    @WorkerThread
    public final void zza(zzgq zzgq) {
        String str;
        zzel zzel;
        zzq().zzd();
        zzs.zze();
        zzac zzac2 = new zzac(this);
        zzac2.zzab();
        this.zzv = zzac2;
        zzec zzec = new zzec(this, zzgq.zzf);
        zzec.zzx();
        this.zzw = zzec;
        zzef zzef = new zzef(this);
        zzef.zzx();
        this.zzt = zzef;
        zzhy zzhy = new zzhy(this);
        zzhy.zzx();
        this.zzu = zzhy;
        this.zzm.zzac();
        this.zzi.zzac();
        this.zzx = new zzey(this);
        this.zzw.zzy();
        zzr().zzv().zza("App measurement is starting up, version", Long.valueOf(this.zzh.zzf()));
        zzr zzr2 = this.zzg;
        zzr().zzv().zza("To enable debug logging run: adb shell setprop log.tag.FA VERBOSE");
        zzr zzr3 = this.zzg;
        String zzab2 = zzec.zzab();
        if (TextUtils.isEmpty(this.zzc)) {
            if (zzi().zzf(zzab2)) {
                zzel = zzr().zzv();
                str = "Faster debug mode event logging enabled. To disable, run:\n  adb shell setprop debug.firebase.analytics.app .none.";
            } else {
                zzel = zzr().zzv();
                String valueOf = String.valueOf(zzab2);
                str = valueOf.length() != 0 ? "To enable faster debug mode event logging run:\n  adb shell setprop debug.firebase.analytics.app ".concat(valueOf) : new String("To enable faster debug mode event logging run:\n  adb shell setprop debug.firebase.analytics.app ");
            }
            zzel.zza(str);
        }
        zzr().zzw().zza("Debug-level message logging enabled");
        if (this.zzae != this.zzaf.get()) {
            zzr().zzf().zza("Not all components initialized", Integer.valueOf(this.zzae), Integer.valueOf(this.zzaf.get()));
        }
        this.zzy = true;
    }

    /* access modifiers changed from: protected */
    @WorkerThread
    public final void zza() {
        zzq().zzd();
        if (zzc().zzc.zza() == 0) {
            zzc().zzc.zza(this.zzo.currentTimeMillis());
        }
        if (Long.valueOf(zzc().zzh.zza()).longValue() == 0) {
            zzr().zzx().zza("Persisting first open", Long.valueOf(this.zzag));
            zzc().zzh.zza(this.zzag);
        }
        if (zzag()) {
            zzr zzr2 = this.zzg;
            if (!TextUtils.isEmpty(zzy().zzac()) || !TextUtils.isEmpty(zzy().zzad())) {
                zzi();
                if (zzjx.zza(zzy().zzac(), zzc().zzg(), zzy().zzad(), zzc().zzh())) {
                    zzr().zzv().zza("Rechecking which service to use due to a GMP App Id change");
                    zzc().zzj();
                    zzk().zzab();
                    this.zzu.zzah();
                    this.zzu.zzaf();
                    zzc().zzh.zza(this.zzag);
                    zzc().zzj.zza((String) null);
                }
                zzc().zzc(zzy().zzac());
                zzc().zzd(zzy().zzad());
            }
            zzh().zza(zzc().zzj.zza());
            zzr zzr3 = this.zzg;
            if (!TextUtils.isEmpty(zzy().zzac()) || !TextUtils.isEmpty(zzy().zzad())) {
                boolean zzab2 = zzab();
                if (!zzc().zzx() && !this.zzh.zzh()) {
                    zzc().zzd(!zzab2);
                }
                if (zzab2) {
                    zzh().zzai();
                }
                zzw().zza((AtomicReference<String>) new AtomicReference());
            }
        } else if (zzab()) {
            if (!zzi().zzd("android.permission.INTERNET")) {
                zzr().zzf().zza("App is missing INTERNET permission");
            }
            if (!zzi().zzd("android.permission.ACCESS_NETWORK_STATE")) {
                zzr().zzf().zza("App is missing ACCESS_NETWORK_STATE permission");
            }
            zzr zzr4 = this.zzg;
            if (!Wrappers.packageManager(this.zzb).isCallerInstantApp() && !this.zzh.zzz()) {
                if (!zzfd.zza(this.zzb)) {
                    zzr().zzf().zza("AppMeasurementReceiver not registered/enabled");
                }
                if (!zzjx.zza(this.zzb, false)) {
                    zzr().zzf().zza("AppMeasurementService not registered/enabled");
                }
            }
            zzr().zzf().zza("Uploading is not possible. App measurement disabled");
        }
        zzc().zzo.zza(this.zzh.zza(zzak.zzbq));
        zzc().zzp.zza(this.zzh.zza(zzak.zzbr));
    }

    public final zzr zzu() {
        return this.zzg;
    }

    public final zzs zzb() {
        return this.zzh;
    }

    public final zzes zzc() {
        zza((zzgj) this.zzi);
        return this.zzi;
    }

    public final zzej zzr() {
        zzb((zzgi) this.zzj);
        return this.zzj;
    }

    public final zzej zzd() {
        zzej zzej = this.zzj;
        if (zzej == null || !zzej.zzz()) {
            return null;
        }
        return this.zzj;
    }

    public final zzfg zzq() {
        zzb((zzgi) this.zzk);
        return this.zzk;
    }

    public final zzjd zze() {
        zzb((zzg) this.zzl);
        return this.zzl;
    }

    public final zzey zzf() {
        return this.zzx;
    }

    /* access modifiers changed from: package-private */
    public final zzfg zzg() {
        return this.zzk;
    }

    public final zzgt zzh() {
        zzb((zzg) this.zzq);
        return this.zzq;
    }

    public final zzjx zzi() {
        zza((zzgj) this.zzm);
        return this.zzm;
    }

    public final zzeh zzj() {
        zza((zzgj) this.zzn);
        return this.zzn;
    }

    public final zzef zzk() {
        zzb((zzg) this.zzt);
        return this.zzt;
    }

    private final zzho zzai() {
        zzb((zzgi) this.zzs);
        return this.zzs;
    }

    public final Context zzn() {
        return this.zzb;
    }

    public final boolean zzl() {
        return TextUtils.isEmpty(this.zzc);
    }

    public final String zzo() {
        return this.zzc;
    }

    public final String zzp() {
        return this.zzd;
    }

    public final String zzs() {
        return this.zze;
    }

    public final boolean zzt() {
        return this.zzf;
    }

    public final Clock zzm() {
        return this.zzo;
    }

    public final zzhx zzv() {
        zzb((zzg) this.zzp);
        return this.zzp;
    }

    public final zzhy zzw() {
        zzb((zzg) this.zzu);
        return this.zzu;
    }

    public final zzac zzx() {
        zzb((zzgi) this.zzv);
        return this.zzv;
    }

    public final zzec zzy() {
        zzb((zzg) this.zzw);
        return this.zzw;
    }

    public final zza zzz() {
        zza zza2 = this.zzr;
        if (zza2 != null) {
            return zza2;
        }
        throw new IllegalStateException("Component not created");
    }

    @VisibleForTesting
    public static zzfn zza(Context context, String str, String str2, Bundle bundle) {
        return zza(context, new zzx(0, 0, true, (String) null, (String) null, (String) null, bundle));
    }

    public static zzfn zza(Context context, zzx zzx2) {
        if (zzx2 != null && (zzx2.zze == null || zzx2.zzf == null)) {
            zzx2 = new zzx(zzx2.zza, zzx2.zzb, zzx2.zzc, zzx2.zzd, (String) null, (String) null, zzx2.zzg);
        }
        Preconditions.checkNotNull(context);
        Preconditions.checkNotNull(context.getApplicationContext());
        if (zza == null) {
            synchronized (zzfn.class) {
                if (zza == null) {
                    zza = new zzfn(new zzgq(context, zzx2));
                }
            }
        } else if (!(zzx2 == null || zzx2.zzg == null || !zzx2.zzg.containsKey("dataCollectionDefaultEnabled"))) {
            zza.zza(zzx2.zzg.getBoolean("dataCollectionDefaultEnabled"));
        }
        return zza;
    }

    private final void zzaj() {
        if (!this.zzy) {
            throw new IllegalStateException("AppMeasurement is not initialized");
        }
    }

    private static void zzb(zzgi zzgi) {
        if (zzgi == null) {
            throw new IllegalStateException("Component not created");
        } else if (!zzgi.zzz()) {
            String valueOf = String.valueOf(zzgi.getClass());
            StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 27);
            sb.append("Component not initialized: ");
            sb.append(valueOf);
            throw new IllegalStateException(sb.toString());
        }
    }

    private static void zzb(zzg zzg2) {
        if (zzg2 == null) {
            throw new IllegalStateException("Component not created");
        } else if (!zzg2.zzv()) {
            String valueOf = String.valueOf(zzg2.getClass());
            StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 27);
            sb.append("Component not initialized: ");
            sb.append(valueOf);
            throw new IllegalStateException(sb.toString());
        }
    }

    private static void zza(zzgj zzgj) {
        if (zzgj == null) {
            throw new IllegalStateException("Component not created");
        }
    }

    /* access modifiers changed from: package-private */
    @WorkerThread
    public final void zza(boolean z) {
        this.zzab = Boolean.valueOf(z);
    }

    @WorkerThread
    public final boolean zzaa() {
        return this.zzab != null && this.zzab.booleanValue();
    }

    @WorkerThread
    public final boolean zzab() {
        boolean z;
        zzq().zzd();
        zzaj();
        if (this.zzh.zza(zzak.zzbi)) {
            if (this.zzh.zzh()) {
                return false;
            }
            Boolean bool = this.zzad;
            if (bool != null && bool.booleanValue()) {
                return false;
            }
            Boolean zzk2 = zzc().zzk();
            if (zzk2 != null) {
                return zzk2.booleanValue();
            }
            Boolean zzi2 = this.zzh.zzi();
            if (zzi2 != null) {
                return zzi2.booleanValue();
            }
            Boolean bool2 = this.zzac;
            if (bool2 != null) {
                return bool2.booleanValue();
            }
            if (GoogleServices.isMeasurementExplicitlyDisabled()) {
                return false;
            }
            if (!this.zzh.zza(zzak.zzbd) || this.zzab == null) {
                return true;
            }
            return this.zzab.booleanValue();
        } else if (this.zzh.zzh()) {
            return false;
        } else {
            Boolean zzi3 = this.zzh.zzi();
            if (zzi3 != null) {
                z = zzi3.booleanValue();
            } else {
                z = !GoogleServices.isMeasurementExplicitlyDisabled();
                if (z && this.zzab != null && zzak.zzbd.zza(null).booleanValue()) {
                    z = this.zzab.booleanValue();
                }
            }
            return zzc().zzc(z);
        }
    }

    /* access modifiers changed from: package-private */
    public final long zzac() {
        Long valueOf = Long.valueOf(zzc().zzh.zza());
        if (valueOf.longValue() == 0) {
            return this.zzag;
        }
        return Math.min(this.zzag, valueOf.longValue());
    }

    /* access modifiers changed from: package-private */
    public final void zzad() {
        zzr zzr2 = this.zzg;
    }

    /* access modifiers changed from: package-private */
    public final void zzae() {
        zzr zzr2 = this.zzg;
        throw new IllegalStateException("Unexpected call on client side");
    }

    /* access modifiers changed from: package-private */
    public final void zza(zzgi zzgi) {
        this.zzae++;
    }

    /* access modifiers changed from: package-private */
    public final void zza(zzg zzg2) {
        this.zzae++;
    }

    /* access modifiers changed from: package-private */
    public final void zzaf() {
        this.zzaf.incrementAndGet();
    }

    /* access modifiers changed from: protected */
    @WorkerThread
    public final boolean zzag() {
        zzaj();
        zzq().zzd();
        Boolean bool = this.zzz;
        if (bool == null || this.zzaa == 0 || (bool != null && !bool.booleanValue() && Math.abs(this.zzo.elapsedRealtime() - this.zzaa) > 1000)) {
            this.zzaa = this.zzo.elapsedRealtime();
            zzr zzr2 = this.zzg;
            boolean z = true;
            this.zzz = Boolean.valueOf(zzi().zzd("android.permission.INTERNET") && zzi().zzd("android.permission.ACCESS_NETWORK_STATE") && (Wrappers.packageManager(this.zzb).isCallerInstantApp() || this.zzh.zzz() || (zzfd.zza(this.zzb) && zzjx.zza(this.zzb, false))));
            if (this.zzz.booleanValue()) {
                if (!zzi().zzc(zzy().zzac(), zzy().zzad()) && TextUtils.isEmpty(zzy().zzad())) {
                    z = false;
                }
                this.zzz = Boolean.valueOf(z);
            }
        }
        return this.zzz.booleanValue();
    }

    @WorkerThread
    public final void zzah() {
        zzq().zzd();
        zzb((zzgi) zzai());
        String zzab2 = zzy().zzab();
        Pair<String, Boolean> zza2 = zzc().zza(zzab2);
        if (!this.zzh.zzj().booleanValue() || ((Boolean) zza2.second).booleanValue() || TextUtils.isEmpty((CharSequence) zza2.first)) {
            zzr().zzw().zza("ADID unavailable to retrieve Deferred Deep Link. Skipping");
        } else if (!zzai().zzg()) {
            zzr().zzi().zza("Network is not available for Deferred Deep Link request. Skipping");
        } else {
            zzjx zzi2 = zzi();
            URL zza3 = zzi2.zza(zzy().zzt().zzf(), zzab2, (String) zza2.first, zzc().zzv.zza() - 1);
            zzho zzai = zzai();
            zzfm zzfm = new zzfm(this);
            zzai.zzd();
            zzai.zzaa();
            Preconditions.checkNotNull(zza3);
            Preconditions.checkNotNull(zzfm);
            zzai.zzq().zzb((Runnable) new zzhq(zzai, zzab2, zza3, (byte[]) null, (Map<String, String>) null, zzfm));
        }
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zza(String str, int i, Throwable th, byte[] bArr, Map map) {
        List<ResolveInfo> queryIntentActivities;
        boolean z = true;
        if (!((i == 200 || i == 204 || i == 304) && th == null)) {
            zzr().zzi().zza("Network Request for Deferred Deep Link failed. response, exception", Integer.valueOf(i), th);
            return;
        }
        zzc().zzu.zza(true);
        if (bArr.length == 0) {
            zzr().zzw().zza("Deferred Deep Link response empty.");
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(new String(bArr));
            String optString = jSONObject.optString("deeplink", "");
            String optString2 = jSONObject.optString("gclid", "");
            zzjx zzi2 = zzi();
            zzi2.zzb();
            if (TextUtils.isEmpty(optString) || (queryIntentActivities = zzi2.zzn().getPackageManager().queryIntentActivities(new Intent("android.intent.action.VIEW", Uri.parse(optString)), 0)) == null || queryIntentActivities.isEmpty()) {
                z = false;
            }
            if (!z) {
                zzr().zzi().zza("Deferred Deep Link validation failed. gclid, deep link", optString2, optString);
                return;
            }
            Bundle bundle = new Bundle();
            bundle.putString("gclid", optString2);
            bundle.putString("_cis", "ddp");
            this.zzq.zza("auto", "_cmp", bundle);
            zzjx zzi3 = zzi();
            if (!TextUtils.isEmpty(optString) && zzi3.zzg(optString)) {
                zzi3.zzn().sendBroadcast(new Intent("android.google.analytics.action.DEEPLINK_ACTION"));
            }
        } catch (JSONException e) {
            zzr().zzf().zza("Failed to parse the Deferred Deep Link response. exception", e);
        }
    }
}
