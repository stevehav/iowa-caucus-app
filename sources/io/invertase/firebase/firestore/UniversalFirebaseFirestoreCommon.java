package io.invertase.firebase.firestore;

import com.google.firebase.FirebaseApp;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreSettings;
import com.google.firebase.firestore.Query;
import io.invertase.firebase.common.UniversalFirebasePreferences;
import java.util.HashMap;

public class UniversalFirebaseFirestoreCommon {
    private static HashMap<String, Boolean> settingsLock = new HashMap<>();

    static FirebaseFirestore getFirestoreForApp(String str) {
        FirebaseFirestore instance = FirebaseFirestore.getInstance(FirebaseApp.getInstance(str));
        setFirestoreSettings(instance, str);
        return instance;
    }

    private static void setFirestoreSettings(FirebaseFirestore firebaseFirestore, String str) {
        if (!settingsLock.containsKey(str)) {
            UniversalFirebasePreferences sharedInstance = UniversalFirebasePreferences.getSharedInstance();
            FirebaseFirestoreSettings.Builder builder = new FirebaseFirestoreSettings.Builder();
            int intValue = sharedInstance.getIntValue(UniversalFirebaseFirestoreStatics.FIRESTORE_CACHE_SIZE + "_" + str, (int) firebaseFirestore.getFirestoreSettings().getCacheSizeBytes());
            String stringValue = sharedInstance.getStringValue(UniversalFirebaseFirestoreStatics.FIRESTORE_HOST + "_" + str, firebaseFirestore.getFirestoreSettings().getHost());
            boolean booleanValue = sharedInstance.getBooleanValue(UniversalFirebaseFirestoreStatics.FIRESTORE_PERSISTENCE + "_" + str, firebaseFirestore.getFirestoreSettings().isPersistenceEnabled());
            boolean booleanValue2 = sharedInstance.getBooleanValue(UniversalFirebaseFirestoreStatics.FIRESTORE_SSL + "_" + str, firebaseFirestore.getFirestoreSettings().isSslEnabled());
            if (intValue == -1) {
                builder.setCacheSizeBytes(-1);
            } else {
                builder.setCacheSizeBytes((long) intValue);
            }
            builder.setHost(stringValue);
            builder.setPersistenceEnabled(booleanValue);
            builder.setSslEnabled(booleanValue2);
            firebaseFirestore.setFirestoreSettings(builder.build());
            settingsLock.put(str, true);
        }
    }

    static Query getQueryForFirestore(FirebaseFirestore firebaseFirestore, String str, String str2) {
        if ("collectionGroup".equals(str2)) {
            return firebaseFirestore.collectionGroup(str);
        }
        return firebaseFirestore.collection(str);
    }

    static DocumentReference getDocumentForFirestore(FirebaseFirestore firebaseFirestore, String str) {
        return firebaseFirestore.document(str);
    }
}
