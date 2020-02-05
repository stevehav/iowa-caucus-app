package com.google.android.gms.vision;

import android.util.Log;
import androidx.annotation.Keep;

@Keep
public class L {
    public static boolean isLoggable(int i) {
        return 4 <= i;
    }

    public static int zza(String str, Object... objArr) {
        if (isLoggable(2)) {
            return Log.v("Vision", String.format(str, objArr));
        }
        return 0;
    }

    public static int zzb(String str, Object... objArr) {
        if (isLoggable(3)) {
            return Log.d("Vision", String.format(str, objArr));
        }
        return 0;
    }

    public static int zzc(String str, Object... objArr) {
        if (isLoggable(6)) {
            return Log.e("Vision", String.format(str, objArr));
        }
        return 0;
    }

    public static int zza(Throwable th, String str, Object... objArr) {
        if (!isLoggable(6)) {
            return 0;
        }
        if (isLoggable(3)) {
            return Log.e("Vision", String.format(str, objArr), th);
        }
        String format = String.format(str, objArr);
        String valueOf = String.valueOf(th);
        StringBuilder sb = new StringBuilder(String.valueOf(format).length() + 2 + String.valueOf(valueOf).length());
        sb.append(format);
        sb.append(": ");
        sb.append(valueOf);
        return Log.e("Vision", sb.toString());
    }
}
