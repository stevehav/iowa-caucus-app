package com.google.firebase.storage;

import android.net.Uri;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.common.internal.Preconditions;
import com.google.firebase.FirebaseApp;
import com.google.firebase.annotations.PublicApi;
import com.google.firebase.auth.internal.InternalAuthProvider;
import com.google.firebase.inject.Provider;
import com.google.firebase.storage.internal.Util;
import java.io.UnsupportedEncodingException;

@PublicApi
/* compiled from: com.google.firebase:firebase-storage@@18.1.1 */
public class FirebaseStorage {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final String STORAGE_BUCKET_WITH_PATH_EXCEPTION = "The storage Uri cannot contain a path element.";
    private static final String STORAGE_URI_PARSE_EXCEPTION = "The storage Uri could not be parsed.";
    private static final String TAG = "FirebaseStorage";
    @NonNull
    private final FirebaseApp mApp;
    @Nullable
    private final Provider<InternalAuthProvider> mAuthProvider;
    @Nullable
    private final String mBucketName;
    private long sMaxDownloadRetry = 600000;
    private long sMaxQueryRetry = 120000;
    private long sMaxUploadRetry = 600000;

    FirebaseStorage(@Nullable String str, @NonNull FirebaseApp firebaseApp, @Nullable Provider<InternalAuthProvider> provider) {
        this.mBucketName = str;
        this.mApp = firebaseApp;
        this.mAuthProvider = provider;
    }

    private static FirebaseStorage getInstanceImpl(@NonNull FirebaseApp firebaseApp, @Nullable Uri uri) {
        String host = uri != null ? uri.getHost() : null;
        if (uri == null || TextUtils.isEmpty(uri.getPath())) {
            Preconditions.checkNotNull(firebaseApp, "Provided FirebaseApp must not be null.");
            FirebaseStorageComponent firebaseStorageComponent = (FirebaseStorageComponent) firebaseApp.get(FirebaseStorageComponent.class);
            Preconditions.checkNotNull(firebaseStorageComponent, "Firebase Storage component is not present.");
            return firebaseStorageComponent.get(host);
        }
        throw new IllegalArgumentException(STORAGE_BUCKET_WITH_PATH_EXCEPTION);
    }

    @PublicApi
    @NonNull
    public static FirebaseStorage getInstance() {
        FirebaseApp instance = FirebaseApp.getInstance();
        Preconditions.checkArgument(instance != null, "You must call FirebaseApp.initialize() first.");
        return getInstance(instance);
    }

    @PublicApi
    @NonNull
    public static FirebaseStorage getInstance(@NonNull String str) {
        FirebaseApp instance = FirebaseApp.getInstance();
        Preconditions.checkArgument(instance != null, "You must call FirebaseApp.initialize() first.");
        return getInstance(instance, str);
    }

    @PublicApi
    @NonNull
    public static FirebaseStorage getInstance(@NonNull FirebaseApp firebaseApp) {
        Preconditions.checkArgument(firebaseApp != null, "Null is not a valid value for the FirebaseApp.");
        String storageBucket = firebaseApp.getOptions().getStorageBucket();
        if (storageBucket == null) {
            return getInstanceImpl(firebaseApp, (Uri) null);
        }
        try {
            return getInstanceImpl(firebaseApp, Util.normalize(firebaseApp, "gs://" + firebaseApp.getOptions().getStorageBucket()));
        } catch (UnsupportedEncodingException e) {
            Log.e(TAG, "Unable to parse bucket:" + storageBucket, e);
            throw new IllegalArgumentException(STORAGE_URI_PARSE_EXCEPTION);
        }
    }

