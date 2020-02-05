package com.google.firebase.firestore.model.value;

import androidx.annotation.NonNull;
import com.google.firebase.firestore.util.Assert;
import com.google.firebase.firestore.util.Util;
import javax.annotation.Nullable;

/* compiled from: com.google.firebase:firebase-firestore@@20.2.0 */
public abstract class FieldValue implements Comparable<FieldValue> {
    static final int TYPE_ORDER_ARRAY = 8;
    static final int TYPE_ORDER_BLOB = 5;
    static final int TYPE_ORDER_BOOLEAN = 1;
    static final int TYPE_ORDER_GEOPOINT = 7;
    static final int TYPE_ORDER_NULL = 0;
    static final int TYPE_ORDER_NUMBER = 2;
    static final int TYPE_ORDER_OBJECT = 9;
    static final int TYPE_ORDER_REFERENCE = 6;
    static final int TYPE_ORDER_STRING = 4;
    static final int TYPE_ORDER_TIMESTAMP = 3;

    public abstract int compareTo(@NonNull FieldValue fieldValue);

    public abstract boolean equals(Object obj);

    public abstract int hashCode();

    public abstract int typeOrder();

    @Nullable
    public abstract Object value();

    public String toString() {
        Object value = value();
        if (value == null) {
            return "null";
        }
        return value.toString();
    }

    /* access modifiers changed from: protected */
    public int defaultCompareTo(FieldValue fieldValue) {
        int compareIntegers = Util.compareIntegers(typeOrder(), fieldValue.typeOrder());
        Assert.hardAssert(compareIntegers != 0, "Default compareTo should not be used for values of same type.", new Object[0]);
        return compareIntegers;
    }
}
