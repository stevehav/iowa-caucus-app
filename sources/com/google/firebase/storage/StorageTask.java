package com.google.firebase.storage;

import android.app.Activity;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.tasks.CancellationTokenSource;
import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.OnCanceledListener;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.RuntimeExecutionException;
import com.google.android.gms.tasks.SuccessContinuation;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.firebase.annotations.PublicApi;
import com.google.firebase.storage.StorageTask.ProvideError;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.concurrent.Executor;

@PublicApi
/* compiled from: com.google.firebase:firebase-storage@@18.1.1 */
public abstract class StorageTask<ResultT extends ProvideError> extends ControllableTask<ResultT> {
    static final int INTERNAL_STATE_CANCELED = 256;
    static final int INTERNAL_STATE_CANCELING = 32;
    static final int INTERNAL_STATE_FAILURE = 64;
    static final int INTERNAL_STATE_IN_PROGRESS = 4;
    static final int INTERNAL_STATE_NOT_STARTED = 1;
    static final int INTERNAL_STATE_PAUSED = 16;
    static final int INTERNAL_STATE_PAUSING = 8;
    static final int INTERNAL_STATE_QUEUED = 2;
    static final int INTERNAL_STATE_SUCCESS = 128;
    static final int STATES_CANCELED = 256;
    static final int STATES_COMPLETE = 448;
    static final int STATES_FAILURE = 64;
    static final int STATES_INPROGRESS = -465;
    static final int STATES_PAUSED = 16;
    static final int STATES_SUCCESS = 128;
    private static final String TAG = "StorageTask";
    private static final HashMap<Integer, HashSet<Integer>> ValidTaskInitiatedStateChanges = new HashMap<>();
    private static final HashMap<Integer, HashSet<Integer>> ValidUserInitiatedStateChanges = new HashMap<>();
    @VisibleForTesting
    final TaskListenerImpl<OnCanceledListener, ResultT> cancelManager = new TaskListenerImpl<>(this, 256, StorageTask$$Lambda$6.lambdaFactory$(this));
    @VisibleForTesting
    final TaskListenerImpl<OnCompleteListener<ResultT>, ResultT> completeListener = new TaskListenerImpl<>(this, STATES_COMPLETE, StorageTask$$Lambda$5.lambdaFactory$(this));
    private volatile int currentState = 1;
    @VisibleForTesting
    final TaskListenerImpl<OnFailureListener, ResultT> failureManager = new TaskListenerImpl<>(this, 64, StorageTask$$Lambda$4.lambdaFactory$(this));
    private ResultT finalResult;
    @VisibleForTesting
    final TaskListenerImpl<OnPausedListener<? super ResultT>, ResultT> pausedManager = new TaskListenerImpl<>(this, 16, StorageTask$$Lambda$8.lambdaFactory$());
    @VisibleForTesting
    final TaskListenerImpl<OnProgressListener<? super ResultT>, ResultT> progressManager = new TaskListenerImpl<>(this, STATES_INPROGRESS, StorageTask$$Lambda$7.lambdaFactory$());
    @VisibleForTesting
    final TaskListenerImpl<OnSuccessListener<? super ResultT>, ResultT> successManager = new TaskListenerImpl<>(this, 128, StorageTask$$Lambda$1.lambdaFactory$(this));
    protected final Object syncObject = new Object();

    /* compiled from: com.google.firebase:firebase-storage@@18.1.1 */
    protected interface ProvideError {
        Exception getError();
    }

    private String getStateString(int i) {
        return i != 1 ? i != 2 ? i != 4 ? i != 8 ? i != 16 ? i != 32 ? i != 64 ? i != 128 ? i != 256 ? "Unknown Internal State!" : "INTERNAL_STATE_CANCELED" : "INTERNAL_STATE_SUCCESS" : "INTERNAL_STATE_FAILURE" : "INTERNAL_STATE_CANCELING" : "INTERNAL_STATE_PAUSED" : "INTERNAL_STATE_PAUSING" : "INTERNAL_STATE_IN_PROGRESS" : "INTERNAL_STATE_QUEUED" : "INTERNAL_STATE_NOT_STARTED";
    }

    /* access modifiers changed from: package-private */
    @VisibleForTesting
    public abstract StorageReference getStorage();

    /* access modifiers changed from: protected */
    @PublicApi
    public void onCanceled() {
    }

    /* access modifiers changed from: protected */
    @PublicApi
    public void onFailure() {
    }

