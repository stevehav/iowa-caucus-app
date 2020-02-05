package com.google.firebase.firestore.remote;

import com.google.firebase.database.collection.ImmutableSortedSet;
import com.google.firebase.firestore.model.DocumentKey;
import com.google.protobuf.ByteString;

/* compiled from: com.google.firebase:firebase-firestore@@20.2.0 */
public final class TargetChange {
    private final ImmutableSortedSet<DocumentKey> addedDocuments;
    private final boolean current;
    private final ImmutableSortedSet<DocumentKey> modifiedDocuments;
    private final ImmutableSortedSet<DocumentKey> removedDocuments;
    private final ByteString resumeToken;

    public TargetChange(ByteString byteString, boolean z, ImmutableSortedSet<DocumentKey> immutableSortedSet, ImmutableSortedSet<DocumentKey> immutableSortedSet2, ImmutableSortedSet<DocumentKey> immutableSortedSet3) {
        this.resumeToken = byteString;
        this.current = z;
        this.addedDocuments = immutableSortedSet;
        this.modifiedDocuments = immutableSortedSet2;
        this.removedDocuments = immutableSortedSet3;
    }

    public ByteString getResumeToken() {
        return this.resumeToken;
    }

    public boolean isCurrent() {
        return this.current;
    }

    public ImmutableSortedSet<DocumentKey> getAddedDocuments() {
        return this.addedDocuments;
    }

    public ImmutableSortedSet<DocumentKey> getModifiedDocuments() {
        return this.modifiedDocuments;
    }

    public ImmutableSortedSet<DocumentKey> getRemovedDocuments() {
        return this.removedDocuments;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        TargetChange targetChange = (TargetChange) obj;
        if (this.current == targetChange.current && this.resumeToken.equals(targetChange.resumeToken) && this.addedDocuments.equals(targetChange.addedDocuments) && this.modifiedDocuments.equals(targetChange.modifiedDocuments)) {
            return this.removedDocuments.equals(targetChange.removedDocuments);
        }
        return false;
    }

    public int hashCode() {
        return (((((((this.resumeToken.hashCode() * 31) + (this.current ? 1 : 0)) * 31) + this.addedDocuments.hashCode()) * 31) + this.modifiedDocuments.hashCode()) * 31) + this.removedDocuments.hashCode();
    }
}
