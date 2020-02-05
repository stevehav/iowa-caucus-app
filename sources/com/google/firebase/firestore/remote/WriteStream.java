package com.google.firebase.firestore.remote;

import com.google.common.base.Preconditions;
import com.google.firebase.firestore.model.SnapshotVersion;
import com.google.firebase.firestore.model.mutation.Mutation;
import com.google.firebase.firestore.model.mutation.MutationResult;
import com.google.firebase.firestore.remote.Stream;
import com.google.firebase.firestore.util.Assert;
import com.google.firebase.firestore.util.AsyncQueue;
import com.google.firestore.v1.FirestoreGrpc;
import com.google.firestore.v1.WriteRequest;
import com.google.firestore.v1.WriteResponse;
import com.google.protobuf.ByteString;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* compiled from: com.google.firebase:firebase-firestore@@20.2.0 */
public class WriteStream extends AbstractStream<WriteRequest, WriteResponse, Callback> {
    public static final ByteString EMPTY_STREAM_TOKEN = ByteString.EMPTY;
    protected boolean handshakeComplete = false;
    private ByteString lastStreamToken = EMPTY_STREAM_TOKEN;
    private final RemoteSerializer serializer;

    /* compiled from: com.google.firebase:firebase-firestore@@20.2.0 */
    public interface Callback extends Stream.StreamCallback {
        void onHandshakeComplete();

        void onWriteResponse(SnapshotVersion snapshotVersion, List<MutationResult> list);
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

    public /* bridge */ /* synthetic */ void stop() {
        super.stop();
    }

    WriteStream(FirestoreChannel firestoreChannel, AsyncQueue asyncQueue, RemoteSerializer remoteSerializer, Callback callback) {
        super(firestoreChannel, FirestoreGrpc.getWriteMethod(), asyncQueue, AsyncQueue.TimerId.WRITE_STREAM_CONNECTION_BACKOFF, AsyncQueue.TimerId.WRITE_STREAM_IDLE, callback);
        this.serializer = remoteSerializer;
    }

    public void start() {
        this.handshakeComplete = false;
        super.start();
    }

    /* access modifiers changed from: protected */
    public void tearDown() {
        if (this.handshakeComplete) {
            writeMutations(Collections.emptyList());
        }
    }

    /* access modifiers changed from: package-private */
    public boolean isHandshakeComplete() {
        return this.handshakeComplete;
    }

    /* access modifiers changed from: package-private */
    public ByteString getLastStreamToken() {
        return this.lastStreamToken;
    }

    /* access modifiers changed from: package-private */
    public void setLastStreamToken(ByteString byteString) {
        this.lastStreamToken = (ByteString) Preconditions.checkNotNull(byteString);
    }

    /* access modifiers changed from: package-private */
    public void writeHandshake() {
        Assert.hardAssert(isOpen(), "Writing handshake requires an opened stream", new Object[0]);
        Assert.hardAssert(!this.handshakeComplete, "Handshake already completed", new Object[0]);
        writeRequest((WriteRequest) WriteRequest.newBuilder().setDatabase(this.serializer.databaseName()).build());
    }

    /* access modifiers changed from: package-private */
    public void writeMutations(List<Mutation> list) {
        Assert.hardAssert(isOpen(), "Writing mutations requires an opened stream", new Object[0]);
        Assert.hardAssert(this.handshakeComplete, "Handshake must be complete before writing mutations", new Object[0]);
        WriteRequest.Builder newBuilder = WriteRequest.newBuilder();
        for (Mutation encodeMutation : list) {
            newBuilder.addWrites(this.serializer.encodeMutation(encodeMutation));
        }
        newBuilder.setStreamToken(this.lastStreamToken);
        writeRequest((WriteRequest) newBuilder.build());
    }

    public void onNext(WriteResponse writeResponse) {
        this.lastStreamToken = writeResponse.getStreamToken();
        if (!this.handshakeComplete) {
            this.handshakeComplete = true;
            ((Callback) this.listener).onHandshakeComplete();
            return;
        }
        this.backoff.reset();
        SnapshotVersion decodeVersion = this.serializer.decodeVersion(writeResponse.getCommitTime());
        int writeResultsCount = writeResponse.getWriteResultsCount();
        ArrayList arrayList = new ArrayList(writeResultsCount);
        for (int i = 0; i < writeResultsCount; i++) {
            arrayList.add(this.serializer.decodeMutationResult(writeResponse.getWriteResults(i), decodeVersion));
        }
        ((Callback) this.listener).onWriteResponse(decodeVersion, arrayList);
    }
}
