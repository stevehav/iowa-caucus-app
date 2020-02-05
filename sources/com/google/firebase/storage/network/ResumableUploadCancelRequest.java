package com.google.firebase.storage.network;

import android.net.Uri;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.VisibleForTesting;
import com.google.firebase.FirebaseApp;
import io.grpc.internal.GrpcUtil;

/* compiled from: com.google.firebase:firebase-storage@@18.1.1 */
public class ResumableUploadCancelRequest extends ResumableNetworkRequest {
    @VisibleForTesting
    public static boolean cancelCalled = false;
    private final String uploadURL;

    /* access modifiers changed from: protected */
    @NonNull
    public String getAction() {
        return GrpcUtil.HTTP_METHOD;
    }

    public ResumableUploadCancelRequest(@NonNull Uri uri, @NonNull FirebaseApp firebaseApp, @NonNull String str) {
        super(uri, firebaseApp);
        cancelCalled = true;
        if (TextUtils.isEmpty(str)) {
            this.mException = new IllegalArgumentException("uploadURL is null or empty");
        }
        this.uploadURL = str;
        super.setCustomHeader("X-Goog-Upload-Protocol", "resumable");
        super.setCustomHeader("X-Goog-Upload-Command", "cancel");
    }

    /* access modifiers changed from: protected */
    @NonNull
    public String getURL() {
        return this.uploadURL;
    }
}
