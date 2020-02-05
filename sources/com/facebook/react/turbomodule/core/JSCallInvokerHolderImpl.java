package com.facebook.react.turbomodule.core;

import com.facebook.jni.HybridData;
import com.facebook.react.turbomodule.core.interfaces.JSCallInvokerHolder;
import com.facebook.soloader.SoLoader;

public class JSCallInvokerHolderImpl implements JSCallInvokerHolder {
    private final HybridData mHybridData;

    static {
        SoLoader.loadLibrary("turbomodulejsijni");
    }

    private JSCallInvokerHolderImpl(HybridData hybridData) {
        this.mHybridData = hybridData;
    }
}
