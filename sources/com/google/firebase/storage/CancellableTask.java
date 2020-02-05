package com.google.firebase.storage;

import android.app.Activity;
import androidx.annotation.NonNull;
import com.google.android.gms.tasks.Task;
import com.google.firebase.annotations.PublicApi;
import java.util.concurrent.Executor;

@PublicApi
/* compiled from: com.google.firebase:firebase-storage@@18.1.1 */
public abstract class CancellableTask<StateT> extends Task<StateT> {
    @PublicApi
    public abstract CancellableTask<StateT> addOnProgressListener(@NonNull Activity activity, @NonNull OnProgressListener<? super StateT> onProgressListener);

    @PublicApi
    public abstract CancellableTask<StateT> addOnProgressListener(@NonNull OnProgressListener<? super StateT> onProgressListener);

    @PublicApi
    public abstract CancellableTask<StateT> addOnProgressListener(@NonNull Executor executor, @NonNull OnProgressListener<? super StateT> onProgressListener);

    @PublicApi
    public abstract boolean cancel();

    @PublicApi
    public abstract boolean isCanceled();

    @PublicApi
    public abstract boolean isInProgress();
}
