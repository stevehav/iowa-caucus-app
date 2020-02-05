package androidx.core.util;

import android.annotation.SuppressLint;

public interface Predicate<T> {
    @SuppressLint({"UnknownNullness"})
    boolean test(T t);
}
