package com.facebook.react.common.network;

import okhttp3.Call;
import okhttp3.OkHttpClient;

public class OkHttpCallUtil {
    private OkHttpCallUtil() {
    }

    public static void cancelTag(OkHttpClient okHttpClient, Object obj) {
        for (Call next : okHttpClient.dispatcher().queuedCalls()) {
            if (obj.equals(next.request().tag())) {
                next.cancel();
                return;
            }
        }
        for (Call next2 : okHttpClient.dispatcher().runningCalls()) {
            if (obj.equals(next2.request().tag())) {
                next2.cancel();
                return;
            }
        }
    }
}
