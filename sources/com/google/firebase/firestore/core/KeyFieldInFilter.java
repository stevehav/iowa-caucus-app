package com.google.firebase.firestore.core;

import com.google.firebase.firestore.core.Filter;
import com.google.firebase.firestore.model.Document;
import com.google.firebase.firestore.model.FieldPath;
import com.google.firebase.firestore.model.value.ArrayValue;
import com.google.firebase.firestore.model.value.FieldValue;
import com.google.firebase.firestore.model.value.ReferenceValue;
import com.google.firebase.firestore.util.Assert;
import java.util.Iterator;

/* compiled from: com.google.firebase:firebase-firestore@@20.2.0 */
public class KeyFieldInFilter extends FieldFilter {
    KeyFieldInFilter(FieldPath fieldPath, ArrayValue arrayValue) {
        super(fieldPath, Filter.Operator.IN, arrayValue);
        for (FieldValue fieldValue : ((ArrayValue) getValue()).getInternalValue()) {
            Assert.hardAssert(fieldValue instanceof ReferenceValue, "Comparing on key with IN, but an array value was not a ReferenceValue", new Object[0]);
        }
    }

    public boolean matches(Document document) {
        Iterator<FieldValue> it = ((ArrayValue) getValue()).getInternalValue().iterator();
        while (it.hasNext()) {
            if (document.getKey().equals(((ReferenceValue) it.next()).value())) {
                return true;
            }
        }
        return false;
    }
}
