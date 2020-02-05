package com.google.android.gms.internal.measurement;

import android.content.Context;
import android.content.SharedPreferences;
import androidx.annotation.GuardedBy;
import androidx.collection.ArrayMap;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.0.1 */
public final class zzcu implements zzcb {
    @GuardedBy("SharedPreferencesLoader.class")
    private static final Map<String, zzcu> zza = new ArrayMap();
    private final SharedPreferences zzb;
    private final SharedPreferences.OnSharedPreferenceChangeListener zzc = new zzct(this);
    private final Object zzd = new Object();
    private volatile Map<String, ?> zze;
    @GuardedBy("this")
    private final List<zzcc> zzf = new ArrayList();

    static zzcu zza(Context context, String str) {
        zzcu zzcu;
        SharedPreferences sharedPreferences;
        if (!((!zzby.zza() || str.startsWith("direct_boot:")) ? true : zzby.zza(context))) {
            return null;
        }
        synchronized (zzcu.class) {
            zzcu = zza.get(str);
            if (zzcu == null) {
                if (str.startsWith("direct_boot:")) {
                    if (zzby.zza()) {
                        context = context.createDeviceProtectedStorageContext();
                    }
                    sharedPreferences = context.getSharedPreferences(str.substring(12), 0);
                } else {
                    sharedPreferences = context.getSharedPreferences(str, 0);
                }
                zzcu = new zzcu(sharedPreferences);
                zza.put(str, zzcu);
            }
        }
        return zzcu;
    }

    private zzcu(SharedPreferences sharedPreferences) {
        this.zzb = sharedPreferences;
        this.zzb.registerOnSharedPreferenceChangeListener(this.zzc);
    }

    public final Object zza(String str) {
        Map<String, ?> map = this.zze;
        if (map == null) {
            synchronized (this.zzd) {
                map = this.zze;
                if (map == null) {
                    map = this.zzb.getAll();
                    this.zze = map;
                }
            }
        }
        if (map != null) {
            return map.get(str);
        }
        return null;
    }

    static synchronized void zza() {
        synchronized (zzcu.class) {
            for (zzcu next : zza.values()) {
                next.zzb.unregisterOnSharedPreferenceChangeListener(next.zzc);
            }
            zza.clear();
        }
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zza(SharedPreferences sharedPreferences, String str) {
        synchronized (this.zzd) {
            this.zze = null;
            zzcl.zza();
        }
        synchronized (this) {
            for (zzcc zza2 : this.zzf) {
                zza2.zza();
            }
        }
    }
}
