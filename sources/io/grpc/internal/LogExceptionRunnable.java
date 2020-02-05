package io.grpc.internal;

import com.google.common.base.Preconditions;
import com.google.common.base.Throwables;
import java.util.logging.Level;
import java.util.logging.Logger;

public final class LogExceptionRunnable implements Runnable {
    private static final Logger log = Logger.getLogger(LogExceptionRunnable.class.getName());
    private final Runnable task;

    public LogExceptionRunnable(Runnable runnable) {
        this.task = (Runnable) Preconditions.checkNotNull(runnable, "task");
    }

    public void run() {
        try {
            this.task.run();
        } catch (Throwable th) {
            Logger logger = log;
            Level level = Level.SEVERE;
            logger.log(level, "Exception while executing runnable " + this.task, th);
            Throwables.throwIfUnchecked(th);
            throw new AssertionError(th);
        }
    }

    public String toString() {
        return "LogExceptionRunnable(" + this.task + ")";
    }
}
