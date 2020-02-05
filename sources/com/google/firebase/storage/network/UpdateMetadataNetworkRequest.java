package com.google.firebase.storage.network;

import android.net.Uri;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.firebase.FirebaseApp;
import org.json.JSONObject;

/* compiled from: com.google.firebase:firebase-storage@@18.1.1 */
public class UpdateMetadataNetworkRequest extends NetworkRequest {
    private final JSONObject metadata;

    /* access modifiers changed from: protected */
    @NonNull
    public String getAction() {
        return "PUT";
    }

    public UpdateMetadataNetworkRequest(@NonNull Uri uri, @NonNull FirebaseApp firebaseApp, @Nullable JSONObject jSONObject) {
        super(uri, firebaseApp);
        this.metadata = jSONObject;
        setCustomHeader("X-HTTP-Method-Override", "PATCH");
    }

    /* access modifiers changed from: protected */
    @Nullable
    public JSONObject getOutputJSON() {
        return this.metadata;
    }
}
