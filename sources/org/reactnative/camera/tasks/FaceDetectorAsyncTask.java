package org.reactnative.camera.tasks;

import android.os.AsyncTask;
import android.util.SparseArray;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.WritableArray;
import com.facebook.react.bridge.WritableMap;
import com.google.android.gms.vision.face.Face;
import org.reactnative.camera.utils.ImageDimensions;
import org.reactnative.facedetector.FaceDetectorUtils;
import org.reactnative.facedetector.RNFaceDetector;
import org.reactnative.frame.RNFrameFactory;

public class FaceDetectorAsyncTask extends AsyncTask<Void, Void, SparseArray<Face>> {
    private FaceDetectorAsyncTaskDelegate mDelegate;
    private RNFaceDetector mFaceDetector;
    private int mHeight;
    private byte[] mImageData;
    private ImageDimensions mImageDimensions;
    private int mPaddingLeft;
    private int mPaddingTop;
    private int mRotation;
    private double mScaleX;
    private double mScaleY;
    private int mWidth;

    public FaceDetectorAsyncTask(FaceDetectorAsyncTaskDelegate faceDetectorAsyncTaskDelegate, RNFaceDetector rNFaceDetector, byte[] bArr, int i, int i2, int i3, float f, int i4, int i5, int i6, int i7, int i8) {
        this.mImageData = bArr;
        this.mWidth = i;
        this.mHeight = i2;
        this.mRotation = i3;
        this.mDelegate = faceDetectorAsyncTaskDelegate;
        this.mFaceDetector = rNFaceDetector;
        this.mImageDimensions = new ImageDimensions(i, i2, i3, i4);
        double d = (double) i5;
        double width = (double) (((float) this.mImageDimensions.getWidth()) * f);
        Double.isNaN(d);
        Double.isNaN(width);
        this.mScaleX = d / width;
        double d2 = (double) i6;
        double height = (double) (((float) this.mImageDimensions.getHeight()) * f);
        Double.isNaN(d2);
        Double.isNaN(height);
        this.mScaleY = d2 / height;
        this.mPaddingLeft = i7;
        this.mPaddingTop = i8;
    }

    /* access modifiers changed from: protected */
    public SparseArray<Face> doInBackground(Void... voidArr) {
        RNFaceDetector rNFaceDetector;
        if (isCancelled() || this.mDelegate == null || (rNFaceDetector = this.mFaceDetector) == null || !rNFaceDetector.isOperational()) {
            return null;
        }
        return this.mFaceDetector.detect(RNFrameFactory.buildFrame(this.mImageData, this.mWidth, this.mHeight, this.mRotation));
    }

    /* access modifiers changed from: protected */
    public void onPostExecute(SparseArray<Face> sparseArray) {
        super.onPostExecute(sparseArray);
        if (sparseArray == null) {
            this.mDelegate.onFaceDetectionError(this.mFaceDetector);
            return;
        }
        if (sparseArray.size() > 0) {
            this.mDelegate.onFacesDetected(serializeEventData(sparseArray));
        }
        this.mDelegate.onFaceDetectingTaskCompleted();
    }

    private WritableArray serializeEventData(SparseArray<Face> sparseArray) {
        WritableMap writableMap;
        WritableArray createArray = Arguments.createArray();
        for (int i = 0; i < sparseArray.size(); i++) {
            WritableMap serializeFace = FaceDetectorUtils.serializeFace(sparseArray.valueAt(i), this.mScaleX, this.mScaleY, this.mWidth, this.mHeight, this.mPaddingLeft, this.mPaddingTop);
            if (this.mImageDimensions.getFacing() == 1) {
                writableMap = FaceDetectorUtils.rotateFaceX(serializeFace, this.mImageDimensions.getWidth(), this.mScaleX);
            } else {
                writableMap = FaceDetectorUtils.changeAnglesDirection(serializeFace);
            }
            createArray.pushMap(writableMap);
        }
        return createArray;
    }
}
