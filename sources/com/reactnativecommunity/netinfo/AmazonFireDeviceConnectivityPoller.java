package com.reactnativecommunity.netinfo;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build;
import android.os.Handler;

public class AmazonFireDeviceConnectivityPoller {
    private static final String ACTION_CONNECTIVITY_CHECK = "com.amazon.tv.networkmonitor.CONNECTIVITY_CHECK";
    private static final String ACTION_INTERNET_DOWN = "com.amazon.tv.networkmonitor.INTERNET_DOWN";
    private static final String ACTION_INTERNET_UP = "com.amazon.tv.networkmonitor.INTERNET_UP";
    private static final long POLLING_INTERVAL_MS = 10000;
    /* access modifiers changed from: private */
    public final ConnectivityChangedCallback callback;
    /* access modifiers changed from: private */
    public final Runnable checker = new PollerTask();
    /* access modifiers changed from: private */
    public final Context context;
    /* access modifiers changed from: private */
    public Handler handler;
    /* access modifiers changed from: private */
    public boolean pollerRunning = false;
    private final Receiver receiver = new Receiver();

    public interface ConnectivityChangedCallback {
        void onAmazonFireDeviceConnectivityChanged(boolean z);
    }

    AmazonFireDeviceConnectivityPoller(Context context2, ConnectivityChangedCallback connectivityChangedCallback) {
        this.context = context2;
        this.callback = connectivityChangedCallback;
    }

    public void register() {
        if (isFireOsDevice()) {
            registerReceiver();
            startPoller();
        }
    }

    public void unregister() {
        if (isFireOsDevice()) {
            stopPoller();
            unregisterReceiver();
        }
    }

    private boolean isFireOsDevice() {
        return Build.MANUFACTURER.equals("Amazon") && (Build.MODEL.startsWith("AF") || Build.MODEL.startsWith("KF"));
    }

    private void registerReceiver() {
        if (!this.receiver.registered) {
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction(ACTION_INTERNET_DOWN);
            intentFilter.addAction(ACTION_INTERNET_UP);
            this.context.registerReceiver(this.receiver, intentFilter);
            this.receiver.registered = true;
        }
    }

    private void startPoller() {
        if (!this.pollerRunning) {
            this.handler = new Handler();
            this.pollerRunning = true;
            this.handler.post(this.checker);
        }
    }

    private void unregisterReceiver() {
        if (this.receiver.registered) {
            this.context.unregisterReceiver(this.receiver);
            this.receiver.registered = false;
        }
    }

    private void stopPoller() {
        if (this.pollerRunning) {
            this.pollerRunning = false;
            this.handler.removeCallbacksAndMessages((Object) null);
            this.handler = null;
        }
    }

    private class Receiver extends BroadcastReceiver {
        private Boolean lastIsConnected;
        boolean registered;

        private Receiver() {
            this.registered = false;
        }

        public void onReceive(Context context, Intent intent) {
            boolean z;
            String action = intent == null ? null : intent.getAction();
            if (AmazonFireDeviceConnectivityPoller.ACTION_INTERNET_DOWN.equals(action)) {
                z = false;
            } else if (AmazonFireDeviceConnectivityPoller.ACTION_INTERNET_UP.equals(action)) {
                z = true;
            } else {
                return;
            }
            Boolean bool = this.lastIsConnected;
            if (bool == null || bool.booleanValue() != z) {
                this.lastIsConnected = Boolean.valueOf(z);
                AmazonFireDeviceConnectivityPoller.this.callback.onAmazonFireDeviceConnectivityChanged(z);
            }
        }
    }

    private class PollerTask implements Runnable {
        private PollerTask() {
        }

        public void run() {
            if (AmazonFireDeviceConnectivityPoller.this.pollerRunning) {
                AmazonFireDeviceConnectivityPoller.this.context.sendBroadcast(new Intent(AmazonFireDeviceConnectivityPoller.ACTION_CONNECTIVITY_CHECK));
                AmazonFireDeviceConnectivityPoller.this.handler.postDelayed(AmazonFireDeviceConnectivityPoller.this.checker, AmazonFireDeviceConnectivityPoller.POLLING_INTERVAL_MS);
            }
        }
    }
}
