package com.google.firebase.firestore.remote;

import android.content.Context;
import com.google.firebase.firestore.core.DatabaseInfo;
import io.grpc.CallCredentials;
import java.util.concurrent.Callable;

/* compiled from: com.google.firebase:firebase-firestore@@20.2.0 */
final /* synthetic */ class GrpcCallProvider$$Lambda$1 implements Callable {
    private final GrpcCallProvider arg$1;
    private final Context arg$2;
    private final DatabaseInfo arg$3;
    private final CallCredentials arg$4;

    private GrpcCallProvider$$Lambda$1(GrpcCallProvider grpcCallProvider, Context context, DatabaseInfo databaseInfo, CallCredentials callCredentials) {
        this.arg$1 = grpcCallProvider;
        this.arg$2 = context;
        this.arg$3 = databaseInfo;
        this.arg$4 = callCredentials;
    }

    public static Callable lambdaFactory$(GrpcCallProvider grpcCallProvider, Context context, DatabaseInfo databaseInfo, CallCredentials callCredentials) {
        return new GrpcCallProvider$$Lambda$1(grpcCallProvider, context, databaseInfo, callCredentials);
    }

    public Object call() {
        return GrpcCallProvider.lambda$new$0(this.arg$1, this.arg$2, this.arg$3, this.arg$4);
    }
}
