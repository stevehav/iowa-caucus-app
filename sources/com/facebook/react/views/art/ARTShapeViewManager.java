package com.facebook.react.views.art;

import com.facebook.react.module.annotations.ReactModule;

@ReactModule(name = "ARTShape")
public class ARTShapeViewManager extends ARTRenderableViewManager {
    ARTShapeViewManager() {
        super(ARTRenderableViewManager.CLASS_SHAPE);
    }
}
