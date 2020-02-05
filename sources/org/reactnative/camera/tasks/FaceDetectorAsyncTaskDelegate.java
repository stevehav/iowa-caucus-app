package org.reactnative.camera.tasks;

import com.facebook.react.bridge.WritableArray;
import org.reactnative.facedetector.RNFaceDetector;

public interface FaceDetectorAsyncTaskDelegate {
    void onFaceDetectingTaskCompleted();

    void onFaceDetectionError(RNFaceDetector rNFaceDetector);

    void onFacesDetected(WritableArray writableArray);
}
