package com.google.firebase.firestore.model;

/* compiled from: com.google.firebase:firebase-firestore@@20.2.0 */
public final class UnknownDocument extends MaybeDocument {
    public boolean hasPendingWrites() {
        return true;
    }

    public UnknownDocument(DocumentKey documentKey, SnapshotVersion snapshotVersion) {
        super(documentKey, snapshotVersion);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        UnknownDocument unknownDocument = (UnknownDocument) obj;
        if (!getVersion().equals(unknownDocument.getVersion()) || !getKey().equals(unknownDocument.getKey())) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        return (getKey().hashCode() * 31) + getVersion().hashCode();
    }

    public String toString() {
        return "UnknownDocument{key=" + getKey() + ", version=" + getVersion() + '}';
    }
}
