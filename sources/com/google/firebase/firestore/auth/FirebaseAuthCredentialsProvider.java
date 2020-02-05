package com.google.firebase.firestore.auth;

import androidx.annotation.NonNull;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.GetTokenResult;
import com.google.firebase.auth.internal.IdTokenListener;
import com.google.firebase.auth.internal.InternalAuthProvider;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.util.Listener;
import com.google.firebase.internal.InternalTokenResult;
import javax.annotation.Nullable;

/* compiled from: com.google.firebase:firebase-firestore@@20.2.0 */
public final class FirebaseAuthCredentialsProvider extends CredentialsProvider {
    private final InternalAuthProvider authProvider;
    @Nullable
    private Listener<User> changeListener;
    private User currentUser = getUser();
    private boolean forceRefresh;
    private final IdTokenListener idTokenListener = FirebaseAuthCredentialsProvider$$Lambda$1.lambdaFactory$(this);
    private int tokenCounter = 0;

    public FirebaseAuthCredentialsProvider(InternalAuthProvider internalAuthProvider) {
        this.authProvider = internalAuthProvider;
        internalAuthProvider.addIdTokenListener(this.idTokenListener);
    }

    static /* synthetic */ void lambda$new$0(FirebaseAuthCredentialsProvider firebaseAuthCredentialsProvider, InternalTokenResult internalTokenResult) {
        synchronized (firebaseAuthCredentialsProvider) {
            firebaseAuthCredentialsProvider.currentUser = firebaseAuthCredentialsProvider.getUser();
            firebaseAuthCredentialsProvider.tokenCounter++;
            if (firebaseAuthCredentialsProvider.changeListener != null) {
                firebaseAuthCredentialsProvider.changeListener.onValue(firebaseAuthCredentialsProvider.currentUser);
            }
        }
    }

    public synchronized Task<String> getToken() {
        boolean z;
        z = this.forceRefresh;
        this.forceRefresh = false;
        return this.authProvider.getAccessToken(z).continueWith(FirebaseAuthCredentialsProvider$$Lambda$2.lambdaFactory$(this, this.tokenCounter));
    }

    static /* synthetic */ String lambda$getToken$1(FirebaseAuthCredentialsProvider firebaseAuthCredentialsProvider, int i, Task task) throws Exception {
        String token;
        synchronized (firebaseAuthCredentialsProvider) {
            if (i != firebaseAuthCredentialsProvider.tokenCounter) {
                throw new FirebaseFirestoreException("getToken aborted due to token change", FirebaseFirestoreException.Code.ABORTED);
            } else if (task.isSuccessful()) {
                token = ((GetTokenResult) task.getResult()).getToken();
            } else {
                throw task.getException();
            }
        }
        return token;
    }

    public synchronized void invalidateToken() {
        this.forceRefresh = true;
    }

    public synchronized void setChangeListener(@NonNull Listener<User> listener) {
        this.changeListener = listener;
        listener.onValue(this.currentUser);
    }

    public synchronized void removeChangeListener() {
        this.changeListener = null;
        this.authProvider.removeIdTokenListener(this.idTokenListener);
    }

    private User getUser() {
        String uid = this.authProvider.getUid();
        return uid != null ? new User(uid) : User.UNAUTHENTICATED;
    }
}
