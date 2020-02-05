package org.reactnative.barcodedetector;

import android.content.Context;
import android.util.SparseArray;
import com.google.android.gms.vision.barcode.Barcode;
import com.google.android.gms.vision.barcode.BarcodeDetector;
import org.reactnative.camera.utils.ImageDimensions;
import org.reactnative.frame.RNFrame;

public class RNBarcodeDetector {
    public static int ALL_FORMATS = 0;
    public static int ALTERNATE_MODE = 1;
    public static int INVERTED_MODE = 2;
    public static int NORMAL_MODE;
    private BarcodeDetector mBarcodeDetector = null;
    private int mBarcodeType = 0;
    private BarcodeDetector.Builder mBuilder;
    private ImageDimensions mPreviousDimensions;

    public RNBarcodeDetector(Context context) {
        this.mBuilder = new BarcodeDetector.Builder(context).setBarcodeFormats(this.mBarcodeType);
    }

    public boolean isOperational() {
        if (this.mBarcodeDetector == null) {
            createBarcodeDetector();
        }
        return this.mBarcodeDetector.isOperational();
    }

    public SparseArray<Barcode> detect(RNFrame rNFrame) {
        if (!rNFrame.getDimensions().equals(this.mPreviousDimensions)) {
            releaseBarcodeDetector();
        }
        if (this.mBarcodeDetector == null) {
            createBarcodeDetector();
            this.mPreviousDimensions = rNFrame.getDimensions();
        }
        return this.mBarcodeDetector.detect(rNFrame.getFrame());
    }

    public void setBarcodeType(int i) {
        if (i != this.mBarcodeType) {
            release();
            this.mBuilder.setBarcodeFormats(i);
            this.mBarcodeType = i;
        }
    }

    public void release() {
        releaseBarcodeDetector();
        this.mPreviousDimensions = null;
    }

    private void releaseBarcodeDetector() {
        BarcodeDetector barcodeDetector = this.mBarcodeDetector;
        if (barcodeDetector != null) {
            barcodeDetector.release();
            this.mBarcodeDetector = null;
        }
    }

    private void createBarcodeDetector() {
        this.mBarcodeDetector = this.mBuilder.build();
    }
}
