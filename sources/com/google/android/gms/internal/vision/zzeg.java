package com.google.android.gms.internal.vision;

final class zzeg {
    private static final Class<?> zzrm = zzk("libcore.io.Memory");
    private static final boolean zzrn = (zzk("org.robolectric.Robolectric") != null);

    static boolean zzck() {
        return zzrm != null && !zzrn;
    }

    static Class<?> zzcl() {
        return zzrm;
    }

    private static <T> Class<T> zzk(String str) {
        try {
            return Class.forName(str);
        } catch (Throwable unused) {
            return null;
        }
    }
}
