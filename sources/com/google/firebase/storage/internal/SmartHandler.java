package com.google.firebase.storage.internal;

import android.os.Handler;
import android.os.Looper;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.common.internal.Preconditions;
import com.google.firebase.storage.StorageTaskScheduler;
import java.util.concurrent.Executor;

/* compiled from: com.google.firebase:firebase-storage@@18.1.1 */
public class SmartHandler {
    static boolean testMode = false;
    private final Executor executor;
    private final Handler handler;

    public SmartHandler(@Nullable Executor executor2) {
        this.executor = executor2;
        if (this.executor != null) {
            this.handler = null;
        } else if (!testMode) {
            this.handler = new Handler(Looper.getMainLooper());
        } else {
            this.handler = null;
        }
    }

    public void callBack(@NonNull Runnable runnable) {
        Preconditions.checkNotNull(runnable);
        Handler handler2 = this.handler;
        if (handler2 == null) {
            Executor executor2 = this.executor;
            if (executor2 != null) {
                executor2.execute(runnable);
            } else {
                StorageTaskScheduler.getInstance().scheduleCallback(runnable);
            }
        } else {
            handler2.post(runnable);
        }
    }
}
