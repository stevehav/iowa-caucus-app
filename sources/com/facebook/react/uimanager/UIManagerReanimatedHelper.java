package com.facebook.react.uimanager;

public class UIManagerReanimatedHelper {
    public static boolean isOperationQueueEmpty(UIImplementation uIImplementation) {
        return uIImplementation.getUIViewOperationQueue().isEmpty();
    }
}
