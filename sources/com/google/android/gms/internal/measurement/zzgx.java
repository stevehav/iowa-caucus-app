package com.google.android.gms.internal.measurement;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.0.1 */
final class zzgx {
    private static final zzgv zza = zzc();
    private static final zzgv zzb = new zzgu();

    static zzgv zza() {
        return zza;
    }

    static zzgv zzb() {
        return zzb;
    }

    private static zzgv zzc() {
        try {
            return (zzgv) Class.forName("com.google.protobuf.NewInstanceSchemaFull").getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
        } catch (Exception unused) {
            return null;
        }
    }
}
