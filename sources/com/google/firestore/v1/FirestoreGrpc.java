package com.google.firestore.v1;

import com.google.common.util.concurrent.ListenableFuture;
import com.google.protobuf.Empty;
import io.grpc.BindableService;
import io.grpc.CallOptions;
import io.grpc.Channel;
import io.grpc.MethodDescriptor;
import io.grpc.ServerServiceDefinition;
import io.grpc.ServiceDescriptor;
import io.grpc.protobuf.lite.ProtoLiteUtils;
import io.grpc.stub.AbstractStub;
import io.grpc.stub.ClientCalls;
import io.grpc.stub.ServerCalls;
import io.grpc.stub.StreamObserver;
import io.grpc.stub.annotations.RpcMethod;
import java.util.Iterator;

/* compiled from: com.google.firebase:firebase-firestore@@20.2.0 */
public final class FirestoreGrpc {
    private static final int METHODID_BATCH_GET_DOCUMENTS = 5;
    private static final int METHODID_BEGIN_TRANSACTION = 6;
    private static final int METHODID_COMMIT = 7;
    private static final int METHODID_CREATE_DOCUMENT = 2;
    private static final int METHODID_DELETE_DOCUMENT = 4;
    private static final int METHODID_GET_DOCUMENT = 0;
    private static final int METHODID_LISTEN = 12;
    private static final int METHODID_LIST_COLLECTION_IDS = 10;
    private static final int METHODID_LIST_DOCUMENTS = 1;
    private static final int METHODID_ROLLBACK = 8;
    private static final int METHODID_RUN_QUERY = 9;
    private static final int METHODID_UPDATE_DOCUMENT = 3;
    private static final int METHODID_WRITE = 11;
    public static final String SERVICE_NAME = "google.firestore.v1.Firestore";
    private static volatile MethodDescriptor<BatchGetDocumentsRequest, BatchGetDocumentsResponse> getBatchGetDocumentsMethod;
    private static volatile MethodDescriptor<BeginTransactionRequest, BeginTransactionResponse> getBeginTransactionMethod;
    private static volatile MethodDescriptor<CommitRequest, CommitResponse> getCommitMethod;
    private static volatile MethodDescriptor<CreateDocumentRequest, Document> getCreateDocumentMethod;
    private static volatile MethodDescriptor<DeleteDocumentRequest, Empty> getDeleteDocumentMethod;
    private static volatile MethodDescriptor<GetDocumentRequest, Document> getGetDocumentMethod;
    private static volatile MethodDescriptor<ListCollectionIdsRequest, ListCollectionIdsResponse> getListCollectionIdsMethod;
    private static volatile MethodDescriptor<ListDocumentsRequest, ListDocumentsResponse> getListDocumentsMethod;
    private static volatile MethodDescriptor<ListenRequest, ListenResponse> getListenMethod;
    private static volatile MethodDescriptor<RollbackRequest, Empty> getRollbackMethod;
    private static volatile MethodDescriptor<RunQueryRequest, RunQueryResponse> getRunQueryMethod;
    private static volatile MethodDescriptor<UpdateDocumentRequest, Document> getUpdateDocumentMethod;
    private static volatile MethodDescriptor<WriteRequest, WriteResponse> getWriteMethod;
    private static volatile ServiceDescriptor serviceDescriptor;

    private FirestoreGrpc() {
    }

    @RpcMethod(fullMethodName = "google.firestore.v1.Firestore/GetDocument", methodType = MethodDescriptor.MethodType.UNARY, requestType = GetDocumentRequest.class, responseType = Document.class)
    public static MethodDescriptor<GetDocumentRequest, Document> getGetDocumentMethod() {
        MethodDescriptor<GetDocumentRequest, Document> methodDescriptor = getGetDocumentMethod;
        if (methodDescriptor == null) {
            synchronized (FirestoreGrpc.class) {
                methodDescriptor = getGetDocumentMethod;
                if (methodDescriptor == null) {
                    methodDescriptor = MethodDescriptor.newBuilder().setType(MethodDescriptor.MethodType.UNARY).setFullMethodName(MethodDescriptor.generateFullMethodName(SERVICE_NAME, "GetDocument")).setSampledToLocalTracing(true).setRequestMarshaller(ProtoLiteUtils.marshaller(GetDocumentRequest.getDefaultInstance())).setResponseMarshaller(ProtoLiteUtils.marshaller(Document.getDefaultInstance())).build();
                    getGetDocumentMethod = methodDescriptor;
                }
            }
        }
        return methodDescriptor;
    }

