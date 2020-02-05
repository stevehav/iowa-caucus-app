package com.google.android.gms.common.api.internal;

import android.os.Bundle;
import androidx.annotation.NonNull;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;

final class zaat implements GoogleApiClient.ConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener {
    private final /* synthetic */ zaak zagj;

    private zaat(zaak zaak) {
        this.zagj = zaak;
    }

    public final void onConnectionSuspended(int i) {
    }

    public final void onConnected(Bundle bundle) {
        if (this.zagj.zaet.isSignInClientDisconnectFixEnabled()) {
            this.zagj.zaeo.lock();
            try {
                if (this.zagj.zagb != null) {
                    this.zagj.zagb.zaa(new zaar(this.zagj));
                    this.zagj.zaeo.unlock();
                }
            } finally {
                this.zagj.zaeo.unlock();
            }
        } else {
            this.zagj.zagb.zaa(new zaar(this.zagj));
        }
    }

    public final void onConnectionFailed(@NonNull ConnectionResult connectionResult) {
        this.zagj.zaeo.lock();
        try {
            if (this.zagj.zad(connectionResult)) {
                this.zagj.zaar();
                this.zagj.zaap();
            } else {
                this.zagj.zae(connectionResult);
            }
        } finally {
            this.zagj.zaeo.unlock();
        }
    }

    /* synthetic */ zaat(zaak zaak, zaal zaal) {
        this(zaak);
    }
}
