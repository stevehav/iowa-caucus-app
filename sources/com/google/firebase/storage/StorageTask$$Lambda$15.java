package com.google.firebase.storage;

import com.google.android.gms.tasks.CancellationTokenSource;
import com.google.android.gms.tasks.OnCanceledListener;

/* compiled from: com.google.firebase:firebase-storage@@18.1.1 */
final /* synthetic */ class StorageTask$$Lambda$15 implements OnCanceledListener {
    private final CancellationTokenSource arg$1;

    private StorageTask$$Lambda$15(CancellationTokenSource cancellationTokenSource) {
        this.arg$1 = cancellationTokenSource;
    }

    public static OnCanceledListener lambdaFactory$(CancellationTokenSource cancellationTokenSource) {
        return new StorageTask$$Lambda$15(cancellationTokenSource);
    }

    public void onCanceled() {
        this.arg$1.cancel();
    }
}
