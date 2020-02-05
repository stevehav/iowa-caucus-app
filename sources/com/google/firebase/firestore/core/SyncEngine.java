package com.google.firebase.firestore.core;

import androidx.annotation.VisibleForTesting;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.android.gms.tasks.Tasks;
import com.google.common.base.Function;
import com.google.firebase.database.collection.ImmutableSortedMap;
import com.google.firebase.database.collection.ImmutableSortedSet;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.auth.User;
import com.google.firebase.firestore.core.LimboDocumentChange;
import com.google.firebase.firestore.core.View;
import com.google.firebase.firestore.local.LocalStore;
import com.google.firebase.firestore.local.LocalViewChanges;
import com.google.firebase.firestore.local.LocalWriteResult;
import com.google.firebase.firestore.local.QueryData;
import com.google.firebase.firestore.local.QueryPurpose;
import com.google.firebase.firestore.local.ReferenceSet;
import com.google.firebase.firestore.model.Document;
import com.google.firebase.firestore.model.DocumentKey;
import com.google.firebase.firestore.model.MaybeDocument;
import com.google.firebase.firestore.model.NoDocument;
import com.google.firebase.firestore.model.SnapshotVersion;
import com.google.firebase.firestore.model.mutation.Mutation;
import com.google.firebase.firestore.model.mutation.MutationBatchResult;
import com.google.firebase.firestore.remote.RemoteEvent;
import com.google.firebase.firestore.remote.RemoteStore;
import com.google.firebase.firestore.remote.TargetChange;
import com.google.firebase.firestore.util.Assert;
import com.google.firebase.firestore.util.AsyncQueue;
import com.google.firebase.firestore.util.Logger;
import com.google.firebase.firestore.util.Util;
import io.grpc.Status;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import javax.annotation.Nullable;

/* compiled from: com.google.firebase:firebase-firestore@@20.2.0 */
public class SyncEngine implements RemoteStore.RemoteStoreCallback {
    private static final String TAG = "SyncEngine";
    private User currentUser;
    private final ReferenceSet limboDocumentRefs = new ReferenceSet();
    private final Map<Integer, LimboResolution> limboResolutionsByTarget = new HashMap();
    private final Map<DocumentKey, Integer> limboTargetsByKey = new HashMap();
    private final LocalStore localStore;
    private final Map<User, Map<Integer, TaskCompletionSource<Void>>> mutationUserCallbacks = new HashMap();
    private final Map<Query, QueryView> queryViewsByQuery = new HashMap();
    private final Map<Integer, QueryView> queryViewsByTarget = new HashMap();
    private final RemoteStore remoteStore;
    private SyncEngineCallback syncEngineListener;
    private final TargetIdGenerator targetIdGenerator = TargetIdGenerator.forSyncEngine();

    /* compiled from: com.google.firebase:firebase-firestore@@20.2.0 */
    interface SyncEngineCallback {
        void handleOnlineStateChange(OnlineState onlineState);

        void onError(Query query, Status status);

        void onViewSnapshots(List<ViewSnapshot> list);
    }

    /* compiled from: com.google.firebase:firebase-firestore@@20.2.0 */
    private static class LimboResolution {
        /* access modifiers changed from: private */
        public final DocumentKey key;
        /* access modifiers changed from: private */
        public boolean receivedDocument;

        LimboResolution(DocumentKey documentKey) {
            this.key = documentKey;
        }
    }

    public SyncEngine(LocalStore localStore2, RemoteStore remoteStore2, User user) {
        this.localStore = localStore2;
        this.remoteStore = remoteStore2;
        this.currentUser = user;
    }

    public void setCallback(SyncEngineCallback syncEngineCallback) {
        this.syncEngineListener = syncEngineCallback;
    }

    private void assertCallback(String str) {
        Assert.hardAssert(this.syncEngineListener != null, "Trying to call %s before setting callback", str);
    }

