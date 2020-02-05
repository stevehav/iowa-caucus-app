package com.google.android.gms.internal.measurement;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.0.1 */
final class zzeu {
    private static final zzes<?> zza = new zzer();
    private static final zzes<?> zzb = zzc();

    private static zzes<?> zzc() {
        try {
            return (zzes) Class.forName("com.google.protobuf.ExtensionSchemaFull").getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
        } catch (Exception unused) {
            return null;
        }
    }

    static zzes<?> zza() {
        return zza;
    }

    static zzes<?> zzb() {
        zzes<?> zzes = zzb;
        if (zzes != null) {
            return zzes;
        }
        throw new IllegalStateException("Protobuf runtime is not correctly loaded.");
    }
}
