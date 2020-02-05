package com.google.firebase.firestore.remote;

import android.content.Context;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.auth.CredentialsProvider;
import com.google.firebase.firestore.core.DatabaseInfo;
import com.google.firebase.firestore.model.DatabaseId;
import com.google.firebase.firestore.util.Assert;
import com.google.firebase.firestore.util.AsyncQueue;
import com.google.firebase.firestore.util.Util;
import io.grpc.ClientCall;
import io.grpc.ForwardingClientCall;
import io.grpc.Metadata;
import io.grpc.MethodDescriptor;
import io.grpc.Status;
import java.util.ArrayList;
import java.util.List;

/* compiled from: com.google.firebase:firebase-firestore@@20.2.0 */
class FirestoreChannel {
    private static final Metadata.Key<String> RESOURCE_PREFIX_HEADER = Metadata.Key.of("google-cloud-resource-prefix", Metadata.ASCII_STRING_MARSHALLER);
    private static final Metadata.Key<String> X_GOOG_API_CLIENT_HEADER = Metadata.Key.of("x-goog-api-client", Metadata.ASCII_STRING_MARSHALLER);
    private static final String X_GOOG_API_CLIENT_VALUE = "gl-java/ fire/20.2.0 grpc/";
    /* access modifiers changed from: private */
    public final AsyncQueue asyncQueue;
    private final GrpcCallProvider callProvider;
    private final CredentialsProvider credentialsProvider;
    private final String resourcePrefixValue;

    FirestoreChannel(AsyncQueue asyncQueue2, Context context, CredentialsProvider credentialsProvider2, DatabaseInfo databaseInfo) {
        this.asyncQueue = asyncQueue2;
        this.credentialsProvider = credentialsProvider2;
        this.callProvider = new GrpcCallProvider(asyncQueue2, context, databaseInfo, new FirestoreCallCredentials(credentialsProvider2));
        DatabaseId databaseId = databaseInfo.getDatabaseId();
        this.resourcePrefixValue = String.format("projects/%s/databases/%s", new Object[]{databaseId.getProjectId(), databaseId.getDatabaseId()});
    }

    public void shutdown() {
        this.callProvider.shutdown();
    }

    /* access modifiers changed from: package-private */
    public <ReqT, RespT> ClientCall<ReqT, RespT> runBidiStreamingRpc(MethodDescriptor<ReqT, RespT> methodDescriptor, IncomingStreamObserver<RespT> incomingStreamObserver) {
        final ClientCall[] clientCallArr = {null};
        final Task<ClientCall<ReqT, RespT>> createClientCall = this.callProvider.createClientCall(methodDescriptor);
        createClientCall.addOnCompleteListener(this.asyncQueue.getExecutor(), (OnCompleteListener<ClientCall<ReqT, RespT>>) FirestoreChannel$$Lambda$1.lambdaFactory$(this, clientCallArr, incomingStreamObserver));
        return new ForwardingClientCall<ReqT, RespT>() {
            /* access modifiers changed from: protected */
            public ClientCall<ReqT, RespT> delegate() {
                Assert.hardAssert(clientCallArr[0] != null, "ClientCall used before onOpen() callback", new Object[0]);
                return clientCallArr[0];
            }

            public void halfClose() {
                if (clientCallArr[0] == null) {
                    createClientCall.addOnSuccessListener(FirestoreChannel.this.asyncQueue.getExecutor(), FirestoreChannel$2$$Lambda$1.lambdaFactory$());
                } else {
                    super.halfClose();
                }
            }
        };
    }

    static /* synthetic */ void lambda$runBidiStreamingRpc$0(FirestoreChannel firestoreChannel, final ClientCall[] clientCallArr, final IncomingStreamObserver incomingStreamObserver, Task task) {
        clientCallArr[0] = (ClientCall) task.getResult();
        clientCallArr[0].start(new ClientCall.Listener<RespT>() {
            public void onReady() {
            }

            public void onHeaders(Metadata metadata) {
                try {
                    incomingStreamObserver.onHeaders(metadata);
                } catch (Throwable th) {
                    FirestoreChannel.this.asyncQueue.panic(th);
                }
            }

            public void onMessage(RespT respt) {
                try {
                    incomingStreamObserver.onNext(respt);
                    clientCallArr[0].request(1);
                } catch (Throwable th) {
                    FirestoreChannel.this.asyncQueue.panic(th);
                }
            }

            public void onClose(Status status, Metadata metadata) {
                try {
                    incomingStreamObserver.onClose(status);
                } catch (Throwable th) {
                    FirestoreChannel.this.asyncQueue.panic(th);
                }
            }
        }, firestoreChannel.requestHeaders());
        incomingStreamObserver.onOpen();
        clientCallArr[0].request(1);
    }

