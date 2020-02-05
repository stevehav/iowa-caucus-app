package com.google.android.gms.internal.measurement;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.0.1 */
public final class zzmd implements zzma {
    private static final zzcl<Boolean> zza;
    private static final zzcl<Boolean> zzb;
    private static final zzcl<Boolean> zzc;
    private static final zzcl<Boolean> zzd;
    private static final zzcl<Long> zze;
    private static final zzcl<Long> zzf;

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

    static {
        zzcr zzcr = new zzcr(zzcm.zza("com.google.android.gms.measurement"));
        zza = zzcr.zza("measurement.client.sessions.background_sessions_enabled", true);
        zzb = zzcr.zza("measurement.client.sessions.immediate_start_enabled_foreground", true);
        zzc = zzcr.zza("measurement.client.sessions.remove_expired_session_properties_enabled", true);
        zzd = zzcr.zza("measurement.client.sessions.session_id_enabled", true);
        zze = zzcr.zza("measurement.id.sessionization_client", 0);
        zzf = zzcr.zza("measurement.id.sessions.immediate_session_start", 0);
    }
}
