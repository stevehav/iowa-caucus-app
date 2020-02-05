package org.reactnative.camera;

import android.annotation.SuppressLint;
import android.media.CamcorderProfile;
import android.media.MediaActionSound;
import android.os.AsyncTask;
import android.os.Build;
import android.view.View;
import androidx.core.content.ContextCompat;
import androidx.core.view.ViewCompat;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.LifecycleEventListener;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.WritableArray;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.uimanager.ThemedReactContext;
import com.google.android.cameraview.CameraView;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.DecodeHintType;
import com.google.zxing.MultiFormatReader;
import com.google.zxing.Result;
import java.io.File;
import java.io.IOException;
import java.util.EnumMap;
import java.util.EnumSet;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;
import org.reactnative.barcodedetector.RNBarcodeDetector;
import org.reactnative.camera.tasks.BarCodeScannerAsyncTaskDelegate;
import org.reactnative.camera.tasks.BarcodeDetectorAsyncTaskDelegate;
import org.reactnative.camera.tasks.FaceDetectorAsyncTaskDelegate;
import org.reactnative.camera.tasks.PictureSavedDelegate;
import org.reactnative.camera.tasks.ResolveTakenPictureAsyncTask;
import org.reactnative.camera.tasks.TextRecognizerAsyncTaskDelegate;
import org.reactnative.camera.utils.RNFileUtils;
import org.reactnative.facedetector.RNFaceDetector;

public class RNCameraView extends CameraView implements LifecycleEventListener, BarCodeScannerAsyncTaskDelegate, FaceDetectorAsyncTaskDelegate, BarcodeDetectorAsyncTaskDelegate, TextRecognizerAsyncTaskDelegate, PictureSavedDelegate {
    public volatile boolean barCodeScannerTaskLock = false;
    public volatile boolean faceDetectorTaskLock = false;
    public volatile boolean googleBarcodeDetectorTaskLock = false;
    /* access modifiers changed from: private */
    public boolean invertImageData = false;
    private List<String> mBarCodeTypes = null;
    private int mFaceDetectionClassifications = RNFaceDetector.NO_CLASSIFICATIONS;
    private int mFaceDetectionLandmarks = RNFaceDetector.NO_LANDMARKS;
    /* access modifiers changed from: private */
    public RNFaceDetector mFaceDetector;
    private int mFaceDetectorMode = RNFaceDetector.FAST_MODE;
    /* access modifiers changed from: private */
    public RNBarcodeDetector mGoogleBarcodeDetector;
    /* access modifiers changed from: private */
    public int mGoogleVisionBarCodeMode = RNBarcodeDetector.NORMAL_MODE;
    private int mGoogleVisionBarCodeType = RNBarcodeDetector.ALL_FORMATS;
    /* access modifiers changed from: private */
    public boolean mIsNew = true;
    /* access modifiers changed from: private */
    public boolean mIsPaused = false;
    /* access modifiers changed from: private */
    public Boolean mIsRecording = false;
    /* access modifiers changed from: private */
    public Boolean mIsRecordingInterrupted = false;
    /* access modifiers changed from: private */
    public MultiFormatReader mMultiFormatReader;
    /* access modifiers changed from: private */
    public int mPaddingX;
    /* access modifiers changed from: private */
    public int mPaddingY;
    /* access modifiers changed from: private */
    public Map<Promise, File> mPictureTakenDirectories = new ConcurrentHashMap();
    /* access modifiers changed from: private */
    public Map<Promise, ReadableMap> mPictureTakenOptions = new ConcurrentHashMap();
    /* access modifiers changed from: private */
    public Queue<Promise> mPictureTakenPromises = new ConcurrentLinkedQueue();
    /* access modifiers changed from: private */
    public Boolean mPlaySoundOnCapture = false;
    /* access modifiers changed from: private */
    public boolean mShouldDetectFaces = false;
    /* access modifiers changed from: private */
    public boolean mShouldGoogleDetectBarcodes = false;
    /* access modifiers changed from: private */
    public boolean mShouldRecognizeText = false;
    /* access modifiers changed from: private */
    public boolean mShouldScanBarCodes = false;
    /* access modifiers changed from: private */
    public ThemedReactContext mThemedReactContext;
    private boolean mTrackingEnabled = true;
    /* access modifiers changed from: private */
    public Promise mVideoRecordedPromise;
    public volatile boolean textRecognizerTaskLock = false;

