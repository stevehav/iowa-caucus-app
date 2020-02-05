package com.google.firebase.firestore.core;

import com.google.firebase.firestore.core.OrderBy;
import com.google.firebase.firestore.model.Document;
import com.google.firebase.firestore.model.DocumentKey;
import com.google.firebase.firestore.model.FieldPath;
import com.google.firebase.firestore.model.value.FieldValue;
import com.google.firebase.firestore.util.Assert;
import java.util.List;

/* compiled from: com.google.firebase:firebase-firestore@@20.2.0 */
public final class Bound {
    private final boolean before;
    private final List<FieldValue> position;

    public Bound(List<FieldValue> list, boolean z) {
        this.position = list;
        this.before = z;
    }

    public List<FieldValue> getPosition() {
        return this.position;
    }

    public boolean isBefore() {
        return this.before;
    }

    public String canonicalString() {
        StringBuilder sb = new StringBuilder();
        if (this.before) {
            sb.append("b:");
        } else {
            sb.append("a:");
        }
        for (FieldValue fieldValue : this.position) {
            sb.append(fieldValue.toString());
        }
        return sb.toString();
    }

    public boolean sortsBeforeDocument(List<OrderBy> list, Document document) {
        int i;
        Assert.hardAssert(this.position.size() <= list.size(), "Bound has more components than query's orderBy", new Object[0]);
        int i2 = 0;
        for (int i3 = 0; i3 < this.position.size(); i3++) {
            OrderBy orderBy = list.get(i3);
            FieldValue fieldValue = this.position.get(i3);
            if (orderBy.field.equals(FieldPath.KEY_PATH)) {
                Object value = fieldValue.value();
                Assert.hardAssert(value instanceof DocumentKey, "Bound has a non-key value where the key path is being used %s", fieldValue);
                i = ((DocumentKey) value).compareTo(document.getKey());
            } else {
                FieldValue field = document.getField(orderBy.getField());
                Assert.hardAssert(field != null, "Field should exist since document matched the orderBy already.", new Object[0]);
                i = fieldValue.compareTo(field);
            }
            if (orderBy.getDirection().equals(OrderBy.Direction.DESCENDING)) {
                i *= -1;
            }
            i2 = i;
            if (i2 != 0) {
                break;
            }
        }
        if (this.before) {
            if (i2 <= 0) {
                return true;
            }
        } else if (i2 < 0) {
            return true;
        }
        return false;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Bound bound = (Bound) obj;
        if (this.before != bound.before || !this.position.equals(bound.position)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        return ((this.before ? 1 : 0) * true) + this.position.hashCode();
    }

    public String toString() {
        return "Bound{before=" + this.before + ", position=" + this.position + '}';
    }
}
