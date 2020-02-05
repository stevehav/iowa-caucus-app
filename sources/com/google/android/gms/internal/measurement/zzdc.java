package com.google.android.gms.internal.measurement;

import java.io.Serializable;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.0.1 */
public final class zzdc {
    public static <T> zzcz<T> zza(zzcz<T> zzcz) {
        if ((zzcz instanceof zzde) || (zzcz instanceof zzdb)) {
            return zzcz;
        }
        if (zzcz instanceof Serializable) {
            return new zzdb(zzcz);
        }
        return new zzde(zzcz);
    }

    public static <T> zzcz<T> zza(@NullableDecl T t) {
        return new zzdd(t);
    }
}
