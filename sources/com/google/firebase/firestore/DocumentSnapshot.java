package com.google.firebase.firestore;

import androidx.annotation.NonNull;
import com.google.common.base.Preconditions;
import com.google.firebase.Timestamp;
import com.google.firebase.annotations.PublicApi;
import com.google.firebase.firestore.model.DatabaseId;
import com.google.firebase.firestore.model.Document;
import com.google.firebase.firestore.model.DocumentKey;
import com.google.firebase.firestore.model.FieldPath;
import com.google.firebase.firestore.model.value.ArrayValue;
import com.google.firebase.firestore.model.value.FieldValue;
import com.google.firebase.firestore.model.value.ObjectValue;
import com.google.firebase.firestore.model.value.ReferenceValue;
import com.google.firebase.firestore.model.value.ServerTimestampValue;
import com.google.firebase.firestore.model.value.TimestampValue;
import com.google.firebase.firestore.util.CustomClassMapper;
import com.google.firebase.firestore.util.Logger;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import javax.annotation.Nullable;

@PublicApi
/* compiled from: com.google.firebase:firebase-firestore@@20.2.0 */
public class DocumentSnapshot {
    @Nullable
    private final Document doc;
    private final FirebaseFirestore firestore;
    private final DocumentKey key;
    private final SnapshotMetadata metadata;

    @PublicApi
    /* compiled from: com.google.firebase:firebase-firestore@@20.2.0 */
    public enum ServerTimestampBehavior {
        NONE,
        ESTIMATE,
        PREVIOUS;
        
        static final ServerTimestampBehavior DEFAULT = null;

        static {
            ServerTimestampBehavior serverTimestampBehavior;
            DEFAULT = serverTimestampBehavior;
        }
    }

    /* compiled from: com.google.firebase:firebase-firestore@@20.2.0 */
    static class FieldValueOptions {
        final ServerTimestampBehavior serverTimestampBehavior;
        final boolean timestampsInSnapshotsEnabled;

        /* synthetic */ FieldValueOptions(ServerTimestampBehavior serverTimestampBehavior2, boolean z, AnonymousClass1 r3) {
            this(serverTimestampBehavior2, z);
        }

        private FieldValueOptions(ServerTimestampBehavior serverTimestampBehavior2, boolean z) {
            this.serverTimestampBehavior = serverTimestampBehavior2;
            this.timestampsInSnapshotsEnabled = z;
        }
    }

    DocumentSnapshot(FirebaseFirestore firebaseFirestore, DocumentKey documentKey, @Nullable Document document, boolean z, boolean z2) {
        this.firestore = (FirebaseFirestore) Preconditions.checkNotNull(firebaseFirestore);
        this.key = (DocumentKey) Preconditions.checkNotNull(documentKey);
        this.doc = document;
        this.metadata = new SnapshotMetadata(z2, z);
    }

    static DocumentSnapshot fromDocument(FirebaseFirestore firebaseFirestore, Document document, boolean z, boolean z2) {
        return new DocumentSnapshot(firebaseFirestore, document.getKey(), document, z, z2);
    }

    static DocumentSnapshot fromNoDocument(FirebaseFirestore firebaseFirestore, DocumentKey documentKey, boolean z, boolean z2) {
        return new DocumentSnapshot(firebaseFirestore, documentKey, (Document) null, z, z2);
    }

    @PublicApi
    @NonNull
    public String getId() {
        return this.key.getPath().getLastSegment();
    }

    @PublicApi
    @NonNull
    public SnapshotMetadata getMetadata() {
        return this.metadata;
    }

    @PublicApi
    public boolean exists() {
        return this.doc != null;
    }

    /* access modifiers changed from: package-private */
    @Nullable
    public Document getDocument() {
        return this.doc;
    }

    @PublicApi
    @Nullable
    public Map<String, Object> getData() {
        return getData(ServerTimestampBehavior.DEFAULT);
    }

    @PublicApi
    @Nullable
    public Map<String, Object> getData(@NonNull ServerTimestampBehavior serverTimestampBehavior) {
        Preconditions.checkNotNull(serverTimestampBehavior, "Provided serverTimestampBehavior value must not be null.");
        Document document = this.doc;
        if (document == null) {
            return null;
        }
        return convertObject(document.getData(), new FieldValueOptions(serverTimestampBehavior, this.firestore.getFirestoreSettings().areTimestampsInSnapshotsEnabled(), (AnonymousClass1) null));
    }

