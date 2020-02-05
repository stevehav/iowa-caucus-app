package io.sentry.context;

public interface ContextManager {
    void clear();

    Context getContext();
}
