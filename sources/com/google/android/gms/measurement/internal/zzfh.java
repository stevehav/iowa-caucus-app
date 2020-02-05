package com.google.android.gms.measurement.internal;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteException;
import android.text.TextUtils;
import androidx.annotation.WorkerThread;
import androidx.collection.ArrayMap;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.Clock;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.internal.measurement.zzbj;
import com.google.android.gms.internal.measurement.zzbo;
import com.google.android.gms.internal.measurement.zzeq;
import com.google.android.gms.internal.measurement.zzfd;
import com.google.android.gms.internal.measurement.zzfn;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-measurement@@17.0.1 */
public final class zzfh extends zzjm implements zzu {
    @VisibleForTesting
    private static int zzb = 65535;
    @VisibleForTesting
    private static int zzc = 2;
    private final Map<String, Map<String, String>> zzd = new ArrayMap();
    private final Map<String, Map<String, Boolean>> zze = new ArrayMap();
    private final Map<String, Map<String, Boolean>> zzf = new ArrayMap();
    private final Map<String, zzbo.zzb> zzg = new ArrayMap();
    private final Map<String, Map<String, Integer>> zzh = new ArrayMap();
    private final Map<String, String> zzi = new ArrayMap();

    zzfh(zzjp zzjp) {
        super(zzjp);
    }

    /* access modifiers changed from: protected */
    public final boolean zze() {
        return false;
    }

    @WorkerThread
    private final void zzi(String str) {
        zzak();
        zzd();
        Preconditions.checkNotEmpty(str);
        if (this.zzg.get(str) == null) {
            byte[] zzd2 = zzi().zzd(str);
            if (zzd2 == null) {
                this.zzd.put(str, (Object) null);
                this.zze.put(str, (Object) null);
                this.zzf.put(str, (Object) null);
                this.zzg.put(str, (Object) null);
                this.zzi.put(str, (Object) null);
                this.zzh.put(str, (Object) null);
                return;
            }
            zzbo.zzb.zza zza = (zzbo.zzb.zza) zza(str, zzd2).zzbk();
            zza(str, zza);
            this.zzd.put(str, zza((zzbo.zzb) ((zzfd) zza.zzu())));
            this.zzg.put(str, (zzbo.zzb) ((zzfd) zza.zzu()));
            this.zzi.put(str, (Object) null);
        }
    }

    /* access modifiers changed from: protected */
    @WorkerThread
    public final zzbo.zzb zza(String str) {
        zzak();
        zzd();
        Preconditions.checkNotEmpty(str);
        zzi(str);
        return this.zzg.get(str);
    }

    /* access modifiers changed from: protected */
    @WorkerThread
    public final String zzb(String str) {
        zzd();
        return this.zzi.get(str);
    }

    /* access modifiers changed from: protected */
    @WorkerThread
    public final void zzc(String str) {
        zzd();
        this.zzi.put(str, (Object) null);
    }

    /* access modifiers changed from: package-private */
    @WorkerThread
    public final void zzd(String str) {
        zzd();
        this.zzg.remove(str);
    }

    /* access modifiers changed from: package-private */
    @WorkerThread
    public final boolean zze(String str) {
        zzd();
        zzbo.zzb zza = zza(str);
        if (zza == null) {
            return false;
        }
        return zza.zzg();
    }

    @WorkerThread
    public final String zza(String str, String str2) {
        zzd();
        zzi(str);
        Map map = this.zzd.get(str);
        if (map != null) {
            return (String) map.get(str2);
        }
        return null;
    }

    private static Map<String, String> zza(zzbo.zzb zzb2) {
        ArrayMap arrayMap = new ArrayMap();
        if (zzb2 != null) {
            for (zzbo.zzc next : zzb2.zzd()) {
                arrayMap.put(next.zza(), next.zzb());
            }
        }
        return arrayMap;
    }

