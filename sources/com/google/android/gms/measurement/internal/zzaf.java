package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import android.text.TextUtils;
import com.google.android.gms.common.internal.Preconditions;
import java.util.Iterator;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.0.1 */
public final class zzaf {
    final String zza;
    final String zzb;
    final long zzc;
    final long zzd;
    final zzah zze;
    private final String zzf;

    private zzaf(zzfn zzfn, String str, String str2, String str3, long j, long j2, zzah zzah) {
        Preconditions.checkNotEmpty(str2);
        Preconditions.checkNotEmpty(str3);
        Preconditions.checkNotNull(zzah);
        this.zza = str2;
        this.zzb = str3;
        this.zzf = TextUtils.isEmpty(str) ? null : str;
        this.zzc = j;
        this.zzd = j2;
        long j3 = this.zzd;
        if (j3 != 0 && j3 > this.zzc) {
            zzfn.zzr().zzi().zza("Event created with reverse previous/current timestamps. appId, name", zzej.zza(str2), zzej.zza(str3));
        }
        this.zze = zzah;
    }

    zzaf(zzfn zzfn, String str, String str2, String str3, long j, long j2, Bundle bundle) {
        zzah zzah;
        Preconditions.checkNotEmpty(str2);
        Preconditions.checkNotEmpty(str3);
        this.zza = str2;
        this.zzb = str3;
        this.zzf = TextUtils.isEmpty(str) ? null : str;
        this.zzc = j;
        this.zzd = j2;
        long j3 = this.zzd;
        if (j3 != 0 && j3 > this.zzc) {
            zzfn.zzr().zzi().zza("Event created with reverse previous/current timestamps. appId", zzej.zza(str2));
        }
        if (bundle == null || bundle.isEmpty()) {
            zzah = new zzah(new Bundle());
        } else {
            Bundle bundle2 = new Bundle(bundle);
            Iterator it = bundle2.keySet().iterator();
            while (it.hasNext()) {
                String str4 = (String) it.next();
                if (str4 == null) {
                    zzfn.zzr().zzf().zza("Param name can't be null");
                    it.remove();
                } else {
                    Object zza2 = zzfn.zzi().zza(str4, bundle2.get(str4));
                    if (zza2 == null) {
                        zzfn.zzr().zzi().zza("Param value can't be null", zzfn.zzj().zzb(str4));
                        it.remove();
                    } else {
                        zzfn.zzi().zza(bundle2, str4, zza2);
                    }
                }
            }
            zzah = new zzah(bundle2);
        }
        this.zze = zzah;
    }

    /* access modifiers changed from: package-private */
    public final zzaf zza(zzfn zzfn, long j) {
        return new zzaf(zzfn, this.zzf, this.zza, this.zzb, this.zzc, j, this.zze);
    }

    public final String toString() {
        String str = this.zza;
        String str2 = this.zzb;
        String valueOf = String.valueOf(this.zze);
        StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 33 + String.valueOf(str2).length() + String.valueOf(valueOf).length());
        sb.append("Event{appId='");
        sb.append(str);
        sb.append("', name='");
        sb.append(str2);
        sb.append("', params=");
        sb.append(valueOf);
        sb.append('}');
        return sb.toString();
    }
}
