package io.opencensus.trace.config;

public abstract class TraceConfig {
    private static final NoopTraceConfig NOOP_TRACE_CONFIG = new NoopTraceConfig();

    public abstract TraceParams getActiveTraceParams();

    public abstract void updateActiveTraceParams(TraceParams traceParams);

    public static TraceConfig getNoopTraceConfig() {
        return NOOP_TRACE_CONFIG;
    }

    private static final class NoopTraceConfig extends TraceConfig {
        public void updateActiveTraceParams(TraceParams traceParams) {
        }

        private NoopTraceConfig() {
        }

        public TraceParams getActiveTraceParams() {
            return TraceParams.DEFAULT;
        }
    }
}