    @PublicApi
    @Nullable
    public <T> T toObject(@NonNull Class<T> cls) {
        return toObject(cls, ServerTimestampBehavior.DEFAULT);
    }

    @PublicApi
    @Nullable
    public <T> T toObject(@NonNull Class<T> cls, @NonNull ServerTimestampBehavior serverTimestampBehavior) {
        Preconditions.checkNotNull(cls, "Provided POJO type must not be null.");
        Preconditions.checkNotNull(serverTimestampBehavior, "Provided serverTimestampBehavior value must not be null.");
        Map<String, Object> data = getData(serverTimestampBehavior);
        if (data == null) {
            return null;
        }
        return CustomClassMapper.convertToCustomClass(data, cls, getReference());
    }

    @PublicApi
    public boolean contains(@NonNull String str) {
        return contains(FieldPath.fromDotSeparatedPath(str));
    }

    @PublicApi
    public boolean contains(@NonNull FieldPath fieldPath) {
        Preconditions.checkNotNull(fieldPath, "Provided field path must not be null.");
        Document document = this.doc;
        return (document == null || document.getField(fieldPath.getInternalPath()) == null) ? false : true;
    }

    @PublicApi
    @Nullable
    public Object get(@NonNull String str) {
        return get(FieldPath.fromDotSeparatedPath(str), ServerTimestampBehavior.DEFAULT);
    }

    @PublicApi
    @Nullable
    public Object get(@NonNull String str, @NonNull ServerTimestampBehavior serverTimestampBehavior) {
        return get(FieldPath.fromDotSeparatedPath(str), serverTimestampBehavior);
    }

    @PublicApi
    @Nullable
    public Object get(@NonNull FieldPath fieldPath) {
        return get(fieldPath, ServerTimestampBehavior.DEFAULT);
    }

    @PublicApi
    @Nullable
    public Object get(@NonNull FieldPath fieldPath, @NonNull ServerTimestampBehavior serverTimestampBehavior) {
        Preconditions.checkNotNull(fieldPath, "Provided field path must not be null.");
        Preconditions.checkNotNull(serverTimestampBehavior, "Provided serverTimestampBehavior value must not be null.");
        return getInternal(fieldPath.getInternalPath(), new FieldValueOptions(serverTimestampBehavior, this.firestore.getFirestoreSettings().areTimestampsInSnapshotsEnabled(), (AnonymousClass1) null));
    }

    @PublicApi
    @Nullable
    public <T> T get(@NonNull String str, @NonNull Class<T> cls) {
        return get(FieldPath.fromDotSeparatedPath(str), cls, ServerTimestampBehavior.DEFAULT);
    }

    @PublicApi
    @Nullable
    public <T> T get(@NonNull String str, @NonNull Class<T> cls, @NonNull ServerTimestampBehavior serverTimestampBehavior) {
        return get(FieldPath.fromDotSeparatedPath(str), cls, serverTimestampBehavior);
    }

    @PublicApi
    @Nullable
    public <T> T get(@NonNull FieldPath fieldPath, @NonNull Class<T> cls) {
        return get(fieldPath, cls, ServerTimestampBehavior.DEFAULT);
    }

    @PublicApi
    @Nullable
    public <T> T get(@NonNull FieldPath fieldPath, @NonNull Class<T> cls, @NonNull ServerTimestampBehavior serverTimestampBehavior) {
        Object obj = get(fieldPath, serverTimestampBehavior);
        if (obj == null) {
            return null;
        }
        return CustomClassMapper.convertToCustomClass(obj, cls, getReference());
    }

    @PublicApi
    @Nullable
    public Boolean getBoolean(@NonNull String str) {
        return (Boolean) getTypedValue(str, Boolean.class);
    }

    @PublicApi
    @Nullable
    public Double getDouble(@NonNull String str) {
        Number number = (Number) getTypedValue(str, Number.class);
        if (number != null) {
            return Double.valueOf(number.doubleValue());
        }
        return null;
    }

    @PublicApi
    @Nullable
    public String getString(@NonNull String str) {
        return (String) getTypedValue(str, String.class);
    }

    @PublicApi
    @Nullable
    public Long getLong(@NonNull String str) {
        Number number = (Number) getTypedValue(str, Number.class);
        if (number != null) {
            return Long.valueOf(number.longValue());
        }
        return null;
    }

    @PublicApi
    @Nullable
    public Date getDate(@NonNull String str) {
        return getDate(str, ServerTimestampBehavior.DEFAULT);
    }

