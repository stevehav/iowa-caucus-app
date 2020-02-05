package com.google.firebase.storage;

import android.net.Uri;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.Preconditions;
import com.google.firebase.FirebaseApp;
import com.google.firebase.annotations.PublicApi;
import com.google.firebase.auth.internal.InternalAuthProvider;
import com.google.firebase.storage.StorageMetadata;
import com.google.firebase.storage.internal.AdaptiveStreamBuffer;
import com.google.firebase.storage.internal.ExponentialBackoffSender;
import com.google.firebase.storage.internal.Util;
import com.google.firebase.storage.network.NetworkRequest;
import com.google.firebase.storage.network.ResumableUploadByteRequest;
import com.google.firebase.storage.network.ResumableUploadCancelRequest;
import com.google.firebase.storage.network.ResumableUploadQueryRequest;
import com.google.firebase.storage.network.ResumableUploadStartRequest;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.concurrent.atomic.AtomicLong;
import org.json.JSONException;
import org.json.JSONObject;

@PublicApi
/* compiled from: com.google.firebase:firebase-storage@@18.1.1 */
public class UploadTask extends StorageTask<TaskSnapshot> {
    private static final String APPLICATION_OCTET_STREAM = "application/octet-stream";
    private static final int MAXIMUM_CHUNK_SIZE = 33554432;
    @VisibleForTesting
    static final int PREFERRED_CHUNK_SIZE = 262144;
    private static final String RESUMABLE_FINAL_STATUS = "final";
    private static final String TAG = "UploadTask";
    private static final String X_GOOG_UPLOAD_URL = "X-Goog-Upload-URL";
    /* access modifiers changed from: private */
    @Nullable
    public final InternalAuthProvider mAuthProvider;
    private final AtomicLong mBytesUploaded;
    private int mCurrentChunkSize;
    private volatile Exception mException;
    private boolean mIsStreamOwned;
    private volatile StorageMetadata mMetadata;
    private volatile int mResultCode;
    private ExponentialBackoffSender mSender;
    private volatile Exception mServerException;
    private volatile String mServerStatus;
    /* access modifiers changed from: private */
    public final StorageReference mStorageRef;
    private final AdaptiveStreamBuffer mStreamBuffer;
    private final long mTotalByteCount;
    private volatile Uri mUploadUri;
    private final Uri mUri;

    private boolean isValidHttpResponseCode(int i) {
        return i == 308 || (i >= 200 && i < 300);
    }

    UploadTask(StorageReference storageReference, StorageMetadata storageMetadata, byte[] bArr) {
        this.mBytesUploaded = new AtomicLong(0);
        this.mCurrentChunkSize = 262144;
        this.mUploadUri = null;
        this.mException = null;
        this.mServerException = null;
        this.mResultCode = 0;
        Preconditions.checkNotNull(storageReference);
        Preconditions.checkNotNull(bArr);
        FirebaseStorage storage = storageReference.getStorage();
        this.mTotalByteCount = (long) bArr.length;
        this.mStorageRef = storageReference;
        this.mMetadata = storageMetadata;
        this.mAuthProvider = storage.getAuthProvider();
        this.mUri = null;
        this.mStreamBuffer = new AdaptiveStreamBuffer(new ByteArrayInputStream(bArr), 262144);
        this.mIsStreamOwned = true;
        this.mSender = new ExponentialBackoffSender(storage.getApp().getApplicationContext(), storage.getAuthProvider(), storage.getMaxDownloadRetryTimeMillis());
    }

