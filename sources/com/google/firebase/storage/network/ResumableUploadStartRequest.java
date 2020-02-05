package com.google.firebase.storage.network;

import android.net.Uri;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.facebook.react.uimanager.ViewProps;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import com.google.firebase.FirebaseApp;
import com.google.firebase.storage.internal.Slashes;
import io.grpc.internal.GrpcUtil;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import org.json.JSONObject;

/* compiled from: com.google.firebase:firebase-storage@@18.1.1 */
public class ResumableUploadStartRequest extends ResumableNetworkRequest {
    private final String contentType;
    private final JSONObject metadata;

    /* access modifiers changed from: protected */
    @NonNull
    public String getAction() {
        return GrpcUtil.HTTP_METHOD;
    }

    public ResumableUploadStartRequest(@NonNull Uri uri, @NonNull FirebaseApp firebaseApp, @Nullable JSONObject jSONObject, @NonNull String str) {
        super(uri, firebaseApp);
        this.metadata = jSONObject;
        this.contentType = str;
        if (TextUtils.isEmpty(this.contentType)) {
            this.mException = new IllegalArgumentException("mContentType is null or empty");
        }
        super.setCustomHeader("X-Goog-Upload-Protocol", "resumable");
        super.setCustomHeader("X-Goog-Upload-Command", ViewProps.START);
        super.setCustomHeader("X-Goog-Upload-Header-Content-Type", this.contentType);
    }

    /* access modifiers changed from: protected */
    @NonNull
    public String getURL() {
        return sUploadUrl + this.mGsUri.getAuthority() + "/o";
    }

    /* access modifiers changed from: protected */
    @NonNull
    public String getQueryParameters() throws UnsupportedEncodingException {
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        String pathWithoutBucket = getPathWithoutBucket();
        arrayList.add(AppMeasurementSdk.ConditionalUserProperty.NAME);
        arrayList2.add(pathWithoutBucket != null ? Slashes.unSlashize(pathWithoutBucket) : "");
        arrayList.add("uploadType");
        arrayList2.add("resumable");
        return getPostDataString(arrayList, arrayList2, false);
    }

    /* access modifiers changed from: protected */
    @Nullable
    public JSONObject getOutputJSON() {
        return this.metadata;
    }
}
