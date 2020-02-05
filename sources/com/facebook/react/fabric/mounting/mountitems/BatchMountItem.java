package com.facebook.react.fabric.mounting.mountitems;

import com.facebook.common.logging.FLog;
import com.facebook.proguard.annotations.DoNotStrip;
import com.facebook.react.bridge.ReactMarker;
import com.facebook.react.bridge.ReactMarkerConstants;
import com.facebook.react.fabric.FabricUIManager;
import com.facebook.react.fabric.mounting.MountingManager;
import com.facebook.systrace.Systrace;

@DoNotStrip
public class BatchMountItem implements MountItem {
    private final int mCommitNumber;
    private final MountItem[] mMountItems;
    private final int mSize;

    public BatchMountItem(MountItem[] mountItemArr, int i, int i2) {
        if (mountItemArr == null) {
            throw new NullPointerException();
        } else if (i < 0 || i > mountItemArr.length) {
            throw new IllegalArgumentException("Invalid size received by parameter size: " + i + " items.size = " + mountItemArr.length);
        } else {
            this.mMountItems = mountItemArr;
            this.mSize = i;
            this.mCommitNumber = i2;
        }
    }

    public void execute(MountingManager mountingManager) {
        Systrace.beginSection(0, "FabricUIManager::mountViews - " + this.mSize + " items");
        if (this.mCommitNumber > 0) {
            ReactMarker.logFabricMarker(ReactMarkerConstants.FABRIC_BATCH_EXECUTION_START, (String) null, this.mCommitNumber);
        }
        for (int i = 0; i < this.mSize; i++) {
            MountItem mountItem = this.mMountItems[i];
            if (FabricUIManager.DEBUG) {
                String str = FabricUIManager.TAG;
                FLog.d(str, "Executing mountItem: " + mountItem);
            }
            mountItem.execute(mountingManager);
        }
        if (this.mCommitNumber > 0) {
            ReactMarker.logFabricMarker(ReactMarkerConstants.FABRIC_BATCH_EXECUTION_END, (String) null, this.mCommitNumber);
        }
        Systrace.endSection(0);
    }

    public String toString() {
        return "BatchMountItem - size " + this.mMountItems.length;
    }
}
