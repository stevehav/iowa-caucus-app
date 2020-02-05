package com.google.firebase.firestore;

import android.app.Activity;
import androidx.annotation.NonNull;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.android.gms.tasks.Tasks;
import com.google.common.base.Preconditions;
import com.google.firebase.annotations.PublicApi;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.core.ActivityScope;
import com.google.firebase.firestore.core.AsyncEventListener;
import com.google.firebase.firestore.core.Bound;
import com.google.firebase.firestore.core.EventManager;
import com.google.firebase.firestore.core.FieldFilter;
import com.google.firebase.firestore.core.Filter;
import com.google.firebase.firestore.core.ListenerRegistrationImpl;
import com.google.firebase.firestore.core.OrderBy;
import com.google.firebase.firestore.core.ViewSnapshot;
import com.google.firebase.firestore.model.Document;
import com.google.firebase.firestore.model.DocumentKey;
import com.google.firebase.firestore.model.FieldPath;
import com.google.firebase.firestore.model.ResourcePath;
import com.google.firebase.firestore.model.value.ArrayValue;
import com.google.firebase.firestore.model.value.FieldValue;
import com.google.firebase.firestore.model.value.ReferenceValue;
import com.google.firebase.firestore.model.value.ServerTimestampValue;
import com.google.firebase.firestore.util.Assert;
import com.google.firebase.firestore.util.Executors;
import com.google.firebase.firestore.util.Util;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import javax.annotation.Nullable;

@PublicApi
/* compiled from: com.google.firebase:firebase-firestore@@20.2.0 */
public class Query {
    final FirebaseFirestore firestore;
    final com.google.firebase.firestore.core.Query query;

    @PublicApi
    /* compiled from: com.google.firebase:firebase-firestore@@20.2.0 */
    public enum Direction {
        ASCENDING,
        DESCENDING
    }

    Query(com.google.firebase.firestore.core.Query query2, FirebaseFirestore firebaseFirestore) {
        this.query = (com.google.firebase.firestore.core.Query) Preconditions.checkNotNull(query2);
        this.firestore = (FirebaseFirestore) Preconditions.checkNotNull(firebaseFirestore);
    }

    @PublicApi
    @NonNull
    public FirebaseFirestore getFirestore() {
        return this.firestore;
    }

    @PublicApi
    @NonNull
    public Query whereEqualTo(@NonNull String str, @Nullable Object obj) {
        return whereHelper(FieldPath.fromDotSeparatedPath(str), Filter.Operator.EQUAL, obj);
    }

    @PublicApi
    @NonNull
    public Query whereEqualTo(@NonNull FieldPath fieldPath, @Nullable Object obj) {
        return whereHelper(fieldPath, Filter.Operator.EQUAL, obj);
    }

    @PublicApi
    @NonNull
    public Query whereLessThan(@NonNull String str, @NonNull Object obj) {
        return whereHelper(FieldPath.fromDotSeparatedPath(str), Filter.Operator.LESS_THAN, obj);
    }

    @PublicApi
    @NonNull
    public Query whereLessThan(@NonNull FieldPath fieldPath, @NonNull Object obj) {
        return whereHelper(fieldPath, Filter.Operator.LESS_THAN, obj);
    }

    @PublicApi
    @NonNull
    public Query whereLessThanOrEqualTo(@NonNull String str, @NonNull Object obj) {
        return whereHelper(FieldPath.fromDotSeparatedPath(str), Filter.Operator.LESS_THAN_OR_EQUAL, obj);
    }

    @PublicApi
    @NonNull
    public Query whereLessThanOrEqualTo(@NonNull FieldPath fieldPath, @NonNull Object obj) {
        return whereHelper(fieldPath, Filter.Operator.LESS_THAN_OR_EQUAL, obj);
    }

    @PublicApi
    @NonNull
    public Query whereGreaterThan(@NonNull String str, @NonNull Object obj) {
        return whereHelper(FieldPath.fromDotSeparatedPath(str), Filter.Operator.GREATER_THAN, obj);
    }

