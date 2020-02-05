package com.google.firebase.firestore.core;

import com.google.firebase.firestore.model.DatabaseId;

/* compiled from: com.google.firebase:firebase-firestore@@20.2.0 */
public final class DatabaseInfo {
    private final DatabaseId databaseId;
    private final String host;
    private final String persistenceKey;
    private final boolean sslEnabled;

    public DatabaseInfo(DatabaseId databaseId2, String str, String str2, boolean z) {
        this.databaseId = databaseId2;
        this.persistenceKey = str;
        this.host = str2;
        this.sslEnabled = z;
    }

    public DatabaseId getDatabaseId() {
        return this.databaseId;
    }

    public String getPersistenceKey() {
        return this.persistenceKey;
    }

    public String getHost() {
        return this.host;
    }

    public boolean isSslEnabled() {
        return this.sslEnabled;
    }

    public String toString() {
        return "DatabaseInfo(databaseId:" + this.databaseId + " host:" + this.host + ")";
    }
}
