package com.google.android.gms.measurement;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import androidx.annotation.MainThread;
import com.google.android.gms.measurement.internal.zzfd;
import com.google.android.gms.measurement.internal.zzfe;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.0.1 */
public final class AppMeasurementInstallReferrerReceiver extends BroadcastReceiver implements zzfe {
    private zzfd zza;

    public final void doStartService(Context context, Intent intent) {
    }

    @MainThread
    public final void onReceive(Context context, Intent intent) {
        if (this.zza == null) {
            this.zza = new zzfd(this);
        }
        this.zza.zza(context, intent);
    }

    public final BroadcastReceiver.PendingResult doGoAsync() {
        return goAsync();
    }
}
