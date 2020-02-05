package com.google.android.cameraview;

import android.annotation.SuppressLint;
import android.graphics.Rect;
import android.graphics.SurfaceTexture;
import android.hardware.Camera;
import android.media.CamcorderProfile;
import android.media.MediaRecorder;
import android.os.Build;
import android.os.Handler;
import android.util.Log;
import android.view.SurfaceHolder;
import androidx.collection.SparseArrayCompat;
import androidx.core.app.NotificationManagerCompat;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.uimanager.ViewProps;
import com.google.android.cameraview.CameraViewImpl;
import com.google.android.cameraview.PreviewImpl;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.Properties;
import java.util.Set;
import java.util.SortedSet;
import java.util.concurrent.atomic.AtomicBoolean;

class Camera1 extends CameraViewImpl implements MediaRecorder.OnInfoListener, MediaRecorder.OnErrorListener, Camera.PreviewCallback {
    private static final int DELAY_MILLIS_BEFORE_RESETTING_FOCUS = 3000;
    private static final SparseArrayCompat<String> FLASH_MODES = new SparseArrayCompat<>();
    private static final int FOCUS_AREA_SIZE_DEFAULT = 300;
    private static final int FOCUS_METERING_AREA_WEIGHT_DEFAULT = 1000;
    private static final int INVALID_CAMERA_ID = -1;
    private static final SparseArrayCompat<String> WB_MODES = new SparseArrayCompat<>();
    private String _mCameraId;
    /* access modifiers changed from: private */
    public final AtomicBoolean isPictureCaptureInProgress = new AtomicBoolean(false);
    private AspectRatio mAspectRatio;
    private boolean mAutoFocus;
    Camera mCamera;
    private int mCameraId;
    private final Camera.CameraInfo mCameraInfo = new Camera.CameraInfo();
    private Camera.Parameters mCameraParameters;
    /* access modifiers changed from: private */
    public int mDeviceOrientation;
    private int mDisplayOrientation;
    private float mExposure;
    private int mFacing;
    private int mFlash;
    private Handler mHandler = new Handler();
    /* access modifiers changed from: private */
    public boolean mIsPreviewActive = false;
    private final AtomicBoolean mIsRecording = new AtomicBoolean(false);
    /* access modifiers changed from: private */
    public boolean mIsScanning;
    private MediaRecorder mMediaRecorder;
    /* access modifiers changed from: private */
    public int mOrientation = 0;
    private Size mPictureSize;
    private final SizeMap mPictureSizes = new SizeMap();
    private final SizeMap mPreviewSizes = new SizeMap();
    /* access modifiers changed from: private */
    public SurfaceTexture mPreviewTexture;
    /* access modifiers changed from: private */
    public boolean mShowingPreview = true;
    private String mVideoPath;
    private int mWhiteBalance;
    private float mZoom;
    /* access modifiers changed from: private */
    public boolean mustUpdateSurface;

    private boolean isLandscape(int i) {
        return i == 90 || i == 270;
    }

    /* access modifiers changed from: package-private */
    public int displayOrientationToOrientationEnum(int i) {
        if (i == 0) {
            return 1;
        }
        if (i == 90) {
            return 4;
        }
        if (i != 180) {
            return i != 270 ? 1 : 3;
        }
        return 2;
    }

    /* access modifiers changed from: package-private */
    public float getFocusDepth() {
        return 0.0f;
    }

    /* access modifiers changed from: package-private */
    public int orientationEnumToRotation(int i) {
        if (i == 1) {
            return 0;
        }
        if (i == 2) {
            return 180;
        }
        if (i != 3) {
            return i != 4 ? 1 : 90;
        }
        return 270;
    }

    public void setFocusDepth(float f) {
    }

    static {
        FLASH_MODES.put(0, "off");
        FLASH_MODES.put(1, ViewProps.ON);
        FLASH_MODES.put(2, "torch");
        FLASH_MODES.put(3, "auto");
        FLASH_MODES.put(4, "red-eye");
        WB_MODES.put(0, "auto");
        WB_MODES.put(1, "cloudy-daylight");
        WB_MODES.put(2, "daylight");
        WB_MODES.put(3, "shade");
        WB_MODES.put(4, "fluorescent");
        WB_MODES.put(5, "incandescent");
    }

    Camera1(CameraViewImpl.Callback callback, PreviewImpl previewImpl, Handler handler) {
        super(callback, previewImpl, handler);
        previewImpl.setCallback(new PreviewImpl.Callback() {
            public void onSurfaceChanged() {
                Camera1.this.updateSurface();
            }

            public void onSurfaceDestroyed() {
                Camera1.this.stop();
            }
        });
    }

