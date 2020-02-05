package com.google.firebase.firestore.core;

import com.google.firebase.database.collection.ImmutableSortedSet;
import com.google.firebase.firestore.core.DocumentViewChange;
import com.google.firebase.firestore.model.Document;
import com.google.firebase.firestore.model.DocumentKey;
import com.google.firebase.firestore.model.DocumentSet;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: com.google.firebase:firebase-firestore@@20.2.0 */
public class ViewSnapshot {
    private final List<DocumentViewChange> changes;
    private final boolean didSyncStateChange;
    private final DocumentSet documents;
    private boolean excludesMetadataChanges;
    private final boolean isFromCache;
    private final ImmutableSortedSet<DocumentKey> mutatedKeys;
    private final DocumentSet oldDocuments;
    private final Query query;

    /* compiled from: com.google.firebase:firebase-firestore@@20.2.0 */
    public enum SyncState {
        NONE,
        LOCAL,
        SYNCED
    }

    public ViewSnapshot(Query query2, DocumentSet documentSet, DocumentSet documentSet2, List<DocumentViewChange> list, boolean z, ImmutableSortedSet<DocumentKey> immutableSortedSet, boolean z2, boolean z3) {
        this.query = query2;
        this.documents = documentSet;
        this.oldDocuments = documentSet2;
        this.changes = list;
        this.isFromCache = z;
        this.mutatedKeys = immutableSortedSet;
        this.didSyncStateChange = z2;
        this.excludesMetadataChanges = z3;
    }

    public static ViewSnapshot fromInitialDocuments(Query query2, DocumentSet documentSet, ImmutableSortedSet<DocumentKey> immutableSortedSet, boolean z, boolean z2) {
        ArrayList arrayList = new ArrayList();
        Iterator<Document> it = documentSet.iterator();
        while (it.hasNext()) {
            arrayList.add(DocumentViewChange.create(DocumentViewChange.Type.ADDED, it.next()));
        }
        return new ViewSnapshot(query2, documentSet, DocumentSet.emptySet(query2.comparator()), arrayList, z, immutableSortedSet, true, z2);
    }

    public Query getQuery() {
        return this.query;
    }

    public DocumentSet getDocuments() {
        return this.documents;
    }

    public DocumentSet getOldDocuments() {
        return this.oldDocuments;
    }

    public List<DocumentViewChange> getChanges() {
        return this.changes;
    }

    public boolean isFromCache() {
        return this.isFromCache;
    }

    public boolean hasPendingWrites() {
        return !this.mutatedKeys.isEmpty();
    }

    public ImmutableSortedSet<DocumentKey> getMutatedKeys() {
        return this.mutatedKeys;
    }

    public boolean didSyncStateChange() {
        return this.didSyncStateChange;
    }

    public boolean excludesMetadataChanges() {
        return this.excludesMetadataChanges;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ViewSnapshot)) {
            return false;
        }
        ViewSnapshot viewSnapshot = (ViewSnapshot) obj;
        if (this.isFromCache == viewSnapshot.isFromCache && this.didSyncStateChange == viewSnapshot.didSyncStateChange && this.excludesMetadataChanges == viewSnapshot.excludesMetadataChanges && this.query.equals(viewSnapshot.query) && this.mutatedKeys.equals(viewSnapshot.mutatedKeys) && this.documents.equals(viewSnapshot.documents) && this.oldDocuments.equals(viewSnapshot.oldDocuments)) {
            return this.changes.equals(viewSnapshot.changes);
        }
        return false;
    }

    public int hashCode() {
        return (((((((((((((this.query.hashCode() * 31) + this.documents.hashCode()) * 31) + this.oldDocuments.hashCode()) * 31) + this.changes.hashCode()) * 31) + this.mutatedKeys.hashCode()) * 31) + (this.isFromCache ? 1 : 0)) * 31) + (this.didSyncStateChange ? 1 : 0)) * 31) + (this.excludesMetadataChanges ? 1 : 0);
    }

    public String toString() {
        return "ViewSnapshot(" + this.query + ", " + this.documents + ", " + this.oldDocuments + ", " + this.changes + ", isFromCache=" + this.isFromCache + ", mutatedKeys=" + this.mutatedKeys.size() + ", didSyncStateChange=" + this.didSyncStateChange + ", excludesMetadataChanges=" + this.excludesMetadataChanges + ")";
    }
}
