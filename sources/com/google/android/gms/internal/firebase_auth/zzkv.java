package com.google.android.gms.internal.firebase_auth;

import java.util.Iterator;

/* compiled from: com.google.firebase:firebase-auth@@18.1.0 */
final class zzkv implements Iterator<String> {
    private Iterator<String> zza = this.zzb.zza.iterator();
    private final /* synthetic */ zzkt zzb;

    zzkv(zzkt zzkt) {
        this.zzb = zzkt;
    }

    public final boolean hasNext() {
        return this.zza.hasNext();
    }

    public final void remove() {
        throw new UnsupportedOperationException();
    }

    public final /* synthetic */ Object next() {
        return this.zza.next();
    }
}
