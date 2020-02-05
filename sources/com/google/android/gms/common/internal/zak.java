package com.google.android.gms.common.internal;

import com.google.android.gms.common.api.Response;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.internal.PendingResultUtil;

final class zak implements PendingResultUtil.ResultConverter<R, T> {
    private final /* synthetic */ Response zaoz;

    zak(Response response) {
        this.zaoz = response;
    }

    public final /* synthetic */ Object convert(Result result) {
        this.zaoz.setResult(result);
        return this.zaoz;
    }
}
