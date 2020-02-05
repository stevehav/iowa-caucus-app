package io.invertase.firebase.storage;

import android.net.Uri;
import android.util.Log;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.WritableMap;
import com.google.android.gms.tasks.OnCanceledListener;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.storage.OnPausedListener;
import com.google.firebase.storage.OnProgressListener;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.StorageTask;
import com.google.firebase.storage.UploadTask;
import io.invertase.firebase.common.ReactNativeFirebaseEventEmitter;
import io.invertase.firebase.common.SharedUtils;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import javax.annotation.Nullable;

class ReactNativeFirebaseStorageUploadTask extends ReactNativeFirebaseStorageTask {
    private static final String TAG = "RNFBStorageUpload";
    private UploadTask uploadTask;

    ReactNativeFirebaseStorageUploadTask(int i, StorageReference storageReference, String str) {
        super(i, storageReference, str);
    }

    private static WritableMap buildUploadSnapshotMap(@Nullable UploadTask.TaskSnapshot taskSnapshot) {
        WritableMap createMap = Arguments.createMap();
        if (taskSnapshot != null) {
            createMap.putDouble("totalBytes", (double) taskSnapshot.getTotalByteCount());
            createMap.putDouble("bytesTransferred", (double) taskSnapshot.getBytesTransferred());
            createMap.putString("state", ReactNativeFirebaseStorageCommon.getTaskStatus(taskSnapshot.getTask()));
            createMap.putMap("metadata", ReactNativeFirebaseStorageCommon.getMetadataAsMap(taskSnapshot.getMetadata()));
        } else {
            createMap.putDouble("totalBytes", 0.0d);
            createMap.putDouble("bytesTransferred", 0.0d);
            createMap.putString("state", ReactNativeFirebaseStorageCommon.getTaskStatus((StorageTask<?>) null));
            createMap.putMap("metadata", Arguments.createMap());
        }
        return createMap;
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0028  */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x0033  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private byte[] uploadStringToByteArray(java.lang.String r5, java.lang.String r6) {
        /*
            r4 = this;
            int r0 = r6.hashCode()
            r1 = -1856179776(0xffffffff915cf1c0, float:-1.7429435E-28)
            r2 = 0
            r3 = 1
            if (r0 == r1) goto L_0x001b
            r1 = -1396204209(0xffffffffacc79d4f, float:-5.673385E-12)
            if (r0 == r1) goto L_0x0011
            goto L_0x0025
        L_0x0011:
            java.lang.String r0 = "base64"
            boolean r6 = r6.equals(r0)
            if (r6 == 0) goto L_0x0025
            r6 = 0
            goto L_0x0026
        L_0x001b:
            java.lang.String r0 = "base64url"
            boolean r6 = r6.equals(r0)
            if (r6 == 0) goto L_0x0025
            r6 = 1
            goto L_0x0026
        L_0x0025:
            r6 = -1
        L_0x0026:
            if (r6 == 0) goto L_0x0033
            if (r6 == r3) goto L_0x002c
            r5 = 0
            goto L_0x0037
        L_0x002c:
            r6 = 8
            byte[] r5 = android.util.Base64.decode(r5, r6)
            goto L_0x0037
        L_0x0033:
            byte[] r5 = android.util.Base64.decode(r5, r2)
        L_0x0037:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: io.invertase.firebase.storage.ReactNativeFirebaseStorageUploadTask.uploadStringToByteArray(java.lang.String, java.lang.String):byte[]");
    }

    private void addEventListeners(ExecutorService executorService) {
        this.uploadTask.addOnProgressListener((Executor) executorService, (OnProgressListener) new OnProgressListener() {
            public final void onProgress(Object obj) {
                ReactNativeFirebaseStorageUploadTask.this.lambda$addEventListeners$0$ReactNativeFirebaseStorageUploadTask((UploadTask.TaskSnapshot) obj);
            }
        });
        this.uploadTask.addOnCanceledListener((Executor) executorService, (OnCanceledListener) new OnCanceledListener() {
            public final void onCanceled() {
                ReactNativeFirebaseStorageUploadTask.this.lambda$addEventListeners$1$ReactNativeFirebaseStorageUploadTask();
            }
        });
        this.uploadTask.addOnPausedListener((Executor) executorService, (OnPausedListener) new OnPausedListener() {
            public final void onPaused(Object obj) {
                ReactNativeFirebaseStorageUploadTask.this.lambda$addEventListeners$2$ReactNativeFirebaseStorageUploadTask((UploadTask.TaskSnapshot) obj);
            }
        });
    }

    public /* synthetic */ void lambda$addEventListeners$0$ReactNativeFirebaseStorageUploadTask(UploadTask.TaskSnapshot taskSnapshot) {
        Log.d(TAG, "onProgress " + this.storageReference.toString());
        ReactNativeFirebaseEventEmitter.getSharedInstance().sendEvent(new ReactNativeFirebaseStorageEvent(buildUploadSnapshotMap(taskSnapshot), "state_changed", this.appName, this.taskId));
    }

    public /* synthetic */ void lambda$addEventListeners$1$ReactNativeFirebaseStorageUploadTask() {
        Log.d(TAG, "onCancelled " + this.storageReference.toString());
        ReactNativeFirebaseEventEmitter.getSharedInstance().sendEvent(new ReactNativeFirebaseStorageEvent(buildCancelledSnapshotMap(buildUploadSnapshotMap((UploadTask.TaskSnapshot) this.uploadTask.getSnapshot())), "state_changed", this.appName, this.taskId));
    }

    public /* synthetic */ void lambda$addEventListeners$2$ReactNativeFirebaseStorageUploadTask(UploadTask.TaskSnapshot taskSnapshot) {
        Log.d(TAG, "onPaused " + this.storageReference.toString());
        ReactNativeFirebaseEventEmitter.getSharedInstance().sendEvent(new ReactNativeFirebaseStorageEvent(buildUploadSnapshotMap(taskSnapshot), "state_changed", this.appName, this.taskId));
    }

    /* access modifiers changed from: package-private */
    public void addOnCompleteListener(ExecutorService executorService, Promise promise) {
        this.uploadTask.addOnCompleteListener((Executor) executorService, (OnCompleteListener) new OnCompleteListener(promise) {
            private final /* synthetic */ Promise f$1;

            {
                this.f$1 = r2;
            }

            public final void onComplete(Task task) {
                ReactNativeFirebaseStorageUploadTask.this.lambda$addOnCompleteListener$3$ReactNativeFirebaseStorageUploadTask(this.f$1, task);
            }
        });
    }

    public /* synthetic */ void lambda$addOnCompleteListener$3$ReactNativeFirebaseStorageUploadTask(Promise promise, Task task) {
        destroyTask();
        if (task.isSuccessful()) {
            ReactNativeFirebaseEventEmitter sharedInstance = ReactNativeFirebaseEventEmitter.getSharedInstance();
            sharedInstance.sendEvent(new ReactNativeFirebaseStorageEvent(buildUploadSnapshotMap((UploadTask.TaskSnapshot) task.getResult()), "state_changed", this.appName, this.taskId));
            sharedInstance.sendEvent(new ReactNativeFirebaseStorageEvent(buildUploadSnapshotMap((UploadTask.TaskSnapshot) task.getResult()), "upload_success", this.appName, this.taskId));
            promise.resolve(buildUploadSnapshotMap((UploadTask.TaskSnapshot) task.getResult()));
            return;
        }
        ReactNativeFirebaseEventEmitter sharedInstance2 = ReactNativeFirebaseEventEmitter.getSharedInstance();
        WritableMap buildErrorSnapshotMap = buildErrorSnapshotMap(task.getException(), buildUploadSnapshotMap((UploadTask.TaskSnapshot) this.uploadTask.getSnapshot()), true);
        if (buildErrorSnapshotMap != null) {
            sharedInstance2.sendEvent(new ReactNativeFirebaseStorageEvent(buildErrorSnapshotMap, "state_changed", this.appName, this.taskId));
        }
        sharedInstance2.sendEvent(new ReactNativeFirebaseStorageEvent(buildErrorSnapshotMap(task.getException(), buildUploadSnapshotMap((UploadTask.TaskSnapshot) this.uploadTask.getSnapshot()), false), "upload_failure", this.appName, this.taskId));
        ReactNativeFirebaseStorageCommon.promiseRejectStorageException(promise, task.getException());
    }

    /* access modifiers changed from: package-private */
    public void begin(ExecutorService executorService, String str, String str2, ReadableMap readableMap) {
        this.uploadTask = this.storageReference.putBytes(uploadStringToByteArray(str, str2), ReactNativeFirebaseStorageCommon.buildMetadataFromMap(readableMap, (Uri) null));
        setStorageTask(this.uploadTask);
        addEventListeners(executorService);
    }

    /* access modifiers changed from: package-private */
    public void begin(ExecutorService executorService, String str, ReadableMap readableMap) {
        Uri uri = SharedUtils.getUri(str);
        this.uploadTask = this.storageReference.putFile(uri, ReactNativeFirebaseStorageCommon.buildMetadataFromMap(readableMap, uri));
        setStorageTask(this.uploadTask);
        addEventListeners(executorService);
    }
}