    @PublicApi
    @NonNull
    public Query whereGreaterThan(@NonNull FieldPath fieldPath, @NonNull Object obj) {
        return whereHelper(fieldPath, Filter.Operator.GREATER_THAN, obj);
    }

    @PublicApi
    @NonNull
    public Query whereGreaterThanOrEqualTo(@NonNull String str, @NonNull Object obj) {
        return whereHelper(FieldPath.fromDotSeparatedPath(str), Filter.Operator.GREATER_THAN_OR_EQUAL, obj);
    }

    @PublicApi
    @NonNull
    public Query whereGreaterThanOrEqualTo(@NonNull FieldPath fieldPath, @NonNull Object obj) {
        return whereHelper(fieldPath, Filter.Operator.GREATER_THAN_OR_EQUAL, obj);
    }

    @PublicApi
    @NonNull
    public Query whereArrayContains(@NonNull String str, @NonNull Object obj) {
        return whereHelper(FieldPath.fromDotSeparatedPath(str), Filter.Operator.ARRAY_CONTAINS, obj);
    }

    @PublicApi
    @NonNull
    public Query whereArrayContains(@NonNull FieldPath fieldPath, @NonNull Object obj) {
        return whereHelper(fieldPath, Filter.Operator.ARRAY_CONTAINS, obj);
    }

    /* access modifiers changed from: package-private */
    @NonNull
    public Query whereArrayContainsAny(@NonNull String str, @NonNull List<Object> list) {
        return whereHelper(FieldPath.fromDotSeparatedPath(str), Filter.Operator.ARRAY_CONTAINS_ANY, list);
    }

    /* access modifiers changed from: package-private */
    @NonNull
    public Query whereArrayContainsAny(@NonNull FieldPath fieldPath, @NonNull List<Object> list) {
        return whereHelper(fieldPath, Filter.Operator.ARRAY_CONTAINS_ANY, list);
    }

    /* access modifiers changed from: package-private */
    @NonNull
    public Query whereIn(@NonNull String str, @NonNull List<Object> list) {
        return whereHelper(FieldPath.fromDotSeparatedPath(str), Filter.Operator.IN, list);
    }

    /* access modifiers changed from: package-private */
    @NonNull
    public Query whereIn(@NonNull FieldPath fieldPath, @NonNull List<Object> list) {
        return whereHelper(fieldPath, Filter.Operator.IN, list);
    }

    private Query whereHelper(@NonNull FieldPath fieldPath, Filter.Operator operator, Object obj) {
        FieldValue fieldValue;
        Preconditions.checkNotNull(fieldPath, "Provided field path must not be null.");
        Preconditions.checkNotNull(operator, "Provided op must not be null.");
        if (!fieldPath.getInternalPath().isKeyField()) {
            if (operator == Filter.Operator.IN || operator == Filter.Operator.ARRAY_CONTAINS_ANY) {
                validateDisjunctiveFilterElements(obj, operator);
            }
            fieldValue = this.firestore.getDataConverter().parseQueryValue(obj);
        } else if (operator == Filter.Operator.ARRAY_CONTAINS || operator == Filter.Operator.ARRAY_CONTAINS_ANY) {
            throw new IllegalArgumentException("Invalid query. You can't perform '" + operator.toString() + "' queries on FieldPath.documentId().");
        } else if (operator == Filter.Operator.IN) {
            validateDisjunctiveFilterElements(obj, operator);
            ArrayList arrayList = new ArrayList();
            for (Object parseDocumentIdValue : (List) obj) {
                arrayList.add(parseDocumentIdValue(parseDocumentIdValue));
            }
            fieldValue = ArrayValue.fromList(arrayList);
        } else {
            fieldValue = parseDocumentIdValue(obj);
        }
        FieldFilter create = FieldFilter.create(fieldPath.getInternalPath(), operator, fieldValue);
        validateNewFilter(create);
        return new Query(this.query.filter(create), this.firestore);
    }

