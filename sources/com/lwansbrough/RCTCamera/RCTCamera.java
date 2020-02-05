package com.lwansbrough.RCTCamera;

import android.hardware.Camera;
import android.media.CamcorderProfile;
import android.util.Log;
import com.drew.metadata.exif.makernotes.OlympusCameraSettingsMakernoteDirectory;
import com.drew.metadata.photoshop.PhotoshopDirectory;
import com.facebook.react.uimanager.ViewProps;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RCTCamera {
    private static final Resolution RESOLUTION_1080P = new Resolution(1920, PhotoshopDirectory.TAG_COUNT_INFORMATION);
    private static final Resolution RESOLUTION_480P = new Resolution(853, 480);
    private static final Resolution RESOLUTION_720P = new Resolution(OlympusCameraSettingsMakernoteDirectory.TagWhiteBalance2, 720);
    private static RCTCamera ourInstance;
    private int _actualDeviceOrientation = 0;
    private int _adjustedDeviceOrientation = 0;
    private List<String> _barCodeTypes = null;
    private boolean _barcodeScannerEnabled = false;
    private final HashMap<Integer, CameraInfoWrapper> _cameraInfos = new HashMap<>();
    private final HashMap<Integer, Integer> _cameraTypeToIndex = new HashMap<>();
    private final Map<Number, Camera> _cameras = new HashMap();
    private int _orientation = -1;

    public static RCTCamera getInstance() {
        return ourInstance;
    }

    public static void createInstance(int i) {
        ourInstance = new RCTCamera(i);
    }

    public synchronized Camera acquireCameraInstance(int i) {
        if (this._cameras.get(Integer.valueOf(i)) == null && this._cameraTypeToIndex.get(Integer.valueOf(i)) != null) {
            try {
                this._cameras.put(Integer.valueOf(i), Camera.open(this._cameraTypeToIndex.get(Integer.valueOf(i)).intValue()));
                adjustPreviewLayout(i);
            } catch (Exception e) {
                Log.e("RCTCamera", "acquireCameraInstance failed", e);
            }
        }
        return this._cameras.get(Integer.valueOf(i));
    }

    public void releaseCameraInstance(int i) {
        Camera camera = this._cameras.get(Integer.valueOf(i));
        if (camera != null) {
            this._cameras.remove(Integer.valueOf(i));
            camera.release();
        }
    }

    public int getPreviewWidth(int i) {
        CameraInfoWrapper cameraInfoWrapper = this._cameraInfos.get(Integer.valueOf(i));
        if (cameraInfoWrapper == null) {
            return 0;
        }
        return cameraInfoWrapper.previewWidth;
    }

    public int getPreviewHeight(int i) {
        CameraInfoWrapper cameraInfoWrapper = this._cameraInfos.get(Integer.valueOf(i));
        if (cameraInfoWrapper == null) {
            return 0;
        }
        return cameraInfoWrapper.previewHeight;
    }

    public int getPreviewVisibleHeight(int i) {
        CameraInfoWrapper cameraInfoWrapper = this._cameraInfos.get(Integer.valueOf(i));
        if (cameraInfoWrapper == null) {
            return 0;
        }
        return cameraInfoWrapper.previewVisibleHeight;
    }

    public int getPreviewVisibleWidth(int i) {
        CameraInfoWrapper cameraInfoWrapper = this._cameraInfos.get(Integer.valueOf(i));
        if (cameraInfoWrapper == null) {
            return 0;
        }
        return cameraInfoWrapper.previewVisibleWidth;
    }

    public Camera.Size getBestSize(List<Camera.Size> list, int i, int i2) {
        Camera.Size size = null;
        for (Camera.Size next : list) {
            if (next.width <= i && next.height <= i2) {
                if (size == null || next.width * next.height > size.width * size.height) {
                    size = next;
                }
            }
        }
        return size;
    }

    private Camera.Size getSmallestSize(List<Camera.Size> list) {
        Camera.Size size = null;
        for (Camera.Size next : list) {
            if (size == null || next.width * next.height < size.width * size.height) {
                size = next;
            }
        }
        return size;
    }

    private Camera.Size getClosestSize(List<Camera.Size> list, int i, int i2) {
        Camera.Size size = null;
        for (Camera.Size next : list) {
            if (size != null) {
                if (Math.sqrt(Math.pow((double) (next.width - i), 2.0d) + Math.pow((double) (next.height - i2), 2.0d)) >= Math.sqrt(Math.pow((double) (size.width - i), 2.0d) + Math.pow((double) (size.height - i2), 2.0d))) {
                }
            }
            size = next;
        }
        return size;
    }

    /* access modifiers changed from: protected */
    public List<Camera.Size> getSupportedVideoSizes(Camera camera) {
        Camera.Parameters parameters = camera.getParameters();
        List<Camera.Size> supportedVideoSizes = parameters.getSupportedVideoSizes();
        if (supportedVideoSizes != null) {
            return supportedVideoSizes;
        }
        return parameters.getSupportedPreviewSizes();
    }

    public int getOrientation() {
        return this._orientation;
    }

    public void setOrientation(int i) {
        if (this._orientation != i) {
            this._orientation = i;
            adjustPreviewLayout(1);
            adjustPreviewLayout(2);
        }
    }

    public boolean isBarcodeScannerEnabled() {
        return this._barcodeScannerEnabled;
    }

    public void setBarcodeScannerEnabled(boolean z) {
        this._barcodeScannerEnabled = z;
    }

    public List<String> getBarCodeTypes() {
        return this._barCodeTypes;
    }

    public void setBarCodeTypes(List<String> list) {
        this._barCodeTypes = list;
    }

    public int getActualDeviceOrientation() {
        return this._actualDeviceOrientation;
    }

    public void setAdjustedDeviceOrientation(int i) {
        this._adjustedDeviceOrientation = i;
    }

    public int getAdjustedDeviceOrientation() {
        return this._adjustedDeviceOrientation;
    }

    public void setActualDeviceOrientation(int i) {
        this._actualDeviceOrientation = i;
        adjustPreviewLayout(1);
        adjustPreviewLayout(2);
    }

    public void setCaptureMode(int i, int i2) {
        Camera camera = this._cameras.get(Integer.valueOf(i));
        if (camera != null) {
            Camera.Parameters parameters = camera.getParameters();
            boolean z = true;
            if (i2 != 1) {
                z = false;
            }
            parameters.setRecordingHint(z);
            try {
                camera.setParameters(parameters);
            } catch (RuntimeException e) {
                Log.e("RCTCamera", "setParameters failed", e);
            }
        }
    }

    public void setCaptureQuality(int i, String str) {
        Camera acquireCameraInstance = acquireCameraInstance(i);
        if (acquireCameraInstance != null) {
            Camera.Parameters parameters = acquireCameraInstance.getParameters();
            Camera.Size size = null;
            List<Camera.Size> supportedPictureSizes = parameters.getSupportedPictureSizes();
            char c = 65535;
            switch (str.hashCode()) {
                case -1078030475:
                    if (str.equals("medium")) {
                        c = 1;
                        break;
                    }
                    break;
                case -318184504:
                    if (str.equals(RCTCameraModule.RCT_CAMERA_CAPTURE_QUALITY_PREVIEW)) {
                        c = 3;
                        break;
                    }
                    break;
                case 107348:
                    if (str.equals(RCTCameraModule.RCT_CAMERA_CAPTURE_QUALITY_LOW)) {
                        c = 0;
                        break;
                    }
                    break;
                case 1604548:
                    if (str.equals(RCTCameraModule.RCT_CAMERA_CAPTURE_QUALITY_480P)) {
                        c = 4;
                        break;
                    }
                    break;
                case 1688155:
                    if (str.equals(RCTCameraModule.RCT_CAMERA_CAPTURE_QUALITY_720P)) {
                        c = 5;
                        break;
                    }
                    break;
                case 3202466:
                    if (str.equals(RCTCameraModule.RCT_CAMERA_CAPTURE_QUALITY_HIGH)) {
                        c = 2;
                        break;
                    }
                    break;
                case 46737913:
                    if (str.equals(RCTCameraModule.RCT_CAMERA_CAPTURE_QUALITY_1080P)) {
                        c = 6;
                        break;
                    }
                    break;
            }
            switch (c) {
                case 0:
                    size = getSmallestSize(supportedPictureSizes);
                    break;
                case 1:
                    size = supportedPictureSizes.get(supportedPictureSizes.size() / 2);
                    break;
                case 2:
                    size = getBestSize(parameters.getSupportedPictureSizes(), Integer.MAX_VALUE, Integer.MAX_VALUE);
                    break;
                case 3:
                    Camera.Size bestSize = getBestSize(parameters.getSupportedPreviewSizes(), Integer.MAX_VALUE, Integer.MAX_VALUE);
                    size = getClosestSize(parameters.getSupportedPictureSizes(), bestSize.width, bestSize.height);
                    break;
                case 4:
                    size = getBestSize(supportedPictureSizes, RESOLUTION_480P.width, RESOLUTION_480P.height);
                    break;
                case 5:
                    size = getBestSize(supportedPictureSizes, RESOLUTION_720P.width, RESOLUTION_720P.height);
                    break;
                case 6:
                    size = getBestSize(supportedPictureSizes, RESOLUTION_1080P.width, RESOLUTION_1080P.height);
                    break;
            }
            if (size != null) {
                parameters.setPictureSize(size.width, size.height);
                try {
                    acquireCameraInstance.setParameters(parameters);
                } catch (RuntimeException e) {
                    Log.e("RCTCamera", "setParameters failed", e);
                }
            }
        }
    }

    public CamcorderProfile setCaptureVideoQuality(int i, String str) {
        Camera.Size size;
        CamcorderProfile camcorderProfile;
        Camera acquireCameraInstance = acquireCameraInstance(i);
        if (acquireCameraInstance == null) {
            return null;
        }
        List<Camera.Size> supportedVideoSizes = getSupportedVideoSizes(acquireCameraInstance);
        char c = 65535;
        switch (str.hashCode()) {
            case -1078030475:
                if (str.equals("medium")) {
                    c = 1;
                    break;
                }
                break;
            case 107348:
                if (str.equals(RCTCameraModule.RCT_CAMERA_CAPTURE_QUALITY_LOW)) {
                    c = 0;
                    break;
                }
                break;
            case 1604548:
                if (str.equals(RCTCameraModule.RCT_CAMERA_CAPTURE_QUALITY_480P)) {
                    c = 3;
                    break;
                }
                break;
            case 1688155:
                if (str.equals(RCTCameraModule.RCT_CAMERA_CAPTURE_QUALITY_720P)) {
                    c = 4;
                    break;
                }
                break;
            case 3202466:
                if (str.equals(RCTCameraModule.RCT_CAMERA_CAPTURE_QUALITY_HIGH)) {
                    c = 2;
                    break;
                }
                break;
            case 46737913:
                if (str.equals(RCTCameraModule.RCT_CAMERA_CAPTURE_QUALITY_1080P)) {
                    c = 5;
                    break;
                }
                break;
        }
        if (c == 0) {
            size = getSmallestSize(supportedVideoSizes);
            camcorderProfile = CamcorderProfile.get(this._cameraTypeToIndex.get(Integer.valueOf(i)).intValue(), 4);
        } else if (c == 1) {
            size = supportedVideoSizes.get(supportedVideoSizes.size() / 2);
            camcorderProfile = CamcorderProfile.get(this._cameraTypeToIndex.get(Integer.valueOf(i)).intValue(), 5);
        } else if (c == 2) {
            size = getBestSize(supportedVideoSizes, Integer.MAX_VALUE, Integer.MAX_VALUE);
            camcorderProfile = CamcorderProfile.get(this._cameraTypeToIndex.get(Integer.valueOf(i)).intValue(), 1);
        } else if (c == 3) {
            size = getBestSize(supportedVideoSizes, RESOLUTION_480P.width, RESOLUTION_480P.height);
            camcorderProfile = CamcorderProfile.get(this._cameraTypeToIndex.get(Integer.valueOf(i)).intValue(), 4);
        } else if (c == 4) {
            size = getBestSize(supportedVideoSizes, RESOLUTION_720P.width, RESOLUTION_720P.height);
            camcorderProfile = CamcorderProfile.get(this._cameraTypeToIndex.get(Integer.valueOf(i)).intValue(), 5);
        } else if (c != 5) {
            camcorderProfile = null;
            size = null;
        } else {
            size = getBestSize(supportedVideoSizes, RESOLUTION_1080P.width, RESOLUTION_1080P.height);
            camcorderProfile = CamcorderProfile.get(this._cameraTypeToIndex.get(Integer.valueOf(i)).intValue(), 6);
        }
        if (camcorderProfile == null) {
            return null;
        }
        if (size != null) {
            camcorderProfile.videoFrameHeight = size.height;
            camcorderProfile.videoFrameWidth = size.width;
        }
        return camcorderProfile;
    }

    public void setTorchMode(int i, int i2) {
        Camera acquireCameraInstance = acquireCameraInstance(i);
        if (acquireCameraInstance != null) {
            Camera.Parameters parameters = acquireCameraInstance.getParameters();
            String flashMode = parameters.getFlashMode();
            if (i2 == 0) {
                flashMode = "off";
            } else if (i2 == 1) {
                flashMode = "torch";
            }
            List<String> supportedFlashModes = parameters.getSupportedFlashModes();
            if (supportedFlashModes != null && supportedFlashModes.contains(flashMode)) {
                parameters.setFlashMode(flashMode);
                try {
                    acquireCameraInstance.setParameters(parameters);
                } catch (RuntimeException e) {
                    Log.e("RCTCamera", "setParameters failed", e);
                }
            }
        }
    }

    public void setFlashMode(int i, int i2) {
        Camera acquireCameraInstance = acquireCameraInstance(i);
        if (acquireCameraInstance != null) {
            Camera.Parameters parameters = acquireCameraInstance.getParameters();
            String flashMode = parameters.getFlashMode();
            if (i2 == 0) {
                flashMode = "off";
            } else if (i2 == 1) {
                flashMode = ViewProps.ON;
            } else if (i2 == 2) {
                flashMode = "auto";
            }
            List<String> supportedFlashModes = parameters.getSupportedFlashModes();
            if (supportedFlashModes != null && supportedFlashModes.contains(flashMode)) {
                parameters.setFlashMode(flashMode);
                try {
                    acquireCameraInstance.setParameters(parameters);
                } catch (RuntimeException e) {
                    Log.e("RCTCamera", "setParameters failed", e);
                }
            }
        }
    }

    public void setZoom(int i, int i2) {
        Camera acquireCameraInstance = acquireCameraInstance(i);
        if (acquireCameraInstance != null) {
            Camera.Parameters parameters = acquireCameraInstance.getParameters();
            int maxZoom = parameters.getMaxZoom();
            if (parameters.isZoomSupported() && i2 >= 0 && i2 < maxZoom) {
                parameters.setZoom(i2);
                try {
                    acquireCameraInstance.setParameters(parameters);
                } catch (RuntimeException e) {
                    Log.e("RCTCamera", "setParameters failed", e);
                }
            }
        }
    }

    public void adjustCameraRotationToDeviceOrientation(int i, int i2) {
        int i3;
        Camera camera = this._cameras.get(Integer.valueOf(i));
        if (camera != null) {
            CameraInfoWrapper cameraInfoWrapper = this._cameraInfos.get(Integer.valueOf(i));
            int i4 = cameraInfoWrapper.info.orientation;
            if (cameraInfoWrapper.info.facing == 1) {
                i3 = (i4 + (i2 * 90)) % 360;
            } else {
                i3 = ((i4 - (i2 * 90)) + 360) % 360;
            }
            cameraInfoWrapper.rotation = i3;
            Camera.Parameters parameters = camera.getParameters();
            parameters.setRotation(cameraInfoWrapper.rotation);
            try {
                camera.setParameters(parameters);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void adjustPreviewLayout(int i) {
        int i2;
        int i3;
        Camera camera = this._cameras.get(Integer.valueOf(i));
        if (camera != null) {
            CameraInfoWrapper cameraInfoWrapper = this._cameraInfos.get(Integer.valueOf(i));
            int i4 = cameraInfoWrapper.info.orientation;
            if (cameraInfoWrapper.info.facing == 1) {
                int i5 = this._actualDeviceOrientation;
                i2 = ((i5 * 90) + i4) % 360;
                i3 = ((720 - i4) - (i5 * 90)) % 360;
            } else {
                i2 = ((i4 - (this._actualDeviceOrientation * 90)) + 360) % 360;
                i3 = i2;
            }
            cameraInfoWrapper.rotation = i2;
            setAdjustedDeviceOrientation(i2);
            camera.setDisplayOrientation(i3);
            Camera.Parameters parameters = camera.getParameters();
            parameters.setRotation(cameraInfoWrapper.rotation);
            Camera.Size bestSize = getBestSize(parameters.getSupportedPreviewSizes(), Integer.MAX_VALUE, Integer.MAX_VALUE);
            int i6 = bestSize.width;
            int i7 = bestSize.height;
            parameters.setPreviewSize(i6, i7);
            try {
                camera.setParameters(parameters);
            } catch (Exception e) {
                e.printStackTrace();
            }
            if (cameraInfoWrapper.rotation == 0 || cameraInfoWrapper.rotation == 180) {
                cameraInfoWrapper.previewWidth = i6;
                cameraInfoWrapper.previewHeight = i7;
                return;
            }
            cameraInfoWrapper.previewWidth = i7;
            cameraInfoWrapper.previewHeight = i6;
        }
    }

    public void setPreviewVisibleSize(int i, int i2, int i3) {
        CameraInfoWrapper cameraInfoWrapper = this._cameraInfos.get(Integer.valueOf(i));
        if (cameraInfoWrapper != null) {
            cameraInfoWrapper.previewVisibleWidth = i2;
            cameraInfoWrapper.previewVisibleHeight = i3;
        }
    }

    private RCTCamera(int i) {
        this._actualDeviceOrientation = i;
        for (int i2 = 0; i2 < Camera.getNumberOfCameras(); i2++) {
            Camera.CameraInfo cameraInfo = new Camera.CameraInfo();
            Camera.getCameraInfo(i2, cameraInfo);
            if (cameraInfo.facing == 1 && this._cameraInfos.get(1) == null) {
                this._cameraInfos.put(1, new CameraInfoWrapper(cameraInfo));
                this._cameraTypeToIndex.put(1, Integer.valueOf(i2));
                acquireCameraInstance(1);
                releaseCameraInstance(1);
            } else if (cameraInfo.facing == 0 && this._cameraInfos.get(2) == null) {
                this._cameraInfos.put(2, new CameraInfoWrapper(cameraInfo));
                this._cameraTypeToIndex.put(2, Integer.valueOf(i2));
                acquireCameraInstance(2);
                releaseCameraInstance(2);
            }
        }
    }

    private class CameraInfoWrapper {
        public final Camera.CameraInfo info;
        public int previewHeight = -1;
        public int previewVisibleHeight = -1;
        public int previewVisibleWidth = -1;
        public int previewWidth = -1;
        public int rotation = 0;

        public CameraInfoWrapper(Camera.CameraInfo cameraInfo) {
            this.info = cameraInfo;
        }
    }

    private static class Resolution {
        public int height;
        public int width;

        public Resolution(int i, int i2) {
            this.width = i;
            this.height = i2;
        }
    }
}
