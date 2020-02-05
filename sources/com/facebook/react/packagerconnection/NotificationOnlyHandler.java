package com.facebook.react.packagerconnection;

import androidx.annotation.Nullable;
import com.facebook.common.logging.FLog;

public abstract class NotificationOnlyHandler implements RequestHandler {
    private static final String TAG = JSPackagerClient.class.getSimpleName();

    public abstract void onNotification(@Nullable Object obj);

    public final void onRequest(@Nullable Object obj, Responder responder) {
        responder.error("Request is not supported");
        FLog.e(TAG, "Request is not supported");
    }
}
