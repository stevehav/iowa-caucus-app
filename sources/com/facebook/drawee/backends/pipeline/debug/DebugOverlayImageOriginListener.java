package com.facebook.drawee.backends.pipeline.debug;

import com.facebook.drawee.backends.pipeline.info.ImageOriginListener;
import com.facebook.drawee.backends.pipeline.info.ImageOriginUtils;

public class DebugOverlayImageOriginListener implements ImageOriginListener {
    private int mImageOrigin = 1;

    public void onImageLoaded(String str, int i, boolean z, String str2) {
        this.mImageOrigin = i;
    }

    public String getImageOrigin() {
        return ImageOriginUtils.toString(this.mImageOrigin);
    }
}
