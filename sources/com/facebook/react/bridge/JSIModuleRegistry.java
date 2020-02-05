package com.facebook.react.bridge;

import com.facebook.infer.annotation.Assertions;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class JSIModuleRegistry {
    private final Map<JSIModuleType, JSIModuleHolder> mModules = new HashMap();

    public JSIModule getModule(JSIModuleType jSIModuleType) {
        JSIModuleHolder jSIModuleHolder = this.mModules.get(jSIModuleType);
        if (jSIModuleHolder != null) {
            return (JSIModule) Assertions.assertNotNull(jSIModuleHolder.getJSIModule());
        }
        throw new IllegalArgumentException("Unable to find JSIModule for class " + jSIModuleType);
    }

    public void registerModules(List<JSIModuleSpec> list) {
        for (JSIModuleSpec next : list) {
            this.mModules.put(next.getJSIModuleType(), new JSIModuleHolder(next));
        }
    }

    public void notifyJSInstanceDestroy() {
        for (Map.Entry next : this.mModules.entrySet()) {
            if (((JSIModuleType) next.getKey()) != JSIModuleType.TurboModuleManager) {
                ((JSIModuleHolder) next.getValue()).notifyJSInstanceDestroy();
            }
        }
    }
}
