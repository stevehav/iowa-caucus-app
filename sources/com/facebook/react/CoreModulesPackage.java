package com.facebook.react;

import androidx.annotation.Nullable;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactMarker;
import com.facebook.react.bridge.ReactMarkerConstants;
import com.facebook.react.module.annotations.ReactModule;
import com.facebook.react.module.model.ReactModuleInfo;
import com.facebook.react.module.model.ReactModuleInfoProvider;
import com.facebook.react.modules.core.DefaultHardwareBackBtnHandler;
import com.facebook.react.modules.core.DeviceEventManagerModule;
import com.facebook.react.modules.core.ExceptionsManagerModule;
import com.facebook.react.modules.core.HeadlessJsTaskSupportModule;
import com.facebook.react.modules.core.Timing;
import com.facebook.react.modules.debug.DevSettingsModule;
import com.facebook.react.modules.debug.SourceCodeModule;
import com.facebook.react.modules.deviceinfo.DeviceInfoModule;
import com.facebook.react.modules.systeminfo.AndroidInfoModule;
import com.facebook.react.uimanager.UIImplementationProvider;
import com.facebook.react.uimanager.UIManagerModule;
import com.facebook.react.uimanager.ViewManager;
import com.facebook.systrace.Systrace;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class CoreModulesPackage extends TurboReactPackage implements ReactPackageLogger {
    private final DefaultHardwareBackBtnHandler mHardwareBackBtnHandler;
    private final boolean mLazyViewManagersEnabled;
    private final int mMinTimeLeftInFrameForNonBatchedOperationMs;
    /* access modifiers changed from: private */
    public final ReactInstanceManager mReactInstanceManager;

    CoreModulesPackage(ReactInstanceManager reactInstanceManager, DefaultHardwareBackBtnHandler defaultHardwareBackBtnHandler, @Nullable UIImplementationProvider uIImplementationProvider, boolean z, int i) {
        this.mReactInstanceManager = reactInstanceManager;
        this.mHardwareBackBtnHandler = defaultHardwareBackBtnHandler;
        this.mLazyViewManagersEnabled = z;
        this.mMinTimeLeftInFrameForNonBatchedOperationMs = i;
    }

    public ReactModuleInfoProvider getReactModuleInfoProvider() {
        try {
            return (ReactModuleInfoProvider) Class.forName("com.facebook.react.CoreModulesPackage$$ReactModuleInfoProvider").newInstance();
        } catch (ClassNotFoundException unused) {
            final HashMap hashMap = new HashMap();
            for (Class cls : new Class[]{AndroidInfoModule.class, DeviceEventManagerModule.class, DeviceInfoModule.class, DevSettingsModule.class, ExceptionsManagerModule.class, HeadlessJsTaskSupportModule.class, SourceCodeModule.class, Timing.class, UIManagerModule.class}) {
                ReactModule reactModule = (ReactModule) cls.getAnnotation(ReactModule.class);
                hashMap.put(reactModule.name(), new ReactModuleInfo(reactModule.name(), cls.getName(), reactModule.canOverrideExistingModule(), reactModule.needsEagerInit(), reactModule.hasConstants(), reactModule.isCxxModule(), false));
            }
            return new ReactModuleInfoProvider() {
                public Map<String, ReactModuleInfo> getReactModuleInfos() {
                    return hashMap;
                }
            };
        } catch (InstantiationException e) {
            throw new RuntimeException("No ReactModuleInfoProvider for CoreModulesPackage$$ReactModuleInfoProvider", e);
        } catch (IllegalAccessException e2) {
            throw new RuntimeException("No ReactModuleInfoProvider for CoreModulesPackage$$ReactModuleInfoProvider", e2);
        }
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.facebook.react.bridge.NativeModule getModule(java.lang.String r3, com.facebook.react.bridge.ReactApplicationContext r4) {
        /*
            r2 = this;
            int r0 = r3.hashCode()
            switch(r0) {
                case -1789797270: goto L_0x0059;
                case -1633589448: goto L_0x004f;
                case -1520650172: goto L_0x0044;
                case -1037217463: goto L_0x003a;
                case -790603268: goto L_0x0030;
                case 512434409: goto L_0x0026;
                case 881516744: goto L_0x001c;
                case 1256514152: goto L_0x0012;
                case 1861242489: goto L_0x0008;
                default: goto L_0x0007;
            }
        L_0x0007:
            goto L_0x0063
        L_0x0008:
            java.lang.String r0 = "UIManager"
            boolean r0 = r3.equals(r0)
            if (r0 == 0) goto L_0x0063
            r0 = 7
            goto L_0x0064
        L_0x0012:
            java.lang.String r0 = "HeadlessJsTaskSupport"
            boolean r0 = r3.equals(r0)
            if (r0 == 0) goto L_0x0063
            r0 = 4
            goto L_0x0064
        L_0x001c:
            java.lang.String r0 = "SourceCode"
            boolean r0 = r3.equals(r0)
            if (r0 == 0) goto L_0x0063
            r0 = 5
            goto L_0x0064
        L_0x0026:
            java.lang.String r0 = "ExceptionsManager"
            boolean r0 = r3.equals(r0)
            if (r0 == 0) goto L_0x0063
            r0 = 3
            goto L_0x0064
        L_0x0030:
            java.lang.String r0 = "PlatformConstants"
            boolean r0 = r3.equals(r0)
            if (r0 == 0) goto L_0x0063
            r0 = 0
            goto L_0x0064
        L_0x003a:
            java.lang.String r0 = "DeviceEventManager"
            boolean r0 = r3.equals(r0)
            if (r0 == 0) goto L_0x0063
            r0 = 1
            goto L_0x0064
        L_0x0044:
            java.lang.String r0 = "DeviceInfo"
            boolean r0 = r3.equals(r0)
            if (r0 == 0) goto L_0x0063
            r0 = 8
            goto L_0x0064
        L_0x004f:
            java.lang.String r0 = "DevSettings"
            boolean r0 = r3.equals(r0)
            if (r0 == 0) goto L_0x0063
            r0 = 2
            goto L_0x0064
        L_0x0059:
            java.lang.String r0 = "Timing"
            boolean r0 = r3.equals(r0)
            if (r0 == 0) goto L_0x0063
            r0 = 6
            goto L_0x0064
        L_0x0063:
            r0 = -1
        L_0x0064:
            switch(r0) {
                case 0: goto L_0x00c1;
                case 1: goto L_0x00b9;
                case 2: goto L_0x00ad;
                case 3: goto L_0x00a1;
                case 4: goto L_0x009b;
                case 5: goto L_0x0095;
                case 6: goto L_0x0089;
                case 7: goto L_0x0084;
                case 8: goto L_0x007e;
                default: goto L_0x0067;
            }
        L_0x0067:
            java.lang.IllegalArgumentException r4 = new java.lang.IllegalArgumentException
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "In CoreModulesPackage, could not find Native module for "
            r0.append(r1)
            r0.append(r3)
            java.lang.String r3 = r0.toString()
            r4.<init>(r3)
            throw r4
        L_0x007e:
            com.facebook.react.modules.deviceinfo.DeviceInfoModule r3 = new com.facebook.react.modules.deviceinfo.DeviceInfoModule
            r3.<init>((com.facebook.react.bridge.ReactApplicationContext) r4)
            return r3
        L_0x0084:
            com.facebook.react.uimanager.UIManagerModule r3 = r2.createUIManager(r4)
            return r3
        L_0x0089:
            com.facebook.react.modules.core.Timing r3 = new com.facebook.react.modules.core.Timing
            com.facebook.react.ReactInstanceManager r0 = r2.mReactInstanceManager
            com.facebook.react.devsupport.interfaces.DevSupportManager r0 = r0.getDevSupportManager()
            r3.<init>(r4, r0)
            return r3
        L_0x0095:
            com.facebook.react.modules.debug.SourceCodeModule r3 = new com.facebook.react.modules.debug.SourceCodeModule
            r3.<init>(r4)
            return r3
        L_0x009b:
            com.facebook.react.modules.core.HeadlessJsTaskSupportModule r3 = new com.facebook.react.modules.core.HeadlessJsTaskSupportModule
            r3.<init>(r4)
            return r3
        L_0x00a1:
            com.facebook.react.modules.core.ExceptionsManagerModule r3 = new com.facebook.react.modules.core.ExceptionsManagerModule
            com.facebook.react.ReactInstanceManager r4 = r2.mReactInstanceManager
            com.facebook.react.devsupport.interfaces.DevSupportManager r4 = r4.getDevSupportManager()
            r3.<init>(r4)
            return r3
        L_0x00ad:
            com.facebook.react.modules.debug.DevSettingsModule r3 = new com.facebook.react.modules.debug.DevSettingsModule
            com.facebook.react.ReactInstanceManager r4 = r2.mReactInstanceManager
            com.facebook.react.devsupport.interfaces.DevSupportManager r4 = r4.getDevSupportManager()
            r3.<init>(r4)
            return r3
        L_0x00b9:
            com.facebook.react.modules.core.DeviceEventManagerModule r3 = new com.facebook.react.modules.core.DeviceEventManagerModule
            com.facebook.react.modules.core.DefaultHardwareBackBtnHandler r0 = r2.mHardwareBackBtnHandler
            r3.<init>(r4, r0)
            return r3
        L_0x00c1:
            com.facebook.react.modules.systeminfo.AndroidInfoModule r3 = new com.facebook.react.modules.systeminfo.AndroidInfoModule
            r3.<init>(r4)
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.react.CoreModulesPackage.getModule(java.lang.String, com.facebook.react.bridge.ReactApplicationContext):com.facebook.react.bridge.NativeModule");
    }

    private UIManagerModule createUIManager(ReactApplicationContext reactApplicationContext) {
        ReactMarker.logMarker(ReactMarkerConstants.CREATE_UI_MANAGER_MODULE_START);
        Systrace.beginSection(0, "createUIManagerModule");
        try {
            if (this.mLazyViewManagersEnabled) {
                return new UIManagerModule(reactApplicationContext, (UIManagerModule.ViewManagerResolver) new UIManagerModule.ViewManagerResolver() {
                    @Nullable
                    public ViewManager getViewManager(String str) {
                        return CoreModulesPackage.this.mReactInstanceManager.createViewManager(str);
                    }

                    public List<String> getViewManagerNames() {
                        return CoreModulesPackage.this.mReactInstanceManager.getViewManagerNames();
                    }
                }, this.mMinTimeLeftInFrameForNonBatchedOperationMs);
            }
            UIManagerModule uIManagerModule = new UIManagerModule(reactApplicationContext, this.mReactInstanceManager.getOrCreateViewManagers(reactApplicationContext), this.mMinTimeLeftInFrameForNonBatchedOperationMs);
            Systrace.endSection(0);
            ReactMarker.logMarker(ReactMarkerConstants.CREATE_UI_MANAGER_MODULE_END);
            return uIManagerModule;
        } finally {
            Systrace.endSection(0);
            ReactMarker.logMarker(ReactMarkerConstants.CREATE_UI_MANAGER_MODULE_END);
        }
    }

    public void startProcessPackage() {
        ReactMarker.logMarker(ReactMarkerConstants.PROCESS_CORE_REACT_PACKAGE_START);
    }

    public void endProcessPackage() {
        ReactMarker.logMarker(ReactMarkerConstants.PROCESS_CORE_REACT_PACKAGE_END);
    }
}
