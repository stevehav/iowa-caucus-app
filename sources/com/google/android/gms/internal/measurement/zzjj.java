package com.google.android.gms.internal.measurement;

import android.support.v4.media.session.PlaybackStateCompat;
import com.facebook.common.util.UriUtil;
import io.sentry.DefaultSentryClientFactory;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.0.1 */
public final class zzjj implements zzjg {
    private static final zzcl<Long> zza;
    private static final zzcl<Long> zzaa;
    private static final zzcl<Long> zzab;
    private static final zzcl<Long> zzac;
    private static final zzcl<Long> zzad;
    private static final zzcl<Long> zzae;
    private static final zzcl<Long> zzaf;
    private static final zzcl<Long> zzag;
    private static final zzcl<Long> zzah;
    private static final zzcl<String> zzai;
    private static final zzcl<Long> zzaj;
    private static final zzcl<Long> zzb;
    private static final zzcl<String> zzc;
    private static final zzcl<String> zzd;
    private static final zzcl<String> zze;
    private static final zzcl<Long> zzf;
    private static final zzcl<Long> zzg;
    private static final zzcl<Long> zzh;
    private static final zzcl<Long> zzi;
    private static final zzcl<Long> zzj;
    private static final zzcl<Long> zzk;
    private static final zzcl<Long> zzl;
    private static final zzcl<Long> zzm;
    private static final zzcl<Long> zzn;
    private static final zzcl<Long> zzo;
    private static final zzcl<Long> zzp;
    private static final zzcl<Long> zzq;
    private static final zzcl<String> zzr;
    private static final zzcl<Long> zzs;
    private static final zzcl<Long> zzt;
    private static final zzcl<Long> zzu;
    private static final zzcl<Long> zzv;
    private static final zzcl<Long> zzw;
    private static final zzcl<Long> zzx;
    private static final zzcl<Long> zzy;
    private static final zzcl<Long> zzz;

    public final long zza() {
        return zza.zzc().longValue();
    }

    public final long zzb() {
        return zzb.zzc().longValue();
    }

    public final String zzc() {
        return zzc.zzc();
    }

    public final String zzd() {
        return zzd.zzc();
    }

    public final String zze() {
        return zze.zzc();
    }

    public final long zzf() {
        return zzf.zzc().longValue();
    }

    public final long zzg() {
        return zzg.zzc().longValue();
    }

    public final long zzh() {
        return zzh.zzc().longValue();
    }

    public final long zzi() {
        return zzi.zzc().longValue();
    }

    public final long zzj() {
        return zzj.zzc().longValue();
    }

    public final long zzk() {
        return zzk.zzc().longValue();
    }

    public final long zzl() {
        return zzl.zzc().longValue();
    }

    public final long zzm() {
        return zzm.zzc().longValue();
    }

    public final long zzn() {
        return zzn.zzc().longValue();
    }

    public final long zzo() {
        return zzo.zzc().longValue();
    }

    public final long zzp() {
        return zzp.zzc().longValue();
    }

    public final long zzq() {
        return zzq.zzc().longValue();
    }

    public final String zzr() {
        return zzr.zzc();
    }

    public final long zzs() {
        return zzs.zzc().longValue();
    }

    public final long zzt() {
        return zzt.zzc().longValue();
    }

    public final long zzu() {
        return zzu.zzc().longValue();
    }

    public final long zzv() {
        return zzv.zzc().longValue();
    }

    public final long zzw() {
        return zzw.zzc().longValue();
    }

    public final long zzx() {
        return zzx.zzc().longValue();
    }

    public final long zzy() {
        return zzy.zzc().longValue();
    }

    public final long zzz() {
        return zzz.zzc().longValue();
    }

    public final long zzaa() {
        return zzaa.zzc().longValue();
    }

    public final long zzab() {
        return zzab.zzc().longValue();
    }

    public final long zzac() {
        return zzac.zzc().longValue();
    }

