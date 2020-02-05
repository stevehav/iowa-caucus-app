package com.facebook.react.fabric.mounting.mountitems;

import com.facebook.react.fabric.events.EventEmitterWrapper;
import com.facebook.react.fabric.mounting.MountingManager;

public class UpdateEventEmitterMountItem implements MountItem {
    private final EventEmitterWrapper mEventHandler;
    private final int mReactTag;

    public UpdateEventEmitterMountItem(int i, EventEmitterWrapper eventEmitterWrapper) {
        this.mReactTag = i;
        this.mEventHandler = eventEmitterWrapper;
    }

    public void execute(MountingManager mountingManager) {
        mountingManager.updateEventEmitter(this.mReactTag, this.mEventHandler);
    }

    public String toString() {
        return "UpdateEventEmitterMountItem [" + this.mReactTag + "]";
    }
}
