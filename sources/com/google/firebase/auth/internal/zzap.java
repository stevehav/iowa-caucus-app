package com.google.firebase.auth.internal;

import com.google.android.gms.common.logging.Logger;
import com.google.android.gms.internal.firebase_auth.zzbq;
import com.google.firebase.auth.GetTokenResult;
import java.util.Collections;
import java.util.Map;

/* compiled from: com.google.firebase:firebase-auth@@18.1.0 */
public final class zzap {
    private static final Logger zza = new Logger("GetTokenResultFactory", new String[0]);

    public static GetTokenResult zza(String str) {
        Map<String, Object> map;
        try {
            map = zzao.zza(str);
        } catch (zzbq e) {
            zza.e("Error parsing token claims", e, new Object[0]);
            map = Collections.EMPTY_MAP;
        }
        return new GetTokenResult(str, map);
    }
}
