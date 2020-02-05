package com.google.android.gms.internal.measurement;

import com.google.android.gms.internal.measurement.zzfd;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.0.1 */
public class zzeq {
    private static volatile boolean zza = false;
    private static boolean zzb = true;
    private static final Class<?> zzc = zzc();
    private static volatile zzeq zzd;
    private static volatile zzeq zze;
    private static final zzeq zzf = new zzeq(true);
    private final Map<zza, zzfd.zze<?, ?>> zzg;

    private static Class<?> zzc() {
        try {
            return Class.forName("com.google.protobuf.Extension");
        } catch (ClassNotFoundException unused) {
            return null;
        }
    }

    /* compiled from: com.google.android.gms:play-services-measurement-impl@@17.0.1 */
    static final class zza {
        private final Object zza;
        private final int zzb;

        zza(Object obj, int i) {
            this.zza = obj;
            this.zzb = i;
        }

        public final int hashCode() {
            return (System.identityHashCode(this.zza) * 65535) + this.zzb;
        }

        public final boolean equals(Object obj) {
            if (!(obj instanceof zza)) {
                return false;
            }
            zza zza2 = (zza) obj;
            if (this.zza == zza2.zza && this.zzb == zza2.zzb) {
                return true;
            }
            return false;
        }
    }

    public static zzeq zza() {
        zzeq zzeq = zzd;
        if (zzeq == null) {
            synchronized (zzeq.class) {
                zzeq = zzd;
                if (zzeq == null) {
                    zzeq = zzf;
                    zzd = zzeq;
                }
            }
        }
        return zzeq;
    }

    public static zzeq zzb() {
        zzeq zzeq = zze;
        if (zzeq == null) {
            synchronized (zzeq.class) {
                zzeq = zze;
                if (zzeq == null) {
                    zzeq = zzfc.zza(zzeq.class);
                    zze = zzeq;
                }
            }
        }
        return zzeq;
    }

    public final <ContainingType extends zzgn> zzfd.zze<ContainingType, ?> zza(ContainingType containingtype, int i) {
        return this.zzg.get(new zza(containingtype, i));
    }

    zzeq() {
        this.zzg = new HashMap();
    }

    private zzeq(boolean z) {
        this.zzg = Collections.emptyMap();
    }
}
