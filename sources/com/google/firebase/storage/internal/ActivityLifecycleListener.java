package com.google.firebase.storage.internal;

import android.app.Activity;
import android.util.Log;
import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import com.google.android.gms.common.api.internal.LifecycleActivity;
import com.google.android.gms.common.api.internal.LifecycleCallback;
import com.google.android.gms.common.api.internal.LifecycleFragment;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* compiled from: com.google.firebase:firebase-storage@@18.1.1 */
public class ActivityLifecycleListener {
    private static final ActivityLifecycleListener instance = new ActivityLifecycleListener();
    private final Map<Object, LifecycleEntry> cookieMap = new HashMap();
    private final Object sync = new Object();

    private ActivityLifecycleListener() {
    }

    @NonNull
    public static ActivityLifecycleListener getInstance() {
        return instance;
    }

    public void runOnActivityStopped(@NonNull Activity activity, @NonNull Object obj, @NonNull Runnable runnable) {
        synchronized (this.sync) {
            LifecycleEntry lifecycleEntry = new LifecycleEntry(activity, runnable, obj);
            OnStopCallback.getInstance(activity).addEntry(lifecycleEntry);
            this.cookieMap.put(obj, lifecycleEntry);
        }
    }

    public void removeCookie(@NonNull Object obj) {
        synchronized (this.sync) {
            LifecycleEntry lifecycleEntry = this.cookieMap.get(obj);
            if (lifecycleEntry != null) {
                OnStopCallback.getInstance(lifecycleEntry.getActivity()).removeEntry(lifecycleEntry);
            }
        }
    }

    /* compiled from: com.google.firebase:firebase-storage@@18.1.1 */
    private static class LifecycleEntry {
        @NonNull
        private final Activity activity;
        @NonNull
        private final Object cookie;
        @NonNull
        private final Runnable runnable;

        public LifecycleEntry(@NonNull Activity activity2, @NonNull Runnable runnable2, @NonNull Object obj) {
            this.activity = activity2;
            this.runnable = runnable2;
            this.cookie = obj;
        }

        public int hashCode() {
            return this.cookie.hashCode();
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof LifecycleEntry)) {
                return false;
            }
            LifecycleEntry lifecycleEntry = (LifecycleEntry) obj;
            if (lifecycleEntry.cookie.equals(this.cookie) && lifecycleEntry.runnable == this.runnable && lifecycleEntry.activity == this.activity) {
                return true;
            }
            return false;
        }

        @NonNull
        public Activity getActivity() {
            return this.activity;
        }

        @NonNull
        public Runnable getRunnable() {
            return this.runnable;
        }

        @NonNull
        public Object getCookie() {
            return this.cookie;
        }
    }

    /* compiled from: com.google.firebase:firebase-storage@@18.1.1 */
    private static class OnStopCallback extends LifecycleCallback {
        private static final String TAG = "StorageOnStopCallback";
        private final List<LifecycleEntry> listeners = new ArrayList();

        private OnStopCallback(LifecycleFragment lifecycleFragment) {
            super(lifecycleFragment);
            this.mLifecycleFragment.addCallback(TAG, this);
        }

        public static OnStopCallback getInstance(Activity activity) {
            LifecycleFragment fragment = getFragment(new LifecycleActivity(activity));
            OnStopCallback onStopCallback = (OnStopCallback) fragment.getCallbackOrNull(TAG, OnStopCallback.class);
            return onStopCallback == null ? new OnStopCallback(fragment) : onStopCallback;
        }

        public void addEntry(LifecycleEntry lifecycleEntry) {
            synchronized (this.listeners) {
                this.listeners.add(lifecycleEntry);
            }
        }

        public void removeEntry(LifecycleEntry lifecycleEntry) {
            synchronized (this.listeners) {
                this.listeners.remove(lifecycleEntry);
            }
        }

        @MainThread
        public void onStop() {
            ArrayList arrayList;
            synchronized (this.listeners) {
                arrayList = new ArrayList(this.listeners);
                this.listeners.clear();
            }
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                LifecycleEntry lifecycleEntry = (LifecycleEntry) it.next();
                if (lifecycleEntry != null) {
                    Log.d(TAG, "removing subscription from activity.");
                    lifecycleEntry.getRunnable().run();
                    ActivityLifecycleListener.getInstance().removeCookie(lifecycleEntry.getCookie());
                }
            }
        }
    }
}