    @RpcMethod(fullMethodName = "google.firestore.v1.Firestore/ListDocuments", methodType = MethodDescriptor.MethodType.UNARY, requestType = ListDocumentsRequest.class, responseType = ListDocumentsResponse.class)
    public static MethodDescriptor<ListDocumentsRequest, ListDocumentsResponse> getListDocumentsMethod() {
        MethodDescriptor<ListDocumentsRequest, ListDocumentsResponse> methodDescriptor = getListDocumentsMethod;
        if (methodDescriptor == null) {
            synchronized (FirestoreGrpc.class) {
                methodDescriptor = getListDocumentsMethod;
                if (methodDescriptor == null) {
                    methodDescriptor = MethodDescriptor.newBuilder().setType(MethodDescriptor.MethodType.UNARY).setFullMethodName(MethodDescriptor.generateFullMethodName(SERVICE_NAME, "ListDocuments")).setSampledToLocalTracing(true).setRequestMarshaller(ProtoLiteUtils.marshaller(ListDocumentsRequest.getDefaultInstance())).setResponseMarshaller(ProtoLiteUtils.marshaller(ListDocumentsResponse.getDefaultInstance())).build();
                    getListDocumentsMethod = methodDescriptor;
                }
            }
        }
        return methodDescriptor;
    }

    @RpcMethod(fullMethodName = "google.firestore.v1.Firestore/CreateDocument", methodType = MethodDescriptor.MethodType.UNARY, requestType = CreateDocumentRequest.class, responseType = Document.class)
    public static MethodDescriptor<CreateDocumentRequest, Document> getCreateDocumentMethod() {
        MethodDescriptor<CreateDocumentRequest, Document> methodDescriptor = getCreateDocumentMethod;
        if (methodDescriptor == null) {
            synchronized (FirestoreGrpc.class) {
                methodDescriptor = getCreateDocumentMethod;
                if (methodDescriptor == null) {
                    methodDescriptor = MethodDescriptor.newBuilder().setType(MethodDescriptor.MethodType.UNARY).setFullMethodName(MethodDescriptor.generateFullMethodName(SERVICE_NAME, "CreateDocument")).setSampledToLocalTracing(true).setRequestMarshaller(ProtoLiteUtils.marshaller(CreateDocumentRequest.getDefaultInstance())).setResponseMarshaller(ProtoLiteUtils.marshaller(Document.getDefaultInstance())).build();
                    getCreateDocumentMethod = methodDescriptor;
                }
            }
        }
        return methodDescriptor;
    }

    @RpcMethod(fullMethodName = "google.firestore.v1.Firestore/UpdateDocument", methodType = MethodDescriptor.MethodType.UNARY, requestType = UpdateDocumentRequest.class, responseType = Document.class)
    public static MethodDescriptor<UpdateDocumentRequest, Document> getUpdateDocumentMethod() {
        MethodDescriptor<UpdateDocumentRequest, Document> methodDescriptor = getUpdateDocumentMethod;
        if (methodDescriptor == null) {
            synchronized (FirestoreGrpc.class) {
                methodDescriptor = getUpdateDocumentMethod;
                if (methodDescriptor == null) {
                    methodDescriptor = MethodDescriptor.newBuilder().setType(MethodDescriptor.MethodType.UNARY).setFullMethodName(MethodDescriptor.generateFullMethodName(SERVICE_NAME, "UpdateDocument")).setSampledToLocalTracing(true).setRequestMarshaller(ProtoLiteUtils.marshaller(UpdateDocumentRequest.getDefaultInstance())).setResponseMarshaller(ProtoLiteUtils.marshaller(Document.getDefaultInstance())).build();
                    getUpdateDocumentMethod = methodDescriptor;
                }
            }
        }
        return methodDescriptor;
    }

    @RpcMethod(fullMethodName = "google.firestore.v1.Firestore/DeleteDocument", methodType = MethodDescriptor.MethodType.UNARY, requestType = DeleteDocumentRequest.class, responseType = Empty.class)
    public static MethodDescriptor<DeleteDocumentRequest, Empty> getDeleteDocumentMethod() {
        MethodDescriptor<DeleteDocumentRequest, Empty> methodDescriptor = getDeleteDocumentMethod;
        if (methodDescriptor == null) {
            synchronized (FirestoreGrpc.class) {
                methodDescriptor = getDeleteDocumentMethod;
                if (methodDescriptor == null) {
                    methodDescriptor = MethodDescriptor.newBuilder().setType(MethodDescriptor.MethodType.UNARY).setFullMethodName(MethodDescriptor.generateFullMethodName(SERVICE_NAME, "DeleteDocument")).setSampledToLocalTracing(true).setRequestMarshaller(ProtoLiteUtils.marshaller(DeleteDocumentRequest.getDefaultInstance())).setResponseMarshaller(ProtoLiteUtils.marshaller(Empty.getDefaultInstance())).build();
                    getDeleteDocumentMethod = methodDescriptor;
                }
            }
        }
        return methodDescriptor;
    }

