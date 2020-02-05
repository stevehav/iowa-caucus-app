package com.google.android.gms.measurement.internal;

import android.content.ServiceConnection;
import android.net.Uri;
import android.os.Bundle;
import com.google.android.gms.common.stats.ConnectionTracker;
import com.google.android.gms.internal.measurement.zzf;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.0.1 */
final class zzfa implements Runnable {
    private final /* synthetic */ zzf zza;
    private final /* synthetic */ ServiceConnection zzb;
    private final /* synthetic */ zzfb zzc;

    zzfa(zzfb zzfb, zzf zzf, ServiceConnection serviceConnection) {
        this.zzc = zzfb;
        this.zza = zzf;
        this.zzb = serviceConnection;
    }

    public final void run() {
        zzey zzey = this.zzc.zza;
        String zza2 = this.zzc.zzb;
        zzf zzf = this.zza;
        ServiceConnection serviceConnection = this.zzb;
        Bundle zza3 = zzey.zza(zza2, zzf);
        zzey.zza.zzq().zzd();
        if (zza3 != null) {
            long j = zza3.getLong("install_begin_timestamp_seconds", 0) * 1000;
            if (j == 0) {
                zzey.zza.zzr().zzf().zza("Service response is missing Install Referrer install timestamp");
            } else {
                String string = zza3.getString("install_referrer");
                if (string == null || string.isEmpty()) {
                    zzey.zza.zzr().zzf().zza("No referrer defined in install referrer response");
                } else {
                    zzey.zza.zzr().zzx().zza("InstallReferrer API result", string);
                    zzjx zzi = zzey.zza.zzi();
                    String valueOf = String.valueOf(string);
                    Bundle zza4 = zzi.zza(Uri.parse(valueOf.length() != 0 ? "?".concat(valueOf) : new String("?")));
                    if (zza4 == null) {
                        zzey.zza.zzr().zzf().zza("No campaign params defined in install referrer result");
                    } else {
                        String string2 = zza4.getString("medium");
                        if (string2 != null && !"(not set)".equalsIgnoreCase(string2) && !"organic".equalsIgnoreCase(string2)) {
                            long j2 = zza3.getLong("referrer_click_timestamp_seconds", 0) * 1000;
                            if (j2 == 0) {
                                zzey.zza.zzr().zzf().zza("Install Referrer is missing click timestamp for ad campaign");
                            } else {
                                zza4.putLong("click_timestamp", j2);
                            }
                        }
                        if (j == zzey.zza.zzc().zzi.zza()) {
                            zzey.zza.zzu();
                            zzey.zza.zzr().zzx().zza("Campaign has already been logged");
                        } else {
                            zzey.zza.zzc().zzi.zza(j);
                            zzey.zza.zzu();
                            zzey.zza.zzr().zzx().zza("Logging Install Referrer campaign from sdk with ", "referrer API");
                            zza4.putString("_cis", "referrer API");
                            zzey.zza.zzh().zza("auto", "_cmp", zza4);
                        }
                    }
                }
            }
        }
        if (serviceConnection != null) {
            ConnectionTracker.getInstance().unbindService(zzey.zza.zzn(), serviceConnection);
        }
    }
}
