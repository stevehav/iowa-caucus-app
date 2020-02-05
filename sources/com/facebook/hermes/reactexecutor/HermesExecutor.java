package com.facebook.hermes.reactexecutor;

import com.facebook.hermes.instrumentation.HermesMemoryDumper;
import com.facebook.jni.HybridData;
import com.facebook.react.bridge.JavaScriptExecutor;
import com.facebook.soloader.SoLoader;
import javax.annotation.Nullable;

public class HermesExecutor extends JavaScriptExecutor {
    private static String mode_;

    public static native boolean canLoadFile(String str);

    private static native HybridData initHybrid(long j, boolean z, int i, boolean z2, @Nullable HermesMemoryDumper hermesMemoryDumper, long j2, long j3);

    private static native HybridData initHybridDefaultConfig();

    static {
        SoLoader.loadLibrary("hermes");
        try {
            SoLoader.loadLibrary("hermes-executor-release");
            mode_ = "Release";
        } catch (UnsatisfiedLinkError unused) {
            SoLoader.loadLibrary("hermes-executor-debug");
            mode_ = "Debug";
        }
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    HermesExecutor(@javax.annotation.Nullable com.facebook.hermes.reactexecutor.RuntimeConfig r11) {
        /*
            r10 = this;
            if (r11 != 0) goto L_0x0007
            com.facebook.jni.HybridData r11 = initHybridDefaultConfig()
            goto L_0x0019
        L_0x0007:
            long r0 = r11.heapSizeMB
            boolean r2 = r11.es6Symbol
            int r3 = r11.bytecodeWarmupPercent
            boolean r4 = r11.tripWireEnabled
            com.facebook.hermes.instrumentation.HermesMemoryDumper r5 = r11.heapDumper
            long r6 = r11.tripWireCooldownMS
            long r8 = r11.tripWireLimitBytes
            com.facebook.jni.HybridData r11 = initHybrid(r0, r2, r3, r4, r5, r6, r8)
        L_0x0019:
            r10.<init>(r11)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.hermes.reactexecutor.HermesExecutor.<init>(com.facebook.hermes.reactexecutor.RuntimeConfig):void");
    }

    public String getName() {
        return "HermesExecutor" + mode_;
    }
}
