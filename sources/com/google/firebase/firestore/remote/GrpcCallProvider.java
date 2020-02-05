package com.google.firebase.firestore.remote;

import android.content.Context;
import androidx.annotation.VisibleForTesting;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesRepairableException;
import com.google.android.gms.security.ProviderInstaller;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;
import com.google.firebase.firestore.core.DatabaseInfo;
import com.google.firebase.firestore.util.AsyncQueue;
import com.google.firebase.firestore.util.Executors;
import com.google.firebase.firestore.util.Logger;
import com.google.firebase.firestore.util.Supplier;
import com.google.firestore.v1.FirestoreGrpc;
import io.grpc.CallCredentials;
import io.grpc.CallOptions;
import io.grpc.ClientCall;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.MethodDescriptor;
import io.grpc.android.AndroidChannelBuilder;
import java.util.concurrent.TimeUnit;

/* compiled from: com.google.firebase:firebase-firestore@@20.2.0 */
public class GrpcCallProvider {
    private static final String LOG_TAG = "GrpcCallProvider";
    private static Supplier<ManagedChannelBuilder<?>> overrideChannelBuilderSupplier;
    private final AsyncQueue asyncQueue;
    private CallOptions callOptions;
    private final Task<ManagedChannel> channelTask;

    @VisibleForTesting
    public static void overrideChannelBuilder(Supplier<ManagedChannelBuilder<?>> supplier) {
        overrideChannelBuilderSupplier = supplier;
    }

    GrpcCallProvider(AsyncQueue asyncQueue2, Context context, DatabaseInfo databaseInfo, CallCredentials callCredentials) {
        this.asyncQueue = asyncQueue2;
        this.channelTask = Tasks.call(Executors.BACKGROUND_EXECUTOR, GrpcCallProvider$$Lambda$1.lambdaFactory$(this, context, databaseInfo, callCredentials));
    }

    static /* synthetic */ ManagedChannel lambda$new$0(GrpcCallProvider grpcCallProvider, Context context, DatabaseInfo databaseInfo, CallCredentials callCredentials) throws Exception {
        ManagedChannel initChannel = grpcCallProvider.initChannel(context, databaseInfo);
        grpcCallProvider.callOptions = ((FirestoreGrpc.FirestoreStub) FirestoreGrpc.newStub(initChannel).withCallCredentials(callCredentials)).getCallOptions();
        return initChannel;
    }

    private ManagedChannel initChannel(Context context, DatabaseInfo databaseInfo) {
        ManagedChannelBuilder<?> managedChannelBuilder;
        try {
            ProviderInstaller.installIfNeeded(context);
        } catch (GooglePlayServicesNotAvailableException | GooglePlayServicesRepairableException | IllegalStateException e) {
            Logger.warn(LOG_TAG, "Failed to update ssl context: %s", e);
        }
        Supplier<ManagedChannelBuilder<?>> supplier = overrideChannelBuilderSupplier;
        if (supplier != null) {
            managedChannelBuilder = supplier.get();
        } else {
            ManagedChannelBuilder<?> forTarget = ManagedChannelBuilder.forTarget(databaseInfo.getHost());
            if (!databaseInfo.isSslEnabled()) {
                forTarget.usePlaintext();
            }
            managedChannelBuilder = forTarget;
        }
        managedChannelBuilder.keepAliveTime(30, TimeUnit.SECONDS);
        managedChannelBuilder.executor(this.asyncQueue.getExecutor());
        return AndroidChannelBuilder.fromBuilder(managedChannelBuilder).context(context).build();
    }

    /* access modifiers changed from: package-private */
    public <ReqT, RespT> Task<ClientCall<ReqT, RespT>> createClientCall(MethodDescriptor<ReqT, RespT> methodDescriptor) {
        return this.channelTask.continueWithTask(this.asyncQueue.getExecutor(), GrpcCallProvider$$Lambda$2.lambdaFactory$(this, methodDescriptor));
    }

    /* access modifiers changed from: package-private */
    public void shutdown() {
        this.channelTask.addOnCompleteListener(this.asyncQueue.getExecutor(), GrpcCallProvider$$Lambda$3.lambdaFactory$());
    }

    static /* synthetic */ void lambda$shutdown$2(Task task) {
        ManagedChannel managedChannel = (ManagedChannel) task.getResult();
        managedChannel.shutdown();
        try {
            if (!managedChannel.awaitTermination(1, TimeUnit.SECONDS)) {
                Logger.debug(FirestoreChannel.class.getSimpleName(), "Unable to gracefully shutdown the gRPC ManagedChannel. Will attempt an immediate shutdown.", new Object[0]);
                managedChannel.shutdownNow();
                if (!managedChannel.awaitTermination(60, TimeUnit.SECONDS)) {
                    Logger.warn(FirestoreChannel.class.getSimpleName(), "Unable to forcefully shutdown the gRPC ManagedChannel.", new Object[0]);
                }
            }
        } catch (InterruptedException unused) {
            managedChannel.shutdownNow();
            Logger.warn(FirestoreChannel.class.getSimpleName(), "Interrupted while shutting down the gRPC Managed Channel", new Object[0]);
            Thread.currentThread().interrupt();
        }
    }
}
