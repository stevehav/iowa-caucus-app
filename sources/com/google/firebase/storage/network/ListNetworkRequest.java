package com.google.firebase.storage.network;

import android.net.Uri;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.firebase.FirebaseApp;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

/* compiled from: com.google.firebase:firebase-storage@@18.1.1 */
public class ListNetworkRequest extends NetworkRequest {
    @Nullable
    private final Integer maxPageSize;
    @Nullable
    private final String nextPageToken;

    /* access modifiers changed from: protected */
    @NonNull
    public String getAction() {
        return "GET";
    }

    public ListNetworkRequest(@NonNull Uri uri, @NonNull FirebaseApp firebaseApp, @Nullable Integer num, @Nullable String str) {
        super(uri, firebaseApp);
        this.maxPageSize = num;
        this.nextPageToken = str;
    }

    /* access modifiers changed from: protected */
    @NonNull
    public String getURL() {
        return sNetworkRequestUrl + "/b/" + this.mGsUri.getAuthority() + "/o";
    }

    /* access modifiers changed from: protected */
    @Nullable
    public String getQueryParameters() throws UnsupportedEncodingException {
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        String pathWithoutBucket = getPathWithoutBucket();
        if (!TextUtils.isEmpty(pathWithoutBucket)) {
            arrayList.add("prefix");
            arrayList2.add(pathWithoutBucket + "/");
        }
        arrayList.add("delimiter");
        arrayList2.add("/");
        if (this.maxPageSize != null) {
            arrayList.add("maxResults");
            arrayList2.add(Integer.toString(this.maxPageSize.intValue()));
        }
        if (!TextUtils.isEmpty(this.nextPageToken)) {
            arrayList.add("pageToken");
            arrayList2.add(this.nextPageToken);
        }
        return getPostDataString(arrayList, arrayList2, true);
    }
}
