package com.google.firebase.firestore.remote;

import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import com.google.firebase.database.collection.ImmutableSortedSet;
import com.google.firebase.firestore.core.OnlineState;
import com.google.firebase.firestore.core.Transaction;
import com.google.firebase.firestore.local.LocalStore;
import com.google.firebase.firestore.local.QueryData;
import com.google.firebase.firestore.local.QueryPurpose;
import com.google.firebase.firestore.model.DocumentKey;
import com.google.firebase.firestore.model.SnapshotVersion;
import com.google.firebase.firestore.model.mutation.MutationBatch;
import com.google.firebase.firestore.model.mutation.MutationBatchResult;
import com.google.firebase.firestore.model.mutation.MutationResult;
import com.google.firebase.firestore.remote.WatchChange;
import com.google.firebase.firestore.remote.WatchChangeAggregator;
import com.google.firebase.firestore.remote.WatchStream;
import com.google.firebase.firestore.remote.WriteStream;
import com.google.firebase.firestore.util.Assert;
import com.google.firebase.firestore.util.AsyncQueue;
import com.google.firebase.firestore.util.Logger;
import com.google.firebase.firestore.util.Util;
import com.google.protobuf.ByteString;
import io.grpc.Status;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* compiled from: com.google.firebase:firebase-firestore@@20.2.0 */
public final class RemoteStore implements WatchChangeAggregator.TargetMetadataProvider {
    private static final String LOG_TAG = "RemoteStore";
    private static final int MAX_PENDING_WRITES = 10;
    private final ConnectivityMonitor connectivityMonitor;
    private final Datastore datastore;
    private final Map<Integer, QueryData> listenTargets;
    private final LocalStore localStore;
    private boolean networkEnabled = false;
    private final OnlineStateTracker onlineStateTracker;
    private final RemoteStoreCallback remoteStoreCallback;
    @Nullable
    private WatchChangeAggregator watchChangeAggregator;
    private final WatchStream watchStream;
    private final Deque<MutationBatch> writePipeline;
    /* access modifiers changed from: private */
    public final WriteStream writeStream;

    /* compiled from: com.google.firebase:firebase-firestore@@20.2.0 */
    public interface RemoteStoreCallback {
        ImmutableSortedSet<DocumentKey> getRemoteKeysForTarget(int i);

        void handleOnlineStateChange(OnlineState onlineState);

        void handleRejectedListen(int i, Status status);

        void handleRejectedWrite(int i, Status status);

        void handleRemoteEvent(RemoteEvent remoteEvent);

        void handleSuccessfulWrite(MutationBatchResult mutationBatchResult);
    }

    public RemoteStore(RemoteStoreCallback remoteStoreCallback2, LocalStore localStore2, Datastore datastore2, AsyncQueue asyncQueue, ConnectivityMonitor connectivityMonitor2) {
        this.remoteStoreCallback = remoteStoreCallback2;
        this.localStore = localStore2;
        this.datastore = datastore2;
        this.connectivityMonitor = connectivityMonitor2;
        this.listenTargets = new HashMap();
        this.writePipeline = new ArrayDeque();
        remoteStoreCallback2.getClass();
        this.onlineStateTracker = new OnlineStateTracker(asyncQueue, RemoteStore$$Lambda$1.lambdaFactory$(remoteStoreCallback2));
        this.watchStream = datastore2.createWatchStream(new WatchStream.Callback() {
            public void onOpen() {
                RemoteStore.this.handleWatchStreamOpen();
            }

            public void onWatchChange(SnapshotVersion snapshotVersion, WatchChange watchChange) {
                RemoteStore.this.handleWatchChange(snapshotVersion, watchChange);
            }

            public void onClose(Status status) {
                RemoteStore.this.handleWatchStreamClose(status);
            }
        });
        this.writeStream = datastore2.createWriteStream(new WriteStream.Callback() {
            public void onOpen() {
                RemoteStore.this.writeStream.writeHandshake();
            }

            public void onHandshakeComplete() {
                RemoteStore.this.handleWriteStreamHandshakeComplete();
            }

            public void onWriteResponse(SnapshotVersion snapshotVersion, List<MutationResult> list) {
                RemoteStore.this.handleWriteStreamMutationResults(snapshotVersion, list);
            }

            public void onClose(Status status) {
                RemoteStore.this.handleWriteStreamClose(status);
            }
        });
        connectivityMonitor2.addCallback(RemoteStore$$Lambda$2.lambdaFactory$(this, asyncQueue));
    }

