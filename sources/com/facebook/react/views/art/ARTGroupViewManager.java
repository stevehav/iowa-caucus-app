package com.facebook.react.views.art;

import com.facebook.react.module.annotations.ReactModule;

@ReactModule(name = "ARTGroup")
public class ARTGroupViewManager extends ARTRenderableViewManager {
    ARTGroupViewManager() {
        super(ARTRenderableViewManager.CLASS_GROUP);
    }
}
