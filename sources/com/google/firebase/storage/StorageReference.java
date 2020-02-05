package com.google.firebase.storage;

import android.net.Uri;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.android.gms.tasks.Tasks;
import com.google.firebase.FirebaseApp;
import com.google.firebase.annotations.PublicApi;
import com.google.firebase.storage.StreamDownloadTask;
import com.google.firebase.storage.internal.Slashes;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executor;

@PublicApi
/* compiled from: com.google.firebase:firebase-storage@@18.1.1 */
public class StorageReference implements Comparable<StorageReference> {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final String TAG = "StorageReference";
    private final FirebaseStorage mFirebaseStorage;
    private final Uri mStorageUri;

    StorageReference(@NonNull Uri uri, @NonNull FirebaseStorage firebaseStorage) {
        boolean z = true;
        Preconditions.checkArgument(uri != null, "storageUri cannot be null");
        Preconditions.checkArgument(firebaseStorage == null ? false : z, "FirebaseApp cannot be null");
        this.mStorageUri = uri;
        this.mFirebaseStorage = firebaseStorage;
    }

    @PublicApi
    @NonNull
    public StorageReference child(@NonNull String str) {
        Preconditions.checkArgument(!TextUtils.isEmpty(str), "childName cannot be null or empty");
        String normalizeSlashes = Slashes.normalizeSlashes(str);
        try {
            return new StorageReference(this.mStorageUri.buildUpon().appendEncodedPath(Slashes.preserveSlashEncode(normalizeSlashes)).build(), this.mFirebaseStorage);
        } catch (UnsupportedEncodingException e) {
            Log.e(TAG, "Unable to create a valid default Uri. " + normalizeSlashes, e);
            throw new IllegalArgumentException("childName");
        }
    }

    @PublicApi
    @Nullable
    public StorageReference getParent() {
        String path = this.mStorageUri.getPath();
        if (TextUtils.isEmpty(path)) {
            return null;
        }
        String str = "/";
        if (path.equals(str)) {
            return null;
        }
        int lastIndexOf = path.lastIndexOf(47);
        if (lastIndexOf != -1) {
            str = path.substring(0, lastIndexOf);
        }
        return new StorageReference(this.mStorageUri.buildUpon().path(str).build(), this.mFirebaseStorage);
    }

    @PublicApi
    @NonNull
    public StorageReference getRoot() {
        return new StorageReference(this.mStorageUri.buildUpon().path("").build(), this.mFirebaseStorage);
    }

    @PublicApi
    @NonNull
    public String getName() {
        String path = this.mStorageUri.getPath();
        int lastIndexOf = path.lastIndexOf(47);
        return lastIndexOf != -1 ? path.substring(lastIndexOf + 1) : path;
    }

    @PublicApi
    @NonNull
    public String getPath() {
        return this.mStorageUri.getPath();
    }

    @PublicApi
    @NonNull
    public String getBucket() {
        return this.mStorageUri.getAuthority();
    }

    @PublicApi
    @NonNull
    public FirebaseStorage getStorage() {
        return this.mFirebaseStorage;
    }

    /* access modifiers changed from: package-private */
    @NonNull
    public FirebaseApp getApp() {
        return getStorage().getApp();
    }

    @PublicApi
    @NonNull
    public UploadTask putBytes(@NonNull byte[] bArr) {
        Preconditions.checkArgument(bArr != null, "bytes cannot be null");
        UploadTask uploadTask = new UploadTask(this, (StorageMetadata) null, bArr);
        uploadTask.queue();
        return uploadTask;
    }

    @PublicApi
    @NonNull
    public UploadTask putBytes(@NonNull byte[] bArr, @NonNull StorageMetadata storageMetadata) {
        boolean z = true;
        Preconditions.checkArgument(bArr != null, "bytes cannot be null");
        if (storageMetadata == null) {
            z = false;
        }
        Preconditions.checkArgument(z, "metadata cannot be null");
        UploadTask uploadTask = new UploadTask(this, storageMetadata, bArr);
        uploadTask.queue();
        return uploadTask;
    }

    @PublicApi
    @NonNull
    public UploadTask putFile(@NonNull Uri uri) {
        Preconditions.checkArgument(uri != null, "uri cannot be null");
        UploadTask uploadTask = new UploadTask(this, (StorageMetadata) null, uri, (Uri) null);
        uploadTask.queue();
        return uploadTask;
    }

    @PublicApi
    @NonNull
    public UploadTask putFile(@NonNull Uri uri, @NonNull StorageMetadata storageMetadata) {
        boolean z = true;
        Preconditions.checkArgument(uri != null, "uri cannot be null");
        if (storageMetadata == null) {
            z = false;
        }
        Preconditions.checkArgument(z, "metadata cannot be null");
        UploadTask uploadTask = new UploadTask(this, storageMetadata, uri, (Uri) null);
        uploadTask.queue();
        return uploadTask;
    }

