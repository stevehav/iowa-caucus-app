package io.opencensus.trace;

import io.grpc.Context;
import io.opencensus.common.Scope;
import io.opencensus.trace.unsafe.ContextUtils;
import java.util.concurrent.Callable;
import javax.annotation.Nullable;

final class CurrentSpanUtils {
    private CurrentSpanUtils() {
    }

    @Nullable
    static Span getCurrentSpan() {
        return ContextUtils.getValue(Context.current());
    }

    static Scope withSpan(Span span, boolean z) {
        return new ScopeInSpan(span, z);
    }

    static Runnable withSpan(Span span, boolean z, Runnable runnable) {
        return new RunnableInSpan(span, runnable, z);
    }

    static <C> Callable<C> withSpan(Span span, boolean z, Callable<C> callable) {
        return new CallableInSpan(span, callable, z);
    }

    private static final class ScopeInSpan implements Scope {
        private final boolean endSpan;
        private final Context origContext;
        private final Span span;

        private ScopeInSpan(Span span2, boolean z) {
            this.span = span2;
            this.endSpan = z;
            this.origContext = ContextUtils.withValue(Context.current(), span2).attach();
        }

        public void close() {
            Context.current().detach(this.origContext);
            if (this.endSpan) {
                this.span.end();
            }
        }
    }

    private static final class RunnableInSpan implements Runnable {
        private final boolean endSpan;
        private final Runnable runnable;
        private final Span span;

        private RunnableInSpan(Span span2, Runnable runnable2, boolean z) {
            this.span = span2;
            this.runnable = runnable2;
            this.endSpan = z;
        }

        public void run() {
            Context attach = ContextUtils.withValue(Context.current(), this.span).attach();
            try {
                this.runnable.run();
                Context.current().detach(attach);
                if (this.endSpan) {
                    this.span.end();
                }
            } catch (Throwable th) {
                Context.current().detach(attach);
                if (this.endSpan) {
                    this.span.end();
                }
                throw th;
            }
        }
    }

    private static final class CallableInSpan<V> implements Callable<V> {
        private final Callable<V> callable;
        private final boolean endSpan;
        private final Span span;

        private CallableInSpan(Span span2, Callable<V> callable2, boolean z) {
            this.span = span2;
            this.callable = callable2;
            this.endSpan = z;
        }

        public V call() throws Exception {
            Context attach = ContextUtils.withValue(Context.current(), this.span).attach();
            try {
                V call = this.callable.call();
                Context.current().detach(attach);
                if (this.endSpan) {
                    this.span.end();
                }
                return call;
            } catch (Exception e) {
                CurrentSpanUtils.setErrorStatus(this.span, e);
                throw e;
            } catch (Throwable th) {
                Context.current().detach(attach);
                if (this.endSpan) {
                    this.span.end();
                }
                throw th;
            }
        }
    }

    /* access modifiers changed from: private */
    public static void setErrorStatus(Span span, Throwable th) {
        span.setStatus(Status.UNKNOWN.withDescription(th.getMessage() == null ? th.getClass().getSimpleName() : th.getMessage()));
    }
}
