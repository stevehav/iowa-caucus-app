package com.facebook.react.fabric.mounting.mountitems;

import androidx.annotation.Nullable;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.fabric.mounting.MountingManager;

public class DispatchStringCommandMountItem implements MountItem {
    @Nullable
    private final ReadableArray mCommandArgs;
    private final String mCommandId;
    private final int mReactTag;

    public DispatchStringCommandMountItem(int i, String str, @Nullable ReadableArray readableArray) {
        this.mReactTag = i;
        this.mCommandId = str;
        this.mCommandArgs = readableArray;
    }

    public void execute(MountingManager mountingManager) {
        mountingManager.receiveCommand(this.mReactTag, this.mCommandId, this.mCommandArgs);
    }

    public String toString() {
        return "DispatchStringCommandMountItem [" + this.mReactTag + "] " + this.mCommandId;
    }
}
