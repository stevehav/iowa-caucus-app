package com.google.firebase.firestore.core;

import com.google.firebase.firestore.core.Filter;
import com.google.firebase.firestore.model.Document;
import com.google.firebase.firestore.model.FieldPath;
import com.google.firebase.firestore.model.value.ArrayValue;
import com.google.firebase.firestore.model.value.FieldValue;

/* compiled from: com.google.firebase:firebase-firestore@@20.2.0 */
public class ArrayContainsFilter extends FieldFilter {
    ArrayContainsFilter(FieldPath fieldPath, FieldValue fieldValue) {
        super(fieldPath, Filter.Operator.ARRAY_CONTAINS, fieldValue);
    }

    public boolean matches(Document document) {
        FieldValue field = document.getField(getField());
        return (field instanceof ArrayValue) && ((ArrayValue) field).getInternalValue().contains(getValue());
    }
}