    static /* synthetic */ void lambda$new$0(RemoteStore remoteStore) {
        if (remoteStore.canUseNetwork()) {
            Logger.debug(LOG_TAG, "Restarting streams for network reachability change.", new Object[0]);
            remoteStore.restartNetwork();
        }
    }

    public void enableNetwork() {
        this.networkEnabled = true;
        if (canUseNetwork()) {
            this.writeStream.setLastStreamToken(this.localStore.getLastStreamToken());
            if (shouldStartWatchStream()) {
                startWatchStream();
            } else {
                this.onlineStateTracker.updateState(OnlineState.UNKNOWN);
            }
            fillWritePipeline();
        }
    }

    /* access modifiers changed from: package-private */
    @VisibleForTesting
    public void forceEnableNetwork() {
        enableNetwork();
        this.onlineStateTracker.updateState(OnlineState.ONLINE);
    }

    public void disableNetwork() {
        this.networkEnabled = false;
        disableNetworkInternal();
        this.onlineStateTracker.updateState(OnlineState.OFFLINE);
    }

    private void disableNetworkInternal() {
        this.watchStream.stop();
        this.writeStream.stop();
        if (!this.writePipeline.isEmpty()) {
            Logger.debug(LOG_TAG, "Stopping write stream with %d pending writes", Integer.valueOf(this.writePipeline.size()));
            this.writePipeline.clear();
        }
        cleanUpWatchStreamState();
    }

    private void restartNetwork() {
        this.networkEnabled = false;
        disableNetworkInternal();
        this.onlineStateTracker.updateState(OnlineState.UNKNOWN);
        enableNetwork();
    }

    public void start() {
        enableNetwork();
    }

    public void shutdown() {
        Logger.debug(LOG_TAG, "Shutting down", new Object[0]);
        this.connectivityMonitor.shutdown();
        this.networkEnabled = false;
        disableNetworkInternal();
        this.datastore.shutdown();
        this.onlineStateTracker.updateState(OnlineState.UNKNOWN);
    }

    public void handleCredentialChange() {
        if (canUseNetwork()) {
            Logger.debug(LOG_TAG, "Restarting streams for new credential.", new Object[0]);
            restartNetwork();
        }
    }

    public void listen(QueryData queryData) {
        Integer valueOf = Integer.valueOf(queryData.getTargetId());
        Assert.hardAssert(!this.listenTargets.containsKey(valueOf), "listen called with duplicate target ID: %d", valueOf);
        this.listenTargets.put(valueOf, queryData);
        if (shouldStartWatchStream()) {
            startWatchStream();
        } else if (this.watchStream.isOpen()) {
            sendWatchRequest(queryData);
        }
    }

    private void sendWatchRequest(QueryData queryData) {
        this.watchChangeAggregator.recordPendingTargetRequest(queryData.getTargetId());
        this.watchStream.watchQuery(queryData);
    }

    public void stopListening(int i) {
        Assert.hardAssert(this.listenTargets.remove(Integer.valueOf(i)) != null, "stopListening called on target no currently watched: %d", Integer.valueOf(i));
        if (this.watchStream.isOpen()) {
            sendUnwatchRequest(i);
        }
        if (!this.listenTargets.isEmpty()) {
            return;
        }
        if (this.watchStream.isOpen()) {
            this.watchStream.markIdle();
        } else if (canUseNetwork()) {
            this.onlineStateTracker.updateState(OnlineState.UNKNOWN);
        }
    }

    private void sendUnwatchRequest(int i) {
        this.watchChangeAggregator.recordPendingTargetRequest(i);
        this.watchStream.unwatchTarget(i);
    }

    private boolean shouldStartWriteStream() {
        return canUseNetwork() && !this.writeStream.isStarted() && !this.writePipeline.isEmpty();
    }

    private boolean shouldStartWatchStream() {
        return canUseNetwork() && !this.watchStream.isStarted() && !this.listenTargets.isEmpty();
    }

    private void cleanUpWatchStreamState() {
        this.watchChangeAggregator = null;
    }

    private void startWatchStream() {
        Assert.hardAssert(shouldStartWatchStream(), "startWatchStream() called when shouldStartWatchStream() is false.", new Object[0]);
        this.watchChangeAggregator = new WatchChangeAggregator(this);
        this.watchStream.start();
        this.onlineStateTracker.handleWatchStreamStart();
    }