    @RpcMethod(fullMethodName = "google.firestore.v1.Firestore/BatchGetDocuments", methodType = MethodDescriptor.MethodType.SERVER_STREAMING, requestType = BatchGetDocumentsRequest.class, responseType = BatchGetDocumentsResponse.class)
    public static MethodDescriptor<BatchGetDocumentsRequest, BatchGetDocumentsResponse> getBatchGetDocumentsMethod() {
        MethodDescriptor<BatchGetDocumentsRequest, BatchGetDocumentsResponse> methodDescriptor = getBatchGetDocumentsMethod;
        if (methodDescriptor == null) {
            synchronized (FirestoreGrpc.class) {
                methodDescriptor = getBatchGetDocumentsMethod;
                if (methodDescriptor == null) {
                    methodDescriptor = MethodDescriptor.newBuilder().setType(MethodDescriptor.MethodType.SERVER_STREAMING).setFullMethodName(MethodDescriptor.generateFullMethodName(SERVICE_NAME, "BatchGetDocuments")).setSampledToLocalTracing(true).setRequestMarshaller(ProtoLiteUtils.marshaller(BatchGetDocumentsRequest.getDefaultInstance())).setResponseMarshaller(ProtoLiteUtils.marshaller(BatchGetDocumentsResponse.getDefaultInstance())).build();
                    getBatchGetDocumentsMethod = methodDescriptor;
                }
            }
        }
        return methodDescriptor;
    }

    @RpcMethod(fullMethodName = "google.firestore.v1.Firestore/BeginTransaction", methodType = MethodDescriptor.MethodType.UNARY, requestType = BeginTransactionRequest.class, responseType = BeginTransactionResponse.class)
    public static MethodDescriptor<BeginTransactionRequest, BeginTransactionResponse> getBeginTransactionMethod() {
        MethodDescriptor<BeginTransactionRequest, BeginTransactionResponse> methodDescriptor = getBeginTransactionMethod;
        if (methodDescriptor == null) {
            synchronized (FirestoreGrpc.class) {
                methodDescriptor = getBeginTransactionMethod;
                if (methodDescriptor == null) {
                    methodDescriptor = MethodDescriptor.newBuilder().setType(MethodDescriptor.MethodType.UNARY).setFullMethodName(MethodDescriptor.generateFullMethodName(SERVICE_NAME, "BeginTransaction")).setSampledToLocalTracing(true).setRequestMarshaller(ProtoLiteUtils.marshaller(BeginTransactionRequest.getDefaultInstance())).setResponseMarshaller(ProtoLiteUtils.marshaller(BeginTransactionResponse.getDefaultInstance())).build();
                    getBeginTransactionMethod = methodDescriptor;
                }
            }
        }
        return methodDescriptor;
    }

    @RpcMethod(fullMethodName = "google.firestore.v1.Firestore/Commit", methodType = MethodDescriptor.MethodType.UNARY, requestType = CommitRequest.class, responseType = CommitResponse.class)
    public static MethodDescriptor<CommitRequest, CommitResponse> getCommitMethod() {
        MethodDescriptor<CommitRequest, CommitResponse> methodDescriptor = getCommitMethod;
        if (methodDescriptor == null) {
            synchronized (FirestoreGrpc.class) {
                methodDescriptor = getCommitMethod;
                if (methodDescriptor == null) {
                    methodDescriptor = MethodDescriptor.newBuilder().setType(MethodDescriptor.MethodType.UNARY).setFullMethodName(MethodDescriptor.generateFullMethodName(SERVICE_NAME, "Commit")).setSampledToLocalTracing(true).setRequestMarshaller(ProtoLiteUtils.marshaller(CommitRequest.getDefaultInstance())).setResponseMarshaller(ProtoLiteUtils.marshaller(CommitResponse.getDefaultInstance())).build();
                    getCommitMethod = methodDescriptor;
                }
            }
        }
        return methodDescriptor;
    }

    @RpcMethod(fullMethodName = "google.firestore.v1.Firestore/Rollback", methodType = MethodDescriptor.MethodType.UNARY, requestType = RollbackRequest.class, responseType = Empty.class)
    public static MethodDescriptor<RollbackRequest, Empty> getRollbackMethod() {
        MethodDescriptor<RollbackRequest, Empty> methodDescriptor = getRollbackMethod;
        if (methodDescriptor == null) {
            synchronized (FirestoreGrpc.class) {
                methodDescriptor = getRollbackMethod;
                if (methodDescriptor == null) {
                    methodDescriptor = MethodDescriptor.newBuilder().setType(MethodDescriptor.MethodType.UNARY).setFullMethodName(MethodDescriptor.generateFullMethodName(SERVICE_NAME, "Rollback")).setSampledToLocalTracing(true).setRequestMarshaller(ProtoLiteUtils.marshaller(RollbackRequest.getDefaultInstance())).setResponseMarshaller(ProtoLiteUtils.marshaller(Empty.getDefaultInstance())).build();
                    getRollbackMethod = methodDescriptor;
                }
            }
        }
        return methodDescriptor;
    }

