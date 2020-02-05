package com.google.android.gms.internal.vision;

final class zzhc {
    private static final zzha zzyz = zzgd();
    private static final zzha zzza = new zzhb();

    static zzha zzgb() {
        return zzyz;
    }

    static zzha zzgc() {
        return zzza;
    }

    private static zzha zzgd() {
        try {
            return (zzha) Class.forName("com.google.protobuf.MapFieldSchemaFull").getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
        } catch (Exception unused) {
            return null;
        }
    }
}