    @PublicApi
    @Nullable
    public Date getDate(@NonNull String str, @NonNull ServerTimestampBehavior serverTimestampBehavior) {
        Preconditions.checkNotNull(str, "Provided field path must not be null.");
        Preconditions.checkNotNull(serverTimestampBehavior, "Provided serverTimestampBehavior value must not be null.");
        return (Date) castTypedValue(getInternal(FieldPath.fromDotSeparatedPath(str).getInternalPath(), new FieldValueOptions(serverTimestampBehavior, false, (AnonymousClass1) null)), str, Date.class);
    }

    @PublicApi
    @Nullable
    public Timestamp getTimestamp(@NonNull String str) {
        return getTimestamp(str, ServerTimestampBehavior.DEFAULT);
    }

    @PublicApi
    @Nullable
    public Timestamp getTimestamp(@NonNull String str, @NonNull ServerTimestampBehavior serverTimestampBehavior) {
        Preconditions.checkNotNull(str, "Provided field path must not be null.");
        Preconditions.checkNotNull(serverTimestampBehavior, "Provided serverTimestampBehavior value must not be null.");
        return (Timestamp) castTypedValue(getInternal(FieldPath.fromDotSeparatedPath(str).getInternalPath(), new FieldValueOptions(serverTimestampBehavior, true, (AnonymousClass1) null)), str, Timestamp.class);
    }

    @PublicApi
    @Nullable
    public Blob getBlob(@NonNull String str) {
        return (Blob) getTypedValue(str, Blob.class);
    }

    @PublicApi
    @Nullable
    public GeoPoint getGeoPoint(@NonNull String str) {
        return (GeoPoint) getTypedValue(str, GeoPoint.class);
    }

    @PublicApi
    @Nullable
    public DocumentReference getDocumentReference(@NonNull String str) {
        return (DocumentReference) getTypedValue(str, DocumentReference.class);
    }

    @PublicApi
    @NonNull
    public DocumentReference getReference() {
        return new DocumentReference(this.key, this.firestore);
    }

    @Nullable
    private <T> T getTypedValue(String str, Class<T> cls) {
        Preconditions.checkNotNull(str, "Provided field must not be null.");
        return castTypedValue(get(str, ServerTimestampBehavior.DEFAULT), str, cls);
    }

    @Nullable
    private <T> T castTypedValue(Object obj, String str, Class<T> cls) {
        if (obj == null) {
            return null;
        }
        if (cls.isInstance(obj)) {
            return cls.cast(obj);
        }
        throw new RuntimeException("Field '" + str + "' is not a " + cls.getName());
    }

    @Nullable
    private Object convertValue(FieldValue fieldValue, FieldValueOptions fieldValueOptions) {
        if (fieldValue instanceof ObjectValue) {
            return convertObject((ObjectValue) fieldValue, fieldValueOptions);
        }
        if (fieldValue instanceof ArrayValue) {
            return convertArray((ArrayValue) fieldValue, fieldValueOptions);
        }
        if (fieldValue instanceof ReferenceValue) {
            return convertReference((ReferenceValue) fieldValue);
        }
        if (fieldValue instanceof TimestampValue) {
            return convertTimestamp((TimestampValue) fieldValue, fieldValueOptions);
        }
        if (fieldValue instanceof ServerTimestampValue) {
            return convertServerTimestamp((ServerTimestampValue) fieldValue, fieldValueOptions);
        }
        return fieldValue.value();
    }