    /* access modifiers changed from: protected */
    @PublicApi
    public void onPaused() {
    }

    /* access modifiers changed from: protected */
    @PublicApi
    public void onProgress() {
    }

    /* access modifiers changed from: protected */
    @PublicApi
    public void onQueued() {
    }

    /* access modifiers changed from: protected */
    @PublicApi
    public void onSuccess() {
    }

    /* access modifiers changed from: package-private */
    @VisibleForTesting
    public void resetState() {
    }

    /* access modifiers changed from: package-private */
    @VisibleForTesting
    public abstract void run();

    /* access modifiers changed from: package-private */
    @VisibleForTesting
    public abstract void schedule();

    /* access modifiers changed from: package-private */
    @VisibleForTesting
    @NonNull
    public abstract ResultT snapStateImpl();

    static {
        ValidUserInitiatedStateChanges.put(1, new HashSet(Arrays.asList(new Integer[]{16, 256})));
        ValidUserInitiatedStateChanges.put(2, new HashSet(Arrays.asList(new Integer[]{8, 32})));
        ValidUserInitiatedStateChanges.put(4, new HashSet(Arrays.asList(new Integer[]{8, 32})));
        ValidUserInitiatedStateChanges.put(16, new HashSet(Arrays.asList(new Integer[]{2, 256})));
        ValidUserInitiatedStateChanges.put(64, new HashSet(Arrays.asList(new Integer[]{2, 256})));
        ValidTaskInitiatedStateChanges.put(1, new HashSet(Arrays.asList(new Integer[]{2, 64})));
        ValidTaskInitiatedStateChanges.put(2, new HashSet(Arrays.asList(new Integer[]{4, 64, 128})));
        ValidTaskInitiatedStateChanges.put(4, new HashSet(Arrays.asList(new Integer[]{4, 64, 128})));
        ValidTaskInitiatedStateChanges.put(8, new HashSet(Arrays.asList(new Integer[]{16, 64, 128})));
        ValidTaskInitiatedStateChanges.put(32, new HashSet(Arrays.asList(new Integer[]{256, 64, 128})));
    }

    static /* synthetic */ void lambda$new$0(StorageTask storageTask, OnSuccessListener onSuccessListener, ProvideError provideError) {
        StorageTaskManager.getInstance().unRegister(storageTask);
        onSuccessListener.onSuccess(provideError);
    }

    static /* synthetic */ void lambda$new$1(StorageTask storageTask, OnFailureListener onFailureListener, ProvideError provideError) {
        StorageTaskManager.getInstance().unRegister(storageTask);
        onFailureListener.onFailure(provideError.getError());
    }

    static /* synthetic */ void lambda$new$2(StorageTask storageTask, OnCompleteListener onCompleteListener, ProvideError provideError) {
        StorageTaskManager.getInstance().unRegister(storageTask);
        onCompleteListener.onComplete(storageTask);
    }

    static /* synthetic */ void lambda$new$3(StorageTask storageTask, OnCanceledListener onCanceledListener, ProvideError provideError) {
        StorageTaskManager.getInstance().unRegister(storageTask);
        onCanceledListener.onCanceled();
    }

    protected StorageTask() {
    }

    /* access modifiers changed from: package-private */
    @VisibleForTesting
    public boolean queue() {
        if (!tryChangeState(2, false)) {
            return false;
        }
        schedule();
        return true;
    }

    @PublicApi
    public boolean resume() {
        if (!tryChangeState(2, true)) {
            return false;
        }
        resetState();
        schedule();
        return true;
    }

    @PublicApi
    public boolean pause() {
        return tryChangeState(new int[]{16, 8}, true);
    }

    @PublicApi
    public boolean cancel() {
        return tryChangeState(new int[]{256, 32}, true);
    }

    @PublicApi
    public boolean isComplete() {
        return (getInternalState() & STATES_COMPLETE) != 0;
    }

    @PublicApi
    public boolean isSuccessful() {
        return (getInternalState() & 128) != 0;
    }

    @PublicApi
    public boolean isCanceled() {
        return getInternalState() == 256;
    }

    @PublicApi
    public boolean isInProgress() {
        return (getInternalState() & STATES_INPROGRESS) != 0;
    }

    @PublicApi
    public boolean isPaused() {
        return (getInternalState() & 16) != 0;
    }

