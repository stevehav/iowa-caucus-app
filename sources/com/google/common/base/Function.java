package com.google.common.base;

import com.google.common.annotations.GwtCompatible;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

@GwtCompatible
public interface Function<F, T> {
    @NullableDecl
    @CanIgnoreReturnValue
    T apply(@NullableDecl F f);

    boolean equals(@NullableDecl Object obj);
}
