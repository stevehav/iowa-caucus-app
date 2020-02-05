package com.google.firebase.storage;

import android.net.Uri;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import com.google.android.gms.common.api.Status;
import com.google.common.net.HttpHeaders;
import com.google.firebase.annotations.PublicApi;
import com.google.firebase.storage.internal.ExponentialBackoffSender;
import com.google.firebase.storage.network.GetNetworkRequest;
import com.google.firebase.storage.network.NetworkRequest;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

@PublicApi
/* compiled from: com.google.firebase:firebase-storage@@18.1.1 */
public class FileDownloadTask extends StorageTask<TaskSnapshot> {
    static final int PREFERRED_CHUNK_SIZE = 262144;
    private static final String TAG = "FileDownloadTask";
    private long mBytesDownloaded;
    private final Uri mDestinationFile;
    private String mETagVerification = null;
    private volatile Exception mException = null;
    private int mResultCode;
    private long mResumeOffset = 0;
    private ExponentialBackoffSender mSender;
    private StorageReference mStorageRef;
    private long mTotalBytes = -1;

    private boolean isValidHttpResponseCode(int i) {
        return i == 308 || (i >= 200 && i < 300);
    }

    FileDownloadTask(@NonNull StorageReference storageReference, @NonNull Uri uri) {
        this.mStorageRef = storageReference;
        this.mDestinationFile = uri;
        FirebaseStorage storage = this.mStorageRef.getStorage();
        this.mSender = new ExponentialBackoffSender(storage.getApp().getApplicationContext(), storage.getAuthProvider(), storage.getMaxDownloadRetryTimeMillis());
    }

    /* access modifiers changed from: package-private */
    public long getDownloadedSizeInBytes() {
        return this.mBytesDownloaded;
    }

    /* access modifiers changed from: package-private */
    public long getTotalBytes() {
        return this.mTotalBytes;
    }

    /* access modifiers changed from: package-private */
    @NonNull
    public StorageReference getStorage() {
        return this.mStorageRef;
    }

    /* access modifiers changed from: protected */
    public void schedule() {
        StorageTaskScheduler.getInstance().scheduleDownload(getRunnable());
    }

    /* access modifiers changed from: package-private */
    @NonNull
    public TaskSnapshot snapStateImpl() {
        return new TaskSnapshot(StorageException.fromExceptionAndHttpCode(this.mException, this.mResultCode), this.mBytesDownloaded + this.mResumeOffset);
    }

    private int fillBuffer(InputStream inputStream, byte[] bArr) {
        int read;
        int i = 0;
        boolean z = false;
        while (i != bArr.length && (read = inputStream.read(bArr, i, bArr.length - i)) != -1) {
            try {
                z = true;
                i += read;
            } catch (IOException e) {
                this.mException = e;
            }
        }
        if (z) {
            return i;
        }
        return -1;
    }

    /* JADX INFO: finally extract failed */
    private boolean processResponse(NetworkRequest networkRequest) throws IOException {
        FileOutputStream fileOutputStream;
        InputStream stream = networkRequest.getStream();
        if (stream != null) {
            File file = new File(this.mDestinationFile.getPath());
            if (!file.exists()) {
                if (this.mResumeOffset > 0) {
                    Log.e(TAG, "The file downloading to has been deleted:" + file.getAbsolutePath());
                    throw new IllegalStateException("expected a file to resume from.");
                } else if (!file.createNewFile()) {
                    Log.w(TAG, "unable to create file:" + file.getAbsolutePath());
                }
            }
            boolean z = true;
            if (this.mResumeOffset > 0) {
                Log.d(TAG, "Resuming download file " + file.getAbsolutePath() + " at " + this.mResumeOffset);
                fileOutputStream = new FileOutputStream(file, true);
            } else {
                fileOutputStream = new FileOutputStream(file);
            }
            try {
                byte[] bArr = new byte[262144];
                while (z) {
                    int fillBuffer = fillBuffer(stream, bArr);
                    if (fillBuffer == -1) {
                        break;
                    }
                    fileOutputStream.write(bArr, 0, fillBuffer);
                    this.mBytesDownloaded += (long) fillBuffer;
                    if (this.mException != null) {
                        Log.d(TAG, "Exception occurred during file download. Retrying.", this.mException);
                        this.mException = null;
                        z = false;
                    }
                    if (!tryChangeState(4, false)) {
                        z = false;
                    }
                }
                fileOutputStream.flush();
                fileOutputStream.close();
                stream.close();
                return z;
            } catch (Throwable th) {
                fileOutputStream.flush();
                fileOutputStream.close();
                stream.close();
                throw th;
            }
        } else {
            this.mException = new IllegalStateException("Unable to open Firebase Storage stream.");
            return false;
        }
    }

