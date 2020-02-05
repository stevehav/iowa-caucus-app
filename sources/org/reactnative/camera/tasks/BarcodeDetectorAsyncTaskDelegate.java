package org.reactnative.camera.tasks;

import com.facebook.react.bridge.WritableArray;
import org.reactnative.barcodedetector.RNBarcodeDetector;

public interface BarcodeDetectorAsyncTaskDelegate {
    void onBarcodeDetectingTaskCompleted();

    void onBarcodeDetectionError(RNBarcodeDetector rNBarcodeDetector);

    void onBarcodesDetected(WritableArray writableArray);
}
