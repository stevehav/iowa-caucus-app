package com.google.firebase.firestore.core;

import com.google.firebase.firestore.core.Filter;
import com.google.firebase.firestore.model.Document;
import com.google.firebase.firestore.model.FieldPath;
import com.google.firebase.firestore.model.value.ArrayValue;
import com.google.firebase.firestore.model.value.FieldValue;

/* compiled from: com.google.firebase:firebase-firestore@@20.2.0 */
public class InFilter extends FieldFilter {
    InFilter(FieldPath fieldPath, ArrayValue arrayValue) {
        super(fieldPath, Filter.Operator.IN, arrayValue);
    }

    public boolean matches(Document document) {
        ArrayValue arrayValue = (ArrayValue) getValue();
        FieldValue field = document.getField(getField());
        return field != null && arrayValue.getInternalValue().contains(field);
    }
}
