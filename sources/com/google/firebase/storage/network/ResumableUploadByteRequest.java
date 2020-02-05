package com.google.firebase.storage.network;

import android.net.Uri;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.firebase.FirebaseApp;
import io.grpc.internal.GrpcUtil;

/* compiled from: com.google.firebase:firebase-storage@@18.1.1 */
public class ResumableUploadByteRequest extends ResumableNetworkRequest {
    private final int bytesToWrite;
    private final byte[] chunk;
    private final boolean isFinal;
    private final long offset;
    private final String uploadURL;

    /* access modifiers changed from: protected */
    @NonNull
    public String getAction() {
        return GrpcUtil.HTTP_METHOD;
    }

    public ResumableUploadByteRequest(@NonNull Uri uri, @NonNull FirebaseApp firebaseApp, @NonNull String str, @Nullable byte[] bArr, long j, int i, boolean z) {
        super(uri, firebaseApp);
        if (TextUtils.isEmpty(str)) {
            this.mException = new IllegalArgumentException("uploadURL is null or empty");
        }
        if (bArr == null && i != -1) {
            this.mException = new IllegalArgumentException("contentType is null or empty");
        }
        if (j < 0) {
            this.mException = new IllegalArgumentException("offset cannot be negative");
        }
        this.bytesToWrite = i;
        this.uploadURL = str;
        this.chunk = i <= 0 ? null : bArr;
        this.offset = j;
        this.isFinal = z;
        super.setCustomHeader("X-Goog-Upload-Protocol", "resumable");
        if (this.isFinal && this.bytesToWrite > 0) {
            super.setCustomHeader("X-Goog-Upload-Command", "upload, finalize");
        } else if (this.isFinal) {
            super.setCustomHeader("X-Goog-Upload-Command", "finalize");
        } else {
            super.setCustomHeader("X-Goog-Upload-Command", "upload");
        }
        super.setCustomHeader("X-Goog-Upload-Offset", Long.toString(this.offset));
    }

    /* access modifiers changed from: protected */
    @NonNull
    public String getURL() {
        return this.uploadURL;
    }

    /* access modifiers changed from: protected */
    @Nullable
    public byte[] getOutputRaw() {
        return this.chunk;
    }

    /* access modifiers changed from: protected */
    public int getOutputRawSize() {
        int i = this.bytesToWrite;
        if (i > 0) {
            return i;
        }
        return 0;
    }
}
