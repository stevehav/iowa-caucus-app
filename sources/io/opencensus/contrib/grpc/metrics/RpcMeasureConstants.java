package io.opencensus.contrib.grpc.metrics;

import com.google.firebase.analytics.FirebaseAnalytics;
import io.opencensus.stats.Measure;
import io.opencensus.tags.TagKey;

public final class RpcMeasureConstants {
    private static final String BYTE = "By";
    private static final String COUNT = "1";
    public static final TagKey GRPC_CLIENT_METHOD = TagKey.create("grpc_client_method");
    public static final Measure.MeasureDouble GRPC_CLIENT_RECEIVED_BYTES_PER_METHOD = Measure.MeasureDouble.create("grpc.io/client/received_bytes_per_method", "Total bytes received per method, recorded real-time as bytes are received.", BYTE);
    public static final Measure.MeasureDouble GRPC_CLIENT_RECEIVED_BYTES_PER_RPC = Measure.MeasureDouble.create("grpc.io/client/received_bytes_per_rpc", "Total bytes received across all response messages per RPC", BYTE);
    public static final Measure.MeasureLong GRPC_CLIENT_RECEIVED_MESSAGES_PER_METHOD = Measure.MeasureLong.create("grpc.io/client/received_messages_per_method", "Total messages received per method.", COUNT);
    public static final Measure.MeasureLong GRPC_CLIENT_RECEIVED_MESSAGES_PER_RPC = Measure.MeasureLong.create("grpc.io/client/received_messages_per_rpc", "Number of response messages received per RPC", COUNT);
    public static final Measure.MeasureDouble GRPC_CLIENT_ROUNDTRIP_LATENCY = Measure.MeasureDouble.create("grpc.io/client/roundtrip_latency", "Time between first byte of request sent to last byte of response received, or terminal error.", MILLISECOND);
    public static final Measure.MeasureDouble GRPC_CLIENT_SENT_BYTES_PER_METHOD = Measure.MeasureDouble.create("grpc.io/client/sent_bytes_per_method", "Total bytes sent per method, recorded real-time as bytes are sent.", BYTE);
    public static final Measure.MeasureDouble GRPC_CLIENT_SENT_BYTES_PER_RPC = Measure.MeasureDouble.create("grpc.io/client/sent_bytes_per_rpc", "Total bytes sent across all request messages per RPC", BYTE);
    public static final Measure.MeasureLong GRPC_CLIENT_SENT_MESSAGES_PER_METHOD = Measure.MeasureLong.create("grpc.io/client/sent_messages_per_method", "Total messages sent per method.", COUNT);
    public static final Measure.MeasureLong GRPC_CLIENT_SENT_MESSAGES_PER_RPC = Measure.MeasureLong.create("grpc.io/client/sent_messages_per_rpc", "Number of messages sent in the RPC", COUNT);
    public static final Measure.MeasureDouble GRPC_CLIENT_SERVER_LATENCY = Measure.MeasureDouble.create("grpc.io/client/server_latency", "Server latency in msecs", MILLISECOND);
    public static final Measure.MeasureLong GRPC_CLIENT_STARTED_RPCS = Measure.MeasureLong.create("grpc.io/client/started_rpcs", "Number of started client RPCs.", COUNT);
    public static final TagKey GRPC_CLIENT_STATUS = TagKey.create("grpc_client_status");
    public static final TagKey GRPC_SERVER_METHOD = TagKey.create("grpc_server_method");
    public static final Measure.MeasureDouble GRPC_SERVER_RECEIVED_BYTES_PER_METHOD = Measure.MeasureDouble.create("grpc.io/server/received_bytes_per_method", "Total bytes received per method, recorded real-time as bytes are received.", BYTE);
    public static final Measure.MeasureDouble GRPC_SERVER_RECEIVED_BYTES_PER_RPC = Measure.MeasureDouble.create("grpc.io/server/received_bytes_per_rpc", "Total bytes received across all messages per RPC", BYTE);
    public static final Measure.MeasureLong GRPC_SERVER_RECEIVED_MESSAGES_PER_METHOD = Measure.MeasureLong.create("grpc.io/server/received_messages_per_method", "Total messages received per method.", COUNT);
    public static final Measure.MeasureLong GRPC_SERVER_RECEIVED_MESSAGES_PER_RPC = Measure.MeasureLong.create("grpc.io/server/received_messages_per_rpc", "Number of messages received in each RPC", COUNT);
    public static final Measure.MeasureDouble GRPC_SERVER_SENT_BYTES_PER_METHOD = Measure.MeasureDouble.create("grpc.io/server/sent_bytes_per_method", "Total bytes sent per method, recorded real-time as bytes are sent.", BYTE);
    public static final Measure.MeasureDouble GRPC_SERVER_SENT_BYTES_PER_RPC = Measure.MeasureDouble.create("grpc.io/server/sent_bytes_per_rpc", "Total bytes sent across all response messages per RPC", BYTE);
    public static final Measure.MeasureLong GRPC_SERVER_SENT_MESSAGES_PER_METHOD = Measure.MeasureLong.create("grpc.io/server/sent_messages_per_method", "Total messages sent per method.", COUNT);
    public static final Measure.MeasureLong GRPC_SERVER_SENT_MESSAGES_PER_RPC = Measure.MeasureLong.create("grpc.io/server/sent_messages_per_rpc", "Number of messages sent in each RPC", COUNT);
    public static final Measure.MeasureDouble GRPC_SERVER_SERVER_LATENCY = Measure.MeasureDouble.create("grpc.io/server/server_latency", "Time between first byte of request received to last byte of response sent, or terminal error.", MILLISECOND);
    public static final Measure.MeasureLong GRPC_SERVER_STARTED_RPCS = Measure.MeasureLong.create("grpc.io/server/started_rpcs", "Number of started server RPCs.", COUNT);
    public static final TagKey GRPC_SERVER_STATUS = TagKey.create("grpc_server_status");
    private static final String MILLISECOND = "ms";
    @Deprecated
    public static final Measure.MeasureLong RPC_CLIENT_ERROR_COUNT = Measure.MeasureLong.create("grpc.io/client/error_count", "RPC Errors", COUNT);
    @Deprecated
    public static final Measure.MeasureLong RPC_CLIENT_FINISHED_COUNT = Measure.MeasureLong.create("grpc.io/client/finished_count", "Number of client RPCs (streams) finished", COUNT);
    @Deprecated
    public static final Measure.MeasureDouble RPC_CLIENT_REQUEST_BYTES = GRPC_CLIENT_SENT_BYTES_PER_RPC;
    @Deprecated
    public static final Measure.MeasureLong RPC_CLIENT_REQUEST_COUNT = GRPC_CLIENT_SENT_MESSAGES_PER_RPC;
    @Deprecated
    public static final Measure.MeasureDouble RPC_CLIENT_RESPONSE_BYTES = GRPC_CLIENT_RECEIVED_BYTES_PER_RPC;
    @Deprecated
    public static final Measure.MeasureLong RPC_CLIENT_RESPONSE_COUNT = GRPC_CLIENT_RECEIVED_MESSAGES_PER_RPC;
    @Deprecated
    public static final Measure.MeasureDouble RPC_CLIENT_ROUNDTRIP_LATENCY = GRPC_CLIENT_ROUNDTRIP_LATENCY;
    @Deprecated
    public static final Measure.MeasureDouble RPC_CLIENT_SERVER_ELAPSED_TIME = GRPC_CLIENT_SERVER_LATENCY;
    @Deprecated
    public static final Measure.MeasureLong RPC_CLIENT_STARTED_COUNT = GRPC_CLIENT_STARTED_RPCS;
    @Deprecated
    public static final Measure.MeasureDouble RPC_CLIENT_UNCOMPRESSED_REQUEST_BYTES = Measure.MeasureDouble.create("grpc.io/client/uncompressed_request_bytes", "Uncompressed Request bytes", BYTE);
    @Deprecated
    public static final Measure.MeasureDouble RPC_CLIENT_UNCOMPRESSED_RESPONSE_BYTES = Measure.MeasureDouble.create("grpc.io/client/uncompressed_response_bytes", "Uncompressed Response bytes", BYTE);
    @Deprecated
    public static final TagKey RPC_METHOD = TagKey.create(FirebaseAnalytics.Param.METHOD);
    @Deprecated
    public static final Measure.MeasureLong RPC_SERVER_ERROR_COUNT = Measure.MeasureLong.create("grpc.io/server/error_count", "RPC Errors", COUNT);
    @Deprecated
    public static final Measure.MeasureLong RPC_SERVER_FINISHED_COUNT = Measure.MeasureLong.create("grpc.io/server/finished_count", "Number of server RPCs (streams) finished", COUNT);
    @Deprecated
    public static final Measure.MeasureDouble RPC_SERVER_REQUEST_BYTES = GRPC_SERVER_RECEIVED_BYTES_PER_RPC;
    @Deprecated
    public static final Measure.MeasureLong RPC_SERVER_REQUEST_COUNT = GRPC_SERVER_RECEIVED_MESSAGES_PER_RPC;
    @Deprecated
    public static final Measure.MeasureDouble RPC_SERVER_RESPONSE_BYTES = GRPC_SERVER_SENT_BYTES_PER_RPC;
    @Deprecated
    public static final Measure.MeasureLong RPC_SERVER_RESPONSE_COUNT = GRPC_SERVER_SENT_MESSAGES_PER_RPC;
    @Deprecated
    public static final Measure.MeasureDouble RPC_SERVER_SERVER_ELAPSED_TIME = Measure.MeasureDouble.create("grpc.io/server/server_elapsed_time", "Server elapsed time in msecs", MILLISECOND);
    @Deprecated
    public static final Measure.MeasureDouble RPC_SERVER_SERVER_LATENCY = GRPC_SERVER_SERVER_LATENCY;
    @Deprecated
    public static final Measure.MeasureLong RPC_SERVER_STARTED_COUNT = GRPC_SERVER_STARTED_RPCS;
    @Deprecated
    public static final Measure.MeasureDouble RPC_SERVER_UNCOMPRESSED_REQUEST_BYTES = Measure.MeasureDouble.create("grpc.io/server/uncompressed_request_bytes", "Uncompressed Request bytes", BYTE);
    @Deprecated
    public static final Measure.MeasureDouble RPC_SERVER_UNCOMPRESSED_RESPONSE_BYTES = Measure.MeasureDouble.create("grpc.io/server/uncompressed_response_bytes", "Uncompressed Response bytes", BYTE);
    @Deprecated
    public static final TagKey RPC_STATUS = TagKey.create("canonical_status");

    private RpcMeasureConstants() {
    }
}
