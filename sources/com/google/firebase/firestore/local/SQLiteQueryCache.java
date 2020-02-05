package com.google.firebase.firestore.local;

import android.database.Cursor;
import android.database.sqlite.SQLiteStatement;
import android.util.SparseArray;
import com.google.firebase.Timestamp;
import com.google.firebase.database.collection.ImmutableSortedSet;
import com.google.firebase.firestore.core.Query;
import com.google.firebase.firestore.model.DocumentKey;
import com.google.firebase.firestore.model.SnapshotVersion;
import com.google.firebase.firestore.proto.Target;
import com.google.firebase.firestore.util.Assert;
import com.google.firebase.firestore.util.Consumer;
import com.google.protobuf.InvalidProtocolBufferException;
import java.util.Iterator;
import javax.annotation.Nullable;

/* compiled from: com.google.firebase:firebase-firestore@@20.2.0 */
final class SQLiteQueryCache implements QueryCache {
    private final SQLitePersistence db;
    private int highestTargetId;
    private long lastListenSequenceNumber;
    private SnapshotVersion lastRemoteSnapshotVersion = SnapshotVersion.NONE;
    private final LocalSerializer localSerializer;
    private long targetCount;

    SQLiteQueryCache(SQLitePersistence sQLitePersistence, LocalSerializer localSerializer2) {
        this.db = sQLitePersistence;
        this.localSerializer = localSerializer2;
    }

    /* access modifiers changed from: package-private */
    public void start() {
        boolean z = true;
        if (this.db.query("SELECT highest_target_id, highest_listen_sequence_number, last_remote_snapshot_version_seconds, last_remote_snapshot_version_nanos, target_count FROM target_globals LIMIT 1").first(SQLiteQueryCache$$Lambda$1.lambdaFactory$(this)) != 1) {
            z = false;
        }
        Assert.hardAssert(z, "Missing target_globals entry", new Object[0]);
    }

    static /* synthetic */ void lambda$start$0(SQLiteQueryCache sQLiteQueryCache, Cursor cursor) {
        sQLiteQueryCache.highestTargetId = cursor.getInt(0);
        sQLiteQueryCache.lastListenSequenceNumber = (long) cursor.getInt(1);
        sQLiteQueryCache.lastRemoteSnapshotVersion = new SnapshotVersion(new Timestamp(cursor.getLong(2), cursor.getInt(3)));
        sQLiteQueryCache.targetCount = cursor.getLong(4);
    }

    public int getHighestTargetId() {
        return this.highestTargetId;
    }

    public long getHighestListenSequenceNumber() {
        return this.lastListenSequenceNumber;
    }

    public long getTargetCount() {
        return this.targetCount;
    }

    public void forEachTarget(Consumer<QueryData> consumer) {
        this.db.query("SELECT target_proto FROM targets").forEach(SQLiteQueryCache$$Lambda$2.lambdaFactory$(this, consumer));
    }

    public SnapshotVersion getLastRemoteSnapshotVersion() {
        return this.lastRemoteSnapshotVersion;
    }

    public void setLastRemoteSnapshotVersion(SnapshotVersion snapshotVersion) {
        this.lastRemoteSnapshotVersion = snapshotVersion;
        writeMetadata();
    }

    private void saveQueryData(QueryData queryData) {
        int targetId = queryData.getTargetId();
        String canonicalId = queryData.getQuery().getCanonicalId();
        Timestamp timestamp = queryData.getSnapshotVersion().getTimestamp();
        Target encodeQueryData = this.localSerializer.encodeQueryData(queryData);
        this.db.execute("INSERT OR REPLACE INTO targets (target_id, canonical_id, snapshot_version_seconds, snapshot_version_nanos, resume_token, last_listen_sequence_number, target_proto) VALUES (?, ?, ?, ?, ?, ?, ?)", Integer.valueOf(targetId), canonicalId, Long.valueOf(timestamp.getSeconds()), Integer.valueOf(timestamp.getNanoseconds()), queryData.getResumeToken().toByteArray(), Long.valueOf(queryData.getSequenceNumber()), encodeQueryData.toByteArray());
    }

    private boolean updateMetadata(QueryData queryData) {
        boolean z;
        if (queryData.getTargetId() > this.highestTargetId) {
            this.highestTargetId = queryData.getTargetId();
            z = true;
        } else {
            z = false;
        }
        if (queryData.getSequenceNumber() <= this.lastListenSequenceNumber) {
            return z;
        }
        this.lastListenSequenceNumber = queryData.getSequenceNumber();
        return true;
    }

    public void addQueryData(QueryData queryData) {
        saveQueryData(queryData);
        updateMetadata(queryData);
        this.targetCount++;
        writeMetadata();
    }

    public void updateQueryData(QueryData queryData) {
        saveQueryData(queryData);
        if (updateMetadata(queryData)) {
            writeMetadata();
        }
    }

    private void writeMetadata() {
        this.db.execute("UPDATE target_globals SET highest_target_id = ?, highest_listen_sequence_number = ?, last_remote_snapshot_version_seconds = ?, last_remote_snapshot_version_nanos = ?, target_count = ?", Integer.valueOf(this.highestTargetId), Long.valueOf(this.lastListenSequenceNumber), Long.valueOf(this.lastRemoteSnapshotVersion.getTimestamp().getSeconds()), Integer.valueOf(this.lastRemoteSnapshotVersion.getTimestamp().getNanoseconds()), Long.valueOf(this.targetCount));
    }