    /* access modifiers changed from: package-private */
    public void run() {
        String str;
        if (this.mException != null) {
            tryChangeState(64, false);
        } else if (tryChangeState(4, false)) {
            do {
                this.mBytesDownloaded = 0;
                this.mException = null;
                this.mSender.reset();
                GetNetworkRequest getNetworkRequest = new GetNetworkRequest(this.mStorageRef.getStorageUri(), this.mStorageRef.getApp(), this.mResumeOffset);
                this.mSender.sendWithExponentialBackoff(getNetworkRequest, false);
                this.mResultCode = getNetworkRequest.getResultCode();
                this.mException = getNetworkRequest.getException() != null ? getNetworkRequest.getException() : this.mException;
                boolean z = true;
                boolean z2 = isValidHttpResponseCode(this.mResultCode) && this.mException == null && getInternalState() == 4;
                if (z2) {
                    this.mTotalBytes = (long) getNetworkRequest.getResultingContentLength();
                    String resultString = getNetworkRequest.getResultString(HttpHeaders.ETAG);
                    if (TextUtils.isEmpty(resultString) || (str = this.mETagVerification) == null || str.equals(resultString)) {
                        this.mETagVerification = resultString;
                        try {
                            z2 = processResponse(getNetworkRequest);
                        } catch (IOException e) {
                            Log.e(TAG, "Exception occurred during file write.  Aborting.", e);
                            this.mException = e;
                        }
                    } else {
                        Log.w(TAG, "The file at the server has changed.  Restarting from the beginning.");
                        this.mResumeOffset = 0;
                        this.mETagVerification = null;
                        getNetworkRequest.performRequestEnd();
                        schedule();
                        return;
                    }
                }
                getNetworkRequest.performRequestEnd();
                if (!(z2 && this.mException == null && getInternalState() == 4)) {
                    z = false;
                }
                if (z) {
                    tryChangeState(128, false);
                    return;
                }
                File file = new File(this.mDestinationFile.getPath());
                if (file.exists()) {
                    this.mResumeOffset = file.length();
                } else {
                    this.mResumeOffset = 0;
                }
                if (getInternalState() == 8) {
                    tryChangeState(16, false);
                    return;
                } else if (getInternalState() == 32) {
                    if (!tryChangeState(256, false)) {
                        Log.w(TAG, "Unable to change download task to final state from " + getInternalState());
                        return;
                    }
                    return;
                }
            } while (this.mBytesDownloaded > 0);
            tryChangeState(64, false);
        }
    }

    /* access modifiers changed from: protected */
    @PublicApi
    public void onCanceled() {
        this.mSender.cancel();
        this.mException = StorageException.fromErrorStatus(Status.RESULT_CANCELED);
    }

    @PublicApi
    /* compiled from: com.google.firebase:firebase-storage@@18.1.1 */
    public class TaskSnapshot extends StorageTask<TaskSnapshot>.SnapshotBase {
        private final long mBytesDownloaded;

        TaskSnapshot(Exception exc, long j) {
            super(exc);
            this.mBytesDownloaded = j;
        }

        @PublicApi
        public long getBytesTransferred() {
            return this.mBytesDownloaded;
        }

        @PublicApi
        public long getTotalByteCount() {
            return FileDownloadTask.this.getTotalBytes();
        }
    }
}