    private final void zza(String str, zzbo.zzb.zza zza) {
        ArrayMap arrayMap = new ArrayMap();
        ArrayMap arrayMap2 = new ArrayMap();
        ArrayMap arrayMap3 = new ArrayMap();
        if (zza != null) {
            for (int i = 0; i < zza.zza(); i++) {
                zzbo.zza.C0011zza zza2 = (zzbo.zza.C0011zza) zza.zza(i).zzbk();
                if (TextUtils.isEmpty(zza2.zza())) {
                    zzr().zzi().zza("EventConfig contained null event name");
                } else {
                    String zzb2 = zzgn.zzb(zza2.zza());
                    if (!TextUtils.isEmpty(zzb2)) {
                        zza2 = zza2.zza(zzb2);
                        zza.zza(i, zza2);
                    }
                    arrayMap.put(zza2.zza(), Boolean.valueOf(zza2.zzb()));
                    arrayMap2.put(zza2.zza(), Boolean.valueOf(zza2.zzc()));
                    if (zza2.zzd()) {
                        if (zza2.zze() < zzc || zza2.zze() > zzb) {
                            zzr().zzi().zza("Invalid sampling rate. Event name, sample rate", zza2.zza(), Integer.valueOf(zza2.zze()));
                        } else {
                            arrayMap3.put(zza2.zza(), Integer.valueOf(zza2.zze()));
                        }
                    }
                }
            }
        }
        this.zze.put(str, arrayMap);
        this.zzf.put(str, arrayMap2);
        this.zzh.put(str, arrayMap3);
    }

    /* access modifiers changed from: protected */
    @WorkerThread
    public final boolean zza(String str, byte[] bArr, String str2) {
        byte[] bArr2;
        boolean z;
        String str3 = str;
        zzak();
        zzd();
        Preconditions.checkNotEmpty(str);
        zzbo.zzb.zza zza = (zzbo.zzb.zza) zza(str, bArr).zzbk();
        if (zza == null) {
            return false;
        }
        zza(str3, zza);
        this.zzg.put(str3, (zzbo.zzb) ((zzfd) zza.zzu()));
        this.zzi.put(str3, str2);
        this.zzd.put(str3, zza((zzbo.zzb) ((zzfd) zza.zzu())));
        zzp e_ = e_();
        zzbj.zza[] zzaArr = (zzbj.zza[]) zza.zzb().toArray(new zzbj.zza[0]);
        Preconditions.checkNotNull(zzaArr);
        for (int i = 0; i < zzaArr.length; i++) {
            zzbj.zza.C0010zza zza2 = (zzbj.zza.C0010zza) zzaArr[i].zzbk();
            if (zza2.zzb() != 0) {
                zzbj.zza.C0010zza zza3 = zza2;
                for (int i2 = 0; i2 < zza3.zzb(); i2++) {
                    zzbj.zzb.zza zza4 = (zzbj.zzb.zza) zza3.zzb(i2).zzbk();
                    zzbj.zzb.zza zza5 = (zzbj.zzb.zza) ((zzfd.zza) zza4.clone());
                    String zzb2 = zzgn.zzb(zza4.zza());
                    if (zzb2 != null) {
                        zza5.zza(zzb2);
                        z = true;
                    } else {
                        z = false;
                    }
                    boolean z2 = z;
                    for (int i3 = 0; i3 < zza4.zzb(); i3++) {
                        zzbj.zzc zza6 = zza4.zza(i3);
                        String zza7 = zzgm.zza(zza6.zzg());
                        if (zza7 != null) {
                            zza5.zza(i3, (zzbj.zzc) ((zzfd) ((zzbj.zzc.zza) zza6.zzbk()).zza(zza7).zzu()));
                            z2 = true;
                        }
                    }
                    if (z2) {
                        zza3 = zza3.zza(i2, zza5);
                        zzaArr[i] = (zzbj.zza) ((zzfd) zza3.zzu());
                    }
                }
                zza2 = zza3;
            }
            if (zza2.zza() != 0) {
                zzbj.zza.C0010zza zza8 = zza2;
                for (int i4 = 0; i4 < zza8.zza(); i4++) {
                    zzbj.zze zza9 = zza8.zza(i4);
                    String zza10 = zzgp.zza(zza9.zzc());
                    if (zza10 != null) {
                        zza8 = zza8.zza(i4, ((zzbj.zze.zza) zza9.zzbk()).zza(zza10));
                        zzaArr[i] = (zzbj.zza) ((zzfd) zza8.zzu());
                    }
                }
            }
        }
        e_.zzi().zza(str3, zzaArr);
        try {
            zza.zzc();
            bArr2 = ((zzbo.zzb) ((zzfd) zza.zzu())).zzbh();
        } catch (RuntimeException e) {
            zzr().zzi().zza("Unable to serialize reduced-size config. Storing full config instead. appId", zzej.zza(str), e);
            bArr2 = bArr;
        }
        zzx zzi2 = zzi();
        Preconditions.checkNotEmpty(str);
        zzi2.zzd();
        zzi2.zzak();
        ContentValues contentValues = new ContentValues();
        contentValues.put("remote_config", bArr2);
        try {
            if (((long) zzi2.c_().update("apps", contentValues, "app_id = ?", new String[]{str3})) == 0) {
                zzi2.zzr().zzf().zza("Failed to update remote config (got 0). appId", zzej.zza(str));
            }
        } catch (SQLiteException e2) {
            zzi2.zzr().zzf().zza("Error storing remote config. appId", zzej.zza(str), e2);
        }
        this.zzg.put(str3, (zzbo.zzb) ((zzfd) zza.zzu()));
        return true;
    }

