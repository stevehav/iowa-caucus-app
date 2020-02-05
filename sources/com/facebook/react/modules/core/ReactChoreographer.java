package com.facebook.react.modules.core;

import androidx.annotation.GuardedBy;
import androidx.annotation.Nullable;
import com.facebook.common.logging.FLog;
import com.facebook.infer.annotation.Assertions;
import com.facebook.react.bridge.UiThreadUtil;
import com.facebook.react.common.ReactConstants;
import com.facebook.react.modules.core.ChoreographerCompat;
import java.util.ArrayDeque;

public class ReactChoreographer {
    private static ReactChoreographer sInstance;
    /* access modifiers changed from: private */
    @GuardedBy("mCallbackQueuesLock")
    public final ArrayDeque<ChoreographerCompat.FrameCallback>[] mCallbackQueues;
    /* access modifiers changed from: private */
    public final Object mCallbackQueuesLock = new Object();
    /* access modifiers changed from: private */
    @Nullable
    public volatile ChoreographerCompat mChoreographer;
    /* access modifiers changed from: private */
    public boolean mHasPostedCallback;
    private final ReactChoreographerDispatcher mReactChoreographerDispatcher;
    private int mTotalCallbacks;

    static /* synthetic */ int access$610(ReactChoreographer reactChoreographer) {
        int i = reactChoreographer.mTotalCallbacks;
        reactChoreographer.mTotalCallbacks = i - 1;
        return i;
    }

    public enum CallbackType {
        PERF_MARKERS(0),
        DISPATCH_UI(1),
        NATIVE_ANIMATED_MODULE(2),
        TIMERS_EVENTS(3),
        IDLE_EVENT(4);
        
        private final int mOrder;

        private CallbackType(int i) {
            this.mOrder = i;
        }

        /* access modifiers changed from: package-private */
        public int getOrder() {
            return this.mOrder;
        }
    }

    public static void initialize() {
        if (sInstance == null) {
            sInstance = new ReactChoreographer();
        }
    }

    public static ReactChoreographer getInstance() {
        Assertions.assertNotNull(sInstance, "ReactChoreographer needs to be initialized.");
        return sInstance;
    }

    private ReactChoreographer() {
        int i = 0;
        this.mTotalCallbacks = 0;
        this.mHasPostedCallback = false;
        this.mReactChoreographerDispatcher = new ReactChoreographerDispatcher();
        this.mCallbackQueues = new ArrayDeque[CallbackType.values().length];
        while (true) {
            ArrayDeque<ChoreographerCompat.FrameCallback>[] arrayDequeArr = this.mCallbackQueues;
            if (i < arrayDequeArr.length) {
                arrayDequeArr[i] = new ArrayDeque<>();
                i++;
            } else {
                initializeChoreographer((Runnable) null);
                return;
            }
        }
    }

    public void postFrameCallback(CallbackType callbackType, ChoreographerCompat.FrameCallback frameCallback) {
        synchronized (this.mCallbackQueuesLock) {
            this.mCallbackQueues[callbackType.getOrder()].addLast(frameCallback);
            boolean z = true;
            this.mTotalCallbacks++;
            if (this.mTotalCallbacks <= 0) {
                z = false;
            }
            Assertions.assertCondition(z);
            if (!this.mHasPostedCallback) {
                if (this.mChoreographer == null) {
                    initializeChoreographer(new Runnable() {
                        public void run() {
                            ReactChoreographer.this.postFrameCallbackOnChoreographer();
                        }
                    });
                } else {
                    postFrameCallbackOnChoreographer();
                }
            }
        }
    }

    /* access modifiers changed from: private */
    public void postFrameCallbackOnChoreographer() {
        this.mChoreographer.postFrameCallback(this.mReactChoreographerDispatcher);
        this.mHasPostedCallback = true;
    }

    public void initializeChoreographer(@Nullable final Runnable runnable) {
        UiThreadUtil.runOnUiThread(new Runnable() {
            public void run() {
                synchronized (ReactChoreographer.class) {
                    if (ReactChoreographer.this.mChoreographer == null) {
                        ChoreographerCompat unused = ReactChoreographer.this.mChoreographer = ChoreographerCompat.getInstance();
                    }
                }
                Runnable runnable = runnable;
                if (runnable != null) {
                    runnable.run();
                }
            }
        });
    }

    public void removeFrameCallback(CallbackType callbackType, ChoreographerCompat.FrameCallback frameCallback) {
        synchronized (this.mCallbackQueuesLock) {
            if (this.mCallbackQueues[callbackType.getOrder()].removeFirstOccurrence(frameCallback)) {
                this.mTotalCallbacks--;
                maybeRemoveFrameCallback();
            } else {
                FLog.e(ReactConstants.TAG, "Tried to remove non-existent frame callback");
            }
        }
    }

    /* access modifiers changed from: private */
    public void maybeRemoveFrameCallback() {
        Assertions.assertCondition(this.mTotalCallbacks >= 0);
        if (this.mTotalCallbacks == 0 && this.mHasPostedCallback) {
            if (this.mChoreographer != null) {
                this.mChoreographer.removeFrameCallback(this.mReactChoreographerDispatcher);
            }
            this.mHasPostedCallback = false;
        }
    }

    private class ReactChoreographerDispatcher extends ChoreographerCompat.FrameCallback {
        private ReactChoreographerDispatcher() {
        }

        public void doFrame(long j) {
            synchronized (ReactChoreographer.this.mCallbackQueuesLock) {
                boolean unused = ReactChoreographer.this.mHasPostedCallback = false;
                for (ArrayDeque arrayDeque : ReactChoreographer.this.mCallbackQueues) {
                    int size = arrayDeque.size();
                    for (int i = 0; i < size; i++) {
                        ChoreographerCompat.FrameCallback frameCallback = (ChoreographerCompat.FrameCallback) arrayDeque.pollFirst();
                        if (frameCallback != null) {
                            frameCallback.doFrame(j);
                            ReactChoreographer.access$610(ReactChoreographer.this);
                        } else {
                            FLog.e(ReactConstants.TAG, "Tried to execute non-existent frame callback");
                        }
                    }
                }
                ReactChoreographer.this.maybeRemoveFrameCallback();
            }
        }
    }
}
