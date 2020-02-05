package com.google.firebase.firestore.remote;

import androidx.annotation.Nullable;
import com.google.firebase.database.collection.ImmutableSortedSet;
import com.google.firebase.firestore.core.DocumentViewChange;
import com.google.firebase.firestore.core.Query;
import com.google.firebase.firestore.local.QueryData;
import com.google.firebase.firestore.local.QueryPurpose;
import com.google.firebase.firestore.model.Document;
import com.google.firebase.firestore.model.DocumentKey;
import com.google.firebase.firestore.model.MaybeDocument;
import com.google.firebase.firestore.model.NoDocument;
import com.google.firebase.firestore.model.SnapshotVersion;
import com.google.firebase.firestore.remote.WatchChange;
import com.google.firebase.firestore.util.Assert;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* compiled from: com.google.firebase:firebase-firestore@@20.2.0 */
public class WatchChangeAggregator {
    private Map<DocumentKey, Set<Integer>> pendingDocumentTargetMapping = new HashMap();
    private Map<DocumentKey, MaybeDocument> pendingDocumentUpdates = new HashMap();
    private Set<Integer> pendingTargetResets = new HashSet();
    private final TargetMetadataProvider targetMetadataProvider;
    private final Map<Integer, TargetState> targetStates = new HashMap();

    /* compiled from: com.google.firebase:firebase-firestore@@20.2.0 */
    public interface TargetMetadataProvider {
        @Nullable
        QueryData getQueryDataForTarget(int i);

        ImmutableSortedSet<DocumentKey> getRemoteKeysForTarget(int i);
    }

    public WatchChangeAggregator(TargetMetadataProvider targetMetadataProvider2) {
        this.targetMetadataProvider = targetMetadataProvider2;
    }

    public void handleDocumentChange(WatchChange.DocumentChange documentChange) {
        MaybeDocument newDocument = documentChange.getNewDocument();
        DocumentKey documentKey = documentChange.getDocumentKey();
        for (Integer intValue : documentChange.getUpdatedTargetIds()) {
            int intValue2 = intValue.intValue();
            if (newDocument instanceof Document) {
                addDocumentToTarget(intValue2, newDocument);
            } else if (newDocument instanceof NoDocument) {
                removeDocumentFromTarget(intValue2, documentKey, newDocument);
            }
        }
        for (Integer intValue3 : documentChange.getRemovedTargetIds()) {
            removeDocumentFromTarget(intValue3.intValue(), documentKey, documentChange.getNewDocument());
        }
    }

    public void handleTargetChange(WatchChange.WatchTargetChange watchTargetChange) {
        for (Integer intValue : getTargetIds(watchTargetChange)) {
            int intValue2 = intValue.intValue();
            TargetState ensureTargetState = ensureTargetState(intValue2);
            int i = AnonymousClass1.$SwitchMap$com$google$firebase$firestore$remote$WatchChange$WatchTargetChangeType[watchTargetChange.getChangeType().ordinal()];
            boolean z = true;
            if (i != 1) {
                if (i == 2) {
                    ensureTargetState.recordTargetResponse();
                    if (!ensureTargetState.isPending()) {
                        ensureTargetState.clearChanges();
                    }
                    ensureTargetState.updateResumeToken(watchTargetChange.getResumeToken());
                } else if (i == 3) {
                    ensureTargetState.recordTargetResponse();
                    if (!ensureTargetState.isPending()) {
                        removeTarget(intValue2);
                    }
                    if (watchTargetChange.getCause() != null) {
                        z = false;
                    }
                    Assert.hardAssert(z, "WatchChangeAggregator does not handle errored targets", new Object[0]);
                } else if (i != 4) {
                    if (i != 5) {
                        throw Assert.fail("Unknown target watch change state: %s", watchTargetChange.getChangeType());
                    } else if (isActiveTarget(intValue2)) {
                        resetTarget(intValue2);
                        ensureTargetState.updateResumeToken(watchTargetChange.getResumeToken());
                    }
                } else if (isActiveTarget(intValue2)) {
                    ensureTargetState.markCurrent();
                    ensureTargetState.updateResumeToken(watchTargetChange.getResumeToken());
                }
            } else if (isActiveTarget(intValue2)) {
                ensureTargetState.updateResumeToken(watchTargetChange.getResumeToken());
            }
        }
    }

    /* renamed from: com.google.firebase.firestore.remote.WatchChangeAggregator$1  reason: invalid class name */
    /* compiled from: com.google.firebase:firebase-firestore@@20.2.0 */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$google$firebase$firestore$remote$WatchChange$WatchTargetChangeType = new int[WatchChange.WatchTargetChangeType.values().length];

