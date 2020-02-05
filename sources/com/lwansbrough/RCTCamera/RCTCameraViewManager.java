package com.lwansbrough.RCTCamera;

import androidx.annotation.Nullable;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.common.MapBuilder;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.ViewGroupManager;
import com.facebook.react.uimanager.annotations.ReactProp;
import java.util.ArrayList;
import java.util.Map;

public class RCTCameraViewManager extends ViewGroupManager<RCTCameraView> {
    public static final int COMMAND_START_PREVIEW = 2;
    public static final int COMMAND_STOP_PREVIEW = 1;
    private static final String REACT_CLASS = "RCTCamera";

    public String getName() {
        return REACT_CLASS;
    }

    @ReactProp(name = "captureAudio")
    public void setCaptureAudio(RCTCameraView rCTCameraView, boolean z) {
    }

    @ReactProp(name = "captureTarget")
    public void setCaptureTarget(RCTCameraView rCTCameraView, int i) {
    }

    public RCTCameraView createViewInstance(ThemedReactContext themedReactContext) {
        return new RCTCameraView(themedReactContext);
    }

    public Map<String, Integer> getCommandsMap() {
        return MapBuilder.of("stopPreview", 1, "startPreview", 2);
    }

    public void receiveCommand(RCTCameraView rCTCameraView, int i, @Nullable ReadableArray readableArray) {
        if (rCTCameraView == null) {
            throw new AssertionError();
        } else if (i == 1) {
            rCTCameraView.stopPreview();
        } else if (i == 2) {
            rCTCameraView.startPreview();
        } else {
            throw new IllegalArgumentException(String.format("Unsupported command %d received by %s.", new Object[]{Integer.valueOf(i), getClass().getSimpleName()}));
        }
    }

    @ReactProp(name = "aspect")
    public void setAspect(RCTCameraView rCTCameraView, int i) {
        rCTCameraView.setAspect(i);
    }

    @ReactProp(name = "captureMode")
    public void setCaptureMode(RCTCameraView rCTCameraView, int i) {
        rCTCameraView.setCaptureMode(i);
    }

    @ReactProp(name = "type")
    public void setType(RCTCameraView rCTCameraView, int i) {
        rCTCameraView.setCameraType(i);
    }

    @ReactProp(name = "captureQuality")
    public void setCaptureQuality(RCTCameraView rCTCameraView, String str) {
        rCTCameraView.setCaptureQuality(str);
    }

    @ReactProp(name = "torchMode")
    public void setTorchMode(RCTCameraView rCTCameraView, int i) {
        rCTCameraView.setTorchMode(i);
    }

    @ReactProp(name = "flashMode")
    public void setFlashMode(RCTCameraView rCTCameraView, int i) {
        rCTCameraView.setFlashMode(i);
    }

    @ReactProp(name = "zoom")
    public void setZoom(RCTCameraView rCTCameraView, int i) {
        rCTCameraView.setZoom(i);
    }

    @ReactProp(name = "orientation")
    public void setOrientation(RCTCameraView rCTCameraView, int i) {
        rCTCameraView.setOrientation(i);
    }

    @ReactProp(name = "barcodeScannerEnabled")
    public void setBarcodeScannerEnabled(RCTCameraView rCTCameraView, boolean z) {
        rCTCameraView.setBarcodeScannerEnabled(z);
    }

    @ReactProp(name = "barCodeTypes")
    public void setBarCodeTypes(RCTCameraView rCTCameraView, ReadableArray readableArray) {
        if (readableArray != null) {
            ArrayList arrayList = new ArrayList(readableArray.size());
            for (int i = 0; i < readableArray.size(); i++) {
                arrayList.add(readableArray.getString(i));
            }
            rCTCameraView.setBarCodeTypes(arrayList);
        }
    }

    @ReactProp(name = "clearWindowBackground")
    public void setClearWindowBackground(RCTCameraView rCTCameraView, boolean z) {
        rCTCameraView.setClearWindowBackground(z);
    }
}
