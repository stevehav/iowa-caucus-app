package com.google.firebase.storage;

import android.app.Activity;
import androidx.annotation.NonNull;
import com.google.firebase.annotations.PublicApi;
import java.util.concurrent.Executor;

@PublicApi
/* compiled from: com.google.firebase:firebase-storage@@18.1.1 */
public abstract class ControllableTask<StateT> extends CancellableTask<StateT> {
    @PublicApi
    public abstract ControllableTask<StateT> addOnPausedListener(@NonNull Activity activity, @NonNull OnPausedListener<? super StateT> onPausedListener);

    @PublicApi
    public abstract ControllableTask<StateT> addOnPausedListener(@NonNull OnPausedListener<? super StateT> onPausedListener);

    @PublicApi
    public abstract ControllableTask<StateT> addOnPausedListener(@NonNull Executor executor, @NonNull OnPausedListener<? super StateT> onPausedListener);

    @PublicApi
    public abstract boolean isPaused();

    @PublicApi
    public abstract boolean pause();

    @PublicApi
    public abstract boolean resume();
}
