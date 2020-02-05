package com.google.firebase.firestore.model;

import com.google.firebase.Timestamp;

/* compiled from: com.google.firebase:firebase-firestore@@20.2.0 */
public final class SnapshotVersion implements Comparable<SnapshotVersion> {
    public static final SnapshotVersion NONE = new SnapshotVersion(new Timestamp(0, 0));
    private final Timestamp timestamp;

    public SnapshotVersion(Timestamp timestamp2) {
        this.timestamp = timestamp2;
    }

    public Timestamp getTimestamp() {
        return this.timestamp;
    }

    public int compareTo(SnapshotVersion snapshotVersion) {
        return this.timestamp.compareTo(snapshotVersion.timestamp);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if ((obj instanceof SnapshotVersion) && compareTo((SnapshotVersion) obj) == 0) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return getTimestamp().hashCode();
    }

    public String toString() {
        return "SnapshotVersion(seconds=" + this.timestamp.getSeconds() + ", nanos=" + this.timestamp.getNanoseconds() + ")";
    }
}
