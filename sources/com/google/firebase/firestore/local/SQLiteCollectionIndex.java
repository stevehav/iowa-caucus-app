package com.google.firebase.firestore.local;

import com.google.firebase.firestore.auth.User;
import com.google.firebase.firestore.core.IndexRange;
import com.google.firebase.firestore.model.DocumentKey;
import com.google.firebase.firestore.model.FieldPath;
import com.google.firebase.firestore.model.ResourcePath;
import com.google.firebase.firestore.model.value.FieldValue;

/* compiled from: com.google.firebase:firebase-firestore@@20.2.0 */
public class SQLiteCollectionIndex {
    private final SQLitePersistence db;
    private final String uid;

    SQLiteCollectionIndex(SQLitePersistence sQLitePersistence, User user) {
        this.db = sQLitePersistence;
        this.uid = user.isAuthenticated() ? user.getUid() : "";
    }

    public void addEntry(FieldPath fieldPath, FieldValue fieldValue, DocumentKey documentKey) {
        throw new RuntimeException("Not yet implemented.");
    }

    public void removeEntry(FieldPath fieldPath, FieldValue fieldValue, DocumentKey documentKey) {
        throw new RuntimeException("Not yet implemented.");
    }

    public IndexCursor getCursor(ResourcePath resourcePath, IndexRange indexRange) {
        throw new RuntimeException("Not yet implemented.");
    }
}
