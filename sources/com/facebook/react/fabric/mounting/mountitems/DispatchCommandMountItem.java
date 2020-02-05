package com.facebook.react.fabric.mounting.mountitems;

import androidx.annotation.Nullable;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.fabric.mounting.MountingManager;

public class DispatchCommandMountItem implements MountItem {
    @Nullable
    private final ReadableArray mCommandArgs;
    private final int mCommandId;
    private final int mReactTag;

    public DispatchCommandMountItem(int i, int i2, @Nullable ReadableArray readableArray) {
        this.mReactTag = i;
        this.mCommandId = i2;
        this.mCommandArgs = readableArray;
    }

    public void execute(MountingManager mountingManager) {
        mountingManager.receiveCommand(this.mReactTag, this.mCommandId, this.mCommandArgs);
    }

    public String toString() {
        return "DispatchCommandMountItem [" + this.mReactTag + "] " + this.mCommandId;
    }
}
