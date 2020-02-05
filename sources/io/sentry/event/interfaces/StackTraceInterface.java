package io.sentry.event.interfaces;

import io.sentry.jvmti.Frame;
import java.util.Arrays;

public class StackTraceInterface implements SentryInterface {
    public static final String STACKTRACE_INTERFACE = "sentry.interfaces.Stacktrace";
    private final int framesCommonWithEnclosing;
    private final SentryStackTraceElement[] stackTrace;

    public String getInterfaceName() {
        return STACKTRACE_INTERFACE;
    }

    public StackTraceInterface(StackTraceElement[] stackTraceElementArr) {
        this(stackTraceElementArr, new StackTraceElement[0], (Frame[]) null);
    }

    public StackTraceInterface(StackTraceElement[] stackTraceElementArr, StackTraceElement[] stackTraceElementArr2) {
        this(stackTraceElementArr, stackTraceElementArr2, (Frame[]) null);
    }

    public StackTraceInterface(StackTraceElement[] stackTraceElementArr, StackTraceElement[] stackTraceElementArr2, Frame[] frameArr) {
        this.stackTrace = SentryStackTraceElement.fromStackTraceElements(stackTraceElementArr, frameArr);
        int length = stackTraceElementArr.length - 1;
        int length2 = stackTraceElementArr2.length - 1;
        while (length >= 0 && length2 >= 0 && stackTraceElementArr[length].equals(stackTraceElementArr2[length2])) {
            length--;
            length2--;
        }
        this.framesCommonWithEnclosing = (stackTraceElementArr.length - 1) - length;
    }

    public StackTraceInterface(SentryStackTraceElement[] sentryStackTraceElementArr) {
        this.stackTrace = (SentryStackTraceElement[]) Arrays.copyOf(sentryStackTraceElementArr, sentryStackTraceElementArr.length);
        this.framesCommonWithEnclosing = 0;
    }

    public SentryStackTraceElement[] getStackTrace() {
        SentryStackTraceElement[] sentryStackTraceElementArr = this.stackTrace;
        return (SentryStackTraceElement[]) Arrays.copyOf(sentryStackTraceElementArr, sentryStackTraceElementArr.length);
    }

    public int getFramesCommonWithEnclosing() {
        return this.framesCommonWithEnclosing;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        return Arrays.equals(this.stackTrace, ((StackTraceInterface) obj).stackTrace);
    }

    public int hashCode() {
        return Arrays.hashCode(this.stackTrace);
    }

    public String toString() {
        return "StackTraceInterface{stackTrace=" + Arrays.toString(this.stackTrace) + '}';
    }
}
