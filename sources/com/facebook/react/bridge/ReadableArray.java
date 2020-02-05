package com.facebook.react.bridge;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.ArrayList;

public interface ReadableArray {
    @Nullable
    ReadableArray getArray(int i);

    boolean getBoolean(int i);

    double getDouble(int i);

    @NonNull
    Dynamic getDynamic(int i);

    int getInt(int i);

    @Nullable
    ReadableMap getMap(int i);

    @Nullable
    String getString(int i);

    @NonNull
    ReadableType getType(int i);

    boolean isNull(int i);

    int size();

    @NonNull
    ArrayList<Object> toArrayList();
}
