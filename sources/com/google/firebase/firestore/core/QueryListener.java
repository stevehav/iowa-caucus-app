package com.google.firebase.firestore.core;

import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.core.DocumentViewChange;
import com.google.firebase.firestore.core.EventManager;
import com.google.firebase.firestore.util.Assert;
import java.util.ArrayList;
import javax.annotation.Nullable;

/* compiled from: com.google.firebase:firebase-firestore@@20.2.0 */
public class QueryListener {
    private final EventListener<ViewSnapshot> listener;
    private OnlineState onlineState = OnlineState.UNKNOWN;
    private final EventManager.ListenOptions options;
    private final Query query;
    private boolean raisedInitialEvent = false;
    @Nullable
    private ViewSnapshot snapshot;

    public QueryListener(Query query2, EventManager.ListenOptions listenOptions, EventListener<ViewSnapshot> eventListener) {
        this.query = query2;
        this.listener = eventListener;
        this.options = listenOptions;
    }

    public Query getQuery() {
        return this.query;
    }

    public void onViewSnapshot(ViewSnapshot viewSnapshot) {
        Assert.hardAssert(!viewSnapshot.getChanges().isEmpty() || viewSnapshot.didSyncStateChange(), "We got a new snapshot with no changes?", new Object[0]);
        if (!this.options.includeDocumentMetadataChanges) {
            ArrayList arrayList = new ArrayList();
            for (DocumentViewChange next : viewSnapshot.getChanges()) {
                if (next.getType() != DocumentViewChange.Type.METADATA) {
                    arrayList.add(next);
                }
            }
            viewSnapshot = new ViewSnapshot(viewSnapshot.getQuery(), viewSnapshot.getDocuments(), viewSnapshot.getOldDocuments(), arrayList, viewSnapshot.isFromCache(), viewSnapshot.getMutatedKeys(), viewSnapshot.didSyncStateChange(), true);
        }
        if (!this.raisedInitialEvent) {
            if (shouldRaiseInitialEvent(viewSnapshot, this.onlineState)) {
                raiseInitialEvent(viewSnapshot);
            }
        } else if (shouldRaiseEvent(viewSnapshot)) {
            this.listener.onEvent(viewSnapshot, (FirebaseFirestoreException) null);
        }
        this.snapshot = viewSnapshot;
    }

    public void onError(FirebaseFirestoreException firebaseFirestoreException) {
        this.listener.onEvent(null, firebaseFirestoreException);
    }

    public void onOnlineStateChanged(OnlineState onlineState2) {
        this.onlineState = onlineState2;
        ViewSnapshot viewSnapshot = this.snapshot;
        if (viewSnapshot != null && !this.raisedInitialEvent && shouldRaiseInitialEvent(viewSnapshot, onlineState2)) {
            raiseInitialEvent(this.snapshot);
        }
    }

    private boolean shouldRaiseInitialEvent(ViewSnapshot viewSnapshot, OnlineState onlineState2) {
        Assert.hardAssert(!this.raisedInitialEvent, "Determining whether to raise first event but already had first event.", new Object[0]);
        if (!viewSnapshot.isFromCache()) {
            return true;
        }
        boolean z = !onlineState2.equals(OnlineState.OFFLINE);
        if (this.options.waitForSyncWhenOnline && z) {
            Assert.hardAssert(viewSnapshot.isFromCache(), "Waiting for sync, but snapshot is not from cache", new Object[0]);
            return false;
        } else if (!viewSnapshot.getDocuments().isEmpty() || onlineState2.equals(OnlineState.OFFLINE)) {
            return true;
        } else {
            return false;
        }
    }

    private boolean shouldRaiseEvent(ViewSnapshot viewSnapshot) {
        boolean z = true;
        if (!viewSnapshot.getChanges().isEmpty()) {
            return true;
        }
        ViewSnapshot viewSnapshot2 = this.snapshot;
        if (viewSnapshot2 == null || viewSnapshot2.hasPendingWrites() == viewSnapshot.hasPendingWrites()) {
            z = false;
        }
        if (viewSnapshot.didSyncStateChange() || z) {
            return this.options.includeQueryMetadataChanges;
        }
        return false;
    }

    private void raiseInitialEvent(ViewSnapshot viewSnapshot) {
        Assert.hardAssert(!this.raisedInitialEvent, "Trying to raise initial event for second time", new Object[0]);
        ViewSnapshot fromInitialDocuments = ViewSnapshot.fromInitialDocuments(viewSnapshot.getQuery(), viewSnapshot.getDocuments(), viewSnapshot.getMutatedKeys(), viewSnapshot.isFromCache(), viewSnapshot.excludesMetadataChanges());
        this.raisedInitialEvent = true;
        this.listener.onEvent(fromInitialDocuments, (FirebaseFirestoreException) null);
    }
}