    /* access modifiers changed from: package-private */
    public <ReqT, RespT> Task<List<RespT>> runStreamingResponseRpc(MethodDescriptor<ReqT, RespT> methodDescriptor, ReqT reqt) {
        TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        this.callProvider.createClientCall(methodDescriptor).addOnCompleteListener(this.asyncQueue.getExecutor(), FirestoreChannel$$Lambda$2.lambdaFactory$(this, taskCompletionSource, reqt));
        return taskCompletionSource.getTask();
    }

    static /* synthetic */ void lambda$runStreamingResponseRpc$1(FirestoreChannel firestoreChannel, final TaskCompletionSource taskCompletionSource, Object obj, Task task) {
        final ClientCall clientCall = (ClientCall) task.getResult();
        final ArrayList arrayList = new ArrayList();
        clientCall.start(new ClientCall.Listener<RespT>() {
            public void onMessage(RespT respt) {
                arrayList.add(respt);
                clientCall.request(1);
            }

            public void onClose(Status status, Metadata metadata) {
                if (status.isOk()) {
                    taskCompletionSource.setResult(arrayList);
                } else {
                    taskCompletionSource.setException(FirestoreChannel.this.exceptionFromStatus(status));
                }
            }
        }, firestoreChannel.requestHeaders());
        clientCall.request(1);
        clientCall.sendMessage(obj);
        clientCall.halfClose();
    }

    /* access modifiers changed from: package-private */
    public <ReqT, RespT> Task<RespT> runRpc(MethodDescriptor<ReqT, RespT> methodDescriptor, ReqT reqt) {
        TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        this.callProvider.createClientCall(methodDescriptor).addOnCompleteListener(this.asyncQueue.getExecutor(), FirestoreChannel$$Lambda$3.lambdaFactory$(this, taskCompletionSource, reqt));
        return taskCompletionSource.getTask();
    }

    static /* synthetic */ void lambda$runRpc$2(FirestoreChannel firestoreChannel, final TaskCompletionSource taskCompletionSource, Object obj, Task task) {
        ClientCall clientCall = (ClientCall) task.getResult();
        clientCall.start(new ClientCall.Listener<RespT>() {
            public void onMessage(RespT respt) {
                taskCompletionSource.setResult(respt);
            }

            public void onClose(Status status, Metadata metadata) {
                if (!status.isOk()) {
                    taskCompletionSource.setException(FirestoreChannel.this.exceptionFromStatus(status));
                } else if (!taskCompletionSource.getTask().isComplete()) {
                    taskCompletionSource.setException(new FirebaseFirestoreException("Received onClose with status OK, but no message.", FirebaseFirestoreException.Code.INTERNAL));
                }
            }
        }, firestoreChannel.requestHeaders());
        clientCall.request(2);
        clientCall.sendMessage(obj);
        clientCall.halfClose();
    }

    /* access modifiers changed from: private */
    public FirebaseFirestoreException exceptionFromStatus(Status status) {
        if (Datastore.isSslHandshakeError(status)) {
            return new FirebaseFirestoreException("The Firestore SDK failed to establish a secure connection. This is likely a problem with your app, rather than with Firestore itself. See https://bit.ly/2XFpdma for instructions on how to enable TLS on Android 4.x devices.", FirebaseFirestoreException.Code.fromValue(status.getCode().value()), status.getCause());
        }
        return Util.exceptionFromStatus(status);
    }

    public void invalidateToken() {
        this.credentialsProvider.invalidateToken();
    }

    private Metadata requestHeaders() {
        Metadata metadata = new Metadata();
        metadata.put(X_GOOG_API_CLIENT_HEADER, X_GOOG_API_CLIENT_VALUE);
        metadata.put(RESOURCE_PREFIX_HEADER, this.resourcePrefixValue);
        return metadata;
    }
}
