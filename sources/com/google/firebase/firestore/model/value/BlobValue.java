package com.google.firebase.firestore.model.value;

import com.google.firebase.firestore.Blob;

/* compiled from: com.google.firebase:firebase-firestore@@20.2.0 */
public class BlobValue extends FieldValue {
    private final Blob internalValue;

    public int typeOrder() {
        return 5;
    }

    private BlobValue(Blob blob) {
        this.internalValue = blob;
    }

    public Blob value() {
        return this.internalValue;
    }

    public boolean equals(Object obj) {
        return (obj instanceof BlobValue) && this.internalValue.equals(((BlobValue) obj).internalValue);
    }

    public int hashCode() {
        return this.internalValue.hashCode();
    }

    public int compareTo(FieldValue fieldValue) {
        if (fieldValue instanceof BlobValue) {
            return this.internalValue.compareTo(((BlobValue) fieldValue).internalValue);
        }
        return defaultCompareTo(fieldValue);
    }

    public static BlobValue valueOf(Blob blob) {
        return new BlobValue(blob);
    }
}