    public final long zzad() {
        return zzad.zzc().longValue();
    }

    public final long zzae() {
        return zzae.zzc().longValue();
    }

    public final long zzaf() {
        return zzaf.zzc().longValue();
    }

    public final long zzag() {
        return zzag.zzc().longValue();
    }

    public final long zzah() {
        return zzah.zzc().longValue();
    }

    public final String zzai() {
        return zzai.zzc();
    }

    public final long zzaj() {
        return zzaj.zzc().longValue();
    }

    static {
        zzcr zzcr = new zzcr(zzcm.zza("com.google.android.gms.measurement"));
        zza = zzcr.zza("measurement.ad_id_cache_time", 10000);
        zzb = zzcr.zza("measurement.config.cache_time", 86400000);
        zzc = zzcr.zza("measurement.log_tag", "FA");
        zzd = zzcr.zza("measurement.config.url_authority", "app-measurement.com");
        zze = zzcr.zza("measurement.config.url_scheme", UriUtil.HTTPS_SCHEME);
        zzf = zzcr.zza("measurement.upload.debug_upload_interval", 1000);
        zzg = zzcr.zza("measurement.lifetimevalue.max_currency_tracked", 4);
        zzh = zzcr.zza("measurement.store.max_stored_events_per_app", 100000);
        zzi = zzcr.zza("measurement.experiment.max_ids", 50);
        zzj = zzcr.zza("measurement.audience.filter_result_max_count", 200);
        zzk = zzcr.zza("measurement.alarm_manager.minimum_interval", (long) DefaultSentryClientFactory.BUFFER_FLUSHTIME_DEFAULT);
        zzl = zzcr.zza("measurement.upload.minimum_delay", 500);
        zzm = zzcr.zza("measurement.monitoring.sample_period_millis", 86400000);
        zzn = zzcr.zza("measurement.upload.realtime_upload_interval", 10000);
        zzo = zzcr.zza("measurement.upload.refresh_blacklisted_config_interval", 604800000);
        zzp = zzcr.zza("measurement.config.cache_time.service", 3600000);
        zzq = zzcr.zza("measurement.service_client.idle_disconnect_millis", 5000);
        zzr = zzcr.zza("measurement.log_tag.service", "FA-SVC");
        zzs = zzcr.zza("measurement.upload.stale_data_deletion_interval", 86400000);
        zzt = zzcr.zza("measurement.upload.backoff_period", 43200000);
        zzu = zzcr.zza("measurement.upload.initial_upload_delay_time", 15000);
        zzv = zzcr.zza("measurement.upload.interval", 3600000);
        zzw = zzcr.zza("measurement.upload.max_bundle_size", (long) PlaybackStateCompat.ACTION_PREPARE_FROM_SEARCH);
        zzx = zzcr.zza("measurement.upload.max_bundles", 100);
        zzy = zzcr.zza("measurement.upload.max_conversions_per_day", 500);
        zzz = zzcr.zza("measurement.upload.max_error_events_per_day", 1000);
        zzaa = zzcr.zza("measurement.upload.max_events_per_bundle", 1000);
        zzab = zzcr.zza("measurement.upload.max_events_per_day", 100000);
        zzac = zzcr.zza("measurement.upload.max_public_events_per_day", 50000);
        zzad = zzcr.zza("measurement.upload.max_queue_time", 2419200000L);
        zzae = zzcr.zza("measurement.upload.max_realtime_events_per_day", 10);
        zzaf = zzcr.zza("measurement.upload.max_batch_size", (long) PlaybackStateCompat.ACTION_PREPARE_FROM_SEARCH);
        zzag = zzcr.zza("measurement.upload.retry_count", 6);
        zzah = zzcr.zza("measurement.upload.retry_time", 1800000);
        zzai = zzcr.zza("measurement.upload.url", "https://app-measurement.com/a");
        zzaj = zzcr.zza("measurement.upload.window_interval", 3600000);
    }
}
