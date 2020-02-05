package com.facebook.react.views.modal;

import com.facebook.react.bridge.WritableMap;
import com.facebook.react.uimanager.events.Event;
import com.facebook.react.uimanager.events.RCTEventEmitter;

class ShowEvent extends Event<ShowEvent> {
    public static final String EVENT_NAME = "topShow";

    public String getEventName() {
        return EVENT_NAME;
    }

    protected ShowEvent(int i) {
        super(i);
    }

    public void dispatch(RCTEventEmitter rCTEventEmitter) {
        rCTEventEmitter.receiveEvent(getViewTag(), getEventName(), (WritableMap) null);
    }
}
