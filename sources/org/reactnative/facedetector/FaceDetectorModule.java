package org.reactnative.facedetector;

import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.uimanager.ViewProps;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import javax.annotation.Nullable;
import org.reactnative.facedetector.tasks.FileFaceDetectionAsyncTask;

public class FaceDetectorModule extends ReactContextBaseJavaModule {
    private static final String TAG = "RNFaceDetector";
    private static ReactApplicationContext mScopedContext;

    public String getName() {
        return TAG;
    }

    public FaceDetectorModule(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
        mScopedContext = reactApplicationContext;
    }

    @Nullable
    public Map<String, Object> getConstants() {
        return Collections.unmodifiableMap(new HashMap<String, Object>() {
            {
                put("Mode", getFaceDetectionModeConstants());
                put("Landmarks", getFaceDetectionLandmarksConstants());
                put("Classifications", getFaceDetectionClassificationsConstants());
            }

            private Map<String, Object> getFaceDetectionModeConstants() {
                return Collections.unmodifiableMap(new HashMap<String, Object>() {
                    {
                        put("fast", Integer.valueOf(RNFaceDetector.FAST_MODE));
                        put("accurate", Integer.valueOf(RNFaceDetector.ACCURATE_MODE));
                    }
                });
            }

            private Map<String, Object> getFaceDetectionClassificationsConstants() {
                return Collections.unmodifiableMap(new HashMap<String, Object>() {
                    {
                        put("all", Integer.valueOf(RNFaceDetector.ALL_CLASSIFICATIONS));
                        put(ViewProps.NONE, Integer.valueOf(RNFaceDetector.NO_CLASSIFICATIONS));
                    }
                });
            }

            private Map<String, Object> getFaceDetectionLandmarksConstants() {
                return Collections.unmodifiableMap(new HashMap<String, Object>() {
                    {
                        put("all", Integer.valueOf(RNFaceDetector.ALL_LANDMARKS));
                        put(ViewProps.NONE, Integer.valueOf(RNFaceDetector.NO_LANDMARKS));
                    }
                });
            }
        });
    }

    @ReactMethod
    public void detectFaces(ReadableMap readableMap, Promise promise) {
        new FileFaceDetectionAsyncTask(mScopedContext, readableMap, promise).execute(new Void[0]);
    }
}
