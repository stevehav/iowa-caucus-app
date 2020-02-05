package com.google.android.gms.internal.measurement;

import android.net.Uri;
import java.util.Map;
import javax.annotation.Nullable;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.0.1 */
final class zzch {
    @Nullable
    private final Map<String, Map<String, String>> zza;

    zzch(@Nullable Map<String, Map<String, String>> map) {
        this.zza = map;
    }

    static zzch zza() {
        return new zzch((Map<String, Map<String, String>>) null);
    }

    /* access modifiers changed from: package-private */
    @Nullable
    public final String zza(@Nullable Uri uri, @Nullable String str, @Nullable String str2, String str3) {
        if (this.zza == null) {
            return null;
        }
        if (uri != null) {
            str = uri.toString();
        } else if (str == null) {
            return null;
        }
        Map map = this.zza.get(str);
        if (map == null) {
            return null;
        }
        if (str2 != null) {
            String valueOf = String.valueOf(str2);
            String valueOf2 = String.valueOf(str3);
            str3 = valueOf2.length() != 0 ? valueOf.concat(valueOf2) : new String(valueOf);
        }
        return (String) map.get(str3);
    }
}
