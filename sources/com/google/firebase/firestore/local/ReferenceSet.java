package com.google.firebase.firestore.local;

import com.google.firebase.database.collection.ImmutableSortedSet;
import com.google.firebase.firestore.model.DocumentKey;
import java.util.Collections;
import java.util.Iterator;

/* compiled from: com.google.firebase:firebase-firestore@@20.2.0 */
public class ReferenceSet {
    private ImmutableSortedSet<DocumentReference> referencesByKey = new ImmutableSortedSet<>(Collections.emptyList(), DocumentReference.BY_KEY);
    private ImmutableSortedSet<DocumentReference> referencesByTarget = new ImmutableSortedSet<>(Collections.emptyList(), DocumentReference.BY_TARGET);

    public boolean isEmpty() {
        return this.referencesByKey.isEmpty();
    }

    public void addReference(DocumentKey documentKey, int i) {
        DocumentReference documentReference = new DocumentReference(documentKey, i);
        this.referencesByKey = this.referencesByKey.insert(documentReference);
        this.referencesByTarget = this.referencesByTarget.insert(documentReference);
    }

    public void addReferences(ImmutableSortedSet<DocumentKey> immutableSortedSet, int i) {
        Iterator<DocumentKey> it = immutableSortedSet.iterator();
        while (it.hasNext()) {
            addReference(it.next(), i);
        }
    }

    public void removeReference(DocumentKey documentKey, int i) {
        removeReference(new DocumentReference(documentKey, i));
    }

    public void removeReferences(ImmutableSortedSet<DocumentKey> immutableSortedSet, int i) {
        Iterator<DocumentKey> it = immutableSortedSet.iterator();
        while (it.hasNext()) {
            removeReference(it.next(), i);
        }
    }

    public ImmutableSortedSet<DocumentKey> removeReferencesForId(int i) {
        Iterator<DocumentReference> iteratorFrom = this.referencesByTarget.iteratorFrom(new DocumentReference(DocumentKey.empty(), i));
        ImmutableSortedSet<DocumentKey> emptyKeySet = DocumentKey.emptyKeySet();
        while (iteratorFrom.hasNext()) {
            DocumentReference next = iteratorFrom.next();
            if (next.getId() != i) {
                break;
            }
            emptyKeySet = emptyKeySet.insert(next.getKey());
            removeReference(next);
        }
        return emptyKeySet;
    }

    public void removeAllReferences() {
        Iterator<DocumentReference> it = this.referencesByKey.iterator();
        while (it.hasNext()) {
            removeReference(it.next());
        }
    }

    private void removeReference(DocumentReference documentReference) {
        this.referencesByKey = this.referencesByKey.remove(documentReference);
        this.referencesByTarget = this.referencesByTarget.remove(documentReference);
    }

    public ImmutableSortedSet<DocumentKey> referencesForId(int i) {
        Iterator<DocumentReference> iteratorFrom = this.referencesByTarget.iteratorFrom(new DocumentReference(DocumentKey.empty(), i));
        ImmutableSortedSet<DocumentKey> emptyKeySet = DocumentKey.emptyKeySet();
        while (iteratorFrom.hasNext()) {
            DocumentReference next = iteratorFrom.next();
            if (next.getId() != i) {
                break;
            }
            emptyKeySet = emptyKeySet.insert(next.getKey());
        }
        return emptyKeySet;
    }

    public boolean containsKey(DocumentKey documentKey) {
        Iterator<DocumentReference> iteratorFrom = this.referencesByKey.iteratorFrom(new DocumentReference(documentKey, 0));
        if (!iteratorFrom.hasNext()) {
            return false;
        }
        return iteratorFrom.next().getKey().equals(documentKey);
    }
}
