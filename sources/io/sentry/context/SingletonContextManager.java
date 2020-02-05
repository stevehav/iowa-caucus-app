package io.sentry.context;

public class SingletonContextManager implements ContextManager {
    private final Context context = new Context();

    public Context getContext() {
        return this.context;
    }

    public void clear() {
        this.context.clear();
    }
}
