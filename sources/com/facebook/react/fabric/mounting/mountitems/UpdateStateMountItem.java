package com.facebook.react.fabric.mounting.mountitems;

import com.facebook.react.fabric.mounting.MountingManager;
import com.facebook.react.uimanager.StateWrapper;

public class UpdateStateMountItem implements MountItem {
    private final int mReactTag;
    private final StateWrapper mStateWrapper;

    public UpdateStateMountItem(int i, StateWrapper stateWrapper) {
        this.mReactTag = i;
        this.mStateWrapper = stateWrapper;
    }

    public void execute(MountingManager mountingManager) {
        mountingManager.updateState(this.mReactTag, this.mStateWrapper);
    }

    public String toString() {
        return "UpdateStateMountItem [" + this.mReactTag + "] - stateWrapper: " + this.mStateWrapper;
    }
}
