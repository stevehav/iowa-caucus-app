package com.google.android.gms.internal.measurement;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.0.1 */
final class zzgi {
    private static final zzgg zza = zzc();
    private static final zzgg zzb = new zzgj();

    static zzgg zza() {
        return zza;
    }

    static zzgg zzb() {
        return zzb;
    }

    private static zzgg zzc() {
        try {
            return (zzgg) Class.forName("com.google.protobuf.MapFieldSchemaFull").getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
        } catch (Exception unused) {
            return null;
        }
    }
}
