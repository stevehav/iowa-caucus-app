package com.google.firebase.firestore.util;

import android.util.Log;
import com.google.firebase.firestore.BuildConfig;

/* compiled from: com.google.firebase:firebase-firestore@@20.2.0 */
public class Logger {
    private static Level logLevel = Level.WARN;

    /* compiled from: com.google.firebase:firebase-firestore@@20.2.0 */
    public enum Level {
        DEBUG,
        WARN,
        NONE
    }

    public static void setLogLevel(Level level) {
        logLevel = level;
    }

    public static boolean isDebugEnabled() {
        return logLevel.ordinal() >= Level.DEBUG.ordinal();
    }

    private static void doLog(Level level, String str, String str2, Object... objArr) {
        if (level.ordinal() >= logLevel.ordinal()) {
            String str3 = String.format("(%s) [%s]: ", new Object[]{BuildConfig.VERSION_NAME, str}) + String.format(str2, objArr);
            int i = AnonymousClass1.$SwitchMap$com$google$firebase$firestore$util$Logger$Level[level.ordinal()];
            if (i == 1) {
                Log.i("Firestore", str3);
            } else if (i == 2) {
                Log.w("Firestore", str3);
            } else if (i == 3) {
                throw new IllegalStateException("Trying to log something on level NONE");
            }
        }
    }

    /* renamed from: com.google.firebase.firestore.util.Logger$1  reason: invalid class name */
    /* compiled from: com.google.firebase:firebase-firestore@@20.2.0 */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$google$firebase$firestore$util$Logger$Level = new int[Level.values().length];

        /* JADX WARNING: Can't wrap try/catch for region: R(8:0|1|2|3|4|5|6|8) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0014 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001f */
        static {
            /*
                com.google.firebase.firestore.util.Logger$Level[] r0 = com.google.firebase.firestore.util.Logger.Level.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$com$google$firebase$firestore$util$Logger$Level = r0
                int[] r0 = $SwitchMap$com$google$firebase$firestore$util$Logger$Level     // Catch:{ NoSuchFieldError -> 0x0014 }
                com.google.firebase.firestore.util.Logger$Level r1 = com.google.firebase.firestore.util.Logger.Level.DEBUG     // Catch:{ NoSuchFieldError -> 0x0014 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0014 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0014 }
            L_0x0014:
                int[] r0 = $SwitchMap$com$google$firebase$firestore$util$Logger$Level     // Catch:{ NoSuchFieldError -> 0x001f }
                com.google.firebase.firestore.util.Logger$Level r1 = com.google.firebase.firestore.util.Logger.Level.WARN     // Catch:{ NoSuchFieldError -> 0x001f }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001f }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001f }
            L_0x001f:
                int[] r0 = $SwitchMap$com$google$firebase$firestore$util$Logger$Level     // Catch:{ NoSuchFieldError -> 0x002a }
                com.google.firebase.firestore.util.Logger$Level r1 = com.google.firebase.firestore.util.Logger.Level.NONE     // Catch:{ NoSuchFieldError -> 0x002a }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x002a }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x002a }
            L_0x002a:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.firestore.util.Logger.AnonymousClass1.<clinit>():void");
        }
    }

    public static void warn(String str, String str2, Object... objArr) {
        doLog(Level.WARN, str, str2, objArr);
    }

    public static void debug(String str, String str2, Object... objArr) {
        doLog(Level.DEBUG, str, str2, objArr);
    }
}
