package com.facebook.react.fabric;

import android.annotation.SuppressLint;
import android.os.SystemClock;
import android.view.View;
import androidx.annotation.GuardedBy;
import androidx.annotation.Nullable;
import androidx.annotation.UiThread;
import com.drew.metadata.photoshop.PhotoshopDirectory;
import com.facebook.common.logging.FLog;
import com.facebook.debug.holder.PrinterHolder;
import com.facebook.debug.tags.ReactDebugOverlayTags;
import com.facebook.infer.annotation.ThreadConfined;
import com.facebook.proguard.annotations.DoNotStrip;
import com.facebook.react.bridge.LifecycleEventListener;
import com.facebook.react.bridge.NativeMap;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.bridge.ReactMarker;
import com.facebook.react.bridge.ReactMarkerConstants;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.UIManager;
import com.facebook.react.bridge.UiThreadUtil;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.common.ReactConstants;
import com.facebook.react.config.ReactFeatureFlags;
import com.facebook.react.fabric.events.EventBeatManager;
import com.facebook.react.fabric.events.EventEmitterWrapper;
import com.facebook.react.fabric.events.FabricEventEmitter;
import com.facebook.react.fabric.mounting.LayoutMetricsConversions;
import com.facebook.react.fabric.mounting.MountingManager;
import com.facebook.react.fabric.mounting.mountitems.BatchMountItem;
import com.facebook.react.fabric.mounting.mountitems.CreateMountItem;
import com.facebook.react.fabric.mounting.mountitems.DeleteMountItem;
import com.facebook.react.fabric.mounting.mountitems.DispatchCommandMountItem;
import com.facebook.react.fabric.mounting.mountitems.DispatchStringCommandMountItem;
import com.facebook.react.fabric.mounting.mountitems.InsertMountItem;
import com.facebook.react.fabric.mounting.mountitems.MountItem;
import com.facebook.react.fabric.mounting.mountitems.PreAllocateViewMountItem;
import com.facebook.react.fabric.mounting.mountitems.RemoveMountItem;
import com.facebook.react.fabric.mounting.mountitems.UpdateEventEmitterMountItem;
import com.facebook.react.fabric.mounting.mountitems.UpdateLayoutMountItem;
import com.facebook.react.fabric.mounting.mountitems.UpdateLocalDataMountItem;
import com.facebook.react.fabric.mounting.mountitems.UpdatePropsMountItem;
import com.facebook.react.fabric.mounting.mountitems.UpdateStateMountItem;
import com.facebook.react.modules.core.ReactChoreographer;
import com.facebook.react.uimanager.ReactRoot;
import com.facebook.react.uimanager.ReactRootViewTagGenerator;
import com.facebook.react.uimanager.StateWrapper;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.ViewManagerPropertyUpdater;
import com.facebook.react.uimanager.ViewManagerRegistry;
import com.facebook.react.uimanager.events.EventDispatcher;
import com.facebook.systrace.Systrace;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@SuppressLint({"MissingNativeLoadLibrary"})
public class FabricUIManager implements UIManager, LifecycleEventListener {
    public static final boolean DEBUG = (ReactFeatureFlags.enableFabricLogs || PrinterHolder.getPrinter().shouldDisplayLogMessage(ReactDebugOverlayTags.FABRIC_UI_MANAGER));
    private static final int FRAME_TIME_MS = 16;
    private static final int MAX_TIME_IN_FRAME_FOR_NON_BATCHED_OPERATIONS_MS = 8;
    private static final int PRE_MOUNT_ITEMS_INITIAL_SIZE_ARRAY = 250;
    public static final String TAG = "FabricUIManager";
    private long mBatchedExecutionTime = 0;
    private Binding mBinding;
    private long mCommitStartTime = 0;
    private int mCurrentSynchronousCommitNumber = PhotoshopDirectory.TAG_PRINT_FLAGS_INFO;
    /* access modifiers changed from: private */
    @ThreadConfined("UI")
    public final DispatchUIFrameCallback mDispatchUIFrameCallback;
    private long mDispatchViewUpdatesTime = 0;
    private final EventBeatManager mEventBeatManager;
    private final EventDispatcher mEventDispatcher;
    private long mFinishTransactionCPPTime = 0;
    private long mFinishTransactionTime = 0;
    /* access modifiers changed from: private */
    @ThreadConfined("UI")
    public boolean mIsMountingEnabled = true;
    private long mLayoutTime = 0;
    @GuardedBy("mMountItemsLock")
    private List<MountItem> mMountItems = new ArrayList();
    private final Object mMountItemsLock = new Object();
    private final MountingManager mMountingManager;
    @GuardedBy("mPreMountItemsLock")
    private ArrayDeque<MountItem> mPreMountItems = new ArrayDeque<>(250);
    private final Object mPreMountItemsLock = new Object();
    private final ReactApplicationContext mReactApplicationContext;
    private final ConcurrentHashMap<Integer, ThemedReactContext> mReactContextForRootTag = new ConcurrentHashMap<>();
    private long mRunStartTime = 0;

