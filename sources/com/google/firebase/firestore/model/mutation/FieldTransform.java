package com.google.firebase.firestore.model.mutation;

import com.google.firebase.firestore.model.FieldPath;

/* compiled from: com.google.firebase:firebase-firestore@@20.2.0 */
public final class FieldTransform {
    private final FieldPath fieldPath;
    private final TransformOperation operation;

    public FieldTransform(FieldPath fieldPath2, TransformOperation transformOperation) {
        this.fieldPath = fieldPath2;
        this.operation = transformOperation;
    }

    public FieldPath getFieldPath() {
        return this.fieldPath;
    }

    public TransformOperation getOperation() {
        return this.operation;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        FieldTransform fieldTransform = (FieldTransform) obj;
        if (!this.fieldPath.equals(fieldTransform.fieldPath)) {
            return false;
        }
        return this.operation.equals(fieldTransform.operation);
    }

    public int hashCode() {
        return (this.fieldPath.hashCode() * 31) + this.operation.hashCode();
    }
}
