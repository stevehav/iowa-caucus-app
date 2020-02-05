package com.lwansbrough.RCTCamera;

import android.graphics.SurfaceTexture;
import android.hardware.Camera;
import android.media.CamcorderProfile;
import android.media.MediaActionSound;
import android.media.MediaRecorder;
import android.media.MediaScannerConnection;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Environment;
import android.util.Log;
import androidx.exifinterface.media.ExifInterface;
import com.facebook.react.bridge.LifecycleEventListener;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.WritableNativeMap;
import com.facebook.react.uimanager.ViewProps;
import com.facebook.react.uimanager.events.TouchesHelper;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.Nullable;

public class RCTCameraModule extends ReactContextBaseJavaModule implements MediaRecorder.OnInfoListener, MediaRecorder.OnErrorListener, LifecycleEventListener {
    public static final int MEDIA_TYPE_IMAGE = 1;
    public static final int MEDIA_TYPE_VIDEO = 2;
    public static final int RCT_CAMERA_ASPECT_FILL = 0;
    public static final int RCT_CAMERA_ASPECT_FIT = 1;
    public static final int RCT_CAMERA_ASPECT_STRETCH = 2;
    public static final int RCT_CAMERA_CAPTURE_MODE_STILL = 0;
    public static final int RCT_CAMERA_CAPTURE_MODE_VIDEO = 1;
    public static final String RCT_CAMERA_CAPTURE_QUALITY_1080P = "1080p";
    public static final String RCT_CAMERA_CAPTURE_QUALITY_480P = "480p";
    public static final String RCT_CAMERA_CAPTURE_QUALITY_720P = "720p";
    public static final String RCT_CAMERA_CAPTURE_QUALITY_HIGH = "high";
    public static final String RCT_CAMERA_CAPTURE_QUALITY_LOW = "low";
    public static final String RCT_CAMERA_CAPTURE_QUALITY_MEDIUM = "medium";
    public static final String RCT_CAMERA_CAPTURE_QUALITY_PREVIEW = "preview";
    public static final int RCT_CAMERA_CAPTURE_TARGET_CAMERA_ROLL = 2;
    public static final int RCT_CAMERA_CAPTURE_TARGET_DISK = 1;
    public static final int RCT_CAMERA_CAPTURE_TARGET_MEMORY = 0;
    public static final int RCT_CAMERA_CAPTURE_TARGET_TEMP = 3;
    public static final int RCT_CAMERA_FLASH_MODE_AUTO = 2;
    public static final int RCT_CAMERA_FLASH_MODE_OFF = 0;
    public static final int RCT_CAMERA_FLASH_MODE_ON = 1;
    public static final int RCT_CAMERA_ORIENTATION_AUTO = Integer.MAX_VALUE;
    public static final int RCT_CAMERA_ORIENTATION_LANDSCAPE_LEFT = 1;
    public static final int RCT_CAMERA_ORIENTATION_LANDSCAPE_RIGHT = 3;
    public static final int RCT_CAMERA_ORIENTATION_PORTRAIT = 0;
    public static final int RCT_CAMERA_ORIENTATION_PORTRAIT_UPSIDE_DOWN = 2;
    public static final int RCT_CAMERA_TORCH_MODE_AUTO = 2;
    public static final int RCT_CAMERA_TORCH_MODE_OFF = 0;
    public static final int RCT_CAMERA_TORCH_MODE_ON = 1;
    public static final int RCT_CAMERA_TYPE_BACK = 2;
    public static final int RCT_CAMERA_TYPE_FRONT = 1;
    private static final String TAG = "RCTCameraModule";
    private static ReactApplicationContext _reactContext;
    private long MRStartTime;
    /* access modifiers changed from: private */
    public RCTSensorOrientationChecker _sensorOrientationChecker;
    private Camera mCamera = null;
    private MediaRecorder mMediaRecorder;
    private ReadableMap mRecordingOptions;
    private Promise mRecordingPromise = null;
    /* access modifiers changed from: private */
    public Boolean mSafeToCapture = true;
    private File mVideoFile;

    public String getName() {
        return TAG;
    }

    public void onHostDestroy() {
    }

    public RCTCameraModule(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
        _reactContext = reactApplicationContext;
        this._sensorOrientationChecker = new RCTSensorOrientationChecker(_reactContext);
        _reactContext.addLifecycleEventListener(this);
    }

    public static ReactApplicationContext getReactContextSingleton() {
        return _reactContext;
    }

    public void onInfo(MediaRecorder mediaRecorder, int i, int i2) {
        if ((i == 800 || i == 801) && this.mRecordingPromise != null) {
            releaseMediaRecorder();
        }
    }

    public void onError(MediaRecorder mediaRecorder, int i, int i2) {
        if (this.mRecordingPromise != null) {
            releaseMediaRecorder();
        }
    }

