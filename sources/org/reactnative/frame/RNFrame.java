package org.reactnative.frame;

import com.google.android.gms.vision.Frame;
import org.reactnative.camera.utils.ImageDimensions;

public class RNFrame {
    private ImageDimensions mDimensions;
    private Frame mFrame;

    public RNFrame(Frame frame, ImageDimensions imageDimensions) {
        this.mFrame = frame;
        this.mDimensions = imageDimensions;
    }

    public Frame getFrame() {
        return this.mFrame;
    }

    public ImageDimensions getDimensions() {
        return this.mDimensions;
    }
}
