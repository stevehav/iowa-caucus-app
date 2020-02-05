package com.facebook.yoga;

import com.facebook.proguard.annotations.DoNotStrip;

@DoNotStrip
public interface YogaLogger {
    @DoNotStrip
    void log(YogaNode yogaNode, YogaLogLevel yogaLogLevel, String str);
}
