package com.google.firebase.firestore.model;

import com.google.common.base.Function;
import com.google.firebase.firestore.model.value.FieldValue;
import com.google.firebase.firestore.model.value.ObjectValue;
import com.google.firebase.firestore.util.Assert;
import com.google.firestore.v1.Value;
import java.util.Comparator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;

/* compiled from: com.google.firebase:firebase-firestore@@20.2.0 */
public final class Document extends MaybeDocument {
    private static final Comparator<Document> KEY_COMPARATOR = Document$$Lambda$1.lambdaFactory$();
    @Nullable
    private final Function<Value, FieldValue> converter;
    private final DocumentState documentState;
    @Nullable
    private Map<FieldPath, FieldValue> fieldValueCache;
    @Nullable
    private ObjectValue objectValue;
    @Nullable
    private final com.google.firestore.v1.Document proto;

    /* compiled from: com.google.firebase:firebase-firestore@@20.2.0 */
    public enum DocumentState {
        LOCAL_MUTATIONS,
        COMMITTED_MUTATIONS,
        SYNCED
    }

    public static Comparator<Document> keyComparator() {
        return KEY_COMPARATOR;
    }

    public Document(DocumentKey documentKey, SnapshotVersion snapshotVersion, DocumentState documentState2, ObjectValue objectValue2) {
        super(documentKey, snapshotVersion);
        this.documentState = documentState2;
        this.objectValue = objectValue2;
        this.proto = null;
        this.converter = null;
    }

    public Document(DocumentKey documentKey, SnapshotVersion snapshotVersion, DocumentState documentState2, com.google.firestore.v1.Document document, Function<Value, FieldValue> function) {
        super(documentKey, snapshotVersion);
        this.documentState = documentState2;
        this.proto = document;
        this.converter = function;
    }

    @Nullable
    public com.google.firestore.v1.Document getProto() {
        return this.proto;
    }

    @Nonnull
    public ObjectValue getData() {
        if (this.objectValue == null) {
            Assert.hardAssert((this.proto == null || this.converter == null) ? false : true, "Expected proto and converter to be non-null", new Object[0]);
            ObjectValue emptyObject = ObjectValue.emptyObject();
            for (Map.Entry next : this.proto.getFieldsMap().entrySet()) {
                emptyObject = emptyObject.set(FieldPath.fromSingleSegment((String) next.getKey()), this.converter.apply((Value) next.getValue()));
            }
            this.objectValue = emptyObject;
            this.fieldValueCache = null;
        }
        return this.objectValue;
    }

    @Nullable
    public FieldValue getField(FieldPath fieldPath) {
        ObjectValue objectValue2 = this.objectValue;
        if (objectValue2 != null) {
            return objectValue2.get(fieldPath);
        }
        int i = 1;
        Assert.hardAssert((this.proto == null || this.converter == null) ? false : true, "Expected proto and converter to be non-null", new Object[0]);
        if (this.fieldValueCache == null) {
            this.fieldValueCache = new ConcurrentHashMap();
        }
        FieldValue fieldValue = this.fieldValueCache.get(fieldPath);
        if (fieldValue != null) {
            return fieldValue;
        }
        Value value = this.proto.getFieldsMap().get(fieldPath.getFirstSegment());
        while (value != null && i < fieldPath.length()) {
            if (value.getValueTypeCase() != Value.ValueTypeCase.MAP_VALUE) {
                return null;
            }
            value = value.getMapValue().getFieldsMap().get(fieldPath.getSegment(i));
            i++;
        }
        if (value == null) {
            return fieldValue;
        }
        FieldValue apply = this.converter.apply(value);
        this.fieldValueCache.put(fieldPath, apply);
        return apply;
    }

    @Nullable
    public Object getFieldValue(FieldPath fieldPath) {
        FieldValue field = getField(fieldPath);
        if (field == null) {
            return null;
        }
        return field.value();
    }

    public boolean hasLocalMutations() {
        return this.documentState.equals(DocumentState.LOCAL_MUTATIONS);
    }

    public boolean hasCommittedMutations() {
        return this.documentState.equals(DocumentState.COMMITTED_MUTATIONS);
    }

    public boolean hasPendingWrites() {
        return hasLocalMutations() || hasCommittedMutations();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Document)) {
            return false;
        }
        Document document = (Document) obj;
        if (!getVersion().equals(document.getVersion()) || !getKey().equals(document.getKey()) || !this.documentState.equals(document.documentState) || !getData().equals(document.getData())) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        return (((getKey().hashCode() * 31) + getVersion().hashCode()) * 31) + this.documentState.hashCode();
    }

    public String toString() {
        return "Document{key=" + getKey() + ", data=" + getData() + ", version=" + getVersion() + ", documentState=" + this.documentState.name() + '}';
    }
}