    @RpcMethod(fullMethodName = "google.firestore.v1.Firestore/RunQuery", methodType = MethodDescriptor.MethodType.SERVER_STREAMING, requestType = RunQueryRequest.class, responseType = RunQueryResponse.class)
    public static MethodDescriptor<RunQueryRequest, RunQueryResponse> getRunQueryMethod() {
        MethodDescriptor<RunQueryRequest, RunQueryResponse> methodDescriptor = getRunQueryMethod;
        if (methodDescriptor == null) {
            synchronized (FirestoreGrpc.class) {
                methodDescriptor = getRunQueryMethod;
                if (methodDescriptor == null) {
                    methodDescriptor = MethodDescriptor.newBuilder().setType(MethodDescriptor.MethodType.SERVER_STREAMING).setFullMethodName(MethodDescriptor.generateFullMethodName(SERVICE_NAME, "RunQuery")).setSampledToLocalTracing(true).setRequestMarshaller(ProtoLiteUtils.marshaller(RunQueryRequest.getDefaultInstance())).setResponseMarshaller(ProtoLiteUtils.marshaller(RunQueryResponse.getDefaultInstance())).build();
                    getRunQueryMethod = methodDescriptor;
                }
            }
        }
        return methodDescriptor;
    }

    @RpcMethod(fullMethodName = "google.firestore.v1.Firestore/Write", methodType = MethodDescriptor.MethodType.BIDI_STREAMING, requestType = WriteRequest.class, responseType = WriteResponse.class)
    public static MethodDescriptor<WriteRequest, WriteResponse> getWriteMethod() {
        MethodDescriptor<WriteRequest, WriteResponse> methodDescriptor = getWriteMethod;
        if (methodDescriptor == null) {
            synchronized (FirestoreGrpc.class) {
                methodDescriptor = getWriteMethod;
                if (methodDescriptor == null) {
                    methodDescriptor = MethodDescriptor.newBuilder().setType(MethodDescriptor.MethodType.BIDI_STREAMING).setFullMethodName(MethodDescriptor.generateFullMethodName(SERVICE_NAME, "Write")).setSampledToLocalTracing(true).setRequestMarshaller(ProtoLiteUtils.marshaller(WriteRequest.getDefaultInstance())).setResponseMarshaller(ProtoLiteUtils.marshaller(WriteResponse.getDefaultInstance())).build();
                    getWriteMethod = methodDescriptor;
                }
            }
        }
        return methodDescriptor;
    }

    @RpcMethod(fullMethodName = "google.firestore.v1.Firestore/Listen", methodType = MethodDescriptor.MethodType.BIDI_STREAMING, requestType = ListenRequest.class, responseType = ListenResponse.class)
    public static MethodDescriptor<ListenRequest, ListenResponse> getListenMethod() {
        MethodDescriptor<ListenRequest, ListenResponse> methodDescriptor = getListenMethod;
        if (methodDescriptor == null) {
            synchronized (FirestoreGrpc.class) {
                methodDescriptor = getListenMethod;
                if (methodDescriptor == null) {
                    methodDescriptor = MethodDescriptor.newBuilder().setType(MethodDescriptor.MethodType.BIDI_STREAMING).setFullMethodName(MethodDescriptor.generateFullMethodName(SERVICE_NAME, "Listen")).setSampledToLocalTracing(true).setRequestMarshaller(ProtoLiteUtils.marshaller(ListenRequest.getDefaultInstance())).setResponseMarshaller(ProtoLiteUtils.marshaller(ListenResponse.getDefaultInstance())).build();
                    getListenMethod = methodDescriptor;
                }
            }
        }
        return methodDescriptor;
    }

    @RpcMethod(fullMethodName = "google.firestore.v1.Firestore/ListCollectionIds", methodType = MethodDescriptor.MethodType.UNARY, requestType = ListCollectionIdsRequest.class, responseType = ListCollectionIdsResponse.class)
    public static MethodDescriptor<ListCollectionIdsRequest, ListCollectionIdsResponse> getListCollectionIdsMethod() {
        MethodDescriptor<ListCollectionIdsRequest, ListCollectionIdsResponse> methodDescriptor = getListCollectionIdsMethod;
        if (methodDescriptor == null) {
            synchronized (FirestoreGrpc.class) {
                methodDescriptor = getListCollectionIdsMethod;
                if (methodDescriptor == null) {
                    methodDescriptor = MethodDescriptor.newBuilder().setType(MethodDescriptor.MethodType.UNARY).setFullMethodName(MethodDescriptor.generateFullMethodName(SERVICE_NAME, "ListCollectionIds")).setSampledToLocalTracing(true).setRequestMarshaller(ProtoLiteUtils.marshaller(ListCollectionIdsRequest.getDefaultInstance())).setResponseMarshaller(ProtoLiteUtils.marshaller(ListCollectionIdsResponse.getDefaultInstance())).build();
                    getListCollectionIdsMethod = methodDescriptor;
                }
            }
        }
        return methodDescriptor;
    }

    public static FirestoreStub newStub(Channel channel) {
        return new FirestoreStub(channel);
    }

    public static FirestoreBlockingStub newBlockingStub(Channel channel) {
        return new FirestoreBlockingStub(channel);
    }

    public static FirestoreFutureStub newFutureStub(Channel channel) {
        return new FirestoreFutureStub(channel);
    }

    /* compiled from: com.google.firebase:firebase-firestore@@20.2.0 */
    public static abstract class FirestoreImplBase implements BindableService {
        public void getDocument(GetDocumentRequest getDocumentRequest, StreamObserver<Document> streamObserver) {
            ServerCalls.asyncUnimplementedUnaryCall(FirestoreGrpc.getGetDocumentMethod(), streamObserver);
        }