    public int listen(Query query) {
        assertCallback("listen");
        Assert.hardAssert(!this.queryViewsByQuery.containsKey(query), "We already listen to query: %s", query);
        QueryData allocateQuery = this.localStore.allocateQuery(query);
        this.syncEngineListener.onViewSnapshots(Collections.singletonList(initializeViewAndComputeSnapshot(allocateQuery)));
        this.remoteStore.listen(allocateQuery);
        return allocateQuery.getTargetId();
    }

    private ViewSnapshot initializeViewAndComputeSnapshot(QueryData queryData) {
        Query query = queryData.getQuery();
        ImmutableSortedMap<DocumentKey, Document> executeQuery = this.localStore.executeQuery(query);
        View view = new View(query, this.localStore.getRemoteDocumentKeys(queryData.getTargetId()));
        ViewChange applyChanges = view.applyChanges(view.computeDocChanges(executeQuery));
        Assert.hardAssert(view.getLimboDocuments().size() == 0, "View returned limbo docs before target ack from the server", new Object[0]);
        QueryView queryView = new QueryView(query, queryData.getTargetId(), view);
        this.queryViewsByQuery.put(query, queryView);
        this.queryViewsByTarget.put(Integer.valueOf(queryData.getTargetId()), queryView);
        return applyChanges.getSnapshot();
    }

    /* access modifiers changed from: package-private */
    public void stopListening(Query query) {
        assertCallback("stopListening");
        QueryView queryView = this.queryViewsByQuery.get(query);
        Assert.hardAssert(queryView != null, "Trying to stop listening to a query not found", new Object[0]);
        this.localStore.releaseQuery(query);
        this.remoteStore.stopListening(queryView.getTargetId());
        removeAndCleanupQuery(queryView);
    }

    public void writeMutations(List<Mutation> list, TaskCompletionSource<Void> taskCompletionSource) {
        assertCallback("writeMutations");
        LocalWriteResult writeLocally = this.localStore.writeLocally(list);
        addUserCallback(writeLocally.getBatchId(), taskCompletionSource);
        emitNewSnapsAndNotifyLocalStore(writeLocally.getChanges(), (RemoteEvent) null);
        this.remoteStore.fillWritePipeline();
    }

    private void addUserCallback(int i, TaskCompletionSource<Void> taskCompletionSource) {
        Map map = this.mutationUserCallbacks.get(this.currentUser);
        if (map == null) {
            map = new HashMap();
            this.mutationUserCallbacks.put(this.currentUser, map);
        }
        map.put(Integer.valueOf(i), taskCompletionSource);
    }

    public <TResult> Task<TResult> transaction(AsyncQueue asyncQueue, Function<Transaction, Task<TResult>> function, int i) {
        Assert.hardAssert(i >= 0, "Got negative number of retries for transaction.", new Object[0]);
        Transaction createTransaction = this.remoteStore.createTransaction();
        return function.apply(createTransaction).continueWithTask(asyncQueue.getExecutor(), SyncEngine$$Lambda$1.lambdaFactory$(this, createTransaction, asyncQueue, i, function));
    }

    static /* synthetic */ Task lambda$transaction$1(SyncEngine syncEngine, Transaction transaction, AsyncQueue asyncQueue, int i, Function function, Task task) throws Exception {
        if (!task.isSuccessful()) {
            return task;
        }
        return transaction.commit().continueWithTask(asyncQueue.getExecutor(), SyncEngine$$Lambda$2.lambdaFactory$(syncEngine, task, i, asyncQueue, function));
    }

    static /* synthetic */ Task lambda$transaction$0(SyncEngine syncEngine, Task task, int i, AsyncQueue asyncQueue, Function function, Task task2) throws Exception {
        if (task2.isSuccessful()) {
            return Tasks.forResult(task.getResult());
        }
        if (i == 0) {
            return Tasks.forException(new FirebaseFirestoreException("Transaction failed all retries.", FirebaseFirestoreException.Code.ABORTED, task2.getException()));
        }
        return syncEngine.transaction(asyncQueue, function, i - 1);
    }

