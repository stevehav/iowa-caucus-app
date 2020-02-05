package com.google.firebase.firestore.local;

import android.database.Cursor;
import android.database.sqlite.SQLiteStatement;
import com.google.common.base.Preconditions;
import com.google.firebase.Timestamp;
import com.google.firebase.firestore.auth.User;
import com.google.firebase.firestore.core.Query;
import com.google.firebase.firestore.local.SQLitePersistence;
import com.google.firebase.firestore.model.DocumentKey;
import com.google.firebase.firestore.model.ResourcePath;
import com.google.firebase.firestore.model.mutation.Mutation;
import com.google.firebase.firestore.model.mutation.MutationBatch;
import com.google.firebase.firestore.proto.WriteBatch;
import com.google.firebase.firestore.remote.WriteStream;
import com.google.firebase.firestore.util.Assert;
import com.google.firebase.firestore.util.Consumer;
import com.google.protobuf.ByteString;
import com.google.protobuf.InvalidProtocolBufferException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.annotation.Nullable;

/* compiled from: com.google.firebase:firebase-firestore@@20.2.0 */
final class SQLiteMutationQueue implements MutationQueue {
    private static final int BLOB_MAX_INLINE_LENGTH = 1000000;
    private final SQLitePersistence db;
    /* access modifiers changed from: private */
    public ByteString lastStreamToken;
    /* access modifiers changed from: private */
    public int nextBatchId;
    private final LocalSerializer serializer;
    private final String uid;

    SQLiteMutationQueue(SQLitePersistence sQLitePersistence, LocalSerializer localSerializer, User user) {
        this.db = sQLitePersistence;
        this.serializer = localSerializer;
        this.uid = user.isAuthenticated() ? user.getUid() : "";
        this.lastStreamToken = WriteStream.EMPTY_STREAM_TOKEN;
    }

    public void start() {
        loadNextBatchIdAcrossAllUsers();
        if (this.db.query("SELECT last_stream_token FROM mutation_queues WHERE uid = ?").binding(this.uid).first(SQLiteMutationQueue$$Lambda$1.lambdaFactory$(this)) == 0) {
            writeMutationQueueMetadata();
        }
    }

    private void loadNextBatchIdAcrossAllUsers() {
        ArrayList<String> arrayList = new ArrayList<>();
        this.db.query("SELECT uid FROM mutation_queues").forEach(SQLiteMutationQueue$$Lambda$2.lambdaFactory$(arrayList));
        this.nextBatchId = 0;
        for (String str : arrayList) {
            this.db.query("SELECT MAX(batch_id) FROM mutations WHERE uid = ?").binding(str).forEach(SQLiteMutationQueue$$Lambda$3.lambdaFactory$(this));
        }
        this.nextBatchId++;
    }

    public boolean isEmpty() {
        return this.db.query("SELECT batch_id FROM mutations WHERE uid = ? LIMIT 1").binding(this.uid).isEmpty();
    }

    public void acknowledgeBatch(MutationBatch mutationBatch, ByteString byteString) {
        this.lastStreamToken = (ByteString) Preconditions.checkNotNull(byteString);
        writeMutationQueueMetadata();
    }

    public ByteString getLastStreamToken() {
        return this.lastStreamToken;
    }

    public void setLastStreamToken(ByteString byteString) {
        this.lastStreamToken = (ByteString) Preconditions.checkNotNull(byteString);
        writeMutationQueueMetadata();
    }

    private void writeMutationQueueMetadata() {
        this.db.execute("INSERT OR REPLACE INTO mutation_queues (uid, last_acknowledged_batch_id, last_stream_token) VALUES (?, ?, ?)", this.uid, -1, this.lastStreamToken.toByteArray());
    }

    public MutationBatch addMutationBatch(Timestamp timestamp, List<Mutation> list, List<Mutation> list2) {
        int i = this.nextBatchId;
        this.nextBatchId = i + 1;
        MutationBatch mutationBatch = new MutationBatch(i, timestamp, list, list2);
        WriteBatch encodeMutationBatch = this.serializer.encodeMutationBatch(mutationBatch);
        this.db.execute("INSERT INTO mutations (uid, batch_id, mutations) VALUES (?, ?, ?)", this.uid, Integer.valueOf(i), encodeMutationBatch.toByteArray());
        HashSet hashSet = new HashSet();
        SQLiteStatement prepare = this.db.prepare("INSERT INTO document_mutations (uid, path, batch_id) VALUES (?, ?, ?)");
        for (Mutation key : list2) {
            DocumentKey key2 = key.getKey();
            if (hashSet.add(key2)) {
                String encode = EncodedPath.encode(key2.getPath());
                this.db.execute(prepare, this.uid, encode, Integer.valueOf(i));
                this.db.getIndexManager().addToCollectionParentIndex((ResourcePath) key2.getPath().popLast());
            }
        }
        return mutationBatch;
    }

