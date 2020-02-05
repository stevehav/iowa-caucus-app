package com.google.android.gms.internal.measurement;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.0.1 */
public final class zzlm implements zzln {
    private static final zzcl<Boolean> zza;
    private static final zzcl<Long> zzb;

    public final boolean zza() {
        return zza.zzc().booleanValue();
    }

    static {
        zzcr zzcr = new zzcr(zzcm.zza("com.google.android.gms.measurement"));
        zza = zzcr.zza("measurement.reset_analytics.persist_time", false);
        zzb = zzcr.zza("measurement.id.reset_analytics.persist_time", 0);
    }
}