    public void handleRemoteEvent(RemoteEvent remoteEvent) {
        assertCallback("handleRemoteEvent");
        for (Map.Entry next : remoteEvent.getTargetChanges().entrySet()) {
            TargetChange targetChange = (TargetChange) next.getValue();
            LimboResolution limboResolution = this.limboResolutionsByTarget.get((Integer) next.getKey());
            if (limboResolution != null) {
                Assert.hardAssert((targetChange.getAddedDocuments().size() + targetChange.getModifiedDocuments().size()) + targetChange.getRemovedDocuments().size() <= 1, "Limbo resolution for single document contains multiple changes.", new Object[0]);
                if (targetChange.getAddedDocuments().size() > 0) {
                    boolean unused = limboResolution.receivedDocument = true;
                } else if (targetChange.getModifiedDocuments().size() > 0) {
                    Assert.hardAssert(limboResolution.receivedDocument, "Received change for limbo target document without add.", new Object[0]);
                } else if (targetChange.getRemovedDocuments().size() > 0) {
                    Assert.hardAssert(limboResolution.receivedDocument, "Received remove for limbo target document without add.", new Object[0]);
                    boolean unused2 = limboResolution.receivedDocument = false;
                }
            }
        }
        emitNewSnapsAndNotifyLocalStore(this.localStore.applyRemoteEvent(remoteEvent), remoteEvent);
    }

    public void handleOnlineStateChange(OnlineState onlineState) {
        ArrayList arrayList = new ArrayList();
        for (Map.Entry<Query, QueryView> value : this.queryViewsByQuery.entrySet()) {
            ViewChange applyOnlineStateChange = ((QueryView) value.getValue()).getView().applyOnlineStateChange(onlineState);
            Assert.hardAssert(applyOnlineStateChange.getLimboChanges().isEmpty(), "OnlineState should not affect limbo documents.", new Object[0]);
            if (applyOnlineStateChange.getSnapshot() != null) {
                arrayList.add(applyOnlineStateChange.getSnapshot());
            }
        }
        this.syncEngineListener.onViewSnapshots(arrayList);
        this.syncEngineListener.handleOnlineStateChange(onlineState);
    }

    public ImmutableSortedSet<DocumentKey> getRemoteKeysForTarget(int i) {
        LimboResolution limboResolution = this.limboResolutionsByTarget.get(Integer.valueOf(i));
        if (limboResolution != null && limboResolution.receivedDocument) {
            return DocumentKey.emptyKeySet().insert(limboResolution.key);
        }
        QueryView queryView = this.queryViewsByTarget.get(Integer.valueOf(i));
        if (queryView != null) {
            return queryView.getView().getSyncedDocuments();
        }
        return DocumentKey.emptyKeySet();
    }

    public void handleRejectedListen(int i, Status status) {
        assertCallback("handleRejectedListen");
        LimboResolution limboResolution = this.limboResolutionsByTarget.get(Integer.valueOf(i));
        DocumentKey access$100 = limboResolution != null ? limboResolution.key : null;
        if (access$100 != null) {
            this.limboTargetsByKey.remove(access$100);
            this.limboResolutionsByTarget.remove(Integer.valueOf(i));
            handleRemoteEvent(new RemoteEvent(SnapshotVersion.NONE, Collections.emptyMap(), Collections.emptySet(), Collections.singletonMap(access$100, new NoDocument(access$100, SnapshotVersion.NONE, false)), Collections.singleton(access$100)));
            return;
        }
        QueryView queryView = this.queryViewsByTarget.get(Integer.valueOf(i));
        Assert.hardAssert(queryView != null, "Unknown target: %s", Integer.valueOf(i));
        Query query = queryView.getQuery();
        this.localStore.releaseQuery(query);
        removeAndCleanupQuery(queryView);
        logErrorIfInteresting(status, "Listen for %s failed", query);
        this.syncEngineListener.onError(query, status);
    }

    public void handleSuccessfulWrite(MutationBatchResult mutationBatchResult) {
        assertCallback("handleSuccessfulWrite");
        notifyUser(mutationBatchResult.getBatch().getBatchId(), (Status) null);
        emitNewSnapsAndNotifyLocalStore(this.localStore.acknowledgeBatch(mutationBatchResult), (RemoteEvent) null);
    }

