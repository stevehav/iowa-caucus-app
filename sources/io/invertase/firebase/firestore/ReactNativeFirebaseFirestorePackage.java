package io.invertase.firebase.firestore;

import com.facebook.react.ReactPackage;
import com.facebook.react.bridge.NativeModule;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.uimanager.ViewManager;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ReactNativeFirebaseFirestorePackage implements ReactPackage {
    public List<NativeModule> createNativeModules(ReactApplicationContext reactApplicationContext) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new ReactNativeFirebaseFirestoreModule(reactApplicationContext));
        arrayList.add(new ReactNativeFirebaseFirestoreCollectionModule(reactApplicationContext));
        arrayList.add(new ReactNativeFirebaseFirestoreDocumentModule(reactApplicationContext));
        arrayList.add(new ReactNativeFirebaseFirestoreTransactionModule(reactApplicationContext));
        return arrayList;
    }

    public List<ViewManager> createViewManagers(ReactApplicationContext reactApplicationContext) {
        return Collections.emptyList();
    }
}
