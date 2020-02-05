package com.google.firebase.firestore.auth;

import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.util.Listener;

/* compiled from: com.google.firebase:firebase-firestore@@20.2.0 */
public abstract class CredentialsProvider {
    public abstract Task<String> getToken();

    public abstract void invalidateToken();

    public abstract void removeChangeListener();

    public abstract void setChangeListener(Listener<User> listener);
}
