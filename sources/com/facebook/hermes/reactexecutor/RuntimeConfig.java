package com.facebook.hermes.reactexecutor;

import com.facebook.hermes.instrumentation.HermesMemoryDumper;
import javax.annotation.Nullable;

public final class RuntimeConfig {
    public int bytecodeWarmupPercent;
    public boolean enableSampledStats;
    public boolean es6Symbol;
    @Nullable
    public HermesMemoryDumper heapDumper;
    public long heapSizeMB;
    public long tripWireCooldownMS;
    public boolean tripWireEnabled;
    public long tripWireLimitBytes;
}
