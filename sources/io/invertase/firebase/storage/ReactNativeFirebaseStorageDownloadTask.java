package io.invertase.firebase.storage;

import android.util.Log;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.WritableMap;
import com.google.android.gms.tasks.OnCanceledListener;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.storage.FileDownloadTask;
import com.google.firebase.storage.OnPausedListener;
import com.google.firebase.storage.OnProgressListener;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.StorageTask;
import io.invertase.firebase.common.ReactNativeFirebaseEventEmitter;
import io.invertase.firebase.common.ReactNativeFirebaseModule;
import java.io.File;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import javax.annotation.Nullable;

class ReactNativeFirebaseStorageDownloadTask extends ReactNativeFirebaseStorageTask {
    private static final String TAG = "RNFBStorageDownload";
    private FileDownloadTask fileDownloadTask;

    ReactNativeFirebaseStorageDownloadTask(int i, StorageReference storageReference, String str) {
        super(i, storageReference, str);
    }

    private static WritableMap buildDownloadSnapshotMap(@Nullable FileDownloadTask.TaskSnapshot taskSnapshot) {
        WritableMap createMap = Arguments.createMap();
        if (taskSnapshot != null) {
            createMap.putDouble("totalBytes", (double) taskSnapshot.getTotalByteCount());
            createMap.putDouble("bytesTransferred", (double) taskSnapshot.getBytesTransferred());
            createMap.putString("state", ReactNativeFirebaseStorageCommon.getTaskStatus(taskSnapshot.getTask()));
        } else {
            createMap.putDouble("totalBytes", 0.0d);
            createMap.putDouble("bytesTransferred", 0.0d);
            createMap.putString("state", ReactNativeFirebaseStorageCommon.getTaskStatus((StorageTask<?>) null));
        }
        return createMap;
    }

    private String getPath(String str) {
        int lastIndexOf = str.lastIndexOf("/");
        if (lastIndexOf <= 0) {
            return "/";
        }
        return str.substring(0, lastIndexOf) + "/";
    }

    private String getFileName(String str) {
        int lastIndexOf = str.lastIndexOf("/");
        return lastIndexOf > 0 ? str.substring(lastIndexOf + 1) : str;
    }

    /* access modifiers changed from: package-private */
    public void addOnCompleteListener(ExecutorService executorService, Promise promise) {
        FileDownloadTask fileDownloadTask2 = this.fileDownloadTask;
        if (fileDownloadTask2 == null) {
            ReactNativeFirebaseModule.rejectPromiseWithCodeAndMessage(promise, "error-creating-directory", "Unable to create the directory specified as the download path for your file.");
        } else {
            fileDownloadTask2.addOnCompleteListener((Executor) executorService, (OnCompleteListener) new OnCompleteListener(promise) {
                private final /* synthetic */ Promise f$1;

                {
                    this.f$1 = r2;
                }

                public final void onComplete(Task task) {
                    ReactNativeFirebaseStorageDownloadTask.this.lambda$addOnCompleteListener$0$ReactNativeFirebaseStorageDownloadTask(this.f$1, task);
                }
            });
        }
    }

