package com.google.firebase.storage;

import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.Preconditions;
import com.google.common.net.HttpHeaders;
import com.google.firebase.annotations.PublicApi;
import com.google.firebase.storage.internal.ExponentialBackoffSender;
import com.google.firebase.storage.network.GetNetworkRequest;
import com.google.firebase.storage.network.NetworkRequest;
import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.concurrent.Callable;

@PublicApi
/* compiled from: com.google.firebase:firebase-storage@@18.1.1 */
public class StreamDownloadTask extends StorageTask<TaskSnapshot> {
    static final long PREFERRED_CHUNK_SIZE = 262144;
    private static final String TAG = "StreamDownloadTask";
    private long bytesDownloaded;
    private long bytesDownloadedSnapped;
    private String eTagVerification;
    private volatile Exception exception = null;
    /* access modifiers changed from: private */
    public InputStream inputStream;
    private StreamProcessor processor;
    /* access modifiers changed from: private */
    public NetworkRequest request;
    private volatile int resultCode = 0;
    private ExponentialBackoffSender sender;
    private StorageReference storageRef;
    private long totalBytes = -1;

    @PublicApi
    /* compiled from: com.google.firebase:firebase-storage@@18.1.1 */
    public interface StreamProcessor {
        void doInBackground(TaskSnapshot taskSnapshot, InputStream inputStream) throws IOException;
    }

    private boolean isValidHttpResponseCode(int i) {
        return i == 308 || (i >= 200 && i < 300);
    }

    StreamDownloadTask(@NonNull StorageReference storageReference) {
        this.storageRef = storageReference;
        FirebaseStorage storage = this.storageRef.getStorage();
        this.sender = new ExponentialBackoffSender(storage.getApp().getApplicationContext(), storage.getAuthProvider(), storage.getMaxDownloadRetryTimeMillis());
    }

    /* access modifiers changed from: package-private */
    public StreamDownloadTask setStreamProcessor(@NonNull StreamProcessor streamProcessor) {
        Preconditions.checkNotNull(streamProcessor);
        Preconditions.checkState(this.processor == null);
        this.processor = streamProcessor;
        return this;
    }

    /* access modifiers changed from: package-private */
    @NonNull
    public StorageReference getStorage() {
        return this.storageRef;
    }

    /* access modifiers changed from: package-private */
    public long getTotalBytes() {
        return this.totalBytes;
    }

    /* access modifiers changed from: package-private */
    public void recordDownloadedBytes(long j) {
        this.bytesDownloaded += j;
        if (this.bytesDownloadedSnapped + 262144 > this.bytesDownloaded) {
            return;
        }
        if (getInternalState() == 4) {
            tryChangeState(4, false);
        } else {
            this.bytesDownloadedSnapped = this.bytesDownloaded;
        }
    }

    /* access modifiers changed from: protected */
    public void schedule() {
        StorageTaskScheduler.getInstance().scheduleDownload(getRunnable());
    }

    /* access modifiers changed from: private */
    public InputStream createDownloadStream() throws Exception {
        String str;
        this.sender.reset();
        NetworkRequest networkRequest = this.request;
        if (networkRequest != null) {
            networkRequest.performRequestEnd();
        }
        this.request = new GetNetworkRequest(this.storageRef.getStorageUri(), this.storageRef.getApp(), this.bytesDownloaded);
        boolean z = false;
        this.sender.sendWithExponentialBackoff(this.request, false);
        this.resultCode = this.request.getResultCode();
        this.exception = this.request.getException() != null ? this.request.getException() : this.exception;
        if (isValidHttpResponseCode(this.resultCode) && this.exception == null && getInternalState() == 4) {
            z = true;
        }
        if (z) {
            String resultString = this.request.getResultString(HttpHeaders.ETAG);
            if (TextUtils.isEmpty(resultString) || (str = this.eTagVerification) == null || str.equals(resultString)) {
                this.eTagVerification = resultString;
                if (this.totalBytes == -1) {
                    this.totalBytes = (long) this.request.getResultingContentLength();
                }
                return this.request.getStream();
            }
            this.resultCode = 409;
            throw new IOException("The ETag on the server changed.");
        }
        throw new IOException("Could not open resulting stream.");
    }

