package com.google.firebase.firestore.remote;

import com.google.firebase.firestore.core.OnlineState;
import com.google.firebase.firestore.util.Assert;
import com.google.firebase.firestore.util.AsyncQueue;
import com.google.firebase.firestore.util.Logger;
import io.grpc.Status;
import java.util.Locale;

/* compiled from: com.google.firebase:firebase-firestore@@20.2.0 */
class OnlineStateTracker {
    private static final String LOG_TAG = "OnlineStateTracker";
    private static final int MAX_WATCH_STREAM_FAILURES = 1;
    private static final int ONLINE_STATE_TIMEOUT_MS = 10000;
    private final OnlineStateCallback onlineStateCallback;
    private AsyncQueue.DelayedTask onlineStateTimer;
    private boolean shouldWarnClientIsOffline = true;
    private OnlineState state = OnlineState.UNKNOWN;
    private int watchStreamFailures;
    private final AsyncQueue workerQueue;

    /* compiled from: com.google.firebase:firebase-firestore@@20.2.0 */
    interface OnlineStateCallback {
        void handleOnlineStateChange(OnlineState onlineState);
    }

    OnlineStateTracker(AsyncQueue asyncQueue, OnlineStateCallback onlineStateCallback2) {
        this.workerQueue = asyncQueue;
        this.onlineStateCallback = onlineStateCallback2;
    }

    /* access modifiers changed from: package-private */
    public void handleWatchStreamStart() {
        if (this.watchStreamFailures == 0) {
            setAndBroadcastState(OnlineState.UNKNOWN);
            Assert.hardAssert(this.onlineStateTimer == null, "onlineStateTimer shouldn't be started yet", new Object[0]);
            this.onlineStateTimer = this.workerQueue.enqueueAfterDelay(AsyncQueue.TimerId.ONLINE_STATE_TIMEOUT, 10000, OnlineStateTracker$$Lambda$1.lambdaFactory$(this));
        }
    }

    static /* synthetic */ void lambda$handleWatchStreamStart$0(OnlineStateTracker onlineStateTracker) {
        onlineStateTracker.onlineStateTimer = null;
        Assert.hardAssert(onlineStateTracker.state == OnlineState.UNKNOWN, "Timer should be canceled if we transitioned to a different state.", new Object[0]);
        onlineStateTracker.logClientOfflineWarningIfNecessary(String.format(Locale.ENGLISH, "Backend didn't respond within %d seconds\n", new Object[]{10}));
        onlineStateTracker.setAndBroadcastState(OnlineState.OFFLINE);
    }

    /* access modifiers changed from: package-private */
    public void handleWatchStreamFailure(Status status) {
        boolean z = true;
        if (this.state == OnlineState.ONLINE) {
            setAndBroadcastState(OnlineState.UNKNOWN);
            Assert.hardAssert(this.watchStreamFailures == 0, "watchStreamFailures must be 0", new Object[0]);
            if (this.onlineStateTimer != null) {
                z = false;
            }
            Assert.hardAssert(z, "onlineStateTimer must be null", new Object[0]);
            return;
        }
        this.watchStreamFailures++;
        if (this.watchStreamFailures >= 1) {
            clearOnlineStateTimer();
            logClientOfflineWarningIfNecessary(String.format(Locale.ENGLISH, "Connection failed %d times. Most recent error: %s", new Object[]{1, status}));
            setAndBroadcastState(OnlineState.OFFLINE);
        }
    }

    /* access modifiers changed from: package-private */
    public void updateState(OnlineState onlineState) {
        clearOnlineStateTimer();
        this.watchStreamFailures = 0;
        if (onlineState == OnlineState.ONLINE) {
            this.shouldWarnClientIsOffline = false;
        }
        setAndBroadcastState(onlineState);
    }

    private void setAndBroadcastState(OnlineState onlineState) {
        if (onlineState != this.state) {
            this.state = onlineState;
            this.onlineStateCallback.handleOnlineStateChange(onlineState);
        }
    }

    private void logClientOfflineWarningIfNecessary(String str) {
        String format = String.format("Could not reach Cloud Firestore backend. %s\nThis typically indicates that your device does not have a healthy Internet connection at the moment. The client will operate in offline mode until it is able to successfully connect to the backend.", new Object[]{str});
        if (this.shouldWarnClientIsOffline) {
            Logger.warn(LOG_TAG, "%s", format);
            this.shouldWarnClientIsOffline = false;
            return;
        }
        Logger.debug(LOG_TAG, "%s", format);
    }

    private void clearOnlineStateTimer() {
        AsyncQueue.DelayedTask delayedTask = this.onlineStateTimer;
        if (delayedTask != null) {
            delayedTask.cancel();
            this.onlineStateTimer = null;
        }
    }
}
