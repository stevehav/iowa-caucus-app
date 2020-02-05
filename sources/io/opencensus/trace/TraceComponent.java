package io.opencensus.trace;

import io.opencensus.common.Clock;
import io.opencensus.internal.ZeroTimeClock;
import io.opencensus.trace.config.TraceConfig;
import io.opencensus.trace.export.ExportComponent;
import io.opencensus.trace.propagation.PropagationComponent;

public abstract class TraceComponent {
    public abstract Clock getClock();

    public abstract ExportComponent getExportComponent();

    public abstract PropagationComponent getPropagationComponent();

    public abstract TraceConfig getTraceConfig();

    public abstract Tracer getTracer();

    static TraceComponent newNoopTraceComponent() {
        return new NoopTraceComponent();
    }

    private static final class NoopTraceComponent extends TraceComponent {
        private final ExportComponent noopExportComponent;

        public Tracer getTracer() {
            return Tracer.getNoopTracer();
        }

        public PropagationComponent getPropagationComponent() {
            return PropagationComponent.getNoopPropagationComponent();
        }

        public Clock getClock() {
            return ZeroTimeClock.getInstance();
        }

        public ExportComponent getExportComponent() {
            return this.noopExportComponent;
        }

        public TraceConfig getTraceConfig() {
            return TraceConfig.getNoopTraceConfig();
        }

        private NoopTraceComponent() {
            this.noopExportComponent = ExportComponent.newNoopExportComponent();
        }
    }
}
