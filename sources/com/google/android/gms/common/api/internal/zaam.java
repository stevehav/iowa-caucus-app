package com.google.android.gms.common.api.internal;

import android.os.Looper;
import androidx.annotation.NonNull;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.internal.BaseGmsClient;
import com.google.android.gms.common.internal.Preconditions;
import java.lang.ref.WeakReference;

final class zaam implements BaseGmsClient.ConnectionProgressReportCallbacks {
    private final Api<?> mApi;
    /* access modifiers changed from: private */
    public final boolean zaec;
    private final WeakReference<zaak> zagk;

    public zaam(zaak zaak, Api<?> api, boolean z) {
        this.zagk = new WeakReference<>(zaak);
        this.mApi = api;
        this.zaec = z;
    }

    public final void onReportServiceBinding(@NonNull ConnectionResult connectionResult) {
        zaak zaak = (zaak) this.zagk.get();
        if (zaak != null) {
            Preconditions.checkState(Looper.myLooper() == zaak.zaft.zaee.getLooper(), "onReportServiceBinding must be called on the GoogleApiClient handler thread");
            zaak.zaeo.lock();
            try {
                if (zaak.zac(0)) {
                    if (!connectionResult.isSuccess()) {
                        zaak.zab(connectionResult, this.mApi, this.zaec);
                    }
                    if (zaak.zaao()) {
                        zaak.zaap();
                    }
                    zaak.zaeo.unlock();
                }
            } finally {
                zaak.zaeo.unlock();
            }
        }
    }
}