    private void validateOrderByField(FieldPath fieldPath) {
        FieldPath inequalityField = this.query.inequalityField();
        if (this.query.getFirstOrderByField() == null && inequalityField != null) {
            validateOrderByFieldMatchesInequality(fieldPath, inequalityField);
        }
    }

    private ReferenceValue parseDocumentIdValue(Object obj) {
        if (obj instanceof String) {
            String str = (String) obj;
            if (str.isEmpty()) {
                throw new IllegalArgumentException("Invalid query. When querying with FieldPath.documentId() you must provide a valid document ID, but it was an empty string.");
            } else if (this.query.isCollectionGroupQuery() || !str.contains("/")) {
                ResourcePath resourcePath = (ResourcePath) this.query.getPath().append(ResourcePath.fromString(str));
                if (DocumentKey.isDocumentKey(resourcePath)) {
                    return ReferenceValue.valueOf(getFirestore().getDatabaseId(), DocumentKey.fromPath(resourcePath));
                }
                throw new IllegalArgumentException("Invalid query. When querying a collection group by FieldPath.documentId(), the value provided must result in a valid document path, but '" + resourcePath + "' is not because it has an odd number of segments (" + resourcePath.length() + ").");
            } else {
                throw new IllegalArgumentException("Invalid query. When querying a collection by FieldPath.documentId() you must provide a plain document ID, but '" + str + "' contains a '/' character.");
            }
        } else if (obj instanceof DocumentReference) {
            return ReferenceValue.valueOf(getFirestore().getDatabaseId(), ((DocumentReference) obj).getKey());
        } else {
            throw new IllegalArgumentException("Invalid query. When querying with FieldPath.documentId() you must provide a valid String or DocumentReference, but it was of type: " + Util.typeName(obj));
        }
    }

    private void validateDisjunctiveFilterElements(Object obj, Filter.Operator operator) {
        if (obj instanceof List) {
            List list = (List) obj;
            if (list.size() != 0) {
                if (list.size() > 10) {
                    throw new IllegalArgumentException("Invalid Query. '" + operator.toString() + "' filters support a maximum of 10 elements in the value array.");
                } else if (list.contains((Object) null)) {
                    throw new IllegalArgumentException("Invalid Query. '" + operator.toString() + "' filters cannot contain 'null' in the value array.");
                } else if (list.contains(Double.valueOf(Double.NaN)) || list.contains(Float.valueOf(Float.NaN))) {
                    throw new IllegalArgumentException("Invalid Query. '" + operator.toString() + "' filters cannot contain 'NaN' in the value array.");
                } else {
                    return;
                }
            }
        }
        throw new IllegalArgumentException("Invalid Query. A non-empty array is required for '" + operator.toString() + "' filters.");
    }

    private void validateOrderByFieldMatchesInequality(FieldPath fieldPath, FieldPath fieldPath2) {
        if (!fieldPath.equals(fieldPath2)) {
            String canonicalString = fieldPath2.canonicalString();
            throw new IllegalArgumentException(String.format("Invalid query. You have an inequality where filter (whereLessThan(), whereGreaterThan(), etc.) on field '%s' and so you must also have '%s' as your first orderBy() field, but your first orderBy() is currently on field '%s' instead.", new Object[]{canonicalString, canonicalString, fieldPath.canonicalString()}));
        }
    }

