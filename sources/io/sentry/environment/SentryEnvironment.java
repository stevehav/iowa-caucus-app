package io.sentry.environment;

import java.util.concurrent.atomic.AtomicInteger;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public final class SentryEnvironment {
    public static final String SDK_NAME = "sentry-java";
    public static final String SDK_VERSION = "1.7.23-1d154";
    protected static final ThreadLocal<AtomicInteger> SENTRY_THREAD = new ThreadLocal<AtomicInteger>() {
        /* access modifiers changed from: protected */
        public AtomicInteger initialValue() {
            return new AtomicInteger();
        }
    };
    private static final Logger logger = LoggerFactory.getLogger((Class<?>) SentryEnvironment.class);

    public static String getSentryName() {
        return "sentry-java/1.7.23-1d154";
    }

    private SentryEnvironment() {
    }

    public static void startManagingThread() {
        try {
            if (isManagingThread()) {
                logger.warn("Thread already managed by Sentry");
            }
        } finally {
            SENTRY_THREAD.get().incrementAndGet();
        }
    }

    public static void stopManagingThread() {
        try {
            if (!isManagingThread()) {
                startManagingThread();
                logger.warn("Thread not yet managed by Sentry");
            }
        } finally {
            if (SENTRY_THREAD.get().decrementAndGet() == 0) {
                SENTRY_THREAD.remove();
            }
        }
    }

    public static boolean isManagingThread() {
        return SENTRY_THREAD.get().get() > 0;
    }
}
