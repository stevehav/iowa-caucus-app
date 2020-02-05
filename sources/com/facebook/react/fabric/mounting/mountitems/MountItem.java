package com.facebook.react.fabric.mounting.mountitems;

import androidx.annotation.UiThread;
import com.facebook.react.fabric.mounting.MountingManager;

public interface MountItem {
    @UiThread
    void execute(MountingManager mountingManager);
}