    /* access modifiers changed from: private */
    public void handleWatchStreamOpen() {
        for (QueryData sendWatchRequest : this.listenTargets.values()) {
            sendWatchRequest(sendWatchRequest);
        }
    }

    /* access modifiers changed from: private */
    public void handleWatchChange(SnapshotVersion snapshotVersion, WatchChange watchChange) {
        this.onlineStateTracker.updateState(OnlineState.ONLINE);
        Assert.hardAssert((this.watchStream == null || this.watchChangeAggregator == null) ? false : true, "WatchStream and WatchStreamAggregator should both be non-null", new Object[0]);
        boolean z = watchChange instanceof WatchChange.WatchTargetChange;
        WatchChange.WatchTargetChange watchTargetChange = z ? (WatchChange.WatchTargetChange) watchChange : null;
        if (watchTargetChange == null || !watchTargetChange.getChangeType().equals(WatchChange.WatchTargetChangeType.Removed) || watchTargetChange.getCause() == null) {
            if (watchChange instanceof WatchChange.DocumentChange) {
                this.watchChangeAggregator.handleDocumentChange((WatchChange.DocumentChange) watchChange);
            } else if (watchChange instanceof WatchChange.ExistenceFilterWatchChange) {
                this.watchChangeAggregator.handleExistenceFilter((WatchChange.ExistenceFilterWatchChange) watchChange);
            } else {
                Assert.hardAssert(z, "Expected watchChange to be an instance of WatchTargetChange", new Object[0]);
                this.watchChangeAggregator.handleTargetChange((WatchChange.WatchTargetChange) watchChange);
            }
            if (!snapshotVersion.equals(SnapshotVersion.NONE) && snapshotVersion.compareTo(this.localStore.getLastRemoteSnapshotVersion()) >= 0) {
                raiseWatchSnapshot(snapshotVersion);
                return;
            }
            return;
        }
        processTargetError(watchTargetChange);
    }

    /* access modifiers changed from: private */
    public void handleWatchStreamClose(Status status) {
        if (Status.OK.equals(status)) {
            Assert.hardAssert(!shouldStartWatchStream(), "Watch stream was stopped gracefully while still needed.", new Object[0]);
        }
        cleanUpWatchStreamState();
        if (shouldStartWatchStream()) {
            this.onlineStateTracker.handleWatchStreamFailure(status);
            startWatchStream();
            return;
        }
        this.onlineStateTracker.updateState(OnlineState.UNKNOWN);
    }

    private boolean canUseNetwork() {
        return this.networkEnabled;
    }

    private void raiseWatchSnapshot(SnapshotVersion snapshotVersion) {
        Assert.hardAssert(!snapshotVersion.equals(SnapshotVersion.NONE), "Can't raise event for unknown SnapshotVersion", new Object[0]);
        RemoteEvent createRemoteEvent = this.watchChangeAggregator.createRemoteEvent(snapshotVersion);
        for (Map.Entry next : createRemoteEvent.getTargetChanges().entrySet()) {
            TargetChange targetChange = (TargetChange) next.getValue();
            if (!targetChange.getResumeToken().isEmpty()) {
                int intValue = ((Integer) next.getKey()).intValue();
                QueryData queryData = this.listenTargets.get(Integer.valueOf(intValue));
                if (queryData != null) {
                    this.listenTargets.put(Integer.valueOf(intValue), queryData.copy(snapshotVersion, targetChange.getResumeToken(), queryData.getSequenceNumber()));
                }
            }
        }
        for (Integer intValue2 : createRemoteEvent.getTargetMismatches()) {
            int intValue3 = intValue2.intValue();
            QueryData queryData2 = this.listenTargets.get(Integer.valueOf(intValue3));
            if (queryData2 != null) {
                this.listenTargets.put(Integer.valueOf(intValue3), queryData2.copy(queryData2.getSnapshotVersion(), ByteString.EMPTY, queryData2.getSequenceNumber()));
                sendUnwatchRequest(intValue3);
                sendWatchRequest(new QueryData(queryData2.getQuery(), intValue3, queryData2.getSequenceNumber(), QueryPurpose.EXISTENCE_FILTER_MISMATCH));
            }
        }
        this.remoteStoreCallback.handleRemoteEvent(createRemoteEvent);
    }

