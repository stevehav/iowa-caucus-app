package com.drew.lang;

import com.drew.lang.annotations.NotNull;
import com.drew.lang.annotations.Nullable;
import java.io.PrintStream;
import java.io.PrintWriter;

public class CompoundException extends Exception {
    private static final long serialVersionUID = -9207883813472069925L;
    @Nullable
    private final Throwable _innerException;

    public CompoundException(@Nullable String str) {
        this(str, (Throwable) null);
    }

    public CompoundException(@Nullable Throwable th) {
        this((String) null, th);
    }

    public CompoundException(@Nullable String str, @Nullable Throwable th) {
        super(str);
        this._innerException = th;
    }

    @Nullable
    public Throwable getInnerException() {
        return this._innerException;
    }

    @NotNull
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString());
        if (this._innerException != null) {
            sb.append(ReactEditTextInputConnectionWrapper.NEWLINE_RAW_VALUE);
            sb.append("--- inner exception ---");
            sb.append(ReactEditTextInputConnectionWrapper.NEWLINE_RAW_VALUE);
            sb.append(this._innerException.toString());
        }
        return sb.toString();
    }

    public void printStackTrace(@NotNull PrintStream printStream) {
        super.printStackTrace(printStream);
        if (this._innerException != null) {
            printStream.println("--- inner exception ---");
            this._innerException.printStackTrace(printStream);
        }
    }

    public void printStackTrace(@NotNull PrintWriter printWriter) {
        super.printStackTrace(printWriter);
        if (this._innerException != null) {
            printWriter.println("--- inner exception ---");
            this._innerException.printStackTrace(printWriter);
        }
    }

    public void printStackTrace() {
        super.printStackTrace();
        if (this._innerException != null) {
            System.err.println("--- inner exception ---");
            this._innerException.printStackTrace();
        }
    }
}
