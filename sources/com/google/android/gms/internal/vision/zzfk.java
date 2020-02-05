package com.google.android.gms.internal.vision;

import com.google.android.gms.internal.vision.zzfy;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class zzfk {
    private static volatile boolean zztf = false;
    private static final Class<?> zztg = zzei();
    private static volatile zzfk zzth;
    static final zzfk zzti = new zzfk(true);
    private final Map<zza, zzfy.zzf<?, ?>> zztj;

    private static Class<?> zzei() {
        try {
            return Class.forName("com.google.protobuf.Extension");
        } catch (ClassNotFoundException unused) {
            return null;
        }
    }

    static final class zza {
        private final int number;
        private final Object object;

        zza(Object obj, int i) {
            this.object = obj;
            this.number = i;
        }

        public final int hashCode() {
            return (System.identityHashCode(this.object) * 65535) + this.number;
        }

        public final boolean equals(Object obj) {
            if (!(obj instanceof zza)) {
                return false;
            }
            zza zza = (zza) obj;
            if (this.object == zza.object && this.number == zza.number) {
                return true;
            }
            return false;
        }
    }

    public static zzfk zzej() {
        return zzfj.zzef();
    }

    public static zzfk zzek() {
        return zzfj.zzeg();
    }

    public static zzfk zzel() {
        zzfk zzfk = zzth;
        if (zzfk == null) {
            synchronized (zzfk.class) {
                zzfk = zzth;
                if (zzfk == null) {
                    zzfk = zzfj.zzeh();
                    zzth = zzfk;
                }
            }
        }
        return zzfk;
    }

    static zzfk zzeh() {
        return zzfw.zza(zzfk.class);
    }

    public final <ContainingType extends zzhf> zzfy.zzf<ContainingType, ?> zza(ContainingType containingtype, int i) {
        return this.zztj.get(new zza(containingtype, i));
    }

    public final void zza(zzfy.zzf<?, ?> zzf) {
        this.zztj.put(new zza(zzf.zzwu, zzf.zzww.number), zzf);
    }

    zzfk() {
        this.zztj = new HashMap();
    }

    private zzfk(boolean z) {
        this.zztj = Collections.emptyMap();
    }
}
