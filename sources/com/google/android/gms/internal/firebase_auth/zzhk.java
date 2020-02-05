package com.google.android.gms.internal.firebase_auth;

import com.google.android.gms.internal.firebase_auth.zzhx;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* compiled from: com.google.firebase:firebase-auth@@18.1.0 */
public class zzhk {
    private static volatile boolean zza = false;
    private static boolean zzb = true;
    private static final Class<?> zzc = zzc();
    private static volatile zzhk zzd;
    private static volatile zzhk zze;
    private static final zzhk zzf = new zzhk(true);
    private final Map<zza, zzhx.zzc<?, ?>> zzg;

    private static Class<?> zzc() {
        try {
            return Class.forName("com.google.protobuf.Extension");
        } catch (ClassNotFoundException unused) {
            return null;
        }
    }

    /* compiled from: com.google.firebase:firebase-auth@@18.1.0 */
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

    public static zzhk zza() {
        zzhk zzhk = zzd;
        if (zzhk == null) {
            synchronized (zzhk.class) {
                zzhk = zzd;
                if (zzhk == null) {
                    zzhk = zzf;
                    zzd = zzhk;
                }
            }
        }
        return zzhk;
    }

    public static zzhk zzb() {
        zzhk zzhk = zze;
        if (zzhk == null) {
            synchronized (zzhk.class) {
                zzhk = zze;
                if (zzhk == null) {
                    zzhk = zzhv.zza(zzhk.class);
                    zze = zzhk;
                }
            }
        }
        return zzhk;
    }

    public final <ContainingType extends zzjg> zzhx.zzc<ContainingType, ?> zza(ContainingType containingtype, int i) {
        return this.zzg.get(new zza(containingtype, i));
    }

    zzhk() {
        this.zzg = new HashMap();
    }

    private zzhk(boolean z) {
        this.zzg = Collections.emptyMap();
    }
}