    @Nullable
    public MutationBatch lookupMutationBatch(int i) {
        return (MutationBatch) this.db.query("SELECT SUBSTR(mutations, 1, ?) FROM mutations WHERE uid = ? AND batch_id = ?").binding(Integer.valueOf(BLOB_MAX_INLINE_LENGTH), this.uid, Integer.valueOf(i)).firstValue(SQLiteMutationQueue$$Lambda$4.lambdaFactory$(this, i));
    }

    @Nullable
    public MutationBatch getNextMutationBatchAfterBatchId(int i) {
        return (MutationBatch) this.db.query("SELECT batch_id, SUBSTR(mutations, 1, ?) FROM mutations WHERE uid = ? AND batch_id >= ? ORDER BY batch_id ASC LIMIT 1").binding(Integer.valueOf(BLOB_MAX_INLINE_LENGTH), this.uid, Integer.valueOf(i + 1)).firstValue(SQLiteMutationQueue$$Lambda$5.lambdaFactory$(this));
    }

    public List<MutationBatch> getAllMutationBatches() {
        ArrayList arrayList = new ArrayList();
        this.db.query("SELECT batch_id, SUBSTR(mutations, 1, ?) FROM mutations WHERE uid = ? ORDER BY batch_id ASC").binding(Integer.valueOf(BLOB_MAX_INLINE_LENGTH), this.uid).forEach(SQLiteMutationQueue$$Lambda$6.lambdaFactory$(this, arrayList));
        return arrayList;
    }

    public List<MutationBatch> getAllMutationBatchesAffectingDocumentKey(DocumentKey documentKey) {
        String encode = EncodedPath.encode(documentKey.getPath());
        ArrayList arrayList = new ArrayList();
        this.db.query("SELECT m.batch_id, SUBSTR(m.mutations, 1, ?) FROM document_mutations dm, mutations m WHERE dm.uid = ? AND dm.path = ? AND dm.uid = m.uid AND dm.batch_id = m.batch_id ORDER BY dm.batch_id").binding(Integer.valueOf(BLOB_MAX_INLINE_LENGTH), this.uid, encode).forEach(SQLiteMutationQueue$$Lambda$7.lambdaFactory$(this, arrayList));
        return arrayList;
    }

    public List<MutationBatch> getAllMutationBatchesAffectingDocumentKeys(Iterable<DocumentKey> iterable) {
        ArrayList arrayList = new ArrayList();
        for (DocumentKey path : iterable) {
            arrayList.add(EncodedPath.encode(path.getPath()));
        }
        SQLitePersistence.LongQuery longQuery = new SQLitePersistence.LongQuery(this.db, "SELECT DISTINCT dm.batch_id, SUBSTR(m.mutations, 1, ?) FROM document_mutations dm, mutations m WHERE dm.uid = ? AND dm.path IN (", Arrays.asList(new Object[]{Integer.valueOf(BLOB_MAX_INLINE_LENGTH), this.uid}), arrayList, ") AND dm.uid = m.uid AND dm.batch_id = m.batch_id ORDER BY dm.batch_id");
        ArrayList arrayList2 = new ArrayList();
        HashSet hashSet = new HashSet();
        while (longQuery.hasMoreSubqueries()) {
            longQuery.performNextSubquery().forEach(SQLiteMutationQueue$$Lambda$8.lambdaFactory$(this, hashSet, arrayList2));
        }
        if (longQuery.getSubqueriesPerformed() > 1) {
            Collections.sort(arrayList2, SQLiteMutationQueue$$Lambda$9.lambdaFactory$());
        }
        return arrayList2;
    }

    static /* synthetic */ void lambda$getAllMutationBatchesAffectingDocumentKeys$7(SQLiteMutationQueue sQLiteMutationQueue, Set set, List list, Cursor cursor) {
        int i = cursor.getInt(0);
        if (!set.contains(Integer.valueOf(i))) {
            set.add(Integer.valueOf(i));
            list.add(sQLiteMutationQueue.decodeInlineMutationBatch(i, cursor.getBlob(1)));
        }
    }

