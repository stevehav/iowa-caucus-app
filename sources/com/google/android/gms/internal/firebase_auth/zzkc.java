package com.google.android.gms.internal.firebase_auth;

import java.util.Iterator;
import java.util.Map;

/* compiled from: com.google.firebase:firebase-auth@@18.1.0 */
final class zzkc extends zzki {
    private final /* synthetic */ zzkb zza;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    private zzkc(zzkb zzkb) {
        super(zzkb, (zzka) null);
        this.zza = zzkb;
    }

    public final Iterator<Map.Entry<K, V>> iterator() {
        return new zzkd(this.zza, (zzka) null);
    }

    /* synthetic */ zzkc(zzkb zzkb, zzka zzka) {
        this(zzkb);
    }
}