    @Nullable
    public Map<String, Object> getConstants() {
        return Collections.unmodifiableMap(new HashMap<String, Object>() {
            {
                put("Aspect", getAspectConstants());
                put("BarCodeType", getBarCodeConstants());
                put("Type", getTypeConstants());
                put("CaptureQuality", getCaptureQualityConstants());
                put("CaptureMode", getCaptureModeConstants());
                put("CaptureTarget", getCaptureTargetConstants());
                put(ExifInterface.TAG_ORIENTATION, getOrientationConstants());
                put("FlashMode", getFlashModeConstants());
                put("TorchMode", getTorchModeConstants());
            }

            private Map<String, Object> getAspectConstants() {
                return Collections.unmodifiableMap(new HashMap<String, Object>() {
                    {
                        put("stretch", 2);
                        put("fit", 1);
                        put("fill", 0);
                    }
                });
            }

            private Map<String, Object> getBarCodeConstants() {
                return Collections.unmodifiableMap(new HashMap<String, Object>() {
                });
            }

            private Map<String, Object> getTypeConstants() {
                return Collections.unmodifiableMap(new HashMap<String, Object>() {
                    {
                        put("front", 1);
                        put("back", 2);
                    }
                });
            }

            private Map<String, Object> getCaptureQualityConstants() {
                return Collections.unmodifiableMap(new HashMap<String, Object>() {
                    {
                        put(RCTCameraModule.RCT_CAMERA_CAPTURE_QUALITY_LOW, RCTCameraModule.RCT_CAMERA_CAPTURE_QUALITY_LOW);
                        put("medium", "medium");
                        put(RCTCameraModule.RCT_CAMERA_CAPTURE_QUALITY_HIGH, RCTCameraModule.RCT_CAMERA_CAPTURE_QUALITY_HIGH);
                        put("photo", RCTCameraModule.RCT_CAMERA_CAPTURE_QUALITY_HIGH);
                        put(RCTCameraModule.RCT_CAMERA_CAPTURE_QUALITY_PREVIEW, RCTCameraModule.RCT_CAMERA_CAPTURE_QUALITY_PREVIEW);
                        put(RCTCameraModule.RCT_CAMERA_CAPTURE_QUALITY_480P, RCTCameraModule.RCT_CAMERA_CAPTURE_QUALITY_480P);
                        put(RCTCameraModule.RCT_CAMERA_CAPTURE_QUALITY_720P, RCTCameraModule.RCT_CAMERA_CAPTURE_QUALITY_720P);
                        put(RCTCameraModule.RCT_CAMERA_CAPTURE_QUALITY_1080P, RCTCameraModule.RCT_CAMERA_CAPTURE_QUALITY_1080P);
                    }
                });
            }

            private Map<String, Object> getCaptureModeConstants() {
                return Collections.unmodifiableMap(new HashMap<String, Object>() {
                    {
                        put("still", 0);
                        put("video", 1);
                    }
                });
            }

            private Map<String, Object> getCaptureTargetConstants() {
                return Collections.unmodifiableMap(new HashMap<String, Object>() {
                    {
                        put("memory", 0);
                        put("disk", 1);
                        put("cameraRoll", 2);
                        put("temp", 3);
                    }
                });
            }

            private Map<String, Object> getOrientationConstants() {
                return Collections.unmodifiableMap(new HashMap<String, Object>() {
                    {
                        put("auto", Integer.MAX_VALUE);
                        put("landscapeLeft", 1);
                        put("landscapeRight", 3);
                        put("portrait", 0);
                        put("portraitUpsideDown", 2);
                    }
                });
            }

            private Map<String, Object> getFlashModeConstants() {
                return Collections.unmodifiableMap(new HashMap<String, Object>() {
                    {
                        put("off", 0);
                        put(ViewProps.ON, 1);
                        put("auto", 2);
                    }
                });
            }

            private Map<String, Object> getTorchModeConstants() {
                return Collections.unmodifiableMap(new HashMap<String, Object>() {
                    {
                        put("off", 0);
                        put(ViewProps.ON, 1);
                        put("auto", 2);
                    }
                });
            }
        });
    }