    /* renamed from: com.google.firebase.firestore.DocumentSnapshot$1  reason: invalid class name */
    /* compiled from: com.google.firebase:firebase-firestore@@20.2.0 */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$google$firebase$firestore$DocumentSnapshot$ServerTimestampBehavior = new int[ServerTimestampBehavior.values().length];

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|6) */
        /* JADX WARNING: Code restructure failed: missing block: B:7:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0014 */
        static {
            /*
                com.google.firebase.firestore.DocumentSnapshot$ServerTimestampBehavior[] r0 = com.google.firebase.firestore.DocumentSnapshot.ServerTimestampBehavior.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$com$google$firebase$firestore$DocumentSnapshot$ServerTimestampBehavior = r0
                int[] r0 = $SwitchMap$com$google$firebase$firestore$DocumentSnapshot$ServerTimestampBehavior     // Catch:{ NoSuchFieldError -> 0x0014 }
                com.google.firebase.firestore.DocumentSnapshot$ServerTimestampBehavior r1 = com.google.firebase.firestore.DocumentSnapshot.ServerTimestampBehavior.PREVIOUS     // Catch:{ NoSuchFieldError -> 0x0014 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0014 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0014 }
            L_0x0014:
                int[] r0 = $SwitchMap$com$google$firebase$firestore$DocumentSnapshot$ServerTimestampBehavior     // Catch:{ NoSuchFieldError -> 0x001f }
                com.google.firebase.firestore.DocumentSnapshot$ServerTimestampBehavior r1 = com.google.firebase.firestore.DocumentSnapshot.ServerTimestampBehavior.ESTIMATE     // Catch:{ NoSuchFieldError -> 0x001f }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001f }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001f }
            L_0x001f:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.firestore.DocumentSnapshot.AnonymousClass1.<clinit>():void");
        }
    }

    private Object convertServerTimestamp(ServerTimestampValue serverTimestampValue, FieldValueOptions fieldValueOptions) {
        int i = AnonymousClass1.$SwitchMap$com$google$firebase$firestore$DocumentSnapshot$ServerTimestampBehavior[fieldValueOptions.serverTimestampBehavior.ordinal()];
        if (i == 1) {
            return serverTimestampValue.getPreviousValue();
        }
        if (i != 2) {
            return serverTimestampValue.value();
        }
        return serverTimestampValue.getLocalWriteTime();
    }

    private Object convertTimestamp(TimestampValue timestampValue, FieldValueOptions fieldValueOptions) {
        Timestamp value = timestampValue.value();
        if (fieldValueOptions.timestampsInSnapshotsEnabled) {
            return value;
        }
        return value.toDate();
    }

    private Object convertReference(ReferenceValue referenceValue) {
        DocumentKey value = referenceValue.value();
        DatabaseId databaseId = referenceValue.getDatabaseId();
        DatabaseId databaseId2 = this.firestore.getDatabaseId();
        if (!databaseId.equals(databaseId2)) {
            Logger.warn("DocumentSnapshot", "Document %s contains a document reference within a different database (%s/%s) which is not supported. It will be treated as a reference in the current database (%s/%s) instead.", value.getPath(), databaseId.getProjectId(), databaseId.getDatabaseId(), databaseId2.getProjectId(), databaseId2.getDatabaseId());
        }
        return new DocumentReference(value, this.firestore);
    }

    private Map<String, Object> convertObject(ObjectValue objectValue, FieldValueOptions fieldValueOptions) {
        HashMap hashMap = new HashMap();
        Iterator<Map.Entry<String, FieldValue>> it = objectValue.getInternalValue().iterator();
        while (it.hasNext()) {
            Map.Entry next = it.next();
            hashMap.put((String) next.getKey(), convertValue((FieldValue) next.getValue(), fieldValueOptions));
        }
        return hashMap;
    }

    private List<Object> convertArray(ArrayValue arrayValue, FieldValueOptions fieldValueOptions) {
        ArrayList arrayList = new ArrayList(arrayValue.getInternalValue().size());
        for (FieldValue convertValue : arrayValue.getInternalValue()) {
            arrayList.add(convertValue(convertValue, fieldValueOptions));
        }
        return arrayList;
    }

    @Nullable
    private Object getInternal(@NonNull FieldPath fieldPath, @NonNull FieldValueOptions fieldValueOptions) {
        FieldValue field;
        Document document = this.doc;
        if (document == null || (field = document.getField(fieldPath)) == null) {
            return null;
        }
        return convertValue(field, fieldValueOptions);
    }

    public boolean equals(@Nullable Object obj) {
        Document document;
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof DocumentSnapshot)) {
            return false;
        }
        DocumentSnapshot documentSnapshot = (DocumentSnapshot) obj;
        if (!this.firestore.equals(documentSnapshot.firestore) || !this.key.equals(documentSnapshot.key) || ((document = this.doc) != null ? !document.equals(documentSnapshot.doc) : documentSnapshot.doc != null) || !this.metadata.equals(documentSnapshot.metadata)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int hashCode = ((this.firestore.hashCode() * 31) + this.key.hashCode()) * 31;
        Document document = this.doc;
        return ((hashCode + (document != null ? document.hashCode() : 0)) * 31) + this.metadata.hashCode();
    }

    public String toString() {
        return "DocumentSnapshot{key=" + this.key + ", metadata=" + this.metadata + ", doc=" + this.doc + '}';
    }
}
