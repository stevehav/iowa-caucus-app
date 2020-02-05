package com.facebook.react;

import android.annotation.SuppressLint;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.os.PowerManager;
import androidx.annotation.Nullable;
import com.facebook.infer.annotation.Assertions;
import com.facebook.react.ReactInstanceManager;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.bridge.UiThreadUtil;
import com.facebook.react.jstasks.HeadlessJsTaskConfig;
import com.facebook.react.jstasks.HeadlessJsTaskContext;
import com.facebook.react.jstasks.HeadlessJsTaskEventListener;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;

public abstract class HeadlessJsTaskService extends Service implements HeadlessJsTaskEventListener {
    @Nullable
    private static PowerManager.WakeLock sWakeLock;
    /* access modifiers changed from: private */
    public final Set<Integer> mActiveTasks = new CopyOnWriteArraySet();

    /* access modifiers changed from: protected */
    @Nullable
    public HeadlessJsTaskConfig getTaskConfig(Intent intent) {
        return null;
    }

    @Nullable
    public IBinder onBind(Intent intent) {
        return null;
    }

    public void onHeadlessJsTaskStart(int i) {
    }

    public int onStartCommand(Intent intent, int i, int i2) {
        HeadlessJsTaskConfig taskConfig = getTaskConfig(intent);
        if (taskConfig == null) {
            return 2;
        }
        startTask(taskConfig);
        return 3;
    }

    @SuppressLint({"WakelockTimeout"})
    public static void acquireWakeLockNow(Context context) {
        PowerManager.WakeLock wakeLock = sWakeLock;
        if (wakeLock == null || !wakeLock.isHeld()) {
            sWakeLock = ((PowerManager) Assertions.assertNotNull((PowerManager) context.getSystemService("power"))).newWakeLock(1, HeadlessJsTaskService.class.getCanonicalName());
            sWakeLock.setReferenceCounted(false);
            sWakeLock.acquire();
        }
    }

    /* access modifiers changed from: protected */
    public void startTask(final HeadlessJsTaskConfig headlessJsTaskConfig) {
        UiThreadUtil.assertOnUiThread();
        acquireWakeLockNow(this);
        final ReactInstanceManager reactInstanceManager = getReactNativeHost().getReactInstanceManager();
        ReactContext currentReactContext = reactInstanceManager.getCurrentReactContext();
        if (currentReactContext == null) {
            reactInstanceManager.addReactInstanceEventListener(new ReactInstanceManager.ReactInstanceEventListener() {
                public void onReactContextInitialized(ReactContext reactContext) {
                    HeadlessJsTaskService.this.invokeStartTask(reactContext, headlessJsTaskConfig);
                    reactInstanceManager.removeReactInstanceEventListener(this);
                }
            });
            reactInstanceManager.createReactContextInBackground();
            return;
        }
        invokeStartTask(currentReactContext, headlessJsTaskConfig);
    }

    /* access modifiers changed from: private */
    public void invokeStartTask(ReactContext reactContext, final HeadlessJsTaskConfig headlessJsTaskConfig) {
        final HeadlessJsTaskContext instance = HeadlessJsTaskContext.getInstance(reactContext);
        instance.addTaskEventListener(this);
        UiThreadUtil.runOnUiThread(new Runnable() {
            public void run() {
                HeadlessJsTaskService.this.mActiveTasks.add(Integer.valueOf(instance.startTask(headlessJsTaskConfig)));
            }
        });
    }

    public void onDestroy() {
        ReactContext currentReactContext;
        super.onDestroy();
        if (getReactNativeHost().hasInstance() && (currentReactContext = getReactNativeHost().getReactInstanceManager().getCurrentReactContext()) != null) {
            HeadlessJsTaskContext.getInstance(currentReactContext).removeTaskEventListener(this);
        }
        PowerManager.WakeLock wakeLock = sWakeLock;
        if (wakeLock != null) {
            wakeLock.release();
        }
    }

    public void onHeadlessJsTaskFinish(int i) {
        this.mActiveTasks.remove(Integer.valueOf(i));
        if (this.mActiveTasks.size() == 0) {
            stopSelf();
        }
    }

    /* access modifiers changed from: protected */
    public ReactNativeHost getReactNativeHost() {
        return ((ReactApplication) getApplication()).getReactNativeHost();
    }
}
