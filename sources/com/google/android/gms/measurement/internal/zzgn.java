package com.google.android.gms.measurement.internal;

/* compiled from: com.google.android.gms:play-services-measurement-base@@17.0.1 */
public class zzgn {
    public static final String[] zza = {"app_background", "app_clear_data", "app_exception", "app_remove", "app_upgrade", "app_install", "app_update", "firebase_campaign", "ga_campaign", "error", "first_open", "first_visit", "in_app_purchase", "notification_dismiss", "notification_foreground", "notification_open", "notification_receive", "os_update", "session_start", "user_engagement", "ad_exposure", "adunit_exposure", "ad_query", "ad_activeview", "ad_impression", "ad_click", "ad_reward", "screen_view", "ga_extra_parameter"};
    public static final String[] zzb = {"_ab", "_cd", "_ae", "_ui", "_ug", "_in", "_au", "_cmp", "_cmp", "_err", "_f", "_v", "_iap", "_nd", "_nf", "_no", "_nr", "_ou", "_s", "_e", "_xa", "_xu", "_aq", "_aa", "_ai", "_ac", "_ar", "_vs", "_ep"};

    protected zzgn() {
    }

    public static String zza(String str) {
        return zzhv.zza(str, zzb, zza);
    }

    public static String zzb(String str) {
        return zzhv.zza(str, zza, zzb);
    }
}
