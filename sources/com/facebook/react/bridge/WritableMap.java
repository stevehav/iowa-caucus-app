package com.facebook.react.bridge;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public interface WritableMap extends ReadableMap {
    WritableMap copy();

    void merge(@NonNull ReadableMap readableMap);

    void putArray(@NonNull String str, @Nullable ReadableArray readableArray);

    void putBoolean(@NonNull String str, boolean z);

    void putDouble(@NonNull String str, double d);

    void putInt(@NonNull String str, int i);

    void putMap(@NonNull String str, @Nullable ReadableMap readableMap);

    void putNull(@NonNull String str);

    void putString(@NonNull String str, @Nullable String str2);
}
