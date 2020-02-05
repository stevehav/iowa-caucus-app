package com.google.firebase.firestore.model.value;

import com.google.firebase.firestore.model.DatabaseId;
import com.google.firebase.firestore.model.DocumentKey;

/* compiled from: com.google.firebase:firebase-firestore@@20.2.0 */
public class ReferenceValue extends FieldValue {
    private final DatabaseId databaseId;
    private final DocumentKey key;

    public int typeOrder() {
        return 6;
    }

    private ReferenceValue(DatabaseId databaseId2, DocumentKey documentKey) {
        this.databaseId = databaseId2;
        this.key = documentKey;
    }

    public DocumentKey value() {
        return this.key;
    }

    public DatabaseId getDatabaseId() {
        return this.databaseId;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof ReferenceValue)) {
            return false;
        }
        ReferenceValue referenceValue = (ReferenceValue) obj;
        if (!this.key.equals(referenceValue.key) || !this.databaseId.equals(referenceValue.databaseId)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        return ((961 + this.databaseId.hashCode()) * 31) + this.key.hashCode();
    }

    public int compareTo(FieldValue fieldValue) {
        if (!(fieldValue instanceof ReferenceValue)) {
            return defaultCompareTo(fieldValue);
        }
        ReferenceValue referenceValue = (ReferenceValue) fieldValue;
        int compareTo = this.databaseId.compareTo(referenceValue.databaseId);
        return compareTo != 0 ? compareTo : this.key.compareTo(referenceValue.key);
    }

    public static ReferenceValue valueOf(DatabaseId databaseId2, DocumentKey documentKey) {
        return new ReferenceValue(databaseId2, documentKey);
    }
}
