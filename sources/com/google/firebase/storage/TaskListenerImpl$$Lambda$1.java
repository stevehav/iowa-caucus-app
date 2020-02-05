package com.google.firebase.storage;

/* compiled from: com.google.firebase:firebase-storage@@18.1.1 */
final /* synthetic */ class TaskListenerImpl$$Lambda$1 implements Runnable {
    private final TaskListenerImpl arg$1;
    private final Object arg$2;

    private TaskListenerImpl$$Lambda$1(TaskListenerImpl taskListenerImpl, Object obj) {
        this.arg$1 = taskListenerImpl;
        this.arg$2 = obj;
    }

    public static Runnable lambdaFactory$(TaskListenerImpl taskListenerImpl, Object obj) {
        return new TaskListenerImpl$$Lambda$1(taskListenerImpl, obj);
    }

    public void run() {
        this.arg$1.removeListener(this.arg$2);
    }
}
