package com.google.android.gms.flags.impl;

import android.content.Context;
import android.content.SharedPreferences;
import com.google.android.gms.internal.flags.zze;

public final class zzj {
    private static SharedPreferences zzw;

    public static SharedPreferences zza(Context context) throws Exception {
        SharedPreferences sharedPreferences;
        synchronized (SharedPreferences.class) {
            if (zzw == null) {
                zzw = (SharedPreferences) zze.zza(new zzk(context));
            }
            sharedPreferences = zzw;
        }
        return sharedPreferences;
    }
}
