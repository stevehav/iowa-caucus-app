package com.google.android.gms.measurement.internal;

import android.content.Context;
import androidx.annotation.Nullable;
import com.facebook.common.util.UriUtil;
import com.google.android.gms.common.GoogleApiAvailabilityLight;
import com.google.android.gms.common.GooglePlayServicesUtilLight;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.internal.measurement.zzbx;
import com.google.android.gms.internal.measurement.zzcm;
import com.google.android.gms.internal.measurement.zzjh;
import com.google.android.gms.internal.measurement.zzkg;
import com.google.logging.type.LogSeverity;
import io.sentry.DefaultSentryClientFactory;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

@VisibleForTesting
/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.0.1 */
public final class zzak {
    static zzr zza;
    public static zzdy<Long> zzaa;
    public static zzdy<Long> zzab = zza("measurement.upload.stale_data_deletion_interval", 86400000L, 86400000L, zzbe.zza);
    public static zzdy<Long> zzac = zza("measurement.upload.refresh_blacklisted_config_interval", 604800000L, 604800000L, zzbh.zza);
    public static zzdy<Long> zzad = zza("measurement.upload.initial_upload_delay_time", 15000L, 15000L, zzbg.zza);
    public static zzdy<Long> zzae = zza("measurement.upload.retry_time", 1800000L, 1800000L, zzbj.zza);
    public static zzdy<Integer> zzaf = zza("measurement.upload.retry_count", 6, 6, zzbl.zza);
    public static zzdy<Long> zzag = zza("measurement.upload.max_queue_time", 2419200000L, 2419200000L, zzbk.zza);
    public static zzdy<Integer> zzah = zza("measurement.lifetimevalue.max_currency_tracked", 4, 4, zzbn.zza);
    public static zzdy<Integer> zzai;
    public static zzdy<Long> zzaj = zza("measurement.service_client.idle_disconnect_millis", 5000L, 5000L, zzbp.zza);
    public static zzdy<Boolean> zzak = zza("measurement.test.boolean_flag", false, false, zzbo.zza);
    public static zzdy<String> zzal = zza("measurement.test.string_flag", "---", "---", zzbr.zza);
    public static zzdy<Long> zzam = zza("measurement.test.long_flag", -1L, -1L, zzbq.zza);
    public static zzdy<Integer> zzan = zza("measurement.test.int_flag", -2, -2, zzbt.zza);
    public static zzdy<Double> zzao;
    public static zzdy<Integer> zzap = zza("measurement.experiment.max_ids", 50, 50, zzbu.zza);
    public static zzdy<Boolean> zzaq = zza("measurement.validation.internal_limits_internal_event_params", false, false, zzbx.zza);
    public static zzdy<Boolean> zzar = zza("measurement.audience.dynamic_filters", true, true, zzbw.zza);
    public static zzdy<Boolean> zzas = zza("measurement.reset_analytics.persist_time", false, false, zzbz.zza);
    public static zzdy<Boolean> zzat = zza("measurement.validation.value_and_currency_params", true, true, zzby.zza);
    public static zzdy<Boolean> zzau = zza("measurement.sampling.time_zone_offset_enabled", false, false, zzcb.zza);
    public static zzdy<Boolean> zzav = zza("measurement.referrer.enable_logging_install_referrer_cmp_from_apk", false, false, zzca.zza);
    public static zzdy<Boolean> zzaw = zza("measurement.client.sessions.session_id_enabled", false, false, zzcd.zza);
    public static zzdy<Boolean> zzax = zza("measurement.service.sessions.session_number_enabled", true, true, zzcc.zza);
    public static zzdy<Boolean> zzay = zza("measurement.client.sessions.immediate_start_enabled_foreground", false, false, zzcf.zza);
    public static zzdy<Boolean> zzaz = zza("measurement.client.sessions.background_sessions_enabled", false, false, zzch.zza);
    public static zzdy<Boolean> zzb = zza("measurement.log_androidId_enabled", false, false, zzan.zza);
    public static zzdy<Boolean> zzba = zza("measurement.client.sessions.remove_expired_session_properties_enabled", false, false, zzcg.zza);
    public static zzdy<Boolean> zzbb = zza("measurement.service.sessions.session_number_backfill_enabled", true, true, zzcj.zza);
    public static zzdy<Boolean> zzbc = zza("measurement.service.sessions.remove_disabled_session_number", true, true, zzci.zza);
    public static zzdy<Boolean> zzbd = zza("measurement.collection.firebase_global_collection_flag_enabled", true, true, zzcl.zza);
    public static zzdy<Boolean> zzbe = zza("measurement.collection.efficient_engagement_reporting_enabled", false, false, zzck.zza);
    public static zzdy<Boolean> zzbf = zza("measurement.collection.redundant_engagement_removal_enabled", false, false, zzcn.zza);
    public static zzdy<Boolean> zzbg = zza("measurement.personalized_ads_signals_collection_enabled", true, true, zzcm.zza);
    public static zzdy<Boolean> zzbh = zza("measurement.personalized_ads_property_translation_enabled", true, true, zzcp.zza);
    public static zzdy<Boolean> zzbi = zza("measurement.collection.init_params_control_enabled", true, true, zzco.zza);
    public static zzdy<Boolean> zzbj = zza("measurement.upload.disable_is_uploader", true, true, zzcq.zza);
    public static zzdy<Boolean> zzbk = zza("measurement.experiment.enable_experiment_reporting", true, true, zzct.zza);
    public static zzdy<Boolean> zzbl = zza("measurement.collection.log_event_and_bundle_v2", true, true, zzcs.zza);
    public static zzdy<Boolean> zzbm = zza("measurement.collection.null_empty_event_name_fix", true, true, zzcv.zza);
    public static zzdy<Boolean> zzbn = zza("measurement.audience.sequence_filters", true, true, zzcu.zza);
    public static zzdy<Boolean> zzbo = zza("measurement.quality.checksum", false, false, (zzdz) null);
    public static zzdy<Boolean> zzbp = zza("measurement.module.collection.conditionally_omit_admob_app_id", true, true, zzcx.zza);
    public static zzdy<Boolean> zzbq = zza("measurement.sdk.dynamite.use_dynamite2", false, false, zzcw.zza);
    public static zzdy<Boolean> zzbr = zza("measurement.sdk.dynamite.allow_remote_dynamite", false, false, zzcz.zza);
    public static zzdy<Boolean> zzbs = zza("measurement.sdk.collection.validate_param_names_alphabetical", false, false, zzcy.zza);
    public static zzdy<Boolean> zzbt = zza("measurement.collection.event_safelist", false, false, zzdb.zza);
    public static zzdy<Boolean> zzbu = zza("measurement.service.audience.scoped_filters_v27", false, false, zzdd.zza);
    public static zzdy<Boolean> zzbv = zza("measurement.service.audience.session_scoped_event_aggregates", false, false, zzdc.zza);
    public static zzdy<Boolean> zzbw = zza("measurement.service.audience.session_scoped_user_engagement", false, false, zzdf.zza);
    public static zzdy<Boolean> zzbx = zza("measurement.service.audience.remove_disabled_session_scoped_user_engagement", false, false, zzde.zza);
    public static zzdy<Boolean> zzby = zza("measurement.service.audience.use_bundle_timestamp_for_property_filters", false, false, zzdh.zza);
    public static zzdy<Boolean> zzbz = zza("measurement.service.audience.not_prepend_timestamps_for_sequence_session_scoped_filters", false, false, zzdg.zza);
    public static zzdy<Boolean> zzc = zza("measurement.upload_dsid_enabled", false, false, zzam.zza);
    public static zzdy<Boolean> zzca = zza("measurement.sdk.collection.retrieve_deeplink_from_bow", false, false, zzdj.zza);
    public static zzdy<Boolean> zzcb = zza("measurement.app_launch.event_ordering_fix", false, false, zzdi.zza);
    public static zzdy<Boolean> zzcc = zza("measurement.sdk.collection.last_deep_link_referrer", false, false, zzdl.zza);
    public static zzdy<Boolean> zzcd = zza("measurement.sdk.collection.last_gclid_from_referrer", false, false, zzdm.zza);
    public static zzdy<Boolean> zzce = zza("measurement.upload.file_lock_state_check", false, false, zzdp.zza);
    public static zzdy<Boolean> zzcf = zza("measurement.sampling.calculate_bundle_timestamp_before_sampling", true, true, zzdo.zza);
    public static zzdy<Boolean> zzcg = zza("measurement.lifecycle.app_backgrounded_tracking", false, false, zzdq.zza);
    public static zzdy<Boolean> zzch = zza("measurement.lifecycle.app_in_background_parameter", false, false, zzdt.zza);
    public static zzdy<Boolean> zzci = zza("measurement.integration.disable_firebase_instance_id", false, false, zzds.zza);
    public static zzdy<Boolean> zzcj = zza("measurement.lifecycle.app_backgrounded_engagement", false, false, zzdv.zza);
    public static zzdy<Boolean> zzck = zza("measurement.service.fix_gmp_version", false, false, zzdu.zza);
    /* access modifiers changed from: private */
    public static List<zzdy<?>> zzcl = Collections.synchronizedList(new ArrayList());
    private static Set<zzdy<?>> zzcm = Collections.synchronizedSet(new HashSet());
    private static volatile zzfn zzcn;
    @VisibleForTesting
    private static Boolean zzco;
    private static zzdy<Boolean> zzcp = zza("measurement.sdk.collection.last_deep_link_referrer_campaign", false, false, zzdk.zza);
    private static zzdy<Boolean> zzcq = zza("measurement.ga.ga_app_id", false, Boolean.valueOf(zzkg.zzb()), zzdr.zza);
    public static zzdy<String> zzd = zza("measurement.log_tag", "FA", "FA-SVC", zzaz.zza);
    public static zzdy<Long> zze = zza("measurement.ad_id_cache_time", 10000L, 10000L, zzbi.zza);
    public static zzdy<Long> zzf = zza("measurement.monitoring.sample_period_millis", 86400000L, 86400000L, zzbv.zza);
    public static zzdy<Long> zzg = zza("measurement.config.cache_time", 86400000L, 3600000L, zzce.zza);
    public static zzdy<String> zzh = zza("measurement.config.url_scheme", UriUtil.HTTPS_SCHEME, UriUtil.HTTPS_SCHEME, zzcr.zza);
    public static zzdy<String> zzi = zza("measurement.config.url_authority", "app-measurement.com", "app-measurement.com", zzda.zza);
    public static zzdy<Integer> zzj = zza("measurement.upload.max_bundles", 100, 100, zzdn.zza);
    public static zzdy<Integer> zzk = zza("measurement.upload.max_batch_size", 65536, 65536, zzdx.zza);
    public static zzdy<Integer> zzl = zza("measurement.upload.max_bundle_size", 65536, 65536, zzap.zza);
    public static zzdy<Integer> zzm = zza("measurement.upload.max_events_per_bundle", 1000, 1000, zzao.zza);
    public static zzdy<Integer> zzn = zza("measurement.upload.max_events_per_day", 100000, 100000, zzar.zza);
    public static zzdy<Integer> zzo = zza("measurement.upload.max_error_events_per_day", 1000, 1000, zzaq.zza);
    public static zzdy<Integer> zzp = zza("measurement.upload.max_public_events_per_day", 50000, 50000, zzat.zza);
    public static zzdy<Integer> zzq = zza("measurement.upload.max_conversions_per_day", 500, 500, zzas.zza);
    public static zzdy<Integer> zzr = zza("measurement.upload.max_realtime_events_per_day", 10, 10, zzav.zza);
    public static zzdy<Integer> zzs = zza("measurement.store.max_stored_events_per_app", 100000, 100000, zzau.zza);
    public static zzdy<String> zzt = zza("measurement.upload.url", "https://app-measurement.com/a", "https://app-measurement.com/a", zzax.zza);
    public static zzdy<Long> zzu = zza("measurement.upload.backoff_period", 43200000L, 43200000L, zzaw.zza);
    public static zzdy<Long> zzv = zza("measurement.upload.window_interval", 3600000L, 3600000L, zzay.zza);
    public static zzdy<Long> zzw = zza("measurement.upload.interval", 3600000L, 3600000L, zzbb.zza);
    public static zzdy<Long> zzx = zza("measurement.upload.realtime_upload_interval", 10000L, 10000L, zzba.zza);
    public static zzdy<Long> zzy = zza("measurement.upload.debug_upload_interval", 1000L, 1000L, zzbd.zza);
    public static zzdy<Long> zzz = zza("measurement.upload.minimum_delay", 500L, 500L, zzbc.zza);

