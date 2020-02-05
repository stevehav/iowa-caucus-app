package com.google.firebase.auth.api.internal;

import androidx.annotation.Nullable;

/* compiled from: com.google.firebase:firebase-auth@@18.1.0 */
public final class zzfi {
    @Nullable
    public static String zza(String str) {
        try {
            Object invoke = Class.forName("android.os.SystemProperties").getDeclaredMethod("get", new Class[]{String.class}).invoke((Object) null, new Object[]{str});
            if (invoke != null && String.class.isAssignableFrom(invoke.getClass())) {
                return (String) invoke;
            }
        } catch (Exception unused) {
        }
        return null;
    }
}
