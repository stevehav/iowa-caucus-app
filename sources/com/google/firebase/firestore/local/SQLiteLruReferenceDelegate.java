package com.google.firebase.firestore.local;

import android.database.Cursor;
import android.util.SparseArray;
import com.google.firebase.firestore.core.ListenSequence;
import com.google.firebase.firestore.local.LruGarbageCollector;
import com.google.firebase.firestore.model.DocumentKey;
import com.google.firebase.firestore.util.Assert;
import com.google.firebase.firestore.util.Consumer;

/* compiled from: com.google.firebase:firebase-firestore@@20.2.0 */
class SQLiteLruReferenceDelegate implements ReferenceDelegate, LruDelegate {
    private long currentSequenceNumber = -1;
    private final LruGarbageCollector garbageCollector;
    private ReferenceSet inMemoryPins;
    private ListenSequence listenSequence;
    private final SQLitePersistence persistence;

    SQLiteLruReferenceDelegate(SQLitePersistence sQLitePersistence, LruGarbageCollector.Params params) {
        this.persistence = sQLitePersistence;
        this.garbageCollector = new LruGarbageCollector(this, params);
    }

    /* access modifiers changed from: package-private */
    public void start(long j) {
        this.listenSequence = new ListenSequence(j);
    }

    public void onTransactionStarted() {
        Assert.hardAssert(this.currentSequenceNumber == -1, "Starting a transaction without committing the previous one", new Object[0]);
        this.currentSequenceNumber = this.listenSequence.next();
    }

    public void onTransactionCommitted() {
        Assert.hardAssert(this.currentSequenceNumber != -1, "Committing a transaction without having started one", new Object[0]);
        this.currentSequenceNumber = -1;
    }

    public long getCurrentSequenceNumber() {
        Assert.hardAssert(this.currentSequenceNumber != -1, "Attempting to get a sequence number outside of a transaction", new Object[0]);
        return this.currentSequenceNumber;
    }

    public LruGarbageCollector getGarbageCollector() {
        return this.garbageCollector;
    }

    public long getSequenceNumberCount() {
        return this.persistence.getQueryCache().getTargetCount() + ((Long) this.persistence.query("SELECT COUNT(*) FROM (SELECT sequence_number FROM target_documents GROUP BY path HAVING COUNT(*) = 1 AND target_id = 0)").firstValue(SQLiteLruReferenceDelegate$$Lambda$1.lambdaFactory$())).longValue();
    }

    public void forEachTarget(Consumer<QueryData> consumer) {
        this.persistence.getQueryCache().forEachTarget(consumer);
    }

    public void forEachOrphanedDocumentSequenceNumber(Consumer<Long> consumer) {
        this.persistence.query("select sequence_number from target_documents group by path having COUNT(*) = 1 AND target_id = 0").forEach(SQLiteLruReferenceDelegate$$Lambda$2.lambdaFactory$(consumer));
    }

    public void setInMemoryPins(ReferenceSet referenceSet) {
        this.inMemoryPins = referenceSet;
    }

    public void addReference(DocumentKey documentKey) {
        writeSentinel(documentKey);
    }

    public void removeReference(DocumentKey documentKey) {
        writeSentinel(documentKey);
    }

    public int removeTargets(long j, SparseArray<?> sparseArray) {
        return this.persistence.getQueryCache().removeQueries(j, sparseArray);
    }

    public void removeMutationReference(DocumentKey documentKey) {
        writeSentinel(documentKey);
    }

    private boolean mutationQueuesContainKey(DocumentKey documentKey) {
        return !this.persistence.query("SELECT 1 FROM document_mutations WHERE path = ?").binding(EncodedPath.encode(documentKey.getPath())).isEmpty();
    }

    private boolean isPinned(DocumentKey documentKey) {
        if (this.inMemoryPins.containsKey(documentKey)) {
            return true;
        }
        return mutationQueuesContainKey(documentKey);
    }

    private void removeSentinel(DocumentKey documentKey) {
        this.persistence.execute("DELETE FROM target_documents WHERE path = ? AND target_id = 0", EncodedPath.encode(documentKey.getPath()));
    }

    public int removeOrphanedDocuments(long j) {
        int[] iArr = new int[1];
        this.persistence.query("select path from target_documents group by path having COUNT(*) = 1 AND target_id = 0 AND sequence_number <= ?").binding(Long.valueOf(j)).forEach(SQLiteLruReferenceDelegate$$Lambda$3.lambdaFactory$(this, iArr));
        return iArr[0];
    }

    static /* synthetic */ void lambda$removeOrphanedDocuments$2(SQLiteLruReferenceDelegate sQLiteLruReferenceDelegate, int[] iArr, Cursor cursor) {
        DocumentKey fromPath = DocumentKey.fromPath(EncodedPath.decodeResourcePath(cursor.getString(0)));
        if (!sQLiteLruReferenceDelegate.isPinned(fromPath)) {
            iArr[0] = iArr[0] + 1;
            sQLiteLruReferenceDelegate.persistence.getRemoteDocumentCache().remove(fromPath);
            sQLiteLruReferenceDelegate.removeSentinel(fromPath);
        }
    }

    public void removeTarget(QueryData queryData) {
        this.persistence.getQueryCache().updateQueryData(queryData.copy(queryData.getSnapshotVersion(), queryData.getResumeToken(), getCurrentSequenceNumber()));
    }

    public void updateLimboDocument(DocumentKey documentKey) {
        writeSentinel(documentKey);
    }

    private void writeSentinel(DocumentKey documentKey) {
        String encode = EncodedPath.encode(documentKey.getPath());
        this.persistence.execute("INSERT OR REPLACE INTO target_documents (target_id, path, sequence_number) VALUES (0, ?, ?)", encode, Long.valueOf(getCurrentSequenceNumber()));
    }

    public long getByteSize() {
        return this.persistence.getByteSize();
    }
}
