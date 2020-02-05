package com.google.firebase.auth.api.internal;

import android.content.Context;
import android.os.Looper;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.internal.ClientSettings;

/* compiled from: com.google.firebase:firebase-auth@@18.1.0 */
final class zzeg extends Api.AbstractClientBuilder<zzdu, zzej> {
    zzeg() {
    }

    public final /* synthetic */ Api.Client buildClient(Context context, Looper looper, ClientSettings clientSettings, Object obj, GoogleApiClient.ConnectionCallbacks connectionCallbacks, GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener) {
        return new zzdt(context, looper, clientSettings, (zzej) obj, connectionCallbacks, onConnectionFailedListener);
    }
}
