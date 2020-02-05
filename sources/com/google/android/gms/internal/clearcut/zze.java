package com.google.android.gms.internal.clearcut;

import android.content.Context;
import androidx.annotation.NonNull;
import com.google.android.gms.clearcut.ClearcutLogger;
import com.google.android.gms.clearcut.zzb;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApi;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.ApiExceptionMapper;
import com.google.android.gms.common.api.internal.StatusExceptionMapper;
import com.google.android.gms.common.util.VisibleForTesting;

public final class zze extends GoogleApi<Api.ApiOptions.NoOptions> implements zzb {
    @VisibleForTesting
    private zze(@NonNull Context context) {
        super(context, ClearcutLogger.API, null, (StatusExceptionMapper) new ApiExceptionMapper());
    }

    public static zzb zzb(@NonNull Context context) {
        return new zze(context);
    }

    public final PendingResult<Status> zzb(com.google.android.gms.clearcut.zze zze) {
        return doBestEffortWrite(new zzh(zze, asGoogleApiClient()));
    }
}