    public void onHostDestroy() {
    }

    public void profileNextBatch() {
    }

    static {
        FabricSoLoader.staticInit();
    }

    public FabricUIManager(ReactApplicationContext reactApplicationContext, ViewManagerRegistry viewManagerRegistry, EventDispatcher eventDispatcher, EventBeatManager eventBeatManager) {
        this.mDispatchUIFrameCallback = new DispatchUIFrameCallback(reactApplicationContext);
        this.mReactApplicationContext = reactApplicationContext;
        this.mMountingManager = new MountingManager(viewManagerRegistry);
        this.mEventDispatcher = eventDispatcher;
        this.mEventBeatManager = eventBeatManager;
        this.mReactApplicationContext.addLifecycleEventListener(this);
    }

    public <T extends View> int addRootView(T t, WritableMap writableMap, @Nullable String str) {
        int nextRootViewTag = ReactRootViewTagGenerator.getNextRootViewTag();
        ThemedReactContext themedReactContext = new ThemedReactContext(this.mReactApplicationContext, t.getContext());
        this.mMountingManager.addRootView(nextRootViewTag, t);
        this.mReactContextForRootTag.put(Integer.valueOf(nextRootViewTag), themedReactContext);
        String jSModuleName = ((ReactRoot) t).getJSModuleName();
        if (DEBUG) {
            FLog.d(TAG, "Starting surface for module: %s and reactTag: %d", (Object) jSModuleName, (Object) Integer.valueOf(nextRootViewTag));
        }
        this.mBinding.startSurface(nextRootViewTag, jSModuleName, (NativeMap) writableMap);
        if (str != null) {
            this.mBinding.renderTemplateToSurface(nextRootViewTag, str);
        }
        return nextRootViewTag;
    }

    public <T extends View> int startSurface(T t, String str, WritableMap writableMap, int i, int i2) {
        int nextRootViewTag = ReactRootViewTagGenerator.getNextRootViewTag();
        ThemedReactContext themedReactContext = new ThemedReactContext(this.mReactApplicationContext, t.getContext());
        if (DEBUG) {
            FLog.d(TAG, "Starting surface for module: %s and reactTag: %d", (Object) str, (Object) Integer.valueOf(nextRootViewTag));
        }
        this.mMountingManager.addRootView(nextRootViewTag, t);
        this.mReactContextForRootTag.put(Integer.valueOf(nextRootViewTag), themedReactContext);
        this.mBinding.startSurfaceWithConstraints(nextRootViewTag, str, (NativeMap) writableMap, LayoutMetricsConversions.getMinSize(i), LayoutMetricsConversions.getMaxSize(i), LayoutMetricsConversions.getMinSize(i2), LayoutMetricsConversions.getMaxSize(i2));
        return nextRootViewTag;
    }

    @DoNotStrip
    public void onRequestEventBeat() {
        this.mEventDispatcher.dispatchAllEvents();
    }

    public void stopSurface(int i) {
        this.mBinding.stopSurface(i);
    }

