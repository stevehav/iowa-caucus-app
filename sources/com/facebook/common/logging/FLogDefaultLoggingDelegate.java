package com.facebook.common.logging;

import android.util.Log;
import androidx.core.os.EnvironmentCompat;
import java.io.PrintWriter;
import java.io.StringWriter;

public class FLogDefaultLoggingDelegate implements LoggingDelegate {
    public static final FLogDefaultLoggingDelegate sInstance = new FLogDefaultLoggingDelegate();
    private String mApplicationTag = EnvironmentCompat.MEDIA_UNKNOWN;
    private int mMinimumLoggingLevel = 5;

    public static FLogDefaultLoggingDelegate getInstance() {
        return sInstance;
    }

    private FLogDefaultLoggingDelegate() {
    }

    public void setApplicationTag(String str) {
        this.mApplicationTag = str;
    }

    public void setMinimumLoggingLevel(int i) {
        this.mMinimumLoggingLevel = i;
    }

    public int getMinimumLoggingLevel() {
        return this.mMinimumLoggingLevel;
    }

    public boolean isLoggable(int i) {
        return this.mMinimumLoggingLevel <= i;
    }

    public void v(String str, String str2) {
        println(2, str, str2);
    }

    public void v(String str, String str2, Throwable th) {
        println(2, str, str2, th);
    }

    public void d(String str, String str2) {
        println(3, str, str2);
    }

    public void d(String str, String str2, Throwable th) {
        println(3, str, str2, th);
    }

    public void i(String str, String str2) {
        println(4, str, str2);
    }

    public void i(String str, String str2, Throwable th) {
        println(4, str, str2, th);
    }

    public void w(String str, String str2) {
        println(5, str, str2);
    }

    public void w(String str, String str2, Throwable th) {
        println(5, str, str2, th);
    }

    public void e(String str, String str2) {
        println(6, str, str2);
    }

    public void e(String str, String str2, Throwable th) {
        println(6, str, str2, th);
    }

    public void wtf(String str, String str2) {
        println(6, str, str2);
    }

    public void wtf(String str, String str2, Throwable th) {
        println(6, str, str2, th);
    }

    public void log(int i, String str, String str2) {
        println(i, str, str2);
    }

    private void println(int i, String str, String str2) {
        Log.println(i, prefixTag(str), str2);
    }

    private void println(int i, String str, String str2, Throwable th) {
        Log.println(i, prefixTag(str), getMsg(str2, th));
    }

    private String prefixTag(String str) {
        if (this.mApplicationTag == null) {
            return str;
        }
        return this.mApplicationTag + ":" + str;
    }

    private static String getMsg(String str, Throwable th) {
        return str + 10 + getStackTraceString(th);
    }

    private static String getStackTraceString(Throwable th) {
        if (th == null) {
            return "";
        }
        StringWriter stringWriter = new StringWriter();
        th.printStackTrace(new PrintWriter(stringWriter));
        return stringWriter.toString();
    }
}
