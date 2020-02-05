package com.google.android.gms.internal.firebase_auth;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* compiled from: com.google.firebase:firebase-auth@@18.1.0 */
public final class zzan {
    /* access modifiers changed from: private */
    public final zzaf zza;
    private final boolean zzb;
    private final zzat zzc;
    /* access modifiers changed from: private */
    public final int zzd;

    private zzan(zzat zzat) {
        this(zzat, false, zzaj.zza, Integer.MAX_VALUE);
    }

    private zzan(zzat zzat, boolean z, zzaf zzaf, int i) {
        this.zzc = zzat;
        this.zzb = false;
        this.zza = zzaf;
        this.zzd = Integer.MAX_VALUE;
    }

    public static zzan zza(char c) {
        zzah zzah = new zzah(c);
        zzao.zza(zzah);
        return new zzan(new zzaq(zzah));
    }

    public static zzan zza(String str) {
        zzao.zza(str.length() != 0, (Object) "The separator may not be the empty string.");
        if (str.length() == 1) {
            return zza(str.charAt(0));
        }
        return new zzan(new zzas(str));
    }

    public final List<String> zza(CharSequence charSequence) {
        zzao.zza(charSequence);
        Iterator<String> zza2 = this.zzc.zza(this, charSequence);
        ArrayList arrayList = new ArrayList();
        while (zza2.hasNext()) {
            arrayList.add(zza2.next());
        }
        return Collections.unmodifiableList(arrayList);
    }
}