    public void initialize() {
        this.mEventDispatcher.registerEventEmitter(2, new FabricEventEmitter(this));
        this.mEventDispatcher.addBatchEventDispatchedListener(this.mEventBeatManager);
    }

    public void onCatalystInstanceDestroy() {
        if (DEBUG) {
            FLog.d(TAG, "Destroying Catalyst Instance");
        }
        this.mEventDispatcher.removeBatchEventDispatchedListener(this.mEventBeatManager);
        this.mEventDispatcher.unregisterEventEmitter(2);
        this.mBinding.unregister();
        ViewManagerPropertyUpdater.clear();
    }

    @DoNotStrip
    private void preallocateView(int i, int i2, String str, @Nullable ReadableMap readableMap, @Nullable Object obj, boolean z) {
        ThemedReactContext themedReactContext = this.mReactContextForRootTag.get(Integer.valueOf(i));
        String fabricComponentName = FabricComponents.getFabricComponentName(str);
        synchronized (this.mPreMountItemsLock) {
            this.mPreMountItems.add(new PreAllocateViewMountItem(themedReactContext, i, i2, fabricComponentName, readableMap, (StateWrapper) obj, z));
        }
    }

    @DoNotStrip
    private MountItem createMountItem(String str, @Nullable ReadableMap readableMap, @Nullable Object obj, int i, int i2, boolean z) {
        String fabricComponentName = FabricComponents.getFabricComponentName(str);
        ThemedReactContext themedReactContext = this.mReactContextForRootTag.get(Integer.valueOf(i));
        if (themedReactContext != null) {
            return new CreateMountItem(themedReactContext, i, i2, fabricComponentName, readableMap, (StateWrapper) obj, z);
        }
        throw new IllegalArgumentException("Unable to find ReactContext for root: " + i);
    }

    @DoNotStrip
    private MountItem removeMountItem(int i, int i2, int i3) {
        return new RemoveMountItem(i, i2, i3);
    }

    @DoNotStrip
    private MountItem insertMountItem(int i, int i2, int i3) {
        return new InsertMountItem(i, i2, i3);
    }

    @DoNotStrip
    private MountItem deleteMountItem(int i) {
        return new DeleteMountItem(i);
    }

    @DoNotStrip
    private MountItem updateLayoutMountItem(int i, int i2, int i3, int i4, int i5, int i6) {
        return new UpdateLayoutMountItem(i, i2, i3, i4, i5, i6);
    }

    @DoNotStrip
    private MountItem updatePropsMountItem(int i, ReadableMap readableMap) {
        return new UpdatePropsMountItem(i, readableMap);
    }

    @DoNotStrip
    private MountItem updateLocalDataMountItem(int i, ReadableMap readableMap) {
        return new UpdateLocalDataMountItem(i, readableMap);
    }

    @DoNotStrip
    private MountItem updateStateMountItem(int i, Object obj) {
        return new UpdateStateMountItem(i, (StateWrapper) obj);
    }

    @DoNotStrip
    private MountItem updateEventEmitterMountItem(int i, Object obj) {
        return new UpdateEventEmitterMountItem(i, (EventEmitterWrapper) obj);
    }

    @DoNotStrip
    private MountItem createBatchMountItem(MountItem[] mountItemArr, int i, int i2) {
        return new BatchMountItem(mountItemArr, i, i2);
    }

    @DoNotStrip
    private long measure(String str, ReadableMap readableMap, ReadableMap readableMap2, ReadableMap readableMap3, float f, float f2, float f3, float f4) {
        return this.mMountingManager.measure(this.mReactApplicationContext, str, readableMap, readableMap2, readableMap3, LayoutMetricsConversions.getYogaSize(f, f2), LayoutMetricsConversions.getYogaMeasureMode(f, f2), LayoutMetricsConversions.getYogaSize(f3, f4), LayoutMetricsConversions.getYogaMeasureMode(f3, f4));
    }

