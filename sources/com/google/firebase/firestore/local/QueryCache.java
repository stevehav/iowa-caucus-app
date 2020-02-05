package com.google.firebase.firestore.local;

import com.google.firebase.database.collection.ImmutableSortedSet;
import com.google.firebase.firestore.core.Query;
import com.google.firebase.firestore.model.DocumentKey;
import com.google.firebase.firestore.model.SnapshotVersion;
import com.google.firebase.firestore.util.Consumer;
import javax.annotation.Nullable;

/* compiled from: com.google.firebase:firebase-firestore@@20.2.0 */
interface QueryCache {
    void addMatchingKeys(ImmutableSortedSet<DocumentKey> immutableSortedSet, int i);

    void addQueryData(QueryData queryData);

    boolean containsKey(DocumentKey documentKey);

    void forEachTarget(Consumer<QueryData> consumer);

    long getHighestListenSequenceNumber();

    int getHighestTargetId();

    SnapshotVersion getLastRemoteSnapshotVersion();

    ImmutableSortedSet<DocumentKey> getMatchingKeysForTargetId(int i);

    @Nullable
    QueryData getQueryData(Query query);

    long getTargetCount();

    void removeMatchingKeys(ImmutableSortedSet<DocumentKey> immutableSortedSet, int i);

    void removeQueryData(QueryData queryData);

    void setLastRemoteSnapshotVersion(SnapshotVersion snapshotVersion);

    void updateQueryData(QueryData queryData);
}