        public void listDocuments(ListDocumentsRequest listDocumentsRequest, StreamObserver<ListDocumentsResponse> streamObserver) {
            ServerCalls.asyncUnimplementedUnaryCall(FirestoreGrpc.getListDocumentsMethod(), streamObserver);
        }

        public void createDocument(CreateDocumentRequest createDocumentRequest, StreamObserver<Document> streamObserver) {
            ServerCalls.asyncUnimplementedUnaryCall(FirestoreGrpc.getCreateDocumentMethod(), streamObserver);
        }

        public void updateDocument(UpdateDocumentRequest updateDocumentRequest, StreamObserver<Document> streamObserver) {
            ServerCalls.asyncUnimplementedUnaryCall(FirestoreGrpc.getUpdateDocumentMethod(), streamObserver);
        }

        public void deleteDocument(DeleteDocumentRequest deleteDocumentRequest, StreamObserver<Empty> streamObserver) {
            ServerCalls.asyncUnimplementedUnaryCall(FirestoreGrpc.getDeleteDocumentMethod(), streamObserver);
        }

        public void batchGetDocuments(BatchGetDocumentsRequest batchGetDocumentsRequest, StreamObserver<BatchGetDocumentsResponse> streamObserver) {
            ServerCalls.asyncUnimplementedUnaryCall(FirestoreGrpc.getBatchGetDocumentsMethod(), streamObserver);
        }

        public void beginTransaction(BeginTransactionRequest beginTransactionRequest, StreamObserver<BeginTransactionResponse> streamObserver) {
            ServerCalls.asyncUnimplementedUnaryCall(FirestoreGrpc.getBeginTransactionMethod(), streamObserver);
        }

        public void commit(CommitRequest commitRequest, StreamObserver<CommitResponse> streamObserver) {
            ServerCalls.asyncUnimplementedUnaryCall(FirestoreGrpc.getCommitMethod(), streamObserver);
        }

        public void rollback(RollbackRequest rollbackRequest, StreamObserver<Empty> streamObserver) {
            ServerCalls.asyncUnimplementedUnaryCall(FirestoreGrpc.getRollbackMethod(), streamObserver);
        }

        public void runQuery(RunQueryRequest runQueryRequest, StreamObserver<RunQueryResponse> streamObserver) {
            ServerCalls.asyncUnimplementedUnaryCall(FirestoreGrpc.getRunQueryMethod(), streamObserver);
        }

        public StreamObserver<WriteRequest> write(StreamObserver<WriteResponse> streamObserver) {
            return ServerCalls.asyncUnimplementedStreamingCall(FirestoreGrpc.getWriteMethod(), streamObserver);
        }

        public StreamObserver<ListenRequest> listen(StreamObserver<ListenResponse> streamObserver) {
            return ServerCalls.asyncUnimplementedStreamingCall(FirestoreGrpc.getListenMethod(), streamObserver);
        }

        public void listCollectionIds(ListCollectionIdsRequest listCollectionIdsRequest, StreamObserver<ListCollectionIdsResponse> streamObserver) {
            ServerCalls.asyncUnimplementedUnaryCall(FirestoreGrpc.getListCollectionIdsMethod(), streamObserver);
        }

        public final ServerServiceDefinition bindService() {
            return ServerServiceDefinition.builder(FirestoreGrpc.getServiceDescriptor()).addMethod(FirestoreGrpc.getGetDocumentMethod(), ServerCalls.asyncUnaryCall(new MethodHandlers(this, 0))).addMethod(FirestoreGrpc.getListDocumentsMethod(), ServerCalls.asyncUnaryCall(new MethodHandlers(this, 1))).addMethod(FirestoreGrpc.getCreateDocumentMethod(), ServerCalls.asyncUnaryCall(new MethodHandlers(this, 2))).addMethod(FirestoreGrpc.getUpdateDocumentMethod(), ServerCalls.asyncUnaryCall(new MethodHandlers(this, 3))).addMethod(FirestoreGrpc.getDeleteDocumentMethod(), ServerCalls.asyncUnaryCall(new MethodHandlers(this, 4))).addMethod(FirestoreGrpc.getBatchGetDocumentsMethod(), ServerCalls.asyncServerStreamingCall(new MethodHandlers(this, 5))).addMethod(FirestoreGrpc.getBeginTransactionMethod(), ServerCalls.asyncUnaryCall(new MethodHandlers(this, 6))).addMethod(FirestoreGrpc.getCommitMethod(), ServerCalls.asyncUnaryCall(new MethodHandlers(this, 7))).addMethod(FirestoreGrpc.getRollbackMethod(), ServerCalls.asyncUnaryCall(new MethodHandlers(this, 8))).addMethod(FirestoreGrpc.getRunQueryMethod(), ServerCalls.asyncServerStreamingCall(new MethodHandlers(this, 9))).addMethod(FirestoreGrpc.getWriteMethod(), ServerCalls.asyncBidiStreamingCall(new MethodHandlers(this, 11))).addMethod(FirestoreGrpc.getListenMethod(), ServerCalls.asyncBidiStreamingCall(new MethodHandlers(this, 12))).addMethod(FirestoreGrpc.getListCollectionIdsMethod(), ServerCalls.asyncUnaryCall(new MethodHandlers(this, 10))).build();
        }
    }

