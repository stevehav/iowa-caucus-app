package io.invertase.firebase.storage;

import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.WritableMap;
import io.invertase.firebase.interfaces.NativeEvent;

public class ReactNativeFirebaseStorageEvent implements NativeEvent {
    private static final String EVENT_DEFAULT = "storage_event";
    static final String EVENT_DOWNLOAD_FAILURE = "download_failure";
    static final String EVENT_DOWNLOAD_SUCCESS = "download_success";
    static final String EVENT_STATE_CHANGED = "state_changed";
    static final String EVENT_UPLOAD_FAILURE = "upload_failure";
    static final String EVENT_UPLOAD_SUCCESS = "upload_success";
    private static final String KEY_APP_NAME = "appName";
    private static final String KEY_BODY = "body";
    private static final String KEY_EVENT_NAME = "eventName";
    private static final String KEY_ID = "taskId";
    private String appName;
    private WritableMap eventBody;
    private String internalEventName;
    private int taskId;

    public String getEventName() {
        return EVENT_DEFAULT;
    }

    ReactNativeFirebaseStorageEvent(WritableMap writableMap, String str, String str2, int i) {
        this.eventBody = writableMap;
        this.internalEventName = str;
        this.appName = str2;
        this.taskId = i;
    }

    public WritableMap getEventBody() {
        WritableMap createMap = Arguments.createMap();
        createMap.putInt(KEY_ID, this.taskId);
        createMap.putMap(KEY_BODY, this.eventBody);
        createMap.putString(KEY_APP_NAME, this.appName);
        createMap.putString(KEY_EVENT_NAME, this.internalEventName);
        return createMap;
    }

    public String getFirebaseAppName() {
        return this.appName;
    }
}