    private void removeTarget(int i) {
        removeMatchingKeysForTargetId(i);
        this.db.execute("DELETE FROM targets WHERE target_id = ?", Integer.valueOf(i));
        this.targetCount--;
    }

    public void removeQueryData(QueryData queryData) {
        removeTarget(queryData.getTargetId());
        writeMetadata();
    }

    /* access modifiers changed from: package-private */
    public int removeQueries(long j, SparseArray<?> sparseArray) {
        int[] iArr = new int[1];
        this.db.query("SELECT target_id FROM targets WHERE last_listen_sequence_number <= ?").binding(Long.valueOf(j)).forEach(SQLiteQueryCache$$Lambda$3.lambdaFactory$(this, sparseArray, iArr));
        writeMetadata();
        return iArr[0];
    }

    static /* synthetic */ void lambda$removeQueries$2(SQLiteQueryCache sQLiteQueryCache, SparseArray sparseArray, int[] iArr, Cursor cursor) {
        int i = cursor.getInt(0);
        if (sparseArray.get(i) == null) {
            sQLiteQueryCache.removeTarget(i);
            iArr[0] = iArr[0] + 1;
        }
    }

    @Nullable
    public QueryData getQueryData(Query query) {
        String canonicalId = query.getCanonicalId();
        QueryDataHolder queryDataHolder = new QueryDataHolder();
        this.db.query("SELECT target_proto FROM targets WHERE canonical_id = ?").binding(canonicalId).forEach(SQLiteQueryCache$$Lambda$4.lambdaFactory$(this, query, queryDataHolder));
        return queryDataHolder.queryData;
    }

    static /* synthetic */ void lambda$getQueryData$3(SQLiteQueryCache sQLiteQueryCache, Query query, QueryDataHolder queryDataHolder, Cursor cursor) {
        QueryData decodeQueryData = sQLiteQueryCache.decodeQueryData(cursor.getBlob(0));
        if (query.equals(decodeQueryData.getQuery())) {
            queryDataHolder.queryData = decodeQueryData;
        }
    }

    /* compiled from: com.google.firebase:firebase-firestore@@20.2.0 */
    private static class QueryDataHolder {
        QueryData queryData;

        private QueryDataHolder() {
        }
    }

    private QueryData decodeQueryData(byte[] bArr) {
        try {
            return this.localSerializer.decodeQueryData(Target.parseFrom(bArr));
        } catch (InvalidProtocolBufferException e) {
            throw Assert.fail("QueryData failed to parse: %s", e);
        }
    }

    public void addMatchingKeys(ImmutableSortedSet<DocumentKey> immutableSortedSet, int i) {
        SQLiteStatement prepare = this.db.prepare("INSERT OR IGNORE INTO target_documents (target_id, path) VALUES (?, ?)");
        SQLiteLruReferenceDelegate referenceDelegate = this.db.getReferenceDelegate();
        Iterator<DocumentKey> it = immutableSortedSet.iterator();
        while (it.hasNext()) {
            DocumentKey next = it.next();
            String encode = EncodedPath.encode(next.getPath());
            this.db.execute(prepare, Integer.valueOf(i), encode);
            referenceDelegate.addReference(next);
        }
    }

    public void removeMatchingKeys(ImmutableSortedSet<DocumentKey> immutableSortedSet, int i) {
        SQLiteStatement prepare = this.db.prepare("DELETE FROM target_documents WHERE target_id = ? AND path = ?");
        SQLiteLruReferenceDelegate referenceDelegate = this.db.getReferenceDelegate();
        Iterator<DocumentKey> it = immutableSortedSet.iterator();
        while (it.hasNext()) {
            DocumentKey next = it.next();
            String encode = EncodedPath.encode(next.getPath());
            this.db.execute(prepare, Integer.valueOf(i), encode);
            referenceDelegate.removeReference(next);
        }
    }

    private void removeMatchingKeysForTargetId(int i) {
        this.db.execute("DELETE FROM target_documents WHERE target_id = ?", Integer.valueOf(i));
    }

    public ImmutableSortedSet<DocumentKey> getMatchingKeysForTargetId(int i) {
        DocumentKeysHolder documentKeysHolder = new DocumentKeysHolder();
        this.db.query("SELECT path FROM target_documents WHERE target_id = ?").binding(Integer.valueOf(i)).forEach(SQLiteQueryCache$$Lambda$5.lambdaFactory$(documentKeysHolder));
        return documentKeysHolder.keys;
    }

    /* compiled from: com.google.firebase:firebase-firestore@@20.2.0 */
    private static class DocumentKeysHolder {
        /* access modifiers changed from: package-private */
        public ImmutableSortedSet<DocumentKey> keys;

        private DocumentKeysHolder() {
            this.keys = DocumentKey.emptyKeySet();
        }
    }

    public boolean containsKey(DocumentKey documentKey) {
        String encode = EncodedPath.encode(documentKey.getPath());
        return !this.db.query("SELECT target_id FROM target_documents WHERE path = ? AND target_id != 0 LIMIT 1").binding(encode).isEmpty();
    }
}
