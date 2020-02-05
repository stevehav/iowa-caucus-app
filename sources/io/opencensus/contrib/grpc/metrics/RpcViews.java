package io.opencensus.contrib.grpc.metrics;

import com.google.common.annotations.VisibleForTesting;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.UnmodifiableIterator;
import io.opencensus.stats.Stats;
import io.opencensus.stats.View;
import io.opencensus.stats.ViewManager;

public final class RpcViews {
    @VisibleForTesting
    static final ImmutableSet<View> GRPC_CLIENT_BASIC_VIEWS_SET = ImmutableSet.of(RpcViewConstants.GRPC_CLIENT_ROUNDTRIP_LATENCY_VIEW, RpcViewConstants.GRPC_CLIENT_STARTED_RPC_VIEW);
    @VisibleForTesting
    static final ImmutableSet<View> GRPC_CLIENT_VIEWS_SET = ImmutableSet.of(RpcViewConstants.GRPC_CLIENT_ROUNDTRIP_LATENCY_VIEW, RpcViewConstants.GRPC_CLIENT_SENT_BYTES_PER_RPC_VIEW, RpcViewConstants.GRPC_CLIENT_RECEIVED_BYTES_PER_RPC_VIEW, RpcViewConstants.GRPC_CLIENT_SENT_MESSAGES_PER_RPC_VIEW, RpcViewConstants.GRPC_CLIENT_RECEIVED_MESSAGES_PER_RPC_VIEW, RpcViewConstants.GRPC_CLIENT_SERVER_LATENCY_VIEW, RpcViewConstants.GRPC_CLIENT_COMPLETED_RPC_VIEW, RpcViewConstants.GRPC_CLIENT_STARTED_RPC_VIEW);
    @VisibleForTesting
    static final ImmutableSet<View> GRPC_REAL_TIME_METRICS_VIEWS_SET = ImmutableSet.of(RpcViewConstants.GRPC_CLIENT_SENT_BYTES_PER_METHOD_VIEW, RpcViewConstants.GRPC_CLIENT_RECEIVED_BYTES_PER_METHOD_VIEW, RpcViewConstants.GRPC_CLIENT_SENT_MESSAGES_PER_METHOD_VIEW, RpcViewConstants.GRPC_CLIENT_RECEIVED_MESSAGES_PER_METHOD_VIEW, RpcViewConstants.GRPC_SERVER_SENT_BYTES_PER_METHOD_VIEW, RpcViewConstants.GRPC_SERVER_RECEIVED_BYTES_PER_METHOD_VIEW, RpcViewConstants.GRPC_SERVER_SENT_MESSAGES_PER_METHOD_VIEW, RpcViewConstants.GRPC_SERVER_RECEIVED_MESSAGES_PER_METHOD_VIEW);
    @VisibleForTesting
    static final ImmutableSet<View> GRPC_SERVER_BASIC_VIEWS_SET = ImmutableSet.of(RpcViewConstants.GRPC_SERVER_SERVER_LATENCY_VIEW, RpcViewConstants.GRPC_SERVER_STARTED_RPC_VIEW);
    @VisibleForTesting
    static final ImmutableSet<View> GRPC_SERVER_VIEWS_SET = ImmutableSet.of(RpcViewConstants.GRPC_SERVER_SERVER_LATENCY_VIEW, RpcViewConstants.GRPC_SERVER_SENT_BYTES_PER_RPC_VIEW, RpcViewConstants.GRPC_SERVER_RECEIVED_BYTES_PER_RPC_VIEW, RpcViewConstants.GRPC_SERVER_SENT_MESSAGES_PER_RPC_VIEW, RpcViewConstants.GRPC_SERVER_RECEIVED_MESSAGES_PER_RPC_VIEW, RpcViewConstants.GRPC_SERVER_COMPLETED_RPC_VIEW, RpcViewConstants.GRPC_SERVER_STARTED_RPC_VIEW);
    @VisibleForTesting
    static final ImmutableSet<View> RPC_CUMULATIVE_VIEWS_SET = ImmutableSet.of(RpcViewConstants.RPC_CLIENT_ERROR_COUNT_VIEW, RpcViewConstants.RPC_CLIENT_ROUNDTRIP_LATENCY_VIEW, RpcViewConstants.RPC_CLIENT_REQUEST_BYTES_VIEW, RpcViewConstants.RPC_CLIENT_RESPONSE_BYTES_VIEW, RpcViewConstants.RPC_CLIENT_REQUEST_COUNT_VIEW, RpcViewConstants.RPC_CLIENT_RESPONSE_COUNT_VIEW, RpcViewConstants.RPC_CLIENT_UNCOMPRESSED_REQUEST_BYTES_VIEW, RpcViewConstants.RPC_CLIENT_UNCOMPRESSED_RESPONSE_BYTES_VIEW, RpcViewConstants.RPC_CLIENT_SERVER_ELAPSED_TIME_VIEW, RpcViewConstants.RPC_CLIENT_STARTED_COUNT_CUMULATIVE_VIEW, RpcViewConstants.RPC_CLIENT_FINISHED_COUNT_CUMULATIVE_VIEW, RpcViewConstants.RPC_SERVER_ERROR_COUNT_VIEW, RpcViewConstants.RPC_SERVER_SERVER_LATENCY_VIEW, RpcViewConstants.RPC_SERVER_SERVER_ELAPSED_TIME_VIEW, RpcViewConstants.RPC_SERVER_REQUEST_BYTES_VIEW, RpcViewConstants.RPC_SERVER_RESPONSE_BYTES_VIEW, RpcViewConstants.RPC_SERVER_REQUEST_COUNT_VIEW, RpcViewConstants.RPC_SERVER_RESPONSE_COUNT_VIEW, RpcViewConstants.RPC_SERVER_UNCOMPRESSED_REQUEST_BYTES_VIEW, RpcViewConstants.RPC_SERVER_UNCOMPRESSED_RESPONSE_BYTES_VIEW, RpcViewConstants.RPC_SERVER_STARTED_COUNT_CUMULATIVE_VIEW, RpcViewConstants.RPC_SERVER_FINISHED_COUNT_CUMULATIVE_VIEW);
    @VisibleForTesting
    static final ImmutableSet<View> RPC_INTERVAL_VIEWS_SET = ImmutableSet.of(RpcViewConstants.RPC_CLIENT_ERROR_COUNT_MINUTE_VIEW, RpcViewConstants.RPC_CLIENT_ROUNDTRIP_LATENCY_MINUTE_VIEW, RpcViewConstants.RPC_CLIENT_REQUEST_BYTES_MINUTE_VIEW, RpcViewConstants.RPC_CLIENT_RESPONSE_BYTES_MINUTE_VIEW, RpcViewConstants.RPC_CLIENT_REQUEST_COUNT_MINUTE_VIEW, RpcViewConstants.RPC_CLIENT_RESPONSE_COUNT_MINUTE_VIEW, RpcViewConstants.RPC_CLIENT_UNCOMPRESSED_REQUEST_BYTES_MINUTE_VIEW, RpcViewConstants.RPC_CLIENT_UNCOMPRESSED_RESPONSE_BYTES_MINUTE_VIEW, RpcViewConstants.RPC_CLIENT_SERVER_ELAPSED_TIME_MINUTE_VIEW, RpcViewConstants.RPC_CLIENT_STARTED_COUNT_MINUTE_VIEW, RpcViewConstants.RPC_CLIENT_FINISHED_COUNT_MINUTE_VIEW, RpcViewConstants.RPC_SERVER_ERROR_COUNT_MINUTE_VIEW, RpcViewConstants.RPC_SERVER_SERVER_LATENCY_MINUTE_VIEW, RpcViewConstants.RPC_SERVER_SERVER_ELAPSED_TIME_MINUTE_VIEW, RpcViewConstants.RPC_SERVER_REQUEST_BYTES_MINUTE_VIEW, RpcViewConstants.RPC_SERVER_RESPONSE_BYTES_MINUTE_VIEW, RpcViewConstants.RPC_SERVER_REQUEST_COUNT_MINUTE_VIEW, RpcViewConstants.RPC_SERVER_RESPONSE_COUNT_MINUTE_VIEW, RpcViewConstants.RPC_SERVER_UNCOMPRESSED_REQUEST_BYTES_MINUTE_VIEW, RpcViewConstants.RPC_SERVER_UNCOMPRESSED_RESPONSE_BYTES_MINUTE_VIEW, RpcViewConstants.RPC_SERVER_STARTED_COUNT_MINUTE_VIEW, RpcViewConstants.RPC_SERVER_FINISHED_COUNT_MINUTE_VIEW, RpcViewConstants.RPC_CLIENT_ERROR_COUNT_HOUR_VIEW, RpcViewConstants.RPC_CLIENT_ROUNDTRIP_LATENCY_HOUR_VIEW, RpcViewConstants.RPC_CLIENT_REQUEST_BYTES_HOUR_VIEW, RpcViewConstants.RPC_CLIENT_RESPONSE_BYTES_HOUR_VIEW, RpcViewConstants.RPC_CLIENT_REQUEST_COUNT_HOUR_VIEW, RpcViewConstants.RPC_CLIENT_RESPONSE_COUNT_HOUR_VIEW, RpcViewConstants.RPC_CLIENT_UNCOMPRESSED_REQUEST_BYTES_HOUR_VIEW, RpcViewConstants.RPC_CLIENT_UNCOMPRESSED_RESPONSE_BYTES_HOUR_VIEW, RpcViewConstants.RPC_CLIENT_SERVER_ELAPSED_TIME_HOUR_VIEW, RpcViewConstants.RPC_CLIENT_STARTED_COUNT_HOUR_VIEW, RpcViewConstants.RPC_CLIENT_FINISHED_COUNT_HOUR_VIEW, RpcViewConstants.RPC_SERVER_ERROR_COUNT_HOUR_VIEW, RpcViewConstants.RPC_SERVER_SERVER_LATENCY_HOUR_VIEW, RpcViewConstants.RPC_SERVER_SERVER_ELAPSED_TIME_HOUR_VIEW, RpcViewConstants.RPC_SERVER_REQUEST_BYTES_HOUR_VIEW, RpcViewConstants.RPC_SERVER_RESPONSE_BYTES_HOUR_VIEW, RpcViewConstants.RPC_SERVER_REQUEST_COUNT_HOUR_VIEW, RpcViewConstants.RPC_SERVER_RESPONSE_COUNT_HOUR_VIEW, RpcViewConstants.RPC_SERVER_UNCOMPRESSED_REQUEST_BYTES_HOUR_VIEW, RpcViewConstants.RPC_SERVER_UNCOMPRESSED_RESPONSE_BYTES_HOUR_VIEW, RpcViewConstants.RPC_SERVER_STARTED_COUNT_HOUR_VIEW, RpcViewConstants.RPC_SERVER_FINISHED_COUNT_HOUR_VIEW);