    /* access modifiers changed from: private */
    public void updateSurface() {
        if (this.mCamera == null) {
            return;
        }
        if (this.isPictureCaptureInProgress.get() || this.mIsRecording.get()) {
            this.mustUpdateSurface = true;
        } else {
            this.mBgHandler.post(new Runnable() {
                public void run() {
                    synchronized (Camera1.this) {
                        if (Camera1.this.mCamera != null) {
                            boolean unused = Camera1.this.mustUpdateSurface = false;
                            Camera1.this.setUpPreview();
                            Camera1.this.adjustCameraParameters();
                            if (Camera1.this.mShowingPreview) {
                                Camera1.this.startCameraPreview();
                            }
                        }
                    }
                }
            });
        }
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0025, code lost:
        return true;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean start() {
        /*
            r2 = this;
            monitor-enter(r2)
            r2.chooseCamera()     // Catch:{ all -> 0x0026 }
            boolean r0 = r2.openCamera()     // Catch:{ all -> 0x0026 }
            r1 = 1
            if (r0 != 0) goto L_0x0012
            com.google.android.cameraview.CameraViewImpl$Callback r0 = r2.mCallback     // Catch:{ all -> 0x0026 }
            r0.onMountError()     // Catch:{ all -> 0x0026 }
            monitor-exit(r2)     // Catch:{ all -> 0x0026 }
            return r1
        L_0x0012:
            com.google.android.cameraview.PreviewImpl r0 = r2.mPreview     // Catch:{ all -> 0x0026 }
            boolean r0 = r0.isReady()     // Catch:{ all -> 0x0026 }
            if (r0 == 0) goto L_0x0024
            r2.setUpPreview()     // Catch:{ all -> 0x0026 }
            boolean r0 = r2.mShowingPreview     // Catch:{ all -> 0x0026 }
            if (r0 == 0) goto L_0x0024
            r2.startCameraPreview()     // Catch:{ all -> 0x0026 }
        L_0x0024:
            monitor-exit(r2)     // Catch:{ all -> 0x0026 }
            return r1
        L_0x0026:
            r0 = move-exception
            monitor-exit(r2)     // Catch:{ all -> 0x0026 }
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.cameraview.Camera1.start():boolean");
    }

    /* access modifiers changed from: package-private */
    public void stop() {
        synchronized (this) {
            if (this.mMediaRecorder != null) {
                try {
                    this.mMediaRecorder.stop();
                } catch (RuntimeException e) {
                    Log.e("CAMERA_1::", "mMediaRecorder.stop() failed", e);
                }
                try {
                    this.mMediaRecorder.reset();
                    this.mMediaRecorder.release();
                } catch (RuntimeException e2) {
                    Log.e("CAMERA_1::", "mMediaRecorder.release() failed", e2);
                }
                this.mMediaRecorder = null;
                if (this.mIsRecording.get()) {
                    int displayOrientationToOrientationEnum = displayOrientationToOrientationEnum(this.mDeviceOrientation);
                    this.mCallback.onVideoRecorded(this.mVideoPath, this.mOrientation != 0 ? this.mOrientation : displayOrientationToOrientationEnum, displayOrientationToOrientationEnum);
                }
            }
            if (this.mCamera != null) {
                this.mIsPreviewActive = false;
                this.mCamera.stopPreview();
                this.mCamera.setPreviewCallback((Camera.PreviewCallback) null);
            }
            releaseCamera();
        }
        return;
    }

    /* access modifiers changed from: package-private */
    @SuppressLint({"NewApi"})
    public void setUpPreview() {
        try {
            if (this.mCamera == null) {
                return;
            }
            if (this.mPreviewTexture != null) {
                this.mCamera.setPreviewTexture(this.mPreviewTexture);
            } else if (this.mPreview.getOutputClass() == SurfaceHolder.class) {
                boolean z = this.mIsPreviewActive && Build.VERSION.SDK_INT < 14;
                if (z) {
                    this.mCamera.stopPreview();
                    this.mIsPreviewActive = false;
                }
                this.mCamera.setPreviewDisplay(this.mPreview.getSurfaceHolder());
                if (z) {
                    startCameraPreview();
                }
            } else {
                this.mCamera.setPreviewTexture((SurfaceTexture) this.mPreview.getSurfaceTexture());
            }
        } catch (Exception e) {
            Log.e("CAMERA_1::", "setUpPreview failed", e);
        }
    }

    /* access modifiers changed from: private */
    public void startCameraPreview() {
        Camera camera;
        if (!this.mIsPreviewActive && (camera = this.mCamera) != null) {
            try {
                this.mIsPreviewActive = true;
                camera.startPreview();
                if (this.mIsScanning) {
                    this.mCamera.setPreviewCallback(this);
                }
            } catch (Exception e) {
                this.mIsPreviewActive = false;
                Log.e("CAMERA_1::", "startCameraPreview failed", e);
            }
        }
    }

    public void resumePreview() {
        this.mBgHandler.post(new Runnable() {
            public void run() {
                synchronized (this) {
                    boolean unused = Camera1.this.mShowingPreview = true;
                    Camera1.this.startCameraPreview();
                }
            }
        });
    }

    public void pausePreview() {
        synchronized (this) {
            this.mIsPreviewActive = false;
            this.mShowingPreview = false;
            if (this.mCamera != null) {
                this.mCamera.stopPreview();
            }
        }
    }

    /* access modifiers changed from: package-private */
    public boolean isCameraOpened() {
        return this.mCamera != null;
    }

    /* access modifiers changed from: package-private */
    public void setFacing(int i) {
        if (this.mFacing != i) {
            this.mFacing = i;
            this.mBgHandler.post(new Runnable() {
                public void run() {
                    if (Camera1.this.isCameraOpened()) {
                        Camera1.this.stop();
                        Camera1.this.start();
                    }
                }
            });
        }
    }

    /* access modifiers changed from: package-private */
    public int getFacing() {
        return this.mFacing;
    }

    /* access modifiers changed from: package-private */
    public void setCameraId(String str) {
        if (!Objects.equals(this._mCameraId, str)) {
            this._mCameraId = str;
            if (!Objects.equals(this._mCameraId, String.valueOf(this.mCameraId))) {
                this.mBgHandler.post(new Runnable() {
                    public void run() {
                        if (Camera1.this.isCameraOpened()) {
                            Camera1.this.stop();
                            Camera1.this.start();
                        }
                    }
                });
            }
        }
    }

    /* access modifiers changed from: package-private */
    public String getCameraId() {
        return this._mCameraId;
    }

    /* access modifiers changed from: package-private */
    public Set<AspectRatio> getSupportedAspectRatios() {
        SizeMap sizeMap = this.mPreviewSizes;
        for (AspectRatio next : sizeMap.ratios()) {
            if (this.mPictureSizes.sizes(next) == null) {
                sizeMap.remove(next);
            }
        }
        return sizeMap.ratios();
    }

    /* access modifiers changed from: package-private */
    public List<Properties> getCameraIds() {
        ArrayList arrayList = new ArrayList();
        Camera.CameraInfo cameraInfo = new Camera.CameraInfo();
        int numberOfCameras = Camera.getNumberOfCameras();
        for (int i = 0; i < numberOfCameras; i++) {
            Properties properties = new Properties();
            Camera.getCameraInfo(i, cameraInfo);
            properties.put("id", String.valueOf(i));
            properties.put("type", String.valueOf(cameraInfo.facing));
            arrayList.add(properties);
        }
        return arrayList;
    }

    /* access modifiers changed from: package-private */
    public SortedSet<Size> getAvailablePictureSizes(AspectRatio aspectRatio) {
        return this.mPictureSizes.sizes(aspectRatio);
    }

    /* access modifiers changed from: package-private */
    public void setPictureSize(Size size) {
        if (size == null) {
            AspectRatio aspectRatio = this.mAspectRatio;
            if (aspectRatio != null) {
                SortedSet<Size> sizes = this.mPictureSizes.sizes(aspectRatio);
                if (sizes != null && !sizes.isEmpty()) {
                    this.mPictureSize = sizes.last();
                }
            } else {
                return;
            }
        } else {
            this.mPictureSize = size;
        }
        synchronized (this) {
            if (!(this.mCameraParameters == null || this.mCamera == null)) {
                this.mCameraParameters.setPictureSize(this.mPictureSize.getWidth(), this.mPictureSize.getHeight());
                try {
                    this.mCamera.setParameters(this.mCameraParameters);
                } catch (RuntimeException e) {
                    Log.e("CAMERA_1::", "setParameters failed", e);
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    public Size getPictureSize() {
        return this.mPictureSize;
    }

    /* access modifiers changed from: package-private */
    public boolean setAspectRatio(AspectRatio aspectRatio) {
        if (this.mAspectRatio == null || !isCameraOpened()) {
            this.mAspectRatio = aspectRatio;
            return true;
        } else if (this.mAspectRatio.equals(aspectRatio) || this.mPreviewSizes.sizes(aspectRatio) == null) {
            return false;
        } else {
            this.mAspectRatio = aspectRatio;
            this.mBgHandler.post(new Runnable() {
                public void run() {
                    synchronized (Camera1.this) {
                        if (Camera1.this.mCamera != null) {
                            Camera1.this.adjustCameraParameters();
                        }
                    }
                }
            });
            return true;
        }
    }

    /* access modifiers changed from: package-private */
    public AspectRatio getAspectRatio() {
        return this.mAspectRatio;
    }

    /* access modifiers changed from: package-private */
    public void setAutoFocus(boolean z) {
        if (this.mAutoFocus != z) {
            synchronized (this) {
                if (setAutoFocusInternal(z)) {
                    try {
                        if (this.mCamera != null) {
                            this.mCamera.setParameters(this.mCameraParameters);
                        }
                    } catch (RuntimeException e) {
                        Log.e("CAMERA_1::", "setParameters failed", e);
                    }
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    public boolean getAutoFocus() {
        if (!isCameraOpened()) {
            return this.mAutoFocus;
        }
        String focusMode = this.mCameraParameters.getFocusMode();
        return focusMode != null && focusMode.contains("continuous");
    }

    /* access modifiers changed from: package-private */
    public void setFlash(int i) {
        if (i != this.mFlash && setFlashInternal(i)) {
            try {
                if (this.mCamera != null) {
                    this.mCamera.setParameters(this.mCameraParameters);
                }
            } catch (RuntimeException e) {
                Log.e("CAMERA_1::", "setParameters failed", e);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public int getFlash() {
        return this.mFlash;
    }

    /* access modifiers changed from: package-private */
    public float getExposureCompensation() {
        return this.mExposure;
    }

    /* access modifiers changed from: package-private */
    public void setExposureCompensation(float f) {
        if (f != this.mExposure && setExposureInternal(f)) {
            try {
                if (this.mCamera != null) {
                    this.mCamera.setParameters(this.mCameraParameters);
                }
            } catch (RuntimeException e) {
                Log.e("CAMERA_1::", "setParameters failed", e);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void setZoom(float f) {
        if (f != this.mZoom && setZoomInternal(f)) {
            try {
                if (this.mCamera != null) {
                    this.mCamera.setParameters(this.mCameraParameters);
                }
            } catch (RuntimeException e) {
                Log.e("CAMERA_1::", "setParameters failed", e);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public float getZoom() {
        return this.mZoom;
    }

    public void setWhiteBalance(int i) {
        if (i != this.mWhiteBalance && setWhiteBalanceInternal(i)) {
            try {
                if (this.mCamera != null) {
                    this.mCamera.setParameters(this.mCameraParameters);
                }
            } catch (RuntimeException e) {
                Log.e("CAMERA_1::", "setParameters failed", e);
            }
        }
    }

    public int getWhiteBalance() {
        return this.mWhiteBalance;
    }

    /* access modifiers changed from: package-private */
    public void setScanning(boolean z) {
        if (z != this.mIsScanning) {
            setScanningInternal(z);
        }
    }

    /* access modifiers changed from: package-private */
    public boolean getScanning() {
        return this.mIsScanning;
    }

    /* access modifiers changed from: package-private */
    public void takePicture(ReadableMap readableMap) {
        if (!isCameraOpened()) {
            throw new IllegalStateException("Camera is not ready. Call start() before takePicture().");
        } else if (this.mIsPreviewActive) {
            takePictureInternal(readableMap);
        } else {
            throw new IllegalStateException("Preview is paused - resume it before taking a picture.");
        }
    }

    /* access modifiers changed from: package-private */
    public void takePictureInternal(final ReadableMap readableMap) {
        if (this.mIsRecording.get() || !this.isPictureCaptureInProgress.compareAndSet(false, true)) {
            throw new IllegalStateException("Camera capture failed. Camera is already capturing.");
        }
        try {
            if (readableMap.hasKey("orientation")) {
                if (readableMap.getInt("orientation") != 0) {
                    this.mOrientation = readableMap.getInt("orientation");
                    this.mCameraParameters.setRotation(calcCameraRotation(orientationEnumToRotation(this.mOrientation)));
                    try {
                        this.mCamera.setParameters(this.mCameraParameters);
                    } catch (RuntimeException e) {
                        Log.e("CAMERA_1::", "setParameters rotation failed", e);
                    }
                }
            }
            if (readableMap.hasKey("quality")) {
                this.mCameraParameters.setJpegQuality((int) (readableMap.getDouble("quality") * 100.0d));
                try {
                    this.mCamera.setParameters(this.mCameraParameters);
                } catch (RuntimeException e2) {
                    Log.e("CAMERA_1::", "setParameters quality failed", e2);
                }
            }
            this.mCamera.takePicture((Camera.ShutterCallback) null, (Camera.PictureCallback) null, (Camera.PictureCallback) null, new Camera.PictureCallback() {
                public void onPictureTaken(byte[] bArr, Camera camera) {
                    if (!readableMap.hasKey("pauseAfterCapture") || readableMap.getBoolean("pauseAfterCapture")) {
                        camera.stopPreview();
                        boolean unused = Camera1.this.mIsPreviewActive = false;
                        camera.setPreviewCallback((Camera.PreviewCallback) null);
                    } else {
                        camera.startPreview();
                        boolean unused2 = Camera1.this.mIsPreviewActive = true;
                        if (Camera1.this.mIsScanning) {
                            camera.setPreviewCallback(Camera1.this);
                        }
                    }
                    Camera1.this.isPictureCaptureInProgress.set(false);
                    int unused3 = Camera1.this.mOrientation = 0;
                    CameraViewImpl.Callback callback = Camera1.this.mCallback;
                    Camera1 camera1 = Camera1.this;
                    callback.onPictureTaken(bArr, camera1.displayOrientationToOrientationEnum(camera1.mDeviceOrientation));
                    if (Camera1.this.mustUpdateSurface) {
                        Camera1.this.updateSurface();
                    }
                }
            });
        } catch (Exception e3) {
            this.isPictureCaptureInProgress.set(false);
            throw e3;
        }
    }

    /* access modifiers changed from: package-private */
    public boolean record(String str, int i, int i2, boolean z, CamcorderProfile camcorderProfile, int i3) {
        if (!this.isPictureCaptureInProgress.get() && this.mIsRecording.compareAndSet(false, true)) {
            if (i3 != 0) {
                this.mOrientation = i3;
            }
            try {
                setUpMediaRecorder(str, i, i2, z, camcorderProfile);
                this.mMediaRecorder.prepare();
                this.mMediaRecorder.start();
                try {
                    this.mCamera.setParameters(this.mCameraParameters);
                } catch (Exception e) {
                    Log.e("CAMERA_1::", "Record setParameters failed", e);
                }
                return true;
            } catch (Exception e2) {
                this.mIsRecording.set(false);
                Log.e("CAMERA_1::", "Record start failed", e2);
            }
        }
        return false;
    }

    /* access modifiers changed from: package-private */
    public void stopRecording() {
        if (this.mIsRecording.compareAndSet(true, false)) {
            stopMediaRecorder();
            Camera camera = this.mCamera;
            if (camera != null) {
                camera.lock();
            }
            if (this.mustUpdateSurface) {
                updateSurface();
            }
        }
    }

    /* access modifiers changed from: package-private */
    public int getCameraOrientation() {
        return this.mCameraInfo.orientation;
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x003e, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void setDisplayOrientation(int r4) {
        /*
            r3 = this;
            monitor-enter(r3)
            int r0 = r3.mDisplayOrientation     // Catch:{ all -> 0x003f }
            if (r0 != r4) goto L_0x0007
            monitor-exit(r3)     // Catch:{ all -> 0x003f }
            return
        L_0x0007:
            r3.mDisplayOrientation = r4     // Catch:{ all -> 0x003f }
            boolean r0 = r3.isCameraOpened()     // Catch:{ all -> 0x003f }
            if (r0 == 0) goto L_0x003d
            boolean r0 = r3.mIsPreviewActive     // Catch:{ all -> 0x003f }
            r1 = 0
            if (r0 == 0) goto L_0x001c
            int r0 = android.os.Build.VERSION.SDK_INT     // Catch:{ all -> 0x003f }
            r2 = 14
            if (r0 >= r2) goto L_0x001c
            r0 = 1
            goto L_0x001d
        L_0x001c:
            r0 = 0
        L_0x001d:
            if (r0 == 0) goto L_0x0026
            android.hardware.Camera r2 = r3.mCamera     // Catch:{ all -> 0x003f }
            r2.stopPreview()     // Catch:{ all -> 0x003f }
            r3.mIsPreviewActive = r1     // Catch:{ all -> 0x003f }
        L_0x0026:
            android.hardware.Camera r1 = r3.mCamera     // Catch:{ RuntimeException -> 0x0030 }
            int r4 = r3.calcDisplayOrientation(r4)     // Catch:{ RuntimeException -> 0x0030 }
            r1.setDisplayOrientation(r4)     // Catch:{ RuntimeException -> 0x0030 }
            goto L_0x0038
        L_0x0030:
            r4 = move-exception
            java.lang.String r1 = "CAMERA_1::"
            java.lang.String r2 = "setDisplayOrientation failed"
            android.util.Log.e(r1, r2, r4)     // Catch:{ all -> 0x003f }
        L_0x0038:
            if (r0 == 0) goto L_0x003d
            r3.startCameraPreview()     // Catch:{ all -> 0x003f }
        L_0x003d:
            monitor-exit(r3)     // Catch:{ all -> 0x003f }
            return
        L_0x003f:
            r4 = move-exception
            monitor-exit(r3)     // Catch:{ all -> 0x003f }
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.cameraview.Camera1.setDisplayOrientation(int):void");
    }

    /* access modifiers changed from: package-private */
    public void setDeviceOrientation(int i) {
        synchronized (this) {
            if (this.mDeviceOrientation != i) {
                this.mDeviceOrientation = i;
                if (isCameraOpened() && this.mOrientation == 0 && !this.mIsRecording.get() && !this.isPictureCaptureInProgress.get()) {
                    this.mCameraParameters.setRotation(calcCameraRotation(i));
                    try {
                        this.mCamera.setParameters(this.mCameraParameters);
                    } catch (RuntimeException e) {
                        Log.e("CAMERA_1::", "setParameters failed", e);
                    }
                }
            }
        }
    }

    public void setPreviewTexture(final SurfaceTexture surfaceTexture) {
        this.mBgHandler.post(new Runnable() {
            public void run() {
                try {
                    if (Camera1.this.mCamera == null) {
                        SurfaceTexture unused = Camera1.this.mPreviewTexture = surfaceTexture;
                        return;
                    }
                    Camera1.this.mCamera.stopPreview();
                    boolean unused2 = Camera1.this.mIsPreviewActive = false;
                    if (surfaceTexture == null) {
                        Camera1.this.mCamera.setPreviewTexture((SurfaceTexture) Camera1.this.mPreview.getSurfaceTexture());
                    } else {
                        Camera1.this.mCamera.setPreviewTexture(surfaceTexture);
                    }
                    SurfaceTexture unused3 = Camera1.this.mPreviewTexture = surfaceTexture;
                    Camera1.this.startCameraPreview();
                } catch (IOException e) {
                    Log.e("CAMERA_1::", "setPreviewTexture failed", e);
                }
            }
        });
    }

    public Size getPreviewSize() {
        Camera.Size previewSize = this.mCameraParameters.getPreviewSize();
        return new Size(previewSize.width, previewSize.height);
    }

    private void chooseCamera() {
        String str = this._mCameraId;
        if (str == null) {
            int numberOfCameras = Camera.getNumberOfCameras();
            if (numberOfCameras != 0) {
                for (int i = 0; i < numberOfCameras; i++) {
                    Camera.getCameraInfo(i, this.mCameraInfo);
                    if (this.mCameraInfo.facing == this.mFacing) {
                        this.mCameraId = i;
                        return;
                    }
                }
                this.mCameraId = 0;
                Camera.getCameraInfo(this.mCameraId, this.mCameraInfo);
                return;
            }
            throw new RuntimeException("No camera available.");
        }
        try {
            this.mCameraId = Integer.parseInt(str);
            Camera.getCameraInfo(this.mCameraId, this.mCameraInfo);
        } catch (Exception unused) {
            this.mCameraId = -1;
        }
    }

    private boolean openCamera() {
        if (this.mCamera != null) {
            releaseCamera();
        }
        try {
            this.mCamera = Camera.open(this.mCameraId);
            this.mCameraParameters = this.mCamera.getParameters();
            this.mPreviewSizes.clear();
            for (Camera.Size next : this.mCameraParameters.getSupportedPreviewSizes()) {
                this.mPreviewSizes.add(new Size(next.width, next.height));
            }
            this.mPictureSizes.clear();
            for (Camera.Size next2 : this.mCameraParameters.getSupportedPictureSizes()) {
                this.mPictureSizes.add(new Size(next2.width, next2.height));
            }
            if (this.mAspectRatio == null) {
                this.mAspectRatio = Constants.DEFAULT_ASPECT_RATIO;
            }
            adjustCameraParameters();
            this.mCamera.setDisplayOrientation(calcDisplayOrientation(this.mDisplayOrientation));
            this.mCallback.onCameraOpened();
            return true;
        } catch (RuntimeException unused) {
            return false;
        }
    }

    private AspectRatio chooseAspectRatio() {
        Iterator<AspectRatio> it = this.mPreviewSizes.ratios().iterator();
        AspectRatio aspectRatio = null;
        while (it.hasNext()) {
            aspectRatio = it.next();
            if (aspectRatio.equals(Constants.DEFAULT_ASPECT_RATIO)) {
                break;
            }
        }
        return aspectRatio;
    }

    /* access modifiers changed from: package-private */
    public void adjustCameraParameters() {
        SortedSet<Size> sizes = this.mPreviewSizes.sizes(this.mAspectRatio);
        if (sizes == null) {
            this.mAspectRatio = chooseAspectRatio();
            sizes = this.mPreviewSizes.sizes(this.mAspectRatio);
        }
        Size chooseOptimalSize = chooseOptimalSize(sizes);
        this.mPictureSize = this.mPictureSizes.sizes(this.mAspectRatio).last();
        boolean z = this.mIsPreviewActive;
        if (z) {
            this.mCamera.stopPreview();
            this.mIsPreviewActive = false;
        }
        this.mCameraParameters.setPreviewSize(chooseOptimalSize.getWidth(), chooseOptimalSize.getHeight());
        this.mCameraParameters.setPictureSize(this.mPictureSize.getWidth(), this.mPictureSize.getHeight());
        int i = this.mOrientation;
        if (i != 0) {
            this.mCameraParameters.setRotation(calcCameraRotation(orientationEnumToRotation(i)));
        } else {
            this.mCameraParameters.setRotation(calcCameraRotation(this.mDeviceOrientation));
        }
        setAutoFocusInternal(this.mAutoFocus);
        setFlashInternal(this.mFlash);
        setExposureInternal(this.mExposure);
        setAspectRatio(this.mAspectRatio);
        setZoomInternal(this.mZoom);
        setWhiteBalanceInternal(this.mWhiteBalance);
        setScanningInternal(this.mIsScanning);
        try {
            this.mCamera.setParameters(this.mCameraParameters);
        } catch (RuntimeException e) {
            Log.e("CAMERA_1::", "setParameters failed", e);
        }
        if (z) {
            startCameraPreview();
        }
    }

    private Size chooseOptimalSize(SortedSet<Size> sortedSet) {
        if (!this.mPreview.isReady()) {
            return sortedSet.first();
        }
        int width = this.mPreview.getWidth();
        int height = this.mPreview.getHeight();
        if (isLandscape(this.mDisplayOrientation)) {
            int i = height;
            height = width;
            width = i;
        }
        r2 = null;
        for (Size size : sortedSet) {
            if (width <= size.getWidth() && height <= size.getHeight()) {
                break;
            }
        }
        return size;
    }

    private void releaseCamera() {
        Camera camera = this.mCamera;
        if (camera != null) {
            camera.release();
            this.mCamera = null;
            this.mPictureSize = null;
            this.mCallback.onCameraClosed();
            this.isPictureCaptureInProgress.set(false);
            this.mIsRecording.set(false);
        }
    }

    /* access modifiers changed from: package-private */
    public void setFocusArea(final float f, final float f2) {
        this.mBgHandler.post(new Runnable() {
            public void run() {
                Camera.Parameters parameters;
                synchronized (Camera1.this) {
                    if (Camera1.this.mCamera != null) {
                        try {
                            parameters = Camera1.this.mCamera.getParameters();
                        } catch (Exception e) {
                            Log.e("CAMERA_1::", "setFocusArea.getParameters failed", e);
                            parameters = null;
                        }
                        if (parameters != null) {
                            String focusMode = parameters.getFocusMode();
                            Rect access$1000 = Camera1.this.calculateFocusArea(f, f2);
                            ArrayList arrayList = new ArrayList();
                            arrayList.add(new Camera.Area(access$1000, 1000));
                            if (parameters.getMaxNumFocusAreas() != 0 && focusMode != null && (focusMode.equals("auto") || focusMode.equals("macro") || focusMode.equals("continuous-picture") || focusMode.equals("continuous-video"))) {
                                parameters.setFocusMode("auto");
                                parameters.setFocusAreas(arrayList);
                                if (parameters.getMaxNumMeteringAreas() > 0) {
                                    parameters.setMeteringAreas(arrayList);
                                }
                                if (parameters.getSupportedFocusModes().contains("auto")) {
                                    try {
                                        Camera1.this.mCamera.setParameters(parameters);
                                    } catch (RuntimeException e2) {
                                        Log.e("CAMERA_1::", "setParameters failed", e2);
                                    }
                                    try {
                                        Camera1.this.mCamera.autoFocus(new Camera.AutoFocusCallback() {
                                            public void onAutoFocus(boolean z, Camera camera) {
                                            }
                                        });
                                    } catch (RuntimeException e3) {
                                        Log.e("CAMERA_1::", "autoFocus failed", e3);
                                    }
                                } else {
                                    return;
                                }
                            } else if (parameters.getMaxNumMeteringAreas() <= 0) {
                                try {
                                    Camera1.this.mCamera.autoFocus(new Camera.AutoFocusCallback() {
                                        public void onAutoFocus(boolean z, Camera camera) {
                                        }
                                    });
                                } catch (RuntimeException e4) {
                                    Log.e("CAMERA_1::", "autoFocus failed", e4);
                                }
                            } else if (parameters.getSupportedFocusModes().contains("auto")) {
                                parameters.setFocusMode("auto");
                                parameters.setFocusAreas(arrayList);
                                parameters.setMeteringAreas(arrayList);
                                try {
                                    Camera1.this.mCamera.setParameters(parameters);
                                } catch (RuntimeException e5) {
                                    Log.e("CAMERA_1::", "setParameters failed", e5);
                                }
                                try {
                                    Camera1.this.mCamera.autoFocus(new Camera.AutoFocusCallback() {
                                        public void onAutoFocus(boolean z, Camera camera) {
                                        }
                                    });
                                } catch (RuntimeException e6) {
                                    Log.e("CAMERA_1::", "autoFocus failed", e6);
                                }
                            } else {
                                return;
                            }
                        } else {
                            return;
                        }
                    }
                }
                return;
            }
        });
    }

    private void resetFocus(boolean z, Camera camera) {
        this.mHandler.removeCallbacksAndMessages((Object) null);
        this.mHandler.postDelayed(new Runnable() {
            public void run() {
                Camera.Parameters parameters;
                if (Camera1.this.mCamera != null) {
                    Camera1.this.mCamera.cancelAutoFocus();
                    try {
                        parameters = Camera1.this.mCamera.getParameters();
                    } catch (Exception e) {
                        Log.e("CAMERA_1::", "resetFocus.getParameters failed", e);
                        parameters = null;
                    }
                    if (parameters != null) {
                        if (parameters.getFocusMode() != "continuous-picture") {
                            parameters.setFocusMode("continuous-picture");
                            parameters.setFocusAreas((List) null);
                            parameters.setMeteringAreas((List) null);
                            try {
                                Camera1.this.mCamera.setParameters(parameters);
                            } catch (RuntimeException e2) {
                                Log.e("CAMERA_1::", "setParameters failed", e2);
                            }
                        }
                        Camera1.this.mCamera.cancelAutoFocus();
                    }
                }
            }
        }, 3000);
    }

    /* access modifiers changed from: private */
    public Rect calculateFocusArea(float f, float f2) {
        int i = (int) (f * 2000.0f);
        int i2 = (int) (f2 * 2000.0f);
        int i3 = i - 150;
        int i4 = i2 - 150;
        int i5 = i + 150;
        int i6 = i2 + 150;
        if (i3 < 0) {
            i3 = 0;
        }
        if (i5 > 2000) {
            i5 = 2000;
        }
        if (i4 < 0) {
            i4 = 0;
        }
        if (i6 > 2000) {
            i6 = 2000;
        }
        return new Rect(i3 + NotificationManagerCompat.IMPORTANCE_UNSPECIFIED, i4 + NotificationManagerCompat.IMPORTANCE_UNSPECIFIED, i5 + NotificationManagerCompat.IMPORTANCE_UNSPECIFIED, i6 + NotificationManagerCompat.IMPORTANCE_UNSPECIFIED);
    }

    private int calcDisplayOrientation(int i) {
        if (this.mCameraInfo.facing == 1) {
            return (360 - ((this.mCameraInfo.orientation + i) % 360)) % 360;
        }
        return ((this.mCameraInfo.orientation - i) + 360) % 360;
    }

    private int calcCameraRotation(int i) {
        if (this.mCameraInfo.facing == 0) {
            return (this.mCameraInfo.orientation + i) % 360;
        }
        return ((this.mCameraInfo.orientation + i) + (isLandscape(i) ? 180 : 0)) % 360;
    }

    private boolean setAutoFocusInternal(boolean z) {
        this.mAutoFocus = z;
        if (!isCameraOpened()) {
            return false;
        }
        List<String> supportedFocusModes = this.mCameraParameters.getSupportedFocusModes();
        if (z && supportedFocusModes.contains("continuous-picture")) {
            this.mCameraParameters.setFocusMode("continuous-picture");
            return true;
        } else if (supportedFocusModes.contains("fixed")) {
            this.mCameraParameters.setFocusMode("fixed");
            return true;
        } else if (supportedFocusModes.contains("infinity")) {
            this.mCameraParameters.setFocusMode("infinity");
            return true;
        } else {
            this.mCameraParameters.setFocusMode(supportedFocusModes.get(0));
            return true;
        }
    }

    private boolean setFlashInternal(int i) {
        if (isCameraOpened()) {
            List<String> supportedFlashModes = this.mCameraParameters.getSupportedFlashModes();
            String str = FLASH_MODES.get(i);
            if (supportedFlashModes == null) {
                return false;
            }
            if (supportedFlashModes.contains(str)) {
                this.mCameraParameters.setFlashMode(str);
                this.mFlash = i;
                return true;
            } else if (supportedFlashModes.contains(FLASH_MODES.get(this.mFlash))) {
                return false;
            } else {
                this.mCameraParameters.setFlashMode("off");
                return true;
            }
        } else {
            this.mFlash = i;
            return false;
        }
    }

    private boolean setExposureInternal(float f) {
        int minExposureCompensation;
        int maxExposureCompensation;
        this.mExposure = f;
        int i = 0;
        if (!isCameraOpened() || (minExposureCompensation = this.mCameraParameters.getMinExposureCompensation()) == (maxExposureCompensation = this.mCameraParameters.getMaxExposureCompensation())) {
            return false;
        }
        float f2 = this.mExposure;
        if (f2 >= 0.0f && f2 <= 1.0f) {
            i = ((int) (f2 * ((float) (maxExposureCompensation - minExposureCompensation)))) + minExposureCompensation;
        }
        this.mCameraParameters.setExposureCompensation(i);
        return true;
    }

    private boolean setZoomInternal(float f) {
        if (!isCameraOpened() || !this.mCameraParameters.isZoomSupported()) {
            this.mZoom = f;
            return false;
        }
        this.mCameraParameters.setZoom((int) (((float) this.mCameraParameters.getMaxZoom()) * f));
        this.mZoom = f;
        return true;
    }

    private boolean setWhiteBalanceInternal(int i) {
        this.mWhiteBalance = i;
        if (!isCameraOpened()) {
            return false;
        }
        List<String> supportedWhiteBalance = this.mCameraParameters.getSupportedWhiteBalance();
        String str = WB_MODES.get(i);
        if (supportedWhiteBalance == null || !supportedWhiteBalance.contains(str)) {
            String str2 = WB_MODES.get(this.mWhiteBalance);
            if (supportedWhiteBalance != null && supportedWhiteBalance.contains(str2)) {
                return false;
            }
            this.mCameraParameters.setWhiteBalance("auto");
            return true;
        }
        this.mCameraParameters.setWhiteBalance(str);
        return true;
    }

    private void setScanningInternal(boolean z) {
        this.mIsScanning = z;
        if (!isCameraOpened()) {
            return;
        }
        if (this.mIsScanning) {
            this.mCamera.setPreviewCallback(this);
        } else {
            this.mCamera.setPreviewCallback((Camera.PreviewCallback) null);
        }
    }

    public void onPreviewFrame(byte[] bArr, Camera camera) {
        Camera.Size previewSize = this.mCameraParameters.getPreviewSize();
        this.mCallback.onFramePreview(bArr, previewSize.width, previewSize.height, this.mDeviceOrientation);
    }

    private void setUpMediaRecorder(String str, int i, int i2, boolean z, CamcorderProfile camcorderProfile) {
        CamcorderProfile camcorderProfile2;
        this.mMediaRecorder = new MediaRecorder();
        this.mCamera.unlock();
        this.mMediaRecorder.setCamera(this.mCamera);
        this.mMediaRecorder.setVideoSource(1);
        if (z) {
            this.mMediaRecorder.setAudioSource(5);
        }
        this.mMediaRecorder.setOutputFile(str);
        this.mVideoPath = str;
        if (CamcorderProfile.hasProfile(this.mCameraId, camcorderProfile.quality)) {
            camcorderProfile2 = CamcorderProfile.get(this.mCameraId, camcorderProfile.quality);
        } else {
            camcorderProfile2 = CamcorderProfile.get(this.mCameraId, 1);
        }
        camcorderProfile2.videoBitRate = camcorderProfile.videoBitRate;
        setCamcorderProfile(camcorderProfile2, z);
        MediaRecorder mediaRecorder = this.mMediaRecorder;
        int i3 = this.mOrientation;
        mediaRecorder.setOrientationHint(calcCameraRotation(i3 != 0 ? orientationEnumToRotation(i3) : this.mDeviceOrientation));
        if (i != -1) {
            this.mMediaRecorder.setMaxDuration(i);
        }
        if (i2 != -1) {
            this.mMediaRecorder.setMaxFileSize((long) i2);
        }
        this.mMediaRecorder.setOnInfoListener(this);
        this.mMediaRecorder.setOnErrorListener(this);
    }

    private void stopMediaRecorder() {
        MediaRecorder mediaRecorder = this.mMediaRecorder;
        if (mediaRecorder != null) {
            try {
                mediaRecorder.stop();
            } catch (RuntimeException e) {
                Log.e("CAMERA_1::", "stopMediaRecorder failed", e);
            }
            this.mMediaRecorder.reset();
            this.mMediaRecorder.release();
            this.mMediaRecorder = null;
        }
        int displayOrientationToOrientationEnum = displayOrientationToOrientationEnum(this.mDeviceOrientation);
        String str = this.mVideoPath;
        if (str == null || !new File(str).exists()) {
            CameraViewImpl.Callback callback = this.mCallback;
            int i = this.mOrientation;
            if (i == 0) {
                i = displayOrientationToOrientationEnum;
            }
            callback.onVideoRecorded((String) null, i, displayOrientationToOrientationEnum);
            return;
        }
        CameraViewImpl.Callback callback2 = this.mCallback;
        String str2 = this.mVideoPath;
        int i2 = this.mOrientation;
        if (i2 == 0) {
            i2 = displayOrientationToOrientationEnum;
        }
        callback2.onVideoRecorded(str2, i2, displayOrientationToOrientationEnum);
        this.mVideoPath = null;
    }

    private void setCamcorderProfile(CamcorderProfile camcorderProfile, boolean z) {
        this.mMediaRecorder.setOutputFormat(camcorderProfile.fileFormat);
        this.mMediaRecorder.setVideoFrameRate(camcorderProfile.videoFrameRate);
        this.mMediaRecorder.setVideoSize(camcorderProfile.videoFrameWidth, camcorderProfile.videoFrameHeight);
        this.mMediaRecorder.setVideoEncodingBitRate(camcorderProfile.videoBitRate);
        this.mMediaRecorder.setVideoEncoder(camcorderProfile.videoCodec);
        if (z) {
            this.mMediaRecorder.setAudioEncodingBitRate(camcorderProfile.audioBitRate);
            this.mMediaRecorder.setAudioChannels(camcorderProfile.audioChannels);
            this.mMediaRecorder.setAudioSamplingRate(camcorderProfile.audioSampleRate);
            this.mMediaRecorder.setAudioEncoder(camcorderProfile.audioCodec);
        }
    }

    public void onInfo(MediaRecorder mediaRecorder, int i, int i2) {
        if (i == 800 || i == 801) {
            stopRecording();
        }
    }

    public void onError(MediaRecorder mediaRecorder, int i, int i2) {
        stopRecording();
    }
}
