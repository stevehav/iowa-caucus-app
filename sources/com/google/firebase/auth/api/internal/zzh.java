package com.google.firebase.auth.api.internal;

import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.google.android.gms.internal.firebase_auth.zzeq;
import com.google.android.gms.internal.firebase_auth.zzes;
import com.google.android.gms.internal.firebase_auth.zzey;
import com.google.android.gms.internal.firebase_auth.zzfc;
import com.google.android.gms.internal.firebase_auth.zzfe;
import com.google.firebase.auth.zzg;
import java.util.List;

/* compiled from: com.google.firebase:firebase-auth@@18.1.0 */
final class zzh implements zzfe<zzeq> {
    private final /* synthetic */ zzfb zza;
    private final /* synthetic */ String zzb;
    private final /* synthetic */ String zzc;
    private final /* synthetic */ Boolean zzd;
    private final /* synthetic */ zzg zze;
    private final /* synthetic */ zzdr zzf;
    private final /* synthetic */ zzey zzg;

    zzh(zza zza2, zzfb zzfb, String str, String str2, Boolean bool, zzg zzg2, zzdr zzdr, zzey zzey) {
        this.zza = zzfb;
        this.zzb = str;
        this.zzc = str2;
        this.zzd = bool;
        this.zze = zzg2;
        this.zzf = zzdr;
        this.zzg = zzey;
    }

    public final void zza(@Nullable String str) {
        this.zza.zza(str);
    }

    public final /* synthetic */ void zza(Object obj) {
        List<zzes> zzb2 = ((zzeq) obj).zzb();
        if (zzb2 == null || zzb2.isEmpty()) {
            this.zza.zza("No users.");
            return;
        }
        boolean z = false;
        zzes zzes = zzb2.get(0);
        zzfe zzk = zzes.zzk();
        List<zzfc> zza2 = zzk != null ? zzk.zza() : null;
        if (zza2 != null && !zza2.isEmpty()) {
            if (!TextUtils.isEmpty(this.zzb)) {
                int i = 0;
                while (true) {
                    if (i >= zza2.size()) {
                        break;
                    } else if (zza2.get(i).zzd().equals(this.zzb)) {
                        zza2.get(i).zza(this.zzc);
                        break;
                    } else {
                        i++;
                    }
                }
            } else {
                zza2.get(0).zza(this.zzc);
            }
        }
        Boolean bool = this.zzd;
        if (bool != null) {
            zzes.zza(bool.booleanValue());
        } else {
            if (zzes.zzh() - zzes.zzg() < 1000) {
                z = true;
            }
            zzes.zza(z);
        }
        zzes.zza(this.zze);
        this.zzf.zza(this.zzg, zzes);
    }
}
