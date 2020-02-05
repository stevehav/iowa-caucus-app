package io.invertase.firebase.firestore;

import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.WritableMap;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.MetadataChanges;
import com.google.firebase.firestore.Query;
import com.google.firebase.firestore.QuerySnapshot;
import com.google.firebase.firestore.Source;
import io.invertase.firebase.common.RCTConvertFirebase;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;

public class ReactNativeFirebaseFirestoreQuery {
    Query query;

    ReactNativeFirebaseFirestoreQuery(Query query2, ReadableArray readableArray, ReadableArray readableArray2, ReadableMap readableMap) {
        this.query = query2;
        applyFilters(readableArray);
        applyOrders(readableArray2);
        applyOptions(readableMap);
    }

    public Task<WritableMap> get(Executor executor, Source source) {
        return Tasks.call(executor, new Callable(source) {
            private final /* synthetic */ Source f$1;

            {
                this.f$1 = r2;
            }

            public final Object call() {
                return ReactNativeFirebaseFirestoreQuery.this.lambda$get$0$ReactNativeFirebaseFirestoreQuery(this.f$1);
            }
        });
    }

    public /* synthetic */ WritableMap lambda$get$0$ReactNativeFirebaseFirestoreQuery(Source source) throws Exception {
        return ReactNativeFirebaseFirestoreSerialize.snapshotToWritableMap("get", (QuerySnapshot) Tasks.await(this.query.get(source)), (MetadataChanges) null);
    }

    private void applyFilters(ReadableArray readableArray) {
        for (int i = 0; i < readableArray.size(); i++) {
            ReadableMap map = readableArray.getMap(i);
            map.getClass();
            String string = map.getString("fieldPath");
            String string2 = map.getString("operator");
            ReadableArray array = map.getArray("value");
            FirebaseFirestore firestore = this.query.getFirestore();
            array.getClass();
            Object parseTypeMap = ReactNativeFirebaseFirestoreSerialize.parseTypeMap(firestore, array);
            string2.getClass();
            String str = string2;
            char c = 65535;
            switch (str.hashCode()) {
                case -2081783184:
                    if (str.equals("LESS_THAN_OR_EQUAL")) {
                        c = 4;
                        break;
                    }
                    break;
                case -1112834937:
                    if (str.equals("LESS_THAN")) {
                        c = 3;
                        break;
                    }
                    break;
                case 66219796:
                    if (str.equals("EQUAL")) {
                        c = 0;
                        break;
                    }
                    break;
                case 67210597:
                    if (str.equals("ARRAY_CONTAINS")) {
                        c = 5;
                        break;
                    }
                    break;
                case 972152550:
                    if (str.equals("GREATER_THAN")) {
                        c = 1;
                        break;
                    }
                    break;
                case 989027057:
                    if (str.equals("GREATER_THAN_OR_EQUAL")) {
                        c = 2;
                        break;
                    }
                    break;
            }
            if (c == 0) {
                Query query2 = this.query;
                string.getClass();
                this.query = query2.whereEqualTo(string, parseTypeMap);
            } else if (c == 1) {
                Query query3 = this.query;
                string.getClass();
                parseTypeMap.getClass();
                this.query = query3.whereGreaterThan(string, parseTypeMap);
            } else if (c == 2) {
                Query query4 = this.query;
                string.getClass();
                parseTypeMap.getClass();
                this.query = query4.whereGreaterThanOrEqualTo(string, parseTypeMap);
            } else if (c == 3) {
                Query query5 = this.query;
                string.getClass();
                parseTypeMap.getClass();
                this.query = query5.whereLessThan(string, parseTypeMap);
            } else if (c == 4) {
                Query query6 = this.query;
                string.getClass();
                parseTypeMap.getClass();
                this.query = query6.whereLessThanOrEqualTo(string, parseTypeMap);
            } else if (c == 5) {
                Query query7 = this.query;
                string.getClass();
                parseTypeMap.getClass();
                this.query = query7.whereArrayContains(string, parseTypeMap);
            }
        }
    }

    private void applyOrders(ReadableArray readableArray) {
        Iterator<Object> it = RCTConvertFirebase.toArrayList(readableArray).iterator();
        while (it.hasNext()) {
            Map map = (Map) it.next();
            String str = (String) map.get("fieldPath");
            Query query2 = this.query;
            str.getClass();
            this.query = query2.orderBy(str, Query.Direction.valueOf((String) map.get("direction")));
        }
    }

    private void applyOptions(ReadableMap readableMap) {
        if (readableMap.hasKey("limit")) {
            this.query = this.query.limit((long) readableMap.getInt("limit"));
        }
        if (readableMap.hasKey("startAt")) {
            List<Object> parseReadableArray = ReactNativeFirebaseFirestoreSerialize.parseReadableArray(this.query.getFirestore(), readableMap.getArray("startAt"));
            Query query2 = this.query;
            Object[] array = parseReadableArray.toArray();
            array.getClass();
            this.query = query2.startAt(array);
        }
        if (readableMap.hasKey("startAfter")) {
            List<Object> parseReadableArray2 = ReactNativeFirebaseFirestoreSerialize.parseReadableArray(this.query.getFirestore(), readableMap.getArray("startAfter"));
            Query query3 = this.query;
            Object[] array2 = parseReadableArray2.toArray();
            array2.getClass();
            this.query = query3.startAfter(array2);
        }
        if (readableMap.hasKey("endAt")) {
            List<Object> parseReadableArray3 = ReactNativeFirebaseFirestoreSerialize.parseReadableArray(this.query.getFirestore(), readableMap.getArray("endAt"));
            Query query4 = this.query;
            Object[] array3 = parseReadableArray3.toArray();
            array3.getClass();
            this.query = query4.endAt(array3);
        }
        if (readableMap.hasKey("endBefore")) {
            List<Object> parseReadableArray4 = ReactNativeFirebaseFirestoreSerialize.parseReadableArray(this.query.getFirestore(), readableMap.getArray("endBefore"));
            Query query5 = this.query;
            Object[] array4 = parseReadableArray4.toArray();
            array4.getClass();
            this.query = query5.endBefore(array4);
        }
    }
}
