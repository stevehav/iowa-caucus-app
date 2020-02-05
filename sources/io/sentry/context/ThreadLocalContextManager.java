package io.sentry.context;

public class ThreadLocalContextManager implements ContextManager {
    private final ThreadLocal<Context> context = new ThreadLocal<Context>() {
        /* access modifiers changed from: protected */
        public Context initialValue() {
            return new Context();
        }
    };

    public Context getContext() {
        return this.context.get();
    }

    public void clear() {
        this.context.remove();
    }
}
