package com.google.firebase.firestore.model.value;

/* compiled from: com.google.firebase:firebase-firestore@@20.2.0 */
public final class IntegerValue extends NumberValue {
    private final long internalValue;

    private IntegerValue(Long l) {
        this.internalValue = l.longValue();
    }

    public static IntegerValue valueOf(Long l) {
        return new IntegerValue(l);
    }

    public Long value() {
        return Long.valueOf(this.internalValue);
    }

    public boolean equals(Object obj) {
        return (obj instanceof IntegerValue) && this.internalValue == ((IntegerValue) obj).internalValue;
    }

    public int hashCode() {
        long j = this.internalValue;
        return (int) (j ^ (j >>> 32));
    }

    public long getInternalValue() {
        return this.internalValue;
    }
}
