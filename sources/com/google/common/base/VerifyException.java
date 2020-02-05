package com.google.common.base;

import com.google.common.annotations.GwtCompatible;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

@GwtCompatible
public class VerifyException extends RuntimeException {
    public VerifyException() {
    }

    public VerifyException(@NullableDecl String str) {
        super(str);
    }

    public VerifyException(@NullableDecl Throwable th) {
        super(th);
    }

    public VerifyException(@NullableDecl String str, @NullableDecl Throwable th) {
        super(str, th);
    }
}
