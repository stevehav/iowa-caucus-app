package com.google.android.gms.common.api.internal;

import androidx.annotation.NonNull;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.api.OptionalPendingResult;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.ResultCallback;
import com.google.android.gms.common.api.ResultTransform;
import com.google.android.gms.common.api.TransformedResult;
import java.util.concurrent.TimeUnit;

@KeepForSdk
public final class OptionalPendingResultImpl<R extends Result> extends OptionalPendingResult<R> {
    private final BasePendingResult<R> zajq;

    public OptionalPendingResultImpl(PendingResult<R> pendingResult) {
        this.zajq = (BasePendingResult) pendingResult;
    }

    public final boolean isDone() {
        return this.zajq.isReady();
    }

    public final R get() {
        if (isDone()) {
            return await(0, TimeUnit.MILLISECONDS);
        }
        throw new IllegalStateException("Result is not available. Check that isDone() returns true before calling get().");
    }

    public final R await() {
        return this.zajq.await();
    }

    public final R await(long j, TimeUnit timeUnit) {
        return this.zajq.await(j, timeUnit);
    }

    public final void cancel() {
        this.zajq.cancel();
    }

    public final boolean isCanceled() {
        return this.zajq.isCanceled();
    }

    public final void setResultCallback(ResultCallback<? super R> resultCallback) {
        this.zajq.setResultCallback(resultCallback);
    }

    public final void setResultCallback(ResultCallback<? super R> resultCallback, long j, TimeUnit timeUnit) {
        this.zajq.setResultCallback(resultCallback, j, timeUnit);
    }

    public final void addStatusListener(PendingResult.StatusListener statusListener) {
        this.zajq.addStatusListener(statusListener);
    }

    @NonNull
    public final <S extends Result> TransformedResult<S> then(@NonNull ResultTransform<? super R, ? extends S> resultTransform) {
        return this.zajq.then(resultTransform);
    }

    public final Integer zam() {
        return this.zajq.zam();
    }
}
