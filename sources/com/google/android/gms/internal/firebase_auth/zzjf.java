package com.google.android.gms.internal.firebase_auth;

/* compiled from: com.google.firebase:firebase-auth@@18.1.0 */
final class zzjf {
    private static final zzjd zza = zzc();
    private static final zzjd zzb = new zzjc();

    static zzjd zza() {
        return zza;
    }

    static zzjd zzb() {
        return zzb;
    }

    private static zzjd zzc() {
        try {
            return (zzjd) Class.forName("com.google.protobuf.MapFieldSchemaFull").getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
        } catch (Exception unused) {
            return null;
        }
    }
}
