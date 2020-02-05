package com.google.android.cameraview;

import android.graphics.SurfaceTexture;
import android.media.CamcorderProfile;
import android.os.Handler;
import android.view.View;
import com.facebook.react.bridge.ReadableMap;
import java.util.List;
import java.util.Properties;
import java.util.Set;
import java.util.SortedSet;

abstract class CameraViewImpl {
    protected final Handler mBgHandler;
    protected final Callback mCallback;
    protected final PreviewImpl mPreview;

    interface Callback {
        void onCameraClosed();

        void onCameraOpened();

        void onFramePreview(byte[] bArr, int i, int i2, int i3);

        void onMountError();

        void onPictureTaken(byte[] bArr, int i);

        void onVideoRecorded(String str, int i, int i2);
    }

    /* access modifiers changed from: package-private */
    public abstract AspectRatio getAspectRatio();

    /* access modifiers changed from: package-private */
    public abstract boolean getAutoFocus();

    /* access modifiers changed from: package-private */
    public abstract SortedSet<Size> getAvailablePictureSizes(AspectRatio aspectRatio);

    /* access modifiers changed from: package-private */
    public abstract String getCameraId();

    /* access modifiers changed from: package-private */
    public abstract List<Properties> getCameraIds();

    /* access modifiers changed from: package-private */
    public abstract int getCameraOrientation();

    /* access modifiers changed from: package-private */
    public abstract float getExposureCompensation();

    /* access modifiers changed from: package-private */
    public abstract int getFacing();

    /* access modifiers changed from: package-private */
    public abstract int getFlash();

    /* access modifiers changed from: package-private */
    public abstract float getFocusDepth();

    /* access modifiers changed from: package-private */
    public abstract Size getPictureSize();

    public abstract Size getPreviewSize();

    /* access modifiers changed from: package-private */
    public abstract boolean getScanning();

    /* access modifiers changed from: package-private */
    public abstract Set<AspectRatio> getSupportedAspectRatios();

    /* access modifiers changed from: package-private */
    public abstract int getWhiteBalance();

    /* access modifiers changed from: package-private */
    public abstract float getZoom();

    /* access modifiers changed from: package-private */
    public abstract boolean isCameraOpened();

    public abstract void pausePreview();

    /* access modifiers changed from: package-private */
    public abstract boolean record(String str, int i, int i2, boolean z, CamcorderProfile camcorderProfile, int i3);

    public abstract void resumePreview();

    /* access modifiers changed from: package-private */
    public abstract boolean setAspectRatio(AspectRatio aspectRatio);

    /* access modifiers changed from: package-private */
    public abstract void setAutoFocus(boolean z);

    /* access modifiers changed from: package-private */
    public abstract void setCameraId(String str);

    /* access modifiers changed from: package-private */
    public abstract void setDeviceOrientation(int i);

    /* access modifiers changed from: package-private */
    public abstract void setDisplayOrientation(int i);

    /* access modifiers changed from: package-private */
    public abstract void setExposureCompensation(float f);

    /* access modifiers changed from: package-private */
    public abstract void setFacing(int i);

    /* access modifiers changed from: package-private */
    public abstract void setFlash(int i);

    /* access modifiers changed from: package-private */
    public abstract void setFocusArea(float f, float f2);

    /* access modifiers changed from: package-private */
    public abstract void setFocusDepth(float f);

    /* access modifiers changed from: package-private */
    public abstract void setPictureSize(Size size);

    public abstract void setPreviewTexture(SurfaceTexture surfaceTexture);

    /* access modifiers changed from: package-private */
    public abstract void setScanning(boolean z);

    /* access modifiers changed from: package-private */
    public abstract void setWhiteBalance(int i);

    /* access modifiers changed from: package-private */
    public abstract void setZoom(float f);

    /* access modifiers changed from: package-private */
    public abstract boolean start();

    /* access modifiers changed from: package-private */
    public abstract void stop();

    /* access modifiers changed from: package-private */
    public abstract void stopRecording();

    /* access modifiers changed from: package-private */
    public abstract void takePicture(ReadableMap readableMap);

    CameraViewImpl(Callback callback, PreviewImpl previewImpl, Handler handler) {
        this.mCallback = callback;
        this.mPreview = previewImpl;
        this.mBgHandler = handler;
    }

    /* access modifiers changed from: package-private */
    public View getView() {
        return this.mPreview.getView();
    }
}
