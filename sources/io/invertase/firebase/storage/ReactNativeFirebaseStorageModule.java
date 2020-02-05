package io.invertase.firebase.storage;

import android.net.Uri;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.ReadableMap;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseApp;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.ListResult;
import com.google.firebase.storage.StorageMetadata;
import com.google.firebase.storage.StorageReference;
import io.invertase.firebase.common.ReactNativeFirebaseModule;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Executor;

public class ReactNativeFirebaseStorageModule extends ReactNativeFirebaseModule {
    private static final String TAG = "Storage";

    ReactNativeFirebaseStorageModule(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext, TAG);
    }

    public void onCatalystInstanceDestroy() {
        ReactNativeFirebaseStorageTask.destroyAllTasks();
    }

    @ReactMethod
    public void delete(String str, String str2, Promise promise) {
        getReferenceFromUrl(str2, str).delete().addOnCompleteListener(new OnCompleteListener() {
            public final void onComplete(Task task) {
                ReactNativeFirebaseStorageModule.lambda$delete$0(Promise.this, task);
            }
        });
    }

    static /* synthetic */ void lambda$delete$0(Promise promise, Task task) {
        if (task.isSuccessful()) {
            promise.resolve((Object) null);
            return;
        }
        Exception exception = task.getException();
        exception.getClass();
        ReactNativeFirebaseStorageCommon.promiseRejectStorageException(promise, exception);
    }

    @ReactMethod
    public void getDownloadURL(String str, String str2, Promise promise) {
        getReferenceFromUrl(str2, str).getDownloadUrl().addOnCompleteListener(new OnCompleteListener() {
            public final void onComplete(Task task) {
                ReactNativeFirebaseStorageModule.lambda$getDownloadURL$1(Promise.this, task);
            }
        });
    }

    static /* synthetic */ void lambda$getDownloadURL$1(Promise promise, Task task) {
        if (task.isSuccessful()) {
            promise.resolve(task.getResult() != null ? ((Uri) task.getResult()).toString() : null);
        } else {
            ReactNativeFirebaseStorageCommon.promiseRejectStorageException(promise, task.getException());
        }
    }

    @ReactMethod
    public void getMetadata(String str, String str2, Promise promise) {
        getReferenceFromUrl(str2, str).getMetadata().addOnCompleteListener((Executor) getExecutor(), new OnCompleteListener() {
            public final void onComplete(Task task) {
                ReactNativeFirebaseStorageModule.lambda$getMetadata$2(Promise.this, task);
            }
        });
    }

    static /* synthetic */ void lambda$getMetadata$2(Promise promise, Task task) {
        if (task.isSuccessful()) {
            promise.resolve(ReactNativeFirebaseStorageCommon.getMetadataAsMap((StorageMetadata) task.getResult()));
        } else {
            ReactNativeFirebaseStorageCommon.promiseRejectStorageException(promise, task.getException());
        }
    }

    @ReactMethod
    public void list(String str, String str2, ReadableMap readableMap, Promise promise) {
        Task<ListResult> task;
        StorageReference referenceFromUrl = getReferenceFromUrl(str2, str);
        int i = readableMap.getInt("maxResults");
        if (readableMap.hasKey("pageToken")) {
            String string = readableMap.getString("pageToken");
            string.getClass();
            task = referenceFromUrl.list(i, string);
        } else {
            task = referenceFromUrl.list(i);
        }
        task.addOnCompleteListener((Executor) getExecutor(), (OnCompleteListener<ListResult>) new OnCompleteListener() {
            public final void onComplete(Task task) {
                ReactNativeFirebaseStorageModule.lambda$list$3(Promise.this, task);
            }
        });
    }

    static /* synthetic */ void lambda$list$3(Promise promise, Task task) {
        if (task.isSuccessful()) {
            promise.resolve(ReactNativeFirebaseStorageCommon.getListResultAsMap((ListResult) task.getResult()));
        } else {
            ReactNativeFirebaseStorageCommon.promiseRejectStorageException(promise, task.getException());
        }
    }

    @ReactMethod
    public void listAll(String str, String str2, Promise promise) {
        getReferenceFromUrl(str2, str).listAll().addOnCompleteListener((Executor) getExecutor(), new OnCompleteListener() {
            public final void onComplete(Task task) {
                ReactNativeFirebaseStorageModule.lambda$listAll$4(Promise.this, task);
            }
        });
    }

    static /* synthetic */ void lambda$listAll$4(Promise promise, Task task) {
        if (task.isSuccessful()) {
            promise.resolve(ReactNativeFirebaseStorageCommon.getListResultAsMap((ListResult) task.getResult()));
        } else {
            ReactNativeFirebaseStorageCommon.promiseRejectStorageException(promise, task.getException());
        }
    }

    @ReactMethod
    public void updateMetadata(String str, String str2, ReadableMap readableMap, Promise promise) {
        getReferenceFromUrl(str2, str).updateMetadata(ReactNativeFirebaseStorageCommon.buildMetadataFromMap(readableMap, (Uri) null)).addOnCompleteListener((Executor) getExecutor(), new OnCompleteListener() {
            public final void onComplete(Task task) {
                ReactNativeFirebaseStorageModule.lambda$updateMetadata$5(Promise.this, task);
            }
        });
    }

    static /* synthetic */ void lambda$updateMetadata$5(Promise promise, Task task) {
        if (task.isSuccessful()) {
            promise.resolve(ReactNativeFirebaseStorageCommon.getMetadataAsMap((StorageMetadata) task.getResult()));
        } else {
            ReactNativeFirebaseStorageCommon.promiseRejectStorageException(promise, task.getException());
        }
    }

    @ReactMethod
    public void setMaxDownloadRetryTime(String str, double d, Promise promise) {
        FirebaseStorage.getInstance(FirebaseApp.getInstance(str)).setMaxDownloadRetryTimeMillis((long) d);
        promise.resolve((Object) null);
    }

    @ReactMethod
    public void setMaxOperationRetryTime(String str, double d, Promise promise) {
        FirebaseStorage.getInstance(FirebaseApp.getInstance(str)).setMaxOperationRetryTimeMillis((long) d);
        promise.resolve((Object) null);
    }

    @ReactMethod
    public void setMaxUploadRetryTime(String str, double d, Promise promise) {
        FirebaseStorage.getInstance(FirebaseApp.getInstance(str)).setMaxUploadRetryTimeMillis((long) d);
        promise.resolve((Object) null);
    }

    @ReactMethod
    public void writeToFile(String str, String str2, String str3, int i, Promise promise) {
        if (!ReactNativeFirebaseStorageCommon.isExternalStorageWritable()) {
            rejectPromiseWithCodeAndMessage(promise, "invalid-device-file-path", "The specified device file path is invalid or is restricted.");
            return;
        }
        ReactNativeFirebaseStorageDownloadTask reactNativeFirebaseStorageDownloadTask = new ReactNativeFirebaseStorageDownloadTask(i, getReferenceFromUrl(str2, str), str);
        reactNativeFirebaseStorageDownloadTask.begin(getExecutor(), str3);
        reactNativeFirebaseStorageDownloadTask.addOnCompleteListener(getExecutor(), promise);
    }

    @ReactMethod
    public void putString(String str, String str2, String str3, String str4, ReadableMap readableMap, int i, Promise promise) {
        ReactNativeFirebaseStorageUploadTask reactNativeFirebaseStorageUploadTask = new ReactNativeFirebaseStorageUploadTask(i, getReferenceFromUrl(str2, str), str);
        reactNativeFirebaseStorageUploadTask.begin(getExecutor(), str3, str4, readableMap);
        reactNativeFirebaseStorageUploadTask.addOnCompleteListener(getExecutor(), promise);
    }

    @ReactMethod
    public void putFile(String str, String str2, String str3, ReadableMap readableMap, int i, Promise promise) {
        ReactNativeFirebaseStorageUploadTask reactNativeFirebaseStorageUploadTask = new ReactNativeFirebaseStorageUploadTask(i, getReferenceFromUrl(str2, str), str);
        reactNativeFirebaseStorageUploadTask.begin(getExecutor(), str3, readableMap);
        reactNativeFirebaseStorageUploadTask.addOnCompleteListener(getExecutor(), promise);
    }

    @ReactMethod
    public void setTaskStatus(String str, int i, int i2, Promise promise) {
        if (i2 == 0) {
            promise.resolve(Boolean.valueOf(ReactNativeFirebaseStorageTask.pauseTaskById(i)));
        } else if (i2 == 1) {
            promise.resolve(Boolean.valueOf(ReactNativeFirebaseStorageTask.resumeTaskById(i)));
        } else if (i2 == 2) {
            promise.resolve(Boolean.valueOf(ReactNativeFirebaseStorageTask.cancelTaskById(i)));
        }
    }

    private String getBucketFromUrl(String str) {
        return str.substring(0, str.substring(5).indexOf("/") + 5);
    }

    private StorageReference getReferenceFromUrl(String str, String str2) {
        return FirebaseStorage.getInstance(FirebaseApp.getInstance(str2), getBucketFromUrl(str)).getReferenceFromUrl(str);
    }

    public Map<String, Object> getConstants() {
        HashMap hashMap = new HashMap();
        if (FirebaseApp.getApps(getReactApplicationContext()).size() > 0) {
            FirebaseStorage instance = FirebaseStorage.getInstance();
            hashMap.put("maxDownloadRetryTime", Long.valueOf(instance.getMaxDownloadRetryTimeMillis()));
            hashMap.put("maxOperationRetryTime", Long.valueOf(instance.getMaxOperationRetryTimeMillis()));
            hashMap.put("maxUploadRetryTime", Long.valueOf(instance.getMaxUploadRetryTimeMillis()));
        }
        return hashMap;
    }
}