    public void synchronouslyUpdateViewOnUIThread(int i, ReadableMap readableMap) {
        String str;
        int i2;
        ReactMarkerConstants reactMarkerConstants;
        String str2;
        int i3;
        long uptimeMillis = SystemClock.uptimeMillis();
        int i4 = this.mCurrentSynchronousCommitNumber;
        this.mCurrentSynchronousCommitNumber = i4 + 1;
        try {
            ReactMarker.logFabricMarker(ReactMarkerConstants.FABRIC_UPDATE_UI_MAIN_THREAD_START, (String) null, i4);
            int i5 = i4;
            try {
                scheduleMountItem(updatePropsMountItem(i, readableMap), i4, uptimeMillis, 0, 0, 0, 0, 0, 0);
                reactMarkerConstants = ReactMarkerConstants.FABRIC_UPDATE_UI_MAIN_THREAD_END;
                i2 = i5;
                str = null;
            } catch (Exception unused) {
                i2 = i5;
                str = null;
                reactMarkerConstants = ReactMarkerConstants.FABRIC_UPDATE_UI_MAIN_THREAD_END;
                ReactMarker.logFabricMarker(reactMarkerConstants, str, i2);
            } catch (Throwable th) {
                th = th;
                i3 = i5;
                str2 = null;
                ReactMarker.logFabricMarker(ReactMarkerConstants.FABRIC_UPDATE_UI_MAIN_THREAD_END, str2, i3);
                throw th;
            }
        } catch (Exception unused2) {
            str = null;
            i2 = i4;
            reactMarkerConstants = ReactMarkerConstants.FABRIC_UPDATE_UI_MAIN_THREAD_END;
            ReactMarker.logFabricMarker(reactMarkerConstants, str, i2);
        } catch (Throwable th2) {
            th = th2;
            str2 = null;
            i3 = i4;
            ReactMarker.logFabricMarker(ReactMarkerConstants.FABRIC_UPDATE_UI_MAIN_THREAD_END, str2, i3);
            throw th;
        }
        ReactMarker.logFabricMarker(reactMarkerConstants, str, i2);
    }

