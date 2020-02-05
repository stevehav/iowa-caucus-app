package com.google.android.gms.common.api.internal;

import android.os.DeadObjectException;
import android.os.RemoteException;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.common.Feature;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.GoogleApiManager;
import com.google.android.gms.tasks.TaskCompletionSource;

public final class zag<ResultT> extends zac {
    private final TaskCompletionSource<ResultT> zacn;
    private final TaskApiCall<Api.AnyClient, ResultT> zacr;
    private final StatusExceptionMapper zacs;

    public zag(int i, TaskApiCall<Api.AnyClient, ResultT> taskApiCall, TaskCompletionSource<ResultT> taskCompletionSource, StatusExceptionMapper statusExceptionMapper) {
        super(i);
        this.zacn = taskCompletionSource;
        this.zacr = taskApiCall;
        this.zacs = statusExceptionMapper;
    }

    public final void zaa(GoogleApiManager.zaa<?> zaa) throws DeadObjectException {
        try {
            this.zacr.doExecute(zaa.zaab(), this.zacn);
        } catch (DeadObjectException e) {
            throw e;
        } catch (RemoteException e2) {
            zaa(zab.zaa(e2));
        } catch (RuntimeException e3) {
            zaa(e3);
        }
    }

    public final void zaa(@NonNull Status status) {
        this.zacn.trySetException(this.zacs.getException(status));
    }

    public final void zaa(@NonNull RuntimeException runtimeException) {
        this.zacn.trySetException(runtimeException);
    }

    public final void zaa(@NonNull zaab zaab, boolean z) {
        zaab.zaa(this.zacn, z);
    }

    @Nullable
    public final Feature[] zab(GoogleApiManager.zaa<?> zaa) {
        return this.zacr.zabt();
    }

    public final boolean zac(GoogleApiManager.zaa<?> zaa) {
        return this.zacr.shouldAutoResolveMissingFeatures();
    }
}
