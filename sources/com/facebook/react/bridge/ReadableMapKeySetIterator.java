package com.facebook.react.bridge;

import com.facebook.proguard.annotations.DoNotStrip;

@DoNotStrip
public interface ReadableMapKeySetIterator {
    boolean hasNextKey();

    String nextKey();
}