    @SuppressLint({"all"})
    public void requestLayout() {
    }

    public RNCameraView(ThemedReactContext themedReactContext) {
        super(themedReactContext, true);
        this.mThemedReactContext = themedReactContext;
        themedReactContext.addLifecycleEventListener(this);
        addCallback(new CameraView.Callback() {
            public void onCameraOpened(CameraView cameraView) {
                RNCameraViewHelper.emitCameraReadyEvent(cameraView);
            }

            public void onMountError(CameraView cameraView) {
                RNCameraViewHelper.emitMountErrorEvent(cameraView, "Camera view threw an error - component could not be rendered.");
            }

            public void onPictureTaken(CameraView cameraView, byte[] bArr, int i) {
                Promise promise = (Promise) RNCameraView.this.mPictureTakenPromises.poll();
                ReadableMap readableMap = (ReadableMap) RNCameraView.this.mPictureTakenOptions.remove(promise);
                if (readableMap.hasKey("fastMode") && readableMap.getBoolean("fastMode")) {
                    promise.resolve((Object) null);
                }
                File file = (File) RNCameraView.this.mPictureTakenDirectories.remove(promise);
                if (Build.VERSION.SDK_INT >= 11) {
                    new ResolveTakenPictureAsyncTask(bArr, promise, readableMap, file, i, RNCameraView.this).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
                } else {
                    new ResolveTakenPictureAsyncTask(bArr, promise, readableMap, file, i, RNCameraView.this).execute(new Void[0]);
                }
                RNCameraViewHelper.emitPictureTakenEvent(cameraView);
            }

            public void onVideoRecorded(CameraView cameraView, String str, int i, int i2) {
                if (RNCameraView.this.mVideoRecordedPromise != null) {
                    if (str != null) {
                        WritableMap createMap = Arguments.createMap();
                        createMap.putBoolean("isRecordingInterrupted", RNCameraView.this.mIsRecordingInterrupted.booleanValue());
                        createMap.putInt("videoOrientation", i);
                        createMap.putInt("deviceOrientation", i2);
                        createMap.putString("uri", RNFileUtils.uriFromFile(new File(str)).toString());
                        RNCameraView.this.mVideoRecordedPromise.resolve(createMap);
                    } else {
                        RNCameraView.this.mVideoRecordedPromise.reject("E_RECORDING", "Couldn't stop recording - there is none in progress");
                    }
                    Boolean unused = RNCameraView.this.mIsRecording = false;
                    Boolean unused2 = RNCameraView.this.mIsRecordingInterrupted = false;
                    Promise unused3 = RNCameraView.this.mVideoRecordedPromise = null;
                }
            }

            /* JADX WARNING: type inference failed for: r15v2 */
            /* JADX WARNING: type inference failed for: r15v4 */
            /* JADX WARNING: Incorrect type for immutable var: ssa=int, code=?, for r15v1, types: [boolean, int] */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public void onFramePreview(com.google.android.cameraview.CameraView r26, byte[] r27, int r28, int r29, int r30) {
                /*
                    r25 = this;
                    r0 = r25
                    r1 = r26
                    r15 = r27
                    org.reactnative.camera.RNCameraView r2 = org.reactnative.camera.RNCameraView.this
                    int r2 = r2.getFacing()
                    org.reactnative.camera.RNCameraView r3 = org.reactnative.camera.RNCameraView.this
                    int r3 = r3.getCameraOrientation()
                    r4 = r30
                    int r16 = org.reactnative.camera.RNCameraViewHelper.getCorrectCameraRotation(r4, r2, r3)
                    org.reactnative.camera.RNCameraView r2 = org.reactnative.camera.RNCameraView.this
                    boolean r2 = r2.mShouldScanBarCodes
                    r14 = 0
                    r13 = 1
                    if (r2 == 0) goto L_0x002e
                    org.reactnative.camera.RNCameraView r2 = org.reactnative.camera.RNCameraView.this
                    boolean r2 = r2.barCodeScannerTaskLock
                    if (r2 != 0) goto L_0x002e
                    boolean r2 = r1 instanceof org.reactnative.camera.tasks.BarCodeScannerAsyncTaskDelegate
                    if (r2 == 0) goto L_0x002e
                    r2 = 1
                    goto L_0x002f
                L_0x002e:
                    r2 = 0
                L_0x002f:
                    org.reactnative.camera.RNCameraView r3 = org.reactnative.camera.RNCameraView.this
                    boolean r3 = r3.mShouldDetectFaces
                    if (r3 == 0) goto L_0x0043
                    org.reactnative.camera.RNCameraView r3 = org.reactnative.camera.RNCameraView.this
                    boolean r3 = r3.faceDetectorTaskLock
                    if (r3 != 0) goto L_0x0043
                    boolean r3 = r1 instanceof org.reactnative.camera.tasks.FaceDetectorAsyncTaskDelegate
                    if (r3 == 0) goto L_0x0043
                    r8 = 1
                    goto L_0x0044
                L_0x0043:
                    r8 = 0
                L_0x0044:
                    org.reactnative.camera.RNCameraView r3 = org.reactnative.camera.RNCameraView.this
                    boolean r3 = r3.mShouldGoogleDetectBarcodes
                    if (r3 == 0) goto L_0x0059
                    org.reactnative.camera.RNCameraView r3 = org.reactnative.camera.RNCameraView.this
                    boolean r3 = r3.googleBarcodeDetectorTaskLock
                    if (r3 != 0) goto L_0x0059
                    boolean r3 = r1 instanceof org.reactnative.camera.tasks.BarcodeDetectorAsyncTaskDelegate
                    if (r3 == 0) goto L_0x0059
                    r17 = 1
                    goto L_0x005b
                L_0x0059:
                    r17 = 0
                L_0x005b:
                    org.reactnative.camera.RNCameraView r3 = org.reactnative.camera.RNCameraView.this
                    boolean r3 = r3.mShouldRecognizeText
                    if (r3 == 0) goto L_0x0070
                    org.reactnative.camera.RNCameraView r3 = org.reactnative.camera.RNCameraView.this
                    boolean r3 = r3.textRecognizerTaskLock
                    if (r3 != 0) goto L_0x0070
                    boolean r3 = r1 instanceof org.reactnative.camera.tasks.TextRecognizerAsyncTaskDelegate
                    if (r3 == 0) goto L_0x0070
                    r18 = 1
                    goto L_0x0072
                L_0x0070:
                    r18 = 0
                L_0x0072:
                    if (r2 != 0) goto L_0x007b
                    if (r8 != 0) goto L_0x007b
                    if (r17 != 0) goto L_0x007b
                    if (r18 != 0) goto L_0x007b
                    return
                L_0x007b:
                    int r3 = r15.length
                    double r3 = (double) r3
                    r5 = 4609434218613702656(0x3ff8000000000000, double:1.5)
                    r12 = r28
                    double r9 = (double) r12
                    java.lang.Double.isNaN(r9)
                    double r9 = r9 * r5
                    r11 = r29
                    double r5 = (double) r11
                    java.lang.Double.isNaN(r5)
                    double r9 = r9 * r5
                    int r5 = (r3 > r9 ? 1 : (r3 == r9 ? 0 : -1))
                    if (r5 >= 0) goto L_0x0094
                    return
                L_0x0094:
                    if (r2 == 0) goto L_0x00b2
                    org.reactnative.camera.RNCameraView r2 = org.reactnative.camera.RNCameraView.this
                    r2.barCodeScannerTaskLock = r13
                    r3 = r1
                    org.reactnative.camera.tasks.BarCodeScannerAsyncTaskDelegate r3 = (org.reactnative.camera.tasks.BarCodeScannerAsyncTaskDelegate) r3
                    org.reactnative.camera.tasks.BarCodeScannerAsyncTask r9 = new org.reactnative.camera.tasks.BarCodeScannerAsyncTask
                    com.google.zxing.MultiFormatReader r4 = r2.mMultiFormatReader
                    r2 = r9
                    r5 = r27
                    r6 = r28
                    r7 = r29
                    r2.<init>(r3, r4, r5, r6, r7)
                    java.lang.Void[] r2 = new java.lang.Void[r14]
                    r9.execute(r2)
                L_0x00b2:
                    if (r8 == 0) goto L_0x010a
                    org.reactnative.camera.RNCameraView r2 = org.reactnative.camera.RNCameraView.this
                    r2.faceDetectorTaskLock = r13
                    r3 = r1
                    org.reactnative.camera.tasks.FaceDetectorAsyncTaskDelegate r3 = (org.reactnative.camera.tasks.FaceDetectorAsyncTaskDelegate) r3
                    org.reactnative.camera.tasks.FaceDetectorAsyncTask r10 = new org.reactnative.camera.tasks.FaceDetectorAsyncTask
                    org.reactnative.facedetector.RNFaceDetector r4 = r2.mFaceDetector
                    org.reactnative.camera.RNCameraView r2 = org.reactnative.camera.RNCameraView.this
                    android.content.res.Resources r2 = r2.getResources()
                    android.util.DisplayMetrics r2 = r2.getDisplayMetrics()
                    float r9 = r2.density
                    org.reactnative.camera.RNCameraView r2 = org.reactnative.camera.RNCameraView.this
                    int r19 = r2.getFacing()
                    org.reactnative.camera.RNCameraView r2 = org.reactnative.camera.RNCameraView.this
                    int r20 = r2.getWidth()
                    org.reactnative.camera.RNCameraView r2 = org.reactnative.camera.RNCameraView.this
                    int r21 = r2.getHeight()
                    org.reactnative.camera.RNCameraView r2 = org.reactnative.camera.RNCameraView.this
                    int r22 = r2.mPaddingX
                    org.reactnative.camera.RNCameraView r2 = org.reactnative.camera.RNCameraView.this
                    int r23 = r2.mPaddingY
                    r2 = r10
                    r5 = r27
                    r6 = r28
                    r7 = r29
                    r8 = r16
                    r1 = r10
                    r10 = r19
                    r11 = r20
                    r12 = r21
                    r15 = 1
                    r13 = r22
                    r15 = 0
                    r14 = r23
                    r2.<init>(r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14)
                    java.lang.Void[] r2 = new java.lang.Void[r15]
                    r1.execute(r2)
                    goto L_0x010b
                L_0x010a:
                    r15 = 0
                L_0x010b:
                    if (r17 == 0) goto L_0x01b3
                    org.reactnative.camera.RNCameraView r1 = org.reactnative.camera.RNCameraView.this
                    r2 = 1
                    r1.googleBarcodeDetectorTaskLock = r2
                    int r1 = r1.mGoogleVisionBarCodeMode
                    int r2 = org.reactnative.barcodedetector.RNBarcodeDetector.NORMAL_MODE
                    if (r1 != r2) goto L_0x0121
                    org.reactnative.camera.RNCameraView r1 = org.reactnative.camera.RNCameraView.this
                    boolean unused = r1.invertImageData = r15
                    r3 = 1
                    goto L_0x0147
                L_0x0121:
                    org.reactnative.camera.RNCameraView r1 = org.reactnative.camera.RNCameraView.this
                    int r1 = r1.mGoogleVisionBarCodeMode
                    int r2 = org.reactnative.barcodedetector.RNBarcodeDetector.ALTERNATE_MODE
                    if (r1 != r2) goto L_0x0137
                    org.reactnative.camera.RNCameraView r1 = org.reactnative.camera.RNCameraView.this
                    boolean r2 = r1.invertImageData
                    r3 = 1
                    r2 = r2 ^ r3
                    boolean unused = r1.invertImageData = r2
                    goto L_0x0147
                L_0x0137:
                    r3 = 1
                    org.reactnative.camera.RNCameraView r1 = org.reactnative.camera.RNCameraView.this
                    int r1 = r1.mGoogleVisionBarCodeMode
                    int r2 = org.reactnative.barcodedetector.RNBarcodeDetector.INVERTED_MODE
                    if (r1 != r2) goto L_0x0147
                    org.reactnative.camera.RNCameraView r1 = org.reactnative.camera.RNCameraView.this
                    boolean unused = r1.invertImageData = r3
                L_0x0147:
                    org.reactnative.camera.RNCameraView r1 = org.reactnative.camera.RNCameraView.this
                    boolean r1 = r1.invertImageData
                    if (r1 == 0) goto L_0x0160
                    r1 = r27
                    r2 = 0
                    r14 = 1
                L_0x0153:
                    int r3 = r1.length
                    if (r2 >= r3) goto L_0x0163
                    byte r3 = r1[r2]
                    r3 = r3 ^ -1
                    byte r3 = (byte) r3
                    r1[r2] = r3
                    int r2 = r2 + 1
                    goto L_0x0153
                L_0x0160:
                    r1 = r27
                    r14 = 1
                L_0x0163:
                    r3 = r26
                    org.reactnative.camera.tasks.BarcodeDetectorAsyncTaskDelegate r3 = (org.reactnative.camera.tasks.BarcodeDetectorAsyncTaskDelegate) r3
                    org.reactnative.camera.tasks.BarcodeDetectorAsyncTask r13 = new org.reactnative.camera.tasks.BarcodeDetectorAsyncTask
                    org.reactnative.camera.RNCameraView r2 = org.reactnative.camera.RNCameraView.this
                    org.reactnative.barcodedetector.RNBarcodeDetector r4 = r2.mGoogleBarcodeDetector
                    org.reactnative.camera.RNCameraView r2 = org.reactnative.camera.RNCameraView.this
                    android.content.res.Resources r2 = r2.getResources()
                    android.util.DisplayMetrics r2 = r2.getDisplayMetrics()
                    float r9 = r2.density
                    org.reactnative.camera.RNCameraView r2 = org.reactnative.camera.RNCameraView.this
                    int r10 = r2.getFacing()
                    org.reactnative.camera.RNCameraView r2 = org.reactnative.camera.RNCameraView.this
                    int r11 = r2.getWidth()
                    org.reactnative.camera.RNCameraView r2 = org.reactnative.camera.RNCameraView.this
                    int r12 = r2.getHeight()
                    org.reactnative.camera.RNCameraView r2 = org.reactnative.camera.RNCameraView.this
                    int r17 = r2.mPaddingX
                    org.reactnative.camera.RNCameraView r2 = org.reactnative.camera.RNCameraView.this
                    int r19 = r2.mPaddingY
                    r2 = r13
                    r5 = r27
                    r6 = r28
                    r7 = r29
                    r8 = r16
                    r24 = r13
                    r13 = r17
                    r14 = r19
                    r2.<init>(r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14)
                    java.lang.Void[] r2 = new java.lang.Void[r15]
                    r3 = r24
                    r3.execute(r2)
                    goto L_0x01b5
                L_0x01b3:
                    r1 = r27
                L_0x01b5:
                    if (r18 == 0) goto L_0x0203
                    org.reactnative.camera.RNCameraView r2 = org.reactnative.camera.RNCameraView.this
                    r3 = 1
                    r2.textRecognizerTaskLock = r3
                    r3 = r26
                    org.reactnative.camera.tasks.TextRecognizerAsyncTaskDelegate r3 = (org.reactnative.camera.tasks.TextRecognizerAsyncTaskDelegate) r3
                    org.reactnative.camera.tasks.TextRecognizerAsyncTask r14 = new org.reactnative.camera.tasks.TextRecognizerAsyncTask
                    com.facebook.react.uimanager.ThemedReactContext r4 = r2.mThemedReactContext
                    org.reactnative.camera.RNCameraView r2 = org.reactnative.camera.RNCameraView.this
                    android.content.res.Resources r2 = r2.getResources()
                    android.util.DisplayMetrics r2 = r2.getDisplayMetrics()
                    float r8 = r2.density
                    org.reactnative.camera.RNCameraView r2 = org.reactnative.camera.RNCameraView.this
                    int r9 = r2.getFacing()
                    org.reactnative.camera.RNCameraView r2 = org.reactnative.camera.RNCameraView.this
                    int r10 = r2.getWidth()
                    org.reactnative.camera.RNCameraView r2 = org.reactnative.camera.RNCameraView.this
                    int r11 = r2.getHeight()
                    org.reactnative.camera.RNCameraView r2 = org.reactnative.camera.RNCameraView.this
                    int r12 = r2.mPaddingX
                    org.reactnative.camera.RNCameraView r2 = org.reactnative.camera.RNCameraView.this
                    int r13 = r2.mPaddingY
                    r1 = r14
                    r2 = r3
                    r3 = r4
                    r4 = r27
                    r5 = r28
                    r6 = r29
                    r7 = r16
                    r1.<init>(r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13)
                    java.lang.Void[] r1 = new java.lang.Void[r15]
                    r14.execute(r1)
                L_0x0203:
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: org.reactnative.camera.RNCameraView.AnonymousClass1.onFramePreview(com.google.android.cameraview.CameraView, byte[], int, int, int):void");
            }
        });
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int i5;
        int i6;
        View view = getView();
        if (view != null) {
            float f = (float) (i3 - i);
            float f2 = (float) (i4 - i2);
            float f3 = getAspectRatio().toFloat();
            int i7 = getResources().getConfiguration().orientation;
            setBackgroundColor(ViewCompat.MEASURED_STATE_MASK);
            if (i7 == 2) {
                float f4 = f3 * f2;
                if (f4 < f) {
                    i6 = (int) (f / f3);
                } else {
                    i5 = (int) f4;
                    i6 = (int) f2;
                    int i8 = (int) ((f - ((float) i5)) / 2.0f);
                    int i9 = (int) ((f2 - ((float) i6)) / 2.0f);
                    this.mPaddingX = i8;
                    this.mPaddingY = i9;
                    view.layout(i8, i9, i5 + i8, i6 + i9);
                }
            } else {
                float f5 = f3 * f;
                if (f5 > f2) {
                    i6 = (int) f5;
                } else {
                    i5 = (int) (f2 / f3);
                    i6 = (int) f2;
                    int i82 = (int) ((f - ((float) i5)) / 2.0f);
                    int i92 = (int) ((f2 - ((float) i6)) / 2.0f);
                    this.mPaddingX = i82;
                    this.mPaddingY = i92;
                    view.layout(i82, i92, i5 + i82, i6 + i92);
                }
            }
            i5 = (int) f;
            int i822 = (int) ((f - ((float) i5)) / 2.0f);
            int i922 = (int) ((f2 - ((float) i6)) / 2.0f);
            this.mPaddingX = i822;
            this.mPaddingY = i922;
            view.layout(i822, i922, i5 + i822, i6 + i922);
        }
    }

    public void setBarCodeTypes(List<String> list) {
        this.mBarCodeTypes = list;
        initBarcodeReader();
    }

    public void setPlaySoundOnCapture(Boolean bool) {
        this.mPlaySoundOnCapture = bool;
    }

    public void takePicture(final ReadableMap readableMap, final Promise promise, final File file) {
        this.mBgHandler.post(new Runnable() {
            public void run() {
                RNCameraView.this.mPictureTakenPromises.add(promise);
                RNCameraView.this.mPictureTakenOptions.put(promise, readableMap);
                RNCameraView.this.mPictureTakenDirectories.put(promise, file);
                if (RNCameraView.this.mPlaySoundOnCapture.booleanValue()) {
                    new MediaActionSound().play(0);
                }
                try {
                    RNCameraView.super.takePicture(readableMap);
                } catch (Exception e) {
                    RNCameraView.this.mPictureTakenPromises.remove(promise);
                    RNCameraView.this.mPictureTakenOptions.remove(promise);
                    RNCameraView.this.mPictureTakenDirectories.remove(promise);
                    promise.reject("E_TAKE_PICTURE_FAILED", e.getMessage());
                }
            }
        });
    }

    public void onPictureSaved(WritableMap writableMap) {
        RNCameraViewHelper.emitPictureSavedEvent(this, writableMap);
    }

    public void record(final ReadableMap readableMap, final Promise promise, final File file) {
        this.mBgHandler.post(new Runnable() {
            public void run() {
                try {
                    String string = readableMap.hasKey("path") ? readableMap.getString("path") : RNFileUtils.getOutputFilePath(file, ".mp4");
                    int i = readableMap.hasKey("maxDuration") ? readableMap.getInt("maxDuration") : -1;
                    int i2 = readableMap.hasKey("maxFileSize") ? readableMap.getInt("maxFileSize") : -1;
                    CamcorderProfile camcorderProfile = readableMap.hasKey("quality") ? RNCameraViewHelper.getCamcorderProfile(readableMap.getInt("quality")) : CamcorderProfile.get(1);
                    if (readableMap.hasKey("videoBitrate")) {
                        camcorderProfile.videoBitRate = readableMap.getInt("videoBitrate");
                    }
                    if (RNCameraView.super.record(string, i * 1000, i2, readableMap.hasKey("mute") ? !readableMap.getBoolean("mute") : true, camcorderProfile, readableMap.hasKey("orientation") ? readableMap.getInt("orientation") : 0)) {
                        Boolean unused = RNCameraView.this.mIsRecording = true;
                        Promise unused2 = RNCameraView.this.mVideoRecordedPromise = promise;
                        return;
                    }
                    promise.reject("E_RECORDING_FAILED", "Starting video recording failed. Another recording might be in progress.");
                } catch (IOException unused3) {
                    promise.reject("E_RECORDING_FAILED", "Starting video recording failed - could not create video file.");
                }
            }
        });
    }

    private void initBarcodeReader() {
        this.mMultiFormatReader = new MultiFormatReader();
        EnumMap enumMap = new EnumMap(DecodeHintType.class);
        EnumSet<E> noneOf = EnumSet.noneOf(BarcodeFormat.class);
        List<String> list = this.mBarCodeTypes;
        if (list != null) {
            for (String str : list) {
                String str2 = (String) CameraModule.VALID_BARCODE_TYPES.get(str);
                if (str2 != null) {
                    noneOf.add(BarcodeFormat.valueOf(str2));
                }
            }
        }
        enumMap.put(DecodeHintType.POSSIBLE_FORMATS, noneOf);
        this.mMultiFormatReader.setHints(enumMap);
    }

    public void setShouldScanBarCodes(boolean z) {
        if (z && this.mMultiFormatReader == null) {
            initBarcodeReader();
        }
        this.mShouldScanBarCodes = z;
        setScanning(this.mShouldDetectFaces || this.mShouldGoogleDetectBarcodes || this.mShouldScanBarCodes || this.mShouldRecognizeText);
    }

    public void onBarCodeRead(Result result, int i, int i2) {
        String barcodeFormat = result.getBarcodeFormat().toString();
        if (this.mShouldScanBarCodes && this.mBarCodeTypes.contains(barcodeFormat)) {
            RNCameraViewHelper.emitBarCodeReadEvent(this, result, i, i2);
        }
    }

    public void onBarCodeScanningTaskCompleted() {
        this.barCodeScannerTaskLock = false;
        MultiFormatReader multiFormatReader = this.mMultiFormatReader;
        if (multiFormatReader != null) {
            multiFormatReader.reset();
        }
    }

    private void setupFaceDetector() {
        this.mFaceDetector = new RNFaceDetector(this.mThemedReactContext);
        this.mFaceDetector.setMode(this.mFaceDetectorMode);
        this.mFaceDetector.setLandmarkType(this.mFaceDetectionLandmarks);
        this.mFaceDetector.setClassificationType(this.mFaceDetectionClassifications);
        this.mFaceDetector.setTracking(this.mTrackingEnabled);
    }

    public void setFaceDetectionLandmarks(int i) {
        this.mFaceDetectionLandmarks = i;
        RNFaceDetector rNFaceDetector = this.mFaceDetector;
        if (rNFaceDetector != null) {
            rNFaceDetector.setLandmarkType(i);
        }
    }

    public void setFaceDetectionClassifications(int i) {
        this.mFaceDetectionClassifications = i;
        RNFaceDetector rNFaceDetector = this.mFaceDetector;
        if (rNFaceDetector != null) {
            rNFaceDetector.setClassificationType(i);
        }
    }

    public void setFaceDetectionMode(int i) {
        this.mFaceDetectorMode = i;
        RNFaceDetector rNFaceDetector = this.mFaceDetector;
        if (rNFaceDetector != null) {
            rNFaceDetector.setMode(i);
        }
    }

    public void setTracking(boolean z) {
        this.mTrackingEnabled = z;
        RNFaceDetector rNFaceDetector = this.mFaceDetector;
        if (rNFaceDetector != null) {
            rNFaceDetector.setTracking(z);
        }
    }

    public void setShouldDetectFaces(boolean z) {
        if (z && this.mFaceDetector == null) {
            setupFaceDetector();
        }
        this.mShouldDetectFaces = z;
        setScanning(this.mShouldDetectFaces || this.mShouldGoogleDetectBarcodes || this.mShouldScanBarCodes || this.mShouldRecognizeText);
    }

    public void onFacesDetected(WritableArray writableArray) {
        if (this.mShouldDetectFaces) {
            RNCameraViewHelper.emitFacesDetectedEvent(this, writableArray);
        }
    }

    public void onFaceDetectionError(RNFaceDetector rNFaceDetector) {
        if (this.mShouldDetectFaces) {
            RNCameraViewHelper.emitFaceDetectionErrorEvent(this, rNFaceDetector);
        }
    }

    public void onFaceDetectingTaskCompleted() {
        this.faceDetectorTaskLock = false;
    }

    private void setupBarcodeDetector() {
        this.mGoogleBarcodeDetector = new RNBarcodeDetector(this.mThemedReactContext);
        this.mGoogleBarcodeDetector.setBarcodeType(this.mGoogleVisionBarCodeType);
    }

    public void setShouldGoogleDetectBarcodes(boolean z) {
        if (z && this.mGoogleBarcodeDetector == null) {
            setupBarcodeDetector();
        }
        this.mShouldGoogleDetectBarcodes = z;
        setScanning(this.mShouldDetectFaces || this.mShouldGoogleDetectBarcodes || this.mShouldScanBarCodes || this.mShouldRecognizeText);
    }

    public void setGoogleVisionBarcodeType(int i) {
        this.mGoogleVisionBarCodeType = i;
        RNBarcodeDetector rNBarcodeDetector = this.mGoogleBarcodeDetector;
        if (rNBarcodeDetector != null) {
            rNBarcodeDetector.setBarcodeType(i);
        }
    }

    public void setGoogleVisionBarcodeMode(int i) {
        this.mGoogleVisionBarCodeMode = i;
    }

    public void onBarcodesDetected(WritableArray writableArray) {
        if (this.mShouldGoogleDetectBarcodes) {
            RNCameraViewHelper.emitBarcodesDetectedEvent(this, writableArray);
        }
    }

    public void onBarcodeDetectionError(RNBarcodeDetector rNBarcodeDetector) {
        if (this.mShouldGoogleDetectBarcodes) {
            RNCameraViewHelper.emitBarcodeDetectionErrorEvent(this, rNBarcodeDetector);
        }
    }

    public void onBarcodeDetectingTaskCompleted() {
        this.googleBarcodeDetectorTaskLock = false;
    }

    public void setShouldRecognizeText(boolean z) {
        this.mShouldRecognizeText = z;
        setScanning(this.mShouldDetectFaces || this.mShouldGoogleDetectBarcodes || this.mShouldScanBarCodes || this.mShouldRecognizeText);
    }

    public void onTextRecognized(WritableArray writableArray) {
        if (this.mShouldRecognizeText) {
            RNCameraViewHelper.emitTextRecognizedEvent(this, writableArray);
        }
    }

    public void onTextRecognizerTaskCompleted() {
        this.textRecognizerTaskLock = false;
    }

    public void onHostResume() {
        if (hasCameraPermissions()) {
            this.mBgHandler.post(new Runnable() {
                public void run() {
                    if ((RNCameraView.this.mIsPaused && !RNCameraView.this.isCameraOpened()) || RNCameraView.this.mIsNew) {
                        boolean unused = RNCameraView.this.mIsPaused = false;
                        boolean unused2 = RNCameraView.this.mIsNew = false;
                        RNCameraView.this.start();
                    }
                }
            });
        } else {
            RNCameraViewHelper.emitMountErrorEvent(this, "Camera permissions not granted - component could not be rendered.");
        }
    }

    public void onHostPause() {
        if (this.mIsRecording.booleanValue()) {
            this.mIsRecordingInterrupted = true;
        }
        if (!this.mIsPaused && isCameraOpened()) {
            this.mIsPaused = true;
            stop();
        }
    }

    public void onHostDestroy() {
        RNFaceDetector rNFaceDetector = this.mFaceDetector;
        if (rNFaceDetector != null) {
            rNFaceDetector.release();
        }
        RNBarcodeDetector rNBarcodeDetector = this.mGoogleBarcodeDetector;
        if (rNBarcodeDetector != null) {
            rNBarcodeDetector.release();
        }
        this.mMultiFormatReader = null;
        stop();
        this.mThemedReactContext.removeLifecycleEventListener(this);
        cleanup();
    }

    private boolean hasCameraPermissions() {
        if (Build.VERSION.SDK_INT < 23 || ContextCompat.checkSelfPermission(getContext(), "android.permission.CAMERA") == 0) {
            return true;
        }
        return false;
    }
}