    private void validateNewFilter(Filter filter) {
        if (filter instanceof FieldFilter) {
            FieldFilter fieldFilter = (FieldFilter) filter;
            Filter.Operator operator = fieldFilter.getOperator();
            List asList = Arrays.asList(new Filter.Operator[]{Filter.Operator.ARRAY_CONTAINS, Filter.Operator.ARRAY_CONTAINS_ANY});
            List asList2 = Arrays.asList(new Filter.Operator[]{Filter.Operator.ARRAY_CONTAINS_ANY, Filter.Operator.IN});
            boolean contains = asList.contains(operator);
            boolean contains2 = asList2.contains(operator);
            if (fieldFilter.isInequality()) {
                FieldPath inequalityField = this.query.inequalityField();
                FieldPath field = filter.getField();
                if (inequalityField == null || inequalityField.equals(field)) {
                    FieldPath firstOrderByField = this.query.getFirstOrderByField();
                    if (firstOrderByField != null) {
                        validateOrderByFieldMatchesInequality(firstOrderByField, field);
                        return;
                    }
                    return;
                }
                throw new IllegalArgumentException(String.format("All where filters other than whereEqualTo() must be on the same field. But you have filters on '%s' and '%s'", new Object[]{inequalityField.canonicalString(), field.canonicalString()}));
            } else if (contains2 || contains) {
                Filter.Operator operator2 = null;
                if (contains2) {
                    operator2 = this.query.findFilterOperator(asList2);
                }
                if (operator2 == null && contains) {
                    operator2 = this.query.findFilterOperator(asList);
                }
                if (operator2 == null) {
                    return;
                }
                if (operator2 == operator) {
                    throw new IllegalArgumentException("Invalid Query. You cannot use more than one '" + operator.toString() + "' filter.");
                }
                throw new IllegalArgumentException("Invalid Query. You cannot use '" + operator.toString() + "' filters with '" + operator2.toString() + "' filters.");
            }
        }
    }

    @PublicApi
    @NonNull
    public Query orderBy(@NonNull String str) {
        return orderBy(FieldPath.fromDotSeparatedPath(str), Direction.ASCENDING);
    }

    @PublicApi
    @NonNull
    public Query orderBy(@NonNull FieldPath fieldPath) {
        Preconditions.checkNotNull(fieldPath, "Provided field path must not be null.");
        return orderBy(fieldPath.getInternalPath(), Direction.ASCENDING);
    }

    @PublicApi
    @NonNull
    public Query orderBy(@NonNull String str, @NonNull Direction direction) {
        return orderBy(FieldPath.fromDotSeparatedPath(str), direction);
    }

    @PublicApi
    @NonNull
    public Query orderBy(@NonNull FieldPath fieldPath, @NonNull Direction direction) {
        Preconditions.checkNotNull(fieldPath, "Provided field path must not be null.");
        return orderBy(fieldPath.getInternalPath(), direction);
    }

    private Query orderBy(@NonNull FieldPath fieldPath, @NonNull Direction direction) {
        OrderBy.Direction direction2;
        Preconditions.checkNotNull(direction, "Provided direction must not be null.");
        if (this.query.getStartAt() != null) {
            throw new IllegalArgumentException("Invalid query. You must not call Query.startAt() or Query.startAfter() before calling Query.orderBy().");
        } else if (this.query.getEndAt() == null) {
            validateOrderByField(fieldPath);
            if (direction == Direction.ASCENDING) {
                direction2 = OrderBy.Direction.ASCENDING;
            } else {
                direction2 = OrderBy.Direction.DESCENDING;
            }
            return new Query(this.query.orderBy(OrderBy.getInstance(direction2, fieldPath)), this.firestore);
        } else {
            throw new IllegalArgumentException("Invalid query. You must not call Query.endAt() or Query.endBefore() before calling Query.orderBy().");
        }
    }

    @PublicApi
    @NonNull
    public Query limit(long j) {
        if (j > 0) {
            return new Query(this.query.limit(j), this.firestore);
        }
        throw new IllegalArgumentException("Invalid Query. Query limit (" + j + ") is invalid. Limit must be positive.");
    }

    @PublicApi
    @NonNull
    public Query startAt(@NonNull DocumentSnapshot documentSnapshot) {
        return new Query(this.query.startAt(boundFromDocumentSnapshot("startAt", documentSnapshot, true)), this.firestore);
    }

