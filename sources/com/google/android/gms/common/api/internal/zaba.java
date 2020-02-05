package com.google.android.gms.common.api.internal;

import androidx.annotation.NonNull;
import com.google.android.gms.auth.api.signin.internal.Storage;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.ResultCallback;
import com.google.android.gms.common.api.Status;

final class zaba implements ResultCallback<Status> {
    private final /* synthetic */ zaaw zahh;
    private final /* synthetic */ StatusPendingResult zahj;
    private final /* synthetic */ boolean zahk;
    private final /* synthetic */ GoogleApiClient zahl;

    zaba(zaaw zaaw, StatusPendingResult statusPendingResult, boolean z, GoogleApiClient googleApiClient) {
        this.zahh = zaaw;
        this.zahj = statusPendingResult;
        this.zahk = z;
        this.zahl = googleApiClient;
    }

    public final /* synthetic */ void onResult(@NonNull Result result) {
        Status status = (Status) result;
        Storage.getInstance(this.zahh.mContext).zaf();
        if (status.isSuccess() && this.zahh.isConnected()) {
            this.zahh.reconnect();
        }
        this.zahj.setResult(status);
        if (this.zahk) {
            this.zahl.disconnect();
        }
    }
}
