package com.facebook.react.uimanager.events;

import android.util.SparseArray;
import androidx.annotation.Nullable;
import com.facebook.infer.annotation.Assertions;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.WritableArray;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.uimanager.common.ViewUtil;

public class ReactEventEmitter implements RCTEventEmitter {
    private static final String TAG = "ReactEventEmitter";
    private final SparseArray<RCTEventEmitter> mEventEmitters = new SparseArray<>();
    private final ReactApplicationContext mReactContext;

    public ReactEventEmitter(ReactApplicationContext reactApplicationContext) {
        this.mReactContext = reactApplicationContext;
    }

    public void register(int i, RCTEventEmitter rCTEventEmitter) {
        this.mEventEmitters.put(i, rCTEventEmitter);
    }

    public void unregister(int i) {
        this.mEventEmitters.remove(i);
    }

    public void receiveEvent(int i, String str, @Nullable WritableMap writableMap) {
        getEventEmitter(i).receiveEvent(i, str, writableMap);
    }

    public void receiveTouches(String str, WritableArray writableArray, WritableArray writableArray2) {
        Assertions.assertCondition(writableArray.size() > 0);
        getEventEmitter(writableArray.getMap(0).getInt(TouchesHelper.TARGET_KEY)).receiveTouches(str, writableArray, writableArray2);
    }

    private RCTEventEmitter getEventEmitter(int i) {
        RCTEventEmitter rCTEventEmitter = this.mEventEmitters.get(ViewUtil.getUIManagerType(i));
        return rCTEventEmitter == null ? (RCTEventEmitter) this.mReactContext.getJSModule(RCTEventEmitter.class) : rCTEventEmitter;
    }
}
