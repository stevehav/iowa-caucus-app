package com.google.firebase.firestore.core;

import com.google.firebase.firestore.core.DocumentViewChange;
import com.google.firebase.firestore.model.DocumentKey;
import com.google.firebase.firestore.util.Assert;
import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

/* compiled from: com.google.firebase:firebase-firestore@@20.2.0 */
public class DocumentViewChangeSet {
    private final TreeMap<DocumentKey, DocumentViewChange> changes = new TreeMap<>();

    public void addChange(DocumentViewChange documentViewChange) {
        DocumentKey key = documentViewChange.getDocument().getKey();
        DocumentViewChange documentViewChange2 = this.changes.get(key);
        if (documentViewChange2 == null) {
            this.changes.put(key, documentViewChange);
            return;
        }
        DocumentViewChange.Type type = documentViewChange2.getType();
        DocumentViewChange.Type type2 = documentViewChange.getType();
        if (type2 != DocumentViewChange.Type.ADDED && type == DocumentViewChange.Type.METADATA) {
            this.changes.put(key, documentViewChange);
        } else if (type2 == DocumentViewChange.Type.METADATA && type != DocumentViewChange.Type.REMOVED) {
            this.changes.put(key, DocumentViewChange.create(type, documentViewChange.getDocument()));
        } else if (type2 == DocumentViewChange.Type.MODIFIED && type == DocumentViewChange.Type.MODIFIED) {
            this.changes.put(key, DocumentViewChange.create(DocumentViewChange.Type.MODIFIED, documentViewChange.getDocument()));
        } else if (type2 == DocumentViewChange.Type.MODIFIED && type == DocumentViewChange.Type.ADDED) {
            this.changes.put(key, DocumentViewChange.create(DocumentViewChange.Type.ADDED, documentViewChange.getDocument()));
        } else if (type2 == DocumentViewChange.Type.REMOVED && type == DocumentViewChange.Type.ADDED) {
            this.changes.remove(key);
        } else if (type2 == DocumentViewChange.Type.REMOVED && type == DocumentViewChange.Type.MODIFIED) {
            this.changes.put(key, DocumentViewChange.create(DocumentViewChange.Type.REMOVED, documentViewChange2.getDocument()));
        } else if (type2 == DocumentViewChange.Type.ADDED && type == DocumentViewChange.Type.REMOVED) {
            this.changes.put(key, DocumentViewChange.create(DocumentViewChange.Type.MODIFIED, documentViewChange.getDocument()));
        } else {
            throw Assert.fail("Unsupported combination of changes %s after %s", type2, type);
        }
    }

    /* access modifiers changed from: package-private */
    public List<DocumentViewChange> getChanges() {
        return new ArrayList(this.changes.values());
    }
}