    private Throwable prepareMediaRecorder(ReadableMap readableMap, int i) {
        CamcorderProfile captureVideoQuality = RCTCamera.getInstance().setCaptureVideoQuality(readableMap.getInt("type"), readableMap.getString("quality"));
        if (captureVideoQuality == null) {
            return new RuntimeException("CamcorderProfile not found in prepareMediaRecorder.");
        }
        this.mCamera.unlock();
        this.mMediaRecorder = new MediaRecorder();
        this.mMediaRecorder.setOnInfoListener(this);
        this.mMediaRecorder.setOnErrorListener(this);
        this.mMediaRecorder.setCamera(this.mCamera);
        this.mMediaRecorder.setAudioSource(5);
        this.mMediaRecorder.setVideoSource(1);
        if (i == 0) {
            this.mMediaRecorder.setOrientationHint(90);
        } else if (i == 1) {
            this.mMediaRecorder.setOrientationHint(0);
        } else if (i == 2) {
            this.mMediaRecorder.setOrientationHint(270);
        } else if (i == 3) {
            this.mMediaRecorder.setOrientationHint(180);
        }
        captureVideoQuality.fileFormat = 2;
        this.mMediaRecorder.setProfile(captureVideoQuality);
        this.mVideoFile = null;
        int i2 = readableMap.getInt(TouchesHelper.TARGET_KEY);
        if (i2 == 0) {
            this.mVideoFile = getTempMediaFile(2);
        } else if (i2 == 2) {
            this.mVideoFile = getOutputCameraRollFile(2);
        } else if (i2 != 3) {
            this.mVideoFile = getOutputMediaFile(2);
        } else {
            this.mVideoFile = getTempMediaFile(2);
        }
        File file = this.mVideoFile;
        if (file == null) {
            return new RuntimeException("Error while preparing output file in prepareMediaRecorder.");
        }
        this.mMediaRecorder.setOutputFile(file.getPath());
        if (readableMap.hasKey("totalSeconds")) {
            this.mMediaRecorder.setMaxDuration(readableMap.getInt("totalSeconds") * 1000);
        }
        if (readableMap.hasKey("maxFileSize")) {
            this.mMediaRecorder.setMaxFileSize((long) readableMap.getInt("maxFileSize"));
        }
        try {
            this.mMediaRecorder.prepare();
            return null;
        } catch (Exception e) {
            Log.e(TAG, "Media recorder prepare error.", e);
            releaseMediaRecorder();
            return e;
        }
    }

