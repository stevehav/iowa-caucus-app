package com.google.firebase.firestore.model.mutation;

import androidx.annotation.Nullable;
import com.google.firebase.Timestamp;
import com.google.firebase.firestore.model.value.ArrayValue;
import com.google.firebase.firestore.model.value.FieldValue;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* compiled from: com.google.firebase:firebase-firestore@@20.2.0 */
public abstract class ArrayTransformOperation implements TransformOperation {
    private final List<FieldValue> elements;

    /* access modifiers changed from: protected */
    public abstract ArrayValue apply(@Nullable FieldValue fieldValue);

    @Nullable
    public FieldValue computeBaseValue(@Nullable FieldValue fieldValue) {
        return null;
    }

    ArrayTransformOperation(List<FieldValue> list) {
        this.elements = Collections.unmodifiableList(list);
    }

    public List<FieldValue> getElements() {
        return this.elements;
    }

    public FieldValue applyToLocalView(@Nullable FieldValue fieldValue, Timestamp timestamp) {
        return apply(fieldValue);
    }

    public FieldValue applyToRemoteDocument(@Nullable FieldValue fieldValue, FieldValue fieldValue2) {
        return apply(fieldValue);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        return this.elements.equals(((ArrayTransformOperation) obj).elements);
    }

    public int hashCode() {
        return (getClass().hashCode() * 31) + this.elements.hashCode();
    }

    static ArrayList<FieldValue> coercedFieldValuesArray(@Nullable FieldValue fieldValue) {
        if (fieldValue instanceof ArrayValue) {
            return new ArrayList<>(((ArrayValue) fieldValue).getInternalValue());
        }
        return new ArrayList<>();
    }

    /* compiled from: com.google.firebase:firebase-firestore@@20.2.0 */
    public static class Union extends ArrayTransformOperation {
        public Union(List<FieldValue> list) {
            super(list);
        }

        /* access modifiers changed from: protected */
        public ArrayValue apply(@Nullable FieldValue fieldValue) {
            ArrayList<FieldValue> coercedFieldValuesArray = coercedFieldValuesArray(fieldValue);
            for (FieldValue next : getElements()) {
                if (!coercedFieldValuesArray.contains(next)) {
                    coercedFieldValuesArray.add(next);
                }
            }
            return ArrayValue.fromList(coercedFieldValuesArray);
        }
    }

    /* compiled from: com.google.firebase:firebase-firestore@@20.2.0 */
    public static class Remove extends ArrayTransformOperation {
        public Remove(List<FieldValue> list) {
            super(list);
        }

        /* access modifiers changed from: protected */
        public ArrayValue apply(@Nullable FieldValue fieldValue) {
            ArrayList<FieldValue> coercedFieldValuesArray = coercedFieldValuesArray(fieldValue);
            for (FieldValue singleton : getElements()) {
                coercedFieldValuesArray.removeAll(Collections.singleton(singleton));
            }
            return ArrayValue.fromList(coercedFieldValuesArray);
        }
    }
}
