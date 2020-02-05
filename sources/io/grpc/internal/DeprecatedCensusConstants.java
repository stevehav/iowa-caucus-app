package io.grpc.internal;

import com.google.common.annotations.VisibleForTesting;
import io.opencensus.contrib.grpc.metrics.RpcMeasureConstants;
import io.opencensus.stats.Measure;
import io.opencensus.tags.TagKey;

@VisibleForTesting
public final class DeprecatedCensusConstants {
    public static final Measure.MeasureLong RPC_CLIENT_ERROR_COUNT = RpcMeasureConstants.RPC_CLIENT_ERROR_COUNT;
    public static final Measure.MeasureLong RPC_CLIENT_FINISHED_COUNT = RpcMeasureConstants.RPC_CLIENT_FINISHED_COUNT;
    public static final Measure.MeasureDouble RPC_CLIENT_REQUEST_BYTES = RpcMeasureConstants.RPC_CLIENT_REQUEST_BYTES;
    public static final Measure.MeasureLong RPC_CLIENT_REQUEST_COUNT = RpcMeasureConstants.RPC_CLIENT_REQUEST_COUNT;
    public static final Measure.MeasureDouble RPC_CLIENT_RESPONSE_BYTES = RpcMeasureConstants.RPC_CLIENT_RESPONSE_BYTES;
    public static final Measure.MeasureLong RPC_CLIENT_RESPONSE_COUNT = RpcMeasureConstants.RPC_CLIENT_RESPONSE_COUNT;
    public static final Measure.MeasureDouble RPC_CLIENT_ROUNDTRIP_LATENCY = RpcMeasureConstants.RPC_CLIENT_ROUNDTRIP_LATENCY;
    public static final Measure.MeasureDouble RPC_CLIENT_SERVER_ELAPSED_TIME = RpcMeasureConstants.RPC_CLIENT_SERVER_ELAPSED_TIME;
    public static final Measure.MeasureLong RPC_CLIENT_STARTED_COUNT = RpcMeasureConstants.RPC_CLIENT_STARTED_COUNT;
    public static final Measure.MeasureDouble RPC_CLIENT_UNCOMPRESSED_REQUEST_BYTES = RpcMeasureConstants.RPC_CLIENT_UNCOMPRESSED_REQUEST_BYTES;
    public static final Measure.MeasureDouble RPC_CLIENT_UNCOMPRESSED_RESPONSE_BYTES = RpcMeasureConstants.RPC_CLIENT_UNCOMPRESSED_RESPONSE_BYTES;
    public static final TagKey RPC_METHOD = RpcMeasureConstants.RPC_METHOD;
    public static final Measure.MeasureLong RPC_SERVER_ERROR_COUNT = RpcMeasureConstants.RPC_SERVER_ERROR_COUNT;
    public static final Measure.MeasureLong RPC_SERVER_FINISHED_COUNT = RpcMeasureConstants.RPC_SERVER_FINISHED_COUNT;
    public static final Measure.MeasureDouble RPC_SERVER_REQUEST_BYTES = RpcMeasureConstants.RPC_SERVER_REQUEST_BYTES;
    public static final Measure.MeasureLong RPC_SERVER_REQUEST_COUNT = RpcMeasureConstants.RPC_SERVER_REQUEST_COUNT;
    public static final Measure.MeasureDouble RPC_SERVER_RESPONSE_BYTES = RpcMeasureConstants.RPC_SERVER_RESPONSE_BYTES;
    public static final Measure.MeasureLong RPC_SERVER_RESPONSE_COUNT = RpcMeasureConstants.RPC_SERVER_RESPONSE_COUNT;
    public static final Measure.MeasureDouble RPC_SERVER_SERVER_ELAPSED_TIME = RpcMeasureConstants.RPC_SERVER_SERVER_ELAPSED_TIME;
    public static final Measure.MeasureDouble RPC_SERVER_SERVER_LATENCY = RpcMeasureConstants.RPC_SERVER_SERVER_LATENCY;
    public static final Measure.MeasureLong RPC_SERVER_STARTED_COUNT = RpcMeasureConstants.RPC_SERVER_STARTED_COUNT;
    public static final Measure.MeasureDouble RPC_SERVER_UNCOMPRESSED_REQUEST_BYTES = RpcMeasureConstants.RPC_SERVER_UNCOMPRESSED_REQUEST_BYTES;
    public static final Measure.MeasureDouble RPC_SERVER_UNCOMPRESSED_RESPONSE_BYTES = RpcMeasureConstants.RPC_SERVER_UNCOMPRESSED_RESPONSE_BYTES;
    public static final TagKey RPC_STATUS = RpcMeasureConstants.RPC_STATUS;

    private DeprecatedCensusConstants() {
    }
}