    private void processTargetError(WatchChange.WatchTargetChange watchTargetChange) {
        Assert.hardAssert(watchTargetChange.getCause() != null, "Processing target error without a cause", new Object[0]);
        for (Integer next : watchTargetChange.getTargetIds()) {
            if (this.listenTargets.containsKey(next)) {
                this.listenTargets.remove(next);
                this.watchChangeAggregator.removeTarget(next.intValue());
                this.remoteStoreCallback.handleRejectedListen(next.intValue(), watchTargetChange.getCause());
            }
        }
    }

    public void fillWritePipeline() {
        int batchId = this.writePipeline.isEmpty() ? -1 : this.writePipeline.getLast().getBatchId();
        while (true) {
            if (!canAddToWritePipeline()) {
                break;
            }
            MutationBatch nextMutationBatch = this.localStore.getNextMutationBatch(batchId);
            if (nextMutationBatch != null) {
                addToWritePipeline(nextMutationBatch);
                batchId = nextMutationBatch.getBatchId();
            } else if (this.writePipeline.size() == 0) {
                this.writeStream.markIdle();
            }
        }
        if (shouldStartWriteStream()) {
            startWriteStream();
        }
    }

    private boolean canAddToWritePipeline() {
        return canUseNetwork() && this.writePipeline.size() < 10;
    }

    private void addToWritePipeline(MutationBatch mutationBatch) {
        Assert.hardAssert(canAddToWritePipeline(), "addToWritePipeline called when pipeline is full", new Object[0]);
        this.writePipeline.add(mutationBatch);
        if (this.writeStream.isOpen() && this.writeStream.isHandshakeComplete()) {
            this.writeStream.writeMutations(mutationBatch.getMutations());
        }
    }

    private void startWriteStream() {
        Assert.hardAssert(shouldStartWriteStream(), "startWriteStream() called when shouldStartWriteStream() is false.", new Object[0]);
        this.writeStream.start();
    }

    /* access modifiers changed from: private */
    public void handleWriteStreamHandshakeComplete() {
        this.localStore.setLastStreamToken(this.writeStream.getLastStreamToken());
        for (MutationBatch mutations : this.writePipeline) {
            this.writeStream.writeMutations(mutations.getMutations());
        }
    }

    /* access modifiers changed from: private */
    public void handleWriteStreamMutationResults(SnapshotVersion snapshotVersion, List<MutationResult> list) {
        this.remoteStoreCallback.handleSuccessfulWrite(MutationBatchResult.create(this.writePipeline.poll(), snapshotVersion, list, this.writeStream.getLastStreamToken()));
        fillWritePipeline();
    }

    /* access modifiers changed from: private */
    public void handleWriteStreamClose(Status status) {
        if (Status.OK.equals(status)) {
            Assert.hardAssert(!shouldStartWriteStream(), "Write stream was stopped gracefully while still needed.", new Object[0]);
        }
        if (!status.isOk() && !this.writePipeline.isEmpty()) {
            if (this.writeStream.isHandshakeComplete()) {
                handleWriteError(status);
            } else {
                handleWriteHandshakeError(status);
            }
        }
        if (shouldStartWriteStream()) {
            startWriteStream();
        }
    }

    private void handleWriteHandshakeError(Status status) {
        Assert.hardAssert(!status.isOk(), "Handling write error with status OK.", new Object[0]);
        if (Datastore.isPermanentError(status)) {
            Logger.debug(LOG_TAG, "RemoteStore error before completed handshake; resetting stream token %s: %s", Util.toDebugString(this.writeStream.getLastStreamToken()), status);
            this.writeStream.setLastStreamToken(WriteStream.EMPTY_STREAM_TOKEN);
            this.localStore.setLastStreamToken(WriteStream.EMPTY_STREAM_TOKEN);
        }
    }

    private void handleWriteError(Status status) {
        Assert.hardAssert(!status.isOk(), "Handling write error with status OK.", new Object[0]);
        if (Datastore.isPermanentWriteError(status)) {
            this.writeStream.inhibitBackoff();
            this.remoteStoreCallback.handleRejectedWrite(this.writePipeline.poll().getBatchId(), status);
            fillWritePipeline();
        }
    }

    public Transaction createTransaction() {
        return new Transaction(this.datastore);
    }

    public ImmutableSortedSet<DocumentKey> getRemoteKeysForTarget(int i) {
        return this.remoteStoreCallback.getRemoteKeysForTarget(i);
    }

    @Nullable
    public QueryData getQueryDataForTarget(int i) {
        return this.listenTargets.get(Integer.valueOf(i));
    }
}
