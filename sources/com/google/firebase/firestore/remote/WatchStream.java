package com.google.firebase.firestore.remote;

import com.google.firebase.firestore.local.QueryData;
import com.google.firebase.firestore.model.SnapshotVersion;
import com.google.firebase.firestore.remote.Stream;
import com.google.firebase.firestore.util.Assert;
import com.google.firebase.firestore.util.AsyncQueue;
import com.google.firestore.v1.FirestoreGrpc;
import com.google.firestore.v1.ListenRequest;
import com.google.firestore.v1.ListenResponse;
import com.google.protobuf.ByteString;
import java.util.Map;

/* compiled from: com.google.firebase:firebase-firestore@@20.2.0 */
public class WatchStream extends AbstractStream<ListenRequest, ListenResponse, Callback> {
    public static final ByteString EMPTY_RESUME_TOKEN = ByteString.EMPTY;
    private final RemoteSerializer serializer;

    /* compiled from: com.google.firebase:firebase-firestore@@20.2.0 */
    interface Callback extends Stream.StreamCallback {
        void onWatchChange(SnapshotVersion snapshotVersion, WatchChange watchChange);
    }

    public /* bridge */ /* synthetic */ void inhibitBackoff() {
        super.inhibitBackoff();
    }

    public /* bridge */ /* synthetic */ boolean isOpen() {
        return super.isOpen();
    }

    public /* bridge */ /* synthetic */ boolean isStarted() {
        return super.isStarted();
    }

    public /* bridge */ /* synthetic */ void start() {
        super.start();
    }

    public /* bridge */ /* synthetic */ void stop() {
        super.stop();
    }

    WatchStream(FirestoreChannel firestoreChannel, AsyncQueue asyncQueue, RemoteSerializer remoteSerializer, Callback callback) {
        super(firestoreChannel, FirestoreGrpc.getListenMethod(), asyncQueue, AsyncQueue.TimerId.LISTEN_STREAM_CONNECTION_BACKOFF, AsyncQueue.TimerId.LISTEN_STREAM_IDLE, callback);
        this.serializer = remoteSerializer;
    }

    public void watchQuery(QueryData queryData) {
        Assert.hardAssert(isOpen(), "Watching queries requires an open stream", new Object[0]);
        ListenRequest.Builder addTarget = ListenRequest.newBuilder().setDatabase(this.serializer.databaseName()).setAddTarget(this.serializer.encodeTarget(queryData));
        Map<String, String> encodeListenRequestLabels = this.serializer.encodeListenRequestLabels(queryData);
        if (encodeListenRequestLabels != null) {
            addTarget.putAllLabels(encodeListenRequestLabels);
        }
        writeRequest((ListenRequest) addTarget.build());
    }

    public void unwatchTarget(int i) {
        Assert.hardAssert(isOpen(), "Unwatching targets requires an open stream", new Object[0]);
        writeRequest((ListenRequest) ListenRequest.newBuilder().setDatabase(this.serializer.databaseName()).setRemoveTarget(i).build());
    }

    public void onNext(ListenResponse listenResponse) {
        this.backoff.reset();
        WatchChange decodeWatchChange = this.serializer.decodeWatchChange(listenResponse);
        ((Callback) this.listener).onWatchChange(this.serializer.decodeVersionFromListenResponse(listenResponse), decodeWatchChange);
    }
}
