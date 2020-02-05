package com.facebook.react.turbomodule.core;

import androidx.annotation.Nullable;
import com.facebook.jni.HybridData;
import com.facebook.react.bridge.CxxModuleWrapper;
import com.facebook.react.turbomodule.core.interfaces.TurboModule;
import com.facebook.soloader.SoLoader;

public abstract class TurboModuleManagerDelegate {
    private final HybridData mHybridData = initHybrid();

    @Nullable
    public abstract CxxModuleWrapper getLegacyCxxModule(String str);

    @Nullable
    public abstract TurboModule getModule(String str);

    /* access modifiers changed from: protected */
    public abstract HybridData initHybrid();

    static {
        SoLoader.loadLibrary("turbomodulejsijni");
    }

    protected TurboModuleManagerDelegate() {
    }
}
