package com.google.android.gms.vision;

import android.content.Context;
import android.util.Pair;
import androidx.annotation.Keep;
import java.io.File;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

@Keep
public class EngineManager {
    private static final ConcurrentMap<Pair<String, String>, EngineManager> zzai = new ConcurrentHashMap();
    private final String zzaj;

    public static EngineManager zza(String str, String str2) {
        Pair create = Pair.create(str, str2);
        if (zzai.get(create) != null) {
            return (EngineManager) zzai.get(create);
        }
        zzai.putIfAbsent(create, new EngineManager(str, str2));
        return (EngineManager) zzai.get(create);
    }

    private EngineManager(String str, String str2) {
        str2 = str2.startsWith("lib") ? str2.substring(3) : str2;
        this.zzaj = str2.endsWith(".so") ? str2.substring(0, str2.length() - 3) : str2;
    }

    public final synchronized boolean zza(Context context) {
        System.loadLibrary(this.zzaj);
        return true;
    }

    public final synchronized void zzb(Context context) {
        throw new UnsupportedOperationException("SDK might not contain correct files, please re-download.");
    }

    public static File zzc(Context context) {
        return new File("assets/");
    }
}
