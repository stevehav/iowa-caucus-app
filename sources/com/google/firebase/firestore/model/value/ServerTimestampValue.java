package com.google.firebase.firestore.model.value;

import com.google.firebase.Timestamp;
import javax.annotation.Nullable;

/* compiled from: com.google.firebase:firebase-firestore@@20.2.0 */
public final class ServerTimestampValue extends FieldValue {
    private final Timestamp localWriteTime;
    @Nullable
    private final FieldValue previousValue;

    public int typeOrder() {
        return 3;
    }

    @Nullable
    public Object value() {
        return null;
    }

    public ServerTimestampValue(Timestamp timestamp, @Nullable FieldValue fieldValue) {
        this.localWriteTime = timestamp;
        this.previousValue = fieldValue;
    }

    @Nullable
    public Object getPreviousValue() {
        FieldValue fieldValue = this.previousValue;
        if (fieldValue instanceof ServerTimestampValue) {
            return ((ServerTimestampValue) fieldValue).getPreviousValue();
        }
        if (fieldValue != null) {
            return fieldValue.value();
        }
        return null;
    }

    public Timestamp getLocalWriteTime() {
        return this.localWriteTime;
    }

    public String toString() {
        return "<ServerTimestamp localTime=" + this.localWriteTime.toString() + ">";
    }

    public boolean equals(Object obj) {
        return (obj instanceof ServerTimestampValue) && this.localWriteTime.equals(((ServerTimestampValue) obj).localWriteTime);
    }

    public int hashCode() {
        return this.localWriteTime.hashCode();
    }

    public int compareTo(FieldValue fieldValue) {
        if (fieldValue instanceof ServerTimestampValue) {
            return this.localWriteTime.compareTo(((ServerTimestampValue) fieldValue).localWriteTime);
        }
        if (fieldValue instanceof TimestampValue) {
            return 1;
        }
        return defaultCompareTo(fieldValue);
    }
}
