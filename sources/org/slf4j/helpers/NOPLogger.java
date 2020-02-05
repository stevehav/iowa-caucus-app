package org.slf4j.helpers;

public class NOPLogger extends MarkerIgnoringBase {
    public static final NOPLogger NOP_LOGGER = new NOPLogger();
    private static final long serialVersionUID = -517220405410904473L;

    public final void debug(String str) {
    }

    public final void debug(String str, Object obj) {
    }

    public final void debug(String str, Object obj, Object obj2) {
    }

    public final void debug(String str, Throwable th) {
    }

    public final void debug(String str, Object... objArr) {
    }

    public final void error(String str) {
    }

    public final void error(String str, Object obj) {
    }

    public final void error(String str, Object obj, Object obj2) {
    }

    public final void error(String str, Throwable th) {
    }

    public final void error(String str, Object... objArr) {
    }

    public String getName() {
        return "NOP";
    }

    public final void info(String str) {
    }

    public final void info(String str, Object obj) {
    }

    public final void info(String str, Object obj, Object obj2) {
    }

    public final void info(String str, Throwable th) {
    }

    public final void info(String str, Object... objArr) {
    }

    public final boolean isDebugEnabled() {
        return false;
    }

    public final boolean isErrorEnabled() {
        return false;
    }

    public final boolean isInfoEnabled() {
        return false;
    }

    public final boolean isTraceEnabled() {
        return false;
    }

    public final boolean isWarnEnabled() {
        return false;
    }

    public final void trace(String str) {
    }

    public final void trace(String str, Object obj) {
    }

    public final void trace(String str, Object obj, Object obj2) {
    }

    public final void trace(String str, Throwable th) {
    }

    public final void trace(String str, Object... objArr) {
    }

    public final void warn(String str) {
    }

    public final void warn(String str, Object obj) {
    }

    public final void warn(String str, Object obj, Object obj2) {
    }

    public final void warn(String str, Throwable th) {
    }

    public final void warn(String str, Object... objArr) {
    }

    protected NOPLogger() {
    }
}
