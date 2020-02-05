package com.google.firebase.storage.network;

import android.net.Uri;
import androidx.annotation.NonNull;
import com.google.firebase.FirebaseApp;

/* compiled from: com.google.firebase:firebase-storage@@18.1.1 */
public class DeleteNetworkRequest extends NetworkRequest {
    /* access modifiers changed from: protected */
    @NonNull
    public String getAction() {
        return "DELETE";
    }

    public DeleteNetworkRequest(@NonNull Uri uri, @NonNull FirebaseApp firebaseApp) {
        super(uri, firebaseApp);
    }
}
