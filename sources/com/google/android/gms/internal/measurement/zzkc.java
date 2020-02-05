package com.google.android.gms.internal.measurement;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.0.1 */
public final class zzkc implements zzkd {
    private static final zzcl<Boolean> zza;
    private static final zzcl<Boolean> zzb;

    public final boolean zza() {
        return zza.zzc().booleanValue();
    }

    public final boolean zzb() {
        return zzb.zzc().booleanValue();
    }

    static {
        zzcr zzcr = new zzcr(zzcm.zza("com.google.android.gms.measurement"));
        zza = zzcr.zza("measurement.collection.efficient_engagement_reporting_enabled", false);
        zzb = zzcr.zza("measurement.collection.redundant_engagement_removal_enabled", false);
    }
}
