package com.google.firebase.firestore.remote;

import com.google.firebase.firestore.model.DocumentKey;
import com.google.firebase.firestore.model.MaybeDocument;
import com.google.firebase.firestore.model.SnapshotVersion;
import java.util.Map;
import java.util.Set;

/* compiled from: com.google.firebase:firebase-firestore@@20.2.0 */
public final class RemoteEvent {
    private final Map<DocumentKey, MaybeDocument> documentUpdates;
    private final Set<DocumentKey> resolvedLimboDocuments;
    private final SnapshotVersion snapshotVersion;
    private final Map<Integer, TargetChange> targetChanges;
    private final Set<Integer> targetMismatches;

    public RemoteEvent(SnapshotVersion snapshotVersion2, Map<Integer, TargetChange> map, Set<Integer> set, Map<DocumentKey, MaybeDocument> map2, Set<DocumentKey> set2) {
        this.snapshotVersion = snapshotVersion2;
        this.targetChanges = map;
        this.targetMismatches = set;
        this.documentUpdates = map2;
        this.resolvedLimboDocuments = set2;
    }

    public SnapshotVersion getSnapshotVersion() {
        return this.snapshotVersion;
    }

    public Map<Integer, TargetChange> getTargetChanges() {
        return this.targetChanges;
    }

    public Set<Integer> getTargetMismatches() {
        return this.targetMismatches;
    }

    public Map<DocumentKey, MaybeDocument> getDocumentUpdates() {
        return this.documentUpdates;
    }

    public Set<DocumentKey> getResolvedLimboDocuments() {
        return this.resolvedLimboDocuments;
    }

    public String toString() {
        return "RemoteEvent{snapshotVersion=" + this.snapshotVersion + ", targetChanges=" + this.targetChanges + ", targetMismatches=" + this.targetMismatches + ", documentUpdates=" + this.documentUpdates + ", resolvedLimboDocuments=" + this.resolvedLimboDocuments + '}';
    }
}
