package com.google.firebase.storage;

import com.google.firebase.storage.StorageTask;

/* compiled from: com.google.firebase:firebase-storage@@18.1.1 */
final /* synthetic */ class TaskListenerImpl$$Lambda$2 implements Runnable {
    private final TaskListenerImpl arg$1;
    private final Object arg$2;
    private final StorageTask.ProvideError arg$3;

    private TaskListenerImpl$$Lambda$2(TaskListenerImpl taskListenerImpl, Object obj, StorageTask.ProvideError provideError) {
        this.arg$1 = taskListenerImpl;
        this.arg$2 = obj;
        this.arg$3 = provideError;
    }

    public static Runnable lambdaFactory$(TaskListenerImpl taskListenerImpl, Object obj, StorageTask.ProvideError provideError) {
        return new TaskListenerImpl$$Lambda$2(taskListenerImpl, obj, provideError);
    }

    public void run() {
        this.arg$1.onRaise.raise(this.arg$2, this.arg$3);
    }
}
