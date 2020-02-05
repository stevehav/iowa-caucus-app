package com.google.android.gms.internal.clearcut;

final class zzaw {
    private static final Class<?> zzfb = zze("libcore.io.Memory");
    private static final boolean zzfc = (zze("org.robolectric.Robolectric") != null);

    private static <T> Class<T> zze(String str) {
        try {
            return Class.forName(str);
        } catch (Throwable unused) {
            return null;
        }
    }

    static boolean zzx() {
        return zzfb != null && !zzfc;
    }

    static Class<?> zzy() {
        return zzfb;
    }
}
