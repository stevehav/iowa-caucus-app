package org.reactnative.camera.tasks;

import com.google.zxing.Result;

public interface BarCodeScannerAsyncTaskDelegate {
    void onBarCodeRead(Result result, int i, int i2);

    void onBarCodeScanningTaskCompleted();
}