    public static void registerAllGrpcViews() {
        registerAllGrpcViews(Stats.getViewManager());
    }

    @VisibleForTesting
    static void registerAllGrpcViews(ViewManager viewManager) {
        registerClientGrpcViews(viewManager);
        registerServerGrpcViews(viewManager);
    }

    public static void registerClientGrpcViews() {
        registerClientGrpcViews(Stats.getViewManager());
    }

    @VisibleForTesting
    static void registerClientGrpcViews(ViewManager viewManager) {
        UnmodifiableIterator<View> it = GRPC_CLIENT_VIEWS_SET.iterator();
        while (it.hasNext()) {
            viewManager.registerView(it.next());
        }
    }

    public static void registerServerGrpcViews() {
        registerServerGrpcViews(Stats.getViewManager());
    }

    @VisibleForTesting
    static void registerServerGrpcViews(ViewManager viewManager) {
        UnmodifiableIterator<View> it = GRPC_SERVER_VIEWS_SET.iterator();
        while (it.hasNext()) {
            viewManager.registerView(it.next());
        }
    }

    public static void registerAllGrpcBasicViews() {
        registerAllGrpcBasicViews(Stats.getViewManager());
    }

    @VisibleForTesting
    static void registerAllGrpcBasicViews(ViewManager viewManager) {
        registerClientGrpcBasicViews(viewManager);
        registerServerGrpcBasicViews(viewManager);
    }

