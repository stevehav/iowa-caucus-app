package com.google.android.gms.internal.measurement;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.0.1 */
public final class zzls implements zzlt {
    private static final zzcl<Boolean> zza;
    private static final zzcl<Boolean> zzb;
    private static final zzcl<Boolean> zzc;
    private static final zzcl<Boolean> zzd;
    private static final zzcl<Long> zze;
    private static final zzcl<Boolean> zzf;
    private static final zzcl<Boolean> zzg;

    public final boolean zza() {
        return zza.zzc().booleanValue();
    }

    public final boolean zzb() {
        return zzb.zzc().booleanValue();
    }

    public final boolean zzc() {
        return zzc.zzc().booleanValue();
    }

    public final boolean zzd() {
        return zzd.zzc().booleanValue();
    }

    public final boolean zze() {
        return zzf.zzc().booleanValue();
    }

    public final boolean zzf() {
        return zzg.zzc().booleanValue();
    }

    static {
        zzcr zzcr = new zzcr(zzcm.zza("com.google.android.gms.measurement"));
        zza = zzcr.zza("measurement.service.audience.scoped_filters_v27", false);
        zzb = zzcr.zza("measurement.service.audience.session_scoped_user_engagement", false);
        zzc = zzcr.zza("measurement.service.audience.session_scoped_event_aggregates", false);
        zzd = zzcr.zza("measurement.service.audience.use_bundle_timestamp_for_property_filters", false);
        zze = zzcr.zza("measurement.id.scoped_audience_filters", 0);
        zzf = zzcr.zza("measurement.service.audience.not_prepend_timestamps_for_sequence_session_scoped_filters", false);
        zzg = zzcr.zza("measurement.service.audience.remove_disabled_session_scoped_user_engagement", false);
    }
}
