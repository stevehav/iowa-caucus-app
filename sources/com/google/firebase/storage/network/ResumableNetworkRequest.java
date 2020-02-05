package com.google.firebase.storage.network;

import android.net.Uri;
import androidx.annotation.NonNull;
import com.google.firebase.FirebaseApp;

/* compiled from: com.google.firebase:firebase-storage@@18.1.1 */
abstract class ResumableNetworkRequest extends NetworkRequest {
    @NonNull
    static final String COMMAND = "X-Goog-Upload-Command";
    @NonNull
    static final String CONTENT_TYPE = "X-Goog-Upload-Header-Content-Type";
    @NonNull
    static final String OFFSET = "X-Goog-Upload-Offset";
    @NonNull
    static final String PROTOCOL = "X-Goog-Upload-Protocol";

    ResumableNetworkRequest(@NonNull Uri uri, @NonNull FirebaseApp firebaseApp) {
        super(uri, firebaseApp);
    }
}
