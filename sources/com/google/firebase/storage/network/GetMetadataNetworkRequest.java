package com.google.firebase.storage.network;

import android.net.Uri;
import androidx.annotation.NonNull;
import com.google.firebase.FirebaseApp;

/* compiled from: com.google.firebase:firebase-storage@@18.1.1 */
public class GetMetadataNetworkRequest extends NetworkRequest {
    /* access modifiers changed from: protected */
    @NonNull
    public String getAction() {
        return "GET";
    }

    public GetMetadataNetworkRequest(@NonNull Uri uri, @NonNull FirebaseApp firebaseApp) {
        super(uri, firebaseApp);
    }
}
