package com.reactnativecommunity.netinfo;

import android.os.Build;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.module.annotations.ReactModule;
import com.reactnativecommunity.netinfo.AmazonFireDeviceConnectivityPoller;

@ReactModule(name = "RNCNetInfo")
public class NetInfoModule extends ReactContextBaseJavaModule implements AmazonFireDeviceConnectivityPoller.ConnectivityChangedCallback {
    public static final String NAME = "RNCNetInfo";
    private final AmazonFireDeviceConnectivityPoller mAmazonConnectivityChecker;
    private final ConnectivityReceiver mConnectivityReceiver;

    public String getName() {
        return NAME;
    }

    public NetInfoModule(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
        if (Build.VERSION.SDK_INT >= 24) {
            this.mConnectivityReceiver = new NetworkCallbackConnectivityReceiver(reactApplicationContext);
        } else {
            this.mConnectivityReceiver = new BroadcastReceiverConnectivityReceiver(reactApplicationContext);
        }
        this.mAmazonConnectivityChecker = new AmazonFireDeviceConnectivityPoller(reactApplicationContext, this);
    }

    public void initialize() {
        this.mConnectivityReceiver.register();
        this.mAmazonConnectivityChecker.register();
    }

    public void onCatalystInstanceDestroy() {
        this.mAmazonConnectivityChecker.unregister();
        this.mConnectivityReceiver.unregister();
    }

    @ReactMethod
    public void getCurrentState(Promise promise) {
        this.mConnectivityReceiver.getCurrentState(promise);
    }

    public void onAmazonFireDeviceConnectivityChanged(boolean z) {
        this.mConnectivityReceiver.setIsInternetReachableOverride(z);
    }
}
