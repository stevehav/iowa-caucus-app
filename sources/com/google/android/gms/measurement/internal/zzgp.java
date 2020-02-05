package com.google.android.gms.measurement.internal;

import com.google.android.gms.measurement.AppMeasurement;

/* compiled from: com.google.android.gms:play-services-measurement-base@@17.0.1 */
public class zzgp {
    public static final String[] zza = {"firebase_last_notification", "first_open_time", "first_visit_time", "last_deep_link_referrer", "user_id", "first_open_after_install", "lifetime_user_engagement", "session_user_engagement", "non_personalized_ads", "session_number", "ga_session_number", "session_id", "ga_session_id", "last_gclid"};
    public static final String[] zzb = {AppMeasurement.UserProperty.FIREBASE_LAST_NOTIFICATION, "_fot", "_fvt", "_ldl", "_id", "_fi", "_lte", "_se", "_npa", "_sno", "_sno", "_sid", "_sid", "_lgclid"};

    protected zzgp() {
    }

    public static String zza(String str) {
        return zzhv.zza(str, zza, zzb);
    }
}
