package org.reactnative.camera.events;

import androidx.core.util.Pools;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.WritableArray;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.uimanager.events.Event;
import com.facebook.react.uimanager.events.RCTEventEmitter;
import com.facebook.react.uimanager.events.TouchesHelper;
import org.reactnative.camera.CameraViewManager;

public class FacesDetectedEvent extends Event<FacesDetectedEvent> {
    private static final Pools.SynchronizedPool<FacesDetectedEvent> EVENTS_POOL = new Pools.SynchronizedPool<>(3);
    private WritableArray mData;

    private FacesDetectedEvent() {
    }

    public static FacesDetectedEvent obtain(int i, WritableArray writableArray) {
        FacesDetectedEvent acquire = EVENTS_POOL.acquire();
        if (acquire == null) {
            acquire = new FacesDetectedEvent();
        }
        acquire.init(i, writableArray);
        return acquire;
    }

    private void init(int i, WritableArray writableArray) {
        super.init(i);
        this.mData = writableArray;
    }

    public short getCoalescingKey() {
        if (this.mData.size() > 32767) {
            return Short.MAX_VALUE;
        }
        return (short) this.mData.size();
    }

    public String getEventName() {
        return CameraViewManager.Events.EVENT_ON_FACES_DETECTED.toString();
    }

    public void dispatch(RCTEventEmitter rCTEventEmitter) {
        rCTEventEmitter.receiveEvent(getViewTag(), getEventName(), serializeEventData());
    }

    private WritableMap serializeEventData() {
        WritableMap createMap = Arguments.createMap();
        createMap.putString("type", "face");
        createMap.putArray("faces", this.mData);
        createMap.putInt(TouchesHelper.TARGET_KEY, getViewTag());
        return createMap;
    }
}
