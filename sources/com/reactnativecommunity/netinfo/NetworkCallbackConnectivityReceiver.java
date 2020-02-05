package com.reactnativecommunity.netinfo;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.net.ConnectivityManager;
import android.net.LinkProperties;
import android.net.Network;
import android.net.NetworkCapabilities;
import com.facebook.react.bridge.ReactApplicationContext;
import com.reactnativecommunity.netinfo.types.CellularGeneration;
import com.reactnativecommunity.netinfo.types.ConnectionType;

@TargetApi(24)
class NetworkCallbackConnectivityReceiver extends ConnectivityReceiver {
    /* access modifiers changed from: private */
    public Network mNetwork = null;
    private final ConnectivityNetworkCallback mNetworkCallback = new ConnectivityNetworkCallback();
    /* access modifiers changed from: private */
    public NetworkCapabilities mNetworkCapabilities = null;

    public NetworkCallbackConnectivityReceiver(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
    }

    /* access modifiers changed from: package-private */
    @SuppressLint({"MissingPermission"})
    public void register() {
        try {
            getConnectivityManager().registerDefaultNetworkCallback(this.mNetworkCallback);
        } catch (SecurityException unused) {
        }
    }

    /* access modifiers changed from: package-private */
    public void unregister() {
        try {
            getConnectivityManager().unregisterNetworkCallback(this.mNetworkCallback);
        } catch (IllegalArgumentException | SecurityException unused) {
        }
    }

    /* access modifiers changed from: private */
    @SuppressLint({"MissingPermission"})
    public void updateAndSend() {
        ConnectionType connectionType = ConnectionType.UNKNOWN;
        NetworkCapabilities networkCapabilities = this.mNetworkCapabilities;
        boolean z = false;
        CellularGeneration cellularGeneration = null;
        if (networkCapabilities != null) {
            if (networkCapabilities.hasTransport(2)) {
                connectionType = ConnectionType.BLUETOOTH;
            } else if (this.mNetworkCapabilities.hasTransport(0)) {
                connectionType = ConnectionType.CELLULAR;
            } else if (this.mNetworkCapabilities.hasTransport(3)) {
                connectionType = ConnectionType.ETHERNET;
            } else if (this.mNetworkCapabilities.hasTransport(1)) {
                connectionType = ConnectionType.WIFI;
            } else if (this.mNetworkCapabilities.hasTransport(4)) {
                connectionType = ConnectionType.VPN;
            }
            if (this.mNetworkCapabilities.hasCapability(12) && this.mNetworkCapabilities.hasCapability(16)) {
                z = true;
            }
            if (this.mNetwork != null && connectionType == ConnectionType.CELLULAR) {
                cellularGeneration = CellularGeneration.fromNetworkInfo(getConnectivityManager().getNetworkInfo(this.mNetwork));
            }
        } else {
            connectionType = ConnectionType.NONE;
        }
        updateConnectivity(connectionType, cellularGeneration, z);
    }

    private class ConnectivityNetworkCallback extends ConnectivityManager.NetworkCallback {
        private ConnectivityNetworkCallback() {
        }

        public void onAvailable(Network network) {
            Network unused = NetworkCallbackConnectivityReceiver.this.mNetwork = network;
            NetworkCallbackConnectivityReceiver networkCallbackConnectivityReceiver = NetworkCallbackConnectivityReceiver.this;
            NetworkCapabilities unused2 = networkCallbackConnectivityReceiver.mNetworkCapabilities = networkCallbackConnectivityReceiver.getConnectivityManager().getNetworkCapabilities(network);
            NetworkCallbackConnectivityReceiver.this.updateAndSend();
        }

        public void onLosing(Network network, int i) {
            Network unused = NetworkCallbackConnectivityReceiver.this.mNetwork = network;
            NetworkCallbackConnectivityReceiver networkCallbackConnectivityReceiver = NetworkCallbackConnectivityReceiver.this;
            NetworkCapabilities unused2 = networkCallbackConnectivityReceiver.mNetworkCapabilities = networkCallbackConnectivityReceiver.getConnectivityManager().getNetworkCapabilities(network);
            NetworkCallbackConnectivityReceiver.this.updateAndSend();
        }

        public void onLost(Network network) {
            Network unused = NetworkCallbackConnectivityReceiver.this.mNetwork = null;
            NetworkCapabilities unused2 = NetworkCallbackConnectivityReceiver.this.mNetworkCapabilities = null;
            NetworkCallbackConnectivityReceiver.this.updateAndSend();
        }

        public void onUnavailable() {
            Network unused = NetworkCallbackConnectivityReceiver.this.mNetwork = null;
            NetworkCapabilities unused2 = NetworkCallbackConnectivityReceiver.this.mNetworkCapabilities = null;
            NetworkCallbackConnectivityReceiver.this.updateAndSend();
        }

        public void onCapabilitiesChanged(Network network, NetworkCapabilities networkCapabilities) {
            Network unused = NetworkCallbackConnectivityReceiver.this.mNetwork = network;
            NetworkCapabilities unused2 = NetworkCallbackConnectivityReceiver.this.mNetworkCapabilities = networkCapabilities;
            NetworkCallbackConnectivityReceiver.this.updateAndSend();
        }

        public void onLinkPropertiesChanged(Network network, LinkProperties linkProperties) {
            Network unused = NetworkCallbackConnectivityReceiver.this.mNetwork = network;
            NetworkCallbackConnectivityReceiver networkCallbackConnectivityReceiver = NetworkCallbackConnectivityReceiver.this;
            NetworkCapabilities unused2 = networkCallbackConnectivityReceiver.mNetworkCapabilities = networkCallbackConnectivityReceiver.getConnectivityManager().getNetworkCapabilities(network);
            NetworkCallbackConnectivityReceiver.this.updateAndSend();
        }
    }
}