    /* access modifiers changed from: package-private */
    @WorkerThread
    public final boolean zzb(String str, String str2) {
        Boolean bool;
        zzd();
        zzi(str);
        if (zzg(str) && zzjx.zze(str2)) {
            return true;
        }
        if (zzh(str) && zzjx.zza(str2)) {
            return true;
        }
        Map map = this.zze.get(str);
        if (map == null || (bool = (Boolean) map.get(str2)) == null) {
            return false;
        }
        return bool.booleanValue();
    }

    /* access modifiers changed from: package-private */
    @WorkerThread
    public final boolean zzc(String str, String str2) {
        Boolean bool;
        zzd();
        zzi(str);
        if (FirebaseAnalytics.Event.ECOMMERCE_PURCHASE.equals(str2)) {
            return true;
        }
        Map map = this.zzf.get(str);
        if (map == null || (bool = (Boolean) map.get(str2)) == null) {
            return false;
        }
        return bool.booleanValue();
    }

    /* access modifiers changed from: package-private */
    @WorkerThread
    public final int zzd(String str, String str2) {
        Integer num;
        zzd();
        zzi(str);
        Map map = this.zzh.get(str);
        if (map == null || (num = (Integer) map.get(str2)) == null) {
            return 1;
        }
        return num.intValue();
    }

    /* access modifiers changed from: package-private */
    @WorkerThread
    public final long zzf(String str) {
        String zza = zza(str, "measurement.account.time_zone_offset_minutes");
        if (TextUtils.isEmpty(zza)) {
            return 0;
        }
        try {
            return Long.parseLong(zza);
        } catch (NumberFormatException e) {
            zzr().zzi().zza("Unable to parse timezone offset. appId", zzej.zza(str), e);
            return 0;
        }
    }

    @WorkerThread
    private final zzbo.zzb zza(String str, byte[] bArr) {
        if (bArr == null) {
            return zzbo.zzb.zzh();
        }
        try {
            zzbo.zzb zza = zzbo.zzb.zza(bArr, zzeq.zzb());
            zzr().zzx().zza("Parsed config. version, gmp_app_id", zza.zza() ? Long.valueOf(zza.zzb()) : null, zza.zzc());
            return zza;
        } catch (zzfn e) {
            zzr().zzi().zza("Unable to merge remote config. appId", zzej.zza(str), e);
            return zzbo.zzb.zzh();
        } catch (RuntimeException e2) {
            zzr().zzi().zza("Unable to merge remote config. appId", zzej.zza(str), e2);
            return zzbo.zzb.zzh();
        }
    }

    /* access modifiers changed from: package-private */
    public final boolean zzg(String str) {
        return "1".equals(zza(str, "measurement.upload.blacklist_internal"));
    }

    /* access modifiers changed from: package-private */
    public final boolean zzh(String str) {
        return "1".equals(zza(str, "measurement.upload.blacklist_public"));
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