    public /* synthetic */ void lambda$addOnCompleteListener$0$ReactNativeFirebaseStorageDownloadTask(Promise promise, Task task) {
        destroyTask();
        if (task.isSuccessful()) {
            Log.d(TAG, "onComplete:success " + this.storageReference.toString());
            WritableMap buildDownloadSnapshotMap = buildDownloadSnapshotMap((FileDownloadTask.TaskSnapshot) task.getResult());
            ReactNativeFirebaseEventEmitter sharedInstance = ReactNativeFirebaseEventEmitter.getSharedInstance();
            sharedInstance.sendEvent(new ReactNativeFirebaseStorageEvent(buildDownloadSnapshotMap, "state_changed", this.appName, this.taskId));
            sharedInstance.sendEvent(new ReactNativeFirebaseStorageEvent(buildDownloadSnapshotMap((FileDownloadTask.TaskSnapshot) task.getResult()), "download_success", this.appName, this.taskId));
            promise.resolve(buildDownloadSnapshotMap((FileDownloadTask.TaskSnapshot) task.getResult()));
            return;
        }
        Log.d(TAG, "onComplete:failure " + this.storageReference.toString());
        ReactNativeFirebaseEventEmitter sharedInstance2 = ReactNativeFirebaseEventEmitter.getSharedInstance();
        WritableMap buildErrorSnapshotMap = buildErrorSnapshotMap(task.getException(), buildDownloadSnapshotMap((FileDownloadTask.TaskSnapshot) this.fileDownloadTask.getSnapshot()), true);
        if (buildErrorSnapshotMap != null) {
            sharedInstance2.sendEvent(new ReactNativeFirebaseStorageEvent(buildErrorSnapshotMap, "state_changed", this.appName, this.taskId));
        }
        sharedInstance2.sendEvent(new ReactNativeFirebaseStorageEvent(buildErrorSnapshotMap(task.getException(), buildDownloadSnapshotMap((FileDownloadTask.TaskSnapshot) this.fileDownloadTask.getSnapshot()), false), "download_failure", this.appName, this.taskId));
        ReactNativeFirebaseStorageCommon.promiseRejectStorageException(promise, task.getException());
    }

    private void addEventListeners(ExecutorService executorService) {
        this.fileDownloadTask.addOnProgressListener((Executor) executorService, (OnProgressListener) new OnProgressListener() {
            public final void onProgress(Object obj) {
                ReactNativeFirebaseStorageDownloadTask.this.lambda$addEventListeners$1$ReactNativeFirebaseStorageDownloadTask((FileDownloadTask.TaskSnapshot) obj);
            }
        });
        this.fileDownloadTask.addOnCanceledListener((Executor) executorService, (OnCanceledListener) new OnCanceledListener() {
            public final void onCanceled() {
                ReactNativeFirebaseStorageDownloadTask.this.lambda$addEventListeners$2$ReactNativeFirebaseStorageDownloadTask();
            }
        });
        this.fileDownloadTask.addOnPausedListener((Executor) executorService, (OnPausedListener) new OnPausedListener() {
            public final void onPaused(Object obj) {
                ReactNativeFirebaseStorageDownloadTask.this.lambda$addEventListeners$3$ReactNativeFirebaseStorageDownloadTask((FileDownloadTask.TaskSnapshot) obj);
            }
        });
    }

    public /* synthetic */ void lambda$addEventListeners$1$ReactNativeFirebaseStorageDownloadTask(FileDownloadTask.TaskSnapshot taskSnapshot) {
        Log.d(TAG, "onProgress " + this.storageReference.toString());
        ReactNativeFirebaseEventEmitter.getSharedInstance().sendEvent(new ReactNativeFirebaseStorageEvent(buildDownloadSnapshotMap(taskSnapshot), "state_changed", this.appName, this.taskId));
    }

    public /* synthetic */ void lambda$addEventListeners$2$ReactNativeFirebaseStorageDownloadTask() {
        Log.d(TAG, "onCancelled " + this.storageReference.toString());
        ReactNativeFirebaseEventEmitter.getSharedInstance().sendEvent(new ReactNativeFirebaseStorageEvent(buildCancelledSnapshotMap(buildDownloadSnapshotMap((FileDownloadTask.TaskSnapshot) this.fileDownloadTask.getSnapshot())), "state_changed", this.appName, this.taskId));
    }

    public /* synthetic */ void lambda$addEventListeners$3$ReactNativeFirebaseStorageDownloadTask(FileDownloadTask.TaskSnapshot taskSnapshot) {
        Log.d(TAG, "onPaused " + this.storageReference.toString());
        ReactNativeFirebaseEventEmitter.getSharedInstance().sendEvent(new ReactNativeFirebaseStorageEvent(buildDownloadSnapshotMap(taskSnapshot), "state_changed", this.appName, this.taskId));
    }

    /* access modifiers changed from: package-private */
    public void begin(ExecutorService executorService, String str) {
        String path = getPath(str);
        File file = new File(path);
        if (!file.exists() ? file.mkdirs() : true) {
            this.fileDownloadTask = this.storageReference.getFile(new File(path, getFileName(str)));
            addEventListeners(executorService);
            setStorageTask(this.fileDownloadTask);
        }
    }
}
