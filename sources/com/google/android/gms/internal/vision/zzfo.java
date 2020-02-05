package com.google.android.gms.internal.vision;

final class zzfo {
    private static final zzfl<?> zztk = new zzfm();
    private static final zzfl<?> zztl = zzem();

    private static zzfl<?> zzem() {
        try {
            return (zzfl) Class.forName("com.google.protobuf.ExtensionSchemaFull").getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
        } catch (Exception unused) {
            return null;
        }
    }

    static zzfl<?> zzen() {
        return zztk;
    }

    static zzfl<?> zzeo() {
        zzfl<?> zzfl = zztl;
        if (zzfl != null) {
            return zzfl;
        }
        throw new IllegalStateException("Protobuf runtime is not correctly loaded.");
    }
}