    @PublicApi
    public ResultT getResult() {
        if (getFinalResult() != null) {
            Exception error = getFinalResult().getError();
            if (error == null) {
                return getFinalResult();
            }
            throw new RuntimeExecutionException(error);
        }
        throw new IllegalStateException();
    }

    @PublicApi
    public <X extends Throwable> ResultT getResult(@NonNull Class<X> cls) throws Throwable {
        if (getFinalResult() == null) {
            throw new IllegalStateException();
        } else if (!cls.isInstance(getFinalResult().getError())) {
            Exception error = getFinalResult().getError();
            if (error == null) {
                return getFinalResult();
            }
            throw new RuntimeExecutionException(error);
        } else {
            throw ((Throwable) cls.cast(getFinalResult().getError()));
        }
    }

    @PublicApi
    @Nullable
    public Exception getException() {
        if (getFinalResult() == null) {
            return null;
        }
        return getFinalResult().getError();
    }

    @PublicApi
    public ResultT getSnapshot() {
        return snapState();
    }

    /* access modifiers changed from: package-private */
    @VisibleForTesting
    public int getInternalState() {
        return this.currentState;
    }

    /* access modifiers changed from: package-private */
    @VisibleForTesting
    public Object getSyncObject() {
        return this.syncObject;
    }

