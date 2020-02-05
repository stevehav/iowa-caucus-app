package io.opencensus.trace;

import com.google.android.gms.measurement.api.AppMeasurementSdk;
import com.google.errorprone.annotations.MustBeClosed;
import io.opencensus.common.Scope;
import io.opencensus.internal.Utils;
import io.opencensus.trace.Span;
import java.util.List;
import javax.annotation.Nullable;

public abstract class SpanBuilder {
    public abstract SpanBuilder setParentLinks(List<Span> list);

    public abstract SpanBuilder setRecordEvents(boolean z);

    public abstract SpanBuilder setSampler(Sampler sampler);

    public SpanBuilder setSpanKind(@Nullable Span.Kind kind) {
        return this;
    }

    public abstract Span startSpan();

    @MustBeClosed
    public final Scope startScopedSpan() {
        return CurrentSpanUtils.withSpan(startSpan(), true);
    }

    public final void startSpanAndRun(Runnable runnable) {
        CurrentSpanUtils.withSpan(startSpan(), true, runnable).run();
    }

    /* JADX WARNING: type inference failed for: r3v0, types: [java.util.concurrent.Callable, java.util.concurrent.Callable<V>] */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final <V> V startSpanAndCall(java.util.concurrent.Callable<V> r3) throws java.lang.Exception {
        /*
            r2 = this;
            io.opencensus.trace.Span r0 = r2.startSpan()
            r1 = 1
            java.util.concurrent.Callable r3 = io.opencensus.trace.CurrentSpanUtils.withSpan((io.opencensus.trace.Span) r0, (boolean) r1, r3)
            java.lang.Object r3 = r3.call()
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: io.opencensus.trace.SpanBuilder.startSpanAndCall(java.util.concurrent.Callable):java.lang.Object");
    }

    static final class NoopSpanBuilder extends SpanBuilder {
        public SpanBuilder setParentLinks(List<Span> list) {
            return this;
        }

        public SpanBuilder setRecordEvents(boolean z) {
            return this;
        }

        public SpanBuilder setSampler(@Nullable Sampler sampler) {
            return this;
        }

        public SpanBuilder setSpanKind(@Nullable Span.Kind kind) {
            return this;
        }

        static NoopSpanBuilder createWithParent(String str, @Nullable Span span) {
            return new NoopSpanBuilder(str);
        }

        static NoopSpanBuilder createWithRemoteParent(String str, @Nullable SpanContext spanContext) {
            return new NoopSpanBuilder(str);
        }

        public Span startSpan() {
            return BlankSpan.INSTANCE;
        }

        private NoopSpanBuilder(String str) {
            Utils.checkNotNull(str, AppMeasurementSdk.ConditionalUserProperty.NAME);
        }
    }
}