        /* JADX WARNING: Can't wrap try/catch for region: R(12:0|1|2|3|4|5|6|7|8|9|10|12) */
        /* JADX WARNING: Code restructure failed: missing block: B:13:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0014 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001f */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x002a */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0035 */
        static {
            /*
                com.google.firebase.firestore.remote.WatchChange$WatchTargetChangeType[] r0 = com.google.firebase.firestore.remote.WatchChange.WatchTargetChangeType.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$com$google$firebase$firestore$remote$WatchChange$WatchTargetChangeType = r0
                int[] r0 = $SwitchMap$com$google$firebase$firestore$remote$WatchChange$WatchTargetChangeType     // Catch:{ NoSuchFieldError -> 0x0014 }
                com.google.firebase.firestore.remote.WatchChange$WatchTargetChangeType r1 = com.google.firebase.firestore.remote.WatchChange.WatchTargetChangeType.NoChange     // Catch:{ NoSuchFieldError -> 0x0014 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0014 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0014 }
            L_0x0014:
                int[] r0 = $SwitchMap$com$google$firebase$firestore$remote$WatchChange$WatchTargetChangeType     // Catch:{ NoSuchFieldError -> 0x001f }
                com.google.firebase.firestore.remote.WatchChange$WatchTargetChangeType r1 = com.google.firebase.firestore.remote.WatchChange.WatchTargetChangeType.Added     // Catch:{ NoSuchFieldError -> 0x001f }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001f }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001f }
            L_0x001f:
                int[] r0 = $SwitchMap$com$google$firebase$firestore$remote$WatchChange$WatchTargetChangeType     // Catch:{ NoSuchFieldError -> 0x002a }
                com.google.firebase.firestore.remote.WatchChange$WatchTargetChangeType r1 = com.google.firebase.firestore.remote.WatchChange.WatchTargetChangeType.Removed     // Catch:{ NoSuchFieldError -> 0x002a }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x002a }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x002a }
            L_0x002a:
                int[] r0 = $SwitchMap$com$google$firebase$firestore$remote$WatchChange$WatchTargetChangeType     // Catch:{ NoSuchFieldError -> 0x0035 }
                com.google.firebase.firestore.remote.WatchChange$WatchTargetChangeType r1 = com.google.firebase.firestore.remote.WatchChange.WatchTargetChangeType.Current     // Catch:{ NoSuchFieldError -> 0x0035 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0035 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0035 }
            L_0x0035:
                int[] r0 = $SwitchMap$com$google$firebase$firestore$remote$WatchChange$WatchTargetChangeType     // Catch:{ NoSuchFieldError -> 0x0040 }
                com.google.firebase.firestore.remote.WatchChange$WatchTargetChangeType r1 = com.google.firebase.firestore.remote.WatchChange.WatchTargetChangeType.Reset     // Catch:{ NoSuchFieldError -> 0x0040 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0040 }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0040 }
            L_0x0040:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.firestore.remote.WatchChangeAggregator.AnonymousClass1.<clinit>():void");
        }
    }

    private Collection<Integer> getTargetIds(WatchChange.WatchTargetChange watchTargetChange) {
        List<Integer> targetIds = watchTargetChange.getTargetIds();
        if (!targetIds.isEmpty()) {
            return targetIds;
        }
        return this.targetStates.keySet();
    }

    public void handleExistenceFilter(WatchChange.ExistenceFilterWatchChange existenceFilterWatchChange) {
        int targetId = existenceFilterWatchChange.getTargetId();
        int count = existenceFilterWatchChange.getExistenceFilter().getCount();
        QueryData queryDataForActiveTarget = queryDataForActiveTarget(targetId);
        if (queryDataForActiveTarget != null) {
            Query query = queryDataForActiveTarget.getQuery();
            if (query.isDocumentQuery()) {
                if (count == 0) {
                    DocumentKey fromPath = DocumentKey.fromPath(query.getPath());
                    removeDocumentFromTarget(targetId, fromPath, new NoDocument(fromPath, SnapshotVersion.NONE, false));
                    return;
                }
                Assert.hardAssert(count == 1, "Single document existence filter with count: %d", Integer.valueOf(count));
            } else if (((long) getCurrentDocumentCountForTarget(targetId)) != ((long) count)) {
                resetTarget(targetId);
                this.pendingTargetResets.add(Integer.valueOf(targetId));
            }
        }
    }

    public RemoteEvent createRemoteEvent(SnapshotVersion snapshotVersion) {
        HashMap hashMap = new HashMap();
        for (Map.Entry next : this.targetStates.entrySet()) {
            int intValue = ((Integer) next.getKey()).intValue();
            TargetState targetState = (TargetState) next.getValue();
            QueryData queryDataForActiveTarget = queryDataForActiveTarget(intValue);
            if (queryDataForActiveTarget != null) {
                if (targetState.isCurrent() && queryDataForActiveTarget.getQuery().isDocumentQuery()) {
                    DocumentKey fromPath = DocumentKey.fromPath(queryDataForActiveTarget.getQuery().getPath());
                    if (this.pendingDocumentUpdates.get(fromPath) == null && !targetContainsDocument(intValue, fromPath)) {
                        removeDocumentFromTarget(intValue, fromPath, new NoDocument(fromPath, snapshotVersion, false));
                    }
                }
                if (targetState.hasChanges()) {
                    hashMap.put(Integer.valueOf(intValue), targetState.toTargetChange());
                    targetState.clearChanges();
                }
            }
        }
        HashSet hashSet = new HashSet();
        for (Map.Entry next2 : this.pendingDocumentTargetMapping.entrySet()) {
            DocumentKey documentKey = (DocumentKey) next2.getKey();
            boolean z = true;
            Iterator it = ((Set) next2.getValue()).iterator();
            while (true) {
                if (it.hasNext()) {
                    QueryData queryDataForActiveTarget2 = queryDataForActiveTarget(((Integer) it.next()).intValue());
                    if (queryDataForActiveTarget2 != null && !queryDataForActiveTarget2.getPurpose().equals(QueryPurpose.LIMBO_RESOLUTION)) {
                        z = false;
                        break;
                    }
                } else {
                    break;
                }
            }
            if (z) {
                hashSet.add(documentKey);
            }
        }
        RemoteEvent remoteEvent = new RemoteEvent(snapshotVersion, Collections.unmodifiableMap(hashMap), Collections.unmodifiableSet(this.pendingTargetResets), Collections.unmodifiableMap(this.pendingDocumentUpdates), Collections.unmodifiableSet(hashSet));
        this.pendingDocumentUpdates = new HashMap();
        this.pendingDocumentTargetMapping = new HashMap();
        this.pendingTargetResets = new HashSet();
        return remoteEvent;
    }

    private void addDocumentToTarget(int i, MaybeDocument maybeDocument) {
        DocumentViewChange.Type type;
        if (isActiveTarget(i)) {
            if (targetContainsDocument(i, maybeDocument.getKey())) {
                type = DocumentViewChange.Type.MODIFIED;
            } else {
                type = DocumentViewChange.Type.ADDED;
            }
            ensureTargetState(i).addDocumentChange(maybeDocument.getKey(), type);
            this.pendingDocumentUpdates.put(maybeDocument.getKey(), maybeDocument);
            ensureDocumentTargetMapping(maybeDocument.getKey()).add(Integer.valueOf(i));
        }
    }

    private void removeDocumentFromTarget(int i, DocumentKey documentKey, @Nullable MaybeDocument maybeDocument) {
        if (isActiveTarget(i)) {
            TargetState ensureTargetState = ensureTargetState(i);
            if (targetContainsDocument(i, documentKey)) {
                ensureTargetState.addDocumentChange(documentKey, DocumentViewChange.Type.REMOVED);
            } else {
                ensureTargetState.removeDocumentChange(documentKey);
            }
            ensureDocumentTargetMapping(documentKey).add(Integer.valueOf(i));
            if (maybeDocument != null) {
                this.pendingDocumentUpdates.put(documentKey, maybeDocument);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void removeTarget(int i) {
        this.targetStates.remove(Integer.valueOf(i));
    }

    private int getCurrentDocumentCountForTarget(int i) {
        TargetChange targetChange = ensureTargetState(i).toTargetChange();
        return (this.targetMetadataProvider.getRemoteKeysForTarget(i).size() + targetChange.getAddedDocuments().size()) - targetChange.getRemovedDocuments().size();
    }

    /* access modifiers changed from: package-private */
    public void recordPendingTargetRequest(int i) {
        ensureTargetState(i).recordPendingTargetRequest();
    }

    private TargetState ensureTargetState(int i) {
        TargetState targetState = this.targetStates.get(Integer.valueOf(i));
        if (targetState != null) {
            return targetState;
        }
        TargetState targetState2 = new TargetState();
        this.targetStates.put(Integer.valueOf(i), targetState2);
        return targetState2;
    }

    private Set<Integer> ensureDocumentTargetMapping(DocumentKey documentKey) {
        Set<Integer> set = this.pendingDocumentTargetMapping.get(documentKey);
        if (set != null) {
            return set;
        }
        HashSet hashSet = new HashSet();
        this.pendingDocumentTargetMapping.put(documentKey, hashSet);
        return hashSet;
    }

    private boolean isActiveTarget(int i) {
        return queryDataForActiveTarget(i) != null;
    }

    @Nullable
    private QueryData queryDataForActiveTarget(int i) {
        TargetState targetState = this.targetStates.get(Integer.valueOf(i));
        if (targetState == null || !targetState.isPending()) {
            return this.targetMetadataProvider.getQueryDataForTarget(i);
        }
        return null;
    }

    private void resetTarget(int i) {
        Assert.hardAssert(this.targetStates.get(Integer.valueOf(i)) != null && !this.targetStates.get(Integer.valueOf(i)).isPending(), "Should only reset active targets", new Object[0]);
        this.targetStates.put(Integer.valueOf(i), new TargetState());
        Iterator<DocumentKey> it = this.targetMetadataProvider.getRemoteKeysForTarget(i).iterator();
        while (it.hasNext()) {
            removeDocumentFromTarget(i, it.next(), (MaybeDocument) null);
        }
    }

    private boolean targetContainsDocument(int i, DocumentKey documentKey) {
        return this.targetMetadataProvider.getRemoteKeysForTarget(i).contains(documentKey);
    }
}