    @PublicApi
    @NonNull
    public Query startAt(Object... objArr) {
        return new Query(this.query.startAt(boundFromFields("startAt", objArr, true)), this.firestore);
    }

    @PublicApi
    @NonNull
    public Query startAfter(@NonNull DocumentSnapshot documentSnapshot) {
        return new Query(this.query.startAt(boundFromDocumentSnapshot("startAfter", documentSnapshot, false)), this.firestore);
    }

    @PublicApi
    @NonNull
    public Query startAfter(Object... objArr) {
        return new Query(this.query.startAt(boundFromFields("startAfter", objArr, false)), this.firestore);
    }

    @PublicApi
    @NonNull
    public Query endBefore(@NonNull DocumentSnapshot documentSnapshot) {
        return new Query(this.query.endAt(boundFromDocumentSnapshot("endBefore", documentSnapshot, true)), this.firestore);
    }

    @PublicApi
    @NonNull
    public Query endBefore(Object... objArr) {
        return new Query(this.query.endAt(boundFromFields("endBefore", objArr, true)), this.firestore);
    }

    @PublicApi
    @NonNull
    public Query endAt(@NonNull DocumentSnapshot documentSnapshot) {
        return new Query(this.query.endAt(boundFromDocumentSnapshot("endAt", documentSnapshot, false)), this.firestore);
    }

    @PublicApi
    @NonNull
    public Query endAt(Object... objArr) {
        return new Query(this.query.endAt(boundFromFields("endAt", objArr, false)), this.firestore);
    }

    private Bound boundFromDocumentSnapshot(String str, DocumentSnapshot documentSnapshot, boolean z) {
        Preconditions.checkNotNull(documentSnapshot, "Provided snapshot must not be null.");
        if (documentSnapshot.exists()) {
            Document document = documentSnapshot.getDocument();
            ArrayList arrayList = new ArrayList();
            for (OrderBy next : this.query.getOrderBy()) {
                if (next.getField().equals(FieldPath.KEY_PATH)) {
                    arrayList.add(ReferenceValue.valueOf(this.firestore.getDatabaseId(), document.getKey()));
                } else {
                    FieldValue field = document.getField(next.getField());
                    if (field instanceof ServerTimestampValue) {
                        throw new IllegalArgumentException("Invalid query. You are trying to start or end a query using a document for which the field '" + next.getField() + "' is an uncommitted server timestamp. (Since the value of this field is unknown, you cannot start/end a query with it.)");
                    } else if (field != null) {
                        arrayList.add(field);
                    } else {
                        throw new IllegalArgumentException("Invalid query. You are trying to start or end a query using a document for which the field '" + next.getField() + "' (used as the orderBy) does not exist.");
                    }
                }
            }
            return new Bound(arrayList, z);
        }
        throw new IllegalArgumentException("Can't use a DocumentSnapshot for a document that doesn't exist for " + str + "().");
    }

