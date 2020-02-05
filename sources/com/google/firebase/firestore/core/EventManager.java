package com.google.firebase.firestore.core;

import com.google.firebase.firestore.core.SyncEngine;
import com.google.firebase.firestore.util.Util;
import io.grpc.Status;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* compiled from: com.google.firebase:firebase-firestore@@20.2.0 */
public final class EventManager implements SyncEngine.SyncEngineCallback {
    private OnlineState onlineState = OnlineState.UNKNOWN;
    private final Map<Query, QueryListenersInfo> queries;
    private final SyncEngine syncEngine;

    /* compiled from: com.google.firebase:firebase-firestore@@20.2.0 */
    public static class ListenOptions {
        public boolean includeDocumentMetadataChanges;
        public boolean includeQueryMetadataChanges;
        public boolean waitForSyncWhenOnline;
    }

    /* compiled from: com.google.firebase:firebase-firestore@@20.2.0 */
    private static class QueryListenersInfo {
        /* access modifiers changed from: private */
        public final List<QueryListener> listeners = new ArrayList();
        /* access modifiers changed from: private */
        public int targetId;
        /* access modifiers changed from: private */
        public ViewSnapshot viewSnapshot;

        QueryListenersInfo() {
        }
    }

    public EventManager(SyncEngine syncEngine2) {
        this.syncEngine = syncEngine2;
        this.queries = new HashMap();
        syncEngine2.setCallback(this);
    }

    public int addQueryListener(QueryListener queryListener) {
        Query query = queryListener.getQuery();
        QueryListenersInfo queryListenersInfo = this.queries.get(query);
        boolean z = queryListenersInfo == null;
        if (z) {
            queryListenersInfo = new QueryListenersInfo();
            this.queries.put(query, queryListenersInfo);
        }
        queryListenersInfo.listeners.add(queryListener);
        queryListener.onOnlineStateChanged(this.onlineState);
        if (queryListenersInfo.viewSnapshot != null) {
            queryListener.onViewSnapshot(queryListenersInfo.viewSnapshot);
        }
        if (z) {
            int unused = queryListenersInfo.targetId = this.syncEngine.listen(query);
        }
        return queryListenersInfo.targetId;
    }

    public boolean removeQueryListener(QueryListener queryListener) {
        boolean z;
        Query query = queryListener.getQuery();
        QueryListenersInfo queryListenersInfo = this.queries.get(query);
        boolean z2 = false;
        if (queryListenersInfo != null) {
            z2 = queryListenersInfo.listeners.remove(queryListener);
            z = queryListenersInfo.listeners.isEmpty();
        } else {
            z = false;
        }
        if (z) {
            this.queries.remove(query);
            this.syncEngine.stopListening(query);
        }
        return z2;
    }

    public void onViewSnapshots(List<ViewSnapshot> list) {
        for (ViewSnapshot next : list) {
            QueryListenersInfo queryListenersInfo = this.queries.get(next.getQuery());
            if (queryListenersInfo != null) {
                for (QueryListener onViewSnapshot : queryListenersInfo.listeners) {
                    onViewSnapshot.onViewSnapshot(next);
                }
                ViewSnapshot unused = queryListenersInfo.viewSnapshot = next;
            }
        }
    }

    public void onError(Query query, Status status) {
        QueryListenersInfo queryListenersInfo = this.queries.get(query);
        if (queryListenersInfo != null) {
            for (QueryListener onError : queryListenersInfo.listeners) {
                onError.onError(Util.exceptionFromStatus(status));
            }
        }
        this.queries.remove(query);
    }

    public void handleOnlineStateChange(OnlineState onlineState2) {
        this.onlineState = onlineState2;
        for (QueryListenersInfo access$000 : this.queries.values()) {
            for (QueryListener onOnlineStateChanged : access$000.listeners) {
                onOnlineStateChanged.onOnlineStateChanged(onlineState2);
            }
        }
    }
}
