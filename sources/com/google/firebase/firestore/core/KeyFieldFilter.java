package com.google.firebase.firestore.core;

import com.google.firebase.firestore.core.Filter;
import com.google.firebase.firestore.model.Document;
import com.google.firebase.firestore.model.FieldPath;
import com.google.firebase.firestore.model.value.ReferenceValue;

/* compiled from: com.google.firebase:firebase-firestore@@20.2.0 */
public class KeyFieldFilter extends FieldFilter {
    KeyFieldFilter(FieldPath fieldPath, Filter.Operator operator, ReferenceValue referenceValue) {
        super(fieldPath, operator, referenceValue);
    }

    public boolean matches(Document document) {
        return matchesComparison(document.getKey().compareTo(((ReferenceValue) getValue()).value()));
    }
}
