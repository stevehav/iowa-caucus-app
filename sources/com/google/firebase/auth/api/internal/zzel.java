package com.google.firebase.auth.api.internal;

import android.text.TextUtils;
import com.google.android.gms.common.internal.LibraryVersion;
import com.google.android.gms.internal.firebase_auth.zzan;
import java.util.List;

/* compiled from: com.google.firebase:firebase-auth@@18.1.0 */
public final class zzel {
    private final int zza;
    private final int zzb = -1;

    private zzel(String str, int i) {
        this.zza = zzc(str);
    }

    public final boolean zza() {
        return this.zza >= zzc("16.2.1");
    }

    public final boolean zza(String str) {
        return this.zza >= zzc(str);
    }

    public static String zzb() {
        return zzb("firebase-auth");
    }

    private static String zzb(String str) {
        String version = LibraryVersion.getInstance().getVersion(str);
        return (TextUtils.isEmpty(version) || version.equals("UNKNOWN")) ? "-1" : version;
    }

    public static zzel zzc() {
        return new zzel(zzb("firebase-auth-impl"), -1);
    }

    private static int zzc(String str) {
        List<String> zza2 = zzan.zza(".").zza((CharSequence) str);
        if (zza2.size() == 1) {
            return Integer.parseInt(str);
        }
        if (zza2.size() == 3) {
            return (Integer.parseInt(zza2.get(0)) * 1000000) + (Integer.parseInt(zza2.get(1)) * 1000) + Integer.parseInt(zza2.get(2));
        }
        String str2 = "";
        for (String valueOf : zza2) {
            String valueOf2 = String.valueOf(str2);
            String valueOf3 = String.valueOf(valueOf);
            str2 = valueOf3.length() != 0 ? valueOf2.concat(valueOf3) : new String(valueOf2);
        }
        return Integer.parseInt(str2);
    }
}