    public List<MutationBatch> getAllMutationBatchesAffectingQuery(Query query) {
        Assert.hardAssert(!query.isCollectionGroupQuery(), "CollectionGroup queries should be handled in LocalDocumentsView", new Object[0]);
        ResourcePath path = query.getPath();
        String encode = EncodedPath.encode(path);
        String prefixSuccessor = EncodedPath.prefixSuccessor(encode);
        ArrayList arrayList = new ArrayList();
        this.db.query("SELECT dm.batch_id, dm.path, SUBSTR(m.mutations, 1, ?) FROM document_mutations dm, mutations m WHERE dm.uid = ? AND dm.path >= ? AND dm.path < ? AND dm.uid = m.uid AND dm.batch_id = m.batch_id ORDER BY dm.batch_id").binding(Integer.valueOf(BLOB_MAX_INLINE_LENGTH), this.uid, encode, prefixSuccessor).forEach(SQLiteMutationQueue$$Lambda$10.lambdaFactory$(this, arrayList, path.length() + 1));
        return arrayList;
    }

    static /* synthetic */ void lambda$getAllMutationBatchesAffectingQuery$9(SQLiteMutationQueue sQLiteMutationQueue, List list, int i, Cursor cursor) {
        int i2 = cursor.getInt(0);
        int size = list.size();
        if ((size <= 0 || i2 != ((MutationBatch) list.get(size - 1)).getBatchId()) && EncodedPath.decodeResourcePath(cursor.getString(1)).length() == i) {
            list.add(sQLiteMutationQueue.decodeInlineMutationBatch(i2, cursor.getBlob(2)));
        }
    }

    public void removeMutationBatch(MutationBatch mutationBatch) {
        SQLiteStatement prepare = this.db.prepare("DELETE FROM mutations WHERE uid = ? AND batch_id = ?");
        SQLiteStatement prepare2 = this.db.prepare("DELETE FROM document_mutations WHERE uid = ? AND path = ? AND batch_id = ?");
        int batchId = mutationBatch.getBatchId();
        Assert.hardAssert(this.db.execute(prepare, this.uid, Integer.valueOf(batchId)) != 0, "Mutation batch (%s, %d) did not exist", this.uid, Integer.valueOf(mutationBatch.getBatchId()));
        for (Mutation key : mutationBatch.getMutations()) {
            DocumentKey key2 = key.getKey();
            this.db.execute(prepare2, this.uid, EncodedPath.encode(key2.getPath()), Integer.valueOf(batchId));
            this.db.getReferenceDelegate().removeMutationReference(key2);
        }
    }

    public void performConsistencyCheck() {
        if (isEmpty()) {
            ArrayList arrayList = new ArrayList();
            this.db.query("SELECT path FROM document_mutations WHERE uid = ?").binding(this.uid).forEach(SQLiteMutationQueue$$Lambda$11.lambdaFactory$(arrayList));
            Assert.hardAssert(arrayList.isEmpty(), "Document leak -- detected dangling mutation references when queue is empty. Dangling keys: %s", arrayList);
        }
    }

    /* access modifiers changed from: private */
    public MutationBatch decodeInlineMutationBatch(int i, byte[] bArr) {
        try {
            if (bArr.length < BLOB_MAX_INLINE_LENGTH) {
                return this.serializer.decodeMutationBatch(WriteBatch.parseFrom(bArr));
            }
            BlobAccumulator blobAccumulator = new BlobAccumulator(bArr);
            while (blobAccumulator.more) {
                this.db.query("SELECT SUBSTR(mutations, ?, ?) FROM mutations WHERE uid = ? AND batch_id = ?").binding(Integer.valueOf((blobAccumulator.numChunks() * BLOB_MAX_INLINE_LENGTH) + 1), Integer.valueOf(BLOB_MAX_INLINE_LENGTH), this.uid, Integer.valueOf(i)).first(blobAccumulator);
            }
            return this.serializer.decodeMutationBatch(WriteBatch.parseFrom(blobAccumulator.result()));
        } catch (InvalidProtocolBufferException e) {
            throw Assert.fail("MutationBatch failed to parse: %s", e);
        }
    }

    /* compiled from: com.google.firebase:firebase-firestore@@20.2.0 */
    private static class BlobAccumulator implements Consumer<Cursor> {
        private final ArrayList<ByteString> chunks = new ArrayList<>();
        /* access modifiers changed from: private */
        public boolean more = true;

        BlobAccumulator(byte[] bArr) {
            addChunk(bArr);
        }

        /* access modifiers changed from: package-private */
        public int numChunks() {
            return this.chunks.size();
        }

        /* access modifiers changed from: package-private */
        public ByteString result() {
            return ByteString.copyFrom((Iterable<ByteString>) this.chunks);
        }

        public void accept(Cursor cursor) {
            byte[] blob = cursor.getBlob(0);
            addChunk(blob);
            if (blob.length < SQLiteMutationQueue.BLOB_MAX_INLINE_LENGTH) {
                this.more = false;
            }
        }

        private void addChunk(byte[] bArr) {
            this.chunks.add(ByteString.copyFrom(bArr));
        }
    }
}
