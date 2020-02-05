package io.grpc.perfmark;

import com.google.errorprone.annotations.CompileTimeConstant;
import io.grpc.perfmark.PerfTag;

public final class PerfMark {
    private static final PerfTag NULL_PERF_TAG = PerfTag.TagFactory.create();

    public static void event(PerfTag perfTag, @CompileTimeConstant String str) {
    }

    public static void event(@CompileTimeConstant String str) {
    }

    public static void taskEnd(PerfTag perfTag, @CompileTimeConstant String str) {
    }

    public static void taskEnd(@CompileTimeConstant String str) {
    }

    public static void taskStart(PerfTag perfTag, @CompileTimeConstant String str) {
    }

    public static void taskStart(@CompileTimeConstant String str) {
    }

    private PerfMark() {
        throw new AssertionError("nope");
    }

    public static PerfMarkTask task(PerfTag perfTag, @CompileTimeConstant String str) {
        return NoopTask.INSTANCE;
    }

    public static PerfMarkTask task(@CompileTimeConstant String str) {
        return NoopTask.INSTANCE;
    }

    public static PerfTag createTag(long j, String str) {
        return NULL_PERF_TAG;
    }

    public static PerfTag createTag(String str) {
        return NULL_PERF_TAG;
    }

    public static PerfTag createTag(long j) {
        return NULL_PERF_TAG;
    }

    private static final class NoopTask extends PerfMarkTask {
        /* access modifiers changed from: private */
        public static final PerfMarkTask INSTANCE = new NoopTask();

        public void close() {
        }

        NoopTask() {
        }
    }
}
