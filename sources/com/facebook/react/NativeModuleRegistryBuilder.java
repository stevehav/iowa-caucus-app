package com.facebook.react;

import com.facebook.react.bridge.ModuleHolder;
import com.facebook.react.bridge.NativeModuleRegistry;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.config.ReactFeatureFlags;
import java.util.HashMap;
import java.util.Map;

public class NativeModuleRegistryBuilder {
    private final Map<String, ModuleHolder> mModules = new HashMap();
    private final ReactApplicationContext mReactApplicationContext;
    private final ReactInstanceManager mReactInstanceManager;

    public NativeModuleRegistryBuilder(ReactApplicationContext reactApplicationContext, ReactInstanceManager reactInstanceManager) {
        this.mReactApplicationContext = reactApplicationContext;
        this.mReactInstanceManager = reactInstanceManager;
    }

    public void processPackage(ReactPackage reactPackage) {
        Iterable<ModuleHolder> iterable;
        if (reactPackage instanceof LazyReactPackage) {
            iterable = ((LazyReactPackage) reactPackage).getNativeModuleIterator(this.mReactApplicationContext);
        } else if (reactPackage instanceof TurboReactPackage) {
            iterable = ((TurboReactPackage) reactPackage).getNativeModuleIterator(this.mReactApplicationContext);
        } else {
            iterable = ReactPackageHelper.getNativeModuleIterator(reactPackage, this.mReactApplicationContext, this.mReactInstanceManager);
        }
        for (ModuleHolder next : iterable) {
            String name = next.getName();
            if (this.mModules.containsKey(name)) {
                ModuleHolder moduleHolder = this.mModules.get(name);
                if (next.getCanOverrideExistingModule()) {
                    this.mModules.remove(moduleHolder);
                } else {
                    throw new IllegalStateException("Native module " + name + " tried to override " + moduleHolder.getClassName() + ". Check the getPackages() method in MainApplication.java, it might be that module is being created twice. If this was your intention, set canOverrideExistingModule=true. This error may also be present if the package is present only once in getPackages() but is also automatically added later during build time by autolinking. Try removing the existing entry and rebuild.");
                }
            }
            if (!ReactFeatureFlags.useTurboModules || !next.isTurboModule()) {
                this.mModules.put(name, next);
            }
        }
    }

    public NativeModuleRegistry build() {
        return new NativeModuleRegistry(this.mReactApplicationContext, this.mModules);
    }
}