    /* JADX WARNING: Removed duplicated region for block: B:21:0x00a0  */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x00b2  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    UploadTask(com.google.firebase.storage.StorageReference r9, com.google.firebase.storage.StorageMetadata r10, android.net.Uri r11, android.net.Uri r12) {
        /*
            r8 = this;
            java.lang.String r0 = "UploadTask"
            r8.<init>()
            java.util.concurrent.atomic.AtomicLong r1 = new java.util.concurrent.atomic.AtomicLong
            r2 = 0
            r1.<init>(r2)
            r8.mBytesUploaded = r1
            r1 = 262144(0x40000, float:3.67342E-40)
            r8.mCurrentChunkSize = r1
            r2 = 0
            r8.mUploadUri = r2
            r8.mException = r2
            r8.mServerException = r2
            r3 = 0
            r8.mResultCode = r3
            com.google.android.gms.common.internal.Preconditions.checkNotNull(r9)
            com.google.android.gms.common.internal.Preconditions.checkNotNull(r11)
            com.google.firebase.storage.FirebaseStorage r3 = r9.getStorage()
            r8.mStorageRef = r9
            r8.mMetadata = r10
            com.google.firebase.auth.internal.InternalAuthProvider r9 = r3.getAuthProvider()
            r8.mAuthProvider = r9
            r8.mUri = r11
            com.google.firebase.storage.internal.ExponentialBackoffSender r9 = new com.google.firebase.storage.internal.ExponentialBackoffSender
            com.google.firebase.storage.StorageReference r10 = r8.mStorageRef
            com.google.firebase.FirebaseApp r10 = r10.getApp()
            android.content.Context r10 = r10.getApplicationContext()
            com.google.firebase.auth.internal.InternalAuthProvider r11 = r8.mAuthProvider
            long r3 = r3.getMaxUploadRetryTimeMillis()
            r9.<init>(r10, r11, r3)
            r8.mSender = r9
            r9 = -1
            com.google.firebase.storage.StorageReference r11 = r8.mStorageRef     // Catch:{ FileNotFoundException -> 0x00b6 }
            com.google.firebase.storage.FirebaseStorage r11 = r11.getStorage()     // Catch:{ FileNotFoundException -> 0x00b6 }
            com.google.firebase.FirebaseApp r11 = r11.getApp()     // Catch:{ FileNotFoundException -> 0x00b6 }
            android.content.Context r11 = r11.getApplicationContext()     // Catch:{ FileNotFoundException -> 0x00b6 }
            android.content.ContentResolver r11 = r11.getContentResolver()     // Catch:{ FileNotFoundException -> 0x00b6 }
            android.net.Uri r3 = r8.mUri     // Catch:{ NullPointerException -> 0x0090, IOException -> 0x0073 }
            java.lang.String r4 = "r"
            android.os.ParcelFileDescriptor r3 = r11.openFileDescriptor(r3, r4)     // Catch:{ NullPointerException -> 0x0090, IOException -> 0x0073 }
            if (r3 == 0) goto L_0x0097
            long r4 = r3.getStatSize()     // Catch:{ NullPointerException -> 0x0090, IOException -> 0x0073 }
            r3.close()     // Catch:{ NullPointerException -> 0x0071, IOException -> 0x006f }
            goto L_0x0098
        L_0x006f:
            r3 = move-exception
            goto L_0x0075
        L_0x0071:
            r3 = move-exception
            goto L_0x0092
        L_0x0073:
            r3 = move-exception
            r4 = r9
        L_0x0075:
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ FileNotFoundException -> 0x00b4 }
            r6.<init>()     // Catch:{ FileNotFoundException -> 0x00b4 }
            java.lang.String r7 = "could not retrieve file size for upload "
            r6.append(r7)     // Catch:{ FileNotFoundException -> 0x00b4 }
            android.net.Uri r7 = r8.mUri     // Catch:{ FileNotFoundException -> 0x00b4 }
            java.lang.String r7 = r7.toString()     // Catch:{ FileNotFoundException -> 0x00b4 }
            r6.append(r7)     // Catch:{ FileNotFoundException -> 0x00b4 }
            java.lang.String r6 = r6.toString()     // Catch:{ FileNotFoundException -> 0x00b4 }
            android.util.Log.w(r0, r6, r3)     // Catch:{ FileNotFoundException -> 0x00b4 }
            goto L_0x0098
        L_0x0090:
            r3 = move-exception
            r4 = r9
        L_0x0092:
            java.lang.String r6 = "NullPointerException during file size calculation."
            android.util.Log.w(r0, r6, r3)     // Catch:{ FileNotFoundException -> 0x00b4 }
        L_0x0097:
            r4 = r9
        L_0x0098:
            android.net.Uri r3 = r8.mUri     // Catch:{ FileNotFoundException -> 0x00b4 }
            java.io.InputStream r2 = r11.openInputStream(r3)     // Catch:{ FileNotFoundException -> 0x00b4 }
            if (r2 == 0) goto L_0x00b2
            int r11 = (r4 > r9 ? 1 : (r4 == r9 ? 0 : -1))
            if (r11 != 0) goto L_0x00ab
            int r9 = r2.available()     // Catch:{ IOException -> 0x00ab }
            if (r9 < 0) goto L_0x00ab
            long r4 = (long) r9
        L_0x00ab:
            r9 = r4
            java.io.BufferedInputStream r11 = new java.io.BufferedInputStream     // Catch:{ FileNotFoundException -> 0x00b6 }
            r11.<init>(r2)     // Catch:{ FileNotFoundException -> 0x00b6 }
            goto L_0x00d7
        L_0x00b2:
            r11 = r2
            goto L_0x00d6
        L_0x00b4:
            r9 = move-exception
            goto L_0x00b9
        L_0x00b6:
            r11 = move-exception
            r4 = r9
            r9 = r11
        L_0x00b9:
            r11 = r2
            java.lang.StringBuilder r10 = new java.lang.StringBuilder
            r10.<init>()
            java.lang.String r2 = "could not locate file for uploading:"
            r10.append(r2)
            android.net.Uri r2 = r8.mUri
            java.lang.String r2 = r2.toString()
            r10.append(r2)
            java.lang.String r10 = r10.toString()
            android.util.Log.e(r0, r10)
            r8.mException = r9
        L_0x00d6:
            r9 = r4
        L_0x00d7:
            r8.mTotalByteCount = r9
            com.google.firebase.storage.internal.AdaptiveStreamBuffer r9 = new com.google.firebase.storage.internal.AdaptiveStreamBuffer
            r9.<init>(r11, r1)
            r8.mStreamBuffer = r9
            r9 = 1
            r8.mIsStreamOwned = r9
            r8.mUploadUri = r12
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.storage.UploadTask.<init>(com.google.firebase.storage.StorageReference, com.google.firebase.storage.StorageMetadata, android.net.Uri, android.net.Uri):void");
    }

    UploadTask(StorageReference storageReference, StorageMetadata storageMetadata, InputStream inputStream) {
        this.mBytesUploaded = new AtomicLong(0);
        this.mCurrentChunkSize = 262144;
        this.mUploadUri = null;
        this.mException = null;
        this.mServerException = null;
        this.mResultCode = 0;
        Preconditions.checkNotNull(storageReference);
        Preconditions.checkNotNull(inputStream);
        FirebaseStorage storage = storageReference.getStorage();
        this.mTotalByteCount = -1;
        this.mStorageRef = storageReference;
        this.mMetadata = storageMetadata;
        this.mAuthProvider = storage.getAuthProvider();
        this.mStreamBuffer = new AdaptiveStreamBuffer(inputStream, 262144);
        this.mIsStreamOwned = false;
        this.mUri = null;
        this.mSender = new ExponentialBackoffSender(this.mStorageRef.getApp().getApplicationContext(), this.mAuthProvider, this.mStorageRef.getStorage().getMaxUploadRetryTimeMillis());
    }

    /* access modifiers changed from: package-private */
    public StorageReference getStorage() {
        return this.mStorageRef;
    }

    /* access modifiers changed from: package-private */
    public long getTotalByteCount() {
        return this.mTotalByteCount;
    }

    /* access modifiers changed from: protected */
    public void schedule() {
        StorageTaskScheduler.getInstance().scheduleUpload(getRunnable());
    }

    /* access modifiers changed from: package-private */
    public void run() {
        this.mSender.reset();
        if (!tryChangeState(4, false)) {
            Log.d(TAG, "The upload cannot continue as it is not in a valid state.");
            return;
        }
        if (this.mStorageRef.getParent() == null) {
            this.mException = new IllegalArgumentException("Cannot upload to getRoot. You should upload to a storage location such as .getReference('image.png').putFile...");
        }
        if (this.mException == null) {
            if (this.mUploadUri == null) {
                beginResumableUpload();
            } else {
                recoverStatus(false);
            }
            boolean shouldContinue = shouldContinue();
            while (shouldContinue) {
                uploadChunk();
                shouldContinue = shouldContinue();
                if (shouldContinue) {
                    tryChangeState(4, false);
                }
            }
            if (this.mIsStreamOwned && getInternalState() != 16) {
                try {
                    this.mStreamBuffer.close();
                } catch (IOException e) {
                    Log.e(TAG, "Unable to close stream.", e);
                }
            }
        }
    }

    /* access modifiers changed from: protected */
    public void resetState() {
        this.mException = null;
        this.mServerException = null;
        this.mResultCode = 0;
        this.mServerStatus = null;
    }

    private void beginResumableUpload() {
        JSONObject jSONObject = null;
        String contentType = this.mMetadata != null ? this.mMetadata.getContentType() : null;
        if (this.mUri != null && TextUtils.isEmpty(contentType)) {
            contentType = this.mStorageRef.getStorage().getApp().getApplicationContext().getContentResolver().getType(this.mUri);
        }
        if (TextUtils.isEmpty(contentType)) {
            contentType = APPLICATION_OCTET_STREAM;
        }
        try {
            Uri storageUri = this.mStorageRef.getStorageUri();
            FirebaseApp app = this.mStorageRef.getApp();
            if (this.mMetadata != null) {
                jSONObject = this.mMetadata.createJSONObject();
            }
            ResumableUploadStartRequest resumableUploadStartRequest = new ResumableUploadStartRequest(storageUri, app, jSONObject, contentType);
            if (sendWithRetry(resumableUploadStartRequest)) {
                String resultString = resumableUploadStartRequest.getResultString(X_GOOG_UPLOAD_URL);
                if (!TextUtils.isEmpty(resultString)) {
                    this.mUploadUri = Uri.parse(resultString);
                }
            }
        } catch (JSONException e) {
            Log.e(TAG, "Unable to create a network request from metadata", e);
            this.mException = e;
        }
    }

    private boolean shouldContinue() {
        if (getInternalState() == 128) {
            return false;
        }
        if (Thread.interrupted()) {
            this.mException = new InterruptedException();
            tryChangeState(64, false);
            return false;
        } else if (getInternalState() == 32) {
            tryChangeState(256, false);
            return false;
        } else if (getInternalState() == 8) {
            tryChangeState(16, false);
            return false;
        } else if (!serverStateValid()) {
            return false;
        } else {
            if (this.mUploadUri == null) {
                if (this.mException == null) {
                    this.mException = new IllegalStateException("Unable to obtain an upload URL.");
                }
                tryChangeState(64, false);
                return false;
            } else if (this.mException != null) {
                tryChangeState(64, false);
                return false;
            } else {
                if (!(this.mServerException != null || this.mResultCode < 200 || this.mResultCode >= 300) || recoverStatus(true)) {
                    return true;
                }
                if (serverStateValid()) {
                    tryChangeState(64, false);
                }
                return false;
            }
        }
    }

    private boolean serverStateValid() {
        if (!RESUMABLE_FINAL_STATUS.equals(this.mServerStatus)) {
            return true;
        }
        if (this.mException == null) {
            this.mException = new IOException("The server has terminated the upload session", this.mServerException);
        }
        tryChangeState(64, false);
        return false;
    }

    private boolean recoverStatus(boolean z) {
        ResumableUploadQueryRequest resumableUploadQueryRequest = new ResumableUploadQueryRequest(this.mStorageRef.getStorageUri(), this.mStorageRef.getApp(), this.mUploadUri.toString());
        if (RESUMABLE_FINAL_STATUS.equals(this.mServerStatus)) {
            return false;
        }
        if (z) {
            if (!sendWithRetry(resumableUploadQueryRequest)) {
                return false;
            }
        } else if (!send(resumableUploadQueryRequest)) {
            return false;
        }
        if (RESUMABLE_FINAL_STATUS.equals(resumableUploadQueryRequest.getResultString("X-Goog-Upload-Status"))) {
            this.mException = new IOException("The server has terminated the upload session");
            return false;
        }
        String resultString = resumableUploadQueryRequest.getResultString("X-Goog-Upload-Size-Received");
        long parseLong = !TextUtils.isEmpty(resultString) ? Long.parseLong(resultString) : 0;
        long j = this.mBytesUploaded.get();
        if (j > parseLong) {
            this.mException = new IOException("Unexpected error. The server lost a chunk update.");
            return false;
        } else if (j >= parseLong) {
            return true;
        } else {
            try {
                long j2 = parseLong - j;
                if (((long) this.mStreamBuffer.advance((int) j2)) != j2) {
                    this.mException = new IOException("Unexpected end of stream encountered.");
                    return false;
                } else if (this.mBytesUploaded.compareAndSet(j, parseLong)) {
                    return true;
                } else {
                    Log.e(TAG, "Somehow, the uploaded bytes changed during an uploaded.  This should nothappen");
                    this.mException = new IllegalStateException("uploaded bytes changed unexpectedly.");
                    return false;
                }
            } catch (IOException e) {
                Log.e(TAG, "Unable to recover position in Stream during resumable upload", e);
                this.mException = e;
                return false;
            }
        }
    }

    private void uploadChunk() {
        try {
            this.mStreamBuffer.fill(this.mCurrentChunkSize);
            int min = Math.min(this.mCurrentChunkSize, this.mStreamBuffer.available());
            ResumableUploadByteRequest resumableUploadByteRequest = new ResumableUploadByteRequest(this.mStorageRef.getStorageUri(), this.mStorageRef.getApp(), this.mUploadUri.toString(), this.mStreamBuffer.get(), this.mBytesUploaded.get(), min, this.mStreamBuffer.isFinished());
            if (!send(resumableUploadByteRequest)) {
                this.mCurrentChunkSize = 262144;
                Log.d(TAG, "Resetting chunk size to " + this.mCurrentChunkSize);
                return;
            }
            this.mBytesUploaded.getAndAdd((long) min);
            if (!this.mStreamBuffer.isFinished()) {
                this.mStreamBuffer.advance(min);
                if (this.mCurrentChunkSize < MAXIMUM_CHUNK_SIZE) {
                    this.mCurrentChunkSize *= 2;
                    Log.d(TAG, "Increasing chunk size to " + this.mCurrentChunkSize);
                    return;
                }
                return;
            }
            try {
                this.mMetadata = new StorageMetadata.Builder(resumableUploadByteRequest.getResultBody(), this.mStorageRef).build();
                tryChangeState(4, false);
                tryChangeState(128, false);
            } catch (JSONException e) {
                Log.e(TAG, "Unable to parse resulting metadata from upload:" + resumableUploadByteRequest.getRawResult(), e);
                this.mException = e;
            }
        } catch (IOException e2) {
            Log.e(TAG, "Unable to read bytes for uploading", e2);
            this.mException = e2;
        }
    }

    private boolean send(NetworkRequest networkRequest) {
        networkRequest.performRequest(Util.getCurrentAuthToken(this.mAuthProvider), this.mStorageRef.getApp().getApplicationContext());
        return processResultValid(networkRequest);
    }

    private boolean sendWithRetry(NetworkRequest networkRequest) {
        this.mSender.sendWithExponentialBackoff(networkRequest);
        return processResultValid(networkRequest);
    }

    private boolean processResultValid(NetworkRequest networkRequest) {
        int resultCode = networkRequest.getResultCode();
        if (this.mSender.isRetryableError(resultCode)) {
            resultCode = -2;
        }
        this.mResultCode = resultCode;
        this.mServerException = networkRequest.getException();
        this.mServerStatus = networkRequest.getResultString("X-Goog-Upload-Status");
        return isValidHttpResponseCode(this.mResultCode) && this.mServerException == null;
    }

    /* access modifiers changed from: protected */
    public void onCanceled() {
        this.mSender.cancel();
        final ResumableUploadCancelRequest resumableUploadCancelRequest = this.mUploadUri != null ? new ResumableUploadCancelRequest(this.mStorageRef.getStorageUri(), this.mStorageRef.getApp(), this.mUploadUri.toString()) : null;
        if (resumableUploadCancelRequest != null) {
            StorageTaskScheduler.getInstance().scheduleCommand(new Runnable() {
                public void run() {
                    resumableUploadCancelRequest.performRequest(Util.getCurrentAuthToken(UploadTask.this.mAuthProvider), UploadTask.this.mStorageRef.getApp().getApplicationContext());
                }
            });
        }
        this.mException = StorageException.fromErrorStatus(Status.RESULT_CANCELED);
        super.onCanceled();
    }

    /* access modifiers changed from: package-private */
    @NonNull
    public TaskSnapshot snapStateImpl() {
        return new TaskSnapshot(StorageException.fromExceptionAndHttpCode(this.mException != null ? this.mException : this.mServerException, this.mResultCode), this.mBytesUploaded.get(), this.mUploadUri, this.mMetadata);
    }

    @PublicApi
    /* compiled from: com.google.firebase:firebase-storage@@18.1.1 */
    public class TaskSnapshot extends StorageTask<TaskSnapshot>.SnapshotBase {
        private final long mBytesUploaded;
        private final StorageMetadata mMetadata;
        private final Uri mUploadUri;

        TaskSnapshot(Exception exc, long j, Uri uri, StorageMetadata storageMetadata) {
            super(exc);
            this.mBytesUploaded = j;
            this.mUploadUri = uri;
            this.mMetadata = storageMetadata;
        }

        @PublicApi
        public long getBytesTransferred() {
            return this.mBytesUploaded;
        }

        @PublicApi
        public long getTotalByteCount() {
            return UploadTask.this.getTotalByteCount();
        }

        @PublicApi
        @Nullable
        public Uri getUploadSessionUri() {
            return this.mUploadUri;
        }

        @PublicApi
        @Nullable
        public StorageMetadata getMetadata() {
            return this.mMetadata;
        }
    }
}
