package com.facebook.drawee.backends.pipeline.info;

import java.util.Collection;

public class ForwardingImagePerfDataListener implements ImagePerfDataListener {
    private final Collection<ImagePerfDataListener> mListeners;

    public ForwardingImagePerfDataListener(Collection<ImagePerfDataListener> collection) {
        this.mListeners = collection;
    }

    public void onImageLoadStatusUpdated(ImagePerfData imagePerfData, int i) {
        for (ImagePerfDataListener onImageLoadStatusUpdated : this.mListeners) {
            onImageLoadStatusUpdated.onImageLoadStatusUpdated(imagePerfData, i);
        }
    }

    public void onImageVisibilityUpdated(ImagePerfData imagePerfData, int i) {
        for (ImagePerfDataListener onImageVisibilityUpdated : this.mListeners) {
            onImageVisibilityUpdated.onImageVisibilityUpdated(imagePerfData, i);
        }
    }
}
