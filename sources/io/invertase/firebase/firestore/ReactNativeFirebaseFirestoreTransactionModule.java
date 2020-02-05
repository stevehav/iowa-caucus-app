package io.invertase.firebase.firestore;

import android.os.AsyncTask;
import android.util.SparseArray;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.WritableMap;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.SetOptions;
import com.google.firebase.firestore.Transaction;
import io.invertase.firebase.common.RCTConvertFirebase;
import io.invertase.firebase.common.ReactNativeFirebaseEventEmitter;
import io.invertase.firebase.common.ReactNativeFirebaseModule;
import io.sentry.DefaultSentryClientFactory;
import io.sentry.marshaller.json.JsonMarshaller;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;

public class ReactNativeFirebaseFirestoreTransactionModule extends ReactNativeFirebaseModule {
    private static final String SERVICE_NAME = "FirestoreTransaction";
    private SparseArray<ReactNativeFirebaseFirestoreTransactionHandler> transactionHandlers = new SparseArray<>();

    ReactNativeFirebaseFirestoreTransactionModule(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext, SERVICE_NAME);
    }

    public void onCatalystInstanceDestroy() {
        int size = this.transactionHandlers.size();
        for (int i = 0; i < size; i++) {
            ReactNativeFirebaseFirestoreTransactionHandler reactNativeFirebaseFirestoreTransactionHandler = this.transactionHandlers.get(this.transactionHandlers.keyAt(i));
            if (reactNativeFirebaseFirestoreTransactionHandler != null) {
                reactNativeFirebaseFirestoreTransactionHandler.abort();
            }
        }
        this.transactionHandlers.clear();
    }

    @ReactMethod
    public void transactionGetDocument(String str, int i, String str2, Promise promise) {
        ReactNativeFirebaseFirestoreTransactionHandler reactNativeFirebaseFirestoreTransactionHandler = this.transactionHandlers.get(i);
        if (reactNativeFirebaseFirestoreTransactionHandler == null) {
            rejectPromiseWithCodeAndMessage(promise, "internal-error", "An internal error occurred whilst attempting to find a native transaction by id.");
            return;
        }
        Tasks.call(getExecutor(), new Callable(UniversalFirebaseFirestoreCommon.getDocumentForFirestore(UniversalFirebaseFirestoreCommon.getFirestoreForApp(str), str2)) {
            private final /* synthetic */ DocumentReference f$1;

            {
                this.f$1 = r2;
            }

            public final Object call() {
                return ReactNativeFirebaseFirestoreSerialize.snapshotToWritableMap(ReactNativeFirebaseFirestoreTransactionHandler.this.getDocument(this.f$1));
            }
        }).addOnCompleteListener(new OnCompleteListener() {
            public final void onComplete(Task task) {
                ReactNativeFirebaseFirestoreTransactionModule.lambda$transactionGetDocument$1(Promise.this, task);
            }
        });
    }

    static /* synthetic */ void lambda$transactionGetDocument$1(Promise promise, Task task) {
        if (task.isSuccessful()) {
            promise.resolve(task.getResult());
        } else {
            rejectPromiseWithExceptionMap(promise, task.getException());
        }
    }

    @ReactMethod
    public void transactionDispose(String str, int i) {
        ReactNativeFirebaseFirestoreTransactionHandler reactNativeFirebaseFirestoreTransactionHandler = this.transactionHandlers.get(i);
        if (reactNativeFirebaseFirestoreTransactionHandler != null) {
            reactNativeFirebaseFirestoreTransactionHandler.abort();
            this.transactionHandlers.delete(i);
        }
    }

    @ReactMethod
    public void transactionApplyBuffer(String str, int i, ReadableArray readableArray) {
        ReactNativeFirebaseFirestoreTransactionHandler reactNativeFirebaseFirestoreTransactionHandler = this.transactionHandlers.get(i);
        if (reactNativeFirebaseFirestoreTransactionHandler != null) {
            reactNativeFirebaseFirestoreTransactionHandler.signalBufferReceived(readableArray);
        }
    }

    @ReactMethod
    public void transactionBegin(String str, int i) {
        ReactNativeFirebaseFirestoreTransactionHandler reactNativeFirebaseFirestoreTransactionHandler = new ReactNativeFirebaseFirestoreTransactionHandler(str, i);
        this.transactionHandlers.put(i, reactNativeFirebaseFirestoreTransactionHandler);
        FirebaseFirestore firestoreForApp = UniversalFirebaseFirestoreCommon.getFirestoreForApp(str);
        ReactNativeFirebaseEventEmitter sharedInstance = ReactNativeFirebaseEventEmitter.getSharedInstance();
        firestoreForApp.runTransaction(new Transaction.Function(sharedInstance, firestoreForApp) {
            private final /* synthetic */ ReactNativeFirebaseEventEmitter f$1;
            private final /* synthetic */ FirebaseFirestore f$2;

            {
                this.f$1 = r2;
                this.f$2 = r3;
            }

            public final Object apply(Transaction transaction) {
                return ReactNativeFirebaseFirestoreTransactionModule.lambda$transactionBegin$3(ReactNativeFirebaseFirestoreTransactionHandler.this, this.f$1, this.f$2, transaction);
            }
        }).addOnCompleteListener(new OnCompleteListener(sharedInstance) {
            private final /* synthetic */ ReactNativeFirebaseEventEmitter f$1;

            {
                this.f$1 = r2;
            }

            public final void onComplete(Task task) {
                ReactNativeFirebaseFirestoreTransactionModule.lambda$transactionBegin$4(ReactNativeFirebaseFirestoreTransactionHandler.this, this.f$1, task);
            }
        });
    }

    static /* synthetic */ Void lambda$transactionBegin$3(ReactNativeFirebaseFirestoreTransactionHandler reactNativeFirebaseFirestoreTransactionHandler, ReactNativeFirebaseEventEmitter reactNativeFirebaseEventEmitter, FirebaseFirestore firebaseFirestore, Transaction transaction) throws FirebaseFirestoreException {
        reactNativeFirebaseFirestoreTransactionHandler.resetState(transaction);
        AsyncTask.execute(new Runnable(reactNativeFirebaseFirestoreTransactionHandler) {
            private final /* synthetic */ ReactNativeFirebaseFirestoreTransactionHandler f$1;

            {
                this.f$1 = r2;
            }

            public final void run() {
                ReactNativeFirebaseFirestoreTransactionModule.lambda$null$2(ReactNativeFirebaseEventEmitter.this, this.f$1);
            }
        });
        reactNativeFirebaseFirestoreTransactionHandler.await();
        if (reactNativeFirebaseFirestoreTransactionHandler.aborted) {
            throw new FirebaseFirestoreException("abort", FirebaseFirestoreException.Code.ABORTED);
        } else if (!reactNativeFirebaseFirestoreTransactionHandler.timeout) {
            ReadableArray commandBuffer = reactNativeFirebaseFirestoreTransactionHandler.getCommandBuffer();
            if (commandBuffer == null) {
                return null;
            }
            int size = commandBuffer.size();
            for (int i = 0; i < size; i++) {
                ReadableMap map = commandBuffer.getMap(i);
                map.getClass();
                String string = map.getString("path");
                String string2 = map.getString("type");
                DocumentReference documentForFirestore = UniversalFirebaseFirestoreCommon.getDocumentForFirestore(firebaseFirestore, string);
                string2.getClass();
                String str = string2;
                char c = 65535;
                int hashCode = str.hashCode();
                if (hashCode != -1785516855) {
                    if (hashCode != 81986) {
                        if (hashCode == 2012838315 && str.equals("DELETE")) {
                            c = 2;
                        }
                    } else if (str.equals("SET")) {
                        c = 0;
                    }
                } else if (str.equals("UPDATE")) {
                    c = 1;
                }
                if (c == 0) {
                    Map<String, Object> parseReadableMap = ReactNativeFirebaseFirestoreSerialize.parseReadableMap(firebaseFirestore, map.getMap("data"));
                    ReadableMap map2 = map.getMap("options");
                    map2.getClass();
                    if (map2.hasKey("merge") && map2.getBoolean("merge")) {
                        transaction.set(documentForFirestore, parseReadableMap, SetOptions.merge());
                    } else if (map2.hasKey("mergeFields")) {
                        ArrayList arrayList = new ArrayList();
                        Iterator<Object> it = RCTConvertFirebase.toArrayList(map2.getArray("mergeFields")).iterator();
                        while (it.hasNext()) {
                            arrayList.add((String) it.next());
                        }
                        transaction.set(documentForFirestore, parseReadableMap, SetOptions.mergeFields((List<String>) arrayList));
                    } else {
                        transaction.set(documentForFirestore, parseReadableMap);
                    }
                } else if (c == 1) {
                    transaction.update(documentForFirestore, ReactNativeFirebaseFirestoreSerialize.parseReadableMap(firebaseFirestore, map.getMap("data")));
                } else if (c == 2) {
                    transaction.delete(documentForFirestore);
                }
            }
            return null;
        } else {
            throw new FirebaseFirestoreException(DefaultSentryClientFactory.CONNECTION_TIMEOUT_OPTION, FirebaseFirestoreException.Code.DEADLINE_EXCEEDED);
        }
    }

    static /* synthetic */ void lambda$null$2(ReactNativeFirebaseEventEmitter reactNativeFirebaseEventEmitter, ReactNativeFirebaseFirestoreTransactionHandler reactNativeFirebaseFirestoreTransactionHandler) {
        WritableMap createMap = Arguments.createMap();
        createMap.putString("type", "update");
        reactNativeFirebaseEventEmitter.sendEvent(new ReactNativeFirebaseFirestoreEvent("firestore_transaction_event", createMap, reactNativeFirebaseFirestoreTransactionHandler.getAppName(), reactNativeFirebaseFirestoreTransactionHandler.getTransactionId()));
    }

    static /* synthetic */ void lambda$transactionBegin$4(ReactNativeFirebaseFirestoreTransactionHandler reactNativeFirebaseFirestoreTransactionHandler, ReactNativeFirebaseEventEmitter reactNativeFirebaseEventEmitter, Task task) {
        if (!reactNativeFirebaseFirestoreTransactionHandler.aborted) {
            WritableMap createMap = Arguments.createMap();
            if (task.isSuccessful()) {
                createMap.putString("type", "complete");
                reactNativeFirebaseEventEmitter.sendEvent(new ReactNativeFirebaseFirestoreEvent("firestore_transaction_event", createMap, reactNativeFirebaseFirestoreTransactionHandler.getAppName(), reactNativeFirebaseFirestoreTransactionHandler.getTransactionId()));
                return;
            }
            createMap.putString("type", "error");
            Exception exception = task.getException();
            WritableMap createMap2 = Arguments.createMap();
            UniversalFirebaseFirestoreException universalFirebaseFirestoreException = new UniversalFirebaseFirestoreException((FirebaseFirestoreException) exception, exception.getCause());
            createMap2.putString("code", universalFirebaseFirestoreException.getCode());
            createMap2.putString(JsonMarshaller.MESSAGE, universalFirebaseFirestoreException.getMessage());
            createMap.putMap("error", createMap2);
            reactNativeFirebaseEventEmitter.sendEvent(new ReactNativeFirebaseFirestoreEvent("firestore_transaction_event", createMap, reactNativeFirebaseFirestoreTransactionHandler.getAppName(), reactNativeFirebaseFirestoreTransactionHandler.getTransactionId()));
        }
    }
}
