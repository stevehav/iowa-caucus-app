package org.reactnative.camera.events;

import androidx.core.util.Pools;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.uimanager.events.Event;
import com.facebook.react.uimanager.events.RCTEventEmitter;
import io.sentry.marshaller.json.JsonMarshaller;
import org.reactnative.camera.CameraViewManager;

public class CameraMountErrorEvent extends Event<CameraMountErrorEvent> {
    private static final Pools.SynchronizedPool<CameraMountErrorEvent> EVENTS_POOL = new Pools.SynchronizedPool<>(3);
    private String mError;

    public short getCoalescingKey() {
        return 0;
    }

    private CameraMountErrorEvent() {
    }

    public static CameraMountErrorEvent obtain(int i, String str) {
        CameraMountErrorEvent acquire = EVENTS_POOL.acquire();
        if (acquire == null) {
            acquire = new CameraMountErrorEvent();
        }
        acquire.init(i, str);
        return acquire;
    }

    private void init(int i, String str) {
        super.init(i);
        this.mError = str;
    }

    public String getEventName() {
        return CameraViewManager.Events.EVENT_ON_MOUNT_ERROR.toString();
    }

    public void dispatch(RCTEventEmitter rCTEventEmitter) {
        rCTEventEmitter.receiveEvent(getViewTag(), getEventName(), serializeEventData());
    }

    private WritableMap serializeEventData() {
        WritableMap createMap = Arguments.createMap();
        createMap.putString(JsonMarshaller.MESSAGE, this.mError);
        return createMap;
    }
}