    /* access modifiers changed from: package-private */
    @VisibleForTesting
    @NonNull
    public ResultT snapState() {
        ResultT snapStateImpl;
        synchronized (this.syncObject) {
            snapStateImpl = snapStateImpl();
        }
        return snapStateImpl;
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x00bc, code lost:
        return true;
     */
    @androidx.annotation.VisibleForTesting
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean tryChangeState(int[] r9, boolean r10) {
        /*
            r8 = this;
            if (r10 == 0) goto L_0x0005
            java.util.HashMap<java.lang.Integer, java.util.HashSet<java.lang.Integer>> r0 = ValidUserInitiatedStateChanges
            goto L_0x0007
        L_0x0005:
            java.util.HashMap<java.lang.Integer, java.util.HashSet<java.lang.Integer>> r0 = ValidTaskInitiatedStateChanges
        L_0x0007:
            java.lang.Object r1 = r8.syncObject
            monitor-enter(r1)
            int r2 = r9.length     // Catch:{ all -> 0x00f4 }
            r3 = 0
            r4 = 0
        L_0x000d:
            if (r4 >= r2) goto L_0x00c2
            r5 = r9[r4]     // Catch:{ all -> 0x00f4 }
            int r6 = r8.getInternalState()     // Catch:{ all -> 0x00f4 }
            java.lang.Integer r6 = java.lang.Integer.valueOf(r6)     // Catch:{ all -> 0x00f4 }
            java.lang.Object r6 = r0.get(r6)     // Catch:{ all -> 0x00f4 }
            java.util.HashSet r6 = (java.util.HashSet) r6     // Catch:{ all -> 0x00f4 }
            if (r6 == 0) goto L_0x00be
            java.lang.Integer r7 = java.lang.Integer.valueOf(r5)     // Catch:{ all -> 0x00f4 }
            boolean r6 = r6.contains(r7)     // Catch:{ all -> 0x00f4 }
            if (r6 == 0) goto L_0x00be
            r8.currentState = r5     // Catch:{ all -> 0x00f4 }
            int r9 = r8.currentState     // Catch:{ all -> 0x00f4 }
            r0 = 2
            if (r9 == r0) goto L_0x005a
            r0 = 4
            if (r9 == r0) goto L_0x0056
            r0 = 16
            if (r9 == r0) goto L_0x0052
            r0 = 64
            if (r9 == r0) goto L_0x004e
            r0 = 128(0x80, float:1.794E-43)
            if (r9 == r0) goto L_0x004a
            r0 = 256(0x100, float:3.59E-43)
            if (r9 == r0) goto L_0x0046
            goto L_0x0064
        L_0x0046:
            r8.onCanceled()     // Catch:{ all -> 0x00f4 }
            goto L_0x0064
        L_0x004a:
            r8.onSuccess()     // Catch:{ all -> 0x00f4 }
            goto L_0x0064
        L_0x004e:
            r8.onFailure()     // Catch:{ all -> 0x00f4 }
            goto L_0x0064
        L_0x0052:
            r8.onPaused()     // Catch:{ all -> 0x00f4 }
            goto L_0x0064
        L_0x0056:
            r8.onProgress()     // Catch:{ all -> 0x00f4 }
            goto L_0x0064
        L_0x005a:
            com.google.firebase.storage.StorageTaskManager r9 = com.google.firebase.storage.StorageTaskManager.getInstance()     // Catch:{ all -> 0x00f4 }
            r9.ensureRegistered(r8)     // Catch:{ all -> 0x00f4 }
            r8.onQueued()     // Catch:{ all -> 0x00f4 }
        L_0x0064:
            com.google.firebase.storage.TaskListenerImpl<com.google.android.gms.tasks.OnSuccessListener<? super ResultT>, ResultT> r9 = r8.successManager     // Catch:{ all -> 0x00f4 }
            r9.onInternalStateChanged()     // Catch:{ all -> 0x00f4 }
            com.google.firebase.storage.TaskListenerImpl<com.google.android.gms.tasks.OnFailureListener, ResultT> r9 = r8.failureManager     // Catch:{ all -> 0x00f4 }
            r9.onInternalStateChanged()     // Catch:{ all -> 0x00f4 }
            com.google.firebase.storage.TaskListenerImpl<com.google.android.gms.tasks.OnCanceledListener, ResultT> r9 = r8.cancelManager     // Catch:{ all -> 0x00f4 }
            r9.onInternalStateChanged()     // Catch:{ all -> 0x00f4 }
            com.google.firebase.storage.TaskListenerImpl<com.google.android.gms.tasks.OnCompleteListener<ResultT>, ResultT> r9 = r8.completeListener     // Catch:{ all -> 0x00f4 }
            r9.onInternalStateChanged()     // Catch:{ all -> 0x00f4 }
            com.google.firebase.storage.TaskListenerImpl<com.google.firebase.storage.OnPausedListener<? super ResultT>, ResultT> r9 = r8.pausedManager     // Catch:{ all -> 0x00f4 }
            r9.onInternalStateChanged()     // Catch:{ all -> 0x00f4 }
            com.google.firebase.storage.TaskListenerImpl<com.google.firebase.storage.OnProgressListener<? super ResultT>, ResultT> r9 = r8.progressManager     // Catch:{ all -> 0x00f4 }
            r9.onInternalStateChanged()     // Catch:{ all -> 0x00f4 }
            java.lang.String r9 = "StorageTask"
            r0 = 3
            boolean r9 = android.util.Log.isLoggable(r9, r0)     // Catch:{ all -> 0x00f4 }
            if (r9 == 0) goto L_0x00bb
            java.lang.String r9 = "StorageTask"
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ all -> 0x00f4 }
            r0.<init>()     // Catch:{ all -> 0x00f4 }
            java.lang.String r2 = "changed internal state to: "
            r0.append(r2)     // Catch:{ all -> 0x00f4 }
            java.lang.String r2 = r8.getStateString((int) r5)     // Catch:{ all -> 0x00f4 }
            r0.append(r2)     // Catch:{ all -> 0x00f4 }
            java.lang.String r2 = " isUser: "
            r0.append(r2)     // Catch:{ all -> 0x00f4 }
            r0.append(r10)     // Catch:{ all -> 0x00f4 }
            java.lang.String r10 = " from state:"
            r0.append(r10)     // Catch:{ all -> 0x00f4 }
            int r10 = r8.currentState     // Catch:{ all -> 0x00f4 }
            java.lang.String r10 = r8.getStateString((int) r10)     // Catch:{ all -> 0x00f4 }
            r0.append(r10)     // Catch:{ all -> 0x00f4 }
            java.lang.String r10 = r0.toString()     // Catch:{ all -> 0x00f4 }
            android.util.Log.d(r9, r10)     // Catch:{ all -> 0x00f4 }
        L_0x00bb:
            monitor-exit(r1)     // Catch:{ all -> 0x00f4 }
            r9 = 1
            return r9
        L_0x00be:
            int r4 = r4 + 1
            goto L_0x000d
        L_0x00c2:
            java.lang.String r0 = "StorageTask"
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x00f4 }
            r2.<init>()     // Catch:{ all -> 0x00f4 }
            java.lang.String r4 = "unable to change internal state to: "
            r2.append(r4)     // Catch:{ all -> 0x00f4 }
            java.lang.String r9 = r8.getStateString((int[]) r9)     // Catch:{ all -> 0x00f4 }
            r2.append(r9)     // Catch:{ all -> 0x00f4 }
            java.lang.String r9 = " isUser: "
            r2.append(r9)     // Catch:{ all -> 0x00f4 }
            r2.append(r10)     // Catch:{ all -> 0x00f4 }
            java.lang.String r9 = " from state:"
            r2.append(r9)     // Catch:{ all -> 0x00f4 }
            int r9 = r8.currentState     // Catch:{ all -> 0x00f4 }
            java.lang.String r9 = r8.getStateString((int) r9)     // Catch:{ all -> 0x00f4 }
            r2.append(r9)     // Catch:{ all -> 0x00f4 }
            java.lang.String r9 = r2.toString()     // Catch:{ all -> 0x00f4 }
            android.util.Log.w(r0, r9)     // Catch:{ all -> 0x00f4 }
            monitor-exit(r1)     // Catch:{ all -> 0x00f4 }
            return r3
        L_0x00f4:
            r9 = move-exception
            monitor-exit(r1)     // Catch:{ all -> 0x00f4 }
            goto L_0x00f8
        L_0x00f7:
            throw r9
        L_0x00f8:
            goto L_0x00f7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.storage.StorageTask.tryChangeState(int[], boolean):boolean");
    }

    /* access modifiers changed from: package-private */
    @VisibleForTesting
    public boolean tryChangeState(int i, boolean z) {
        return tryChangeState(new int[]{i}, z);
    }

    private ResultT getFinalResult() {
        ResultT resultt = this.finalResult;
        if (resultt != null) {
            return resultt;
        }
        if (!isComplete()) {
            return null;
        }
        if (this.finalResult == null) {
            this.finalResult = snapState();
        }
        return this.finalResult;
    }

    @PublicApi
    public StorageTask<ResultT> addOnPausedListener(@NonNull OnPausedListener<? super ResultT> onPausedListener) {
        Preconditions.checkNotNull(onPausedListener);
        this.pausedManager.addListener((Activity) null, (Executor) null, onPausedListener);
        return this;
    }

    @PublicApi
    public StorageTask<ResultT> addOnPausedListener(@NonNull Executor executor, @NonNull OnPausedListener<? super ResultT> onPausedListener) {
        Preconditions.checkNotNull(onPausedListener);
        Preconditions.checkNotNull(executor);
        this.pausedManager.addListener((Activity) null, executor, onPausedListener);
        return this;
    }

    @PublicApi
    public StorageTask<ResultT> addOnPausedListener(@NonNull Activity activity, @NonNull OnPausedListener<? super ResultT> onPausedListener) {
        Preconditions.checkNotNull(onPausedListener);
        Preconditions.checkNotNull(activity);
        this.pausedManager.addListener(activity, (Executor) null, onPausedListener);
        return this;
    }

    @PublicApi
    public StorageTask<ResultT> removeOnPausedListener(@NonNull OnPausedListener<? super ResultT> onPausedListener) {
        Preconditions.checkNotNull(onPausedListener);
        this.pausedManager.removeListener(onPausedListener);
        return this;
    }

    @PublicApi
    public StorageTask<ResultT> addOnProgressListener(@NonNull OnProgressListener<? super ResultT> onProgressListener) {
        Preconditions.checkNotNull(onProgressListener);
        this.progressManager.addListener((Activity) null, (Executor) null, onProgressListener);
        return this;
    }

    @PublicApi
    public StorageTask<ResultT> addOnProgressListener(@NonNull Executor executor, @NonNull OnProgressListener<? super ResultT> onProgressListener) {
        Preconditions.checkNotNull(onProgressListener);
        Preconditions.checkNotNull(executor);
        this.progressManager.addListener((Activity) null, executor, onProgressListener);
        return this;
    }

    @PublicApi
    public StorageTask<ResultT> addOnProgressListener(@NonNull Activity activity, @NonNull OnProgressListener<? super ResultT> onProgressListener) {
        Preconditions.checkNotNull(onProgressListener);
        Preconditions.checkNotNull(activity);
        this.progressManager.addListener(activity, (Executor) null, onProgressListener);
        return this;
    }

    @PublicApi
    public StorageTask<ResultT> removeOnProgressListener(@NonNull OnProgressListener<? super ResultT> onProgressListener) {
        Preconditions.checkNotNull(onProgressListener);
        this.progressManager.removeListener(onProgressListener);
        return this;
    }

    @PublicApi
    @NonNull
    public StorageTask<ResultT> addOnSuccessListener(@NonNull OnSuccessListener<? super ResultT> onSuccessListener) {
        Preconditions.checkNotNull(onSuccessListener);
        this.successManager.addListener((Activity) null, (Executor) null, onSuccessListener);
        return this;
    }

    @PublicApi
    @NonNull
    public StorageTask<ResultT> addOnSuccessListener(@NonNull Executor executor, @NonNull OnSuccessListener<? super ResultT> onSuccessListener) {
        Preconditions.checkNotNull(executor);
        Preconditions.checkNotNull(onSuccessListener);
        this.successManager.addListener((Activity) null, executor, onSuccessListener);
        return this;
    }

    @PublicApi
    @NonNull
    public StorageTask<ResultT> addOnSuccessListener(@NonNull Activity activity, @NonNull OnSuccessListener<? super ResultT> onSuccessListener) {
        Preconditions.checkNotNull(activity);
        Preconditions.checkNotNull(onSuccessListener);
        this.successManager.addListener(activity, (Executor) null, onSuccessListener);
        return this;
    }

    @PublicApi
    public StorageTask<ResultT> removeOnSuccessListener(@NonNull OnSuccessListener<? super ResultT> onSuccessListener) {
        Preconditions.checkNotNull(onSuccessListener);
        this.successManager.removeListener(onSuccessListener);
        return this;
    }

    @PublicApi
    @NonNull
    public StorageTask<ResultT> addOnFailureListener(@NonNull OnFailureListener onFailureListener) {
        Preconditions.checkNotNull(onFailureListener);
        this.failureManager.addListener((Activity) null, (Executor) null, onFailureListener);
        return this;
    }

    @PublicApi
    @NonNull
    public StorageTask<ResultT> addOnFailureListener(@NonNull Executor executor, @NonNull OnFailureListener onFailureListener) {
        Preconditions.checkNotNull(onFailureListener);
        Preconditions.checkNotNull(executor);
        this.failureManager.addListener((Activity) null, executor, onFailureListener);
        return this;
    }

    @PublicApi
    @NonNull
    public StorageTask<ResultT> addOnFailureListener(@NonNull Activity activity, @NonNull OnFailureListener onFailureListener) {
        Preconditions.checkNotNull(onFailureListener);
        Preconditions.checkNotNull(activity);
        this.failureManager.addListener(activity, (Executor) null, onFailureListener);
        return this;
    }

    @PublicApi
    public StorageTask<ResultT> removeOnFailureListener(@NonNull OnFailureListener onFailureListener) {
        Preconditions.checkNotNull(onFailureListener);
        this.failureManager.removeListener(onFailureListener);
        return this;
    }

    @PublicApi
    @NonNull
    public StorageTask<ResultT> addOnCompleteListener(@NonNull OnCompleteListener<ResultT> onCompleteListener) {
        Preconditions.checkNotNull(onCompleteListener);
        this.completeListener.addListener((Activity) null, (Executor) null, onCompleteListener);
        return this;
    }

    @PublicApi
    @NonNull
    public StorageTask<ResultT> addOnCompleteListener(@NonNull Executor executor, @NonNull OnCompleteListener<ResultT> onCompleteListener) {
        Preconditions.checkNotNull(onCompleteListener);
        Preconditions.checkNotNull(executor);
        this.completeListener.addListener((Activity) null, executor, onCompleteListener);
        return this;
    }

    @PublicApi
    @NonNull
    public StorageTask<ResultT> addOnCompleteListener(@NonNull Activity activity, @NonNull OnCompleteListener<ResultT> onCompleteListener) {
        Preconditions.checkNotNull(onCompleteListener);
        Preconditions.checkNotNull(activity);
        this.completeListener.addListener(activity, (Executor) null, onCompleteListener);
        return this;
    }

    @PublicApi
    public StorageTask<ResultT> removeOnCompleteListener(@NonNull OnCompleteListener<ResultT> onCompleteListener) {
        Preconditions.checkNotNull(onCompleteListener);
        this.completeListener.removeListener(onCompleteListener);
        return this;
    }

    @PublicApi
    @NonNull
    public StorageTask<ResultT> addOnCanceledListener(@NonNull OnCanceledListener onCanceledListener) {
        Preconditions.checkNotNull(onCanceledListener);
        this.cancelManager.addListener((Activity) null, (Executor) null, onCanceledListener);
        return this;
    }

    @PublicApi
    @NonNull
    public StorageTask<ResultT> addOnCanceledListener(@NonNull Executor executor, @NonNull OnCanceledListener onCanceledListener) {
        Preconditions.checkNotNull(onCanceledListener);
        Preconditions.checkNotNull(executor);
        this.cancelManager.addListener((Activity) null, executor, onCanceledListener);
        return this;
    }

    @PublicApi
    @NonNull
    public StorageTask<ResultT> addOnCanceledListener(@NonNull Activity activity, @NonNull OnCanceledListener onCanceledListener) {
        Preconditions.checkNotNull(onCanceledListener);
        Preconditions.checkNotNull(activity);
        this.cancelManager.addListener(activity, (Executor) null, onCanceledListener);
        return this;
    }

    @PublicApi
    public StorageTask<ResultT> removeOnCanceledListener(@NonNull OnCanceledListener onCanceledListener) {
        Preconditions.checkNotNull(onCanceledListener);
        this.cancelManager.removeListener(onCanceledListener);
        return this;
    }

    @PublicApi
    @NonNull
    public <ContinuationResultT> Task<ContinuationResultT> continueWith(@NonNull Continuation<ResultT, ContinuationResultT> continuation) {
        return continueWithImpl((Executor) null, continuation);
    }

    @PublicApi
    @NonNull
    public <ContinuationResultT> Task<ContinuationResultT> continueWith(@NonNull Executor executor, @NonNull Continuation<ResultT, ContinuationResultT> continuation) {
        return continueWithImpl(executor, continuation);
    }

    @NonNull
    private <ContinuationResultT> Task<ContinuationResultT> continueWithImpl(@Nullable Executor executor, @NonNull Continuation<ResultT, ContinuationResultT> continuation) {
        TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        this.completeListener.addListener((Activity) null, executor, StorageTask$$Lambda$9.lambdaFactory$(this, continuation, taskCompletionSource));
        return taskCompletionSource.getTask();
    }

    static /* synthetic */ void lambda$continueWithImpl$4(StorageTask storageTask, Continuation continuation, TaskCompletionSource taskCompletionSource, Task task) {
        try {
            Object then = continuation.then(storageTask);
            if (!taskCompletionSource.getTask().isComplete()) {
                taskCompletionSource.setResult(then);
            }
        } catch (RuntimeExecutionException e) {
            if (e.getCause() instanceof Exception) {
                taskCompletionSource.setException((Exception) e.getCause());
            } else {
                taskCompletionSource.setException(e);
            }
        } catch (Exception e2) {
            taskCompletionSource.setException(e2);
        }
    }

    @PublicApi
    @NonNull
    public <ContinuationResultT> Task<ContinuationResultT> continueWithTask(@NonNull Continuation<ResultT, Task<ContinuationResultT>> continuation) {
        return continueWithTaskImpl((Executor) null, continuation);
    }

    @PublicApi
    @NonNull
    public <ContinuationResultT> Task<ContinuationResultT> continueWithTask(@NonNull Executor executor, @NonNull Continuation<ResultT, Task<ContinuationResultT>> continuation) {
        return continueWithTaskImpl(executor, continuation);
    }

    @PublicApi
    @NonNull
    public <ContinuationResultT> Task<ContinuationResultT> onSuccessTask(@NonNull SuccessContinuation<ResultT, ContinuationResultT> successContinuation) {
        return successTaskImpl((Executor) null, successContinuation);
    }

    @PublicApi
    @NonNull
    public <ContinuationResultT> Task<ContinuationResultT> onSuccessTask(@NonNull Executor executor, @NonNull SuccessContinuation<ResultT, ContinuationResultT> successContinuation) {
        return successTaskImpl(executor, successContinuation);
    }

    @NonNull
    private <ContinuationResultT> Task<ContinuationResultT> continueWithTaskImpl(@Nullable Executor executor, @NonNull Continuation<ResultT, Task<ContinuationResultT>> continuation) {
        CancellationTokenSource cancellationTokenSource = new CancellationTokenSource();
        TaskCompletionSource taskCompletionSource = new TaskCompletionSource(cancellationTokenSource.getToken());
        this.completeListener.addListener((Activity) null, executor, StorageTask$$Lambda$10.lambdaFactory$(this, continuation, taskCompletionSource, cancellationTokenSource));
        return taskCompletionSource.getTask();
    }

    static /* synthetic */ void lambda$continueWithTaskImpl$5(StorageTask storageTask, Continuation continuation, TaskCompletionSource taskCompletionSource, CancellationTokenSource cancellationTokenSource, Task task) {
        try {
            Task task2 = (Task) continuation.then(storageTask);
            if (taskCompletionSource.getTask().isComplete()) {
                return;
            }
            if (task2 == null) {
                taskCompletionSource.setException(new NullPointerException("Continuation returned null"));
                return;
            }
            taskCompletionSource.getClass();
            task2.addOnSuccessListener(StorageTask$$Lambda$16.lambdaFactory$(taskCompletionSource));
            taskCompletionSource.getClass();
            task2.addOnFailureListener(StorageTask$$Lambda$17.lambdaFactory$(taskCompletionSource));
            cancellationTokenSource.getClass();
            task2.addOnCanceledListener(StorageTask$$Lambda$18.lambdaFactory$(cancellationTokenSource));
        } catch (RuntimeExecutionException e) {
            if (e.getCause() instanceof Exception) {
                taskCompletionSource.setException((Exception) e.getCause());
            } else {
                taskCompletionSource.setException(e);
            }
        } catch (Exception e2) {
            taskCompletionSource.setException(e2);
        }
    }

    @NonNull
    private <ContinuationResultT> Task<ContinuationResultT> successTaskImpl(@Nullable Executor executor, @NonNull SuccessContinuation<ResultT, ContinuationResultT> successContinuation) {
        CancellationTokenSource cancellationTokenSource = new CancellationTokenSource();
        TaskCompletionSource taskCompletionSource = new TaskCompletionSource(cancellationTokenSource.getToken());
        this.successManager.addListener((Activity) null, executor, StorageTask$$Lambda$11.lambdaFactory$(successContinuation, taskCompletionSource, cancellationTokenSource));
        return taskCompletionSource.getTask();
    }

    static /* synthetic */ void lambda$successTaskImpl$6(SuccessContinuation successContinuation, TaskCompletionSource taskCompletionSource, CancellationTokenSource cancellationTokenSource, ProvideError provideError) {
        try {
            Task then = successContinuation.then(provideError);
            taskCompletionSource.getClass();
            then.addOnSuccessListener(StorageTask$$Lambda$13.lambdaFactory$(taskCompletionSource));
            taskCompletionSource.getClass();
            then.addOnFailureListener(StorageTask$$Lambda$14.lambdaFactory$(taskCompletionSource));
            cancellationTokenSource.getClass();
            then.addOnCanceledListener(StorageTask$$Lambda$15.lambdaFactory$(cancellationTokenSource));
        } catch (RuntimeExecutionException e) {
            if (e.getCause() instanceof Exception) {
                taskCompletionSource.setException((Exception) e.getCause());
            } else {
                taskCompletionSource.setException(e);
            }
        } catch (Exception e2) {
            taskCompletionSource.setException(e2);
        }
    }

    /* access modifiers changed from: package-private */
    @VisibleForTesting
    public Runnable getRunnable() {
        return StorageTask$$Lambda$12.lambdaFactory$(this);
    }

    static /* synthetic */ void lambda$getRunnable$7(StorageTask storageTask) {
        try {
            storageTask.run();
        } finally {
            storageTask.ensureFinalState();
        }
    }

    private void ensureFinalState() {
        if (!isComplete() && !isPaused() && getInternalState() != 2 && !tryChangeState(256, false)) {
            tryChangeState(64, false);
        }
    }

    private String getStateString(int[] iArr) {
        if (iArr.length == 0) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        for (int stateString : iArr) {
            sb.append(getStateString(stateString));
            sb.append(", ");
        }
        return sb.substring(0, sb.length() - 2);
    }

    @PublicApi
    /* compiled from: com.google.firebase:firebase-storage@@18.1.1 */
    public class SnapshotBase implements ProvideError {
        private final Exception error;

        @PublicApi
        public SnapshotBase(Exception exc) {
            if (exc != null) {
                this.error = exc;
            } else if (StorageTask.this.isCanceled()) {
                this.error = StorageException.fromErrorStatus(Status.RESULT_CANCELED);
            } else if (StorageTask.this.getInternalState() == 64) {
                this.error = StorageException.fromErrorStatus(Status.RESULT_INTERNAL_ERROR);
            } else {
                this.error = null;
            }
        }

        @PublicApi
        @NonNull
        public StorageTask<ResultT> getTask() {
            return StorageTask.this;
        }

        @PublicApi
        @NonNull
        public StorageReference getStorage() {
            return getTask().getStorage();
        }

        @PublicApi
        @Nullable
        public Exception getError() {
            return this.error;
        }
    }
}
