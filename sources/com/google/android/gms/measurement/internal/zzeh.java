package com.google.android.gms.measurement.internal;

import android.content.Context;
import android.os.Bundle;
import androidx.annotation.Nullable;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.Clock;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.0.1 */
public final class zzeh extends zzgi {
    private static final AtomicReference<String[]> zza = new AtomicReference<>();
    private static final AtomicReference<String[]> zzb = new AtomicReference<>();
    private static final AtomicReference<String[]> zzc = new AtomicReference<>();

    zzeh(zzfn zzfn) {
        super(zzfn);
    }

    /* access modifiers changed from: protected */
    public final boolean zze() {
        return false;
    }

    private final boolean zzg() {
        zzu();
        return this.zzw.zzl() && this.zzw.zzr().zza(3);
    }

    /* access modifiers changed from: protected */
    @Nullable
    public final String zza(String str) {
        if (str == null) {
            return null;
        }
        if (!zzg()) {
            return str;
        }
        return zza(str, zzgn.zzb, zzgn.zza, zza);
    }

    /* access modifiers changed from: protected */
    @Nullable
    public final String zzb(String str) {
        if (str == null) {
            return null;
        }
        if (!zzg()) {
            return str;
        }
        return zza(str, zzgm.zzb, zzgm.zza, zzb);
    }

    /* access modifiers changed from: protected */
    @Nullable
    public final String zzc(String str) {
        if (str == null) {
            return null;
        }
        if (!zzg()) {
            return str;
        }
        if (!str.startsWith("_exp_")) {
            return zza(str, zzgp.zzb, zzgp.zza, zzc);
        }
        return "experiment_id" + "(" + str + ")";
    }

    @Nullable
    private static String zza(String str, String[] strArr, String[] strArr2, AtomicReference<String[]> atomicReference) {
        String str2;
        Preconditions.checkNotNull(strArr);
        Preconditions.checkNotNull(strArr2);
        Preconditions.checkNotNull(atomicReference);
        Preconditions.checkArgument(strArr.length == strArr2.length);
        for (int i = 0; i < strArr.length; i++) {
            if (zzjx.zzd(str, strArr[i])) {
                synchronized (atomicReference) {
                    String[] strArr3 = atomicReference.get();
                    if (strArr3 == null) {
                        strArr3 = new String[strArr2.length];
                        atomicReference.set(strArr3);
                    }
                    if (strArr3[i] == null) {
                        strArr3[i] = strArr2[i] + "(" + strArr[i] + ")";
                    }
                    str2 = strArr3[i];
                }
                return str2;
            }
        }
        return str;
    }

    /* access modifiers changed from: protected */
    @Nullable
    public final String zza(zzai zzai) {
        if (zzai == null) {
            return null;
        }
        if (!zzg()) {
            return zzai.toString();
        }
        return "origin=" + zzai.zzc + ",name=" + zza(zzai.zza) + ",params=" + zza(zzai.zzb);
    }

    /* access modifiers changed from: protected */
    @Nullable
    public final String zza(zzaf zzaf) {
        if (zzaf == null) {
            return null;
        }
        if (!zzg()) {
            return zzaf.toString();
        }
        return "Event{appId='" + zzaf.zza + "', name='" + zza(zzaf.zzb) + "', params=" + zza(zzaf.zze) + "}";
    }

    @Nullable
    private final String zza(zzah zzah) {
        if (zzah == null) {
            return null;
        }
        if (!zzg()) {
            return zzah.toString();
        }
        return zza(zzah.zzb());
    }

    /* access modifiers changed from: protected */
    @Nullable
    public final String zza(Bundle bundle) {
        if (bundle == null) {
            return null;
        }
        if (!zzg()) {
            return bundle.toString();
        }
        StringBuilder sb = new StringBuilder();
        for (String str : bundle.keySet()) {
            if (sb.length() != 0) {
                sb.append(", ");
            } else {
                sb.append("Bundle[{");
            }
            sb.append(zzb(str));
            sb.append("=");
            sb.append(bundle.get(str));
        }
        sb.append("}]");
        return sb.toString();
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
