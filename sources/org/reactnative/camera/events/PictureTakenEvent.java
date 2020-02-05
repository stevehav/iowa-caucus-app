package org.reactnative.camera.events;

import androidx.core.util.Pools;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.uimanager.events.Event;
import com.facebook.react.uimanager.events.RCTEventEmitter;
import org.reactnative.camera.CameraViewManager;

public class PictureTakenEvent extends Event<PictureTakenEvent> {
    private static final Pools.SynchronizedPool<PictureTakenEvent> EVENTS_POOL = new Pools.SynchronizedPool<>(3);

    public short getCoalescingKey() {
        return 0;
    }

    private PictureTakenEvent() {
    }

    public static PictureTakenEvent obtain(int i) {
        PictureTakenEvent acquire = EVENTS_POOL.acquire();
        if (acquire == null) {
            acquire = new PictureTakenEvent();
        }
        acquire.init(i);
        return acquire;
    }

    public String getEventName() {
        return CameraViewManager.Events.EVENT_ON_PICTURE_TAKEN.toString();
    }

    public void dispatch(RCTEventEmitter rCTEventEmitter) {
        rCTEventEmitter.receiveEvent(getViewTag(), getEventName(), serializeEventData());
    }

    private WritableMap serializeEventData() {
        return Arguments.createMap();
    }
}
