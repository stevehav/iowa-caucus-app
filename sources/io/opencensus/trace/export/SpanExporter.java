package io.opencensus.trace.export;

import java.util.Collection;
import javax.annotation.concurrent.ThreadSafe;

@ThreadSafe
public abstract class SpanExporter {
    private static final SpanExporter NOOP_SPAN_EXPORTER = new NoopSpanExporter();

    public static abstract class Handler {
        public abstract void export(Collection<SpanData> collection);
    }

    public abstract void registerHandler(String str, Handler handler);

    public abstract void unregisterHandler(String str);

    public static SpanExporter getNoopSpanExporter() {
        return NOOP_SPAN_EXPORTER;
    }

    private static final class NoopSpanExporter extends SpanExporter {
        public void registerHandler(String str, Handler handler) {
        }

        public void unregisterHandler(String str) {
        }

        private NoopSpanExporter() {
        }
    }
}
