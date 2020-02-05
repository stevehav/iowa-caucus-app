package com.google.android.gms.internal.firebase_auth;

/* compiled from: com.google.firebase:firebase-auth@@18.1.0 */
final class zziz implements zzjh {
    private zzjh[] zza;

    zziz(zzjh... zzjhArr) {
        this.zza = zzjhArr;
    }

    public final boolean zza(Class<?> cls) {
        for (zzjh zza2 : this.zza) {
            if (zza2.zza(cls)) {
                return true;
            }
        }
        return false;
    }

    public final zzje zzb(Class<?> cls) {
        for (zzjh zzjh : this.zza) {
            if (zzjh.zza(cls)) {
                return zzjh.zzb(cls);
            }
        }
        String valueOf = String.valueOf(cls.getName());
        throw new UnsupportedOperationException(valueOf.length() != 0 ? "No factory is available for message type: ".concat(valueOf) : new String("No factory is available for message type: "));
    }
}
