package com.google.android.gms.common.internal;

import android.os.Bundle;
import androidx.annotation.Nullable;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.internal.BaseGmsClient;

final class zaf implements BaseGmsClient.BaseConnectionCallbacks {
    private final /* synthetic */ GoogleApiClient.ConnectionCallbacks zaoj;

    zaf(GoogleApiClient.ConnectionCallbacks connectionCallbacks) {
        this.zaoj = connectionCallbacks;
    }

    public final void onConnected(@Nullable Bundle bundle) {
        this.zaoj.onConnected(bundle);
    }

    public final void onConnectionSuspended(int i) {
        this.zaoj.onConnectionSuspended(i);
    }
}
