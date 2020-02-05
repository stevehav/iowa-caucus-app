package io.invertase.firebase.firestore;

import com.facebook.react.bridge.Promise;
import com.google.firebase.firestore.FirebaseFirestoreException;
import io.invertase.firebase.common.ReactNativeFirebaseModule;

class ReactNativeFirebaseFirestoreCommon {
    ReactNativeFirebaseFirestoreCommon() {
    }

    static void rejectPromiseFirestoreException(Promise promise, Exception exc) {
        if (exc instanceof FirebaseFirestoreException) {
            UniversalFirebaseFirestoreException universalFirebaseFirestoreException = new UniversalFirebaseFirestoreException((FirebaseFirestoreException) exc, exc.getCause());
            ReactNativeFirebaseModule.rejectPromiseWithCodeAndMessage(promise, universalFirebaseFirestoreException.getCode(), universalFirebaseFirestoreException.getMessage());
        } else if (exc.getCause() == null || !(exc.getCause() instanceof FirebaseFirestoreException)) {
            ReactNativeFirebaseModule.rejectPromiseWithExceptionMap(promise, exc);
        } else {
            UniversalFirebaseFirestoreException universalFirebaseFirestoreException2 = new UniversalFirebaseFirestoreException((FirebaseFirestoreException) exc.getCause(), exc.getCause().getCause());
            ReactNativeFirebaseModule.rejectPromiseWithCodeAndMessage(promise, universalFirebaseFirestoreException2.getCode(), universalFirebaseFirestoreException2.getMessage());
        }
    }
}
