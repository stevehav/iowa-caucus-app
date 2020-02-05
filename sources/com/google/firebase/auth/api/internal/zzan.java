package com.google.firebase.auth.api.internal;

import android.util.Log;
import com.google.android.gms.common.internal.ImagesContract;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.VisibleForTesting;
import java.util.Map;

@VisibleForTesting
/* compiled from: com.google.firebase:firebase-auth@@18.1.0 */
final class zzan implements zzas {
    private final int zza;
    private final int zzb;
    private final Map<String, Integer> zzc;

    public zzan(int i, int i2, Map<String, Integer> map) {
        this.zza = zza() ? 0 : i;
        this.zzb = i2;
        this.zzc = (Map) Preconditions.checkNotNull(map);
        zza();
    }

    public final boolean zza(String str) {
        int i = this.zza;
        if (i == 0) {
            return true;
        }
        if (this.zzb <= i) {
            return false;
        }
        Integer num = this.zzc.get(str);
        if (num == null) {
            num = 0;
        }
        if (num.intValue() <= this.zza || this.zzb < num.intValue()) {
            return false;
        }
        return true;
    }

    private static boolean zza() {
        boolean equals = ImagesContract.LOCAL.equals(zzfi.zza("firebear.preference"));
        if (equals) {
            Log.e("BiChannelGoogleApi", "Found local preference, will always use local service instance");
        }
        return equals;
    }
}
