package com.google.android.gms.internal.firebase_auth;

import java.util.Iterator;
import java.util.Set;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* compiled from: com.google.firebase:firebase-auth@@18.1.0 */
public abstract class zzbg<E> extends zzba<E> implements Set<E> {
    @NullableDecl
    private transient zzaz<E> zza;

    zzbg() {
    }

    public boolean equals(@NullableDecl Object obj) {
        if (obj == this) {
            return true;
        }
        return zzbl.zza(this, obj);
    }

    public int hashCode() {
        return zzbl.zza(this);
    }

    public zzaz<E> zzc() {
        zzaz<E> zzaz = this.zza;
        if (zzaz != null) {
            return zzaz;
        }
        zzaz<E> zza2 = zza();
        this.zza = zza2;
        return zza2;
    }

    /* access modifiers changed from: package-private */
    public zzaz<E> zza() {
        return zzaz.zza(toArray());
    }

    public /* synthetic */ Iterator iterator() {
        return iterator();
    }
}
