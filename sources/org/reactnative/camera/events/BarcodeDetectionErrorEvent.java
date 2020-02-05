package org.reactnative.camera.events;

import androidx.core.util.Pools;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.uimanager.events.Event;
import com.facebook.react.uimanager.events.RCTEventEmitter;
import org.reactnative.barcodedetector.RNBarcodeDetector;
import org.reactnative.camera.CameraViewManager;

public class BarcodeDetectionErrorEvent extends Event<BarcodeDetectionErrorEvent> {
    private static final Pools.SynchronizedPool<BarcodeDetectionErrorEvent> EVENTS_POOL = new Pools.SynchronizedPool<>(3);
    private RNBarcodeDetector mBarcodeDetector;

    public short getCoalescingKey() {
        return 0;
    }

    private BarcodeDetectionErrorEvent() {
    }

    public static BarcodeDetectionErrorEvent obtain(int i, RNBarcodeDetector rNBarcodeDetector) {
        BarcodeDetectionErrorEvent acquire = EVENTS_POOL.acquire();
        if (acquire == null) {
            acquire = new BarcodeDetectionErrorEvent();
        }
        acquire.init(i, rNBarcodeDetector);
        return acquire;
    }

    private void init(int i, RNBarcodeDetector rNBarcodeDetector) {
        super.init(i);
        this.mBarcodeDetector = rNBarcodeDetector;
    }

    public String getEventName() {
        return CameraViewManager.Events.EVENT_ON_BARCODE_DETECTION_ERROR.toString();
    }

    public void dispatch(RCTEventEmitter rCTEventEmitter) {
        rCTEventEmitter.receiveEvent(getViewTag(), getEventName(), serializeEventData());
    }

    private WritableMap serializeEventData() {
        WritableMap createMap = Arguments.createMap();
        RNBarcodeDetector rNBarcodeDetector = this.mBarcodeDetector;
        createMap.putBoolean("isOperational", rNBarcodeDetector != null && rNBarcodeDetector.isOperational());
        return createMap;
    }
}
