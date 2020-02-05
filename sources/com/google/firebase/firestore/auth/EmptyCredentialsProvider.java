package com.google.firebase.firestore.auth;

import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.firebase.firestore.util.Listener;

/* compiled from: com.google.firebase:firebase-firestore@@20.2.0 */
public class EmptyCredentialsProvider extends CredentialsProvider {
    public void invalidateToken() {
    }

    public void removeChangeListener() {
    }

    public Task<String> getToken() {
        TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        taskCompletionSource.setResult(null);
        return taskCompletionSource.getTask();
    }

    public void setChangeListener(Listener<User> listener) {
        listener.onValue(User.UNAUTHENTICATED);
    }
}
