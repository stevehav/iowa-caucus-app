package org.reactnative.camera.events;

import androidx.core.util.Pools;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.uimanager.events.Event;
import com.facebook.react.uimanager.events.RCTEventEmitter;
import org.reactnative.camera.CameraViewManager;

public class CameraReadyEvent extends Event<CameraReadyEvent> {
    private static final Pools.SynchronizedPool<CameraReadyEvent> EVENTS_POOL = new Pools.SynchronizedPool<>(3);

    public short getCoalescingKey() {
        return 0;
    }

    private CameraReadyEvent() {
    }

    public static CameraReadyEvent obtain(int i) {
        CameraReadyEvent acquire = EVENTS_POOL.acquire();
        if (acquire == null) {
            acquire = new CameraReadyEvent();
        }
        acquire.init(i);
        return acquire;
    }

    public String getEventName() {
        return CameraViewManager.Events.EVENT_CAMERA_READY.toString();
    }

    public void dispatch(RCTEventEmitter rCTEventEmitter) {
        rCTEventEmitter.receiveEvent(getViewTag(), getEventName(), serializeEventData());
    }

    private WritableMap serializeEventData() {
        return Arguments.createMap();
    }
}