    /* access modifiers changed from: package-private */
    public void run() {
        int i = 64;
        if (this.exception != null) {
            tryChangeState(64, false);
        } else if (tryChangeState(4, false)) {
            StreamProgressWrapper streamProgressWrapper = new StreamProgressWrapper(new Callable<InputStream>() {
                public InputStream call() throws Exception {
                    return StreamDownloadTask.this.createDownloadStream();
                }
            }, this);
            this.inputStream = new BufferedInputStream(streamProgressWrapper);
            try {
                boolean unused = streamProgressWrapper.ensureStream();
                if (this.processor != null) {
                    try {
                        this.processor.doInBackground((TaskSnapshot) snapState(), this.inputStream);
                    } catch (Exception e) {
                        Log.w(TAG, "Exception occurred calling doInBackground.", e);
                        this.exception = e;
                    }
                }
            } catch (IOException e2) {
                Log.d(TAG, "Initial opening of Stream failed", e2);
                this.exception = e2;
            }
            if (this.inputStream == null) {
                this.request.performRequestEnd();
                this.request = null;
            }
            if (this.exception == null && getInternalState() == 4) {
                tryChangeState(4, false);
                tryChangeState(128, false);
                return;
            }
            if (getInternalState() == 32) {
                i = 256;
            }
            if (!tryChangeState(i, false)) {
                Log.w(TAG, "Unable to change download task to final state from " + getInternalState());
            }
        }
    }

    public boolean resume() {
        throw new UnsupportedOperationException("this operation is not supported on StreamDownloadTask.");
    }

    public boolean pause() {
        throw new UnsupportedOperationException("this operation is not supported on StreamDownloadTask.");
    }

    /* access modifiers changed from: package-private */
    @NonNull
    public TaskSnapshot snapStateImpl() {
        return new TaskSnapshot(StorageException.fromExceptionAndHttpCode(this.exception, this.resultCode), this.bytesDownloadedSnapped);
    }

    /* access modifiers changed from: protected */
    public void onCanceled() {
        this.sender.cancel();
        this.exception = StorageException.fromErrorStatus(Status.RESULT_CANCELED);
    }

    /* access modifiers changed from: protected */
    public void onProgress() {
        this.bytesDownloadedSnapped = this.bytesDownloaded;
    }

    /* compiled from: com.google.firebase:firebase-storage@@18.1.1 */
    static class StreamProgressWrapper extends InputStream {
        private long mDownloadedBytes;
        private Callable<InputStream> mInputStreamCallable;
        private long mLastExceptionPosition;
        @Nullable
        private StreamDownloadTask mParentTask;
        private boolean mStreamClosed;
        private IOException mTemporaryException;
        @Nullable
        private InputStream mWrappedStream;

        @PublicApi
        public void mark(int i) {
        }

        @PublicApi
        public boolean markSupported() {
            return false;
        }

        StreamProgressWrapper(@NonNull Callable<InputStream> callable, @Nullable StreamDownloadTask streamDownloadTask) {
            this.mParentTask = streamDownloadTask;
            this.mInputStreamCallable = callable;
        }

        private void checkCancel() throws IOException {
            StreamDownloadTask streamDownloadTask = this.mParentTask;
            if (streamDownloadTask != null && streamDownloadTask.getInternalState() == 32) {
                throw new CancelException();
            }
        }

        private void recordDownloadedBytes(long j) {
            StreamDownloadTask streamDownloadTask = this.mParentTask;
            if (streamDownloadTask != null) {
                streamDownloadTask.recordDownloadedBytes(j);
            }
            this.mDownloadedBytes += j;
        }

