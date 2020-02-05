package io.sentry.event.interfaces;

import io.sentry.jvmti.Frame;
import java.io.Serializable;
import java.util.Map;
import java.util.Objects;

public class SentryStackTraceElement implements Serializable {
    private final String absPath;
    private final Integer colno;
    private final String fileName;
    private final String function;
    private final int lineno;
    private final Map<String, Object> locals;
    private final String module;
    private final String platform;

    public SentryStackTraceElement(String str, String str2, String str3, int i, Integer num, String str4, String str5) {
        this(str, str2, str3, i, num, str4, str5, (Map<String, Object>) null);
    }

    public SentryStackTraceElement(String str, String str2, String str3, int i, Integer num, String str4, String str5, Map<String, Object> map) {
        this.module = str;
        this.function = str2;
        this.fileName = str3;
        this.lineno = i;
        this.colno = num;
        this.absPath = str4;
        this.platform = str5;
        this.locals = map;
    }

    public String getModule() {
        return this.module;
    }

    public String getFunction() {
        return this.function;
    }

    public String getFileName() {
        return this.fileName;
    }

    public int getLineno() {
        return this.lineno;
    }

    public Integer getColno() {
        return this.colno;
    }

    public String getAbsPath() {
        return this.absPath;
    }

    public String getPlatform() {
        return this.platform;
    }

    public Map<String, Object> getLocals() {
        return this.locals;
    }

    public static SentryStackTraceElement[] fromStackTraceElements(StackTraceElement[] stackTraceElementArr) {
        return fromStackTraceElements(stackTraceElementArr, (Frame[]) null);
    }

    public static SentryStackTraceElement[] fromStackTraceElements(StackTraceElement[] stackTraceElementArr, Frame[] frameArr) {
        SentryStackTraceElement[] sentryStackTraceElementArr = new SentryStackTraceElement[stackTraceElementArr.length];
        int i = 0;
        int i2 = 0;
        while (i < stackTraceElementArr.length) {
            StackTraceElement stackTraceElement = stackTraceElementArr[i];
            Map<String, Object> map = null;
            if (frameArr != null) {
                while (i2 < frameArr.length && !frameArr[i2].getMethod().getName().equals(stackTraceElement.getMethodName())) {
                    i2++;
                }
                if (i2 < frameArr.length) {
                    map = frameArr[i2].getLocals();
                }
            }
            sentryStackTraceElementArr[i] = fromStackTraceElement(stackTraceElement, map);
            i++;
            i2++;
        }
        return sentryStackTraceElementArr;
    }

    public static SentryStackTraceElement fromStackTraceElement(StackTraceElement stackTraceElement) {
        return fromStackTraceElement(stackTraceElement, (Map<String, Object>) null);
    }

    private static SentryStackTraceElement fromStackTraceElement(StackTraceElement stackTraceElement, Map<String, Object> map) {
        return new SentryStackTraceElement(stackTraceElement.getClassName(), stackTraceElement.getMethodName(), stackTraceElement.getFileName(), stackTraceElement.getLineNumber(), (Integer) null, (String) null, (String) null, map);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        SentryStackTraceElement sentryStackTraceElement = (SentryStackTraceElement) obj;
        if (this.lineno != sentryStackTraceElement.lineno || !Objects.equals(this.module, sentryStackTraceElement.module) || !Objects.equals(this.function, sentryStackTraceElement.function) || !Objects.equals(this.fileName, sentryStackTraceElement.fileName) || !Objects.equals(this.colno, sentryStackTraceElement.colno) || !Objects.equals(this.absPath, sentryStackTraceElement.absPath) || !Objects.equals(this.platform, sentryStackTraceElement.platform) || !Objects.equals(this.locals, sentryStackTraceElement.locals)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        return Objects.hash(new Object[]{this.module, this.function, this.fileName, Integer.valueOf(this.lineno), this.colno, this.absPath, this.platform, this.locals});
    }

    public String toString() {
        return "SentryStackTraceElement{module='" + this.module + '\'' + ", function='" + this.function + '\'' + ", fileName='" + this.fileName + '\'' + ", lineno=" + this.lineno + ", colno=" + this.colno + ", absPath='" + this.absPath + '\'' + ", platform='" + this.platform + '\'' + ", locals='" + this.locals + '\'' + '}';
    }
}