    /* compiled from: com.google.firebase:firebase-firestore@@20.2.0 */
    public static final class FirestoreStub extends AbstractStub<FirestoreStub> {
        private FirestoreStub(Channel channel) {
            super(channel);
        }

        private FirestoreStub(Channel channel, CallOptions callOptions) {
            super(channel, callOptions);
        }

        /* access modifiers changed from: protected */
        public FirestoreStub build(Channel channel, CallOptions callOptions) {
            return new FirestoreStub(channel, callOptions);
        }

        public void getDocument(GetDocumentRequest getDocumentRequest, StreamObserver<Document> streamObserver) {
            ClientCalls.asyncUnaryCall(getChannel().newCall(FirestoreGrpc.getGetDocumentMethod(), getCallOptions()), getDocumentRequest, streamObserver);
        }

        public void listDocuments(ListDocumentsRequest listDocumentsRequest, StreamObserver<ListDocumentsResponse> streamObserver) {
            ClientCalls.asyncUnaryCall(getChannel().newCall(FirestoreGrpc.getListDocumentsMethod(), getCallOptions()), listDocumentsRequest, streamObserver);
        }

        public void createDocument(CreateDocumentRequest createDocumentRequest, StreamObserver<Document> streamObserver) {
            ClientCalls.asyncUnaryCall(getChannel().newCall(FirestoreGrpc.getCreateDocumentMethod(), getCallOptions()), createDocumentRequest, streamObserver);
        }

        public void updateDocument(UpdateDocumentRequest updateDocumentRequest, StreamObserver<Document> streamObserver) {
            ClientCalls.asyncUnaryCall(getChannel().newCall(FirestoreGrpc.getUpdateDocumentMethod(), getCallOptions()), updateDocumentRequest, streamObserver);
        }

        public void deleteDocument(DeleteDocumentRequest deleteDocumentRequest, StreamObserver<Empty> streamObserver) {
            ClientCalls.asyncUnaryCall(getChannel().newCall(FirestoreGrpc.getDeleteDocumentMethod(), getCallOptions()), deleteDocumentRequest, streamObserver);
        }

        public void batchGetDocuments(BatchGetDocumentsRequest batchGetDocumentsRequest, StreamObserver<BatchGetDocumentsResponse> streamObserver) {
            ClientCalls.asyncServerStreamingCall(getChannel().newCall(FirestoreGrpc.getBatchGetDocumentsMethod(), getCallOptions()), batchGetDocumentsRequest, streamObserver);
        }

        public void beginTransaction(BeginTransactionRequest beginTransactionRequest, StreamObserver<BeginTransactionResponse> streamObserver) {
            ClientCalls.asyncUnaryCall(getChannel().newCall(FirestoreGrpc.getBeginTransactionMethod(), getCallOptions()), beginTransactionRequest, streamObserver);
        }

        public void commit(CommitRequest commitRequest, StreamObserver<CommitResponse> streamObserver) {
            ClientCalls.asyncUnaryCall(getChannel().newCall(FirestoreGrpc.getCommitMethod(), getCallOptions()), commitRequest, streamObserver);
        }

        public void rollback(RollbackRequest rollbackRequest, StreamObserver<Empty> streamObserver) {
            ClientCalls.asyncUnaryCall(getChannel().newCall(FirestoreGrpc.getRollbackMethod(), getCallOptions()), rollbackRequest, streamObserver);
        }

        public void runQuery(RunQueryRequest runQueryRequest, StreamObserver<RunQueryResponse> streamObserver) {
            ClientCalls.asyncServerStreamingCall(getChannel().newCall(FirestoreGrpc.getRunQueryMethod(), getCallOptions()), runQueryRequest, streamObserver);
        }

        public StreamObserver<WriteRequest> write(StreamObserver<WriteResponse> streamObserver) {
            return ClientCalls.asyncBidiStreamingCall(getChannel().newCall(FirestoreGrpc.getWriteMethod(), getCallOptions()), streamObserver);
        }

        public StreamObserver<ListenRequest> listen(StreamObserver<ListenResponse> streamObserver) {
            return ClientCalls.asyncBidiStreamingCall(getChannel().newCall(FirestoreGrpc.getListenMethod(), getCallOptions()), streamObserver);
        }

        public void listCollectionIds(ListCollectionIdsRequest listCollectionIdsRequest, StreamObserver<ListCollectionIdsResponse> streamObserver) {
            ClientCalls.asyncUnaryCall(getChannel().newCall(FirestoreGrpc.getListCollectionIdsMethod(), getCallOptions()), listCollectionIdsRequest, streamObserver);
        }
    }

    /* compiled from: com.google.firebase:firebase-firestore@@20.2.0 */
    public static final class FirestoreBlockingStub extends AbstractStub<FirestoreBlockingStub> {
        private FirestoreBlockingStub(Channel channel) {
            super(channel);
        }