    @PublicApi
    @NonNull
    public static FirebaseStorage getInstance(@NonNull FirebaseApp firebaseApp, @NonNull String str) {
        boolean z = true;
        Preconditions.checkArgument(firebaseApp != null, "Null is not a valid value for the FirebaseApp.");
        if (str == null) {
            z = false;
        }
        Preconditions.checkArgument(z, "Null is not a valid value for the Firebase Storage URL.");
        if (str.toLowerCase().startsWith("gs://")) {
            try {
                return getInstanceImpl(firebaseApp, Util.normalize(firebaseApp, str));
            } catch (UnsupportedEncodingException e) {
                Log.e(TAG, "Unable to parse url:" + str, e);
                throw new IllegalArgumentException(STORAGE_URI_PARSE_EXCEPTION);
            }
        } else {
            throw new IllegalArgumentException("Please use a gs:// URL for your Firebase Storage bucket.");
        }
    }

    @PublicApi
    public long getMaxDownloadRetryTimeMillis() {
        return this.sMaxDownloadRetry;
    }

    @PublicApi
    public void setMaxDownloadRetryTimeMillis(long j) {
        this.sMaxDownloadRetry = j;
    }

    @PublicApi
    public long getMaxUploadRetryTimeMillis() {
        return this.sMaxUploadRetry;
    }

    @PublicApi
    public void setMaxUploadRetryTimeMillis(long j) {
        this.sMaxUploadRetry = j;
    }

    @PublicApi
    public long getMaxOperationRetryTimeMillis() {
        return this.sMaxQueryRetry;
    }

    @PublicApi
    public void setMaxOperationRetryTimeMillis(long j) {
        this.sMaxQueryRetry = j;
    }

    @Nullable
    private String getBucketName() {
        return this.mBucketName;
    }

    @PublicApi
    @NonNull
    public StorageReference getReference() {
        if (!TextUtils.isEmpty(getBucketName())) {
            return getReference(new Uri.Builder().scheme("gs").authority(getBucketName()).path("/").build());
        }
        throw new IllegalStateException("FirebaseApp was not initialized with a bucket name.");
    }

    @PublicApi
    @NonNull
    public StorageReference getReferenceFromUrl(@NonNull String str) {
        Preconditions.checkArgument(!TextUtils.isEmpty(str), "location must not be null or empty");
        String lowerCase = str.toLowerCase();
        if (lowerCase.startsWith("gs://") || lowerCase.startsWith("https://") || lowerCase.startsWith("http://")) {
            try {
                Uri normalize = Util.normalize(this.mApp, str);
                if (normalize != null) {
                    return getReference(normalize);
                }
                throw new IllegalArgumentException(STORAGE_URI_PARSE_EXCEPTION);
            } catch (UnsupportedEncodingException e) {
                Log.e(TAG, "Unable to parse location:" + str, e);
                throw new IllegalArgumentException(STORAGE_URI_PARSE_EXCEPTION);
            }
        } else {
            throw new IllegalArgumentException(STORAGE_URI_PARSE_EXCEPTION);
        }
    }

    @PublicApi
    @NonNull
    public StorageReference getReference(@NonNull String str) {
        Preconditions.checkArgument(!TextUtils.isEmpty(str), "location must not be null or empty");
        String lowerCase = str.toLowerCase();
        if (!lowerCase.startsWith("gs://") && !lowerCase.startsWith("https://") && !lowerCase.startsWith("http://")) {
            return getReference().child(str);
        }
        throw new IllegalArgumentException("location should not be a full URL.");
    }

    @NonNull
    private StorageReference getReference(@NonNull Uri uri) {
        Preconditions.checkNotNull(uri, "uri must not be null");
        String bucketName = getBucketName();
        Preconditions.checkArgument(TextUtils.isEmpty(bucketName) || uri.getAuthority().equalsIgnoreCase(bucketName), "The supplied bucketname does not match the storage bucket of the current instance.");
        return new StorageReference(uri, this);
    }

    @PublicApi
    @NonNull
    public FirebaseApp getApp() {
        return this.mApp;
    }

    /* access modifiers changed from: package-private */
    @Nullable
    public InternalAuthProvider getAuthProvider() {
        Provider<InternalAuthProvider> provider = this.mAuthProvider;
        if (provider != null) {
            return provider.get();
        }
        return null;
    }
}
