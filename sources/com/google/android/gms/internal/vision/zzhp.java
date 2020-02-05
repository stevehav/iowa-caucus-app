package com.google.android.gms.internal.vision;

final class zzhp {
    private static final zzhn zzzu = zzgk();
    private static final zzhn zzzv = new zzho();

    static zzhn zzgi() {
        return zzzu;
    }

    static zzhn zzgj() {
        return zzzv;
    }

    private static zzhn zzgk() {
        try {
            return (zzhn) Class.forName("com.google.protobuf.NewInstanceSchemaFull").getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
        } catch (Exception unused) {
            return null;
        }
    }
}
