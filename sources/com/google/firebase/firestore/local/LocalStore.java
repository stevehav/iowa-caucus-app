package com.google.firebase.firestore.local;

import android.util.SparseArray;
import com.google.firebase.Timestamp;
import com.google.firebase.database.collection.ImmutableSortedMap;
import com.google.firebase.database.collection.ImmutableSortedSet;
import com.google.firebase.firestore.auth.User;
import com.google.firebase.firestore.core.Query;
import com.google.firebase.firestore.core.TargetIdGenerator;
import com.google.firebase.firestore.local.LruGarbageCollector;
import com.google.firebase.firestore.model.Document;
import com.google.firebase.firestore.model.DocumentKey;
import com.google.firebase.firestore.model.MaybeDocument;
import com.google.firebase.firestore.model.SnapshotVersion;
import com.google.firebase.firestore.model.mutation.Mutation;
import com.google.firebase.firestore.model.mutation.MutationBatch;
import com.google.firebase.firestore.model.mutation.MutationBatchResult;
import com.google.firebase.firestore.model.mutation.PatchMutation;
import com.google.firebase.firestore.model.mutation.Precondition;
import com.google.firebase.firestore.model.value.ObjectValue;
import com.google.firebase.firestore.remote.RemoteEvent;
import com.google.firebase.firestore.remote.TargetChange;
import com.google.firebase.firestore.util.Assert;
import com.google.firebase.firestore.util.Logger;
import com.google.protobuf.ByteString;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import javax.annotation.Nullable;

/* compiled from: com.google.firebase:firebase-firestore@@20.2.0 */
public final class LocalStore {
    private static final long RESUME_TOKEN_MAX_AGE_SECONDS = TimeUnit.MINUTES.toSeconds(5);
    private LocalDocumentsView localDocuments;
    private final ReferenceSet localViewReferences;
    private MutationQueue mutationQueue;
    private final Persistence persistence;
    private final QueryCache queryCache;
    private QueryEngine queryEngine;
    private final RemoteDocumentCache remoteDocuments;
    private final TargetIdGenerator targetIdGenerator = TargetIdGenerator.forQueryCache(this.queryCache.getHighestTargetId());
    private final SparseArray<QueryData> targetIds;

    public LocalStore(Persistence persistence2, User user) {
        Assert.hardAssert(persistence2.isStarted(), "LocalStore was passed an unstarted persistence implementation", new Object[0]);
        this.persistence = persistence2;
        this.queryCache = persistence2.getQueryCache();
        this.mutationQueue = persistence2.getMutationQueue(user);
        this.remoteDocuments = persistence2.getRemoteDocumentCache();
        this.localDocuments = new LocalDocumentsView(this.remoteDocuments, this.mutationQueue, persistence2.getIndexManager());
        this.queryEngine = new SimpleQueryEngine(this.localDocuments);
        this.localViewReferences = new ReferenceSet();
        persistence2.getReferenceDelegate().setInMemoryPins(this.localViewReferences);
        this.targetIds = new SparseArray<>();
    }

    public void start() {
        startMutationQueue();
    }

    private void startMutationQueue() {
        this.persistence.runTransaction("Start MutationQueue", LocalStore$$Lambda$1.lambdaFactory$(this));
    }

    public ImmutableSortedMap<DocumentKey, MaybeDocument> handleUserChange(User user) {
        List<MutationBatch> allMutationBatches = this.mutationQueue.getAllMutationBatches();
        this.mutationQueue = this.persistence.getMutationQueue(user);
        startMutationQueue();
        List<MutationBatch> allMutationBatches2 = this.mutationQueue.getAllMutationBatches();
        this.localDocuments = new LocalDocumentsView(this.remoteDocuments, this.mutationQueue, this.persistence.getIndexManager());
        this.queryEngine = new SimpleQueryEngine(this.localDocuments);
        ImmutableSortedSet<DocumentKey> emptyKeySet = DocumentKey.emptyKeySet();
        for (List<MutationBatch> it : Arrays.asList(new List[]{allMutationBatches, allMutationBatches2})) {
            for (MutationBatch mutations : it) {
                for (Mutation key : mutations.getMutations()) {
                    emptyKeySet = emptyKeySet.insert(key.getKey());
                }
            }
        }
        return this.localDocuments.getDocuments(emptyKeySet);
    }

    public LocalWriteResult writeLocally(List<Mutation> list) {
        Timestamp now = Timestamp.now();
        HashSet hashSet = new HashSet();
        for (Mutation key : list) {
            hashSet.add(key.getKey());
        }
        return (LocalWriteResult) this.persistence.runTransaction("Locally write mutations", LocalStore$$Lambda$2.lambdaFactory$(this, hashSet, list, now));
    }

