package com.google.android.gms.phenotype;

import android.content.ContentResolver;
import android.database.ContentObserver;
import android.database.Cursor;
import android.net.Uri;
import android.os.Handler;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public final class zza {
    private static final ConcurrentHashMap<Uri, zza> zzg = new ConcurrentHashMap<>();
    private static final String[] zzl = {"key", "value"};
    private final Uri uri;
    private final ContentResolver zzh;
    private final ContentObserver zzi;
    private final Object zzj = new Object();
    private volatile Map<String, String> zzk;

    private zza(ContentResolver contentResolver, Uri uri2) {
        this.zzh = contentResolver;
        this.uri = uri2;
        this.zzi = new zzb(this, (Handler) null);
    }

    public static zza zza(ContentResolver contentResolver, Uri uri2) {
        zza zza = zzg.get(uri2);
        if (zza != null) {
            return zza;
        }
        zza zza2 = new zza(contentResolver, uri2);
        zza putIfAbsent = zzg.putIfAbsent(uri2, zza2);
        if (putIfAbsent != null) {
            return putIfAbsent;
        }
        zza2.zzh.registerContentObserver(zza2.uri, false, zza2.zzi);
        return zza2;
    }

    private final Map<String, String> zzc() {
        HashMap hashMap = new HashMap();
        Cursor query = this.zzh.query(this.uri, zzl, (String) null, (String[]) null, (String) null);
        if (query != null) {
            while (query.moveToNext()) {
                try {
                    hashMap.put(query.getString(0), query.getString(1));
                } finally {
                    query.close();
                }
            }
        }
        return hashMap;
    }

    public final Map<String, String> zza() {
        Map<String, String> zzc = PhenotypeFlag.zza("gms:phenotype:phenotype_flag:debug_disable_caching", false) ? zzc() : this.zzk;
        if (zzc == null) {
            synchronized (this.zzj) {
                Map<String, String> map = this.zzk;
                if (map == null) {
                    map = zzc();
                    this.zzk = map;
                }
            }
        }
        return zzc;
    }

    public final void zzb() {
        synchronized (this.zzj) {
            this.zzk = null;
        }
    }
}