    private Bound boundFromFields(String str, Object[] objArr, boolean z) {
        List<OrderBy> explicitOrderBy = this.query.getExplicitOrderBy();
        if (objArr.length <= explicitOrderBy.size()) {
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < objArr.length; i++) {
                String str2 = objArr[i];
                if (!explicitOrderBy.get(i).getField().equals(FieldPath.KEY_PATH)) {
                    arrayList.add(this.firestore.getDataConverter().parseQueryValue(str2));
                } else if (str2 instanceof String) {
                    String str3 = str2;
                    if (this.query.isCollectionGroupQuery() || !str3.contains("/")) {
                        ResourcePath resourcePath = (ResourcePath) this.query.getPath().append(ResourcePath.fromString(str3));
                        if (DocumentKey.isDocumentKey(resourcePath)) {
                            arrayList.add(ReferenceValue.valueOf(this.firestore.getDatabaseId(), DocumentKey.fromPath(resourcePath)));
                        } else {
                            throw new IllegalArgumentException("Invalid query. When querying a collection group and ordering by FieldPath.documentId(), the value passed to " + str + "() must result in a valid document path, but '" + resourcePath + "' is not because it contains an odd number of segments.");
                        }
                    } else {
                        throw new IllegalArgumentException("Invalid query. When querying a collection and ordering by FieldPath.documentId(), the value passed to " + str + "() must be a plain document ID, but '" + str3 + "' contains a slash.");
                    }
                } else {
                    throw new IllegalArgumentException("Invalid query. Expected a string for document ID in " + str + "(), but got " + str2 + ".");
                }
            }
            return new Bound(arrayList, z);
        }
        throw new IllegalArgumentException("Too many arguments provided to " + str + "(). The number of arguments must be less than or equal to the number of orderBy() clauses.");
    }

    @PublicApi
    @NonNull
    public Task<QuerySnapshot> get() {
        return get(Source.DEFAULT);
    }

    @PublicApi
    @NonNull
    public Task<QuerySnapshot> get(Source source) {
        if (source == Source.CACHE) {
            return this.firestore.getClient().getDocumentsFromLocalCache(this.query).continueWith(Executors.DIRECT_EXECUTOR, Query$$Lambda$1.lambdaFactory$(this));
        }
        return getViaSnapshotListener(source);
    }

    static /* synthetic */ QuerySnapshot lambda$get$0(Query query2, Task task) throws Exception {
        return new QuerySnapshot(new Query(query2.query, query2.firestore), (ViewSnapshot) task.getResult(), query2.firestore);
    }

    private Task<QuerySnapshot> getViaSnapshotListener(Source source) {
        TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        TaskCompletionSource taskCompletionSource2 = new TaskCompletionSource();
        EventManager.ListenOptions listenOptions = new EventManager.ListenOptions();
        listenOptions.includeDocumentMetadataChanges = true;
        listenOptions.includeQueryMetadataChanges = true;
        listenOptions.waitForSyncWhenOnline = true;
        taskCompletionSource2.setResult(addSnapshotListenerInternal(Executors.DIRECT_EXECUTOR, listenOptions, (Activity) null, Query$$Lambda$2.lambdaFactory$(taskCompletionSource, taskCompletionSource2, source)));
        return taskCompletionSource.getTask();
    }

    static /* synthetic */ void lambda$getViaSnapshotListener$1(TaskCompletionSource taskCompletionSource, TaskCompletionSource taskCompletionSource2, Source source, QuerySnapshot querySnapshot, FirebaseFirestoreException firebaseFirestoreException) {
        if (firebaseFirestoreException != null) {
            taskCompletionSource.setException(firebaseFirestoreException);
            return;
        }
        try {
            ((ListenerRegistration) Tasks.await(taskCompletionSource2.getTask())).remove();
            if (!querySnapshot.getMetadata().isFromCache() || source != Source.SERVER) {
                taskCompletionSource.setResult(querySnapshot);
            } else {
                taskCompletionSource.setException(new FirebaseFirestoreException("Failed to get documents from server. (However, these documents may exist in the local cache. Run again without setting source to SERVER to retrieve the cached documents.)", FirebaseFirestoreException.Code.UNAVAILABLE));
            }
        } catch (ExecutionException e) {
            throw Assert.fail(e, "Failed to register a listener for a query result", new Object[0]);
        } catch (InterruptedException e2) {
            Thread.currentThread().interrupt();
            throw Assert.fail(e2, "Failed to register a listener for a query result", new Object[0]);
        }
    }

    @PublicApi
    @NonNull
    public ListenerRegistration addSnapshotListener(@NonNull EventListener<QuerySnapshot> eventListener) {
        return addSnapshotListener(MetadataChanges.EXCLUDE, eventListener);
    }

    @PublicApi
    @NonNull
    public ListenerRegistration addSnapshotListener(@NonNull Executor executor, @NonNull EventListener<QuerySnapshot> eventListener) {
        return addSnapshotListener(executor, MetadataChanges.EXCLUDE, eventListener);
    }

    @PublicApi
    @NonNull
    public ListenerRegistration addSnapshotListener(@NonNull Activity activity, @NonNull EventListener<QuerySnapshot> eventListener) {
        return addSnapshotListener(activity, MetadataChanges.EXCLUDE, eventListener);
    }

    @PublicApi
    @NonNull
    public ListenerRegistration addSnapshotListener(@NonNull MetadataChanges metadataChanges, @NonNull EventListener<QuerySnapshot> eventListener) {
        return addSnapshotListener(Executors.DEFAULT_CALLBACK_EXECUTOR, metadataChanges, eventListener);
    }

    @PublicApi
    @NonNull
    public ListenerRegistration addSnapshotListener(@NonNull Executor executor, @NonNull MetadataChanges metadataChanges, @NonNull EventListener<QuerySnapshot> eventListener) {
        Preconditions.checkNotNull(executor, "Provided executor must not be null.");
        Preconditions.checkNotNull(metadataChanges, "Provided MetadataChanges value must not be null.");
        Preconditions.checkNotNull(eventListener, "Provided EventListener must not be null.");
        return addSnapshotListenerInternal(executor, internalOptions(metadataChanges), (Activity) null, eventListener);
    }

    @PublicApi
    @NonNull
    public ListenerRegistration addSnapshotListener(@NonNull Activity activity, @NonNull MetadataChanges metadataChanges, @NonNull EventListener<QuerySnapshot> eventListener) {
        Preconditions.checkNotNull(activity, "Provided activity must not be null.");
        Preconditions.checkNotNull(metadataChanges, "Provided MetadataChanges value must not be null.");
        Preconditions.checkNotNull(eventListener, "Provided EventListener must not be null.");
        return addSnapshotListenerInternal(Executors.DEFAULT_CALLBACK_EXECUTOR, internalOptions(metadataChanges), activity, eventListener);
    }

    private ListenerRegistration addSnapshotListenerInternal(Executor executor, EventManager.ListenOptions listenOptions, @Nullable Activity activity, EventListener<QuerySnapshot> eventListener) {
        AsyncEventListener asyncEventListener = new AsyncEventListener(executor, Query$$Lambda$3.lambdaFactory$(this, eventListener));
        return ActivityScope.bind(activity, new ListenerRegistrationImpl(this.firestore.getClient(), this.firestore.getClient().listen(this.query, listenOptions, asyncEventListener), asyncEventListener));
    }

    static /* synthetic */ void lambda$addSnapshotListenerInternal$2(Query query2, EventListener eventListener, ViewSnapshot viewSnapshot, FirebaseFirestoreException firebaseFirestoreException) {
        if (firebaseFirestoreException != null) {
            eventListener.onEvent(null, firebaseFirestoreException);
            return;
        }
        Assert.hardAssert(viewSnapshot != null, "Got event without value or error set", new Object[0]);
        eventListener.onEvent(new QuerySnapshot(query2, viewSnapshot, query2.firestore), (FirebaseFirestoreException) null);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Query)) {
            return false;
        }
        Query query2 = (Query) obj;
        if (!this.query.equals(query2.query) || !this.firestore.equals(query2.firestore)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        return (this.query.hashCode() * 31) + this.firestore.hashCode();
    }

    private static EventManager.ListenOptions internalOptions(MetadataChanges metadataChanges) {
        EventManager.ListenOptions listenOptions = new EventManager.ListenOptions();
        boolean z = true;
        listenOptions.includeDocumentMetadataChanges = metadataChanges == MetadataChanges.INCLUDE;
        if (metadataChanges != MetadataChanges.INCLUDE) {
            z = false;
        }
        listenOptions.includeQueryMetadataChanges = z;
        listenOptions.waitForSyncWhenOnline = false;
        return listenOptions;
    }
}