        /* access modifiers changed from: private */
        public boolean ensureStream() throws IOException {
            checkCancel();
            if (this.mTemporaryException != null) {
                try {
                    if (this.mWrappedStream != null) {
                        this.mWrappedStream.close();
                    }
                } catch (IOException unused) {
                }
                this.mWrappedStream = null;
                if (this.mLastExceptionPosition == this.mDownloadedBytes) {
                    Log.i(StreamDownloadTask.TAG, "Encountered exception during stream operation. Aborting.", this.mTemporaryException);
                    return false;
                }
                Log.i(StreamDownloadTask.TAG, "Encountered exception during stream operation. Retrying at " + this.mDownloadedBytes, this.mTemporaryException);
                this.mLastExceptionPosition = this.mDownloadedBytes;
                this.mTemporaryException = null;
            }
            if (this.mStreamClosed) {
                throw new IOException("Can't perform operation on closed stream");
            } else if (this.mWrappedStream != null) {
                return true;
            } else {
                try {
                    this.mWrappedStream = this.mInputStreamCallable.call();
                    return true;
                } catch (Exception e) {
                    if (e instanceof IOException) {
                        throw ((IOException) e);
                    }
                    throw new IOException("Unable to open stream", e);
                }
            }
        }

        @PublicApi
        public int read() throws IOException {
            while (ensureStream()) {
                try {
                    int read = this.mWrappedStream.read();
                    if (read != -1) {
                        recordDownloadedBytes(1);
                    }
                    return read;
                } catch (IOException e) {
                    this.mTemporaryException = e;
                }
            }
            throw this.mTemporaryException;
        }

        @PublicApi
        public int available() throws IOException {
            while (ensureStream()) {
                try {
                    return this.mWrappedStream.available();
                } catch (IOException e) {
                    this.mTemporaryException = e;
                }
            }
            throw this.mTemporaryException;
        }

        @PublicApi
        public void close() throws IOException {
            InputStream inputStream = this.mWrappedStream;
            if (inputStream != null) {
                inputStream.close();
            }
            this.mStreamClosed = true;
            StreamDownloadTask streamDownloadTask = this.mParentTask;
            if (!(streamDownloadTask == null || streamDownloadTask.request == null)) {
                this.mParentTask.request.performRequestEnd();
                NetworkRequest unused = this.mParentTask.request = null;
            }
            checkCancel();
        }

        @PublicApi
        public int read(@NonNull byte[] bArr, int i, int i2) throws IOException {
            int i3 = 0;
            while (ensureStream()) {
                while (((long) i2) > 262144) {
                    try {
                        int read = this.mWrappedStream.read(bArr, i, 262144);
                        if (read != -1) {
                            i3 += read;
                            i += read;
                            i2 -= read;
                            recordDownloadedBytes((long) read);
                            checkCancel();
                        } else if (i3 == 0) {
                            return -1;
                        } else {
                            return i3;
                        }
                    } catch (IOException e) {
                        this.mTemporaryException = e;
                    }
                }
                if (i2 > 0) {
                    int read2 = this.mWrappedStream.read(bArr, i, i2);
                    if (read2 != -1) {
                        i += read2;
                        i3 += read2;
                        i2 -= read2;
                        recordDownloadedBytes((long) read2);
                    } else if (i3 == 0) {
                        return -1;
                    } else {
                        return i3;
                    }
                }
                if (i2 == 0) {
                    return i3;
                }
            }
            throw this.mTemporaryException;
        }

        @PublicApi
        public long skip(long j) throws IOException {
            long j2 = j;
            long j3 = 0;
            while (ensureStream()) {
                while (j2 > 262144) {
                    try {
                        long skip = this.mWrappedStream.skip(262144);
                        if (skip >= 0) {
                            j3 += skip;
                            j2 -= skip;
                            recordDownloadedBytes(skip);
                            checkCancel();
                        } else if (j3 == 0) {
                            return -1;
                        } else {
                            return j3;
                        }
                    } catch (IOException e) {
                        this.mTemporaryException = e;
                    }
                }
                if (j2 > 0) {
                    long skip2 = this.mWrappedStream.skip(j2);
                    if (skip2 >= 0) {
                        j3 += skip2;
                        j2 -= skip2;
                        recordDownloadedBytes(skip2);
                    } else if (j3 == 0) {
                        return -1;
                    } else {
                        return j3;
                    }
                }
                if (j2 == 0) {
                    return j3;
                }
            }
            throw this.mTemporaryException;
        }
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
            return StreamDownloadTask.this.getTotalBytes();
        }

        @PublicApi
        public InputStream getStream() {
            return StreamDownloadTask.this.inputStream;
        }
    }
}