    private void record(ReadableMap readableMap, Promise promise, int i) {
        if (this.mRecordingPromise == null) {
            this.mCamera = RCTCamera.getInstance().acquireCameraInstance(readableMap.getInt("type"));
            if (this.mCamera == null) {
                promise.reject((Throwable) new RuntimeException("No camera found."));
                return;
            }
            Throwable prepareMediaRecorder = prepareMediaRecorder(readableMap, i);
            if (prepareMediaRecorder != null) {
                promise.reject(prepareMediaRecorder);
                return;
            }
            try {
                this.mMediaRecorder.start();
                this.MRStartTime = System.currentTimeMillis();
                this.mRecordingOptions = readableMap;
                this.mRecordingPromise = promise;
            } catch (Exception e) {
                Log.e(TAG, "Media recorder start error.", e);
                promise.reject((Throwable) e);
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:30:0x0080, code lost:
        if (r4 != 3) goto L_0x0140;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void releaseMediaRecorder() {
        /*
            r6 = this;
            long r0 = java.lang.System.currentTimeMillis()
            long r2 = r6.MRStartTime
            long r0 = r0 - r2
            java.lang.String r2 = "RCTCameraModule"
            r3 = 1500(0x5dc, double:7.41E-321)
            int r5 = (r0 > r3 ? 1 : (r0 == r3 ? 0 : -1))
            if (r5 >= 0) goto L_0x001a
            long r3 = r3 - r0
            java.lang.Thread.sleep(r3)     // Catch:{ InterruptedException -> 0x0014 }
            goto L_0x001a
        L_0x0014:
            r0 = move-exception
            java.lang.String r1 = "releaseMediaRecorder thread sleep error."
            android.util.Log.e(r2, r1, r0)
        L_0x001a:
            android.media.MediaRecorder r0 = r6.mMediaRecorder
            r1 = 0
            if (r0 == 0) goto L_0x0035
            r0.stop()     // Catch:{ RuntimeException -> 0x0023 }
            goto L_0x0029
        L_0x0023:
            r0 = move-exception
            java.lang.String r3 = "Media recorder stop error."
            android.util.Log.e(r2, r3, r0)
        L_0x0029:
            android.media.MediaRecorder r0 = r6.mMediaRecorder
            r0.reset()
            android.media.MediaRecorder r0 = r6.mMediaRecorder
            r0.release()
            r6.mMediaRecorder = r1
        L_0x0035:
            android.hardware.Camera r0 = r6.mCamera
            if (r0 == 0) goto L_0x003c
            r0.lock()
        L_0x003c:
            com.facebook.react.bridge.Promise r0 = r6.mRecordingPromise
            if (r0 != 0) goto L_0x0041
            return
        L_0x0041:
            java.io.File r0 = new java.io.File
            java.io.File r2 = r6.mVideoFile
            java.lang.String r2 = r2.getPath()
            r0.<init>(r2)
            boolean r2 = r0.exists()
            if (r2 != 0) goto L_0x0061
            com.facebook.react.bridge.Promise r0 = r6.mRecordingPromise
            java.lang.RuntimeException r2 = new java.lang.RuntimeException
            java.lang.String r3 = "There is nothing recorded."
            r2.<init>(r3)
            r0.reject((java.lang.Throwable) r2)
            r6.mRecordingPromise = r1
            return
        L_0x0061:
            r2 = 0
            r3 = 1
            r0.setReadable(r3, r2)
            r0.setWritable(r3, r2)
            com.facebook.react.bridge.WritableNativeMap r2 = new com.facebook.react.bridge.WritableNativeMap
            r2.<init>()
            com.facebook.react.bridge.ReadableMap r4 = r6.mRecordingOptions
            java.lang.String r5 = "target"
            int r4 = r4.getInt(r5)
            r5 = 2
            if (r4 == 0) goto L_0x0128
            java.lang.String r0 = "path"
            if (r4 == r3) goto L_0x0115
            if (r4 == r5) goto L_0x0084
            r3 = 3
            if (r4 == r3) goto L_0x0115
            goto L_0x0140
        L_0x0084:
            android.content.ContentValues r3 = new android.content.ContentValues
            r3.<init>()
            java.io.File r4 = r6.mVideoFile
            java.lang.String r4 = r4.getPath()
            java.lang.String r5 = "_data"
            r3.put(r5, r4)
            com.facebook.react.bridge.ReadableMap r4 = r6.mRecordingOptions
            java.lang.String r5 = "title"
            boolean r4 = r4.hasKey(r5)
            if (r4 == 0) goto L_0x00a5
            com.facebook.react.bridge.ReadableMap r4 = r6.mRecordingOptions
            java.lang.String r4 = r4.getString(r5)
            goto L_0x00a7
        L_0x00a5:
            java.lang.String r4 = "video"
        L_0x00a7:
            r3.put(r5, r4)
            com.facebook.react.bridge.ReadableMap r4 = r6.mRecordingOptions
            java.lang.String r5 = "description"
            boolean r4 = r4.hasKey(r5)
            if (r4 == 0) goto L_0x00c1
            com.facebook.react.bridge.ReadableMap r4 = r6.mRecordingOptions
            boolean r4 = r4.hasKey(r5)
            java.lang.Boolean r4 = java.lang.Boolean.valueOf(r4)
            r3.put(r5, r4)
        L_0x00c1:
            com.facebook.react.bridge.ReadableMap r4 = r6.mRecordingOptions
            java.lang.String r5 = "latitude"
            boolean r4 = r4.hasKey(r5)
            if (r4 == 0) goto L_0x00d4
            com.facebook.react.bridge.ReadableMap r4 = r6.mRecordingOptions
            java.lang.String r4 = r4.getString(r5)
            r3.put(r5, r4)
        L_0x00d4:
            com.facebook.react.bridge.ReadableMap r4 = r6.mRecordingOptions
            java.lang.String r5 = "longitude"
            boolean r4 = r4.hasKey(r5)
            if (r4 == 0) goto L_0x00e7
            com.facebook.react.bridge.ReadableMap r4 = r6.mRecordingOptions
            java.lang.String r4 = r4.getString(r5)
            r3.put(r5, r4)
        L_0x00e7:
            java.lang.String r4 = "mime_type"
            java.lang.String r5 = "video/mp4"
            r3.put(r4, r5)
            com.facebook.react.bridge.ReactApplicationContext r4 = _reactContext
            android.content.ContentResolver r4 = r4.getContentResolver()
            android.net.Uri r5 = android.provider.MediaStore.Video.Media.EXTERNAL_CONTENT_URI
            r4.insert(r5, r3)
            java.io.File r3 = r6.mVideoFile
            java.lang.String r3 = r3.getAbsolutePath()
            r6.addToMediaStore(r3)
            java.io.File r3 = r6.mVideoFile
            android.net.Uri r3 = android.net.Uri.fromFile(r3)
            java.lang.String r3 = r3.toString()
            r2.putString(r0, r3)
            com.facebook.react.bridge.Promise r0 = r6.mRecordingPromise
            r0.resolve(r2)
            goto L_0x0140
        L_0x0115:
            java.io.File r3 = r6.mVideoFile
            android.net.Uri r3 = android.net.Uri.fromFile(r3)
            java.lang.String r3 = r3.toString()
            r2.putString(r0, r3)
            com.facebook.react.bridge.Promise r0 = r6.mRecordingPromise
            r0.resolve(r2)
            goto L_0x0140
        L_0x0128:
            java.io.File r3 = r6.mVideoFile
            byte[] r3 = convertFileToByteArray(r3)
            java.lang.String r4 = new java.lang.String
            r4.<init>(r3, r5)
            java.lang.String r3 = "data"
            r2.putString(r3, r4)
            com.facebook.react.bridge.Promise r3 = r6.mRecordingPromise
            r3.resolve(r2)
            r0.delete()
        L_0x0140:
            r6.mRecordingPromise = r1
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.lwansbrough.RCTCamera.RCTCameraModule.releaseMediaRecorder():void");
    }

    public static byte[] convertFileToByteArray(File file) {
        try {
            FileInputStream fileInputStream = new FileInputStream(file);
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            byte[] bArr = new byte[8192];
            while (true) {
                int read = fileInputStream.read(bArr);
                if (read == -1) {
                    return byteArrayOutputStream.toByteArray();
                }
                byteArrayOutputStream.write(bArr, 0, read);
            }
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    @ReactMethod
    public void capture(final ReadableMap readableMap, final Promise promise) {
        if (RCTCamera.getInstance() == null) {
            promise.reject("Camera is not ready yet.");
            return;
        }
        int i = readableMap.hasKey("orientation") ? readableMap.getInt("orientation") : RCTCamera.getInstance().getOrientation();
        if (i == Integer.MAX_VALUE) {
            this._sensorOrientationChecker.onResume();
            this._sensorOrientationChecker.registerOrientationListener(new RCTSensorOrientationListener() {
                public void orientationEvent() {
                    int orientation = RCTCameraModule.this._sensorOrientationChecker.getOrientation();
                    RCTCameraModule.this._sensorOrientationChecker.unregisterOrientationListener();
                    RCTCameraModule.this._sensorOrientationChecker.onPause();
                    RCTCameraModule.this.captureWithOrientation(readableMap, promise, orientation);
                }
            });
            return;
        }
        captureWithOrientation(readableMap, promise, i);
    }

    /* access modifiers changed from: private */
    public void captureWithOrientation(final ReadableMap readableMap, final Promise promise, int i) {
        final Camera acquireCameraInstance = RCTCamera.getInstance().acquireCameraInstance(readableMap.getInt("type"));
        if (acquireCameraInstance == null) {
            promise.reject("No camera found.");
        } else if (readableMap.getInt("mode") == 1) {
            record(readableMap, promise, i);
        } else {
            RCTCamera.getInstance().setCaptureQuality(readableMap.getInt("type"), readableMap.getString("quality"));
            if (readableMap.hasKey("playSoundOnCapture") && readableMap.getBoolean("playSoundOnCapture")) {
                new MediaActionSound().play(0);
            }
            if (readableMap.hasKey("quality")) {
                RCTCamera.getInstance().setCaptureQuality(readableMap.getInt("type"), readableMap.getString("quality"));
            }
            RCTCamera.getInstance().adjustCameraRotationToDeviceOrientation(readableMap.getInt("type"), i);
            acquireCameraInstance.setPreviewCallback((Camera.PreviewCallback) null);
            AnonymousClass3 r1 = new Camera.PictureCallback() {
                public void onPictureTaken(final byte[] bArr, Camera camera) {
                    camera.stopPreview();
                    camera.startPreview();
                    AsyncTask.execute(new Runnable() {
                        public void run() {
                            RCTCameraModule.this.processImage(new MutableImage(bArr), readableMap, promise);
                        }
                    });
                    Boolean unused = RCTCameraModule.this.mSafeToCapture = true;
                }
            };
            AnonymousClass4 r7 = new Camera.ShutterCallback() {
                public void onShutter() {
                    try {
                        acquireCameraInstance.setPreviewCallback((Camera.PreviewCallback) null);
                        acquireCameraInstance.setPreviewTexture((SurfaceTexture) null);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            };
            if (this.mSafeToCapture.booleanValue()) {
                try {
                    acquireCameraInstance.takePicture(r7, (Camera.PictureCallback) null, r1);
                    this.mSafeToCapture = false;
                } catch (RuntimeException e) {
                    Log.e(TAG, "Couldn't capture photo.", e);
                }
            }
        }
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:129:0x0166, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized void processImage(com.lwansbrough.RCTCamera.MutableImage r12, com.facebook.react.bridge.ReadableMap r13, com.facebook.react.bridge.Promise r14) {
        /*
            r11 = this;
            monitor-enter(r11)
            java.lang.String r0 = "fixOrientation"
            boolean r0 = r13.hasKey(r0)     // Catch:{ all -> 0x0167 }
            r1 = 0
            r2 = 1
            if (r0 == 0) goto L_0x0015
            java.lang.String r0 = "fixOrientation"
            boolean r0 = r13.getBoolean(r0)     // Catch:{ all -> 0x0167 }
            if (r0 == 0) goto L_0x0015
            r0 = 1
            goto L_0x0016
        L_0x0015:
            r0 = 0
        L_0x0016:
            if (r0 == 0) goto L_0x0022
            r12.fixOrientation()     // Catch:{ ImageMutationFailedException -> 0x001c }
            goto L_0x0022
        L_0x001c:
            r0 = move-exception
            java.lang.String r3 = "Error fixing orientation image"
            r14.reject((java.lang.String) r3, (java.lang.Throwable) r0)     // Catch:{ all -> 0x0167 }
        L_0x0022:
            int r0 = r12.getWidth()     // Catch:{ all -> 0x0167 }
            double r3 = (double) r0     // Catch:{ all -> 0x0167 }
            int r0 = r12.getHeight()     // Catch:{ all -> 0x0167 }
            double r5 = (double) r0
            java.lang.Double.isNaN(r3)
            java.lang.Double.isNaN(r5)
            double r3 = r3 / r5
            r5 = 4607182418800017408(0x3ff0000000000000, double:1.0)
            java.lang.String r0 = "type"
            int r0 = r13.getInt(r0)     // Catch:{ IllegalArgumentException -> 0x0069 }
            com.lwansbrough.RCTCamera.RCTCamera r7 = com.lwansbrough.RCTCamera.RCTCamera.getInstance()     // Catch:{ IllegalArgumentException -> 0x0069 }
            int r7 = r7.getPreviewVisibleWidth(r0)     // Catch:{ IllegalArgumentException -> 0x0069 }
            double r7 = (double) r7     // Catch:{ IllegalArgumentException -> 0x0069 }
            com.lwansbrough.RCTCamera.RCTCamera r9 = com.lwansbrough.RCTCamera.RCTCamera.getInstance()     // Catch:{ IllegalArgumentException -> 0x0069 }
            int r0 = r9.getPreviewVisibleHeight(r0)     // Catch:{ IllegalArgumentException -> 0x0069 }
            double r9 = (double) r0
            java.lang.Double.isNaN(r7)
            java.lang.Double.isNaN(r9)
            double r7 = r7 / r9
            int r0 = (r7 > r5 ? 1 : (r7 == r5 ? 0 : -1))
            if (r0 <= 0) goto L_0x005a
            r0 = 1
            goto L_0x005b
        L_0x005a:
            r0 = 0
        L_0x005b:
            int r9 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r9 <= 0) goto L_0x0061
            r3 = 1
            goto L_0x0062
        L_0x0061:
            r3 = 0
        L_0x0062:
            if (r0 == r3) goto L_0x0066
            r0 = 1
            goto L_0x0067
        L_0x0066:
            r0 = 0
        L_0x0067:
            r3 = r7
            goto L_0x006a
        L_0x0069:
            r0 = 0
        L_0x006a:
            java.lang.String r7 = "cropToPreview"
            boolean r7 = r13.hasKey(r7)     // Catch:{ all -> 0x0167 }
            if (r7 == 0) goto L_0x007c
            java.lang.String r7 = "cropToPreview"
            boolean r7 = r13.getBoolean(r7)     // Catch:{ all -> 0x0167 }
            if (r7 == 0) goto L_0x007c
            r7 = 1
            goto L_0x007d
        L_0x007c:
            r7 = 0
        L_0x007d:
            if (r7 == 0) goto L_0x008d
            if (r0 == 0) goto L_0x0083
            double r3 = r5 / r3
        L_0x0083:
            r12.cropToPreview(r3)     // Catch:{ IllegalArgumentException -> 0x0087 }
            goto L_0x008d
        L_0x0087:
            r3 = move-exception
            java.lang.String r4 = "Error cropping image to preview"
            r14.reject((java.lang.String) r4, (java.lang.Throwable) r3)     // Catch:{ all -> 0x0167 }
        L_0x008d:
            java.lang.String r3 = "mirrorImage"
            boolean r3 = r13.hasKey(r3)     // Catch:{ all -> 0x0167 }
            if (r3 == 0) goto L_0x009e
            java.lang.String r3 = "mirrorImage"
            boolean r3 = r13.getBoolean(r3)     // Catch:{ all -> 0x0167 }
            if (r3 == 0) goto L_0x009e
            r1 = 1
        L_0x009e:
            if (r1 == 0) goto L_0x00aa
            r12.mirrorImage()     // Catch:{ ImageMutationFailedException -> 0x00a4 }
            goto L_0x00aa
        L_0x00a4:
            r1 = move-exception
            java.lang.String r3 = "Error mirroring image"
            r14.reject((java.lang.String) r3, (java.lang.Throwable) r1)     // Catch:{ all -> 0x0167 }
        L_0x00aa:
            r1 = 80
            java.lang.String r3 = "jpegQuality"
            boolean r3 = r13.hasKey(r3)     // Catch:{ all -> 0x0167 }
            if (r3 == 0) goto L_0x00ba
            java.lang.String r1 = "jpegQuality"
            int r1 = r13.getInt(r1)     // Catch:{ all -> 0x0167 }
        L_0x00ba:
            if (r0 == 0) goto L_0x00c1
            int r3 = r12.getHeight()     // Catch:{ all -> 0x0167 }
            goto L_0x00c5
        L_0x00c1:
            int r3 = r12.getWidth()     // Catch:{ all -> 0x0167 }
        L_0x00c5:
            r6 = r3
            if (r0 == 0) goto L_0x00cd
            int r0 = r12.getWidth()     // Catch:{ all -> 0x0167 }
            goto L_0x00d1
        L_0x00cd:
            int r0 = r12.getHeight()     // Catch:{ all -> 0x0167 }
        L_0x00d1:
            r7 = r0
            java.lang.String r0 = "target"
            int r0 = r13.getInt(r0)     // Catch:{ all -> 0x0167 }
            if (r0 == 0) goto L_0x014a
            if (r0 == r2) goto L_0x012b
            r3 = 2
            if (r0 == r3) goto L_0x0103
            r3 = 3
            if (r0 == r3) goto L_0x00e4
            goto L_0x0165
        L_0x00e4:
            java.io.File r5 = r11.getTempMediaFile(r2)     // Catch:{ all -> 0x0167 }
            if (r5 != 0) goto L_0x00f1
            java.lang.String r12 = "Error creating media file."
            r14.reject((java.lang.String) r12)     // Catch:{ all -> 0x0167 }
            monitor-exit(r11)
            return
        L_0x00f1:
            r12.writeDataToFile(r5, r13, r1)     // Catch:{ IOException -> 0x00fb }
            r9 = 0
            r4 = r11
            r8 = r14
            r4.resolveImage(r5, r6, r7, r8, r9)     // Catch:{ all -> 0x0167 }
            goto L_0x0165
        L_0x00fb:
            r12 = move-exception
            java.lang.String r13 = "failed to save image file"
            r14.reject((java.lang.String) r13, (java.lang.Throwable) r12)     // Catch:{ all -> 0x0167 }
            monitor-exit(r11)
            return
        L_0x0103:
            java.io.File r5 = r11.getOutputCameraRollFile(r2)     // Catch:{ all -> 0x0167 }
            if (r5 != 0) goto L_0x0110
            java.lang.String r12 = "Error creating media file."
            r14.reject((java.lang.String) r12)     // Catch:{ all -> 0x0167 }
            monitor-exit(r11)
            return
        L_0x0110:
            r12.writeDataToFile(r5, r13, r1)     // Catch:{ IOException -> 0x0123, NullPointerException -> 0x0121 }
            java.lang.String r12 = r5.getAbsolutePath()     // Catch:{ all -> 0x0167 }
            r11.addToMediaStore(r12)     // Catch:{ all -> 0x0167 }
            r9 = 1
            r4 = r11
            r8 = r14
            r4.resolveImage(r5, r6, r7, r8, r9)     // Catch:{ all -> 0x0167 }
            goto L_0x0165
        L_0x0121:
            r12 = move-exception
            goto L_0x0124
        L_0x0123:
            r12 = move-exception
        L_0x0124:
            java.lang.String r13 = "failed to save image file"
            r14.reject((java.lang.String) r13, (java.lang.Throwable) r12)     // Catch:{ all -> 0x0167 }
            monitor-exit(r11)
            return
        L_0x012b:
            java.io.File r5 = r11.getOutputMediaFile(r2)     // Catch:{ all -> 0x0167 }
            if (r5 != 0) goto L_0x0138
            java.lang.String r12 = "Error creating media file."
            r14.reject((java.lang.String) r12)     // Catch:{ all -> 0x0167 }
            monitor-exit(r11)
            return
        L_0x0138:
            r12.writeDataToFile(r5, r13, r1)     // Catch:{ IOException -> 0x0142 }
            r9 = 0
            r4 = r11
            r8 = r14
            r4.resolveImage(r5, r6, r7, r8, r9)     // Catch:{ all -> 0x0167 }
            goto L_0x0165
        L_0x0142:
            r12 = move-exception
            java.lang.String r13 = "failed to save image file"
            r14.reject((java.lang.String) r13, (java.lang.Throwable) r12)     // Catch:{ all -> 0x0167 }
            monitor-exit(r11)
            return
        L_0x014a:
            java.lang.String r12 = r12.toBase64(r1)     // Catch:{ all -> 0x0167 }
            com.facebook.react.bridge.WritableNativeMap r13 = new com.facebook.react.bridge.WritableNativeMap     // Catch:{ all -> 0x0167 }
            r13.<init>()     // Catch:{ all -> 0x0167 }
            java.lang.String r0 = "data"
            r13.putString(r0, r12)     // Catch:{ all -> 0x0167 }
            java.lang.String r12 = "width"
            r13.putInt(r12, r6)     // Catch:{ all -> 0x0167 }
            java.lang.String r12 = "height"
            r13.putInt(r12, r7)     // Catch:{ all -> 0x0167 }
            r14.resolve(r13)     // Catch:{ all -> 0x0167 }
        L_0x0165:
            monitor-exit(r11)
            return
        L_0x0167:
            r12 = move-exception
            monitor-exit(r11)
            throw r12
        */
        throw new UnsupportedOperationException("Method not decompiled: com.lwansbrough.RCTCamera.RCTCameraModule.processImage(com.lwansbrough.RCTCamera.MutableImage, com.facebook.react.bridge.ReadableMap, com.facebook.react.bridge.Promise):void");
    }

    @ReactMethod
    public void stopCapture(Promise promise) {
        if (this.mRecordingPromise != null) {
            releaseMediaRecorder();
            promise.resolve("Finished recording.");
            return;
        }
        promise.resolve("Not recording.");
    }

    @ReactMethod
    public void hasFlash(ReadableMap readableMap, Promise promise) {
        Camera acquireCameraInstance = RCTCamera.getInstance().acquireCameraInstance(readableMap.getInt("type"));
        if (acquireCameraInstance == null) {
            promise.reject("No camera found.");
            return;
        }
        List<String> supportedFlashModes = acquireCameraInstance.getParameters().getSupportedFlashModes();
        promise.resolve(Boolean.valueOf(supportedFlashModes != null && !supportedFlashModes.isEmpty()));
    }

    @ReactMethod
    public void setZoom(ReadableMap readableMap, int i) {
        Camera acquireCameraInstance;
        RCTCamera instance = RCTCamera.getInstance();
        if (instance != null && (acquireCameraInstance = instance.acquireCameraInstance(readableMap.getInt("type"))) != null) {
            Camera.Parameters parameters = acquireCameraInstance.getParameters();
            int maxZoom = parameters.getMaxZoom();
            if (parameters.isZoomSupported() && i >= 0 && i < maxZoom) {
                parameters.setZoom(i);
                try {
                    acquireCameraInstance.setParameters(parameters);
                } catch (RuntimeException e) {
                    Log.e(TAG, "setParameters failed", e);
                }
            }
        }
    }

    private File getOutputMediaFile(int i) {
        String str;
        if (i == 1) {
            str = Environment.DIRECTORY_PICTURES;
        } else if (i == 2) {
            str = Environment.DIRECTORY_MOVIES;
        } else {
            Log.e(TAG, "Unsupported media type:" + i);
            return null;
        }
        return getOutputFile(i, Environment.getExternalStoragePublicDirectory(str));
    }

    private File getOutputCameraRollFile(int i) {
        return getOutputFile(i, Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DCIM));
    }

    private File getOutputFile(int i, File file) {
        String str;
        if (file.exists() || file.mkdirs()) {
            String format = String.format("%s", new Object[]{new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date())});
            if (i == 1) {
                str = String.format("IMG_%s.jpg", new Object[]{format});
            } else if (i == 2) {
                str = String.format("VID_%s.mp4", new Object[]{format});
            } else {
                Log.e(TAG, "Unsupported media type:" + i);
                return null;
            }
            return new File(String.format("%s%s%s", new Object[]{file.getPath(), File.separator, str}));
        }
        Log.e(TAG, "failed to create directory:" + file.getAbsolutePath());
        return null;
    }

    private File getTempMediaFile(int i) {
        try {
            String format = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
            File cacheDir = _reactContext.getCacheDir();
            if (i == 1) {
                return File.createTempFile("IMG_" + format, ".jpg", cacheDir);
            } else if (i == 2) {
                return File.createTempFile("VID_" + format, ".mp4", cacheDir);
            } else {
                Log.e(TAG, "Unsupported media type:" + i);
                return null;
            }
        } catch (Exception e) {
            Log.e(TAG, e.getMessage());
            return null;
        }
    }

    private void addToMediaStore(String str) {
        MediaScannerConnection.scanFile(_reactContext, new String[]{str}, (String[]) null, (MediaScannerConnection.OnScanCompletedListener) null);
    }

    public void onHostResume() {
        this.mSafeToCapture = true;
    }

    public void onHostPause() {
        if (this.mRecordingPromise != null) {
            releaseMediaRecorder();
        }
    }

    private void resolveImage(File file, int i, int i2, final Promise promise, boolean z) {
        final WritableNativeMap writableNativeMap = new WritableNativeMap();
        writableNativeMap.putString("path", Uri.fromFile(file).toString());
        writableNativeMap.putInt("width", i);
        writableNativeMap.putInt("height", i2);
        if (z) {
            MediaScannerConnection.scanFile(_reactContext, new String[]{file.getAbsolutePath()}, (String[]) null, new MediaScannerConnection.OnScanCompletedListener() {
                public void onScanCompleted(String str, Uri uri) {
                    if (uri != null) {
                        writableNativeMap.putString("mediaUri", uri.toString());
                    }
                    promise.resolve(writableNativeMap);
                }
            });
            return;
        }
        promise.resolve(writableNativeMap);
    }
}
