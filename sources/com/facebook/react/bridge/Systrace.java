package com.facebook.react.bridge;

import com.facebook.proguard.annotations.DoNotStrip;

@DoNotStrip
public interface Systrace extends JavaScriptModule {
    @DoNotStrip
    void setEnabled(boolean z);
}