    @PublicApi
    @NonNull
    public UploadTask putFile(@NonNull Uri uri, @Nullable StorageMetadata storageMetadata, @Nullable Uri uri2) {
        boolean z = true;
        Preconditions.checkArgument(uri != null, "uri cannot be null");
        if (storageMetadata == null) {
            z = false;
        }
        Preconditions.checkArgument(z, "metadata cannot be null");
        UploadTask uploadTask = new UploadTask(this, storageMetadata, uri, uri2);
        uploadTask.queue();
        return uploadTask;
    }

    @PublicApi
    @NonNull
    public UploadTask putStream(@NonNull InputStream inputStream) {
        Preconditions.checkArgument(inputStream != null, "stream cannot be null");
        UploadTask uploadTask = new UploadTask(this, (StorageMetadata) null, inputStream);
        uploadTask.queue();
        return uploadTask;
    }

    @PublicApi
    @NonNull
    public UploadTask putStream(@NonNull InputStream inputStream, @NonNull StorageMetadata storageMetadata) {
        boolean z = true;
        Preconditions.checkArgument(inputStream != null, "stream cannot be null");
        if (storageMetadata == null) {
            z = false;
        }
        Preconditions.checkArgument(z, "metadata cannot be null");
        UploadTask uploadTask = new UploadTask(this, storageMetadata, inputStream);
        uploadTask.queue();
        return uploadTask;
    }

    @PublicApi
    @NonNull
    public List<UploadTask> getActiveUploadTasks() {
        return StorageTaskManager.getInstance().getUploadTasksUnder(this);
    }

    @PublicApi
    @NonNull
    public List<FileDownloadTask> getActiveDownloadTasks() {
        return StorageTaskManager.getInstance().getDownloadTasksUnder(this);
    }

    @PublicApi
    @NonNull
    public Task<StorageMetadata> getMetadata() {
        TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        StorageTaskScheduler.getInstance().scheduleCommand(new GetMetadataTask(this, taskCompletionSource));
        return taskCompletionSource.getTask();
    }

    @PublicApi
    @NonNull
    public Task<Uri> getDownloadUrl() {
        TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        StorageTaskScheduler.getInstance().scheduleCommand(new GetDownloadUrlTask(this, taskCompletionSource));
        return taskCompletionSource.getTask();
    }

    @PublicApi
    @NonNull
    public Task<StorageMetadata> updateMetadata(@NonNull StorageMetadata storageMetadata) {
        Preconditions.checkNotNull(storageMetadata);
        TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        StorageTaskScheduler.getInstance().scheduleCommand(new UpdateMetadataTask(this, taskCompletionSource, storageMetadata));
        return taskCompletionSource.getTask();
    }

    @PublicApi
    @NonNull
    public Task<byte[]> getBytes(final long j) {
        final TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        StreamDownloadTask streamDownloadTask = new StreamDownloadTask(this);
        streamDownloadTask.setStreamProcessor(new StreamDownloadTask.StreamProcessor() {
            @PublicApi
            public void doInBackground(StreamDownloadTask.TaskSnapshot taskSnapshot, InputStream inputStream) throws IOException {
                try {
                    ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                    byte[] bArr = new byte[16384];
                    int i = 0;
                    while (true) {
                        int read = inputStream.read(bArr, 0, bArr.length);
                        if (read != -1) {
                            i += read;
                            if (((long) i) <= j) {
                                byteArrayOutputStream.write(bArr, 0, read);
                            } else {
                                Log.e(StorageReference.TAG, "the maximum allowed buffer size was exceeded.");
                                throw new IndexOutOfBoundsException("the maximum allowed buffer size was exceeded.");
                            }
                        } else {
                            byteArrayOutputStream.flush();
                            taskCompletionSource.setResult(byteArrayOutputStream.toByteArray());
                            return;
                        }
                    }
                } finally {
                    inputStream.close();
                }
            }
        }).addOnSuccessListener((OnSuccessListener) new OnSuccessListener<StreamDownloadTask.TaskSnapshot>() {
            @PublicApi
            public void onSuccess(StreamDownloadTask.TaskSnapshot taskSnapshot) {
                if (!taskCompletionSource.getTask().isComplete()) {
                    Log.e(StorageReference.TAG, "getBytes 'succeeded', but failed to set a Result.");
                    taskCompletionSource.setException(StorageException.fromErrorStatus(Status.RESULT_INTERNAL_ERROR));
                }
            }
        }).addOnFailureListener((OnFailureListener) new OnFailureListener() {
            static final /* synthetic */ boolean $assertionsDisabled = false;

            static {
                Class<StorageReference> cls = StorageReference.class;
            }

            @PublicApi
            public void onFailure(@NonNull Exception exc) {
                taskCompletionSource.setException(StorageException.fromExceptionAndHttpCode(exc, 0));
            }
        });
        streamDownloadTask.queue();
        return taskCompletionSource.getTask();
    }