    public void handleRejectedWrite(int i, Status status) {
        assertCallback("handleRejectedWrite");
        ImmutableSortedMap<DocumentKey, MaybeDocument> rejectBatch = this.localStore.rejectBatch(i);
        if (!rejectBatch.isEmpty()) {
            logErrorIfInteresting(status, "Write failed at %s", rejectBatch.getMinKey().getPath());
        }
        notifyUser(i, status);
        emitNewSnapsAndNotifyLocalStore(rejectBatch, (RemoteEvent) null);
    }

    private void notifyUser(int i, @Nullable Status status) {
        Map map = this.mutationUserCallbacks.get(this.currentUser);
        if (map != null) {
            Integer valueOf = Integer.valueOf(i);
            TaskCompletionSource taskCompletionSource = (TaskCompletionSource) map.get(valueOf);
            if (taskCompletionSource != null) {
                if (status != null) {
                    taskCompletionSource.setException(Util.exceptionFromStatus(status));
                } else {
                    taskCompletionSource.setResult(null);
                }
                map.remove(valueOf);
            }
        }
    }

    private void removeAndCleanupQuery(QueryView queryView) {
        this.queryViewsByQuery.remove(queryView.getQuery());
        this.queryViewsByTarget.remove(Integer.valueOf(queryView.getTargetId()));
        ImmutableSortedSet<DocumentKey> referencesForId = this.limboDocumentRefs.referencesForId(queryView.getTargetId());
        this.limboDocumentRefs.removeReferencesForId(queryView.getTargetId());
        Iterator<DocumentKey> it = referencesForId.iterator();
        while (it.hasNext()) {
            DocumentKey next = it.next();
            if (!this.limboDocumentRefs.containsKey(next)) {
                removeLimboTarget(next);
            }
        }
    }

    private void removeLimboTarget(DocumentKey documentKey) {
        Integer num = this.limboTargetsByKey.get(documentKey);
        if (num != null) {
            this.remoteStore.stopListening(num.intValue());
            this.limboTargetsByKey.remove(documentKey);
            this.limboResolutionsByTarget.remove(num);
        }
    }

    private void emitNewSnapsAndNotifyLocalStore(ImmutableSortedMap<DocumentKey, MaybeDocument> immutableSortedMap, @Nullable RemoteEvent remoteEvent) {
        TargetChange targetChange;
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        for (Map.Entry<Query, QueryView> value : this.queryViewsByQuery.entrySet()) {
            QueryView queryView = (QueryView) value.getValue();
            View view = queryView.getView();
            View.DocumentChanges computeDocChanges = view.computeDocChanges(immutableSortedMap);
            if (computeDocChanges.needsRefill()) {
                computeDocChanges = view.computeDocChanges(this.localStore.executeQuery(queryView.getQuery()), computeDocChanges);
            }
            if (remoteEvent == null) {
                targetChange = null;
            } else {
                targetChange = remoteEvent.getTargetChanges().get(Integer.valueOf(queryView.getTargetId()));
            }
            ViewChange applyChanges = queryView.getView().applyChanges(computeDocChanges, targetChange);
            updateTrackedLimboDocuments(applyChanges.getLimboChanges(), queryView.getTargetId());
            if (applyChanges.getSnapshot() != null) {
                arrayList.add(applyChanges.getSnapshot());
                arrayList2.add(LocalViewChanges.fromViewSnapshot(queryView.getTargetId(), applyChanges.getSnapshot()));
            }
        }
        this.syncEngineListener.onViewSnapshots(arrayList);
        this.localStore.notifyLocalViewChanges(arrayList2);
    }