    static /* synthetic */ LocalWriteResult lambda$writeLocally$1(LocalStore localStore, Set set, List list, Timestamp timestamp) {
        ImmutableSortedMap<DocumentKey, MaybeDocument> documents = localStore.localDocuments.getDocuments(set);
        ArrayList arrayList = new ArrayList();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            Mutation mutation = (Mutation) it.next();
            ObjectValue extractBaseValue = mutation.extractBaseValue(documents.get(mutation.getKey()));
            if (extractBaseValue != null) {
                arrayList.add(new PatchMutation(mutation.getKey(), extractBaseValue, extractBaseValue.getFieldMask(), Precondition.exists(true)));
            }
        }
        MutationBatch addMutationBatch = localStore.mutationQueue.addMutationBatch(timestamp, arrayList, list);
        return new LocalWriteResult(addMutationBatch.getBatchId(), addMutationBatch.applyToLocalDocumentSet(documents));
    }

    public ImmutableSortedMap<DocumentKey, MaybeDocument> acknowledgeBatch(MutationBatchResult mutationBatchResult) {
        return (ImmutableSortedMap) this.persistence.runTransaction("Acknowledge batch", LocalStore$$Lambda$3.lambdaFactory$(this, mutationBatchResult));
    }

    static /* synthetic */ ImmutableSortedMap lambda$acknowledgeBatch$2(LocalStore localStore, MutationBatchResult mutationBatchResult) {
        MutationBatch batch = mutationBatchResult.getBatch();
        localStore.mutationQueue.acknowledgeBatch(batch, mutationBatchResult.getStreamToken());
        localStore.applyWriteToRemoteDocuments(mutationBatchResult);
        localStore.mutationQueue.performConsistencyCheck();
        return localStore.localDocuments.getDocuments(batch.getKeys());
    }

    public ImmutableSortedMap<DocumentKey, MaybeDocument> rejectBatch(int i) {
        return (ImmutableSortedMap) this.persistence.runTransaction("Reject batch", LocalStore$$Lambda$4.lambdaFactory$(this, i));
    }

    static /* synthetic */ ImmutableSortedMap lambda$rejectBatch$3(LocalStore localStore, int i) {
        MutationBatch lookupMutationBatch = localStore.mutationQueue.lookupMutationBatch(i);
        Assert.hardAssert(lookupMutationBatch != null, "Attempt to reject nonexistent batch!", new Object[0]);
        localStore.mutationQueue.removeMutationBatch(lookupMutationBatch);
        localStore.mutationQueue.performConsistencyCheck();
        return localStore.localDocuments.getDocuments(lookupMutationBatch.getKeys());
    }

    public ByteString getLastStreamToken() {
        return this.mutationQueue.getLastStreamToken();
    }

    public void setLastStreamToken(ByteString byteString) {
        this.persistence.runTransaction("Set stream token", LocalStore$$Lambda$5.lambdaFactory$(this, byteString));
    }

    public SnapshotVersion getLastRemoteSnapshotVersion() {
        return this.queryCache.getLastRemoteSnapshotVersion();
    }

    public ImmutableSortedMap<DocumentKey, MaybeDocument> applyRemoteEvent(RemoteEvent remoteEvent) {
        return (ImmutableSortedMap) this.persistence.runTransaction("Apply remote event", LocalStore$$Lambda$6.lambdaFactory$(this, remoteEvent));
    }

    static /* synthetic */ ImmutableSortedMap lambda$applyRemoteEvent$5(LocalStore localStore, RemoteEvent remoteEvent) {
        long currentSequenceNumber = localStore.persistence.getReferenceDelegate().getCurrentSequenceNumber();
        HashSet hashSet = new HashSet();
        for (Map.Entry next : remoteEvent.getTargetChanges().entrySet()) {
            Integer num = (Integer) next.getKey();
            int intValue = num.intValue();
            TargetChange targetChange = (TargetChange) next.getValue();
            QueryData queryData = localStore.targetIds.get(intValue);
            if (queryData != null) {
                Iterator<DocumentKey> it = targetChange.getAddedDocuments().iterator();
                while (it.hasNext()) {
                    hashSet.add(it.next());
                }
                Iterator<DocumentKey> it2 = targetChange.getModifiedDocuments().iterator();
                while (it2.hasNext()) {
                    hashSet.add(it2.next());
                }
                localStore.queryCache.removeMatchingKeys(targetChange.getRemovedDocuments(), intValue);
                localStore.queryCache.addMatchingKeys(targetChange.getAddedDocuments(), intValue);
                ByteString resumeToken = targetChange.getResumeToken();
                if (!resumeToken.isEmpty()) {
                    QueryData copy = queryData.copy(remoteEvent.getSnapshotVersion(), resumeToken, currentSequenceNumber);
                    localStore.targetIds.put(num.intValue(), copy);
                    if (shouldPersistQueryData(queryData, copy, targetChange)) {
                        localStore.queryCache.updateQueryData(copy);
                    }
                }
            }
        }
        HashMap hashMap = new HashMap();
        Map<DocumentKey, MaybeDocument> documentUpdates = remoteEvent.getDocumentUpdates();
        Set<DocumentKey> resolvedLimboDocuments = remoteEvent.getResolvedLimboDocuments();
        Map<DocumentKey, MaybeDocument> all = localStore.remoteDocuments.getAll(documentUpdates.keySet());
        for (Map.Entry next2 : documentUpdates.entrySet()) {
            DocumentKey documentKey = (DocumentKey) next2.getKey();
            MaybeDocument maybeDocument = (MaybeDocument) next2.getValue();
            MaybeDocument maybeDocument2 = all.get(documentKey);
            if (maybeDocument2 == null || maybeDocument.getVersion().equals(SnapshotVersion.NONE) || ((hashSet.contains(maybeDocument.getKey()) && !maybeDocument2.hasPendingWrites()) || maybeDocument.getVersion().compareTo(maybeDocument2.getVersion()) >= 0)) {
                localStore.remoteDocuments.add(maybeDocument);
                hashMap.put(documentKey, maybeDocument);
            } else {
                Logger.debug("LocalStore", "Ignoring outdated watch update for %s.Current version: %s  Watch version: %s", documentKey, maybeDocument2.getVersion(), maybeDocument.getVersion());
            }
            if (resolvedLimboDocuments.contains(documentKey)) {
                localStore.persistence.getReferenceDelegate().updateLimboDocument(documentKey);
            }
        }
        SnapshotVersion lastRemoteSnapshotVersion = localStore.queryCache.getLastRemoteSnapshotVersion();
        SnapshotVersion snapshotVersion = remoteEvent.getSnapshotVersion();
        if (!snapshotVersion.equals(SnapshotVersion.NONE)) {
            Assert.hardAssert(snapshotVersion.compareTo(lastRemoteSnapshotVersion) >= 0, "Watch stream reverted to previous snapshot?? (%s < %s)", snapshotVersion, lastRemoteSnapshotVersion);
            localStore.queryCache.setLastRemoteSnapshotVersion(snapshotVersion);
        }
        return localStore.localDocuments.getLocalViewOfDocuments(hashMap);
    }

    private static boolean shouldPersistQueryData(QueryData queryData, QueryData queryData2, TargetChange targetChange) {
        if (queryData2.getResumeToken().isEmpty()) {
            return false;
        }
        if (!queryData.getResumeToken().isEmpty() && queryData2.getSnapshotVersion().getTimestamp().getSeconds() - queryData.getSnapshotVersion().getTimestamp().getSeconds() < RESUME_TOKEN_MAX_AGE_SECONDS && targetChange.getAddedDocuments().size() + targetChange.getModifiedDocuments().size() + targetChange.getRemovedDocuments().size() <= 0) {
            return false;
        }
        return true;
    }

    public void notifyLocalViewChanges(List<LocalViewChanges> list) {
        this.persistence.runTransaction("notifyLocalViewChanges", LocalStore$$Lambda$7.lambdaFactory$(this, list));
    }

    static /* synthetic */ void lambda$notifyLocalViewChanges$6(LocalStore localStore, List list) {
        Iterator it = list.iterator();
        while (it.hasNext()) {
            LocalViewChanges localViewChanges = (LocalViewChanges) it.next();
            localStore.localViewReferences.addReferences(localViewChanges.getAdded(), localViewChanges.getTargetId());
            ImmutableSortedSet<DocumentKey> removed = localViewChanges.getRemoved();
            Iterator<DocumentKey> it2 = removed.iterator();
            while (it2.hasNext()) {
                localStore.persistence.getReferenceDelegate().removeReference(it2.next());
            }
            localStore.localViewReferences.removeReferences(removed, localViewChanges.getTargetId());
        }
    }

    @Nullable
    public MutationBatch getNextMutationBatch(int i) {
        return this.mutationQueue.getNextMutationBatchAfterBatchId(i);
    }

    @Nullable
    public MaybeDocument readDocument(DocumentKey documentKey) {
        return this.localDocuments.getDocument(documentKey);
    }

    public QueryData allocateQuery(Query query) {
        int i;
        QueryData queryData = this.queryCache.getQueryData(query);
        if (queryData != null) {
            i = queryData.getTargetId();
        } else {
            AllocateQueryHolder allocateQueryHolder = new AllocateQueryHolder();
            this.persistence.runTransaction("Allocate query", LocalStore$$Lambda$8.lambdaFactory$(this, allocateQueryHolder, query));
            i = allocateQueryHolder.targetId;
            queryData = allocateQueryHolder.cached;
        }
        Assert.hardAssert(this.targetIds.get(i) == null, "Tried to allocate an already allocated query: %s", query);
        this.targetIds.put(i, queryData);
        return queryData;
    }

    static /* synthetic */ void lambda$allocateQuery$7(LocalStore localStore, AllocateQueryHolder allocateQueryHolder, Query query) {
        allocateQueryHolder.targetId = localStore.targetIdGenerator.nextId();
        allocateQueryHolder.cached = new QueryData(query, allocateQueryHolder.targetId, localStore.persistence.getReferenceDelegate().getCurrentSequenceNumber(), QueryPurpose.LISTEN);
        localStore.queryCache.addQueryData(allocateQueryHolder.cached);
    }

    /* compiled from: com.google.firebase:firebase-firestore@@20.2.0 */
    private static class AllocateQueryHolder {
        QueryData cached;
        int targetId;

        private AllocateQueryHolder() {
        }
    }

    public void releaseQuery(Query query) {
        this.persistence.runTransaction("Release query", LocalStore$$Lambda$9.lambdaFactory$(this, query));
    }

    static /* synthetic */ void lambda$releaseQuery$8(LocalStore localStore, Query query) {
        QueryData queryData = localStore.queryCache.getQueryData(query);
        Assert.hardAssert(queryData != null, "Tried to release nonexistent query: %s", query);
        QueryData queryData2 = localStore.targetIds.get(queryData.getTargetId());
        if (queryData2.getSnapshotVersion().compareTo(queryData.getSnapshotVersion()) > 0) {
            localStore.queryCache.updateQueryData(queryData2);
        } else {
            queryData2 = queryData;
        }
        Iterator<DocumentKey> it = localStore.localViewReferences.removeReferencesForId(queryData2.getTargetId()).iterator();
        while (it.hasNext()) {
            localStore.persistence.getReferenceDelegate().removeReference(it.next());
        }
        localStore.persistence.getReferenceDelegate().removeTarget(queryData2);
        localStore.targetIds.remove(queryData2.getTargetId());
    }

    public ImmutableSortedMap<DocumentKey, Document> executeQuery(Query query) {
        return this.queryEngine.getDocumentsMatchingQuery(query);
    }

    public ImmutableSortedSet<DocumentKey> getRemoteDocumentKeys(int i) {
        return this.queryCache.getMatchingKeysForTargetId(i);
    }

    private void applyWriteToRemoteDocuments(MutationBatchResult mutationBatchResult) {
        MutationBatch batch = mutationBatchResult.getBatch();
        for (DocumentKey next : batch.getKeys()) {
            MaybeDocument maybeDocument = this.remoteDocuments.get(next);
            SnapshotVersion snapshotVersion = mutationBatchResult.getDocVersions().get(next);
            Assert.hardAssert(snapshotVersion != null, "docVersions should contain every doc in the write.", new Object[0]);
            if (maybeDocument == null || maybeDocument.getVersion().compareTo(snapshotVersion) < 0) {
                MaybeDocument applyToRemoteDocument = batch.applyToRemoteDocument(next, maybeDocument, mutationBatchResult);
                if (applyToRemoteDocument == null) {
                    Assert.hardAssert(maybeDocument == null, "Mutation batch %s applied to document %s resulted in null.", batch, maybeDocument);
                } else {
                    this.remoteDocuments.add(applyToRemoteDocument);
                }
            }
        }
        this.mutationQueue.removeMutationBatch(batch);
    }

    public LruGarbageCollector.Results collectGarbage(LruGarbageCollector lruGarbageCollector) {
        return (LruGarbageCollector.Results) this.persistence.runTransaction("Collect garbage", LocalStore$$Lambda$10.lambdaFactory$(this, lruGarbageCollector));
    }
}
