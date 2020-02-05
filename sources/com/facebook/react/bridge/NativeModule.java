package com.facebook.react.bridge;

import androidx.annotation.NonNull;
import com.facebook.proguard.annotations.DoNotStrip;

@DoNotStrip
public interface NativeModule {

    public interface NativeMethod {
        String getType();

        void invoke(JSInstance jSInstance, ReadableArray readableArray);
    }

    boolean canOverrideExistingModule();

    @NonNull
    String getName();

    void initialize();

    void onCatalystInstanceDestroy();
}
