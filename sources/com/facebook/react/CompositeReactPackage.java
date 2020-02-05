package com.facebook.react;

import androidx.annotation.Nullable;
import com.facebook.react.bridge.NativeModule;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.uimanager.ViewManager;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.ListIterator;

public class CompositeReactPackage implements ViewManagerOnDemandReactPackage, ReactPackage {
    private final List<ReactPackage> mChildReactPackages = new ArrayList();

    public CompositeReactPackage(ReactPackage reactPackage, ReactPackage reactPackage2, ReactPackage... reactPackageArr) {
        this.mChildReactPackages.add(reactPackage);
        this.mChildReactPackages.add(reactPackage2);
        Collections.addAll(this.mChildReactPackages, reactPackageArr);
    }

    public List<NativeModule> createNativeModules(ReactApplicationContext reactApplicationContext) {
        HashMap hashMap = new HashMap();
        for (ReactPackage next : this.mChildReactPackages) {
            if (next instanceof TurboReactPackage) {
                TurboReactPackage turboReactPackage = (TurboReactPackage) next;
                for (String next2 : turboReactPackage.getReactModuleInfoProvider().getReactModuleInfos().keySet()) {
                    hashMap.put(next2, turboReactPackage.getModule(next2, reactApplicationContext));
                }
            } else {
                for (NativeModule next3 : next.createNativeModules(reactApplicationContext)) {
                    hashMap.put(next3.getName(), next3);
                }
            }
        }
        return new ArrayList(hashMap.values());
    }

    public List<ViewManager> createViewManagers(ReactApplicationContext reactApplicationContext) {
        HashMap hashMap = new HashMap();
        for (ReactPackage createViewManagers : this.mChildReactPackages) {
            for (ViewManager next : createViewManagers.createViewManagers(reactApplicationContext)) {
                hashMap.put(next.getName(), next);
            }
        }
        return new ArrayList(hashMap.values());
    }

    public List<String> getViewManagerNames(ReactApplicationContext reactApplicationContext) {
        List<String> viewManagerNames;
        HashSet hashSet = new HashSet();
        for (ReactPackage next : this.mChildReactPackages) {
            if ((next instanceof ViewManagerOnDemandReactPackage) && (viewManagerNames = ((ViewManagerOnDemandReactPackage) next).getViewManagerNames(reactApplicationContext)) != null) {
                hashSet.addAll(viewManagerNames);
            }
        }
        return new ArrayList(hashSet);
    }

    @Nullable
    public ViewManager createViewManager(ReactApplicationContext reactApplicationContext, String str) {
        ViewManager createViewManager;
        List<ReactPackage> list = this.mChildReactPackages;
        ListIterator<ReactPackage> listIterator = list.listIterator(list.size());
        while (listIterator.hasPrevious()) {
            ReactPackage previous = listIterator.previous();
            if ((previous instanceof ViewManagerOnDemandReactPackage) && (createViewManager = ((ViewManagerOnDemandReactPackage) previous).createViewManager(reactApplicationContext, str)) != null) {
                return createViewManager;
            }
        }
        return null;
    }
}
