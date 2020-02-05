package com.google.firebase.firestore.core;

import com.google.firebase.firestore.model.Document;
import com.google.firebase.firestore.model.FieldPath;
import com.google.firebase.firestore.model.value.FieldValue;
import com.google.firebase.firestore.util.Assert;

/* compiled from: com.google.firebase:firebase-firestore@@20.2.0 */
public class OrderBy {
    private final Direction direction;
    final FieldPath field;

    /* compiled from: com.google.firebase:firebase-firestore@@20.2.0 */
    public enum Direction {
        ASCENDING(1),
        DESCENDING(-1);
        
        private final int comparisonModifier;

        private Direction(int i) {
            this.comparisonModifier = i;
        }

        /* access modifiers changed from: package-private */
        public int getComparisonModifier() {
            return this.comparisonModifier;
        }
    }

    public static OrderBy getInstance(Direction direction2, FieldPath fieldPath) {
        return new OrderBy(direction2, fieldPath);
    }

    public Direction getDirection() {
        return this.direction;
    }

    public FieldPath getField() {
        return this.field;
    }

    private OrderBy(Direction direction2, FieldPath fieldPath) {
        this.direction = direction2;
        this.field = fieldPath;
    }

    /* access modifiers changed from: package-private */
    public int compare(Document document, Document document2) {
        int comparisonModifier;
        int compareTo;
        if (this.field.equals(FieldPath.KEY_PATH)) {
            comparisonModifier = this.direction.getComparisonModifier();
            compareTo = document.getKey().compareTo(document2.getKey());
        } else {
            FieldValue field2 = document.getField(this.field);
            FieldValue field3 = document2.getField(this.field);
            Assert.hardAssert((field2 == null || field3 == null) ? false : true, "Trying to compare documents on fields that don't exist.", new Object[0]);
            comparisonModifier = this.direction.getComparisonModifier();
            compareTo = field2.compareTo(field3);
        }
        return comparisonModifier * compareTo;
    }

    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof OrderBy)) {
            return false;
        }
        OrderBy orderBy = (OrderBy) obj;
        if (this.direction != orderBy.direction || !this.field.equals(orderBy.field)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        return ((899 + this.direction.hashCode()) * 31) + this.field.hashCode();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.direction == Direction.ASCENDING ? "" : "-");
        sb.append(this.field.canonicalString());
        return sb.toString();
    }
}
