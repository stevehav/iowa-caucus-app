package io.invertase.firebase.firestore;

import android.content.Context;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;
import io.invertase.firebase.common.UniversalFirebaseModule;
import io.invertase.firebase.common.UniversalFirebasePreferences;
import java.util.Map;
import java.util.concurrent.Callable;

public class UniversalFirebaseFirestoreModule extends UniversalFirebaseModule {
    UniversalFirebaseFirestoreModule(Context context, String str) {
        super(context, str);
    }

    /* access modifiers changed from: package-private */
    public Task<Void> disableNetwork(String str) {
        return UniversalFirebaseFirestoreCommon.getFirestoreForApp(str).disableNetwork();
    }

    /* access modifiers changed from: package-private */
    public Task<Void> enableNetwork(String str) {
        return UniversalFirebaseFirestoreCommon.getFirestoreForApp(str).enableNetwork();
    }

    /* access modifiers changed from: package-private */
    public Task<Void> settings(String str, Map<String, Object> map) {
        return Tasks.call(getExecutor(), new Callable(map, str) {
            private final /* synthetic */ Map f$0;
            private final /* synthetic */ String f$1;

            {
                this.f$0 = r1;
                this.f$1 = r2;
            }

            public final Object call() {
                return UniversalFirebaseFirestoreModule.lambda$settings$0(this.f$0, this.f$1);
            }
        });
    }

    static /* synthetic */ Void lambda$settings$0(Map map, String str) throws Exception {
        if (map.containsKey("cacheSizeBytes")) {
            Double d = (Double) map.get("cacheSizeBytes");
            d.getClass();
            UniversalFirebasePreferences.getSharedInstance().setIntValue(UniversalFirebaseFirestoreStatics.FIRESTORE_CACHE_SIZE + "_" + str, d.intValue());
        }
        if (map.containsKey("host")) {
            UniversalFirebasePreferences.getSharedInstance().setStringValue(UniversalFirebaseFirestoreStatics.FIRESTORE_HOST + "_" + str, (String) map.get("host"));
        }
        if (map.containsKey("persistence")) {
            UniversalFirebasePreferences.getSharedInstance().setBooleanValue(UniversalFirebaseFirestoreStatics.FIRESTORE_PERSISTENCE + "_" + str, ((Boolean) map.get("persistence")).booleanValue());
        }
        if (!map.containsKey("ssl")) {
            return null;
        }
        UniversalFirebasePreferences.getSharedInstance().setBooleanValue(UniversalFirebaseFirestoreStatics.FIRESTORE_SSL + "_" + str, ((Boolean) map.get("ssl")).booleanValue());
        return null;
    }
}
