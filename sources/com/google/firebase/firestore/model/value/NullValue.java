package com.google.firebase.firestore.model.value;

import javax.annotation.Nullable;

/* compiled from: com.google.firebase:firebase-firestore@@20.2.0 */
public class NullValue extends FieldValue {
    private static final NullValue INSTANCE = new NullValue();

    public int hashCode() {
        return -1;
    }

    public int typeOrder() {
        return 0;
    }

    @Nullable
    public Object value() {
        return null;
    }

    private NullValue() {
    }

    public boolean equals(Object obj) {
        return obj instanceof NullValue;
    }

    public int compareTo(FieldValue fieldValue) {
        if (fieldValue instanceof NullValue) {
            return 0;
        }
        return defaultCompareTo(fieldValue);
    }

    public static NullValue nullValue() {
        return INSTANCE;
    }
}