        private FirestoreBlockingStub(Channel channel, CallOptions callOptions) {
            super(channel, callOptions);
        }

        /* access modifiers changed from: protected */
        public FirestoreBlockingStub build(Channel channel, CallOptions callOptions) {
            return new FirestoreBlockingStub(channel, callOptions);
        }

        public Document getDocument(GetDocumentRequest getDocumentRequest) {
            return (Document) ClientCalls.blockingUnaryCall(getChannel(), FirestoreGrpc.getGetDocumentMethod(), getCallOptions(), getDocumentRequest);
        }

        public ListDocumentsResponse listDocuments(ListDocumentsRequest listDocumentsRequest) {
            return (ListDocumentsResponse) ClientCalls.blockingUnaryCall(getChannel(), FirestoreGrpc.getListDocumentsMethod(), getCallOptions(), listDocumentsRequest);
        }

        public Document createDocument(CreateDocumentRequest createDocumentRequest) {
            return (Document) ClientCalls.blockingUnaryCall(getChannel(), FirestoreGrpc.getCreateDocumentMethod(), getCallOptions(), createDocumentRequest);
        }

        public Document updateDocument(UpdateDocumentRequest updateDocumentRequest) {
            return (Document) ClientCalls.blockingUnaryCall(getChannel(), FirestoreGrpc.getUpdateDocumentMethod(), getCallOptions(), updateDocumentRequest);
        }

        public Empty deleteDocument(DeleteDocumentRequest deleteDocumentRequest) {
            return (Empty) ClientCalls.blockingUnaryCall(getChannel(), FirestoreGrpc.getDeleteDocumentMethod(), getCallOptions(), deleteDocumentRequest);
        }

        public Iterator<BatchGetDocumentsResponse> batchGetDocuments(BatchGetDocumentsRequest batchGetDocumentsRequest) {
            return ClientCalls.blockingServerStreamingCall(getChannel(), FirestoreGrpc.getBatchGetDocumentsMethod(), getCallOptions(), batchGetDocumentsRequest);
        }

        public BeginTransactionResponse beginTransaction(BeginTransactionRequest beginTransactionRequest) {
            return (BeginTransactionResponse) ClientCalls.blockingUnaryCall(getChannel(), FirestoreGrpc.getBeginTransactionMethod(), getCallOptions(), beginTransactionRequest);
        }

        public CommitResponse commit(CommitRequest commitRequest) {
            return (CommitResponse) ClientCalls.blockingUnaryCall(getChannel(), FirestoreGrpc.getCommitMethod(), getCallOptions(), commitRequest);
        }

        public Empty rollback(RollbackRequest rollbackRequest) {
            return (Empty) ClientCalls.blockingUnaryCall(getChannel(), FirestoreGrpc.getRollbackMethod(), getCallOptions(), rollbackRequest);
        }

        public Iterator<RunQueryResponse> runQuery(RunQueryRequest runQueryRequest) {
            return ClientCalls.blockingServerStreamingCall(getChannel(), FirestoreGrpc.getRunQueryMethod(), getCallOptions(), runQueryRequest);
        }

        public ListCollectionIdsResponse listCollectionIds(ListCollectionIdsRequest listCollectionIdsRequest) {
            return (ListCollectionIdsResponse) ClientCalls.blockingUnaryCall(getChannel(), FirestoreGrpc.getListCollectionIdsMethod(), getCallOptions(), listCollectionIdsRequest);
        }
    }

    /* compiled from: com.google.firebase:firebase-firestore@@20.2.0 */
    public static final class FirestoreFutureStub extends AbstractStub<FirestoreFutureStub> {
        private FirestoreFutureStub(Channel channel) {
            super(channel);
        }

        private FirestoreFutureStub(Channel channel, CallOptions callOptions) {
            super(channel, callOptions);
        }

        /* access modifiers changed from: protected */
        public FirestoreFutureStub build(Channel channel, CallOptions callOptions) {
            return new FirestoreFutureStub(channel, callOptions);
        }

        public ListenableFuture<Document> getDocument(GetDocumentRequest getDocumentRequest) {
            return ClientCalls.futureUnaryCall(getChannel().newCall(FirestoreGrpc.getGetDocumentMethod(), getCallOptions()), getDocumentRequest);
        }

        public ListenableFuture<ListDocumentsResponse> listDocuments(ListDocumentsRequest listDocumentsRequest) {
            return ClientCalls.futureUnaryCall(getChannel().newCall(FirestoreGrpc.getListDocumentsMethod(), getCallOptions()), listDocumentsRequest);
        }

        public ListenableFuture<Document> createDocument(CreateDocumentRequest createDocumentRequest) {
            return ClientCalls.futureUnaryCall(getChannel().newCall(FirestoreGrpc.getCreateDocumentMethod(), getCallOptions()), createDocumentRequest);
        }

        public ListenableFuture<Document> updateDocument(UpdateDocumentRequest updateDocumentRequest) {
            return ClientCalls.futureUnaryCall(getChannel().newCall(FirestoreGrpc.getUpdateDocumentMethod(), getCallOptions()), updateDocumentRequest);
        }

