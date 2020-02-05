package com.google.firebase.firestore.core;

import com.google.firebase.firestore.core.Filter;
import com.google.firebase.firestore.model.Document;
import com.google.firebase.firestore.model.FieldPath;
import com.google.firebase.firestore.model.value.ArrayValue;
import com.google.firebase.firestore.model.value.FieldValue;

/* compiled from: com.google.firebase:firebase-firestore@@20.2.0 */
public class ArrayContainsAnyFilter extends FieldFilter {
    ArrayContainsAnyFilter(FieldPath fieldPath, FieldValue fieldValue) {
        super(fieldPath, Filter.Operator.ARRAY_CONTAINS_ANY, fieldValue);
    }

    public boolean matches(Document document) {
        ArrayValue arrayValue = (ArrayValue) getValue();
        FieldValue field = document.getField(getField());
        if (!(field instanceof ArrayValue)) {
            return false;
        }
        for (FieldValue contains : ((ArrayValue) field).getInternalValue()) {
            if (arrayValue.getInternalValue().contains(contains)) {
                return true;
            }
        }
        return false;
    }
}
