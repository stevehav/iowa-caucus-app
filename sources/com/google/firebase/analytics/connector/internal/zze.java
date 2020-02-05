package com.google.firebase.analytics.connector.internal;

import com.google.android.gms.measurement.AppMeasurement;
import com.google.firebase.analytics.connector.AnalyticsConnector;
import java.util.Set;

/* compiled from: com.google.android.gms:play-services-measurement-api@@17.0.1 */
public final class zze implements zza {
    /* access modifiers changed from: private */
    public AnalyticsConnector.AnalyticsConnectorListener zza;
    private AppMeasurement zzb;
    private zzg zzc = new zzg(this);

    public zze(AppMeasurement appMeasurement, AnalyticsConnector.AnalyticsConnectorListener analyticsConnectorListener) {
        this.zza = analyticsConnectorListener;
        this.zzb = appMeasurement;
        this.zzb.registerOnMeasurementEventListener(this.zzc);
    }

    public final void zza(Set<String> set) {
    }

    public final void zzb() {
    }

    public final AnalyticsConnector.AnalyticsConnectorListener zza() {
        return this.zza;
    }
}
