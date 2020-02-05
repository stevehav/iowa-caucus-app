package com.google.android.gms.internal.firebase_auth;

/* compiled from: com.google.firebase:firebase-auth@@18.1.0 */
final class zzjr {
    private static final zzjp zza = zzc();
    private static final zzjp zzb = new zzjo();

    static zzjp zza() {
        return zza;
    }

    static zzjp zzb() {
        return zzb;
    }

    private static zzjp zzc() {
        try {
            return (zzjp) Class.forName("com.google.protobuf.NewInstanceSchemaFull").getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
        } catch (Exception unused) {
            return null;
        }
    }
}