        public ListenableFuture<Empty> deleteDocument(DeleteDocumentRequest deleteDocumentRequest) {
            return ClientCalls.futureUnaryCall(getChannel().newCall(FirestoreGrpc.getDeleteDocumentMethod(), getCallOptions()), deleteDocumentRequest);
        }

        public ListenableFuture<BeginTransactionResponse> beginTransaction(BeginTransactionRequest beginTransactionRequest) {
            return ClientCalls.futureUnaryCall(getChannel().newCall(FirestoreGrpc.getBeginTransactionMethod(), getCallOptions()), beginTransactionRequest);
        }

        public ListenableFuture<CommitResponse> commit(CommitRequest commitRequest) {
            return ClientCalls.futureUnaryCall(getChannel().newCall(FirestoreGrpc.getCommitMethod(), getCallOptions()), commitRequest);
        }

        public ListenableFuture<Empty> rollback(RollbackRequest rollbackRequest) {
            return ClientCalls.futureUnaryCall(getChannel().newCall(FirestoreGrpc.getRollbackMethod(), getCallOptions()), rollbackRequest);
        }

        public ListenableFuture<ListCollectionIdsResponse> listCollectionIds(ListCollectionIdsRequest listCollectionIdsRequest) {
            return ClientCalls.futureUnaryCall(getChannel().newCall(FirestoreGrpc.getListCollectionIdsMethod(), getCallOptions()), listCollectionIdsRequest);
        }
    }

    /* compiled from: com.google.firebase:firebase-firestore@@20.2.0 */
    private static final class MethodHandlers<Req, Resp> implements ServerCalls.UnaryMethod<Req, Resp>, ServerCalls.ServerStreamingMethod<Req, Resp>, ServerCalls.ClientStreamingMethod<Req, Resp>, ServerCalls.BidiStreamingMethod<Req, Resp> {
        private final int methodId;
        private final FirestoreImplBase serviceImpl;

        MethodHandlers(FirestoreImplBase firestoreImplBase, int i) {
            this.serviceImpl = firestoreImplBase;
            this.methodId = i;
        }

        public void invoke(Req req, StreamObserver<Resp> streamObserver) {
            switch (this.methodId) {
                case 0:
                    this.serviceImpl.getDocument((GetDocumentRequest) req, streamObserver);
                    return;
                case 1:
                    this.serviceImpl.listDocuments((ListDocumentsRequest) req, streamObserver);
                    return;
                case 2:
                    this.serviceImpl.createDocument((CreateDocumentRequest) req, streamObserver);
                    return;
                case 3:
                    this.serviceImpl.updateDocument((UpdateDocumentRequest) req, streamObserver);
                    return;
                case 4:
                    this.serviceImpl.deleteDocument((DeleteDocumentRequest) req, streamObserver);
                    return;
                case 5:
                    this.serviceImpl.batchGetDocuments((BatchGetDocumentsRequest) req, streamObserver);
                    return;
                case 6:
                    this.serviceImpl.beginTransaction((BeginTransactionRequest) req, streamObserver);
                    return;
                case 7:
                    this.serviceImpl.commit((CommitRequest) req, streamObserver);
                    return;
                case 8:
                    this.serviceImpl.rollback((RollbackRequest) req, streamObserver);
                    return;
                case 9:
                    this.serviceImpl.runQuery((RunQueryRequest) req, streamObserver);
                    return;
                case 10:
                    this.serviceImpl.listCollectionIds((ListCollectionIdsRequest) req, streamObserver);
                    return;
                default:
                    throw new AssertionError();
            }
        }

        public StreamObserver<Req> invoke(StreamObserver<Resp> streamObserver) {
            int i = this.methodId;
            if (i == 11) {
                return this.serviceImpl.write(streamObserver);
            }
            if (i == 12) {
                return this.serviceImpl.listen(streamObserver);
            }
            throw new AssertionError();
        }
    }

    public static ServiceDescriptor getServiceDescriptor() {
        ServiceDescriptor serviceDescriptor2 = serviceDescriptor;
        if (serviceDescriptor2 == null) {
            synchronized (FirestoreGrpc.class) {
                serviceDescriptor2 = serviceDescriptor;
                if (serviceDescriptor2 == null) {
                    serviceDescriptor2 = ServiceDescriptor.newBuilder(SERVICE_NAME).addMethod(getGetDocumentMethod()).addMethod(getListDocumentsMethod()).addMethod(getCreateDocumentMethod()).addMethod(getUpdateDocumentMethod()).addMethod(getDeleteDocumentMethod()).addMethod(getBatchGetDocumentsMethod()).addMethod(getBeginTransactionMethod()).addMethod(getCommitMethod()).addMethod(getRollbackMethod()).addMethod(getRunQueryMethod()).addMethod(getWriteMethod()).addMethod(getListenMethod()).addMethod(getListCollectionIdsMethod()).build();
                    serviceDescriptor = serviceDescriptor2;
                }
            }
        }
        return serviceDescriptor2;
    }
}
