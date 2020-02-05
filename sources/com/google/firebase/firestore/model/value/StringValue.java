package com.google.firebase.firestore.model.value;

/* compiled from: com.google.firebase:firebase-firestore@@20.2.0 */
public class StringValue extends FieldValue {
    private final String internalValue;

    public int typeOrder() {
        return 4;
    }

    private StringValue(String str) {
        this.internalValue = str;
    }

    public String value() {
        return this.internalValue;
    }

    public boolean equals(Object obj) {
        return (obj instanceof StringValue) && this.internalValue.equals(((StringValue) obj).internalValue);
    }

    public int hashCode() {
        return this.internalValue.hashCode();
    }

    public int compareTo(FieldValue fieldValue) {
        if (fieldValue instanceof StringValue) {
            return this.internalValue.compareTo(((StringValue) fieldValue).internalValue);
        }
        return defaultCompareTo(fieldValue);
    }

    public static StringValue valueOf(String str) {
        return new StringValue(str);
    }
}
