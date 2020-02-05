package com.google.firebase.firestore.model.value;

import com.google.firebase.firestore.util.Util;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* compiled from: com.google.firebase:firebase-firestore@@20.2.0 */
public class ArrayValue extends FieldValue {
    private final List<FieldValue> internalValue;

    public int typeOrder() {
        return 8;
    }

    private ArrayValue(List<FieldValue> list) {
        this.internalValue = Collections.unmodifiableList(list);
    }

    public boolean equals(Object obj) {
        return (obj instanceof ArrayValue) && this.internalValue.equals(((ArrayValue) obj).internalValue);
    }

    public int hashCode() {
        return this.internalValue.hashCode();
    }

    public int compareTo(FieldValue fieldValue) {
        if (!(fieldValue instanceof ArrayValue)) {
            return defaultCompareTo(fieldValue);
        }
        ArrayValue arrayValue = (ArrayValue) fieldValue;
        int min = Math.min(this.internalValue.size(), arrayValue.internalValue.size());
        for (int i = 0; i < min; i++) {
            int compareTo = this.internalValue.get(i).compareTo(arrayValue.internalValue.get(i));
            if (compareTo != 0) {
                return compareTo;
            }
        }
        return Util.compareIntegers(this.internalValue.size(), arrayValue.internalValue.size());
    }

    public List<Object> value() {
        ArrayList arrayList = new ArrayList(this.internalValue.size());
        for (FieldValue value : this.internalValue) {
            arrayList.add(value.value());
        }
        return arrayList;
    }

    public List<FieldValue> getInternalValue() {
        return this.internalValue;
    }

    public static ArrayValue fromList(List<FieldValue> list) {
        return new ArrayValue(list);
    }
}
