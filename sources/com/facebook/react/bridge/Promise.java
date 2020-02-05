package com.facebook.react.bridge;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public interface Promise {
    @Deprecated
    void reject(String str);

    void reject(String str, @NonNull WritableMap writableMap);

    void reject(String str, String str2);

    void reject(String str, String str2, @NonNull WritableMap writableMap);

    void reject(String str, String str2, Throwable th);

    void reject(String str, String str2, Throwable th, WritableMap writableMap);

    void reject(String str, Throwable th);

    void reject(String str, Throwable th, WritableMap writableMap);

    void reject(Throwable th);

    void reject(Throwable th, WritableMap writableMap);

    void resolve(@Nullable Object obj);
}
