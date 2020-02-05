package org.reactnative.camera.tasks;

import com.facebook.react.bridge.WritableArray;

public interface TextRecognizerAsyncTaskDelegate {
    void onTextRecognized(WritableArray writableArray);

    void onTextRecognizerTaskCompleted();
}
