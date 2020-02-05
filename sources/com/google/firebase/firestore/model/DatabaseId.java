package com.google.firebase.firestore.model;

import androidx.annotation.NonNull;

/* compiled from: com.google.firebase:firebase-firestore@@20.2.0 */
public final class DatabaseId implements Comparable<DatabaseId> {
    public static final String DEFAULT_DATABASE_ID = "(default)";
    private final String databaseId;
    private final String projectId;

    public static DatabaseId forProject(String str) {
        return forDatabase(str, "(default)");
    }

    public static DatabaseId forDatabase(String str, String str2) {
        return new DatabaseId(str, str2);
    }

    private DatabaseId(String str, String str2) {
        this.projectId = str;
        this.databaseId = str2;
    }

    public String getProjectId() {
        return this.projectId;
    }

    public String getDatabaseId() {
        return this.databaseId;
    }

    public String toString() {
        return "DatabaseId(" + this.projectId + ", " + this.databaseId + ")";
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        DatabaseId databaseId2 = (DatabaseId) obj;
        if (!this.projectId.equals(databaseId2.projectId) || !this.databaseId.equals(databaseId2.databaseId)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        return (this.projectId.hashCode() * 31) + this.databaseId.hashCode();
    }

    public int compareTo(@NonNull DatabaseId databaseId2) {
        int compareTo = this.projectId.compareTo(databaseId2.projectId);
        return compareTo != 0 ? compareTo : this.databaseId.compareTo(databaseId2.databaseId);
    }
}