    @DoNotStrip
    private void scheduleMountItem(MountItem mountItem, int i, long j, long j2, long j3, long j4, long j5, long j6, long j7) {
        int i2 = i;
        long j8 = j4;
        long j9 = j5;
        long j10 = j6;
        long j11 = j7;
        boolean z = mountItem instanceof BatchMountItem;
        if (z) {
            this.mCommitStartTime = j;
            this.mLayoutTime = j9 - j8;
            this.mFinishTransactionCPPTime = j11 - j10;
            this.mFinishTransactionTime = SystemClock.uptimeMillis() - j10;
            this.mDispatchViewUpdatesTime = SystemClock.uptimeMillis();
        }
        synchronized (this.mMountItemsLock) {
            this.mMountItems.add(mountItem);
        }
        if (z) {
            ReactMarker.logFabricMarker(ReactMarkerConstants.FABRIC_COMMIT_START, (String) null, i2, this.mCommitStartTime);
            ReactMarker.logFabricMarker(ReactMarkerConstants.FABRIC_FINISH_TRANSACTION_START, (String) null, i2, j10);
            ReactMarker.logFabricMarker(ReactMarkerConstants.FABRIC_FINISH_TRANSACTION_END, (String) null, i2, j11);
            ReactMarker.logFabricMarker(ReactMarkerConstants.FABRIC_DIFF_START, (String) null, i2, j2);
            ReactMarker.logFabricMarker(ReactMarkerConstants.FABRIC_DIFF_END, (String) null, i2, j3);
            ReactMarker.logFabricMarker(ReactMarkerConstants.FABRIC_LAYOUT_START, (String) null, i2, j8);
            ReactMarker.logFabricMarker(ReactMarkerConstants.FABRIC_LAYOUT_END, (String) null, i2, j9);
            ReactMarker.logFabricMarker(ReactMarkerConstants.FABRIC_COMMIT_END, (String) null, i2);
        }
        if (UiThreadUtil.isOnUiThread()) {
            dispatchMountItems();
        }
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0020, code lost:
        monitor-enter(r2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0027, code lost:
        if (r9.mPreMountItems.isEmpty() != false) goto L_0x0034;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0029, code lost:
        r0 = r9.mPreMountItems;
        r9.mPreMountItems = new java.util.ArrayDeque<>(250);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0034, code lost:
        monitor-exit(r2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0037, code lost:
        if (r0 == null) goto L_0x0066;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0039, code lost:
        com.facebook.systrace.Systrace.beginSection(0, "FabricUIManager::mountViews preMountItems to execute: " + r0.size());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0055, code lost:
        if (r0.isEmpty() != false) goto L_0x0063;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0057, code lost:
        r0.pollFirst().execute(r9.mMountingManager);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0063, code lost:
        com.facebook.systrace.Systrace.endSection(0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0066, code lost:
        com.facebook.systrace.Systrace.beginSection(0, "FabricUIManager::mountViews mountItems to execute: " + r1.size());
        r4 = android.os.SystemClock.uptimeMillis();
        r0 = r1.iterator();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x008a, code lost:
        if (r0.hasNext() == false) goto L_0x00b2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x008c, code lost:
        r1 = r0.next();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x0094, code lost:
        if (DEBUG == false) goto L_0x00ac;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x0096, code lost:
        r6 = TAG;
        com.facebook.common.logging.FLog.d(r6, "dispatchMountItems: Executing mountItem: " + r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x00ac, code lost:
        r1.execute(r9.mMountingManager);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x00b2, code lost:
        r9.mBatchedExecutionTime = android.os.SystemClock.uptimeMillis() - r4;
        com.facebook.systrace.Systrace.endSection(0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x00bc, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x001d, code lost:
        r0 = null;
        r2 = r9.mPreMountItemsLock;
     */
    @androidx.annotation.UiThread
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void dispatchMountItems() {
        /*
            r9 = this;
            long r0 = android.os.SystemClock.uptimeMillis()
            r9.mRunStartTime = r0
            java.lang.Object r0 = r9.mMountItemsLock
            monitor-enter(r0)
            java.util.List<com.facebook.react.fabric.mounting.mountitems.MountItem> r1 = r9.mMountItems     // Catch:{ all -> 0x00c0 }
            boolean r1 = r1.isEmpty()     // Catch:{ all -> 0x00c0 }
            if (r1 == 0) goto L_0x0013
            monitor-exit(r0)     // Catch:{ all -> 0x00c0 }
            return
        L_0x0013:
            java.util.List<com.facebook.react.fabric.mounting.mountitems.MountItem> r1 = r9.mMountItems     // Catch:{ all -> 0x00c0 }
            java.util.ArrayList r2 = new java.util.ArrayList     // Catch:{ all -> 0x00c0 }
            r2.<init>()     // Catch:{ all -> 0x00c0 }
            r9.mMountItems = r2     // Catch:{ all -> 0x00c0 }
            monitor-exit(r0)     // Catch:{ all -> 0x00c0 }
            r0 = 0
            java.lang.Object r2 = r9.mPreMountItemsLock
            monitor-enter(r2)
            java.util.ArrayDeque<com.facebook.react.fabric.mounting.mountitems.MountItem> r3 = r9.mPreMountItems     // Catch:{ all -> 0x00bd }
            boolean r3 = r3.isEmpty()     // Catch:{ all -> 0x00bd }
            if (r3 != 0) goto L_0x0034
            java.util.ArrayDeque<com.facebook.react.fabric.mounting.mountitems.MountItem> r0 = r9.mPreMountItems     // Catch:{ all -> 0x00bd }
            java.util.ArrayDeque r3 = new java.util.ArrayDeque     // Catch:{ all -> 0x00bd }
            r4 = 250(0xfa, float:3.5E-43)
            r3.<init>(r4)     // Catch:{ all -> 0x00bd }
            r9.mPreMountItems = r3     // Catch:{ all -> 0x00bd }
        L_0x0034:
            monitor-exit(r2)     // Catch:{ all -> 0x00bd }
            r2 = 0
            if (r0 == 0) goto L_0x0066
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.String r5 = "FabricUIManager::mountViews preMountItems to execute: "
            r4.append(r5)
            int r5 = r0.size()
            r4.append(r5)
            java.lang.String r4 = r4.toString()
            com.facebook.systrace.Systrace.beginSection(r2, r4)
        L_0x0051:
            boolean r4 = r0.isEmpty()
            if (r4 != 0) goto L_0x0063
            java.lang.Object r4 = r0.pollFirst()
            com.facebook.react.fabric.mounting.mountitems.MountItem r4 = (com.facebook.react.fabric.mounting.mountitems.MountItem) r4
            com.facebook.react.fabric.mounting.MountingManager r5 = r9.mMountingManager
            r4.execute(r5)
            goto L_0x0051
        L_0x0063:
            com.facebook.systrace.Systrace.endSection(r2)
        L_0x0066:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r4 = "FabricUIManager::mountViews mountItems to execute: "
            r0.append(r4)
            int r4 = r1.size()
            r0.append(r4)
            java.lang.String r0 = r0.toString()
            com.facebook.systrace.Systrace.beginSection(r2, r0)
            long r4 = android.os.SystemClock.uptimeMillis()
            java.util.Iterator r0 = r1.iterator()
        L_0x0086:
            boolean r1 = r0.hasNext()
            if (r1 == 0) goto L_0x00b2
            java.lang.Object r1 = r0.next()
            com.facebook.react.fabric.mounting.mountitems.MountItem r1 = (com.facebook.react.fabric.mounting.mountitems.MountItem) r1
            boolean r6 = DEBUG
            if (r6 == 0) goto L_0x00ac
            java.lang.String r6 = TAG
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            r7.<init>()
            java.lang.String r8 = "dispatchMountItems: Executing mountItem: "
            r7.append(r8)
            r7.append(r1)
            java.lang.String r7 = r7.toString()
            com.facebook.common.logging.FLog.d((java.lang.String) r6, (java.lang.String) r7)
        L_0x00ac:
            com.facebook.react.fabric.mounting.MountingManager r6 = r9.mMountingManager
            r1.execute(r6)
            goto L_0x0086
        L_0x00b2:
            long r0 = android.os.SystemClock.uptimeMillis()
            long r0 = r0 - r4
            r9.mBatchedExecutionTime = r0
            com.facebook.systrace.Systrace.endSection(r2)
            return
        L_0x00bd:
            r0 = move-exception
            monitor-exit(r2)     // Catch:{ all -> 0x00bd }
            throw r0
        L_0x00c0:
            r1 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x00c0 }
            goto L_0x00c4
        L_0x00c3:
            throw r1
        L_0x00c4:
            goto L_0x00c3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.react.fabric.FabricUIManager.dispatchMountItems():void");
    }

    /* access modifiers changed from: private */
    @UiThread
    public void dispatchPreMountItems(long j) {
        MountItem pollFirst;
        Systrace.beginSection(0, "FabricUIManager::premountViews");
        while (true) {
            if (16 - ((System.nanoTime() - j) / 1000000) < 8) {
                break;
            }
            synchronized (this.mPreMountItemsLock) {
                if (!this.mPreMountItems.isEmpty()) {
                    pollFirst = this.mPreMountItems.pollFirst();
                }
            }
            pollFirst.execute(this.mMountingManager);
        }
        Systrace.endSection(0);
    }

    public void setBinding(Binding binding) {
        this.mBinding = binding;
    }

    public void updateRootLayoutSpecs(int i, int i2, int i3) {
        if (DEBUG) {
            FLog.d(TAG, "Updating Root Layout Specs");
        }
        this.mBinding.setConstraints(i, LayoutMetricsConversions.getMinSize(i2), LayoutMetricsConversions.getMaxSize(i2), LayoutMetricsConversions.getMinSize(i3), LayoutMetricsConversions.getMaxSize(i3));
    }

    public void receiveEvent(int i, String str, @Nullable WritableMap writableMap) {
        EventEmitterWrapper eventEmitter = this.mMountingManager.getEventEmitter(i);
        if (eventEmitter == null) {
            String str2 = TAG;
            FLog.d(str2, "Unable to invoke event: " + str + " for reactTag: " + i);
            return;
        }
        eventEmitter.invoke(str, writableMap);
    }

    public void onHostResume() {
        ReactChoreographer.getInstance().postFrameCallback(ReactChoreographer.CallbackType.DISPATCH_UI, this.mDispatchUIFrameCallback);
    }

    public void onHostPause() {
        ReactChoreographer.getInstance().removeFrameCallback(ReactChoreographer.CallbackType.DISPATCH_UI, this.mDispatchUIFrameCallback);
    }

    @Deprecated
    public void dispatchCommand(int i, int i2, @Nullable ReadableArray readableArray) {
        synchronized (this.mMountItemsLock) {
            this.mMountItems.add(new DispatchCommandMountItem(i, i2, readableArray));
        }
    }

    public void dispatchCommand(int i, String str, @Nullable ReadableArray readableArray) {
        synchronized (this.mMountItemsLock) {
            this.mMountItems.add(new DispatchStringCommandMountItem(i, str, readableArray));
        }
    }

    @DoNotStrip
    public void setJSResponder(final int i, final int i2, final boolean z) {
        synchronized (this.mMountItemsLock) {
            this.mMountItems.add(new MountItem() {
                public void execute(MountingManager mountingManager) {
                    mountingManager.setJSResponder(i, i2, z);
                }
            });
        }
    }

    @DoNotStrip
    public void clearJSResponder() {
        synchronized (this.mMountItemsLock) {
            this.mMountItems.add(new MountItem() {
                public void execute(MountingManager mountingManager) {
                    mountingManager.clearJSResponder();
                }
            });
        }
    }

    public Map<String, Long> getPerformanceCounters() {
        HashMap hashMap = new HashMap();
        hashMap.put("CommitStartTime", Long.valueOf(this.mCommitStartTime));
        hashMap.put("LayoutTime", Long.valueOf(this.mLayoutTime));
        hashMap.put("DispatchViewUpdatesTime", Long.valueOf(this.mDispatchViewUpdatesTime));
        hashMap.put("RunStartTime", Long.valueOf(this.mRunStartTime));
        hashMap.put("BatchedExecutionTime", Long.valueOf(this.mBatchedExecutionTime));
        hashMap.put("FinishFabricTransactionTime", Long.valueOf(this.mFinishTransactionTime));
        hashMap.put("FinishFabricTransactionCPPTime", Long.valueOf(this.mFinishTransactionCPPTime));
        return hashMap;
    }

    private class DispatchUIFrameCallback extends GuardedFrameCallback {
        private DispatchUIFrameCallback(ReactContext reactContext) {
            super(reactContext);
        }

        public void doFrameGuarded(long j) {
            if (!FabricUIManager.this.mIsMountingEnabled) {
                FLog.w(ReactConstants.TAG, "Not flushing pending UI operations because of previously thrown Exception");
                return;
            }
            try {
                FabricUIManager.this.dispatchPreMountItems(j);
                FabricUIManager.this.dispatchMountItems();
                ReactChoreographer.getInstance().postFrameCallback(ReactChoreographer.CallbackType.DISPATCH_UI, FabricUIManager.this.mDispatchUIFrameCallback);
            } catch (Exception e) {
                FLog.i(ReactConstants.TAG, "Exception thrown when executing UIFrameGuarded", (Throwable) e);
                boolean unused = FabricUIManager.this.mIsMountingEnabled = false;
                throw e;
            } catch (Throwable th) {
                ReactChoreographer.getInstance().postFrameCallback(ReactChoreographer.CallbackType.DISPATCH_UI, FabricUIManager.this.mDispatchUIFrameCallback);
                throw th;
            }
        }
    }
}