    /* renamed from: com.google.firebase.firestore.core.SyncEngine$1  reason: invalid class name */
    /* compiled from: com.google.firebase:firebase-firestore@@20.2.0 */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$google$firebase$firestore$core$LimboDocumentChange$Type = new int[LimboDocumentChange.Type.values().length];

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|6) */
        /* JADX WARNING: Code restructure failed: missing block: B:7:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0014 */
        static {
            /*
                com.google.firebase.firestore.core.LimboDocumentChange$Type[] r0 = com.google.firebase.firestore.core.LimboDocumentChange.Type.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$com$google$firebase$firestore$core$LimboDocumentChange$Type = r0
                int[] r0 = $SwitchMap$com$google$firebase$firestore$core$LimboDocumentChange$Type     // Catch:{ NoSuchFieldError -> 0x0014 }
                com.google.firebase.firestore.core.LimboDocumentChange$Type r1 = com.google.firebase.firestore.core.LimboDocumentChange.Type.ADDED     // Catch:{ NoSuchFieldError -> 0x0014 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0014 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0014 }
            L_0x0014:
                int[] r0 = $SwitchMap$com$google$firebase$firestore$core$LimboDocumentChange$Type     // Catch:{ NoSuchFieldError -> 0x001f }
                com.google.firebase.firestore.core.LimboDocumentChange$Type r1 = com.google.firebase.firestore.core.LimboDocumentChange.Type.REMOVED     // Catch:{ NoSuchFieldError -> 0x001f }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001f }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001f }
            L_0x001f:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.firestore.core.SyncEngine.AnonymousClass1.<clinit>():void");
        }
    }

    private void updateTrackedLimboDocuments(List<LimboDocumentChange> list, int i) {
        for (LimboDocumentChange next : list) {
            int i2 = AnonymousClass1.$SwitchMap$com$google$firebase$firestore$core$LimboDocumentChange$Type[next.getType().ordinal()];
            if (i2 == 1) {
                this.limboDocumentRefs.addReference(next.getKey(), i);
                trackLimboChange(next);
            } else if (i2 == 2) {
                Logger.debug(TAG, "Document no longer in limbo: %s", next.getKey());
                DocumentKey key = next.getKey();
                this.limboDocumentRefs.removeReference(key, i);
                if (!this.limboDocumentRefs.containsKey(key)) {
                    removeLimboTarget(key);
                }
            } else {
                throw Assert.fail("Unknown limbo change type: %s", next.getType());
            }
        }
    }

    private void trackLimboChange(LimboDocumentChange limboDocumentChange) {
        DocumentKey key = limboDocumentChange.getKey();
        if (!this.limboTargetsByKey.containsKey(key)) {
            Logger.debug(TAG, "New document in limbo: %s", key);
            int nextId = this.targetIdGenerator.nextId();
            QueryData queryData = new QueryData(Query.atPath(key.getPath()), nextId, -1, QueryPurpose.LIMBO_RESOLUTION);
            this.limboResolutionsByTarget.put(Integer.valueOf(nextId), new LimboResolution(key));
            this.remoteStore.listen(queryData);
            this.limboTargetsByKey.put(key, Integer.valueOf(nextId));
        }
    }

    @VisibleForTesting
    public Map<DocumentKey, Integer> getCurrentLimboDocuments() {
        return new HashMap(this.limboTargetsByKey);
    }

    public void handleCredentialChange(User user) {
        boolean z = !this.currentUser.equals(user);
        this.currentUser = user;
        if (z) {
            emitNewSnapsAndNotifyLocalStore(this.localStore.handleUserChange(user), (RemoteEvent) null);
        }
        this.remoteStore.handleCredentialChange();
    }

    private void logErrorIfInteresting(Status status, String str, Object... objArr) {
        if (errorIsInteresting(status)) {
            Logger.warn("Firestore", "%s: %s", String.format(str, objArr), status);
        }
    }

    private boolean errorIsInteresting(Status status) {
        Status.Code code = status.getCode();
        String description = status.getDescription() != null ? status.getDescription() : "";
        if ((code != Status.Code.FAILED_PRECONDITION || !description.contains("requires an index")) && code != Status.Code.PERMISSION_DENIED) {
            return false;
        }
        return true;
    }
}
