package com.facebook.react.fabric;

import com.facebook.jni.HybridData;
import com.facebook.proguard.annotations.DoNotStrip;

@DoNotStrip
public class ComponentFactoryDelegate {
    @DoNotStrip
    private final HybridData mHybridData = initHybrid();

    @DoNotStrip
    private static native HybridData initHybrid();

    static {
        FabricSoLoader.staticInit();
    }
}