    public static Map<String, String> zza(Context context) {
        zzbx zza2 = zzbx.zza(context.getContentResolver(), zzcm.zza("com.google.android.gms.measurement"));
        return zza2 == null ? Collections.emptyMap() : zza2.zza();
    }

    static void zza(zzfn zzfn) {
        zzcn = zzfn;
    }

    @VisibleForTesting
    static void zza(Exception exc) {
        if (zzcn != null) {
            Context zzn2 = zzcn.zzn();
            if (zzco == null) {
                zzco = Boolean.valueOf(GoogleApiAvailabilityLight.getInstance().isGooglePlayServicesAvailable(zzn2, GooglePlayServicesUtilLight.GOOGLE_PLAY_SERVICES_VERSION_CODE) == 0);
            }
            if (zzco.booleanValue()) {
                zzcn.zzr().zzf().zza("Got Exception on PhenotypeFlag.get on Play device", exc);
            }
        }
    }

    @VisibleForTesting
    private static <V> zzdy<V> zza(@Nullable String str, @Nullable V v, @Nullable V v2, @Nullable zzdz<V> zzdz) {
        zzdy zzdy = new zzdy(str, v, v2, zzdz);
        zzcl.add(zzdy);
        return zzdy;
    }

    static void zza(zzr zzr2) {
        zza = zzr2;
    }

    private static boolean zzcm() {
        if (zza != null) {
        }
        return false;
    }

    static final /* synthetic */ Long zzcf() {
        long j;
        if (zzcm()) {
            j = zzjh.zzq();
        } else {
            j = zzjh.zzc();
        }
        return Long.valueOf(j);
    }

    static final /* synthetic */ String zzci() {
        return zzcm() ? zzjh.zzs() : zzjh.zzd();
    }

    static {
        Long valueOf = Long.valueOf(DefaultSentryClientFactory.BUFFER_FLUSHTIME_DEFAULT);
        zzaa = zza("measurement.alarm_manager.minimum_interval", valueOf, valueOf, zzbf.zza);
        Integer valueOf2 = Integer.valueOf(LogSeverity.INFO_VALUE);
        zzai = zza("measurement.audience.filter_result_max_count", valueOf2, valueOf2, zzbm.zza);
        Double valueOf3 = Double.valueOf(-3.0d);
        zzao = zza("measurement.test.double_flag", valueOf3, valueOf3, zzbs.zza);
    }
}