    @PublicApi
    @NonNull
    public FileDownloadTask getFile(@NonNull Uri uri) {
        FileDownloadTask fileDownloadTask = new FileDownloadTask(this, uri);
        fileDownloadTask.queue();
        return fileDownloadTask;
    }

    @PublicApi
    @NonNull
    public FileDownloadTask getFile(@NonNull File file) {
        return getFile(Uri.fromFile(file));
    }

    @PublicApi
    @NonNull
    public StreamDownloadTask getStream() {
        StreamDownloadTask streamDownloadTask = new StreamDownloadTask(this);
        streamDownloadTask.queue();
        return streamDownloadTask;
    }

    @PublicApi
    @NonNull
    public StreamDownloadTask getStream(@NonNull StreamDownloadTask.StreamProcessor streamProcessor) {
        StreamDownloadTask streamDownloadTask = new StreamDownloadTask(this);
        streamDownloadTask.setStreamProcessor(streamProcessor);
        streamDownloadTask.queue();
        return streamDownloadTask;
    }

    @PublicApi
    @NonNull
    public Task<Void> delete() {
        TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        StorageTaskScheduler.getInstance().scheduleCommand(new DeleteStorageTask(this, taskCompletionSource));
        return taskCompletionSource.getTask();
    }

    @PublicApi
    @NonNull
    public Task<ListResult> list(int i) {
        boolean z = true;
        Preconditions.checkArgument(i > 0, "maxResults must be greater than zero");
        if (i > 1000) {
            z = false;
        }
        Preconditions.checkArgument(z, "maxResults must be at most 1000");
        return listHelper(Integer.valueOf(i), (String) null);
    }

    @PublicApi
    @NonNull
    public Task<ListResult> list(int i, @NonNull String str) {
        boolean z = true;
        Preconditions.checkArgument(i > 0, "maxResults must be greater than zero");
        Preconditions.checkArgument(i <= 1000, "maxResults must be at most 1000");
        if (str == null) {
            z = false;
        }
        Preconditions.checkArgument(z, "pageToken must be non-null to resume a previous list() operation");
        return listHelper(Integer.valueOf(i), str);
    }

    @PublicApi
    @NonNull
    public Task<ListResult> listAll() {
        TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        final ArrayList arrayList = new ArrayList();
        final ArrayList arrayList2 = new ArrayList();
        Executor commandPoolExecutor = StorageTaskScheduler.getInstance().getCommandPoolExecutor();
        final Executor executor = commandPoolExecutor;
        final TaskCompletionSource taskCompletionSource2 = taskCompletionSource;
        listHelper((Integer) null, (String) null).continueWithTask(commandPoolExecutor, new Continuation<ListResult, Task<Void>>() {
            public Task<Void> then(@NonNull Task<ListResult> task) {
                ListResult result = task.getResult();
                arrayList.addAll(result.getPrefixes());
                arrayList2.addAll(result.getItems());
                if (result.getPageToken() != null) {
                    StorageReference.this.listHelper((Integer) null, result.getPageToken()).continueWithTask(executor, this);
                } else {
                    taskCompletionSource2.setResult(new ListResult(arrayList, arrayList2, (String) null));
                }
                return Tasks.forResult(null);
            }
        });
        return taskCompletionSource.getTask();
    }

    /* access modifiers changed from: private */
    public Task<ListResult> listHelper(@Nullable Integer num, @Nullable String str) {
        TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        StorageTaskScheduler.getInstance().scheduleCommand(new ListTask(this, num, str, taskCompletionSource));
        return taskCompletionSource.getTask();
    }

    /* access modifiers changed from: package-private */
    @NonNull
    public Uri getStorageUri() {
        return this.mStorageUri;
    }

    public String toString() {
        return "gs://" + this.mStorageUri.getAuthority() + this.mStorageUri.getEncodedPath();
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof StorageReference)) {
            return false;
        }
        return ((StorageReference) obj).toString().equals(toString());
    }

    public int hashCode() {
        return toString().hashCode();
    }

    public int compareTo(StorageReference storageReference) {
        return this.mStorageUri.compareTo(storageReference.mStorageUri);
    }
}
