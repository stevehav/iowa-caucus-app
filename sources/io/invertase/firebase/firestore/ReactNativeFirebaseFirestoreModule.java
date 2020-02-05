package io.invertase.firebase.firestore;

import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.ReadableMap;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.FirebaseFirestore;
import io.invertase.firebase.common.RCTConvertFirebase;
import io.invertase.firebase.common.ReactNativeFirebaseModule;

public class ReactNativeFirebaseFirestoreModule extends ReactNativeFirebaseModule {
    private static final String SERVICE_NAME = "Firestore";
    private final UniversalFirebaseFirestoreModule module;

    ReactNativeFirebaseFirestoreModule(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext, SERVICE_NAME);
        this.module = new UniversalFirebaseFirestoreModule(reactApplicationContext, SERVICE_NAME);
    }

    @ReactMethod
    public void setLogLevel(String str) {
        if ("debug".equals(str) || "error".equals(str)) {
            FirebaseFirestore.setLoggingEnabled(true);
        } else {
            FirebaseFirestore.setLoggingEnabled(false);
        }
    }

    @ReactMethod
    public void disableNetwork(String str, Promise promise) {
        this.module.disableNetwork(str).addOnCompleteListener(new OnCompleteListener() {
            public final void onComplete(Task task) {
                ReactNativeFirebaseFirestoreModule.lambda$disableNetwork$0(Promise.this, task);
            }
        });
    }

    static /* synthetic */ void lambda$disableNetwork$0(Promise promise, Task task) {
        if (task.isSuccessful()) {
            promise.resolve((Object) null);
        } else {
            ReactNativeFirebaseFirestoreCommon.rejectPromiseFirestoreException(promise, task.getException());
        }
    }

    @ReactMethod
    public void enableNetwork(String str, Promise promise) {
        this.module.enableNetwork(str).addOnCompleteListener(new OnCompleteListener() {
            public final void onComplete(Task task) {
                ReactNativeFirebaseFirestoreModule.lambda$enableNetwork$1(Promise.this, task);
            }
        });
    }

    static /* synthetic */ void lambda$enableNetwork$1(Promise promise, Task task) {
        if (task.isSuccessful()) {
            promise.resolve((Object) null);
        } else {
            ReactNativeFirebaseFirestoreCommon.rejectPromiseFirestoreException(promise, task.getException());
        }
    }

    @ReactMethod
    public void settings(String str, ReadableMap readableMap, Promise promise) {
        this.module.settings(str, RCTConvertFirebase.toHashMap(readableMap)).addOnCompleteListener(new OnCompleteListener() {
            public final void onComplete(Task task) {
                ReactNativeFirebaseFirestoreModule.lambda$settings$2(Promise.this, task);
            }
        });
    }

    static /* synthetic */ void lambda$settings$2(Promise promise, Task task) {
        if (task.isSuccessful()) {
            promise.resolve((Object) null);
        } else {
            ReactNativeFirebaseFirestoreCommon.rejectPromiseFirestoreException(promise, task.getException());
        }
    }
}
