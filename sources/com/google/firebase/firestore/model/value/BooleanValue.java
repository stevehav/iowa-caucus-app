package com.google.firebase.firestore.model.value;

import com.google.firebase.firestore.util.Util;

/* compiled from: com.google.firebase:firebase-firestore@@20.2.0 */
public class BooleanValue extends FieldValue {
    private static final BooleanValue FALSE_VALUE = new BooleanValue(Boolean.FALSE);
    private static final BooleanValue TRUE_VALUE = new BooleanValue(Boolean.TRUE);
    private final boolean internalValue;

    public boolean equals(Object obj) {
        return this == obj;
    }

    public int typeOrder() {
        return 1;
    }

    private BooleanValue(Boolean bool) {
        this.internalValue = bool.booleanValue();
    }

    public Boolean value() {
        return Boolean.valueOf(this.internalValue);
    }

    public int hashCode() {
        return this.internalValue ? 1 : 0;
    }

    public int compareTo(FieldValue fieldValue) {
        if (fieldValue instanceof BooleanValue) {
            return Util.compareBooleans(this.internalValue, ((BooleanValue) fieldValue).internalValue);
        }
        return defaultCompareTo(fieldValue);
    }

    public static BooleanValue valueOf(Boolean bool) {
        return bool.booleanValue() ? TRUE_VALUE : FALSE_VALUE;
    }
}
