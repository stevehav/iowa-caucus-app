package com.google.android.gms.measurement.internal;

import java.util.List;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-measurement@@17.0.1 */
final class zzjr implements zzep {
    private final /* synthetic */ String zza;
    private final /* synthetic */ zzjp zzb;

    zzjr(zzjp zzjp, String str) {
        this.zzb = zzjp;
        this.zza = str;
    }

    public final void zza(String str, int i, Throwable th, byte[] bArr, Map<String, List<String>> map) {
        this.zzb.zza(i, th, bArr, this.zza);
    }
}
