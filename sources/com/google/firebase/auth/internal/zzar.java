package com.google.firebase.auth.internal;

import android.text.TextUtils;
import com.google.android.gms.internal.firebase_auth.zzaz;
import com.google.android.gms.internal.firebase_auth.zzfa;
import com.google.firebase.auth.zzae;
import com.google.firebase.auth.zzy;
import java.util.ArrayList;
import java.util.List;

/* compiled from: com.google.firebase:firebase-auth@@18.1.0 */
public final class zzar {
    public static zzy zza(zzfa zzfa) {
        if (zzfa != null && !TextUtils.isEmpty(zzfa.zza())) {
            return new zzae(zzfa.zzb(), zzfa.zzc(), zzfa.zzd(), zzfa.zza());
        }
        return null;
    }

    public static List<zzy> zza(List<zzfa> list) {
        if (list == null || list.isEmpty()) {
            return zzaz.zza();
        }
        ArrayList arrayList = new ArrayList();
        for (zzfa zza : list) {
            zzy zza2 = zza(zza);
            if (zza2 != null) {
                arrayList.add(zza2);
            }
        }
        return arrayList;
    }
}
