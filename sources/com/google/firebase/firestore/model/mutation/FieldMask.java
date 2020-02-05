package com.google.firebase.firestore.model.mutation;

import com.google.firebase.firestore.model.FieldPath;
import java.util.Set;

/* compiled from: com.google.firebase:firebase-firestore@@20.2.0 */
public final class FieldMask {
    private final Set<FieldPath> mask;

    public static FieldMask fromSet(Set<FieldPath> set) {
        return new FieldMask(set);
    }

    private FieldMask(Set<FieldPath> set) {
        this.mask = set;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        return this.mask.equals(((FieldMask) obj).mask);
    }

    public String toString() {
        return "FieldMask{mask=" + this.mask.toString() + "}";
    }

    public boolean covers(FieldPath fieldPath) {
        for (FieldPath isPrefixOf : this.mask) {
            if (isPrefixOf.isPrefixOf(fieldPath)) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return this.mask.hashCode();
    }

    public Set<FieldPath> getMask() {
        return this.mask;
    }
}
