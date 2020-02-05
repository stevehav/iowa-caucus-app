package org.reactnative.camera.tasks;

import android.graphics.Rect;
import android.os.AsyncTask;
import android.util.SparseArray;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.WritableArray;
import com.facebook.react.bridge.WritableMap;
import com.google.android.gms.vision.barcode.Barcode;
import org.reactnative.barcodedetector.BarcodeFormatUtils;
import org.reactnative.barcodedetector.RNBarcodeDetector;
import org.reactnative.camera.utils.ImageDimensions;
import org.reactnative.frame.RNFrameFactory;

public class BarcodeDetectorAsyncTask extends AsyncTask<Void, Void, SparseArray<Barcode>> {
    private RNBarcodeDetector mBarcodeDetector;
    private BarcodeDetectorAsyncTaskDelegate mDelegate;
    private int mHeight;
    private byte[] mImageData;
    private ImageDimensions mImageDimensions;
    private int mPaddingLeft;
    private int mPaddingTop;
    private int mRotation;
    private double mScaleX;
    private double mScaleY;
    private int mWidth;

    public BarcodeDetectorAsyncTask(BarcodeDetectorAsyncTaskDelegate barcodeDetectorAsyncTaskDelegate, RNBarcodeDetector rNBarcodeDetector, byte[] bArr, int i, int i2, int i3, float f, int i4, int i5, int i6, int i7, int i8) {
        this.mImageData = bArr;
        this.mWidth = i;
        this.mHeight = i2;
        this.mRotation = i3;
        this.mDelegate = barcodeDetectorAsyncTaskDelegate;
        this.mBarcodeDetector = rNBarcodeDetector;
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
    public SparseArray<Barcode> doInBackground(Void... voidArr) {
        RNBarcodeDetector rNBarcodeDetector;
        if (isCancelled() || this.mDelegate == null || (rNBarcodeDetector = this.mBarcodeDetector) == null || !rNBarcodeDetector.isOperational()) {
            return null;
        }
        return this.mBarcodeDetector.detect(RNFrameFactory.buildFrame(this.mImageData, this.mWidth, this.mHeight, this.mRotation));
    }

    /* access modifiers changed from: protected */
    public void onPostExecute(SparseArray<Barcode> sparseArray) {
        super.onPostExecute(sparseArray);
        if (sparseArray == null) {
            this.mDelegate.onBarcodeDetectionError(this.mBarcodeDetector);
            return;
        }
        if (sparseArray.size() > 0) {
            this.mDelegate.onBarcodesDetected(serializeEventData(sparseArray));
        }
        this.mDelegate.onBarcodeDetectingTaskCompleted();
    }

    private WritableArray serializeEventData(SparseArray<Barcode> sparseArray) {
        WritableArray createArray = Arguments.createArray();
        for (int i = 0; i < sparseArray.size(); i++) {
            Barcode valueAt = sparseArray.valueAt(i);
            WritableMap createMap = Arguments.createMap();
            createMap.putString("data", valueAt.displayValue);
            createMap.putString("rawData", valueAt.rawValue);
            createMap.putString("type", BarcodeFormatUtils.get(valueAt.format));
            createMap.putMap("bounds", processBounds(valueAt.getBoundingBox()));
            createArray.pushMap(createMap);
        }
        return createArray;
    }

    private WritableMap processBounds(Rect rect) {
        WritableMap createMap = Arguments.createMap();
        int i = rect.left;
        int i2 = rect.top;
        if (rect.left < this.mWidth / 2) {
            i += this.mPaddingLeft / 2;
        } else if (rect.left > this.mWidth / 2) {
            i -= this.mPaddingLeft / 2;
        }
        if (rect.top < this.mHeight / 2) {
            i2 += this.mPaddingTop / 2;
        } else if (rect.top > this.mHeight / 2) {
            i2 -= this.mPaddingTop / 2;
        }
        double d = (double) i;
        double d2 = this.mScaleX;
        Double.isNaN(d);
        createMap.putDouble("x", d * d2);
        double d3 = (double) i2;
        double d4 = this.mScaleY;
        Double.isNaN(d3);
        createMap.putDouble("y", d3 * d4);
        WritableMap createMap2 = Arguments.createMap();
        double width = (double) rect.width();
        double d5 = this.mScaleX;
        Double.isNaN(width);
        createMap2.putDouble("width", width * d5);
        double height = (double) rect.height();
        double d6 = this.mScaleY;
        Double.isNaN(height);
        createMap2.putDouble("height", height * d6);
        WritableMap createMap3 = Arguments.createMap();
        createMap3.putMap("origin", createMap);
        createMap3.putMap("size", createMap2);
        return createMap3;
    }
}