    public static void registerClientGrpcBasicViews() {
        registerClientGrpcBasicViews(Stats.getViewManager());
    }

    @VisibleForTesting
    static void registerClientGrpcBasicViews(ViewManager viewManager) {
        UnmodifiableIterator<View> it = GRPC_CLIENT_BASIC_VIEWS_SET.iterator();
        while (it.hasNext()) {
            viewManager.registerView(it.next());
        }
    }

    public static void registerServerGrpcBasicViews() {
        registerServerGrpcBasicViews(Stats.getViewManager());
    }

    @VisibleForTesting
    static void registerServerGrpcBasicViews(ViewManager viewManager) {
        UnmodifiableIterator<View> it = GRPC_SERVER_BASIC_VIEWS_SET.iterator();
        while (it.hasNext()) {
            viewManager.registerView(it.next());
        }
    }

    @Deprecated
    public static void registerAllCumulativeViews() {
        registerAllCumulativeViews(Stats.getViewManager());
    }

    @VisibleForTesting
    static void registerAllCumulativeViews(ViewManager viewManager) {
        UnmodifiableIterator<View> it = RPC_CUMULATIVE_VIEWS_SET.iterator();
        while (it.hasNext()) {
            viewManager.registerView(it.next());
        }
    }

    @Deprecated
    public static void registerAllIntervalViews() {
        registerAllIntervalViews(Stats.getViewManager());
    }

    @VisibleForTesting
    static void registerAllIntervalViews(ViewManager viewManager) {
        UnmodifiableIterator<View> it = RPC_INTERVAL_VIEWS_SET.iterator();
        while (it.hasNext()) {
            viewManager.registerView(it.next());
        }
    }

    @Deprecated
    public static void registerAllViews() {
        registerAllViews(Stats.getViewManager());
    }

    @VisibleForTesting
    static void registerAllViews(ViewManager viewManager) {
        registerAllCumulativeViews(viewManager);
        registerAllIntervalViews(viewManager);
    }

    public static void registerRealTimeMetricsViews() {
        registerRealTimeMetricsViews(Stats.getViewManager());
    }

    @VisibleForTesting
    static void registerRealTimeMetricsViews(ViewManager viewManager) {
        UnmodifiableIterator<View> it = GRPC_REAL_TIME_METRICS_VIEWS_SET.iterator();
        while (it.hasNext()) {
            viewManager.registerView(it.next());
        }
    }

    private RpcViews() {
    }
}
