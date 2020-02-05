package com.facebook.react.modules.debug.interfaces;

public interface DeveloperSettings {
    boolean isAnimationFpsDebugEnabled();

    boolean isElementInspectorEnabled();

    boolean isFpsDebugEnabled();

    boolean isJSDevModeEnabled();

    boolean isJSMinifyEnabled();

    boolean isNuclideJSDebugEnabled();

    boolean isRemoteJSDebugEnabled();

    boolean isStartSamplingProfilerOnInit();

    void setRemoteJSDebugEnabled(boolean z);
}
