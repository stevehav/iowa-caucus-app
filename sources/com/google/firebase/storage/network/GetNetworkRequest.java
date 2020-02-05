package com.google.firebase.storage.network;

import android.net.Uri;
import androidx.annotation.NonNull;
import com.google.common.net.HttpHeaders;
import com.google.firebase.FirebaseApp;
import java.io.UnsupportedEncodingException;
import java.util.Collections;

/* compiled from: com.google.firebase:firebase-storage@@18.1.1 */
public class GetNetworkRequest extends NetworkRequest {
    private static final String TAG = "GetNetworkRequest";

    /* access modifiers changed from: protected */
    @NonNull
    public String getAction() {
        return "GET";
    }

    public GetNetworkRequest(@NonNull Uri uri, @NonNull FirebaseApp firebaseApp, long j) {
        super(uri, firebaseApp);
        if (j != 0) {
            super.setCustomHeader(HttpHeaders.RANGE, "bytes=" + j + "-");
        }
    }

    /* access modifiers changed from: protected */
    @NonNull
    public String getQueryParameters() throws UnsupportedEncodingException {
        return getPostDataString(Collections.singletonList("alt"), Collections.singletonList("media"), true);
    }
}
